package defpackage;

import android.text.TextUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class jo6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f18457a = new HashMap();
    public static final Map<String, String> b = new HashMap();
    public static final Map<String, Integer> c = new HashMap();
    public static boolean d = false;
    public static c e = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static HashMap<String, String> f18458a;

        static {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            f18458a = linkedHashMap;
            linkedHashMap.put("LX-15980", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-16351", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-17165", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-17854", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-18030", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-18357", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-20232", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-20308", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-21684", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-22056", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-28151", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-28472", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-28913", WkAdxAdConfigMg.DSP_NAME_CSJ);
            f18458a.put("LX-30579", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-34227", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-37955", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-38802", WkAdxAdConfigMg.DSP_NAME_CSJ);
            f18458a.put("LX-38893", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-42149", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-42239", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-42300", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-43042", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-43178", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-43257", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-44445", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-45488", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-47326", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-42517", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            f18458a.put("LX-20245", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        }

        public static String a(String str) {
            return f18458a.get(str);
        }

        public static void b() {
            LogUtil.i("PandaTransferKeyManager", "config =" + new JSONObject(f18458a));
            LogUtil.json("PandaTransferKeyManager", new JSONObject(f18458a), "defaultconfig.json");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Map<String, String> f18459a = new HashMap();

        public final String a(String str, String str2) {
            String strN = ap3.a().n(str, "");
            if (TextUtils.isEmpty(strN)) {
                strN = a.a(str);
                if (TextUtils.isEmpty(strN)) {
                    strN = str2;
                }
            }
            LogUtil.i("PandaTransferKeyManager", "getStringImp key=" + str + " defValue=" + str2 + " result=" + strN);
            return strN;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String b(String str, String str2, boolean z) {
            boolean z2;
            String strA = z ? f18459a.get(str) : null;
            if (strA != null) {
                z2 = true;
            } else {
                z2 = false;
                if (lo6.a(str)) {
                    strA = lo6.b(str, str2);
                    if (strA != null) {
                        f18459a.put(str, strA);
                    } else {
                        strA = str2;
                    }
                } else {
                    strA = dt5.a(str);
                    if (TextUtils.isEmpty(strA)) {
                        strA = a(str, str2);
                        if (strA != null) {
                            f18459a.put(str, strA);
                        }
                    } else {
                        f18459a.put(str, strA);
                    }
                }
            }
            LogUtil.i("WKTaiChiImp", "getStringInner key=" + str + "def=" + str2 + "useCache=" + z + " result = " + strA + " cached=" + z2 + " hasInitialed=true");
            return strA;
        }

        @Override // jo6.c
        public boolean getBoolean(String str, boolean z) {
            return WkAdxAdConfigMg.DSP_NAME_BAIDU.equals(b(str, z ? WkAdxAdConfigMg.DSP_NAME_BAIDU : "A", true));
        }

        @Override // jo6.c
        public String getString(String str, String str2) {
            return b(str, str2, true);
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        boolean getBoolean(String str, boolean z);

        String getString(String str, String str2);
    }

    public static boolean A() {
        return d("LX-27820");
    }

    public static boolean B() {
        return true;
    }

    public static boolean C() {
        boolean zA = a("LX-30777", false);
        LogUtil.i("WkTaiChiProxy", "isLX30777Open =" + zA);
        return zA;
    }

    public static boolean D() {
        return d("LX-35838");
    }

    public static boolean E() {
        boolean zD = d("LX-37908");
        LogUtil.i("WkTaiChiProxy", "isLX37908Open =" + zD);
        return zD;
    }

    public static boolean F() {
        return a("LX-41829", false);
    }

    public static boolean G() {
        return a("LX-42472", false);
    }

    public static boolean H() {
        return a("LX-42517", false);
    }

    public static boolean I() {
        return true;
    }

    public static boolean J() {
        return false;
    }

    public static boolean K() {
        return d;
    }

    public static void L() {
        LogUtil.w("WkTaiChiProxy", "\n----------------------");
        for (Map.Entry<String, Integer> entry : c.entrySet()) {
            if (entry.getValue().intValue() > 10) {
                LogUtil.w("WkTaiChiProxy", entry.getKey() + ", value = " + e.getString(entry.getKey(), "A") + ", count = " + entry.getValue());
            }
        }
        LogUtil.w("WkTaiChiProxy", "\n----------------------");
    }

    public static void M(String str) {
        if (d) {
            Map<String, Integer> map = c;
            if (map.containsKey(str)) {
                map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
            } else {
                map.put(str, 1);
            }
        }
    }

    public static void N(boolean z) {
        d = z;
    }

    public static boolean a(String str, boolean z) {
        M(str);
        c cVar = e;
        if (cVar != null) {
            try {
                return cVar.getBoolean(str, z);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return z;
    }

    public static String b() {
        return c("LX-16947", "A");
    }

    public static String c(String str, String str2) {
        M(str);
        c cVar = e;
        if (cVar != null) {
            try {
                return cVar.getString(str, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str2;
    }

    public static boolean d(String str) {
        Map<String, Integer> map = f18457a;
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(a(str, false) ? 1 : 0));
        }
        Integer num = map.get(str);
        LogUtil.d("WkTaiChiProxy", "getTaichiValue key = " + str + ", value = " + num);
        return num != null && num.intValue() == 1;
    }

    public static String e(String str) {
        Map<String, String> map = b;
        if (!map.containsKey(str)) {
            map.put(str, c(str, "A"));
        }
        return map.get(str);
    }

    public static String f(String str, String str2) {
        Map<String, String> map = b;
        if (!map.containsKey(str)) {
            map.put(str, c(str, str2));
        }
        return map.get(str);
    }

    public static boolean g(String str) {
        return "A".equals(e(str));
    }

    public static boolean h(String str) {
        return WkAdxAdConfigMg.DSP_NAME_BAIDU.equals(e(str));
    }

    public static boolean i() {
        return a("LX-11089", false);
    }

    public static boolean j() {
        boolean zA = a("LX-11813", false);
        LogUtil.i("WkTaiChiProxy", "isLX11813pen =" + zA);
        return zA;
    }

    public static boolean k() {
        return true;
    }

    public static boolean l() {
        boolean zA = a("LX-15367", false);
        LogUtil.i("WkTaiChiProxy", "isLX15367Open =" + zA);
        return zA;
    }

    public static boolean m() {
        return d("LX-15877");
    }

    public static boolean n() {
        return d("LX-15980");
    }

    public static boolean o() {
        return d("LX-16136");
    }

    public static boolean p() {
        boolean zA = a("LX-16838", false);
        LogUtil.i("WkTaiChiProxy", "isLX16838Open =" + zA);
        return zA;
    }

    public static boolean q() {
        boolean zA = a("LX-17600", false);
        LogUtil.i("WkTaiChiProxy", "isLX17600Open =" + zA);
        return zA;
    }

    public static boolean r() {
        boolean zA = a("LX-17770", false);
        LogUtil.i("WkTaiChiProxy", "isLX17770Open =" + zA);
        return zA;
    }

    public static boolean s() {
        boolean zA = a("LX-18132", false);
        LogUtil.i("WkTaiChiProxy", "isLX18132Open =" + zA);
        return zA;
    }

    public static boolean t() {
        return a("LX-18912", false);
    }

    public static boolean u() {
        boolean zA = a("LX-19529", false);
        LogUtil.i("WkTaiChiProxy", "isLX19529Open =" + zA);
        return zA;
    }

    public static boolean v() {
        boolean zA = a("LX-19561", false);
        LogUtil.i("WkTaiChiProxy", "isLX19561Open =" + zA);
        return zA;
    }

    public static boolean w() {
        boolean zA = a("LX-20311", false);
        LogUtil.i("WkTaiChiProxy", "isLX20311Open =" + zA);
        return zA;
    }

    public static boolean x() {
        boolean zA = a("LX-21646", false);
        LogUtil.i("WkTaiChiProxy", "isLX21646Open =" + zA);
        return zA;
    }

    public static boolean y() {
        boolean zA = a("LX-22928", false);
        LogUtil.i("WkTaiChiProxy", "isLX22928Open =" + zA);
        return zA;
    }

    public static boolean z() {
        boolean zA = a("LX-25362", false);
        LogUtil.i("WkTaiChiProxy", "isLX25362Open =" + zA);
        return zA;
    }
}
