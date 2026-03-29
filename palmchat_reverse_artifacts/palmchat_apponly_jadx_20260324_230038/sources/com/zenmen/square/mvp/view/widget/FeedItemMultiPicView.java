package com.zenmen.square.mvp.view.widget;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.mvp.model.bean.Media;
import defpackage.a46;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedItemMultiPicView extends LxRelativeLayout implements View.OnClickListener {
    private EffectiveShapeView mFirstImg;
    private int mItemOffset;
    private LeftDrawableText mMediaCountView;
    private ViewOutlineProvider mOutline;
    private b mPicClickListener;
    private int mRadius;
    private EffectiveShapeView mSecondImg;
    private EffectiveShapeView mThirdImg;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), FeedItemMultiPicView.this.mRadius);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void k(int i);
    }

    public FeedItemMultiPicView(Context context) {
        this(context, null);
    }

    private void calculateImageViewSize(List<Media> list) {
        Context context;
        float f;
        ViewGroup.LayoutParams layoutParams = this.mFirstImg.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mSecondImg.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = this.mThirdImg.getLayoutParams();
        if (list.size() == 1) {
            Media media = list.get(0);
            boolean z = media.getHeight() >= media.getWidth();
            layoutParams.width = a46.b(getContext(), z ? 180.0f : 208.0f);
            if (z) {
                context = getContext();
                f = 240.0f;
            } else {
                context = getContext();
                f = 156.0f;
            }
            layoutParams.height = a46.b(context, f);
            this.mFirstImg.setLayoutParams(layoutParams);
            a46.u(a46.h(this.mFirstImg, list.get(0).url), this.mFirstImg, R$drawable.bg_feed_item_loading);
        } else if (list.size() == 2) {
            int iB = (a46.m(getContext()).x - a46.b(getContext(), 90.0f)) / 2;
            layoutParams.width = iB;
            layoutParams.height = iB;
            layoutParams2.width = iB;
            layoutParams2.height = iB;
            this.mFirstImg.setLayoutParams(layoutParams);
            this.mSecondImg.setLayoutParams(layoutParams2);
            String strH = a46.h(this.mFirstImg, list.get(0).url);
            EffectiveShapeView effectiveShapeView = this.mFirstImg;
            int i = R$drawable.bg_feed_item_loading;
            a46.u(strH, effectiveShapeView, i);
            a46.u(a46.h(this.mSecondImg, list.get(1).url), this.mSecondImg, i);
        } else {
            int iB2 = (a46.m(getContext()).x - a46.b(getContext(), 90.0f)) / 3;
            layoutParams2.width = iB2;
            layoutParams2.height = iB2;
            int i2 = iB2 * 2;
            layoutParams.width = i2;
            layoutParams.height = i2;
            layoutParams3.width = layoutParams2.width;
            layoutParams3.height = layoutParams2.height - a46.b(getContext(), 2.0f);
            this.mFirstImg.setLayoutParams(layoutParams);
            this.mSecondImg.setLayoutParams(layoutParams2);
            this.mThirdImg.setLayoutParams(layoutParams3);
            String strH2 = a46.h(this.mFirstImg, list.get(0).url);
            EffectiveShapeView effectiveShapeView2 = this.mFirstImg;
            int i3 = R$drawable.bg_feed_item_loading;
            a46.u(strH2, effectiveShapeView2, i3);
            a46.u(a46.h(this.mSecondImg, list.get(1).url), this.mSecondImg, i3);
            a46.u(a46.h(this.mThirdImg, list.get(2).url), this.mThirdImg, i3);
        }
        if (list.size() <= 3) {
            this.mMediaCountView.setVisibility(8);
        } else {
            this.mMediaCountView.setVisibility(0);
            this.mMediaCountView.setText(getContext().getString(R$string.square_media_count, Integer.valueOf(list.size())));
        }
    }

    public void clearImage() {
        EffectiveShapeView effectiveShapeView = this.mFirstImg;
        int i = R$drawable.bg_feed_item_loading;
        effectiveShapeView.setImageResource(i);
        this.mSecondImg.setImageResource(i);
        this.mThirdImg.setImageResource(i);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        LayoutInflater.from(context).inflate(R$layout.layout_feed_item_multi_pic, this);
        this.mFirstImg = (EffectiveShapeView) findViewById(R$id.iv_img_first);
        this.mSecondImg = (EffectiveShapeView) findViewById(R$id.iv_img_second);
        this.mThirdImg = (EffectiveShapeView) findViewById(R$id.iv_img_third);
        this.mFirstImg.setOnClickListener(this);
        this.mSecondImg.setOnClickListener(this);
        this.mThirdImg.setOnClickListener(this);
        this.mMediaCountView = (LeftDrawableText) findViewById(R$id.iv_pic_count);
        this.mItemOffset = a46.b(context, 14.0f);
        this.mRadius = a46.b(getContext(), 8.0f);
        a aVar = new a();
        this.mOutline = aVar;
        setOutlineProvider(aVar);
        setClipToOutline(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = this.mPicClickListener;
        if (bVar == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).performClick();
                return;
            }
            return;
        }
        int i = 0;
        if (view != this.mFirstImg) {
            if (view == this.mSecondImg) {
                i = 1;
            } else if (view == this.mThirdImg) {
                i = 2;
            }
        }
        bVar.k(i);
    }

    public void setMediaList(List<Media> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mThirdImg.setVisibility(list.size() < 3 ? 8 : 0);
        this.mSecondImg.setVisibility(list.size() >= 2 ? 0 : 8);
        this.mMediaCountView.setVisibility(4);
        calculateImageViewSize(list);
    }

    public void setOnPicClickListener(b bVar) {
        this.mPicClickListener = bVar;
    }

    public FeedItemMultiPicView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedItemMultiPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
