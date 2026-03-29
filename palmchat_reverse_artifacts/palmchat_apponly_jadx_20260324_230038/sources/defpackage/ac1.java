package defpackage;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.platform.comapi.map.MapController;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.lantern.auth.server.WkParams;
import com.oplus.tblplayer.misc.MediaInfo;
import com.umeng.ccg.a;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdMiuiDevice;
import com.wifi.adsdk.utils.LxAdOppoDevice;
import com.wifi.adsdk.utils.LxAdVivoDevice;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.privinfo.PrivInfoManager;
import com.zenmen.palmchat.utils.SmidHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ac1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1194a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static boolean n;
    public static String o;
    public static String p;
    public static String q;
    public static final String r;
    public static List<String> s;
    public static String t;

    static {
        r = nl0.g() ? "zx_default" : MapController.DEFAULT_LAYER_TAG;
        s = null;
        t = null;
    }

    public static void A(Context context) {
        if (r75.l()) {
            k(context);
            g();
            e(context);
        }
    }

    public static void B(Context context) {
        h();
        i();
        l();
        j();
        m();
        d();
        f();
        p(context);
        A(context);
    }

    public static boolean C() {
        return m.startsWith("HWEX") && !m.startsWith("HWEX2");
    }

    public static boolean D() {
        String str = m;
        return str != null && str.startsWith("HWEX");
    }

    public static boolean E(Context context) {
        String strP = p(context);
        if (strP != null) {
            return strP.equals(r) || strP.equals("WF_8F070A55480488C4");
        }
        return false;
    }

    public static boolean F(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null && telephonyManager.getPhoneType() == 0;
    }

    public static boolean G() {
        String str = m;
        return str != null && str.startsWith("XM");
    }

    public static boolean a() {
        if (b()) {
            return true;
        }
        return r75.l();
    }

    public static boolean b() {
        return false;
    }

    public static void c(Context context) {
        m = r;
        try {
            if (context.getResources() != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(context.getResources().getAssets().open("channel"), StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                if (!TextUtils.isEmpty(line)) {
                    m = line;
                }
                bufferedReader.close();
                inputStreamReader.close();
            }
        } catch (IOException e2) {
            LogUtil.i("fetchChannelId", e2.toString());
        }
    }

    public static void d() {
        try {
            Application applicationB = c.b();
            PackageInfo packageInfo = applicationB.getPackageManager().getPackageInfo(applicationB.getPackageName(), 0);
            f = "" + packageInfo.versionCode;
            g = "" + packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            f = "unknown";
            g = "unknown";
        }
    }

    public static void e(Context context) {
        String androidID;
        o = "";
        try {
            androidID = PrivInfoManager.INSTANCE.getAndroidID();
        } catch (Exception e2) {
            e2.printStackTrace();
            androidID = MediaInfo.RENDERER_TYPE_UNKNOWN;
        }
        p = androidID;
        o = i + "_" + k + "_" + p;
    }

    public static void f() {
        String strA;
        try {
            strA = c.e().d("tray_preference_device_id");
        } catch (Exception unused) {
            strA = null;
        }
        if (TextUtils.isEmpty(strA)) {
            strA = xn3.a();
            c.e().h("tray_preference_device_id", strA);
        }
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        h = strA;
    }

    public static void g() {
        k = r();
    }

    public static void h() {
        f1194a = Build.MANUFACTURER;
    }

    public static void i() {
        b = Build.MODEL;
        b05.a("mDeviceModel====>" + b);
    }

    public static void j() {
        d = Build.VERSION.SDK_INT + "";
    }

    @SuppressLint({"MissingPermission"})
    public static void k(Context context) {
        if (tg4.b(context, BaseActivityPermissionDispatcher.PermissionType.PHONE_STATE.permissionList)) {
            if (((TelephonyManager) c.b().getSystemService("phone")) != null) {
                try {
                    PrivInfoManager privInfoManager = PrivInfoManager.INSTANCE;
                    i = privInfoManager.getIMEI();
                    j = privInfoManager.getIMSI();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (TextUtils.isEmpty(i)) {
                    i = MediaInfo.RENDERER_TYPE_UNKNOWN;
                }
                if (TextUtils.isEmpty(j)) {
                    j = MediaInfo.RENDERER_TYPE_UNKNOWN;
                }
            } else {
                i = MediaInfo.RENDERER_TYPE_UNKNOWN;
                j = MediaInfo.RENDERER_TYPE_UNKNOWN;
            }
            if (!TextUtils.isEmpty(j)) {
                if (j.startsWith("46000") || j.startsWith("46002")) {
                    l = "中国移动";
                } else if (j.startsWith("46001")) {
                    l = "中国联通";
                } else if (j.startsWith("46003")) {
                    l = "中国电信";
                }
            }
            if (TextUtils.isEmpty(i)) {
                return;
            }
            if (!i.equals("000000000000000")) {
                String str = Build.MODEL;
                if (!str.equals(a.x) && !str.equals("google_sdk")) {
                    return;
                }
            }
            n = true;
        }
    }

    public static void l() {
        c = "android";
    }

    public static void m() {
        e = Build.VERSION.RELEASE;
    }

    public static void n(Context context) {
        String strD = "";
        try {
            strD = c.e().d("tray_preference_ua");
            if (TextUtils.isEmpty(strD)) {
                String strW = w(context);
                if (!TextUtils.isEmpty(strW)) {
                    try {
                        c.e().h("tray_preference_ua", strW);
                        strD = strW;
                    } catch (Exception e2) {
                        e = e2;
                        strD = strW;
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        q = strD;
    }

    @SuppressLint({"HardwareIds"})
    public static String o(Context context) {
        return p;
    }

    public static String p(Context context) {
        if (m == null) {
            c(context);
        }
        return m;
    }

    public static String q(Context context) {
        try {
            String str = h;
            String strE = v4.e(context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dhid", "");
            jSONObject.put(DeviceInfoUtil.DEVICEID_TAG, str);
            jSONObject.put(DeviceInfoUtil.UID_TAG, strE);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String r() {
        return "";
    }

    public static synchronized String s() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            List<String> listT = t();
            for (int i2 = 0; i2 < listT.size(); i2++) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("packageName", listT.get(i2));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("channelId", m + ("_" + xn3.a()));
            jSONObject.put(WkParams.IMEI, i);
            jSONObject.put("package", jSONArray);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static synchronized List<String> t() {
        if (s == null) {
            s = new ArrayList();
            boolean zD = D();
            LogUtil.i("loggetInstalledPackages", "isHwChannel=" + zD + " " + m);
            if (zD) {
                s.add(c.b().getPackageName());
            } else {
                List<PackageInfo> installedPackages = c.b().getPackageManager().getInstalledPackages(0);
                for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                    s.add(installedPackages.get(i2).packageName);
                }
            }
        }
        return s;
    }

    public static String u() {
        String strC = oy4.b() ? sb1.c("ro.build.version.magic") : dm1.d() ? sb1.c(LxAdEmuiDevice.PROP_VERSION) : j94.d() ? sb1.c(LxAdOppoDevice.PROP_VERSION) : lg6.c() ? sb1.c(LxAdVivoDevice.PROP_VERSION) : vp3.e() ? sb1.c(LxAdMiuiDevice.PROP_VERSION) : "";
        if (TextUtils.isEmpty(strC)) {
            strC = Build.MANUFACTURER;
        }
        LogUtil.d("getPushOs", strC);
        return strC;
    }

    public static String v() {
        return SmidHelper.o();
    }

    public static String w(Context context) {
        try {
            return WebSettings.getDefaultUserAgent(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static String x(Context context) {
        if (q == null) {
            n(context);
        }
        return q;
    }

    public static String y() {
        if (t == null) {
            t = z();
        }
        return t;
    }

    public static String z() {
        return "";
    }
}
