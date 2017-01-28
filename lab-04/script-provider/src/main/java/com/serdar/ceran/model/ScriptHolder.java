package com.serdar.ceran.model;

import java.util.Collections;
import java.util.Set;

/**
 * Created by serdar on 27.01.2017.
 */
public class ScriptHolder {
    public String name;
    public String content = "";
    public Set<String> imports = Collections.emptySet();

    public ScriptHolder() {
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Set<String> getImports() {
        return imports;
    }
}
