package com.bytedance.sdk.component.b;

import android.content.Context;
import android.view.MotionEvent;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface u {

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void reportSoftDecData(String str, JSONObject jSONObject);

        void setCryptInitStatus(long j, boolean z);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.b.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0214u {
        void reportSensorData(JSONObject jSONObject);
    }

    byte[] decrypt(byte[] bArr);

    String decryptWithCBC(String str);

    boolean detectHostLocalIp(String str);

    boolean enableSetHARSensorCallBack(int i);

    byte[] encrypt(byte[] bArr);

    String getArchEnv();

    Context getArmorContext();

    boolean getArmorLoadStatus();

    String getSoftChara();

    int getSpecificArmorLoadStatus();

    void initPglArmorCallApi(nr nrVar);

    void initPglCryptUtils();

    void pglArmorCallApi2c(MotionEvent motionEvent);

    String pglArmorCallApi2ccc(String str, long j, int i, boolean z);

    String pglArmorCallApi2getProperty(String str, String str2);

    void pglArmorCallApi2src(long j, int i);

    void pglArmorCallApiCancelListener();

    boolean registerHarSensors();

    void setBlt(boolean z);

    void setHARSensorCallBack(InterfaceC0214u interfaceC0214u);

    boolean signVerifyMD5withRSA(String str, String str2) throws Exception;

    void softDecTool2ua(double d, long j);

    void updateHARSettings(JSONObject jSONObject);

    void updateNetworkStatus(int i);

    void updateScreenStatus(String str);
}
