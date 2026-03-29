package com.opos.mobad.nativead.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.opos.mobad.ad.e.l;
import com.opos.mobad.ad.e.q;
import com.opos.mobad.cmn.func.b.h;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a implements com.opos.mobad.ad.e.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f9119a;
    private com.opos.mobad.nativead.c b;
    private AdItemData c;
    private MaterialData d;
    private List<com.opos.mobad.ad.e.e> e = null;
    private List<com.opos.mobad.ad.e.e> f = null;
    private long g = SystemClock.elapsedRealtime();
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private l k;

    /* JADX INFO: renamed from: com.opos.mobad.nativead.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0757a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AppPrivacyData f9120a;

        public C0757a(AppPrivacyData appPrivacyData) {
            this.f9120a = appPrivacyData;
        }

        @Override // com.opos.mobad.ad.e.b
        public String a() {
            AppPrivacyData appPrivacyData = this.f9120a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.d;
        }

        @Override // com.opos.mobad.ad.e.b
        public String b() {
            AppPrivacyData appPrivacyData = this.f9120a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.c;
        }

        @Override // com.opos.mobad.ad.e.b
        public String c() {
            AppPrivacyData appPrivacyData = this.f9120a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.e;
        }

        @Override // com.opos.mobad.ad.e.l, com.opos.mobad.ad.e.b
        public String d() {
            AppPrivacyData appPrivacyData = this.f9120a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.b;
        }

        @Override // com.opos.mobad.ad.e.l, com.opos.mobad.ad.e.b
        public String e() {
            AppPrivacyData appPrivacyData = this.f9120a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f9081a;
        }

        @Override // com.opos.mobad.ad.e.l, com.opos.mobad.ad.e.b
        public String f() {
            AppPrivacyData appPrivacyData = this.f9120a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f;
        }
    }

    public a(Context context, com.opos.mobad.nativead.c cVar, AdItemData adItemData) {
        this.f9119a = context;
        this.b = cVar;
        this.c = adItemData;
        this.d = adItemData.i().get(0);
        if (this.c.U() != null) {
            this.k = new C0757a(this.c.U());
        }
    }

    private int m() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "mReqAdTime=" + this.g + ",mHasAdShow=" + this.h + ",nowTime=" + jElapsedRealtime + ",getShowInterval=" + this.c.r());
        int i = this.h ? 10200 : jElapsedRealtime - this.g > ((long) ((this.c.r() * 60) * 1000)) ? 10201 : 0;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getAdShowStatus =" + i);
        return i;
    }

    private int n() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "mReqAdTime=" + this.g + ",mHasAdShow=" + this.h + ",mHasAdClick=" + this.i + ",nowTime=" + jElapsedRealtime + ",getClickInterval=" + this.c.s());
        int i = !this.h ? 10202 : this.i ? 10203 : jElapsedRealtime - this.g > ((long) ((this.c.s() * 60) * 1000)) ? 10204 : 0;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getAdClickStatus =" + i);
        return i;
    }

    @Override // com.opos.mobad.ad.e.d
    public String a() {
        return this.d.f();
    }

    @Override // com.opos.mobad.ad.e.d
    public String b() {
        return this.d.g();
    }

    @Override // com.opos.mobad.ad.e.d
    public List<com.opos.mobad.ad.e.e> c() {
        List<MaterialData> listI;
        List<MaterialFileData> listH;
        if (this.e == null && (listI = this.c.i()) != null && listI.size() > 0) {
            for (MaterialData materialData : listI) {
                if (materialData != null && (listH = materialData.h()) != null && listH.size() > 0) {
                    this.e = new ArrayList();
                    for (MaterialFileData materialFileData : listH) {
                        if (materialFileData != null) {
                            this.e.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getIconFiles =");
        List<com.opos.mobad.ad.e.e> list = this.e;
        sb.append(list != null ? Integer.valueOf(list.size()) : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.toString());
        return this.e;
    }

    @Override // com.opos.mobad.ad.e.d
    public List<com.opos.mobad.ad.e.e> d() {
        List<MaterialData> listI;
        List<MaterialFileData> listE;
        if (this.f == null && (listI = this.c.i()) != null && listI.size() > 0) {
            for (MaterialData materialData : listI) {
                if (materialData != null && (listE = materialData.e()) != null && listE.size() > 0) {
                    this.f = new ArrayList();
                    for (MaterialFileData materialFileData : listE) {
                        if (materialFileData != null) {
                            this.f.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getImgFiles =");
        List<com.opos.mobad.ad.e.e> list = this.f;
        sb.append(list != null ? Integer.valueOf(list.size()) : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.toString());
        return this.f;
    }

    @Override // com.opos.mobad.ad.e.d
    public int e() {
        int iZ = this.d.Z();
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
                if (iZ == 51) {
                    return 5;
                }
                if (iZ == 61) {
                    return 11;
                }
                if (iZ != 63) {
                    return iZ != 71 ? 0 : 3;
                }
                return 4;
            }
        }
        return 2;
    }

    @Override // com.opos.mobad.ad.e.d
    public int f() {
        return this.d.d();
    }

    @Override // com.opos.mobad.ad.e.d
    public com.opos.mobad.ad.e.e g() {
        MaterialFileData materialFileDataL = this.c.l();
        b bVar = materialFileDataL != null ? new b(materialFileDataL) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoFile=");
        sb.append(bVar != null ? bVar : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.toString());
        return bVar;
    }

    @Override // com.opos.mobad.ad.e.d
    public boolean h() {
        boolean z = m() == 0;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "isAdValid=" + z);
        return z;
    }

    @Override // com.opos.mobad.ad.e.d
    public String i() {
        return this.c.p();
    }

    @Override // com.opos.mobad.ad.e.d
    public String j() {
        String strA = h.a(this.f9119a, this.c, false);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getClickBnText=" + strA);
        return strA;
    }

    @Override // com.opos.mobad.ad.e.d
    public boolean k() {
        MaterialData materialData;
        boolean zA = false;
        if (!this.b.d()) {
            try {
                AdItemData adItemData = this.c;
                if (adItemData != null && (materialData = this.d) != null) {
                    zA = this.b.a(adItemData, materialData);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("NativeAdDataImpl", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "launchApp=" + zA);
        return zA;
    }

    @Override // com.opos.mobad.ad.e.d
    public l l() {
        return this.k;
    }

    private String a(int i) {
        switch (i) {
            case 10200:
                return "ad repeat exposure.";
            case 10201:
                return "ad exposure expired.";
            case 10202:
                return "ad hasn't exposed.";
            case 10203:
                return "ad repeat click.";
            case 10204:
                return "ad click expired.";
            default:
                return "";
        }
    }

    @Override // com.opos.mobad.ad.e.d
    public synchronized void b(View view) {
        if (!this.b.d()) {
            int iN = n();
            if (iN == 0) {
                this.i = true;
                this.b.a(this.c, true, null, com.opos.mobad.cmn.func.b.a.CLICK_BT, view, this.j);
            } else {
                this.b.a(this.c, false, null, com.opos.mobad.cmn.func.b.a.CLICK_BT, view, this.j);
                this.b.b().onAdError(new q(iN, a(iN)), this);
            }
            if (!this.j) {
                this.j = true;
            }
        }
    }

    @Override // com.opos.mobad.ad.e.d
    public synchronized void a(View view) {
        if (!this.b.d()) {
            int iM = m();
            if (iM == 0) {
                this.b.b(this.c);
                this.b.a(view, this.c, true, (Map<String, String>) null);
                this.h = true;
            } else {
                this.b.a(view, this.c, false, (Map<String, String>) null);
                this.b.b().onAdError(new q(iM, a(iM)), this);
            }
            this.b.a(this.c);
        }
    }

    @Override // com.opos.mobad.ad.e.d
    public boolean a(String str) {
        Exception e;
        boolean zEquals;
        MaterialData materialData;
        boolean z = false;
        if (!this.b.d()) {
            try {
            } catch (Exception e2) {
                e = e2;
                zEquals = false;
            }
            if (!com.opos.cmn.an.d.b.a(str) && this.c != null && (materialData = this.d) != null) {
                zEquals = str.equals(materialData.i());
                try {
                    com.opos.cmn.an.f.a.b("NativeAdDataImpl", "isCurrentApp downloadPkgName=" + this.d.i());
                } catch (Exception e3) {
                    e = e3;
                    com.opos.cmn.an.f.a.a("NativeAdDataImpl", "", (Throwable) e);
                }
                z = zEquals;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("isCurrentApp pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.toString());
        return z;
    }
}
