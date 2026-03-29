package com.umeng.analytics.pro;

import com.umeng.analytics.pro.da;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class cq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f10910a;
    private final ds b;
    private dg c;

    public cq() {
        this(new da.a());
    }

    public byte[] a(ch chVar) throws cn {
        this.f10910a.reset();
        chVar.write(this.c);
        return this.f10910a.toByteArray();
    }

    public String b(ch chVar) throws cn {
        return new String(a(chVar));
    }

    public cq(di diVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f10910a = byteArrayOutputStream;
        ds dsVar = new ds(byteArrayOutputStream);
        this.b = dsVar;
        this.c = diVar.a(dsVar);
    }

    public String a(ch chVar, String str) throws cn {
        try {
            return new String(a(chVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
