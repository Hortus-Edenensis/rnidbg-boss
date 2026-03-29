package com.zenmen.square.mvp.view;

import android.content.Context;
import android.util.AttributeSet;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.databinding.FeedLayoutItemViewBinding;
import defpackage.zt1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedItemView extends LxRelativeLayout {
    protected FeedLayoutItemViewBinding mBinding;
    private int mPosition;
    private zt1 presenter;

    public FeedItemView(Context context) {
        super(context);
    }

    public Context getCurrentContext() {
        return getContext();
    }

    public FeedItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FeedItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
    }
}
