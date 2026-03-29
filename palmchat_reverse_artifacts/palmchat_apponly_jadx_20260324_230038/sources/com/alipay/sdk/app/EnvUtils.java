package com.alipay.sdk.app;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class EnvUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static EnvEnum f2577a = EnvEnum.ONLINE;

    /* JADX INFO: compiled from: SearchBox */
    public enum EnvEnum {
        ONLINE,
        SANDBOX
    }

    public static boolean a() {
        return f2577a == EnvEnum.SANDBOX;
    }
}
