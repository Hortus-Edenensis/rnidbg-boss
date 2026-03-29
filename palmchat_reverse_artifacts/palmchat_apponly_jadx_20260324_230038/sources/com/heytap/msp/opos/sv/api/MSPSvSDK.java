package com.heytap.msp.opos.sv.api;

import android.content.Context;
import com.heytap.msp.opos.sv.a.a.a;
import com.heytap.msp.opos.sv.a.a.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MSPSvSDK implements a {
    private static volatile MSPSvSDK sInstance;
    private final a mIMSPSvSDK = new b();

    private MSPSvSDK() {
    }

    public static MSPSvSDK getInstance() {
        if (sInstance == null) {
            synchronized (MSPSvSDK.class) {
                if (sInstance == null) {
                    sInstance = new MSPSvSDK();
                }
            }
        }
        return sInstance;
    }

    @Override // com.heytap.msp.opos.sv.a.a.a
    public void enableLog() {
        this.mIMSPSvSDK.enableLog();
    }

    @Override // com.heytap.msp.opos.sv.a.a.a
    public int getSDKVerCode() {
        return this.mIMSPSvSDK.getSDKVerCode();
    }

    @Override // com.heytap.msp.opos.sv.a.a.a
    public String getSDKVerName() {
        return this.mIMSPSvSDK.getSDKVerName();
    }

    @Override // com.heytap.msp.opos.sv.a.a.a
    public String getSupportAuthVerCodeList(Context context) {
        return this.mIMSPSvSDK.getSupportAuthVerCodeList(context);
    }

    @Override // com.heytap.msp.opos.sv.a.a.a
    public void init(Context context) {
        this.mIMSPSvSDK.init(context);
    }
}
