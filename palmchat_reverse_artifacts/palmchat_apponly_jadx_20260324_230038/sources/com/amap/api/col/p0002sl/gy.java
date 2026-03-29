package com.amap.api.col.p0002sl;

import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public enum gy {
    MIUI(ge.c("IeGlhb21p")),
    Flyme(ge.c("IbWVpenU")),
    RH(ge.c("IaHVhd2Vp")),
    ColorOS(ge.c("Ib3Bwbw")),
    FuntouchOS(ge.c("Idml2bw")),
    SmartisanOS(ge.c("Mc21hcnRpc2Fu")),
    AmigoOS(ge.c("IYW1pZ28")),
    EUI(ge.c("IbGV0dg")),
    Sense(ge.c("EaHRj")),
    LG(ge.c("EbGdl")),
    Google(ge.c("IZ29vZ2xl")),
    NubiaUI(ge.c("IbnViaWE")),
    Other("");

    private String n;
    private int o;
    private String p;
    private String q;
    private String r = Build.MANUFACTURER;

    gy(String str) {
        this.n = str;
    }

    public final String a() {
        return this.n;
    }

    public final String b() {
        return this.p;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.o + ", versionName='" + this.q + "',ma=" + this.n + "',manufacturer=" + this.r + "'}";
    }

    public final void a(int i) {
        this.o = i;
    }

    public final void b(String str) {
        this.q = str;
    }

    public final void a(String str) {
        this.p = str;
    }
}
