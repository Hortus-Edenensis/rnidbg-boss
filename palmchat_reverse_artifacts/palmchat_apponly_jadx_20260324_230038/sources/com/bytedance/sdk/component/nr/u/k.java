package com.bytedance.sdk.component.nr.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class k {
    public String b;
    public jk fx;
    public u iz;
    private String nr;
    public byte[] pn;
    private String u;

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        STRING_TYPE,
        BYTE_ARRAY_TYPE,
        FILE_TYPE
    }

    public k() {
    }

    public String nr() {
        return this.nr;
    }

    public String u() {
        return this.u;
    }

    public k(jk jkVar, String str, u uVar) {
        this.fx = jkVar;
        this.b = str;
        this.iz = uVar;
    }

    public static k u(jk jkVar, String str) {
        return new k(jkVar, str, u.STRING_TYPE);
    }

    public static k u(jk jkVar, byte[] bArr) {
        return new k(jkVar, bArr, u.BYTE_ARRAY_TYPE);
    }

    public static k u(jk jkVar, byte[] bArr, String str, String str2) {
        return new k(jkVar, bArr, str, str2, u.FILE_TYPE);
    }

    public k(jk jkVar, byte[] bArr, String str, String str2, u uVar) {
        this.fx = jkVar;
        this.pn = bArr;
        this.nr = str;
        this.u = str2;
        this.iz = uVar;
    }

    public k(jk jkVar, byte[] bArr, u uVar) {
        this.fx = jkVar;
        this.pn = bArr;
        this.iz = uVar;
    }
}
