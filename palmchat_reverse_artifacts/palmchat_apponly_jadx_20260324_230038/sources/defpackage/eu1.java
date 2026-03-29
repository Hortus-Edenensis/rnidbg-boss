package defpackage;

import net.lingala.zip4j.headers.HeaderSignature;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class eu1 extends d1 {
    public int t;
    public int u = 0;
    public int v;
    public byte[] w;
    public byte[] x;
    public long y;
    public String z;

    public eu1() {
        a(HeaderSignature.CENTRAL_DIRECTORY);
    }

    public int J() {
        return this.v;
    }

    public byte[] K() {
        return this.x;
    }

    public long L() {
        return this.y;
    }

    public void M(int i) {
        this.v = i;
    }

    public void N(byte[] bArr) {
        this.x = bArr;
    }

    public void O(String str) {
        this.z = str;
    }

    public void P(int i) {
        this.u = i;
    }

    public void Q(byte[] bArr) {
        this.w = bArr;
    }

    public void R(long j) {
        this.y = j;
    }

    public void S(int i) {
        this.t = i;
    }

    public String toString() {
        return i();
    }
}
