package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class d17 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16961a;

    public d17(Context context) {
        this.f16961a = context;
    }

    public static void a(Context context) {
        b(context, 0);
    }

    public static void b(Context context, int i) {
        try {
            if (!uh7.j().a().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception unused) {
        }
        im7.a().postDelayed(new d17(context), i);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new vc7(this.f16961a).d(pv6.b(this.f16961a));
        } finally {
            try {
            } finally {
            }
        }
    }
}
