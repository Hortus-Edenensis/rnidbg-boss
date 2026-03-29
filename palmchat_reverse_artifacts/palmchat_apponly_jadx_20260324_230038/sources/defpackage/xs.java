package defpackage;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class xs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ws f22039a;
    public ht b;

    public xs(ws wsVar) {
        if (wsVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f22039a = wsVar;
    }

    public ht a() throws NotFoundException {
        if (this.b == null) {
            this.b = this.f22039a.b();
        }
        return this.b;
    }

    public et b(int i, et etVar) throws NotFoundException {
        return this.f22039a.c(i, etVar);
    }

    public int c() {
        return this.f22039a.d();
    }

    public int d() {
        return this.f22039a.f();
    }

    public boolean e() {
        return this.f22039a.e().e();
    }

    public xs f() {
        return new xs(this.f22039a.a(this.f22039a.e().f()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
