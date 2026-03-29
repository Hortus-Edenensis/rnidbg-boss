package com.bytedance.adsdk.u.u.u;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class mv extends n<com.bytedance.adsdk.u.u.nr.u, com.bytedance.adsdk.u.u.nr.nr> {
    static final /* synthetic */ boolean u = true;

    public mv(com.bytedance.adsdk.u.u.nr.u uVar) {
        super(uVar);
    }

    @Override // com.bytedance.adsdk.u.u.u.n
    public Bitmap u(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.bytedance.adsdk.u.u.nr.nr nrVar) {
        Bitmap bitmapDecodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((com.bytedance.adsdk.u.u.nr.u) this.x).d_();
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.bytedance.adsdk.u.u.nr.u) this.x).pn(), null, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.bytedance.adsdk.u.u.nr.u) this.x).pn(), null, options2);
            }
        } catch (IOException unused2) {
            return bitmap2;
        }
        try {
            if (!u && bitmapDecodeStream == null) {
                throw new AssertionError();
            }
            paint.setXfermode(null);
            canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
            return bitmapDecodeStream;
        } catch (IOException unused3) {
            bitmap2 = bitmapDecodeStream;
            return bitmap2;
        }
    }
}
