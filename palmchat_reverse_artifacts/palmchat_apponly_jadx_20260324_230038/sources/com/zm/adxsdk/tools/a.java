package com.zm.adxsdk.tools;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.zm.adxsdk.protocol.api.WfConfig;
import com.zm.adxsdk.protocol.api.WfSensitivityController;
import com.zm.adxsdk.protocol.api.interfaces.IWfRuntime;
import com.zm.fission.fataar.R$id;
import com.zm.fission.fataar.R$layout;
import com.zm.fissionsdk.api.FissionSdk;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f16598a;

    public static ArrayList a(Context context) {
        g gVarA = g.a();
        ArrayList arrayList = gVarA.d;
        if (arrayList != null && !arrayList.isEmpty()) {
            return gVarA.d;
        }
        if (gVarA.d == null) {
            gVarA.d = new ArrayList();
        }
        b bVar = new b();
        bVar.f16607a = "应用名称";
        WfConfig wfConfig = gVarA.f16604a;
        bVar.b = wfConfig != null ? wfConfig.getAppName() : "";
        gVarA.d.add(bVar);
        b bVar2 = new b();
        bVar2.f16607a = "应用包名";
        if (context != null) {
            bVar2.b = context.getPackageName();
        }
        gVarA.d.add(bVar2);
        b bVar3 = new b();
        bVar3.f16607a = "AppId";
        WfConfig wfConfig2 = gVarA.f16604a;
        bVar3.b = wfConfig2 != null ? wfConfig2.getAppId() : "";
        gVarA.d.add(bVar3);
        b bVar4 = new b();
        bVar4.f16607a = "Token";
        WfConfig wfConfig3 = gVarA.f16604a;
        bVar4.b = wfConfig3 != null ? wfConfig3.getToken() : "";
        gVarA.d.add(bVar4);
        b bVar5 = new b();
        bVar5.f16607a = "SDK版本号";
        bVar5.b = FissionSdk.getSdkVersionName();
        gVarA.d.add(bVar5);
        b bVar6 = new b();
        bVar6.f16607a = "SDK初始化";
        bVar6.b = String.valueOf(FissionSdk.isInitSuccess());
        gVarA.d.add(bVar6);
        return gVarA.d;
    }

    public static ArrayList b() {
        boolean z;
        boolean z2;
        boolean z3;
        g gVarA = g.a();
        ArrayList arrayList = gVarA.g;
        if (arrayList == null || arrayList.isEmpty()) {
            if (gVarA.g == null) {
                gVarA.g = new ArrayList();
            }
            String str = "fissionSdk (" + FissionSdk.getSdkVersionName() + ")";
            boolean z4 = false;
            try {
                Class.forName(f.m);
                z = true;
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            gVarA.a(str, z);
            try {
                Class.forName(f.n);
                z2 = true;
            } catch (ClassNotFoundException unused2) {
                z2 = false;
            }
            gVarA.a("androidx.appcompat:appcompat:*", z2);
            try {
                Class.forName(f.o);
                z3 = true;
            } catch (ClassNotFoundException unused3) {
                z3 = false;
            }
            gVarA.a("androidx.legacy:legacy-support-v4:*", z3);
            try {
                Class.forName(f.p);
                try {
                    Class.forName(f.q);
                    z4 = true;
                } catch (ClassNotFoundException unused4) {
                }
                gVarA.a("com.google.guava:guava:*", z4);
            } catch (ClassNotFoundException unused5) {
            }
        }
        return gVarA.g;
    }

    public static ArrayList c() {
        WfConfig wfConfig;
        g gVarA = g.a();
        ArrayList arrayList = gVarA.h;
        if ((arrayList == null || arrayList.isEmpty()) && (wfConfig = gVarA.f16604a) != null) {
            WfSensitivityController sensitivityController = wfConfig.getSensitivityController();
            if (gVarA.h == null) {
                gVarA.h = new ArrayList();
            }
            gVarA.b("setCanGetAndroidId", sensitivityController != null && sensitivityController.canGetAndroidId());
            gVarA.b("setCanGetAppList", sensitivityController != null && sensitivityController.canGetAppList());
            gVarA.b("setCanGetOaid", sensitivityController != null && sensitivityController.canGetOaid());
            gVarA.b("setCanReadPhoneState", sensitivityController != null && sensitivityController.canReadPhoneState());
            gVarA.b("setCanGetNetworkState", sensitivityController != null && sensitivityController.canGetNetworkState());
            gVarA.b("setCanGetLocation", sensitivityController != null && sensitivityController.canGetLocation());
        }
        return gVarA.h;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f16598a == null) {
            this.f16598a = new ArrayList();
        }
        m mVar = new m();
        mVar.f16607a = "媒体信息";
        this.f16598a.add(mVar);
        if (a(getContext()) != null) {
            this.f16598a.addAll(a(getContext()));
        }
        m mVar2 = new m();
        mVar2.f16607a = "基础参数";
        this.f16598a.add(mVar2);
        if (a() != null) {
            this.f16598a.addAll(a());
        }
        m mVar3 = new m();
        mVar3.f16607a = "依赖列表";
        this.f16598a.add(mVar3);
        if (b() != null) {
            this.f16598a.addAll(b());
        }
        m mVar4 = new m();
        mVar4.f16607a = "权限列表";
        this.f16598a.add(mVar4);
        if (g.a().a(getContext()) != null) {
            this.f16598a.addAll(g.a().a(getContext()));
        }
        m mVar5 = new m();
        mVar5.f16607a = "敏感信息开关";
        this.f16598a.add(mVar5);
        if (c() != null) {
            this.f16598a.addAll(c());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.wf_shell_df_layout_fragment_app_info, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((ListView) view.findViewById(R$id.wf_sdk_df_list_view)).setAdapter((ListAdapter) new o(getContext(), this.f16598a));
    }

    public static ArrayList a() {
        String string;
        String string2;
        g gVarA = g.a();
        ArrayList arrayList = gVarA.e;
        if (arrayList != null && !arrayList.isEmpty()) {
            return gVarA.e;
        }
        if (gVarA.e == null) {
            gVarA.e = new ArrayList();
        }
        WfConfig wfConfig = gVarA.f16604a;
        gVarA.a("Channel", wfConfig != null ? wfConfig.getChannel() : "");
        WfConfig wfConfig2 = gVarA.f16604a;
        gVarA.a("AllowShowNotification", wfConfig2 != null ? String.valueOf(wfConfig2.allowShowNotification()) : "");
        WfConfig wfConfig3 = gVarA.f16604a;
        gVarA.a("ShowDownloadToast", wfConfig3 != null ? String.valueOf(wfConfig3.isShowDownloadToast()) : "");
        WfConfig wfConfig4 = gVarA.f16604a;
        gVarA.a("WechatApiVersion", wfConfig4 != null ? wfConfig4.getWxApiVer() : "");
        WfConfig wfConfig5 = gVarA.f16604a;
        gVarA.a("WechatOpenSdkVersion", wfConfig5 != null ? String.valueOf(wfConfig5.getWxOpensdkVer()) : "");
        IWfRuntime iWfRuntime = gVarA.b;
        String str = "(未知)";
        String string3 = "未知";
        if (iWfRuntime == null) {
            string = "未知";
        } else {
            int deviceType = iWfRuntime.getDeviceType();
            StringBuilder sb = new StringBuilder();
            sb.append(deviceType);
            sb.append(deviceType == 1 ? "(PHONE)" : deviceType == 2 ? "(TABLET)" : deviceType == 3 ? "(TV)" : deviceType == 4 ? "(PC)" : "(未知)");
            string = sb.toString();
        }
        gVarA.a("DeviceType", string);
        IWfRuntime iWfRuntime2 = gVarA.b;
        gVarA.a("OaId", iWfRuntime2 != null ? iWfRuntime2.getOAid() : "");
        IWfRuntime iWfRuntime3 = gVarA.b;
        gVarA.a("Imei", iWfRuntime3 != null ? iWfRuntime3.getImei() : "");
        IWfRuntime iWfRuntime4 = gVarA.b;
        gVarA.a("AndroidId", iWfRuntime4 != null ? iWfRuntime4.getAndroidId() : "");
        IWfRuntime iWfRuntime5 = gVarA.b;
        gVarA.a("Mac", iWfRuntime5 != null ? iWfRuntime5.getMac() : "");
        IWfRuntime iWfRuntime6 = gVarA.b;
        if (iWfRuntime6 == null) {
            string2 = "未知";
        } else {
            int networkType = iWfRuntime6.getNetworkType();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(networkType);
            sb2.append(networkType == 1 ? "(ETHERNET)" : networkType == 2 ? "(WIFI)" : networkType == 3 ? "(CELLULAR_UNKNOWN)" : networkType == 4 ? "(2G)" : networkType == 5 ? "(3G)" : networkType == 6 ? "(4G)" : networkType == 7 ? "(5G)" : "(未知)");
            string2 = sb2.toString();
        }
        gVarA.a("NetworkType", string2);
        IWfRuntime iWfRuntime7 = gVarA.b;
        if (iWfRuntime7 != null) {
            int carrier = iWfRuntime7.getCarrier();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(carrier);
            if (carrier == 1) {
                str = "(MOBILE)";
            } else if (carrier == 2) {
                str = "(TELECOM)";
            } else if (carrier == 3) {
                str = "(UNICOM)";
            }
            sb3.append(str);
            string3 = sb3.toString();
        }
        gVarA.a("Carrier", string3);
        IWfRuntime iWfRuntime8 = gVarA.b;
        gVarA.a("Longitude", iWfRuntime8 != null ? String.valueOf(iWfRuntime8.getLongitude()) : "");
        IWfRuntime iWfRuntime9 = gVarA.b;
        gVarA.a("Latitude", iWfRuntime9 != null ? String.valueOf(iWfRuntime9.getLatitude()) : "");
        IWfRuntime iWfRuntime10 = gVarA.b;
        gVarA.a("Uid", iWfRuntime10 != null ? iWfRuntime10.getUid() : "");
        IWfRuntime iWfRuntime11 = gVarA.b;
        gVarA.a("IsLogin", iWfRuntime11 != null ? String.valueOf(iWfRuntime11.isLogin()) : "");
        WfConfig wfConfig6 = gVarA.f16604a;
        if (wfConfig6 != null) {
            Object globalConfig = wfConfig6.getGlobalConfig("userAgent");
            if (globalConfig instanceof String) {
                gVarA.a("UserAgent", (String) globalConfig);
            }
            Object globalConfig2 = gVarA.f16604a.getGlobalConfig("personalRecommend");
            if (globalConfig2 instanceof Boolean) {
                gVarA.a("IsRecommend", String.valueOf(globalConfig2));
            }
            Object globalConfig3 = gVarA.f16604a.getGlobalConfig("sensorEnable");
            if (globalConfig3 instanceof Boolean) {
                gVarA.a("SensorEnable", String.valueOf(globalConfig3));
            }
        }
        return gVarA.e;
    }
}
