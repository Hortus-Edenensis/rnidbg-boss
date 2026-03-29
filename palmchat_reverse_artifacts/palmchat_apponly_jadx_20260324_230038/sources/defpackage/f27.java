package defpackage;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lantern.auth.server.WkParams;
import com.umeng.analytics.pro.f;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f27 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17423a;
    public String b;
    public String c;
    public String d;

    public f27() {
        e("LSHD0001");
        f("agX@1Q$AI2YPLXSW", "aHj3CcB1$qJ^oErs", "Zj0VcpNop1t9f1&!jaPjMWVXfGrhL44F");
    }

    public static String b(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (String str : map.keySet()) {
            if (i > 0) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            String str2 = map.get(str);
            try {
                String strEncode = URLEncoder.encode(str, "UTF-8");
                if (str2 == null) {
                    str2 = "";
                }
                String strEncode2 = URLEncoder.encode(str2, "UTF-8");
                stringBuffer.append(strEncode);
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(strEncode2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public String a(String str, HashMap<String, String> map, boolean z) {
        return b(d(str, map));
    }

    public HashMap<String, String> c(Context context) {
        HashMap<String, String> map = new HashMap<>();
        map.put("appId", this.f17423a);
        map.put(WkParams.LANG, "cn");
        map.put("verName", "");
        map.put("verCode", "109");
        map.put("chanId", context.getPackageName());
        map.put(WkParams.ORIGCHANID, "");
        map.put(WkParams.IMEI, "");
        map.put("mac", "");
        map.put("dhid", "");
        map.put(WkParams.UHID, "");
        map.put("netModel", "");
        map.put(WkParams.CAPBSSID, "");
        map.put(WkParams.CAPSSID, "");
        map.put(WkParams.USERTOKEN, "");
        map.put(WkParams.MAPSP, "");
        map.put(WkParams.LONGI, "");
        map.put(WkParams.LATI, "");
        map.put("sn", "");
        map.put("sr", "");
        map.put("androidId", na7.g(context));
        map.put("ts", System.currentTimeMillis() + "");
        return map;
    }

    public HashMap<String, String> d(String str, HashMap<String, String> map) {
        String string = new JSONObject(map).toString();
        map.clear();
        try {
            map.put("appId", this.f17423a);
            map.put("pid", str);
            map.put("ed", zw6.a(string, this.b, this.c));
            map.put("et", "a");
            map.put("st", "m");
            map.put("sign", cx6.b(map, this.d));
            map.put(f.T, "1.0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public void e(String str) {
        if (str != null) {
            this.f17423a = str;
        }
    }

    public void f(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.d = str3;
    }
}
