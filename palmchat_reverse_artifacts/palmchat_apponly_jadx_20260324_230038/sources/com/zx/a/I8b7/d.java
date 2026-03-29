package com.zx.a.I8b7;

import android.content.pm.PackageManager;
import android.content.pm.Signature;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class d {
    public static Signature[] a(String str) {
        try {
            return i3.a(str, 64).signatures;
        } catch (PackageManager.NameNotFoundException e) {
            r2.a(e);
            return null;
        }
    }
}
