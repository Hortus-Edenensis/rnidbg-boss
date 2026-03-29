package com.zenmen.square.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.listui.list.PageState;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$anim;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import defpackage.ma3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PraiseListStateView extends LxRelativeLayout {
    private int emptyIconRes;
    private int emptyTitleRes;
    private boolean enableBtn;
    private c listener;
    private Animation loadingAnim;
    private TextView mBtn;
    private ImageView mImage;
    private ImageView mLoadingImage;
    private PageState mState;
    private TextView mText;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PraiseListStateView.this.listener != null) {
                PraiseListStateView.this.listener.a(PraiseListStateView.this.mState.f11843a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16552a;

        static {
            int[] iArr = new int[PageState.State.values().length];
            f16552a = iArr;
            try {
                iArr[PageState.State.EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16552a[PageState.State.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16552a[PageState.State.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16552a[PageState.State.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(PageState.State state);
    }

    public PraiseListStateView(Context context) {
        super(context);
        this.mState = new PageState(PageState.State.LOADING, null);
        this.emptyIconRes = R$drawable.icon_square_load_state_empty_praise;
        this.emptyTitleRes = R$string.square_praise_list_state_empty;
        this.enableBtn = true;
    }

    private void updateVisible(PageState.State state) {
        if (state == PageState.State.LOADING) {
            this.mLoadingImage.setVisibility(0);
            this.mText.setVisibility(8);
            this.mImage.setVisibility(8);
        } else {
            this.mLoadingImage.setVisibility(8);
            this.mLoadingImage.clearAnimation();
            this.mText.setVisibility(0);
            this.mImage.setVisibility(0);
        }
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_praise_list_state_view, (ViewGroup) this, false);
        this.mImage = (ImageView) viewInflate.findViewById(R$id.icon_state_praise_empty);
        this.mLoadingImage = (ImageView) viewInflate.findViewById(R$id.iv_page_state_loading);
        this.mText = (TextView) viewInflate.findViewById(R$id.text_state_praise_empty);
        TextView textView = (TextView) viewInflate.findViewById(R$id.btn_empty_praise_guide_publish);
        this.mBtn = textView;
        textView.setVisibility(8);
        addView(viewInflate);
        this.loadingAnim = AnimationUtils.loadAnimation(context, R$anim.square_loading_progress);
        setOnClickListener(new a());
    }

    public PageState getState() {
        return this.mState;
    }

    public void setEmptyIconRes(int i) {
        this.emptyIconRes = i;
    }

    public void setEmptyTitleRes(int i) {
        this.emptyTitleRes = i;
    }

    public void setEnableBtn(boolean z) {
        this.enableBtn = z;
    }

    public void setOnStateViewClickListener(c cVar) {
        this.listener = cVar;
    }

    public void setState(PageState pageState) {
        ma3.a("Page State is " + pageState, new Object[0]);
        if (this.mText == null || this.mImage == null) {
            return;
        }
        this.mState = pageState;
        updateVisible(pageState.f11843a);
        int i = b.f16552a[pageState.f11843a.ordinal()];
        if (i == 1) {
            this.mText.setText(this.emptyTitleRes);
            this.mImage.setImageResource(this.emptyIconRes);
        } else if (i == 2) {
            this.mText.setText(R$string.square_feed_list_state_err);
            this.mImage.setImageResource(R$drawable.icon_square_load_state_err);
        } else if (i == 3) {
            this.mLoadingImage.startAnimation(this.loadingAnim);
        } else {
            if (i != 4) {
                return;
            }
            setVisibility(8);
        }
    }

    public PraiseListStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = new PageState(PageState.State.LOADING, null);
        this.emptyIconRes = R$drawable.icon_square_load_state_empty_praise;
        this.emptyTitleRes = R$string.square_praise_list_state_empty;
        this.enableBtn = true;
    }

    public PraiseListStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = new PageState(PageState.State.LOADING, null);
        this.emptyIconRes = R$drawable.icon_square_load_state_empty_praise;
        this.emptyTitleRes = R$string.square_praise_list_state_empty;
        this.enableBtn = true;
    }

    @RequiresApi(api = 21)
    public PraiseListStateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mState = new PageState(PageState.State.LOADING, null);
        this.emptyIconRes = R$drawable.icon_square_load_state_empty_praise;
        this.emptyTitleRes = R$string.square_praise_list_state_empty;
        this.enableBtn = true;
    }
}
