package com.serdar.ceran;

import com.serdar.ceran.model.ScriptHolder;
import com.serdar.ceran.model.ScriptPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by serdar on 27.01.2017.
 */
@Service
public class ScriptFinder {

    @Autowired
    private ScriptPackageRepository scriptPackageRepository;

    public Optional<ScriptHolder> getScript(String scriptName, String mhVersion, String mhType) {
        Optional<ScriptHolder> scriptHolder = Optional.empty();
        final ScriptPackage newestPackageBelongsMhVersion;
        if(mhType.equals("Java")) {
            newestPackageBelongsMhVersion = scriptPackageRepository.findFirstByMhVersionJavaOrderByVersionDesc(mhVersion);
        } else {
            newestPackageBelongsMhVersion = scriptPackageRepository.findFirstByMhVersionCppOrderByVersionDesc(mhVersion);
        }

        if(newestPackageBelongsMhVersion != null) {
            long version = newestPackageBelongsMhVersion.getVersion();
            scriptHolder = getScriptByName(newestPackageBelongsMhVersion, scriptName);
            while (!scriptHolder.isPresent()) {
                ScriptPackage thePackage = scriptPackageRepository.findFirstByVersionLessThanOrderByVersionDesc(version);
                scriptHolder = getScriptByName(thePackage, scriptName);
                version = thePackage.getVersion();
            }
        }
        return scriptHolder;
    }

    private Optional<ScriptHolder> getScriptByName(ScriptPackage scriptPackage, String name) {
        if(scriptPackage == null) {
            return Optional.empty();
        }
        return scriptPackage.getScripts().stream().filter(s-> s.getName().equals(name)).findFirst();
    }
}
