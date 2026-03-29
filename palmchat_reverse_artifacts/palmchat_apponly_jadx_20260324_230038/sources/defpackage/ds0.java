package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ds0 {
    public static volatile ds0 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nv f17130a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public ds0() {
        this.f17130a = null;
        this.f17130a = new nv(ow5.f19890a);
    }

    public static ds0 a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new ds0();
                }
            }
        }
        return b;
    }

    public void b(a aVar) {
        this.f17130a.i(aVar);
    }

    public void c(Object obj) {
        this.f17130a.j(obj);
    }

    public void d(Object obj) {
        this.f17130a.l(obj);
    }
}
