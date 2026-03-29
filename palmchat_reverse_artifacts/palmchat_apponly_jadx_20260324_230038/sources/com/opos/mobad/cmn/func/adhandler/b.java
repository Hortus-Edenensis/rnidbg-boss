package com.opos.mobad.cmn.func.adhandler;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import com.opos.cmn.i.l;
import com.opos.mobad.cmn.func.a;
import com.opos.mobad.cmn.func.adhandler.a.b;
import com.opos.mobad.cmn.func.adhandler.a.d;
import com.opos.mobad.cmn.func.adhandler.a.h;
import com.opos.mobad.cmn.func.adhandler.a.i;
import com.opos.mobad.cmn.func.adhandler.a.j;
import com.opos.mobad.cmn.func.adhandler.a.k;
import com.opos.mobad.cmn.func.adhandler.a.m;
import com.opos.mobad.cmn.func.adhandler.f;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.model.data.ApkSignerData;
import com.opos.mobad.p.a;
import com.opos.mobad.service.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f8659a;
    private String b;
    private com.opos.mobad.cmn.func.a c;
    private com.opos.mobad.cmn.func.adhandler.f d;
    private com.opos.mobad.ad.g e;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i, int i2, String str, String str2);

        void a(int i, int i2, String str, String str2, String str3);

        void b(int i, int i2, String str, String str2);
    }

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.adhandler.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0726b {
        void a(c cVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8668a;
        public final int b;
        public int c;

        public c(int i, int i2) {
            this.b = i2;
            this.f8668a = i;
        }

        public c a(int i) {
            this.c = i;
            return this;
        }

        public String toString() {
            return "Result{resultType=" + this.f8668a + ", resultCode=" + this.b + '}';
        }

        public boolean a() {
            return this.b == 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(e eVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.opos.mobad.cmn.func.adhandler.d f8669a;
        public c b;
        public c c;
        private List<c> d = new ArrayList();

        public e a(c cVar) {
            this.b = cVar;
            this.c = cVar;
            return this;
        }

        public e b(c cVar) {
            this.d.add(cVar);
            this.c = cVar;
            return this;
        }

        public boolean c() {
            return a() || b();
        }

        public String toString() {
            return "ResultObject{, targetResult=" + this.b + ", lastResult=" + this.c + ", mBaseResult=" + this.d + '}';
        }

        public e a(com.opos.mobad.cmn.func.adhandler.d dVar) {
            this.f8669a = dVar;
            return this;
        }

        public boolean b() {
            c cVar = this.c;
            return cVar != null && cVar.a();
        }

        public boolean a() {
            c cVar = this.b;
            return cVar != null && cVar.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8670a;
        private String b;
        private String c;
        private Signature d;

        public f(Signature signature) {
            this.d = signature;
        }

        public String a() {
            if (!TextUtils.isEmpty(this.f8670a)) {
                return this.f8670a;
            }
            try {
                this.f8670a = l.a("md5", this.d);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("AdHandlerCombination", "", e);
            }
            return this.f8670a;
        }

        public String b() {
            if (!TextUtils.isEmpty(this.b)) {
                return this.b;
            }
            try {
                this.b = l.a("sha1", this.d);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("AdHandlerCombination", "", e);
            }
            return this.b;
        }

        public String c() {
            if (!TextUtils.isEmpty(this.c)) {
                return this.c;
            }
            try {
                this.c = l.a("sha256", this.d);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("AdHandlerCombination", "", e);
            }
            return this.c;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends a.AbstractBinderC0760a {
        private com.opos.mobad.p.a b;

        public g(com.opos.mobad.p.a aVar) {
            this.b = aVar;
        }

        @Override // com.opos.mobad.p.a
        public void a() throws RemoteException {
            com.opos.mobad.p.a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.opos.mobad.p.a
        public void a(com.opos.mobad.p.b bVar) throws RemoteException {
            com.opos.mobad.p.a aVar = this.b;
            if (aVar != null) {
                aVar.a(bVar);
            }
        }

        @Override // com.opos.mobad.p.a
        public void a(final Map map) throws RemoteException {
            com.opos.cmn.an.f.a.a("AdHandlerCombination", "web onDlClick=" + map + ",mDlClickListener=" + b.this.e);
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.cmn.func.adhandler.b.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.e != null) {
                        b.this.e.a(map);
                    }
                }
            });
        }
    }

    public b(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.cmn.func.adhandler.f fVar) {
        this.f8659a = bVar;
        if (bVar != null) {
            this.f8659a = bVar.c();
        }
        this.b = str;
        this.c = aVar;
        this.d = fVar;
    }

    private int a(ApkSignerData apkSignerData, List<f> list) {
        if (TextUtils.isEmpty(apkSignerData.f9079a) && TextUtils.isEmpty(apkSignerData.b) && TextUtils.isEmpty(apkSignerData.c)) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            f fVar = list.get(i);
            if ((TextUtils.isEmpty(apkSignerData.f9079a) || apkSignerData.f9079a.equals(fVar.a())) && ((TextUtils.isEmpty(apkSignerData.b) || apkSignerData.b.equals(fVar.b())) && (TextUtils.isEmpty(apkSignerData.c) || apkSignerData.c.equals(fVar.c())))) {
                return i;
            }
        }
        return -1;
    }

    private PackageManager b() {
        Context contextA = a();
        if (contextA != null) {
            return contextA.getPackageManager();
        }
        return null;
    }

    private void c(com.opos.mobad.cmn.func.adhandler.d dVar) {
        if (dVar == null) {
            return;
        }
        com.opos.mobad.cmn.func.adhandler.a.a aVar = (com.opos.mobad.cmn.func.adhandler.a.a) dVar.f;
        if (aVar == null || !aVar.a()) {
            a(dVar, 16, 2, dVar.d);
        } else if (a(dVar, aVar, dVar.d)) {
            a(dVar, aVar.b, aVar.f8647a, dVar.d);
        }
    }

    private void d(com.opos.mobad.cmn.func.adhandler.d dVar) {
        if (dVar == null) {
            return;
        }
        com.opos.mobad.cmn.func.adhandler.a.g gVar = (com.opos.mobad.cmn.func.adhandler.a.g) dVar.f;
        if (gVar == null || !gVar.a()) {
            a(dVar, 15, -1, dVar.d);
            return;
        }
        String str = gVar.f8652a;
        try {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "loadWebPage url=" + str);
            String strA = -1 != com.opos.mobad.cmn.func.b.g.c(str) ? com.opos.mobad.cmn.func.b.g.a(gVar.b, gVar.c, str, this.b) : "";
            String strA2 = com.opos.mobad.cmn.func.b.g.a(a(), str, (int[]) null, 0L);
            c.b bVar = dVar.c;
            if (bVar != null) {
                com.opos.mobad.cmn.func.b.g.a(bVar);
            }
            this.c.a(this.f8659a, this.b, strA2, dVar.b(), strA, gVar.d);
            a(dVar, 15, 1, dVar.d);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e2);
            a(dVar, 15, -2, dVar.d);
        }
    }

    private void e(com.opos.mobad.cmn.func.adhandler.d dVar) {
        int i;
        if (dVar == null) {
            return;
        }
        k kVar = (k) dVar.f;
        if (kVar == null || !kVar.a()) {
            i = -1;
        } else {
            this.c.a(a(), kVar.f8656a, kVar.b, kVar.c, kVar.d);
            i = 1;
        }
        a(dVar, 14, i, dVar.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context a() {
        com.opos.mobad.b bVar = this.f8659a;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    private void c(com.opos.mobad.cmn.func.adhandler.d dVar, m mVar, InterfaceC0726b interfaceC0726b) {
        int i;
        dVar.e.a(b.EnumC0772b.BROWSER).a("1");
        String str = mVar.f8658a;
        int i2 = mVar instanceof m.b ? 12 : 2;
        if (mVar.a()) {
            String strA = com.opos.mobad.service.e.c.a(a(), str, dVar.e);
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "loadWebPageByBrowser url=" + strA);
            this.c.c(a(), strA, dVar.a());
            i = 1;
        } else {
            i = -1;
        }
        a(dVar, i2, i, interfaceC0726b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.opos.mobad.cmn.func.adhandler.d dVar) {
        com.opos.mobad.cmn.func.adhandler.a.e eVar = dVar.f;
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.a) {
            c(dVar);
            return;
        }
        if (eVar instanceof k) {
            e(dVar);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.g) {
            d(dVar);
        } else if (com.opos.mobad.cmn.func.adhandler.b.a.a(eVar)) {
            a(dVar, dVar.d);
        } else {
            a(dVar, 0, -1, dVar.d);
        }
    }

    private void b(com.opos.mobad.cmn.func.adhandler.d dVar, m mVar, InterfaceC0726b interfaceC0726b) {
        String str;
        String str2;
        String str3;
        String str4;
        String strA;
        String strA2;
        int i = mVar instanceof m.c ? 13 : 3;
        if (mVar == null || !mVar.a()) {
            a(dVar, i, -1, interfaceC0726b);
            return;
        }
        dVar.e.a(b.EnumC0772b.WEB_VIEW).a("1");
        try {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "loadWebPage url=" + mVar.f8658a);
            if (-1 != com.opos.mobad.cmn.func.b.g.c(mVar.f8658a)) {
                try {
                    strA = com.opos.mobad.cmn.func.b.g.a(mVar.b, mVar.c, mVar.f8658a, this.b);
                } catch (Exception e2) {
                    e = e2;
                    str3 = "";
                    str4 = "AdHandlerCombination";
                    com.opos.cmn.an.f.a.a(str4, str3, (Throwable) e);
                    a(dVar, i, -2, interfaceC0726b);
                }
            } else {
                strA = "";
            }
            strA2 = com.opos.mobad.service.e.c.a(a(), mVar.f8658a, dVar.e);
            c.b bVar = dVar.c;
            if (bVar != null) {
                com.opos.mobad.cmn.func.b.g.a(bVar);
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
            str2 = "AdHandlerCombination";
        }
        try {
            if (!TextUtils.isEmpty(mVar.f)) {
                str = "";
                str2 = "AdHandlerCombination";
                this.c.a(this.f8659a, this.b, strA2, dVar.f8674a, strA, mVar.f, new g(mVar.d), mVar.e, mVar.g);
            } else {
                str = "";
                str2 = "AdHandlerCombination";
                this.c.a(this.f8659a, this.b, strA2, dVar.f8674a, strA, new g(null));
            }
            a(dVar, i, 1, interfaceC0726b);
        } catch (Exception e4) {
            e = e4;
            str3 = str;
            str4 = str2;
            com.opos.cmn.an.f.a.a(str4, str3, (Throwable) e);
            a(dVar, i, -2, interfaceC0726b);
        }
    }

    public com.opos.mobad.cmn.func.adhandler.a.e a(List<com.opos.mobad.cmn.func.adhandler.a.e> list, int i) {
        if (list == null || list.size() <= 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, InterfaceC0726b interfaceC0726b) {
        if (interfaceC0726b != null) {
            c cVar = new c(i, i2);
            cVar.a(i3);
            interfaceC0726b.a(cVar);
        }
    }

    public void a(com.opos.mobad.ad.g gVar) {
        this.e = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.opos.mobad.cmn.func.adhandler.a.e eVar, final com.opos.mobad.cmn.func.adhandler.f fVar, final f.a aVar) {
        Runnable runnable;
        if ((eVar instanceof b.c) || (eVar instanceof b.C0725b) || (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.a.a) || (eVar instanceof d.a) || (eVar instanceof i) || (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.d) || (eVar instanceof b.a) || (eVar instanceof m.b) || (eVar instanceof m.a)) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "Type to request keyGuard");
            if (fVar != null && fVar.b()) {
                runnable = new Runnable() { // from class: com.opos.mobad.cmn.func.adhandler.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        fVar.a(b.this.a(), aVar);
                    }
                };
                com.opos.cmn.an.j.b.c(runnable);
                return;
            }
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "Type to default");
            if (aVar == null) {
                aVar.a();
                return;
            }
            return;
        }
        if ((eVar instanceof h) || (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.c) || (eVar instanceof j)) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "Type to request verify");
            if (fVar != null && fVar.b() && fVar.a()) {
                runnable = new Runnable() { // from class: com.opos.mobad.cmn.func.adhandler.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        fVar.b(b.this.a(), aVar);
                    }
                };
                com.opos.cmn.an.j.b.c(runnable);
                return;
            }
        }
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "Type to default");
        if (aVar == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, d dVar) {
        if (dVar != null) {
            dVar.a(eVar);
        }
    }

    public void a(final com.opos.mobad.cmn.func.adhandler.d dVar) {
        if (dVar == null) {
            return;
        }
        com.opos.mobad.cmn.func.adhandler.f fVar = this.d;
        if (fVar != null && fVar.b()) {
            a(dVar.f, fVar, new f.a() { // from class: com.opos.mobad.cmn.func.adhandler.b.1
                @Override // com.opos.mobad.cmn.func.adhandler.f.a
                public void a() {
                    com.opos.cmn.an.f.a.b("AdHandlerCombination", "execute keyguard success");
                    b.this.b(dVar);
                }

                @Override // com.opos.mobad.cmn.func.adhandler.f.a
                public void b() {
                    com.opos.cmn.an.f.a.b("AdHandlerCombination", "execute keyguard fail");
                    b bVar = b.this;
                    com.opos.mobad.cmn.func.adhandler.d dVar2 = dVar;
                    bVar.a(dVar2, dVar2.f.b(), -4, dVar.d);
                }
            });
        } else {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "execute without lock Handler");
            b(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.cmn.func.adhandler.d dVar, int i, int i2, InterfaceC0726b interfaceC0726b) {
        if (interfaceC0726b != null) {
            interfaceC0726b.a(new c(i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.cmn.func.adhandler.d dVar, int i, int i2, d dVar2) {
        if (dVar2 != null) {
            dVar2.a(new e().a(dVar).a(new c(i, i2)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038 A[Catch: Exception -> 0x003f, TRY_LEAVE, TryCatch #0 {Exception -> 0x003f, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x001d, B:9:0x0034, B:10:0x0038), top: B:15:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, b.c cVar, InterfaceC0726b interfaceC0726b) {
        String str;
        if (cVar != null) {
            try {
                if (!cVar.a() || !this.c.b(a(), cVar.f8648a, dVar.a())) {
                    a(dVar, 5, -1, interfaceC0726b);
                    str = "handleDeepLink open deeplink fail.open homepage";
                } else {
                    a(dVar, 5, 1, interfaceC0726b);
                    str = "handleDeepLink open deeplink success.extraUrl = " + cVar.f8648a;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e2);
                return;
            }
        }
        com.opos.cmn.an.f.a.b("AdHandlerCombination", str);
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.b bVar, InterfaceC0726b interfaceC0726b) {
        if (bVar != null) {
            try {
                if (!TextUtils.isEmpty(bVar.f8648a) && this.c.b(a(), bVar.f8648a, dVar.a())) {
                    com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDetailPage extraUrl=" + bVar.f8648a + " success.");
                    a(dVar, 11, 1, interfaceC0726b);
                    return;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e2);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleDetailPage extraUrl=");
        sb.append(bVar != null ? bVar.f8648a : com.igexin.push.core.b.m);
        sb.append(" fail.");
        com.opos.cmn.an.f.a.b("AdHandlerCombination", sb.toString());
        a(dVar, 11, -1, interfaceC0726b);
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, final com.opos.mobad.cmn.func.adhandler.a.c cVar, InterfaceC0726b interfaceC0726b) {
        if (cVar != null) {
            try {
                if (cVar.a()) {
                    String str = cVar.f8649a;
                    String str2 = cVar.b;
                    String str3 = cVar.d;
                    String str4 = cVar.c;
                    com.opos.mobad.b bVar = this.f8659a;
                    com.opos.mobad.cmn.service.a.a aVarL = bVar != null ? bVar.l() : null;
                    com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDownloader() pkgName=", str2, "appName=", str3, "md5=", str4, "url=", str);
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || aVarL == null) {
                        a(dVar, 7, -1, interfaceC0726b);
                        return;
                    }
                    try {
                        aVarL.a(this.f8659a.n().b(), this.f8659a.n().c());
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.c("AdHandlerCombination", "handleDownloader() fail", e2);
                    }
                    aVarL.a(str, str2, str4, str3, new com.opos.mobad.cmn.service.a.c() { // from class: com.opos.mobad.cmn.func.adhandler.b.7
                        @Override // com.opos.mobad.cmn.service.a.c
                        public void a(int i, int i2, String str5, String str6) {
                            a aVar = cVar.f;
                            if (aVar != null) {
                                aVar.a(i, i2, str5, str6);
                            }
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || obj.hashCode() != hashCode()) {
                                return super.equals(obj);
                            }
                            return true;
                        }

                        @Override // com.opos.mobad.cmn.service.a.c
                        public void f(int i, int i2, String str5, String str6) {
                            a aVar = cVar.f;
                            if (aVar != null) {
                                aVar.b(i, i2, str5, str6);
                            }
                        }

                        public int hashCode() {
                            String str5 = cVar.e;
                            return TextUtils.isEmpty(str5) ? super.hashCode() : str5.hashCode();
                        }

                        @Override // com.opos.mobad.cmn.service.a.c
                        public void a(int i, int i2, String str5, String str6, String str7) {
                            a aVar = cVar.f;
                            if (aVar != null) {
                                aVar.a(i, i2, str5, str6, str7);
                            }
                        }

                        @Override // com.opos.mobad.cmn.service.a.c
                        public void b(int i, int i2, String str5, String str6) {
                        }

                        @Override // com.opos.mobad.cmn.service.a.c
                        public void c(int i, int i2, String str5, String str6) {
                        }

                        @Override // com.opos.mobad.cmn.service.a.c
                        public void d(int i, int i2, String str5, String str6) {
                        }

                        @Override // com.opos.mobad.cmn.service.a.c
                        public void e(int i, int i2, String str5, String str6) {
                        }
                    });
                    a(dVar, 7, 1, interfaceC0726b);
                    return;
                }
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e3);
                return;
            }
        }
        a(dVar, 7, -1, interfaceC0726b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.e eVar, InterfaceC0726b interfaceC0726b) {
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handlerClickAction dataType: " + eVar.getClass().getName());
        if (eVar instanceof b.c) {
            a(dVar, (b.c) eVar, interfaceC0726b);
            return;
        }
        if (eVar instanceof b.C0725b) {
            a(dVar, (b.C0725b) eVar, interfaceC0726b);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.a.a) {
            ((com.opos.mobad.cmn.func.adhandler.a.a.a) eVar).a(this.f8659a, dVar, interfaceC0726b);
            return;
        }
        if (eVar instanceof d.a) {
            a(dVar, (d.a) eVar, interfaceC0726b);
            return;
        }
        if (eVar instanceof h) {
            a(dVar, (h) eVar, interfaceC0726b);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.c) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.c) eVar, interfaceC0726b);
            return;
        }
        if (eVar instanceof j) {
            a(dVar, (j) eVar, interfaceC0726b);
            return;
        }
        if (eVar instanceof m) {
            a(dVar, (m) eVar, interfaceC0726b);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.d) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.d) eVar, interfaceC0726b);
            return;
        }
        if (eVar instanceof b.a) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.b) eVar, interfaceC0726b);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.f) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.f) eVar, interfaceC0726b);
            return;
        }
        if (eVar instanceof i) {
            a(dVar, (i) eVar, interfaceC0726b);
        } else if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.l) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.l) eVar, interfaceC0726b);
        } else {
            a(dVar, 0, -2, interfaceC0726b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021 A[Catch: Exception -> 0x002c, TRY_LEAVE, TryCatch #0 {Exception -> 0x002c, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x0021), top: B:13:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(final com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.f fVar, final InterfaceC0726b interfaceC0726b) {
        if (fVar != null) {
            try {
                if (fVar.a()) {
                    this.c.a(a(), fVar.f8651a, fVar.b, fVar.c, new a.InterfaceC0722a() { // from class: com.opos.mobad.cmn.func.adhandler.b.6
                        @Override // com.opos.mobad.cmn.func.a.InterfaceC0722a
                        public void a() {
                            b.this.a(dVar, 6, 1, interfaceC0726b);
                            com.opos.cmn.an.f.a.a("AdHandlerCombination", "handleInstant open instant success.");
                        }

                        @Override // com.opos.mobad.cmn.func.a.InterfaceC0722a
                        public void a(int i, String str) {
                            b.this.a(6, -3, i, interfaceC0726b);
                            com.opos.cmn.an.f.a.a("AdHandlerCombination", "handleInstant open instant fail.open web, code:" + i + ",msg:" + str);
                        }
                    }, fVar.d);
                } else {
                    a(dVar, 6, -1, interfaceC0726b);
                    com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleInstant open instant fail.open web");
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e2);
            }
        }
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, h hVar, InterfaceC0726b interfaceC0726b) {
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDeeplinkDLApk posId=" + this.b);
        if (hVar == null || !hVar.a()) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDeeplinkDLApk null data");
            a(dVar, 1, -1, interfaceC0726b);
            return;
        }
        if (hVar.f8653a ? this.c.e(a(), hVar.b, dVar.a()) : this.c.d(a(), hVar.b, dVar.a())) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDeeplinkDLApk deepLinkUrl=" + hVar.b + " = true ,isSafeJump = " + hVar.f8653a);
            a(dVar, 1, 1, interfaceC0726b);
            return;
        }
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDeeplinkDLApk deepLinkUrl=" + hVar.b + " = false ,isSafeJump = " + hVar.f8653a);
        a(dVar, 1, -1, interfaceC0726b);
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, i iVar, InterfaceC0726b interfaceC0726b) {
        String str;
        if (iVar != null) {
            try {
                if (iVar.a()) {
                    if (this.c.a(a(), iVar.c, iVar.f8654a, iVar.b)) {
                        a(dVar, 8, 1, interfaceC0726b);
                        str = "handleMiniProgram open success.";
                    } else {
                        a(dVar, 8, -3, interfaceC0726b);
                        str = "handleMiniProgram open fail.open web";
                    }
                    com.opos.cmn.an.f.a.a("AdHandlerCombination", str);
                    return;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e2);
                return;
            }
        }
        a(dVar, 8, -1, interfaceC0726b);
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleMiniProgram error param instant fail.open web");
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, j jVar, InterfaceC0726b interfaceC0726b) {
        if (jVar == null || !jVar.a()) {
            com.opos.cmn.an.f.a.a("AdHandlerCombination", "handleDLApk null data");
            a(dVar, 1, -1, interfaceC0726b);
            return;
        }
        if (this.c.a(a(), jVar.f8655a, this.b, jVar.b, jVar.c, jVar.d, jVar.e, jVar.f, jVar.g)) {
            com.opos.cmn.an.f.a.a("AdHandlerCombination", "handleDLApk pkgName" + jVar.f8655a + " = true");
            a(dVar, 1, 1, interfaceC0726b);
            return;
        }
        com.opos.cmn.an.f.a.a("AdHandlerCombination", "handleDLApk pkgName=" + jVar.f8655a + " = false");
        a(dVar, 1, -2, interfaceC0726b);
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.l lVar, InterfaceC0726b interfaceC0726b) {
        String str;
        if (lVar != null) {
            try {
                if (lVar.a()) {
                    if (this.c.b(a(), lVar.f8657a, lVar.b, lVar.c)) {
                        a(dVar, 19, 1, interfaceC0726b);
                        str = "handleWeChatNativePage open success.";
                    } else {
                        a(dVar, 19, -3, interfaceC0726b);
                        str = "handleWeChatNativePage open fail.";
                    }
                    com.opos.cmn.an.f.a.a("AdHandlerCombination", str);
                    return;
                }
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "handleWeChatNativePage exception", th);
                return;
            }
        }
        a(dVar, 19, -1, interfaceC0726b);
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleWeChatNativePage error param instant fail.");
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, m mVar, InterfaceC0726b interfaceC0726b) {
        if ((mVar instanceof m.b) || (mVar instanceof m.a)) {
            c(dVar, mVar, interfaceC0726b);
        } else {
            b(dVar, mVar, interfaceC0726b);
        }
    }

    private void a(final com.opos.mobad.cmn.func.adhandler.d dVar, final d dVar2) {
        if (dVar == null) {
            return;
        }
        com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.mobad.cmn.func.adhandler.b.4
            @Override // java.lang.Runnable
            public void run() {
                final e eVar = new e();
                eVar.a(dVar);
                com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleAdClickAction adItemData=", dVar.b());
                b bVar = b.this;
                com.opos.mobad.cmn.func.adhandler.d dVar3 = dVar;
                bVar.a(dVar3, dVar3.f, new InterfaceC0726b() { // from class: com.opos.mobad.cmn.func.adhandler.b.4.1
                    @Override // com.opos.mobad.cmn.func.adhandler.b.InterfaceC0726b
                    public void a(c cVar) {
                        if (cVar != null) {
                            eVar.a(cVar);
                            if (cVar.a()) {
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                b.this.a(eVar, dVar2);
                                return;
                            }
                        }
                        AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                        b.this.a(dVar, eVar, dVar2, 0);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.opos.mobad.cmn.func.adhandler.d dVar, final e eVar, final d dVar2, final int i) {
        com.opos.mobad.cmn.func.adhandler.a.e eVarA = a(dVar.g, i);
        if (eVarA == null) {
            a(eVar, dVar2);
        } else {
            a(dVar, eVarA, new InterfaceC0726b() { // from class: com.opos.mobad.cmn.func.adhandler.b.5
                @Override // com.opos.mobad.cmn.func.adhandler.b.InterfaceC0726b
                public void a(c cVar) {
                    if (cVar != null) {
                        eVar.b(cVar);
                        if (cVar.a()) {
                            b.this.a(eVar, dVar2);
                        } else {
                            b.this.a(dVar, eVar, dVar2, i + 1);
                        }
                    }
                }
            });
        }
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, String str, String str2, d dVar2) {
        try {
            Intent intent = new Intent(str);
            intent.setPackage(str2);
            List<ResolveInfo> listQueryIntentServices = b().queryIntentServices(intent, 128);
            if (listQueryIntentServices != null && listQueryIntentServices.size() == 1) {
                intent.putExtra("from", a().getPackageName());
                a().startService(intent);
                if (dVar2 != null) {
                    a(dVar, 16, 0, dVar2);
                    return;
                }
                return;
            }
            if (dVar2 != null) {
                a(dVar, 16, 6, dVar2);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "", e2);
            if (dVar2 != null) {
                a(dVar, 16, 7, dVar2);
            }
        }
    }

    public static boolean a(int i) {
        if (i == 19 || i == 20) {
            return true;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return true;
            default:
                return false;
        }
    }

    private boolean a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.a aVar, d dVar2) {
        PackageInfo packageInfo;
        Signature[] apkContentsSigners;
        PackageManager packageManagerB = b();
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                packageInfo = packageManagerB.getPackageInfo(aVar.f8647a, 134217856);
                if (packageInfo == null) {
                    if (dVar2 != null) {
                        a(dVar, 16, 3, dVar2);
                    }
                    return false;
                }
                apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners();
            } else {
                packageInfo = packageManagerB.getPackageInfo(aVar.f8647a, 192);
                if (packageInfo == null) {
                    if (dVar2 != null) {
                        a(dVar, 16, 3, dVar2);
                    }
                    return false;
                }
                apkContentsSigners = packageInfo.signatures;
            }
            if (aVar.d > packageInfo.versionCode) {
                if (dVar2 != null) {
                    a(dVar, 16, 4, dVar2);
                }
                return false;
            }
            List<ApkSignerData> list = aVar.c;
            if (list == null || apkContentsSigners == null) {
                if (dVar2 != null) {
                    a(dVar, 16, 5, dVar2);
                }
                return false;
            }
            if (list.size() <= 0 || aVar.c.size() != apkContentsSigners.length) {
                if (dVar2 != null) {
                    a(dVar, 16, 5, dVar2);
                }
                return false;
            }
            ArrayList arrayList = new ArrayList(apkContentsSigners.length);
            for (Signature signature : apkContentsSigners) {
                arrayList.add(new f(signature));
            }
            Iterator<ApkSignerData> it = aVar.c.iterator();
            while (it.hasNext()) {
                int iA = a(it.next(), arrayList);
                if (iA < 0) {
                    if (dVar2 != null) {
                        a(dVar, 16, 5, dVar2);
                    }
                    return false;
                }
                arrayList.remove(iA);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "activation fail not install");
            if (dVar2 != null) {
                a(dVar, 16, 3, dVar2);
            }
            return false;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "activation fail", e2);
            if (dVar2 != null) {
                a(dVar, 16, 1, dVar2);
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.opos.mobad.cmn.func.adhandler.d dVar, b.C0725b c0725b, InterfaceC0726b interfaceC0726b) {
        boolean z = false;
        if (c0725b != null) {
            try {
                if (!c0725b.a() || !this.c.b(a(), c0725b.f8648a, dVar.a())) {
                    a(dVar, 9, -1, interfaceC0726b);
                    com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleForInstalledDeepLink open deeplink fail.open homepage");
                } else {
                    a(dVar, 9, 1, interfaceC0726b);
                    try {
                        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleForInstalledDeepLink open deeplink success.extraUrl = " + c0725b.f8648a);
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e);
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        return z;
    }

    private boolean a(com.opos.mobad.cmn.func.adhandler.d dVar, d.a aVar, InterfaceC0726b interfaceC0726b) {
        boolean z = false;
        if (aVar != null) {
            try {
                if (aVar.a() && this.c.a(a(), aVar.f8650a, dVar.a())) {
                    a(dVar, 10, 1, interfaceC0726b);
                    try {
                        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleHomePage pkgName=" + aVar.f8650a + " success.");
                        return true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e);
                        return z;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleHomePage pkgName=");
        sb.append(aVar != null ? aVar.f8650a : com.igexin.push.core.b.m);
        sb.append(" fail.");
        com.opos.cmn.an.f.a.b("AdHandlerCombination", sb.toString());
        a(dVar, 10, -1, interfaceC0726b);
        return false;
    }

    private boolean a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.d dVar2, InterfaceC0726b interfaceC0726b) {
        boolean z = false;
        if (dVar2 != null) {
            try {
                if (dVar2.a() && this.c.a(a(), dVar2.f8650a, dVar.a())) {
                    a(dVar, 4, 1, interfaceC0726b);
                    try {
                        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleHomePage pkgName=" + dVar2.f8650a + " success.");
                        return true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e);
                        return z;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleHomePage pkgName=");
        sb.append(dVar2 != null ? dVar2.f8650a : com.igexin.push.core.b.m);
        sb.append(" fail.");
        com.opos.cmn.an.f.a.b("AdHandlerCombination", sb.toString());
        a(dVar, 4, -1, interfaceC0726b);
        return false;
    }
}
