package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.eh;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class dw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeExpressView f5340a;
    private int b;
    private List<com.bytedance.sdk.openadsdk.core.kj.k> fx;
    private List<com.bytedance.adsdk.ugeno.nr.fx<View>> iz;
    private int n;
    private int nr;
    private String pn;
    private double u;
    private boolean x = true;

    public dw(bc bcVar, JSONObject jSONObject, NativeExpressView nativeExpressView) {
        com.bytedance.sdk.openadsdk.core.kj.k kVarU;
        this.b = -1;
        this.n = -1;
        this.f5340a = nativeExpressView;
        this.n = jp.u(bcVar);
        if (jSONObject != null) {
            this.u = jSONObject.optDouble("slide_threshold", 0.0d);
            this.nr = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, 30);
            this.b = jSONObject.optInt("type", -1);
            this.pn = jSONObject.optString("rgb_color");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rects");
            if (jSONArrayOptJSONArray != null) {
                this.fx = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (kVarU = com.bytedance.sdk.openadsdk.core.kj.k.u(jSONObjectOptJSONObject)) != null) {
                        this.fx.add(kVarU);
                    }
                }
            }
        }
        List<com.bytedance.sdk.openadsdk.core.kj.k> list = this.fx;
        if (list != null) {
            list.size();
        }
    }

    public void b() {
        this.x = false;
    }

    public boolean fx() {
        return this.x;
    }

    public void nr() {
        this.f5340a.bq();
    }

    public void u(NativeExpressView nativeExpressView) {
        if (this.fx != null) {
            Context context = nativeExpressView.getContext();
            for (com.bytedance.sdk.openadsdk.core.kj.k kVar : this.fx) {
                View siteGestureView = new SiteGestureView(context, new eh(this.b, this.u, this.nr, this.n), this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(y.fx(context, (float) kVar.fx), y.fx(context, (float) kVar.b));
                layoutParams.leftMargin = y.fx(context, (float) kVar.u);
                layoutParams.topMargin = y.fx(context, (float) kVar.nr);
                try {
                    if (!TextUtils.isEmpty(this.pn) && com.bytedance.sdk.component.utils.k.fx()) {
                        siteGestureView.setBackgroundColor(Color.parseColor(this.pn));
                    }
                } catch (Exception unused) {
                }
                nativeExpressView.addView(siteGestureView, layoutParams);
            }
        }
    }

    public boolean u() {
        View viewA;
        List<com.bytedance.adsdk.ugeno.nr.fx<View>> list = this.iz;
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.bytedance.adsdk.ugeno.nr.fx<View> fxVar : this.iz) {
            if (fxVar != null && (viewA = fxVar.a()) != null && viewA.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void u(List<com.bytedance.adsdk.ugeno.nr.fx<View>> list) {
        this.iz = list;
    }

    public void u(MotionEvent motionEvent) {
        this.f5340a.u(motionEvent);
    }

    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar, eh ehVar) {
        NativeExpressView nativeExpressView = this.f5340a;
        if (nativeExpressView != null) {
            nativeExpressView.u(view, i, fxVar, ehVar);
        }
    }
}
