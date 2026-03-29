package com.zenmen.palmchat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import defpackage.a46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TabCellView5 extends TabCellView2 {
    private WaveView mWaveView;

    public TabCellView5(@NonNull Context context) {
        this(context, null);
    }

    public void calculateParams() {
        float fB = a46.m(getContext()).x - a46.b(getContext(), 3.0f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = (int) (fB / 4.5f);
        setLayoutParams(layoutParams);
        float f = (layoutParams.width * 56) / 82;
        ViewGroup.LayoutParams layoutParams2 = this.cellIcon.getLayoutParams();
        int i = (int) f;
        layoutParams2.width = i;
        layoutParams2.height = i;
        this.cellIcon.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.mWaveView.getLayoutParams();
        int iB = a46.b(getContext(), 20.0f);
        layoutParams3.width = layoutParams2.width + iB;
        layoutParams3.height = layoutParams2.height + iB;
        this.mWaveView.setLayoutParams(layoutParams3);
        this.mWaveView.setInitialRadius(layoutParams2.width / 2);
        this.mWaveView.setMaxRadius(layoutParams3.width / 2);
    }

    @Override // com.zenmen.palmchat.widget.TabCellView2
    public RelativeLayout getCellLayout() {
        View childAt = getChildAt(0);
        return childAt instanceof RelativeLayout ? (RelativeLayout) childAt : super.getCellLayout();
    }

    @Override // com.zenmen.palmchat.widget.TabCellView2
    public int getLayoutId() {
        return R.layout.layout_cell_view_tab_item5;
    }

    public WaveView getWaveView() {
        return this.mWaveView;
    }

    @Override // com.zenmen.palmchat.widget.TabCellView2
    public boolean reSizeMargin() {
        return false;
    }

    public TabCellView5(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabCellView5(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWaveView = (WaveView) findViewById(R.id.wave_bg);
    }
}
