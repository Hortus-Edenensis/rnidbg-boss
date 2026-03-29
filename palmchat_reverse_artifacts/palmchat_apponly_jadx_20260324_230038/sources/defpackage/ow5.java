package defpackage;

import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ow5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ow5 f19890a = new a();
    public static final ow5 b = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ow5 {
        @Override // defpackage.ow5
        public void a(nv nvVar) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return;
            }
            throw new IllegalStateException("Event bus " + nvVar + " accessed from non-main thread " + Looper.myLooper());
        }
    }

    void a(nv nvVar);

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ow5 {
        @Override // defpackage.ow5
        public void a(nv nvVar) {
        }
    }
}
