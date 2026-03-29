package com.zenmen.palmchat.utils.ImageUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase;
import com.zenmen.palmchat.utils.ImageUtils.b;
import defpackage.uy4;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CropImageView extends ImageViewTouchBase {
    Context context;
    ArrayList<b> highlightViews;
    private boolean isMultiDown;
    private float lastX;
    private float lastY;
    private int motionEdge;
    b motionHighlightView;

    public CropImageView(Context context) {
        super(context);
        this.highlightViews = new ArrayList<>();
        this.isMultiDown = false;
    }

    private void centerBasedOnHighlightView(b bVar) {
        Rect rect = bVar.b;
        float fMax = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * getScale());
        if (Math.abs(fMax - getScale()) / fMax > 0.1d) {
            float[] fArr = {bVar.f15708a.centerX(), bVar.f15708a.centerY()};
            getUnrotatedMatrix().mapPoints(fArr);
            zoomTo(fMax, fArr[0], fArr[1], 300.0f);
        }
        ensureVisible(bVar);
    }

    private void ensureVisible(b bVar) {
        Rect rect = bVar.b;
        int iMax = Math.max(0, getLeft() - rect.left);
        int iMin = Math.min(0, getRight() - rect.right);
        int iMax2 = Math.max(0, getTop() - rect.top);
        int iMin2 = Math.min(0, getBottom() - rect.bottom);
        if (iMax == 0) {
            iMax = iMin;
        }
        if (iMax2 == 0) {
            iMax2 = iMin2;
        }
        if (iMax == 0 && iMax2 == 0) {
            return;
        }
        panBy(iMax, iMax2);
    }

    public void add(b bVar) {
        this.highlightViews.add(bVar);
        invalidate();
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase
    public /* bridge */ /* synthetic */ Matrix getUnrotatedMatrix() {
        return super.getUnrotatedMatrix();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator<b> it = this.highlightViews.iterator();
        while (it.hasNext()) {
            it.next().c(canvas);
        }
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bitmapDisplayed.a() != null) {
            for (b bVar : this.highlightViews) {
                bVar.c.set(getUnrotatedMatrix());
                bVar.m();
                if (bVar.k()) {
                    centerBasedOnHighlightView(bVar);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            this.isMultiDown = true;
        }
        if (((CropImageActivity) this.context).X1()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            Iterator<b> it = this.highlightViews.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                int iG = next.g(motionEvent.getX(), motionEvent.getY());
                if (iG != 1) {
                    this.motionEdge = iG;
                    this.motionHighlightView = next;
                    this.lastX = motionEvent.getX();
                    this.lastY = motionEvent.getY();
                    this.motionHighlightView.q(iG == 32 ? b.EnumC1121b.Move : b.EnumC1121b.Grow);
                }
            }
        } else if (action == 1) {
            this.isMultiDown = false;
            b bVar = this.motionHighlightView;
            if (bVar != null) {
                centerBasedOnHighlightView(bVar);
                this.motionHighlightView.q(b.EnumC1121b.None);
            }
            this.motionHighlightView = null;
        } else if (action == 2) {
            if (this.isMultiDown) {
                return true;
            }
            b bVar2 = this.motionHighlightView;
            if (bVar2 != null) {
                bVar2.j(this.motionEdge, motionEvent.getX() - this.lastX, motionEvent.getY() - this.lastY);
                this.lastX = motionEvent.getX();
                this.lastY = motionEvent.getY();
                ensureVisible(this.motionHighlightView);
            }
        }
        int action2 = motionEvent.getAction();
        if (action2 == 1) {
            center(true, true);
        } else if (action2 == 2 && getScale() == 1.0f) {
            center(true, true);
        }
        return true;
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase
    public void postTranslate(float f, float f2) {
        super.postTranslate(f, f2);
        for (b bVar : this.highlightViews) {
            bVar.c.postTranslate(f, f2);
            bVar.m();
        }
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase, android.widget.ImageView
    public /* bridge */ /* synthetic */ void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageBitmapResetBase(Bitmap bitmap, boolean z) {
        super.setImageBitmapResetBase(bitmap, z);
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageRotateBitmapResetBase(uy4 uy4Var, boolean z) {
        super.setImageRotateBitmapResetBase(uy4Var, z);
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setRecycler(ImageViewTouchBase.c cVar) {
        super.setRecycler(cVar);
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase
    public void zoomIn() {
        super.zoomIn();
        for (b bVar : this.highlightViews) {
            bVar.c.set(getUnrotatedMatrix());
            bVar.m();
        }
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase
    public void zoomOut() {
        super.zoomOut();
        for (b bVar : this.highlightViews) {
            bVar.c.set(getUnrotatedMatrix());
            bVar.m();
        }
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase
    public void zoomTo(float f, float f2, float f3) {
        super.zoomTo(f, f2, f3);
        for (b bVar : this.highlightViews) {
            bVar.c.set(getUnrotatedMatrix());
            bVar.m();
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.highlightViews = new ArrayList<>();
        this.isMultiDown = false;
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.highlightViews = new ArrayList<>();
        this.isMultiDown = false;
    }
}
