package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.TextureView;
import android.view.View;
import com.bytedance.adsdk.lottie.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class VideoFrame extends View {
    private RenderScript b;
    private final a.u.C0163u fx;
    private long iz;
    private int n;
    private final Matrix nr;
    private ScriptIntrinsicBlur pn;
    private final TextureView u;
    private Bitmap x;

    public VideoFrame(Context context, TextureView textureView, a.u.C0163u c0163u) {
        super(context);
        this.iz = -1L;
        this.x = null;
        this.n = 0;
        this.u = textureView;
        this.nr = new Matrix();
        this.fx = c0163u;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RenderScript renderScript = this.b;
        if (renderScript != null) {
            renderScript.destroy();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.pn;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        RenderScript renderScriptCreate = RenderScript.create(getContext());
        this.b = renderScriptCreate;
        this.pn = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.x;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.x.recycle();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.pn;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.pn = null;
        }
        RenderScript renderScript = this.b;
        if (renderScript != null) {
            renderScript.destroy();
            this.b = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.iz >= 40) {
            this.iz = jElapsedRealtime;
            TextureView textureView = this.u;
            if (textureView != null && textureView.isAvailable()) {
                float width = this.u.getWidth() / 160.0f;
                if (width > 0.0f) {
                    this.n = (int) (this.u.getHeight() / width);
                }
                int i = this.n;
                if (i > 0 && (bitmap2 = this.u.getBitmap(160, i)) != null) {
                    Bitmap bitmap3 = this.x;
                    if (bitmap3 != null && !bitmap3.isRecycled()) {
                        this.x.recycle();
                    }
                    this.x = u(bitmap2, this.fx.u);
                    bitmap2.recycle();
                }
            }
        }
        if (this.n <= 0 || (bitmap = this.x) == null || bitmap.isRecycled()) {
            return;
        }
        canvas.save();
        this.nr.reset();
        this.nr.setScale(getWidth() / 160.0f, getHeight() / this.n);
        canvas.concat(this.nr);
        canvas.drawBitmap(this.x, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
    }

    public Bitmap u(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap;
        try {
            RenderScript renderScript = this.b;
            if (renderScript != null && this.pn != null) {
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                Allocation allocationCreateTyped = Allocation.createTyped(this.b, allocationCreateFromBitmap.getType());
                this.pn.setRadius(f);
                this.pn.setInput(allocationCreateFromBitmap);
                this.pn.forEach(allocationCreateTyped);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap);
                try {
                    allocationCreateTyped.copyTo(bitmapCreateBitmap);
                    allocationCreateTyped.destroy();
                    allocationCreateFromBitmap.destroy();
                    return bitmapCreateBitmap;
                } catch (Throwable unused) {
                    if (bitmapCreateBitmap != null) {
                        bitmapCreateBitmap.recycle();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable unused2) {
            bitmapCreateBitmap = null;
        }
    }
}
