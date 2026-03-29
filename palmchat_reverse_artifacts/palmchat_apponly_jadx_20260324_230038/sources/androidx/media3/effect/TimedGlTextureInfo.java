package androidx.media3.effect;

import androidx.media3.common.GlTextureInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class TimedGlTextureInfo {
    public final GlTextureInfo glTextureInfo;
    public final long presentationTimeUs;

    public TimedGlTextureInfo(GlTextureInfo glTextureInfo, long j) {
        this.glTextureInfo = glTextureInfo;
        this.presentationTimeUs = j;
    }
}
