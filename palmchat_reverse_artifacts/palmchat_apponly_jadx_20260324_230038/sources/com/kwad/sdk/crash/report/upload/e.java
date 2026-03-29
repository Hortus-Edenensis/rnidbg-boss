package com.kwad.sdk.crash.report.upload;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class e {
    public static e aVA = new e(-11, "Please init.");
    public static e aVB = new e(-12, "error when zip_file");
    public static e aVC = new e(-13, "There is no valid network.");
    public static e aVD = new e(-14, "Token is invalid.");
    public static e aVE = new e(-15, "upload task execute frequence exceed.");
    public static e aVF = new e(-16, "process request fail.");
    public static e aVG = new e(-17, "sever response error http code");
    public static e aVH = new e(-18, "sever response error result code");
    public static e aVI = new e(-19, "server bad response.");
    private final int aVJ;
    private final String aVK;

    private e(int i, String str) {
        this.aVJ = i;
        this.aVK = str;
    }

    public final String AF() {
        return this.aVK;
    }
}
