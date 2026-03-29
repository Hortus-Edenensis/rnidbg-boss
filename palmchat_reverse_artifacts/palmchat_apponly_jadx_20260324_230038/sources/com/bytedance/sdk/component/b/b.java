package com.bytedance.sdk.component.b;

import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.bytedance.sdk.component.b.u;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class b implements u {
    Function u;

    public b(Function function) {
        this.u = function;
    }

    @Override // com.bytedance.sdk.component.b.u
    public byte[] decrypt(byte[] bArr) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, bArr);
        return (byte[]) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public String decryptWithCBC(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public boolean detectHostLocalIp(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.b.u
    public boolean enableSetHARSensorCallBack(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        sparseArray.put(1, Integer.valueOf(i));
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.b.u
    public byte[] encrypt(byte[] bArr) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, bArr);
        return (byte[]) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public String getArchEnv() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public Context getArmorContext() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (Context) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public boolean getArmorLoadStatus() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.b.u
    public String getSoftChara() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public int getSpecificArmorLoadStatus() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return ((Integer) this.u.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.b.u
    public void initPglArmorCallApi(u.nr nrVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        if (nrVar != null) {
            nrVar = new fx(nrVar);
        }
        sparseArray.put(1, nrVar);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void initPglCryptUtils() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void pglArmorCallApi2c(MotionEvent motionEvent) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, motionEvent);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public String pglArmorCallApi2ccc(String str, long j, int i, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        sparseArray.put(2, Long.valueOf(j));
        sparseArray.put(4, Integer.valueOf(i));
        sparseArray.put(5, Boolean.valueOf(z));
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public String pglArmorCallApi2getProperty(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void pglArmorCallApi2src(long j, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Long.valueOf(j));
        sparseArray.put(3, Integer.valueOf(i));
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void pglArmorCallApiCancelListener() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public boolean registerHarSensors() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.b.u
    public void setBlt(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, Boolean.valueOf(z));
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void setHARSensorCallBack(u.InterfaceC0214u interfaceC0214u) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        if (interfaceC0214u != null) {
            interfaceC0214u = new nr(interfaceC0214u);
        }
        sparseArray.put(1, interfaceC0214u);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public boolean signVerifyMD5withRSA(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.b.u
    public void softDecTool2ua(double d, long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Double.valueOf(d));
        sparseArray.put(3, Long.valueOf(j));
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void updateHARSettings(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, jSONObject);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void updateNetworkStatus(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, Integer.valueOf(i));
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void updateScreenStatus(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, str);
        this.u.apply(sparseArray);
    }
}
