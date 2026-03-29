package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.audio.SpeedProvider;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class SpeedChangeShaderProgram extends PassthroughShaderProgram {
    private long lastSpeedChangeInputTimeUs = -9223372036854775807L;
    private long lastSpeedChangeOutputTimeUs = -9223372036854775807L;
    private final OffsetSpeedProvider speedProvider;

    /* JADX INFO: compiled from: SearchBox */
    public static class OffsetSpeedProvider implements SpeedProvider {
        private long offset;
        private final SpeedProvider speedProvider;

        public OffsetSpeedProvider(SpeedProvider speedProvider) {
            this.speedProvider = speedProvider;
        }

        @Override // androidx.media3.common.audio.SpeedProvider
        public long getNextSpeedChangeTimeUs(long j) {
            long nextSpeedChangeTimeUs = this.speedProvider.getNextSpeedChangeTimeUs(j - this.offset);
            if (nextSpeedChangeTimeUs == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.offset + nextSpeedChangeTimeUs;
        }

        @Override // androidx.media3.common.audio.SpeedProvider
        public float getSpeed(long j) {
            return this.speedProvider.getSpeed(j - this.offset);
        }

        public void setOffset(long j) {
            this.offset = j;
        }
    }

    public SpeedChangeShaderProgram(SpeedProvider speedProvider) {
        this.speedProvider = new OffsetSpeedProvider(speedProvider);
    }

    private long getOutputTimeUs(long j, float f) {
        return (long) (this.lastSpeedChangeOutputTimeUs + ((j - this.lastSpeedChangeInputTimeUs) / f));
    }

    @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        long j2 = this.lastSpeedChangeInputTimeUs;
        if (j2 == -9223372036854775807L) {
            this.lastSpeedChangeInputTimeUs = j;
            this.lastSpeedChangeOutputTimeUs = j;
            this.speedProvider.setOffset(j);
        } else {
            long nextSpeedChangeTimeUs = this.speedProvider.getNextSpeedChangeTimeUs(j2);
            while (nextSpeedChangeTimeUs != -9223372036854775807L && nextSpeedChangeTimeUs <= j) {
                this.lastSpeedChangeOutputTimeUs = getOutputTimeUs(nextSpeedChangeTimeUs, this.speedProvider.getSpeed(this.lastSpeedChangeInputTimeUs));
                this.lastSpeedChangeInputTimeUs = nextSpeedChangeTimeUs;
                nextSpeedChangeTimeUs = this.speedProvider.getNextSpeedChangeTimeUs(nextSpeedChangeTimeUs);
            }
            j = getOutputTimeUs(j, this.speedProvider.getSpeed(j));
        }
        super.queueInputFrame(glObjectsProvider, glTextureInfo, j);
    }

    @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        super.signalEndOfCurrentInputStream();
        this.lastSpeedChangeInputTimeUs = -9223372036854775807L;
        this.lastSpeedChangeOutputTimeUs = -9223372036854775807L;
    }
}
