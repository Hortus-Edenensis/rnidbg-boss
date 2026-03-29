package com.zenmen.palmchat.paidservices.superexpose.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wifi.ad.core.custom.flow.GlideImageLoader;
import com.wifi.ad.core.utils.ScreenUtil;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.paidservices.superexpose.bean.Template;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.nc2;
import defpackage.vn5;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeLoopItemLayout extends LinearLayout {
    private vn5 closeCall;
    private ImageView closeImg;
    private GradientDrawable gradientDrawable;
    private ImageView[] imageViews;
    private int imgInt;
    private ImageView logoView;
    private TextView textView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.d("SuperExpose", "closeImg click");
            if (SuperExposeLoopItemLayout.this.closeCall != null) {
                SuperExposeLoopItemLayout.this.closeCall.a();
            }
        }
    }

    public SuperExposeLoopItemLayout(Context context, boolean z, vn5 vn5Var) {
        super(context);
        this.imgInt = 3;
        this.imageViews = new ImageView[3];
        this.textView = null;
        this.logoView = null;
        this.closeImg = null;
        this.gradientDrawable = null;
        this.closeCall = vn5Var;
        initView(z);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.gradientDrawable = gradientDrawable;
        ScreenUtil screenUtil = ScreenUtil.INSTANCE;
        gradientDrawable.setCornerRadius(screenUtil.dp2px(getContext(), 10.0f));
        this.gradientDrawable.setStroke(screenUtil.dp2px(getContext(), 1.0f), -1);
    }

    private void initView(boolean z) {
        setGravity(16);
        setOrientation(0);
        FrameLayout frameLayout = new FrameLayout(getContext());
        for (int i = this.imgInt - 1; i >= 0; i--) {
            this.imageViews[i] = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a46.b(getContext(), 19.0f), a46.b(getContext(), 19.0f));
            layoutParams.leftMargin = a46.b(getContext(), (i * 14) + 8.0f);
            this.imageViews[i].setVisibility(8);
            frameLayout.addView(this.imageViews[i], layoutParams);
        }
        addView(frameLayout, new LinearLayout.LayoutParams(-2, a46.b(getContext(), 19.0f)));
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 1.0f;
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        addView(linearLayout, layoutParams2);
        TextView textView = new TextView(getContext());
        this.textView = textView;
        textView.setMaxLines(1);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setTextSize(12.0f);
        this.textView.setTextColor(Color.parseColor("#222222"));
        this.textView.setGravity(16);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, a46.b(getContext(), 17.0f));
        layoutParams3.leftMargin = a46.b(getContext(), 6.0f);
        layoutParams3.weight = 1.0f;
        linearLayout.addView(this.textView, layoutParams3);
        this.logoView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(a46.b(getContext(), 4.0f), a46.b(getContext(), 8.0f));
        layoutParams4.leftMargin = a46.b(getContext(), 4.0f);
        linearLayout.addView(this.logoView, layoutParams4);
        this.logoView.setBackgroundResource(R.drawable.super_expose_logo_jian);
        this.logoView.setVisibility(8);
        if (z) {
            this.closeImg = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(a46.b(getContext(), 10.0f), a46.b(getContext(), 10.0f));
            layoutParams5.rightMargin = a46.b(getContext(), 8.0f);
            layoutParams5.leftMargin = a46.b(getContext(), 8.0f);
            addView(this.closeImg, layoutParams5);
            this.closeImg.setBackgroundResource(R.drawable.super_expose_close);
            this.closeImg.setOnClickListener(new a());
            this.closeImg.setVisibility(4);
        }
    }

    public void setData(Template template) {
        if (template != null) {
            template.isLoadData = true;
            ArrayList<String> arrayList = template.avatar;
            if (arrayList == null || arrayList.size() <= 0) {
                this.imageViews[0].setVisibility(8);
                this.imageViews[1].setVisibility(8);
                this.imageViews[2].setVisibility(8);
                ImageView imageView = this.logoView;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            } else {
                if (template.avatar.size() == 1) {
                    this.imageViews[0].setVisibility(0);
                    new GlideImageLoader().loadImage(getContext(), this.imageViews[0], template.avatar.get(0), new nc2(this.gradientDrawable));
                    this.imageViews[1].setVisibility(8);
                    this.imageViews[2].setVisibility(8);
                } else if (template.avatar.size() == 2) {
                    this.imageViews[0].setVisibility(0);
                    new GlideImageLoader().loadImage(getContext(), this.imageViews[0], template.avatar.get(0), new nc2(this.gradientDrawable));
                    this.imageViews[1].setVisibility(0);
                    new GlideImageLoader().loadImage(getContext(), this.imageViews[1], template.avatar.get(1), new nc2(this.gradientDrawable));
                    this.imageViews[2].setVisibility(8);
                } else if (template.avatar.size() >= 3) {
                    this.imageViews[0].setVisibility(0);
                    new GlideImageLoader().loadImage(getContext(), this.imageViews[0], template.avatar.get(0), new nc2(this.gradientDrawable));
                    this.imageViews[1].setVisibility(0);
                    new GlideImageLoader().loadImage(getContext(), this.imageViews[1], template.avatar.get(1), new nc2(this.gradientDrawable));
                    this.imageViews[2].setVisibility(0);
                    new GlideImageLoader().loadImage(getContext(), this.imageViews[2], template.avatar.get(2), new nc2(this.gradientDrawable));
                }
                ImageView imageView2 = this.logoView;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            }
            if (!TextUtils.isEmpty(template.text)) {
                this.textView.setText(Html.fromHtml(template.text));
            }
            ImageView imageView3 = this.closeImg;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
        }
    }

    public void setTextSize(float f) {
    }
}
