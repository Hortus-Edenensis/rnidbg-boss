package com.zenmen.palmchat.paidservices.superexpose.msgtab.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.lantern.auth.android.BLUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.model.SuperExposeMsgTabInfo;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.model.SuperExposeMsgTagCItemModel;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo5;
import defpackage.fo5;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MsgTabUiViewTaiJiB extends MsgTabBaseUiView {
    private FrameLayout abAllLayout;
    private int allAnimHeight;
    private int allWidth;
    private View animalLayout;
    private SuperExposeInfo exposeCurInfo;
    private ValueAnimator mAllAnimator;
    private String mCurTaiJi;
    private Handler mHandler;
    private long mLastShowAnimTime;
    private SuperExposeMsgTabInfo msgCurTabInfo;
    private LinearLayout msgTabInfoAllLayout;
    private MsgTabUiViewA msgTabUiViewA;
    private MsgTabUiViewB msgTabUiViewB;
    private MsgTabUiViewC msgTabUiViewC;
    private boolean startAnim;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MsgTabUiViewTaiJiB.this.startAllAnim();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f14868a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;
        public final /* synthetic */ float f;

        public b(float f, float f2, float f3, float f4, float f5, float f6) {
            this.f14868a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
            this.f = f6;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                float fFloatValue = ((Float) animatedValue).floatValue();
                if (fFloatValue > 0.0f) {
                    float f = this.f14868a;
                    if (fFloatValue < f) {
                        MsgTabUiViewTaiJiB.this.animalLayout.getLayoutParams().height = (int) ((fFloatValue / f) * MsgTabUiViewTaiJiB.this.allAnimHeight);
                        MsgTabUiViewTaiJiB.this.animalLayout.requestLayout();
                        return;
                    }
                }
                float f2 = this.f14868a;
                if (fFloatValue >= f2 && fFloatValue <= this.b) {
                    MsgTabUiViewTaiJiB.this.abAllLayout.setAlpha(1.0f - ((fFloatValue - f2) / this.c));
                    return;
                }
                if (fFloatValue < this.d || fFloatValue >= this.e) {
                    return;
                }
                if (MsgTabUiViewTaiJiB.this.msgTabUiViewC.getVisibility() == 8) {
                    MsgTabUiViewTaiJiB.this.msgTabUiViewC.setVisibility(0);
                }
                float f3 = (fFloatValue - this.d) / this.f;
                if (f3 >= 1.0f) {
                    f3 = 1.0f;
                }
                MsgTabUiViewTaiJiB.this.msgTabUiViewC.setAlpha(f3);
                MsgTabUiViewTaiJiB.this.msgTabUiViewC.setTranslationX(MsgTabUiViewTaiJiB.this.allWidth * (1.0f - f3));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            MsgTabUiViewTaiJiB.this.startAnim = false;
            MsgTabUiViewTaiJiB.this.endCLayout();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            MsgTabUiViewTaiJiB.this.startAnim = false;
            MsgTabUiViewTaiJiB.this.endCLayout();
            MsgTabUiViewTaiJiB.this.msgTabUiViewC.startScaleAnimation();
        }
    }

    public MsgTabUiViewTaiJiB(Context context, String str) {
        super(context);
        this.msgTabUiViewA = null;
        this.msgTabUiViewB = null;
        this.msgTabUiViewC = null;
        this.msgCurTabInfo = null;
        this.exposeCurInfo = null;
        this.msgTabInfoAllLayout = null;
        this.animalLayout = null;
        this.mAllAnimator = null;
        this.allWidth = 0;
        this.allAnimHeight = 0;
        this.abAllLayout = null;
        this.mLastShowAnimTime = 0L;
        this.mHandler = null;
        this.startAnim = false;
        this.mCurTaiJi = str;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.allWidth = context.getResources().getDisplayMetrics().widthPixels;
        this.allAnimHeight = BLUtils.dip2px(context, 32.0f);
        this.msgTabUiViewA = new MsgTabUiViewA(context);
        this.msgTabUiViewB = new MsgTabUiViewB(context, false);
        this.msgTabUiViewC = new MsgTabUiViewC(context, -1, true);
        this.msgTabUiViewA.setVisibility(8);
        this.msgTabUiViewB.setVisibility(8);
        this.msgTabUiViewC.setVisibility(8);
        LinearLayout linearLayout = new LinearLayout(context);
        this.msgTabInfoAllLayout = linearLayout;
        linearLayout.setOrientation(1);
        this.abAllLayout = new FrameLayout(context);
        View view = new View(context);
        this.animalLayout = view;
        view.setBackgroundColor(-1);
        this.abAllLayout.addView(this.msgTabUiViewA, new FrameLayout.LayoutParams(-1, -2));
        this.abAllLayout.addView(this.msgTabUiViewB, new FrameLayout.LayoutParams(-1, -2));
        this.msgTabInfoAllLayout.addView(this.abAllLayout, new FrameLayout.LayoutParams(-1, -2));
        this.msgTabInfoAllLayout.addView(this.animalLayout, new FrameLayout.LayoutParams(-1, -2));
        addView(this.msgTabInfoAllLayout, new FrameLayout.LayoutParams(-1, -2));
        addView(this.msgTabUiViewC, new FrameLayout.LayoutParams(-1, -2));
        LogUtil.d("", "MsgTabTaijiModelManager MsgTabUiViewTaiJiB start init ");
    }

    private void animStart() {
        this.startAnim = true;
        this.mLastShowAnimTime = System.currentTimeMillis();
        LogUtil.d("", "MsgTabTaijiModelManager MsgTabUiViewTaiJiB animStart ");
        this.mHandler.postDelayed(new a(), 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endCLayout() {
        this.msgTabUiViewC.setTranslationX(0.0f);
        this.msgTabUiViewC.setAlpha(1.0f);
    }

    private void initABLayout() {
        this.abAllLayout.setAlpha(1.0f);
        this.animalLayout.getLayoutParams().height = 0;
    }

    private void initAnimStartView() {
        initABLayout();
        this.msgTabUiViewC.setVisibility(8);
        this.msgTabUiViewC.setAlpha(0.0f);
        this.msgTabUiViewC.setTranslationX(this.allWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAllAnim() {
        ValueAnimator valueAnimator = this.mAllAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        initAnimStartView();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.2f);
        this.mAllAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration((long) 1200.0f);
        this.mAllAnimator.addUpdateListener(new b(0.3f, 0.6f, 0.3f, 0.7f, 1.2f, 0.40000004f));
        this.mAllAnimator.addListener(new c());
        this.mAllAnimator.start();
    }

    private void viewAShow(boolean z) {
        initABLayout();
        this.msgTabUiViewA.setVisibility(0);
        this.msgTabUiViewB.setVisibility(8);
        this.msgTabUiViewC.setVisibility(8);
        if (z) {
            this.msgTabUiViewC.onDestroy();
        }
        this.msgTabUiViewB.onDestroy();
    }

    private void viewBShow(boolean z) {
        initABLayout();
        this.msgTabUiViewA.setVisibility(8);
        this.msgTabUiViewB.setVisibility(0);
        this.msgTabUiViewC.setVisibility(8);
        this.msgTabUiViewA.onDestroy();
        if (z) {
            this.msgTabUiViewC.onDestroy();
        }
    }

    private void viewCShow() {
        ValueAnimator valueAnimator = this.mAllAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            endCLayout();
            this.mAllAnimator.cancel();
        }
        this.msgTabUiViewA.setVisibility(8);
        this.msgTabUiViewB.setVisibility(8);
        this.msgTabUiViewA.onDestroy();
        this.msgTabUiViewB.onDestroy();
        this.msgTabUiViewC.setVisibility(0);
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public int getRootLayout() {
        return R.layout.super_expose_msg_tab_ui_taijiall;
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void initItemView(bo5 bo5Var) {
        LogUtil.d("", "MsgTabTaijiModelManager MsgTabUiViewTaiJiB initItemView ");
        this.mMsgTabCallBack = bo5Var;
        this.msgTabUiViewA.initItemView(bo5Var);
        this.msgTabUiViewB.initItemView(bo5Var);
        this.msgTabUiViewC.initItemView(bo5Var);
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void onDestroy() {
        super.onDestroy();
        this.msgTabUiViewA.onDestroy();
        this.msgTabUiViewB.onDestroy();
        this.msgTabUiViewC.onDestroy();
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void setData(SuperExposeMsgTabInfo superExposeMsgTabInfo, SuperExposeInfo superExposeInfo, boolean z, boolean z2) {
        ArrayList<SuperExposeMsgTagCItemModel> arrayList;
        LogUtil.d("", "MsgTabTaijiModelManager MsgTabUiViewTaiJiB setData msgTabInfo " + superExposeMsgTabInfo + " exposeInfo " + superExposeInfo + " allowFromRequestAnim " + z + " startAnim " + this.startAnim + " onlyShowAB " + z2);
        if (this.startAnim) {
            return;
        }
        this.msgCurTabInfo = superExposeMsgTabInfo;
        this.exposeCurInfo = superExposeInfo;
        this.msgTabUiViewA.setVisibility(8);
        this.msgTabUiViewB.setVisibility(8);
        this.msgTabUiViewC.setVisibility(8);
        if (this.exposeCurInfo != null) {
            boolean zEquals = WkAdxAdConfigMg.DSP_NAME_CSJ.equals(this.mCurTaiJi);
            SuperExposeInfo superExposeInfo2 = this.exposeCurInfo;
            if (superExposeInfo2.status == 1) {
                superExposeInfo2.showEntrance = true;
            }
            SuperExposeMsgTabInfo superExposeMsgTabInfo2 = this.msgCurTabInfo;
            if (superExposeMsgTabInfo2 == null || (arrayList = superExposeMsgTabInfo2.dataList) == null || arrayList.size() <= 0 || z2) {
                SuperExposeInfo superExposeInfo3 = this.exposeCurInfo;
                if (superExposeInfo3.showEntrance) {
                    if (superExposeInfo3.status == 1) {
                        LogUtil.d("", "MsgTabTaijiModelManager MsgTabUiViewTaiJiB setData msgTabUiViewB show ");
                        viewBShow(true);
                        this.msgTabUiViewB.setData(this.msgCurTabInfo, this.exposeCurInfo, z, z2);
                        return;
                    } else {
                        LogUtil.d("", "MsgTabTaijiModelManager MsgTabUiViewTaiJiB setData msgTabUiViewA show ");
                        viewAShow(true);
                        this.msgTabUiViewA.setData(this.msgCurTabInfo, this.exposeCurInfo, z, z2);
                        return;
                    }
                }
                return;
            }
            LogUtil.d("", "MsgTabTaijiModelManager MsgTabUiViewTaiJiB setData startAnim " + this.startAnim);
            if (this.exposeCurInfo.showEntrance) {
                boolean z3 = z && System.currentTimeMillis() - this.mLastShowAnimTime > fo5.f;
                LogUtil.d("", "MsgTabTaijiModelManager MsgTabUiViewTaiJiB setData allowAnim " + z3);
                if (this.exposeCurInfo.status == 1) {
                    this.msgTabUiViewC.setCurStatus(1);
                    if (zEquals && z3) {
                        LogUtil.d("", "MsgTabTaijiModelManager MsgTabUiViewTaiJiB setData msgTabUiViewB show ");
                        viewBShow(false);
                        this.msgTabUiViewB.setData(this.msgCurTabInfo, this.exposeCurInfo, z, false);
                        animStart();
                    } else {
                        viewCShow();
                    }
                } else {
                    this.msgTabUiViewC.setCurStatus(-1);
                    if (zEquals && z3) {
                        LogUtil.d("", "MsgTabTaijiModelManager MsgTabUiViewTaiJiB setData msgTabUiViewA show ");
                        viewAShow(false);
                        this.msgTabUiViewA.setData(this.msgCurTabInfo, this.exposeCurInfo, z, false);
                        animStart();
                    } else {
                        viewCShow();
                    }
                }
            } else {
                viewCShow();
                this.msgTabUiViewC.setShowIcon(false);
            }
            this.msgTabUiViewC.setData(this.msgCurTabInfo, this.exposeCurInfo, z, false);
        }
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void visibleShow(boolean z) {
        super.visibleShow(z);
        if (this.msgTabUiViewA.getVisibility() == 0) {
            this.msgTabUiViewA.visibleShow(z);
        }
        if (this.msgTabUiViewB.getVisibility() == 0) {
            this.msgTabUiViewB.visibleShow(z);
        }
        if (this.msgTabUiViewC.getVisibility() == 0) {
            this.msgTabUiViewC.visibleShow(z);
        }
    }
}
