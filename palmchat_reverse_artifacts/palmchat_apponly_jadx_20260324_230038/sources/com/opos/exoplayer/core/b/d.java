package com.opos.exoplayer.core.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.opos.exoplayer.core.util.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class d {
    private static final SparseIntArray d;
    private static final SparseIntArray e;
    private static final Map<String, Integer> f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.opos.exoplayer.core.b.a f8115a = com.opos.exoplayer.core.b.a.a("OMX.google.raw.decoder");
    private static final Pattern b = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<c, List<com.opos.exoplayer.core.b.a>> c = new HashMap<>();
    private static int g = -1;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends com.opos.exoplayer.core.util.b {
        private a(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }

        @Override // com.opos.exoplayer.core.util.b
        public String a() {
            return "DecoderQueryException";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8116a;
        public final boolean b;

        public c(String str, boolean z) {
            this.f8116a = str;
            this.b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != c.class) {
                return false;
            }
            c cVar = (c) obj;
            return TextUtils.equals(this.f8116a, cVar.f8116a) && this.b == cVar.b;
        }

        public int hashCode() {
            String str = this.f8116a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.b ? 1231 : 1237);
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.b.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0681d {
        int a();

        MediaCodecInfo a(int i);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e implements InterfaceC0681d {
        private e() {
        }

        @Override // com.opos.exoplayer.core.b.d.InterfaceC0681d
        public int a() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.opos.exoplayer.core.b.d.InterfaceC0681d
        public boolean b() {
            return false;
        }

        @Override // com.opos.exoplayer.core.b.d.InterfaceC0681d
        public MediaCodecInfo a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.opos.exoplayer.core.b.d.InterfaceC0681d
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(21)
    public static final class f implements InterfaceC0681d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8117a;
        private MediaCodecInfo[] b;

        public f(boolean z) {
            this.f8117a = z ? 1 : 0;
        }

        private void c() {
            if (this.b == null) {
                this.b = new MediaCodecList(this.f8117a).getCodecInfos();
            }
        }

        @Override // com.opos.exoplayer.core.b.d.InterfaceC0681d
        public int a() {
            c();
            return this.b.length;
        }

        @Override // com.opos.exoplayer.core.b.d.InterfaceC0681d
        public boolean b() {
            return true;
        }

        @Override // com.opos.exoplayer.core.b.d.InterfaceC0681d
        public MediaCodecInfo a(int i) {
            c();
            return this.b[i];
        }

        @Override // com.opos.exoplayer.core.b.d.InterfaceC0681d
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap map = new HashMap();
        f = map;
        map.put("L30", 1);
        map.put("L60", 4);
        map.put("L63", 16);
        map.put("L90", 64);
        map.put("L93", 256);
        map.put("L120", 1024);
        map.put("L123", 4096);
        map.put("L150", 16384);
        map.put("L153", 65536);
        map.put("L156", 262144);
        map.put("L180", 1048576);
        map.put("L183", 4194304);
        map.put("L186", 16777216);
        map.put("H30", 2);
        map.put("H60", 8);
        map.put("H63", 32);
        map.put("H90", 128);
        map.put("H93", 512);
        map.put("H120", 2048);
        map.put("H123", 8192);
        map.put("H150", 32768);
        map.put("H153", 131072);
        map.put("H156", 524288);
        map.put("H180", 2097152);
        map.put("H183", 8388608);
        map.put("H186", 33554432);
    }

    private static int a(int i) {
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
            default:
                return -1;
        }
    }

    public static int b() {
        if (g == -1) {
            int iMax = 0;
            com.opos.exoplayer.core.b.a aVarA = a("video/avc", false);
            if (aVarA != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrA = aVarA.a();
                int length = codecProfileLevelArrA.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(a(codecProfileLevelArrA[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, y.f8407a >= 21 ? 345600 : 172800);
            }
            g = iMax;
        }
        return g;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> a(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        String str2 = strArrSplit[0];
        str2.hashCode();
        switch (str2) {
        }
        return null;
    }

    private static Pair<Integer, Integer> b(String str, String[] strArr) {
        StringBuilder sb;
        Integer numValueOf;
        Integer numValueOf2;
        Integer numValueOf3;
        String string;
        if (strArr.length >= 2) {
            try {
                if (strArr[1].length() == 6) {
                    numValueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                    numValueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                } else {
                    if (strArr.length < 3) {
                        com.opos.cmn.an.f.a.c("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                        return null;
                    }
                    Integer numValueOf4 = Integer.valueOf(Integer.parseInt(strArr[1]));
                    numValueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                    numValueOf2 = numValueOf4;
                }
                numValueOf3 = Integer.valueOf(d.get(numValueOf2.intValue()));
            } catch (NumberFormatException unused) {
                sb = new StringBuilder();
                sb.append("Ignoring malformed AVC codec string: ");
                sb.append(str);
            }
            if (numValueOf3 == null) {
                string = "Unknown AVC profile: " + numValueOf2;
                com.opos.cmn.an.f.a.c("MediaCodecUtil", string);
                return null;
            }
            Integer numValueOf5 = Integer.valueOf(e.get(numValueOf.intValue()));
            if (numValueOf5 != null) {
                return new Pair<>(numValueOf3, numValueOf5);
            }
            sb = new StringBuilder();
            sb.append("Unknown AVC level: ");
            sb.append(numValueOf);
            string = sb.toString();
            com.opos.cmn.an.f.a.c("MediaCodecUtil", string);
            return null;
        }
        sb = new StringBuilder();
        sb.append("Ignoring malformed AVC codec string: ");
        sb.append(str);
        string = sb.toString();
        com.opos.cmn.an.f.a.c("MediaCodecUtil", string);
        return null;
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        StringBuilder sb;
        int i;
        String string;
        if (strArr.length < 4) {
            sb = new StringBuilder();
        } else {
            Matcher matcher = b.matcher(strArr[1]);
            if (matcher.matches()) {
                str = matcher.group(1);
                if ("1".equals(str)) {
                    i = 1;
                } else {
                    if (!"2".equals(str)) {
                        sb = new StringBuilder();
                        sb.append("Unknown HEVC profile string: ");
                        sb.append(str);
                        string = sb.toString();
                        com.opos.cmn.an.f.a.c("MediaCodecUtil", string);
                        return null;
                    }
                    i = 2;
                }
                Integer num = f.get(strArr[3]);
                if (num != null) {
                    return new Pair<>(Integer.valueOf(i), num);
                }
                string = "Unknown HEVC level string: " + matcher.group(1);
                com.opos.cmn.an.f.a.c("MediaCodecUtil", string);
                return null;
            }
            sb = new StringBuilder();
        }
        sb.append("Ignoring malformed HEVC codec string: ");
        sb.append(str);
        string = sb.toString();
        com.opos.cmn.an.f.a.c("MediaCodecUtil", string);
        return null;
    }

    public static synchronized List<com.opos.exoplayer.core.b.a> b(String str, boolean z) {
        c cVar = new c(str, z);
        HashMap<c, List<com.opos.exoplayer.core.b.a>> map = c;
        List<com.opos.exoplayer.core.b.a> list = map.get(cVar);
        if (list != null) {
            return list;
        }
        int i = y.f8407a;
        InterfaceC0681d fVar = i >= 21 ? new f(z) : new e();
        ArrayList<com.opos.exoplayer.core.b.a> arrayListA = a(cVar, fVar, str);
        if (z && arrayListA.isEmpty() && 21 <= i && i <= 23) {
            fVar = new e();
            arrayListA = a(cVar, fVar, str);
            if (!arrayListA.isEmpty()) {
                com.opos.cmn.an.f.a.c("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + arrayListA.get(0).f8111a);
            }
        }
        if ("audio/eac3-joc".equals(str)) {
            arrayListA.addAll(a(new c("audio/eac3", cVar.b), fVar, str));
        }
        a(arrayListA);
        List<com.opos.exoplayer.core.b.a> listUnmodifiableList = Collections.unmodifiableList(arrayListA);
        map.put(cVar, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public static com.opos.exoplayer.core.b.a a() {
        return f8115a;
    }

    private static boolean b(String str) {
        if (y.f8407a <= 22) {
            String str2 = y.d;
            if ((str2.equals("ODROID-XU3") || str2.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static com.opos.exoplayer.core.b.a a(String str, boolean z) {
        List<com.opos.exoplayer.core.b.a> listB = b(str, z);
        if (listB.isEmpty()) {
            return null;
        }
        return listB.get(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[PHI: r16
      0x004b: PHI (r16v6 int) = (r16v5 int), (r16v7 int) binds: [B:23:0x0055, B:15:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ArrayList<com.opos.exoplayer.core.b.a> a(c cVar, InterfaceC0681d interfaceC0681d, String str) throws a {
        int i;
        InterfaceC0681d interfaceC0681d2 = interfaceC0681d;
        try {
            ArrayList<com.opos.exoplayer.core.b.a> arrayList = new ArrayList<>();
            String str2 = cVar.f8116a;
            int iA = interfaceC0681d.a();
            boolean zB = interfaceC0681d.b();
            int i2 = 0;
            while (i2 < iA) {
                MediaCodecInfo mediaCodecInfoA = interfaceC0681d2.a(i2);
                String name = mediaCodecInfoA.getName();
                if (a(mediaCodecInfoA, name, zB, str)) {
                    String[] supportedTypes = mediaCodecInfoA.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i3 = 0;
                    while (i3 < length) {
                        String str3 = supportedTypes[i3];
                        if (str3.equalsIgnoreCase(str2)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA.getCapabilitiesForType(str3);
                                boolean zA = interfaceC0681d2.a(str2, capabilitiesForType);
                                boolean zB2 = b(name);
                                if (zB) {
                                    i = iA;
                                    try {
                                        if (cVar.b == zA) {
                                            arrayList.add(com.opos.exoplayer.core.b.a.a(name, str2, capabilitiesForType, zB2, false));
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        if (y.f8407a <= 23) {
                                        }
                                        com.opos.cmn.an.f.a.d("MediaCodecUtil", "Failed to query codec " + name + " (" + str3 + ")");
                                        throw e;
                                    }
                                } else {
                                    i = iA;
                                }
                                if (!zB) {
                                    try {
                                        if (!cVar.b) {
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        if (y.f8407a <= 23 || arrayList.isEmpty()) {
                                            com.opos.cmn.an.f.a.d("MediaCodecUtil", "Failed to query codec " + name + " (" + str3 + ")");
                                            throw e;
                                        }
                                        com.opos.cmn.an.f.a.d("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
                                    }
                                }
                                if (!zB && zA) {
                                    arrayList.add(com.opos.exoplayer.core.b.a.a(name + ".secure", str2, capabilitiesForType, zB2, true));
                                    return arrayList;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                i = iA;
                            }
                        } else {
                            i = iA;
                        }
                        i3++;
                        interfaceC0681d2 = interfaceC0681d;
                        iA = i;
                    }
                }
                i2++;
                interfaceC0681d2 = interfaceC0681d;
                iA = iA;
            }
            return arrayList;
        } catch (Exception e5) {
            throw new a(e5);
        }
    }

    private static void a(List<com.opos.exoplayer.core.b.a> list) {
        if (y.f8407a < 26) {
            if (list.size() <= 1 || !"OMX.MTK.AUDIO.DECODER.RAW".equals(list.get(0).f8111a)) {
                return;
            }
            for (int i = 1; i < list.size(); i++) {
                com.opos.exoplayer.core.b.a aVar = list.get(i);
                if ("OMX.google.raw.decoder".equals(aVar.f8111a)) {
                    list.remove(i);
                    list.add(0, aVar);
                    return;
                }
            }
        }
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i = y.f8407a;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = y.b;
            if ("a70".equals(str3) || ("Xiaomi".equals(y.c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = y.b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = y.b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && y.c.equals("samsung"))) {
            String str6 = y.b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || str6.equals("SC-05G") || str6.equals("marinelteatt") || str6.equals("404SC") || str6.equals("SC-04G") || str6.equals("SCV31")) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(y.c)) {
            String str7 = y.b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && y.b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }
}
