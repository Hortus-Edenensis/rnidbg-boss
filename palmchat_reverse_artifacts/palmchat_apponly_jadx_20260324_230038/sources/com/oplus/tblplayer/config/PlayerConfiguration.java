package com.oplus.tblplayer.config;

import com.oplus.tblplayer.Constants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PlayerConfiguration {
    public static final PlayerConfiguration DEFAULT = new Builder().build();
    public final boolean activeReportModeEnabled;
    public final int bufferForPlaybackAfterRebufferMs;
    public final int bufferForPlaybackMs;
    public final long detachSurfaceTimeOutMs;
    public final boolean deviceVolumeControlEnabled;
    public final boolean encryptDataSourceEnabled;
    public final int exoTsExtractorTimestampSearchBytes;
    public final int extractorMode;
    public final boolean highPerformanceEnabled;
    public final boolean loadBufferConfigEnable;
    public final boolean lowMemoryModeEnabled;
    public final int maxBufferMs;
    public final int minBufferMs;
    public final boolean oplusVPPFilterEnabled;
    public final int rendererMode;
    public final boolean retryWithHttpUrl;
    public final boolean videoEffectModeEnabled;
    public final int videoSoftRenderMode;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        boolean activeReportModeEnabled;
        int bufferForPlaybackAfterRebufferMs;
        int bufferForPlaybackMs;
        long detachSurfaceTimeOutMs;
        boolean deviceVolumeControlEnabled;
        boolean encryptDataSourceEnabled;
        int exoTsExtractorTimestampSearchBytes;
        private int extractorMode;
        boolean highPerformanceEnabled;
        boolean loadBufferConfigEnable;
        boolean lowMemoryModeEnabled;
        int maxBufferMs;
        int minBufferMs;
        boolean oplusVPPFilterEnabled;
        private int rendererMode;
        boolean retryWithHttpUrl;
        boolean videoEffectModeEnabled;
        private int videoSoftRenderMode;

        public Builder() {
            this.rendererMode = 0;
            this.extractorMode = 0;
            this.videoSoftRenderMode = 0;
            this.highPerformanceEnabled = false;
            this.oplusVPPFilterEnabled = false;
            this.lowMemoryModeEnabled = false;
            this.activeReportModeEnabled = false;
            this.encryptDataSourceEnabled = false;
            this.loadBufferConfigEnable = false;
            this.retryWithHttpUrl = false;
            this.maxBufferMs = 50000;
            this.minBufferMs = 50000;
            this.bufferForPlaybackMs = 500;
            this.bufferForPlaybackAfterRebufferMs = 5000;
            this.videoEffectModeEnabled = false;
            this.deviceVolumeControlEnabled = false;
            this.detachSurfaceTimeOutMs = 2000L;
            this.exoTsExtractorTimestampSearchBytes = Constants.DEFAULT_TBL_INCREASED_TS_SEARCH_BYTES;
        }

        public PlayerConfiguration build() {
            return new PlayerConfiguration(this);
        }

        public Builder setActiveReportModeEnabled(boolean z) {
            this.activeReportModeEnabled = z;
            return this;
        }

        public Builder setBufferForPlaybackAfterRebufferMs(int i) {
            this.bufferForPlaybackAfterRebufferMs = i;
            return this;
        }

        public Builder setBufferForPlaybackMs(int i) {
            this.bufferForPlaybackMs = i;
            return this;
        }

        public Builder setDetachSurfaceTimeOutMs(long j) {
            this.detachSurfaceTimeOutMs = j;
            return this;
        }

        public Builder setDeviceVolumeControlEnabled(boolean z) {
            this.deviceVolumeControlEnabled = z;
            return this;
        }

        public Builder setExtractorMode(int i) {
            this.extractorMode = i;
            return this;
        }

        public Builder setHighPerformanceEnabled(boolean z) {
            this.highPerformanceEnabled = z;
            return this;
        }

        public Builder setLoadBufferConfigEnable(boolean z) {
            this.loadBufferConfigEnable = z;
            return this;
        }

        public Builder setLowMemoryModeEnabled(boolean z) {
            this.lowMemoryModeEnabled = z;
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

        public Builder setOplusVPPFilterEnabled(boolean z) {
            this.oplusVPPFilterEnabled = z;
            return this;
        }

        public Builder setRendererMode(int i) {
            this.rendererMode = i;
            return this;
        }

        public Builder setRetryWithHttpUrl(boolean z) {
            this.retryWithHttpUrl = z;
            return this;
        }

        public Builder setTBLEncryptDataSourceEnabled(boolean z) {
            this.encryptDataSourceEnabled = z;
            return this;
        }

        public Builder setTsExtractorTimestampSearchBytes(int i) {
            this.exoTsExtractorTimestampSearchBytes = i;
            return this;
        }

        public Builder setVideoEffectModeEnabled(boolean z) {
            this.videoEffectModeEnabled = z;
            return this;
        }

        public Builder setVideoSoftRenderMode(int i) {
            this.videoSoftRenderMode = i;
            return this;
        }

        private Builder(PlayerConfiguration playerConfiguration) {
            this.rendererMode = playerConfiguration.rendererMode;
            this.extractorMode = playerConfiguration.extractorMode;
            this.highPerformanceEnabled = playerConfiguration.highPerformanceEnabled;
            this.oplusVPPFilterEnabled = playerConfiguration.oplusVPPFilterEnabled;
            this.lowMemoryModeEnabled = playerConfiguration.lowMemoryModeEnabled;
            this.activeReportModeEnabled = playerConfiguration.activeReportModeEnabled;
            this.encryptDataSourceEnabled = playerConfiguration.encryptDataSourceEnabled;
            this.retryWithHttpUrl = playerConfiguration.retryWithHttpUrl;
            this.loadBufferConfigEnable = playerConfiguration.loadBufferConfigEnable;
            this.maxBufferMs = playerConfiguration.maxBufferMs;
            this.minBufferMs = playerConfiguration.minBufferMs;
            this.bufferForPlaybackMs = playerConfiguration.bufferForPlaybackMs;
            this.bufferForPlaybackAfterRebufferMs = playerConfiguration.bufferForPlaybackAfterRebufferMs;
            this.videoEffectModeEnabled = playerConfiguration.videoEffectModeEnabled;
            this.deviceVolumeControlEnabled = playerConfiguration.deviceVolumeControlEnabled;
            this.detachSurfaceTimeOutMs = playerConfiguration.detachSurfaceTimeOutMs;
            this.exoTsExtractorTimestampSearchBytes = playerConfiguration.exoTsExtractorTimestampSearchBytes;
        }
    }

    private PlayerConfiguration(Builder builder) {
        this.rendererMode = builder.rendererMode;
        this.extractorMode = builder.extractorMode;
        this.highPerformanceEnabled = builder.highPerformanceEnabled;
        this.oplusVPPFilterEnabled = builder.oplusVPPFilterEnabled;
        this.lowMemoryModeEnabled = builder.lowMemoryModeEnabled;
        this.videoSoftRenderMode = builder.videoSoftRenderMode;
        this.activeReportModeEnabled = builder.activeReportModeEnabled;
        this.encryptDataSourceEnabled = builder.encryptDataSourceEnabled;
        this.loadBufferConfigEnable = builder.loadBufferConfigEnable;
        this.retryWithHttpUrl = builder.retryWithHttpUrl;
        this.maxBufferMs = builder.maxBufferMs;
        this.minBufferMs = builder.minBufferMs;
        this.bufferForPlaybackMs = builder.bufferForPlaybackMs;
        this.bufferForPlaybackAfterRebufferMs = builder.bufferForPlaybackAfterRebufferMs;
        this.videoEffectModeEnabled = builder.videoEffectModeEnabled;
        this.deviceVolumeControlEnabled = builder.deviceVolumeControlEnabled;
        this.detachSurfaceTimeOutMs = builder.detachSurfaceTimeOutMs;
        this.exoTsExtractorTimestampSearchBytes = builder.exoTsExtractorTimestampSearchBytes;
    }

    public Builder buildUpon() {
        return new Builder();
    }
}
