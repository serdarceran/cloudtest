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

    public String build(String scriptName, String mhVersion) {
        final StringBuilder stringBuilder = new StringBuilder();
        getScript(scriptName, mhVersion, stringBuilder);
        return stringBuilder.toString();
    }

    private void getScript(String scriptName, String mhVersion, StringBuilder stringBuilder) {
        Optional<ScriptHolder> foundScript = scriptFinder.getScript(scriptName, mhVersion);
        stringBuilder.insert(0, "\n\n");
        stringBuilder.insert(0, foundScript.map(ScriptHolder::getContent).orElse(""));
        foundScript.map(ScriptHolder::getImports).get().stream().forEach(importedScriptName->
                getScript(importedScriptName, mhVersion,stringBuilder));
    }
}
