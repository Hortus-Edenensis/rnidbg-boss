package com.bytedance.adsdk.lottie.nr;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.adsdk.lottie.fx;
import com.bytedance.adsdk.lottie.model.x;
import com.bytedance.adsdk.lottie.pn.pn;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    private final AssetManager b;
    private fx pn;
    private final x<String> u = new x<>();
    private final Map<x<String>, Typeface> nr = new HashMap();
    private final Map<String, Typeface> fx = new HashMap();
    private String iz = ".ttf";

    public u(Drawable.Callback callback, fx fxVar) {
        this.pn = fxVar;
        if (callback instanceof View) {
            this.b = ((View) callback).getContext().getAssets();
        } else {
            pn.nr("LottieDrawable must be inside of a view for images to work.");
            this.b = null;
        }
    }

    private Typeface nr(com.bytedance.adsdk.lottie.model.fx fxVar) {
        Typeface typefaceCreateFromAsset;
        String strU = fxVar.u();
        Typeface typeface = this.fx.get(strU);
        if (typeface != null) {
            return typeface;
        }
        String strFx = fxVar.fx();
        String strNr = fxVar.nr();
        fx fxVar2 = this.pn;
        if (fxVar2 != null) {
            typefaceCreateFromAsset = fxVar2.u(strU, strFx, strNr);
            if (typefaceCreateFromAsset == null) {
                typefaceCreateFromAsset = this.pn.u(strU);
            }
        } else {
            typefaceCreateFromAsset = null;
        }
        fx fxVar3 = this.pn;
        if (fxVar3 != null && typefaceCreateFromAsset == null) {
            String strNr2 = fxVar3.nr(strU, strFx, strNr);
            if (strNr2 == null) {
                strNr2 = this.pn.nr(strU);
            }
            if (strNr2 != null) {
                try {
                    typefaceCreateFromAsset = Typeface.createFromAsset(this.b, strNr2);
                } catch (Throwable unused) {
                    typefaceCreateFromAsset = Typeface.DEFAULT;
                }
            }
        }
        if (fxVar.b() != null) {
            return fxVar.b();
        }
        if (typefaceCreateFromAsset == null) {
            try {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.b, "fonts/" + strU + this.iz);
            } catch (Throwable unused2) {
                typefaceCreateFromAsset = Typeface.DEFAULT;
            }
        }
        this.fx.put(strU, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    public void u(fx fxVar) {
        this.pn = fxVar;
    }

    public void u(String str) {
        this.iz = str;
    }

    public Typeface u(com.bytedance.adsdk.lottie.model.fx fxVar) {
        this.u.u(fxVar.u(), fxVar.fx());
        Typeface typeface = this.nr.get(this.u);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceU = u(nr(fxVar), fxVar.fx());
        this.nr.put(this.u, typefaceU);
        return typefaceU;
    }

    private Typeface u(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
