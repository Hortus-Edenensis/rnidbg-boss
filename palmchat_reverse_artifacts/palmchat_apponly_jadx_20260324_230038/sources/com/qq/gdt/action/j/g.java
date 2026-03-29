package com.qq.gdt.action.j;

import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g {
    private static volatile g b;
    private volatile boolean c = false;
    private volatile boolean d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile a f10529a = a.NO_CP;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        UNKNOW,
        CP,
        NO_CP
    }

    public static g a() {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    b = new g();
                }
            }
        }
        return b;
    }

    public synchronized boolean b() {
        if (this.c) {
            return this.d;
        }
        try {
            boolean z = false;
            o.a("isCpProcess = " + this.d, new Object[0]);
            if (!this.d) {
                o.a("isCpProcess false, need check", new Object[0]);
                ProviderInfo[] providerInfoArr = com.qq.gdt.action.d.a().g().getPackageManager().getPackageInfo(com.qq.gdt.action.d.a().g().getPackageName(), 8).providers;
                if (providerInfoArr != null) {
                    int length = providerInfoArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        ProviderInfo providerInfo = providerInfoArr[i];
                        o.a("providerInfo name =" + providerInfo.name, new Object[0]);
                        if (providerInfo.name.contains("GDTInitProvider")) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
                if (!z) {
                    this.d = true;
                    this.f10529a = a.UNKNOW;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        this.c = true;
        return this.d;
    }

    public synchronized void a(boolean z) {
        this.d = z;
    }
}
