package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.fe;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.activity.a;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.t;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ComplianceActivity extends a {
    private static final String m = "ComplianceActivity";
    private static final int n = 2;
    private static b o;
    private boolean p;
    private final AdContentData q = new AdContentData();

    private void D() {
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout == null || this.c == null || this.d == null) {
            return;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.ComplianceActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ComplianceActivity.this.finish();
            }
        });
        this.c.setViewClickListener(new fe() { // from class: com.huawei.openalliance.ad.activity.ComplianceActivity.2
            @Override // com.huawei.hms.ads.fe
            public void Code() {
                ComplianceActivity.this.finish();
            }
        });
        this.d.setViewClickListener(new fe() { // from class: com.huawei.openalliance.ad.activity.ComplianceActivity.3
            @Override // com.huawei.hms.ads.fe
            public void Code() {
                ComplianceActivity.this.finish();
            }
        });
    }

    public static void S() {
        o = null;
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public boolean B() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        String stringExtra = safeIntent.getStringExtra(be.aD);
        String stringExtra2 = safeIntent.getStringExtra(be.aE);
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.q.D((List<AdvertiserInfo>) ad.V(stringExtra2, List.class, AdvertiserInfo.class));
        }
        this.p = safeIntent.getBooleanExtra(be.aF, false);
        String stringExtra3 = safeIntent.getStringExtra(be.aw);
        boolean booleanExtra = safeIntent.getBooleanExtra(be.ax, false);
        this.q.L(stringExtra);
        this.q.L(booleanExtra);
        this.q.w(stringExtra3);
        return super.B();
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public void Code() {
        this.i = (RelativeLayout) findViewById(R.id.compliance_activity_root);
        this.j = findViewById(R.id.margin_view);
        this.k = findViewById(R.id.compliance_anchor_view);
        this.c = (PPSBaseDialogContentView) findViewById(R.id.top_compliance_view);
        this.f = (ImageView) findViewById(R.id.top_compliance_iv);
        this.d = (PPSBaseDialogContentView) findViewById(R.id.bottom_compliance_view);
        this.g = (ImageView) findViewById(R.id.bottom_compliance_iv);
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public void I() {
        C();
        this.e.Code(this.L, this.f6912a);
        this.e.setShowWhyThisAd(this.p);
        this.e.setAdContentData(this.q);
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public int V() {
        return R.layout.hiad_activity_compliance;
    }

    @Override // com.huawei.openalliance.ad.activity.a, com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void finish() {
        super.finish();
        b bVar = o;
        if (bVar != null) {
            bVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.activity.a, com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        D();
        b bVar = o;
        if (bVar != null) {
            bVar.Code();
        }
    }

    public static void Code(Context context, View view, AdContentData adContentData, boolean z) {
        if (view == null) {
            return;
        }
        try {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            fh.V(m, "startFeedbackActivity, anchorView.getLocationInWindow [x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int[] iArr3 = {view.getMeasuredWidth(), view.getMeasuredHeight()};
            view.getViewTreeObserver().addOnGlobalLayoutListener(new a.ViewTreeObserverOnGlobalLayoutListenerC0445a(view, context, iArr2));
            Code(context, iArr, iArr3, adContentData, z);
        } catch (Throwable th) {
            fh.I(m, "start Activity error: %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, int[] iArr, int[] iArr2, AdContentData adContentData, boolean z) {
        if (Code(adContentData)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ComplianceActivity.class);
        intent.putExtra(be.av, iArr);
        intent.putExtra(be.ay, iArr2);
        intent.setFlags(65536);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        String strAd = adContentData.ad();
        if (TextUtils.isEmpty(strAd)) {
            strAd = adContentData.ac();
        }
        intent.putExtra(be.aD, strAd);
        intent.putExtra(be.aw, adContentData.aP());
        intent.putExtra(be.ax, adContentData.aQ());
        intent.putExtra(be.aE, ad.V(adContentData.aL()));
        intent.putExtra(be.aF, z);
        intent.setClipData(x.cS);
        bg.Code(context, intent);
    }

    public static void Code(b bVar) {
        o = bVar;
    }

    private static boolean Code(AdContentData adContentData) {
        if (!t.Code()) {
            return adContentData == null;
        }
        fh.V(m, "repeat click too fast");
        return true;
    }
}
