package com.bytedance.sdk.openadsdk.core.a.u.u.u;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x implements com.bytedance.sdk.openadsdk.core.a.u.u.u {
    private String b;
    private bc fx;
    private Context nr;
    private com.bytedance.sdk.openadsdk.core.kj.pn u;

    public x(com.bytedance.sdk.openadsdk.core.kj.pn pnVar, Context context) {
        this.u = pnVar;
        this.nr = context;
    }

    private void nr() {
        new CountDownTimer(3000L, 3000L) { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.x.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (com.bytedance.sdk.openadsdk.core.n.o() == null || com.bytedance.sdk.openadsdk.core.n.o().u()) {
                    x.this.u(true);
                } else {
                    x.this.u(false);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    public void u(bc bcVar) {
        this.fx = bcVar;
    }

    public boolean nr(String str) {
        if (this.nr == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            com.bytedance.sdk.component.utils.nr.startActivity(this.nr, intent, TextUtils.equals("main", UMModuleRegister.INNER));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void u(String str) {
        this.b = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u
    public boolean u(Map<String, Object> map) {
        return u();
    }

    private boolean u() {
        com.bytedance.sdk.openadsdk.core.kj.pn pnVar = this.u;
        if (pnVar == null) {
            return false;
        }
        String strU = pnVar.u();
        if (bq.iz(this.fx) != 3 || TextUtils.isEmpty(strU)) {
            return false;
        }
        boolean zNr = nr(strU);
        if (zNr) {
            nr();
        } else {
            u(false);
        }
        return zNr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.core.s.b.nr(this.fx, this.b, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.s.b.nr(this.fx, this.b, "quickapp_fail");
        }
    }
}
