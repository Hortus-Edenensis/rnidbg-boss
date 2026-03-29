package defpackage;

import android.text.Layout;
import androidx.annotation.Nullable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.umeng.analytics.pro.dn;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class l26 extends md5 {
    public static final Pattern p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    public static final Pattern q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    public static final Pattern r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    public static final Pattern s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    public static final Pattern t = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    public static final Pattern u = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    public static final Pattern v = Pattern.compile("^(\\d+) (\\d+)$");
    public static final b w = new b(30.0f, 1, 1);
    public static final a x = new a(32, 15);
    public final XmlPullParserFactory o;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18894a;
        public final int b;

        public a(int i, int i2) {
            this.f18894a = i;
            this.b = i2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f18895a;
        public final int b;
        public final int c;

        public b(float f, int i, int i2) {
            this.f18895a = f;
            this.b = i;
            this.c = i2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18896a;
        public final int b;

        public c(int i, int i2) {
            this.f18896a = i;
            this.b = i2;
        }
    }

    public l26() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.o = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public static a A(XmlPullParser xmlPullParser, a aVar) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = v.matcher(attributeValue);
        if (!matcher.matches()) {
            y53.i("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int i = Integer.parseInt((String) vh.e(matcher.group(1)));
            int i2 = Integer.parseInt((String) vh.e(matcher.group(2)));
            if (i != 0 && i2 != 0) {
                return new a(i, i2);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + i + " " + i2);
        } catch (NumberFormatException unused) {
            y53.i("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    public static void B(String str, p26 p26Var) throws SubtitleDecoderException {
        Matcher matcher;
        String str2;
        String[] strArrZ0 = g86.Z0(str, "\\s+");
        if (strArrZ0.length == 1) {
            matcher = r.matcher(str);
        } else {
            if (strArrZ0.length != 2) {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + strArrZ0.length + ".");
            }
            matcher = r.matcher(strArrZ0[1]);
            y53.i("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
        str2 = (String) vh.e(matcher.group(3));
        str2.hashCode();
        switch (str2) {
            case "%":
                p26Var.z(3);
                break;
            case "em":
                p26Var.z(2);
                break;
            case "px":
                p26Var.z(1);
                break;
            default:
                throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
        }
        p26Var.y(Float.parseFloat((String) vh.e(matcher.group(1))));
    }

    public static b C(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        float f;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (g86.Z0(attributeValue2, " ").length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f = 1.0f;
        }
        b bVar = w;
        int i2 = bVar.b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = bVar.c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new b(i * f, i2, i3);
    }

    public static Map<String, p26> D(XmlPullParser xmlPullParser, Map<String, p26> map, a aVar, @Nullable c cVar, Map<String, n26> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
        do {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser, "style")) {
                String strA = cp6.a(xmlPullParser, "style");
                p26 p26VarI = I(xmlPullParser, new p26());
                if (strA != null) {
                    for (String str : J(strA)) {
                        p26VarI.a(map.get(str));
                    }
                }
                String strG = p26VarI.g();
                if (strG != null) {
                    map.put(strG, p26VarI);
                }
            } else if (cp6.f(xmlPullParser, "region")) {
                n26 n26VarG = G(xmlPullParser, aVar, cVar);
                if (n26VarG != null) {
                    map2.put(n26VarG.f19425a, n26VarG);
                }
            } else if (cp6.f(xmlPullParser, "metadata")) {
                E(xmlPullParser, map3);
            }
        } while (!cp6.d(xmlPullParser, "head"));
        return map;
    }

    public static void E(XmlPullParser xmlPullParser, Map<String, String> map) throws XmlPullParserException, IOException {
        String strA;
        do {
            xmlPullParser.next();
            if (cp6.f(xmlPullParser, "image") && (strA = cp6.a(xmlPullParser, "id")) != null) {
                map.put(strA, xmlPullParser.nextText());
            }
        } while (!cp6.d(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static m26 F(XmlPullParser xmlPullParser, @Nullable m26 m26Var, Map<String, n26> map, b bVar) throws SubtitleDecoderException {
        long j;
        long j2;
        String attributeValue;
        int attributeCount = xmlPullParser.getAttributeCount();
        p26 p26VarI = I(xmlPullParser, null);
        String[] strArr = null;
        String strSubstring = null;
        String str = "";
        long jK = -9223372036854775807L;
        long jK2 = -9223372036854775807L;
        long jK3 = -9223372036854775807L;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeValue = xmlPullParser.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName) {
                case "region":
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        continue;
                    }
                    break;
                case "dur":
                    jK3 = K(attributeValue, bVar);
                    break;
                case "end":
                    jK2 = K(attributeValue, bVar);
                    break;
                case "begin":
                    jK = K(attributeValue, bVar);
                    break;
                case "style":
                    String[] strArrJ = J(attributeValue);
                    if (strArrJ.length > 0) {
                        strArr = strArrJ;
                        break;
                    }
                    break;
                case "backgroundImage":
                    if (attributeValue.startsWith("#")) {
                        strSubstring = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (m26Var != null) {
            long j3 = m26Var.d;
            j = -9223372036854775807L;
            if (j3 != -9223372036854775807L) {
                if (jK != -9223372036854775807L) {
                    jK += j3;
                }
                if (jK2 != -9223372036854775807L) {
                    jK2 += j3;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        long j4 = jK;
        if (jK2 != j) {
            j2 = jK2;
        } else if (jK3 != j) {
            j2 = j4 + jK3;
        } else if (m26Var != null) {
            long j5 = m26Var.e;
            if (j5 != j) {
                j2 = j5;
            }
        }
        return m26.c(xmlPullParser.getName(), j4, j2, p26VarI, strArr, str, strSubstring, m26Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b4  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static n26 G(XmlPullParser xmlPullParser, a aVar, @Nullable c cVar) {
        float f;
        float f2;
        float f3;
        float f4;
        a aVar2;
        float f5;
        int i;
        int i2;
        String strA = cp6.a(xmlPullParser, "id");
        if (strA == null) {
            return null;
        }
        String strA2 = cp6.a(xmlPullParser, "origin");
        if (strA2 == null) {
            y53.i("TtmlDecoder", "Ignoring region without an origin");
            return null;
        }
        Pattern pattern = t;
        Matcher matcher = pattern.matcher(strA2);
        Pattern pattern2 = u;
        Matcher matcher2 = pattern2.matcher(strA2);
        if (matcher.matches()) {
            try {
                float f6 = Float.parseFloat((String) vh.e(matcher.group(1))) / 100.0f;
                f = Float.parseFloat((String) vh.e(matcher.group(2))) / 100.0f;
                f2 = f6;
            } catch (NumberFormatException unused) {
                y53.i("TtmlDecoder", "Ignoring region with malformed origin: " + strA2);
                return null;
            }
        } else {
            if (!matcher2.matches()) {
                y53.i("TtmlDecoder", "Ignoring region with unsupported origin: " + strA2);
                return null;
            }
            if (cVar == null) {
                y53.i("TtmlDecoder", "Ignoring region with missing tts:extent: " + strA2);
                return null;
            }
            try {
                int i3 = Integer.parseInt((String) vh.e(matcher2.group(1)));
                f2 = i3 / cVar.f18896a;
                f = Integer.parseInt((String) vh.e(matcher2.group(2))) / cVar.b;
            } catch (NumberFormatException unused2) {
                y53.i("TtmlDecoder", "Ignoring region with malformed origin: " + strA2);
                return null;
            }
        }
        String strA3 = cp6.a(xmlPullParser, "extent");
        if (strA3 == null) {
            y53.i("TtmlDecoder", "Ignoring region without an extent");
            return null;
        }
        Matcher matcher3 = pattern.matcher(strA3);
        Matcher matcher4 = pattern2.matcher(strA3);
        if (matcher3.matches()) {
            try {
                f3 = Float.parseFloat((String) vh.e(matcher3.group(1))) / 100.0f;
                f4 = Float.parseFloat((String) vh.e(matcher3.group(2))) / 100.0f;
            } catch (NumberFormatException unused3) {
                y53.i("TtmlDecoder", "Ignoring region with malformed extent: " + strA2);
                return null;
            }
        } else {
            if (!matcher4.matches()) {
                y53.i("TtmlDecoder", "Ignoring region with unsupported extent: " + strA2);
                return null;
            }
            if (cVar == null) {
                y53.i("TtmlDecoder", "Ignoring region with missing tts:extent: " + strA2);
                return null;
            }
            try {
                int i4 = Integer.parseInt((String) vh.e(matcher4.group(1)));
                f3 = i4 / cVar.f18896a;
                f4 = Integer.parseInt((String) vh.e(matcher4.group(2))) / cVar.b;
            } catch (NumberFormatException unused4) {
                y53.i("TtmlDecoder", "Ignoring region with malformed extent: " + strA2);
                return null;
            }
        }
        String strA4 = cp6.a(xmlPullParser, "displayAlign");
        if (strA4 != null) {
            String strE = th.e(strA4);
            strE.hashCode();
            if (strE.equals("center")) {
                aVar2 = aVar;
                f5 = f + (f4 / 2.0f);
                i = 1;
            } else if (strE.equals("after")) {
                aVar2 = aVar;
                f5 = f + f4;
                i = 2;
            } else {
                aVar2 = aVar;
                f5 = f;
                i = 0;
            }
        }
        float f7 = 1.0f / aVar2.b;
        String strA5 = cp6.a(xmlPullParser, "writingMode");
        if (strA5 != null) {
            String strE2 = th.e(strA5);
            strE2.hashCode();
            switch (strE2) {
                case "tb":
                case "tblr":
                    i2 = 2;
                    break;
                case "tbrl":
                    i2 = 1;
                    break;
                default:
                    i2 = Integer.MIN_VALUE;
                    break;
            }
        }
        return new n26(strA, f2, f5, 0, i, f3, f4, 1, f7, i2);
    }

    public static float H(String str) {
        Matcher matcher = s.matcher(str);
        if (!matcher.matches()) {
            y53.i("TtmlDecoder", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) vh.e(matcher.group(1)))));
        } catch (NumberFormatException e) {
            y53.j("TtmlDecoder", "Failed to parse shear: " + str, e);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static p26 I(XmlPullParser xmlPullParser, p26 p26Var) {
        byte b2;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -1550943582:
                    b2 = attributeName.equals("fontStyle") ? (byte) 0 : (byte) -1;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        b2 = 1;
                        break;
                    }
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        b2 = 2;
                        break;
                    }
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        b2 = 3;
                        break;
                    }
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        b2 = 4;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        b2 = 5;
                        break;
                    }
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        b2 = 6;
                        break;
                    }
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        b2 = 7;
                        break;
                    }
                    break;
                case 109403361:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_SHEAR)) {
                        b2 = 8;
                        break;
                    }
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        b2 = 9;
                        break;
                    }
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        b2 = 10;
                        break;
                    }
                    break;
                case 921125321:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_EMPHASIS)) {
                        b2 = 11;
                        break;
                    }
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        b2 = 12;
                        break;
                    }
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        b2 = dn.k;
                        break;
                    }
                    break;
                case 1754920356:
                    if (attributeName.equals(TtmlNode.ATTR_EBUTTS_MULTI_ROW_ALIGN)) {
                        b2 = dn.l;
                        break;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                    p26Var = x(p26Var).B("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    p26Var = x(p26Var).x(attributeValue);
                    break;
                case 2:
                    p26Var = x(p26Var).H(z(attributeValue));
                    break;
                case 3:
                    String strE = th.e(attributeValue);
                    strE.hashCode();
                    switch (strE) {
                        case "nounderline":
                            p26Var = x(p26Var).K(false);
                            break;
                        case "underline":
                            p26Var = x(p26Var).K(true);
                            break;
                        case "nolinethrough":
                            p26Var = x(p26Var).C(false);
                            break;
                        case "linethrough":
                            p26Var = x(p26Var).C(true);
                            break;
                    }
                    break;
                case 4:
                    p26Var = x(p26Var).v("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if ("style".equals(xmlPullParser.getName())) {
                        p26Var = x(p26Var).A(attributeValue);
                    }
                    break;
                case 6:
                    String strE2 = th.e(attributeValue);
                    strE2.hashCode();
                    switch (strE2) {
                        case "baseContainer":
                        case "base":
                            p26Var = x(p26Var).F(2);
                            break;
                        case "container":
                            p26Var = x(p26Var).F(1);
                            break;
                        case "delimiter":
                            p26Var = x(p26Var).F(4);
                            break;
                        case "textContainer":
                        case "text":
                            p26Var = x(p26Var).F(3);
                            break;
                    }
                    break;
                case 7:
                    p26Var = x(p26Var);
                    try {
                        p26Var.w(qh0.c(attributeValue));
                    } catch (IllegalArgumentException unused) {
                        y53.i("TtmlDecoder", "Failed parsing color value: " + attributeValue);
                    }
                    break;
                case 8:
                    p26Var = x(p26Var).G(H(attributeValue));
                    break;
                case 9:
                    String strE3 = th.e(attributeValue);
                    strE3.hashCode();
                    if (strE3.equals("all")) {
                        p26Var = x(p26Var).I(true);
                    } else if (strE3.equals("none")) {
                        p26Var = x(p26Var).I(false);
                    }
                    break;
                case 10:
                    try {
                        p26Var = x(p26Var);
                        B(attributeValue, p26Var);
                    } catch (SubtitleDecoderException unused2) {
                        y53.i("TtmlDecoder", "Failed parsing fontSize value: " + attributeValue);
                    }
                    break;
                case 11:
                    p26Var = x(p26Var).J(qu5.a(attributeValue));
                    break;
                case 12:
                    String strE4 = th.e(attributeValue);
                    strE4.hashCode();
                    if (strE4.equals("before")) {
                        p26Var = x(p26Var).E(1);
                    } else if (strE4.equals("after")) {
                        p26Var = x(p26Var).E(2);
                    }
                    break;
                case 13:
                    p26Var = x(p26Var);
                    try {
                        p26Var.u(qh0.c(attributeValue));
                    } catch (IllegalArgumentException unused3) {
                        y53.i("TtmlDecoder", "Failed parsing background value: " + attributeValue);
                    }
                    break;
                case 14:
                    p26Var = x(p26Var).D(z(attributeValue));
                    break;
            }
        }
        return p26Var;
    }

    public static String[] J(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : g86.Z0(strTrim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long K(String str, b bVar) throws SubtitleDecoderException {
        double d;
        double d2;
        double d3;
        Matcher matcher = p.matcher(str);
        if (matcher.matches()) {
            double d4 = (Long.parseLong((String) vh.e(matcher.group(1))) * 3600) + (Long.parseLong((String) vh.e(matcher.group(2))) * 60) + Long.parseLong((String) vh.e(matcher.group(3)));
            String strGroup = matcher.group(4);
            return (long) ((d4 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d) + (matcher.group(5) != null ? Long.parseLong(r13) / bVar.f18895a : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r13) / ((double) bVar.b)) / ((double) bVar.f18895a) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = q.matcher(str);
        if (!matcher2.matches()) {
            throw new SubtitleDecoderException("Malformed time expression: " + str);
        }
        d = Double.parseDouble((String) vh.e(matcher2.group(1)));
        String str2 = (String) vh.e(matcher2.group(2));
        str2.hashCode();
        switch (str2) {
            case "f":
                d2 = bVar.f18895a;
                d /= d2;
                return (long) (d * 1000000.0d);
            case "h":
                d3 = 3600.0d;
                break;
            case "m":
                d3 = 60.0d;
                break;
            case "t":
                d2 = bVar.c;
                d /= d2;
                return (long) (d * 1000000.0d);
            case "ms":
                d2 = 1000.0d;
                d /= d2;
                return (long) (d * 1000000.0d);
            default:
                return (long) (d * 1000000.0d);
        }
        d *= d3;
        return (long) (d * 1000000.0d);
    }

    @Nullable
    public static c L(XmlPullParser xmlPullParser) {
        String strA = cp6.a(xmlPullParser, "extent");
        if (strA == null) {
            return null;
        }
        Matcher matcher = u.matcher(strA);
        if (!matcher.matches()) {
            y53.i("TtmlDecoder", "Ignoring non-pixel tts extent: " + strA);
            return null;
        }
        try {
            return new c(Integer.parseInt((String) vh.e(matcher.group(1))), Integer.parseInt((String) vh.e(matcher.group(2))));
        } catch (NumberFormatException unused) {
            y53.i("TtmlDecoder", "Ignoring malformed tts extent: " + strA);
            return null;
        }
    }

    public static p26 x(@Nullable p26 p26Var) {
        return p26Var == null ? new p26() : p26Var;
    }

    public static boolean y(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    @Nullable
    public static Layout.Alignment z(String str) {
        String strE = th.e(str);
        strE.hashCode();
        switch (strE) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    @Override // defpackage.md5
    public dn5 v(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        b bVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.o.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new n26(""));
            c cVarL = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarC = w;
            a aVarA = x;
            q26 q26Var = null;
            int i2 = 0;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                m26 m26Var = (m26) arrayDeque.peek();
                if (i2 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVarC = C(xmlPullParserNewPullParser);
                            aVarA = A(xmlPullParserNewPullParser, x);
                            cVarL = L(xmlPullParserNewPullParser);
                        }
                        c cVar = cVarL;
                        b bVar2 = bVarC;
                        a aVar = aVarA;
                        if (y(name)) {
                            if ("head".equals(name)) {
                                bVar = bVar2;
                                D(xmlPullParserNewPullParser, map, aVar, cVar, map2, map3);
                            } else {
                                bVar = bVar2;
                                try {
                                    m26 m26VarF = F(xmlPullParserNewPullParser, m26Var, map2, bVar);
                                    arrayDeque.push(m26VarF);
                                    if (m26Var != null) {
                                        m26Var.a(m26VarF);
                                    }
                                } catch (SubtitleDecoderException e) {
                                    y53.j("TtmlDecoder", "Suppressing parser error", e);
                                    i2++;
                                }
                            }
                            bVarC = bVar;
                        } else {
                            y53.f("TtmlDecoder", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            i2++;
                            bVarC = bVar2;
                        }
                        cVarL = cVar;
                        aVarA = aVar;
                    } else if (eventType == 4) {
                        ((m26) vh.e(m26Var)).a(m26.d(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            q26Var = new q26((m26) vh.e((m26) arrayDeque.peek()), map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                xmlPullParserNewPullParser.next();
            }
            if (q26Var != null) {
                return q26Var;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }
}
