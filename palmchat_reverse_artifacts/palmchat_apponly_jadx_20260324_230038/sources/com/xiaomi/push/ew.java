package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private XmlPullParser f11557a;

    public ew() {
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f11557a = xmlPullParserNewPullParser;
            xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public fo a(byte[] bArr, fa faVar) throws XmlPullParserException, fi, IOException {
        this.f11557a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f11557a.next();
        int eventType = this.f11557a.getEventType();
        String name = this.f11557a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name.equals("message")) {
            return fw.a(this.f11557a);
        }
        if (name.equals("iq")) {
            return fw.a(this.f11557a, faVar);
        }
        if (name.equals("presence")) {
            return fw.m464a(this.f11557a);
        }
        if (this.f11557a.getName().equals("stream")) {
            return null;
        }
        if (this.f11557a.getName().equals("error")) {
            throw new fi(fw.m465a(this.f11557a));
        }
        if (!this.f11557a.getName().equals("warning")) {
            this.f11557a.getName().equals("bind");
            return null;
        }
        this.f11557a.next();
        this.f11557a.getName().equals("multi-login");
        return null;
    }
}
