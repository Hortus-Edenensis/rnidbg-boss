package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class er0 extends wt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17343a;
    public final int b;

    public er0() {
        this.f17343a = q86.a(4);
        this.b = -16777216;
    }

    @Override // defpackage.wt
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        Bitmap bitmapCircleCrop = TransformationUtils.circleCrop(bitmapPool, bitmap, i, i2);
        a(bitmap, bitmapCircleCrop);
        Paint paint = new Paint();
        paint.setColor(this.b);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f17343a);
        paint.setAntiAlias(true);
        new Canvas(bitmapCircleCrop).drawCircle(i / 2.0f, i2 / 2.0f, (Math.max(i, i2) / 2.0f) - (this.f17343a / 2.0f), paint);
        return bitmapCircleCrop;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof er0) {
            er0 er0Var = (er0) obj;
            if (er0Var.f17343a == this.f17343a && er0Var.b == this.b) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 882652245 + (this.f17343a * 100) + this.b + 10;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation.1" + this.f17343a + this.b).getBytes(Key.CHARSET));
    }

    public er0(int i, @ColorInt int i2) {
        this.f17343a = i;
        this.b = i2;
    }
}
