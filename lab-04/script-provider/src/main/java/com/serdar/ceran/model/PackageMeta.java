package com.serdar.ceran.model;

/**
 * Created by serdar on 28.01.2017.
 */
public class PackageMeta {
    private Long version;
    private String mhVersion;

    public PackageMeta(Long version, String mhVersion) {
        this.version = version;
        this.mhVersion = mhVersion;
    }

    public PackageMeta() {
    }

    public Long getVersion() {
        return version;
    }

    public String getMhVersion() {
        return mhVersion;
    }

    @Override
    public String toString() {
        return "PackageMeta{" +
                "version=" + version +
                ", mhVersion='" + mhVersion + '\'' +
                '}';
    }
}
