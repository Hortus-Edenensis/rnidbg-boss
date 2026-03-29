package com.wifi.lxad.ad;

import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.adsdk.render.ILxAdItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/wifi/lxad/ad/LxAdSensitiveCatcher;", "", "()V", "createInfoByAd", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "lxad", "Lcom/wifi/adsdk/render/ILxAdItem;", "adLevel", "", "(Lcom/wifi/adsdk/render/ILxAdItem;Ljava/lang/Integer;)Lcom/wifi/ad/core/entity/SensitiveInfo;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class LxAdSensitiveCatcher {
    public static final LxAdSensitiveCatcher INSTANCE = new LxAdSensitiveCatcher();

    private LxAdSensitiveCatcher() {
    }

    public final SensitiveInfo createInfoByAd(ILxAdItem lxad, Integer adLevel) {
        SensitiveInfo sensitiveInfo = new SensitiveInfo();
        sensitiveInfo.setContentSourceId(String.valueOf(sensitiveInfo.getCONTENT_RESOURCE_LXAD_AD()));
        String title = lxad.getTitle();
        Intrinsics.checkExpressionValueIsNotNull(title, "lxad.title");
        sensitiveInfo.setTitle(title);
        String appName = lxad.getAppName();
        Intrinsics.checkExpressionValueIsNotNull(appName, "lxad.appName");
        sensitiveInfo.setAppName(appName);
        String videoUrl = lxad.getVideoUrl();
        Intrinsics.checkExpressionValueIsNotNull(videoUrl, "lxad.videoUrl");
        sensitiveInfo.setVideoUrl(videoUrl);
        String landingUrl = lxad.getLandingUrl();
        Intrinsics.checkExpressionValueIsNotNull(landingUrl, "lxad.landingUrl");
        sensitiveInfo.setH5Url(landingUrl);
        String deeplinkUrl = lxad.getDeeplinkUrl();
        Intrinsics.checkExpressionValueIsNotNull(deeplinkUrl, "lxad.deeplinkUrl");
        sensitiveInfo.setDeepUrl(deeplinkUrl);
        String imageUrl = lxad.getImageUrl();
        Intrinsics.checkExpressionValueIsNotNull(imageUrl, "lxad.imageUrl");
        sensitiveInfo.setCoverUrl(imageUrl);
        String adId = lxad.getAdId();
        Intrinsics.checkExpressionValueIsNotNull(adId, "lxad.adId");
        sensitiveInfo.setShenheSdkId(adId);
        String downloadUrl = lxad.getDownloadUrl();
        Intrinsics.checkExpressionValueIsNotNull(downloadUrl, "lxad.downloadUrl");
        sensitiveInfo.setDownloadUrl(downloadUrl);
        sensitiveInfo.setAdCode(lxad.getSlotId());
        sensitiveInfo.setVideoSize(lxad.getVideoDura());
        sensitiveInfo.setAdLevel(adLevel);
        String packageName = lxad.getPackageName();
        Intrinsics.checkExpressionValueIsNotNull(packageName, "lxad.packageName");
        sensitiveInfo.setPackageName(packageName);
        String apiSrcId = lxad.getApiSrcId();
        Intrinsics.checkExpressionValueIsNotNull(apiSrcId, "lxad.apiSrcId");
        sensitiveInfo.setApiSrcId(apiSrcId);
        String apiId = lxad.getApiId();
        Intrinsics.checkExpressionValueIsNotNull(apiId, "lxad.apiId");
        sensitiveInfo.setApiId(apiId);
        return sensitiveInfo;
    }
}
