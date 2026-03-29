package defpackage;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class jq<T, K> {
    public final String b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ey1<T, K>> f18475a = Collections.synchronizedList(new ArrayList());
    public boolean c = false;

    public jq(String str) {
        this.b = str;
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public abstract void i();

    @SuppressLint({"CheckResult"})
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void g(final K k) {
        synchronized (this.f18475a) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: hq
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18028a.g(k);
                    }
                });
                return;
            }
            j();
            Iterator<ey1<T, K>> it = this.f18475a.iterator();
            while (it.hasNext()) {
                it.next().b(k);
            }
            this.f18475a.clear();
            this.c = true;
        }
    }

    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void h(final T t) {
        synchronized (this.f18475a) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: iq
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18224a.h(t);
                    }
                });
                return;
            }
            j();
            Iterator<ey1<T, K>> it = this.f18475a.iterator();
            while (it.hasNext()) {
                it.next().a(t);
            }
            this.f18475a.clear();
            this.c = true;
        }
    }

    public final void j() {
        i02.b().c(this.b);
    }

    public void k(ey1<T, K> ey1Var) {
        synchronized (this.f18475a) {
            this.f18475a.add(ey1Var);
            if (this.f18475a.size() > 1) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: gq
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17769a.i();
                }
            });
        }
    }
}
