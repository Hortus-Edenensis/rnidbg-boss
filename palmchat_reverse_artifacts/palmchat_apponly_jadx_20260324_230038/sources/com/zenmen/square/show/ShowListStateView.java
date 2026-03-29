package com.zenmen.square.show;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.listui.list.PageState;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$anim;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import defpackage.mm2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ShowListStateView extends LxRelativeLayout implements View.OnClickListener, mm2 {
    public static final int EVENT_ID_OPT_CLICK = 1;
    public static final int EVENT_ID_REFRESH = 2;
    protected Animation loadingAnim;
    private ImageView mIvError;
    private ImageView mIvLoading;
    protected PageState mState;
    private TextView mTvEmpty;
    private TextView mTvError;
    private TextView mTvOpBtn;

    public ShowListStateView(Context context) {
        super(context);
        this.mState = new PageState(PageState.State.LOADING, null);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        LayoutInflater.from(context).inflate(R$layout.layout_show_list_state_view, (ViewGroup) this, true);
        this.mTvEmpty = (TextView) findViewById(R$id.tv_square_load_state_text);
        this.mTvError = (TextView) findViewById(R$id.tv_error_state);
        TextView textView = (TextView) findViewById(R$id.btn_operator);
        this.mTvOpBtn = textView;
        textView.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R$id.iv_error_state);
        this.mIvError = imageView;
        imageView.setOnClickListener(this);
        this.mIvLoading = (ImageView) findViewById(R$id.iv_page_state_loading);
        this.loadingAnim = AnimationUtils.loadAnimation(context, R$anim.square_loading_progress);
        SpannableString spannableString = new SpannableString("加载失败，点击刷新");
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#14CD64")), 5, 9, 33);
        this.mTvError.setText(spannableString);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mTvOpBtn) {
            disPatchEvent(1, null);
        } else if (view == this && this.mState.f11843a == PageState.State.ERROR) {
            disPatchEvent(2, null);
        }
    }

    public void setState(PageState pageState) {
        this.mState = pageState;
        if (pageState.f11843a == PageState.State.NORMAL) {
            setVisibility(8);
            this.mIvLoading.clearAnimation();
            return;
        }
        setVisibility(0);
        PageState.State state = pageState.f11843a;
        if (state == PageState.State.EMPTY) {
            this.mTvEmpty.setVisibility(0);
            this.mIvLoading.setVisibility(8);
            this.mIvLoading.clearAnimation();
            this.mTvError.setVisibility(8);
            this.mIvError.setVisibility(8);
            return;
        }
        if (state == PageState.State.LOADING) {
            this.mTvOpBtn.setVisibility(8);
            this.mTvEmpty.setVisibility(8);
            this.mIvLoading.setVisibility(0);
            this.mTvError.setVisibility(8);
            this.mIvError.setVisibility(8);
            this.mIvLoading.startAnimation(this.loadingAnim);
            return;
        }
        if (state == PageState.State.ERROR) {
            this.mTvOpBtn.setVisibility(8);
            this.mTvEmpty.setVisibility(8);
            this.mIvLoading.setVisibility(8);
            this.mTvError.setVisibility(0);
            this.mIvError.setVisibility(0);
            this.mIvLoading.clearAnimation();
        }
    }

    @Override // defpackage.mm2
    public void showStatePage(PageState pageState) {
        setState(pageState);
    }

    public ShowListStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = new PageState(PageState.State.LOADING, null);
    }

    public ShowListStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = new PageState(PageState.State.LOADING, null);
    }

    public ShowListStateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mState = new PageState(PageState.State.LOADING, null);
    }
}
