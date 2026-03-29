package com.zenmen.palmchat.paidservices.superexpose.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.paidservices.superexpose.bean.StyleConfig;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.hc2;
import defpackage.yn5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeTypeCLayout extends FrameLayout {
    private ImageView mBgView;
    private Context mContext;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yn5 f14877a;

        public a(yn5 yn5Var) {
            this.f14877a = yn5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.d("SuperExpose", "onClick SuperExposeTypeCLayout ");
            this.f14877a.a(1);
        }
    }

    public SuperExposeTypeCLayout(Context context, yn5 yn5Var) {
        super(context);
        this.mContext = null;
        this.mBgView = null;
        this.mContext = context.getApplicationContext();
        initView(yn5Var);
    }

    private void initView(yn5 yn5Var) {
        ImageView imageView = new ImageView(this.mContext);
        this.mBgView = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mBgView.setImageResource(R.drawable.super_expose_c_bg);
        addView(this.mBgView, new FrameLayout.LayoutParams(-1, a46.b(this.mContext, 54.0f)));
        setOnClickListener(new a(yn5Var));
    }

    public void setAllData(SuperExposeInfo superExposeInfo) {
        StyleConfig styleConfig;
        if (superExposeInfo == null || (styleConfig = superExposeInfo.styleConfig) == null || this.mBgView == null || TextUtils.isEmpty(styleConfig.bgImg)) {
            return;
        }
        hc2.a(this.mContext).load(styleConfig.bgImg).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.super_expose_c_bg).error(R.drawable.super_expose_c_bg).transition(DrawableTransitionOptions.withCrossFade()).into(this.mBgView);
    }
}
