package com.bytedance.sdk.openadsdk.core.activity.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner;
import com.bytedance.sdk.openadsdk.core.k.n;
import com.bytedance.sdk.openadsdk.core.k.u.fx;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.kj.pn;
import com.bytedance.sdk.openadsdk.core.nr.nr;
import com.bytedance.sdk.openadsdk.core.ugeno.x.u;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.az;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BaseLandingPageActivity extends BaseThemeActivity {
    protected int b;
    protected String fx;
    private UgenBanner iz;
    protected String nr;
    protected String u;
    private boolean x;

    private boolean nr() {
        my myVarKv = this.pn.kv();
        if (myVarKv == null) {
            return false;
        }
        myVarKv.u(true);
        int iFx = myVarKv.fx();
        return (iFx == 1 || iFx == 2) && !this.x;
    }

    private u u() {
        my myVarKv = this.pn.kv();
        if (myVarKv == null) {
            return null;
        }
        String strIz = myVarKv.iz();
        if (TextUtils.isEmpty(strIz)) {
            return null;
        }
        u uVar = new u();
        uVar.fx(strIz);
        uVar.nr(myVarKv.x());
        uVar.u(strIz);
        return uVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.fx = intent.getStringExtra("event_tag");
        this.u = intent.getStringExtra(MediationConstant.EXTRA_ADID);
        this.nr = intent.getStringExtra("log_extra");
        this.b = intent.getIntExtra(az.at, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        my myVarKv;
        super.onDestroy();
        UgenBanner ugenBanner = this.iz;
        if (ugenBanner != null) {
            ugenBanner.u();
        }
        bc bcVar = this.pn;
        if (bcVar == null || (myVarKv = bcVar.kv()) == null) {
            return;
        }
        myVarKv.u(false);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Window window = getWindow();
        if (window != null) {
            n.u(window.getDecorView());
        }
        if (this.pn == null || !nr()) {
            return;
        }
        if (this.iz == null) {
            this.iz = new UgenBanner(this);
        }
        addContentView(this.iz, new ViewGroup.LayoutParams(-1, -2));
        this.x = true;
        pn pnVarPu = this.pn.pu();
        String strFx = pnVarPu != null ? pnVarPu.fx() : this.pn.j();
        this.iz.setTopMargin(y.fx(this, 50.0f));
        this.iz.u(u(), this.pn, new nr(this, this.pn, this.fx, this.b), strFx, this.pn.wf(), "立即打开", true);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        fx fxVarU = fx.u();
        bc bcVar = this.pn;
        fxVarU.u(this, bcVar, jp.qq(bcVar));
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        fx.u().nr((Context) this, this.pn, false);
    }
}
