package com.wifi.ad.core.helper;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wifi.ad.core.R;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.feedbanner.NestNativeAdFeedContainer;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.wifi.ad.core.utils.WifiLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class DefInterstitialAdDialog extends Dialog implements NestAdData.AppDownloadListener, NestAdData.AdInteractionListener {
    private DialogInterface.OnDismissListener mOnDismissListener;
    protected NestAdData mResultBean;
    private PopShowListener showListener;

    public DefInterstitialAdDialog(@NonNull Context context) {
        super(context, R.style.AdSDKFullScreenDialog);
        setCanceledOnTouchOutside(false);
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.wifi.ad.core.helper.DefInterstitialAdDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) throws JSONException {
                DefInterstitialAdDialog.this.onAdClose();
                if (DefInterstitialAdDialog.this.mOnDismissListener != null) {
                    DefInterstitialAdDialog.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdClose() throws JSONException {
        EventReporter.INSTANCE.reportDefaultViewEvent(this.mResultBean, "nest_sdk_cancle_click", null);
        PopShowListener popShowListener = this.showListener;
        if (popShowListener != null) {
            popShowListener.onAdClose(this.mResultBean.getAdType(), this.mResultBean);
        }
    }

    public int getActionType() {
        NestAdData nestAdData = this.mResultBean;
        if (nestAdData == null) {
            return 0;
        }
        return nestAdData.getInteractionType().intValue();
    }

    public String getCompany(NestAdData nestAdData) {
        if (nestAdData == null) {
            return "";
        }
        String adAppDeveloperName = nestAdData.getAdAppDeveloperName();
        return !TextUtils.isEmpty(adAppDeveloperName) ? adAppDeveloperName : "";
    }

    public int getHeight(NestAdData nestAdData) {
        return 0;
    }

    public String getImageUrl() {
        List<String> imageList;
        NestAdData nestAdData = this.mResultBean;
        if (nestAdData == null || (imageList = nestAdData.getImageList()) == null || imageList.isEmpty()) {
            return null;
        }
        return imageList.get(0);
    }

    public String getTitle(NestAdData nestAdData) {
        return nestAdData == null ? "" : nestAdData.getTitle();
    }

    public String getVersion(NestAdData nestAdData) {
        if (nestAdData == null) {
            return "";
        }
        String adAppVersion = nestAdData.getAdAppVersion();
        return !TextUtils.isEmpty(adAppVersion) ? adAppVersion : "";
    }

    public int getWidth(NestAdData nestAdData) {
        return 0;
    }

    public boolean isVideoType() {
        int iIntValue = this.mResultBean.getAdMode().intValue();
        return iIntValue == 4 || iIntValue == 5;
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

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadComplete(@NonNull NestAdData nestAdData) {
        WifiLog.d("DefInterstitialAdDialog onDownloadComplete...");
        refreshDownloadView(this.mResultBean, 100, 4);
        PopShowListener popShowListener = this.showListener;
        if (popShowListener != null) {
            popShowListener.onDownloadComplete(nestAdData.getAdType(), nestAdData);
        }
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadFailed(@NonNull NestAdData nestAdData) {
        WifiLog.d("DefInterstitialAdDialog onDownloadFailed...");
        refreshDownloadView(this.mResultBean, -1, 6);
        PopShowListener popShowListener = this.showListener;
        if (popShowListener != null) {
            popShowListener.onDownloadFailed(nestAdData.getAdType(), nestAdData);
        }
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadInstalled(@NonNull NestAdData nestAdData) {
        WifiLog.d("DefInterstitialAdDialog onDownloadInstalled...");
        refreshDownloadView(this.mResultBean, -1, 5);
        PopShowListener popShowListener = this.showListener;
        if (popShowListener != null) {
            popShowListener.onDownloadInstalled(nestAdData.getAdType(), nestAdData);
        }
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadPause(@NonNull NestAdData nestAdData) {
        WifiLog.d("DefInterstitialAdDialog onDownloadPause...");
        refreshDownloadView(this.mResultBean, -1, 2);
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadProgress(@NonNull NestAdData nestAdData, int i) {
        WifiLog.d("DefInterstitialAdDialog onDownloadProgress progress=" + i);
        refreshDownloadView(this.mResultBean, i, 3);
    }

    @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
    public void onDownloadStart(@NonNull NestAdData nestAdData) {
        WifiLog.d("DefInterstitialAdDialog onDownloadStart...");
        refreshDownloadView(this.mResultBean, -1, 1);
        PopShowListener popShowListener = this.showListener;
        if (popShowListener != null) {
            popShowListener.onDownloadStart(nestAdData.getAdType(), nestAdData);
        }
    }

    public void refreshDownloadView(NestAdData nestAdData, int i, int i2) {
        WifiLog.d("DefInterstitialAdDialog currentState = " + i2);
    }

    public void registerViewAndAction(ViewGroup viewGroup, View view, View[] viewArr, View view2, View view3) {
        int i = 0;
        if (!SDKAlias.GDT.getType().equals(this.mResultBean.getAdType())) {
            ArrayList arrayList = new ArrayList();
            if (view != null) {
                arrayList.add(view);
            }
            if (viewArr != null) {
                int length = viewArr.length;
                while (i < length) {
                    View view4 = viewArr[i];
                    if (view4 != null) {
                        arrayList.add(view4);
                    }
                    i++;
                }
            }
            if (view2 != null) {
                arrayList.add(view2);
            }
            if (view3 != null) {
                arrayList.add(view3);
            }
            AdHelperFeed.INSTANCE.registerViewAndAction(viewGroup, arrayList, this.mResultBean);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (view != null) {
            view.setTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
            arrayList2.add(view);
        }
        if (viewArr != null) {
            int length2 = viewArr.length;
            while (i < length2) {
                View view5 = viewArr[i];
                if (view5 != null) {
                    arrayList2.add(view5);
                }
                i++;
            }
        }
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.DefInterstitialAdDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view6) {
                    String adAppPrivacyUrl = DefInterstitialAdDialog.this.mResultBean.getAdAppPrivacyUrl();
                    if (TextUtils.isEmpty(adAppPrivacyUrl)) {
                        return;
                    }
                    AdComplianceUtil.startCommonWebView(adAppPrivacyUrl, DefInterstitialAdDialog.this.getContext().getString(R.string.adsdk_generic_ad_info_privacy), DefInterstitialAdDialog.this.getContext());
                }
            });
        }
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.DefInterstitialAdDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view6) {
                    String adAppPermissionsUrl = DefInterstitialAdDialog.this.mResultBean.getAdAppPermissionsUrl();
                    if (TextUtils.isEmpty(adAppPermissionsUrl)) {
                        return;
                    }
                    AdComplianceUtil.startCommonWebView(adAppPermissionsUrl, DefInterstitialAdDialog.this.getContext().getString(R.string.adsdk_generic_ad_info_permission), DefInterstitialAdDialog.this.getContext());
                }
            });
        }
        AdHelperFeed.INSTANCE.registerViewAndAction(viewGroup, arrayList2, this.mResultBean);
    }

    public void setAdText(TextView textView) {
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            textView.setText(R.string.adsdk_generic_ad_group_personalize);
        } else {
            textView.setText(R.string.adsdk_generic_ad_group_normal);
        }
    }

    public abstract void setData();

    public final void setDataAndShow(NestAdData nestAdData) {
        if (nestAdData == null) {
            return;
        }
        this.mResultBean = nestAdData;
        show();
        nestAdData.setAppDownloadListener(this);
        nestAdData.setAdInteractionListener(this);
        nestAdData.setVideoAdListener(new NestAdData.VideoAdListener() { // from class: com.wifi.ad.core.helper.DefInterstitialAdDialog.4
            @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
            public void onVideoComplete(@NonNull NestAdData nestAdData2) {
                WifiLog.d("DefInterstitialAdDialog onVideoComplete...");
                if (DefInterstitialAdDialog.this.showListener != null) {
                    DefInterstitialAdDialog.this.showListener.onVideoComplete(nestAdData2.getAdType(), nestAdData2);
                }
            }

            @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
            public void onVideoError(@NonNull NestAdData nestAdData2) {
                WifiLog.d("DefInterstitialAdDialog onVideoError...");
                if (DefInterstitialAdDialog.this.showListener != null) {
                    DefInterstitialAdDialog.this.showListener.onVideoError(nestAdData2.getAdType(), nestAdData2);
                }
            }

            @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
            public void onVideoPause(@NonNull NestAdData nestAdData2) {
                WifiLog.d("DefInterstitialAdDialog onVideoPause...");
                if (DefInterstitialAdDialog.this.showListener != null) {
                    DefInterstitialAdDialog.this.showListener.onVideoPause(nestAdData2.getAdType(), nestAdData2);
                }
            }

            @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
            public void onVideoStart(@NonNull NestAdData nestAdData2) {
                WifiLog.d("DefInterstitialAdDialog onVideoStart...");
                if (DefInterstitialAdDialog.this.showListener != null) {
                    DefInterstitialAdDialog.this.showListener.onVideoStart(nestAdData2.getAdType(), nestAdData2);
                }
            }
        });
        setData();
    }

    public void setHeGui(Context context, TextView textView) {
        String company = getCompany(this.mResultBean);
        String version = getVersion(this.mResultBean);
        if (TextUtils.isEmpty(company) && TextUtils.isEmpty(version)) {
            textView.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(company) && !TextUtils.isEmpty(version)) {
            textView.setVisibility(0);
            textView.setText(String.format(context.getString(R.string.adsdk_generic_ad_hegui), company, version));
        } else if (!TextUtils.isEmpty(company) || TextUtils.isEmpty(version)) {
            textView.setVisibility(0);
            textView.setText(String.format(context.getString(R.string.adsdk_generic_ad_hegui_company), company));
        } else {
            textView.setVisibility(0);
            textView.setText(String.format(context.getString(R.string.adsdk_generic_ad_hegui_version), version));
        }
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShowListener(PopShowListener popShowListener) {
        this.showListener = popShowListener;
    }

    public void setTitle(NestAdData nestAdData, TextView textView) {
        String title = getTitle(nestAdData);
        if (TextUtils.isEmpty(title) || ".".equals(title)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(title);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        WindowManager.LayoutParams attributes;
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
    }

    public void switchVideoOrImage(ViewGroup viewGroup, ImageView imageView) {
        viewGroup.removeAllViews();
        if (!isVideoType()) {
            String imageUrl = getImageUrl();
            if (TextUtils.isEmpty(imageUrl)) {
                return;
            }
            WifiNestAd.INSTANCE.getImageLoader().display(imageView, imageUrl);
            return;
        }
        View adView = this.mResultBean.getAdView();
        if (adView != null) {
            ViewParent parent = adView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(adView);
            }
            viewGroup.addView(adView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public View wrapDecorationIfGDT(View view, boolean z) {
        int id;
        int id2;
        if (this.mResultBean == null || !SDKAlias.GDT.getType().equals(this.mResultBean.getAdType())) {
            return view;
        }
        ViewParent parent = view.getParent();
        if (parent == null) {
            NestNativeAdFeedContainer nestNativeAdFeedContainer = new NestNativeAdFeedContainer(view.getContext());
            nestNativeAdFeedContainer.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (z && (id2 = view.getId()) != -1) {
                view.setId(-1);
                nestNativeAdFeedContainer.setId(id2);
            }
            return nestNativeAdFeedContainer;
        }
        if (!(parent instanceof ViewGroup)) {
            return view;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int iIndexOfChild = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);
        NestNativeAdFeedContainer nestNativeAdFeedContainer2 = new NestNativeAdFeedContainer(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            nestNativeAdFeedContainer2.setLayoutParams(layoutParams);
        }
        nestNativeAdFeedContainer2.addView(view, new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(nestNativeAdFeedContainer2, iIndexOfChild);
        if (z && (id = view.getId()) != -1) {
            view.setId(-1);
            nestNativeAdFeedContainer2.setId(id);
        }
        return nestNativeAdFeedContainer2;
    }
}
