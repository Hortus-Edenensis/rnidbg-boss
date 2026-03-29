package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import defpackage.ef3;
import defpackage.fp3;
import defpackage.g86;
import defpackage.hf3;
import defpackage.if3;
import defpackage.ow0;
import defpackage.vh;
import defpackage.y53;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5902a;
    public final String b;
    public final String c;

    @Nullable
    public final MediaCodecInfo.CodecCapabilities d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(29)
    public static final class a {
        @DoNotInline
        public static int a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
            List supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty() || d.C()) {
                return 0;
            }
            if3.a();
            MediaCodecInfo.VideoCapabilities.PerformancePoint performancePointA = hf3.a(i, i2, (int) d);
            for (int i3 = 0; i3 < supportedPerformancePoints.size(); i3++) {
                if (ef3.a(supportedPerformancePoints.get(i3)).covers(performancePointA)) {
                    return 2;
                }
            }
            return 1;
        }
    }

    @VisibleForTesting
    public d(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f5902a = (String) vh.e(str);
        this.b = str2;
        this.c = str3;
        this.d = codecCapabilities;
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.e = z4;
        this.f = z5;
        this.g = z6;
        this.k = fp3.s(str2);
    }

    public static boolean A(String str) {
        return g86.d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    public static boolean B(String str) {
        if (g86.f17680a <= 22) {
            String str2 = g86.d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean C() {
        String str = g86.b;
        if (!str.equals("sabrina") && !str.equals("boreal")) {
            String str2 = g86.d;
            if (!str2.startsWith("Lenovo TB-X605") && !str2.startsWith("Lenovo TB-X606") && !str2.startsWith("Lenovo TB-X616")) {
                return false;
            }
        }
        return true;
    }

    public static boolean D(String str, int i) {
        if ("video/hevc".equals(str) && 2 == i) {
            String str2 = g86.b;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean E(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(g86.b)) ? false : true;
    }

    public static d F(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new d(str, str2, str3, codecCapabilities, z, z2, z3, (z4 || codecCapabilities == null || !i(codecCapabilities) || B(str)) ? false : true, codecCapabilities != null && u(codecCapabilities), z5 || (codecCapabilities != null && s(codecCapabilities)));
    }

    public static int b(String str, String str2, int i) {
        if (i > 1 || ((g86.f17680a >= 26 && i > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i;
        }
        int i2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        y53.i("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
        return i2;
    }

    @RequiresApi(21)
    public static Point d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(g86.l(i, widthAlignment) * widthAlignment, g86.l(i2, heightAlignment) * heightAlignment);
    }

    @RequiresApi(21)
    public static boolean e(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point pointD = d(videoCapabilities, i, i2);
        int i3 = pointD.x;
        int i4 = pointD.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    public static MediaCodecInfo.CodecProfileLevel[] g(@Nullable MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int iIntValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
        int i = iIntValue >= 180000000 ? 1024 : iIntValue >= 120000000 ? 512 : iIntValue >= 60000000 ? 256 : iIntValue >= 30000000 ? 128 : iIntValue >= 18000000 ? 64 : iIntValue >= 12000000 ? 32 : iIntValue >= 7200000 ? 16 : iIntValue >= 3600000 ? 8 : iIntValue >= 1800000 ? 4 : iIntValue >= 800000 ? 2 : 1;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    public static boolean i(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return g86.f17680a >= 19 && j(codecCapabilities);
    }

    @RequiresApi(19)
    public static boolean j(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return g86.f17680a >= 21 && t(codecCapabilities);
    }

    @RequiresApi(21)
    public static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static boolean u(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return g86.f17680a >= 21 && v(codecCapabilities);
    }

    @RequiresApi(21)
    public static boolean v(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public static boolean z(String str) {
        return "audio/opus".equals(str);
    }

    @Nullable
    @RequiresApi(21)
    public Point c(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return d(videoCapabilities, i, i2);
    }

    public ow0 f(m mVar, m mVar2) {
        int i = !g86.c(mVar.l, mVar2.l) ? 8 : 0;
        if (this.k) {
            if (mVar.t != mVar2.t) {
                i |= 1024;
            }
            if (!this.e && (mVar.q != mVar2.q || mVar.r != mVar2.r)) {
                i |= 512;
            }
            if (!g86.c(mVar.x, mVar2.x)) {
                i |= 2048;
            }
            if (A(this.f5902a) && !mVar.g(mVar2)) {
                i |= 2;
            }
            if (i == 0) {
                return new ow0(this.f5902a, mVar, mVar2, mVar.g(mVar2) ? 3 : 2, 0);
            }
        } else {
            if (mVar.y != mVar2.y) {
                i |= 4096;
            }
            if (mVar.z != mVar2.z) {
                i |= 8192;
            }
            if (mVar.A != mVar2.A) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.b)) {
                Pair<Integer, Integer> pairR = MediaCodecUtil.r(mVar);
                Pair<Integer, Integer> pairR2 = MediaCodecUtil.r(mVar2);
                if (pairR != null && pairR2 != null) {
                    int iIntValue = ((Integer) pairR.first).intValue();
                    int iIntValue2 = ((Integer) pairR2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new ow0(this.f5902a, mVar, mVar2, 3, 0);
                    }
                }
            }
            if (!mVar.g(mVar2)) {
                i |= 32;
            }
            if (z(this.b)) {
                i |= 2;
            }
            if (i == 0) {
                return new ow0(this.f5902a, mVar, mVar2, 1, 0);
            }
        }
        return new ow0(this.f5902a, mVar, mVar2, 0, i);
    }

    public MediaCodecInfo.CodecProfileLevel[] h() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @RequiresApi(21)
    public boolean k(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            y("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            y("channelCount.aCaps");
            return false;
        }
        if (b(this.f5902a, this.b, audioCapabilities.getMaxInputChannelCount()) >= i) {
            return true;
        }
        y("channelCount.support, " + i);
        return false;
    }

    @RequiresApi(21)
    public boolean l(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            y("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            y("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        y("sampleRate.support, " + i);
        return false;
    }

    public final boolean m(m mVar, boolean z) {
        Pair<Integer, Integer> pairR = MediaCodecUtil.r(mVar);
        if (pairR == null) {
            return true;
        }
        int iIntValue = ((Integer) pairR.first).intValue();
        int iIntValue2 = ((Integer) pairR.second).intValue();
        if ("video/dolby-vision".equals(mVar.l)) {
            if (!"video/avc".equals(this.b)) {
                iIntValue = "video/hevc".equals(this.b) ? 2 : 8;
            }
            iIntValue2 = 0;
        }
        if (!this.k && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrH = h();
        if (g86.f17680a <= 23 && "video/x-vnd.on2.vp9".equals(this.b) && codecProfileLevelArrH.length == 0) {
            codecProfileLevelArrH = g(this.d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrH) {
            if (codecProfileLevel.profile == iIntValue && ((codecProfileLevel.level >= iIntValue2 || !z) && !D(this.b, iIntValue))) {
                return true;
            }
        }
        y("codec.profileLevel, " + mVar.i + ", " + this.c);
        return false;
    }

    public boolean n(m mVar) {
        return q(mVar) && m(mVar, false);
    }

    public boolean o(m mVar) throws MediaCodecUtil.DecoderQueryException {
        int i;
        if (!q(mVar) || !m(mVar, true)) {
            return false;
        }
        if (!this.k) {
            if (g86.f17680a >= 21) {
                int i2 = mVar.z;
                if (i2 != -1 && !l(i2)) {
                    return false;
                }
                int i3 = mVar.y;
                if (i3 != -1 && !k(i3)) {
                    return false;
                }
            }
            return true;
        }
        int i4 = mVar.q;
        if (i4 <= 0 || (i = mVar.r) <= 0) {
            return true;
        }
        if (g86.f17680a >= 21) {
            return w(i4, i, mVar.s);
        }
        boolean z = i4 * i <= MediaCodecUtil.P();
        if (!z) {
            y("legacyFrameSize, " + mVar.q + "x" + mVar.r);
        }
        return z;
    }

    public boolean p() {
        if (g86.f17680a >= 29 && "video/x-vnd.on2.vp9".equals(this.b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : h()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean q(m mVar) {
        return this.b.equals(mVar.l) || this.b.equals(MediaCodecUtil.m(mVar));
    }

    public boolean r(m mVar) {
        if (this.k) {
            return this.e;
        }
        Pair<Integer, Integer> pairR = MediaCodecUtil.r(mVar);
        return pairR != null && ((Integer) pairR.first).intValue() == 42;
    }

    public String toString() {
        return this.f5902a;
    }

    @RequiresApi(21)
    public boolean w(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            y("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            y("sizeAndRate.vCaps");
            return false;
        }
        if (g86.f17680a >= 29) {
            int iA = a.a(videoCapabilities, i, i2, d);
            if (iA == 2) {
                return true;
            }
            if (iA == 1) {
                y("sizeAndRate.cover, " + i + "x" + i2 + "@" + d);
                return false;
            }
        }
        if (!e(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !E(this.f5902a) || !e(videoCapabilities, i2, i, d)) {
                y("sizeAndRate.support, " + i + "x" + i2 + "@" + d);
                return false;
            }
            x("sizeAndRate.rotated, " + i + "x" + i2 + "@" + d);
        }
        return true;
    }

    public final void x(String str) {
        y53.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f5902a + ", " + this.b + "] [" + g86.e + "]");
    }

    public final void y(String str) {
        y53.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f5902a + ", " + this.b + "] [" + g86.e + "]");
    }
}
