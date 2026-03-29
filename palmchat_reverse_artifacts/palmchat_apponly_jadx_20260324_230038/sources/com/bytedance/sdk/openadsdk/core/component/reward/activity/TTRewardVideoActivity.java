package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.n.u.fx;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.pn;
import com.bytedance.sdk.openadsdk.core.component.reward.u.n;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.ja;
import com.bytedance.sdk.openadsdk.core.kj.w;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.n.b;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.qq.u.nr;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.bytedance.sdk.openadsdk.core.y.kj;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.t.u.u;
import com.huawei.openalliance.ad.constant.bq;
import com.ss.android.download.api.constant.BaseConstants;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.cordova.jssdk.general.Action;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private String ge;
    private int ju;
    private String ob;
    private String rv;
    private fx uq;
    private String zx;
    private final int mk = 10111;
    private final int p = 10112;
    private final int kw = 10113;
    private final int f = 10114;
    private final int za = 10115;
    private final int tm = 10116;
    private final AtomicBoolean jw = new AtomicBoolean();

    private boolean ge() {
        if (TextUtils.isEmpty(this.pn.xx())) {
            return false;
        }
        return this.jw.get();
    }

    private void ju() {
        this.rh.u("cancelClickLandingRewardTip", (JSONObject) null);
    }

    private int ob() {
        final int i = 0;
        if (yd.b(this.pn)) {
            if (this.k.get()) {
                i = 10116;
            } else if (!ge()) {
                i = 10111;
            }
        }
        if (dw.nr().kd() == 0) {
            return i;
        }
        boolean zN = kj.n();
        int iU = kj.u(this.pn.si() + "_" + this.pn.wo());
        if (zN) {
            i = 10115;
        } else if (iU == kj.nr) {
            i = 10114;
        } else if (iU == kj.fx) {
            i = 10113;
        }
        s.u().nr(new u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                nr<nr> nrVarNr = nr.nr();
                nrVarNr.u("armor_reward");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorCode", i);
                nrVarNr.nr(jSONObject.toString());
                return nrVarNr;
            }
        }, "armor_reward");
        return i;
    }

    private void rv() {
        pn pnVar;
        if (yd.x(this.pn) && this.xg.dw() >= yd.jk(this.pn)) {
            if (!this.y.x() || (pnVar = this.rh) == null || pnVar.a() != 0) {
                y.u(this.bc, yd.a(this.pn), 0);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("toast_text", yd.a(this.pn));
                this.rh.u(Action.ACTION_SHOW_TOAST, jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void b() {
        fx fxVar = new fx() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.1
            @Override // com.bytedance.sdk.component.n.u.fx
            public void u(String str, String str2) {
                if (((BaseThemeActivity) TTRewardVideoActivity.this).pn != null) {
                    String strXx = ((BaseThemeActivity) TTRewardVideoActivity.this).pn.xx();
                    if (TextUtils.equals(bq.b.V, str) && TextUtils.equals(str2, strXx)) {
                        TTRewardVideoActivity.this.jw.set(true);
                    }
                }
            }
        };
        this.uq = fxVar;
        com.bytedance.sdk.component.n.nr.u.u(fxVar);
        super.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void bg() {
        super.bg();
        za();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public int d() {
        if (this.ju != 0 && !TextUtils.isEmpty(this.ob)) {
            return this.ju;
        }
        if (yd.nr(this.pn) == 0 || TextUtils.isEmpty(yd.u(this.pn))) {
            return 0;
        }
        return yd.nr(this.pn);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean gi() {
        return this.gc.u() || this.eh.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String h() {
        return (this.ju == 0 || TextUtils.isEmpty(this.ob)) ? (yd.nr(this.pn) == 0 || TextUtils.isEmpty(yd.u(this.pn))) ? "" : yd.u(this.pn) : this.ob;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String ja() {
        if (this.gc.u() && !TextUtils.isEmpty(this.gc.x()) && !TextUtils.isEmpty(this.gc.iz())) {
            return this.gc.iz();
        }
        return h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean kj() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void n(int i) {
        if (!this.b.containsKey(0)) {
            this.nr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    h.u(TTRewardVideoActivity.this.bc, "当前不满足条件，下次记得看完视频哦～", 1);
                }
            });
        } else if (wi.u(this.pn)) {
            this.nr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    h.u(TTRewardVideoActivity.this.bc, "非常抱歉，当前不支持再看一个", 1);
                }
            });
        } else {
            this.gc.fx(i);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.wq.pb()) {
            return;
        }
        this.y.u(i, i2, intent);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        fx fxVar;
        super.onDestroy();
        this.gc.fx();
        List<fx> listU = com.bytedance.sdk.component.n.nr.u.u();
        if (listU == null || listU.size() == 0 || (fxVar = this.uq) == null) {
            return;
        }
        listU.remove(fxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (yd.o(this.pn)) {
            this.y.fx(b.nr);
            b.fx = false;
            b.nr = 0;
            b.u = this.y.y();
            fx(0);
        }
        if (yd.bg(this.pn) && b.b) {
            ju();
            b(4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean q() {
        return super.q() || this.gc.pn();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String rh() {
        if (this.gc.u() && !TextUtils.isEmpty(this.gc.x()) && !TextUtils.isEmpty(this.gc.iz())) {
            return this.gc.x();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d());
        return sb.toString();
    }

    public boolean tm() {
        return Math.round(((float) (this.xg.rh() + (((long) this.y.tk()) * 1000))) / 1000.0f) >= this.y.wi();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void w() {
        super.w();
        if (yd.o(this.pn) || this.wq.rh() || bg.b(this.pn)) {
            return;
        }
        if (this.xg.bf()) {
            this.bf.u(false, null, null, true, true);
            return;
        }
        int iIz = this.y.iz(true);
        int iIz2 = this.y.iz(ja.nr(kj(), this.pn, true));
        String str = "已领取奖励";
        if (tm() || this.y.o()) {
            com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar = this.bf;
            if (iIz2 > 0) {
                str = iIz2 + "s";
            }
            pnVar.u(false, str, "跳过", false, true);
        } else {
            com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar2 = this.bf;
            if (iIz2 > 0) {
                str = iIz2 + "s";
            }
            pnVar2.u(false, str, null, false, false);
        }
        this.y.nr(iIz);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void z() {
        if (this.fx.getAndSet(true) || this.gc.u() || this.nb.nr() || ja.nr(kj(), this.pn, true)) {
            return;
        }
        b("onAdClose");
    }

    public void za() {
        if (ja.nr(kj(), this.pn, true)) {
            if (this.eh.u() > this.y.m()) {
                this.eh.u(false);
            }
            int iMax = Math.max(this.y.iz(true) - this.eh.u(), 0);
            int iIz = this.y.iz(false) - this.eh.u();
            if (this.y.n(false)) {
                iIz = Math.max(0, iIz - iMax);
            }
            if (this.b.containsKey(0)) {
                iMax = 999;
                iIz = 999;
            }
            t(iIz);
            l(iMax);
            if (this.b.containsKey(0)) {
                fx(0, true);
            }
            kw();
        }
    }

    private JSONObject nr(int i, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put(MediationConstant.REWARD_NAME, h());
            jSONObject.put(MediationConstant.REWARD_AMOUNT, d());
            jSONObject.put("network", o.fx(dw.getContext()));
            jSONObject.put("sdk_version", d.b);
            jSONObject.put("user_agent", jk.mv());
            jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, this.pn.tq());
            jSONObject.put("media_extra", this.rv);
            jSONObject.put(WfConstant.EXTRA_KEY_VIDEO_DURATION, this.xg.d());
            jSONObject.put("play_start_ts", this.wi);
            jSONObject.put("play_end_ts", System.currentTimeMillis() / 1000);
            jSONObject.put("duration", this.xg.dw());
            jSONObject.put("user_id", this.ge);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
            jSONObject.put("reward_type", i);
            if (yd.b(this.pn)) {
                jSONObject.put("show_result", z ? 1 : 0);
            }
            com.bytedance.sdk.openadsdk.k.nr.u(this.bc, jSONObject);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void fx(int i) {
        if (i != 0) {
            b(i);
            return;
        }
        if (this.y.m() > 0) {
            return;
        }
        if ((!yd.gi(this.pn) || this.x.get()) && this.y.bf()) {
            b(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void b(final int i) {
        if (!this.o.getAndSet(true)) {
            this.gc.b();
        }
        if (this.b.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.b.put(Integer.valueOf(i), Boolean.TRUE);
        this.f5220jp.fx();
        boolean z = !yd.kj(this.pn);
        final int iD = d();
        final String strH = h();
        int iOb = ob();
        boolean z2 = iOb == 0;
        if (z2 && !z) {
            fx(i, true);
            dw.u().u(nr(i, true), new qq.pn() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.2
                @Override // com.bytedance.sdk.openadsdk.core.qq.pn
                public void u(int i2, String str) {
                    TTRewardVideoActivity.this.fx(TTRewardVideoActivity.this.u(i, false, i2, str, iD, strH, false));
                }

                @Override // com.bytedance.sdk.openadsdk.core.qq.pn
                public void u(kj.b bVar) {
                    int iU = bVar.fx.u();
                    String strNr = bVar.fx.nr();
                    TTRewardVideoActivity.this.fx(bVar.nr ? TTRewardVideoActivity.this.u(i, true, 10111, "reward failed", iU, strNr, true) : TTRewardVideoActivity.this.u(i, false, 10112, "server refuse", iU, strNr, true));
                }
            });
        } else {
            fx(u(i, z2, iOb, "reward failed", iD, strH, false));
            fx(i, z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String u() {
        return this.zx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void u(Intent intent) {
        super.u(intent);
        if (intent == null) {
            return;
        }
        this.rv = intent.getStringExtra("media_extra");
        this.ge = intent.getStringExtra("user_id");
        this.ob = intent.getStringExtra(MediationConstant.REWARD_NAME);
        this.zx = intent.getStringExtra("userData");
        this.ju = intent.getIntExtra(MediationConstant.REWARD_AMOUNT, 0);
        this.gc.u(intent.getBooleanExtra("is_play_again", false));
        this.gc.u(intent.getIntExtra("play_again_count", 0));
        this.gc.nr(intent.getBooleanExtra("custom_play_again", false));
        this.gc.nr(intent.getIntExtra("source_rit_id", 0));
        this.gc.u(intent.getStringExtra("reward_again_name"));
        this.gc.nr(intent.getStringExtra("reward_again_amount"));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fx(boolean z) {
        int i;
        if (!this.qq) {
            i = z ? 0 : -1;
        } else if (dw.nr().si() == 1) {
            i = 2000;
        }
        int i2 = this.gc.u() ? -1 : i;
        if (i2 < 0 || this.dw.get()) {
            return;
        }
        if (i2 == 0) {
            if (this.dw.getAndSet(true)) {
                return;
            }
            n.u().u(String.valueOf(this.oa));
            return;
        }
        this.nr.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (TTRewardVideoActivity.this.dw.getAndSet(true)) {
                    return;
                }
                n.u().u(String.valueOf(TTRewardVideoActivity.this.oa));
            }
        }, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(Bundle bundle) {
        int i = bundle.getInt("callback_extra_key_reward_type");
        if (i == 0) {
            u("onRewardVerify", bundle);
        }
        u("onRewardArrived", bundle);
        this.f5220jp.u(bundle);
        this.y.u(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean u(Bundle bundle) {
        com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.nr.u();
        fxVarU.put("is_reward_deep_link_to_live", false);
        fxVarU.put("click_to_live_duration", System.currentTimeMillis());
        return super.u(bundle);
    }

    private void fx(int i, boolean z) {
        if (i == 0) {
            this.rh.mv();
            this.m.nr(z);
            rv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void b(String str) {
        u(str, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle u(int i, boolean z, int i2, String str, int i3, String str2, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("callback_extra_key_reward_valid", z);
        bundle.putInt("callback_extra_key_reward_type", i);
        bundle.putInt("callback_extra_key_reward_amount", i3);
        bundle.putString("callback_extra_key_reward_name", str2);
        bundle.putFloat("callback_extra_key_reward_propose", yd.u(this.pn, i));
        bundle.putBoolean("callback_extra_key_is_server_verify", z2);
        if (!z) {
            bundle.putInt("callback_extra_key_error_code", i2);
            bundle.putString("callback_extra_key_error_msg", str);
        }
        if (i == 0 && yd.x(this.pn) && this.xg.dw() >= yd.jk(this.pn)) {
            bundle.putBoolean("callback_extra_key_video_complete_reward", true);
        }
        return bundle;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void nr() {
        if (!this.eh.pn() && this.b.containsKey(0) && this.gc.fx(2)) {
            return;
        }
        super.nr();
    }

    private void u(String str, Bundle bundle) {
        com.bytedance.sdk.openadsdk.core.component.reward.u.u(0, this.gc.u() ? w.u(this.w) : this.w, str, bundle);
    }
}
