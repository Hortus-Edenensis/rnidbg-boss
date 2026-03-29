package com.bytedance.sdk.openadsdk.core.l.fx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.huawei.openalliance.ad.constant.az;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends iz {
    public nr(Context context, bc bcVar, String str, boolean z) {
        super(context, bcVar, str, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn
    public boolean iz() {
        if (this.pn.kv() == null) {
            return false;
        }
        String strNr = this.pn.kv().nr();
        if (!TextUtils.isEmpty(strNr)) {
            my.u((String) null);
            Uri uri = Uri.parse(strNr);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            jp.nr(intent);
            if (this.o) {
                com.bytedance.sdk.openadsdk.core.s.b.nr(this.pn, this.iz, "lp_open_dpl", u(strNr));
            }
            try {
                Context context = getContext();
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                if (!u(this.iz, "open_url_app", this.pn)) {
                    HashMap map = new HashMap();
                    map.put(az.at, "AndroidRDMLicManager");
                    com.bytedance.sdk.openadsdk.core.s.b.n(this.pn, this.iz, "open_url_app", map);
                }
                jp.u(this.o, this.pn, this.iz);
                com.bytedance.sdk.component.utils.nr.startActivity(context, intent, TextUtils.equals("main", UMModuleRegister.INNER));
                com.bytedance.sdk.openadsdk.core.s.n.u().u(this.pn, this.iz, this.o);
                if (this.o) {
                    com.bytedance.sdk.openadsdk.core.s.b.fx(this.pn, this.iz, "lp_openurl");
                    com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, this.iz, "lp_deeplink_success_realtime", (Throwable) null);
                } else {
                    com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, this.iz, "deeplink_success_realtime", (Throwable) null);
                }
                return true;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.core.s.b.fx(this.pn, this.iz, "open_fallback_download");
                if (this.o) {
                    com.bytedance.sdk.openadsdk.core.s.b.fx(this.pn, this.iz, "lp_openurl_failed");
                    u(this.pn, this.iz, "lp_deeplink_fail_realtime", th);
                } else {
                    u(this.pn, this.iz, "deeplink_fail_realtime", th);
                }
            }
        }
        if (this.x.get() == 4 || this.x.get() == 3) {
            return false;
        }
        if (this.f5332a && !this.n.get()) {
            return false;
        }
        this.f5332a = true;
        if (u(this.iz, "open_fallback_url", this.pn)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.s.b.n(this.pn, this.iz, "open_fallback_url", null);
        return false;
    }
}
