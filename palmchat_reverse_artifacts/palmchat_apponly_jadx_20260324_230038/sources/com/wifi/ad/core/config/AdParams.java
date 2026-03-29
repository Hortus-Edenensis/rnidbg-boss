package com.wifi.ad.core.config;

import android.view.View;
import com.wifi.ad.core.entity.AdSize;
import com.wifi.adsdk.utils.LxAdConst;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001QB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010P\u001a\u00020\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010)\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\b\"\u0004\b+\u0010\nR\u001a\u0010,\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001a\u0010/\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\b\"\u0004\b1\u0010\nR\u001a\u00102\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\nR\u001a\u00105\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\b\"\u0004\b7\u0010\nR\u001a\u00108\u001a\u000209X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010?X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u001c\u0010G\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0014\"\u0004\bI\u0010\u0016R\u001c\u0010J\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0014\"\u0004\bL\u0010\u0016R\u001a\u0010M\u001a\u000209X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010;\"\u0004\bO\u0010=¨\u0006R"}, d2 = {"Lcom/wifi/ad/core/config/AdParams;", "", "builder", "Lcom/wifi/ad/core/config/AdParams$Builder;", "(Lcom/wifi/ad/core/config/AdParams$Builder;)V", "adModel", "", "getAdModel$core_release", "()I", "setAdModel$core_release", "(I)V", "adSize", "Lcom/wifi/ad/core/entity/AdSize;", "getAdSize", "()Lcom/wifi/ad/core/entity/AdSize;", "setAdSize", "(Lcom/wifi/ad/core/entity/AdSize;)V", LxAdConst.EventKeyParams.KEY_PARAM_ADUNITID, "", "getAdUnitId", "()Ljava/lang/String;", "setAdUnitId", "(Ljava/lang/String;)V", "adxType", "getAdxType$core_release", "setAdxType$core_release", "appId", "getAppId$core_release", "setAppId$core_release", "defaultConfig", "getDefaultConfig", "setDefaultConfig", "ext", "", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "fullStrategyJson", "getFullStrategyJson$core_release", "setFullStrategyJson$core_release", "h5AdType", "getH5AdType$core_release", "setH5AdType$core_release", "nestType", "getNestType", "setNestType", "popRequestTime", "getPopRequestTime$core_release", "setPopRequestTime$core_release", "renderStyle", "getRenderStyle$core_release", "setRenderStyle$core_release", "scene", "getScene", "setScene", "serialSpaceTime", "", "getSerialSpaceTime$core_release", "()J", "setSerialSpaceTime$core_release", "(J)V", "splashBottomArea", "Landroid/view/View;", "getSplashBottomArea$core_release", "()Landroid/view/View;", "setSplashBottomArea$core_release", "(Landroid/view/View;)V", "splashHuaweiView", "getSplashHuaweiView$core_release", "setSplashHuaweiView$core_release", "strategyJson", "getStrategyJson$core_release", "setStrategyJson$core_release", "taiChikeys", "getTaiChikeys$core_release", "setTaiChikeys$core_release", "totalTimeout", "getTotalTimeout$core_release", "setTotalTimeout$core_release", "toString", "Builder", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdParams {
    private int adModel;
    private AdSize adSize;
    private String adUnitId;
    private int adxType;
    private String appId;
    private String defaultConfig;
    private Map<String, String> ext;
    private String fullStrategyJson;
    private int h5AdType;
    private String nestType;
    private int popRequestTime;
    private int renderStyle;
    private int scene;
    private long serialSpaceTime;
    private View splashBottomArea;
    private View splashHuaweiView;
    private String strategyJson;
    private String taiChikeys;
    private long totalTimeout;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010H\u001a\u00020IJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010K\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010L\u001a\u00020\u00002\b\u0010M\u001a\u0004\u0018\u00010\u0010J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004J\u0010\u0010O\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010J\u0010\u0010P\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010J\u001c\u0010Q\u001a\u00020\u00002\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001fJ\u0010\u0010R\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0010J\u000e\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\u0004J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0004J\u000e\u0010W\u001a\u00020\u00002\u0006\u00100\u001a\u000201J\u000e\u0010X\u001a\u00020\u00002\u0006\u00106\u001a\u000207J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010<\u001a\u000207J\u0010\u0010Z\u001a\u00020\u00002\b\u0010?\u001a\u0004\u0018\u00010\u0010J\u0010\u0010[\u001a\u00020\u00002\b\u0010\\\u001a\u0004\u0018\u00010\u0010J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010E\u001a\u000201R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010'\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u000201X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u000107X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\u001c\u0010?\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R\u001c\u0010B\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014R\u001a\u0010E\u001a\u000201X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00103\"\u0004\bG\u00105¨\u0006^"}, d2 = {"Lcom/wifi/ad/core/config/AdParams$Builder;", "", "()V", "adModel", "", "getAdModel$core_release", "()I", "setAdModel$core_release", "(I)V", "adSize", "Lcom/wifi/ad/core/entity/AdSize;", "getAdSize$core_release", "()Lcom/wifi/ad/core/entity/AdSize;", "setAdSize$core_release", "(Lcom/wifi/ad/core/entity/AdSize;)V", LxAdConst.EventKeyParams.KEY_PARAM_ADUNITID, "", "getAdUnitId$core_release", "()Ljava/lang/String;", "setAdUnitId$core_release", "(Ljava/lang/String;)V", "adxType", "getAdxType$core_release", "setAdxType$core_release", "appId", "getAppId$core_release", "setAppId$core_release", "defaultConfig", "getDefaultConfig$core_release", "setDefaultConfig$core_release", "ext", "", "getExt$core_release", "()Ljava/util/Map;", "setExt$core_release", "(Ljava/util/Map;)V", "fullStrategyJson", "getFullStrategyJson$core_release", "setFullStrategyJson$core_release", "h5AdType", "getH5AdType$core_release", "setH5AdType$core_release", "popRequestTime", "getPopRequestTime$core_release", "setPopRequestTime$core_release", "scene", "getScene$core_release", "setScene$core_release", "serialSpaceTime", "", "getSerialSpaceTime$core_release", "()J", "setSerialSpaceTime$core_release", "(J)V", "splashBottomArea", "Landroid/view/View;", "getSplashBottomArea$core_release", "()Landroid/view/View;", "setSplashBottomArea$core_release", "(Landroid/view/View;)V", "splashHuaweiView", "getSplashHuaweiView$core_release", "setSplashHuaweiView$core_release", "strategyJson", "getStrategyJson$core_release", "setStrategyJson$core_release", "taiChikeys", "getTaiChikeys$core_release", "setTaiChikeys$core_release", "totalTimeout", "getTotalTimeout$core_release", "setTotalTimeout$core_release", "build", "Lcom/wifi/ad/core/config/AdParams;", "setAdModel", "setAdSize", "setAdUnitId", WfConstant.EXTRA_UNIT_ID, "setAdxType", "setAppId", "setDefaultConfig", "setExt", "setFullStrategyJson", "setH5AdType", "adType", "setPopRequestTime", "setScene", "setSerialSpaceTime", "setSplashBottomArea", "setSplashHuaweiView", "setStrategyJson", "setTaiChiKeys", "keys", "setTotalTimeout", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class Builder {
        private int adModel;
        private AdSize adSize;
        private String adUnitId;
        private int adxType;
        private String appId;
        private String defaultConfig;
        private Map<String, String> ext;
        private String fullStrategyJson;
        private int h5AdType;
        private int popRequestTime;
        private int scene;
        private View splashBottomArea;
        private View splashHuaweiView;
        private String strategyJson;
        private String taiChikeys;
        private long totalTimeout = 3500;
        private long serialSpaceTime = 1000;

        public final AdParams build() {
            return new AdParams(this, null);
        }

        /* JADX INFO: renamed from: getAdModel$core_release, reason: from getter */
        public final int getAdModel() {
            return this.adModel;
        }

        /* JADX INFO: renamed from: getAdSize$core_release, reason: from getter */
        public final AdSize getAdSize() {
            return this.adSize;
        }

        /* JADX INFO: renamed from: getAdUnitId$core_release, reason: from getter */
        public final String getAdUnitId() {
            return this.adUnitId;
        }

        /* JADX INFO: renamed from: getAdxType$core_release, reason: from getter */
        public final int getAdxType() {
            return this.adxType;
        }

        /* JADX INFO: renamed from: getAppId$core_release, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        /* JADX INFO: renamed from: getDefaultConfig$core_release, reason: from getter */
        public final String getDefaultConfig() {
            return this.defaultConfig;
        }

        public final Map<String, String> getExt$core_release() {
            return this.ext;
        }

        /* JADX INFO: renamed from: getFullStrategyJson$core_release, reason: from getter */
        public final String getFullStrategyJson() {
            return this.fullStrategyJson;
        }

        /* JADX INFO: renamed from: getH5AdType$core_release, reason: from getter */
        public final int getH5AdType() {
            return this.h5AdType;
        }

        /* JADX INFO: renamed from: getPopRequestTime$core_release, reason: from getter */
        public final int getPopRequestTime() {
            return this.popRequestTime;
        }

        /* JADX INFO: renamed from: getScene$core_release, reason: from getter */
        public final int getScene() {
            return this.scene;
        }

        /* JADX INFO: renamed from: getSerialSpaceTime$core_release, reason: from getter */
        public final long getSerialSpaceTime() {
            return this.serialSpaceTime;
        }

        /* JADX INFO: renamed from: getSplashBottomArea$core_release, reason: from getter */
        public final View getSplashBottomArea() {
            return this.splashBottomArea;
        }

        /* JADX INFO: renamed from: getSplashHuaweiView$core_release, reason: from getter */
        public final View getSplashHuaweiView() {
            return this.splashHuaweiView;
        }

        /* JADX INFO: renamed from: getStrategyJson$core_release, reason: from getter */
        public final String getStrategyJson() {
            return this.strategyJson;
        }

        /* JADX INFO: renamed from: getTaiChikeys$core_release, reason: from getter */
        public final String getTaiChikeys() {
            return this.taiChikeys;
        }

        /* JADX INFO: renamed from: getTotalTimeout$core_release, reason: from getter */
        public final long getTotalTimeout() {
            return this.totalTimeout;
        }

        public final Builder setAdModel(int adModel) {
            this.adModel = adModel;
            return this;
        }

        public final void setAdModel$core_release(int i) {
            this.adModel = i;
        }

        public final Builder setAdSize(AdSize adSize) {
            this.adSize = adSize;
            return this;
        }

        public final void setAdSize$core_release(AdSize adSize) {
            this.adSize = adSize;
        }

        public final Builder setAdUnitId(String unitId) {
            this.adUnitId = unitId;
            return this;
        }

        public final void setAdUnitId$core_release(String str) {
            this.adUnitId = str;
        }

        public final Builder setAdxType(int adxType) {
            this.adxType = adxType;
            return this;
        }

        public final void setAdxType$core_release(int i) {
            this.adxType = i;
        }

        public final Builder setAppId(String appId) {
            this.appId = appId;
            return this;
        }

        public final void setAppId$core_release(String str) {
            this.appId = str;
        }

        public final Builder setDefaultConfig(String defaultConfig) {
            this.defaultConfig = defaultConfig;
            return this;
        }

        public final void setDefaultConfig$core_release(String str) {
            this.defaultConfig = str;
        }

        public final Builder setExt(Map<String, String> ext) {
            this.ext = ext;
            return this;
        }

        public final void setExt$core_release(Map<String, String> map) {
            this.ext = map;
        }

        public final Builder setFullStrategyJson(String fullStrategyJson) {
            this.fullStrategyJson = fullStrategyJson;
            return this;
        }

        public final void setFullStrategyJson$core_release(String str) {
            this.fullStrategyJson = str;
        }

        public final Builder setH5AdType(int adType) {
            this.h5AdType = adType;
            return this;
        }

        public final void setH5AdType$core_release(int i) {
            this.h5AdType = i;
        }

        public final Builder setPopRequestTime(int popRequestTime) {
            this.popRequestTime = popRequestTime;
            return this;
        }

        public final void setPopRequestTime$core_release(int i) {
            this.popRequestTime = i;
        }

        public final Builder setScene(int scene) {
            this.scene = scene;
            return this;
        }

        public final void setScene$core_release(int i) {
            this.scene = i;
        }

        public final Builder setSerialSpaceTime(long serialSpaceTime) {
            this.serialSpaceTime = serialSpaceTime;
            return this;
        }

        public final void setSerialSpaceTime$core_release(long j) {
            this.serialSpaceTime = j;
        }

        public final Builder setSplashBottomArea(View splashBottomArea) {
            this.splashBottomArea = splashBottomArea;
            return this;
        }

        public final void setSplashBottomArea$core_release(View view) {
            this.splashBottomArea = view;
        }

        public final Builder setSplashHuaweiView(View splashHuaweiView) {
            this.splashHuaweiView = splashHuaweiView;
            return this;
        }

        public final void setSplashHuaweiView$core_release(View view) {
            this.splashHuaweiView = view;
        }

        public final Builder setStrategyJson(String strategyJson) {
            this.strategyJson = strategyJson;
            return this;
        }

        public final void setStrategyJson$core_release(String str) {
            this.strategyJson = str;
        }

        public final Builder setTaiChiKeys(String keys) {
            this.taiChikeys = keys;
            return this;
        }

        public final void setTaiChikeys$core_release(String str) {
            this.taiChikeys = str;
        }

        public final Builder setTotalTimeout(long totalTimeout) {
            this.totalTimeout = totalTimeout;
            return this;
        }

        public final void setTotalTimeout$core_release(long j) {
            this.totalTimeout = j;
        }
    }

    private AdParams(Builder builder) {
        this.totalTimeout = 3500L;
        this.serialSpaceTime = 1000L;
        this.renderStyle = 2;
        this.nestType = "";
        this.adModel = builder.getAdModel();
        this.totalTimeout = builder.getTotalTimeout();
        this.serialSpaceTime = builder.getSerialSpaceTime();
        this.strategyJson = builder.getStrategyJson();
        this.fullStrategyJson = builder.getFullStrategyJson();
        this.ext = builder.getExt$core_release();
        this.adSize = builder.getAdSize();
        this.adxType = builder.getAdxType();
        this.taiChikeys = builder.getTaiChikeys();
        this.appId = builder.getAppId();
        this.scene = builder.getScene();
        this.h5AdType = builder.getH5AdType();
        this.defaultConfig = builder.getDefaultConfig();
        this.adUnitId = builder.getAdUnitId();
        this.splashBottomArea = builder.getSplashBottomArea();
        this.popRequestTime = builder.getPopRequestTime();
        this.splashHuaweiView = builder.getSplashHuaweiView();
    }

    /* JADX INFO: renamed from: getAdModel$core_release, reason: from getter */
    public final int getAdModel() {
        return this.adModel;
    }

    public final AdSize getAdSize() {
        return this.adSize;
    }

    public final String getAdUnitId() {
        return this.adUnitId;
    }

    /* JADX INFO: renamed from: getAdxType$core_release, reason: from getter */
    public final int getAdxType() {
        return this.adxType;
    }

    /* JADX INFO: renamed from: getAppId$core_release, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    public final String getDefaultConfig() {
        return this.defaultConfig;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    /* JADX INFO: renamed from: getFullStrategyJson$core_release, reason: from getter */
    public final String getFullStrategyJson() {
        return this.fullStrategyJson;
    }

    /* JADX INFO: renamed from: getH5AdType$core_release, reason: from getter */
    public final int getH5AdType() {
        return this.h5AdType;
    }

    public final String getNestType() {
        return this.nestType;
    }

    /* JADX INFO: renamed from: getPopRequestTime$core_release, reason: from getter */
    public final int getPopRequestTime() {
        return this.popRequestTime;
    }

    /* JADX INFO: renamed from: getRenderStyle$core_release, reason: from getter */
    public final int getRenderStyle() {
        return this.renderStyle;
    }

    public final int getScene() {
        return this.scene;
    }

    /* JADX INFO: renamed from: getSerialSpaceTime$core_release, reason: from getter */
    public final long getSerialSpaceTime() {
        return this.serialSpaceTime;
    }

    /* JADX INFO: renamed from: getSplashBottomArea$core_release, reason: from getter */
    public final View getSplashBottomArea() {
        return this.splashBottomArea;
    }

    /* JADX INFO: renamed from: getSplashHuaweiView$core_release, reason: from getter */
    public final View getSplashHuaweiView() {
        return this.splashHuaweiView;
    }

    /* JADX INFO: renamed from: getStrategyJson$core_release, reason: from getter */
    public final String getStrategyJson() {
        return this.strategyJson;
    }

    /* JADX INFO: renamed from: getTaiChikeys$core_release, reason: from getter */
    public final String getTaiChikeys() {
        return this.taiChikeys;
    }

    /* JADX INFO: renamed from: getTotalTimeout$core_release, reason: from getter */
    public final long getTotalTimeout() {
        return this.totalTimeout;
    }

    public final void setAdModel$core_release(int i) {
        this.adModel = i;
    }

    public final void setAdSize(AdSize adSize) {
        this.adSize = adSize;
    }

    public final void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public final void setAdxType$core_release(int i) {
        this.adxType = i;
    }

    public final void setAppId$core_release(String str) {
        this.appId = str;
    }

    public final void setDefaultConfig(String str) {
        this.defaultConfig = str;
    }

    public final void setExt(Map<String, String> map) {
        this.ext = map;
    }

    public final void setFullStrategyJson$core_release(String str) {
        this.fullStrategyJson = str;
    }

    public final void setH5AdType$core_release(int i) {
        this.h5AdType = i;
    }

    public final void setNestType(String str) {
        this.nestType = str;
    }

    public final void setPopRequestTime$core_release(int i) {
        this.popRequestTime = i;
    }

    public final void setRenderStyle$core_release(int i) {
        this.renderStyle = i;
    }

    public final void setScene(int i) {
        this.scene = i;
    }

    public final void setSerialSpaceTime$core_release(long j) {
        this.serialSpaceTime = j;
    }

    public final void setSplashBottomArea$core_release(View view) {
        this.splashBottomArea = view;
    }

    public final void setSplashHuaweiView$core_release(View view) {
        this.splashHuaweiView = view;
    }

    public final void setStrategyJson$core_release(String str) {
        this.strategyJson = str;
    }

    public final void setTaiChikeys$core_release(String str) {
        this.taiChikeys = str;
    }

    public final void setTotalTimeout$core_release(long j) {
        this.totalTimeout = j;
    }

    public String toString() {
        return "AdParams(adModel=" + this.adModel + ", totalTimeout=" + this.totalTimeout + ", serialSpaceTime=" + this.serialSpaceTime + ", strategyJson=" + this.strategyJson + ", fullStrategyJson=" + this.fullStrategyJson + ", taiChikeys=" + this.taiChikeys + ", renderStyle=" + this.renderStyle + ", nestType='" + this.nestType + "', ext=" + this.ext + ", adSize=" + this.adSize + ", adxType=" + this.adxType + ", appId=" + this.appId + ", scene=" + this.scene + ", h5AdType=" + this.h5AdType + ", defaultConfig=" + this.defaultConfig + ", adUnitId=" + this.adUnitId + ')';
    }

    public /* synthetic */ AdParams(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }
}
