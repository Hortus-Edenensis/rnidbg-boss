package com.bytedance.sdk.openadsdk.pn;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.adsdk.ugeno.fx.a;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.o;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.kj.z;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView;
import com.bytedance.sdk.openadsdk.gi.x;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.upie.u;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static com.bytedance.sdk.openadsdk.upie.u a(bc bcVar) {
        if (!b(bcVar) && !u(bcVar)) {
            return new u.C0317u().fx(l(bcVar)).u();
        }
        u.C0317u c0317uT = t(bcVar);
        JSONObject jSONObjectEt = bcVar.et();
        if (jSONObjectEt != null) {
            try {
                jSONObjectEt.put("os", "android");
            } catch (JSONException unused) {
            }
        }
        c0317uT.u(jSONObjectEt);
        return c0317uT.u();
    }

    public static boolean b(bc bcVar) {
        return pn(bcVar) || iz(bcVar);
    }

    public static boolean fx(bc bcVar) {
        return bcVar != null && bcVar.ts() == 16;
    }

    public static boolean iz(bc bcVar) {
        return bcVar != null && bcVar.ts() == 18;
    }

    public static com.bytedance.sdk.openadsdk.upie.image.lottie.u jk(final bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.upie.image.lottie.u() { // from class: com.bytedance.sdk.openadsdk.pn.u.2
            @Override // com.bytedance.sdk.openadsdk.upie.image.lottie.u
            public void u(Map<String, Object> map) {
                s.u().u(bcVar, map.get("duration"));
            }

            @Override // com.bytedance.sdk.openadsdk.upie.image.lottie.u
            public void u(int i, String str) {
                s.u().u(bcVar, i, str);
            }
        };
    }

    private static String l(bc bcVar) {
        List<rh> listZu;
        if (bcVar == null || (listZu = bcVar.zu()) == null || listZu.size() <= 0) {
            return null;
        }
        return listZu.get(0).u();
    }

    public static boolean n(bc bcVar) {
        if (bcVar != null && !bc.nr(bcVar)) {
            if (b(bcVar)) {
                return true;
            }
            if (!dw.nr().yy() && (z.u(bcVar) || z.nr(bcVar) || UGenVideoOrImgPanelView.u(bcVar))) {
                return true;
            }
        }
        return false;
    }

    public static boolean pn(bc bcVar) {
        return bcVar != null && bcVar.ts() == 17;
    }

    private static u.C0317u t(bc bcVar) {
        int[] iArrPn = zx.pn(bcVar);
        o oVarSx = bcVar.sx();
        String strFx = oVarSx != null ? oVarSx.fx() : null;
        u.C0317u c0317u = new u.C0317u();
        if (TextUtils.isEmpty(strFx)) {
            strFx = "";
        }
        u.C0317u c0317uNr = c0317u.u(strFx).u((iArrPn == null || iArrPn.length < 2) ? 1280 : iArrPn[0]).nr((iArrPn == null || iArrPn.length < 2) ? 720 : iArrPn[1]);
        if (nr(bcVar)) {
            com.bykv.vk.openvk.component.video.api.fx.u uVarO = zx.o(bcVar);
            c0317uNr.fx(l(bcVar)).nr(uVarO != null ? uVarO.pn() : "").u(((long) zx.x(bcVar)) * 1000);
        }
        if (b(bcVar)) {
            c0317uNr.fx(l(bcVar));
        }
        return c0317uNr;
    }

    public static boolean u(bc bcVar) {
        return nr(bcVar) || fx(bcVar);
    }

    public static boolean x(bc bcVar) {
        int[] iArrPn;
        if (bcVar == null || (iArrPn = zx.pn(bcVar)) == null || iArrPn.length < 2) {
            return true;
        }
        int i = iArrPn[0];
        int i2 = iArrPn[1];
        int iB = zx.b(bcVar);
        int iFx = zx.fx(bcVar);
        return (i >= i2 && iB >= iFx) || (i <= i2 && iB <= iFx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fx(ImageView imageView, UpieImageView upieImageView) {
        ViewGroup.LayoutParams layoutParams;
        ViewParent parent = imageView.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int i = 0;
            while (true) {
                if (i >= viewGroup.getChildCount()) {
                    i = -1;
                    break;
                } else if (imageView == viewGroup.getChildAt(i)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams2.gravity = 17;
                    layoutParams = layoutParams2;
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams3.addRule(13);
                    layoutParams = layoutParams3;
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams4.gravity = 17;
                    layoutParams = layoutParams4;
                } else {
                    layoutParams = new ViewGroup.LayoutParams(imageView.getWidth(), imageView.getHeight());
                }
                viewGroup.addView(upieImageView, i, layoutParams);
                viewGroup.removeView(imageView);
            }
        }
    }

    public static boolean nr(bc bcVar) {
        return bcVar != null && bcVar.ts() == 15;
    }

    public static com.bytedance.sdk.openadsdk.upie.u u(bc bcVar, JSONObject jSONObject) {
        u.C0317u c0317uT = t(bcVar);
        if (jSONObject != null) {
            try {
                jSONObject.put("os", "android");
            } catch (JSONException unused) {
            }
        }
        c0317uT.u(jSONObject);
        return c0317uT.u();
    }

    public static void u(JSONObject jSONObject, bc bcVar) {
        if (jSONObject != null) {
            if (u(bcVar) || b(bcVar)) {
                try {
                    jSONObject.put("dynamic_join_type", bcVar.ts());
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static void u(boolean z, a.u uVar) {
        JSONObject jSONObjectB;
        if (uVar == null || (jSONObjectB = uVar.b()) == null || !TextUtils.equals("${image[0].url}", jSONObjectB.optString("src"))) {
            return;
        }
        try {
            if (z) {
                jSONObjectB.put("type", "UpieImage");
            } else {
                jSONObjectB.put("name", "UpieImage");
            }
        } catch (JSONException unused) {
        }
        uVar.u("UpieImage");
    }

    public static void u(final ImageView imageView, final UpieImageView upieImageView) {
        x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pn.u.1
            @Override // java.lang.Runnable
            public void run() {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.pn.u.1.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        int width = imageView.getWidth();
                        int height = imageView.getHeight();
                        if (width <= 90 || height <= 90) {
                            return;
                        }
                        imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        u.fx(imageView, upieImageView);
                    }
                };
                imageView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
                imageView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.pn.u.1.2
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        ImageView imageView2 = imageView;
                        if (imageView2 == view) {
                            imageView2.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                    }
                });
            }
        });
    }
}
