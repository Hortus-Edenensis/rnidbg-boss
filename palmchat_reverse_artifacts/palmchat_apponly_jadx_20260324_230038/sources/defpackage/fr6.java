package defpackage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class fr6 implements Cloneable {
    public boolean h;
    public File j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<u43> f17587a = new ArrayList();
    public List<mu0> b = new ArrayList();
    public lh c = new lh();
    public b00 d = new b00();
    public qm1 e = new qm1();
    public xq6 f = new xq6();
    public yq6 g = new yq6();
    public boolean k = false;
    public long i = -1;

    public b00 a() {
        return this.d;
    }

    public qm1 c() {
        return this.e;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public xq6 d() {
        return this.f;
    }

    public yq6 e() {
        return this.g;
    }

    public File f() {
        return this.j;
    }

    public boolean g() {
        return this.h;
    }

    public boolean h() {
        return this.k;
    }

    public void i(b00 b00Var) {
        this.d = b00Var;
    }

    public void j(qm1 qm1Var) {
        this.e = qm1Var;
    }

    public void k(boolean z) {
        this.h = z;
    }

    public void l(xq6 xq6Var) {
        this.f = xq6Var;
    }

    public void m(yq6 yq6Var) {
        this.g = yq6Var;
    }

    public void n(boolean z) {
        this.k = z;
    }

    public void o(File file) {
        this.j = file;
    }
}
