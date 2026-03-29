package com.bytedance.sdk.component.x.fx;

import android.util.Xml;
import com.huawei.openalliance.ad.constant.x;
import com.qq.gdt.action.ActionUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements com.bytedance.sdk.component.x.nr, com.bytedance.sdk.component.x.u {
    private final boolean nr;
    private final com.bytedance.sdk.component.b.nr.u u;

    public iz(com.bytedance.sdk.component.b.nr.u uVar) {
        this.u = uVar;
        this.nr = false;
    }

    @Override // com.bytedance.sdk.component.x.u
    public Map<String, Object> u(File file) throws Throwable {
        FileInputStream fileInputStream;
        HashMap map = new HashMap();
        if (!file.exists() || !file.canRead()) {
            return map;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException unused) {
            }
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setInput(fileInputStream, null);
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                    if (eventType == 2) {
                        String name = xmlPullParserNewPullParser.getName();
                        if ("string".equals(name) || "int".equals(name) || "long".equals(name) || "float".equals(name) || "boolean".equals(name) || "set".equals(name)) {
                            String attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "name");
                            Object objU = u(xmlPullParserNewPullParser, name);
                            if (attributeValue != null && objU != null) {
                                map.put(attributeValue, objU);
                            }
                        }
                    }
                }
                fileInputStream.close();
            } catch (Exception unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return new com.bytedance.sdk.component.x.u.nr().u(map, this.u, this.nr);
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        return new com.bytedance.sdk.component.x.u.nr().u(map, this.u, this.nr);
    }

    public iz(com.bytedance.sdk.component.b.nr.u uVar, boolean z) {
        this.u = uVar;
        this.nr = z;
    }

    private Object u(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        str.hashCode();
        switch (str) {
            case "string":
                return xmlPullParser.nextText();
            case "int":
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT)));
            case "set":
                return u(xmlPullParser);
            case "long":
                return Long.valueOf(Long.parseLong(xmlPullParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT)));
            case "boolean":
                return Boolean.valueOf(Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT)));
            case "float":
                return Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT)));
            default:
                return null;
        }
    }

    private Set<String> u(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashSet hashSet = new HashSet();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && "set".equals(xmlPullParser.getName())) {
                return hashSet;
            }
            if (eventType == 2 && "string".equals(xmlPullParser.getName())) {
                hashSet.add(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    private void u(String str, Object obj, XmlSerializer xmlSerializer) throws IOException {
        if (obj instanceof String) {
            xmlSerializer.startTag(null, "string");
            xmlSerializer.attribute(null, "name", str);
            xmlSerializer.text(u((String) obj));
            xmlSerializer.endTag(null, "string");
            return;
        }
        if (obj instanceof Integer) {
            u(str, (Integer) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Long) {
            u(str, (Long) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Float) {
            u(str, (Float) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Double) {
            u(str, (Double) obj, xmlSerializer);
        } else if (obj instanceof Boolean) {
            u(str, (Boolean) obj, xmlSerializer);
        } else if (obj instanceof Set) {
            u(str, (Set<String>) obj, xmlSerializer);
        }
    }

    private void u(String str, Integer num, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "int");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, ActionUtils.PAYMENT_AMOUNT, Integer.toString(num.intValue()));
        xmlSerializer.endTag(null, "int");
    }

    private void u(String str, Long l, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "long");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, ActionUtils.PAYMENT_AMOUNT, Long.toString(l.longValue()));
        xmlSerializer.endTag(null, "long");
    }

    private void u(String str, Float f, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "float");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, ActionUtils.PAYMENT_AMOUNT, Float.toString(f.floatValue()));
        xmlSerializer.endTag(null, "float");
    }

    private void u(String str, Double d, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "double");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, ActionUtils.PAYMENT_AMOUNT, Double.toString(d.doubleValue()));
        xmlSerializer.endTag(null, "double");
    }

    private void u(String str, Boolean bool, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "boolean");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, ActionUtils.PAYMENT_AMOUNT, Boolean.toString(bool.booleanValue()));
        xmlSerializer.endTag(null, "boolean");
    }

    private void u(String str, Set<String> set, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "set");
        xmlSerializer.attribute(null, "name", str);
        for (String str2 : set) {
            xmlSerializer.startTag(null, "string");
            xmlSerializer.text(u(str2));
            xmlSerializer.endTag(null, "string");
        }
        xmlSerializer.endTag(null, "set");
    }

    @Override // com.bytedance.sdk.component.x.nr
    public void u(Map<String, Object> map, File file) throws Throwable {
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Map<String, Object> mapNr = new com.bytedance.sdk.component.x.u.nr().nr(map, this.u, this.nr);
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                xmlSerializerNewSerializer.setOutput(fileOutputStream2, "utf-8");
                xmlSerializerNewSerializer.startDocument(null, Boolean.TRUE);
                xmlSerializerNewSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                xmlSerializerNewSerializer.startTag(null, "map");
                for (String str : mapNr.keySet()) {
                    if (str != null) {
                        u(str, mapNr.get(str), xmlSerializerNewSerializer);
                    }
                }
                xmlSerializerNewSerializer.endTag(null, "map");
                xmlSerializerNewSerializer.endDocument();
                try {
                    fileOutputStream2.close();
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused4) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String u(String str) {
        int i;
        StringBuilder sb = null;
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt < ' ' || cCharAt > 55295) && !((cCharAt >= 57344 && cCharAt <= 65533) || cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r')) {
                if (sb == null) {
                    sb = new StringBuilder();
                    if (i2 > 0) {
                        sb.append(str.substring(0, i2));
                    }
                }
                if (cCharAt == '\"') {
                    sb.append("&quot;");
                } else if (cCharAt == '<') {
                    sb.append("&lt;");
                } else if (cCharAt == '>') {
                    sb.append("&gt;");
                } else if (cCharAt == '&') {
                    sb.append("&amp;");
                } else if (cCharAt != '\'') {
                    if (Character.isHighSurrogate(cCharAt) && (i = i2 + 1) < length) {
                        char cCharAt2 = str.charAt(i);
                        if (Character.isLowSurrogate(cCharAt2)) {
                            sb.append(cCharAt);
                            sb.append(cCharAt2);
                            i2 = i;
                        }
                    } else {
                        sb.append("&#");
                        sb.append((int) cCharAt);
                        sb.append(x.aQ);
                    }
                } else {
                    sb.append("&apos;");
                }
            } else if (sb != null) {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb != null ? sb.toString() : str;
    }
}
