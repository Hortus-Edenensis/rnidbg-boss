package androidx.media3.effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public abstract class DrawableOverlay extends BitmapOverlay {
    private Bitmap lastBitmap;
    private Drawable lastDrawable;

    public static DrawableOverlay createStaticDrawableOverlay(final Drawable drawable, final StaticOverlaySettings staticOverlaySettings) {
        return new DrawableOverlay() { // from class: androidx.media3.effect.DrawableOverlay.1
            @Override // androidx.media3.effect.DrawableOverlay
            public Drawable getDrawable(long j) {
                return drawable;
            }

            @Override // androidx.media3.effect.TextureOverlay
            public OverlaySettings getOverlaySettings(long j) {
                return staticOverlaySettings;
            }
        };
    }

    @Override // androidx.media3.effect.BitmapOverlay
    public Bitmap getBitmap(long j) {
        Drawable drawable = getDrawable(j);
        if (!drawable.equals(this.lastDrawable)) {
            this.lastDrawable = drawable;
            Bitmap bitmap = this.lastBitmap;
            if (bitmap == null || bitmap.getWidth() != this.lastDrawable.getIntrinsicWidth() || this.lastBitmap.getHeight() != this.lastDrawable.getIntrinsicHeight()) {
                this.lastBitmap = Bitmap.createBitmap(this.lastDrawable.getIntrinsicWidth(), this.lastDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(this.lastBitmap);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.lastDrawable.draw(canvas);
        }
        return (Bitmap) Assertions.checkNotNull(this.lastBitmap);
    }

    public abstract Drawable getDrawable(long j);
}
