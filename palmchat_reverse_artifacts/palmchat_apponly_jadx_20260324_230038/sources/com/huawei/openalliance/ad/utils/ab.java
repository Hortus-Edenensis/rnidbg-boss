package com.huawei.openalliance.ad.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.huawei.hms.ads.dw;
import com.huawei.hms.ads.fh;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ab {
    private static final byte[] B = new byte[0];
    private static final int I = 31457280;
    private static final String V = "ab";
    private static ab Z;
    LruCache<String, WeakReference<Drawable>> Code;

    private ab() {
        V();
    }

    private void V() {
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        this.Code = new LruCache<String, WeakReference<Drawable>>(Math.min(I, iMaxMemory > 0 ? iMaxMemory / 4 : I)) { // from class: com.huawei.openalliance.ad.utils.ab.1
            @Override // android.util.LruCache
            /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, WeakReference<Drawable> weakReference) {
                Drawable drawable;
                if (weakReference == null || (drawable = weakReference.get()) == null) {
                    return 1;
                }
                if (!(drawable instanceof BitmapDrawable)) {
                    if (drawable instanceof dw) {
                        return ((dw) drawable).I();
                    }
                    return 1;
                }
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap != null) {
                    return bitmap.getByteCount();
                }
                return 1;
            }
        };
    }

    public Drawable Code(String str) {
        try {
            WeakReference<Drawable> weakReference = this.Code.get(str);
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        } catch (Throwable th) {
            fh.I(V, "get cache encounter: " + th.getClass().getSimpleName());
            return null;
        }
    }

    public static ab Code() {
        ab abVar;
        synchronized (B) {
            if (Z == null) {
                Z = new ab();
            }
            abVar = Z;
        }
        return abVar;
    }

    public void Code(String str, Drawable drawable) {
        try {
            this.Code.put(str, new WeakReference<>(drawable));
        } catch (Throwable th) {
            fh.I(V, "put cache encounter: " + th.getClass().getSimpleName());
        }
    }
}
