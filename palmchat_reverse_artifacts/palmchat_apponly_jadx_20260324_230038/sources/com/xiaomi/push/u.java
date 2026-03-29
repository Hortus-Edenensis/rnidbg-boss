package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private File f1043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Runnable f1044a;

    public static void a(Context context, File file, final Runnable runnable) {
        new u(context, file) { // from class: com.xiaomi.push.u.1
            @Override // com.xiaomi.push.u
            public void a(Context context2) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }.run();
    }

    public abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        t tVarA = null;
        try {
            try {
                if (this.f1043a == null) {
                    this.f1043a = new File(this.f11793a.getFilesDir(), "default_locker");
                }
                tVarA = t.a(this.f11793a, this.f1043a);
                Runnable runnable = this.f1044a;
                if (runnable != null) {
                    runnable.run();
                }
                a(this.f11793a);
                if (tVarA == null) {
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (tVarA == null) {
                    return;
                }
            }
            tVarA.a();
        } catch (Throwable th) {
            if (tVarA != null) {
                tVarA.a();
            }
            throw th;
        }
    }

    private u(Context context, File file) {
        this.f11793a = context;
        this.f1043a = file;
    }
}
