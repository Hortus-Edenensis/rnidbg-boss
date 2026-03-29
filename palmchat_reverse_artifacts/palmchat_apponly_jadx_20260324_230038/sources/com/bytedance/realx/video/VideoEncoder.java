package com.bytedance.realx.video;

import androidx.annotation.Nullable;
import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.EglBase14;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface VideoEncoder {

    /* JADX INFO: compiled from: SearchBox */
    public enum BitrateMode {
        AUTO(0),
        VBR(1),
        CBR(2);

        private int value;

        BitrateMode(int i) {
            this.value = i;
        }

        public static BitrateMode fromValue(int i) {
            return i != 0 ? i != 1 ? i != 2 ? AUTO : CBR : VBR : AUTO;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Callback {
        void onEncodedFrame(EncodedImage encodedImage, CodecSpecificInfo codecSpecificInfo);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class CodecSpecificInfo {
        public RXVideoCodecStandard codec_standard;

        public CodecSpecificInfo(RXVideoCodecStandard rXVideoCodecStandard) {
            this.codec_standard = rXVideoCodecStandard;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum EncodeMode {
        COMMON(0),
        CLOUD_GAME(1),
        CONFERENCE(2),
        LIVE(3);

        private int value;

        EncodeMode(int i) {
            this.value = i;
        }

        public static EncodeMode fromValue(int i) {
            return i != 1 ? i != 2 ? i != 3 ? COMMON : LIVE : CONFERENCE : CLOUD_GAME;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum ScaleMode {
        AUTO(0),
        STRETCH(1),
        FIT_WITH_CROPPING(2),
        FIT_WITH_FILLING(3);

        private int value;

        ScaleMode(int i) {
            this.value = i;
        }

        public static ScaleMode fromValue(int i) {
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? AUTO : FIT_WITH_FILLING : FIT_WITH_CROPPING : STRETCH : AUTO;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Settings {
        public final int bFrameNum;
        public final BitrateMode bitrateMode;
        public final boolean closeSetProfile;
        public final boolean enableQpSetting;
        public final EncodeMode encodeMode;
        public final int height;
        public final int matrixId;
        public final int maxIQp;
        public final int maxQp;
        public final int minIQp;
        public final int minQp;
        public final int primaryId;
        public final int rangeId;
        public final ScaleMode scaleMode;
        public final EglBase14.Context sharedContext;
        public int targetBps;
        public final int targetFps;
        public final int targetKeyFrameIntervalMs;
        public final int temporalLayerNum;
        public final int transferId;
        public final boolean useSurfaceMode;
        public final int width;

        @CalledByNative("Settings")
        public Settings(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, boolean z, int i14, int i15, int i16, boolean z2, boolean z3, int i17, int i18, EglBase.Context context) {
            this.width = i;
            this.height = i2;
            this.scaleMode = ScaleMode.fromValue(i3);
            this.targetBps = i4;
            this.targetFps = i5;
            this.primaryId = i6;
            this.transferId = i7;
            this.matrixId = i8;
            this.rangeId = i9;
            this.maxQp = i10;
            this.minQp = i11;
            this.temporalLayerNum = i14;
            this.bitrateMode = BitrateMode.fromValue(i15);
            this.targetKeyFrameIntervalMs = i16;
            this.closeSetProfile = z2;
            this.useSurfaceMode = z3;
            this.maxIQp = i12;
            this.minIQp = i13;
            this.bFrameNum = i18;
            this.enableQpSetting = z;
            this.encodeMode = EncodeMode.fromValue(i17);
            if (context instanceof EglBase14.Context) {
                this.sharedContext = (EglBase14.Context) context;
            } else {
                this.sharedContext = null;
            }
        }
    }

    @CalledByNative
    VideoCodecStatus encode(RXVideoFrameInterface rXVideoFrameInterface, boolean z);

    @CalledByNative
    VideoCodecStatus initEncode(Settings settings, Callback callback);

    @CalledByNative
    VideoCodecStatus release();

    @CalledByNative
    VideoCodecStatus requestKeyFrame();

    @CalledByNative
    VideoCodecStatus setPrivateParam(String str, String str2);

    @CalledByNative
    VideoCodecStatus setRateAllocation(int i, int i2);

    /* JADX INFO: compiled from: SearchBox */
    public static class ScalingSettings {
        public static final ScalingSettings OFF = new ScalingSettings();

        @Nullable
        public final Integer high;

        @Nullable
        public final Integer low;
        public final boolean on;

        public ScalingSettings(int i, int i2) {
            this.on = true;
            this.low = Integer.valueOf(i);
            this.high = Integer.valueOf(i2);
        }

        public String toString() {
            if (!this.on) {
                return "OFF";
            }
            return "[ " + this.low + ", " + this.high + " ]";
        }

        private ScalingSettings() {
            this.on = false;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean z) {
            this.on = z;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean z, int i, int i2) {
            this.on = z;
            this.low = Integer.valueOf(i);
            this.high = Integer.valueOf(i2);
        }
    }
}
