package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.adexpress.dynamic.fx.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicPrivacyView extends DynamicBaseWidgetImp {
    private TextView bq;
    private TextView c;
    private TextView dw;
    private TextView nr;
    private LinearLayout q;
    private TextView u;

    public DynamicPrivacyView(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        this.u = new TextView(this.t);
        this.nr = new TextView(this.t);
        this.bq = new TextView(this.t);
        this.q = new LinearLayout(this.t);
        this.dw = new TextView(this.t);
        this.c = new TextView(this.t);
        this.u.setTag(9);
        this.nr.setTag(10);
        this.bq.setTag(12);
        this.q.addView(this.bq);
        this.q.addView(this.c);
        this.q.addView(this.nr);
        this.q.addView(this.dw);
        this.q.addView(this.u);
        addView(this.q, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean fx() {
        this.u.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.u.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.nr.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.nr.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.bq.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.bq.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.x, this.n);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        this.bq.setText("功能");
        this.nr.setText("权限");
        this.dw.setText(" | ");
        this.c.setText(" | ");
        this.u.setText("隐私");
        x xVar = this.l;
        if (xVar != null) {
            this.bq.setTextColor(xVar.x());
            this.bq.setTextSize(this.l.pn());
            this.nr.setTextColor(this.l.x());
            this.nr.setTextSize(this.l.pn());
            this.dw.setTextColor(this.l.x());
            this.c.setTextColor(this.l.x());
            this.u.setTextColor(this.l.x());
            this.u.setTextSize(this.l.pn());
            return false;
        }
        this.bq.setTextColor(-1);
        this.bq.setTextSize(12.0f);
        this.nr.setTextColor(-1);
        this.nr.setTextSize(12.0f);
        this.dw.setTextColor(-1);
        this.c.setTextColor(-1);
        this.u.setTextColor(-1);
        this.u.setTextSize(12.0f);
        return false;
    }
}
