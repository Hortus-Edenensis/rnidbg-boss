package com.opos.exoplayer.core.text.ttml;

import android.text.Layout;
import com.opos.exoplayer.core.util.g;
import com.opos.exoplayer.core.util.y;
import com.opos.exoplayer.core.util.z;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends com.opos.exoplayer.core.text.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f8348a = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern b = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern c = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern d = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final C0703a e = new C0703a(30.0f, 1, 1);
    private final XmlPullParserFactory f;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.text.ttml.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0703a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f8349a;
        final int b;
        final int c;

        public C0703a(float f, int i, int i2) {
            this.f8349a = f;
            this.b = i;
            this.c = i2;
        }
    }

    public a() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long a(String str, C0703a c0703a) throws com.opos.exoplayer.core.text.d {
        double d2;
        double d3;
        double d4;
        Matcher matcher = f8348a.matcher(str);
        if (matcher.matches()) {
            double d5 = (Long.parseLong(matcher.group(1)) * 3600) + (Long.parseLong(matcher.group(2)) * 60) + Long.parseLong(matcher.group(3));
            String strGroup = matcher.group(4);
            return (long) ((d5 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d) + (matcher.group(5) != null ? Long.parseLong(r13) / c0703a.f8349a : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r13) / ((double) c0703a.b)) / ((double) c0703a.f8349a) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = b.matcher(str);
        if (!matcher2.matches()) {
            throw new com.opos.exoplayer.core.text.d("Malformed time expression: " + str);
        }
        d2 = Double.parseDouble(matcher2.group(1));
        String strGroup2 = matcher2.group(2);
        strGroup2.hashCode();
        switch (strGroup2) {
            case "f":
                d3 = c0703a.f8349a;
                d2 /= d3;
                return (long) (d2 * 1000000.0d);
            case "h":
                d4 = 3600.0d;
                break;
            case "m":
                d4 = 60.0d;
                break;
            case "t":
                d3 = c0703a.c;
                d2 /= d3;
                return (long) (d2 * 1000000.0d);
            case "ms":
                d3 = 1000.0d;
                d2 /= d3;
                return (long) (d2 * 1000000.0d);
            default:
                return (long) (d2 * 1000000.0d);
        }
        d2 *= d4;
        return (long) (d2 * 1000000.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c b(XmlPullParser xmlPullParser) {
        String string;
        StringBuilder sb;
        String str;
        float f;
        String strC = z.c(xmlPullParser, "id");
        if (strC == null) {
            return null;
        }
        String strC2 = z.c(xmlPullParser, "origin");
        if (strC2 != null) {
            Pattern pattern = d;
            Matcher matcher = pattern.matcher(strC2);
            if (matcher.matches()) {
                int i = 1;
                try {
                    float f2 = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float f3 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String strC3 = z.c(xmlPullParser, "extent");
                    if (strC3 != null) {
                        Matcher matcher2 = pattern.matcher(strC3);
                        if (matcher2.matches()) {
                            try {
                                float f4 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float f5 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                String strC4 = z.c(xmlPullParser, "displayAlign");
                                if (strC4 != null) {
                                    String strD = y.d(strC4);
                                    strD.hashCode();
                                    if (strD.equals("after")) {
                                        f = f3 + f5;
                                        i = 2;
                                    } else if (strD.equals("center")) {
                                        f = f3 + (f5 / 2.0f);
                                    } else {
                                        f = f3;
                                        i = 0;
                                    }
                                }
                                return new c(strC, f2, f, 0, i, f4);
                            } catch (NumberFormatException unused) {
                                sb = new StringBuilder();
                                str = "Ignoring region with malformed extent: ";
                            }
                        } else {
                            sb = new StringBuilder();
                            str = "Ignoring region with unsupported extent: ";
                        }
                    } else {
                        string = "Ignoring region without an extent";
                    }
                } catch (NumberFormatException unused2) {
                    sb = new StringBuilder();
                    str = "Ignoring region with malformed origin: ";
                }
            } else {
                sb = new StringBuilder();
                str = "Ignoring region with unsupported origin: ";
            }
            sb.append(str);
            sb.append(strC2);
            string = sb.toString();
        } else {
            string = "Ignoring region without an origin";
        }
        com.opos.cmn.an.f.a.c("TtmlDecoder", string);
        return null;
    }

    @Override // com.opos.exoplayer.core.text.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e a(byte[] bArr, int i, boolean z) throws com.opos.exoplayer.core.text.d {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            e eVar = null;
            map2.put("", new c(null));
            int i2 = 0;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            LinkedList linkedList = new LinkedList();
            C0703a c0703aA = e;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                b bVar = (b) linkedList.peekLast();
                if (i2 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            c0703aA = a(xmlPullParserNewPullParser);
                        }
                        if (!b(name)) {
                            com.opos.cmn.an.f.a.a("TtmlDecoder", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                        } else if ("head".equals(name)) {
                            a(xmlPullParserNewPullParser, map, map2);
                        } else {
                            try {
                                b bVarA = a(xmlPullParserNewPullParser, bVar, map2, c0703aA);
                                linkedList.addLast(bVarA);
                                if (bVar != null) {
                                    bVar.a(bVarA);
                                }
                            } catch (com.opos.exoplayer.core.text.d e2) {
                                com.opos.cmn.an.f.a.c("TtmlDecoder", "Suppressing parser error", e2);
                                i2++;
                            }
                        }
                        i2++;
                    } else if (eventType == 4) {
                        bVar.a(b.a(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            eVar = new e((b) linkedList.getLast(), map, map2);
                        }
                        linkedList.removeLast();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                xmlPullParserNewPullParser.next();
            }
            return eVar;
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        } catch (XmlPullParserException e4) {
            throw new com.opos.exoplayer.core.text.d("Unable to decode source", e4);
        }
    }

    private TtmlStyle a(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    private static boolean b(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TtmlStyle a(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        String attributeValue;
        StringBuilder sb;
        String str;
        TtmlStyle ttmlStyleA;
        Layout.Alignment alignment;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            switch (attributeName) {
                case "fontStyle":
                    ttmlStyle = a(ttmlStyle).d("italic".equalsIgnoreCase(attributeValue));
                    continue;
                    break;
                case "fontFamily":
                    ttmlStyle = a(ttmlStyle).a(attributeValue);
                    continue;
                    break;
                case "textAlign":
                    String strD = y.d(attributeValue);
                    strD.hashCode();
                    switch (strD) {
                        case "center":
                            ttmlStyleA = a(ttmlStyle);
                            alignment = Layout.Alignment.ALIGN_CENTER;
                            ttmlStyle = ttmlStyleA.a(alignment);
                            continue;
                            break;
                        case "end":
                        case "right":
                            ttmlStyleA = a(ttmlStyle);
                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                            ttmlStyle = ttmlStyleA.a(alignment);
                            continue;
                            break;
                        case "left":
                        case "start":
                            ttmlStyleA = a(ttmlStyle);
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                            ttmlStyle = ttmlStyleA.a(alignment);
                            continue;
                            break;
                    }
                    break;
                case "textDecoration":
                    String strD2 = y.d(attributeValue);
                    strD2.hashCode();
                    switch (strD2) {
                        case "nounderline":
                            ttmlStyle = a(ttmlStyle).b(false);
                            break;
                        case "underline":
                            ttmlStyle = a(ttmlStyle).b(true);
                            break;
                        case "nolinethrough":
                            ttmlStyle = a(ttmlStyle).a(false);
                            break;
                        case "linethrough":
                            ttmlStyle = a(ttmlStyle).a(true);
                            continue;
                            break;
                    }
                    break;
                case "fontWeight":
                    ttmlStyle = a(ttmlStyle).c("bold".equalsIgnoreCase(attributeValue));
                    continue;
                    break;
                case "id":
                    if ("style".equals(xmlPullParser.getName())) {
                        ttmlStyle = a(ttmlStyle).b(attributeValue);
                    } else {
                        continue;
                    }
                    break;
                case "color":
                    ttmlStyle = a(ttmlStyle);
                    try {
                        ttmlStyle.a(g.a(attributeValue));
                        continue;
                    } catch (IllegalArgumentException unused) {
                        sb = new StringBuilder();
                        str = "Failed parsing color value: ";
                        sb.append(str);
                        sb.append(attributeValue);
                        com.opos.cmn.an.f.a.c("TtmlDecoder", sb.toString());
                    }
                    break;
                case "fontSize":
                    try {
                        ttmlStyle = a(ttmlStyle);
                        a(attributeValue, ttmlStyle);
                        continue;
                    } catch (com.opos.exoplayer.core.text.d unused2) {
                        sb = new StringBuilder();
                        str = "Failed parsing fontSize value: ";
                        sb.append(str);
                        sb.append(attributeValue);
                        com.opos.cmn.an.f.a.c("TtmlDecoder", sb.toString());
                    }
                    break;
                case "backgroundColor":
                    ttmlStyle = a(ttmlStyle);
                    try {
                        ttmlStyle.b(g.a(attributeValue));
                        continue;
                    } catch (IllegalArgumentException unused3) {
                        sb = new StringBuilder();
                        str = "Failed parsing background value: ";
                        sb.append(str);
                        sb.append(attributeValue);
                        com.opos.cmn.an.f.a.c("TtmlDecoder", sb.toString());
                    }
                    break;
                default:
                    break;
            }
            sb.append(str);
            sb.append(attributeValue);
            com.opos.cmn.an.f.a.c("TtmlDecoder", sb.toString());
        }
        return ttmlStyle;
    }

    private C0703a a(XmlPullParser xmlPullParser) throws com.opos.exoplayer.core.text.d {
        float f;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (attributeValue2.split(" ").length != 2) {
                throw new com.opos.exoplayer.core.text.d("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f = 1.0f;
        }
        C0703a c0703a = e;
        int i2 = c0703a.b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = c0703a.c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new C0703a(i * f, i2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private b a(XmlPullParser xmlPullParser, b bVar, Map<String, c> map, C0703a c0703a) throws com.opos.exoplayer.core.text.d {
        long j;
        String attributeValue;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle ttmlStyleA = a(xmlPullParser, (TtmlStyle) null);
        String[] strArr = null;
        long jA = -9223372036854775807L;
        long jA2 = -9223372036854775807L;
        long jA3 = -9223372036854775807L;
        String str = "";
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
                    jA3 = a(attributeValue, c0703a);
                    break;
                case "end":
                    jA2 = a(attributeValue, c0703a);
                    break;
                case "begin":
                    jA = a(attributeValue, c0703a);
                    break;
                case "style":
                    String[] strArrA = a(attributeValue);
                    if (strArrA.length > 0) {
                        strArr = strArrA;
                        break;
                    }
                    break;
            }
        }
        if (bVar != null) {
            long j2 = bVar.d;
            if (j2 != -9223372036854775807L) {
                if (jA != -9223372036854775807L) {
                    jA += j2;
                }
                if (jA2 != -9223372036854775807L) {
                    jA2 += j2;
                }
            }
        }
        if (jA2 != -9223372036854775807L) {
            j = jA2;
        } else if (jA3 != -9223372036854775807L) {
            j = jA + jA3;
        } else if (bVar != null) {
            long j3 = bVar.e;
            if (j3 != -9223372036854775807L) {
                j = j3;
            }
        }
        return b.a(xmlPullParser.getName(), jA, j, ttmlStyleA, strArr, str);
    }

    private Map<String, TtmlStyle> a(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, Map<String, c> map2) throws XmlPullParserException, IOException {
        c cVarB;
        do {
            xmlPullParser.next();
            if (z.b(xmlPullParser, "style")) {
                String strC = z.c(xmlPullParser, "style");
                TtmlStyle ttmlStyleA = a(xmlPullParser, new TtmlStyle());
                if (strC != null) {
                    for (String str : a(strC)) {
                        ttmlStyleA.a(map.get(str));
                    }
                }
                if (ttmlStyleA.i() != null) {
                    map.put(ttmlStyleA.i(), ttmlStyleA);
                }
            } else if (z.b(xmlPullParser, "region") && (cVarB = b(xmlPullParser)) != null) {
                map2.put(cVarB.f8351a, cVarB);
            }
        } while (!z.a(xmlPullParser, "head"));
        return map;
    }

    private static void a(String str, TtmlStyle ttmlStyle) throws com.opos.exoplayer.core.text.d {
        Matcher matcher;
        String strGroup;
        String[] strArrSplit = str.split("\\s+");
        if (strArrSplit.length == 1) {
            matcher = c.matcher(str);
        } else {
            if (strArrSplit.length != 2) {
                throw new com.opos.exoplayer.core.text.d("Invalid number of entries for fontSize: " + strArrSplit.length + ".");
            }
            matcher = c.matcher(strArrSplit[1]);
            com.opos.cmn.an.f.a.c("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new com.opos.exoplayer.core.text.d("Invalid expression for fontSize: '" + str + "'.");
        }
        strGroup = matcher.group(3);
        strGroup.hashCode();
        switch (strGroup) {
            case "%":
                ttmlStyle.c(3);
                break;
            case "em":
                ttmlStyle.c(2);
                break;
            case "px":
                ttmlStyle.c(1);
                break;
            default:
                throw new com.opos.exoplayer.core.text.d("Invalid unit for fontSize: '" + strGroup + "'.");
        }
        ttmlStyle.a(Float.valueOf(matcher.group(1)).floatValue());
    }

    private String[] a(String str) {
        return str.split("\\s+");
    }
}
