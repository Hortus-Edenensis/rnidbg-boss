package com.beizi.ad.lance.a;

import android.graphics.Rect;
import android.view.View;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f4467a;
    private com.beizi.ad.internal.c.c b;
    private com.beizi.ad.internal.c.e c;
    private ScheduledThreadPoolExecutor d;
    private Runnable e;
    private DecimalFormatSymbols f = new DecimalFormatSymbols(Locale.ENGLISH);
    private Format g = new DecimalFormat("0.00", this.f);
    private boolean h = false;
    private boolean i = false;

    /* JADX INFO: renamed from: com.beizi.ad.lance.a.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.e = new Runnable() { // from class: com.beizi.ad.lance.a.f.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.h || f.this.a(10)) {
                        if (!f.this.h && f.this.c != null) {
                            f.this.h = true;
                            f.this.c.a();
                        }
                        if (!f.this.i && f.this.a(50)) {
                            f.this.i = true;
                            if (f.this.d != null) {
                                f.this.d.remove(f.this.e);
                                f.this.d = null;
                            }
                            if (f.this.f4467a != null) {
                                f.this.f4467a.post(new Runnable() { // from class: com.beizi.ad.lance.a.f.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (f.this.b != null) {
                                            f.this.b.a();
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            };
            f.this.d = c.b().g();
            if (f.this.d == null) {
                return;
            }
            f.this.d.scheduleWithFixedDelay(f.this.e, 0L, 250L, TimeUnit.MILLISECONDS);
        }
    }

    public f(View view, com.beizi.ad.internal.c.c cVar, com.beizi.ad.internal.c.e eVar) {
        this.f4467a = view;
        this.b = cVar;
        this.c = eVar;
        b();
    }

    private void b() {
        View view = this.f4467a;
        if (view == null) {
            return;
        }
        view.post(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i) {
        try {
            View view = this.f4467a;
            if (view != null && view.getVisibility() == 0 && this.f4467a.getParent() != null) {
                Rect rect = new Rect();
                if (!this.f4467a.getGlobalVisibleRect(rect)) {
                    return false;
                }
                int iHeight = rect.height() * rect.width();
                int height = this.f4467a.getHeight() * this.f4467a.getWidth();
                return height > 0 && iHeight * 100 >= i * height;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a() {
        Runnable runnable;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.d;
            if (scheduledThreadPoolExecutor != null && (runnable = this.e) != null) {
                scheduledThreadPoolExecutor.remove(runnable);
            }
            this.c = null;
            this.b = null;
            this.f4467a = null;
            this.d = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
