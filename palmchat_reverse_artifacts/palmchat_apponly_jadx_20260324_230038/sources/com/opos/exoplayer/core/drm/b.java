package com.opos.exoplayer.core.drm;

import android.annotation.TargetApi;
import android.os.Looper;
import com.opos.exoplayer.core.drm.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(16)
public interface b<T extends c> {
    DrmSession<T> a(Looper looper, DrmInitData drmInitData);

    void a(DrmSession<T> drmSession);

    boolean a(DrmInitData drmInitData);
}
