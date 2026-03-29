package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class xg {
    private static int b;
    private static int fx;
    private static Handler iz;
    private static final HashSet<String> n;
    private static final boolean nr;
    private static int pn;
    private static final boolean u;
    private static final HashSet<String> x;

    static {
        u = com.bytedance.sdk.openadsdk.core.y.gi.my();
        nr = u();
        fx = -1;
        b = -1;
        pn = -1;
        iz = null;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        x = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        n = hashSet2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fx(com.bytedance.sdk.component.mv.fx fxVar) {
        if (fxVar == null) {
            return;
        }
        fxVar.setWebChromeClient(null);
        fxVar.setWebViewClient(null);
        View view = fxVar.getView();
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        }
        fxVar.removeAllViews();
        try {
            fxVar.destroy();
        } catch (Throwable unused) {
        }
    }

    public static void u(final Context context, final com.bytedance.sdk.component.mv.fx fxVar) {
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xg.1
            @Override // java.lang.Runnable
            public void run() {
                xg.nr(context, fxVar);
            }
        });
    }

    public static void nr(Context context, com.bytedance.sdk.component.mv.fx fxVar) {
        if (context == null || fxVar == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            try {
                fxVar.loadUrl("about:blank");
                if (pn > 0) {
                    View rootView = fxVar.getView().getRootView();
                    if (rootView instanceof ViewGroup) {
                        View childAt = ((ViewGroup) rootView).getChildAt(0);
                        childAt.setDrawingCacheEnabled(true);
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                        childAt.setDrawingCacheEnabled(false);
                        ImageView imageView = new ImageView(activity);
                        imageView.setImageBitmap(bitmapCreateBitmap);
                        imageView.setVisibility(0);
                        ((ViewGroup) rootView).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static boolean u() {
        return u;
    }

    public static void u(final com.bytedance.sdk.component.mv.fx fxVar) {
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xg.2
            @Override // java.lang.Runnable
            public void run() {
                xg.fx(fxVar);
            }
        });
    }
}
