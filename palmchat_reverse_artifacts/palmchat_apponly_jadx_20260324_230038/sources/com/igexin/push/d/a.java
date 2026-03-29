package com.igexin.push.d;

import android.content.Context;
import com.igexin.c.a.b.g;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class a implements com.igexin.c.a.d.a.b<String, Integer, com.igexin.c.a.b.d, com.igexin.c.a.b.f> {
    private static final byte b = 1;
    private static final byte c = 2;
    private static final byte d = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7303a;

    public a(Context context) {
        this.f7303a = context;
    }

    private static byte b(com.igexin.c.a.b.f fVar) {
        String[] strArrA = g.a(fVar.b);
        if (strArrA[0].equals("socket")) {
            return (byte) 3;
        }
        return strArrA[0].equals(HttpHost.DEFAULT_SCHEME_NAME) ? (byte) 2 : (byte) 0;
    }

    @Override // com.igexin.c.a.d.a.b
    public final /* synthetic */ byte a(com.igexin.c.a.d.f fVar) {
        String[] strArrA = g.a(((com.igexin.c.a.b.f) fVar).b);
        if (strArrA[0].equals("socket")) {
            return (byte) 3;
        }
        return strArrA[0].equals(HttpHost.DEFAULT_SCHEME_NAME) ? (byte) 2 : (byte) 0;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static com.igexin.c.a.b.f a2(String str, com.igexin.c.a.b.d dVar) {
        if (str.startsWith("socket") && com.igexin.push.core.e.n) {
            return new com.igexin.c.a.b.a.a.f(str, dVar);
        }
        return null;
    }

    @Override // com.igexin.c.a.d.a.b
    public final /* synthetic */ boolean b(com.igexin.c.a.d.f fVar) {
        com.igexin.c.a.b.f fVar2 = (com.igexin.c.a.b.f) fVar;
        return fVar2.b.startsWith("socket") || fVar2.b.startsWith("submitTcpException");
    }

    @Override // com.igexin.c.a.d.a.b
    public final /* synthetic */ com.igexin.c.a.d.f a(String str, com.igexin.c.a.b.d dVar) {
        String str2 = str;
        com.igexin.c.a.b.d dVar2 = dVar;
        if (str2.startsWith("socket") && com.igexin.push.core.e.n) {
            return new com.igexin.c.a.b.a.a.f(str2, dVar2);
        }
        return null;
    }

    private static boolean a(com.igexin.c.a.b.f fVar) {
        return fVar.b.startsWith("socket") || fVar.b.startsWith("submitTcpException");
    }
}
