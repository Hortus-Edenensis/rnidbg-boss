package com.opos.mobad.cmn.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.RemoteException;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.ad.privacy.b;
import com.opos.mobad.p.a;
import com.opos.mobad.ui.b.e;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d implements com.opos.mobad.ad.privacy.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f8627a;
    private com.opos.mobad.p.b b;
    private Dialog c;
    private b.a d;
    private boolean e = false;
    private a.AbstractBinderC0760a f = new a.AbstractBinderC0760a() { // from class: com.opos.mobad.cmn.a.d.2
        @Override // com.opos.mobad.p.a
        public void a() {
            com.opos.cmn.an.f.a.b("PrivacyShowManager", "onActivityOnDestory");
            d.this.b = null;
            if (d.this.d != null) {
                d.this.d.a();
            }
        }

        @Override // com.opos.mobad.p.a
        public void a(com.opos.mobad.p.b bVar) {
            d.this.b = bVar;
        }

        @Override // com.opos.mobad.p.a
        public void a(Map map) throws RemoteException {
        }
    };

    public d(b bVar) {
        this.f8627a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Dialog dialog = this.c;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.opos.mobad.p.b bVar = this.b;
        if (bVar != null) {
            try {
                bVar.a();
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.b("PrivacyShowManager", "close fail");
            }
            this.b = null;
        }
    }

    private void b(Context context, int i, ComplianceInfo complianceInfo, b.a aVar) {
        com.opos.cmn.an.f.a.a("PrivacyShowManager", "showAsProxyContentView " + complianceInfo);
        if (this.f8627a == null) {
            com.opos.cmn.an.f.a.a("PrivacyShowManager", "null video player");
            return;
        }
        this.d = aVar;
        c();
        this.b = null;
        if (i == 1) {
            this.f8627a.b(context, complianceInfo, this.f);
        } else if (i == 0) {
            this.f8627a.a(context, complianceInfo, this.f);
        } else {
            this.f8627a.c(context, complianceInfo, this.f);
        }
    }

    private String a(Context context, int i) {
        Resources resources;
        int i2;
        if (context == null) {
            return "";
        }
        if (i == 0) {
            resources = context.getResources();
            i2 = R.string.opos_mob_privacy_title;
        } else if (i == 1) {
            resources = context.getResources();
            i2 = R.string.opos_mob_permission_title;
        } else {
            if (i != 2) {
                return "";
            }
            resources = context.getResources();
            i2 = R.string.opos_mob_app_desc_title;
        }
        return resources.getString(i2);
    }

    private String a(ComplianceInfo complianceInfo, int i) {
        return i != 0 ? i != 1 ? i != 2 ? "" : complianceInfo.c() : complianceInfo.b() : complianceInfo.a();
    }

    @Override // com.opos.mobad.ad.privacy.b
    public void a() {
        this.e = true;
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.cmn.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.f8627a = null;
                d.this.b();
                d.this.c();
            }
        });
    }

    private void a(Activity activity, int i, ComplianceInfo complianceInfo, b.a aVar) {
        com.opos.cmn.an.f.a.a("PrivacyShowManager", "showAsDialog " + complianceInfo);
        this.d = aVar;
        b();
        this.c = com.opos.mobad.ui.b.e.a(activity, a(activity, i), a(complianceInfo, i), i == 1 ? complianceInfo.d() : null, new e.b() { // from class: com.opos.mobad.cmn.a.d.1
            @Override // com.opos.mobad.ui.b.e.b
            public void a() {
                if (d.this.d == null) {
                    return;
                }
                d.this.d.a();
            }
        });
    }

    @Override // com.opos.mobad.ad.privacy.b
    public void a(Context context, int i, ComplianceInfo complianceInfo, b.a aVar) {
        String str;
        if (this.e) {
            str = "privacy show but destroy";
        } else if (context == null) {
            str = "null context";
        } else {
            if (complianceInfo != null) {
                if (context instanceof Activity) {
                    a((Activity) context, i, complianceInfo, aVar);
                    return;
                } else {
                    b(context, i, complianceInfo, aVar);
                    return;
                }
            }
            str = "illegal data";
        }
        com.opos.cmn.an.f.a.a("PrivacyShowManager", str);
    }
}
