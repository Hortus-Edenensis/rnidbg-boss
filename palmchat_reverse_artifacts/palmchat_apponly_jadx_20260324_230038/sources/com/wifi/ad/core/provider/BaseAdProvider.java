package com.wifi.ad.core.provider;

import android.app.Activity;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.ActivityPacker;
import com.wifi.ad.core.listener.BannerListener;
import com.wifi.ad.core.listener.InnerRewardShowListener;
import com.wifi.ad.core.listener.InterListener;
import com.wifi.ad.core.listener.NativeListener;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.listener.SplashShowListener;
import com.wifi.ad.core.provider.IAdProvider;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.strategy.IStrategyListener;
import com.wifi.ad.core.strategy.LoadScene;
import com.wifi.ad.core.utils.LogExtKt;
import com.wifi.ad.core.utils.WifiLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0004J\u001c\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0004J\u001c\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0004J&\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0004J\u001c\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0004J\u001c\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0004J&\u0010\u000f\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0004J,\u0010\u0011\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00102\u000e\b\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0004J\u001c\u0010\u0015\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0010H\u0004J\u001c\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0017H\u0004J\u001c\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0017H\u0004J\u001c\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0017H\u0004J&\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0004J\u001c\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0017H\u0004J\u001c\u0010\u001c\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0017H\u0004J&\u0010\u001d\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020 H\u0004J&\u0010!\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020 H\u0004J&\u0010\"\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020 H\u0004J6\u0010#\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0004J,\u0010&\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u001e2\u000e\b\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020 0\u0013H\u0004J(\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001eH\u0004J(\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001eH\u0004J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010)\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 H\u0004J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u00102\u001a\u00020%2\u0006\u0010)\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u00103\u001a\u00020%2\u0006\u0010.\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 H\u0004J\u0012\u00104\u001a\u0004\u0018\u00010\u00062\u0006\u00105\u001a\u00020\u0006H\u0002J\u0010\u00106\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0004J\u0010\u00107\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0004¨\u00068"}, d2 = {"Lcom/wifi/ad/core/provider/BaseAdProvider;", "Lcom/wifi/ad/core/provider/IAdProvider;", "()V", "callbackBannerClicked", "", "adProviderType", "", bq.f.s, "Lcom/wifi/ad/core/listener/BannerListener;", "callbackBannerClosed", "callbackBannerExpose", "callbackBannerFailed", "failedMsg", "callbackBannerLoaded", "callbackBannerStartRequest", "callbackFlowFailed", "Lcom/wifi/ad/core/listener/NativeListener;", "callbackFlowLoaded", "adList", "", "", "callbackFlowStartRequest", "callbackInterClicked", "Lcom/wifi/ad/core/listener/InterListener;", "callbackInterClosed", "callbackInterExpose", "callbackInterFailed", "callbackInterLoaded", "callbackInterStartRequest", "callbackSplashClicked", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "callbackSplashDismiss", "callbackSplashExposure", "callbackSplashFailed", "errorCode", "", "callbackSplashLoaded", "checkAdEcpmDone", "", "ecpm", "builder", "Lcom/wifi/ad/core/config/EventParams$Builder;", "listenerStrategy", "checkAdPriceSwitch", OapsKey.KEY_PRICE, "getAdEcpm", "getNativeView", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "getTestEcpm", "getTestPriceSwitchEcpm", "getsdfile", "fileName", "onNestAdLoadReport", "onNestAdUnLoadReport", "core_release"}, k = 1, mv = {1, 1, 16})
public abstract class BaseAdProvider implements IAdProvider {
    private final String getsdfile(String fileName) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), fileName);
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    WifiLog.i("getsdfile:" + stringBuffer.toString());
                    return stringBuffer.toString();
                }
                stringBuffer.append(line);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public final void callbackBannerClicked(@NonNull final String adProviderType, @NonNull final BannerListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackBannerClicked.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 点击了", null, 1, null);
                listener.onAdClicked(adProviderType);
            }
        });
    }

    public final void callbackBannerClosed(@NonNull final String adProviderType, @NonNull final BannerListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackBannerClosed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 关闭了", null, 1, null);
                listener.onAdClose(adProviderType);
            }
        });
    }

    public final void callbackBannerExpose(@NonNull final String adProviderType, @NonNull final BannerListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackBannerExpose.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 曝光了", null, 1, null);
                listener.onAdExpose(adProviderType);
            }
        });
    }

    public final void callbackBannerFailed(@NonNull final String adProviderType, @NonNull final BannerListener listener, final String failedMsg) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackBannerFailed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.loge$default(adProviderType + ": 请求失败了：" + failedMsg, null, 1, null);
                listener.onAdFailed(adProviderType, failedMsg);
            }
        });
    }

    public final void callbackBannerLoaded(@NonNull final String adProviderType, @NonNull final BannerListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackBannerLoaded.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 请求成功了", null, 1, null);
                listener.onAdLoaded(adProviderType);
            }
        });
    }

    public final void callbackBannerStartRequest(@NonNull final String adProviderType, @NonNull final BannerListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackBannerStartRequest.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 开始请求", null, 1, null);
                listener.onAdStartRequest(adProviderType);
            }
        });
    }

    public final void callbackFlowFailed(@NonNull final String adProviderType, @NonNull final NativeListener listener, final String failedMsg) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackFlowFailed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.loge$default(adProviderType + ": 请求失败了：" + failedMsg, null, 1, null);
                listener.onAdFailed(adProviderType, failedMsg);
            }
        });
    }

    public final void callbackFlowLoaded(@NonNull final String adProviderType, @NonNull final NativeListener listener, @NonNull final List<? extends Object> adList) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackFlowLoaded.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 请求成功了, 请求到" + adList.size() + "个广告", null, 1, null);
                listener.onAdLoaded(adProviderType, adList);
            }
        });
    }

    public final void callbackFlowStartRequest(@NonNull final String adProviderType, @NonNull final NativeListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackFlowStartRequest.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 开始请求", null, 1, null);
                listener.onAdStartRequest(adProviderType);
            }
        });
    }

    public final void callbackInterClicked(@NonNull final String adProviderType, @NonNull final InterListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackInterClicked.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 点击了", null, 1, null);
                listener.onAdClicked(adProviderType);
            }
        });
    }

    public final void callbackInterClosed(@NonNull final String adProviderType, @NonNull final InterListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackInterClosed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 关闭了", null, 1, null);
                listener.onAdClose(adProviderType);
            }
        });
    }

    public final void callbackInterExpose(@NonNull final String adProviderType, @NonNull final InterListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackInterExpose.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 曝光了", null, 1, null);
                listener.onAdExpose(adProviderType);
            }
        });
    }

    public final void callbackInterFailed(@NonNull final String adProviderType, @NonNull final InterListener listener, final String failedMsg) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackInterFailed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.loge$default(adProviderType + ": 请求失败了：" + failedMsg, null, 1, null);
                listener.onAdFailed(adProviderType, failedMsg);
            }
        });
    }

    public final void callbackInterLoaded(@NonNull final String adProviderType, @NonNull final InterListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackInterLoaded.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 请求成功了", null, 1, null);
                listener.onAdLoaded(adProviderType);
            }
        });
    }

    public final void callbackInterStartRequest(@NonNull final String adProviderType, @NonNull final InterListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackInterStartRequest.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 开始请求", null, 1, null);
                listener.onAdStartRequest(adProviderType);
            }
        });
    }

    public final void callbackSplashClicked(@NonNull final String adProviderType, @NonNull final IStrategyListener listener, @NonNull final NestAdData nestAdData) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackSplashClicked.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 点击了", null, 1, null);
                listener.onAdClicked(nestAdData, adProviderType);
            }
        });
    }

    public final void callbackSplashDismiss(@NonNull final String adProviderType, @NonNull final IStrategyListener listener, @NonNull final NestAdData nestAdData) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackSplashDismiss.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 消失了", null, 1, null);
                listener.onAdClose(nestAdData, adProviderType);
            }
        });
    }

    public final void callbackSplashExposure(@NonNull final String adProviderType, @NonNull final IStrategyListener listener, @NonNull final NestAdData nestAdData) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackSplashExposure.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 曝光了", null, 1, null);
                listener.onAdExpose(nestAdData, adProviderType);
            }
        });
    }

    public final void callbackSplashFailed(@NonNull final String adProviderType, @NonNull final IStrategyListener listener, final String failedMsg, @NonNull final NestAdData nestAdData, final int errorCode) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackSplashFailed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.loge$default(adProviderType + ": 请求失败了：" + failedMsg, null, 1, null);
                listener.onAdFailed(nestAdData, failedMsg, errorCode);
            }
        });
    }

    public final void callbackSplashLoaded(@NonNull final String adProviderType, @NonNull final IStrategyListener listener, @NonNull final List<NestAdData> adList) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.provider.BaseAdProvider.callbackSplashLoaded.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 请求成功了", null, 1, null);
                listener.onAdLoaded(adList);
            }
        });
    }

    public final boolean checkAdEcpmDone(int ecpm, NestAdData nestAdData, EventParams.Builder builder, IStrategyListener listenerStrategy) {
        int testEcpm = getTestEcpm(ecpm, nestAdData);
        WifiLog.d("slotcfgModel checkAdEcpmDone start srcid " + nestAdData.getAdCode() + " ecpm " + ecpm + " adCostType " + nestAdData.getAdCostType() + " ecpmLL " + testEcpm + " lowPrice " + nestAdData.getEcpmLowPrice());
        if (nestAdData.getAdCostType() != NestAdData.AdCostType.INSTANCE.getADCOSTTYPE_BIDING() || testEcpm > nestAdData.getEcpmLowPrice()) {
            return false;
        }
        nestAdData.setPriceResponse(4);
        if (testEcpm > 0) {
            nestAdData.setAdCost(testEcpm);
        }
        WifiLog.d("slotcfgModel checkAdEcpmDone not allow ecpmLL " + testEcpm + " nestAdData " + nestAdData);
        EventReporter.INSTANCE.reportNoRespDi(nestAdData, builder, "40200", "");
        listenerStrategy.onAdFailed(nestAdData, "ecpm biding not allow", -2);
        return true;
    }

    public final boolean checkAdPriceSwitch(int price, NestAdData nestAdData, EventParams.Builder builder, IStrategyListener listenerStrategy) {
        if (price > 0) {
            nestAdData.setPriceResponse(3);
            return false;
        }
        WifiLog.d("slotcfgModel checkAdPriceSwitch start srcid " + nestAdData.getAdCode() + " priceSwitch " + nestAdData.getPriceSwitch());
        if (nestAdData.getPriceSwitch() != 0) {
            nestAdData.setPriceResponse(2);
            return false;
        }
        nestAdData.setPriceResponse(1);
        EventReporter.INSTANCE.reportNoRespDi(nestAdData, builder, "40300", "priceSwitch biding not allow");
        listenerStrategy.onAdFailed(nestAdData, "priceSwitch biding not allow", -3);
        return true;
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void destroyAd(@NonNull NestAdData nestAdData) {
        IAdProvider.DefaultImpls.destroyAd(this, nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void destroyBannerAd() {
        IAdProvider.DefaultImpls.destroyBannerAd(this);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void destroyInterAd() {
        IAdProvider.DefaultImpls.destroyInterAd(this);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void destroyNativeAd(@NonNull Object obj) {
        IAdProvider.DefaultImpls.destroyNativeAd(this, obj);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public boolean drawAdIsBelongTheProvider(@NonNull NestAdData nestAdData) {
        return IAdProvider.DefaultImpls.drawAdIsBelongTheProvider(this, nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public boolean drawNativeAdIsBelongTheProvider(@NonNull NestAdData nestAdData) {
        return IAdProvider.DefaultImpls.drawNativeAdIsBelongTheProvider(this, nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public boolean feedAdIsBelongTheProvider(@NonNull NestAdData nestAdData) {
        return IAdProvider.DefaultImpls.feedAdIsBelongTheProvider(this, nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public boolean feedNativeAdIsBelongTheProvider(@NonNull NestAdData nestAdData) {
        return IAdProvider.DefaultImpls.feedNativeAdIsBelongTheProvider(this, nestAdData);
    }

    public final void getAdEcpm(int ecpm, NestAdData nestAdData) {
        if (ecpm > 0) {
            float ecpmRatio = nestAdData.getEcpmRatio() > ((float) 0) ? nestAdData.getEcpmRatio() : 1.0f;
            nestAdData.setAdCost((int) (ecpm * ecpmRatio));
            WifiLog.d("bidding ecpm old " + ecpm + " ecpmRatio " + ecpmRatio + " adCost " + nestAdData.getAdCost() + " code " + nestAdData.getAdCode() + " scene " + nestAdData.getAdScene());
        }
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void getCorrectAd(@NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener, @NonNull LoadScene loadScene) {
        IAdProvider.DefaultImpls.getCorrectAd(this, activityPacker, nestAdData, iStrategyListener, loadScene);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void getDrawVideoAd(@NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        IAdProvider.DefaultImpls.getDrawVideoAd(this, activityPacker, nestAdData, iStrategyListener);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void getInterstitialAd(@NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        IAdProvider.DefaultImpls.getInterstitialAd(this, activityPacker, nestAdData, iStrategyListener);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void getNativeAdList(@NonNull Activity activity, @NonNull String str, @NonNull String str2, int i, @NonNull NativeListener nativeListener) {
        IAdProvider.DefaultImpls.getNativeAdList(this, activity, str, str2, i, nativeListener);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void getNativeDrawVideoAd(@NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        IAdProvider.DefaultImpls.getNativeDrawVideoAd(this, activityPacker, nestAdData, iStrategyListener);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void getNativeFeedAd(@NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        IAdProvider.DefaultImpls.getNativeFeedAd(this, activityPacker, nestAdData, iStrategyListener);
    }

    public abstract BaseNativeView getNativeView(String adProviderType);

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void getSplashAd(@NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        IAdProvider.DefaultImpls.getSplashAd(this, activityPacker, nestAdData, iStrategyListener);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void getTemplateFeedAd(@NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        IAdProvider.DefaultImpls.getTemplateFeedAd(this, activityPacker, nestAdData, iStrategyListener);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public boolean interstitialAdIsBelongTheProvider(@NonNull NestAdData nestAdData) {
        return IAdProvider.DefaultImpls.interstitialAdIsBelongTheProvider(this, nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public boolean nativeAdIsBelongTheProvider(@NonNull Object obj) {
        return IAdProvider.DefaultImpls.nativeAdIsBelongTheProvider(this, obj);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void onNestAdLoad(@NonNull NestAdData nestAdData) {
        IAdProvider.DefaultImpls.onNestAdLoad(this, nestAdData);
    }

    public final void onNestAdLoadReport(NestAdData nestAdData) {
        EventReporter.INSTANCE.reportSdkLoad(nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void onNestAdUnLoad(@NonNull NestAdData nestAdData) {
        IAdProvider.DefaultImpls.onNestAdUnLoad(this, nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void pauseAd(@NonNull NestAdData nestAdData) {
        IAdProvider.DefaultImpls.pauseAd(this, nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void requestInterAd(@NonNull Activity activity, @NonNull String str, @NonNull String str2, @NonNull InterListener interListener) {
        IAdProvider.DefaultImpls.requestInterAd(this, activity, str, str2, interListener);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void requestRewardAd(@NonNull ActivityPacker activityPacker, @NonNull NestAdData nestAdData, @NonNull IStrategyListener iStrategyListener) {
        IAdProvider.DefaultImpls.requestRewardAd(this, activityPacker, nestAdData, iStrategyListener);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void resumeAd(@NonNull NestAdData nestAdData) {
        IAdProvider.DefaultImpls.resumeAd(this, nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void resumeNativeAd(@NonNull Object obj) {
        IAdProvider.DefaultImpls.resumeNativeAd(this, obj);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public boolean rewardAdIsBelongTheProvider(@NonNull NestAdData nestAdData) {
        return IAdProvider.DefaultImpls.rewardAdIsBelongTheProvider(this, nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void showBannerAd(@NonNull Activity activity, @NonNull String str, @NonNull String str2, @NonNull ViewGroup viewGroup, @NonNull BannerListener bannerListener) {
        IAdProvider.DefaultImpls.showBannerAd(this, activity, str, str2, viewGroup, bannerListener);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void showInterAd(@NonNull Activity activity) {
        IAdProvider.DefaultImpls.showInterAd(this, activity);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void showInterstitialAd(Activity activity, NestAdData nestAdData, PopShowListener popShowListener) {
        IAdProvider.DefaultImpls.showInterstitialAd(this, activity, nestAdData, popShowListener);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void showRewardAd(@NonNull Activity activity, @NonNull NestAdData nestAdData, InnerRewardShowListener innerRewardShowListener) {
        IAdProvider.DefaultImpls.showRewardAd(this, activity, nestAdData, innerRewardShowListener);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void showSplashAd(@NonNull Activity activity, @NonNull NestAdData nestAdData, @NonNull ViewGroup viewGroup, @NonNull SplashShowListener splashShowListener) {
        IAdProvider.DefaultImpls.showSplashAd(this, activity, nestAdData, viewGroup, splashShowListener);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public boolean splashAdIsBelongTheProvider(@NonNull NestAdData nestAdData) {
        return IAdProvider.DefaultImpls.splashAdIsBelongTheProvider(this, nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void startAd(@NonNull NestAdData nestAdData) {
        IAdProvider.DefaultImpls.startAd(this, nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void stopAd(@NonNull NestAdData nestAdData) {
        IAdProvider.DefaultImpls.stopAd(this, nestAdData);
    }

    @Override // com.wifi.ad.core.provider.IAdProvider
    public void destroyAd(String str) {
        IAdProvider.DefaultImpls.destroyAd(this, str);
    }

    public final void onNestAdUnLoadReport(NestAdData nestAdData) {
    }

    private final int getTestEcpm(int ecpm, NestAdData nestAdData) {
        return ecpm;
    }

    public final int getTestPriceSwitchEcpm(int price, NestAdData nestAdData) {
        return price;
    }
}
