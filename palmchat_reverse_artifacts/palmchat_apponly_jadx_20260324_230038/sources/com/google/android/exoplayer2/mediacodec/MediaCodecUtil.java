package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.d;
import com.google.common.collect.ImmutableList;
import com.umeng.analytics.pro.dn;
import defpackage.fp3;
import defpackage.g86;
import defpackage.th;
import defpackage.xg0;
import defpackage.y53;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"InlinedApi"})
@Deprecated
public final class MediaCodecUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f5895a = Pattern.compile("^\\D?(\\d+)$");

    @GuardedBy("MediaCodecUtil.class")
    public static final HashMap<b, List<com.google.android.exoplayer2.mediacodec.d>> b = new HashMap<>();
    public static int c = -1;

    /* JADX INFO: compiled from: SearchBox */
    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5896a;
        public final boolean b;
        public final boolean c;

        public b(String str, boolean z, boolean z2) {
            this.f5896a = str;
            this.b = z;
            this.c = z2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.f5896a, bVar.f5896a) && this.b == bVar.b && this.c == bVar.c;
        }

        public int hashCode() {
            return ((((this.f5896a.hashCode() + 31) * 31) + (this.b ? 1231 : 1237)) * 31) + (this.c ? 1231 : 1237);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i);

        boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d implements c {
        public d() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo getCodecInfoAt(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean secureDecodersExplicit() {
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(21)
    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5897a;

        @Nullable
        public MediaCodecInfo[] b;

        public e(boolean z, boolean z2) {
            this.f5897a = (z || z2) ? 1 : 0;
        }

        public final void a() {
            if (this.b == null) {
                this.b = new MediaCodecList(this.f5897a).getCodecInfos();
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int getCodecCount() {
            a();
            return this.b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo getCodecInfoAt(int i) {
            a();
            return this.b[i];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean secureDecodersExplicit() {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f<T> {
        int getScore(T t);
    }

    @Nullable
    public static Pair<Integer, Integer> A(String str, String[] strArr) {
        if (strArr.length < 3) {
            y53.i("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int i = Integer.parseInt(strArr[1]);
            int i2 = Integer.parseInt(strArr[2]);
            int iT = T(i);
            if (iT == -1) {
                y53.i("MediaCodecUtil", "Unknown VP9 profile: " + i);
                return null;
            }
            int iS = S(i2);
            if (iS != -1) {
                return new Pair<>(Integer.valueOf(iT), Integer.valueOf(iS));
            }
            y53.i("MediaCodecUtil", "Unknown VP9 level: " + i2);
            return null;
        } catch (NumberFormatException unused) {
            y53.i("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public static Integer B(@Nullable String str) {
        if (str == null) {
            return null;
        }
        byte b2 = -1;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    b2 = 0;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    b2 = 1;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    b2 = 2;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    b2 = 3;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    b2 = 4;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    b2 = 5;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    b2 = 6;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    b2 = 7;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    b2 = 8;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    b2 = 9;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    b2 = 10;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    b2 = 11;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    b2 = 12;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    b2 = dn.k;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    b2 = dn.l;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    b2 = 15;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    b2 = 16;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    b2 = 17;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    b2 = 18;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    b2 = 19;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    b2 = 20;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    b2 = 21;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    b2 = 22;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    b2 = 23;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    b2 = 24;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    b2 = 25;
                }
                break;
        }
        switch (b2) {
        }
        return null;
    }

    public static boolean C(MediaCodecInfo mediaCodecInfo) {
        return g86.f17680a >= 29 && D(mediaCodecInfo);
    }

    @RequiresApi(29)
    public static boolean D(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    public static boolean E(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i = g86.f17680a;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = g86.b;
            if ("a70".equals(str3) || ("Xiaomi".equals(g86.c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = g86.b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = g86.b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(g86.c))) {
            String str6 = g86.b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(g86.c)) {
            String str7 = g86.b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && g86.b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (i <= 23 && "audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static boolean F(MediaCodecInfo mediaCodecInfo, String str) {
        return g86.f17680a >= 29 ? G(mediaCodecInfo) : !H(mediaCodecInfo, str);
    }

    @RequiresApi(29)
    public static boolean G(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    public static boolean H(MediaCodecInfo mediaCodecInfo, String str) {
        if (g86.f17680a >= 29) {
            return I(mediaCodecInfo);
        }
        if (fp3.o(str)) {
            return true;
        }
        String strE = th.e(mediaCodecInfo.getName());
        if (strE.startsWith("arc.")) {
            return false;
        }
        if (strE.startsWith("omx.google.") || strE.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strE.startsWith("omx.sec.") && strE.contains(".sw.")) || strE.equals("omx.qcom.video.decoder.hevcswvdec") || strE.startsWith("c2.android.") || strE.startsWith("c2.google.")) {
            return true;
        }
        return (strE.startsWith("omx.") || strE.startsWith("c2.")) ? false : true;
    }

    @RequiresApi(29)
    public static boolean I(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    public static boolean J(MediaCodecInfo mediaCodecInfo) {
        if (g86.f17680a >= 29) {
            return K(mediaCodecInfo);
        }
        String strE = th.e(mediaCodecInfo.getName());
        return (strE.startsWith("omx.google.") || strE.startsWith("c2.android.") || strE.startsWith("c2.google.")) ? false : true;
    }

    @RequiresApi(29)
    public static boolean K(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    public static /* synthetic */ int L(com.google.android.exoplayer2.mediacodec.d dVar) {
        String str = dVar.f5902a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (g86.f17680a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    public static /* synthetic */ int M(com.google.android.exoplayer2.mediacodec.d dVar) {
        return dVar.f5902a.startsWith("OMX.google") ? 1 : 0;
    }

    public static /* synthetic */ int N(m mVar, com.google.android.exoplayer2.mediacodec.d dVar) {
        return dVar.n(mVar) ? 1 : 0;
    }

    public static /* synthetic */ int O(f fVar, Object obj, Object obj2) {
        return fVar.getScore(obj2) - fVar.getScore(obj);
    }

    public static int P() throws DecoderQueryException {
        if (c == -1) {
            int iMax = 0;
            com.google.android.exoplayer2.mediacodec.d dVarS = s("video/avc", false, false);
            if (dVarS != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrH = dVarS.h();
                int length = codecProfileLevelArrH.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(h(codecProfileLevelArrH[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, g86.f17680a >= 21 ? 345600 : 172800);
            }
            c = iMax;
        }
        return c;
    }

    public static int Q(int i) {
        int i2 = 17;
        if (i != 17) {
            i2 = 20;
            if (i != 20) {
                i2 = 23;
                if (i != 23) {
                    i2 = 29;
                    if (i != 29) {
                        i2 = 39;
                        if (i != 39) {
                            i2 = 42;
                            if (i != 42) {
                                switch (i) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    public static <T> void R(List<T> list, final f<T> fVar) {
        Collections.sort(list, new Comparator() { // from class: xf3
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MediaCodecUtil.O(fVar, obj, obj2);
            }
        });
    }

    public static int S(int i) {
        if (i == 10) {
            return 1;
        }
        if (i == 11) {
            return 2;
        }
        if (i == 20) {
            return 4;
        }
        if (i == 21) {
            return 8;
        }
        if (i == 30) {
            return 16;
        }
        if (i == 31) {
            return 32;
        }
        if (i == 40) {
            return 64;
        }
        if (i == 41) {
            return 128;
        }
        if (i == 50) {
            return 256;
        }
        if (i == 51) {
            return 512;
        }
        switch (i) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    public static int T(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? -1 : 8;
        }
        return 4;
    }

    public static void e(String str, List<com.google.android.exoplayer2.mediacodec.d> list) {
        if ("audio/raw".equals(str)) {
            if (g86.f17680a < 26 && g86.b.equals("R9") && list.size() == 1 && list.get(0).f5902a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(com.google.android.exoplayer2.mediacodec.d.F("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            R(list, new f() { // from class: uf3
                @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
                public final int getScore(Object obj) {
                    return MediaCodecUtil.L((d) obj);
                }
            });
        }
        int i = g86.f17680a;
        if (i < 21 && list.size() > 1) {
            String str2 = list.get(0).f5902a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                R(list, new f() { // from class: vf3
                    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
                    public final int getScore(Object obj) {
                        return MediaCodecUtil.M((d) obj);
                    }
                });
            }
        }
        if (i >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).f5902a)) {
            return;
        }
        list.add(list.remove(0));
    }

    public static int f(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    public static int g(int i) {
        switch (i) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    public static int h(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return BmLocated.ALIGN_RIGHT_TOP;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    public static int i(int i) {
        if (i == 66) {
            return 1;
        }
        if (i == 77) {
            return 2;
        }
        if (i == 88) {
            return 4;
        }
        if (i == 100) {
            return 8;
        }
        if (i == 110) {
            return 16;
        }
        if (i != 122) {
            return i != 244 ? -1 : 64;
        }
        return 32;
    }

    @Nullable
    public static Integer j(@Nullable String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    @Nullable
    public static Integer k(@Nullable String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> l(String str, String[] strArr) {
        int iQ;
        if (strArr.length != 3) {
            y53.i("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(fp3.h(Integer.parseInt(strArr[1], 16))) && (iQ = Q(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(iQ), 0);
            }
        } catch (NumberFormatException unused) {
            y53.i("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    @Nullable
    public static String m(m mVar) {
        Pair<Integer, Integer> pairR;
        if ("audio/eac3-joc".equals(mVar.l)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(mVar.l) || (pairR = r(mVar)) == null) {
            return null;
        }
        int iIntValue = ((Integer) pairR.first).intValue();
        if (iIntValue == 16 || iIntValue == 256) {
            return "video/hevc";
        }
        if (iIntValue == 512) {
            return "video/avc";
        }
        return null;
    }

    public static List<com.google.android.exoplayer2.mediacodec.d> n(com.google.android.exoplayer2.mediacodec.e eVar, m mVar, boolean z, boolean z2) throws DecoderQueryException {
        String strM = m(mVar);
        return strM == null ? ImmutableList.of() : eVar.getDecoderInfos(strM, z, z2);
    }

    @Nullable
    public static Pair<Integer, Integer> o(String str, String[] strArr, @Nullable xg0 xg0Var) {
        int i;
        if (strArr.length < 4) {
            y53.i("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        try {
            int i2 = Integer.parseInt(strArr[1]);
            int i3 = Integer.parseInt(strArr[2].substring(0, 2));
            int i4 = Integer.parseInt(strArr[3]);
            if (i2 != 0) {
                y53.i("MediaCodecUtil", "Unknown AV1 profile: " + i2);
                return null;
            }
            if (i4 != 8 && i4 != 10) {
                y53.i("MediaCodecUtil", "Unknown AV1 bit depth: " + i4);
                return null;
            }
            int i5 = i4 != 8 ? (xg0Var == null || !(xg0Var.d != null || (i = xg0Var.c) == 7 || i == 6)) ? 2 : 4096 : 1;
            int iF = f(i3);
            if (iF != -1) {
                return new Pair<>(Integer.valueOf(i5), Integer.valueOf(iF));
            }
            y53.i("MediaCodecUtil", "Unknown AV1 level: " + i3);
            return null;
        } catch (NumberFormatException unused) {
            y53.i("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    @Nullable
    public static Pair<Integer, Integer> p(String str, String[] strArr) {
        int i;
        int i2;
        if (strArr.length < 2) {
            y53.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i2 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i = Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    y53.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int i3 = Integer.parseInt(strArr[1]);
                i = Integer.parseInt(strArr[2]);
                i2 = i3;
            }
            int i4 = i(i2);
            if (i4 == -1) {
                y53.i("MediaCodecUtil", "Unknown AVC profile: " + i2);
                return null;
            }
            int iG = g(i);
            if (iG != -1) {
                return new Pair<>(Integer.valueOf(i4), Integer.valueOf(iG));
            }
            y53.i("MediaCodecUtil", "Unknown AVC level: " + i);
            return null;
        } catch (NumberFormatException unused) {
            y53.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    @Nullable
    public static String q(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> r(m mVar) {
        String str = mVar.i;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if ("video/dolby-vision".equals(mVar.l)) {
            return y(mVar.i, strArrSplit);
        }
        String str2 = strArrSplit[0];
        str2.hashCode();
        switch (str2) {
            case "av01":
                return o(mVar.i, strArrSplit, mVar.x);
            case "avc1":
            case "avc2":
                return p(mVar.i, strArrSplit);
            case "hev1":
            case "hvc1":
                return z(mVar.i, strArrSplit, mVar.x);
            case "mp4a":
                return l(mVar.i, strArrSplit);
            case "vp09":
                return A(mVar.i, strArrSplit);
            default:
                return null;
        }
    }

    @Nullable
    public static com.google.android.exoplayer2.mediacodec.d s(String str, boolean z, boolean z2) throws DecoderQueryException {
        List<com.google.android.exoplayer2.mediacodec.d> listT = t(str, z, z2);
        if (listT.isEmpty()) {
            return null;
        }
        return listT.get(0);
    }

    public static synchronized List<com.google.android.exoplayer2.mediacodec.d> t(String str, boolean z, boolean z2) throws DecoderQueryException {
        b bVar = new b(str, z, z2);
        HashMap<b, List<com.google.android.exoplayer2.mediacodec.d>> map = b;
        List<com.google.android.exoplayer2.mediacodec.d> list = map.get(bVar);
        if (list != null) {
            return list;
        }
        int i = g86.f17680a;
        ArrayList<com.google.android.exoplayer2.mediacodec.d> arrayListU = u(bVar, i >= 21 ? new e(z, z2) : new d());
        if (z && arrayListU.isEmpty() && 21 <= i && i <= 23) {
            arrayListU = u(bVar, new d());
            if (!arrayListU.isEmpty()) {
                y53.i("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + arrayListU.get(0).f5902a);
            }
        }
        e(str, arrayListU);
        ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) arrayListU);
        map.put(bVar, immutableListCopyOf);
        return immutableListCopyOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0102 A[Catch: Exception -> 0x0150, TRY_ENTER, TryCatch #1 {Exception -> 0x0150, blocks: (B:3:0x0008, B:5:0x001b, B:61:0x0121, B:8:0x002d, B:11:0x0038, B:55:0x00fa, B:58:0x0102, B:60:0x0108, B:62:0x012b, B:63:0x014e), top: B:70:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012b A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<com.google.android.exoplayer2.mediacodec.d> u(b bVar, c cVar) throws DecoderQueryException {
        String strQ;
        String str;
        String str2;
        int i;
        boolean z;
        int i2;
        String str3;
        b bVar2 = bVar;
        try {
            ArrayList<com.google.android.exoplayer2.mediacodec.d> arrayList = new ArrayList<>();
            String str4 = bVar2.f5896a;
            int codecCount = cVar.getCodecCount();
            boolean zSecureDecodersExplicit = cVar.secureDecodersExplicit();
            int i3 = 0;
            while (i3 < codecCount) {
                MediaCodecInfo codecInfoAt = cVar.getCodecInfoAt(i3);
                if (C(codecInfoAt)) {
                    i = i3;
                    z = zSecureDecodersExplicit;
                    i2 = codecCount;
                } else {
                    String name = codecInfoAt.getName();
                    if (E(codecInfoAt, name, zSecureDecodersExplicit, str4) && (strQ = q(codecInfoAt, name, str4)) != null) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(strQ);
                            boolean zIsFeatureSupported = cVar.isFeatureSupported("tunneled-playback", strQ, capabilitiesForType);
                            boolean zIsFeatureRequired = cVar.isFeatureRequired("tunneled-playback", strQ, capabilitiesForType);
                            boolean z2 = bVar2.c;
                            if ((z2 || !zIsFeatureRequired) && (!z2 || zIsFeatureSupported)) {
                                boolean zIsFeatureSupported2 = cVar.isFeatureSupported("secure-playback", strQ, capabilitiesForType);
                                boolean zIsFeatureRequired2 = cVar.isFeatureRequired("secure-playback", strQ, capabilitiesForType);
                                boolean z3 = bVar2.b;
                                if ((z3 || !zIsFeatureRequired2) && (!z3 || zIsFeatureSupported2)) {
                                    boolean zF = F(codecInfoAt, str4);
                                    boolean zH = H(codecInfoAt, str4);
                                    boolean zJ = J(codecInfoAt);
                                    if (!zSecureDecodersExplicit || bVar2.b != zIsFeatureSupported2) {
                                        if (!zSecureDecodersExplicit) {
                                            try {
                                                if (!bVar2.b) {
                                                    str = strQ;
                                                    str3 = name;
                                                    i = i3;
                                                    z = zSecureDecodersExplicit;
                                                    i2 = codecCount;
                                                    try {
                                                        arrayList.add(com.google.android.exoplayer2.mediacodec.d.F(name, str4, strQ, capabilitiesForType, zF, zH, zJ, false, false));
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        str2 = str3;
                                                        if (g86.f17680a > 23) {
                                                        }
                                                        y53.c("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                        throw e;
                                                    }
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                str = strQ;
                                                str3 = name;
                                                i = i3;
                                                z = zSecureDecodersExplicit;
                                                i2 = codecCount;
                                                str2 = str3;
                                                if (g86.f17680a > 23) {
                                                }
                                                y53.c("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                throw e;
                                            }
                                        }
                                        str = strQ;
                                        i = i3;
                                        z = zSecureDecodersExplicit;
                                        i2 = codecCount;
                                        if (!z && zIsFeatureSupported2) {
                                            StringBuilder sb = new StringBuilder();
                                            try {
                                                sb.append(name);
                                                sb.append(".secure");
                                                str2 = name;
                                            } catch (Exception e4) {
                                                e = e4;
                                                str2 = name;
                                            }
                                            try {
                                                arrayList.add(com.google.android.exoplayer2.mediacodec.d.F(sb.toString(), str4, str, capabilitiesForType, zF, zH, zJ, false, true));
                                                return arrayList;
                                            } catch (Exception e5) {
                                                e = e5;
                                                if (g86.f17680a > 23 || arrayList.isEmpty()) {
                                                    y53.c("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                    throw e;
                                                }
                                                y53.c("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
                                                i3 = i + 1;
                                                bVar2 = bVar;
                                                codecCount = i2;
                                                zSecureDecodersExplicit = z;
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str = strQ;
                            str2 = name;
                            i = i3;
                            z = zSecureDecodersExplicit;
                            i2 = codecCount;
                        }
                    }
                }
                i3 = i + 1;
                bVar2 = bVar;
                codecCount = i2;
                zSecureDecodersExplicit = z;
            }
            return arrayList;
        } catch (Exception e7) {
            throw new DecoderQueryException(e7);
        }
    }

    public static List<com.google.android.exoplayer2.mediacodec.d> v(com.google.android.exoplayer2.mediacodec.e eVar, m mVar, boolean z, boolean z2) throws DecoderQueryException {
        List<com.google.android.exoplayer2.mediacodec.d> decoderInfos = eVar.getDecoderInfos(mVar.l, z, z2);
        return ImmutableList.builder().l(decoderInfos).l(n(eVar, mVar, z, z2)).e();
    }

    @CheckResult
    public static List<com.google.android.exoplayer2.mediacodec.d> w(List<com.google.android.exoplayer2.mediacodec.d> list, final m mVar) {
        ArrayList arrayList = new ArrayList(list);
        R(arrayList, new f() { // from class: wf3
            @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
            public final int getScore(Object obj) {
                return MediaCodecUtil.N(mVar, (d) obj);
            }
        });
        return arrayList;
    }

    @Nullable
    public static com.google.android.exoplayer2.mediacodec.d x() throws DecoderQueryException {
        return s("audio/raw", false, false);
    }

    @Nullable
    public static Pair<Integer, Integer> y(String str, String[] strArr) {
        if (strArr.length < 3) {
            y53.i("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = f5895a.matcher(strArr[1]);
        if (!matcher.matches()) {
            y53.i("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numK = k(strGroup);
        if (numK == null) {
            y53.i("MediaCodecUtil", "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numJ = j(str2);
        if (numJ != null) {
            return new Pair<>(numK, numJ);
        }
        y53.i("MediaCodecUtil", "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> z(String str, String[] strArr, @Nullable xg0 xg0Var) {
        if (strArr.length < 4) {
            y53.i("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i = 1;
        Matcher matcher = f5895a.matcher(strArr[1]);
        if (!matcher.matches()) {
            y53.i("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!"1".equals(strGroup)) {
            if (!"2".equals(strGroup)) {
                y53.i("MediaCodecUtil", "Unknown HEVC profile string: " + strGroup);
                return null;
            }
            i = (xg0Var == null || xg0Var.c != 6) ? 2 : 4096;
        }
        String str2 = strArr[3];
        Integer numB = B(str2);
        if (numB != null) {
            return new Pair<>(Integer.valueOf(i), numB);
        }
        y53.i("MediaCodecUtil", "Unknown HEVC level string: " + str2);
        return null;
    }
}
