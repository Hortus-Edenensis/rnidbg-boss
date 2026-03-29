package io.togoto.imagezoomcrop.cropoverlay;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import io.togoto.imagezoomcrop.R;
import io.togoto.imagezoomcrop.cropoverlay.edge.Edge;
import io.togoto.imagezoomcrop.cropoverlay.utils.PaintUtil;
import io.togoto.imagezoomcrop.photoview.IGetImageBounds;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CropOverlayView extends View implements IGetImageBounds {
    private static final int DEFAULT_CORNER_RADIUS = 6;
    private static final int DEFAULT_OVERLAY_COLOR = Color.argb(204, 41, 48, 63);
    private int DEFAULT_CROPWIDTH;
    private boolean DEFAULT_GUIDELINES;
    private int DEFAULT_MARGINSIDE;
    private int DEFAULT_MARGINTOP;
    private int DEFAULT_MAX_WIDTH;
    private int DEFAULT_MIN_WIDTH;
    private Paint mBackgroundPaint;
    private RectF mBitmapRect;
    private Paint mBorderPaint;
    private Path mClipPath;
    private Context mContext;
    private int mCornerRadius;
    private int mCropHeight;
    private int mCropWidth;
    private Paint mGuidelinePaint;
    private boolean mGuidelines;
    private int mMarginSide;
    private int mMarginTop;
    private int mMaxWidth;
    private int mMinWidth;
    private int mOverlayColor;
    private float ratio;

    public CropOverlayView(Context context) {
        super(context);
        this.DEFAULT_GUIDELINES = true;
        this.DEFAULT_MARGINTOP = 100;
        this.DEFAULT_MARGINSIDE = 50;
        this.DEFAULT_MIN_WIDTH = 500;
        this.DEFAULT_MAX_WIDTH = 700;
        this.DEFAULT_CROPWIDTH = 600;
        this.mCropHeight = 600;
        this.mCropWidth = 600;
        this.ratio = 1.0f;
        init(context);
        this.mContext = context;
    }

    private void drawRuleOfThirdsGuidelines(Canvas canvas) {
        float coordinate = Edge.LEFT.getCoordinate();
        float coordinate2 = Edge.TOP.getCoordinate();
        float coordinate3 = Edge.RIGHT.getCoordinate();
        float coordinate4 = Edge.BOTTOM.getCoordinate();
        float width = Edge.getWidth() / 3.0f;
        float f = coordinate + width;
        canvas.drawLine(f, coordinate2, f, coordinate4, this.mGuidelinePaint);
        float f2 = coordinate3 - width;
        canvas.drawLine(f2, coordinate2, f2, coordinate4, this.mGuidelinePaint);
        float height = Edge.getHeight() / 3.0f;
        float f3 = coordinate2 + height;
        canvas.drawLine(coordinate, f3, coordinate3, f3, this.mGuidelinePaint);
        float f4 = coordinate4 - height;
        canvas.drawLine(coordinate, f4, coordinate3, f4, this.mGuidelinePaint);
    }

    private void init(Context context) {
        this.mBackgroundPaint = PaintUtil.newBackgroundPaint(context);
        this.mBorderPaint = PaintUtil.newBorderPaint(context);
        this.mGuidelinePaint = PaintUtil.newGuidelinePaint();
    }

    private void setEdge(int i, int i2) {
        int iMin = Math.min(i, i2);
        int i3 = this.mMarginSide;
        int i4 = iMin - (i3 * 2);
        this.mCropWidth = i4;
        int i5 = (int) (i4 / this.ratio);
        this.mCropHeight = i5;
        int i6 = (i2 - i5) / 2;
        this.mMarginTop = i6;
        int i7 = i5 + i6;
        int i8 = i4 + i3;
        float f = i6;
        Edge.TOP.setCoordinate(f);
        float f2 = i7;
        Edge.BOTTOM.setCoordinate(f2);
        float f3 = i3;
        Edge.LEFT.setCoordinate(f3);
        float f4 = i8;
        Edge.RIGHT.setCoordinate(f4);
        this.mBitmapRect = new RectF(f3, f, f4, f2);
        this.mClipPath = new Path();
    }

    @Override // io.togoto.imagezoomcrop.photoview.IGetImageBounds
    public Rect getImageBounds() {
        return new Rect((int) Edge.LEFT.getCoordinate(), (int) Edge.TOP.getCoordinate(), (int) Edge.RIGHT.getCoordinate(), (int) Edge.BOTTOM.getCoordinate());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(1, null);
        canvas.save();
        this.mBitmapRect.left = Edge.LEFT.getCoordinate();
        this.mBitmapRect.top = Edge.TOP.getCoordinate();
        this.mBitmapRect.right = Edge.RIGHT.getCoordinate();
        this.mBitmapRect.bottom = Edge.BOTTOM.getCoordinate();
        Path path = this.mClipPath;
        RectF rectF = this.mBitmapRect;
        int i = this.mCornerRadius;
        path.addRoundRect(rectF, i, i, Path.Direction.CW);
        try {
            canvas.clipPath(this.mClipPath, Region.Op.DIFFERENCE);
        } catch (UnsupportedOperationException unused) {
        }
        canvas.drawColor(this.mOverlayColor);
        this.mClipPath.reset();
        canvas.restore();
        RectF rectF2 = this.mBitmapRect;
        int i2 = this.mCornerRadius;
        canvas.drawRoundRect(rectF2, i2, i2, this.mBorderPaint);
        if (this.mGuidelines) {
            drawRuleOfThirdsGuidelines(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setEdge(i, i2);
    }

    public void setRatio(float f) {
        this.ratio = f;
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DEFAULT_GUIDELINES = true;
        this.DEFAULT_MARGINTOP = 100;
        this.DEFAULT_MARGINSIDE = 50;
        this.DEFAULT_MIN_WIDTH = 500;
        this.DEFAULT_MAX_WIDTH = 700;
        this.DEFAULT_CROPWIDTH = 600;
        this.mCropHeight = 600;
        this.mCropWidth = 600;
        this.ratio = 1.0f;
        this.mContext = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CropOverlayView, 0, 0);
        try {
            this.mGuidelines = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CropOverlayView_guideLines, this.DEFAULT_GUIDELINES);
            this.mMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CropOverlayView_marginTop, this.DEFAULT_MARGINTOP);
            this.mMarginSide = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CropOverlayView_marginSide, this.DEFAULT_MARGINSIDE);
            this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CropOverlayView_minWidth, this.DEFAULT_MIN_WIDTH);
            this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CropOverlayView_maxWidth, this.DEFAULT_MAX_WIDTH);
            this.mCornerRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CropOverlayView_cornerRadius, (int) TypedValue.applyDimension(1, 6.0f, this.mContext.getResources().getDisplayMetrics()));
            this.mOverlayColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CropOverlayView_overlayColor, DEFAULT_OVERLAY_COLOR);
            typedArrayObtainStyledAttributes.recycle();
            init(context);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
