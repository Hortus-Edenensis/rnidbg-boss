package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.cd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class bd {
    public static String bfm = "";

    public static com.kwad.sdk.l.a.b QD() {
        return com.kwad.sdk.l.a.b.QD();
    }

    public static com.kwad.sdk.l.a.f QE() {
        return com.kwad.sdk.l.a.f.QE();
    }

    private static String Th() {
        com.kwad.sdk.l.a.f fVarQE = com.kwad.sdk.l.a.f.QE();
        int i = fVarQE != null ? fVarQE.bbP : -1;
        return i >= 0 ? com.kwad.sdk.e.b.a(false, String.valueOf(i), 0) : !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).De() ? com.kwad.sdk.e.b.a(false, String.valueOf(i), 1) : com.kwad.sdk.e.b.a(false, String.valueOf(i), 2);
    }

    private static String Ti() {
        com.kwad.sdk.l.a.b bVarQD = com.kwad.sdk.l.a.b.QD();
        return bVarQD != null ? com.kwad.sdk.e.b.a(false, bVarQD.toJson(), 0) : !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Dg() ? com.kwad.sdk.e.b.a(false, "", 1) : com.kwad.sdk.e.b.a(false, "", 2);
    }

    private static String Tj() {
        return com.kwad.sdk.e.b.a(false, "1", 0);
    }

    private static String Tk() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    private static String Tl() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getAppId()), 0);
    }

    public static com.kwad.sdk.utils.c.a cU(Context context) {
        return x.cU(context);
    }

    private static String cg(boolean z) {
        String strCr = br.cr(z);
        if (!z) {
            return TextUtils.isEmpty(strCr) ? "" : strCr;
        }
        if (TextUtils.isEmpty(strCr)) {
            return (bc.useOaidDisable() || !s.RJ()) ? com.kwad.sdk.e.b.a(false, strCr, 1) : com.kwad.sdk.e.b.a(false, strCr, 5);
        }
        return com.kwad.sdk.e.b.a(bc.useOaidDisable() && !TextUtils.isEmpty(bc.getDevOaid()), strCr, 0);
    }

    private static String ch(boolean z) {
        if (com.kwad.framework.a.a.oy.booleanValue() && !TextUtils.isEmpty(bs.getDeviceId())) {
            return bs.getDeviceId();
        }
        String deviceId = br.getDeviceId();
        if (!z) {
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        if (TextUtils.isEmpty(deviceId)) {
            return (bc.usePhoneStateDisable() || !s.RH()) ? com.kwad.sdk.e.b.a(false, deviceId, 1) : com.kwad.sdk.e.b.a(false, deviceId, 5);
        }
        return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevAndroidId()), deviceId, 0);
    }

    private static String ci(boolean z) {
        String strTY = br.TY();
        return !z ? TextUtils.isEmpty(strTY) ? "" : strTY : !TextUtils.isEmpty(strTY) ? com.kwad.sdk.e.b.a(bc.useNetworkStateDisable(), strTY, 0) : (bc.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(8L)) ? com.kwad.sdk.e.b.a(false, strTY, 1) : com.kwad.sdk.e.b.a(false, strTY, 2);
    }

    public static /* synthetic */ String cj(boolean z) {
        return cg(true);
    }

    public static /* synthetic */ String ck(boolean z) {
        return Th();
    }

    public static /* synthetic */ String cl(boolean z) {
        return Ti();
    }

    public static /* synthetic */ String cm(boolean z) {
        return ch(true);
    }

    public static /* synthetic */ String cn(boolean z) {
        return ci(true);
    }

    public static /* synthetic */ String co(boolean z) {
        return Tj();
    }

    public static /* synthetic */ String cp(boolean z) {
        return Tk();
    }

    public static /* synthetic */ String cq(boolean z) {
        return Tl();
    }

    public static String dA(Context context) {
        return h(context, false);
    }

    public static String dB(Context context) {
        return i(context, false);
    }

    public static String dC(Context context) {
        return j(context, false);
    }

    public static String dD(Context context) {
        return k(context, false);
    }

    public static String dE(Context context) {
        return l(context, false);
    }

    public static String dF(Context context) {
        return m(context, false);
    }

    public static String dG(Context context) {
        return n(context, false);
    }

    public static int dH(Context context) {
        return br.ei(context);
    }

    private static String dI(Context context) {
        int iEi = br.ei(context);
        return iEi > 0 ? com.kwad.sdk.e.b.a(false, String.valueOf(iEi), 0) : Build.VERSION.SDK_INT < 23 ? com.kwad.sdk.e.b.a(false, String.valueOf(iEi), 1) : com.kwad.sdk.e.b.a(false, String.valueOf(iEi), 3);
    }

    public static int dJ(Context context) {
        return br.ej(context);
    }

    private static String dK(Context context) {
        List<cd.a> listO = o(context, 15);
        if (listO != null && listO.size() > 0) {
            return com.kwad.sdk.e.b.a(bc.useNetworkStateDisable(), aa.S(listO), 0);
        }
        if (bc.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(32L)) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", cd.er(context) ? 1 : 3);
    }

    private static Map<String, AppPackageInfo> dL(Context context) {
        com.kwad.sdk.components.p pVar = (com.kwad.sdk.components.p) com.kwad.sdk.components.d.f(com.kwad.sdk.components.p.class);
        return (pVar == null || !s.RL()) ? new HashMap() : pVar.P(context);
    }

    private static String dM(Context context) {
        com.kwad.sdk.core.c.b.Ji();
        if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
            return com.kwad.sdk.e.b.a(false, "", 5);
        }
        Map<String, AppPackageInfo> mapDL = dL(context);
        if (mapDL.size() > 0) {
            boolean z = bc.readInstalledPackagesDisable() && bc.getDevInstalledPackages() != null;
            com.kwad.sdk.components.p pVar = (com.kwad.sdk.components.p) com.kwad.sdk.components.d.f(com.kwad.sdk.components.p.class);
            if (pVar != null && s.RL()) {
                return com.kwad.sdk.e.b.a(z, pVar.c(mapDL), 0);
            }
        }
        if (bc.readInstalledPackagesDisable() || !s.RL()) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", br.ep(context) ? 3 : 1);
    }

    private static String dN(Context context) {
        com.kwad.sdk.utils.c.a aVarCU = x.cU(context);
        if (aVarCU == null || aVarCU.bhT == null) {
            if (bc.readLocationDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(64L)) {
                return com.kwad.sdk.e.b.a(false, "", 1);
            }
            return com.kwad.sdk.e.b.a(false, "", ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == 0 ? 3 : 1);
        }
        HashMap map = new HashMap();
        map.put("latitude", String.valueOf(aVarCU.bhT.getLatitude()));
        map.put("longitude", String.valueOf(aVarCU.bhT.getLongitude()));
        return com.kwad.sdk.e.b.a(bc.readLocationDisable() && bc.Tf() != null, aa.parseMap2JSON(map), 0);
    }

    @NonNull
    private static com.kwad.sdk.e.c dO(final Context context) {
        return new com.kwad.sdk.e.c() { // from class: com.kwad.sdk.utils.bd.1
            @Override // com.kwad.sdk.e.a
            public final String NU() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + bd.p(context, true));
                return bd.p(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String NV() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + bd.r(context, true));
                return bd.r(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String NW() {
                String strS = bd.s(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + strS);
                return strS;
            }

            @Override // com.kwad.sdk.e.a
            public final String NX() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMSI:" + bd.t(context, true));
                return bd.t(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String NY() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + bd.v(context, true));
                return bd.v(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String NZ() {
                String strCk = bd.ck(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + strCk);
                return strCk;
            }

            @Override // com.kwad.sdk.e.a
            public final String Oa() {
                String strCl = bd.cl(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + strCl);
                return strCl;
            }

            @Override // com.kwad.sdk.e.a
            public final String Ob() {
                String strW = bd.w(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getWifiList:" + strW);
                return strW;
            }

            @Override // com.kwad.sdk.e.a
            public final String Oc() {
                String strY = bd.y(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppList:" + strY);
                return strY;
            }

            @Override // com.kwad.sdk.e.a
            public final String Od() {
                String strCo = bd.co(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkType:" + strCo);
                return strCo;
            }

            @Override // com.kwad.sdk.e.a
            public final String getAppId() {
                String strCq = bd.cq(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppId:" + strCq);
                return strCq;
            }

            @Override // com.kwad.sdk.e.a
            public final String getDeviceId() {
                String strCm = bd.cm(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + strCm);
                return strCm;
            }

            @Override // com.kwad.sdk.e.a
            public final String getIMEI() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI:" + bd.o(context, true));
                return bd.o(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getIccId() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIccId:" + bd.u(context, true));
                return bd.u(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getIp() {
                String strCn = bd.cn(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIp:" + strCn);
                return strCn;
            }

            @Override // com.kwad.sdk.e.a
            public final String getLocation() {
                String strX = bd.x(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getLocation:" + strX);
                return strX;
            }

            @Override // com.kwad.sdk.e.a
            public final String getMac() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getMac:" + bd.q(context, true));
                return bd.q(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getOaid() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getOaid:" + bd.cj(true));
                return bd.cj(true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getSdkVersion() {
                String strCp = bd.cp(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkVersion:" + strCp);
                return strCp;
            }
        };
    }

    private static String getAppId() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppId();
    }

    public static String getDeviceId() {
        return ch(false);
    }

    public static String getOaid() {
        return cg(false);
    }

    private static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    private static String h(Context context, boolean z) {
        String strZ = br.z(context, z);
        if (!z) {
            return TextUtils.isEmpty(strZ) ? "" : strZ;
        }
        if (!TextUtils.isEmpty(strZ)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei()), strZ, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, strZ, 4);
        }
        if (bc.usePhoneStateDisable() || !s.RN()) {
            return com.kwad.sdk.e.b.a(false, strZ, 1);
        }
        return com.kwad.sdk.e.b.a(false, strZ, SystemUtil.dZ(context) ? 3 : 1);
    }

    private static String i(Context context, boolean z) {
        String strDB = br.dB(context);
        if (!z) {
            return TextUtils.isEmpty(strDB) ? "" : strDB;
        }
        if (TextUtils.isEmpty(strDB)) {
            return (bc.usePhoneStateDisable() || !s.RH()) ? com.kwad.sdk.e.b.a(false, strDB, 1) : com.kwad.sdk.e.b.a(false, strDB, 5);
        }
        return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevAndroidId()), strDB, 0);
    }

    public static void init(Context context) {
        com.kwad.sdk.e.b.a(dO(context));
    }

    private static String j(Context context, boolean z) {
        String strEn = br.en(context);
        if (!z) {
            return TextUtils.isEmpty(strEn) ? "" : strEn;
        }
        if (!TextUtils.isEmpty(strEn)) {
            return com.kwad.sdk.e.b.a(bc.useMacAddressDisable() && !TextUtils.isEmpty(bc.getDevMacAddress()), strEn.toLowerCase(), 0);
        }
        if (bc.useMacAddressDisable() || !s.RI()) {
            return com.kwad.sdk.e.b.a(false, strEn, 0);
        }
        return com.kwad.sdk.e.b.a(false, strEn, au.aw(context, com.kuaishou.weapon.p0.g.d) == 0 ? 3 : 1);
    }

    private static String k(Context context, boolean z) {
        String[] strArrEh = br.eh(context);
        String str = (strArrEh == null || strArrEh.length <= 0) ? null : strArrEh[0];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (bc.usePhoneStateDisable() || !s.RN()) {
            return com.kwad.sdk.e.b.a(false, str, 1);
        }
        return com.kwad.sdk.e.b.a(false, str, SystemUtil.dZ(context) ? 3 : 1);
    }

    private static String l(Context context, boolean z) {
        String[] strArrEh = br.eh(context);
        String str = (strArrEh == null || strArrEh.length <= 1) ? null : strArrEh[1];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (bc.usePhoneStateDisable() || !s.RN()) {
            return com.kwad.sdk.e.b.a(false, str, 1);
        }
        return com.kwad.sdk.e.b.a(false, str, SystemUtil.dZ(context) ? 3 : 1);
    }

    private static String m(Context context, boolean z) {
        String strDF = br.dF(context);
        if (!z) {
            return TextUtils.isEmpty(strDF) ? "" : strDF;
        }
        if (!TextUtils.isEmpty(strDF)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable(), strDF, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, strDF, 4);
        }
        if (bc.usePhoneStateDisable() || !s.RO()) {
            return com.kwad.sdk.e.b.a(false, strDF, 1);
        }
        return com.kwad.sdk.e.b.a(false, strDF, SystemUtil.dZ(context) ? 3 : 1);
    }

    private static String n(Context context, boolean z) {
        String strEk = br.ek(context);
        if (!z) {
            return TextUtils.isEmpty(strEk) ? "" : strEk;
        }
        if (!TextUtils.isEmpty(strEk)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable(), strEk, 0);
        }
        if (bc.usePhoneStateDisable() || !s.RP()) {
            return com.kwad.sdk.e.b.a(false, strEk, 1);
        }
        return com.kwad.sdk.e.b.a(false, strEk, SystemUtil.dZ(context) ? 3 : 1);
    }

    public static /* synthetic */ String o(Context context, boolean z) {
        return h(context, true);
    }

    public static /* synthetic */ String p(Context context, boolean z) {
        return i(context, true);
    }

    public static /* synthetic */ String q(Context context, boolean z) {
        return j(context, true);
    }

    public static /* synthetic */ String r(Context context, boolean z) {
        return k(context, true);
    }

    public static /* synthetic */ String s(Context context, boolean z) {
        return l(context, true);
    }

    public static /* synthetic */ String t(Context context, boolean z) {
        return m(context, true);
    }

    public static /* synthetic */ String u(Context context, boolean z) {
        return n(context, true);
    }

    public static /* synthetic */ String v(Context context, boolean z) {
        return dI(context);
    }

    public static /* synthetic */ String w(Context context, boolean z) {
        return dK(context);
    }

    public static /* synthetic */ String x(Context context, boolean z) {
        return dN(context);
    }

    public static /* synthetic */ String y(Context context, boolean z) {
        return dM(context);
    }

    public static List<cd.a> o(Context context, int i) {
        return cd.o(context, 15);
    }
}
