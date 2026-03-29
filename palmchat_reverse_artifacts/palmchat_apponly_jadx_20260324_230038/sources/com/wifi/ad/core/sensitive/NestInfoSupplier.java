package com.wifi.ad.core.sensitive;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\b&\u0018\u0000 -2\u00020\u0001:\u0005-./01B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u000f\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\fH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\fH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\fH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\fH&J\n\u0010\u0014\u001a\u0004\u0018\u00010\fH&J\n\u0010\u0015\u001a\u0004\u0018\u00010\fH&J\n\u0010\u0016\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u000eH&J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u000fJ\n\u0010\u001a\u001a\u0004\u0018\u00010\fH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\fH&J\n\u0010\u001c\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001eH&J\n\u0010\u001f\u001a\u0004\u0018\u00010\fH&J\n\u0010 \u001a\u0004\u0018\u00010\fH&J\n\u0010!\u001a\u0004\u0018\u00010\fH&J\n\u0010\"\u001a\u0004\u0018\u00010\fH&J\b\u0010#\u001a\u00020$H&J\n\u0010%\u001a\u0004\u0018\u00010\fH&J\u0012\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u000eH&J\n\u0010'\u001a\u0004\u0018\u00010\fH&J\b\u0010(\u001a\u00020\u000eH&J\n\u0010)\u001a\u0004\u0018\u00010\fH&J\n\u0010*\u001a\u0004\u0018\u00010\fH&J\b\u0010+\u001a\u00020\u000eH&J\n\u0010,\u001a\u0004\u0018\u00010\fH&¨\u00062"}, d2 = {"Lcom/wifi/ad/core/sensitive/NestInfoSupplier;", "", "()V", "canSdkUseLocationState", "Lcom/wifi/ad/core/sensitive/NestInfoSupplier$LocationState;", "canSdkUsePhoneState", "Lcom/wifi/ad/core/sensitive/NestInfoSupplier$PhoneState;", "canSdkUseSdCardState", "Lcom/wifi/ad/core/sensitive/NestInfoSupplier$StorageState;", "canSdkUseWifiState", "Lcom/wifi/ad/core/sensitive/NestInfoSupplier$WifiState;", "getAdxUrl", "", "getAge", "", "()Ljava/lang/Integer;", "getAndroidId", "getAppVer", "getAppVerName", "getChannel", "getConfigTai", "getDeviceId", "getDeviceInfo", "getDftConfig", "scene", "getGender", "getImei", "getImei1", "getImei2", "getInstalledPackages", "", "getLXUA", "getLatitude", "getLongitude", "getLxCityCode", "getLxVpnStatus", "", "getMacAddress", "getNativeConfig", "getOaId", "getOpenSdkVer", "getUA", "getUId", "getWxApiVer", "getWxAppId", "Companion", "LocationState", "PhoneState", "StorageState", "WifiState", "core_release"}, k = 1, mv = {1, 1, 16})
public abstract class NestInfoSupplier {
    public static final int ALLOW_USE = 0;
    public static final int DENIED_USE = 1;
    public static final int PARTIAL_USE = 2;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/wifi/ad/core/sensitive/NestInfoSupplier$LocationState;", "", "(Ljava/lang/String;I)V", "ALLOW_USE", "DENIED_USE", "PARTIAL_USE", "core_release"}, k = 1, mv = {1, 1, 16})
    public enum LocationState {
        ALLOW_USE,
        DENIED_USE,
        PARTIAL_USE
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/wifi/ad/core/sensitive/NestInfoSupplier$PhoneState;", "", "(Ljava/lang/String;I)V", "ALLOW_USE", "DENIED_USE", "PARTIAL_USE", "core_release"}, k = 1, mv = {1, 1, 16})
    public enum PhoneState {
        ALLOW_USE,
        DENIED_USE,
        PARTIAL_USE
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/wifi/ad/core/sensitive/NestInfoSupplier$StorageState;", "", "(Ljava/lang/String;I)V", "ALLOW_USE", "DENIED_USE", "PARTIAL_USE", "core_release"}, k = 1, mv = {1, 1, 16})
    public enum StorageState {
        ALLOW_USE,
        DENIED_USE,
        PARTIAL_USE
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/wifi/ad/core/sensitive/NestInfoSupplier$WifiState;", "", "(Ljava/lang/String;I)V", "ALLOW_USE", "DENIED_USE", "PARTIAL_USE", "core_release"}, k = 1, mv = {1, 1, 16})
    public enum WifiState {
        ALLOW_USE,
        DENIED_USE,
        PARTIAL_USE
    }

    public LocationState canSdkUseLocationState() {
        return LocationState.ALLOW_USE;
    }

    public PhoneState canSdkUsePhoneState() {
        return PhoneState.ALLOW_USE;
    }

    public StorageState canSdkUseSdCardState() {
        return StorageState.ALLOW_USE;
    }

    public WifiState canSdkUseWifiState() {
        return WifiState.ALLOW_USE;
    }

    public abstract String getAdxUrl();

    public abstract Integer getAge();

    public abstract String getAndroidId();

    public abstract String getAppVer();

    public abstract String getAppVerName();

    public abstract String getChannel();

    public abstract String getConfigTai();

    public abstract String getDeviceId();

    public abstract String getDeviceInfo();

    public abstract String getDftConfig(int scene);

    public abstract Integer getGender();

    public abstract String getImei();

    public abstract String getImei1();

    public abstract String getImei2();

    public abstract List<String> getInstalledPackages();

    public abstract String getLXUA();

    public abstract String getLatitude();

    public abstract String getLongitude();

    public abstract String getLxCityCode();

    public abstract boolean getLxVpnStatus();

    public abstract String getMacAddress();

    public abstract String getNativeConfig(int scene);

    public abstract String getOaId();

    public abstract int getOpenSdkVer();

    public abstract String getUA();

    public abstract String getUId();

    public abstract int getWxApiVer();

    public abstract String getWxAppId();
}
