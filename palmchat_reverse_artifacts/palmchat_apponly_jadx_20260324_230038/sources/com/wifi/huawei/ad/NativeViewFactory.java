package com.wifi.huawei.ad;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.AppDownloadButtonStyle;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.nativead.MediaView;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeView;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.utils.WifiLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class NativeViewFactory {
    private static final String TAG = "NativeViewFactory";

    /* JADX INFO: compiled from: SearchBox */
    public static class MyAppDownloadStyle extends AppDownloadButtonStyle {
        public MyAppDownloadStyle(Context context, int i) {
            super(context);
            try {
                this.normalStyle.setTextColor(context.getResources().getColor(R.color.white));
                this.processingStyle.setTextColor(context.getResources().getColor(R.color.black));
                if (i > 0) {
                    this.normalStyle.setBackground(context.getResources().getDrawable(i));
                } else {
                    this.normalStyle.setBackground(context.getResources().getDrawable(R.drawable.native_button_rounded_corners_shape));
                }
            } catch (Exception unused) {
            }
        }
    }

    public static View createAppDownloadButtonAdView(NativeAd nativeAd, Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.native_ad_with_app_download_btn_template, (ViewGroup) null);
        NativeView nativeView = (NativeView) viewInflate.findViewById(R.id.native_app_download_button_view);
        nativeView.setTitleView(viewInflate.findViewById(R.id.ad_title));
        nativeView.setMediaView((MediaView) viewInflate.findViewById(R.id.ad_media));
        nativeView.setAdSourceView(viewInflate.findViewById(R.id.ad_source));
        nativeView.setCallToActionView(viewInflate.findViewById(R.id.ad_call_to_action));
        ((TextView) nativeView.getTitleView()).setText(nativeAd.getTitle());
        nativeView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getAdSource() != null) {
            ((TextView) nativeView.getAdSourceView()).setText(nativeAd.getAdSource());
        }
        nativeView.getAdSourceView().setVisibility(nativeAd.getAdSource() != null ? 0 : 4);
        if (nativeAd.getCallToAction() != null) {
            ((Button) nativeView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        nativeView.setNativeAd(nativeAd);
        AppDownloadButton appDownloadButton = (AppDownloadButton) nativeView.findViewById(R.id.app_download_btn);
        appDownloadButton.setAppDownloadButtonStyle(new MyAppDownloadStyle(context, -1));
        if (nativeView.register(appDownloadButton)) {
            appDownloadButton.setVisibility(0);
            appDownloadButton.refreshAppStatus();
            nativeView.getCallToActionView().setVisibility(8);
        } else {
            appDownloadButton.setVisibility(8);
            nativeView.getCallToActionView().setVisibility(0);
        }
        return nativeView;
    }

    public static View createImageOnlyAdView(NativeAd nativeAd, Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.native_image_only_template, (ViewGroup) null);
        NativeView nativeView = (NativeView) viewInflate.findViewById(R.id.native_image_only_view);
        nativeView.setMediaView((MediaView) viewInflate.findViewById(R.id.ad_media));
        nativeView.setCallToActionView(viewInflate.findViewById(R.id.ad_call_to_action));
        nativeView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getCallToAction() != null) {
            ((Button) nativeView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        nativeView.getCallToActionView().setVisibility(nativeAd.getCallToAction() != null ? 0 : 4);
        nativeView.setNativeAd(nativeAd);
        return nativeView;
    }

    public static View createMediumAdView(NativeAd nativeAd, Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.native_common_medium_template, (ViewGroup) null);
        NativeView nativeView = (NativeView) viewInflate.findViewById(R.id.native_medium_view);
        nativeView.setTitleView(viewInflate.findViewById(R.id.ad_title));
        nativeView.setMediaView((MediaView) viewInflate.findViewById(R.id.ad_media));
        nativeView.setAdSourceView(viewInflate.findViewById(R.id.ad_source));
        nativeView.setCallToActionView(viewInflate.findViewById(R.id.ad_call_to_action));
        ((TextView) nativeView.getTitleView()).setText(nativeAd.getTitle());
        nativeView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getAdSource() != null) {
            ((TextView) nativeView.getAdSourceView()).setText(nativeAd.getAdSource());
        }
        nativeView.getAdSourceView().setVisibility(nativeAd.getAdSource() != null ? 0 : 4);
        if (nativeAd.getCallToAction() != null) {
            ((Button) nativeView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        nativeView.getCallToActionView().setVisibility(nativeAd.getCallToAction() == null ? 4 : 0);
        VideoOperator videoOperator = nativeAd.getVideoOperator();
        if (videoOperator.hasVideo()) {
            videoOperator.setVideoLifecycleListener(new VideoOperator.VideoLifecycleListener() { // from class: com.wifi.huawei.ad.NativeViewFactory.1
                @Override // com.huawei.hms.ads.VideoOperator.VideoLifecycleListener
                public void onVideoEnd() {
                    Log.i(NativeViewFactory.TAG, "NativeAd video play end.");
                }

                @Override // com.huawei.hms.ads.VideoOperator.VideoLifecycleListener
                public void onVideoPlay() {
                    Log.i(NativeViewFactory.TAG, "NativeAd video playing.");
                }

                @Override // com.huawei.hms.ads.VideoOperator.VideoLifecycleListener
                public void onVideoStart() {
                    Log.i(NativeViewFactory.TAG, "NativeAd video play start.");
                }
            });
        }
        nativeView.setNativeAd(nativeAd);
        return nativeView;
    }

    public static View createSmallImageAdView(NativeAd nativeAd, Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.native_small_image_template, (ViewGroup) null);
        NativeView nativeView = (NativeView) viewInflate.findViewById(R.id.native_small_view);
        nativeView.setTitleView(viewInflate.findViewById(R.id.ad_title));
        nativeView.setMediaView((MediaView) viewInflate.findViewById(R.id.ad_media));
        nativeView.setAdSourceView(viewInflate.findViewById(R.id.ad_source));
        nativeView.setCallToActionView(viewInflate.findViewById(R.id.ad_call_to_action));
        ((TextView) nativeView.getTitleView()).setText(nativeAd.getTitle());
        nativeView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getAdSource() != null) {
            ((TextView) nativeView.getAdSourceView()).setText(nativeAd.getAdSource());
        }
        nativeView.getAdSourceView().setVisibility(nativeAd.getAdSource() != null ? 0 : 4);
        if (nativeAd.getCallToAction() != null) {
            ((Button) nativeView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        nativeView.getCallToActionView().setVisibility(nativeAd.getCallToAction() == null ? 4 : 0);
        nativeView.setNativeAd(nativeAd);
        return nativeView;
    }

    public static View createThreeImagesAdView(NativeAd nativeAd, Context context, String str) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.native_three_images_template, (ViewGroup) null);
        NativeView nativeView = (NativeView) viewInflate.findViewById(R.id.native_three_images);
        nativeView.setTitleView(viewInflate.findViewById(R.id.ad_title));
        nativeView.setAdSourceView(viewInflate.findViewById(R.id.ad_source));
        nativeView.setCallToActionView(viewInflate.findViewById(R.id.ad_call_to_action));
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image_view_1);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.image_view_2);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.image_view_3);
        ((TextView) nativeView.getTitleView()).setText(nativeAd.getTitle());
        if (nativeAd.getAdSource() != null) {
            ((TextView) nativeView.getAdSourceView()).setText(nativeAd.getAdSource());
        }
        nativeView.getAdSourceView().setVisibility(nativeAd.getAdSource() != null ? 0 : 4);
        if (nativeAd.getCallToAction() != null) {
            ((Button) nativeView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        nativeView.getCallToActionView().setVisibility(nativeAd.getCallToAction() != null ? 0 : 4);
        WifiLog.d("HWAD createThreeImagesAdView nativeAd.getImages() " + nativeAd.getImages() + " code " + str);
        if (nativeAd.getImages() != null) {
            WifiLog.d("HWAD createThreeImagesAdView nativeAd.getImages().size " + nativeAd.getImages().size() + " code " + str);
        }
        if (nativeAd.getImages() != null && nativeAd.getImages().size() >= 3) {
            try {
                String string = nativeAd.getImages().get(0).getUri().toString();
                WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
                wifiNestAd.getImageLoader().display(imageView, string);
                wifiNestAd.getImageLoader().display(imageView2, nativeAd.getImages().get(1).getUri().toString());
                wifiNestAd.getImageLoader().display(imageView3, nativeAd.getImages().get(2).getUri().toString());
            } catch (Exception unused) {
            }
        }
        nativeView.setNativeAd(nativeAd);
        return nativeView;
    }
}
