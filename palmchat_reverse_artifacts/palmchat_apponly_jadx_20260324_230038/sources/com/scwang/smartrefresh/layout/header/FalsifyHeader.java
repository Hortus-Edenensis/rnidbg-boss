package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.R$string;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import defpackage.nf5;
import defpackage.uu4;
import defpackage.wu4;
import defpackage.xu4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class FalsifyHeader extends InternalAbstract implements uu4 {
    protected wu4 mRefreshKernel;

    public FalsifyHeader(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int iD = nf5.d(5.0f);
            Context context = getContext();
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-858993460);
            paint.setStrokeWidth(nf5.d(1.0f));
            float f = iD;
            paint.setPathEffect(new DashPathEffect(new float[]{f, f, f, f}, 1.0f));
            canvas.drawRect(f, f, getWidth() - iD, getBottom() - iD, paint);
            TextView textView = new TextView(context);
            textView.setText(context.getString(R$string.srl_component_falsify, getClass().getSimpleName(), Float.valueOf(nf5.j(getHeight()))));
            textView.setTextColor(-858993460);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.vu4
    public void onInitialized(@NonNull wu4 wu4Var, int i, int i2) {
        this.mRefreshKernel = wu4Var;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.vu4
    public void onReleased(@NonNull xu4 xu4Var, int i, int i2) {
        if (this.mRefreshKernel != null) {
            xu4Var.closeHeaderOrFooter();
        }
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }
}
