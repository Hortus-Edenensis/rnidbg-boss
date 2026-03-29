package com.zenmen.listui.list;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class SquareLoadFooter extends ClassicsFooter {
    public SquareLoadFooter(Context context) {
        this(context, null);
    }

    public void clearTextLoading() {
        this.mTextLoading = "";
        if (this.mProgressView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mProgressView.getLayoutParams().width, this.mProgressView.getLayoutParams().height);
            layoutParams.addRule(13);
            this.mProgressView.setLayoutParams(layoutParams);
        }
    }

    public void setTitleColor(int i) {
        this.mTitleText.setTextColor(i);
    }

    public SquareLoadFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextNothing = "我也是有底线的";
        this.mTitleText.setTextSize(1, 15.0f);
    }
}
