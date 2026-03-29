package com.zenmen.square.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$anim;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import defpackage.tu4;
import defpackage.xu4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquarePersonLoadFooter extends InternalClassics<ClassicsFooter> implements tu4 {
    private boolean mNoMoreData;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16565a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f16565a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16565a[RefreshState.Loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16565a[RefreshState.LoadReleased.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16565a[RefreshState.LoadFinish.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SquarePersonLoadFooter(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.vu4
    public int onFinish(@NonNull xu4 xu4Var, boolean z) {
        super.onFinish(xu4Var, z);
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.l74
    public void onStateChanged(@NonNull xu4 xu4Var, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        if (this.mNoMoreData) {
            return;
        }
        LogUtil.d("SquarePersonLoadFooter", refreshState2.name());
        int i = a.f16565a[refreshState2.ordinal()];
        if (i == 1) {
            this.mProgressView.setVisibility(8);
        } else if (i != 2 && i != 3) {
            if (i != 4) {
                return;
            }
            this.mProgressView.clearAnimation();
            return;
        }
        this.mProgressView.setVisibility(0);
        this.mProgressView.startAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.square_loading_progress));
        this.mTitleText.setText(R$string.loading_more);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.tu4
    public boolean setNoMoreData(boolean z) {
        this.mNoMoreData = z;
        return super.setNoMoreData(z);
    }

    public SquarePersonLoadFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        View.inflate(context, R$layout.layout_square_personal_footer, this);
        this.mArrowView = (ImageView) findViewById(R$id.srl_classics_arrow);
        this.mProgressView = (ImageView) findViewById(R$id.srl_classics_progress);
        this.mTitleText = (TextView) findViewById(R$id.srl_classics_title);
        this.mProgressView.setVisibility(8);
    }
}
