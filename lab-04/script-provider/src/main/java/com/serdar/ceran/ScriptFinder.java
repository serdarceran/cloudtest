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

    public Optional<ScriptHolder> getScript(String scriptName, String mhVersion) {
        ScriptPackage newestPackageBelongsMhVersion = scriptPackageRepository.findFirstByMhVersion(mhVersion);
        long version = newestPackageBelongsMhVersion.getVersion();
        Optional<ScriptHolder> scriptHolder = getScriptByName(newestPackageBelongsMhVersion, scriptName);
        while (!scriptHolder.isPresent()) {
            ScriptPackage thePackage = scriptPackageRepository.findFirstByVersionLessThanOrderByVersionDesc(version);
            scriptHolder = getScriptByName(thePackage, scriptName);
            version = thePackage.getVersion();
        }
        return scriptHolder;
    }

    private Optional<ScriptHolder> getScriptByName(ScriptPackage scriptPackage, String name) {
        return scriptPackage.getScripts().stream().filter(s-> s.getName().equals(name)).findFirst();
    }
}
