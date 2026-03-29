package com.bytedance.realx.video;

import android.view.Surface;
import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface VideoDecoder {

    /* JADX INFO: compiled from: SearchBox */
    public interface Callback {
        void onDecodedFrame(RXVideoFrameInterface rXVideoFrameInterface);

        void onDecoderInited(long j);

        void onMediaCodecStatus(VideoCodecStatus videoCodecStatus, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class DecodeInfo {
        public final boolean isMissingFrames;
        public final long renderTimeMs;

        public DecodeInfo(boolean z, long j) {
            this.isMissingFrames = z;
            this.renderTimeMs = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Settings {
        public final boolean enableBFrameDecode;
        public final boolean enableRecreateByResolution;
        public final boolean enableSmoothOutput;
        public final boolean enableSurfaceTextureReuse;
        public final boolean enableYUVOutput;
        public final int height;
        public final boolean latencyInsensitiveMode;
        public final int numberOfCores;
        public final boolean outputByDts;
        public final int width;

        @CalledByNative("Settings")
        public Settings(int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            this.numberOfCores = i;
            this.width = i2;
            this.height = i3;
            this.outputByDts = z;
            this.enableSmoothOutput = z2;
            this.enableYUVOutput = z3;
            this.latencyInsensitiveMode = z4;
            this.enableSurfaceTextureReuse = z5;
            this.enableRecreateByResolution = z6;
            this.enableBFrameDecode = z7;
        }
    }

    @CalledByNative
    long createNativeVideoDecoder();

    @CalledByNative
    VideoCodecStatus decode(EncodedImage encodedImage);

    @CalledByNative
    void disableExternalSurface();

    @CalledByNative
    String getImplementationName();

    @CalledByNative
    boolean getPrefersLateDecoding();

    @CalledByNative
    VideoCodecStatus initDecode(Settings settings, Callback callback);

    @CalledByNative
    void onFrame(RXVideoFrameInterface rXVideoFrameInterface);

    @CalledByNative
    VideoCodecStatus release();

    @CalledByNative
    VideoCodecStatus setDeliverParams(boolean z, int i, float f, float f2, int i2);

    @CalledByNative
    void setExternalSurface(Surface surface);

    @CalledByNative
    VideoCodecStatus setPrivateParam(String str, String str2);

    @CalledByNative
    VideoCodecStatus updateSettings(Settings settings);
}
