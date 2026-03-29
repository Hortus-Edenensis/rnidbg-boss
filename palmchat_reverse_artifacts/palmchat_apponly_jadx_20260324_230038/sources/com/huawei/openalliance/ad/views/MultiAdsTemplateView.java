package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.al;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MultiAdsTemplateView extends LinearLayout {
    private LinearLayout B;
    private String C;
    private List<View> F;
    private TextView I;
    private Context S;
    private View V;

    public MultiAdsTemplateView(Context context) {
        super(context);
        this.F = new ArrayList();
        this.S = context;
        Code(context);
    }

    private void Code(Context context) {
        View viewInflate = View.inflate(context, R.layout.hiad_multi_ads_template_view, this);
        this.V = viewInflate;
        this.I = (TextView) viewInflate.findViewById(R.id.multi_ads_title);
        this.B = (LinearLayout) this.V.findViewById(R.id.content_layout_view);
        I();
    }

    private void I() {
        Map<String, String> mapAr = eh.Code(this.S).ar();
        if (!al.Code(mapAr) && mapAr.containsKey(this.C)) {
            this.I.setText(bc.V(mapAr.get(this.C)));
        }
    }

    public void V() {
        if (z.C(getContext())) {
            TextView textView = this.I;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.hiad_90_percent_white));
            }
            if (ag.Code(this.F)) {
                return;
            }
            Iterator<View> it = this.F.iterator();
            while (it.hasNext()) {
                it.next().setBackgroundColor(getResources().getColor(R.color.hiad_line_color));
            }
            return;
        }
        TextView textView2 = this.I;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(R.color.hiad_90_percent_black));
        }
        if (ag.Code(this.F)) {
            return;
        }
        Iterator<View> it2 = this.F.iterator();
        while (it2.hasNext()) {
            it2.next().setBackgroundColor(getResources().getColor(R.color.hiad_20_percent_black));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        V();
    }

    public MultiAdsTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = new ArrayList();
        this.S = context;
        Code(context);
    }

    public void Code(View view) {
        view.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout = this.B;
        if (linearLayout != null) {
            linearLayout.addView(view);
        }
    }

    public MultiAdsTemplateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = new ArrayList();
        this.S = context;
        Code(context);
    }
}
