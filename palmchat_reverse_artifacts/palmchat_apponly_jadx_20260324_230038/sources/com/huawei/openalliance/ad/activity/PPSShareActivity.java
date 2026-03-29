package com.huawei.openalliance.ad.activity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.ld;
import com.huawei.hms.ads.le;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSShareActivity extends d {
    private static final String Code = "PPSShareActivity";
    private static final String V = "shareClick";
    private com.huawei.openalliance.ad.views.dialog.b Z;
    private boolean I = true;
    private final DialogInterface.OnDismissListener B = new DialogInterface.OnDismissListener() { // from class: com.huawei.openalliance.ad.activity.PPSShareActivity.1
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PPSShareActivity.this.finish();
        }
    };

    private le V() {
        SafeIntent safeIntent = (SafeIntent) getIntent();
        try {
            le leVar = new le(safeIntent.getStringExtra("title"), safeIntent.getStringExtra("description"), safeIntent.getStringExtra(ld.f6599a), safeIntent.getStringExtra("cshareUrl"));
            leVar.Code(getPackageManager().getApplicationInfo(getPackageName(), 0).icon);
            leVar.B(safeIntent.getStringExtra("contentId"));
            leVar.S(safeIntent.getStringExtra("slotId"));
            leVar.C(safeIntent.getStringExtra("templateId"));
            leVar.Code((ImageInfo) ad.V(safeIntent.getStringExtra(ld.f), ImageInfo.class, new Class[0]));
            leVar.Code((AdContentData) ad.V(safeIntent.getStringExtra(ld.g), AdContentData.class, new Class[0]));
            return leVar;
        } catch (RuntimeException e) {
            fh.I(Code, "getIntentParams runtime exception: %s", e.getClass().getSimpleName());
            return null;
        } catch (Throwable th) {
            fh.I(Code, "getIntentParams error: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    public void Code() {
        setContentView(R.layout.hiad_activity_share);
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.huawei.openalliance.ad.views.dialog.b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        fh.V(Code, "onCreate");
        super.onCreate(bundle);
        Code();
        le leVarV = V();
        if (leVarV == null) {
            finish();
            return;
        }
        com.huawei.openalliance.ad.views.dialog.b bVar = new com.huawei.openalliance.ad.views.dialog.b(this, leVarV);
        this.Z = bVar;
        bVar.Code();
        this.Z.Code(this.B);
        db.Code(this, V, leVarV.L());
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onDestroy() {
        fh.V(Code, "onDestroy");
        super.onDestroy();
        com.huawei.openalliance.ad.views.dialog.b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onResume() {
        super.onResume();
        fh.V(Code, "onResume");
        if (this.I) {
            this.I = false;
            return;
        }
        com.huawei.openalliance.ad.views.dialog.b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
    }
}
