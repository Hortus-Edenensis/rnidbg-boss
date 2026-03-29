package defpackage;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface ed0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ed0 f17276a = new rq5();

    mg2 createHandler(Looper looper, @Nullable Handler.Callback callback);

    long elapsedRealtime();

    void onThreadBlocked();

    long uptimeMillis();
}
