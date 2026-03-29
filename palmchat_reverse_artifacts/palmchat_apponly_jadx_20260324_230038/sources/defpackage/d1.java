package defpackage;

import java.util.List;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d1 extends dr6 {
    public int b;
    public byte[] c;
    public CompressionMethod d;
    public long e;
    public int i;
    public int j;
    public String k;
    public boolean l;
    public boolean n;
    public zq6 o;
    public f p;
    public boolean q;
    public List<is1> r;
    public boolean s;
    public long f = 0;
    public long g = 0;
    public long h = 0;
    public EncryptionMethod m = EncryptionMethod.NONE;

    public void A(int i) {
        this.j = i;
    }

    public void B(String str) {
        this.k = str;
    }

    public void C(int i) {
        this.i = i;
    }

    public void D(boolean z) {
        this.q = z;
    }

    public void E(byte[] bArr) {
        this.c = bArr;
    }

    public void F(long j) {
        this.e = j;
    }

    public void G(long j) {
        this.h = j;
    }

    public void H(int i) {
        this.b = i;
    }

    public void I(zq6 zq6Var) {
        this.o = zq6Var;
    }

    public f b() {
        return this.p;
    }

    public long c() {
        return this.g;
    }

    public CompressionMethod d() {
        return this.d;
    }

    public long e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof d1)) {
            return i().equals(((d1) obj).i());
        }
        return false;
    }

    public EncryptionMethod f() {
        return this.m;
    }

    public List<is1> g() {
        return this.r;
    }

    public int h() {
        return this.j;
    }

    public String i() {
        return this.k;
    }

    public byte[] j() {
        return this.c;
    }

    public long k() {
        return this.e;
    }

    public long l() {
        return this.h;
    }

    public zq6 m() {
        return this.o;
    }

    public boolean n() {
        return this.n;
    }

    public boolean o() {
        return this.s;
    }

    public boolean p() {
        return this.l;
    }

    public boolean q() {
        return this.q;
    }

    public void r(f fVar) {
        this.p = fVar;
    }

    public void s(long j) {
        this.g = j;
    }

    public void t(CompressionMethod compressionMethod) {
        this.d = compressionMethod;
    }

    public void u(long j) {
        this.f = j;
    }

    public void v(boolean z) {
        this.n = z;
    }

    public void w(boolean z) {
        this.s = z;
    }

    public void x(boolean z) {
        this.l = z;
    }

    public void y(EncryptionMethod encryptionMethod) {
        this.m = encryptionMethod;
    }

    public void z(List<is1> list) {
        this.r = list;
    }
}
