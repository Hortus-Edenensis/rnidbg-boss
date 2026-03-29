package com.bytedance.adsdk.lottie.nr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.b;
import com.bytedance.adsdk.lottie.pn.pn;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr {
    private static final Object u = new Object();
    private b b;
    private final String fx;
    private final Context nr;
    private final Map<String, a> pn;

    public nr(Drawable.Callback callback, String str, b bVar, Map<String, a> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.fx = str;
        } else {
            this.fx = str + '/';
        }
        this.pn = map;
        u(bVar);
        if (callback instanceof View) {
            this.nr = ((View) callback).getContext().getApplicationContext();
        } else {
            this.nr = null;
        }
    }

    private Bitmap nr(String str, Bitmap bitmap) {
        synchronized (u) {
        }
        return bitmap;
    }

    public void u(b bVar) {
        this.b = bVar;
    }

    public Bitmap u(String str, Bitmap bitmap) {
        if (bitmap != null) {
            return this.pn.get(str).k();
        }
        a aVar = this.pn.get(str);
        Bitmap bitmapK = aVar.k();
        aVar.u(null);
        return bitmapK;
    }

    public Bitmap u(String str) {
        a aVar = this.pn.get(str);
        if (aVar == null) {
            return null;
        }
        Bitmap bitmapK = aVar.k();
        if (bitmapK != null) {
            return bitmapK;
        }
        b bVar = this.b;
        if (bVar != null) {
            return bVar.u(aVar);
        }
        Context context = this.nr;
        if (context == null) {
            return null;
        }
        String strMv = aVar.mv();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strMv.startsWith("data:") && strMv.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strMv.substring(strMv.indexOf(44) + 1), 0);
                return nr(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                pn.u("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.fx)) {
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.fx + strMv), null, options);
                    if (bitmapDecodeStream == null) {
                        pn.nr("Decoded image `" + str + "` is null.");
                        return null;
                    }
                    return nr(str, com.bytedance.adsdk.lottie.pn.a.u(bitmapDecodeStream, aVar.u(), aVar.nr()));
                } catch (IllegalArgumentException e2) {
                    pn.u("Unable to decode image `" + str + "`.", e2);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e3) {
            pn.u("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean u(Context context) {
        return (context == null && this.nr == null) || this.nr.equals(context);
    }
}
