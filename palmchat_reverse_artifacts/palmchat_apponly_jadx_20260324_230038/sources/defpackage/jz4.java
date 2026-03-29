package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class jz4 {
    public final String b(Object obj) {
        try {
            return c(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            yn1.d(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    public String c(Object obj) throws InterruptedException {
        return null;
    }

    @Deprecated
    public void a(Throwable th) {
    }
}
