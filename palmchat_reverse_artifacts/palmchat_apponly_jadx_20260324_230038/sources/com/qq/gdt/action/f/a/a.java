package com.qq.gdt.action.f.a;

import android.os.Handler;
import android.os.Looper;
import com.qq.gdt.action.f.b.i;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class a<T> implements com.qq.gdt.action.f.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f10493a = new Handler(Looper.getMainLooper());
    private boolean b;

    public a(boolean z) {
        this.b = z;
    }

    private void b(final int i, final T t) {
        f10493a.post(new Runnable() { // from class: com.qq.gdt.action.f.a.a.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(i, t);
            }
        });
    }

    private void c(final Throwable th) {
        f10493a.post(new Runnable() { // from class: com.qq.gdt.action.f.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(th);
            }
        });
    }

    public abstract void a(int i, T t);

    @Override // com.qq.gdt.action.f.b.b
    public void a(i iVar) {
        try {
            int iC = iVar.c();
            T tB = b(iVar);
            if (this.b) {
                b(iC, tB);
            } else {
                a(iC, tB);
            }
        } catch (Throwable th) {
            com.qq.gdt.action.d.a aVar = new com.qq.gdt.action.d.a("Response parse error", th);
            if (this.b) {
                c(aVar);
            } else {
                b(aVar);
            }
        }
    }

    public abstract T b(i iVar) throws Exception;

    public abstract void b(Throwable th);

    @Override // com.qq.gdt.action.f.b.b
    public void a(Throwable th) {
        if (this.b) {
            c(th);
        } else {
            b(th);
        }
    }
}
