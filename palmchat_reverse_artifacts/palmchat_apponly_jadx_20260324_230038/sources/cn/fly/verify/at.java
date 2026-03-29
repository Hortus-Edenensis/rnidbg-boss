package cn.fly.verify;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2075a;
    private Object b;
    private String c;
    private e d;

    public at(String str) {
        this.c = str == null ? getClass().getSimpleName() : str;
    }

    public synchronized Object a() {
        if (!this.f2075a) {
            this.b = null;
            this.f2075a = true;
            f.a().a(this.c + " do lock");
            return null;
        }
        try {
            f.a().a(this.c + " wait lock");
            wait();
            f.a().a(this.c + " after wait, result = " + this.b);
            return this.b;
        } catch (Throwable th) {
            f.a().a(th);
            return null;
        }
    }

    public synchronized Object b() {
        if (!this.f2075a) {
            return null;
        }
        try {
            f.a().a(this.c + " wait lock");
            wait();
            f.a().a(this.c + " after wait, result = " + this.b);
            return this.b;
        } catch (Throwable th) {
            f.a().a(th);
            return null;
        }
    }

    public e c() {
        f.a().a("last:" + this.d.a());
        return this.d;
    }

    public void a(e eVar) {
        this.d = eVar;
        f.a().a("last:" + eVar.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000c A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #1 {all -> 0x002d, blocks: (B:8:0x0008, B:10:0x000c), top: B:19:0x0008, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(Object obj) {
        if (obj != null) {
            this.b = obj;
            try {
                if (this.f2075a) {
                    f.a().a(this.c + " notify wait");
                    notifyAll();
                    this.f2075a = false;
                }
            } catch (Throwable th) {
                f.a().a(th);
            }
        } else if (this.f2075a) {
        }
    }
}
