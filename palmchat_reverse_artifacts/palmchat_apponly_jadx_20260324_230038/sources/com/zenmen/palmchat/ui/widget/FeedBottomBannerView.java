package com.zenmen.palmchat.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import defpackage.vl1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class FeedBottomBannerView extends LinearLayout {
    private View mBottom;
    private TextView mCommentInfo;
    private ImageView mImgLike;
    private TextView mLikeInfo;
    private d mOnClickListener;
    private ImageView mSendFial;
    private View mTopView;
    private TextView mTvComment;
    private TextView mTvLike;
    private View mViewComment;
    private View mViewInfo;
    private View mViewLike;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FeedBottomBannerView.this.mOnClickListener != null) {
                FeedBottomBannerView.this.mOnClickListener.c();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FeedBottomBannerView.this.mOnClickListener != null) {
                FeedBottomBannerView.this.mOnClickListener.a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FeedBottomBannerView.this.mOnClickListener != null) {
                FeedBottomBannerView.this.mOnClickListener.b();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();

        void b();

        void c();
    }

    public FeedBottomBannerView(Context context) {
        this(context, null);
    }

    private void initViews(Context context) {
        View.inflate(context, R$layout.layout_feed_bottom_banner, this);
        this.mTvComment = (TextView) findViewById(R$id.tv_comment);
        this.mTopView = findViewById(R$id.top_comment);
        this.mBottom = findViewById(R$id.lyt_banner);
        View viewFindViewById = findViewById(R$id.lyt_like);
        this.mViewLike = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        View viewFindViewById2 = findViewById(R$id.lyt_comment);
        this.mViewComment = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
        View viewFindViewById3 = findViewById(R$id.lyt_info);
        this.mViewInfo = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new c());
        this.mImgLike = (ImageView) findViewById(R$id.img_like);
        this.mTvLike = (TextView) findViewById(R$id.btn_favour);
        this.mLikeInfo = (TextView) findViewById(R$id.tv_like_num);
        this.mCommentInfo = (TextView) findViewById(R$id.tv_comment_num);
        this.mSendFial = (ImageView) findViewById(R$id.send_fail);
    }

    private void setComment(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTopView.setVisibility(8);
        } else {
            this.mTopView.setVisibility(0);
            this.mTvComment.setText(vl1.c(str, getContext(), vl1.d));
        }
    }

    private void setFavour(boolean z) {
        if (z) {
            this.mImgLike.setImageResource(R$drawable.ic_liked);
            this.mTvLike.setText("取消");
        } else {
            this.mImgLike.setImageResource(R$drawable.ic_like);
            this.mTvLike.setText("赞");
        }
    }

    private void setFavourAndCommentNum(int i, int i2) {
        if (i > 0) {
            this.mLikeInfo.setText(String.valueOf(i));
        } else {
            this.mLikeInfo.setText("");
        }
        if (i2 > 0) {
            this.mCommentInfo.setText(String.valueOf(i2));
        } else {
            this.mCommentInfo.setText("");
        }
    }

    public void initData(String str, boolean z, int i, int i2) {
        setComment(str);
        setFavour(z);
        setFavourAndCommentNum(i, i2);
    }

    public void setBottomVisibility(int i) {
        this.mBottom.setVisibility(i);
    }

    public void setOnClickListener(d dVar) {
        this.mOnClickListener = dVar;
    }

    public void showSendFail(boolean z) {
        if (z) {
            this.mSendFial.setVisibility(0);
        } else {
            this.mSendFial.setVisibility(8);
        }
    }

    public FeedBottomBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedBottomBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initViews(context);
    }
}
