package com.zenmen.palmchat.ui.widget.pullrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PullRefreshFooter extends FrameLayout {
    private TextView loadingText;
    private ImageView loadingView;
    private RotateAnimation rotateAnimation;

    public PullRefreshFooter(Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        View.inflate(context, R$layout.view_ptr_footer, this);
        this.loadingView = (ImageView) findViewById(R$id.iv_loading);
        this.loadingText = (TextView) findViewById(R$id.tv_loading);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.rotateAnimation = rotateAnimation;
        rotateAnimation.setDuration(600L);
        this.rotateAnimation.setInterpolator(new LinearInterpolator());
        this.rotateAnimation.setRepeatCount(-1);
        setVisibility(8);
    }

    public void onFinish() {
        setVisibility(8);
        this.loadingView.clearAnimation();
    }

    public void onNoMoreContent() {
        this.loadingView.clearAnimation();
        this.loadingView.setVisibility(8);
        this.loadingText.setText("无更多内容");
    }

    public void onRefreshing() {
        setVisibility(0);
        this.loadingText.setText("正在加载");
        this.loadingView.startAnimation(this.rotateAnimation);
    }

    public PullRefreshFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullRefreshFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
