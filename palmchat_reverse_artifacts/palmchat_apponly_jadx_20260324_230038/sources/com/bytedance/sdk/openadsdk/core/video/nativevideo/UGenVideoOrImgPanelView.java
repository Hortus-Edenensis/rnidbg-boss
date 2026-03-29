package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.adsdk.ugeno.fx.c;
import com.bytedance.sdk.component.adexpress.nr.s;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.q;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.bg;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a;
import com.bytedance.sdk.openadsdk.core.ugeno.express.nr;
import com.bytedance.sdk.openadsdk.core.ugeno.jk;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class UGenVideoOrImgPanelView extends NativeExpressView {
    private final View b;
    private final com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz d;
    private final NativeVideoTsView fx;
    private boolean gi;
    private final AtomicBoolean kj;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.b nr;
    private View pn;
    private ViewGroup q;
    private final Context qq;
    private final bc u;
    private volatile boolean z;

    public UGenVideoOrImgPanelView(Context context, bc bcVar, NativeVideoTsView nativeVideoTsView, View view, ViewGroup viewGroup, String str, boolean z) {
        super(context, bcVar, new com.bytedance.sdk.openadsdk.my.fx.fx.nr(new SparseArray()), str);
        this.kj = new AtomicBoolean(true);
        this.z = false;
        this.gi = false;
        this.d = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void pn() {
                UGenVideoOrImgPanelView.this.k();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void u() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void u(boolean z2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void fx() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void nr() {
            }
        };
        this.qq = context;
        this.u = bcVar;
        this.fx = nativeVideoTsView;
        this.b = view;
        this.q = viewGroup;
        this.gi = z;
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        View view = this.pn;
        if (view != null) {
            view.setVisibility(4);
            this.pn.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (UGenVideoOrImgPanelView.this.pn == null) {
                        return;
                    }
                    if (UGenVideoOrImgPanelView.this.pn instanceof ViewGroup) {
                        ((ViewGroup) UGenVideoOrImgPanelView.this.pn).removeAllViews();
                    }
                    ViewParent parent = UGenVideoOrImgPanelView.this.pn.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(UGenVideoOrImgPanelView.this.pn);
                    }
                }
            });
        }
    }

    public int getComponentType() {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void mv() {
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.2
            @Override // java.lang.Runnable
            public void run() {
                UGenVideoOrImgPanelView.this.z = true;
                if (UGenVideoOrImgPanelView.this.pn != null) {
                    ViewParent parent = UGenVideoOrImgPanelView.this.pn.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(UGenVideoOrImgPanelView.this.pn);
                    }
                }
                UGenVideoOrImgPanelView.super.mv();
                if (UGenVideoOrImgPanelView.this.nr != null) {
                    UGenVideoOrImgPanelView.this.nr.u((com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz) null);
                    UGenVideoOrImgPanelView.this.nr.t();
                }
            }
        });
    }

    public void s() {
        if (!this.kj.getAndSet(false)) {
            a.u(this.u, false, 3, 6);
            return;
        }
        bc bcVar = this.u;
        if (bcVar == null) {
            a.u(bcVar, false, 3, 7);
            return;
        }
        if (this.fx == null && this.b == null) {
            a.u(bcVar, false, 3, 1);
            return;
        }
        JSONObject jSONObjectE = bcVar.e();
        if (jSONObjectE == null) {
            a.u(this.u, false, 3, 8);
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectE.optJSONArray("components");
        if (jSONArrayOptJSONArray == null) {
            a.u(this.u, false, 3, 8);
            return;
        }
        this.bq = this.u.jn() == 1;
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            final int iOptInt = jSONObjectOptJSONObject.optInt("render_sequence");
            final int iOptInt2 = jSONObjectOptJSONObject.optInt("displayAreaAndroid");
            String strOptString = jSONObjectOptJSONObject.optString("ugen_md5");
            String strOptString2 = jSONObjectOptJSONObject.optString("ugen_url");
            final String strOptString3 = jSONObjectOptJSONObject.optString("ugen_id");
            jk.u(strOptString2, strOptString, new com.bytedance.sdk.openadsdk.core.ugeno.fx() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.3
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.fx
                public void u(String str) {
                    try {
                        a.u(UGenVideoOrImgPanelView.this.u, true, 3, 0);
                        UGenVideoOrImgPanelView.this.u(new JSONObject(str), iOptInt2, strOptString3, iOptInt);
                    } catch (Throwable unused) {
                        a.u(UGenVideoOrImgPanelView.this.u, false, 3, 3);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.fx
                public void u() {
                    a.u(UGenVideoOrImgPanelView.this.u, false, 3, 4);
                }
            });
        }
    }

    public void setAdSlot(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        this.n = nrVar;
    }

    private void b(final View view) {
        ViewGroup viewGroup = this.q;
        if (viewGroup == null || this.fx == null) {
            a.u(this.u, false, getComponentType(), 101, (Map<String, Object>) null);
        } else {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.9
                @Override // java.lang.Runnable
                public void run() {
                    view.setLayoutParams(new ViewGroup.LayoutParams(UGenVideoOrImgPanelView.this.q.getWidth(), UGenVideoOrImgPanelView.this.q.getHeight()));
                    view.setVisibility(0);
                    UGenVideoOrImgPanelView.this.fx.removeView(view);
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    UGenVideoOrImgPanelView.this.fx.addView(view);
                    UGenVideoOrImgPanelView.this.q.getGlobalVisibleRect(new Rect());
                    UGenVideoOrImgPanelView.this.fx.getGlobalVisibleRect(new Rect());
                    view.setTranslationY(r2.top - r3.top);
                    for (ViewParent parent2 = UGenVideoOrImgPanelView.this.fx.getParent(); parent2 != null; parent2 = parent2.getParent()) {
                        if (parent2 instanceof ViewGroup) {
                            ((ViewGroup) parent2).setClipChildren(false);
                            if (parent2.hashCode() == UGenVideoOrImgPanelView.this.q.hashCode()) {
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    private void fx(final int i, String str) {
        com.bytedance.sdk.component.adexpress.nr.x xVar = new com.bytedance.sdk.component.adexpress.nr.x() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.6
            @Override // com.bytedance.sdk.component.adexpress.nr.x
            public void u(View view, s sVar) {
                a.u(UGenVideoOrImgPanelView.this.u, true, UGenVideoOrImgPanelView.this.getComponentType(), (Map<String, Object>) null);
                if (view == null) {
                    a.u(UGenVideoOrImgPanelView.this.u, false, UGenVideoOrImgPanelView.this.getComponentType(), 200, (Map<String, Object>) null);
                    return;
                }
                UGenVideoOrImgPanelView.this.pn = view;
                UGenVideoOrImgPanelView.this.pn.setTag("U_V_I_P_V_TAG");
                UGenVideoOrImgPanelView.this.u(view, i);
                if (UGenVideoOrImgPanelView.this.u(view)) {
                    a.u(UGenVideoOrImgPanelView.this.u, false, UGenVideoOrImgPanelView.this.getComponentType(), 103, (Map<String, Object>) null);
                } else {
                    a.u(UGenVideoOrImgPanelView.this.u, true, UGenVideoOrImgPanelView.this.getComponentType(), 0, (Map<String, Object>) null);
                }
            }

            @Override // com.bytedance.sdk.component.adexpress.nr.x
            public void u(int i2, String str2) {
                HashMap map = new HashMap();
                map.put("ugen_error_code", Integer.valueOf(i2));
                a.u(UGenVideoOrImgPanelView.this.u, false, UGenVideoOrImgPanelView.this.getComponentType(), (Map<String, Object>) map);
            }
        };
        a.nr(this.u, getComponentType());
        this.nr.u(xVar);
    }

    private void pn(final View view) {
        ViewGroup viewGroup = this.q;
        if (viewGroup == null) {
            a.u(this.u, false, getComponentType(), 101, (Map<String, Object>) null);
        } else if ((viewGroup instanceof FrameLayout) || (viewGroup instanceof RelativeLayout)) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.10
                @Override // java.lang.Runnable
                public void run() {
                    view.setLayoutParams(new ViewGroup.LayoutParams(UGenVideoOrImgPanelView.this.q.getWidth(), UGenVideoOrImgPanelView.this.q.getHeight()));
                    view.setVisibility(0);
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    UGenVideoOrImgPanelView.this.q.removeView(view);
                    UGenVideoOrImgPanelView.this.q.addView(view);
                }
            });
        } else {
            a.u(this.u, false, getComponentType(), 202, (Map<String, Object>) null);
        }
    }

    private void nr(View view) {
        if (this.fx == null) {
            a.u(this.u, false, getComponentType(), 101, (Map<String, Object>) null);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        view.setVisibility(0);
        this.fx.addView(view);
    }

    private void fx(final View view) {
        View view2 = this.b;
        if (view2 == null) {
            a.u(this.u, false, getComponentType(), 101, (Map<String, Object>) null);
            return;
        }
        ViewGroup viewGroup = this.q;
        if (!(viewGroup instanceof FrameLayout) && !(viewGroup instanceof RelativeLayout)) {
            a.u(this.u, false, getComponentType(), 202, (Map<String, Object>) null);
        } else {
            view2.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.8
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[2];
                    UGenVideoOrImgPanelView.this.b.getLocationInWindow(iArr);
                    int[] iArr2 = new int[2];
                    UGenVideoOrImgPanelView.this.q.getLocationInWindow(iArr2);
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    if (UGenVideoOrImgPanelView.this.q instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(UGenVideoOrImgPanelView.this.b.getWidth(), UGenVideoOrImgPanelView.this.b.getHeight());
                        layoutParams.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                        view.setVisibility(0);
                        UGenVideoOrImgPanelView.this.q.addView(view, layoutParams);
                    }
                    if (UGenVideoOrImgPanelView.this.q instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(UGenVideoOrImgPanelView.this.b.getWidth(), UGenVideoOrImgPanelView.this.b.getHeight());
                        layoutParams2.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                        view.setVisibility(0);
                        UGenVideoOrImgPanelView.this.q.addView(view, layoutParams2);
                    }
                }
            });
        }
    }

    public static boolean u(bc bcVar) {
        JSONObject jSONObjectE;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        return (bcVar == null || (jSONObjectE = bcVar.e()) == null || (jSONArrayOptJSONArray = jSONObjectE.optJSONArray("components")) == null || jSONArrayOptJSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null || TextUtils.isEmpty(jSONObjectOptJSONObject.optString("ugen_url"))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final JSONObject jSONObject, final int i, final String str, final int i2) {
        if (jSONObject == null) {
            return;
        }
        NativeVideoTsView nativeVideoTsView = this.fx;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.4
                @Override // java.lang.Runnable
                public void run() {
                    UGenVideoOrImgPanelView uGenVideoOrImgPanelView = UGenVideoOrImgPanelView.this;
                    uGenVideoOrImgPanelView.u(uGenVideoOrImgPanelView.fx, jSONObject, i, str, i2);
                }
            });
            return;
        }
        View view = this.b;
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (i == 0) {
                        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = UGenVideoOrImgPanelView.this;
                        uGenVideoOrImgPanelView.u(uGenVideoOrImgPanelView.q, jSONObject, i, str, i2);
                    } else {
                        UGenVideoOrImgPanelView uGenVideoOrImgPanelView2 = UGenVideoOrImgPanelView.this;
                        uGenVideoOrImgPanelView2.u(uGenVideoOrImgPanelView2.b, jSONObject, i, str, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(View view, JSONObject jSONObject, int i, String str, int i2) {
        if (i2 == 3) {
            jSONObject = com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(this.u, com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(view), jSONObject, this.gi, null);
        }
        JSONObject jSONObjectU = jk.u(this.u, view, this.gi);
        if (jSONObjectU != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObjectU.put("ugen_id", str);
            } catch (JSONException unused) {
            }
        }
        nr.u uVar = new nr.u();
        uVar.pn(jSONObjectU);
        uVar.u(jSONObject);
        uVar.u((c) new bg());
        uVar.nr(view.getHeight());
        uVar.u(view.getWidth());
        uVar.u(n.o().pn());
        uVar.jk(this.u.n());
        uVar.b(dw.nr().jk());
        com.bytedance.sdk.openadsdk.core.ugeno.express.nr nrVarU = uVar.u();
        if (i2 == 3) {
            this.nr = new com.bytedance.sdk.openadsdk.core.ugeno.express.iz(this.qq, this.u, nrVarU, this.q);
        } else {
            this.nr = new com.bytedance.sdk.openadsdk.core.ugeno.express.b(this.qq, this.u, nrVarU, this.q);
        }
        this.nr.u(this);
        this.nr.u(this.d);
        fx(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(View view) {
        View childAt;
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() <= 0) {
            return false;
        }
        View childAt2 = viewGroup.getChildAt(0);
        if ((this.nr instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.iz) && childAt2 != null) {
            ViewGroup viewGroup2 = (ViewGroup) childAt2;
            if (viewGroup2.getChildCount() <= 0 || (childAt = viewGroup2.getChildAt(0)) == null || childAt.getVisibility() != 8) {
                return false;
            }
        } else if (childAt2 == null || childAt2.getVisibility() != 8) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(View view, int i) {
        if (this.z) {
            a.u(this.u, false, getComponentType(), 203, (Map<String, Object>) null);
            return;
        }
        if (i == 0) {
            pn(view);
        } else if (i != 2) {
            if (this.fx != null) {
                nr(view);
            } else {
                fx(view);
            }
        } else {
            b(view);
        }
        if (this.b == null) {
            view.bringToFront();
            u(this.bq);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.nr.n
    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
        this.c = true;
        super.u(view, i, fxVar);
        View view2 = this.fx;
        if (view2 == null) {
            view2 = this.b;
        }
        a.u(this.u, a.u(view2, fxVar), 3, ((q) fxVar).u().optBoolean("isLottieInternalClick", false) ? 2 : 1, (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.nr.n
    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar, int i2) {
        this.c = true;
        super.u(view, i, fxVar, i2);
        View view2 = this.fx;
        if (view2 == null) {
            view2 = this.b;
        }
        a.u(this.u, a.u(view2, fxVar), 3, ((q) fxVar).u().optBoolean("isLottieInternalClick", false) ? 2 : 1, (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(boolean z) {
        NativeVideoTsView nativeVideoTsView = this.fx;
        if (nativeVideoTsView == null) {
            return;
        }
        this.bq = z;
        nativeVideoTsView.nr(z, true);
        com.bykv.vk.openvk.component.video.api.b.fx nativeVideoController = this.fx.getNativeVideoController();
        if (nativeVideoController != null) {
            nativeVideoController.nr(z);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.b bVar = this.nr;
        if (bVar == null) {
            return;
        }
        bVar.setSoundMute(z);
    }
}
