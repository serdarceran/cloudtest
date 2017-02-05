import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.channel.ChannelExec;
import org.apache.sshd.client.channel.ClientChannel;
import org.apache.sshd.client.channel.ClientChannelEvent;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.keyprovider.AbstractFileKeyPairProvider;
import org.apache.sshd.common.util.SecurityUtils;
import org.apache.sshd.common.util.io.NoCloseOutputStream;

import java.io.File;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws Exception {
        SshClient client = SshClient.setUpDefaultClient();

        // override any default configuration...

        KeyPair[] keys = null;

        List<File> files = new ArrayList<File>();
        File f = new File("C:\\Program Files\\apache-sshd-1.2.0\\key.pem");
        files.add(f);

        AbstractFileKeyPairProvider fileKeyPairProvider =
                SecurityUtils.createFileKeyPairProvider();

        fileKeyPairProvider.setFiles(files);
        Iterable<KeyPair> keyPairs = fileKeyPairProvider.loadKeys();

        client.start();


        // using the client for multiple sessions...
        try (ClientSession session = client.connect("serdar", "localhost", 8000).verify(500000).getSession()) {
//            session.addPasswordIdentity("378249"); // for password-based authentication
            // or
            keyPairs.forEach(session::addPublicKeyIdentity);
            //ession.addPublicKeyIdentity(...key-pair...); // for password-less authentication
            // Note: can add BOTH password AND public key identities - depends on the client/server security setup

            session.auth().verify(10, TimeUnit.SECONDS);

            ChannelExec dirCommandChannel = session.createExecChannel("mkdir serdar123");

            NoCloseOutputStream var203 = new NoCloseOutputStream(System.out);
            NoCloseOutputStream var205 = new NoCloseOutputStream(System.err);

            ((ClientChannel)dirCommandChannel).setOut(var203);
            ((ClientChannel)dirCommandChannel).setErr(var205);
            ((ClientChannel)dirCommandChannel).open().await();
            ((ClientChannel)dirCommandChannel).waitFor(EnumSet.of(ClientChannelEvent.CLOSED), 0L);


            // start using the session to run commands, do SCP/SFTP, create local/remote port forwarding, etc...
        }

        // exiting in an orderly fashion once the code no longer needs to establish SSH session
        // NOTE: this can/should be done when the application exits.
        client.stop();
    }
}