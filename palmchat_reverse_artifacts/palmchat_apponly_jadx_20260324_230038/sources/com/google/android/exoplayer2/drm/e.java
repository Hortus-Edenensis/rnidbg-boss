package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.g;
import defpackage.bk4;
import defpackage.hr0;
import defpackage.lo1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(18)
@Deprecated
public final class e implements g {
    @Override // com.google.android.exoplayer2.drm.g
    public /* synthetic */ void b(byte[] bArr, bk4 bk4Var) {
        lo1.a(this, bArr, bk4Var);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public hr0 createCryptoConfig(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public int getCryptoType() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.drm.g
    public g.a getKeyRequest(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public g.d getProvisionRequest() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public byte[] openSession() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // com.google.android.exoplayer2.drm.g
    @Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void provideProvisionResponse(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public boolean requiresSecureDecoder(byte[] bArr, String str) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void release() {
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void a(@Nullable g.b bVar) {
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void closeSession(byte[] bArr) {
    }
}
