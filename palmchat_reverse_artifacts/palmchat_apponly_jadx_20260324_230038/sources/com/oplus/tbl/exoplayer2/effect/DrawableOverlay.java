package com.oplus.tbl.exoplayer2.effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public abstract class DrawableOverlay extends BitmapOverlay {
    private Bitmap lastBitmap;
    private Drawable lastDrawable;

    public static DrawableOverlay createStaticDrawableOverlay(final Drawable drawable, final OverlaySettings overlaySettings) {
        return new DrawableOverlay() { // from class: com.oplus.tbl.exoplayer2.effect.DrawableOverlay.1
            @Override // com.oplus.tbl.exoplayer2.effect.DrawableOverlay
            public Drawable getDrawable(long j) {
                return drawable;
            }

            @Override // com.oplus.tbl.exoplayer2.effect.TextureOverlay
            public OverlaySettings getOverlaySettings(long j) {
                return overlaySettings;
            }
        };
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BitmapOverlay
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
