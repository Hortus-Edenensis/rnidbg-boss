package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.k;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr {
    private EasyPlayableContainer b;
    protected boolean fx = false;
    protected u nr;
    protected final bc u;

    public nr(bc bcVar, u uVar) {
        this.u = bcVar;
        this.nr = uVar;
    }

    public abstract iz nr();

    public abstract int u();

    public abstract boolean u(int i, int i2);

    public void u(final ViewGroup viewGroup, final View view, final View view2, final boolean z, final boolean z2, final float[] fArr, final com.bytedance.sdk.openadsdk.core.z.u uVar) {
        final HashMap map = new HashMap();
        if (viewGroup == null || view == null) {
            a.u(this.u, false, u(), 101, (Map<String, Object>) map);
        } else if (view2 == null) {
            a.u(this.u, false, u(), 102, (Map<String, Object>) map);
        } else {
            view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!nr.this.u(view.getWidth(), view.getHeight())) {
                        map.put("view_width", Integer.valueOf(view.getWidth()));
                        map.put("view_height", Integer.valueOf(view.getHeight()));
                        nr nrVar = nr.this;
                        a.u(nrVar.u, false, nrVar.u(), 201, (Map<String, Object>) map);
                        return;
                    }
                    boolean[] zArr = {true};
                    k kVarU = nr.this.u(zArr, fArr, uVar, view.getWidth(), view.getHeight());
                    if (!zArr[0]) {
                        nr nrVar2 = nr.this;
                        nrVar2.u(uVar, nrVar2.u());
                        return;
                    }
                    if (view2.getParent() != null) {
                        ((ViewGroup) view2.getParent()).removeView(view2);
                    }
                    nr.this.b = new EasyPlayableContainer(dw.getContext(), nr.this.nr(), kVarU, nr.this.u);
                    nr.this.b.setTag("easy_pfwv");
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                    layoutParams.gravity = 17;
                    nr.this.b.addView(view2, layoutParams);
                    map.put("container_name", viewGroup.getClass().getName());
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationInWindow(iArr2);
                    ViewGroup viewGroup2 = viewGroup;
                    if (viewGroup2 instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(view.getWidth(), view.getHeight());
                        layoutParams2.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                        nr.this.b.setLayoutParams(layoutParams2);
                    } else if (!(viewGroup2 instanceof FrameLayout)) {
                        nr nrVar3 = nr.this;
                        a.u(nrVar3.u, false, nrVar3.u(), 202, (Map<String, Object>) map);
                        return;
                    } else {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                        layoutParams3.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                        nr.this.b.setLayoutParams(layoutParams3);
                    }
                    viewGroup.addView(nr.this.b);
                    if (!z) {
                        viewGroup.setClipChildren(false);
                    }
                    if (!z2) {
                        nr nrVar4 = nr.this;
                        a.u(nrVar4.u, false, nrVar4.u(), 103, (Map<String, Object>) map);
                    } else {
                        nr.this.u(uVar, kVarU);
                        nr nrVar5 = nr.this;
                        a.u(nrVar5.u, true, nrVar5.u(), 0, (Map<String, Object>) map);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public k u(boolean[] zArr, float[] fArr, com.bytedance.sdk.openadsdk.core.z.u uVar, float f, float f2) {
        k kVarU = uVar != null ? k.u(uVar.nr()) : null;
        if (fArr == null) {
            if (kVarU == null) {
                return new k(0.0d, 0.0d, y.b(dw.getContext(), f), y.b(dw.getContext(), f2));
            }
            return kVarU;
        }
        final k kVarU2 = u(fArr, f, f2);
        if (kVarU == null) {
            return kVarU2;
        }
        double dU = k.u(kVarU, kVarU2);
        final double d = kVarU2.fx * kVarU2.b;
        final double d2 = kVarU.fx * kVarU.b;
        final k kVarNr = k.nr(kVarU, kVarU2);
        final double d3 = kVarNr != null ? kVarNr.fx * kVarNr.b : 0.0d;
        if (uVar != null) {
            uVar.u(new com.bytedance.sdk.openadsdk.core.z.nr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.nr.2
                @Override // com.bytedance.sdk.openadsdk.core.z.nr
                public JSONObject getActualRectJson() {
                    return k.u(kVarU2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.z.nr
                public double getExceedAreaRate() {
                    double d4 = d2;
                    if (d4 <= 0.0d) {
                        return 1.0d;
                    }
                    if (d <= 0.0d) {
                        return -1.0d;
                    }
                    return (d3 - d4) / d4;
                }

                @Override // com.bytedance.sdk.openadsdk.core.z.nr
                public JSONObject getMaxRectJson() {
                    return k.u(kVarNr);
                }
            });
        }
        if (d2 <= 0.0d) {
            zArr[0] = false;
            return null;
        }
        if (d <= 0.0d) {
            zArr[0] = false;
            return null;
        }
        if (dU / d >= 0.8d) {
            return kVarNr;
        }
        zArr[0] = false;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.z.u uVar, k kVar) {
        if (uVar != null) {
            uVar.u(true, k.u(kVar), u());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.z.u uVar, int i) {
        if (uVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, 1);
            } catch (JSONException e) {
                e.getMessage();
            }
            uVar.u(false, jSONObject, i);
        }
    }

    private k u(float[] fArr, float f, float f2) {
        int iB = y.b(dw.getContext(), f);
        int iB2 = y.b(dw.getContext(), f2);
        float f3 = fArr[1];
        float f4 = fArr[0];
        float f5 = (iB - f3) - fArr[3];
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        return new k(f3, f4, f5, (iB2 - f4) - fArr[2] >= 0.0f ? r15 : 0.0f);
    }
}
