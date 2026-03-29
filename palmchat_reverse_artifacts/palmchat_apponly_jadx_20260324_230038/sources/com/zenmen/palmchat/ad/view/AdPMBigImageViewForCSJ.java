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
import com.zenmen.palmchat.widget.EffectiveShapeView;
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
public class AdPMBigImageViewForCSJ extends AdView {
    private static final String TAG = "AdPMBigImageViewForCSJ";
    private ImageView adIcon;
    private ImageView adImageView;
    private EffectiveShapeView adImageViewBottom;
    private EffectiveShapeView adImageViewTop;
    private ViewGroup adLayout;
    private TextView adName;
    private boolean buttonFlash;
    private View ll_ad_close_pop;
    private View ll_ad_close_pop_wrapper;
    private View ll_ad_close_tag;
    private e6 mAdData;
    private Map<Long, TTAppDownloadListener> mTTAppDownloadListenerMap;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdPMBigImageViewForCSJ.this.ll_ad_close_pop_wrapper.setVisibility(AdPMBigImageViewForCSJ.this.ll_ad_close_pop_wrapper.getVisibility() == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdPMBigImageViewForCSJ.this.progressButton.setBackgroundResource(R$drawable.ad_pm_btn_red_bg);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TTAppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Button f12447a;
        public final /* synthetic */ e6 b;

        public c(Button button, e6 e6Var) {
            this.f12447a = button;
            this.b = e6Var;
        }

        public final boolean a() {
            return AdPMBigImageViewForCSJ.this.mTTAppDownloadListenerMap.get(Long.valueOf(this.b.b)) == this;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        @SuppressLint({"SetTextI18n"})
        public void onDownloadActive(long j, long j2, String str, String str2) {
            LogUtil.d(AdPMBigImageViewForCSJ.TAG, "onDownloadActive");
            if (a()) {
                if (j <= 0) {
                    this.f12447a.setText("0%");
                } else {
                    this.f12447a.setText(((j2 * 100) / j) + "%");
                }
                w50.B("lx_client_sdkad_downloadS", this.b.f17220a.getImageMode(), this.b.f17220a.getInteractionType(), this.b.b, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            LogUtil.d(AdPMBigImageViewForCSJ.TAG, "onDownloadFailed");
            if (a()) {
                this.f12447a.setText("重新下载");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            LogUtil.d(AdPMBigImageViewForCSJ.TAG, "onDownloadFinished");
            if (a()) {
                this.f12447a.setText("点击安装");
                w50.B("lx_client_sdkad_downloadF", this.b.f17220a.getImageMode(), this.b.f17220a.getInteractionType(), this.b.b, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        @SuppressLint({"SetTextI18n"})
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            LogUtil.d(AdPMBigImageViewForCSJ.TAG, "onDownloadPaused");
            if (a()) {
                if (j <= 0) {
                    this.f12447a.setText("0%");
                    return;
                }
                this.f12447a.setText(((j2 * 100) / j) + "%");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            LogUtil.d(AdPMBigImageViewForCSJ.TAG, "onIdle");
            if (a()) {
                this.f12447a.setText("开始下载");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            if (a()) {
                this.f12447a.setText("点击打开");
                w50.B("lx_client_sdkad_downloadO", this.b.f17220a.getImageMode(), this.b.f17220a.getInteractionType(), this.b.b, str2);
            }
        }
    }

    public AdPMBigImageViewForCSJ(@NonNull Context context) {
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

    private void startScaleAnimation(View view) {
        LogUtil.d(TAG, "startScaleAnimation");
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.03f, 0.98f, 1.03f, 0.98f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(700L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        view.startAnimation(scaleAnimation);
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
            arrayList.add(this.adImageView);
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
        View viewInflate = View.inflate(this.mContext, R$layout.layout_ad_pm_big_image_widget_csj, this);
        this.rootView = viewInflate;
        this.adLayout = (ViewGroup) viewInflate.findViewById(R$id.ad_view_layout);
        this.adImageView = (ImageView) this.rootView.findViewById(R$id.ad_image);
        this.adImageViewTop = (EffectiveShapeView) this.rootView.findViewById(R$id.ad_image_top);
        this.adImageViewBottom = (EffectiveShapeView) this.rootView.findViewById(R$id.ad_image_bottom);
        int iB = me1.b(this.mContext, 11);
        this.adImageViewTop.changeShapeType(3);
        this.adImageViewTop.setDegreeForRoundRectangle(iB, iB);
        this.adImageViewBottom.changeShapeType(3);
        this.adImageViewBottom.setDegreeForRoundRectangle(iB, iB);
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
            gr2.j().h(imageList.get(0).getImageUrl(), this.adImageView, AdView.getDisplayImageOptions());
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
        ViewGroup.LayoutParams layoutParams = this.adImageView.getLayoutParams();
        int iG = me1.g() - me1.b(com.zenmen.palmchat.c.b(), 8);
        layoutParams.width = iG;
        layoutParams.height = (int) ((((double) iG) * 9.0d) / 16.0d);
        LogUtil.d(TAG, "updateImage width = " + layoutParams.width + ", height = " + layoutParams.height);
        this.adImageView.setLayoutParams(layoutParams);
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
    }

    public AdPMBigImageViewForCSJ(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.buttonFlash = false;
        this.mTTAppDownloadListenerMap = new WeakHashMap();
        initView();
    }

    public AdPMBigImageViewForCSJ(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.buttonFlash = false;
        this.mTTAppDownloadListenerMap = new WeakHashMap();
        initView();
    }
}
