package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.upstream.g;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import defpackage.bv2;
import defpackage.ei2;
import defpackage.fp3;
import defpackage.g86;
import defpackage.v56;
import defpackage.vh;
import defpackage.xo4;
import defpackage.y53;
import defpackage.zv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class HlsPlaylistParser implements g.a<ei2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5958a;

    @Nullable
    public final b b;
    public static final Pattern c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern d = Pattern.compile("VIDEO=\"(.+?)\"");
    public static final Pattern e = Pattern.compile("AUDIO=\"(.+?)\"");
    public static final Pattern f = Pattern.compile("SUBTITLES=\"(.+?)\"");
    public static final Pattern g = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    public static final Pattern h = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final Pattern i = Pattern.compile("CHANNELS=\"(.+?)\"");
    public static final Pattern j = Pattern.compile("CODECS=\"(.+?)\"");
    public static final Pattern k = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final Pattern l = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    public static final Pattern m = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final Pattern n = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    public static final Pattern o = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    public static final Pattern p = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final Pattern q = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final Pattern r = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    public static final Pattern s = b("CAN-SKIP-DATERANGES");
    public static final Pattern t = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    public static final Pattern u = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern v = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern w = b("CAN-BLOCK-RELOAD");
    public static final Pattern x = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern y = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern z = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    public static final Pattern A = Pattern.compile("LAST-MSN=(\\d+)\\b");
    public static final Pattern B = Pattern.compile("LAST-PART=(\\d+)\\b");
    public static final Pattern C = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern D = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern E = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern F = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    public static final Pattern G = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    public static final Pattern H = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    public static final Pattern I = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final Pattern J = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    public static final Pattern K = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern L = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern M = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern N = Pattern.compile("TYPE=(PART|MAP)");
    public static final Pattern O = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern P = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern Q = Pattern.compile("GROUP-ID=\"(.+?)\"");
    public static final Pattern R = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    public static final Pattern S = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern T = b("AUTOSELECT");
    public static final Pattern U = b("DEFAULT");
    public static final Pattern V = b("FORCED");
    public static final Pattern W = b("INDEPENDENT");
    public static final Pattern X = b("GAP");
    public static final Pattern Y = b("PRECISE");
    public static final Pattern Z = Pattern.compile("VALUE=\"(.+?)\"");
    public static final Pattern a0 = Pattern.compile("IMPORT=\"(.+?)\"");
    public static final Pattern b0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* JADX INFO: compiled from: SearchBox */
    public static final class DeltaUpdateException extends IOException {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedReader f5959a;
        public final Queue<String> b;

        @Nullable
        public String c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.b = queue;
            this.f5959a = bufferedReader;
        }

        public boolean a() throws IOException {
            String strTrim;
            if (this.c != null) {
                return true;
            }
            if (!this.b.isEmpty()) {
                this.c = (String) vh.e(this.b.poll());
                return true;
            }
            do {
                String line = this.f5959a.readLine();
                this.c = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.c = strTrim;
            } while (strTrim.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (!a()) {
                throw new NoSuchElementException();
            }
            String str = this.c;
            this.c = null;
            return str;
        }
    }

    public HlsPlaylistParser() {
        this(c.n, null);
    }

    public static String A(String str, Map<String, String> map) {
        Matcher matcher = b0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (map.containsKey(strGroup)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(strGroup)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static int B(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !g86.A0(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    public static boolean a(BufferedReader bufferedReader) throws IOException {
        int i2 = bufferedReader.read();
        if (i2 == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            i2 = bufferedReader.read();
        }
        int iB = B(bufferedReader, true, i2);
        for (int i3 = 0; i3 < 7; i3++) {
            if (iB != "#EXTM3U".charAt(i3)) {
                return false;
            }
            iB = bufferedReader.read();
        }
        return g86.A0(B(bufferedReader, false, iB));
    }

    public static Pattern b(String str) {
        return Pattern.compile(str + "=(NO" + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "YES)");
    }

    public static DrmInitData c(@Nullable String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i2 = 0; i2 < schemeDataArr.length; i2++) {
            schemeDataArr2[i2] = schemeDataArr[i2].copyWithData(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    @Nullable
    public static String d(long j2, @Nullable String str, @Nullable String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j2);
    }

    @Nullable
    public static c.b e(ArrayList<c.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.b bVar = arrayList.get(i2);
            if (str.equals(bVar.d)) {
                return bVar;
            }
        }
        return null;
    }

    @Nullable
    public static c.b f(ArrayList<c.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.b bVar = arrayList.get(i2);
            if (str.equals(bVar.e)) {
                return bVar;
            }
        }
        return null;
    }

    @Nullable
    public static c.b g(ArrayList<c.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.b bVar = arrayList.get(i2);
            if (str.equals(bVar.c)) {
                return bVar;
            }
        }
        return null;
    }

    public static double i(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(y(str, pattern, Collections.emptyMap()));
    }

    @Nullable
    public static DrmInitData.SchemeData j(String str, String str2, Map<String, String> map) throws ParserException {
        String strT = t(str, J, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String strY = y(str, K, map);
            return new DrmInitData.SchemeData(zv.d, "video/mp4", Base64.decode(strY.substring(strY.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(zv.d, LiveConfigKey.HLS, g86.o0(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(strT)) {
            return null;
        }
        String strY2 = y(str, K, map);
        byte[] bArrDecode = Base64.decode(strY2.substring(strY2.indexOf(44)), 0);
        UUID uuid = zv.e;
        return new DrmInitData.SchemeData(uuid, "video/mp4", xo4.a(uuid, bArrDecode));
    }

    public static String k(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    public static int l(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(y(str, pattern, Collections.emptyMap()));
    }

    public static long m(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(y(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b n(c cVar, @Nullable b bVar, a aVar, String str) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        long j2;
        int i2;
        b.C0357b c0357b;
        int i3;
        String strU;
        long j3;
        long j4;
        Object drmInitData;
        long j5;
        long j6;
        c cVar2 = cVar;
        b bVar2 = bVar;
        boolean z2 = cVar2.c;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        b.f fVar = new b.f(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
        TreeMap treeMap = new TreeMap();
        boolean z3 = false;
        String str3 = "";
        boolean z4 = z2;
        b.f fVarX = fVar;
        String strT = str3;
        int i4 = 0;
        String strY = null;
        long jI = -9223372036854775807L;
        boolean zP = false;
        long jH0 = 0;
        boolean z5 = false;
        int i5 = 0;
        long j7 = 0;
        int iL = 1;
        long jL = -9223372036854775807L;
        long jI2 = -9223372036854775807L;
        boolean z6 = false;
        DrmInitData drmInitDataC = null;
        long j8 = 0;
        Object obj = null;
        long j9 = 0;
        boolean z7 = false;
        long j10 = -1;
        String str4 = null;
        String strK = null;
        int i6 = 0;
        long j11 = 0;
        long jM = 0;
        boolean z8 = false;
        b.d dVar = null;
        long jZ = 0;
        long j12 = 0;
        ArrayList arrayList7 = arrayList4;
        b.C0357b c0357b2 = null;
        while (aVar.a()) {
            String strB = aVar.b();
            if (strB.startsWith("#EXT")) {
                arrayList6.add(strB);
            }
            if (strB.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String strY2 = y(strB, q, map);
                if ("VOD".equals(strY2)) {
                    i4 = 1;
                } else if ("EVENT".equals(strY2)) {
                    i4 = 2;
                }
            } else if (strB.equals("#EXT-X-I-FRAMES-ONLY")) {
                z8 = true;
            } else if (strB.startsWith("#EXT-X-START")) {
                jI = (long) (i(strB, C) * 1000000.0d);
                zP = p(strB, Y, z3);
            } else if (strB.startsWith("#EXT-X-SERVER-CONTROL")) {
                fVarX = x(strB);
            } else if (strB.startsWith("#EXT-X-PART-INF")) {
                jI2 = (long) (i(strB, o) * 1000000.0d);
            } else if (strB.startsWith("#EXT-X-MAP")) {
                String strY3 = y(strB, K, map);
                String strU2 = u(strB, E, map);
                if (strU2 != null) {
                    String[] strArrZ0 = g86.Z0(strU2, "@");
                    j10 = Long.parseLong(strArrZ0[z3 ? 1 : 0]);
                    if (strArrZ0.length > 1) {
                        j8 = Long.parseLong(strArrZ0[1]);
                    }
                }
                if (j10 == -1) {
                    j8 = 0;
                }
                String str5 = str4;
                if (strY != null && str5 == null) {
                    throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                }
                dVar = new b.d(strY3, j8, j10, strY, str5);
                if (j10 != -1) {
                    j8 += j10;
                }
                str4 = str5;
                j10 = -1;
            } else {
                String str6 = str4;
                if (strB.startsWith("#EXT-X-TARGETDURATION")) {
                    jL = 1000000 * ((long) l(strB, m));
                } else {
                    if (strB.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        jM = m(strB, x);
                        str4 = str6;
                        j7 = jM;
                    } else if (strB.startsWith("#EXT-X-VERSION")) {
                        iL = l(strB, p);
                    } else {
                        if (strB.startsWith("#EXT-X-DEFINE")) {
                            String strU3 = u(strB, a0, map);
                            if (strU3 != null) {
                                String str7 = cVar2.l.get(strU3);
                                if (str7 != null) {
                                    map.put(strU3, str7);
                                }
                            } else {
                                map.put(y(strB, P, map), y(strB, Z, map));
                            }
                            arrayList = arrayList7;
                            arrayList2 = arrayList6;
                            str2 = strK;
                            j2 = jM;
                            i2 = i4;
                        } else if (strB.startsWith("#EXTINF")) {
                            jZ = z(strB, y);
                            strT = t(strB, z, str3, map);
                        } else {
                            String str8 = str3;
                            if (strB.startsWith("#EXT-X-SKIP")) {
                                int iL2 = l(strB, t);
                                vh.g(bVar2 != null && arrayList3.isEmpty());
                                int i7 = (int) (j7 - ((b) g86.j(bVar)).k);
                                int i8 = iL2 + i7;
                                if (i7 < 0 || i8 > bVar2.r.size()) {
                                    throw new DeltaUpdateException();
                                }
                                str3 = str8;
                                String str9 = str6;
                                long j13 = j11;
                                while (i7 < i8) {
                                    b.d dVarB = bVar2.r.get(i7);
                                    ArrayList arrayList8 = arrayList7;
                                    ArrayList arrayList9 = arrayList6;
                                    if (j7 != bVar2.k) {
                                        dVarB = dVarB.b(j13, (bVar2.j - i5) + dVarB.d);
                                    }
                                    arrayList3.add(dVarB);
                                    j13 += dVarB.c;
                                    long j14 = dVarB.j;
                                    if (j14 != -1) {
                                        i3 = i8;
                                        j8 = dVarB.i + j14;
                                    } else {
                                        i3 = i8;
                                    }
                                    int i9 = dVarB.d;
                                    b.d dVar2 = dVarB.b;
                                    DrmInitData drmInitData2 = dVarB.f;
                                    String str10 = dVarB.g;
                                    String str11 = dVarB.h;
                                    if (str11 == null || !str11.equals(Long.toHexString(jM))) {
                                        str9 = dVarB.h;
                                    }
                                    jM++;
                                    i7++;
                                    bVar2 = bVar;
                                    obj = drmInitData2;
                                    strY = str10;
                                    j9 = j13;
                                    i8 = i3;
                                    i6 = i9;
                                    dVar = dVar2;
                                    arrayList7 = arrayList8;
                                    arrayList6 = arrayList9;
                                }
                                cVar2 = cVar;
                                bVar2 = bVar;
                                j11 = j13;
                                str4 = str9;
                            } else {
                                ArrayList arrayList10 = arrayList7;
                                arrayList2 = arrayList6;
                                str3 = str8;
                                if (strB.startsWith("#EXT-X-KEY")) {
                                    String strY4 = y(strB, H, map);
                                    String strT2 = t(strB, I, HTTP.IDENTITY_CODING, map);
                                    if ("NONE".equals(strY4)) {
                                        treeMap.clear();
                                        strU = null;
                                        strY = null;
                                    } else {
                                        strU = u(strB, L, map);
                                        if (HTTP.IDENTITY_CODING.equals(strT2)) {
                                            if ("AES-128".equals(strY4)) {
                                                strY = y(strB, K, map);
                                            }
                                            cVar2 = cVar;
                                            bVar2 = bVar;
                                            str4 = strU;
                                        } else {
                                            String str12 = strK;
                                            strK = str12 == null ? k(strY4) : str12;
                                            DrmInitData.SchemeData schemeDataJ = j(strB, strT2, map);
                                            if (schemeDataJ != null) {
                                                treeMap.put(strT2, schemeDataJ);
                                                strY = null;
                                            }
                                        }
                                        strY = null;
                                        cVar2 = cVar;
                                        bVar2 = bVar;
                                        str4 = strU;
                                    }
                                    obj = strY;
                                    cVar2 = cVar;
                                    bVar2 = bVar;
                                    str4 = strU;
                                } else {
                                    String str13 = strK;
                                    if (strB.startsWith("#EXT-X-BYTERANGE")) {
                                        String[] strArrZ02 = g86.Z0(y(strB, D, map), "@");
                                        j10 = Long.parseLong(strArrZ02[0]);
                                        if (strArrZ02.length > 1) {
                                            j8 = Long.parseLong(strArrZ02[1]);
                                        }
                                    } else if (strB.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                        i5 = Integer.parseInt(strB.substring(strB.indexOf(58) + 1));
                                        cVar2 = cVar;
                                        bVar2 = bVar;
                                        strK = str13;
                                        str4 = str6;
                                        arrayList7 = arrayList10;
                                        arrayList6 = arrayList2;
                                        z3 = false;
                                        z5 = true;
                                    } else if (strB.equals("#EXT-X-DISCONTINUITY")) {
                                        i6++;
                                    } else {
                                        if (strB.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                            if (jH0 == 0) {
                                                jH0 = g86.H0(g86.O0(strB.substring(strB.indexOf(58) + 1))) - j11;
                                            } else {
                                                i2 = i4;
                                                str2 = str13;
                                            }
                                        } else if (strB.equals("#EXT-X-GAP")) {
                                            cVar2 = cVar;
                                            bVar2 = bVar;
                                            strK = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z3 = false;
                                            z7 = true;
                                        } else if (strB.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                            cVar2 = cVar;
                                            bVar2 = bVar;
                                            strK = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z3 = false;
                                            z4 = true;
                                        } else if (strB.equals("#EXT-X-ENDLIST")) {
                                            cVar2 = cVar;
                                            bVar2 = bVar;
                                            strK = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z3 = false;
                                            z6 = true;
                                        } else if (strB.startsWith("#EXT-X-RENDITION-REPORT")) {
                                            i2 = i4;
                                            str2 = str13;
                                            arrayList5.add(new b.c(Uri.parse(v56.d(str, y(strB, K, map))), s(strB, A, -1L), r(strB, B, -1)));
                                        } else {
                                            i2 = i4;
                                            str2 = str13;
                                            if (!strB.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                j2 = jM;
                                                if (strB.startsWith("#EXT-X-PART")) {
                                                    String strD = d(j2, strY, str6);
                                                    String strY5 = y(strB, K, map);
                                                    long jI3 = (long) (i(strB, n) * 1000000.0d);
                                                    c0357b = c0357b2;
                                                    boolean zP2 = p(strB, W, false) | (z4 && arrayList10.isEmpty());
                                                    boolean zP3 = p(strB, X, false);
                                                    String strU4 = u(strB, E, map);
                                                    if (strU4 != null) {
                                                        String[] strArrZ03 = g86.Z0(strU4, "@");
                                                        j6 = Long.parseLong(strArrZ03[0]);
                                                        if (strArrZ03.length > 1) {
                                                            j12 = Long.parseLong(strArrZ03[1]);
                                                        }
                                                        j5 = -1;
                                                    } else {
                                                        j5 = -1;
                                                        j6 = -1;
                                                    }
                                                    if (j6 == j5) {
                                                        j12 = 0;
                                                    }
                                                    if (obj == null && !treeMap.isEmpty()) {
                                                        DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        DrmInitData drmInitData3 = new DrmInitData(str2, schemeDataArr);
                                                        if (drmInitDataC == null) {
                                                            drmInitDataC = c(str2, schemeDataArr);
                                                        }
                                                        obj = drmInitData3;
                                                    }
                                                    arrayList = arrayList10;
                                                    arrayList.add(new b.C0357b(strY5, dVar, jI3, i6, j9, obj, strY, strD, j12, j6, zP3, zP2, false));
                                                    j9 += jI3;
                                                    if (j6 != j5) {
                                                        j12 += j6;
                                                    }
                                                } else {
                                                    c0357b = c0357b2;
                                                    arrayList = arrayList10;
                                                    if (!strB.startsWith("#")) {
                                                        String strD2 = d(j2, strY, str6);
                                                        long j15 = j2 + 1;
                                                        String strA = A(strB, map);
                                                        b.d dVar3 = (b.d) map2.get(strA);
                                                        if (j10 == -1) {
                                                            j3 = 0;
                                                        } else {
                                                            if (z8 && dVar == null && dVar3 == null) {
                                                                dVar3 = new b.d(strA, 0L, j8, null, null);
                                                                map2.put(strA, dVar3);
                                                            }
                                                            j3 = j8;
                                                        }
                                                        if (obj != null || treeMap.isEmpty()) {
                                                            j4 = j15;
                                                            drmInitData = obj;
                                                        } else {
                                                            j4 = j15;
                                                            DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                            drmInitData = new DrmInitData(str2, schemeDataArr2);
                                                            if (drmInitDataC == null) {
                                                                drmInitDataC = c(str2, schemeDataArr2);
                                                            }
                                                        }
                                                        arrayList3.add(new b.d(strA, dVar != null ? dVar : dVar3, strT, jZ, i6, j11, drmInitData, strY, strD2, j3, j10, z7, arrayList));
                                                        j9 = j11 + jZ;
                                                        arrayList7 = new ArrayList();
                                                        if (j10 != -1) {
                                                            j3 += j10;
                                                        }
                                                        j8 = j3;
                                                        cVar2 = cVar;
                                                        bVar2 = bVar;
                                                        str4 = str6;
                                                        obj = drmInitData;
                                                        strT = str3;
                                                        j11 = j9;
                                                        i4 = i2;
                                                        c0357b2 = c0357b;
                                                        arrayList6 = arrayList2;
                                                        z7 = false;
                                                        j10 = -1;
                                                        jZ = 0;
                                                        strK = str2;
                                                        jM = j4;
                                                    }
                                                }
                                                cVar2 = cVar;
                                                bVar2 = bVar;
                                                str4 = str6;
                                                i4 = i2;
                                                c0357b2 = c0357b;
                                                jM = j2;
                                                strK = str2;
                                                arrayList7 = arrayList;
                                                arrayList6 = arrayList2;
                                            } else if (c0357b2 == null && "PART".equals(y(strB, N, map))) {
                                                String strY6 = y(strB, K, map);
                                                long jS = s(strB, F, -1L);
                                                long jS2 = s(strB, G, -1L);
                                                long j16 = jM;
                                                String strD3 = d(j16, strY, str6);
                                                if (obj == null && !treeMap.isEmpty()) {
                                                    DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                    DrmInitData drmInitData4 = new DrmInitData(str2, schemeDataArr3);
                                                    if (drmInitDataC == null) {
                                                        drmInitDataC = c(str2, schemeDataArr3);
                                                    }
                                                    obj = drmInitData4;
                                                }
                                                if (jS == -1 || jS2 != -1) {
                                                    c0357b2 = new b.C0357b(strY6, dVar, 0L, i6, j9, obj, strY, strD3, jS != -1 ? jS : 0L, jS2, false, false, true);
                                                }
                                                cVar2 = cVar;
                                                bVar2 = bVar;
                                                jM = j16;
                                                str4 = str6;
                                                arrayList7 = arrayList10;
                                                i4 = i2;
                                                arrayList6 = arrayList2;
                                                strK = str2;
                                            }
                                        }
                                        arrayList = arrayList10;
                                        j2 = jM;
                                    }
                                    cVar2 = cVar;
                                    bVar2 = bVar;
                                    strK = str13;
                                    str4 = str6;
                                }
                                arrayList7 = arrayList10;
                                arrayList6 = arrayList2;
                            }
                        }
                        c0357b = c0357b2;
                        cVar2 = cVar;
                        bVar2 = bVar;
                        str4 = str6;
                        i4 = i2;
                        c0357b2 = c0357b;
                        jM = j2;
                        strK = str2;
                        arrayList7 = arrayList;
                        arrayList6 = arrayList2;
                    }
                    z3 = false;
                }
                str4 = str6;
                z3 = false;
            }
        }
        int i10 = i4;
        b.C0357b c0357b3 = c0357b2;
        ArrayList arrayList11 = arrayList7;
        ArrayList arrayList12 = arrayList6;
        HashMap map3 = new HashMap();
        for (int i11 = 0; i11 < arrayList5.size(); i11++) {
            b.c cVar3 = (b.c) arrayList5.get(i11);
            long size = cVar3.b;
            if (size == -1) {
                size = (j7 + ((long) arrayList3.size())) - (arrayList11.isEmpty() ? 1L : 0L);
            }
            int size2 = cVar3.c;
            if (size2 == -1 && jI2 != -9223372036854775807L) {
                size2 = (arrayList11.isEmpty() ? ((b.d) bv2.g(arrayList3)).m : arrayList11).size() - 1;
            }
            Uri uri = cVar3.f5963a;
            map3.put(uri, new b.c(uri, size, size2));
        }
        if (c0357b3 != null) {
            arrayList11.add(c0357b3);
        }
        return new b(i10, str, arrayList12, jI, zP, jH0, z5, i5, j7, iL, jL, jI2, z4, z6, jH0 != 0, drmInitDataC, arrayList3, arrayList11, fVarX, map3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0326  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c o(a aVar, String str) throws IOException {
        String str2;
        String strY;
        String strY2;
        m.b bVarX;
        Uri uriE;
        Metadata metadata;
        m mVarG;
        ArrayList arrayList;
        ArrayList arrayList2;
        String strG;
        ArrayList arrayList3;
        int i2;
        String str3;
        String strG2;
        boolean z2;
        int i3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        int i4;
        int i5;
        ArrayList arrayList9;
        ArrayList arrayList10;
        Uri uriE2;
        HashMap map;
        int i6;
        String str4 = str;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            String str5 = "application/x-mpegURL";
            if (!aVar.a()) {
                HashMap map4 = map2;
                ArrayList arrayList19 = arrayList16;
                ArrayList arrayList20 = arrayList12;
                ArrayList arrayList21 = arrayList13;
                ArrayList arrayList22 = arrayList14;
                ArrayList arrayList23 = arrayList15;
                ArrayList arrayList24 = arrayList18;
                boolean z5 = z3;
                ArrayList arrayList25 = arrayList17;
                ArrayList arrayList26 = new ArrayList();
                HashSet hashSet = new HashSet();
                for (int i7 = 0; i7 < arrayList11.size(); i7++) {
                    c.b bVar = (c.b) arrayList11.get(i7);
                    if (hashSet.add(bVar.f5967a)) {
                        vh.g(bVar.b.j == null);
                        arrayList26.add(bVar.a(bVar.b.b().Z(new Metadata(new HlsTrackMetadataEntry(null, null, (List) vh.e((ArrayList) map4.get(bVar.f5967a))))).G()));
                    }
                }
                Uri uri = null;
                ArrayList arrayList27 = null;
                m mVar = null;
                int i8 = 0;
                while (i8 < arrayList19.size()) {
                    ArrayList arrayList28 = arrayList19;
                    str2 = (String) arrayList28.get(i8);
                    strY = y(str2, Q, map3);
                    strY2 = y(str2, P, map3);
                    bVarX = new m.b().U(strY + ":" + strY2).W(strY2).M(str5).i0(w(str2)).e0(v(str2, map3)).X(u(str2, O, map3));
                    String strU = u(str2, K, map3);
                    uriE = strU == null ? uri : v56.e(str, strU);
                    arrayList19 = arrayList28;
                    String str6 = str5;
                    metadata = new Metadata(new HlsTrackMetadataEntry(strY, strY2, Collections.emptyList()));
                    String strY3 = y(str2, M, map3);
                    strY3.hashCode();
                    switch (strY3) {
                        case "SUBTITLES":
                            mVarG = mVar;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            c.b bVarF = f(arrayList11, strY);
                            if (bVarF != null) {
                                String strK = g86.K(bVarF.b.i, 3);
                                bVarX.K(strK);
                                strG = fp3.g(strK);
                            } else {
                                strG = null;
                            }
                            if (strG == null) {
                                strG = "text/vtt";
                            }
                            bVarX.g0(strG).Z(metadata);
                            if (uriE != null) {
                                c.a aVar2 = new c.a(uriE, bVarX.G(), strY, strY2);
                                arrayList3 = arrayList22;
                                arrayList3.add(aVar2);
                                break;
                            } else {
                                arrayList3 = arrayList22;
                                y53.i("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                                break;
                            }
                            break;
                        case "CLOSED-CAPTIONS":
                            mVarG = mVar;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            String strY4 = y(str2, S, map3);
                            if (strY4.startsWith("CC")) {
                                i2 = Integer.parseInt(strY4.substring(2));
                                str3 = "application/cea-608";
                            } else {
                                i2 = Integer.parseInt(strY4.substring(7));
                                str3 = "application/cea-708";
                            }
                            if (arrayList27 == null) {
                                arrayList27 = new ArrayList();
                            }
                            bVarX.g0(str3).H(i2);
                            arrayList27.add(bVarX.G());
                            arrayList3 = arrayList22;
                            break;
                        case "AUDIO":
                            arrayList2 = arrayList20;
                            c.b bVarE = e(arrayList11, strY);
                            if (bVarE != null) {
                                mVarG = mVar;
                                String strK2 = g86.K(bVarE.b.i, 1);
                                bVarX.K(strK2);
                                strG2 = fp3.g(strK2);
                            } else {
                                mVarG = mVar;
                                strG2 = null;
                            }
                            String strU2 = u(str2, i, map3);
                            if (strU2 != null) {
                                bVarX.J(Integer.parseInt(g86.a1(strU2, "/")[0]));
                                if ("audio/eac3".equals(strG2) && strU2.endsWith("/JOC")) {
                                    bVarX.K(MimeTypes.CODEC_E_AC3_JOC);
                                    strG2 = "audio/eac3-joc";
                                }
                            }
                            bVarX.g0(strG2);
                            if (uriE != null) {
                                bVarX.Z(metadata);
                                arrayList = arrayList21;
                                arrayList.add(new c.a(uriE, bVarX.G(), strY, strY2));
                            } else {
                                arrayList = arrayList21;
                                if (bVarE != null) {
                                    mVarG = bVarX.G();
                                }
                            }
                            arrayList3 = arrayList22;
                            break;
                        case "VIDEO":
                            c.b bVarG = g(arrayList11, strY);
                            if (bVarG != null) {
                                m mVar2 = bVarG.b;
                                String strK3 = g86.K(mVar2.i, 2);
                                bVarX.K(strK3).g0(fp3.g(strK3)).n0(mVar2.q).S(mVar2.r).R(mVar2.s);
                            }
                            if (uriE != null) {
                                bVarX.Z(metadata);
                                arrayList2 = arrayList20;
                                arrayList2.add(new c.a(uriE, bVarX.G(), strY, strY2));
                                mVarG = mVar;
                                arrayList3 = arrayList22;
                                arrayList = arrayList21;
                            }
                        default:
                            mVarG = mVar;
                            arrayList3 = arrayList22;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            break;
                    }
                    i8++;
                    arrayList22 = arrayList3;
                    arrayList21 = arrayList;
                    arrayList20 = arrayList2;
                    str5 = str6;
                    mVar = mVarG;
                    uri = null;
                }
                return new c(str, arrayList24, arrayList26, arrayList20, arrayList21, arrayList22, arrayList23, mVar, z4 ? Collections.emptyList() : arrayList27, z5, map3, arrayList25);
            }
            String strB = aVar.b();
            if (strB.startsWith("#EXT")) {
                arrayList18.add(strB);
            }
            boolean zStartsWith = strB.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            boolean z6 = z3;
            if (strB.startsWith("#EXT-X-DEFINE")) {
                map3.put(y(strB, P, map3), y(strB, Z, map3));
            } else {
                if (strB.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    map = map2;
                    arrayList10 = arrayList16;
                    arrayList9 = arrayList12;
                    arrayList8 = arrayList13;
                    arrayList7 = arrayList14;
                    arrayList5 = arrayList15;
                    arrayList6 = arrayList18;
                    arrayList4 = arrayList17;
                    z3 = true;
                } else if (strB.startsWith("#EXT-X-MEDIA")) {
                    arrayList16.add(strB);
                } else if (strB.startsWith("#EXT-X-SESSION-KEY")) {
                    DrmInitData.SchemeData schemeDataJ = j(strB, t(strB, I, HTTP.IDENTITY_CODING, map3), map3);
                    if (schemeDataJ != null) {
                        arrayList17.add(new DrmInitData(k(y(strB, H, map3)), schemeDataJ));
                    }
                } else if (strB.startsWith("#EXT-X-STREAM-INF") || zStartsWith) {
                    boolean zContains = z4 | strB.contains("CLOSED-CAPTIONS=NONE");
                    if (zStartsWith) {
                        i3 = 16384;
                        z2 = zContains;
                    } else {
                        z2 = zContains;
                        i3 = 0;
                    }
                    int iL = l(strB, h);
                    arrayList4 = arrayList17;
                    arrayList5 = arrayList15;
                    int iR = r(strB, c, -1);
                    String strU3 = u(strB, j, map3);
                    arrayList6 = arrayList18;
                    String strU4 = u(strB, k, map3);
                    if (strU4 != null) {
                        arrayList7 = arrayList14;
                        String[] strArrZ0 = g86.Z0(strU4, "x");
                        int i9 = Integer.parseInt(strArrZ0[0]);
                        int i10 = Integer.parseInt(strArrZ0[1]);
                        if (i9 <= 0 || i10 <= 0) {
                            i10 = -1;
                            i6 = -1;
                        } else {
                            i6 = i9;
                        }
                        arrayList8 = arrayList13;
                        i5 = i10;
                        i4 = i6;
                    } else {
                        arrayList7 = arrayList14;
                        arrayList8 = arrayList13;
                        i4 = -1;
                        i5 = -1;
                    }
                    String strU5 = u(strB, l, map3);
                    float f2 = strU5 != null ? Float.parseFloat(strU5) : -1.0f;
                    arrayList9 = arrayList12;
                    String strU6 = u(strB, d, map3);
                    arrayList10 = arrayList16;
                    String strU7 = u(strB, e, map3);
                    HashMap map5 = map2;
                    String strU8 = u(strB, f, map3);
                    String strU9 = u(strB, g, map3);
                    if (zStartsWith) {
                        uriE2 = v56.e(str4, y(strB, K, map3));
                    } else {
                        if (!aVar.a()) {
                            throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                        }
                        uriE2 = v56.e(str4, A(aVar.b(), map3));
                    }
                    arrayList11.add(new c.b(uriE2, new m.b().T(arrayList11.size()).M("application/x-mpegURL").K(strU3).I(iR).b0(iL).n0(i4).S(i5).R(f2).e0(i3).G(), strU6, strU7, strU8, strU9));
                    map = map5;
                    ArrayList arrayList29 = (ArrayList) map.get(uriE2);
                    if (arrayList29 == null) {
                        arrayList29 = new ArrayList();
                        map.put(uriE2, arrayList29);
                    }
                    arrayList29.add(new HlsTrackMetadataEntry.VariantInfo(iR, iL, strU6, strU7, strU8, strU9));
                    z3 = z6;
                    z4 = z2;
                }
                map2 = map;
                arrayList17 = arrayList4;
                arrayList15 = arrayList5;
                arrayList18 = arrayList6;
                arrayList14 = arrayList7;
                arrayList13 = arrayList8;
                arrayList12 = arrayList9;
                arrayList16 = arrayList10;
                str4 = str;
            }
            map = map2;
            arrayList10 = arrayList16;
            arrayList9 = arrayList12;
            arrayList8 = arrayList13;
            arrayList7 = arrayList14;
            arrayList5 = arrayList15;
            arrayList6 = arrayList18;
            arrayList4 = arrayList17;
            z3 = z6;
            map2 = map;
            arrayList17 = arrayList4;
            arrayList15 = arrayList5;
            arrayList18 = arrayList6;
            arrayList14 = arrayList7;
            arrayList13 = arrayList8;
            arrayList12 = arrayList9;
            arrayList16 = arrayList10;
            str4 = str;
        }
    }

    public static boolean p(String str, Pattern pattern, boolean z2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z2;
    }

    public static double q(String str, Pattern pattern, double d2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) vh.e(matcher.group(1))) : d2;
    }

    public static int r(String str, Pattern pattern, int i2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) vh.e(matcher.group(1))) : i2;
    }

    public static long s(String str, Pattern pattern, long j2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) vh.e(matcher.group(1))) : j2;
    }

    public static String t(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) vh.e(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : A(str2, map);
    }

    @Nullable
    public static String u(String str, Pattern pattern, Map<String, String> map) {
        return t(str, pattern, null, map);
    }

    public static int v(String str, Map<String, String> map) {
        String strU = u(str, R, map);
        if (TextUtils.isEmpty(strU)) {
            return 0;
        }
        String[] strArrZ0 = g86.Z0(strU, ",");
        int i2 = g86.s(strArrZ0, "public.accessibility.describes-video") ? 512 : 0;
        if (g86.s(strArrZ0, "public.accessibility.transcribes-spoken-dialog")) {
            i2 |= 4096;
        }
        if (g86.s(strArrZ0, "public.accessibility.describes-music-and-sound")) {
            i2 |= 1024;
        }
        return g86.s(strArrZ0, "public.easy-to-read") ? i2 | 8192 : i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static int w(String str) {
        boolean zP = p(str, U, false);
        ?? r0 = zP;
        if (p(str, V, false)) {
            r0 = (zP ? 1 : 0) | 2;
        }
        return p(str, T, false) ? r0 | 4 : r0;
    }

    public static b.f x(String str) {
        double dQ = q(str, r, -9.223372036854776E18d);
        long j2 = dQ == -9.223372036854776E18d ? -9223372036854775807L : (long) (dQ * 1000000.0d);
        boolean zP = p(str, s, false);
        double dQ2 = q(str, u, -9.223372036854776E18d);
        long j3 = dQ2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (dQ2 * 1000000.0d);
        double dQ3 = q(str, v, -9.223372036854776E18d);
        return new b.f(j2, zP, j3, dQ3 != -9.223372036854776E18d ? (long) (dQ3 * 1000000.0d) : -9223372036854775807L, p(str, w, false));
    }

    public static String y(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String strU = u(str, pattern, map);
        if (strU != null) {
            return strU;
        }
        throw ParserException.createForMalformedManifest("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    public static long z(String str, Pattern pattern) throws ParserException {
        return new BigDecimal(y(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    @Override // com.google.android.exoplayer2.upstream.g.a
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public ei2 parse(Uri uri, InputStream inputStream) throws IOException {
        String strTrim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!a(bufferedReader)) {
                throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    g86.n(bufferedReader);
                    throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                }
                strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    if (!strTrim.startsWith("#EXT-X-STREAM-INF")) {
                        if (strTrim.startsWith("#EXT-X-TARGETDURATION") || strTrim.startsWith("#EXT-X-MEDIA-SEQUENCE") || strTrim.startsWith("#EXTINF") || strTrim.startsWith("#EXT-X-KEY") || strTrim.startsWith("#EXT-X-BYTERANGE") || strTrim.equals("#EXT-X-DISCONTINUITY") || strTrim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || strTrim.equals("#EXT-X-ENDLIST")) {
                            break;
                        }
                        arrayDeque.add(strTrim);
                    } else {
                        arrayDeque.add(strTrim);
                        return o(new a(arrayDeque, bufferedReader), uri.toString());
                    }
                }
            }
            arrayDeque.add(strTrim);
            return n(this.f5958a, this.b, new a(arrayDeque, bufferedReader), uri.toString());
        } finally {
            g86.n(bufferedReader);
        }
    }

    public HlsPlaylistParser(c cVar, @Nullable b bVar) {
        this.f5958a = cVar;
        this.b = bVar;
    }
}
