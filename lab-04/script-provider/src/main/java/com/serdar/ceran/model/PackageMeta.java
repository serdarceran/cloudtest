package com.serdar.ceran.model;

/**
 * Created by serdar on 28.01.2017.
 */
public class PackageMeta {
    private Long version;
    private String mhVersionCpp;
    private String mhVersionJava;

    public PackageMeta() {
    }

    public Long getVersion() {
        return version;
    }

    public String getMhVersionJava() {
        return mhVersionJava;
    }

    public String getMhVersionCpp() {
        return mhVersionCpp;
    }

    @Override
    public String toString() {
        return "PackageMeta{" +
                "version=" + version +
                ", mhVersionCpp='" + mhVersionCpp + '\'' +
                ", mhVersionJava='" + mhVersionJava + '\'' +
                '}';
    }
}
