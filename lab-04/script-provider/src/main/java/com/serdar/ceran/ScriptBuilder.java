package com.serdar.ceran;

import com.serdar.ceran.model.ScriptHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by serdar on 28.01.2017.
 */
@Service
public class ScriptBuilder {

    @Autowired
    private ScriptFinder scriptFinder;

    public String build(String scriptName, String mhVersion, String mhType) {
        final StringBuilder stringBuilder = new StringBuilder();
        getScript(scriptName, mhVersion, mhType, stringBuilder);
        return stringBuilder.toString();
    }

    private void getScript(String scriptName, String mhVersion, String mhType, StringBuilder stringBuilder) {
        Optional<ScriptHolder> foundScript = scriptFinder.getScript(scriptName, mhVersion, mhType);
        foundScript.ifPresent(sh-> {
            stringBuilder.insert(0, "\n\n");
            stringBuilder.insert(0, sh.getContent());
            sh.getImports().stream().forEach(importedScriptName->
                    getScript(importedScriptName, mhVersion,mhType, stringBuilder));
        });

    }
}
