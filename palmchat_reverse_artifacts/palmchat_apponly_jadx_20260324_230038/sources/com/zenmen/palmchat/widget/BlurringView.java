package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class BlurringView extends View {
    private Bitmap mBitmapToBlur;
    private Allocation mBlurInput;
    private Allocation mBlurOutput;
    private ScriptIntrinsicBlur mBlurScript;
    private Bitmap mBlurredBitmap;
    private View mBlurredView;
    private int mBlurredViewHeight;
    private int mBlurredViewWidth;
    private Canvas mBlurringCanvas;
    private int mDownsampleFactor;
    private boolean mDownsampleFactorChanged;
    private int mOverlayColor;
    private RenderScript mRenderScript;

    @RequiresApi(api = 17)
    public BlurringView(Context context) {
        this(context, null);
    }

    @RequiresApi(api = 17)
    private void initializeRenderScript(Context context) {
        try {
            RenderScript renderScriptCreate = RenderScript.create(context);
            this.mRenderScript = renderScriptCreate;
            this.mBlurScript = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        } catch (Exception unused) {
        }
    }

    @RequiresApi(api = 17)
    public void blur() {
        try {
            this.mBlurInput.copyFrom(this.mBitmapToBlur);
            this.mBlurScript.setInput(this.mBlurInput);
            this.mBlurScript.forEach(this.mBlurOutput);
            this.mBlurOutput.copyTo(this.mBlurredBitmap);
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            RenderScript renderScript = this.mRenderScript;
            if (renderScript != null) {
                renderScript.destroy();
            }
        } catch (Exception e) {
            Log.e("BlurringView", "destroy exception.", e);
        }
    }

    @Override // android.view.View
    @RequiresApi(api = 17)
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            if (this.mBlurredView != null) {
                if (prepare()) {
                    if (this.mBlurredView.getBackground() == null || !(this.mBlurredView.getBackground() instanceof ColorDrawable)) {
                        this.mBitmapToBlur.eraseColor(0);
                    } else {
                        this.mBitmapToBlur.eraseColor(((ColorDrawable) this.mBlurredView.getBackground()).getColor());
                    }
                    this.mBlurredView.draw(this.mBlurringCanvas);
                    blur();
                    canvas.save();
                    canvas.translate(this.mBlurredView.getX() - getX(), this.mBlurredView.getY() - getY());
                    int i = this.mDownsampleFactor;
                    canvas.scale(i, i);
                    canvas.drawBitmap(this.mBlurredBitmap, 0.0f, 0.0f, (Paint) null);
                    canvas.restore();
                }
                canvas.drawColor(this.mOverlayColor);
            }
        } catch (Exception unused) {
        }
    }

    public boolean prepare() {
        try {
            int width = this.mBlurredView.getWidth();
            int height = this.mBlurredView.getHeight();
            if (this.mBlurringCanvas == null || this.mDownsampleFactorChanged || this.mBlurredViewWidth != width || this.mBlurredViewHeight != height) {
                this.mDownsampleFactorChanged = false;
                this.mBlurredViewWidth = width;
                this.mBlurredViewHeight = height;
                int i = this.mDownsampleFactor;
                int i2 = width / i;
                int i3 = height / i;
                int i4 = (i2 - (i2 % 4)) + 4;
                int i5 = (i3 - (i3 % 4)) + 4;
                Bitmap bitmap = this.mBlurredBitmap;
                if (bitmap == null || bitmap.getWidth() != i4 || this.mBlurredBitmap.getHeight() != i5) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                    this.mBitmapToBlur = bitmapCreateBitmap;
                    if (bitmapCreateBitmap == null) {
                        return false;
                    }
                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                    this.mBlurredBitmap = bitmapCreateBitmap2;
                    if (bitmapCreateBitmap2 == null) {
                        return false;
                    }
                }
                Canvas canvas = new Canvas(this.mBitmapToBlur);
                this.mBlurringCanvas = canvas;
                int i6 = this.mDownsampleFactor;
                canvas.scale(1.0f / i6, 1.0f / i6);
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.mRenderScript, this.mBitmapToBlur, Allocation.MipmapControl.MIPMAP_NONE, 1);
                this.mBlurInput = allocationCreateFromBitmap;
                this.mBlurOutput = Allocation.createTyped(this.mRenderScript, allocationCreateFromBitmap.getType());
            }
        } catch (Exception unused) {
        }
        return true;
    }

    @RequiresApi(api = 17)
    public void setBlurRadius(int i) {
        try {
            this.mBlurScript.setRadius(i);
        } catch (Exception unused) {
        }
    }

    public void setBlurredView(View view) {
        this.mBlurredView = view;
    }

    public void setDownsampleFactor(int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("Downsample factor must be greater than 0.");
            }
            if (this.mDownsampleFactor != i) {
                this.mDownsampleFactor = i;
                this.mDownsampleFactorChanged = true;
            }
        } catch (Exception unused) {
        }
    }

    public void setOverlayColor(int i) {
        this.mOverlayColor = i;
    }

    @RequiresApi(api = 17)
    public BlurringView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int color = Color.parseColor("#00FFFFFF");
        try {
            initializeRenderScript(context);
            setBlurRadius(2);
            setDownsampleFactor(4);
            setOverlayColor(color);
        } catch (Exception unused) {
        }
    }
}
