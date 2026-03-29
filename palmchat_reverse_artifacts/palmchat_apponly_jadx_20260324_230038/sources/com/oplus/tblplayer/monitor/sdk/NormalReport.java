package com.oplus.tblplayer.monitor.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NormalReport {
    public NetInfo netInfo;
    public PerformanceInfo performanceInfo;
    public SrcInfo srcInfo;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private static final float NO_VALUE_FLOAT = 0.0f;
        private static final int NO_VALUE_INTEGER = 0;
        private static final long NO_VALUE_LONG = 0;
        private static final String NO_VALUE_STRING = "NULL";
        private static final int VIDEO_DECODER_UNKNOWN = 2;
        public String mediaUrl = NO_VALUE_STRING;
        public String containerMimeType = NO_VALUE_STRING;
        public int bitrate = 0;
        public long mediaDuration = 0;
        public int width = 0;
        public int height = 0;
        public float fps = 0.0f;
        int videoBitrate = 0;
        public String videoMimeType = NO_VALUE_STRING;
        public int sampleRate = 0;
        int audioBitrate = 0;
        public String audioMimeType = NO_VALUE_STRING;
        public int contentType = 0;
        public boolean isLive = false;
        int errorCode = 0;
        long loadTimeMs = 0;
        long aliveDurationMs = 0;
        long curPositionMs = 0;
        long reBufferingCount = 0;
        long reBufferingTimeMs = 0;
        float videoFLR = 0.0f;
        int decoderMode = 2;
        public String netType = NO_VALUE_STRING;
        public long downloadSpeed = 0;
        public int wifiRssi = 0;
        public int lteSignal = 0;
        public boolean supportPreCache = false;
        public long maxCacheFileSize = 0;
        public long maxCacheDirSize = 0;
        public long alreadyPreCachedBytes = 0;
        public long totalCachedBytes = 0;
        public long totalBytesTransferred = 0;
        public long totalBufferedDurationMs = 0;

        public NormalReport build() {
            return new NormalReport(new SrcInfo(this.mediaUrl, this.containerMimeType, this.bitrate, this.mediaDuration, this.width, this.height, this.fps, this.videoBitrate, this.videoMimeType, this.sampleRate, this.audioBitrate, this.audioMimeType, this.contentType, this.isLive), new PerformanceInfo(this.errorCode, this.loadTimeMs, this.aliveDurationMs, this.curPositionMs, this.reBufferingCount, this.reBufferingTimeMs, this.videoFLR, this.decoderMode), new NetInfo(this.netType, this.downloadSpeed, this.wifiRssi, this.lteSignal, this.supportPreCache, this.maxCacheFileSize, this.maxCacheDirSize, this.alreadyPreCachedBytes, this.totalCachedBytes, this.totalBytesTransferred, this.totalBufferedDurationMs));
        }

        public Builder setAliveDurationMs(long j) {
            this.aliveDurationMs = j;
            return this;
        }

        public Builder setAlreadyPreCachedBytes(long j) {
            this.alreadyPreCachedBytes = j;
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

        public Builder setCurPositionMs(long j) {
            this.curPositionMs = j;
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

        public Builder setErrorCode(int i) {
            this.errorCode = i;
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

        public Builder setLoadTimeMs(long j) {
            this.loadTimeMs = j;
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

        public Builder setNetType(String str) {
            this.netType = str;
            return this;
        }

        public Builder setReBufferingCount(long j) {
            this.reBufferingCount = j;
            return this;
        }

        public Builder setReBufferingTimeMs(long j) {
            this.reBufferingTimeMs = j;
            return this;
        }

        public Builder setSampleRate(int i) {
            this.sampleRate = i;
            return this;
        }

        public Builder setSupportPreCache(boolean z) {
            this.supportPreCache = z;
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

        public Builder setVideoBitrate(int i) {
            this.videoBitrate = i;
            return this;
        }

        public Builder setVideoFLR(float f) {
            this.videoFLR = f;
            return this;
        }

        public Builder setVideoMimeType(String str) {
            this.videoMimeType = str;
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
        public boolean supportPreCache;
        public long totalBufferedDurationMs;
        public long totalBytesTransferred;
        public long totalCachedBytes;
        public int wifiRssi;

        public NetInfo(String str, long j, int i, int i2, boolean z, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.netType = str;
            this.downloadSpeed = j;
            this.wifiRssi = i;
            this.lteSignal = i2;
            this.supportPreCache = z;
            this.maxCacheFileSize = j2;
            this.maxCacheDirSize = j3;
            this.alreadyPreCachedBytes = j4;
            this.totalCachedBytes = j5;
            this.totalBytesTransferred = j6;
            this.totalBufferedDurationMs = j7;
        }

        public String toString() {
            return "NetInfo{netType='" + this.netType + "', downloadSpeed=" + this.downloadSpeed + ", wifiRssi=" + this.wifiRssi + ", lteSignal=" + this.lteSignal + ", supportPreCache=" + this.supportPreCache + ", maxCacheFileSize=" + this.maxCacheFileSize + ", maxCacheDirSize=" + this.maxCacheDirSize + ", alreadyPreCachedBytes=" + this.alreadyPreCachedBytes + ", totalCachedBytes=" + this.totalCachedBytes + ", totalBytesTransferred=" + this.totalBytesTransferred + ", totalBufferedDurationMs=" + this.totalBufferedDurationMs + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class PerformanceInfo {
        public long aliveDurationMs;
        public long curPositionMs;
        public int decoderMode;
        public int errorCode;
        public long loadTimeMs;
        public long reBufferingCount;
        public long reBufferingTimeMs;
        public float videoFLR;

        public PerformanceInfo(int i, long j, long j2, long j3, long j4, long j5, float f, int i2) {
            this.errorCode = i;
            this.loadTimeMs = j;
            this.aliveDurationMs = j2;
            this.curPositionMs = j3;
            this.reBufferingCount = j4;
            this.reBufferingTimeMs = j5;
            this.videoFLR = f;
            this.decoderMode = i2;
        }

        public String toString() {
            return "PerformanceInfo{errorCode=" + this.errorCode + ", loadTimeMs=" + this.loadTimeMs + ", aliveDurationMs=" + this.aliveDurationMs + ", curPositionMs=" + this.curPositionMs + ", reBufferingCount=" + this.reBufferingCount + ", reBufferingTimeMs=" + this.reBufferingTimeMs + ", videoFLR=" + this.videoFLR + ", decoderMode=" + this.decoderMode + '}';
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

    public NormalReport(SrcInfo srcInfo, PerformanceInfo performanceInfo, NetInfo netInfo) {
        this.srcInfo = srcInfo;
        this.performanceInfo = performanceInfo;
        this.netInfo = netInfo;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String toString() {
        return "NormalReport{srcInfo=" + this.srcInfo + ", performanceInfo=" + this.performanceInfo + ", netInfo=" + this.netInfo + '}';
    }
}
