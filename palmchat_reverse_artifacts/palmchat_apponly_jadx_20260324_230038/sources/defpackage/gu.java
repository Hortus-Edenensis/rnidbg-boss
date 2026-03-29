package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class gu extends wt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17805a;
    public final int b;

    public gu() {
        this(25, 1);
    }

    @Override // defpackage.wt
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = this.b;
        Bitmap bitmap2 = bitmapPool.get(width / i3, height / i3, Bitmap.Config.ARGB_8888);
        a(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        int i4 = this.b;
        canvas.scale(1.0f / i4, 1.0f / i4);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        try {
            return yq4.a(context, bitmap2, this.f17805a);
        } catch (RSRuntimeException unused) {
            return ft1.a(bitmap2, this.f17805a, true);
        }
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof gu) {
            gu guVar = (gu) obj;
            if (guVar.f17805a == this.f17805a && guVar.b == this.b) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 737513610 + (this.f17805a * 1000) + (this.b * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.f17805a + ", sampling=" + this.b + ")";
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.BlurTransformation.1" + this.f17805a + this.b).getBytes(Key.CHARSET));
    }

    public gu(int i, int i2) {
        this.f17805a = i;
        this.b = i2;
    }
}
