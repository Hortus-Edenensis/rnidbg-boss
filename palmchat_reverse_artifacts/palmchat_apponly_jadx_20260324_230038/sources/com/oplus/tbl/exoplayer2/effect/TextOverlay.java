package com.oplus.tbl.exoplayer2.effect;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public abstract class TextOverlay extends BitmapOverlay {
    public static final int TEXT_SIZE_PIXELS = 100;
    private Bitmap lastBitmap;
    private SpannableString lastText;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(23)
    public static final class Api23 {
        private Api23() {
        }

        @DoNotInline
        public static StaticLayout getStaticLayout(SpannableString spannableString, TextPaint textPaint, int i) {
            return StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, i).build();
        }
    }

    @SuppressLint({"InlinedApi"})
    private StaticLayout createStaticLayout(SpannableString spannableString, TextPaint textPaint, int i) {
        return Util.SDK_INT >= 23 ? Api23.getStaticLayout(spannableString, textPaint, i) : new StaticLayout(spannableString, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public static TextOverlay createStaticTextOverlay(final SpannableString spannableString) {
        return new TextOverlay() { // from class: com.oplus.tbl.exoplayer2.effect.TextOverlay.1
            @Override // com.oplus.tbl.exoplayer2.effect.TextOverlay
            public SpannableString getText(long j) {
                return spannableString;
            }
        };
    }

    private int getSpannedTextWidth(SpannableString spannableString, TextPaint textPaint) {
        StaticLayout staticLayoutCreateStaticLayout = createStaticLayout(spannableString, textPaint, (int) textPaint.measureText(spannableString, 0, spannableString.length()));
        int lineCount = staticLayoutCreateStaticLayout.getLineCount();
        float lineWidth = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            lineWidth += staticLayoutCreateStaticLayout.getLineWidth(i);
        }
        return (int) Math.ceil(lineWidth);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.BitmapOverlay
    public Bitmap getBitmap(long j) {
        SpannableString text = getText(j);
        if (!text.equals(this.lastText)) {
            this.lastText = text;
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(100.0f);
            StaticLayout staticLayoutCreateStaticLayout = createStaticLayout(text, textPaint, getSpannedTextWidth(text, textPaint));
            Bitmap bitmap = this.lastBitmap;
            if (bitmap == null || bitmap.getWidth() != staticLayoutCreateStaticLayout.getWidth() || this.lastBitmap.getHeight() != staticLayoutCreateStaticLayout.getHeight()) {
                this.lastBitmap = Bitmap.createBitmap(staticLayoutCreateStaticLayout.getWidth(), staticLayoutCreateStaticLayout.getHeight(), Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas((Bitmap) Assertions.checkNotNull(this.lastBitmap));
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            staticLayoutCreateStaticLayout.draw(canvas);
        }
        return (Bitmap) Assertions.checkNotNull(this.lastBitmap);
    }

    public abstract SpannableString getText(long j);

    public static TextOverlay createStaticTextOverlay(final SpannableString spannableString, final OverlaySettings overlaySettings) {
        return new TextOverlay() { // from class: com.oplus.tbl.exoplayer2.effect.TextOverlay.2
            @Override // com.oplus.tbl.exoplayer2.effect.TextureOverlay
            public OverlaySettings getOverlaySettings(long j) {
                return overlaySettings;
            }

            @Override // com.oplus.tbl.exoplayer2.effect.TextOverlay
            public SpannableString getText(long j) {
                return spannableString;
            }
        };
    }
}
