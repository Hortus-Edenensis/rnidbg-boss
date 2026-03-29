package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.zenmen.palmchat.framework.R$color;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.gr2;
import defpackage.je1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class VenusBadgeView extends AppCompatImageView {
    private static final float MAX_ASPECT_RATIO_DEFORMATION_FRACTION = 0.01f;
    je1 options;
    private float ratio;

    public VenusBadgeView(Context context) {
        this(context, null);
    }

    private void setRatio(float f) {
        if (this.ratio != f) {
            this.ratio = f;
            requestLayout();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = measuredHeight;
        if (Math.abs((this.ratio / (measuredWidth / f)) - 1.0f) > 0.01f) {
            int i3 = (int) (f * this.ratio);
            LogUtil.d("logvenus", "VenusBadgeView: width = " + i3 + ", height = " + measuredHeight);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    public void setData(String str, int i, int i2) {
        if (TextUtils.isEmpty(str) || i <= 0 || i2 <= 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setRatio((i * 1.0f) / i2);
        gr2.j().h(str, this, this.options);
    }

    public VenusBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ratio = 1.0f;
        je1.a aVarS = new je1.a().s(true);
        int i = R$color.transparent;
        this.options = aVarS.A(i).t(true).q(Bitmap.Config.RGB_565).B(i).z(i).r();
    }
}
