package com.wifi.ad.core.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wifi.ad.core.R;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.compliance.AdNativeStyleManagerSDK;
import com.wifi.ad.core.custom.flow.GlideImageLoader;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.imageloader.GlideRoundedTransformation;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.wifi.ad.core.utils.ScreenUtil;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.ad.core.view.AspectRatioFrameLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DefPopNativeDialogStyle2 extends Dialog implements NestAdData.AppDownloadListener, NestAdData.AdInteractionListener, View.OnClickListener {
    private static final float[][] sSupportSize = {new float[]{16.0f, 9.0f}, new float[]{3.0f, 2.0f}, new float[]{9.0f, 16.0f}};
    private View adYYLayout;
    private ImageView blurBg;
    private View clickBtnButton;
    private View csjCloseView;
    private FrameLayout interactiveTypeLayout;
    private boolean isCsjAd;
    private Activity mAct;
    private TextView mAd;
    private ViewGroup mAdAllLayout;
    private ViewGroup mAdFramelayout;
    private ImageView mAdIcon;
    private ViewGroup mAdImgVideoLayout;
    private ImageView mAdImgView;
    private LinearLayout mAdInfoLayout;
    private ImageView mAdLogo;
    private ViewGroup mAllFunctionLayout;
    private TextView mAppDesc;
    private TextView mAppName;
    private TextView mAppVersion;
    private TextView mBtn;
    private ImageView mClose;
    private TextView mCompany;
    private ViewGroup mComplianceLayout;
    private ViewGroup mContentView;
    private Context mContext;
    private TextView mFunction;
    private TextView mFuntionView;
    private AspectRatioFrameLayout mHeadIconLayout;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private TextView mPermission;
    private TextView mPrivacy;
    private NestAdData mResultBean;
    private RelativeLayout mRootLayout;
    private ViewGroup mVideoView;
    private final String pauseAdText;
    private PopShowListener showListener;

    public DefPopNativeDialogStyle2(@NonNull Context context) {
        super(context, R.style.AdSDKFullScreenDialog);
        this.mAct = null;
        this.mBtn = null;
        this.adYYLayout = null;
        this.mAdIcon = null;
        this.mAppName = null;
        this.mAppDesc = null;
        this.pauseAdText = "暂停下载";
        this.clickBtnButton = null;
        this.blurBg = null;
        this.isCsjAd = false;
        setCanceledOnTouchOutside(false);
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.wifi.ad.core.helper.DefPopNativeDialogStyle2.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) throws JSONException {
                DefPopNativeDialogStyle2.this.onAdClose();
                if (DefPopNativeDialogStyle2.this.mOnDismissListener != null) {
                    DefPopNativeDialogStyle2.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.mContentView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.adsdk_dialog_interstitial_style2, (ViewGroup) null);
        this.mContext = context.getApplicationContext();
        if (context instanceof Activity) {
            this.mAct = (Activity) context;
        }
    }

    private void changeLxAdxLayout(NestAdData nestAdData) {
        ViewGroup viewGroup;
        if (nestAdData == null || !SDKAlias.LXAD.getType().equals(nestAdData.getAdType()) || (viewGroup = this.mAdFramelayout) == null || this.mAdAllLayout == null) {
            return;
        }
        try {
            ViewGroup viewGroupWrapDecorationIfADX = wrapDecorationIfADX(viewGroup, nestAdData);
            if (viewGroupWrapDecorationIfADX != this.mAdFramelayout) {
                this.mAdAllLayout.addView(viewGroupWrapDecorationIfADX);
            }
        } catch (Exception unused) {
        }
    }

    private String getCompany(NestAdData nestAdData) {
        if (nestAdData == null) {
            return "";
        }
        String adAppDeveloperName = nestAdData.getAdAppDeveloperName();
        return !TextUtils.isEmpty(adAppDeveloperName) ? adAppDeveloperName : "";
    }

    private String getImageUrl() {
        List<String> imageList;
        NestAdData nestAdData = this.mResultBean;
        if (nestAdData == null || (imageList = nestAdData.getImageList()) == null || imageList.isEmpty()) {
            return null;
        }
        return imageList.get(0);
    }

    private String getVersion(NestAdData nestAdData) {
        if (nestAdData == null) {
            return "";
        }
        String adAppVersion = nestAdData.getAdAppVersion();
        return !TextUtils.isEmpty(adAppVersion) ? adAppVersion : "";
    }

    private void initView() {
        this.mAdAllLayout = (ViewGroup) findViewById(R.id.pop_native_ad_all_layout);
        this.mAdImgVideoLayout = (ViewGroup) findViewById(R.id.ad_img_video_layout);
        this.mHeadIconLayout = (AspectRatioFrameLayout) findViewById(R.id.headIconLayout);
        this.mAdInfoLayout = (LinearLayout) findViewById(R.id.adInfoLayout);
        this.mComplianceLayout = (ViewGroup) findViewById(R.id.complianceLayout);
        this.mRootLayout = (RelativeLayout) findViewById(R.id.rootLayout);
        this.mAdFramelayout = (ViewGroup) findViewById(R.id.pop_ad_framelayout);
        View viewFindViewById = findViewById(R.id.csj_close);
        this.csjCloseView = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
    }

    private boolean isVideoType() {
        NestAdData nestAdData = this.mResultBean;
        if (nestAdData == null) {
            return false;
        }
        int iIntValue = nestAdData.getAdMode().intValue();
        return iIntValue == 4 || iIntValue == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdClose() throws JSONException {
        NestAdData nestAdData = this.mResultBean;
        if (nestAdData == null) {
            return;
        }
        EventReporter.INSTANCE.reportDefaultViewEvent(nestAdData, "nest_sdk_cancle_click", null);
        PopShowListener popShowListener = this.showListener;
        if (popShowListener != null) {
            popShowListener.onAdClose(this.mResultBean.getAdType(), this.mResultBean);
        }
    }

    private void registerViewAndAction(ViewGroup viewGroup, View view, List<View> list, View view2, View view3, View view4, ArrayList<View> arrayList) {
        if (this.mResultBean == null) {
            return;
        }
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.DefPopNativeDialogStyle2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view5) {
                    String adAppPrivacyUrl = DefPopNativeDialogStyle2.this.mResultBean.getAdAppPrivacyUrl();
                    if (TextUtils.isEmpty(adAppPrivacyUrl)) {
                        return;
                    }
                    AdComplianceUtil.startCommonWebView(adAppPrivacyUrl, DefPopNativeDialogStyle2.this.getContext().getString(R.string.adsdk_generic_ad_info_privacy), DefPopNativeDialogStyle2.this.getContext());
                }
            });
        }
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.DefPopNativeDialogStyle2.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view5) {
                    String adAppPermissionsUrl = DefPopNativeDialogStyle2.this.mResultBean.getAdAppPermissionsUrl();
                    if (TextUtils.isEmpty(adAppPermissionsUrl)) {
                        return;
                    }
                    AdComplianceUtil.startCommonWebView(adAppPermissionsUrl, DefPopNativeDialogStyle2.this.getContext().getString(R.string.adsdk_generic_ad_info_permission), DefPopNativeDialogStyle2.this.getContext());
                }
            });
        }
        if (view4 != null) {
            view4.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.DefPopNativeDialogStyle2.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view5) {
                    String adAppFunctionDescUrl = DefPopNativeDialogStyle2.this.mResultBean.getAdAppFunctionDescUrl();
                    if (TextUtils.isEmpty(adAppFunctionDescUrl)) {
                        return;
                    }
                    AdComplianceUtil.startCommonWebView(adAppFunctionDescUrl, DefPopNativeDialogStyle2.this.getContext().getString(R.string.ad_function), DefPopNativeDialogStyle2.this.getContext());
                }
            });
        }
        if (list != null) {
            this.mResultBean.setAdDownTextView(this.mBtn);
            if (this.mResultBean.getAdData() != null && SDKAlias.LXAD.getType().equals(this.mResultBean.getAdType())) {
                try {
                    if (this.mAct != null) {
                        Method declaredMethod = this.mResultBean.getAdData().getClass().getDeclaredMethod("setShowAct", Activity.class);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(this.mResultBean.getAdData(), this.mAct);
                    }
                } catch (Exception unused) {
                }
            }
            AdHelperFeed adHelperFeed = AdHelperFeed.INSTANCE;
            adHelperFeed.setOppoComInfoViews(this.mResultBean, this.mPrivacy, this.mPermission, this.mFuntionView);
            adHelperFeed.registerViewAndAction(viewGroup, view, (View[]) list.toArray(new View[list.size()]), null, null, this.mResultBean, arrayList);
        }
    }

    private void setAdText(TextView textView) {
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            textView.setText(R.string.adsdk_generic_ad_group_personalize);
        } else {
            textView.setText(R.string.adsdk_generic_ad_group_normal);
        }
    }

    private void setHeGui() {
        NestAdData nestAdData = this.mResultBean;
        if (nestAdData == null) {
            return;
        }
        String company = getCompany(nestAdData);
        String version = getVersion(this.mResultBean);
        TextView textView = this.mAppVersion;
        if (textView != null) {
            textView.setText("版本号:" + version);
        }
        TextView textView2 = this.mCompany;
        if (textView2 != null) {
            textView2.setText(company);
        }
        if (this.mAllFunctionLayout != null) {
            if (TextUtils.isEmpty(this.mResultBean.getAdAppFunctionDescUrl())) {
                this.mAllFunctionLayout.setVisibility(8);
            } else {
                this.mAllFunctionLayout.setVisibility(0);
            }
        }
    }

    private boolean shakeEnabled(NestAdData nestAdData) {
        if (nestAdData == null) {
            return false;
        }
        String adType = nestAdData.getAdType();
        if (SDKAlias.CSJ.getType().equals(adType)) {
            if (nestAdData.getShakeSwitch() == 1) {
                return true;
            }
        } else if (SDKAlias.LXAD.getType().equals(adType) && nestAdData.getShakeSwitchLxad() == 1) {
            return true;
        }
        return false;
    }

    private void showAppIconInfo() {
        int i;
        boolean z;
        int i2;
        NestAdData nestAdData = this.mResultBean;
        if (nestAdData == null) {
            return;
        }
        float nativeAdImgWidth = nestAdData.getNativeAdImgWidth();
        float nativeAdImgHeight = this.mResultBean.getNativeAdImgHeight();
        int i3 = 1;
        if (nativeAdImgWidth > 0.0f && nativeAdImgHeight > 0.0f) {
            float f = nativeAdImgWidth / nativeAdImgHeight;
            Float fValueOf = null;
            int i4 = 0;
            i = 0;
            while (true) {
                float[][] fArr = sSupportSize;
                if (i4 >= fArr.length) {
                    break;
                }
                float[] fArr2 = fArr[i4];
                float fAbs = Math.abs((fArr2[0] / fArr2[1]) - f);
                if (fValueOf == null || fAbs < fValueOf.floatValue()) {
                    fValueOf = Float.valueOf(fAbs);
                    i = i4;
                }
                i4++;
            }
        } else {
            i = 0;
        }
        WifiLog.d("DDT setDataAndShow in bind img width = " + nativeAdImgWidth + ", height = " + nativeAdImgHeight + " sizeIndex " + i);
        this.mHeadIconLayout.setResizeMode(1);
        AspectRatioFrameLayout aspectRatioFrameLayout = this.mHeadIconLayout;
        float[] fArr3 = sSupportSize[i];
        aspectRatioFrameLayout.setAspectRatio(fArr3[0] / fArr3[1]);
        View viewFindViewById = this.mContentView.findViewById(R.id.hengban_layout);
        View viewFindViewById2 = this.mContentView.findViewById(R.id.shuban_layout);
        if (i == 2) {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(0);
            this.mResultBean.setHwDownBtnTag("huawei_download_btn_group");
            ViewGroup viewGroup = this.mContentView;
            int i5 = R.id.ad_down_yaoyiyao_layout_shu;
            startScaleAnimation(viewGroup.findViewById(i5));
            View viewFindViewById3 = this.mContentView.findViewById(R.id.ad_yaoyiyao_shu);
            this.adYYLayout = viewFindViewById3;
            if (shakeEnabled(this.mResultBean)) {
                viewFindViewById3.setVisibility(0);
            } else {
                viewFindViewById3.setVisibility(8);
            }
            this.mComplianceLayout.addView((ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.adsdk_dialog_interstitial_apphegui_view_style2, (ViewGroup) null));
            this.mPermission = (TextView) findViewById(R.id.permission);
            int i6 = R.id.function;
            this.mFuntionView = (TextView) findViewById(i6);
            this.mFunction = (TextView) findViewById(i6);
            this.mAllFunctionLayout = (ViewGroup) findViewById(R.id.function_all_layout);
            this.mPrivacy = (TextView) findViewById(R.id.privacy);
            this.mAppVersion = (TextView) findViewById(R.id.version);
            this.mCompany = (TextView) findViewById(R.id.company);
            this.mAdImgView = (ImageView) findViewById(R.id.bigImg_shu);
            this.interactiveTypeLayout = (FrameLayout) findViewById(R.id.interactive_type_layout_shu);
            this.mAd = (TextView) findViewById(R.id.ad_shu);
            this.mAdLogo = (ImageView) findViewById(R.id.ad_logo_shu);
            this.mClose = (ImageView) findViewById(R.id.close_shu);
            this.mVideoView = (ViewGroup) findViewById(R.id.videoView_shu);
            this.mClose.setOnClickListener(this);
            if (!this.isCsjAd) {
                RelativeLayout relativeLayout = this.mRootLayout;
                ScreenUtil screenUtil = ScreenUtil.INSTANCE;
                relativeLayout.setPadding(screenUtil.dp2px(this.mContext, 20.0f), 0, screenUtil.dp2px(this.mContext, 20.0f), 0);
            }
            if (!TextUtils.isEmpty(this.mResultBean.getAdAppName())) {
                this.mAppName = (TextView) this.mContentView.findViewById(R.id.ad_name_shu);
                if (!TextUtils.isEmpty(this.mResultBean.getAdAppName())) {
                    this.mAppName.setText(this.mResultBean.getAdAppName());
                } else if (!TextUtils.isEmpty(this.mResultBean.getTitle())) {
                    this.mAppName.setText(this.mResultBean.getTitle());
                }
            }
            this.blurBg = (ImageView) this.mContentView.findViewById(R.id.blur_bg_layout);
            String imageUrl = getImageUrl();
            if (!TextUtils.isEmpty(imageUrl) && this.blurBg != null) {
                WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
                if (wifiNestAd.getMAdRequestCallBack() != null) {
                    wifiNestAd.getMAdRequestCallBack().showBlurImg(imageUrl, this.blurBg);
                }
            }
            if (!TextUtils.isEmpty(this.mResultBean.getDescription())) {
                TextView textView = (TextView) this.mContentView.findViewById(R.id.ad_desc_shu);
                this.mAppDesc = textView;
                textView.setText(this.mResultBean.getDescription());
            }
            this.clickBtnButton = this.mContentView.findViewById(i5);
            this.mBtn = (TextView) findViewById(R.id.adInfoDownload_shu);
            if (getActionType() == 1) {
                this.mBtn.setText("点击下载");
                z = true;
            } else {
                this.mBtn.setText("立即查看");
                z = false;
                i3 = 2;
            }
            if (AdNativeStyleManagerSDK.isShowComplianceInfo(this.mResultBean.getAdScene() + "", i3)) {
                this.mComplianceLayout.setVisibility(0);
            } else {
                this.mComplianceLayout.setVisibility(8);
            }
            i2 = 0;
        } else {
            viewFindViewById.setVisibility(0);
            viewFindViewById2.setVisibility(8);
            this.mResultBean.setHwDownBtnTag("huawei_download_btn");
            ViewGroup viewGroup2 = this.mContentView;
            int i7 = R.id.ad_down_yaoyiyao_layout;
            startScaleAnimation(viewGroup2.findViewById(i7));
            View viewFindViewById4 = this.mContentView.findViewById(R.id.ad_yaoyiyao);
            this.adYYLayout = viewFindViewById4;
            if (shakeEnabled(this.mResultBean)) {
                viewFindViewById4.setVisibility(0);
            } else {
                viewFindViewById4.setVisibility(8);
            }
            this.mComplianceLayout.addView((ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.adsdk_dialog_interstitial_apphegui_view_style2, (ViewGroup) null));
            this.mPermission = (TextView) findViewById(R.id.permission);
            int i8 = R.id.function;
            this.mFuntionView = (TextView) findViewById(i8);
            this.mFunction = (TextView) findViewById(i8);
            this.mAllFunctionLayout = (ViewGroup) findViewById(R.id.function_all_layout);
            this.mPrivacy = (TextView) findViewById(R.id.privacy);
            this.mAppVersion = (TextView) findViewById(R.id.version);
            this.mCompany = (TextView) findViewById(R.id.company);
            this.mAdImgView = (ImageView) findViewById(R.id.bigImg);
            this.interactiveTypeLayout = (FrameLayout) findViewById(R.id.interactive_type_layout);
            this.mAd = (TextView) findViewById(R.id.ad);
            this.mAdLogo = (ImageView) findViewById(R.id.ad_logo);
            this.mClose = (ImageView) findViewById(R.id.close);
            this.mVideoView = (ViewGroup) findViewById(R.id.videoView);
            this.mClose.setOnClickListener(this);
            if (!this.isCsjAd) {
                RelativeLayout relativeLayout2 = this.mRootLayout;
                ScreenUtil screenUtil2 = ScreenUtil.INSTANCE;
                relativeLayout2.setPadding(screenUtil2.dp2px(this.mContext, 20.0f), 0, screenUtil2.dp2px(this.mContext, 20.0f), 0);
            }
            if (!TextUtils.isEmpty(this.mResultBean.getAdIcon())) {
                this.mAdIcon = (ImageView) this.mContentView.findViewById(R.id.adInfoIcon);
                GlideImageLoader glideImageLoader = new GlideImageLoader();
                Context context = this.mContext;
                ImageView imageView = this.mAdIcon;
                String adIcon = this.mResultBean.getAdIcon();
                Context context2 = this.mContext;
                glideImageLoader.loadImage(context, imageView, adIcon, new GlideRoundedTransformation(context2, ScreenUtil.INSTANCE.dp2px(context2, 8.0f)));
            }
            if (!TextUtils.isEmpty(this.mResultBean.getAdAppName())) {
                this.mAppName = (TextView) this.mContentView.findViewById(R.id.adInfoName);
                if (!TextUtils.isEmpty(this.mResultBean.getAdAppName())) {
                    this.mAppName.setText(this.mResultBean.getAdAppName());
                } else if (!TextUtils.isEmpty(this.mResultBean.getTitle())) {
                    this.mAppName.setText(this.mResultBean.getTitle());
                }
            }
            if (!TextUtils.isEmpty(this.mResultBean.getDescription())) {
                TextView textView2 = (TextView) this.mContentView.findViewById(R.id.adInfoDes);
                this.mAppDesc = textView2;
                textView2.setText(this.mResultBean.getDescription());
            }
            this.clickBtnButton = this.mContentView.findViewById(i7);
            this.mBtn = (TextView) findViewById(R.id.adInfoDownload);
            if (getActionType() == 1) {
                this.mBtn.setText("点击下载");
                z = true;
            } else {
                this.mBtn.setText("立即查看");
                z = false;
                i3 = 2;
            }
            if (AdNativeStyleManagerSDK.isShowComplianceInfo(this.mResultBean.getAdScene() + "", i3)) {
                this.mComplianceLayout.setVisibility(0);
            } else {
                this.mComplianceLayout.setVisibility(8);
            }
            i2 = 2;
        }
        if (this.isCsjAd) {
            ImageView imageView2 = this.mClose;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            this.csjCloseView.setVisibility(0);
        }
        showInteractiveTypeLayout(i2, z);
    }

    private void showInteractiveTypeLayout(int i, boolean z) {
        FrameLayout frameLayout = this.interactiveTypeLayout;
        if (frameLayout != null) {
            WkInteractiveManager.addInteractiveView(frameLayout, this.mResultBean, i, z, 1001);
        }
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

    private void switchVideoOrImage(ViewGroup viewGroup, ImageView imageView) {
        if (this.mResultBean == null) {
            return;
        }
        if (!isVideoType()) {
            String imageUrl = getImageUrl();
            if (TextUtils.isEmpty(imageUrl) || imageView == null) {
                return;
            }
            imageView.setVisibility(0);
            WifiNestAd.INSTANCE.getImageLoader().display(imageView, imageUrl);
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                return;
            }
            return;
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            viewGroup.setVisibility(0);
            View adView = this.mResultBean.getAdView();
            if (adView != null) {
                ViewParent parent = adView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(adView);
                }
                viewGroup.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                AdDownViVoConfig.checkVideoViewClick(this.mResultBean, viewGroup);
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    private ViewGroup wrapDecorationIfADX(ViewGroup viewGroup, NestAdData nestAdData) {
        if (nestAdData != null && viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (nestAdData.getAdData() != null) {
                try {
                    Method declaredMethod = nestAdData.getAdData().getClass().getDeclaredMethod("createLxAdNativeContainer", NestAdData.class);
                    declaredMethod.setAccessible(true);
                    Object objInvoke = declaredMethod.invoke(nestAdData.getAdData(), nestAdData);
                    if (objInvoke instanceof ViewGroup) {
                        viewGroup2.removeView(viewGroup);
                        ((ViewGroup) objInvoke).addView(viewGroup, new ViewGroup.LayoutParams(-1, -1));
                        return (ViewGroup) objInvoke;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return viewGroup;
    }

    public int getActionType() {
        NestAdData nestAdData = this.mResultBean;
        if (nestAdData == null) {
            return 0;
        }
        return nestAdData.getInteractionType().intValue();
    }

    @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
    public void onAdClicked(@NonNull NestAdData nestAdData) {
        PopShowListener popShowListener = this.showListener;
        if (popShowListener != null) {
            popShowListener.onAdClicked(nestAdData.getAdType(), nestAdData);
        }
    }

    @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
    public void onAdExposed(@NonNull NestAdData nestAdData) {
        PopShowListener popShowListener = this.showListener;
        if (popShowListener != null) {
            popShowListener.onAdExpose(nestAdData.getAdType(), nestAdData);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.close || view.getId() == R.id.close_shu || view.getId() == R.id.csj_close) {
            dismiss();
            try {
                if (this.mResultBean == null || !SDKAlias.LXAD.getType().equals(this.mResultBean.getAdType()) || this.mResultBean.getAdData() == null) {
                    return;
                }
                Method declaredMethod = this.mResultBean.getAdData().getClass().getDeclaredMethod("adRemoveDone", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.mResultBean.getAdData(), new Object[0]);
            } catch (Exception e) {
                WifiLog.d("e " + e.toString());
            }
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.mContentView);
        initView();
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadComplete(@NonNull NestAdData nestAdData) {
        WifiLog.d("DefInterstitialAdDialog onDownloadComplete...");
        PopShowListener popShowListener = this.showListener;
        if (popShowListener != null) {
            popShowListener.onDownloadComplete(nestAdData.getAdType(), nestAdData);
        }
        TextView textView = this.mBtn;
        if (textView != null) {
            textView.setText("立即安装");
        }
        View view = this.adYYLayout;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.adYYLayout.setVisibility(8);
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadFailed(@NonNull NestAdData nestAdData) {
        WifiLog.d("DefInterstitialAdDialog onDownloadFailed...");
        PopShowListener popShowListener = this.showListener;
        if (popShowListener != null) {
            popShowListener.onDownloadFailed(nestAdData.getAdType(), nestAdData);
        }
        TextView textView = this.mBtn;
        if (textView != null) {
            textView.setText("下载失败，稍后重试");
        }
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadInstalled(@NonNull NestAdData nestAdData) {
        WifiLog.d("DefInterstitialAdDialog onDownloadInstalled...");
        PopShowListener popShowListener = this.showListener;
        if (popShowListener != null) {
            popShowListener.onDownloadInstalled(nestAdData.getAdType(), nestAdData);
        }
        TextView textView = this.mBtn;
        if (textView != null) {
            textView.setText("立即打开");
        }
        View view = this.adYYLayout;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.adYYLayout.setVisibility(8);
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadPause(@NonNull NestAdData nestAdData) {
        WifiLog.d("DefInterstitialAdDialog onDownloadPause...");
        TextView textView = this.mBtn;
        if (textView != null) {
            textView.setText("继续下载");
        }
        View view = this.adYYLayout;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.adYYLayout.setVisibility(8);
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadProgress(@NonNull NestAdData nestAdData, int i) {
        WifiLog.d("DefInterstitialAdDialog onDownloadProgress progress=" + i);
        TextView textView = this.mBtn;
        if (textView != null) {
            textView.setText("暂停下载");
        }
        View view = this.adYYLayout;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.adYYLayout.setVisibility(8);
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadStart(@NonNull NestAdData nestAdData) {
        WifiLog.d("DefInterstitialAdDialog onDownloadStart...");
        PopShowListener popShowListener = this.showListener;
        if (popShowListener != null) {
            popShowListener.onDownloadStart(nestAdData.getAdType(), nestAdData);
        }
    }

    public final void setDataAndShow(NestAdData nestAdData) {
        if (nestAdData == null) {
            return;
        }
        Activity activity = this.mAct;
        if (activity == null || !activity.isFinishing()) {
            this.mResultBean = nestAdData;
            if (SDKAlias.CSJ.getType().equals(nestAdData.getAdType())) {
                this.isCsjAd = true;
            }
            WifiLog.d("setDataAndShow isCsjAd..." + this.isCsjAd);
            show();
            changeLxAdxLayout(nestAdData);
            showAppIconInfo();
            nestAdData.setAppDownloadListener(this);
            nestAdData.setAdInteractionListener(this);
            nestAdData.setVideoAdListener(new NestAdData.VideoAdListener() { // from class: com.wifi.ad.core.helper.DefPopNativeDialogStyle2.5
                @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
                public void onVideoComplete(@NonNull NestAdData nestAdData2) {
                    WifiLog.d("DefInterstitialAdDialog onVideoComplete...");
                    if (DefPopNativeDialogStyle2.this.showListener != null) {
                        DefPopNativeDialogStyle2.this.showListener.onVideoComplete(nestAdData2.getAdType(), nestAdData2);
                    }
                }

                @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
                public void onVideoError(@NonNull NestAdData nestAdData2) {
                    WifiLog.d("DefInterstitialAdDialog onVideoError...");
                    if (DefPopNativeDialogStyle2.this.showListener != null) {
                        DefPopNativeDialogStyle2.this.showListener.onVideoError(nestAdData2.getAdType(), nestAdData2);
                    }
                }

                @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
                public void onVideoPause(@NonNull NestAdData nestAdData2) {
                    WifiLog.d("DefInterstitialAdDialog onVideoPause...");
                    if (DefPopNativeDialogStyle2.this.showListener != null) {
                        DefPopNativeDialogStyle2.this.showListener.onVideoPause(nestAdData2.getAdType(), nestAdData2);
                    }
                }

                @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
                public void onVideoStart(@NonNull NestAdData nestAdData2) {
                    WifiLog.d("DefInterstitialAdDialog onVideoStart...");
                    if (DefPopNativeDialogStyle2.this.showListener != null) {
                        DefPopNativeDialogStyle2.this.showListener.onVideoStart(nestAdData2.getAdType(), nestAdData2);
                    }
                }
            });
            switchVideoOrImage(this.mVideoView, this.mAdImgView);
            setAdText(this.mAd);
            this.mAdLogo.setImageResource(this.mResultBean.getAdLogoResId());
            setHeGui();
            List<View> arrayList = new ArrayList<>();
            ArrayList<View> arrayList2 = new ArrayList<>();
            ImageView imageView = this.mAdImgView;
            if (imageView != null && imageView.getVisibility() == 0) {
                arrayList2.add(this.mAdImgView);
            }
            ViewGroup viewGroup = this.mVideoView;
            if (viewGroup != null && viewGroup.getVisibility() == 0) {
                arrayList2.add(this.mVideoView);
            }
            ImageView imageView2 = this.mAdIcon;
            if (imageView2 != null && imageView2.getVisibility() == 0) {
                arrayList2.add(this.mAdIcon);
            }
            View view = this.mAppDesc;
            if (view != null) {
                arrayList2.add(view);
            }
            View view2 = this.mAppName;
            if (view2 != null) {
                arrayList2.add(view2);
            }
            View view3 = this.mBtn;
            if (view3 != null) {
                arrayList2.add(view3);
                this.mBtn.setTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
            }
            View view4 = this.clickBtnButton;
            if (view4 != null) {
                arrayList2.add(view4);
            }
            View view5 = this.blurBg;
            if (view5 != null) {
                arrayList2.add(view5);
            }
            if (SDKAlias.GDT.getType().equals(nestAdData.getAdType())) {
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(this.mContentView);
            }
            registerViewAndAction(this.mContentView, this.clickBtnButton, arrayList, this.mPrivacy, this.mPermission, this.mFunction, arrayList2);
        }
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShowListener(PopShowListener popShowListener) {
        this.showListener = popShowListener;
    }

    @Override // android.app.Dialog
    public void show() {
        WindowManager.LayoutParams attributes;
        try {
            super.show();
            Window window = getWindow();
            if (window == null || (attributes = window.getAttributes()) == null) {
                return;
            }
            attributes.width = -1;
            attributes.height = -2;
            window.addFlags(2);
            attributes.dimAmount = 0.6f;
            attributes.gravity = 17;
            window.setAttributes(attributes);
        } catch (Exception unused) {
        }
    }
}
