package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Ginkgo implements Canesatici {
    public static final byte[] j = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10700a;
    public final long b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Ginkgo$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class Cdo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10701a;
        public long b;
        public int c;
        public String d;
        public String e;
        public String f;
        public String g;

        public Cdo(int i) {
            this.c = i;
        }
    }

    public Ginkgo(int i, byte[] bArr, int i2, int i3) {
        this.f10700a = "";
        this.b = 0L;
        this.c = i;
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = i2;
        this.i = i3;
    }

    public static Ginkgo a(int i) {
        return new Ginkgo(i, j, 0, 0);
    }

    public Ginkgo(Cdo cdo) {
        this.h = 0;
        this.i = 0;
        this.f10700a = cdo.f10701a;
        this.b = cdo.b;
        this.c = cdo.c;
        this.d = cdo.d;
        this.e = cdo.e;
        this.f = cdo.f;
        this.g = cdo.g;
    }
}
