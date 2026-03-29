package com.zenmen.square.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$anim;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$styleable;
import defpackage.fh5;
import defpackage.uu4;
import defpackage.wu4;
import defpackage.xu4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquarePullHeader extends LxRelativeLayout implements uu4 {
    private String finishText;
    private boolean hideSuccess;
    private Animation loadingAnim;
    private View mProgressLayout;
    private TextView mProgressTips;
    private ImageView mProgressView;
    private TextView mTextView;

    public SquarePullHeader(Context context) {
        this(context, null);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.layout_square_pull_header_view, this);
        this.mProgressView = (ImageView) findViewById(R$id.iv_smart_pull_header_progress);
        this.mTextView = (TextView) findViewById(R$id.tv_smart_pull_header);
        this.mProgressTips = (TextView) findViewById(R$id.tv_refresh_tips);
        this.mProgressLayout = findViewById(R$id.rl_refresh_layout_header);
        this.loadingAnim = AnimationUtils.loadAnimation(context, R$anim.square_loading_progress);
    }

    @Override // defpackage.vu4
    @NonNull
    public fh5 getSpinnerStyle() {
        return fh5.d;
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void initAttr(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.header);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.header_finishText);
        this.finishText = string;
        if (TextUtils.isEmpty(string)) {
            this.finishText = "完成刷新";
        }
        this.mTextView.setText(this.finishText);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // defpackage.vu4
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // defpackage.vu4
    public int onFinish(@NonNull xu4 xu4Var, boolean z) {
        this.mProgressView.clearAnimation();
        if (!z || this.hideSuccess) {
            return 10;
        }
        this.mTextView.setVisibility(0);
        return 1000;
    }

    @Override // defpackage.vu4
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        this.mTextView.setVisibility(8);
    }

    @Override // defpackage.vu4
    public void onStartAnimator(@NonNull xu4 xu4Var, int i, int i2) {
        this.mProgressView.startAnimation(this.loadingAnim);
    }

    @Override // defpackage.l74
    public void onStateChanged(@NonNull xu4 xu4Var, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        this.mProgressLayout.setVisibility(0);
        if (refreshState2 == RefreshState.PullDownToRefresh) {
            this.mProgressTips.setText("下拉刷新");
        }
        if (refreshState2 == RefreshState.ReleaseToRefresh) {
            this.mProgressTips.setText("释放更新");
        }
        if (refreshState2 == RefreshState.Refreshing) {
            this.mProgressTips.setText("加载中");
        }
        if (refreshState2 == RefreshState.RefreshFinish) {
            this.mProgressTips.setText("下拉刷新");
            this.mProgressLayout.setVisibility(8);
        }
    }

    public void setHideSuccess(boolean z) {
        this.hideSuccess = z;
    }

    public SquarePullHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SquarePullHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttr(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public SquarePullHeader(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initAttr(context, attributeSet);
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
}
