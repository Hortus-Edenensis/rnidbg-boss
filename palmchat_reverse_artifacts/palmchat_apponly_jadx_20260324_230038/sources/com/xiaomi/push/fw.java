package com.xiaomi.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.bq;
import com.lantern.auth.server.WkParams;
import com.xiaomi.push.fm;
import com.xiaomi.push.fq;
import com.xiaomi.push.fs;
import com.xiaomi.push.service.am;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class fw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static XmlPullParser f11585a;

    public static fo a(XmlPullParser xmlPullParser) throws XmlPullParserException, fi, IOException {
        String attributeValue;
        boolean z = false;
        String strNextText = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue2 = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue5 = xmlPullParser.getAttributeValue("", RemoteMessageConst.TO);
            String attributeValue6 = xmlPullParser.getAttributeValue("", "type");
            am.b bVarA = com.xiaomi.push.service.am.a().a(attributeValue2, attributeValue5);
            if (bVarA == null) {
                bVarA = com.xiaomi.push.service.am.a().a(attributeValue2, attributeValue4);
            }
            if (bVarA == null) {
                throw new fi("the channel id is wrong while receiving a encrypted message");
            }
            fo foVarA = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!"s".equals(xmlPullParser.getName())) {
                        throw new fi("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new fi("error while receiving a encrypted message with wrong format");
                    }
                    String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue2) || "6".equals(attributeValue2)) {
                        fn fnVar = new fn();
                        fnVar.l(attributeValue2);
                        fnVar.b(true);
                        fnVar.n(attributeValue4);
                        fnVar.m(attributeValue5);
                        fnVar.k(attributeValue3);
                        fnVar.f(attributeValue6);
                        fl flVar = new fl("s", null, null, null);
                        flVar.m453a(text);
                        fnVar.a(flVar);
                        return fnVar;
                    }
                    a(com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(bVarA.h, attributeValue3), text));
                    f11585a.next();
                    foVarA = a(f11585a);
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
            }
            if (foVarA != null) {
                return foVarA;
            }
            throw new fi("error while receiving a encrypted message with wrong format");
        }
        fn fnVar2 = new fn();
        String attributeValue7 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue7 == null) {
            attributeValue7 = "ID_NOT_AVAILABLE";
        }
        fnVar2.k(attributeValue7);
        fnVar2.m(xmlPullParser.getAttributeValue("", RemoteMessageConst.TO));
        fnVar2.n(xmlPullParser.getAttributeValue("", "from"));
        fnVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        fnVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            attributeValue = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            attributeValue = null;
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                fnVar2.b(attributeValue8);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                fnVar2.c(attributeValue9);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue10)) {
                fnVar2.d(attributeValue10);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue11 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue11)) {
                fnVar2.e(attributeValue11);
            }
        } catch (Exception unused5) {
        }
        fnVar2.a(!TextUtils.isEmpty(attributeValue) && attributeValue.equalsIgnoreCase(com.huawei.hms.ads.ex.Code));
        fnVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String strB = b(xmlPullParser);
        if (strB == null || "".equals(strB.trim())) {
            fo.q();
        } else {
            fnVar2.j(strB);
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    b(xmlPullParser);
                    fnVar2.g(m467a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue12 = xmlPullParser.getAttributeValue("", "encode");
                    String strM467a = m467a(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue12)) {
                        fnVar2.h(strM467a);
                    } else {
                        fnVar2.a(strM467a, attributeValue12);
                    }
                } else if (name.equals("thread")) {
                    if (strNextText == null) {
                        strNextText = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    fnVar2.a(m466a(xmlPullParser));
                } else {
                    fnVar2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        fnVar2.i(strNextText);
        return fnVar2;
    }

    private static String b(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || (WkParams.LANG.equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    private static void a(byte[] bArr) throws XmlPullParserException {
        if (f11585a == null) {
            try {
                XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
                f11585a = xmlPullParserNewPullParser;
                xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        f11585a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String m467a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static fq m464a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        fq.b bVarValueOf = fq.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVarValueOf = fq.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        fq fqVar = new fq(bVarValueOf);
        fqVar.m(xmlPullParser.getAttributeValue("", RemoteMessageConst.TO));
        fqVar.n(xmlPullParser.getAttributeValue("", "from"));
        fqVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        fqVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    fqVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        fqVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        fqVar.a(0);
                    }
                } else if (name.equals(bq.b.V)) {
                    String strNextText = xmlPullParser.nextText();
                    try {
                        fqVar.a(fq.a.valueOf(strNextText));
                    } catch (IllegalArgumentException unused4) {
                        System.err.println("Found invalid presence mode " + strNextText);
                    }
                } else if (name.equals("error")) {
                    fqVar.a(m466a(xmlPullParser));
                } else {
                    fqVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return fqVar;
    }

    public static fm a(XmlPullParser xmlPullParser, fa faVar) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", RemoteMessageConst.TO);
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        fm.a aVarA = fm.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap map = new HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            map.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        fm fmVar = null;
        fs fsVarM466a = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    fsVarM466a = m466a(xmlPullParser);
                } else {
                    fmVar = new fm();
                    fmVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (fmVar == null) {
            if (fm.a.f11575a != aVarA && fm.a.b != aVarA) {
                fmVar = new fm() { // from class: com.xiaomi.push.fw.2
                    @Override // com.xiaomi.push.fm
                    public String b() {
                        return null;
                    }
                };
            } else {
                fm fmVar2 = new fm() { // from class: com.xiaomi.push.fw.1
                    @Override // com.xiaomi.push.fm
                    public String b() {
                        return null;
                    }
                };
                fmVar2.k(attributeValue);
                fmVar2.m(attributeValue3);
                fmVar2.n(attributeValue2);
                fmVar2.a(fm.a.d);
                fmVar2.l(attributeValue4);
                fmVar2.a(new fs(fs.a.e));
                faVar.a(fmVar2);
                com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                return null;
            }
        }
        fmVar.k(attributeValue);
        fmVar.m(attributeValue2);
        fmVar.l(attributeValue4);
        fmVar.n(attributeValue3);
        fmVar.a(aVarA);
        fmVar.a(fsVarM466a);
        fmVar.a(map);
        return fmVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static fr m465a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        fr frVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                frVar = new fr(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return frVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static fs m466a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        String attributeValue = "-1";
        boolean z = false;
        String attributeValue2 = null;
        String attributeValue3 = null;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals("code")) {
                attributeValue = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i).equals("type")) {
                attributeValue3 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                attributeValue2 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str = null;
        String strNextText = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    strNextText = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                strNextText = xmlPullParser.getText();
            }
        }
        return new fs(Integer.parseInt(attributeValue), attributeValue3 == null ? "cancel" : attributeValue3, attributeValue2, str, strNextText, arrayList);
    }

    public static fl a(String str, String str2, XmlPullParser xmlPullParser) {
        Object objM462a = fv.a().m462a("all", "xm:chat");
        if (objM462a == null || !(objM462a instanceof com.xiaomi.push.service.i)) {
            return null;
        }
        return ((com.xiaomi.push.service.i) objM462a).b(xmlPullParser);
    }
}
