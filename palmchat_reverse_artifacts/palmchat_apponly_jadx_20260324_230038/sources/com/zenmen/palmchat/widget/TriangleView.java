package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TriangleView extends View {
    private final int BOTTOM;
    private final int LEFT;
    private final int RIGHT;
    private final int TOP;
    private int color;
    private int direction;
    private int height;
    private Paint mPaint;
    private int width;

    public TriangleView(Context context) {
        super(context);
        this.TOP = 0;
        this.BOTTOM = 1;
        this.RIGHT = 2;
        this.LEFT = 3;
        this.mPaint = new Paint();
        this.color = -16777216;
        this.width = 50;
        this.height = 50;
        this.direction = 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.color);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        int i = this.direction;
        if (i == 0) {
            path.moveTo(0.0f, this.width);
            path.lineTo(this.width, this.height);
            path.lineTo(this.width / 2, 0.0f);
        } else if (i == 1) {
            path.moveTo(0.0f, 0.0f);
            path.lineTo(this.width / 2, this.height);
            path.lineTo(this.width, 0.0f);
        } else if (i == 2) {
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, this.height);
            path.lineTo(this.width, this.height / 2);
        } else if (i == 3) {
            path.moveTo(0.0f, this.height / 2);
            path.lineTo(this.width, this.height);
            path.lineTo(this.width, 0.0f);
        }
        path.close();
        canvas.drawPath(path, this.mPaint);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    public TriangleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TOP = 0;
        this.BOTTOM = 1;
        this.RIGHT = 2;
        this.LEFT = 3;
        this.mPaint = new Paint();
        this.color = -16777216;
        this.width = 50;
        this.height = 50;
        this.direction = 0;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TriangleView, 0, 0);
        this.color = typedArrayObtainStyledAttributes.getColor(0, this.color);
        this.width = (int) typedArrayObtainStyledAttributes.getDimension(3, this.width);
        this.height = (int) typedArrayObtainStyledAttributes.getDimension(2, this.height);
        this.direction = typedArrayObtainStyledAttributes.getInt(1, this.direction);
    }
}
