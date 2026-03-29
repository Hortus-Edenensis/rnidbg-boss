package com.zenmen.square.ui.widget;

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
import androidx.annotation.RequiresApi;
import com.zenmen.listui.list.PageState;
import com.zenmen.square.R$anim;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import defpackage.a46;
import defpackage.ma3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ListStateView extends RelativeLayout {
    protected TextView btnOperator;
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
        public static final /* synthetic */ int[] f16523a;

        static {
            int[] iArr = new int[PageState.State.values().length];
            f16523a = iArr;
            try {
                iArr[PageState.State.EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16523a[PageState.State.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16523a[PageState.State.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16523a[PageState.State.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ListStateView(Context context) {
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
        this.mImage = (ImageView) viewInflate.findViewById(R$id.iv_square_load_state_icon);
        this.mLoadingImage = (ImageView) viewInflate.findViewById(R$id.iv_page_state_loading);
        this.mText = (TextView) viewInflate.findViewById(R$id.tv_square_load_state_text);
        this.btnOperator = (TextView) viewInflate.findViewById(R$id.btn_operator);
        this.emptyString = context.getString(R$string.square_feed_list_state_empty);
        this.loadingString = context.getString(R$string.square_feed_list_state_loading);
        addView(viewInflate);
        this.loadingAnim = AnimationUtils.loadAnimation(context, R$anim.square_loading_progress);
        SpannableString spannableString = new SpannableString(context.getString(R$string.square_feed_list_state_err));
        this.errorMsg = spannableString;
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#14CD64")), 5, 9, 33);
    }

    public TextView getBtnOperator() {
        return this.btnOperator;
    }

    public TextView getEmptyTextView() {
        return this.mText;
    }

    public int getLayoutResource() {
        return R$layout.layout_feeds_list_state_view;
    }

    public PageState getState() {
        return this.mState;
    }

    public void setEmptyString(String str) {
        this.emptyString = str;
    }

    public void setImageSize(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mImage.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.mImage.setLayoutParams(layoutParams);
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
        int i = a.f16523a[pageState.f11843a.ordinal()];
        if (i == 1) {
            this.mText.setText(this.emptyString);
            this.mImage.setImageResource(R$drawable.icon_square_load_state_empty);
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.mLoadingImage.startAnimation(this.loadingAnim);
                return;
            } else {
                if (i != 4) {
                    return;
                }
                setVisibility(8);
                return;
            }
        }
        this.mImage.setImageResource(R$drawable.icon_square_load_state_err);
        if (14 == this.pageType) {
            if (!a46.p()) {
                this.mImage.setImageDrawable(null);
                return;
            } else if (pageState.c == -1001) {
                this.mText.setText(pageState.b);
                return;
            }
        }
        this.mText.setText(this.errorMsg);
    }

    public void setTopMargin(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mImage.getLayoutParams();
        layoutParams.topMargin = i;
        this.mImage.setLayoutParams(layoutParams);
    }

    public ListStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListStateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    @RequiresApi(api = 21)
    public ListStateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mState = new PageState(PageState.State.LOADING, null);
        createView(context);
    }

    public void setState(PageState pageState, int i, int i2) {
        ma3.a("Page State is " + pageState, new Object[0]);
        if (this.mText == null || this.mImage == null) {
            return;
        }
        this.mState = pageState;
        updateVisible(pageState.f11843a);
        int i3 = a.f16523a[pageState.f11843a.ordinal()];
        if (i3 == 1) {
            this.mText.setText(this.emptyString);
            this.mImage.setImageResource(i2);
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                this.mLoadingImage.startAnimation(this.loadingAnim);
                return;
            } else {
                if (i3 != 4) {
                    return;
                }
                setVisibility(8);
                return;
            }
        }
        this.mImage.setImageResource(i);
        if (14 == this.pageType) {
            if (!a46.p()) {
                this.mImage.setImageDrawable(null);
                return;
            } else if (pageState.c == -1001) {
                this.mText.setText(pageState.b);
                return;
            }
        }
        this.mText.setText(this.errorMsg);
    }
}
