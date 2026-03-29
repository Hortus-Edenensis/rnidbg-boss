package com.opos.exoplayer.core.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class ab implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f8389a;

    public ab(Handler handler) {
        this.f8389a = handler;
    }

    @Override // com.opos.exoplayer.core.util.j
    public Looper a() {
        return this.f8389a.getLooper();
    }

    @Override // com.opos.exoplayer.core.util.j
    public void b(int i) {
        this.f8389a.removeMessages(i);
    }

    @Override // com.opos.exoplayer.core.util.j
    public Message a(int i, int i2, int i3) {
        return this.f8389a.obtainMessage(i, i2, i3);
    }

    @Override // com.opos.exoplayer.core.util.j
    public Message a(int i, int i2, int i3, Object obj) {
        return this.f8389a.obtainMessage(i, i2, i3, obj);
    }

    @Override // com.opos.exoplayer.core.util.j
    public Message a(int i, Object obj) {
        return this.f8389a.obtainMessage(i, obj);
    }

    @Override // com.opos.exoplayer.core.util.j
    public boolean a(int i) {
        return this.f8389a.sendEmptyMessage(i);
    }

    @Override // com.opos.exoplayer.core.util.j
    public boolean a(int i, long j) {
        return this.f8389a.sendEmptyMessageAtTime(i, j);
    }
}
