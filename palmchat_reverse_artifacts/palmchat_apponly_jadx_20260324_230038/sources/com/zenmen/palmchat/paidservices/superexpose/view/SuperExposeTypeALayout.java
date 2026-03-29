package com.zenmen.palmchat.paidservices.superexpose.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.paidservices.superexpose.bean.StyleConfig;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.paidservices.superexpose.bean.Template;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.ui.widget.FindSelectTabView;
import defpackage.a46;
import defpackage.gr2;
import defpackage.me1;
import defpackage.vn5;
import defpackage.yn5;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeTypeALayout extends FrameLayout {
    private ImageView mBgView;
    private Context mContext;
    private FindSelectTabView mFindSelectTabView;
    private SuperExposeLoopAllLayout mLoopLayout;
    private yn5 mSuperExposeEventListener;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yn5 f14874a;

        public a(yn5 yn5Var) {
            this.f14874a = yn5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.d("SuperExpose", "onClick mEnterBgView ");
            this.f14874a.a(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yn5 f14875a;

        public b(yn5 yn5Var) {
            this.f14875a = yn5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.d("SuperExpose", "onClick SuperExposeTypeALayout ");
            this.f14875a.a(1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements vn5 {
        public c() {
        }

        @Override // defpackage.vn5
        public void a() {
            SuperExposeTypeALayout.this.mFindSelectTabView.hideSuperExposeTabEnter();
            SuperExposeTypeALayout.this.mFindSelectTabView.hideSuperExposeTipEnter(true);
            SuperExposeTypeALayout.this.mSuperExposeEventListener.b();
        }
    }

    public SuperExposeTypeALayout(Context context, FindSelectTabView findSelectTabView, yn5 yn5Var) {
        super(context);
        this.mLoopLayout = null;
        this.mBgView = null;
        this.mContext = context.getApplicationContext();
        this.mSuperExposeEventListener = yn5Var;
        this.mFindSelectTabView = findSelectTabView;
        findSelectTabView.getSuperExposeTabEnter().setOnClickListener(new a(yn5Var));
        setOnClickListener(new b(yn5Var));
        initView();
    }

    private void initView() {
        ImageView imageView = new ImageView(this.mContext);
        this.mBgView = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a46.b(getContext(), 35.0f));
        this.mBgView.setImageResource(R.drawable.super_expose_a_bg);
        addView(this.mBgView, layoutParams);
        this.mLoopLayout = new SuperExposeLoopAllLayout(this.mContext, 12.0f, true, new c());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = me1.b(this.mContext, 11);
        addView(this.mLoopLayout, layoutParams2);
        this.mLoopLayout.setTextStillTime(5000L);
        this.mLoopLayout.setAnimTime(300L);
        this.mLoopLayout.startAutoScroll();
    }

    public void setAllData(SuperExposeInfo superExposeInfo) {
        StyleConfig styleConfig;
        SuperExposeLoopAllLayout superExposeLoopAllLayout;
        LogUtil.d("SuperExpose", "SuperExposeTypeALayout setAllData ");
        if (superExposeInfo == null || (styleConfig = superExposeInfo.styleConfig) == null) {
            return;
        }
        ArrayList<Template> arrayList = styleConfig.template;
        if (arrayList != null && (superExposeLoopAllLayout = this.mLoopLayout) != null) {
            superExposeLoopAllLayout.setDataList(arrayList);
        }
        if (superExposeInfo.styleConfig.bgImg == null || this.mBgView == null) {
            return;
        }
        gr2.j().g(superExposeInfo.styleConfig.bgImg, this.mBgView);
    }

    public void startAutoScroll() {
        SuperExposeLoopAllLayout superExposeLoopAllLayout = this.mLoopLayout;
        if (superExposeLoopAllLayout != null) {
            superExposeLoopAllLayout.startAutoScroll();
        }
    }

    public void stopAutoScroll() {
        SuperExposeLoopAllLayout superExposeLoopAllLayout = this.mLoopLayout;
        if (superExposeLoopAllLayout != null) {
            superExposeLoopAllLayout.stopAutoScroll();
        }
    }
}
