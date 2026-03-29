package com.zenmen.palmchat.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import cn.shuzilm.core.Listener;
import cn.shuzilm.core.Main;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qiniu.android.utils.Crc32;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.open.sec.SmDuManager;
import com.wifi.open.sec.StringCallback;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.ir5;
import defpackage.k86;
import defpackage.nl0;
import defpackage.rb3;
import defpackage.v4;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SmidHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15715a;
    public static String b;
    public static String c;
    public static final AtomicBoolean d = new AtomicBoolean(false);
    public static ArrayList<e> e = new ArrayList<>();
    public static boolean f = false;
    public static boolean g = false;
    public static String h = null;
    public static String i = null;
    public static StringCallback j = new b();
    public static boolean k = false;

    /* JADX INFO: compiled from: SearchBox */
    public enum SMScene {
        Login("00"),
        FRIEND_ADD(HiAnalyticsConstant.KeyAndValue.NUMBER_01),
        FRIEND_AGREE(com.huawei.hms.ads.dynamic.a.t),
        CHAT_PRIVATE("03"),
        CHAT_FRIEND("04"),
        CHAT_GROUP("05"),
        SQUARE_COMMENT("06"),
        SQUARE_PUBLISH("07");

        private String code;

        SMScene(String str) {
            this.code = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements StringCallback {
        @Override // com.wifi.open.sec.StringCallback
        public void callback(String str) {
            LogUtil.i("SmidHelper", "getDuLabelAsync end" + str);
            if (str != null) {
                SmidHelper.z(str);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements StringCallback {
        @Override // com.wifi.open.sec.StringCallback
        public void callback(String str) {
            LogUtil.i("SmidHelper", "get3: " + str);
            if (str != null) {
                SmidHelper.d.set(false);
                SmidHelper.f15715a = str;
                SmidHelper.y(str);
                Iterator it = SmidHelper.e.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).callback(str);
                }
                SmidHelper.e.clear();
                SmidHelper.f = false;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Listener {
        @Override // cn.shuzilm.core.Listener
        public void handler(String str) {
            LogUtil.i("MdidSdkConfigHelper", "getOpenAnmsID s=" + str);
            SmidHelper.h = str;
            SmidHelper.u(false, str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Listener {
        @Override // cn.shuzilm.core.Listener
        public void handler(String str) {
            LogUtil.i("MdidSdkConfigHelper", "getHMSOpenAnmsID s=" + str);
            SmidHelper.i = str;
            SmidHelper.u(true, str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void callback(String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Set<String> f15716a = new HashSet();
        public static long b = 0;
        public static boolean c = false;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Listener {
            @Override // cn.shuzilm.core.Listener
            public void handler(String str) {
                LogUtil.i("SmSceneReporter", "report end " + str);
                if (!TextUtils.isEmpty(str)) {
                    SmidHelper.f15715a = str;
                }
                f.c = false;
            }
        }

        public static String b(SMScene sMScene) {
            String strB = k86.b(v4.e(com.zenmen.palmchat.c.b()));
            return (f(strB) + strB) + "-" + sMScene.code + "-" + e();
        }

        public static void c() {
            f15716a.clear();
        }

        public static String d(String str) {
            return str.replace("-", "").replace("_", "");
        }

        public static String e() {
            String str = ac1.m;
            if (nl0.c().equals("debug")) {
                str = "zx_test";
            }
            return rb3.c(str) + "_" + ac1.f + "_" + d(Build.MANUFACTURER) + "_" + d(Build.MODEL);
        }

        public static String f(String str) {
            return Long.toString(Crc32.bytes(str.getBytes()), 16);
        }

        public static void g(SMScene sMScene) {
            if (SmDuManager.isNeedInit() && !f15716a.contains(sMScene.code) && Math.abs(b - ir5.b()) >= 2000 && !c) {
                c = true;
                b = ir5.b();
                f15716a.add(sMScene.code);
                try {
                    String strB = b(sMScene);
                    LogUtil.i("SmSceneReporter", "report " + strB);
                    Main.getQueryID(com.zenmen.palmchat.c.b(), rb3.c(ac1.m), strB, 1, new a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static String j(String str) {
        return t(str) ? str : t(i) ? i : t(h) ? h : str;
    }

    public static synchronized void k(e eVar) {
        LogUtil.i("SmidHelper", "get1");
        if (SmDuManager.isNeedInit()) {
            if (TextUtils.isEmpty(f15715a)) {
                if (eVar != null) {
                    e.add(eVar);
                }
                LogUtil.i("SmidHelper", "get1.5");
                if (!d.getAndSet(true)) {
                    LogUtil.i("SmidHelper", "get2");
                    if (!f) {
                        f = true;
                        SmDuManager.Get(j);
                    }
                }
            }
        }
    }

    public static String l() {
        LogUtil.i("SmidHelper", "getLocalCacheId start" + b);
        if (b == null) {
            b = SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, "local_smid", "");
        }
        LogUtil.i("SmidHelper", "getLocalCacheId end" + b);
        return b;
    }

    public static String m() {
        LogUtil.i("SmidHelper", "getLocalCacheLabel start" + c);
        if (c == null) {
            c = SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, "local_smid_label", "");
        }
        LogUtil.i("SmidHelper", "getLocalCacheLabel end" + c);
        return c;
    }

    public static void n() {
        if (k) {
            boolean zEqualsIgnoreCase = Build.MANUFACTURER.equalsIgnoreCase("HONOR");
            boolean zS = s();
            boolean z = ir5.b() < 1719763200000L;
            LogUtil.i("MdidSdkConfigHelper", "SM onInitFinished isHonorManu=" + zEqualsIgnoreCase + " isNewHonorDevice=" + zS + " isRightTime=" + z);
            Main.getOpenAnmsID(com.zenmen.palmchat.c.b(), new c());
            if (zEqualsIgnoreCase && !zS && z) {
                Main.getHMSOpenAnmsID(com.zenmen.palmchat.c.b(), new d());
            }
        }
    }

    public static String o() {
        return p(null);
    }

    public static String p(e eVar) {
        if (TextUtils.isEmpty(f15715a)) {
            String deviceId = SmDuManager.getDeviceId();
            if (TextUtils.isEmpty(deviceId)) {
                k(eVar);
            } else {
                f15715a = deviceId;
            }
            if (TextUtils.isEmpty(f15715a)) {
                String strL = l();
                if (!TextUtils.isEmpty(strL)) {
                    f15715a = strL;
                }
            }
        }
        LogUtil.i("SmidHelper", "getSzlmId =" + f15715a);
        return f15715a;
    }

    public static String q() {
        String duLabel = SmDuManager.getDuLabel();
        LogUtil.i("SmidHelper", "getSzlmLabel start=" + duLabel);
        if (duLabel != null) {
            z(duLabel);
            return duLabel;
        }
        String strM = m();
        LogUtil.i("SmidHelper", "getSzlmLabel cache" + strM);
        SmDuManager.getDuLabelAsync(new a());
        return strM;
    }

    public static void r() {
        LogUtil.i("SmidHelper", "hasInitOnReady" + g);
        if (g) {
            return;
        }
        g = true;
        SmDuManager.initOnReady(com.zenmen.palmchat.c.b(), ac1.m, ac1.p);
    }

    public static boolean s() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR")) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, LxAdEmuiDevice.PROP_VERSION);
            if (str != null) {
                if (str.length() != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            Log.i("SmidHelper", "msg" + th.getMessage());
            return false;
        }
    }

    public static boolean t(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !TextUtils.isEmpty(str.replace("0", "").replace("-", ""));
    }

    public static void u(boolean z, String str) {
        HashMap map = new HashMap();
        if (z) {
            if (str == null) {
                str = "";
            }
            map.put("HMS_oaid", str);
        } else {
            if (str == null) {
                str = "";
            }
            map.put("oaid", str);
        }
        map.put(com.umeng.ccg.a.x, "SM");
        map.put("result", String.valueOf(true));
        zn6.i("oaidGetResult", map);
    }

    public static void v() {
        k = true;
        n();
    }

    public static void w() {
        f.c();
    }

    public static void x(SMScene sMScene) {
        f.g(sMScene);
    }

    public static void y(String str) {
        if (str == null || str.equals(b)) {
            return;
        }
        b = str;
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "local_smid", str);
        LogUtil.i("SmidHelper", "updateLocalCacheId id=" + str);
    }

    public static void z(String str) {
        if (str == null || str.equals(c)) {
            return;
        }
        c = str;
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "local_smid_label", str);
        LogUtil.i("SmidHelper", "updateLocalCacheLabel id=" + str);
    }
}
