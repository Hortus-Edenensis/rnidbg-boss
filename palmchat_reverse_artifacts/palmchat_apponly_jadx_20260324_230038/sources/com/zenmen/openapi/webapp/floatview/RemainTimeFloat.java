package com.zenmen.openapi.webapp.floatview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.R$id;
import com.zenmen.openapi.R$layout;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RemainTimeFloat extends LxRelativeLayout {
    private TextView mTvTimeRemain;

    public RemainTimeFloat(Context context) {
        this(context, null);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.lx_webapp_float_time_remain, this);
        this.mTvTimeRemain = (TextView) findViewById(R$id.lx_webapp_time_remain);
    }

    public void setRemainTime(String str) {
        TextView textView = this.mTvTimeRemain;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public RemainTimeFloat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RemainTimeFloat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public RemainTimeFloat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
