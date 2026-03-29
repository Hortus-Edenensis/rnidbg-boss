package com.zenmen.palmchat.ad.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a7;
import defpackage.e6;
import defpackage.gr2;
import defpackage.gu;
import defpackage.hc2;
import defpackage.je1;
import defpackage.kc2;
import defpackage.me1;
import defpackage.w50;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdPMVideoViewForCSJ extends AdView {
    private static final String TAG = "AdPMVideoViewForCSJ";
    private ImageView adIcon;
    private ImageView adImageViewBottom;
    private ImageView adImageViewTop;
    private ViewGroup adLayout;
    private TextView adName;
    private boolean buttonFlash;
    private View ll_ad_close_pop;
    private View ll_ad_close_pop_wrapper;
    private View ll_ad_close_tag;
    private e6 mAdData;
    private Map<Long, TTAppDownloadListener> mTTAppDownloadListenerMap;
    private FrameLayout videoView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdPMVideoViewForCSJ.this.ll_ad_close_pop_wrapper.setVisibility(AdPMVideoViewForCSJ.this.ll_ad_close_pop_wrapper.getVisibility() == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdPMVideoViewForCSJ.this.progressButton.setBackgroundResource(R$drawable.ad_pm_btn_red_bg);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TTAppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Button f12450a;
        public final /* synthetic */ e6 b;

        public c(Button button, e6 e6Var) {
            this.f12450a = button;
            this.b = e6Var;
        }

        public final boolean a() {
            return AdPMVideoViewForCSJ.this.mTTAppDownloadListenerMap.get(Long.valueOf(this.b.b)) == this;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        @SuppressLint({"SetTextI18n"})
        public void onDownloadActive(long j, long j2, String str, String str2) {
            LogUtil.d(AdPMVideoViewForCSJ.TAG, "onDownloadActive");
            if (a()) {
                if (j <= 0) {
                    this.f12450a.setText("0%");
                } else {
                    this.f12450a.setText(((j2 * 100) / j) + "%");
                }
                w50.B("lx_client_sdkad_downloadS", this.b.f17220a.getImageMode(), this.b.f17220a.getInteractionType(), this.b.b, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            LogUtil.d(AdPMVideoViewForCSJ.TAG, "onDownloadFailed");
            if (a()) {
                this.f12450a.setText("重新下载");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            LogUtil.d(AdPMVideoViewForCSJ.TAG, "onDownloadFinished");
            if (a()) {
                this.f12450a.setText("点击安装");
                w50.B("lx_client_sdkad_downloadF", this.b.f17220a.getImageMode(), this.b.f17220a.getInteractionType(), this.b.b, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        @SuppressLint({"SetTextI18n"})
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            LogUtil.d(AdPMVideoViewForCSJ.TAG, "onDownloadPaused");
            if (a()) {
                if (j <= 0) {
                    this.f12450a.setText("0%");
                    return;
                }
                this.f12450a.setText(((j2 * 100) / j) + "%");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            LogUtil.d(AdPMVideoViewForCSJ.TAG, "onIdle");
            if (a()) {
                this.f12450a.setText("开始下载");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            if (a()) {
                this.f12450a.setText("点击打开");
                w50.B("lx_client_sdkad_downloadO", this.b.f17220a.getImageMode(), this.b.f17220a.getInteractionType(), this.b.b, str2);
            }
        }
    }

    public AdPMVideoViewForCSJ(@NonNull Context context) {
        super(context);
        this.buttonFlash = false;
        this.mTTAppDownloadListenerMap = new WeakHashMap();
        initView();
    }

    private void bindDownloadListener(Button button, e6 e6Var) {
        c cVar = new c(button, e6Var);
        e6Var.b(cVar);
        this.mTTAppDownloadListenerMap.put(Long.valueOf(e6Var.b), cVar);
    }

    private void bindVideoListener(e6 e6Var) {
        View adView;
        ArrayList arrayList = new ArrayList();
        TTFeedAd tTFeedAd = e6Var.f17220a;
        if (tTFeedAd.getImageMode() == 5) {
            arrayList.add(this.videoView);
            if (this.videoView != null && (adView = tTFeedAd.getAdView()) != null && adView.getParent() == null) {
                this.videoView.removeAllViews();
                this.videoView.addView(adView);
            }
            tTFeedAd.setVideoAdListener(new w50.c(e6Var));
        }
    }

    private void startScaleAnimation(View view) {
        LogUtil.d(TAG, "startScaleAnimation");
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.03f, 0.98f, 1.03f, 0.98f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(700L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        view.startAnimation(scaleAnimation);
    }

    private void updateVideoSize(TTFeedAd tTFeedAd) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.videoView.getLayoutParams();
        layoutParams.width = me1.g() - me1.b(com.zenmen.palmchat.c.b(), 8);
        if (tTFeedAd.getImageMode() == 15) {
            layoutParams.height = -1;
        } else {
            layoutParams.height = me1.b(this.mContext, 234);
        }
        if (tTFeedAd.getImageList() != null && tTFeedAd.getImageList().size() != 0) {
            int height = tTFeedAd.getImageList().get(0).getHeight();
            int width = tTFeedAd.getImageList().get(0).getWidth();
            if (width != 0 && height != 0) {
                layoutParams.height = (layoutParams.width * height) / width;
            }
        }
        LogUtil.d(TAG, "updateVideoSize width = " + layoutParams.width + ", height = " + layoutParams.height);
        this.videoView.setLayoutParams(layoutParams);
    }

    private void updateWithConfig(e6 e6Var) {
        TTFeedAd tTFeedAd;
        JSONObject jSONObject;
        int i;
        boolean z;
        boolean z2;
        if (e6Var == null || (tTFeedAd = e6Var.f17220a) == null) {
            return;
        }
        String strD = a7.d();
        LogUtil.d(TAG, "pmConfig = " + strD);
        int i2 = 0;
        if (TextUtils.isEmpty(strD)) {
            z2 = false;
            z = false;
        } else {
            try {
                jSONObject = new JSONObject(strD);
                i = jSONObject.getInt("buttonA");
            } catch (Exception unused) {
            }
            try {
                z = jSONObject.getBoolean("normalClickA");
                try {
                    boolean z3 = jSONObject.getBoolean("textClick");
                    try {
                        this.buttonFlash = jSONObject.getBoolean("buttonFlash");
                    } catch (Exception unused2) {
                    }
                    i2 = i;
                    z2 = z3;
                } catch (Exception unused3) {
                    i2 = i;
                    z2 = false;
                }
            } catch (Exception unused4) {
                i2 = i;
                z2 = false;
                z = false;
            }
        }
        this.progressButton.postDelayed(new b(), i2);
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(this.videoView);
        }
        if (z2) {
            arrayList.add(this.adName);
            arrayList.add(this.adIcon);
            arrayList.add(this.adTitle);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.progressButton);
        tTFeedAd.registerViewForInteraction(this.adLayout, arrayList, arrayList2, new w50.b(e6Var, w50.m()));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void focusableViewAvailable(View view) {
        super.focusableViewAvailable(view);
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void initView() {
        View viewInflate = View.inflate(this.mContext, R$layout.layout_ad_pm_video_widget_csj, this);
        this.rootView = viewInflate;
        this.adLayout = (ViewGroup) viewInflate.findViewById(R$id.ad_view_layout);
        this.videoView = (FrameLayout) this.rootView.findViewById(R$id.ad_video_layout);
        this.adImageViewTop = (ImageView) this.rootView.findViewById(R$id.ad_image_top);
        this.adImageViewBottom = (ImageView) this.rootView.findViewById(R$id.ad_image_bottom);
        TextView textView = (TextView) this.rootView.findViewById(R$id.ad_permission);
        this.adPermission = textView;
        textView.setVisibility(8);
        this.adTitle = (TextView) this.rootView.findViewById(R$id.ad_title);
        this.adIcon = (ImageView) this.rootView.findViewById(R$id.ad_icon);
        this.adName = (TextView) this.rootView.findViewById(R$id.ad_name);
        this.ll_ad_close_tag = this.rootView.findViewById(R$id.ll_ad_close_tag);
        this.ll_ad_close_pop_wrapper = this.rootView.findViewById(R$id.ll_ad_close_pop_wrapper);
        this.ll_ad_close_pop = this.rootView.findViewById(R$id.ll_ad_close_pop);
        ProgressButton progressButton = (ProgressButton) this.rootView.findViewById(R$id.ad_attatch_progress_btn);
        this.progressButton = progressButton;
        progressButton.setDrawableProgress(Color.parseColor("#26ffffff"));
        View view = this.ll_ad_close_tag;
        if (view != null) {
            view.setOnClickListener(new a());
        }
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void onAppeared() {
        LogUtil.d(TAG, "onAppeared buttonFlash = " + this.buttonFlash);
        if (this.buttonFlash) {
            startScaleAnimation(this.progressButton);
        }
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void release() {
        super.release();
        e6 e6Var = this.mAdData;
        if (e6Var != null) {
            e6Var.a();
        }
    }

    public void setCSJData(e6 e6Var) {
        if (e6Var == null || e6Var.f17220a == null) {
            return;
        }
        e6 e6Var2 = this.mAdData;
        if (e6Var2 != null) {
            e6Var2.a();
        }
        this.mAdData = e6Var;
        TTFeedAd tTFeedAd = e6Var.f17220a;
        this.adTitle.setText(tTFeedAd.getDescription());
        List<TTImage> imageList = tTFeedAd.getImageList();
        if (imageList != null && imageList.size() != 0) {
            LogUtil.d(TAG, "setData title = " + tTFeedAd.getImageList() + ", imgurl = " + imageList.get(0).getImageUrl());
            kc2<Drawable> kc2VarLoad = hc2.a(getContext()).load(imageList.get(0).getImageUrl());
            int i = R$drawable.shape_people_match_photo_placeholder;
            kc2VarLoad.placeholder(i).error(i).transform(new gu(25, 5)).into(this.adImageViewTop);
            hc2.a(getContext()).load(imageList.get(0).getImageUrl()).placeholder(i).error(i).transform(new gu(25, 5)).into(this.adImageViewBottom);
        }
        je1.a aVarQ = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565);
        int i2 = R$drawable.ad_head;
        je1 je1VarR = aVarQ.B(i2).A(i2).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(i2).r();
        if (tTFeedAd.getIcon() != null) {
            gr2.j().h(tTFeedAd.getIcon().getImageUrl(), this.adIcon, je1VarR);
        }
        this.adName.setText(tTFeedAd.getTitle());
        int interactionType = tTFeedAd.getInteractionType();
        if (interactionType == 2 || interactionType == 3) {
            this.progressButton.setVisibility(0);
            this.progressButton.setText("查看详情");
        } else if (interactionType == 4) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                tTFeedAd.setActivityForDownloadApp((Activity) context);
            }
            this.progressButton.setVisibility(0);
            this.progressButton.setText("立即下载");
            bindDownloadListener(this.progressButton, e6Var);
        } else if (interactionType != 5) {
            this.progressButton.setVisibility(8);
        } else {
            this.progressButton.setVisibility(0);
            this.progressButton.setText("立即拨打");
        }
        updateWithConfig(e6Var);
        bindVideoListener(e6Var);
        updateVideoSize(e6Var.f17220a);
    }

    public AdPMVideoViewForCSJ(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.buttonFlash = false;
        this.mTTAppDownloadListenerMap = new WeakHashMap();
        initView();
    }

    public AdPMVideoViewForCSJ(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.buttonFlash = false;
        this.mTTAppDownloadListenerMap = new WeakHashMap();
        initView();
    }
}
