package com.cdadata.sdk.api;

import android.content.Context;
import defpackage.g57;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ZMConfigOptions {
    public Context mContext;
    public boolean isEnableDebug = false;
    public long sessionTime = 30000;
    public String reportUrl = "http://track-gateway.y5kfpt.com/api/oceantunnel/v1/trackData/collect";
    public String configUrl = "http://track-config.y5kfpt.com/openApi/trackShipmaster/v1/sdkConfigInfo/fetchConfig";
    public String appId = "";
    public String publicKey = "";
    public String securityType = "a";
    public String channelId = "";
    public long maxCacheSize = 33554432;
    public long flushTime = 0;
    public boolean disableSDK = false;
    public boolean isUploadEnable = true;
    public int uploadNetWorkType = 3;
    public boolean isAndroididEnable = false;
    public boolean isImeiEnable = false;
    public boolean isMacEnable = false;
    public boolean isSnEnable = false;
    public boolean isInstallAppEnable = false;
    public boolean isCarrierEnable = false;
    public boolean isNetWorkType = false;
    public boolean isGPSEnable = false;
    public boolean isBrandEnable = false;
    public boolean isModelEnable = false;
    public boolean isProductEnable = false;
    public boolean isManufacturerEnable = false;
    public boolean isBoardEnable = false;
    public boolean isCpuAbiEnable = false;
    public boolean isDeviceEnable = false;
    public boolean isDisplayEnable = false;
    public boolean isHostEnable = false;
    public boolean isIdEnable = false;
    public boolean isTagsEnable = false;
    public boolean isTypeEnable = false;
    public boolean isUserEnable = false;
    public boolean isResolutionEnable = false;
    public boolean isOSEnable = false;
    public boolean isOSVersionEnable = false;
    public boolean isLanguageEnable = false;
    public boolean isHardwareEnable = false;
    public boolean isFingerPrintEnable = false;
    public boolean isTimeZoneEnable = false;
    public boolean isCpuCoreEnable = false;
    public boolean isMaxCpuHZEnable = false;
    public boolean isMemorySizeEnable = false;
    public boolean isIncrementalEnable = false;
    public boolean isRadioEnable = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private ZMConfigOptions zmConfigOptions;

        public Builder(Context context) {
            ZMConfigOptions zMConfigOptions = new ZMConfigOptions();
            this.zmConfigOptions = zMConfigOptions;
            zMConfigOptions.mContext = context;
        }

        public ZMConfigOptions build() {
            return this.zmConfigOptions;
        }

        public Builder enableAndroidid(boolean z) {
            this.zmConfigOptions.isAndroididEnable = z;
            return this;
        }

        public Builder enableBoard(boolean z) {
            this.zmConfigOptions.isBoardEnable = z;
            return this;
        }

        public Builder enableBrand(boolean z) {
            this.zmConfigOptions.isBrandEnable = z;
            return this;
        }

        public Builder enableCarrier(boolean z) {
            this.zmConfigOptions.isCarrierEnable = z;
            return this;
        }

        public Builder enableCpuAbi(boolean z) {
            this.zmConfigOptions.isCpuAbiEnable = z;
            return this;
        }

        public Builder enableCpuCore(boolean z) {
            this.zmConfigOptions.isCpuCoreEnable = z;
            return this;
        }

        public Builder enableDebug(Boolean bool) {
            this.zmConfigOptions.isEnableDebug = bool.booleanValue();
            g57.f17667a = bool.booleanValue();
            return this;
        }

        public Builder enableDevice(boolean z) {
            this.zmConfigOptions.isDeviceEnable = z;
            return this;
        }

        public Builder enableDeviceInfo(boolean z) {
            ZMConfigOptions zMConfigOptions = this.zmConfigOptions;
            zMConfigOptions.isAndroididEnable = z;
            zMConfigOptions.isImeiEnable = z;
            zMConfigOptions.isMacEnable = z;
            zMConfigOptions.isSnEnable = z;
            zMConfigOptions.isInstallAppEnable = z;
            zMConfigOptions.isCarrierEnable = z;
            zMConfigOptions.isNetWorkType = z;
            zMConfigOptions.isGPSEnable = z;
            zMConfigOptions.isBrandEnable = z;
            zMConfigOptions.isModelEnable = z;
            zMConfigOptions.isProductEnable = z;
            zMConfigOptions.isManufacturerEnable = z;
            zMConfigOptions.isBoardEnable = z;
            zMConfigOptions.isCpuAbiEnable = z;
            zMConfigOptions.isDeviceEnable = z;
            zMConfigOptions.isDisplayEnable = z;
            zMConfigOptions.isHostEnable = z;
            zMConfigOptions.isIdEnable = z;
            zMConfigOptions.isTagsEnable = z;
            zMConfigOptions.isTypeEnable = z;
            zMConfigOptions.isUserEnable = z;
            zMConfigOptions.isResolutionEnable = z;
            zMConfigOptions.isOSEnable = z;
            zMConfigOptions.isOSVersionEnable = z;
            zMConfigOptions.isLanguageEnable = z;
            zMConfigOptions.isHardwareEnable = z;
            zMConfigOptions.isFingerPrintEnable = z;
            zMConfigOptions.isTimeZoneEnable = z;
            zMConfigOptions.isCpuCoreEnable = z;
            zMConfigOptions.isMaxCpuHZEnable = z;
            zMConfigOptions.isMemorySizeEnable = z;
            zMConfigOptions.isIncrementalEnable = z;
            zMConfigOptions.isRadioEnable = z;
            return this;
        }

        public Builder enableDisplay(boolean z) {
            this.zmConfigOptions.isDisplayEnable = z;
            return this;
        }

        public Builder enableFingerPrint(boolean z) {
            this.zmConfigOptions.isFingerPrintEnable = z;
            return this;
        }

        public Builder enableGPS(boolean z) {
            this.zmConfigOptions.isGPSEnable = z;
            return this;
        }

        public Builder enableHardware(boolean z) {
            this.zmConfigOptions.isHardwareEnable = z;
            return this;
        }

        public Builder enableHost(boolean z) {
            this.zmConfigOptions.isHostEnable = z;
            return this;
        }

        public Builder enableId(boolean z) {
            this.zmConfigOptions.isIdEnable = z;
            return this;
        }

        public Builder enableImei(boolean z) {
            this.zmConfigOptions.isImeiEnable = z;
            return this;
        }

        public Builder enableIncremental(boolean z) {
            this.zmConfigOptions.isIncrementalEnable = z;
            return this;
        }

        public Builder enableInstallApp(boolean z) {
            this.zmConfigOptions.isInstallAppEnable = z;
            return this;
        }

        public Builder enableLanguage(boolean z) {
            this.zmConfigOptions.isLanguageEnable = z;
            return this;
        }

        public Builder enableMac(boolean z) {
            this.zmConfigOptions.isMacEnable = z;
            return this;
        }

        public Builder enableManufactuer(boolean z) {
            this.zmConfigOptions.isManufacturerEnable = z;
            return this;
        }

        public Builder enableMaxCpuHZ(boolean z) {
            this.zmConfigOptions.isMaxCpuHZEnable = z;
            return this;
        }

        public Builder enableMemorySize(boolean z) {
            this.zmConfigOptions.isMemorySizeEnable = z;
            return this;
        }

        public Builder enableModel(boolean z) {
            this.zmConfigOptions.isModelEnable = z;
            return this;
        }

        public Builder enableNetWorkTypeEnable(boolean z) {
            this.zmConfigOptions.isNetWorkType = z;
            return this;
        }

        public Builder enableOS(boolean z) {
            this.zmConfigOptions.isOSEnable = z;
            return this;
        }

        public Builder enableOSVersion(boolean z) {
            this.zmConfigOptions.isOSVersionEnable = z;
            return this;
        }

        public Builder enableProduct(boolean z) {
            this.zmConfigOptions.isProductEnable = z;
            return this;
        }

        public Builder enableRadio(boolean z) {
            this.zmConfigOptions.isRadioEnable = z;
            return this;
        }

        public Builder enableResolution(boolean z) {
            this.zmConfigOptions.isResolutionEnable = z;
            return this;
        }

        public Builder enableSn(boolean z) {
            this.zmConfigOptions.isSnEnable = z;
            return this;
        }

        public Builder enableTags(boolean z) {
            this.zmConfigOptions.isTagsEnable = z;
            return this;
        }

        public Builder enableTimeZone(boolean z) {
            this.zmConfigOptions.isTimeZoneEnable = z;
            return this;
        }

        public Builder enableType(boolean z) {
            this.zmConfigOptions.isTypeEnable = z;
            return this;
        }

        public Builder enableUploadDataToServer(boolean z) {
            this.zmConfigOptions.isUploadEnable = z;
            return this;
        }

        public Builder enableUser(boolean z) {
            this.zmConfigOptions.isUserEnable = z;
            return this;
        }

        public Builder setAppId(String str) {
            this.zmConfigOptions.appId = str;
            return this;
        }

        public Builder setChannelId(String str) {
            this.zmConfigOptions.channelId = str;
            return this;
        }

        public Builder setConfigUrl(String str) {
            this.zmConfigOptions.configUrl = str;
            return this;
        }

        public Builder setFlushTime(long j) {
            if (j < 5000) {
                j = 5000;
            }
            this.zmConfigOptions.flushTime = j;
            return this;
        }

        public Builder setPublicKey(String str) {
            this.zmConfigOptions.publicKey = str;
            return this;
        }

        public Builder setReportUrl(String str) {
            this.zmConfigOptions.reportUrl = str;
            return this;
        }
    }
}
