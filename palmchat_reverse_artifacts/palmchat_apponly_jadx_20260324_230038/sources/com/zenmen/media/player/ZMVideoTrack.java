package com.zenmen.media.player;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.Surface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ZMVideoTrack {
    private final String TAG = "ZMVideoTrack";
    private int mViewWidth = 0;
    private int mViewHeight = 0;
    private Rect mDst = null;
    private Surface mSurface = null;
    private Bitmap mBitmap = null;
    private int mWidthBitmap = 0;
    private int mHeightBitmap = 0;

    private int init(int i, int i2) {
        Log.v("ZMVideoTrack", "Init " + i + "X" + i2);
        if (i != 0 && i2 != 0) {
            if (this.mWidthBitmap == i && this.mHeightBitmap == i2) {
                return 0;
            }
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.mBitmap = null;
            }
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.mBitmap = bitmapCreateBitmap;
                if (bitmapCreateBitmap == null) {
                    Log.e("ZMVideoTrack", "Failed to Create Bitmap buffer");
                    return -1;
                }
                this.mWidthBitmap = i;
                this.mHeightBitmap = i2;
                updateRect();
                Log.v("ZMVideoTrack", "Init OK ");
                return 0;
            } catch (Exception e) {
                Log.e("ZMVideoTrack", "Failed to Create Bitmap buffer on catch! " + e.getMessage());
            }
        }
        return -1;
    }

    private int render() {
        Surface surface = this.mSurface;
        if (surface == null || this.mBitmap == null) {
            return -1;
        }
        try {
            Canvas canvasLockCanvas = surface.lockCanvas(null);
            if (canvasLockCanvas == null) {
                this.mSurface.unlockCanvasAndPost(canvasLockCanvas);
                return -1;
            }
            canvasLockCanvas.drawBitmap(this.mBitmap, (Rect) null, this.mDst, (Paint) null);
            this.mSurface.unlockCanvasAndPost(canvasLockCanvas);
            return 0;
        } catch (Surface.OutOfResourcesException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private void setSurface(Surface surface) {
        this.mSurface = surface;
    }

    private void setViewSize(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
    }

    private void updateRect() {
        int i;
        int i2 = this.mWidthBitmap;
        if (i2 == 0 || (i = this.mHeightBitmap) == 0) {
            return;
        }
        int i3 = this.mViewWidth;
        int i4 = this.mViewHeight;
        if (i3 * i > i2 * i4) {
            int i5 = ((i2 * i4) / i) & (-4);
            int i6 = ((i3 - i5) / 2) & (-4);
            this.mDst = new Rect(i6, 0, i5 + i6, i4 & (-4));
        } else {
            int i7 = (i * i3) / i2;
            int i8 = i3 & (-4);
            int i9 = i7 & (-4);
            int i10 = ((i4 - i9) / 2) & (-4);
            this.mDst = new Rect(0, i10, i8, i9 + i10);
        }
    }
}
