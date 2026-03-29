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
/* JADX INFO: loaded from: classes13.dex */
public class y5 extends wt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22123a;
    public final int b;

    public y5() {
        this(25, 1);
    }

    @Override // defpackage.wt
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i3 = this.b;
            Bitmap bitmap2 = bitmapPool.get(width / i3, height / i3, Bitmap.Config.ARGB_8888);
            bitmap2.setDensity(bitmap.getDensity());
            Canvas canvas = new Canvas(bitmap2);
            int i4 = this.b;
            canvas.scale(1.0f / i4, 1.0f / i4);
            Paint paint = new Paint();
            paint.setFlags(2);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return ft1.a(bitmap2, this.f22123a, true);
        } catch (RSRuntimeException unused) {
            return null;
        }
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof y5) {
            y5 y5Var = (y5) obj;
            if (y5Var.f22123a == this.f22123a && y5Var.b == this.b) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (-1063285251) + (this.f22123a * 1000) + (this.b * 10);
    }

    public String toString() {
        return "AdBlurTransformation(radius=" + this.f22123a + ", sampling=" + this.b + ")";
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(("com.zenmen.palmchat.ad.nest.nativead.ui.AdBlurTransformation.1" + this.f22123a + this.b).getBytes(Key.CHARSET));
    }

    public y5(int i, int i2) {
        this.f22123a = i;
        this.b = i2;
    }
}
