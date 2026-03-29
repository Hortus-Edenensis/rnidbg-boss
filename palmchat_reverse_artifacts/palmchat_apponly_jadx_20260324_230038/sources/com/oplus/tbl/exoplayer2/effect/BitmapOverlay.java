package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.Matrix;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public abstract class BitmapOverlay extends TextureOverlay {
    private final float[] flipVerticallyMatrix;
    private Bitmap lastBitmap;
    private int lastBitmapGenerationId;
    private int lastTextureId;

    public BitmapOverlay() {
        float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
        Matrix.scaleM(fArrCreate4x4IdentityMatrix, 0, 1.0f, -1.0f, 1.0f);
        this.flipVerticallyMatrix = fArrCreate4x4IdentityMatrix;
        this.lastTextureId = -1;
    }

    public static BitmapOverlay createStaticBitmapOverlay(Context context, Uri uri, final OverlaySettings overlaySettings) {
        return new BitmapOverlay() { // from class: com.oplus.tbl.exoplayer2.effect.BitmapOverlay.3
            private Bitmap lastBitmap;

            @Override // com.oplus.tbl.exoplayer2.effect.BitmapOverlay
            public Bitmap getBitmap(long j) throws VideoFrameProcessingException {
                return this.lastBitmap;
            }

            @Override // com.oplus.tbl.exoplayer2.effect.TextureOverlay
            public OverlaySettings getOverlaySettings(long j) {
                return overlaySettings;
            }
        };
    }

    public abstract Bitmap getBitmap(long j) throws VideoFrameProcessingException;

    @Override // com.oplus.tbl.exoplayer2.effect.TextureOverlay
    public int getTextureId(long j) throws VideoFrameProcessingException {
        Bitmap bitmap = getBitmap(j);
        int generationId = bitmap.getGenerationId();
        if (bitmap != this.lastBitmap || generationId != this.lastBitmapGenerationId) {
            this.lastBitmap = bitmap;
            this.lastBitmapGenerationId = generationId;
            try {
                if (this.lastTextureId == -1) {
                    this.lastTextureId = GlUtil.generateTexture();
                }
                GlUtil.setTexture(this.lastTextureId, bitmap);
            } catch (GlUtil.GlException e) {
                throw new VideoFrameProcessingException(e);
            }
        }
        return this.lastTextureId;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureOverlay
    public Size getTextureSize(long j) {
        return new Size(((Bitmap) Assertions.checkNotNull(this.lastBitmap)).getWidth(), ((Bitmap) Assertions.checkNotNull(this.lastBitmap)).getHeight());
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureOverlay
    public float[] getVertexTransformation(long j) {
        return this.flipVerticallyMatrix;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.TextureOverlay
    public void release() throws VideoFrameProcessingException {
        super.release();
        this.lastBitmap = null;
        int i = this.lastTextureId;
        if (i != -1) {
            try {
                GlUtil.deleteTexture(i);
            } catch (GlUtil.GlException e) {
                throw new VideoFrameProcessingException(e);
            }
        }
        this.lastTextureId = -1;
    }

    public static BitmapOverlay createStaticBitmapOverlay(final Bitmap bitmap) {
        return new BitmapOverlay() { // from class: com.oplus.tbl.exoplayer2.effect.BitmapOverlay.1
            @Override // com.oplus.tbl.exoplayer2.effect.BitmapOverlay
            public Bitmap getBitmap(long j) {
                return bitmap;
            }
        };
    }

    public static BitmapOverlay createStaticBitmapOverlay(final Bitmap bitmap, final OverlaySettings overlaySettings) {
        return new BitmapOverlay() { // from class: com.oplus.tbl.exoplayer2.effect.BitmapOverlay.2
            @Override // com.oplus.tbl.exoplayer2.effect.BitmapOverlay
            public Bitmap getBitmap(long j) {
                return bitmap;
            }

            @Override // com.oplus.tbl.exoplayer2.effect.TextureOverlay
            public OverlaySettings getOverlaySettings(long j) {
                return overlaySettings;
            }
        };
    }
}
