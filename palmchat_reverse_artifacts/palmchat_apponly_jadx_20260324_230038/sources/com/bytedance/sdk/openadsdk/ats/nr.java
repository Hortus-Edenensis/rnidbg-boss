package com.bytedance.sdk.openadsdk.ats;

import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.bytedance.sdk.component.b.u;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.panglearmor.a;
import com.bytedance.sdk.component.panglearmor.nr.b;
import com.bytedance.sdk.component.panglearmor.x;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import j$.util.function.Function$CC;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements com.bytedance.sdk.component.b.u, Function {
    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return encrypt((byte[]) sparseArray.get(1));
            case 2:
                return Boolean.valueOf(getArmorLoadStatus());
            case 3:
                return decryptWithCBC((String) sparseArray.get(1));
            case 4:
                return decrypt((byte[]) sparseArray.get(1));
            case 5:
                return Boolean.valueOf(signVerifyMD5withRSA((String) sparseArray.get(1), (String) sparseArray.get(2)));
            case 6:
                return Boolean.valueOf(detectHostLocalIp((String) sparseArray.get(1)));
            case 7:
                return getSoftChara();
            case 8:
                pglArmorCallApi2c((MotionEvent) sparseArray.get(1));
                return null;
            case 9:
                return pglArmorCallApi2ccc((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue(), ((Integer) sparseArray.get(3)).intValue(), ((Boolean) sparseArray.get(4)).booleanValue());
            case 10:
                pglArmorCallApi2src(((Long) sparseArray.get(1)).longValue(), ((Integer) sparseArray.get(2)).intValue());
                return null;
            case 11:
                return pglArmorCallApi2getProperty((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 12:
                return getArmorContext();
            case 13:
                return getArchEnv();
            case 14:
                setBlt(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 15:
                softDecTool2ua(((Double) sparseArray.get(1)).doubleValue(), ((Long) sparseArray.get(2)).longValue());
                return null;
            case 16:
                Object nrVar = sparseArray.get(1);
                if (nrVar != null) {
                    nrVar = new com.bytedance.sdk.component.b.nr((Function) nrVar);
                }
                setHARSensorCallBack((u.InterfaceC0214u) nrVar);
                return null;
            case 17:
                return Boolean.valueOf(registerHarSensors());
            case 18:
                Object fxVar = sparseArray.get(1);
                if (fxVar != null) {
                    fxVar = new com.bytedance.sdk.component.b.fx((Function) fxVar);
                }
                initPglArmorCallApi((u.nr) fxVar);
                return null;
            case 19:
                pglArmorCallApiCancelListener();
                return null;
            case 20:
                updateScreenStatus((String) sparseArray.get(1));
                return null;
            case 21:
                updateNetworkStatus(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 22:
                return Integer.valueOf(getSpecificArmorLoadStatus());
            case 23:
                updateHARSettings((JSONObject) sparseArray.get(1));
                return null;
            case 24:
                initPglCryptUtils();
                return null;
            case 25:
                return Boolean.valueOf(enableSetHARSensorCallBack(((Integer) sparseArray.get(1)).intValue()));
            default:
                return null;
        }
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.b.u
    public byte[] decrypt(byte[] bArr) {
        return a.u().nr(bArr);
    }

    @Override // com.bytedance.sdk.component.b.u
    public String decryptWithCBC(String str) {
        return a.u().u(str);
    }

    @Override // com.bytedance.sdk.component.b.u
    public boolean detectHostLocalIp(String str) {
        return com.bytedance.sdk.component.panglearmor.b.u(str);
    }

    @Override // com.bytedance.sdk.component.b.u
    public boolean enableSetHARSensorCallBack(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zNr = com.bytedance.sdk.component.panglearmor.nr.pn.u().nr();
        boolean z = ((long) (i - 1)) % com.bytedance.sdk.component.panglearmor.nr.pn.u().pn() == 0;
        boolean z2 = jCurrentTimeMillis - com.bytedance.sdk.component.panglearmor.nr.b.u().b() > com.bytedance.sdk.component.panglearmor.nr.pn.u().b();
        boolean zFx = com.bytedance.sdk.component.panglearmor.nr.b.u().fx();
        com.bytedance.sdk.component.panglearmor.nr.pn.u();
        com.bytedance.sdk.component.panglearmor.nr.pn.u();
        com.bytedance.sdk.component.panglearmor.nr.pn.u();
        com.bytedance.sdk.component.panglearmor.nr.pn.u();
        boolean z3 = SoftDecTool.f;
        return z && z2 && zNr && !zFx;
    }

    @Override // com.bytedance.sdk.component.b.u
    public byte[] encrypt(byte[] bArr) {
        return a.u().u(bArr);
    }

    @Override // com.bytedance.sdk.component.b.u
    public String getArchEnv() {
        return com.bytedance.sdk.component.panglearmor.iz.nr();
    }

    @Override // com.bytedance.sdk.component.b.u
    public Context getArmorContext() {
        return com.bytedance.sdk.component.panglearmor.iz.fx();
    }

    @Override // com.bytedance.sdk.component.b.u
    public boolean getArmorLoadStatus() {
        return a.nr();
    }

    @Override // com.bytedance.sdk.component.b.u
    public String getSoftChara() {
        return com.bytedance.sdk.component.panglearmor.iz.u(com.bytedance.sdk.openadsdk.core.n.o().sx().nr());
    }

    @Override // com.bytedance.sdk.component.b.u
    public int getSpecificArmorLoadStatus() {
        return a.fx();
    }

    @Override // com.bytedance.sdk.component.b.u
    public void initPglArmorCallApi(final u.nr nrVar) {
        x.u uVarU = new x.u(dw.getContext(), d.iz(), "7232").u(true);
        uVarU.u(new com.bytedance.sdk.component.panglearmor.n() { // from class: com.bytedance.sdk.openadsdk.ats.nr.2
            @Override // com.bytedance.sdk.component.panglearmor.n
            public void u(long j, boolean z) {
                nrVar.setCryptInitStatus(j, z);
            }

            @Override // com.bytedance.sdk.component.panglearmor.n
            public void u(String str, JSONObject jSONObject) {
                nrVar.reportSoftDecData(str, jSONObject);
            }
        });
        com.bytedance.sdk.component.panglearmor.iz.u(uVarU.u());
    }

    @Override // com.bytedance.sdk.component.b.u
    public void initPglCryptUtils() {
        a.u();
    }

    @Override // com.bytedance.sdk.component.b.u
    public void pglArmorCallApi2c(MotionEvent motionEvent) {
        com.bytedance.sdk.component.panglearmor.iz.u(motionEvent);
    }

    @Override // com.bytedance.sdk.component.b.u
    public String pglArmorCallApi2ccc(String str, long j, int i, boolean z) {
        return com.bytedance.sdk.component.panglearmor.iz.u(str, j, i, z);
    }

    @Override // com.bytedance.sdk.component.b.u
    public String pglArmorCallApi2getProperty(String str, String str2) {
        return com.bytedance.sdk.component.panglearmor.iz.u(str, str2);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void pglArmorCallApi2src(long j, int i) {
        com.bytedance.sdk.component.panglearmor.iz.u(j, i);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void pglArmorCallApiCancelListener() {
        com.bytedance.sdk.component.panglearmor.iz.u();
    }

    @Override // com.bytedance.sdk.component.b.u
    public boolean registerHarSensors() {
        return com.bytedance.sdk.component.panglearmor.nr.b.u().nr();
    }

    @Override // com.bytedance.sdk.component.b.u
    public void setBlt(boolean z) {
        SoftDecTool.setBlt(z);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void setHARSensorCallBack(final u.InterfaceC0214u interfaceC0214u) {
        com.bytedance.sdk.component.panglearmor.nr.b.u().u(new b.u() { // from class: com.bytedance.sdk.openadsdk.ats.nr.1
            @Override // com.bytedance.sdk.component.panglearmor.nr.b.u
            public void u(JSONObject jSONObject) {
                interfaceC0214u.reportSensorData(jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.component.b.u
    public boolean signVerifyMD5withRSA(String str, String str2) throws Exception {
        return com.bytedance.sdk.component.panglearmor.b.u(str, str2);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void softDecTool2ua(double d, long j) {
        SoftDecTool.ua(d, j);
        boolean z = SoftDecTool.f;
    }

    @Override // com.bytedance.sdk.component.b.u
    public void updateHARSettings(JSONObject jSONObject) {
        com.bytedance.sdk.component.panglearmor.nr.pn.u().u(jSONObject);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void updateNetworkStatus(int i) {
        com.bytedance.sdk.component.panglearmor.nr.nr.u().u(i);
    }

    @Override // com.bytedance.sdk.component.b.u
    public void updateScreenStatus(String str) {
        com.bytedance.sdk.component.panglearmor.nr.nr.u().nr(str);
    }
}
