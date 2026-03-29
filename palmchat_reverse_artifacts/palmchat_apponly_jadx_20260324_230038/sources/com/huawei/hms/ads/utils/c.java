package com.huawei.hms.ads.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c {
    public static RequestOptions Code(RequestOptions requestOptions) {
        RequestOptions requestOptionsI = k.Code().I();
        if (requestOptions == null) {
            return requestOptionsI;
        }
        RequestOptions.Builder builder = requestOptions.toBuilder();
        if (requestOptions.C() == null) {
            builder.setAdContentClassification(requestOptionsI.getAdContentClassification());
        }
        if (requestOptions.getTagForUnderAgeOfPromise() == null) {
            builder.setTagForUnderAgeOfPromise(requestOptionsI.getTagForUnderAgeOfPromise());
        }
        if (requestOptions.getTagForChildProtection() == null) {
            builder.setTagForChildProtection(requestOptionsI.getTagForChildProtection());
        }
        if (requestOptions.getNonPersonalizedAd() == null) {
            builder.setNonPersonalizedAd(requestOptionsI.getNonPersonalizedAd());
        }
        if (requestOptions.getIsQueryUseEnabled() == null) {
            builder.setIsQueryUseEnabled(requestOptionsI.getIsQueryUseEnabled());
        }
        if (requestOptions.Code() == null) {
            builder.setHwNonPersonalizedAd(requestOptionsI.Code());
        }
        if (requestOptions.V() == null) {
            builder.setThirdNonPersonalizedAd(requestOptionsI.V());
        }
        if (requestOptions.getAppLang() == null) {
            builder.setAppLang(requestOptionsI.getAppLang());
        }
        if (requestOptions.getAppCountry() == null) {
            builder.setAppCountry(requestOptionsI.getAppCountry());
        }
        if (requestOptions.getApp() == null) {
            builder.setApp(requestOptionsI.getApp());
        }
        if (TextUtils.isEmpty(requestOptions.getConsent())) {
            builder.setConsent(requestOptionsI.getConsent());
        }
        if (requestOptions.B() == null) {
            builder.setRequestLocation(requestOptionsI.B());
        }
        if (requestOptions.F() == null) {
            builder.setSearchInfo(requestOptionsI.F());
        }
        if (requestOptions.a() == null) {
            builder.setSupportFa(requestOptionsI.a());
        }
        return builder.build();
    }
}
