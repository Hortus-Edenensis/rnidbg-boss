package com.zenmen.listui.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.zenmen.palmchat.widget.RhythmView;
import defpackage.a46;
import defpackage.fh5;
import defpackage.uu4;
import defpackage.wu4;
import defpackage.xu4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class PullRefreshHeader extends RelativeLayout implements uu4 {
    public PullRefreshHeader(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        RhythmView rhythmView = new RhythmView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a46.b(context, 21.0f), a46.b(context, 30.0f));
        layoutParams.addRule(13, -1);
        addView(rhythmView, layoutParams);
        rhythmView.setCandidate(new int[]{5, 20, 10}).setRoundRadius(2.0f).setColor(Color.parseColor("#FFD330")).setStripe(3.0f, 25.0f, 5.0f).setFreq(30L).setMinHeight(7.0f).setMaxHeight(20.0f).init();
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

    public PullRefreshHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullRefreshHeader(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PullRefreshHeader(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
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
