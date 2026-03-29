package com.zenmen.listui.widget;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zenmen.listui.R$anim;
import com.zenmen.listui.R$drawable;
import com.zenmen.listui.R$id;
import com.zenmen.listui.R$layout;
import com.zenmen.listui.list.PageState;
import defpackage.ma3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class StateView extends RelativeLayout {
    protected String emptyString;
    protected SpannableString errorMsg;
    protected Animation loadingAnim;
    protected String loadingString;
    protected ImageView mImage;
    protected ImageView mLoadingImage;
    protected PageState mState;
    protected TextView mText;
    protected int pageType;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11850a;

        static {
            int[] iArr = new int[PageState.State.values().length];
            f11850a = iArr;
            try {
                iArr[PageState.State.EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11850a[PageState.State.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11850a[PageState.State.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11850a[PageState.State.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public StateView(Context context) {
        this(context, null);
    }

    private void updateVisible(PageState.State state) {
        if (state == PageState.State.NORMAL) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        if (state == PageState.State.LOADING) {
            this.mLoadingImage.setVisibility(0);
            this.mText.setVisibility(4);
            this.mImage.setVisibility(4);
        } else {
            this.mLoadingImage.setVisibility(4);
            this.mLoadingImage.clearAnimation();
            this.mText.setVisibility(0);
            this.mImage.setVisibility(0);
        }
    }

    public void createView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(getLayoutResource(), (ViewGroup) this, false);
        this.mImage = (ImageView) viewInflate.findViewById(R$id.iv_load_state_icon);
        this.mLoadingImage = (ImageView) viewInflate.findViewById(R$id.iv_page_state_loading);
        this.mText = (TextView) viewInflate.findViewById(R$id.tv_load_state_text);
        this.emptyString = "空空如也";
        addView(viewInflate);
        this.loadingAnim = AnimationUtils.loadAnimation(context, R$anim.square_loading_progress);
        SpannableString spannableString = new SpannableString("加载失败，点击刷新");
        this.errorMsg = spannableString;
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#14CD64")), 5, 9, 33);
    }

    public int getLayoutResource() {
        return R$layout.layout_comm_list_state_view;
    }

    public PageState getState() {
        return this.mState;
    }

    public void setEmptyString(String str) {
        this.emptyString = str;
    }

    public void setPageType(int i) {
        this.pageType = i;
    }

    public void setState(PageState pageState) {
        ma3.a("Page State is " + pageState, new Object[0]);
        if (this.mText == null || this.mImage == null) {
            return;
        }
        this.mState = pageState;
        updateVisible(pageState.f11843a);
        int i = a.f11850a[pageState.f11843a.ordinal()];
        if (i == 1) {
            this.mText.setText(this.emptyString);
            this.mImage.setImageResource(R$drawable.icon_load_state_empty);
        } else if (i == 2) {
            this.mImage.setImageResource(R$drawable.icon_load_state_error);
            this.mText.setText(this.errorMsg);
        } else if (i == 3) {
            this.mLoadingImage.startAnimation(this.loadingAnim);
        } else {
            if (i != 4) {
                return;
            }
            setVisibility(8);
        }
    }

    public void setTopMargin(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mImage.getLayoutParams();
        layoutParams.topMargin = i;
        this.mImage.setLayoutParams(layoutParams);
    }

    public StateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public StateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mState = new PageState(PageState.State.LOADING, null);
        createView(context);
    }
}
