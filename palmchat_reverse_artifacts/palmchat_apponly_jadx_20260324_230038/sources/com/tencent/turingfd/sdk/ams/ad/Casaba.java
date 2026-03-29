package com.tencent.turingfd.sdk.ams.ad;

import com.tencent.turingfd.sdk.ams.ad.Nucleus;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Casaba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Nucleus f10674a;

    public static Nucleus a(String str) {
        try {
            return new Nucleus(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Nucleus.Cif b(String str) {
        Nucleus.Cif cifA;
        Nucleus.Cfor cfor = new Nucleus.Cfor(str, str, 5000L);
        try {
            if (f10674a == null) {
                synchronized (Casaba.class) {
                    if (f10674a == null) {
                        f10674a = a("sh");
                    }
                }
            }
            cifA = f10674a.a(cfor);
        } catch (Exception e) {
            if (((e instanceof IOException) || (e instanceof InterruptedException)) && f10674a != null) {
                synchronized (Casaba.class) {
                    if (f10674a != null) {
                        Nucleus nucleus = f10674a;
                        nucleus.getClass();
                        try {
                            nucleus.a();
                        } catch (Throwable unused) {
                        }
                        f10674a = null;
                    }
                }
            }
            cifA = null;
        }
        return cifA == null ? new Nucleus.Cif(cfor.f10726a, 2, "", "e") : cifA;
    }
}
