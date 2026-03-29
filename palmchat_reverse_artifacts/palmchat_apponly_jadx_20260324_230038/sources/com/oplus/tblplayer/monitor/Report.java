package com.oplus.tblplayer.monitor;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.oplus.tblplayer.exception.IPCException;
import com.oplus.tblplayer.misc.MediaInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class Report implements Parcelable, ErrorCode {
    public static final Parcelable.Creator<Report> CREATOR = new Parcelable.Creator<Report>() { // from class: com.oplus.tblplayer.monitor.Report.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Report createFromParcel(Parcel parcel) {
            return new Report(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Report[] newArray(int i) {
            return new Report[i];
        }
    };
    public static final int NO_VALUE = -1;
    public final long aliveDuration;
    public final float audioFLR;
    public final String audioMimeType;
    public final int audioSampleRate;
    public final long currentPlaybackPositionMs;
    public final int currentPlaybackState;
    public final int errorCode;
    public final String errorRenderer;
    public final IPCException exception;
    public final int firstReadingFromCache;
    public final int height;
    public final int mediaContentType;
    public final String mediaUrl;
    public final long rebufferCount;
    public final long rebufferTimeMs;
    public final long renderedFirstFrameTimeMs;
    public final int rendererSupport;
    public final long totalBufferedDurationMs;
    public final long totalBytesTransferred;
    public final float videoFLR;
    public final float videoFps;
    public final String videoMimeType;
    public final int width;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        long aliveDuration;
        float audioFLR;
        String audioMimeType;
        int audioSampleRate;
        long currentPlaybackPositionMs;
        int currentPlaybackState;
        int errorCode;
        String errorRenderer;
        IPCException exception;
        int firstReadingFromCache;
        int height;
        int mediaContentType;
        String mediaUrl;
        long rebufferCount;
        long rebufferTimeMs;
        long renderedFirstFrameTimeMs;
        int rendererSupport;
        long totalBufferedDurationMs;
        long totalBytesTransferred;
        float videoFLR;
        float videoFps;
        String videoMimeType;
        int width;

        public Builder() {
            this.errorCode = -1;
            this.mediaContentType = -1;
            this.rendererSupport = -1;
            this.width = -1;
            this.height = -1;
            this.videoFps = -1.0f;
            this.audioSampleRate = -1;
            this.renderedFirstFrameTimeMs = -1L;
            this.aliveDuration = -1L;
            this.videoFLR = -1.0f;
            this.audioFLR = -1.0f;
            this.rebufferCount = -1L;
            this.rebufferTimeMs = -1L;
            this.totalBytesTransferred = -1L;
            this.currentPlaybackState = -1;
            this.currentPlaybackPositionMs = -1L;
            this.totalBufferedDurationMs = -1L;
        }

        public Report build() {
            return new Report(this);
        }

        public Builder setAliveDuration(long j) {
            this.aliveDuration = j;
            return this;
        }

        public Builder setAudioFLR(float f) {
            this.audioFLR = f;
            return this;
        }

        public Builder setCurrentPlaybackPositionMs(long j) {
            this.currentPlaybackPositionMs = j;
            return this;
        }

        public Builder setCurrentPlaybackState(int i) {
            this.currentPlaybackState = i;
            return this;
        }

        public Builder setErrorCode(int i) {
            this.errorCode = i;
            return this;
        }

        public Builder setErrorRenderer(String str) {
            this.errorRenderer = str;
            return this;
        }

        public Builder setException(Exception exc) {
            this.exception = IPCException.toIPCException(exc);
            return this;
        }

        public Builder setFirstReadingFromCache(boolean z) {
            this.firstReadingFromCache = z ? 1 : 0;
            return this;
        }

        public Builder setMediaInfo(MediaInfo mediaInfo) {
            if (mediaInfo != null) {
                this.mediaUrl = mediaInfo.mediaUrl;
                this.mediaContentType = mediaInfo.mediaContentType;
                this.rendererSupport = (mediaInfo.videoRendererSupport * 10) + mediaInfo.audioRendererSupport;
                this.width = mediaInfo.width;
                this.height = mediaInfo.height;
                this.videoMimeType = mediaInfo.videoMimeType;
                this.videoFps = mediaInfo.videoFps;
                this.audioSampleRate = mediaInfo.audioSampleRate;
                this.audioMimeType = mediaInfo.audioMimeType;
            }
            return this;
        }

        public Builder setRebufferCount(long j, long j2) {
            this.rebufferCount = j;
            this.rebufferTimeMs = j2;
            return this;
        }

        public Builder setRenderedFirstFrameTimeMs(long j) {
            this.renderedFirstFrameTimeMs = j;
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

        public Builder setVideoFLR(float f) {
            this.videoFLR = f;
            return this;
        }

        private Builder(@NonNull Report report) {
            this.errorCode = -1;
            this.mediaContentType = -1;
            this.rendererSupport = -1;
            this.width = -1;
            this.height = -1;
            this.videoFps = -1.0f;
            this.audioSampleRate = -1;
            this.renderedFirstFrameTimeMs = -1L;
            this.aliveDuration = -1L;
            this.videoFLR = -1.0f;
            this.audioFLR = -1.0f;
            this.rebufferCount = -1L;
            this.rebufferTimeMs = -1L;
            this.totalBytesTransferred = -1L;
            this.currentPlaybackState = -1;
            this.currentPlaybackPositionMs = -1L;
            this.totalBufferedDurationMs = -1L;
            this.errorCode = report.errorCode;
            this.mediaUrl = report.mediaUrl;
            this.mediaContentType = report.mediaContentType;
            this.rendererSupport = report.rendererSupport;
            this.width = report.width;
            this.height = report.height;
            this.videoMimeType = report.videoMimeType;
            this.audioMimeType = report.audioMimeType;
            this.videoFps = report.videoFps;
            this.audioSampleRate = report.audioSampleRate;
            this.renderedFirstFrameTimeMs = report.renderedFirstFrameTimeMs;
            this.aliveDuration = report.aliveDuration;
            this.videoFLR = report.videoFLR;
            this.audioFLR = report.audioFLR;
            this.rebufferCount = report.rebufferCount;
            this.rebufferTimeMs = report.rebufferTimeMs;
            this.firstReadingFromCache = report.firstReadingFromCache;
            this.totalBytesTransferred = report.totalBytesTransferred;
            this.currentPlaybackState = report.currentPlaybackState;
            this.currentPlaybackPositionMs = report.currentPlaybackPositionMs;
            this.totalBufferedDurationMs = report.totalBufferedDurationMs;
            this.errorRenderer = report.errorRenderer;
            this.exception = report.exception;
        }
    }

    public Report(Parcel parcel) {
        this.errorCode = parcel.readInt();
        this.mediaUrl = parcel.readString();
        this.mediaContentType = parcel.readInt();
        this.rendererSupport = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.videoMimeType = parcel.readString();
        this.audioMimeType = parcel.readString();
        this.videoFps = parcel.readFloat();
        this.audioSampleRate = parcel.readInt();
        this.renderedFirstFrameTimeMs = parcel.readLong();
        this.aliveDuration = parcel.readLong();
        this.videoFLR = parcel.readFloat();
        this.audioFLR = parcel.readFloat();
        this.rebufferCount = parcel.readLong();
        this.rebufferTimeMs = parcel.readLong();
        this.firstReadingFromCache = parcel.readInt();
        this.totalBytesTransferred = parcel.readLong();
        this.currentPlaybackState = parcel.readInt();
        this.currentPlaybackPositionMs = parcel.readLong();
        this.totalBufferedDurationMs = parcel.readLong();
        this.errorRenderer = parcel.readString();
        this.exception = (IPCException) parcel.readParcelable(IPCException.class.getClassLoader());
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public Report copyWithBytesTransferred(long j) {
        return buildUpon().setTotalBytesTransferred(j).build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isHitPreCache() {
        return this.firstReadingFromCache > 0;
    }

    public String toString() {
        return "Report{errorCode=" + this.errorCode + ", mediaUrl=" + this.mediaUrl + ", mediaContentType=" + this.mediaContentType + ", rendererSupport=" + this.rendererSupport + ", width=" + this.width + ", height=" + this.height + ", videoMimeType=" + this.videoMimeType + ", audioMimeType=" + this.audioMimeType + ", videoFps=" + this.videoFps + ", audioSampleRate=" + this.audioSampleRate + ", renderedFirstFrameTimeMs=" + this.renderedFirstFrameTimeMs + ", aliveDuration=" + this.aliveDuration + ", videoFLR=" + this.videoFLR + ", audioFLR=" + this.audioFLR + ", rebufferCount=" + this.rebufferCount + ", rebufferTimeMs=" + this.rebufferTimeMs + ", firstReadingFromCache=" + this.firstReadingFromCache + ", totalBytesTransferred=" + this.totalBytesTransferred + ", currentPlaybackState=" + this.currentPlaybackState + ", currentPlaybackPositionMs=" + this.currentPlaybackPositionMs + ", totalBufferedDurationMs=" + this.totalBufferedDurationMs + ", errorRenderer=" + this.errorRenderer + ", exception=" + this.exception + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.mediaUrl);
        parcel.writeInt(this.mediaContentType);
        parcel.writeInt(this.rendererSupport);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.videoMimeType);
        parcel.writeString(this.audioMimeType);
        parcel.writeFloat(this.videoFps);
        parcel.writeInt(this.audioSampleRate);
        parcel.writeLong(this.renderedFirstFrameTimeMs);
        parcel.writeLong(this.aliveDuration);
        parcel.writeFloat(this.videoFLR);
        parcel.writeFloat(this.audioFLR);
        parcel.writeLong(this.rebufferCount);
        parcel.writeLong(this.rebufferTimeMs);
        parcel.writeInt(this.firstReadingFromCache);
        parcel.writeLong(this.totalBytesTransferred);
        parcel.writeInt(this.currentPlaybackState);
        parcel.writeLong(this.currentPlaybackPositionMs);
        parcel.writeLong(this.totalBufferedDurationMs);
        parcel.writeString(this.errorRenderer);
        parcel.writeParcelable(this.exception, i);
    }

    public Report(@NonNull Builder builder) {
        this.errorCode = builder.errorCode;
        this.mediaUrl = builder.mediaUrl;
        this.mediaContentType = builder.mediaContentType;
        this.rendererSupport = builder.rendererSupport;
        this.width = builder.width;
        this.height = builder.height;
        this.videoMimeType = builder.videoMimeType;
        this.audioMimeType = builder.audioMimeType;
        this.videoFps = builder.videoFps;
        this.audioSampleRate = builder.audioSampleRate;
        this.renderedFirstFrameTimeMs = builder.renderedFirstFrameTimeMs;
        this.aliveDuration = builder.aliveDuration;
        this.videoFLR = builder.videoFLR;
        this.audioFLR = builder.audioFLR;
        this.rebufferCount = builder.rebufferCount;
        this.rebufferTimeMs = builder.rebufferTimeMs;
        this.firstReadingFromCache = builder.firstReadingFromCache;
        this.totalBytesTransferred = builder.totalBytesTransferred;
        this.currentPlaybackState = builder.currentPlaybackState;
        this.currentPlaybackPositionMs = builder.currentPlaybackPositionMs;
        this.totalBufferedDurationMs = builder.totalBufferedDurationMs;
        this.errorRenderer = builder.errorRenderer;
        this.exception = builder.exception;
    }
}
