package com.bytedance.sdk.openadsdk.core.ugeno.t;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.fx.k;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.b;
import com.bytedance.sdk.openadsdk.core.ugeno.component.skip.nr;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements rh.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fx f5387a;
    private fx b;
    private boolean bg;
    private int bq;
    private int c;
    private boolean d;
    private int dw;
    private fx fx;
    private int gi;
    private fx iz;
    private fx jk;
    private int k;
    private boolean kj;
    private int l;
    private int mv;
    private int my;
    private fx n;
    private k nr;
    private int o;
    private fx pn;
    private boolean q;
    private boolean qq;
    private int s;
    private fx t;
    private fx x;
    private int z;
    protected final rh u = new rh(Looper.getMainLooper(), this);
    private int sx = Integer.MIN_VALUE;

    public u(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("xCreative");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("xSetting");
            String strOptString = jSONObject.optString("dynamic_configs", "");
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("video");
                if (jSONObjectOptJSONObject3 != null) {
                    this.mv = jSONObjectOptJSONObject3.optInt(WfConstant.EXTRA_KEY_VIDEO_DURATION);
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("reward_full_time_type", 0);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("reward_full_play_time", 0);
                if (iOptInt == 1) {
                    this.s = iOptInt2;
                    this.bg = true;
                }
            }
            if (jSONObjectOptJSONObject2 != null) {
                if (jSONObjectOptJSONObject2.optInt("ad_slot_type", 0) == 8) {
                    this.l = jSONObjectOptJSONObject2.optInt("iv_skip_time", 0);
                } else {
                    this.l = jSONObjectOptJSONObject2.optInt("rv_skip_time", 0);
                }
            }
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                if (new JSONObject(strOptString).optBoolean("is_show_video_duration", false)) {
                    this.bg = false;
                }
            } catch (JSONException unused) {
            }
        }
    }

    private boolean b() {
        return (this.b == null && this.iz == null && this.pn == null && this.n == null && this.jk == null) ? false : true;
    }

    private void fx() {
        int i;
        int i2;
        int i3;
        fx fxVar;
        if (this.bg) {
            i = this.s;
            i2 = this.my;
        } else {
            i = this.mv;
            i2 = this.k;
        }
        k kVar = this.nr;
        boolean z = true;
        if (kVar != null && (fxVar = this.fx) != null) {
            kVar.u(fxVar, "videoProgress", Integer.valueOf(i2));
        }
        int i4 = i2 + this.o;
        int iMax = Math.max(0, i - i4);
        if (i4 < this.l && iMax != 0 && this.sx > 0) {
            z = false;
        }
        fx fxVar2 = this.b;
        if ((fxVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.u) && this.sx != Integer.MIN_VALUE) {
            fxVar2.nr(0);
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.u) this.b).u(iMax, i4, this.sx);
        }
        fx fxVar3 = this.iz;
        if (fxVar3 instanceof nr) {
            ((nr) fxVar3).b(z);
        }
        fx fxVar4 = this.x;
        if ((fxVar4 instanceof b) && (i3 = this.sx) != Integer.MIN_VALUE) {
            ((b) fxVar4).u(iMax, i4, i3);
        }
        fx fxVar5 = this.pn;
        if (fxVar5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.nr) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.nr) fxVar5).u(i, i4, iMax, z);
        }
        fx fxVar6 = this.n;
        if (fxVar6 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.skip.u) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.skip.u) fxVar6).nr(this.bq, this.dw);
        }
        fx fxVar7 = this.f5387a;
        if (fxVar7 != null) {
            fxVar7.nr(this.q ? 0 : 8);
        }
        fx fxVar8 = this.t;
        if (fxVar8 != null) {
            fxVar8.nr(this.kj ? 0 : 8);
        }
        fx fxVar9 = this.jk;
        if (fxVar9 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.fx) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.fx) fxVar9).u(this.c, this.z, this.gi, this.qq, this.d);
        }
    }

    public void nr() {
        this.u.removeCallbacksAndMessages(null);
    }

    public void u(k kVar, fx fxVar) {
        this.nr = kVar;
        this.fx = fxVar;
        fx fxVarPn = fxVar.pn("RVCountdown");
        this.b = fxVarPn;
        if (fxVarPn == null) {
            this.b = this.fx.pn("FVCountdown");
        }
        fx fxVarPn2 = this.fx.pn("RVSkip");
        this.iz = fxVarPn2;
        if (fxVarPn2 == null) {
            this.iz = this.fx.pn("FVSkip");
        }
        this.pn = this.fx.pn("CycleCountDownView");
        this.x = this.fx.pn("RewardClickCountdown");
        this.n = this.fx.pn("CycleSkip");
        this.jk = this.fx.pn("CsjRefreshTip");
        this.f5387a = this.fx.b("CsjRefreshTipContainer");
        this.t = this.fx.b("CsjRefreshTipCancel");
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what != 100) {
            return;
        }
        this.u.sendEmptyMessageDelayed(100, 200L);
        fx();
    }

    public void u() {
        if (b()) {
            this.u.sendEmptyMessage(100);
        }
    }

    public void u(int i, int i2, int i3, int i4) {
        this.k = i;
        this.my = i2;
        this.o = i3;
        this.sx = i4;
    }

    public void u(int i, int i2) {
        this.bq = i;
        this.dw = i2;
    }

    public void u(int i, boolean z, int i2, int i3, boolean z2, boolean z3, boolean z4) {
        this.c = i;
        this.z = i2;
        this.gi = i3;
        this.q = z2;
        this.qq = z3;
        this.kj = z4;
        this.d = z;
    }
}
