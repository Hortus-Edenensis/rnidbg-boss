package com.zenmen.palmchat.ad.compliance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.zenmen.palmchat.framework.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdComInfoAllLayoutLine extends AdComInfoLayoutBase {
    public AdComInfoAllLayoutLine(Context context) {
        super(context);
        initLayout();
    }

    private void initLayout() {
        this.mComplianceLayout = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R$layout.adsdk_cominfo_apphegui_view_line, (ViewGroup) null);
        initView();
    }

    public AdComInfoAllLayoutLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initLayout();
    }

    public AdComInfoAllLayoutLine(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initLayout();
    }

    public AdComInfoAllLayoutLine(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initLayout();
    }
}
