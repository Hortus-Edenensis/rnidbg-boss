package defpackage;

import android.graphics.Point;
import android.text.TextUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.find.bean.conf.FindMapActiveConf;
import com.zenmen.openapi.config.LxApiProxy;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$string;
import com.zenmen.square.bean.UserrecommendTabs230414Config;
import com.zenmen.square.fragment.FriendFeedsFragment;
import com.zenmen.square.fragment.MapFindNearByFragment;
import com.zenmen.square.fragment.NearByFeedsFragment;
import com.zenmen.square.fragment.NearByFragment;
import com.zenmen.square.fragment.RecommendFeedsFragment;
import com.zenmen.square.fragment.RecommendNearByFragment;
import com.zenmen.square.fragment.online.OnlineRecommend;
import com.zenmen.square.util.conf.MapFinderConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class gi5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f17735a = -1;
    public static long b = -1;
    public static MapFinderConfig c = null;
    public static long d = -1;
    public static List<qs5> e = new ArrayList();
    public static Map<String, Class> f;
    public static Map<String, Class> g;

    static {
        qs5 qs5Var = new qs5();
        qs5Var.b = "动态";
        qs5Var.c = RecommendFeedsFragment.class.getName();
        qs5Var.f20313a = 1;
        qs5Var.d = "recommendTitle";
        e.add(qs5Var);
        qs5 qs5Var2 = new qs5();
        qs5Var2.b = "附近";
        qs5Var2.e = "同城";
        qs5Var2.c = NearByFeedsFragment.class.getName();
        qs5Var2.f20313a = 2;
        qs5Var2.d = "nearbyFeedTitle";
        e.add(qs5Var2);
        qs5 qs5Var3 = new qs5();
        qs5Var3.b = "好友";
        qs5Var3.c = FriendFeedsFragment.class.getName();
        qs5Var3.f20313a = 3;
        qs5Var3.d = "friendFeedTitle";
        e.add(qs5Var3);
        HashMap map = new HashMap();
        f = map;
        map.put("recommendTitle", RecommendFeedsFragment.class);
        f.put("nearbyFeedTitle", NearByFeedsFragment.class);
        f.put("friendFeedTitle", FriendFeedsFragment.class);
        HashMap map2 = new HashMap();
        g = map2;
        map2.put("userrecommend", RecommendNearByFragment.class);
        g.put("nearbyrecommend", NearByFragment.class);
        g.put("onlinerecommend", OnlineRecommend.class);
        g.put("mapfinder", MapFindNearByFragment.class);
    }

    public static qs5 a(String str) {
        for (qs5 qs5Var : r()) {
            String str2 = qs5Var.d;
            if (str2 != null && str2.equals(str)) {
                return qs5Var;
            }
        }
        return null;
    }

    public static rs5 b() {
        JSONObject config = vs0.a().getConfig("1v1RecommendList_NewLabel");
        if (config == null || config.length() <= 0) {
            return null;
        }
        rs5 rs5Var = new rs5();
        rs5Var.f20561a = config.optBoolean("enable");
        rs5Var.b = config.optString("Show_BeginTime");
        rs5Var.c = config.optString("Show_EndTime");
        return rs5Var;
    }

    public static FindMapActiveConf c() {
        JSONObject config = vs0.a().getConfig("mapfinder_lowerright_Adbutton_v2");
        LogUtil.d("MapPendantManager", "getFindMapActiveConf configObj " + config);
        FindMapActiveConf findMapActiveConf = config != null ? (FindMapActiveConf) az2.a(config.toString(), FindMapActiveConf.class) : null;
        return findMapActiveConf == null ? new FindMapActiveConf() : findMapActiveConf;
    }

    public static Point d() {
        Point point = new Point(3, 3);
        JSONObject config = vs0.a().getConfig("mapFinderConfig");
        if (config != null) {
            point.y = config.optInt("row", 3);
            point.x = config.optInt("column", 3);
        }
        return point;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<qs5> e() {
        JSONObject jSONObject;
        String str;
        String str2;
        Iterator<String> it;
        int i;
        ArrayList arrayList = new ArrayList();
        JSONObject config = vs0.a().getConfig("userrecommend_tabs_230414");
        ArrayList arrayList2 = new ArrayList(f());
        HashMap map = new HashMap(g);
        String strQ = bj5.b().a().Q("LX-70594");
        String str3 = "";
        LogUtil.d("", "onlineTT value70594 " + strQ);
        if (!WkAdxAdConfigMg.DSP_NAME_BAIDU.equals(strQ)) {
            map.remove("onlinerecommend");
        }
        String strQ2 = bj5.b().a().Q("LX-74314");
        UserrecommendTabs230414Config userrecommendTabs230414Config = UserrecommendTabs230414Config.getUserrecommendTabs230414Config();
        if ("A".equals(strQ2) || !userrecommendTabs230414Config.mapfinder.show_Switch) {
            map.remove("mapfinder");
        }
        if (config == null || config.length() <= 0) {
            return arrayList2;
        }
        if (config.length() > 0) {
            Iterator<String> itKeys = config.keys();
            String str4 = "地图找人";
            boolean z = false;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                LogUtil.d(str3, "onlineTT key " + next);
                if (map.containsKey(next)) {
                    Class cls = (Class) map.get(next);
                    JSONObject jSONObjectOptJSONObject = config.optJSONObject(next);
                    if (cls == null || jSONObjectOptJSONObject == null) {
                        jSONObject = config;
                        str = str3;
                        str2 = strQ2;
                        it = itKeys;
                    } else {
                        jSONObject = config;
                        try {
                            i = jSONObjectOptJSONObject.getInt("order");
                            str = str3;
                        } catch (Exception e2) {
                            e = e2;
                            str = str3;
                        }
                        try {
                            String string = jSONObjectOptJSONObject.getString("name");
                            it = itKeys;
                            try {
                                qs5 qs5Var = new qs5();
                                qs5Var.b = string;
                                qs5Var.c = cls.getName();
                                qs5Var.f20313a = i;
                                if ("A".equals(strQ2) || !userrecommendTabs230414Config.mapfinder.show_Switch) {
                                    str2 = strQ2;
                                    qs5Var.e = jSONObjectOptJSONObject.optString("redText", next.equals("nearbyrecommend") ? "找人中" : "New");
                                } else {
                                    str2 = strQ2;
                                }
                                if (next.equals("nearbyrecommend")) {
                                    try {
                                        qs5Var.f = R$drawable.bg_text_dot_green;
                                    } catch (Exception e3) {
                                        e = e3;
                                        e.printStackTrace();
                                    }
                                }
                                if (next.equals("onlinerecommend")) {
                                    qs5Var.g = true;
                                } else {
                                    qs5Var.g = jSONObjectOptJSONObject.optBoolean("hideFilter", false);
                                }
                                qs5Var.d = next;
                                if (!LxApiProxy.getInstance().getConfigApi().b() && TextUtils.equals("推荐", string)) {
                                    qs5Var.b = "精选";
                                }
                                if (next.equals("mapfinder") && !TextUtils.isEmpty(string)) {
                                    str4 = string;
                                    z = true;
                                }
                                arrayList.add(qs5Var);
                            } catch (Exception e4) {
                                e = e4;
                                str2 = strQ2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            str2 = strQ2;
                            it = itKeys;
                            e.printStackTrace();
                            config = jSONObject;
                            str3 = str;
                            itKeys = it;
                            strQ2 = str2;
                        }
                    }
                }
                config = jSONObject;
                str3 = str;
                itKeys = it;
                strQ2 = str2;
            }
            if (!z && map.containsKey("mapfinder")) {
                qs5 qs5Var2 = new qs5();
                qs5Var2.b = str4;
                qs5Var2.c = ((Class) map.get("mapfinder")).getName();
                qs5Var2.f20313a = 6;
                qs5Var2.g = false;
                qs5Var2.d = "mapfinder";
                arrayList.add(qs5Var2);
            }
            Collections.sort(arrayList);
        }
        return arrayList.size() == 0 ? arrayList2 : arrayList;
    }

    public static List<qs5> f() {
        ArrayList arrayList = new ArrayList();
        qs5 qs5Var = new qs5();
        qs5Var.b = LxApiProxy.getInstance().getConfigApi().b() ? "推荐" : "精选";
        qs5Var.c = RecommendNearByFragment.class.getName();
        qs5Var.f20313a = 1;
        qs5Var.d = "userrecommend";
        arrayList.add(qs5Var);
        qs5 qs5Var2 = new qs5();
        qs5Var2.b = "附近的人";
        qs5Var2.c = NearByFragment.class.getName();
        qs5Var2.f20313a = 2;
        qs5Var2.d = "nearbyrecommend";
        arrayList.add(qs5Var2);
        qs5 qs5Var3 = new qs5();
        qs5Var3.b = "活跃大厅";
        qs5Var3.c = OnlineRecommend.class.getName();
        qs5Var3.f20313a = 3;
        qs5Var3.g = true;
        qs5Var3.d = "onlinerecommend";
        arrayList.add(qs5Var3);
        String strQ = bj5.b().a().Q("LX-74314");
        UserrecommendTabs230414Config userrecommendTabs230414Config = UserrecommendTabs230414Config.getUserrecommendTabs230414Config();
        if (!"A".equals(strQ) && userrecommendTabs230414Config.mapfinder.show_Switch) {
            qs5 qs5Var4 = new qs5();
            qs5Var4.b = "地图找人";
            qs5Var4.c = MapFindNearByFragment.class.getName();
            qs5Var4.f20313a = 4;
            qs5Var4.d = "mapfinder";
            arrayList.add(qs5Var4);
        }
        return arrayList;
    }

    public static MapFinderConfig g() {
        if (c == null) {
            c = h();
        }
        return c;
    }

    public static MapFinderConfig h() {
        JSONObject config = vs0.a().getConfig("mapFinderConfig");
        return config != null ? (MapFinderConfig) az2.a(config.toString(), MapFinderConfig.class) : MapFinderConfig.getDefaultConfig();
    }

    public static int i() {
        JSONObject config = vs0.a().getConfig("mapFinderConfig");
        if (config == null) {
            return 16;
        }
        try {
            JSONObject jSONObjectOptJSONObject = config.optJSONObject("android_defaultscaling");
            if (jSONObjectOptJSONObject != null) {
                return ap3.h() ? jSONObjectOptJSONObject.optInt("baidu_ratio", 16) : jSONObjectOptJSONObject.optInt("ratio", 16);
            }
            return 16;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 16;
        }
    }

    public static String j() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject config = vs0.a().getConfig("squareTabsNew");
        return (config == null || (jSONObjectOptJSONObject = config.optJSONObject("momentsTitle")) == null || TextUtils.isEmpty(jSONObjectOptJSONObject.optString("name"))) ? "好友分享" : jSONObjectOptJSONObject.optString("name");
    }

    public static int k() {
        JSONObject config = vs0.a().getConfig("likeHintInfo");
        if (config != null) {
            return config.optInt("indexOfLikeHint", 3);
        }
        return 3;
    }

    public static String l() {
        JSONObject config = vs0.a().getConfig("likeHintInfo");
        return config != null ? config.optString("textOfLikeHint", "点赞更容易获得对方回复哦～") : "点赞更容易获得对方回复哦～";
    }

    public static long m() {
        if (d < 0) {
            d = vs0.a().d("postdetail_greethint", 3L) * 1000;
        }
        return d;
    }

    public static i25 n() {
        i25 i25Var;
        try {
            i25Var = new i25(vs0.a().getConfig("postfeed_live_greethint").toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            i25Var = null;
        }
        return i25Var == null ? new i25() : i25Var;
    }

    public static int o() {
        return vs0.a().a("publish_default", 1);
    }

    public static String p(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject config = vs0.a().getConfig("pagenewslist");
        if (config == null || (jSONObjectOptJSONObject = config.optJSONObject(str)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("name");
    }

    public static String q(String str, String str2) {
        String strB = vs0.a().b(str);
        return TextUtils.isEmpty(strB) ? str2 : strB;
    }

    public static List<qs5> r() {
        ArrayList arrayList = new ArrayList();
        JSONObject config = vs0.a().getConfig("squareTabsNew");
        ArrayList arrayList2 = new ArrayList(e);
        HashMap map = new HashMap(f);
        if (config == null || config.length() <= 0) {
            return arrayList2;
        }
        if (config.length() > 0) {
            Iterator<String> itKeys = config.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Class cls = (Class) map.get(next);
                JSONObject jSONObjectOptJSONObject = config.optJSONObject(next);
                if (cls != null && jSONObjectOptJSONObject != null) {
                    try {
                        int i = jSONObjectOptJSONObject.getInt("order");
                        String string = jSONObjectOptJSONObject.getString("name");
                        qs5 qs5Var = new qs5();
                        qs5Var.b = string;
                        qs5Var.e = jSONObjectOptJSONObject.optString("redText", c.b().getString(R$string.same_city));
                        qs5Var.c = cls.getName();
                        qs5Var.f20313a = i;
                        qs5Var.d = next;
                        qs5Var.h = jSONObjectOptJSONObject.optInt("hint", 0);
                        qs5Var.i = jSONObjectOptJSONObject.optInt("hintfre", 24);
                        arrayList.add(qs5Var);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            Collections.sort(arrayList);
        }
        return arrayList.size() == 0 ? arrayList2 : arrayList;
    }

    public static boolean s() {
        return vs0.a().e("comment_ip", false);
    }

    public static boolean t(String str) {
        return a(str) != null;
    }

    public static boolean u() {
        JSONObject config = vs0.a().getConfig("likeHintInfo");
        return (config != null ? config.optInt("likeHintInfoShow", 1) : 1) == 1;
    }
}
