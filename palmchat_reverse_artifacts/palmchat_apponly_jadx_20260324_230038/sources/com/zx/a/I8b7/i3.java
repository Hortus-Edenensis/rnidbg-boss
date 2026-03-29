package com.zx.a.I8b7;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.zx.module.annotation.Java2C;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f16812a = Integer.MIN_VALUE;
    public static Object b;

    @Java2C.Method2C
    private static native int a();

    @Java2C.Method2C
    public static native PackageInfo a(String str, int i) throws PackageManager.NameNotFoundException;

    @Java2C.Method2C
    private static native PackageInfo a(String str, int i, int i2);

    @Java2C.Method2C
    private static native PackageInfo b(String str, int i);
}
