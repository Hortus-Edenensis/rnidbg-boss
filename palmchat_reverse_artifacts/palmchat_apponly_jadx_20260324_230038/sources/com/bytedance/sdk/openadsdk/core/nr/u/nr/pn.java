package com.bytedance.sdk.openadsdk.core.nr.u.nr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jw;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.s.n;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.q;
import com.bytedance.sdk.openadsdk.gi.x;
import com.cdo.oaps.ad.OapsWrapper;
import com.huawei.openalliance.ad.constant.az;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private static volatile boolean n = false;
    private int b;
    private final Context fx;
    private boolean iz;
    private final bc nr;
    private String pn;
    private Toast u;
    private jw x;

    /* JADX INFO: compiled from: SearchBox */
    public class nr implements qq.fx<JSONObject> {
        private final Toast b;
        private final jw nr;
        private final u u;

        public nr(u uVar, jw jwVar, Toast toast) {
            this.u = uVar;
            this.nr = jwVar;
            this.b = toast;
        }

        @Override // com.bytedance.sdk.openadsdk.core.qq.fx
        public void u(int i, String str) {
            this.nr.nr(0);
            Toast toast = this.b;
            if (toast != null) {
                toast.cancel();
            }
            u uVar = this.u;
            if (uVar != null) {
                uVar.nr();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.sdk.openadsdk.core.qq.fx
        public void u(JSONObject jSONObject) {
            String strOptString = jSONObject.optString("scheme");
            if (!TextUtils.isEmpty(strOptString)) {
                pn.this.u(strOptString, this.nr, this.u);
            } else {
                u(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, " scheme is null!");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void nr();

        void u();
    }

    public pn(bc bcVar, Context context) {
        this.nr = bcVar;
        this.fx = context;
    }

    public pn nr(boolean z) {
        this.iz = z;
        return this;
    }

    private int nr(u uVar) {
        jw jwVarKg;
        bc bcVar = this.nr;
        if (bcVar == null || (jwVarKg = bcVar.kg()) == null) {
            return 0;
        }
        if (jwVarKg.iz() != 1 || !b.fx().u()) {
            return 1;
        }
        if (TextUtils.isEmpty(jwVarKg.x())) {
            return 0;
        }
        u(uVar, jwVarKg);
        return 2;
    }

    public static boolean u() {
        return n;
    }

    public static void u(boolean z) {
        n = z;
    }

    public pn u(String str) {
        this.pn = str;
        return this;
    }

    public pn u(int i) {
        this.b = i;
        return this;
    }

    public boolean u(u uVar) {
        int iNr;
        if (this.x == null) {
            bc bcVar = this.nr;
            this.x = bcVar != null ? bcVar.kg() : null;
        }
        jw jwVar = this.x;
        if (jwVar == null) {
            return false;
        }
        int iNr2 = jwVar.nr();
        if (iNr2 != 1) {
            if (iNr2 != 2 || (iNr = nr(uVar)) == 0) {
                return false;
            }
            if (iNr == 2) {
                return true;
            }
            if (TextUtils.isEmpty(this.x.u())) {
                return false;
            }
            u(uVar, this.x, 2000L);
            return true;
        }
        if (this.iz && (TextUtils.isEmpty(this.x.n()) || nr(uVar) == 2)) {
            return true;
        }
        return false;
    }

    private void nr() {
        x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nr.u.nr.pn.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (pn.this.u != null) {
                        pn.this.u.cancel();
                    }
                    pn pnVar = pn.this;
                    pnVar.u = h.u(pnVar.fx, "即将跳转微信...", 1, 17, 0, 0);
                    pn.this.u.show();
                } catch (Throwable th) {
                    k.u("toast error:" + th.getMessage());
                }
            }
        });
    }

    private void u(final u uVar, jw jwVar) {
        nr();
        dw.u().u(jwVar, this.nr.jf(), this.nr.ap(), new nr(uVar, jwVar, this.u) { // from class: com.bytedance.sdk.openadsdk.core.nr.u.nr.pn.1
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.nr.pn.nr, com.bytedance.sdk.openadsdk.core.qq.fx
            public void u(JSONObject jSONObject) {
                String strOptString = jSONObject.optString("userName");
                String strOptString2 = jSONObject.optString(OapsWrapper.KEY_PATH);
                if (TextUtils.isEmpty(strOptString)) {
                    u(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, " userName or path is null!");
                    return;
                }
                if (pn.this.u != null) {
                    pn.this.u.cancel();
                }
                b.fx().u(pn.this.nr, strOptString, strOptString2, uVar, pn.this.pn, pn.this.iz);
            }
        }, 1, 2000L);
    }

    private void u(u uVar, jw jwVar, long j) {
        nr();
        dw.u().u(jwVar, this.nr.jf(), this.nr.ap(), new nr(uVar, jwVar, this.u), 2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, final jw jwVar, final u uVar) {
        Toast toast = this.u;
        if (toast != null) {
            toast.cancel();
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        final String strU = q.nr(this.nr) ? this.pn : jp.u(this.b);
        com.bytedance.sdk.component.utils.nr.u(this.fx, intent, new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.nr.u.nr.pn.3
            @Override // com.bytedance.sdk.component.utils.nr.u
            public void u() {
                jwVar.nr(1);
                com.bytedance.sdk.openadsdk.core.s.b.u(pn.this.nr, strU, "deeplink_success_realtime", (Throwable) null);
                HashMap map = new HashMap();
                map.put(az.at, "WechatClickProcesser");
                com.bytedance.sdk.openadsdk.core.s.b.n(pn.this.nr, strU, "open_url_app", map);
                n.u().u(pn.this.nr, strU, false);
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.u();
                }
            }

            @Override // com.bytedance.sdk.component.utils.nr.u
            public void u(Throwable th) {
                jwVar.nr(0);
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.nr();
                }
            }
        }, TextUtils.equals("main", UMModuleRegister.INNER));
    }
}
