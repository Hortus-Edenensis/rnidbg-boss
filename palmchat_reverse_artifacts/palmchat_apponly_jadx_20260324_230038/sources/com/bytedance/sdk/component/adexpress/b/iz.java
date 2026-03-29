package com.bytedance.sdk.component.adexpress.b;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.l;
import defpackage.td;
import defpackage.ud;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static final byte[] u = u("VP8X");

    private static void b(final ImageView imageView, byte[] bArr, int i, int i2) {
        final Bitmap bitmapU = new com.bytedance.sdk.component.iz.fx.nr.u(i, i2, imageView.getScaleType(), Bitmap.Config.RGB_565, i, i2).u(bArr);
        if (bitmapU != null) {
            com.bytedance.sdk.component.utils.jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.b.iz.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapU);
                }
            });
        }
    }

    private static void fx(final ImageView imageView, byte[] bArr, int i, int i2) {
        if (!u(bArr)) {
            b(imageView, bArr, i, i2);
        } else {
            final com.bytedance.adsdk.u.u.u uVarU = com.bytedance.adsdk.u.u.u.u(ByteBuffer.wrap(bArr));
            com.bytedance.sdk.component.utils.jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.b.iz.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageDrawable(uVarU);
                }
            });
        }
    }

    public static void nr(ImageView imageView, byte[] bArr, int i, int i2) {
        try {
            if (imageView instanceof GifView) {
                ((GifView) imageView).u(bArr, false);
                return;
            }
            if (TextUtils.equals("png", l.u(Arrays.copyOfRange(bArr, 0, l.u())))) {
                fx(imageView, bArr, i, i2);
            } else if (u(bArr, 0)) {
                u(imageView, bArr, i, i2);
            } else {
                b(imageView, bArr, i, i2);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static byte[] u(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    public static boolean u(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return u.u(bArr);
    }

    public static void u(final ImageView imageView, byte[] bArr, int i, int i2) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                final Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap));
                com.bytedance.sdk.component.utils.jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.b.iz.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (td.a(drawableDecodeDrawable)) {
                            ud.a(drawableDecodeDrawable).start();
                        }
                        imageView.setImageDrawable(drawableDecodeDrawable);
                    }
                });
                return;
            } catch (IOException unused) {
                return;
            }
        }
        b(imageView, bArr, i, i2);
    }

    public static boolean u(byte[] bArr, int i) {
        try {
            boolean zU = u(bArr, i + 12, u);
            int i2 = i + 20;
            if (bArr.length <= i2) {
                return false;
            }
            boolean z = (bArr[i2] & 2) == 2;
            if (zU && z) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean u(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
