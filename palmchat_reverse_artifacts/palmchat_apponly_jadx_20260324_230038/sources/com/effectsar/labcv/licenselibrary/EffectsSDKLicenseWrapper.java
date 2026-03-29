package com.effectsar.labcv.licenselibrary;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class EffectsSDKLicenseWrapper implements EffectsSDKLicenseInterface {
    private HttpRequestProvider _provider;
    private long mNativeWrapperPtr = 0;

    public EffectsSDKLicenseWrapper(HashMap<String, String> map, HttpRequestProvider httpRequestProvider) {
        this._provider = httpRequestProvider;
        nativeGetInstanceWithParam(map);
    }

    public static void loadLib() throws UnsatisfiedLinkError {
        try {
            System.loadLibrary("effect");
            System.err.println("licenseWrapper_jni: library load!");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("WARNING: licenseWrapper_jni Could not load library!");
            System.err.print(e);
            throw e;
        }
    }

    private native void nativeClearParams();

    private native int nativeGetInstanceWithParam(HashMap<String, String> map);

    private native int nativeGetLicenseWithParams(HashMap<String, String> map, boolean z, LicenseCallback licenseCallback);

    private native String nativeGetParam(String str);

    private native void nativeSetParam(String str, String str2);

    private native int nativeUpdateLicenseWithParams(HashMap<String, String> map, boolean z, LicenseCallback licenseCallback);

    @Override // com.effectsar.labcv.licenselibrary.EffectsSDKLicenseInterface
    public void clearParams() {
        nativeClearParams();
    }

    @Override // com.effectsar.labcv.licenselibrary.EffectsSDKLicenseInterface
    public int getLicenseWithParams(HashMap<String, String> map, boolean z, LicenseCallback licenseCallback) {
        return nativeGetLicenseWithParams(map, z, licenseCallback);
    }

    @Override // com.effectsar.labcv.licenselibrary.EffectsSDKLicenseInterface
    public String getParam(String str) {
        return nativeGetParam(str);
    }

    @Override // com.effectsar.labcv.licenselibrary.EffectsSDKLicenseInterface
    public void registerHttpProvider(HttpRequestProvider httpRequestProvider) {
        this._provider = httpRequestProvider;
    }

    @Override // com.effectsar.labcv.licenselibrary.EffectsSDKLicenseInterface
    public void setParam(String str, String str2) {
        nativeSetParam(str, str2);
    }

    @Override // com.effectsar.labcv.licenselibrary.EffectsSDKLicenseInterface
    public int updateLicenseWithParams(HashMap<String, String> map, boolean z, LicenseCallback licenseCallback) {
        return nativeUpdateLicenseWithParams(map, z, licenseCallback);
    }
}
