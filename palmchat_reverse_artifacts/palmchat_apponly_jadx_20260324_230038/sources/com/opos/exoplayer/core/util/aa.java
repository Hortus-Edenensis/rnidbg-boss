package com.opos.exoplayer.core.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class aa implements e {
    @Override // com.opos.exoplayer.core.util.e
    public long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.opos.exoplayer.core.util.e
    public long b() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.opos.exoplayer.core.util.e
    public j a(Looper looper, @Nullable Handler.Callback callback) {
        return new ab(new Handler(looper, callback));
    }
}
