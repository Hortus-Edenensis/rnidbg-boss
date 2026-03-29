package com.oplus.tblplayer.misc;

import com.oplus.tblplayer.Constants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MediaInfo implements Constants {
    public static final int RENDERER_SUPPORT_HARDWARE = 3;
    public static final int RENDERER_SUPPORT_HARDWARE_TO_SOFTWARE = 4;
    public static final int RENDERER_SUPPORT_NO_TRACK = 1;
    public static final int RENDERER_SUPPORT_SOFTWARE = 5;
    public static final int RENDERER_SUPPORT_UNSET = 0;
    public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACK = 2;
    public static final String RENDERER_TYPE_FF_AUDIO = "FF_AUDIO";
    public static final String RENDERER_TYPE_FF_VIDEO = "FF_VIDEO";
    public static final String RENDERER_TYPE_MC_AUDIO = "MC_AUDIO";
    public static final String RENDERER_TYPE_MC_VIDEO = "MC_VIDEO";
    public static final String RENDERER_TYPE_METADATA = "METADATA";
    public static final String RENDERER_TYPE_NONE = "None";
    public static final String RENDERER_TYPE_NOT_LOAD = "NOT_LOAD";
    public static final String RENDERER_TYPE_TEXT = "TEXT";
    public static final String RENDERER_TYPE_UNKNOWN = "Unknown";
    public String audioDecoder;
    public String audioMimeType;
    public int audioRendererSupport;
    public int audioSampleRate;
    public int bitrate;
    public int height;
    public int mediaContentType;
    public String mediaPlayerName;
    public String mediaUrl;
    public String videoDecoder;
    public float videoFps;
    public String videoMimeType;
    public int videoRendererSupport;
    public int width;

    public MediaInfo() {
        this.width = -1;
        this.height = -1;
        this.bitrate = -1;
        this.videoFps = -1.0f;
        this.videoRendererSupport = 0;
        this.audioRendererSupport = 0;
    }

    public String getBitrateString() {
        int i = this.bitrate;
        return i <= 0 ? Constants.STRING_VALUE_UNSET : Integer.toString(i);
    }

    public String getResolutionString() {
        if (this.width <= 0 || this.height <= 0) {
            return Constants.STRING_VALUE_UNSET;
        }
        return this.width + " x " + this.height;
    }

    public String getVideoFpsString() {
        float f = this.videoFps;
        return f <= 0.0f ? Constants.STRING_VALUE_UNSET : Float.toString(f);
    }

    public String toString() {
        return "MediaInfo{mediaPlayerName=" + this.mediaPlayerName + ", mediaUrl=" + this.mediaUrl + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", videoMimeType=" + this.videoMimeType + ", audioMimeType=" + this.audioMimeType + ", videoFps=" + this.videoFps + ", audioSampleRate=" + this.audioSampleRate + ", videoDecoder=" + this.videoDecoder + ", videoDecoderType=" + this.videoRendererSupport + ", audioDecoder=" + this.audioDecoder + ", audioDecoderType=" + this.audioRendererSupport + "}";
    }

    public MediaInfo(String str) {
        this(str, 3);
    }

    public MediaInfo(String str, int i) {
        this.width = -1;
        this.height = -1;
        this.bitrate = -1;
        this.videoFps = -1.0f;
        this.videoRendererSupport = 0;
        this.audioRendererSupport = 0;
        this.mediaUrl = str;
        this.mediaContentType = i;
    }
}
