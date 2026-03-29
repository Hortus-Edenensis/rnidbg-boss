package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.Xml;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MimeTypes;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.upstream.g;
import com.google.common.collect.ImmutableList;
import com.kuaishou.weapon.p0.t;
import com.lantern.auth.server.WkParams;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.qq.gdt.action.ActionUtils;
import defpackage.a55;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHeaders;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class au0 extends DefaultHandler implements g.a<zt0> {
    public static final Pattern b = Pattern.compile("(\\d+)(?:/(\\d+))?");
    public static final Pattern c = Pattern.compile("CC([1-4])=.*");
    public static final Pattern d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    public static final int[] e = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f1568a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f1569a;
        public final ImmutableList<cs> b;
        public final a55 c;

        @Nullable
        public final String d;
        public final ArrayList<DrmInitData.SchemeData> e;
        public final ArrayList<ab1> f;
        public final long g;
        public final List<ab1> h;
        public final List<ab1> i;

        public a(m mVar, List<cs> list, a55 a55Var, @Nullable String str, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<ab1> arrayList2, List<ab1> list2, List<ab1> list3, long j) {
            this.f1569a = mVar;
            this.b = ImmutableList.copyOf((Collection) list);
            this.c = a55Var;
            this.d = str;
            this.e = arrayList;
            this.f = arrayList2;
            this.h = list2;
            this.i = list3;
            this.g = j;
        }
    }

    public au0() {
        try {
            this.f1568a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    public static int C(List<ab1> list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            ab1 ab1Var = list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(ab1Var.f1189a) && (str = ab1Var.b) != null) {
                Matcher matcher = c.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                y53.i("MpdParser", "Unable to parse CEA-608 channel number from: " + ab1Var.b);
            }
        }
        return -1;
    }

    public static int D(List<ab1> list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            ab1 ab1Var = list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(ab1Var.f1189a) && (str = ab1Var.b) != null) {
                Matcher matcher = d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                y53.i("MpdParser", "Unable to parse CEA-708 service block number from: " + ab1Var.b);
            }
        }
        return -1;
    }

    public static long G(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : g86.O0(attributeValue);
    }

    public static ab1 H(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String strQ0 = q0(xmlPullParser, "schemeIdUri", "");
        String strQ02 = q0(xmlPullParser, ActionUtils.PAYMENT_AMOUNT, null);
        String strQ03 = q0(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!cp6.d(xmlPullParser, str));
        return new ab1(strQ0, strQ02, strQ03);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int I(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT);
        if (attributeValue == null) {
            return -1;
        }
        String strE = th.e(attributeValue);
        strE.hashCode();
        switch (strE) {
        }
        return -1;
    }

    public static int J(XmlPullParser xmlPullParser) {
        int iT = T(xmlPullParser, ActionUtils.PAYMENT_AMOUNT, -1);
        if (iT <= 0 || iT >= 33) {
            return -1;
        }
        return iT;
    }

    public static int K(XmlPullParser xmlPullParser) {
        int iBitCount;
        String attributeValue = xmlPullParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT);
        if (attributeValue == null || (iBitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return iBitCount;
    }

    public static long L(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : g86.P0(attributeValue);
    }

    public static String M(List<ab1> list) {
        for (int i = 0; i < list.size(); i++) {
            ab1 ab1Var = list.get(i);
            String str = ab1Var.f1189a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(ab1Var.b)) {
                return "audio/eac3-joc";
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && MimeTypes.CODEC_E_AC3_JOC.equals(ab1Var.b)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    public static float Q(XmlPullParser xmlPullParser, String str, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? f : Float.parseFloat(attributeValue);
    }

    public static float R(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f;
        }
        Matcher matcher = b.matcher(attributeValue);
        if (!matcher.matches()) {
            return f;
        }
        int i = Integer.parseInt(matcher.group(1));
        return !TextUtils.isEmpty(matcher.group(2)) ? i / Integer.parseInt(r2) : i;
    }

    public static int T(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    public static long V(List<ab1> list) {
        for (int i = 0; i < list.size(); i++) {
            ab1 ab1Var = list.get(i);
            if (th.a("http://dashif.org/guidelines/last-segment-number", ab1Var.f1189a)) {
                return Long.parseLong(ab1Var.b);
            }
        }
        return -1L;
    }

    public static long W(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    public static int Y(XmlPullParser xmlPullParser) {
        int iT = T(xmlPullParser, ActionUtils.PAYMENT_AMOUNT, -1);
        if (iT < 0) {
            return -1;
        }
        int[] iArr = e;
        if (iT < iArr.length) {
            return iArr[iT];
        }
        return -1;
    }

    public static int o(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        vh.g(i == i2);
        return i;
    }

    @Nullable
    public static String p(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        vh.g(str.equals(str2));
        return str;
    }

    public static void q(ArrayList<DrmInitData.SchemeData> arrayList) {
        String str;
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                str = null;
                break;
            }
            DrmInitData.SchemeData schemeData = arrayList.get(i);
            if (zv.c.equals(schemeData.uuid) && (str = schemeData.licenseServerUrl) != null) {
                arrayList.remove(i);
                break;
            }
            i++;
        }
        if (str == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            DrmInitData.SchemeData schemeData2 = arrayList.get(i2);
            if (zv.b.equals(schemeData2.uuid) && schemeData2.licenseServerUrl == null) {
                arrayList.set(i2, new DrmInitData.SchemeData(zv.c, str, schemeData2.mimeType, schemeData2.data));
            }
        }
    }

    public static String q0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    public static void r(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                int i = 0;
                while (true) {
                    if (i >= arrayList.size()) {
                        break;
                    }
                    if (arrayList.get(i).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public static String r0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String text = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                text = xmlPullParser.getText();
            } else {
                v(xmlPullParser);
            }
        } while (!cp6.d(xmlPullParser, str));
        return text;
    }

    public static long s(long j, long j2) {
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        if (j == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j;
    }

    @Nullable
    public static String t(@Nullable String str, @Nullable String str2) {
        if (fp3.o(str)) {
            return fp3.c(str2);
        }
        if (fp3.s(str)) {
            return fp3.n(str2);
        }
        if (fp3.r(str) || fp3.p(str)) {
            return str;
        }
        if (!"application/mp4".equals(str)) {
            return null;
        }
        String strG = fp3.g(str2);
        return "text/vtt".equals(strG) ? "application/x-mp4-vtt" : strG;
    }

    public static void v(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (cp6.e(xmlPullParser)) {
            int i = 1;
            while (i != 0) {
                xmlPullParser.next();
                if (cp6.e(xmlPullParser)) {
                    i++;
                } else if (cp6.c(xmlPullParser)) {
                    i--;
                }
            }
        }
    }

    public long A(XmlPullParser xmlPullParser, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    public List<cs> B(XmlPullParser xmlPullParser, List<cs> list, boolean z) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : z ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        int i2 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String strR0 = r0(xmlPullParser, "BaseURL");
        if (v56.b(strR0)) {
            if (attributeValue3 == null) {
                attributeValue3 = strR0;
            }
            return d43.k(new cs(strR0, attributeValue3, i, i2));
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            cs csVar = list.get(i3);
            String strD = v56.d(csVar.f16905a, strR0);
            String str = attributeValue3 == null ? strD : attributeValue3;
            if (z) {
                i = csVar.c;
                i2 = csVar.d;
                str = csVar.b;
            }
            arrayList.add(new cs(strD, str, i, i2));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010c  */
    /* JADX WARN: Type inference failed for: r4v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<String, DrmInitData.SchemeData> E(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String attributeValue;
        UUID uuid;
        UUID uuid2;
        ?? attributeValue2;
        ?? B;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue3 != null) {
            String strE = th.e(attributeValue3);
            strE.hashCode();
            switch (strE) {
                case "urn:uuid:e2719d58-a985-b3c9-781a-b030af78d30e":
                    uuid = zv.c;
                    attributeValue = null;
                    uuid2 = null;
                    attributeValue2 = uuid2;
                    B = uuid2;
                    break;
                case "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95":
                    uuid = zv.e;
                    attributeValue = null;
                    uuid2 = null;
                    attributeValue2 = uuid2;
                    B = uuid2;
                    break;
                case "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed":
                    uuid = zv.d;
                    attributeValue = null;
                    uuid2 = null;
                    attributeValue2 = uuid2;
                    B = uuid2;
                    break;
                case "urn:mpeg:dash:mp4protection:2011":
                    attributeValue = xmlPullParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT);
                    String strB = cp6.b(xmlPullParser, "default_KID");
                    if (!TextUtils.isEmpty(strB) && !"00000000-0000-0000-0000-000000000000".equals(strB)) {
                        String[] strArrSplit = strB.split("\\s+");
                        UUID[] uuidArr = new UUID[strArrSplit.length];
                        for (int i = 0; i < strArrSplit.length; i++) {
                            uuidArr[i] = UUID.fromString(strArrSplit[i]);
                        }
                        uuid = zv.b;
                        attributeValue2 = 0;
                        B = xo4.b(uuid, uuidArr, null);
                        break;
                    } else {
                        uuid = null;
                        uuid2 = uuid;
                        attributeValue2 = uuid2;
                        B = uuid2;
                        break;
                    }
                    break;
                default:
                    attributeValue = null;
                    uuid = null;
                    uuid2 = uuid;
                    attributeValue2 = uuid2;
                    B = uuid2;
                    break;
            }
        }
        do {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser, "clearkey:Laurl") && xmlPullParser.next() == 4) {
                B = B;
                attributeValue2 = xmlPullParser.getText();
            } else if (cp6.f(xmlPullParser, "ms:laurl")) {
                B = B;
                attributeValue2 = xmlPullParser.getAttributeValue(null, "licenseUrl");
            } else if (B == 0 && cp6.g(xmlPullParser, "pssh") && xmlPullParser.next() == 4) {
                byte[] bArrDecode = Base64.decode(xmlPullParser.getText(), 0);
                UUID uuidF = xo4.f(bArrDecode);
                if (uuidF == null) {
                    y53.i("MpdParser", "Skipping malformed cenc:pssh data");
                    uuid = uuidF;
                    B = 0;
                    attributeValue2 = attributeValue2;
                } else {
                    B = bArrDecode;
                    uuid = uuidF;
                    attributeValue2 = attributeValue2;
                }
            } else if (B == 0) {
                UUID uuid3 = zv.e;
                if (uuid3.equals(uuid) && cp6.f(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                    B = xo4.a(uuid3, Base64.decode(xmlPullParser.getText(), 0));
                    attributeValue2 = attributeValue2;
                } else {
                    v(xmlPullParser);
                    B = B;
                    attributeValue2 = attributeValue2;
                }
            }
        } while (!cp6.d(xmlPullParser, "ContentProtection"));
        return Pair.create(attributeValue, uuid != null ? new DrmInitData.SchemeData(uuid, attributeValue2, "video/mp4", B) : null);
    }

    public int F(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        return "image".equals(attributeValue) ? 4 : -1;
    }

    public Pair<Long, EventMessage> N(XmlPullParser xmlPullParser, String str, String str2, long j, long j2, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        long jW = W(xmlPullParser, "id", 0L);
        long jW2 = W(xmlPullParser, "duration", -9223372036854775807L);
        long jW3 = W(xmlPullParser, "presentationTime", 0L);
        long jU0 = g86.U0(jW2, 1000L, j);
        long jU02 = g86.U0(jW3 - j2, 1000000L, j);
        String strQ0 = q0(xmlPullParser, "messageData", null);
        byte[] bArrO = O(xmlPullParser, byteArrayOutputStream);
        Long lValueOf = Long.valueOf(jU02);
        if (strQ0 != null) {
            bArrO = g86.o0(strQ0);
        }
        return Pair.create(lValueOf, c(str, str2, jW, jU0, bArrO));
    }

    public byte[] O(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        xmlSerializerNewSerializer.setOutput(byteArrayOutputStream, f10.c.name());
        xmlPullParser.nextToken();
        while (!cp6.d(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    xmlSerializerNewSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    xmlSerializerNewSerializer.endDocument();
                    break;
                case 2:
                    xmlSerializerNewSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                        xmlSerializerNewSerializer.attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    break;
                case 3:
                    xmlSerializerNewSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    xmlSerializerNewSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    xmlSerializerNewSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    xmlSerializerNewSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    xmlSerializerNewSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    xmlSerializerNewSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    xmlSerializerNewSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    xmlSerializerNewSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        xmlSerializerNewSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public vn1 P(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        long j;
        ArrayList arrayList;
        String strQ0 = q0(xmlPullParser, "schemeIdUri", "");
        String strQ02 = q0(xmlPullParser, ActionUtils.PAYMENT_AMOUNT, "");
        long jW = W(xmlPullParser, "timescale", 1L);
        long jW2 = W(xmlPullParser, "presentationTimeOffset", 0L);
        ArrayList arrayList2 = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        while (true) {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser, "Event")) {
                byteArrayOutputStream = byteArrayOutputStream2;
                long j2 = jW2;
                j = jW2;
                arrayList = arrayList2;
                arrayList.add(N(xmlPullParser, strQ0, strQ02, jW, j2, byteArrayOutputStream));
            } else {
                byteArrayOutputStream = byteArrayOutputStream2;
                j = jW2;
                arrayList = arrayList2;
                v(xmlPullParser);
            }
            if (cp6.d(xmlPullParser, "EventStream")) {
                break;
            }
            arrayList2 = arrayList;
            byteArrayOutputStream2 = byteArrayOutputStream;
            jW2 = j;
        }
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            Pair pair = (Pair) arrayList.get(i);
            jArr[i] = ((Long) pair.first).longValue();
            eventMessageArr[i] = (EventMessage) pair.second;
        }
        return d(strQ0, strQ02, jW, jArr, eventMessageArr);
    }

    public bt4 S(XmlPullParser xmlPullParser) {
        return c0(xmlPullParser, "sourceURL", "range");
    }

    public String U(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return r0(xmlPullParser, "Label");
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x01e6 A[LOOP:0: B:25:0x00a4->B:82:0x01e6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zt0 X(XmlPullParser xmlPullParser, Uri uri) throws XmlPullParserException, IOException {
        long j;
        ArrayList arrayList;
        ArrayList arrayList2;
        long j2;
        Throwable th;
        ArrayList arrayList3;
        long j3;
        boolean z;
        long j4;
        au0 au0Var = this;
        boolean zU = au0Var.u(au0Var.a0(xmlPullParser, "profiles", new String[0]));
        long j5 = -9223372036854775807L;
        long jG = G(xmlPullParser, "availabilityStartTime", -9223372036854775807L);
        long jL = L(xmlPullParser, "mediaPresentationDuration", -9223372036854775807L);
        long jL2 = L(xmlPullParser, "minBufferTime", -9223372036854775807L);
        Throwable th2 = null;
        boolean zEquals = "dynamic".equals(xmlPullParser.getAttributeValue(null, "type"));
        long jL3 = zEquals ? L(xmlPullParser, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long jL4 = zEquals ? L(xmlPullParser, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long jL5 = zEquals ? L(xmlPullParser, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        long jG2 = G(xmlPullParser, "publishTime", -9223372036854775807L);
        long jA = zEquals ? 0L : -9223372036854775807L;
        ArrayList arrayListK = d43.k(new cs(uri.toString(), uri.toString(), zU ? 1 : Integer.MIN_VALUE, 1));
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        long j6 = zEquals ? -9223372036854775807L : 0L;
        vn4 vn4VarB0 = null;
        f76 f76VarV0 = null;
        Uri uriE = null;
        e65 e65VarP0 = null;
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    jA = au0Var.A(xmlPullParser, jA);
                    z2 = true;
                }
                arrayList5.addAll(au0Var.B(xmlPullParser, arrayListK, zU));
            } else if (cp6.f(xmlPullParser, "ProgramInformation")) {
                vn4VarB0 = b0(xmlPullParser);
            } else if (cp6.f(xmlPullParser, "UTCTiming")) {
                f76VarV0 = v0(xmlPullParser);
            } else if (cp6.f(xmlPullParser, HttpHeaders.LOCATION)) {
                uriE = v56.e(uri.toString(), xmlPullParser.nextText());
            } else if (cp6.f(xmlPullParser, "ServiceDescription")) {
                e65VarP0 = p0(xmlPullParser);
            } else {
                if (!cp6.f(xmlPullParser, "Period") || z3) {
                    j = jA;
                    arrayList = arrayList5;
                    arrayList2 = arrayListK;
                    j2 = j5;
                    th = th2;
                    arrayList3 = arrayList4;
                    v(xmlPullParser);
                } else {
                    j = jA;
                    ArrayList arrayList6 = arrayList4;
                    arrayList = arrayList5;
                    arrayList2 = arrayListK;
                    j2 = j5;
                    th = th2;
                    Pair<mg4, Long> pairZ = Z(xmlPullParser, !arrayList5.isEmpty() ? arrayList5 : arrayListK, j6, j, jG, jL4, zU);
                    mg4 mg4Var = (mg4) pairZ.first;
                    if (mg4Var.b != j2) {
                        long jLongValue = ((Long) pairZ.second).longValue();
                        if (jLongValue == j2) {
                            arrayList3 = arrayList6;
                            j3 = j2;
                        } else {
                            j3 = mg4Var.b + jLongValue;
                            arrayList3 = arrayList6;
                        }
                        arrayList3.add(mg4Var);
                        j6 = j3;
                        z = z3;
                    } else {
                        if (!zEquals) {
                            throw ParserException.createForMalformedManifest("Unable to determine start of period " + arrayList6.size(), th);
                        }
                        arrayList3 = arrayList6;
                        z = true;
                    }
                    z3 = z;
                }
                jA = j;
                if (!cp6.d(xmlPullParser, "MPD")) {
                    if (jL != j2) {
                        j4 = jL;
                    } else if (j6 != j2) {
                        j4 = j6;
                    } else {
                        if (!zEquals) {
                            throw ParserException.createForMalformedManifest("Unable to determine duration of static manifest.", th);
                        }
                        j4 = jL;
                    }
                    if (arrayList3.isEmpty()) {
                        throw ParserException.createForMalformedManifest("No periods found.", th);
                    }
                    return f(jG, j4, jL2, zEquals, jL3, jL4, jL5, jG2, vn4VarB0, f76VarV0, e65VarP0, uriE, arrayList3);
                }
                arrayList4 = arrayList3;
                th2 = th;
                arrayList5 = arrayList;
                arrayListK = arrayList2;
                j5 = j2;
                au0Var = this;
            }
            arrayList = arrayList5;
            arrayList2 = arrayListK;
            j2 = j5;
            th = th2;
            arrayList3 = arrayList4;
            if (!cp6.d(xmlPullParser, "MPD")) {
            }
        }
    }

    public Pair<mg4, Long> Z(XmlPullParser xmlPullParser, List<cs> list, long j, long j2, long j3, long j4, boolean z) throws XmlPullParserException, IOException {
        long j5;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Object obj;
        long j6;
        a55 a55VarK0;
        au0 au0Var = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        long jL = L(xmlPullParser2, "start", j);
        long j7 = -9223372036854775807L;
        long j8 = j3 != -9223372036854775807L ? j3 + jL : -9223372036854775807L;
        long jL2 = L(xmlPullParser2, "duration", -9223372036854775807L);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        long jA = j2;
        long j9 = -9223372036854775807L;
        a55 a55VarI0 = null;
        ab1 ab1VarH = null;
        boolean z2 = false;
        while (true) {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser2, "BaseURL")) {
                if (!z2) {
                    jA = au0Var.A(xmlPullParser2, jA);
                    z2 = true;
                }
                arrayList6.addAll(au0Var.B(xmlPullParser2, list, z));
                arrayList3 = arrayList5;
                arrayList = arrayList6;
                j6 = j7;
                obj = obj2;
                arrayList2 = arrayList4;
            } else {
                if (cp6.f(xmlPullParser2, "AdaptationSet")) {
                    j5 = jA;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    arrayList2.add(x(xmlPullParser, !arrayList6.isEmpty() ? arrayList6 : list, a55VarI0, jL2, jA, j9, j8, j4, z));
                    xmlPullParser2 = xmlPullParser;
                    arrayList3 = arrayList5;
                } else {
                    j5 = jA;
                    ArrayList arrayList7 = arrayList5;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    xmlPullParser2 = xmlPullParser;
                    if (cp6.f(xmlPullParser2, "EventStream")) {
                        arrayList7.add(P(xmlPullParser));
                        arrayList3 = arrayList7;
                    } else if (cp6.f(xmlPullParser2, "SegmentBase")) {
                        arrayList3 = arrayList7;
                        a55VarI0 = i0(xmlPullParser2, null);
                        obj = null;
                        jA = j5;
                        j6 = -9223372036854775807L;
                    } else {
                        arrayList3 = arrayList7;
                        if (cp6.f(xmlPullParser2, "SegmentList")) {
                            long jA2 = A(xmlPullParser2, -9223372036854775807L);
                            obj = null;
                            a55VarK0 = j0(xmlPullParser, null, j8, jL2, j5, jA2, j4);
                            j9 = jA2;
                            jA = j5;
                            j6 = -9223372036854775807L;
                        } else {
                            obj = null;
                            if (cp6.f(xmlPullParser2, "SegmentTemplate")) {
                                long jA3 = A(xmlPullParser2, -9223372036854775807L);
                                j6 = -9223372036854775807L;
                                a55VarK0 = k0(xmlPullParser, null, ImmutableList.of(), j8, jL2, j5, jA3, j4);
                                j9 = jA3;
                                jA = j5;
                            } else {
                                j6 = -9223372036854775807L;
                                if (cp6.f(xmlPullParser2, "AssetIdentifier")) {
                                    ab1VarH = H(xmlPullParser2, "AssetIdentifier");
                                } else {
                                    v(xmlPullParser);
                                }
                                jA = j5;
                            }
                        }
                        a55VarI0 = a55VarK0;
                    }
                }
                obj = null;
                j6 = -9223372036854775807L;
                jA = j5;
            }
            if (cp6.d(xmlPullParser2, "Period")) {
                return Pair.create(g(attributeValue, jL, arrayList2, arrayList3, ab1VarH), Long.valueOf(jL2));
            }
            arrayList4 = arrayList2;
            arrayList6 = arrayList;
            obj2 = obj;
            arrayList5 = arrayList3;
            j7 = j6;
            au0Var = this;
        }
    }

    public final long a(List<a55.d> list, long j, long j2, int i, long j3) {
        int iM = i >= 0 ? i + 1 : (int) g86.m(j3 - j, j2);
        for (int i2 = 0; i2 < iM; i2++) {
            list.add(l(j, j2));
            j += j2;
        }
        return j;
    }

    public String[] a0(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? strArr : attributeValue.split(",");
    }

    public c7 b(long j, int i, List<ow4> list, List<ab1> list2, List<ab1> list3, List<ab1> list4) {
        return new c7(j, i, list, list2, list3, list4);
    }

    public vn4 b0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String strNextText = null;
        String strQ0 = q0(xmlPullParser, "moreInformationURL", null);
        String strQ02 = q0(xmlPullParser, WkParams.LANG, null);
        String strNextText2 = null;
        String strNextText3 = null;
        while (true) {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser, "Title")) {
                strNextText = xmlPullParser.nextText();
            } else if (cp6.f(xmlPullParser, "Source")) {
                strNextText2 = xmlPullParser.nextText();
            } else if (cp6.f(xmlPullParser, ExifInterface.TAG_COPYRIGHT)) {
                strNextText3 = xmlPullParser.nextText();
            } else {
                v(xmlPullParser);
            }
            String str = strNextText3;
            if (cp6.d(xmlPullParser, "ProgramInformation")) {
                return new vn4(strNextText, strNextText2, str, strQ0, strQ02);
            }
            strNextText3 = str;
        }
    }

    public EventMessage c(String str, String str2, long j, long j2, byte[] bArr) {
        return new EventMessage(str, str2, j2, j, bArr);
    }

    public bt4 c0(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split("-");
            j = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j2 = (Long.parseLong(strArrSplit[1]) - j) + 1;
            }
            return h(attributeValue, j, j2);
        }
        j = 0;
        j2 = -1;
        return h(attributeValue, j, j2);
    }

    public vn1 d(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        return new vn1(str, str2, j, jArr, eventMessageArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x01ee A[LOOP:0: B:3:0x006a->B:57:0x01ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0198 A[EDGE_INSN: B:58:0x0198->B:47:0x0198 BREAK  A[LOOP:0: B:3:0x006a->B:57:0x01ee], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a d0(XmlPullParser xmlPullParser, List<cs> list, @Nullable String str, @Nullable String str2, int i, int i2, float f, int i3, int i4, @Nullable String str3, List<ab1> list2, List<ab1> list3, List<ab1> list4, List<ab1> list5, @Nullable a55 a55Var, long j, long j2, long j3, long j4, long j5, boolean z) throws XmlPullParserException, IOException {
        long j6;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        int iZ;
        long jA;
        ArrayList arrayList7;
        a55 eVar;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        ArrayList arrayList11;
        au0 au0Var = this;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        int iT = T(xmlPullParser, "bandwidth", -1);
        String strQ0 = q0(xmlPullParser, "mimeType", str);
        String strQ02 = q0(xmlPullParser, IMediaFormat.KEY_CODECS, str2);
        int iT2 = T(xmlPullParser, "width", i);
        int iT3 = T(xmlPullParser, "height", i2);
        float fR = R(xmlPullParser, f);
        int iT4 = T(xmlPullParser, "audioSamplingRate", i4);
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList(list4);
        ArrayList arrayList15 = new ArrayList(list5);
        int i5 = i3;
        a55 a55VarK0 = a55Var;
        long jA2 = j3;
        String str4 = null;
        boolean z2 = false;
        long j7 = j4;
        ArrayList arrayList16 = new ArrayList();
        while (true) {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    jA2 = au0Var.A(xmlPullParser, jA2);
                    z2 = true;
                }
                arrayList16.addAll(au0Var.B(xmlPullParser, list, z));
            } else if (cp6.f(xmlPullParser, "AudioChannelConfiguration")) {
                eVar = a55VarK0;
                arrayList10 = arrayList16;
                arrayList4 = arrayList12;
                iZ = z(xmlPullParser);
                arrayList5 = arrayList13;
                arrayList6 = arrayList15;
                arrayList11 = arrayList10;
                if (cp6.d(xmlPullParser, "Representation")) {
                    break;
                }
                arrayList15 = arrayList6;
                arrayList13 = arrayList5;
                arrayList12 = arrayList4;
                a55VarK0 = eVar;
                au0Var = this;
                i5 = iZ;
                arrayList16 = arrayList11;
            } else if (cp6.f(xmlPullParser, "SegmentBase")) {
                a55VarK0 = au0Var.i0(xmlPullParser, (a55.e) a55VarK0);
            } else {
                if (cp6.f(xmlPullParser, "SegmentList")) {
                    jA = au0Var.A(xmlPullParser, j7);
                    j6 = jA2;
                    arrayList9 = arrayList16;
                    arrayList = arrayList15;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList14;
                    a55VarK0 = j0(xmlPullParser, (a55.b) a55VarK0, j, j2, j6, jA, j5);
                    arrayList4 = arrayList12;
                } else {
                    j6 = jA2;
                    ArrayList arrayList17 = arrayList16;
                    arrayList = arrayList15;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList14;
                    if (cp6.f(xmlPullParser, "SegmentTemplate")) {
                        jA = au0Var.A(xmlPullParser, j7);
                        arrayList4 = arrayList12;
                        a55VarK0 = k0(xmlPullParser, (a55.c) a55VarK0, list5, j, j2, j6, jA, j5);
                        arrayList9 = arrayList17;
                    } else {
                        arrayList4 = arrayList12;
                        if (cp6.f(xmlPullParser, "ContentProtection")) {
                            Pair<String, DrmInitData.SchemeData> pairE = E(xmlPullParser);
                            Object obj = pairE.first;
                            if (obj != null) {
                                str4 = (String) obj;
                            }
                            Object obj2 = pairE.second;
                            if (obj2 != null) {
                                arrayList4.add((DrmInitData.SchemeData) obj2);
                            }
                            iZ = i5;
                            arrayList8 = arrayList17;
                            jA2 = j6;
                            arrayList6 = arrayList;
                            arrayList5 = arrayList2;
                            arrayList14 = arrayList3;
                            arrayList7 = arrayList8;
                            eVar = a55VarK0;
                            arrayList11 = arrayList7;
                            if (cp6.d(xmlPullParser, "Representation")) {
                            }
                        } else {
                            if (cp6.f(xmlPullParser, "InbandEventStream")) {
                                arrayList5 = arrayList2;
                                arrayList5.add(H(xmlPullParser, "InbandEventStream"));
                                arrayList6 = arrayList;
                                arrayList14 = arrayList3;
                            } else {
                                arrayList5 = arrayList2;
                                if (cp6.f(xmlPullParser, "EssentialProperty")) {
                                    arrayList14 = arrayList3;
                                    arrayList14.add(H(xmlPullParser, "EssentialProperty"));
                                    arrayList6 = arrayList;
                                } else {
                                    arrayList14 = arrayList3;
                                    if (cp6.f(xmlPullParser, "SupplementalProperty")) {
                                        arrayList6 = arrayList;
                                        arrayList6.add(H(xmlPullParser, "SupplementalProperty"));
                                    } else {
                                        arrayList6 = arrayList;
                                        v(xmlPullParser);
                                    }
                                }
                            }
                            iZ = i5;
                            jA2 = j6;
                            arrayList7 = arrayList17;
                            eVar = a55VarK0;
                            arrayList11 = arrayList7;
                            if (cp6.d(xmlPullParser, "Representation")) {
                            }
                        }
                    }
                }
                iZ = i5;
                j7 = jA;
                arrayList8 = arrayList9;
                jA2 = j6;
                arrayList6 = arrayList;
                arrayList5 = arrayList2;
                arrayList14 = arrayList3;
                arrayList7 = arrayList8;
                eVar = a55VarK0;
                arrayList11 = arrayList7;
                if (cp6.d(xmlPullParser, "Representation")) {
                }
            }
            arrayList10 = arrayList16;
            arrayList4 = arrayList12;
            iZ = i5;
            eVar = a55VarK0;
            arrayList5 = arrayList13;
            arrayList6 = arrayList15;
            arrayList11 = arrayList10;
            if (cp6.d(xmlPullParser, "Representation")) {
            }
        }
        ArrayList arrayList18 = arrayList6;
        ArrayList arrayList19 = arrayList14;
        ArrayList arrayList20 = arrayList5;
        m mVarE = e(attributeValue, strQ0, iT2, iT3, fR, iZ, iT4, iT, str3, list2, list3, strQ02, arrayList19, arrayList18);
        if (eVar == null) {
            eVar = new a55.e();
        }
        boolean zIsEmpty = arrayList11.isEmpty();
        List list6 = arrayList11;
        if (zIsEmpty) {
            list6 = list;
        }
        return new a(mVarE, list6, eVar, str4, arrayList4, arrayList20, arrayList19, arrayList18, -1L);
    }

    public m e(@Nullable String str, @Nullable String str2, int i, int i2, float f, int i3, int i4, int i5, @Nullable String str3, List<ab1> list, List<ab1> list2, @Nullable String str4, List<ab1> list3, List<ab1> list4) {
        String str5 = str4;
        String strT = t(str2, str5);
        if ("audio/eac3".equals(strT)) {
            strT = M(list4);
            if ("audio/eac3-joc".equals(strT)) {
                str5 = MimeTypes.CODEC_E_AC3_JOC;
            }
        }
        int iO0 = o0(list);
        int iH0 = h0(list) | e0(list2) | g0(list3) | g0(list4);
        Pair<Integer, Integer> pairS0 = s0(list3);
        m.b bVarX = new m.b().U(str).M(str2).g0(strT).K(str5).b0(i5).i0(iO0).e0(iH0).X(str3);
        int iD = -1;
        m.b bVarM0 = bVarX.l0(pairS0 != null ? ((Integer) pairS0.first).intValue() : -1).m0(pairS0 != null ? ((Integer) pairS0.second).intValue() : -1);
        if (fp3.s(strT)) {
            bVarM0.n0(i).S(i2).R(f);
        } else if (fp3.o(strT)) {
            bVarM0.J(i3).h0(i4);
        } else if (fp3.r(strT)) {
            if ("application/cea-608".equals(strT)) {
                iD = C(list2);
            } else if ("application/cea-708".equals(strT)) {
                iD = D(list2);
            }
            bVarM0.H(iD);
        } else if (fp3.p(strT)) {
            bVarM0.n0(i).S(i2);
        }
        return bVarM0.G();
    }

    public int e0(List<ab1> list) {
        int iT0;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            ab1 ab1Var = list.get(i2);
            if (th.a("urn:mpeg:dash:role:2011", ab1Var.f1189a)) {
                iT0 = f0(ab1Var.b);
            } else if (th.a("urn:tva:metadata:cs:AudioPurposeCS:2007", ab1Var.f1189a)) {
                iT0 = t0(ab1Var.b);
            }
            i |= iT0;
        }
        return i;
    }

    public zt0 f(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, @Nullable vn4 vn4Var, @Nullable f76 f76Var, @Nullable e65 e65Var, @Nullable Uri uri, List<mg4> list) {
        return new zt0(j, j2, j3, z, j4, j5, j6, j7, vn4Var, f76Var, e65Var, uri, list);
    }

    public int f0(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    public mg4 g(@Nullable String str, long j, List<c7> list, List<vn1> list2, @Nullable ab1 ab1Var) {
        return new mg4(str, j, list, list2, ab1Var);
    }

    public int g0(List<ab1> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (th.a("http://dashif.org/guidelines/trickmode", list.get(i2).f1189a)) {
                i |= 16384;
            }
        }
        return i;
    }

    public bt4 h(String str, long j, long j2) {
        return new bt4(str, j, j2);
    }

    public int h0(List<ab1> list) {
        int iF0 = 0;
        for (int i = 0; i < list.size(); i++) {
            ab1 ab1Var = list.get(i);
            if (th.a("urn:mpeg:dash:role:2011", ab1Var.f1189a)) {
                iF0 |= f0(ab1Var.b);
            }
        }
        return iF0;
    }

    public ow4 i(a aVar, @Nullable String str, @Nullable String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<ab1> arrayList2) {
        m.b bVarB = aVar.f1569a.b();
        if (str != null) {
            bVarB.W(str);
        }
        String str3 = aVar.d;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = aVar.e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            q(arrayList3);
            r(arrayList3);
            bVarB.O(new DrmInitData(str2, arrayList3));
        }
        ArrayList<ab1> arrayList4 = aVar.f;
        arrayList4.addAll(arrayList2);
        return ow4.n(aVar.g, bVarB.G(), aVar.b, aVar.c, arrayList4, aVar.h, aVar.i, null);
    }

    public a55.e i0(XmlPullParser xmlPullParser, @Nullable a55.e eVar) throws XmlPullParserException, IOException {
        long j;
        long j2;
        long jW = W(xmlPullParser, "timescale", eVar != null ? eVar.b : 1L);
        long jW2 = W(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.c : 0L);
        long j3 = eVar != null ? eVar.d : 0L;
        long j4 = eVar != null ? eVar.e : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] strArrSplit = attributeValue.split("-");
            j2 = Long.parseLong(strArrSplit[0]);
            j = (Long.parseLong(strArrSplit[1]) - j2) + 1;
        } else {
            j = j4;
            j2 = j3;
        }
        bt4 bt4VarS = eVar != null ? eVar.f1156a : null;
        do {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser, "Initialization")) {
                bt4VarS = S(xmlPullParser);
            } else {
                v(xmlPullParser);
            }
        } while (!cp6.d(xmlPullParser, "SegmentBase"));
        return m(bt4VarS, jW, jW2, j2, j);
    }

    public a55.b j(bt4 bt4Var, long j, long j2, long j3, long j4, @Nullable List<a55.d> list, long j5, @Nullable List<bt4> list2, long j6, long j7) {
        return new a55.b(bt4Var, j, j2, j3, j4, list, j5, list2, g86.H0(j6), g86.H0(j7));
    }

    public a55.b j0(XmlPullParser xmlPullParser, @Nullable a55.b bVar, long j, long j2, long j3, long j4, long j5) throws XmlPullParserException, IOException {
        long jW = W(xmlPullParser, "timescale", bVar != null ? bVar.b : 1L);
        long jW2 = W(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.c : 0L);
        long jW3 = W(xmlPullParser, "duration", bVar != null ? bVar.e : -9223372036854775807L);
        long jW4 = W(xmlPullParser, "startNumber", bVar != null ? bVar.d : 1L);
        long jS = s(j3, j4);
        List<a55.d> listL0 = null;
        List<bt4> arrayList = null;
        bt4 bt4VarS = null;
        do {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser, "Initialization")) {
                bt4VarS = S(xmlPullParser);
            } else if (cp6.f(xmlPullParser, "SegmentTimeline")) {
                listL0 = l0(xmlPullParser, jW, j2);
            } else if (cp6.f(xmlPullParser, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(m0(xmlPullParser));
            } else {
                v(xmlPullParser);
            }
        } while (!cp6.d(xmlPullParser, "SegmentList"));
        if (bVar != null) {
            if (bt4VarS == null) {
                bt4VarS = bVar.f1156a;
            }
            if (listL0 == null) {
                listL0 = bVar.f;
            }
            if (arrayList == null) {
                arrayList = bVar.j;
            }
        }
        return j(bt4VarS, jW, jW2, jW4, jW3, listL0, jS, arrayList, j5, j);
    }

    public a55.c k(bt4 bt4Var, long j, long j2, long j3, long j4, long j5, List<a55.d> list, long j6, @Nullable z56 z56Var, @Nullable z56 z56Var2, long j7, long j8) {
        return new a55.c(bt4Var, j, j2, j3, j4, j5, list, j6, z56Var, z56Var2, g86.H0(j7), g86.H0(j8));
    }

    public a55.c k0(XmlPullParser xmlPullParser, @Nullable a55.c cVar, List<ab1> list, long j, long j2, long j3, long j4, long j5) throws XmlPullParserException, IOException {
        long jW = W(xmlPullParser, "timescale", cVar != null ? cVar.b : 1L);
        long jW2 = W(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.c : 0L);
        long jW3 = W(xmlPullParser, "duration", cVar != null ? cVar.e : -9223372036854775807L);
        long jW4 = W(xmlPullParser, "startNumber", cVar != null ? cVar.d : 1L);
        long jV = V(list);
        long jS = s(j3, j4);
        List<a55.d> listL0 = null;
        z56 z56VarU0 = u0(xmlPullParser, "media", cVar != null ? cVar.k : null);
        z56 z56VarU02 = u0(xmlPullParser, "initialization", cVar != null ? cVar.j : null);
        bt4 bt4VarS = null;
        do {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser, "Initialization")) {
                bt4VarS = S(xmlPullParser);
            } else if (cp6.f(xmlPullParser, "SegmentTimeline")) {
                listL0 = l0(xmlPullParser, jW, j2);
            } else {
                v(xmlPullParser);
            }
        } while (!cp6.d(xmlPullParser, "SegmentTemplate"));
        if (cVar != null) {
            if (bt4VarS == null) {
                bt4VarS = cVar.f1156a;
            }
            if (listL0 == null) {
                listL0 = cVar.f;
            }
        }
        return k(bt4VarS, jW, jW2, jW4, jV, jW3, listL0, jS, z56VarU02, z56VarU0, j5, j);
    }

    public a55.d l(long j, long j2) {
        return new a55.d(j, j2);
    }

    public List<a55.d> l0(XmlPullParser xmlPullParser, long j, long j2) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long jA = 0;
        long jW = -9223372036854775807L;
        boolean z = false;
        int iT = 0;
        do {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser, ExifInterface.LATITUDE_SOUTH)) {
                long jW2 = W(xmlPullParser, "t", -9223372036854775807L);
                if (z) {
                    jA = a(arrayList, jA, jW, iT, jW2);
                }
                if (jW2 == -9223372036854775807L) {
                    jW2 = jA;
                }
                jW = W(xmlPullParser, "d", -9223372036854775807L);
                iT = T(xmlPullParser, t.k, 0);
                jA = jW2;
                z = true;
            } else {
                v(xmlPullParser);
            }
        } while (!cp6.d(xmlPullParser, "SegmentTimeline"));
        if (z) {
            a(arrayList, jA, jW, iT, g86.U0(j2, j, 1000L));
        }
        return arrayList;
    }

    public a55.e m(bt4 bt4Var, long j, long j2, long j3, long j4) {
        return new a55.e(bt4Var, j, j2, j3, j4);
    }

    public bt4 m0(XmlPullParser xmlPullParser) {
        return c0(xmlPullParser, "media", "mediaRange");
    }

    public f76 n(String str, String str2) {
        return new f76(str, str2);
    }

    public int n0(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        return (str.equals("forced_subtitle") || str.equals("forced-subtitle")) ? 2 : 0;
    }

    public int o0(List<ab1> list) {
        int iN0 = 0;
        for (int i = 0; i < list.size(); i++) {
            ab1 ab1Var = list.get(i);
            if (th.a("urn:mpeg:dash:role:2011", ab1Var.f1189a)) {
                iN0 |= n0(ab1Var.b);
            }
        }
        return iN0;
    }

    public e65 p0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        long jW = -9223372036854775807L;
        long jW2 = -9223372036854775807L;
        long jW3 = -9223372036854775807L;
        float fQ = -3.4028235E38f;
        float fQ2 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser, "Latency")) {
                jW = W(xmlPullParser, com.umeng.ccg.a.F, -9223372036854775807L);
                jW2 = W(xmlPullParser, "min", -9223372036854775807L);
                jW3 = W(xmlPullParser, "max", -9223372036854775807L);
            } else if (cp6.f(xmlPullParser, "PlaybackRate")) {
                fQ = Q(xmlPullParser, "min", -3.4028235E38f);
                fQ2 = Q(xmlPullParser, "max", -3.4028235E38f);
            }
            long j = jW;
            long j2 = jW2;
            long j3 = jW3;
            float f = fQ;
            float f2 = fQ2;
            if (cp6.d(xmlPullParser, "ServiceDescription")) {
                return new e65(j, j2, j3, f, f2);
            }
            jW = j;
            jW2 = j2;
            jW3 = j3;
            fQ = f;
            fQ2 = f2;
        }
    }

    @Nullable
    public Pair<Integer, Integer> s0(List<ab1> list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            ab1 ab1Var = list.get(i);
            if ((th.a("http://dashif.org/thumbnail_tile", ab1Var.f1189a) || th.a("http://dashif.org/guidelines/thumbnail_tile", ab1Var.f1189a)) && (str = ab1Var.b) != null) {
                String[] strArrZ0 = g86.Z0(str, "x");
                if (strArrZ0.length != 2) {
                    continue;
                } else {
                    try {
                        return Pair.create(Integer.valueOf(Integer.parseInt(strArrZ0[0])), Integer.valueOf(Integer.parseInt(strArrZ0[1])));
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public int t0(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    public final boolean u(String[] strArr) {
        for (String str : strArr) {
            if (str.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public z56 u0(XmlPullParser xmlPullParser, String str, @Nullable z56 z56Var) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? z56.b(attributeValue) : z56Var;
    }

    public f76 v0(XmlPullParser xmlPullParser) {
        return n(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT));
    }

    @Override // com.google.android.exoplayer2.upstream.g.a
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public zt0 parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f1568a.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            if (xmlPullParserNewPullParser.next() == 2 && "MPD".equals(xmlPullParserNewPullParser.getName())) {
                return X(xmlPullParserNewPullParser, uri);
            }
            throw ParserException.createForMalformedManifest("inputStream does not contain a valid media presentation description", null);
        } catch (XmlPullParserException e2) {
            throw ParserException.createForMalformedManifest(null, e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x030f A[LOOP:0: B:3:0x007e->B:71:0x030f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02d0 A[EDGE_INSN: B:72:0x02d0->B:65:0x02d0 BREAK  A[LOOP:0: B:3:0x007e->B:71:0x030f], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c7 x(XmlPullParser xmlPullParser, List<cs> list, @Nullable a55 a55Var, long j, long j2, long j3, long j4, long j5, boolean z) throws XmlPullParserException, IOException {
        long j6;
        ArrayList<ab1> arrayList;
        Object obj;
        long j7;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList<DrmInitData.SchemeData> arrayList7;
        String str;
        String str2;
        ArrayList arrayList8;
        int i;
        ArrayList<ab1> arrayList9;
        long jA;
        au0 au0Var = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long jW = W(xmlPullParser2, "id", -1L);
        int iF = F(xmlPullParser);
        String attributeValue = xmlPullParser2.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser2.getAttributeValue(null, IMediaFormat.KEY_CODECS);
        int iT = T(xmlPullParser2, "width", -1);
        int iT2 = T(xmlPullParser2, "height", -1);
        float fR = R(xmlPullParser2, -1.0f);
        int iT3 = T(xmlPullParser2, "audioSamplingRate", -1);
        String str3 = WkParams.LANG;
        String attributeValue3 = xmlPullParser2.getAttributeValue(null, WkParams.LANG);
        String attributeValue4 = xmlPullParser2.getAttributeValue(null, "label");
        ArrayList<DrmInitData.SchemeData> arrayList10 = new ArrayList<>();
        ArrayList<ab1> arrayList11 = new ArrayList<>();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        a55 a55VarK0 = a55Var;
        int i2 = iF;
        String str4 = attributeValue3;
        String strU = attributeValue4;
        String str5 = null;
        int iZ = -1;
        boolean z2 = false;
        long jA2 = j2;
        long j8 = j3;
        while (true) {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser2, "BaseURL")) {
                if (!z2) {
                    jA2 = au0Var.A(xmlPullParser2, jA2);
                    z2 = true;
                }
                j6 = j8;
                arrayList = arrayList11;
                arrayList17.addAll(au0Var.B(xmlPullParser2, list, z));
            } else {
                j6 = j8;
                arrayList = arrayList11;
                if (cp6.f(xmlPullParser2, "ContentProtection")) {
                    Pair<String, DrmInitData.SchemeData> pairE = E(xmlPullParser);
                    Object obj2 = pairE.first;
                    if (obj2 != null) {
                        str5 = (String) obj2;
                    }
                    Object obj3 = pairE.second;
                    if (obj3 != null) {
                        arrayList10.add((DrmInitData.SchemeData) obj3);
                    }
                } else {
                    if (cp6.f(xmlPullParser2, "ContentComponent")) {
                        String strP = p(str4, xmlPullParser2.getAttributeValue(null, str3));
                        int iO = o(i2, F(xmlPullParser));
                        str2 = strP;
                        obj = null;
                        j7 = jA2;
                        arrayList2 = arrayList17;
                        arrayList8 = arrayList16;
                        arrayList3 = arrayList15;
                        arrayList4 = arrayList14;
                        arrayList5 = arrayList13;
                        arrayList6 = arrayList12;
                        arrayList7 = arrayList10;
                        str = str3;
                        i = iO;
                        arrayList9 = arrayList;
                    } else {
                        int i3 = i2;
                        String str6 = str4;
                        if (cp6.f(xmlPullParser2, "Role")) {
                            arrayList13.add(H(xmlPullParser2, "Role"));
                        } else if (cp6.f(xmlPullParser2, "AudioChannelConfiguration")) {
                            iZ = z(xmlPullParser);
                        } else if (cp6.f(xmlPullParser2, "Accessibility")) {
                            arrayList12.add(H(xmlPullParser2, "Accessibility"));
                        } else if (cp6.f(xmlPullParser2, "EssentialProperty")) {
                            arrayList14.add(H(xmlPullParser2, "EssentialProperty"));
                        } else if (cp6.f(xmlPullParser2, "SupplementalProperty")) {
                            arrayList15.add(H(xmlPullParser2, "SupplementalProperty"));
                        } else if (cp6.f(xmlPullParser2, "Representation")) {
                            j7 = jA2;
                            arrayList2 = arrayList17;
                            arrayList3 = arrayList15;
                            arrayList4 = arrayList14;
                            arrayList5 = arrayList13;
                            arrayList6 = arrayList12;
                            arrayList7 = arrayList10;
                            str = str3;
                            obj = null;
                            str2 = str6;
                            a aVarD0 = d0(xmlPullParser, !arrayList17.isEmpty() ? arrayList17 : list, attributeValue, attributeValue2, iT, iT2, fR, iZ, iT3, str6, arrayList5, arrayList6, arrayList4, arrayList3, a55VarK0, j4, j, j7, j6, j5, z);
                            int iO2 = o(i3, fp3.k(aVarD0.f1569a.l));
                            arrayList8 = arrayList16;
                            arrayList8.add(aVarD0);
                            xmlPullParser2 = xmlPullParser;
                            i = iO2;
                            arrayList9 = arrayList;
                        } else {
                            obj = null;
                            j7 = jA2;
                            arrayList2 = arrayList17;
                            arrayList3 = arrayList15;
                            arrayList4 = arrayList14;
                            arrayList5 = arrayList13;
                            arrayList6 = arrayList12;
                            arrayList7 = arrayList10;
                            str = str3;
                            str2 = str6;
                            arrayList8 = arrayList16;
                            if (cp6.f(xmlPullParser, "SegmentBase")) {
                                a55VarK0 = i0(xmlPullParser, (a55.e) a55VarK0);
                                i = i3;
                                arrayList9 = arrayList;
                                j8 = j6;
                                xmlPullParser2 = xmlPullParser;
                            } else {
                                if (cp6.f(xmlPullParser, "SegmentList")) {
                                    jA = A(xmlPullParser, j6);
                                    i = i3;
                                    a55VarK0 = j0(xmlPullParser, (a55.b) a55VarK0, j4, j, j7, jA, j5);
                                    xmlPullParser2 = xmlPullParser;
                                } else {
                                    j8 = j6;
                                    i = i3;
                                    if (cp6.f(xmlPullParser, "SegmentTemplate")) {
                                        jA = A(xmlPullParser, j8);
                                        xmlPullParser2 = xmlPullParser;
                                        a55VarK0 = k0(xmlPullParser, (a55.c) a55VarK0, arrayList3, j4, j, j7, jA, j5);
                                    } else {
                                        xmlPullParser2 = xmlPullParser;
                                        if (cp6.f(xmlPullParser2, "InbandEventStream")) {
                                            arrayList9 = arrayList;
                                            arrayList9.add(H(xmlPullParser2, "InbandEventStream"));
                                        } else {
                                            arrayList9 = arrayList;
                                            if (cp6.f(xmlPullParser2, "Label")) {
                                                strU = U(xmlPullParser);
                                            } else if (cp6.e(xmlPullParser)) {
                                                y(xmlPullParser);
                                            }
                                        }
                                    }
                                }
                                j8 = jA;
                                arrayList9 = arrayList;
                            }
                            if (!cp6.d(xmlPullParser2, "AdaptationSet")) {
                                break;
                            }
                            arrayList11 = arrayList9;
                            arrayList16 = arrayList8;
                            jA2 = j7;
                            arrayList17 = arrayList2;
                            arrayList15 = arrayList3;
                            arrayList14 = arrayList4;
                            arrayList13 = arrayList5;
                            arrayList12 = arrayList6;
                            arrayList10 = arrayList7;
                            str3 = str;
                            i2 = i;
                            str4 = str2;
                            au0Var = this;
                        }
                        obj = null;
                        j7 = jA2;
                        arrayList2 = arrayList17;
                        arrayList3 = arrayList15;
                        arrayList4 = arrayList14;
                        arrayList5 = arrayList13;
                        arrayList6 = arrayList12;
                        arrayList7 = arrayList10;
                        str = str3;
                        i = i3;
                        str2 = str6;
                        arrayList9 = arrayList;
                        j8 = j6;
                        arrayList8 = arrayList16;
                        if (!cp6.d(xmlPullParser2, "AdaptationSet")) {
                        }
                    }
                    j8 = j6;
                    if (!cp6.d(xmlPullParser2, "AdaptationSet")) {
                    }
                }
            }
            j8 = j6;
            arrayList2 = arrayList17;
            arrayList8 = arrayList16;
            arrayList3 = arrayList15;
            arrayList4 = arrayList14;
            arrayList5 = arrayList13;
            arrayList6 = arrayList12;
            arrayList7 = arrayList10;
            str = str3;
            i = i2;
            str2 = str4;
            obj = null;
            j7 = jA2;
            arrayList9 = arrayList;
            if (!cp6.d(xmlPullParser2, "AdaptationSet")) {
            }
        }
        ArrayList arrayList18 = new ArrayList(arrayList8.size());
        for (int i4 = 0; i4 < arrayList8.size(); i4++) {
            arrayList18.add(i((a) arrayList8.get(i4), strU, str5, arrayList7, arrayList9));
        }
        return b(jW, i, arrayList18, arrayList6, arrayList4, arrayList3);
    }

    public void y(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        v(xmlPullParser);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int z(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int iJ;
        String strQ0 = q0(xmlPullParser, "schemeIdUri", null);
        strQ0.hashCode();
        iJ = -1;
        switch (strQ0) {
            case "urn:dts:dash:audio_channel_configuration:2012":
            case "tag:dts.com,2014:dash:audio_channel_configuration:2012":
                iJ = J(xmlPullParser);
                break;
            case "urn:mpeg:dash:23003:3:audio_channel_configuration:2011":
                iJ = T(xmlPullParser, ActionUtils.PAYMENT_AMOUNT, -1);
                break;
            case "tag:dolby.com,2014:dash:audio_channel_configuration:2011":
            case "urn:dolby:dash:audio_channel_configuration:2011":
                iJ = I(xmlPullParser);
                break;
            case "urn:mpeg:mpegB:cicp:ChannelConfiguration":
                iJ = Y(xmlPullParser);
                break;
            case "tag:dts.com,2018:uhd:audio_channel_configuration":
                iJ = K(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!cp6.d(xmlPullParser, "AudioChannelConfiguration"));
        return iJ;
    }
}
