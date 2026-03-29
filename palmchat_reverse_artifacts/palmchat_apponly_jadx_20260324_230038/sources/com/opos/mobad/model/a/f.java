package com.opos.mobad.model.a;

import android.content.Context;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.opos.mobad.b.a.aa;
import com.opos.mobad.b.a.ad;
import com.opos.mobad.b.a.ae;
import com.opos.mobad.b.a.af;
import com.opos.mobad.b.a.ag;
import com.opos.mobad.b.a.ah;
import com.opos.mobad.b.a.al;
import com.opos.mobad.b.a.am;
import com.opos.mobad.b.a.c;
import com.opos.mobad.b.a.n;
import com.opos.mobad.b.a.s;
import com.opos.mobad.b.a.x;
import com.tencent.mm.opensdk.constants.Build;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f implements com.opos.mobad.model.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<com.opos.mobad.b.a.f> f9046a;
    private Context b;

    public f(Context context) {
        if (context == null) {
            return;
        }
        this.b = context.getApplicationContext();
        com.opos.cmn.an.i.e.a(new Runnable() { // from class: com.opos.mobad.model.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                fVar.f9046a = fVar.a(fVar.b);
            }
        });
    }

    private ah b(int i) {
        return i == 3 ? ah.SPLASH : i == 6 ? ah.HOT_SPLASH : ah.UNKNOWN;
    }

    private al c() {
        try {
            return new al(Integer.valueOf(Build.SDK_INT), Integer.valueOf(com.opos.mobad.cmn.func.b.i.b(this.b)));
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("FetchAdProtocolParser", "getWxInfo:", th);
            return null;
        }
    }

    private ad.b a(int i) {
        ad.b bVar = ad.b.UNKNOWN;
        switch (i) {
            case 1:
                return ad.b.BANNER;
            case 2:
                return ad.b.POP_WINDOW;
            case 3:
            case 6:
                return ad.b.SPLASH_SCREEN;
            case 4:
                return ad.b.RAW;
            case 5:
                return ad.b.REWARD_VIDEO;
            default:
                return bVar;
        }
    }

    private n b() {
        try {
            return com.opos.mobad.service.f.a.a(this.b);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("FetchAdProtocolParser", "getDevInfo:", th);
            return null;
        }
    }

    private s a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new s(str);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("FetchAdProtocolParser", "getExtInfo", th);
            return null;
        }
    }

    @Override // com.opos.mobad.model.b.c
    public com.opos.mobad.model.c.d a(byte[] bArr) throws IOException {
        com.opos.mobad.b.a.d dVarA = com.opos.mobad.b.a.d.c.a(bArr);
        if (dVarA == null) {
            return null;
        }
        com.opos.cmn.an.f.a.a("FetchAdProtocolParser", "parseResponse = ", dVarA);
        return new com.opos.mobad.model.c.d(dVarA);
    }

    private String a(com.opos.mobad.model.c.c cVar) {
        return "26" + (cVar.e() == 5 ? ",30" : "");
    }

    private List<com.opos.mobad.b.a.f> a() {
        List<com.opos.mobad.b.a.f> list = this.f9046a;
        if (list == null || list.size() <= 0) {
            this.f9046a = a(this.b);
        }
        return this.f9046a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.opos.mobad.b.a.f> a(Context context) {
        String strA;
        ArrayList arrayList = null;
        if (context == null) {
            return null;
        }
        Signature[] signatureArrA = com.opos.cmn.i.l.a(context);
        if (signatureArrA != null && signatureArrA.length > 0) {
            arrayList = new ArrayList(signatureArrA.length);
            for (Signature signature : signatureArrA) {
                try {
                    strA = com.opos.cmn.i.l.a("sha1", signature);
                } catch (Exception unused) {
                    strA = "";
                }
                com.opos.cmn.an.f.a.a("FetchAdProtocolParser", "getApkSignerList() md5Sign=", "", "sha1Sign=", strA, "sha256Sign=", "");
                arrayList.add(new com.opos.mobad.b.a.f("", strA, ""));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00ed  */
    @Override // com.opos.mobad.model.b.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] a(com.opos.mobad.b bVar, com.opos.mobad.model.c.c cVar) {
        ag agVar;
        List<com.opos.mobad.b.a.f> listA;
        com.opos.cmn.an.f.a.b("FetchAdProtocolParser", "parseRequest() start");
        com.opos.mobad.b.a.h hVarA = com.opos.mobad.service.f.a.a(bVar.b(), bVar.d(), bVar.e(), bVar.f());
        af afVarE = com.opos.mobad.service.f.a.e();
        ad adVarB = new ad.a().a(cVar.d()).a(a(cVar.e())).a(new ae.a().a(Integer.valueOf(cVar.f())).b(Integer.valueOf(cVar.g())).b()).a(b(cVar.e())).a(Integer.valueOf(cVar.h())).b();
        n nVarB = b().c().a(Integer.valueOf(cVar.n())).b(Integer.valueOf(cVar.o())).c(Integer.valueOf(cVar.p())).b();
        aa aaVarB = com.opos.mobad.service.f.a.b(this.b);
        x xVarA = com.opos.mobad.service.f.a.a();
        am amVarB = com.opos.mobad.service.f.a.b();
        c.a aVar = new c.a();
        if (cVar.b() != 1) {
            if (cVar.b() == 2) {
                agVar = ag.MODE_TWO;
            }
            listA = a();
            if (listA != null && listA.size() > 0) {
                aVar.a(listA);
            }
            aVar.a(c.EnumC0719c.SDK);
            if (cVar.l() != null) {
                aVar.b(cVar.l());
            }
            com.opos.mobad.b.a.c cVarB = aVar.a(Integer.valueOf(cVar.c())).a(hVarA).a(afVarE).a(adVarB).a(nVarB).a(com.opos.mobad.service.d.d.a().p()).a(aaVarB).a(com.opos.mobad.service.f.a.c()).a(xVarA).a(amVarB).a(Boolean.valueOf(com.opos.mobad.service.c.a.a().l())).b(cVar.a()).b(Boolean.valueOf(com.opos.mobad.service.c.a.a().f())).c(com.opos.mobad.service.d.d.a().s()).a(Long.valueOf(bVar.n().d())).d(cVar.i()).e(bVar.a()).g(cVar.k()).f(cVar.j()).b(Long.valueOf(com.opos.mobad.service.d.b.a().f())).a(c()).h(a(cVar)).c(Boolean.valueOf(cVar.m())).a(a(bVar.g().g())).b();
            com.opos.cmn.an.f.a.a("FetchAdProtocolParser", "FetchAdRequest = ", cVarB);
            return com.opos.mobad.b.a.c.c.b(cVarB);
        }
        agVar = ag.MODE_ONE;
        aVar.a(agVar);
        listA = a();
        if (listA != null) {
            aVar.a(listA);
        }
        aVar.a(c.EnumC0719c.SDK);
        if (cVar.l() != null) {
        }
        com.opos.mobad.b.a.c cVarB2 = aVar.a(Integer.valueOf(cVar.c())).a(hVarA).a(afVarE).a(adVarB).a(nVarB).a(com.opos.mobad.service.d.d.a().p()).a(aaVarB).a(com.opos.mobad.service.f.a.c()).a(xVarA).a(amVarB).a(Boolean.valueOf(com.opos.mobad.service.c.a.a().l())).b(cVar.a()).b(Boolean.valueOf(com.opos.mobad.service.c.a.a().f())).c(com.opos.mobad.service.d.d.a().s()).a(Long.valueOf(bVar.n().d())).d(cVar.i()).e(bVar.a()).g(cVar.k()).f(cVar.j()).b(Long.valueOf(com.opos.mobad.service.d.b.a().f())).a(c()).h(a(cVar)).c(Boolean.valueOf(cVar.m())).a(a(bVar.g().g())).b();
        com.opos.cmn.an.f.a.a("FetchAdProtocolParser", "FetchAdRequest = ", cVarB2);
        return com.opos.mobad.b.a.c.c.b(cVarB2);
    }
}
