package com.oplus.tblplayer.config;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class LoadControlConfig {
    public final int bufferForPlaybackAfterRebufferMs;
    public final int bufferForPlaybackMs;
    public final boolean loadControlEnable;
    public final int maxBufferMs;
    public final int minBufferMs;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        public int maxBufferMs = 50000;
        public int minBufferMs = 50000;
        public int bufferForPlaybackMs = 500;
        public int bufferForPlaybackAfterRebufferMs = 500;
        public boolean loadControlEnable = false;

        public LoadControlConfig build() {
            return new LoadControlConfig(this.loadControlEnable, this.maxBufferMs, this.minBufferMs, this.bufferForPlaybackMs, this.bufferForPlaybackAfterRebufferMs);
        }

        public Builder setBufferForPlaybackAfterRebufferMs(int i) {
            this.bufferForPlaybackAfterRebufferMs = i;
            return this;
        }

        public Builder setBufferForPlaybackMs(int i) {
            this.bufferForPlaybackMs = i;
            return this;
        }

        public Builder setLoadControlEnable(boolean z) {
            this.loadControlEnable = z;
            return this;
        }

        public Builder setMaxBufferMs(int i) {
            this.maxBufferMs = i;
            return this;
        }

        public Builder setMinBufferMs(int i) {
            this.minBufferMs = i;
            return this;
        }
    }

    private LoadControlConfig(boolean z, int i, int i2, int i3, int i4) {
        this.loadControlEnable = z;
        this.maxBufferMs = i;
        this.minBufferMs = i2;
        this.bufferForPlaybackMs = i3;
        this.bufferForPlaybackAfterRebufferMs = i4;
    }

    public String toString() {
        return "CustomizedLoadControlConfig{loadControlEnable=" + this.loadControlEnable + ", maxBufferMs=" + this.maxBufferMs + ", minBufferMs=" + this.minBufferMs + ", bufferForPlaybackMs=" + this.bufferForPlaybackMs + ", bufferForPlaybackAfterRebufferMs=" + this.bufferForPlaybackAfterRebufferMs + "}";
    }
}
