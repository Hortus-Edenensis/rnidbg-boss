package com.oplus.tbl.exoplayer2.drm;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.drm.DrmSession;
import com.oplus.tbl.exoplayer2.drm.DrmSessionEventListener;
import defpackage.bi1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface DrmSessionManager {
    public static final DrmSessionManager DRM_UNSUPPORTED;

    @Deprecated
    public static final DrmSessionManager DUMMY;

    static {
        DrmSessionManager drmSessionManager = new DrmSessionManager() { // from class: com.oplus.tbl.exoplayer2.drm.DrmSessionManager.1
            @Override // com.oplus.tbl.exoplayer2.drm.DrmSessionManager
            @Nullable
            public DrmSession acquireSession(Looper looper, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
                if (format.drmInitData == null) {
                    return null;
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1)));
            }

            @Override // com.oplus.tbl.exoplayer2.drm.DrmSessionManager
            @Nullable
            public Class<UnsupportedMediaCrypto> getExoMediaCryptoType(Format format) {
                if (format.drmInitData != null) {
                    return UnsupportedMediaCrypto.class;
                }
                return null;
            }

            @Override // com.oplus.tbl.exoplayer2.drm.DrmSessionManager
            public /* synthetic */ void prepare() {
                bi1.a(this);
            }

            @Override // com.oplus.tbl.exoplayer2.drm.DrmSessionManager
            public /* synthetic */ void release() {
                bi1.b(this);
            }
        };
        DRM_UNSUPPORTED = drmSessionManager;
        DUMMY = drmSessionManager;
    }

    @Nullable
    DrmSession acquireSession(Looper looper, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    @Nullable
    Class<? extends ExoMediaCrypto> getExoMediaCryptoType(Format format);

    void prepare();

    void release();
}
