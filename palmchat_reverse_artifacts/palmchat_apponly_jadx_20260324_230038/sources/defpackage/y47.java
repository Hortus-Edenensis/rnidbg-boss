package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cdadata.cdazmj.cdazmb;
import com.cdadata.sdk.api.IAppParams;
import com.cdadata.sdk.api.ZMDataSDKManager;
import com.kuaishou.weapon.p0.g;
import com.qq.gdt.action.ActionUtils;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class y47 {
    public static y47 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f22121a = new HashMap();
    public String b = "";
    public String c = "";
    public IAppParams d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements x57 {
        public a() {
        }

        @Override // defpackage.x57
        public void callBackLocation(String str, String str2) {
            y47 y47Var = y47.this;
            y47Var.b = str;
            y47Var.c = str2;
        }
    }

    public static y47 k() {
        if (e == null) {
            synchronized (y47.class) {
                if (e == null) {
                    e = new y47();
                }
            }
        }
        return e;
    }

    public String a() {
        String brand = "";
        if (c("brand")) {
            return this.f22121a.get("brand");
        }
        if (ZMDataSDKManager.getInstance().zmConfigOptions.isBrandEnable) {
            brand = Build.BRAND.toLowerCase();
        } else {
            IAppParams iAppParams = this.d;
            if (iAppParams != null) {
                brand = iAppParams.getBrand();
            }
        }
        this.f22121a.put("brand", brand);
        return brand;
    }

    public String b(Context context) {
        String androidId;
        String str = "";
        if (c("aid")) {
            return this.f22121a.get("aid");
        }
        if (ZMDataSDKManager.getInstance().zmConfigOptions.isAndroididEnable) {
            androidId = cdazmb.c(context);
        } else {
            IAppParams iAppParams = this.d;
            androidId = iAppParams != null ? iAppParams.getAndroidId() : "";
            try {
                try {
                } catch (Exception unused) {
                    return androidId;
                }
            } catch (Exception unused2) {
                str = androidId;
            }
            if (TextUtils.isEmpty(androidId)) {
                c57 c57VarL = c57.l();
                c57VarL.getClass();
                try {
                    String[] strArrE = c57VarL.c.e(o57.a().n, 1, true);
                    if (strArrE != null && strArrE.length > 0) {
                        androidId = strArrE[0];
                    }
                } catch (Exception e2) {
                    g57.a(e2);
                }
                this.f22121a.put("aid", str);
                return str;
            }
            c57 c57VarL2 = c57.l();
            c57VarL2.getClass();
            if (!TextUtils.isEmpty(androidId)) {
                try {
                    c57VarL2.c.b(o57.a().n, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, androidId), true);
                } catch (JSONException e3) {
                    g57.a(e3);
                }
            }
        }
        str = androidId;
        this.f22121a.put("aid", str);
        return str;
    }

    public final boolean c(String str) {
        Map<String, String> map = this.f22121a;
        return (map == null || !map.containsKey(str) || TextUtils.isEmpty(this.f22121a.get(str))) ? false : true;
    }

    public String d() {
        IAppParams iAppParams = this.d;
        return iAppParams != null ? iAppParams.getCapSsid() : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0058 A[Catch: Exception -> 0x00bf, TryCatch #1 {Exception -> 0x00bf, blocks: (B:3:0x0004, B:5:0x000a, B:6:0x0014, B:8:0x001e, B:49:0x00b8, B:24:0x0058, B:21:0x004a, B:23:0x0055, B:25:0x005b, B:27:0x005f, B:9:0x0020, B:11:0x0028, B:13:0x0033, B:15:0x003d, B:18:0x0045), top: B:57:0x0004, inners: #3, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String e(Context context) {
        String carrier;
        TelephonyManager telephonyManager;
        String str = "";
        try {
            if (c(bt.P)) {
                return this.f22121a.get(bt.P);
            }
            if (ZMDataSDKManager.getInstance().zmConfigOptions.isCarrierEnable) {
                String str2 = cdazmb.f1964a;
                try {
                    try {
                    } catch (Error e2) {
                        g57.b("DeviceInfoUtils", e2.toString());
                    }
                } catch (Exception e3) {
                    g57.a(e3);
                }
                if (l67.a(context, g.c)) {
                    try {
                        telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    } catch (Exception e4) {
                        g57.a(e4);
                    }
                    if (telephonyManager != null) {
                        String simOperator = telephonyManager.getSimOperator();
                        if (TextUtils.isEmpty(simOperator)) {
                            carrier = cdazmb.b;
                        } else {
                            carrier = cdazmb.e(context, simOperator, telephonyManager);
                            cdazmb.b = carrier;
                        }
                    }
                }
            } else {
                IAppParams iAppParams = this.d;
                carrier = iAppParams != null ? iAppParams.getCarrier() : "";
                try {
                    if (TextUtils.isEmpty(carrier)) {
                        c57 c57VarL = c57.l();
                        c57VarL.getClass();
                        try {
                            String[] strArrE = c57VarL.c.e(o57.a().r, 1, true);
                            if (strArrE != null && strArrE.length > 0) {
                                carrier = strArrE[0];
                            }
                        } catch (Exception e5) {
                            g57.a(e5);
                        }
                        this.f22121a.put(bt.P, str);
                    } else {
                        c57 c57VarL2 = c57.l();
                        c57VarL2.getClass();
                        if (!TextUtils.isEmpty(carrier)) {
                            try {
                                c57VarL2.c.b(o57.a().r, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, carrier), true);
                            } catch (JSONException e6) {
                                g57.a(e6);
                            }
                        }
                    }
                } catch (Exception unused) {
                    str = carrier;
                }
            }
            str = carrier;
            this.f22121a.put(bt.P, str);
        } catch (Exception unused2) {
        }
        return str;
    }

    public String f() {
        IAppParams iAppParams = this.d;
        return iAppParams != null ? iAppParams.getDid() : "";
    }

    public String g(Context context) {
        String[] strArrE;
        if (!ZMDataSDKManager.getInstance().zmConfigOptions.isGPSEnable) {
            IAppParams iAppParams = this.d;
            if (iAppParams != null) {
                this.b = iAppParams.getLatitude();
            }
            if (TextUtils.isEmpty(this.b)) {
                c57 c57VarL = c57.l();
                c57VarL.getClass();
                try {
                    strArrE = c57VarL.c.e(o57.a().p, 1, true);
                } catch (Exception e2) {
                    g57.a(e2);
                }
                String str = (strArrE == null || strArrE.length <= 0) ? "" : strArrE[0];
                this.b = str;
            } else {
                c57 c57VarL2 = c57.l();
                String str2 = this.b;
                c57VarL2.getClass();
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        c57VarL2.c.b(o57.a().p, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, str2), true);
                    } catch (JSONException e3) {
                        g57.a(e3);
                    }
                }
            }
        } else if (TextUtils.isEmpty(this.b)) {
            d67.a(context, new a());
        }
        return this.b;
    }

    public String h() {
        IAppParams iAppParams = this.d;
        return iAppParams != null ? iAppParams.getEpid() : "";
    }

    public String i(Context context) {
        String netWorkType;
        String str = "";
        if (c("networkType")) {
            return this.f22121a.get("networkType");
        }
        if (ZMDataSDKManager.getInstance().zmConfigOptions.isCarrierEnable) {
            netWorkType = cdazmb.v(context);
        } else {
            IAppParams iAppParams = this.d;
            netWorkType = iAppParams != null ? iAppParams.getNetWorkType() : "";
            try {
                try {
                } catch (Exception unused) {
                    return netWorkType;
                }
            } catch (Exception unused2) {
                str = netWorkType;
            }
            if (TextUtils.isEmpty(netWorkType)) {
                c57 c57VarL = c57.l();
                c57VarL.getClass();
                try {
                    String[] strArrE = c57VarL.c.e(o57.a().s, 1, true);
                    if (strArrE != null && strArrE.length > 0) {
                        netWorkType = strArrE[0];
                    }
                } catch (Exception e2) {
                    g57.a(e2);
                }
                this.f22121a.put("networkType", str);
                return str;
            }
            c57 c57VarL2 = c57.l();
            c57VarL2.getClass();
            if (!TextUtils.isEmpty(netWorkType)) {
                try {
                    c57VarL2.c.b(o57.a().s, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, netWorkType), true);
                } catch (JSONException e3) {
                    g57.a(e3);
                }
            }
        }
        str = netWorkType;
        this.f22121a.put("networkType", str);
        return str;
    }

    public String j() {
        IAppParams iAppParams = this.d;
        return iAppParams != null ? iAppParams.getEsid() : "";
    }

    public String l() {
        String language = "";
        if (c("language")) {
            return this.f22121a.get("language");
        }
        if (ZMDataSDKManager.getInstance().zmConfigOptions.isLanguageEnable) {
            Configuration configuration = Resources.getSystem().getConfiguration();
            language = (Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale).getLanguage();
        } else {
            IAppParams iAppParams = this.d;
            if (iAppParams != null) {
                language = iAppParams.getLanguage();
            }
        }
        this.f22121a.put("language", language);
        return language;
    }

    public String m() {
        String[] strArrE;
        if (!ZMDataSDKManager.getInstance().zmConfigOptions.isGPSEnable) {
            IAppParams iAppParams = this.d;
            if (iAppParams != null) {
                this.c = iAppParams.getLongitude();
            }
            if (TextUtils.isEmpty(this.c)) {
                c57 c57VarL = c57.l();
                c57VarL.getClass();
                try {
                    strArrE = c57VarL.c.e(o57.a().q, 1, true);
                } catch (Exception e2) {
                    g57.a(e2);
                }
                String str = (strArrE == null || strArrE.length <= 0) ? "" : strArrE[0];
                this.c = str;
            } else {
                c57 c57VarL2 = c57.l();
                String str2 = this.c;
                c57VarL2.getClass();
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        c57VarL2.c.b(o57.a().q, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, str2), true);
                    } catch (JSONException e3) {
                        g57.a(e3);
                    }
                }
            }
        }
        return this.c;
    }

    public String n() {
        IAppParams iAppParams = this.d;
        return iAppParams != null ? iAppParams.getMapsp() : "";
    }

    public String o() {
        String os = "";
        if (c("os")) {
            return this.f22121a.get("os");
        }
        if (ZMDataSDKManager.getInstance().zmConfigOptions.isOSEnable) {
            os = cdazmb.g("os");
        } else {
            IAppParams iAppParams = this.d;
            if (iAppParams != null) {
                os = iAppParams.getOS();
            }
        }
        this.f22121a.put("os", os);
        return os;
    }

    public String p() {
        String oSVersion = "";
        if (c("os_version")) {
            return this.f22121a.get("os_version");
        }
        if (ZMDataSDKManager.getInstance().zmConfigOptions.isOSVersionEnable) {
            oSVersion = cdazmb.g("version");
        } else {
            IAppParams iAppParams = this.d;
            if (iAppParams != null) {
                oSVersion = iAppParams.getOSVersion();
            }
        }
        this.f22121a.put("os_version", oSVersion);
        return oSVersion;
    }

    public String q() {
        IAppParams iAppParams = this.d;
        return iAppParams != null ? iAppParams.getUid() : "";
    }
}
