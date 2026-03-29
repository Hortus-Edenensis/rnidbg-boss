package com.oplus.tblplayer.monitor.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class StuckReport {
    public BaseInfo baseInfo;
    public NetInfo netInfo;
    public SrcInfo srcInfo;

    /* JADX INFO: compiled from: SearchBox */
    public static class BaseInfo {
        public int appCpuRatio;
        public int decoderMode;
        public float memoryUsage;
        public int stuckCode;
        public long stuckDurationMs;
        public long stuckTimeMs;
        public int stuckType;
        public float temperature;
        public int totalCpuRatio;
        public int videoInputFps;
        public int videoOutputFps;
        public int videoRenderFps;

        public BaseInfo(int i, int i2, int i3, int i4, int i5, float f, float f2, int i6, int i7, int i8, long j, long j2) {
            this.videoInputFps = i;
            this.videoOutputFps = i2;
            this.videoRenderFps = i3;
            this.appCpuRatio = i4;
            this.totalCpuRatio = i5;
            this.temperature = f;
            this.memoryUsage = f2;
            this.decoderMode = i6;
            this.stuckType = i7;
            this.stuckCode = i8;
            this.stuckTimeMs = j;
            this.stuckDurationMs = j2;
        }

        public String toString() {
            return "BaseInfo{videoInputFps=" + this.videoInputFps + ", videoOutputFps=" + this.videoOutputFps + ", videoRenderFps=" + this.videoRenderFps + ", appCpuRatio=" + this.appCpuRatio + ", totalCpuRatio=" + this.totalCpuRatio + ", temperature=" + this.temperature + ", memoryUsage=" + this.memoryUsage + ", decoderMode=" + this.decoderMode + ", stuckType=" + this.stuckType + ", stuckCode=" + this.stuckCode + ", stuckTimeMs=" + this.stuckTimeMs + ", stuckDurationMs=" + this.stuckDurationMs + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private static final float NO_VALUE_FLOAT = 0.0f;
        private static final int NO_VALUE_INTEGER = 0;
        private static final long NO_VALUE_LONG = 0;
        private static final String NO_VALUE_STRING = "NULL";
        String mediaUrl = NO_VALUE_STRING;
        String containerMimeType = NO_VALUE_STRING;
        int bitrate = 0;
        long mediaDuration = 0;
        int width = 0;
        int height = 0;
        float fps = 0.0f;
        int videoBitrate = 0;
        String videoMimeType = NO_VALUE_STRING;
        int sampleRate = 0;
        int audioBitrate = 0;
        String audioMimeType = NO_VALUE_STRING;
        int contentType = 0;
        boolean isLive = false;
        String netType = NO_VALUE_STRING;
        long downloadSpeed = 0;
        int wifiRssi = 0;
        int lteSignal = 0;
        boolean supportPreCache = false;
        long maxCacheFileSize = 0;
        long maxCacheDirSize = 0;
        long alreadyPreCachedBytes = 0;
        long totalCachedBytes = 0;
        long totalBufferedDurationMs = 0;
        long totalBytesTransferred = 0;
        long reBufferCount = 0;
        long reBufferTimeMs = 0;
        int videoInputFps = 0;
        int videoOutputFps = 0;
        int videoRenderFps = 0;
        int appCpuRatio = 0;
        int totalCpuRatio = 0;
        float temperature = 0.0f;
        float memoryUsage = 0.0f;
        int decoderMode = 0;
        int stuckType = 0;
        int stuckCode = 0;
        long stuckTimeMs = 0;
        long stuckDurationMs = 0;

        public StuckReport build() {
            return new StuckReport(new SrcInfo(this.mediaUrl, this.containerMimeType, this.bitrate, this.mediaDuration, this.width, this.height, this.fps, this.videoBitrate, this.videoMimeType, this.sampleRate, this.audioBitrate, this.audioMimeType, this.contentType, this.isLive), new NetInfo(this.netType, this.downloadSpeed, this.wifiRssi, this.lteSignal, this.supportPreCache, this.maxCacheFileSize, this.maxCacheDirSize, this.alreadyPreCachedBytes, this.totalCachedBytes, this.totalBufferedDurationMs, this.totalBytesTransferred, this.reBufferCount, this.reBufferTimeMs), new BaseInfo(this.videoInputFps, this.videoOutputFps, this.videoRenderFps, this.appCpuRatio, this.totalCpuRatio, this.temperature, this.memoryUsage, this.decoderMode, this.stuckType, this.stuckCode, this.stuckTimeMs, this.stuckDurationMs));
        }

        public Builder setAlreadyPreCachedBytes(long j) {
            this.alreadyPreCachedBytes = j;
            return this;
        }

        public Builder setAppCpuRatio(int i) {
            this.appCpuRatio = i;
            return this;
        }

        public Builder setAudioBitrate(int i) {
            this.audioBitrate = i;
            return this;
        }

        public Builder setAudioMimeType(String str) {
            this.audioMimeType = str;
            return this;
        }

        public Builder setBitrate(int i) {
            this.bitrate = i;
            return this;
        }

        public Builder setContainerMimeType(String str) {
            this.containerMimeType = str;
            return this;
        }

        public Builder setContentType(int i) {
            this.contentType = i;
            return this;
        }

        public Builder setDecoderMode(int i) {
            this.decoderMode = i;
            return this;
        }

        public Builder setDownloadSpeed(long j) {
            this.downloadSpeed = j;
            return this;
        }

        public Builder setFps(float f) {
            this.fps = f;
            return this;
        }

        public Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setLive(boolean z) {
            this.isLive = z;
            return this;
        }

        public Builder setLteSignal(int i) {
            this.lteSignal = i;
            return this;
        }

        public Builder setMaxCacheDirSize(long j) {
            this.maxCacheDirSize = j;
            return this;
        }

        public Builder setMaxCacheFileSize(long j) {
            this.maxCacheFileSize = j;
            return this;
        }

        public Builder setMediaDuration(long j) {
            this.mediaDuration = j;
            return this;
        }

        public Builder setMediaUrl(String str) {
            this.mediaUrl = str;
            return this;
        }

        public Builder setMemoryUsage(float f) {
            this.memoryUsage = f;
            return this;
        }

        public Builder setNetType(String str) {
            this.netType = str;
            return this;
        }

        public Builder setReBufferCount(long j) {
            this.reBufferCount = j;
            return this;
        }

        public Builder setReBufferTimeMs(long j) {
            this.reBufferTimeMs = j;
            return this;
        }

        public Builder setSampleRate(int i) {
            this.sampleRate = i;
            return this;
        }

        public Builder setStuckCode(int i) {
            this.stuckCode = i;
            return this;
        }

        public Builder setStuckDurationMs(long j) {
            this.stuckDurationMs = j;
            return this;
        }

        public Builder setStuckTimeMs(long j) {
            this.stuckTimeMs = j;
            return this;
        }

        public Builder setStuckType(int i) {
            this.stuckType = i;
            return this;
        }

        public Builder setSupportPreCache(boolean z) {
            this.supportPreCache = z;
            return this;
        }

        public Builder setTemperature(float f) {
            this.temperature = f;
            return this;
        }

        public Builder setTotalBufferedDurationMs(long j) {
            this.totalBufferedDurationMs = j;
            return this;
        }

        public Builder setTotalBytesTransferred(long j) {
            this.totalBytesTransferred = j;
            return this;
        }

        public Builder setTotalCachedBytes(long j) {
            this.totalCachedBytes = j;
            return this;
        }

        public Builder setTotalCpuRatio(int i) {
            this.totalCpuRatio = i;
            return this;
        }

        public Builder setVideoBitrate(int i) {
            this.videoBitrate = i;
            return this;
        }

        public Builder setVideoInputFps(int i) {
            this.videoInputFps = i;
            return this;
        }

        public Builder setVideoMimeType(String str) {
            this.videoMimeType = str;
            return this;
        }

        public Builder setVideoOutputFps(int i) {
            this.videoOutputFps = i;
            return this;
        }

        public Builder setVideoRenderFps(int i) {
            this.videoRenderFps = i;
            return this;
        }

        public Builder setWidth(int i) {
            this.width = i;
            return this;
        }

        public Builder setWifiRssi(int i) {
            this.wifiRssi = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class NetInfo {
        public long alreadyPreCachedBytes;
        public long downloadSpeed;
        public int lteSignal;
        public long maxCacheDirSize;
        public long maxCacheFileSize;
        public String netType;
        public long reBufferCount;
        public long reBufferTimeMs;
        public boolean supportPreCache;
        public long totalBufferedDurationMs;
        public long totalBytesTransferred;
        public long totalCachedBytes;
        public int wifiRssi;

        public NetInfo(String str, long j, int i, int i2, boolean z, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
            this.netType = str;
            this.downloadSpeed = j;
            this.wifiRssi = i;
            this.lteSignal = i2;
            this.supportPreCache = z;
            this.maxCacheFileSize = j2;
            this.maxCacheDirSize = j3;
            this.alreadyPreCachedBytes = j4;
            this.totalCachedBytes = j5;
            this.totalBufferedDurationMs = j6;
            this.totalBytesTransferred = j7;
            this.reBufferCount = j8;
            this.reBufferTimeMs = j9;
        }

        public String toString() {
            return "NetInfo{netType='" + this.netType + "', downloadSpeed=" + this.downloadSpeed + ", wifiRssi=" + this.wifiRssi + ", lteSignal=" + this.lteSignal + ", supportPreCache=" + this.supportPreCache + ", maxCacheFileSize=" + this.maxCacheFileSize + ", maxCacheDirSize=" + this.maxCacheDirSize + ", alreadyPreCachedBytes=" + this.alreadyPreCachedBytes + ", totalCachedBytes=" + this.totalCachedBytes + ", totalBufferedDurationMs=" + this.totalBufferedDurationMs + ", totalBytesTransferred=" + this.totalBytesTransferred + ", reBufferCount=" + this.reBufferCount + ", reBufferTimeMs=" + this.reBufferTimeMs + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SrcInfo {
        public int audioBitrate;
        public String audioMimeType;
        public int bitrate;
        public String containerMimeType;
        public int contentType;
        public float fps;
        public int height;
        public boolean isLive;
        public long mediaDuration;
        public String mediaUrl;
        public int sampleRate;
        public int videoBitrate;
        public String videoMimeType;
        public int width;

        public SrcInfo(String str, String str2, int i, long j, int i2, int i3, float f, int i4, String str3, int i5, int i6, String str4, int i7, boolean z) {
            this.mediaUrl = str;
            this.containerMimeType = str2;
            this.bitrate = i;
            this.mediaDuration = j;
            this.width = i2;
            this.height = i3;
            this.fps = f;
            this.videoBitrate = i4;
            this.videoMimeType = str3;
            this.sampleRate = i5;
            this.audioBitrate = i6;
            this.audioMimeType = str4;
            this.contentType = i7;
            this.isLive = z;
        }

        public String toString() {
            return "SrcInfo{mediaUrl='" + this.mediaUrl + "', containerMimeType='" + this.containerMimeType + "', bitrate=" + this.bitrate + ", mediaDuration=" + this.mediaDuration + ", width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", videoBitrate=" + this.videoBitrate + ", videoMimeType='" + this.videoMimeType + "', sampleRate=" + this.sampleRate + ", audioBitrate=" + this.audioBitrate + ", audioMimeType='" + this.audioMimeType + "', contentType=" + this.contentType + ", isLive=" + this.isLive + '}';
        }
    }

    public StuckReport(SrcInfo srcInfo, NetInfo netInfo, BaseInfo baseInfo) {
        this.srcInfo = srcInfo;
        this.netInfo = netInfo;
        this.baseInfo = baseInfo;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String toString() {
        return "StuckReport{srcInfo=" + this.srcInfo + ", netInfo=" + this.netInfo + ", baseInfo=" + this.baseInfo + '}';
    }
}
