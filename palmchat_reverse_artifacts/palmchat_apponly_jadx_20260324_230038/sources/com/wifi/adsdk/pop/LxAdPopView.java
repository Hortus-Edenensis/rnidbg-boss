package com.wifi.adsdk.pop;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.custom.flow.GlideImageLoader;
import com.wifi.ad.core.imageloader.GlideRoundedTransformation;
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.wifi.ad.core.utils.ScreenUtil;
import com.wifi.ad.core.utils.UIUtils;
import com.wifi.ad.core.view.AspectRatioFrameLayout;
import com.wifi.adsdk.AdAllInitConfig;
import com.wifi.adsdk.entity.LxAdBaseView;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.entity.SingleImage;
import com.wifi.adsdk.listener.LxPopShowListener;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.utils.BLPlatform;
import com.wifi.adsdk.utils.BLUtils;
import com.wifi.adsdk.utils.CheckDoubleClick;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.lxad.ad.R;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdPopView extends LxAdBaseView {
    private static final float[][] sSupportSize = {new float[]{16.0f, 9.0f}, new float[]{3.0f, 2.0f}, new float[]{9.0f, 16.0f}};
    private LxPopAdDialog adDialog;
    private View adYYLayout;
    private ImageView blurBg;
    private View clickBtnButton;
    private Timer delayTimer;
    private TextView mAd;
    private ViewGroup mAdAllLayout;
    private ImageView mAdIcon;
    private ViewGroup mAdImgVideoLayout;
    private ImageView mAdImgView;
    private LinearLayout mAdInfoLayout;
    private View mAllFunctionLayout;
    private TextView mAppDesc;
    private TextView mAppName;
    private TextView mAppVersion;
    private ImageView mClose;
    private TextView mCompany;
    private ViewGroup mComplianceLayout;
    private Context mContext;
    private AspectRatioFrameLayout mHeadIconLayout;
    private TextView mPermission;
    private TextView mPrivacy;
    private RelativeLayout mRootLayout;
    private ViewGroup mVideoView;
    private int popShowDelay;

    public LxAdPopView(@NonNull Context context, LxAdBeanData lxAdBeanData, LxAdReqParams lxAdReqParams) {
        super(context, lxAdBeanData, lxAdReqParams);
        this.adYYLayout = null;
        this.mAdIcon = null;
        this.mAppName = null;
        this.mAppDesc = null;
        this.clickBtnButton = null;
        this.blurBg = null;
        this.popShowDelay = -1;
        this.delayTimer = null;
        this.lxEventReplace = lxAdBeanData.getEventReplace();
        this.mContext = getContext();
    }

    private void cancelDelayTimer() {
        Timer timer = this.delayTimer;
        if (timer != null) {
            timer.cancel();
            this.delayTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismiss() {
        LxPopAdDialog lxPopAdDialog = this.adDialog;
        if (lxPopAdDialog != null) {
            lxPopAdDialog.dismiss();
        }
    }

    private int getPopShowConfig() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        if (lxAdBeanData == null || TextUtils.isEmpty(lxAdBeanData.getApiId())) {
            return 0;
        }
        return AdAllInitConfig.getInterstitialDelayTime(this.mAdItem.getApiId());
    }

    private void initUi(View view) {
        int height;
        int i;
        TextView textView;
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.pop_native_ad_all_layout);
        this.mAdAllLayout = viewGroup;
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.pop.LxAdPopView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                LxAdPopView.this.popAdClick("0", 1);
            }
        });
        this.mAdImgVideoLayout = (ViewGroup) view.findViewById(R.id.ad_img_video_layout);
        this.mHeadIconLayout = (AspectRatioFrameLayout) view.findViewById(R.id.headIconLayout);
        this.mAdInfoLayout = (LinearLayout) view.findViewById(R.id.adInfoLayout);
        this.mComplianceLayout = (ViewGroup) view.findViewById(R.id.complianceLayout);
        this.mRootLayout = (RelativeLayout) view.findViewById(R.id.rootLayout);
        String url = null;
        SingleImage singleImage = this.mAdItem.getSingleImage() != null ? this.mAdItem.getSingleImage() : (this.mAdItem.getGroupImage() == null || this.mAdItem.getGroupImage().size() <= 0) ? null : this.mAdItem.getGroupImage().get(0);
        float f = 9.0f;
        if (isVideoAd() && this.mAdItem.getVideo() != null) {
            width = this.mAdItem.getVideo().getVideoWidth() > 0 ? this.mAdItem.getVideo().getVideoWidth() : 16.0f;
            if (this.mAdItem.getVideo().getVideoHeight() > 0) {
                height = this.mAdItem.getVideo().getVideoHeight();
                f = height;
            }
        } else if (singleImage != null) {
            width = singleImage.getWidth() > 0 ? singleImage.getWidth() : 16.0f;
            if (singleImage.getHeight() > 0) {
                height = singleImage.getHeight();
                f = height;
            }
        }
        boolean zIsDownloadAd = isDownloadAd();
        this.srcWidth = UIUtils.getScreenAllWidth(this.mContext);
        this.srcHeight = UIUtils.getRealHeight(this.mContext);
        if (width > 0.0f && f > 0.0f) {
            float f2 = width / f;
            Float fValueOf = null;
            int i2 = 0;
            i = 0;
            while (true) {
                float[][] fArr = sSupportSize;
                if (i2 >= fArr.length) {
                    break;
                }
                float[] fArr2 = fArr[i2];
                float fAbs = Math.abs((fArr2[0] / fArr2[1]) - f2);
                if (fValueOf == null || fAbs < fValueOf.floatValue()) {
                    fValueOf = Float.valueOf(fAbs);
                    i = i2;
                }
                i2++;
            }
        } else {
            i = 0;
        }
        LxAdLog.d("DDT setDataAndShow in bind img width = " + width + ", height = " + f + " sizeIndex " + i);
        this.mHeadIconLayout.setResizeMode(1);
        AspectRatioFrameLayout aspectRatioFrameLayout = this.mHeadIconLayout;
        float[] fArr3 = sSupportSize[i];
        aspectRatioFrameLayout.setAspectRatio(fArr3[0] / fArr3[1]);
        View viewFindViewById = view.findViewById(R.id.hengban_layout);
        View viewFindViewById2 = view.findViewById(R.id.shuban_layout);
        if (i == 2) {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(0);
            int i3 = R.id.ad_down_yaoyiyao_layout_shu;
            startScaleAnimation(view.findViewById(i3));
            this.adYYLayout = view.findViewById(R.id.ad_yaoyiyao_shu);
            this.mComplianceLayout.addView((ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.layout_download_app_info, (ViewGroup) null));
            this.mPermission = (TextView) findViewById(R.id.permission);
            this.mAllFunctionLayout = findViewById(R.id.function_all_layout);
            this.mPrivacy = (TextView) findViewById(R.id.privacy);
            this.mAppVersion = (TextView) findViewById(R.id.version);
            this.mCompany = (TextView) findViewById(R.id.company);
            this.mAdImgView = (ImageView) findViewById(R.id.bigImg_shu);
            this.mAd = (TextView) findViewById(R.id.ad_shu);
            this.mClose = (ImageView) findViewById(R.id.close_shu);
            this.mVideoView = (ViewGroup) findViewById(R.id.videoView_shu);
            this.mRootLayout.setPadding(BLUtils.dp2px(this.mContext, 20.0f), 0, BLUtils.dp2px(this.mContext, 20.0f), 0);
            this.mAppName = (TextView) view.findViewById(R.id.ad_name_shu);
            this.voiceView = (ImageView) view.findViewById(R.id.voice_shu);
            this.blurBg = (ImageView) view.findViewById(R.id.blur_bg_layout);
            if (isVideoAd()) {
                if (this.mAdItem.getVideo() != null) {
                    url = this.mAdItem.getVideo().getPreImgUrl();
                }
            } else if (singleImage != null) {
                url = singleImage.getUrl();
            }
            if (!TextUtils.isEmpty(url) && this.blurBg != null && !url.endsWith(".gif")) {
                WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
                if (wifiNestAd.getMAdRequestCallBack() != null) {
                    wifiNestAd.getMAdRequestCallBack().showBlurImg(url, this.blurBg);
                }
            }
            if (!TextUtils.isEmpty(this.mAdItem.getDescription())) {
                TextView textView2 = (TextView) view.findViewById(R.id.ad_desc_shu);
                this.mAppDesc = textView2;
                textView2.setText(this.mAdItem.getDescription());
            }
            this.clickBtnButton = view.findViewById(i3);
            this.adAction = (TextView) findViewById(R.id.adInfoDownload_shu);
            this.reStartVideoView = findViewById(R.id.video_finish_restart_shu);
            this.videoFinishLayout = findViewById(R.id.video_finish_layout_shu);
            this.videoFinishImg = (ImageView) findViewById(R.id.video_finish_img_shu);
        } else {
            viewFindViewById.setVisibility(0);
            viewFindViewById2.setVisibility(8);
            int i4 = R.id.ad_down_yaoyiyao_layout;
            startScaleAnimation(view.findViewById(i4));
            this.adYYLayout = view.findViewById(R.id.ad_yaoyiyao);
            this.mComplianceLayout.addView((ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.layout_download_app_info, (ViewGroup) null));
            this.mPermission = (TextView) findViewById(R.id.permission);
            this.mAllFunctionLayout = findViewById(R.id.function_all_layout);
            this.mPrivacy = (TextView) findViewById(R.id.privacy);
            this.mAppVersion = (TextView) findViewById(R.id.version);
            this.mCompany = (TextView) findViewById(R.id.company);
            this.mAdImgView = (ImageView) findViewById(R.id.bigImg);
            this.mAd = (TextView) findViewById(R.id.ad);
            this.mClose = (ImageView) findViewById(R.id.close);
            this.voiceView = (ImageView) view.findViewById(R.id.voice);
            this.mVideoView = (ViewGroup) findViewById(R.id.videoView);
            this.mRootLayout.setPadding(BLUtils.dp2px(this.mContext, 20.0f), 0, BLUtils.dp2px(this.mContext, 20.0f), 0);
            this.mAdIcon = (ImageView) view.findViewById(R.id.adInfoIcon);
            this.mAppName = (TextView) view.findViewById(R.id.adInfoName);
            if (!TextUtils.isEmpty(this.mAdItem.getDescription())) {
                TextView textView3 = (TextView) view.findViewById(R.id.adInfoDes);
                this.mAppDesc = textView3;
                textView3.setText(this.mAdItem.getDescription());
            }
            this.clickBtnButton = view.findViewById(i4);
            this.adAction = (TextView) findViewById(R.id.adInfoDownload);
            this.reStartVideoView = findViewById(R.id.video_finish_restart);
            this.videoFinishLayout = findViewById(R.id.video_finish_layout);
            this.videoFinishImg = (ImageView) findViewById(R.id.video_finish_img);
        }
        if (this.adYYLayout != null) {
            if (isYYAd()) {
                this.adYYLayout.setVisibility(0);
            } else {
                this.adYYLayout.setVisibility(8);
            }
        }
        if (this.voiceView != null) {
            if (isVideoAd()) {
                this.voiceView.setVisibility(0);
                initVoiceView();
            } else {
                this.voiceView.setVisibility(8);
            }
        }
        ImageView imageView = this.mClose;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.pop.LxAdPopView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    LxAdPopView.this.dismiss();
                }
            });
        }
        if (!TextUtils.isEmpty(this.mAdItem.getIconUrl()) && this.mAdIcon != null) {
            GlideImageLoader glideImageLoader = new GlideImageLoader();
            Context context = this.mContext;
            ImageView imageView2 = this.mAdIcon;
            String iconUrl = this.mAdItem.getIconUrl();
            Context context2 = this.mContext;
            glideImageLoader.loadImage(context, imageView2, iconUrl, new GlideRoundedTransformation(context2, ScreenUtil.INSTANCE.dp2px(context2, 8.0f)));
        }
        if (!TextUtils.isEmpty(this.mAdItem.getAppName()) && (textView = this.mAppName) != null) {
            textView.setText(this.mAdItem.getAppName());
        }
        if (zIsDownloadAd) {
            if (this.adAction != null) {
                if (isYYAd()) {
                    this.adAction.setText("点击下载");
                } else {
                    this.adAction.setText("立即下载");
                }
            }
            ViewGroup viewGroup2 = this.mComplianceLayout;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
            }
            showComplianceInfo();
        } else {
            if (this.adAction != null) {
                if (isYYAd()) {
                    this.adAction.setText("点击查看");
                } else {
                    this.adAction.setText("查看详情");
                }
            }
            ViewGroup viewGroup3 = this.mComplianceLayout;
            if (viewGroup3 != null) {
                viewGroup3.setVisibility(8);
            }
        }
        TextView textView4 = this.mAd;
        if (textView4 != null) {
            setAdText(textView4);
        }
        if (isVideoAd()) {
            ViewGroup viewGroup4 = this.mVideoView;
            if (viewGroup4 != null) {
                viewGroup4.setVisibility(0);
                addVideoView(this.mVideoView);
            }
            ImageView imageView3 = this.mAdImgView;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
        } else {
            ViewGroup viewGroup5 = this.mVideoView;
            if (viewGroup5 != null) {
                viewGroup5.setVisibility(8);
            }
            ImageView imageView4 = this.mAdImgView;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
                if (singleImage != null && !TextUtils.isEmpty(singleImage.getUrl())) {
                    if (singleImage.getUrl().endsWith(".gif")) {
                        Glide.with(this.mContext).asGif().load2(singleImage.getUrl()).into(this.mAdImgView);
                    } else {
                        Glide.with(this.mContext).load2(singleImage.getUrl()).into(this.mAdImgView);
                    }
                }
            }
        }
        View view2 = this.clickBtnButton;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.pop.LxAdPopView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    LxAdPopView.this.popAdClick("0", 2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popAdClick(String str, int i) {
        LxAdLog.d("LxAdPopView popAdClick  ");
        LxPopAdDialog lxPopAdDialog = this.adDialog;
        if (lxPopAdDialog == null || !lxPopAdDialog.isShowing()) {
            return;
        }
        clickEventReplace(str, i);
    }

    private void showComplianceInfo() {
        if (this.mAppVersion != null && !TextUtils.isEmpty(this.mAdItem.getAppVersion())) {
            this.mAppVersion.setText("版本号:" + this.mAdItem.getAppVersion());
        }
        if (this.mCompany != null && !TextUtils.isEmpty(this.mAdItem.getAdvertiserName())) {
            this.mCompany.setText(this.mAdItem.getAdvertiserName());
        }
        TextView textView = this.mPermission;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.pop.LxAdPopView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    String permissionUrl = LxAdPopView.this.mAdItem.getPermissionUrl();
                    if (permissionUrl == null || !permissionUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        BLPlatform.startTextActivity(permissionUrl, "权限", LxAdPopView.this.getContext());
                    } else {
                        AdComplianceUtil.startCommonWebView(permissionUrl, "权限", LxAdPopView.this.getContext());
                    }
                }
            });
        }
        TextView textView2 = this.mPrivacy;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.pop.LxAdPopView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    String privacyPolicyUrl = LxAdPopView.this.mAdItem.getPrivacyPolicyUrl();
                    if (privacyPolicyUrl == null || !privacyPolicyUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        BLPlatform.startTextActivity(privacyPolicyUrl, "隐私", LxAdPopView.this.getContext());
                    } else {
                        AdComplianceUtil.startCommonWebView(privacyPolicyUrl, "隐私", LxAdPopView.this.getContext());
                    }
                }
            });
        }
        View view = this.mAllFunctionLayout;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.pop.LxAdPopView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (CheckDoubleClick.isFastDoubleClick()) {
                        return;
                    }
                    String descriptionUrl = LxAdPopView.this.mAdItem.getDescriptionUrl();
                    if (descriptionUrl == null || !descriptionUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        BLPlatform.startTextActivity(descriptionUrl, "功能", LxAdPopView.this.getContext());
                    } else {
                        AdComplianceUtil.startCommonWebView(descriptionUrl, "功能", LxAdPopView.this.getContext());
                    }
                }
            });
        }
    }

    private void startDelayTimeCheck() {
        this.delayTimer = new Timer();
        this.delayTimer.schedule(new TimerTask() { // from class: com.wifi.adsdk.pop.LxAdPopView.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LxAdPopView.this.mainHandler.post(new Runnable() { // from class: com.wifi.adsdk.pop.LxAdPopView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LxAdPopView.this.showEventReplace("插屏延时判断展示popShowDelay:" + LxAdPopView.this.popShowDelay);
                    }
                });
            }
        }, this.popShowDelay);
    }

    private void startScaleAnimation(View view) {
        if (view != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.03f, 0.98f, 1.03f, 0.98f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(700L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            view.startAnimation(scaleAnimation);
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdBaseView
    public void adDestroy() {
        if (this.popShowDelay > 0) {
            showEventReplace("插屏被销毁时候展示popShowDelay:" + this.popShowDelay);
        }
        super.adDestroy();
    }

    public void initView(LxPopAdDialog lxPopAdDialog) {
        if (this.mAdItem == null) {
            if (lxPopAdDialog != null) {
                lxPopAdDialog.dismiss();
            }
        } else {
            this.adDialog = lxPopAdDialog;
            View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.layout_pop_ad, (ViewGroup) null);
            addView(viewInflate);
            initUi(viewInflate);
            initSensor();
            adShow();
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdBaseView
    public void readyToShowEvent() {
        if (this.popShowDelay == -1) {
            int popShowConfig = getPopShowConfig();
            this.popShowDelay = popShowConfig;
            if (popShowConfig == 0) {
                showEventReplace("插屏popShowDelay为0正常展示");
            } else {
                startDelayTimeCheck();
            }
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdBaseView
    public void sensorClick() {
        LxAdLog.d("LxAdSensorUtil popad sensorClick ");
        popAdClick("2", 3);
    }

    public void setShowListener(LxPopShowListener lxPopShowListener) {
        this.showListener = lxPopShowListener;
    }

    @Override // com.wifi.adsdk.entity.LxAdBaseView
    public void showEventReplace(String str) {
        cancelDelayTimer();
        super.showEventReplace(str);
    }

    private void adShow() {
    }
}
