package com.serdar.ceran.model;

import org.springframework.data.annotation.Id;

import java.util.Set;

/**
 * Created by serdar on 27.01.2017.
 */
public class ScriptPackage {
    @Id
    public Long version;
    public String mhVersion;
    public Set<ScriptHolder> scripts;

    public ScriptPackage() {
    }

    public Long getVersion() {
        return version;
    }

    public String getMhVersion() {
        return mhVersion;
    }

    public Set<ScriptHolder> getScripts() {
        return scripts;
    }
}
