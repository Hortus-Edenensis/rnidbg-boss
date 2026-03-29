package net.lingala.zip4j.progress;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ProgressMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f19502a;
    public long b;
    public long c;
    public int d;
    public Task e;
    public String f;
    public Result g;
    public Exception h;
    public boolean i;
    public boolean j;

    /* JADX INFO: compiled from: SearchBox */
    public enum Result {
        SUCCESS,
        WORK_IN_PROGRESS,
        ERROR,
        CANCELLED
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum State {
        READY,
        BUSY
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum Task {
        NONE,
        ADD_ENTRY,
        REMOVE_ENTRY,
        CALCULATE_CRC,
        EXTRACT_ENTRY,
        MERGE_ZIP_FILES,
        SET_COMMENT,
        RENAME_FILE
    }

    public ProgressMonitor() {
        f();
    }

    public void a() {
        this.g = Result.SUCCESS;
        this.d = 100;
        f();
    }

    public void b(Exception exc) {
        this.g = Result.ERROR;
        this.h = exc;
        f();
    }

    public void c() {
        f();
        this.f = null;
        this.b = 0L;
        this.c = 0L;
        this.d = 0;
    }

    public State d() {
        return this.f19502a;
    }

    public boolean e() {
        return this.i;
    }

    public final void f() {
        this.e = Task.NONE;
        this.f19502a = State.READY;
    }

    public void g(Task task) {
        this.e = task;
    }

    public void h(String str) {
        this.f = str;
    }

    public void i(Result result) {
        this.g = result;
    }

    public void j(State state) {
        this.f19502a = state;
    }

    public void k(long j) {
        this.b = j;
    }

    public void l(long j) {
        long j2 = this.c + j;
        this.c = j2;
        long j3 = this.b;
        if (j3 > 0) {
            int i = (int) ((j2 * 100) / j3);
            this.d = i;
            if (i > 100) {
                this.d = 100;
            }
        }
        while (this.j) {
            try {
                Thread.sleep(150L);
            } catch (InterruptedException unused) {
            }
        }
    }
}
