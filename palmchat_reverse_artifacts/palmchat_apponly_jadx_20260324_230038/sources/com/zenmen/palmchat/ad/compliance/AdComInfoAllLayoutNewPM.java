package com.zenmen.palmchat.ad.compliance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.zenmen.palmchat.framework.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdComInfoAllLayoutNewPM extends AdComInfoLayoutBase {
    public AdComInfoAllLayoutNewPM(Context context) {
        super(context);
        initLayout();
    }

    private void initLayout() {
        this.mComplianceLayout = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R$layout.adsdk_cominfo_apphegui_view_new_pm, (ViewGroup) null);
        initView();
    }

    public AdComInfoAllLayoutNewPM(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initLayout();
    }

    public AdComInfoAllLayoutNewPM(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initLayout();
    }

    public AdComInfoAllLayoutNewPM(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initLayout();
    }
}
