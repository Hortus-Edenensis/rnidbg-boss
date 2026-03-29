package com.zenmen.palmchat.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.zenmen.openapi.webapp.WebAppManager;
import defpackage.an1;
import defpackage.m5;
import defpackage.so6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IWXAPI f16071a;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        m5.c(this, bundle);
        super.onCreate(bundle);
        IWXAPI iwxapiB = so6.a().b();
        this.f16071a = iwxapiB;
        iwxapiB.handleIntent(getIntent(), this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f16071a.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp.getType() == 5 && !WebAppManager.getInstance().isFromSdp()) {
            an1.c().l(baseResp);
        }
        finish();
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }
}
