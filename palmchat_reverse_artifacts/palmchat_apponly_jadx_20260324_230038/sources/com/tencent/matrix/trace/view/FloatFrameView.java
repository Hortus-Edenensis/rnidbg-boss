package com.tencent.matrix.trace.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.tencent.matrix.batterycanary.R;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class FloatFrameView extends LinearLayout {
    public LineChartView chartView;
    public TextView extraInfoView;
    public TextView fpsView;
    public TextView levelFrozenView;
    public TextView levelHighView;
    public TextView levelMiddleView;
    public TextView levelNormalView;
    public TextView qiWangView;
    public TextView sceneView;
    public TextView sumLevelFrozenView;
    public TextView sumLevelHighView;
    public TextView sumLevelMiddleView;
    public TextView sumLevelNormalView;
    public TextView sumQiWangView;

    public FloatFrameView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(context).inflate(R.layout.float_frame_view, this);
        this.fpsView = (TextView) findViewById(R.id.fps_view);
        this.extraInfoView = (TextView) findViewById(R.id.extra_info);
        this.sceneView = (TextView) findViewById(R.id.scene_view);
        this.extraInfoView.setText("{other info}");
        this.qiWangView = (TextView) findViewById(R.id.qi_wang_tv);
        this.levelFrozenView = (TextView) findViewById(R.id.level_frozen);
        this.levelHighView = (TextView) findViewById(R.id.level_high);
        this.levelMiddleView = (TextView) findViewById(R.id.level_middle);
        this.levelNormalView = (TextView) findViewById(R.id.level_normal);
        this.sumQiWangView = (TextView) findViewById(R.id.sum_qi_wang_tv);
        this.sumLevelFrozenView = (TextView) findViewById(R.id.sum_level_frozen);
        this.sumLevelHighView = (TextView) findViewById(R.id.sum_level_high);
        this.sumLevelMiddleView = (TextView) findViewById(R.id.sum_level_middle);
        this.sumLevelNormalView = (TextView) findViewById(R.id.sum_level_normal);
        this.chartView = (LineChartView) findViewById(R.id.chart);
    }

    public FloatFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class LineChartView extends View {
        private static final int LINE_COUNT = 50;
        private int bestColor;
        private int frozenColor;
        private int grayColor;
        float height;
        private int highColor;
        private final Paint levelLinePaint;
        float lineContentWidth;
        float linePadding;
        float lineStrokeWidth;
        private final LinkedList<LineInfo> lines;
        private int middleColor;
        private Path middlePath;
        private float[] middleTip;
        private int normalColor;
        float padding;
        private final Paint paint;
        float textSize;
        private final Paint tipLinePaint;
        private final TextPaint tipPaint;
        private Path topPath;
        private float[] topTip;
        float width;

        /* JADX INFO: compiled from: SearchBox */
        public class LineInfo {
            int color;
            int fps;
            private float[] linePoint;

            public LineInfo(int i, int i2) {
                this.linePoint = new float[]{LineChartView.this.width, 0.0f, (((60 - i) * LineChartView.this.lineContentWidth) / 60.0f) + (LineChartView.this.getWidth() - LineChartView.this.lineContentWidth), 0.0f};
                this.fps = i;
                this.color = i2;
            }

            public void draw(Canvas canvas, int i) {
                if (LineChartView.this.paint.getColor() != this.color) {
                    LineChartView.this.paint.setColor(this.color);
                }
                float[] fArr = this.linePoint;
                LineChartView lineChartView = LineChartView.this;
                float f = (i + 1) * lineChartView.linePadding;
                fArr[1] = f;
                fArr[3] = f;
                canvas.drawLine(fArr[0], f, fArr[2], f, lineChartView.paint);
            }
        }

        public LineChartView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.topPath = new Path();
            this.middlePath = new Path();
            this.topTip = new float[2];
            this.middleTip = new float[2];
            this.bestColor = getContext().getResources().getColor(R.color.level_best_color);
            this.normalColor = getContext().getResources().getColor(R.color.level_normal_color);
            this.middleColor = getContext().getResources().getColor(R.color.level_middle_color);
            this.highColor = getContext().getResources().getColor(R.color.level_high_color);
            this.frozenColor = getContext().getResources().getColor(R.color.level_frozen_color);
            this.grayColor = getContext().getResources().getColor(R.color.dark_text);
            this.padding = dip2px(getContext(), 8.0f);
            this.paint = new Paint();
            TextPaint textPaint = new TextPaint(1);
            this.tipPaint = textPaint;
            float fDip2px = dip2px(getContext(), 8.0f);
            this.textSize = fDip2px;
            textPaint.setTextSize(fDip2px);
            textPaint.setStrokeWidth(dip2px(getContext(), 1.0f));
            textPaint.setColor(this.grayColor);
            TextPaint textPaint2 = new TextPaint(1);
            this.levelLinePaint = textPaint2;
            textPaint2.setStrokeWidth(dip2px(getContext(), 1.0f));
            textPaint2.setStyle(Paint.Style.STROKE);
            textPaint2.setPathEffect(new DashPathEffect(new float[]{6.0f, 6.0f}, 0.0f));
            Paint paint = new Paint(textPaint);
            this.tipLinePaint = paint;
            paint.setStrokeWidth(dip2px(getContext(), 1.0f));
            paint.setColor(this.grayColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setPathEffect(new DashPathEffect(new float[]{6.0f, 6.0f}, 0.0f));
            this.lines = new LinkedList<>();
        }

        public static int dip2px(Context context, float f) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        private int getColor(int i) {
            return i > 57 ? this.bestColor : i > 51 ? this.normalColor : i > 36 ? this.middleColor : i > 18 ? this.highColor : this.frozenColor;
        }

        public void addFps(int i, int i2) {
            LineInfo lineInfo = new LineInfo(i, i2);
            if (this.lines.size() >= 50) {
                this.lines.removeLast();
            }
            this.lines.addFirst(lineInfo);
            invalidate();
        }

        @Override // android.view.View
        @SuppressLint({"DefaultLocale"})
        public void draw(Canvas canvas) {
            super.draw(canvas);
            int i = 0;
            int i2 = 1;
            for (LineInfo lineInfo : this.lines) {
                i += lineInfo.fps;
                lineInfo.draw(canvas, i2);
                if (i2 % 25 == 0) {
                    Path path = new Path();
                    float f = lineInfo.linePoint[1];
                    path.moveTo(0.0f, f);
                    path.lineTo(getMeasuredHeight(), f);
                    canvas.drawPath(path, this.tipLinePaint);
                    this.tipPaint.setColor(this.grayColor);
                    canvas.drawText((i2 / 5) + "s", 0.0f, this.textSize + f, this.tipPaint);
                    if (i2 > 0) {
                        int i3 = i / i2;
                        this.tipPaint.setColor(getColor(i3));
                        canvas.drawText(i3 + "FPS", 0.0f, f - (this.textSize / 2.0f), this.tipPaint);
                    }
                }
                i2++;
            }
            this.tipPaint.setColor(this.grayColor);
            this.levelLinePaint.setColor(this.normalColor);
            canvas.drawPath(this.topPath, this.levelLinePaint);
            float[] fArr = this.topTip;
            float f2 = fArr[0];
            float f3 = this.textSize;
            canvas.drawText("50", f2 - (f3 / 2.0f), fArr[1] + f3, this.tipPaint);
            this.levelLinePaint.setColor(this.middleColor);
            canvas.drawPath(this.middlePath, this.levelLinePaint);
            float[] fArr2 = this.middleTip;
            float f4 = fArr2[0];
            float f5 = this.textSize;
            canvas.drawText(BaseWrapper.ENTER_ID_TOOLKIT, f4 - (f5 / 2.0f), fArr2[1] + f5, this.tipPaint);
        }

        @Override // android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                this.width = getMeasuredWidth();
                this.height = getMeasuredHeight();
                this.lineContentWidth = this.width - (this.padding * 3.0f);
                float fDip2px = dip2px(getContext(), 1.0f);
                this.lineStrokeWidth = fDip2px;
                this.paint.setStrokeWidth(fDip2px);
                float f = this.lineStrokeWidth * 2.0f;
                this.linePadding = f;
                float f2 = this.lineContentWidth;
                float f3 = f2 / 60.0f;
                float[] fArr = this.topTip;
                float f4 = (10.0f * f3) + (this.width - f2);
                fArr[0] = f4;
                float f5 = (f * 50.0f) + this.padding;
                fArr[1] = f5;
                this.topPath.moveTo(f4, f5);
                this.topPath.lineTo(this.topTip[0], 0.0f);
                float[] fArr2 = this.middleTip;
                float f6 = (f3 * 30.0f) + (this.width - this.lineContentWidth);
                fArr2[0] = f6;
                float f7 = (this.linePadding * 50.0f) + this.padding;
                fArr2[1] = f7;
                this.middlePath.moveTo(f6, f7);
                this.middlePath.lineTo(this.middleTip[0], 0.0f);
            }
        }

        public LineChartView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }
    }
}
