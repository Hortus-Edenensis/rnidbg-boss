package com.zenmen.listui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import defpackage.fh5;
import defpackage.tu4;
import defpackage.wu4;
import defpackage.xu4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class NoneRefreshFooter extends RelativeLayout implements tu4 {
    public NoneRefreshFooter(Context context) {
        super(context);
    }

    @Override // defpackage.vu4
    @NonNull
    public fh5 getSpinnerStyle() {
        return fh5.d;
    }

    @Override // defpackage.vu4
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // defpackage.vu4
    public int onFinish(@NonNull xu4 xu4Var, boolean z) {
        return 0;
    }

    @Override // defpackage.tu4
    public boolean setNoMoreData(boolean z) {
        return true;
    }

    public NoneRefreshFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NoneRefreshFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // defpackage.vu4
    @NonNull
    public View getView() {
        return this;
    }

    @Override // defpackage.vu4
    public void setPrimaryColors(int... iArr) {
    }

    @Override // defpackage.vu4
    public void onHorizontalDrag(float f, int i, int i2) {
    }

    @Override // defpackage.vu4
    public void onInitialized(@NonNull wu4 wu4Var, int i, int i2) {
    }

    @Override // defpackage.vu4
    public void onReleased(@NonNull xu4 xu4Var, int i, int i2) {
    }

    @Override // defpackage.vu4
    public void onStartAnimator(@NonNull xu4 xu4Var, int i, int i2) {
    }

    @Override // defpackage.l74
    public void onStateChanged(@NonNull xu4 xu4Var, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
    }

    @Override // defpackage.vu4
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
    }
}
