package com.effectsar.labcv.licenselibrary;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface EffectsSDKLicenseInterface {
    void clearParams();

    int getLicenseWithParams(HashMap<String, String> map, boolean z, LicenseCallback licenseCallback);

    String getParam(String str);

    void registerHttpProvider(HttpRequestProvider httpRequestProvider);

    void setParam(String str, String str2);

    int updateLicenseWithParams(HashMap<String, String> map, boolean z, LicenseCallback licenseCallback);
}
