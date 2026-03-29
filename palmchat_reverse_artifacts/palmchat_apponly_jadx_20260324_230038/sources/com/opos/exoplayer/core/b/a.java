package com.opos.exoplayer.core.b;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.opos.exoplayer.core.util.m;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(16)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8111a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    private final String e;
    private final MediaCodecInfo.CodecCapabilities f;

    private a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        this.f8111a = (String) com.opos.exoplayer.core.util.a.a(str);
        this.e = str2;
        this.f = codecCapabilities;
        boolean z3 = true;
        this.b = (z || codecCapabilities == null || !a(codecCapabilities)) ? false : true;
        this.c = codecCapabilities != null && c(codecCapabilities);
        if (!z2 && (codecCapabilities == null || !e(codecCapabilities))) {
            z3 = false;
        }
        this.d = z3;
    }

    private static int a(String str, String str2, int i) {
        if (i > 1 || ((y.f8407a >= 26 && i > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i;
        }
        int i2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        com.opos.cmn.an.f.a.c("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
        return i2;
    }

    private void c(String str) {
        com.opos.cmn.an.f.a.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f8111a + ", " + this.e + "] [" + y.e + "]");
    }

    private void d(String str) {
        com.opos.cmn.an.f.a.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f8111a + ", " + this.e + "] [" + y.e + "]");
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return y.f8407a >= 21 && f(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    @TargetApi(21)
    public boolean b(int i) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        if (codecCapabilities == null) {
            str = "channelCount.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "channelCount.aCaps";
            } else {
                if (a(this.f8111a, this.e, audioCapabilities.getMaxInputChannelCount()) >= i) {
                    return true;
                }
                str = "channelCount.support, " + i;
            }
        }
        c(str);
        return false;
    }

    @TargetApi(19)
    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return y.f8407a >= 21 && d(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    @TargetApi(21)
    public Point a(int i, int i2) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        if (codecCapabilities == null) {
            str = "align.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities != null) {
                int widthAlignment = videoCapabilities.getWidthAlignment();
                int heightAlignment = videoCapabilities.getHeightAlignment();
                return new Point(y.a(i, widthAlignment) * widthAlignment, y.a(i2, heightAlignment) * heightAlignment);
            }
            str = "align.vCaps";
        }
        c(str);
        return null;
    }

    public static a a(String str) {
        return new a(str, null, null, false, false);
    }

    public boolean b(String str) {
        String strD;
        StringBuilder sb;
        String str2;
        if (str == null || this.e == null || (strD = m.d(str)) == null) {
            return true;
        }
        if (this.e.equals(strD)) {
            Pair<Integer, Integer> pairA = d.a(str);
            if (pairA == null) {
                return true;
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
                if (codecProfileLevel.profile == ((Integer) pairA.first).intValue() && codecProfileLevel.level >= ((Integer) pairA.second).intValue()) {
                    return true;
                }
            }
            sb = new StringBuilder();
            str2 = "codec.profileLevel, ";
        } else {
            sb = new StringBuilder();
            str2 = "codec.mime ";
        }
        sb.append(str2);
        sb.append(str);
        sb.append(", ");
        sb.append(strD);
        c(sb.toString());
        return false;
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, z, z2);
    }

    @TargetApi(21)
    public boolean a(int i) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        if (codecCapabilities == null) {
            str = "sampleRate.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "sampleRate.aCaps";
            } else {
                if (audioCapabilities.isSampleRateSupported(i)) {
                    return true;
                }
                str = "sampleRate.support, " + i;
            }
        }
        c(str);
        return false;
    }

    @TargetApi(21)
    public boolean a(int i, int i2, double d) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        if (codecCapabilities == null) {
            str = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                str = "sizeAndRate.vCaps";
            } else {
                if (a(videoCapabilities, i, i2, d)) {
                    return true;
                }
                if (i < i2 && a(videoCapabilities, i2, i, d)) {
                    d("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d);
                    return true;
                }
                str = "sizeAndRate.support, " + i + "x" + i2 + "x" + d;
            }
        }
        c(str);
        return false;
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return y.f8407a >= 19 && b(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        return (d == -1.0d || d <= 0.0d) ? videoCapabilities.isSizeSupported(i, i2) : videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }

    public MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }
}
