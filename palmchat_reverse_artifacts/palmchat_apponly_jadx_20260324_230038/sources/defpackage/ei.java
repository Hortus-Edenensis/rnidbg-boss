package defpackage;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ei<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProgressMonitor f17304a;
    public final boolean b;
    public final ExecutorService c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProgressMonitor f17305a;
        public final boolean b;
        public final ExecutorService c;

        public a(ExecutorService executorService, boolean z, ProgressMonitor progressMonitor) {
            this.c = executorService;
            this.b = z;
            this.f17305a = progressMonitor;
        }
    }

    public ei(a aVar) {
        this.f17304a = aVar.f17305a;
        this.b = aVar.b;
        this.c = aVar.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void g(Object obj) {
        try {
            h(obj, this.f17304a);
        } catch (ZipException unused) {
        } catch (Throwable th) {
            this.c.shutdown();
            throw th;
        }
        this.c.shutdown();
    }

    public abstract long b(T t) throws ZipException;

    public void c(final T t) throws ZipException {
        if (this.b && ProgressMonitor.State.BUSY.equals(this.f17304a.d())) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        f();
        if (!this.b) {
            h(t, this.f17304a);
            return;
        }
        this.f17304a.k(b(t));
        this.c.execute(new Runnable() { // from class: di
            @Override // java.lang.Runnable
            public final void run() {
                this.f17054a.g(t);
            }
        });
    }

    public abstract void d(T t, ProgressMonitor progressMonitor) throws IOException;

    public abstract ProgressMonitor.Task e();

    public final void f() {
        this.f17304a.c();
        this.f17304a.j(ProgressMonitor.State.BUSY);
        this.f17304a.g(e());
    }

    public final void h(T t, ProgressMonitor progressMonitor) throws ZipException {
        try {
            d(t, progressMonitor);
            progressMonitor.a();
        } catch (ZipException e) {
            progressMonitor.b(e);
            throw e;
        } catch (Exception e2) {
            progressMonitor.b(e2);
            throw new ZipException(e2);
        }
    }

    public void i() throws ZipException {
        if (this.f17304a.e()) {
            this.f17304a.i(ProgressMonitor.Result.CANCELLED);
            this.f17304a.j(ProgressMonitor.State.READY);
            throw new ZipException("Task cancelled", ZipException.Type.TASK_CANCELLED_EXCEPTION);
        }
    }
}
