package com.serdar.ceran;

import com.serdar.ceran.model.ScriptHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by serdar on 27.01.2017.
 */
@RestController
public class FatScriptFetchController {

    @Autowired
    private ScriptFinder scriptFinder;

    @RequestMapping("/{scriptName}/{mhVersion}")
    public String getScript(@PathVariable String scriptName, final @PathVariable String mhVersion) {
        final StringBuilder stringBuilder = new StringBuilder();
        getScript(scriptName, mhVersion, stringBuilder);
        return stringBuilder.toString();
    }

    private void getScript(String scriptName, String mhVersion, StringBuilder stringBuilder) {
        Optional<ScriptHolder> foundScript = scriptFinder.getScript(scriptName, mhVersion);
        stringBuilder.insert(0, foundScript.map(ScriptHolder::getContent).orElse(""));
        foundScript.map(ScriptHolder::getImports).get().stream().forEach(a->
                getScript(a.getName(), mhVersion,stringBuilder));
    }
}
