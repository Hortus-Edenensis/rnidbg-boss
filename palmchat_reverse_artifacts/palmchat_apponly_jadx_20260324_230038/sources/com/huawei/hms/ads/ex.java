package com.huawei.hms.ads;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ex {
    public static final String Code = "true";
    private static final String I = "LinkedAdConfiguration";
    public static final String V = "false";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6562a;
    private String b;
    private String c;
    private VideoConfiguration d;
    private int Z = 0;
    private String B = null;
    private int C = 0;
    private String S = Boolean.FALSE.toString();
    private String F = "n";
    private boolean D = false;
    private boolean L = false;
    private String e = "y";
    private String f = "n";

    public void B(String str) {
        this.b = str;
    }

    public int C() {
        return this.Z;
    }

    public int Code() {
        return this.C;
    }

    public String D() {
        return this.b;
    }

    public String F() {
        return this.f6562a;
    }

    public String I() {
        return this.F;
    }

    public String L() {
        return this.c;
    }

    public String S() {
        return this.B;
    }

    public String V() {
        return this.S;
    }

    public void Z(String str) {
        this.f6562a = str;
    }

    public VideoConfiguration a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public boolean B() {
        return this.L;
    }

    public void C(String str) {
        this.c = str;
    }

    public void Code(int i) {
        this.C = i;
    }

    public void F(String str) {
        this.f = str;
    }

    public void I(String str) {
        this.B = str;
    }

    public void S(String str) {
        this.e = str;
    }

    public void V(int i) {
        fh.Code(I, "setLinkedVideoMode %s", Integer.valueOf(i));
        this.Z = i;
    }

    public boolean Z() {
        return this.D;
    }

    public void Code(VideoConfiguration videoConfiguration) {
        this.d = videoConfiguration;
    }

    public void V(String str) {
        this.F = str;
    }

    public void Code(String str) {
        this.S = str;
    }

    public void V(boolean z) {
        this.L = z;
    }

    public void Code(boolean z) {
        this.D = z;
    }
}
