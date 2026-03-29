package com.zenmen.palmchat.ad.compliance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.zenmen.palmchat.framework.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdComInfoAllLayoutNew2 extends AdComInfoLayoutBase {
    public AdComInfoAllLayoutNew2(Context context) {
        super(context);
        initLayout();
    }

    private void initLayout() {
        this.mComplianceLayout = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R$layout.adsdk_cominfo_apphegui_view_new, (ViewGroup) null);
        initView();
    }

    public AdComInfoAllLayoutNew2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initLayout();
    }

    public AdComInfoAllLayoutNew2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initLayout();
    }

    public AdComInfoAllLayoutNew2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initLayout();
    }
}
