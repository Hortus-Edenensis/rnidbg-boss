package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class rq5 implements ed0 {
    @Override // defpackage.ed0
    public mg2 createHandler(Looper looper, @Nullable Handler.Callback callback) {
        return new sq5(new Handler(looper, callback));
    }

    @Override // defpackage.ed0
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // defpackage.ed0
    public long uptimeMillis() {
        return SystemClock.uptimeMillis();
    }

    @Override // defpackage.ed0
    public void onThreadBlocked() {
    }
}
