package androidx.media3.transformer;

import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class AudioEncoderSettings {
    public static final AudioEncoderSettings DEFAULT = new Builder().build();
    public static final int NO_VALUE = -1;
    public final int bitrate;
    public final int profile;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private int profile = -1;
        private int bitrate = -1;

        public AudioEncoderSettings build() {
            return new AudioEncoderSettings(this.profile, this.bitrate);
        }

        public Builder setBitrate(int i) {
            this.bitrate = i;
            return this;
        }

        public Builder setProfile(int i) {
            this.profile = i;
            return this;
        }
    }

    private AudioEncoderSettings(int i, int i2) {
        this.profile = i;
        this.bitrate = i2;
    }
}
