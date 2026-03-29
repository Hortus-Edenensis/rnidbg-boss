package com.opos.cmn.func.dl.base.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.File;
import java.io.InputStream;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    private static final String c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f7958a;
    Context b;

    /* JADX INFO: renamed from: com.opos.cmn.func.dl.base.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0668a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7959a;
        String b;
        String c;
        long d;
        boolean e;
        boolean f = false;
    }

    public a(b bVar) {
        this.f7958a = bVar;
        this.b = bVar.f7965a;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0668a a() {
        C0668a c0668a = new C0668a();
        String str = this.f7958a.h;
        c0668a.c = str;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(this.f7958a.g, c0668a.c);
            boolean z = com.opos.cmn.an.e.b.a.a(file) && com.opos.cmn.func.dl.base.i.a.a(this.f7958a.d, file) && !this.f7958a.q.h;
            c0668a.f = z;
            if (z) {
                c0668a.d = com.opos.cmn.an.e.b.a.g(file);
            }
        }
        if (!c0668a.f) {
            com.opos.cmn.func.dl.base.c.a aVar = new com.opos.cmn.func.dl.base.c.a(this.f7958a.r);
            try {
                try {
                    try {
                        Context contextE = this.f7958a.p.e();
                        b bVar = this.f7958a;
                        InputStream inputStreamA = aVar.a(contextE, bVar.e, new com.opos.cmn.func.dl.base.c.b(bVar.q.j));
                        int iD = aVar.d();
                        if (inputStreamA == null) {
                            if (com.opos.cmn.an.h.c.a.d(this.b)) {
                                throw new DlException(1001, iD, aVar.b());
                            }
                            throw new DlException(1003, iD);
                        }
                        String strA = aVar.a("Content-Type");
                        if (!TextUtils.isEmpty(strA)) {
                            String[] strArrSplit = strA.split(x.aQ);
                            String str2 = strArrSplit.length > 0 ? strArrSplit[0] : "";
                            if (!TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("text/html")) {
                                throw new DlException(1014);
                            }
                            c0668a.d = aVar.e();
                            c0668a.e = aVar.d() == 206 ? true : "bytes".equals(aVar.a(HttpHeaders.ACCEPT_RANGES));
                            c0668a.f7959a = aVar.f7974a.a();
                            c0668a.b = str2;
                            String strC = this.f7958a.h;
                            if (TextUtils.isEmpty(strC)) {
                                strC = com.opos.cmn.func.dl.base.i.a.c(aVar.a(MIME.CONTENT_DISPOSITION));
                            }
                            c0668a.c = strC;
                            aVar.c();
                            if (TextUtils.isEmpty(c0668a.c)) {
                                c0668a.c = com.opos.cmn.func.dl.base.i.a.d(TextUtils.isEmpty(c0668a.f7959a) ? this.f7958a.e : c0668a.f7959a);
                            }
                            File file2 = new File(this.f7958a.g, c0668a.c);
                            c0668a.f = com.opos.cmn.an.e.b.a.a(file2) && com.opos.cmn.func.dl.base.i.a.a(c0668a.d, file2) && com.opos.cmn.func.dl.base.i.a.a(this.f7958a.d, file2) && !this.f7958a.q.h;
                        }
                    } catch (DlException e) {
                        com.opos.cmn.an.f.a.c(c, " check failed1!url:" + this.f7958a.e + ",error msg:" + e.toString());
                        throw e;
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c(c, " check failed2!url:" + this.f7958a.e + ",error msg:" + e2.getMessage());
                    throw new DlException(1001, e2);
                }
            } catch (Throwable th) {
                aVar.c();
                throw th;
            }
        }
        b bVar2 = this.f7958a;
        String str3 = c0668a.c;
        bVar2.h = str3;
        bVar2.q.c = str3;
        bVar2.k = c0668a.d;
        bVar2.m = c0668a.e;
        bVar2.f = c0668a.f7959a;
        if (c0668a.f) {
            File fileA = bVar2.a();
            long length = c0668a.d;
            if (length <= 0) {
                length = fileA.length();
            }
            this.f7958a.a(length);
            this.f7958a.l = length;
        }
        return c0668a;
    }

    public final void a(boolean z) throws DlException {
        b bVar = this.f7958a;
        boolean z2 = true;
        if (z) {
            bVar.n = true;
        }
        if (!z && !bVar.n && !bVar.q.i) {
            z2 = false;
        }
        if (!z2 && com.opos.cmn.an.h.c.a.c(this.b)) {
            throw new DlException(1013);
        }
    }
}
