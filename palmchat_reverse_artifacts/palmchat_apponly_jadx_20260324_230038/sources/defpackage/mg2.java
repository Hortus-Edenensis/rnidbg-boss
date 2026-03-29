package defpackage;

import android.os.Looper;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface mg2 {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void sendToTarget();
    }

    boolean a(a aVar);

    Looper getLooper();

    boolean hasMessages(int i);

    a obtainMessage(int i);

    a obtainMessage(int i, int i2, int i3);

    a obtainMessage(int i, @Nullable Object obj);

    boolean post(Runnable runnable);

    void removeCallbacksAndMessages(@Nullable Object obj);

    void removeMessages(int i);

    boolean sendEmptyMessage(int i);

    boolean sendEmptyMessageAtTime(int i, long j);
}
