package com.opos.exoplayer.core.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(16)
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCrypto f8151a;
    private final boolean b;

    public MediaCrypto a() {
        return this.f8151a;
    }

    public boolean a(String str) {
        return !this.b && this.f8151a.requiresSecureDecoderComponent(str);
    }
}
