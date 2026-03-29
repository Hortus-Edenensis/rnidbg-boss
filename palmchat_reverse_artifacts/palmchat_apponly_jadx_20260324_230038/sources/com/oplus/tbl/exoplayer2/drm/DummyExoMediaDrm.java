package com.oplus.tbl.exoplayer2.drm;

import android.media.MediaDrmException;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.drm.DrmInitData;
import com.oplus.tbl.exoplayer2.drm.ExoMediaDrm;
import com.oplus.tbl.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@RequiresApi(18)
public final class DummyExoMediaDrm implements ExoMediaDrm {
    public static DummyExoMediaDrm getInstance() {
        return new DummyExoMediaDrm();
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public ExoMediaCrypto createMediaCrypto(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public Class<UnsupportedMediaCrypto> getExoMediaCryptoType() {
        return UnsupportedMediaCrypto.class;
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) {
        throw new IllegalStateException();
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    @Nullable
    public PersistableBundle getMetrics() {
        return null;
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public byte[] getPropertyByteArray(String str) {
        return Util.EMPTY_BYTE_ARRAY;
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public String getPropertyString(String str) {
        return "";
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        throw new IllegalStateException();
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public byte[] openSession() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    @Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public void provideProvisionResponse(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public void acquire() {
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public void release() {
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public void closeSession(byte[] bArr) {
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public void setOnEventListener(@Nullable ExoMediaDrm.OnEventListener onEventListener) {
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public void setOnExpirationUpdateListener(@Nullable ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public void setOnKeyStatusChangeListener(@Nullable ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public void setPropertyByteArray(String str, byte[] bArr) {
    }

    @Override // com.oplus.tbl.exoplayer2.drm.ExoMediaDrm
    public void setPropertyString(String str, String str2) {
    }
}
