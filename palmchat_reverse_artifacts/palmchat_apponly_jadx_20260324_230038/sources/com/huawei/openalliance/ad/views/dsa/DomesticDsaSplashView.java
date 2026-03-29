package com.huawei.openalliance.ad.views.dsa;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.openalliance.ad.utils.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class DomesticDsaSplashView extends DomesticDsaView {
    private static final int g = 12;
    private static final int h = 5;

    public DomesticDsaSplashView(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.ad.views.dsa.DomesticDsaView, com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code(Context context) {
        super.Code(context);
        View view = this.B;
        if (view != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int iV = z.V(getContext(), 12.0f);
            layoutParams.setMargins(iV, iV, iV, iV);
            this.B.setLayoutParams(layoutParams);
            this.B.setElevation(z.V(getContext(), 5.0f));
        }
    }

    public DomesticDsaSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DomesticDsaSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DomesticDsaSplashView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
