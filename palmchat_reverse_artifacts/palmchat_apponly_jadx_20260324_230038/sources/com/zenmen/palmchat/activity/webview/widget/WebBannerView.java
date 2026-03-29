package com.zenmen.palmchat.activity.webview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WebBannerView extends RelativeLayout {
    private View bottomView;
    private boolean isClose;
    private View topView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebBannerView.this.isClose = true;
            WebBannerView.this.bottomView.setVisibility(8);
        }
    }

    public WebBannerView(Context context) {
        super(context);
        this.isClose = false;
        initViews();
    }

    private void initViews() {
        View viewInflate = View.inflate(getContext(), R.layout.view_webview_banner, this);
        this.topView = viewInflate.findViewById(R.id.lyt_top_banner);
        this.bottomView = viewInflate.findViewById(R.id.lyt_bottom_banner);
        this.topView.setVisibility(8);
        this.bottomView.setVisibility(8);
        viewInflate.findViewById(R.id.view_close).setOnClickListener(new a());
    }

    public void showBottomBanner(View.OnClickListener onClickListener) {
        if (this.isClose) {
            return;
        }
        this.bottomView.setVisibility(0);
        this.bottomView.setOnClickListener(onClickListener);
    }

    public void showTopBanner(View.OnClickListener onClickListener) {
        this.topView.setVisibility(0);
        this.topView.setOnClickListener(onClickListener);
    }

    public WebBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isClose = false;
        initViews();
    }

    public WebBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isClose = false;
        initViews();
    }
}
