package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class uq2 {
    public static final Object d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21271a;
    public final String b;
    public final Map<String, x83> c;

    public uq2(Drawable.Callback callback, String str, rq2 rq2Var, Map<String, x83> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.b = str;
        } else {
            this.b = str + '/';
        }
        if (callback instanceof View) {
            this.f21271a = ((View) callback).getContext();
            this.c = map;
            d(rq2Var);
        } else {
            m63.c("LottieDrawable must be inside of a view for images to work.");
            this.c = new HashMap();
            this.f21271a = null;
        }
    }

    @Nullable
    public Bitmap a(String str) {
        x83 x83Var = this.c.get(str);
        if (x83Var == null) {
            return null;
        }
        Bitmap bitmapA = x83Var.a();
        if (bitmapA != null) {
            return bitmapA;
        }
        String strB = x83Var.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strB.startsWith("data:") && strB.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strB.substring(strB.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                m63.d("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                return c(str, r86.l(BitmapFactory.decodeStream(this.f21271a.getAssets().open(this.b + strB), null, options), x83Var.e(), x83Var.c()));
            } catch (IllegalArgumentException e2) {
                m63.d("Unable to decode image.", e2);
                return null;
            }
        } catch (IOException e3) {
            m63.d("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f21271a == null) || this.f21271a.equals(context);
    }

    public final Bitmap c(String str, @Nullable Bitmap bitmap) {
        synchronized (d) {
            this.c.get(str).f(bitmap);
        }
        return bitmap;
    }

    @Nullable
    public Bitmap e(String str, @Nullable Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap bitmapA = this.c.get(str).a();
            c(str, bitmap);
            return bitmapA;
        }
        x83 x83Var = this.c.get(str);
        Bitmap bitmapA2 = x83Var.a();
        x83Var.f(null);
        return bitmapA2;
    }

    public void d(@Nullable rq2 rq2Var) {
    }
}
