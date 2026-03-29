package com.wifi.feisuo.ad;

import android.content.Context;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.LocationUtil;
import com.zm.fissionsdk.api.interfaces.IFissionLoginListener;
import com.zm.fissionsdk.api.interfaces.IFissionRuntime;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class FSRealControl implements IFissionRuntime {
    private Context mContext;

    public FSRealControl(Context context) {
        this.mContext = context;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRuntime
    public String getAndroidId() {
        return NestInfoTaker.INSTANCE.getAndroidId();
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRuntime
    public int getCarrier() {
        return 1;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRuntime
    public int getDeviceType() {
        return 1;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRuntime
    public String getImei() {
        return NestInfoTaker.INSTANCE.getImEI1(this.mContext);
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRuntime
    public double getLatitude() {
        try {
            return Double.parseDouble(LocationUtil.INSTANCE.getLatitude(this.mContext));
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRuntime
    public double getLongitude() {
        try {
            return Double.parseDouble(LocationUtil.INSTANCE.getLongitude(this.mContext));
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRuntime
    public String getMac() {
        return NestInfoTaker.INSTANCE.getMacAddress();
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRuntime
    public int getNetworkType() {
        return 2;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRuntime
    public String getOAid() {
        return NestInfoTaker.INSTANCE.getOaId();
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRuntime
    public String getUid() {
        return NestInfoTaker.INSTANCE.getUId();
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRuntime
    public boolean isLogin() {
        return false;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRuntime
    public void toLogin(IFissionLoginListener iFissionLoginListener) {
    }
}
