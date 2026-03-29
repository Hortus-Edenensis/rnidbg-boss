package com.wifi.gdt.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.wifi.ad.core.constants.WifiNestConst;
import com.wifi.ad.core.wrapper.AbsThirdSdkDownloadFixWrapper;
import com.wifi.gdt.ad.NestGdtNativeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class GdtSdkDownloadFixWrapper extends AbsThirdSdkDownloadFixWrapper<NativeUnifiedADData> {
    private NativeUnifiedADData nativeUnifiedADData;

    public GdtSdkDownloadFixWrapper(@NonNull Context context) {
        super(context);
    }

    private void checkData(NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData == null) {
            throw new NullPointerException("data cannot be null");
        }
    }

    @Override // com.wifi.ad.core.wrapper.AbsThirdSdkDownloadFixWrapper
    public boolean canPause() {
        checkData(this.nativeUnifiedADData);
        return this.nativeUnifiedADData.getAppStatus() == 4;
    }

    @Override // com.wifi.ad.core.wrapper.AbsThirdSdkDownloadFixWrapper
    public boolean canResume() {
        checkData(this.nativeUnifiedADData);
        return this.nativeUnifiedADData.getAppStatus() == 32;
    }

    @Override // com.wifi.ad.core.wrapper.AbsThirdSdkDownloadFixWrapper
    public void pause() {
        checkData(this.nativeUnifiedADData);
        this.nativeUnifiedADData.pauseAppDownload();
        if (getNestAdData() != null) {
            NestGdtNativeView.INSTANCE.onEvent(getNestAdData(), WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOAD_PAUSE);
        }
    }

    @Override // com.wifi.ad.core.wrapper.AbsThirdSdkDownloadFixWrapper
    public void resume() {
        checkData(this.nativeUnifiedADData);
        this.nativeUnifiedADData.resumeAppDownload();
        if (getNestAdData() != null) {
            NestGdtNativeView.INSTANCE.onEvent(getNestAdData(), WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOAD_CONTINUE);
        }
    }

    @Override // com.wifi.ad.core.wrapper.AbsThirdSdkDownloadFixWrapper
    public boolean shouldIntercept() {
        checkData(this.nativeUnifiedADData);
        return this.nativeUnifiedADData.getAppStatus() == 4 || this.nativeUnifiedADData.getAppStatus() == 32;
    }

    public GdtSdkDownloadFixWrapper(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.wifi.ad.core.wrapper.AbsThirdSdkDownloadFixWrapper
    public void wrap(NativeUnifiedADData nativeUnifiedADData) {
        checkData(nativeUnifiedADData);
        this.nativeUnifiedADData = nativeUnifiedADData;
    }

    public GdtSdkDownloadFixWrapper(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
