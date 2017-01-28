package com.serdar.ceran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by serdar on 27.01.2017.
 */
@RestController
public class ScriptRestController {
    @Autowired
    private ScriptBuilder scriptBuilder;

    @RequestMapping(method = RequestMethod.GET, value = "/{scriptName:.+}/{mhVersion:.+}")
    public String getScript(@PathVariable String scriptName, final @PathVariable String mhVersion) {
        return  scriptBuilder.build(scriptName, mhVersion);
    }
}
