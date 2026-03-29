package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.Util;
import com.zenmen.palmchat.c;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class nc2 extends BitmapTransformation {
    public static final String b = "nc2";
    public static final byte[] c = nc2.class.getName().getBytes(Key.CHARSET);
    public static int d = me1.a(c.b(), 10.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientDrawable f19489a;

    public nc2(GradientDrawable gradientDrawable) {
        this.f19489a = gradientDrawable;
    }

    public final int a() {
        return Build.VERSION.SDK_INT >= 24 ? (int) this.f19489a.getCornerRadius() : d;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(b.hashCode(), this.f19489a.hashCode());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Bitmap bitmapRoundedCorners = TransformationUtils.roundedCorners(bitmapPool, bitmap, a());
        Canvas canvas = new Canvas(bitmapRoundedCorners);
        this.f19489a.setBounds(0, 0, bitmapRoundedCorners.getWidth(), bitmapRoundedCorners.getHeight());
        this.f19489a.draw(canvas);
        canvas.setBitmap(null);
        return bitmapRoundedCorners;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f19489a.hashCode()).array());
    }
}
