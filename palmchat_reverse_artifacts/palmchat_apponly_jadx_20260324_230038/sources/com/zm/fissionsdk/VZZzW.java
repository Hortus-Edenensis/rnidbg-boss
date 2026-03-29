package com.zm.fissionsdk;

import android.content.Context;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.zm.adxsdk.protocol.api.WfConfig;
import com.zm.adxsdk.protocol.api.interfaces.IWfReporter;
import com.zm.adxsdk.protocol.api.interfaces.IWfRuntime;
import com.zm.fda.FobDeviceIdClient;
import com.zm.fda.FobEventClient;
import com.zm.fda.busi.IPubParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class VZZzW implements IWfReporter {
    public static final String b = "WR";
    public static final String c = "AdxSdk";
    public static final String d = "com.zm.adxsdk";
    public static final String e = "com.zm.fissionsdk";
    public static final String f = "com.zm.glide";
    public static VZZzW g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FobEventClient f16729a;

    /* JADX INFO: compiled from: SearchBox */
    public class zZZ2W implements IPubParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IWfRuntime f16730a;
        public final /* synthetic */ WfConfig b;
        public final /* synthetic */ List c;

        public zZZ2W(IWfRuntime iWfRuntime, WfConfig wfConfig, List list) {
            this.f16730a = iWfRuntime;
            this.b = wfConfig;
            this.c = list;
        }

        @Override // com.zm.fda.busi.IPubParams
        public boolean collectCrash() {
            WfConfig wfConfig = this.b;
            if (wfConfig != null) {
                return wfConfig.useFdaCrash();
            }
            return true;
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getAndroidId() {
            IWfRuntime iWfRuntime = this.f16730a;
            return iWfRuntime != null ? iWfRuntime.getAndroidId() : "";
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getAppId() {
            WfConfig wfConfig = this.b;
            return wfConfig != null ? wfConfig.getAppId() : "";
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getCarrier() {
            IWfRuntime iWfRuntime = this.f16730a;
            return iWfRuntime != null ? String.valueOf(iWfRuntime.getCarrier()) : "";
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getChanId() {
            WfConfig wfConfig = this.b;
            return wfConfig != null ? wfConfig.getChannel() : "";
        }

        @Override // com.zm.fda.busi.IPubParams
        public List<String> getCrashKeyword() {
            return this.c;
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getDHID() {
            IWfRuntime iWfRuntime = this.f16730a;
            return iWfRuntime != null ? iWfRuntime.getDHid() : "";
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getIMEI() {
            IWfRuntime iWfRuntime = this.f16730a;
            return iWfRuntime != null ? iWfRuntime.getImei() : "";
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getLati() {
            IWfRuntime iWfRuntime = this.f16730a;
            return iWfRuntime != null ? String.valueOf(iWfRuntime.getLatitude()) : "";
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getLongi() {
            IWfRuntime iWfRuntime = this.f16730a;
            return iWfRuntime != null ? String.valueOf(iWfRuntime.getLongitude()) : "";
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getMac() {
            IWfRuntime iWfRuntime = this.f16730a;
            return iWfRuntime != null ? iWfRuntime.getMac() : "";
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getOaid() {
            IWfRuntime iWfRuntime = this.f16730a;
            return iWfRuntime != null ? iWfRuntime.getOAid() : "";
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getProjectId() {
            return "AdxSdk";
        }

        @Override // com.zm.fda.busi.IPubParams
        public long getProjectVerCode() {
            return 1009174L;
        }

        @Override // com.zm.fda.busi.IPubParams
        public String getProjectVerName() {
            return z2zz2.g;
        }
    }

    public final IPubParams a(WfConfig wfConfig) {
        IWfRuntime wfRuntime = wfConfig != null ? wfConfig.getWfRuntime() : null;
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.zm.adxsdk");
        arrayList.add(e);
        arrayList.add(f);
        return new zZZ2W(wfRuntime, wfConfig, arrayList);
    }

    public final void b() {
        HashMap map = new HashMap();
        map.put("sdk_pkg_name", "com.zm.adxsdk");
        map.put("sdkversion", VZV2Z.d());
        WVVzW.a(b, "id sdk_init", "ext", String.valueOf(map));
        FobEventClient fobEventClient = this.f16729a;
        if (fobEventClient != null) {
            fobEventClient.onSdkInit(map);
        }
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfReporter
    public String getOaid() {
        return FobDeviceIdClient.getOaid();
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfReporter
    public void initOaidGet(Context context, boolean z) {
        FobDeviceIdClient.initOaidGetter(context, z);
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfReporter
    public void onEvent(String str) {
        WVVzW.a(b, "id", str);
        FobEventClient fobEventClient = this.f16729a;
        if (fobEventClient != null) {
            fobEventClient.track(str);
        }
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfReporter
    public void onEvent(String str, Map<String, Object> map) {
        WVVzW.a(b, "id", str, "ext", String.valueOf(map));
        FobEventClient fobEventClient = this.f16729a;
        if (fobEventClient != null) {
            fobEventClient.track(str, map);
        }
    }

    public synchronized void a(Context context, WfConfig wfConfig) {
        if (this.f16729a == null) {
            this.f16729a = new FobEventClient.Builder().setContext(context).setPubParams(a(wfConfig)).newClient();
            b();
        }
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfReporter
    public void onEvent(String str, JSONObject jSONObject) {
        String[] strArr = new String[4];
        strArr[0] = "id";
        strArr[1] = str;
        strArr[2] = BodyData.TYPE_JSON;
        strArr[3] = jSONObject == null ? "" : jSONObject.toString();
        WVVzW.a(b, strArr);
        FobEventClient fobEventClient = this.f16729a;
        if (fobEventClient != null) {
            fobEventClient.track(str, jSONObject);
        }
    }

    public static VZZzW a() {
        if (g == null) {
            synchronized (VZZzW.class) {
                if (g == null) {
                    g = new VZZzW();
                }
            }
        }
        return g;
    }
}
