package com.bytedance.sdk.openadsdk.core.ugeno.b;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.bytedance.adsdk.ugeno.fx.bq;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.a;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.s.b;
import com.bytedance.sdk.openadsdk.core.s.x;
import com.bytedance.sdk.openadsdk.core.y.q;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.huawei.hms.ads.ex;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends u implements bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5372a;
    private boolean iz;
    private float jk;
    private com.bytedance.adsdk.ugeno.nr.fx l;
    private float n;
    private long t;
    private float x;

    public fx(Activity activity, ViewGroup viewGroup, x xVar, bc bcVar, String str, int i, com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar) {
        super(activity, viewGroup, xVar, bcVar, str, i, uVar);
    }

    private void iz() {
        Animation animation;
        com.bytedance.adsdk.ugeno.nr.fx fxVar = this.l;
        if (fxVar != null) {
            fxVar.nr(8);
            View viewA = this.l.a();
            if (viewA == null || (animation = viewA.getAnimation()) == null) {
                return;
            }
            animation.cancel();
        }
    }

    private int pn() {
        return (int) (((double) (q.pn(this.u) * this.u.na())) / 100.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.b.u
    public void b() {
        super.b();
        iz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.b.u
    public void u(JSONObject jSONObject) {
        this.nr.u((bq) this);
        try {
            jSONObject.put("isPlayable", ex.Code);
            jSONObject.put("remainTime", pn());
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.b.u
    public void u(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
        this.l = fxVar.b("fl_count_down");
    }

    private void u(MotionEvent motionEvent) {
        if (!this.iz) {
            int iN = y.n(dw.getContext());
            b.u("click", this.u, new a.u().iz(this.x).pn(this.n).b(this.f5372a).fx(this.jk).nr(this.t).u(motionEvent.getEventTime()).fx(motionEvent.getToolType(0)).b(motionEvent.getDeviceId()).pn(this.pn).nr(n.o().fx() ? 1 : 2).u(iN).u(y.iz(dw.getContext())).nr(y.x(dw.getContext())).u(), this.b, true, null, -1, false, false);
        }
        this.iz = true;
    }

    @Override // com.bytedance.adsdk.ugeno.fx.bq
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, MotionEvent motionEvent) {
        if (motionEvent == null || this.iz) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.t = motionEvent.getDownTime();
            this.x = motionEvent.getRawX();
            this.n = motionEvent.getRawY();
            iz();
            return;
        }
        if (action != 1) {
            return;
        }
        this.f5372a = motionEvent.getRawX();
        this.jk = motionEvent.getRawY();
        u(motionEvent);
    }
}
