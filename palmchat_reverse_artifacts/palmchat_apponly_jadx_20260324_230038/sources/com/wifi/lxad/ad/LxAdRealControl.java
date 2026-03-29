package com.wifi.lxad.ad;

import android.content.Context;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.LocationUtil;
import com.wifi.adsdk.params.ILxAdAppRuntime;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class LxAdRealControl implements ILxAdAppRuntime {
    private boolean mAlist;
    private boolean mAndroidID;
    private Context mContext;
    private boolean mMacAddress;
    private boolean mPhoneState;
    private boolean mWifiState;
    private boolean mWriteExternal;

    public LxAdRealControl(Context context, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContext = context;
        this.mAlist = z;
        this.mPhoneState = z2;
        this.mAndroidID = z3;
        this.mMacAddress = z6;
        this.mWifiState = z5;
        this.mWriteExternal = z4;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public boolean alist() {
        return this.mAlist;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public int getAge() {
        return NestInfoTaker.INSTANCE.getAge().intValue();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getAndroidId() {
        return NestInfoTaker.INSTANCE.getAndroidId();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getChanId() {
        return NestInfoTaker.INSTANCE.getChannel();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getDeviceId() {
        return NestInfoTaker.INSTANCE.getDeviceId();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public int getGender() {
        return NestInfoTaker.INSTANCE.getGender().intValue();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getImei() {
        return NestInfoTaker.INSTANCE.getImEI1(this.mContext);
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public List<String> getInstallPkgs() {
        return NestInfoTaker.INSTANCE.getInstalledPackages();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getLatitude() {
        return LocationUtil.INSTANCE.getLatitude(this.mContext);
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getLongitude() {
        return LocationUtil.INSTANCE.getLongitude(this.mContext);
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getMac() {
        return NestInfoTaker.INSTANCE.getMacAddress();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getOaId() {
        return NestInfoTaker.INSTANCE.getOaId();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public int getOpenSdkVer() {
        return NestInfoTaker.INSTANCE.getOpenSdkVer();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getUa() {
        return NestInfoTaker.INSTANCE.getUA();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getUid() {
        return NestInfoTaker.INSTANCE.getUId();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public int getWxApiVer() {
        return NestInfoTaker.INSTANCE.getWxApiVer();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public boolean isCanUseAndroidId() {
        return this.mAndroidID;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public boolean isCanUseMacAddress() {
        return this.mMacAddress;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public boolean isCanUsePhoneState() {
        return this.mPhoneState;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public boolean isCanUseWifiState() {
        return this.mWifiState;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public boolean isCanUseWriteExternal() {
        return this.mWriteExternal;
    }
}
