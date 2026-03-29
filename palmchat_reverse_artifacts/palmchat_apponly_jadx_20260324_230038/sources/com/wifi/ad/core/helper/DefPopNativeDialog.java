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
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.wifi.ad.core.utils.ScreenUtil;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.ad.core.view.AspectRatioFrameLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DefPopNativeDialog extends Dialog implements NestAdData.AppDownloadListener, NestAdData.AdInteractionListener, View.OnClickListener {
    private static final float[][] sSupportSize = {new float[]{16.0f, 9.0f}, new float[]{3.0f, 2.0f}, new float[]{9.0f, 16.0f}};
    private Activity mAct;
    private TextView mAd;
    private ViewGroup mAdAllLayout;
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
    private AspectRatioFrameLayout mHeadIconLayout;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private TextView mPermission;
    private TextView mPrivacy;
    private NestAdData mResultBean;
    private RelativeLayout mRootLayout;
    private ViewGroup mVideoView;
    private final String pauseAdText;
    private PopShowListener showListener;

    public DefPopNativeDialog(@NonNull Context context) {
        super(context, R.style.AdSDKFullScreenDialog);
        this.mAct = null;
        this.mBtn = null;
        this.mAdIcon = null;
        this.mAppName = null;
        this.mAppDesc = null;
        this.pauseAdText = "暂停下载";
        setCanceledOnTouchOutside(false);
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.wifi.ad.core.helper.DefPopNativeDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) throws JSONException {
                DefPopNativeDialog.this.onAdClose();
                if (DefPopNativeDialog.this.mOnDismissListener != null) {
                    DefPopNativeDialog.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.mContentView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.adsdk_dialog_interstitial, (ViewGroup) null);
        this.mContext = context.getApplicationContext();
        if (context instanceof Activity) {
            this.mAct = (Activity) context;
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
        this.mAdImgView = (ImageView) findViewById(R.id.bigImg);
        this.mAd = (TextView) findViewById(R.id.ad);
        this.mAdLogo = (ImageView) findViewById(R.id.ad_logo);
        this.mClose = (ImageView) findViewById(R.id.close);
        this.mVideoView = (ViewGroup) findViewById(R.id.videoView);
        this.mClose.setOnClickListener(this);
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

    private void registerViewAndAction(ViewGroup viewGroup, View view, List<View> list, View view2, View view3, View view4) {
        if (this.mResultBean == null) {
            return;
        }
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.DefPopNativeDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view5) {
                    String adAppPrivacyUrl = DefPopNativeDialog.this.mResultBean.getAdAppPrivacyUrl();
                    if (TextUtils.isEmpty(adAppPrivacyUrl)) {
                        return;
                    }
                    AdComplianceUtil.startCommonWebView(adAppPrivacyUrl, DefPopNativeDialog.this.getContext().getString(R.string.adsdk_generic_ad_info_privacy), DefPopNativeDialog.this.getContext());
                }
            });
        }
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.DefPopNativeDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view5) {
                    String adAppPermissionsUrl = DefPopNativeDialog.this.mResultBean.getAdAppPermissionsUrl();
                    if (TextUtils.isEmpty(adAppPermissionsUrl)) {
                        return;
                    }
                    AdComplianceUtil.startCommonWebView(adAppPermissionsUrl, DefPopNativeDialog.this.getContext().getString(R.string.adsdk_generic_ad_info_permission), DefPopNativeDialog.this.getContext());
                }
            });
        }
        if (view4 != null) {
            view4.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.DefPopNativeDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view5) {
                    String adAppFunctionDescUrl = DefPopNativeDialog.this.mResultBean.getAdAppFunctionDescUrl();
                    if (TextUtils.isEmpty(adAppFunctionDescUrl)) {
                        return;
                    }
                    AdComplianceUtil.startCommonWebView(adAppFunctionDescUrl, DefPopNativeDialog.this.getContext().getString(R.string.ad_function), DefPopNativeDialog.this.getContext());
                }
            });
        }
        if (list != null) {
            AdHelperFeed.INSTANCE.registerViewAndAction(viewGroup, view, (View[]) list.toArray(new View[list.size()]), null, null, this.mResultBean);
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

    private void showAppIconInfo() {
        int i;
        NestAdData nestAdData = this.mResultBean;
        if (nestAdData == null) {
            return;
        }
        float nativeAdImgWidth = nestAdData.getNativeAdImgWidth();
        float nativeAdImgHeight = this.mResultBean.getNativeAdImgHeight();
        int i2 = 1;
        if (nativeAdImgWidth > 0.0f && nativeAdImgHeight > 0.0f) {
            float f = nativeAdImgWidth / nativeAdImgHeight;
            Float fValueOf = null;
            int i3 = 0;
            i = 0;
            while (true) {
                float[][] fArr = sSupportSize;
                if (i3 >= fArr.length) {
                    break;
                }
                float[] fArr2 = fArr[i3];
                float fAbs = Math.abs((fArr2[0] / fArr2[1]) - f);
                if (fValueOf == null || fAbs < fValueOf.floatValue()) {
                    fValueOf = Float.valueOf(fAbs);
                    i = i3;
                }
                i3++;
            }
        } else {
            i = 0;
        }
        WifiLog.d("DDT setDataAndShow in bind img width = " + nativeAdImgWidth + ", height = " + nativeAdImgHeight + " sizeIndex " + i);
        this.mHeadIconLayout.setResizeMode(1);
        AspectRatioFrameLayout aspectRatioFrameLayout = this.mHeadIconLayout;
        float[] fArr3 = sSupportSize[i];
        aspectRatioFrameLayout.setAspectRatio(fArr3[0] / fArr3[1]);
        if (i == 0 || i == 1) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.adsdk_dialog_interstitial_info_view, (ViewGroup) null);
            this.mAdInfoLayout.addView(viewGroup);
            this.mComplianceLayout.addView((ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.adsdk_dialog_interstitial_apphegui_view, (ViewGroup) null));
            this.mPermission = (TextView) findViewById(R.id.permission);
            this.mFunction = (TextView) findViewById(R.id.function);
            this.mAllFunctionLayout = (ViewGroup) findViewById(R.id.function_all_layout);
            this.mPrivacy = (TextView) findViewById(R.id.privacy);
            this.mAppVersion = (TextView) findViewById(R.id.version);
            this.mCompany = (TextView) findViewById(R.id.company);
            RelativeLayout relativeLayout = this.mRootLayout;
            ScreenUtil screenUtil = ScreenUtil.INSTANCE;
            relativeLayout.setPadding(screenUtil.dp2px(this.mContext, 20.0f), 0, screenUtil.dp2px(this.mContext, 20.0f), 0);
            if (!TextUtils.isEmpty(this.mResultBean.getAdIcon())) {
                this.mAdIcon = (ImageView) viewGroup.findViewById(R.id.adInfoIcon);
                GlideImageLoader glideImageLoader = new GlideImageLoader();
                Context context = this.mContext;
                ImageView imageView = this.mAdIcon;
                String adIcon = this.mResultBean.getAdIcon();
                Context context2 = this.mContext;
                glideImageLoader.loadImage(context, imageView, adIcon, new GlideRoundedTransformation(context2, screenUtil.dp2px(context2, 8.0f)));
            }
            if (!TextUtils.isEmpty(this.mResultBean.getAdAppName())) {
                this.mAppName = (TextView) viewGroup.findViewById(R.id.adInfoName);
                if (!TextUtils.isEmpty(this.mResultBean.getAdAppName())) {
                    this.mAppName.setText(this.mResultBean.getAdAppName());
                } else if (!TextUtils.isEmpty(this.mResultBean.getTitle())) {
                    this.mAppName.setText(this.mResultBean.getTitle());
                }
            }
            if (!TextUtils.isEmpty(this.mResultBean.getDescription())) {
                ((TextView) viewGroup.findViewById(R.id.adInfoDes)).setText(this.mResultBean.getDescription());
            }
            this.mBtn = (TextView) findViewById(R.id.adInfoDownload);
            if (getActionType() == 1) {
                this.mBtn.setText("立即下载");
            } else {
                this.mBtn.setText("立即查看");
                i2 = 2;
            }
            if (AdNativeStyleManagerSDK.isShowComplianceInfo(this.mResultBean.getAdScene() + "", i2)) {
                this.mComplianceLayout.setVisibility(0);
                return;
            } else {
                this.mComplianceLayout.setVisibility(8);
                return;
            }
        }
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.adsdk_dialog_interstitial_info_view2, (ViewGroup) null);
        this.mAdInfoLayout.addView(viewGroup2);
        this.mComplianceLayout.addView((ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.adsdk_dialog_interstitial_apphegui_view2, (ViewGroup) null));
        this.mPermission = (TextView) findViewById(R.id.permission);
        this.mFunction = (TextView) findViewById(R.id.function);
        this.mAllFunctionLayout = (ViewGroup) findViewById(R.id.function_all_layout);
        this.mPrivacy = (TextView) findViewById(R.id.privacy);
        this.mAppVersion = (TextView) findViewById(R.id.version);
        this.mCompany = (TextView) findViewById(R.id.company);
        RelativeLayout relativeLayout2 = this.mRootLayout;
        ScreenUtil screenUtil2 = ScreenUtil.INSTANCE;
        relativeLayout2.setPadding(screenUtil2.dp2px(this.mContext, 60.0f), 0, screenUtil2.dp2px(this.mContext, 60.0f), 0);
        if (!TextUtils.isEmpty(this.mResultBean.getAdIcon())) {
            this.mAdIcon = (ImageView) viewGroup2.findViewById(R.id.adInfoIcon);
            GlideImageLoader glideImageLoader2 = new GlideImageLoader();
            Context context3 = this.mContext;
            ImageView imageView2 = this.mAdIcon;
            String adIcon2 = this.mResultBean.getAdIcon();
            Context context4 = this.mContext;
            glideImageLoader2.loadImage(context3, imageView2, adIcon2, new GlideRoundedTransformation(context4, screenUtil2.dp2px(context4, 8.0f)));
        }
        if (!TextUtils.isEmpty(this.mResultBean.getAdAppName())) {
            this.mAppName = (TextView) viewGroup2.findViewById(R.id.adInfoName);
            if (!TextUtils.isEmpty(this.mResultBean.getAdAppName())) {
                this.mAppName.setText(this.mResultBean.getAdAppName());
            } else if (!TextUtils.isEmpty(this.mResultBean.getTitle())) {
                this.mAppName.setText(this.mResultBean.getTitle());
            }
        }
        if (!TextUtils.isEmpty(this.mResultBean.getDescription())) {
            TextView textView = (TextView) viewGroup2.findViewById(R.id.adInfoDes);
            this.mAppDesc = textView;
            textView.setText(this.mResultBean.getDescription());
        }
        this.mBtn = (TextView) findViewById(R.id.adInfoDownload);
        if (getActionType() == 1) {
            this.mBtn.setText("立即下载");
        } else {
            this.mBtn.setText("立即查看");
            i2 = 2;
        }
        if (AdNativeStyleManagerSDK.isShowComplianceInfo(this.mResultBean.getAdScene() + "", i2)) {
            this.mComplianceLayout.setVisibility(0);
        } else {
            this.mComplianceLayout.setVisibility(8);
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
        if (view.getId() == R.id.close) {
            dismiss();
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
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadPause(@NonNull NestAdData nestAdData) {
        WifiLog.d("DefInterstitialAdDialog onDownloadPause...");
        TextView textView = this.mBtn;
        if (textView != null) {
            textView.setText("继续下载");
        }
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadProgress(@NonNull NestAdData nestAdData, int i) {
        WifiLog.d("DefInterstitialAdDialog onDownloadProgress progress=" + i);
        TextView textView = this.mBtn;
        if (textView != null) {
            textView.setText("暂停下载");
        }
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
            show();
            showAppIconInfo();
            nestAdData.setAppDownloadListener(this);
            nestAdData.setAdInteractionListener(this);
            nestAdData.setVideoAdListener(new NestAdData.VideoAdListener() { // from class: com.wifi.ad.core.helper.DefPopNativeDialog.5
                @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
                public void onVideoComplete(@NonNull NestAdData nestAdData2) {
                    WifiLog.d("DefInterstitialAdDialog onVideoComplete...");
                    if (DefPopNativeDialog.this.showListener != null) {
                        DefPopNativeDialog.this.showListener.onVideoComplete(nestAdData2.getAdType(), nestAdData2);
                    }
                }

                @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
                public void onVideoError(@NonNull NestAdData nestAdData2) {
                    WifiLog.d("DefInterstitialAdDialog onVideoError...");
                    if (DefPopNativeDialog.this.showListener != null) {
                        DefPopNativeDialog.this.showListener.onVideoError(nestAdData2.getAdType(), nestAdData2);
                    }
                }

                @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
                public void onVideoPause(@NonNull NestAdData nestAdData2) {
                    WifiLog.d("DefInterstitialAdDialog onVideoPause...");
                    if (DefPopNativeDialog.this.showListener != null) {
                        DefPopNativeDialog.this.showListener.onVideoPause(nestAdData2.getAdType(), nestAdData2);
                    }
                }

                @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
                public void onVideoStart(@NonNull NestAdData nestAdData2) {
                    WifiLog.d("DefInterstitialAdDialog onVideoStart...");
                    if (DefPopNativeDialog.this.showListener != null) {
                        DefPopNativeDialog.this.showListener.onVideoStart(nestAdData2.getAdType(), nestAdData2);
                    }
                }
            });
            switchVideoOrImage(this.mVideoView, this.mAdImgView);
            setAdText(this.mAd);
            this.mAdLogo.setImageResource(this.mResultBean.getAdLogoResId());
            setHeGui();
            ArrayList arrayList = new ArrayList();
            if (SDKAlias.GDT.getType().equals(nestAdData.getAdType())) {
                ViewGroup viewGroup = this.mAdImgVideoLayout;
                if (viewGroup != null) {
                    arrayList.add(viewGroup);
                }
                ImageView imageView = this.mAdIcon;
                if (imageView != null) {
                    arrayList.add(imageView);
                }
                TextView textView = this.mAppDesc;
                if (textView != null) {
                    arrayList.add(textView);
                }
                TextView textView2 = this.mAppName;
                if (textView2 != null) {
                    arrayList.add(textView2);
                }
                TextView textView3 = this.mBtn;
                if (textView3 != null) {
                    arrayList.add(textView3);
                    this.mBtn.setTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
                }
                LinearLayout linearLayout = this.mAdInfoLayout;
                if (linearLayout != null) {
                    arrayList.add(linearLayout);
                }
            } else {
                arrayList.add(this.mContentView);
            }
            registerViewAndAction(this.mContentView, this.mBtn, arrayList, this.mPrivacy, this.mPermission, this.mFunction);
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
