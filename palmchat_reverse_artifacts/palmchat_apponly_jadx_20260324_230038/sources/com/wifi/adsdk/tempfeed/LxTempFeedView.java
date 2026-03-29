package com.wifi.adsdk.tempfeed;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.igexin.push.config.c;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.wifi.ad.core.utils.UIUtils;
import com.wifi.adsdk.AdAllInitConfig;
import com.wifi.adsdk.baseview.AdComInfoAllLayoutNew2;
import com.wifi.adsdk.entity.LxAdBaseView;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.entity.SingleImage;
import com.wifi.adsdk.listener.LxBaseShowListener;
import com.wifi.adsdk.listener.LxTempFeedShowListener;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.utils.BLPlatform;
import com.wifi.adsdk.utils.CheckDoubleClick;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.lxad.ad.R;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxTempFeedView extends LxAdBaseView {
    private static final Float[][] sSupportSize;
    private TextView adAppName;
    private View adClose;
    private TextView adDesc;
    private boolean adDestroy;
    private View adDownYYAll;
    private ImageView adImgView;
    private View adMain;
    private int adShowDelay;
    private TextView adSign;
    private ViewGroup adVideoView;
    private View adViewGroup;
    private View adYYLayout;
    private ImageView blurImg;
    private AdComInfoAllLayoutNew2 comInfoLayout;
    private View imgVideoLayout;
    private Context mContext;
    private View yyShakeView;

    static {
        Float fValueOf = Float.valueOf(-1.0f);
        sSupportSize = new Float[][]{new Float[]{fValueOf, Float.valueOf(180.0f)}, new Float[]{fValueOf, Float.valueOf(210.0f)}, new Float[]{Float.valueOf(125.0f), Float.valueOf(223.0f)}};
    }

    public LxTempFeedView(Context context, LxAdBeanData lxAdBeanData, LxAdReqParams lxAdReqParams) {
        super(context, lxAdBeanData, lxAdReqParams);
        this.adShowDelay = -1;
        this.adDestroy = false;
        this.mContext = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.lxad_temp_feed_content_large, (ViewGroup) null);
        this.adViewGroup = viewInflate;
        addView(viewInflate);
        initView();
    }

    private int getAdShowConfig() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        if (lxAdBeanData == null || TextUtils.isEmpty(lxAdBeanData.getApiId())) {
            return 0;
        }
        return AdAllInitConfig.getNativeDelayPp(this.mAdItem.getApiId());
    }

    private void initData() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        if (lxAdBeanData == null) {
            return;
        }
        String appName = lxAdBeanData.getAppName();
        if (TextUtils.isEmpty(appName)) {
            appName = "推荐";
        }
        this.adAppName.setText(appName);
        String description = this.mAdItem.getDescription();
        if (!TextUtils.isEmpty(description)) {
            this.adDesc.setText(description);
        }
        Float fValueOf = null;
        SingleImage singleImage = this.mAdItem.getSingleImage() != null ? this.mAdItem.getSingleImage() : (this.mAdItem.getGroupImage() == null || this.mAdItem.getGroupImage().size() <= 0) ? null : this.mAdItem.getGroupImage().get(0);
        if (singleImage != null) {
            Float[][] fArr = {new Float[]{Float.valueOf(16.0f), Float.valueOf(9.0f)}, new Float[]{Float.valueOf(3.0f), Float.valueOf(2.0f)}, new Float[]{Float.valueOf(9.0f), Float.valueOf(16.0f)}};
            float width = singleImage.getWidth();
            float height = singleImage.getHeight();
            if (width > 0.0f && height > 0.0f) {
                float f = width / height;
                String url = singleImage.getUrl();
                int i = 0;
                for (int i2 = 0; i2 < 3; i2++) {
                    Float[] fArr2 = fArr[i2];
                    float fAbs = Math.abs((fArr2[0].floatValue() / fArr2[1].floatValue()) - f);
                    if (fValueOf == null || fAbs < fValueOf.floatValue()) {
                        fValueOf = Float.valueOf(fAbs);
                        i = i2;
                    }
                }
                LxAdLog.d("LxTempFeedView imageWeight " + f + " sizeIndex " + i);
                if (i == 2) {
                    this.blurImg.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams = this.imgVideoLayout.getLayoutParams();
                    Context context = this.mContext;
                    Float[][] fArr3 = sSupportSize;
                    layoutParams.width = UIUtils.dip2px(context, fArr3[2][0].floatValue());
                    layoutParams.height = UIUtils.dip2px(this.mContext, fArr3[2][1].floatValue());
                    this.imgVideoLayout.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(url) && this.blurImg != null && !url.endsWith(".gif")) {
                        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
                        if (wifiNestAd.getMAdRequestCallBack() != null) {
                            wifiNestAd.getMAdRequestCallBack().showBlurImg(url, this.blurImg);
                        }
                    }
                    i = 1;
                } else {
                    this.blurImg.setVisibility(8);
                }
                View view = this.adMain;
                if (view != null) {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    Float[][] fArr4 = sSupportSize;
                    if (fArr4[i][0].floatValue() == -1.0f) {
                        layoutParams2.width = -1;
                    } else {
                        layoutParams2.width = UIUtils.dip2px(this.mContext, fArr4[i][0].floatValue());
                    }
                    if (fArr4[i][1].floatValue() == -1.0f) {
                        layoutParams2.height = -1;
                    } else {
                        layoutParams2.height = UIUtils.dip2px(this.mContext, fArr4[i][1].floatValue());
                    }
                    this.adMain.setLayoutParams(layoutParams2);
                }
            }
        }
        if (isVideoAd()) {
            this.adVideoView.setVisibility(0);
            this.voiceView.setVisibility(0);
            this.adImgView.setVisibility(8);
            initVoiceView();
            addVideoView(this.adVideoView);
        } else {
            this.adVideoView.setVisibility(8);
            this.voiceView.setVisibility(8);
            this.adImgView.setVisibility(0);
            if (!TextUtils.isEmpty(singleImage.getUrl())) {
                if (singleImage.getUrl().endsWith(".gif")) {
                    Glide.with(this.mContext).asGif().load2(singleImage.getUrl()).into(this.adImgView);
                } else {
                    Glide.with(this.mContext).load2(singleImage.getUrl()).into(this.adImgView);
                }
            }
        }
        if (isDownloadAd()) {
            if (isYYAd()) {
                this.adAction.setText("点击下载");
            } else {
                this.adAction.setText("立即下载");
            }
            this.comInfoLayout.setVisibility(0);
            showComplianceInfo();
        } else {
            if (isYYAd()) {
                this.adAction.setText("点击查看");
            } else {
                this.adAction.setText("查看详情");
            }
            this.comInfoLayout.setVisibility(8);
        }
        if (!isYYAd()) {
            this.adYYLayout.setVisibility(8);
        } else {
            this.adYYLayout.setVisibility(0);
            shakeAnim(this.yyShakeView);
        }
    }

    private void initView() {
        this.blurImg = (ImageView) this.adViewGroup.findViewById(R.id.ad_bg_blur);
        this.adAppName = (TextView) this.adViewGroup.findViewById(R.id.ad_app_name);
        View viewFindViewById = this.adViewGroup.findViewById(R.id.ad_down_yaoyiyao_layout);
        this.adDownYYAll = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.tempfeed.LxTempFeedView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                LxTempFeedView.this.tempClick("0", 2);
            }
        });
        View viewFindViewById2 = this.adViewGroup.findViewById(R.id.ad_close);
        this.adClose = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.tempfeed.LxTempFeedView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                LxBaseShowListener lxBaseShowListener = LxTempFeedView.this.showListener;
                if (lxBaseShowListener instanceof LxTempFeedShowListener) {
                    ((LxTempFeedShowListener) lxBaseShowListener).adClose();
                }
                LxTempFeedView.this.adCloseEvent();
                LxTempFeedView.this.showEventReplace("信息流模板广告点击叉号show");
                LxTempFeedView.this.adDestroy = true;
            }
        });
        this.adDesc = (TextView) this.adViewGroup.findViewById(R.id.ad_desc);
        this.adSign = (TextView) this.adViewGroup.findViewById(R.id.ad_sign);
        this.adAction = (TextView) this.adViewGroup.findViewById(R.id.ad_action);
        this.yyShakeView = this.adViewGroup.findViewById(R.id.yy_shake_bg);
        this.adYYLayout = this.adViewGroup.findViewById(R.id.ad_yaoyiyao);
        this.adImgView = (ImageView) this.adViewGroup.findViewById(R.id.ad_img);
        this.adVideoView = (ViewGroup) this.adViewGroup.findViewById(R.id.ad_video);
        View viewFindViewById3 = this.adViewGroup.findViewById(R.id.ad_main_layout);
        this.adMain = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.tempfeed.LxTempFeedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                LxTempFeedView.this.tempClick("0", 1);
            }
        });
        this.voiceView = (ImageView) this.adViewGroup.findViewById(R.id.voice);
        this.imgVideoLayout = this.adViewGroup.findViewById(R.id.ad_img_video_layout);
        this.comInfoLayout = (AdComInfoAllLayoutNew2) this.adViewGroup.findViewById(R.id.ad_com_info_layout);
        this.reStartVideoView = findViewById(R.id.video_finish_restart);
        this.videoFinishLayout = findViewById(R.id.video_finish_layout);
        this.videoFinishImg = (ImageView) findViewById(R.id.video_finish_img);
        setAdText(this.adSign);
        initData();
    }

    private void shakeAnim(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.wifi.adsdk.tempfeed.LxTempFeedView.8
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                LxTempFeedView.this.startViewAnim(view2);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
            }
        });
    }

    private void showComplianceInfo() {
        TextView textView = (TextView) this.adViewGroup.findViewById(R.id.version);
        if (textView != null && !TextUtils.isEmpty(this.mAdItem.getAppVersion())) {
            textView.setText("版本号:" + this.mAdItem.getAppVersion());
        }
        TextView textView2 = (TextView) this.adViewGroup.findViewById(R.id.company);
        if (textView2 != null && !TextUtils.isEmpty(this.mAdItem.getAdvertiserName())) {
            textView2.setText(this.mAdItem.getAdvertiserName());
        }
        TextView textView3 = (TextView) this.adViewGroup.findViewById(R.id.function);
        TextView textView4 = (TextView) this.adViewGroup.findViewById(R.id.permission);
        TextView textView5 = (TextView) this.adViewGroup.findViewById(R.id.privacy);
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.tempfeed.LxTempFeedView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    String permissionUrl = LxTempFeedView.this.mAdItem.getPermissionUrl();
                    if (permissionUrl == null || !permissionUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        BLPlatform.startTextActivity(permissionUrl, "权限", LxTempFeedView.this.getContext());
                    } else {
                        AdComplianceUtil.startCommonWebView(permissionUrl, "权限", LxTempFeedView.this.getContext());
                    }
                }
            });
        }
        if (textView5 != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.tempfeed.LxTempFeedView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    String privacyPolicyUrl = LxTempFeedView.this.mAdItem.getPrivacyPolicyUrl();
                    if (privacyPolicyUrl == null || !privacyPolicyUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        BLPlatform.startTextActivity(privacyPolicyUrl, "隐私", LxTempFeedView.this.getContext());
                    } else {
                        AdComplianceUtil.startCommonWebView(privacyPolicyUrl, "隐私", LxTempFeedView.this.getContext());
                    }
                }
            });
        }
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.tempfeed.LxTempFeedView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    String descriptionUrl = LxTempFeedView.this.mAdItem.getDescriptionUrl();
                    if (descriptionUrl == null || !descriptionUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        BLPlatform.startTextActivity(descriptionUrl, "功能", LxTempFeedView.this.getContext());
                    } else {
                        AdComplianceUtil.startCommonWebView(descriptionUrl, "功能", LxTempFeedView.this.getContext());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDelayTimeCheck() {
        if (this.adDestroy || this.isShowAd) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.wifi.adsdk.tempfeed.LxTempFeedView.4
            /* JADX WARN: Removed duplicated region for block: B:11:0x0059  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z;
                Rect rect = new Rect();
                if (!LxTempFeedView.this.getGlobalVisibleRect(rect) || rect.height() <= 0 || LxTempFeedView.this.getMeasuredHeight() <= 0) {
                    z = false;
                } else {
                    final float fHeight = (rect.height() * 100.0f) / LxTempFeedView.this.getMeasuredHeight();
                    LxAdLog.d("showEventReplace temp scaleHeight " + fHeight);
                    if (fHeight >= LxTempFeedView.this.adShowDelay) {
                        LxTempFeedView.this.mainHandler.post(new Runnable() { // from class: com.wifi.adsdk.tempfeed.LxTempFeedView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LxTempFeedView.this.showEventReplace("信息流模板广告adShowDelay满足：" + LxTempFeedView.this.adShowDelay + " scaleHeight " + fHeight);
                            }
                        });
                        z = true;
                    }
                }
                if (z) {
                    return;
                }
                LxTempFeedView.this.startDelayTimeCheck();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startViewAnim(final View view) {
        if (view.getAnimation() != null) {
            view.getAnimation().cancel();
        }
        final Animation animationLoadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.nest_ad_shake_bg);
        animationLoadAnimation.setInterpolator(new CycleInterpolator(5.0f));
        animationLoadAnimation.setDuration(c.j);
        view.startAnimation(animationLoadAnimation);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.wifi.adsdk.tempfeed.LxTempFeedView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.postDelayed(new Runnable() { // from class: com.wifi.adsdk.tempfeed.LxTempFeedView.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                        view.startAnimation(animationLoadAnimation);
                    }
                }, 1000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tempClick(String str, int i) {
        clickEventReplace(str, i);
    }

    @Override // com.wifi.adsdk.entity.LxAdBaseView
    public void adDestroy() {
        super.adDestroy();
    }

    public void adShow() {
        LxAdLog.d("LxTempFeedView adShow start");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.srcWidth = getWidth();
            this.srcHeight = getHeight();
            LxAdLog.d("LxTempView onLayout srcWidth " + this.srcWidth + " srcHeight " + this.srcHeight);
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdBaseView
    public void readyToShowEvent() {
        if (this.adShowDelay == -1) {
            int adShowConfig = getAdShowConfig();
            this.adShowDelay = adShowConfig;
            if (adShowConfig == 0) {
                showEventReplace("信息流模板adShowDelay为0正常展示");
            } else {
                startDelayTimeCheck();
            }
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdBaseView
    public void sensorClick() {
        boolean localVisibleRect = getLocalVisibleRect(new Rect());
        LxAdLog.d("LxAdSensorUtil LxTempFeedView sensorClick result " + localVisibleRect);
        if (localVisibleRect) {
            clickEventReplace("2", 3);
        }
    }

    public void setShowListener(LxTempFeedShowListener lxTempFeedShowListener) {
        this.showListener = lxTempFeedShowListener;
    }
}
