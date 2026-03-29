package com.oplus.tbl.exoplayer2.drm;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.C;
import com.oplus.tbl.exoplayer2.drm.DrmSession;
import com.oplus.tbl.exoplayer2.drm.DrmSessionEventListener;
import com.oplus.tbl.exoplayer2.util.Assertions;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ErrorStateDrmSession implements DrmSession {
    private final DrmSession.DrmSessionException error;

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.error = (DrmSession.DrmSessionException) Assertions.checkNotNull(drmSessionException);
    }

    @Override // com.oplus.tbl.exoplayer2.drm.DrmSession
    @Nullable
    public DrmSession.DrmSessionException getError() {
        return this.error;
    }

    @Override // com.oplus.tbl.exoplayer2.drm.DrmSession
    @Nullable
    public ExoMediaCrypto getMediaCrypto() {
        return null;
    }

    @Override // com.oplus.tbl.exoplayer2.drm.DrmSession
    @Nullable
    public byte[] getOfflineLicenseKeySetId() {
        return null;
    }

    @Override // com.oplus.tbl.exoplayer2.drm.DrmSession
    public final UUID getSchemeUuid() {
        return C.UUID_NIL;
    }

    @Override // com.oplus.tbl.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override // com.oplus.tbl.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return false;
    }

    @Override // com.oplus.tbl.exoplayer2.drm.DrmSession
    @Nullable
    public Map<String, String> queryKeyStatus() {
        return null;
    }

    @Override // com.oplus.tbl.exoplayer2.drm.DrmSession
    public void acquire(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    @Override // com.oplus.tbl.exoplayer2.drm.DrmSession
    public void release(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }
}
