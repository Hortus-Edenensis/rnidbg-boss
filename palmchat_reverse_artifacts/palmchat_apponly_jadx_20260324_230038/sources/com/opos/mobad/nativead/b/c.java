package com.opos.mobad.nativead.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.ad.e.h;
import com.opos.mobad.ad.e.i;
import com.opos.mobad.ad.e.k;
import com.opos.mobad.ad.e.t;
import com.opos.mobad.ad.g;
import com.opos.mobad.ad.j;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c extends j.a implements h, com.opos.mobad.ad.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdItemData f9122a;
    private MaterialData b;
    private List<com.opos.mobad.ad.e.e> c = null;
    private List<com.opos.mobad.ad.e.e> d = null;
    private List<com.opos.mobad.ad.e.e> e = null;
    private final long f = SystemClock.elapsedRealtime();
    private com.opos.mobad.b g;
    private d h;
    private com.opos.mobad.ad.e.b i;
    private String j;
    private com.opos.mobad.cmn.func.adhandler.a k;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.opos.mobad.ad.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AppPrivacyData f9123a;

        public a(AppPrivacyData appPrivacyData) {
            this.f9123a = appPrivacyData;
        }

        @Override // com.opos.mobad.ad.e.b
        public String a() {
            AppPrivacyData appPrivacyData = this.f9123a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.d;
        }

        @Override // com.opos.mobad.ad.e.b
        public String b() {
            AppPrivacyData appPrivacyData = this.f9123a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.c;
        }

        @Override // com.opos.mobad.ad.e.b
        public String c() {
            AppPrivacyData appPrivacyData = this.f9123a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.e;
        }

        @Override // com.opos.mobad.ad.e.b
        public String d() {
            AppPrivacyData appPrivacyData = this.f9123a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.b;
        }

        @Override // com.opos.mobad.ad.e.b
        public String e() {
            AppPrivacyData appPrivacyData = this.f9123a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f9081a;
        }

        @Override // com.opos.mobad.ad.e.b
        public String f() {
            AppPrivacyData appPrivacyData = this.f9123a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f;
        }
    }

    public c(com.opos.mobad.cmn.func.adhandler.a aVar, AdItemData adItemData, com.opos.mobad.b bVar, String str, com.opos.mobad.ad.privacy.b bVar2, String str2) {
        this.k = aVar;
        this.f9122a = adItemData;
        this.g = bVar.c();
        this.b = adItemData.i().get(0);
        this.h = new d(bVar, aVar, adItemData, str, bVar2);
        if (this.f9122a.U() != null) {
            this.i = new a(this.f9122a.U());
        }
        this.j = str2;
    }

    private int r() {
        int iZ = this.b.Z();
        if (iZ == 1 || iZ == 2) {
            return 6;
        }
        if (iZ != 3 && iZ != 4 && iZ != 5) {
            if (iZ == 20 || iZ == 21) {
                return 7;
            }
            if (iZ == 30 || iZ == 31) {
                return 8;
            }
            if (iZ != 34) {
                if (iZ == 63) {
                    return 16;
                }
                if (iZ == 71) {
                    return 3;
                }
                if (iZ == 50) {
                    return 15;
                }
                if (iZ == 51) {
                    return 5;
                }
                if (iZ == 60) {
                    return 13;
                }
                if (iZ != 61) {
                    return (iZ == 80 || iZ == 81) ? 14 : 0;
                }
                return 11;
            }
        }
        return 2;
    }

    private boolean s() {
        return (com.opos.mobad.c.b.a().y() & 4) == 0;
    }

    private boolean t() {
        return (com.opos.mobad.c.b.a().y() & 8) == 0;
    }

    private boolean u() {
        return (com.opos.mobad.c.b.a().y() & 16) == 0;
    }

    @Override // com.opos.mobad.ad.e.h
    public String a() {
        return this.b.f();
    }

    @Override // com.opos.mobad.ad.e.h
    public String b() {
        return this.b.g();
    }

    @Override // com.opos.mobad.ad.e.h
    public List<com.opos.mobad.ad.e.e> c() {
        List<MaterialData> listI;
        List<MaterialFileData> listH;
        if (this.c == null && (listI = this.f9122a.i()) != null && listI.size() > 0) {
            for (MaterialData materialData : listI) {
                if (materialData != null && (listH = materialData.h()) != null && listH.size() > 0) {
                    this.c = new ArrayList();
                    for (MaterialFileData materialFileData : listH) {
                        if (materialFileData != null) {
                            this.c.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getIconFiles =");
        List<com.opos.mobad.ad.e.e> list = this.c;
        sb.append(list != null ? Integer.valueOf(list.size()) : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("NativeAdvanceData", sb.toString());
        return this.c;
    }

    @Override // com.opos.mobad.ad.e.h
    public List<com.opos.mobad.ad.e.e> d() {
        List<MaterialData> listI;
        List<MaterialFileData> listE;
        if (this.d == null && (listI = this.f9122a.i()) != null && listI.size() > 0) {
            for (MaterialData materialData : listI) {
                if (materialData != null && materialData.Z() != 60 && (listE = materialData.e()) != null && listE.size() > 0) {
                    this.d = new ArrayList();
                    for (MaterialFileData materialFileData : listE) {
                        if (materialFileData != null) {
                            this.d.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getImgFiles =");
        List<com.opos.mobad.ad.e.e> list = this.d;
        sb.append(list != null ? Integer.valueOf(list.size()) : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("NativeAdvanceData", sb.toString());
        return this.d;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int e() {
        return this.f9122a.ac();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        return this.f9122a.ad();
    }

    @Override // com.opos.mobad.ad.e.h
    public int g() {
        return r();
    }

    @Override // com.opos.mobad.ad.e.h
    public int h() {
        return (int) this.b.s();
    }

    @Override // com.opos.mobad.ad.e.h
    public com.opos.mobad.ad.e.e i() {
        MaterialFileData materialFileDataL = this.f9122a.l();
        b bVar = materialFileDataL != null ? new b(materialFileDataL) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoFile=");
        sb.append(bVar != null ? bVar : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("NativeAdvanceData", sb.toString());
        return bVar;
    }

    @Override // com.opos.mobad.ad.e.h
    public boolean j() {
        return SystemClock.elapsedRealtime() - this.f <= ((long) ((this.f9122a.r() * 60) * 1000));
    }

    @Override // com.opos.mobad.ad.e.h
    public String k() {
        return this.f9122a.p();
    }

    @Override // com.opos.mobad.ad.e.h
    public String l() {
        String strA = com.opos.mobad.cmn.func.b.h.a(this.g.b(), this.f9122a, false);
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "getClickBnText=" + strA);
        return strA;
    }

    @Override // com.opos.mobad.ad.e.h
    public void m() {
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "release");
        d dVar = this.h;
        if (dVar != null) {
            dVar.a();
            this.h = null;
        }
    }

    @Override // com.opos.mobad.ad.e.h
    public com.opos.mobad.ad.e.b n() {
        return this.i;
    }

    @Override // com.opos.mobad.ad.e.h
    public String o() {
        return this.j;
    }

    @Override // com.opos.mobad.ad.e.h
    public int p() {
        return this.f9122a.F();
    }

    @Override // com.opos.mobad.ad.e.h
    public List<com.opos.mobad.ad.e.e> q() {
        List<MaterialData> listI;
        List<MaterialFileData> listD;
        if (this.e == null && (listI = this.f9122a.i()) != null && listI.size() > 0) {
            for (MaterialData materialData : listI) {
                if (materialData != null && (listD = materialData.D()) != null && listD.size() > 0) {
                    this.e = new ArrayList();
                    for (MaterialFileData materialFileData : listD) {
                        if (materialFileData != null) {
                            this.e.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getVideoFiles =");
        List<com.opos.mobad.ad.e.e> list = this.e;
        sb.append(list != null ? Integer.valueOf(list.size()) : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("NativeAdvanceData", sb.toString());
        return this.e;
    }

    @Override // com.opos.mobad.ad.f
    public void setDlClickListener(g gVar) {
        com.opos.mobad.cmn.func.adhandler.a aVar = this.k;
        if (aVar != null) {
            aVar.a(gVar);
        }
    }

    @Override // com.opos.mobad.ad.e.h
    public void a(Context context, FrameLayout frameLayout, k kVar) {
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "bindMediaView nativeMediaView: " + frameLayout + ",listener: " + kVar);
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(frameLayout, kVar);
        }
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(i);
        }
    }

    @Override // com.opos.mobad.ad.e.h
    public void a(Context context, FrameLayout frameLayout, t tVar, List<View> list, List<View> list2) {
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(context, frameLayout, tVar, list, list2, s(), t(), u());
        }
    }

    @Override // com.opos.mobad.ad.e.h
    public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2) {
        d dVar = this.h;
        if (dVar == null) {
            return;
        }
        dVar.a(context, list, aVar, list2, aVar2);
    }

    @Override // com.opos.mobad.ad.e.h
    public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2, List<View> list3, h.a aVar3) {
        d dVar = this.h;
        if (dVar == null) {
            return;
        }
        dVar.a(context, list, aVar, list2, aVar2, list3, aVar3);
    }

    @Override // com.opos.mobad.ad.e.h
    public void a(i iVar) {
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(iVar);
        }
    }

    @Override // com.opos.mobad.ad.e.h
    public boolean a(String str) {
        str.hashCode();
        switch (str) {
            case "nativePrivacyComponent":
                return !t();
            case "nativeAdButton":
                return !s();
            case "nativeCloseBtn":
                return !u();
            default:
                return true;
        }
    }
}
