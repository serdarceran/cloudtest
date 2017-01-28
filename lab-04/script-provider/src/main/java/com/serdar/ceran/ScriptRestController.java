package com.serdar.ceran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by serdar on 27.01.2017.
 */
@RestController
public class ScriptRestController {
    @Autowired
    private ScriptBuilder scriptBuilder;

    @RequestMapping(method = RequestMethod.GET, value = "/{scriptName:.+}")
    public String getScript(@PathVariable String scriptName,
                            @RequestParam String mhVersion,
                            @RequestParam String mhType) {
        return  scriptBuilder.build(scriptName, mhVersion, mhType);
    }
}
