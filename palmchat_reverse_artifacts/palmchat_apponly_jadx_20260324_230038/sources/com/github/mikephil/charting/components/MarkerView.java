package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import defpackage.vb3;
import defpackage.vh2;
import defpackage.wm2;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MarkerView extends RelativeLayout implements wm2 {
    private vb3 mOffset;
    private vb3 mOffset2;
    private WeakReference<Chart> mWeakChart;

    public MarkerView(Context context, int i) {
        super(context);
        this.mOffset = new vb3();
        this.mOffset2 = new vb3();
        setupLayoutResource(i);
    }

    private void setupLayoutResource(int i) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(i, this);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        viewInflate.layout(0, 0, viewInflate.getMeasuredWidth(), viewInflate.getMeasuredHeight());
    }

    @Override // defpackage.wm2
    public void draw(Canvas canvas, float f, float f2) {
        vb3 offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f, f2);
        int iSave = canvas.save();
        canvas.translate(f + offsetForDrawingAtPoint.c, f2 + offsetForDrawingAtPoint.d);
        draw(canvas);
        canvas.restoreToCount(iSave);
    }

    public Chart getChartView() {
        WeakReference<Chart> weakReference = this.mWeakChart;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public vb3 getOffset() {
        return this.mOffset;
    }

    public vb3 getOffsetForDrawingAtPoint(float f, float f2) {
        vb3 offset = getOffset();
        vb3 vb3Var = this.mOffset2;
        vb3Var.c = offset.c;
        vb3Var.d = offset.d;
        Chart chartView = getChartView();
        float width = getWidth();
        float height = getHeight();
        vb3 vb3Var2 = this.mOffset2;
        float f3 = vb3Var2.c;
        if (f + f3 < 0.0f) {
            vb3Var2.c = -f;
        } else if (chartView != null && f + width + f3 > chartView.getWidth()) {
            this.mOffset2.c = (chartView.getWidth() - f) - width;
        }
        vb3 vb3Var3 = this.mOffset2;
        float f4 = vb3Var3.d;
        if (f2 + f4 < 0.0f) {
            vb3Var3.d = -f2;
        } else if (chartView != null && f2 + height + f4 > chartView.getHeight()) {
            this.mOffset2.d = (chartView.getHeight() - f2) - height;
        }
        return this.mOffset2;
    }

    @Override // defpackage.wm2
    public void refreshContent(Entry entry, vh2 vh2Var) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public void setChartView(Chart chart) {
        this.mWeakChart = new WeakReference<>(chart);
    }

    public void setOffset(vb3 vb3Var) {
        this.mOffset = vb3Var;
        if (vb3Var == null) {
            this.mOffset = new vb3();
        }
    }

    public void setOffset(float f, float f2) {
        vb3 vb3Var = this.mOffset;
        vb3Var.c = f;
        vb3Var.d = f2;
    }
}
