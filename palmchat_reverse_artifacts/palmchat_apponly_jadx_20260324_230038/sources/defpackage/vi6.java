package defpackage;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class vi6 {
    public static volatile vi6 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Activity> f21455a;

    public static vi6 c() {
        if (b == null) {
            synchronized (vi6.class) {
                if (b == null) {
                    b = new vi6();
                }
            }
        }
        return b;
    }

    public void a(Activity activity) {
        WeakReference<Activity> weakReference = this.f21455a;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    public Activity b() {
        WeakReference<Activity> weakReference = this.f21455a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void d(Activity activity) {
        this.f21455a = new WeakReference<>(activity);
    }
}
