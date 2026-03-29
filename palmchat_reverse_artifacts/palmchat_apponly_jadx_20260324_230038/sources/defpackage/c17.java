package defpackage;

import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c17 implements Runnable {
    public final cd7 b;
    public volatile boolean c = false;
    public Runnable d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1880a = b();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c17.this.c = false;
        }
    }

    public c17(cd7 cd7Var) {
        this.b = cd7Var;
        ye7.a(2L);
        ej7.f().g(4500L, this.d);
        ej7.f().h(5000L, this, 40, 5000L);
    }

    public final boolean a() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }

    public final long b() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i;
        if (this.c) {
            return;
        }
        if (a()) {
            i = 200;
            str = "/data/anr/traces.txt";
        } else {
            str = null;
            i = 100;
        }
        if (this.b.e(i, str, 25)) {
            this.c = true;
        }
    }
}
