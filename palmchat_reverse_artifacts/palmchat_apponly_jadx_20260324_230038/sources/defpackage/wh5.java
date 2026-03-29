package defpackage;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.helper.AdHelperH5Ad;
import com.wifi.ad.core.listener.FeedLoadListener;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class wh5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21703a = "";
    public static String b = "";
    public static WeakReference<yt1> i;
    public static WeakReference<yt1> j;
    public static WeakReference<yt1> o;
    public static WeakReference<yt1> s;
    public static c6 c = new c6();
    public static c6 d = new c6();
    public static b e = new b(1);
    public static b f = new b(2);
    public static boolean g = false;
    public static boolean h = false;
    public static Handler k = new Handler(Looper.getMainLooper());
    public static c6 l = new c6();
    public static b m = new b(74);
    public static boolean n = false;
    public static c6 p = new c6();
    public static b q = new b(73);
    public static boolean r = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21706a;
        public String b = UUID.randomUUID().toString();
        public Map<Integer, NestAdData> c = new HashMap();
        public Set<Integer> d = new TreeSet();
        public c6 e;
        public String f;

        public b(int i) {
            this.f21706a = i;
        }

        public void b() {
            if (this.c != null) {
                LogUtil.d("ClearAd", "clearCacheAd SquareAdManager mAds.clear()");
                this.c.clear();
            }
            if (this.d != null) {
                LogUtil.d("ClearAd", "clearCacheAd SquareAdManager mPositions.clear()");
                this.d.clear();
            }
        }

        public boolean c(int i) {
            return this.c.containsKey(Integer.valueOf(i));
        }

        public c6 d() {
            c6 c6Var = this.e;
            if (c6Var != null) {
                return c6Var;
            }
            int i = this.f21706a;
            if (i == 1) {
                this.e = wh5.c;
            } else if (i == 73) {
                this.e = wh5.p;
            } else if (i == 74) {
                this.e = wh5.l;
            } else if (i == 2) {
                this.e = wh5.d;
            } else {
                this.e = new c6();
            }
            return this.e;
        }

        public NestAdData e(int i) {
            return this.c.get(Integer.valueOf(i));
        }

        public String f() {
            String str = this.f;
            if (str != null) {
                return str;
            }
            int i = this.f21706a;
            if (i == 1) {
                this.f = wh5.f21703a;
            } else if (i == 2) {
                this.f = wh5.b;
            } else {
                this.f = "";
            }
            return this.f;
        }

        public void g(int i, NestAdData nestAdData) {
            if (nestAdData == null) {
                return;
            }
            this.c.put(Integer.valueOf(i), nestAdData);
            this.d.add(Integer.valueOf(i));
        }

        public List<int[]> h(int i) {
            LinkedList linkedList = new LinkedList();
            Iterator<Integer> it = this.d.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                int i3 = iIntValue + i2;
                i2++;
                if (i3 > i) {
                    linkedList.add(new int[]{i3, iIntValue});
                }
            }
            return linkedList;
        }

        public int i(int i) {
            Iterator<Integer> it = this.d.iterator();
            int i2 = 0;
            while (it.hasNext() && it.next().intValue() < i) {
                i2++;
            }
            return i + i2;
        }

        public Integer j(int i) {
            Iterator<Integer> it = this.d.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int iIntValue = it.next().intValue() + i2;
                if (iIntValue != i) {
                    if (iIntValue >= i) {
                        break;
                    }
                    i2++;
                } else {
                    return -1;
                }
            }
            return Integer.valueOf(i - i2);
        }
    }

    public static NestAdData A(int i2) {
        return f.e(i2);
    }

    public static NestAdData B(int i2) {
        return q.e(i2);
    }

    public static NestAdData C(int i2) {
        return m.e(i2);
    }

    public static NestAdData D(int i2) {
        return e.e(i2);
    }

    public static void E(String str, String str2) {
        boolean z;
        WifiLog.d("SquareAd 1111 getAdJsonAndConfig ");
        f21703a = "";
        b = "";
        c = new c6();
        d = new c6();
        if (S()) {
            boolean z2 = true;
            if (TextUtils.isEmpty(str)) {
                z = false;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("recommend");
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("friend");
                    if (jSONObjectOptJSONObject != null) {
                        f21703a = jSONObjectOptJSONObject.optString(P(), "");
                    }
                    if (jSONObjectOptJSONObject2 != null) {
                        b = jSONObjectOptJSONObject2.optString(P(), "");
                    }
                    z = true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    z = false;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                z2 = false;
            } else {
                try {
                    y(new JSONObject(str2));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    z2 = false;
                }
            }
            if (z && z2) {
                fn1.b();
            }
        }
    }

    public static c6 F() {
        return f.d();
    }

    public static c6 G() {
        return q.d();
    }

    public static c6 H() {
        return m.d();
    }

    public static c6 I() {
        return e.d();
    }

    public static String J() {
        return f.b;
    }

    public static String K() {
        return q.b;
    }

    public static String L() {
        return m.b;
    }

    public static String M() {
        return e.b;
    }

    public static String N() {
        return jo6.c("LX-43408", WkAdxAdConfigMg.DSP_NAME_BAIDU);
    }

    public static String O() {
        return jo6.c("LX-44460", WkAdxAdConfigMg.DSP_NAME_BAIDU);
    }

    public static String P() {
        String strC = jo6.c("LX-35416", WkAdxAdConfigMg.DSP_NAME_CSJ);
        WifiLog.d("SquareAd getBannerTaiValue result " + strC);
        return strC;
    }

    public static boolean Q() {
        return !"A".equalsIgnoreCase(N());
    }

    public static boolean R() {
        return !"A".equalsIgnoreCase(O());
    }

    public static boolean S() {
        return !"A".equalsIgnoreCase(P());
    }

    public static void T(int i2, NestAdData nestAdData, int i3, b bVar) {
        b bVar2;
        yt1 yt1Var = null;
        if (i3 == 1) {
            bVar2 = e;
            WeakReference<yt1> weakReference = i;
            if (weakReference != null) {
                yt1Var = weakReference.get();
            }
        } else if (i3 == 73) {
            bVar2 = q;
            WeakReference<yt1> weakReference2 = s;
            if (weakReference2 != null) {
                yt1Var = weakReference2.get();
            }
        } else if (i3 == 74) {
            bVar2 = m;
            WeakReference<yt1> weakReference3 = o;
            if (weakReference3 != null) {
                yt1Var = weakReference3.get();
            }
        } else {
            bVar2 = f;
            WeakReference<yt1> weakReference4 = j;
            if (weakReference4 != null) {
                yt1Var = weakReference4.get();
            }
        }
        if (bVar != bVar2) {
            return;
        }
        bVar2.g(i2, nestAdData);
        if (yt1Var != null) {
            int i4 = bVar2.i(i2);
            List<SquareFeed> listE = yt1Var.e();
            int size = listE.size();
            if (size > 0) {
                int i5 = size - 1;
                if (!TextUtils.isEmpty(listE.get(i5).bottomTips)) {
                    size = i5;
                }
            }
            if (i4 < 0 || i4 > size) {
                return;
            }
            SquareFeed squareFeed = new SquareFeed();
            squareFeed.adKey = Integer.valueOf(i2);
            LogUtil.d("SquareNewFriend", "showAd insertItem from " + i3 + " adPosition " + i2 + " adFeed.adKey " + squareFeed.adKey);
            yt1Var.M(i4, squareFeed);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void U(Activity activity, int i2, int i3, int i4) {
        b bVar;
        String str;
        String str2;
        String str3;
        int i5;
        if (i4 == 1) {
            bVar = e;
        } else if (i4 == 73) {
            bVar = q;
        } else if (i4 == 74) {
            bVar = m;
            LogUtil.d("SquareNewFriend", "request tryRequest adCache " + bVar);
        } else {
            bVar = f;
        }
        c6 c6VarD = bVar.d();
        String strF = bVar.f();
        if (i2 != 3) {
            WifiLog.d("SquareNewFriend SquareAd 3333 tryRequest config " + c6VarD);
            WifiLog.d("SquareNewFriend SquareAd 3333 tryRequest strategyJson " + strF);
        } else {
            WifiLog.d("SquareAd 3333 tryRequest listPosition " + i3);
            if (i3 < 0) {
                return;
            }
        }
        int i6 = 42;
        if (i4 != 1) {
            if (i4 == 73) {
                i6 = 78;
            } else if (i4 == 2) {
                i6 = 43;
            } else if (i4 == 74) {
                i6 = 83;
            }
        }
        int i7 = 0;
        if (!l6.f(i6)) {
            ma3.a("[SquareAdManager-tryRequest] ad config has not opened.", new Object[0]);
            return;
        }
        if (i4 == 73) {
            if (!Q()) {
                return;
            }
        } else if (i4 == 74) {
            if (!R()) {
                return;
            }
        } else if (!S()) {
            return;
        }
        if (i4 == 1) {
            if (g) {
                return;
            }
        } else if (i4 == 2) {
            if (h) {
                return;
            }
        } else if (i4 == 73) {
            if (r) {
                return;
            }
        } else if (i4 == 74 && n) {
            return;
        }
        int i8 = -1;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    int iIntValue = bVar.j(i3).intValue();
                    if (iIntValue < 0) {
                        return;
                    }
                    int i9 = c6VarD.b;
                    int i10 = (i9 - c6VarD.e) - 1;
                    if (i10 < 0) {
                        i10 = 0;
                    }
                    if (iIntValue != i10 || bVar.c(i9)) {
                        int i11 = c6VarD.c;
                        if (i11 == 0) {
                            return;
                        }
                        int i12 = iIntValue + 1 + c6VarD.e;
                        int i13 = c6VarD.b;
                        int i14 = i12 - i13;
                        if (i14 % i11 != 0 || (i5 = i14 / i11) <= 0 || i5 + 1 > c6VarD.f1897a) {
                            return;
                        } else {
                            i8 = i13 + (i11 * i5);
                        }
                    } else {
                        i8 = c6VarD.b;
                    }
                }
            } else if (c6VarD.d != 0) {
                return;
            } else {
                i8 = c6VarD.b;
            }
        } else if (c6VarD.d != -1) {
            return;
        } else {
            i8 = c6VarD.b;
        }
        LogUtil.d("SquareNewFriend", "request tryRequest curAdPosition " + i8);
        if (bVar.c(i8)) {
            return;
        }
        String adRequestId = AdHelperH5Ad.INSTANCE.getAdRequestId();
        String str4 = "";
        if (i4 == 1) {
            g = true;
            i7 = 1;
            str2 = "";
            fn1.e(adRequestId, i8 == c6VarD.b ? 1 : 2, M(), 1, "LX-35416", P());
            str4 = "c82bl2j8mea8vor3q2og";
        } else if (i4 == 2) {
            h = true;
            i7 = 2;
            str2 = "";
            fn1.e(adRequestId, i8 == c6VarD.b ? 1 : 2, J(), 2, "LX-35416", P());
            str4 = "c82blaach5ldsiae00p0";
        } else {
            if (i4 != 73) {
                if (i4 == 74) {
                    n = true;
                    i7 = 74;
                    str = "";
                    fn1.e(adRequestId, i8 == c6VarD.b ? 1 : 2, L(), 74, "LX-44460", O());
                    StringBuilder sb = new StringBuilder();
                    sb.append("request Ad scene ");
                    sb.append(i6);
                    sb.append(" adUnitId ");
                    str4 = "chm7bcqch5ldk2o88bvg";
                    sb.append("chm7bcqch5ldk2o88bvg");
                    LogUtil.d("SquareNewFriend", sb.toString());
                } else {
                    str = "";
                }
                String strP = P();
                if (i4 != 73) {
                    strP = N();
                    str3 = "LX-43408";
                } else if (i4 == 74) {
                    strP = O();
                    str3 = "LX-44460";
                } else {
                    str3 = "LX-35416";
                }
                HashMap map = new HashMap();
                map.put("requestId", adRequestId);
                map.put("taiChiKey", str3);
                map.put("exp_group", strP);
                map.put("pageType", i7 + str);
                map.put("scene", i6 + str);
                AdHelperFeed adHelperFeedCreateAdFeed = WifiNestAd.INSTANCE.createAdFeed();
                LogUtil.d("SquareNearBy", "request Ad scene " + i6 + " adUnitId " + str4);
                adHelperFeedCreateAdFeed.getNativeFeedAd(activity, new AdParams.Builder().setExt(map).setScene(i6).setAdUnitId(str4).setFullStrategyJson(strF).build(), new a(i4, adRequestId, i8, bVar));
            }
            r = true;
            i7 = 73;
            str2 = "";
            fn1.e(adRequestId, i8 == c6VarD.b ? 1 : 2, K(), 73, "LX-43408", N());
            str4 = "cfmtlr38meaduok7ncpg";
        }
        str = str2;
        String strP2 = P();
        if (i4 != 73) {
        }
        HashMap map2 = new HashMap();
        map2.put("requestId", adRequestId);
        map2.put("taiChiKey", str3);
        map2.put("exp_group", strP2);
        map2.put("pageType", i7 + str);
        map2.put("scene", i6 + str);
        AdHelperFeed adHelperFeedCreateAdFeed2 = WifiNestAd.INSTANCE.createAdFeed();
        LogUtil.d("SquareNearBy", "request Ad scene " + i6 + " adUnitId " + str4);
        adHelperFeedCreateAdFeed2.getNativeFeedAd(activity, new AdParams.Builder().setExt(map2).setScene(i6).setAdUnitId(str4).setFullStrategyJson(strF).build(), new a(i4, adRequestId, i8, bVar));
    }

    public static void V(Activity activity, int i2, int i3) {
        U(activity, i2, i3, 2);
    }

    public static void W(Activity activity, int i2, int i3) {
        LogUtil.d("SquareNearBy", "tryRequestForNearBy requestSource " + i2 + " globalPosition " + i3);
        U(activity, i2, i3, 73);
    }

    public static void X(Activity activity, int i2, int i3) {
        LogUtil.d("SquareNewFriend", "tryRequestForNewFriend requestSource " + i2 + " globalPosition " + i3);
        U(activity, i2, i3, 74);
    }

    public static void Y(Activity activity, int i2, int i3) {
        U(activity, i2, i3, 1);
    }

    public static void Z(String str) {
        WifiLog.d("SquareAd  updateAdConfig ");
        c = new c6();
        d = new c6();
        if (!S() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            y(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void a0(String str) {
        WifiLog.d("SquareAd  updateAdJson ");
        f21703a = "";
        b = "";
        if (!S() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("recommend");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("friend");
            if (jSONObjectOptJSONObject != null) {
                f21703a = jSONObjectOptJSONObject.optString(P(), "");
            }
            if (jSONObjectOptJSONObject2 != null) {
                b = jSONObjectOptJSONObject2.optString(P(), "");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void b0(String str) {
        LogUtil.d("SquareNearBy", "updateNearByAdConfig extra " + str);
        p = new c6();
        if (!Q() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            p = z(new JSONObject(str).optJSONObject("nearby"), N());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void c0(String str) {
        LogUtil.d("SquareNewFriend", "updateNewFriendAdConfig extra " + str);
        l = new c6();
        if (!R() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            l = z(new JSONObject(str).optJSONObject("newFriend"), O());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void m(int i2) {
        WeakReference<yt1> weakReference = j;
        yt1 yt1Var = weakReference == null ? null : weakReference.get();
        if (yt1Var != null) {
            for (int[] iArr : f.h(i2)) {
                if (iArr[0] >= 0) {
                    if (iArr[0] > yt1Var.e().size()) {
                        return;
                    }
                    SquareFeed squareFeed = new SquareFeed();
                    squareFeed.adKey = Integer.valueOf(iArr[1]);
                    yt1Var.M(iArr[0], squareFeed);
                }
            }
        }
    }

    public static void n(int i2) {
        WeakReference<yt1> weakReference = s;
        yt1 yt1Var = weakReference == null ? null : weakReference.get();
        LogUtil.d("SquareNearBy", "appendAdForNearBy beginGlobalPosition " + i2 + " model " + yt1Var);
        if (yt1Var != null) {
            for (int[] iArr : q.h(i2)) {
                if (iArr[0] >= 0) {
                    if (iArr[0] > yt1Var.e().size()) {
                        return;
                    }
                    SquareFeed squareFeed = new SquareFeed();
                    squareFeed.adKey = Integer.valueOf(iArr[1]);
                    yt1Var.M(iArr[0], squareFeed);
                }
            }
        }
    }

    public static void o(int i2) {
        WeakReference<yt1> weakReference = o;
        yt1 yt1Var = weakReference == null ? null : weakReference.get();
        LogUtil.d("SquareNewFriend", "appendAdForNewFriend beginGlobalPosition " + i2 + " model " + yt1Var);
        if (yt1Var != null) {
            for (int[] iArr : m.h(i2)) {
                if (iArr[0] >= 0) {
                    if (iArr[0] > yt1Var.e().size()) {
                        return;
                    }
                    SquareFeed squareFeed = new SquareFeed();
                    squareFeed.adKey = Integer.valueOf(iArr[1]);
                    yt1Var.M(iArr[0], squareFeed);
                }
            }
        }
    }

    public static void p(int i2) {
        WeakReference<yt1> weakReference = i;
        yt1 yt1Var = weakReference == null ? null : weakReference.get();
        if (yt1Var != null) {
            for (int[] iArr : e.h(i2)) {
                if (iArr[0] >= 0) {
                    if (iArr[0] > yt1Var.e().size()) {
                        return;
                    }
                    SquareFeed squareFeed = new SquareFeed();
                    squareFeed.adKey = Integer.valueOf(iArr[1]);
                    yt1Var.M(iArr[0], squareFeed);
                }
            }
        }
    }

    public static void q(yt1 yt1Var) {
        if (yt1Var == null) {
            s = null;
        } else {
            s = new WeakReference<>(yt1Var);
        }
        LogUtil.d("SquareNearBy", "bindModelForNearBy sNearByModel " + s);
    }

    public static void r(yt1 yt1Var) {
        if (yt1Var == null) {
            o = null;
        } else {
            o = new WeakReference<>(yt1Var);
        }
        LogUtil.d("SquareNewFriend", "bindModelForNewFriend sNewFriendModel " + o);
    }

    public static void s(yt1 yt1Var) {
        if (yt1Var == null) {
            i = null;
        } else {
            i = new WeakReference<>(yt1Var);
        }
    }

    public static void t() {
        if (!b6.d()) {
            if (b6.t || b6.f1653a) {
                LogUtil.d("ClearAd", "clearCacheAd SquareAdManager clearAllAd ");
                b bVar = e;
                if (bVar != null) {
                    bVar.b();
                }
                SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
                sPCacheManager.clearCacheAd(42);
                b bVar2 = f;
                if (bVar2 != null) {
                    bVar2.b();
                }
                sPCacheManager.clearCacheAd(43);
                return;
            }
            return;
        }
        if (b6.t) {
            LogUtil.d("ClearAd", "clearCacheAd SquareAdManager clearAllAd ");
            b bVar3 = e;
            if (bVar3 != null) {
                bVar3.b();
            }
            SPCacheManager sPCacheManager2 = SPCacheManager.INSTANCE;
            sPCacheManager2.clearCacheAd(42);
            b bVar4 = f;
            if (bVar4 != null) {
                bVar4.b();
            }
            sPCacheManager2.clearCacheAd(43);
            b bVar5 = q;
            if (bVar5 != null) {
                bVar5.b();
            }
            sPCacheManager2.clearCacheAd(78);
            b bVar6 = m;
            if (bVar6 != null) {
                bVar6.b();
            }
            sPCacheManager2.clearCacheAd(83);
        }
    }

    public static void u() {
        f = new b(2);
    }

    public static void v() {
        LogUtil.d("SquareNearBy", "clearForNearBy");
        q = new b(73);
    }

    public static void w() {
        LogUtil.d("SquareNewFriend", "clearForNewFriend");
        m = new b(74);
    }

    public static void x() {
        e = new b(1);
    }

    public static void y(JSONObject jSONObject) {
        WifiLog.d("SquareAd 2222 createConfigModel ");
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("recommend");
                WifiLog.d("SquareAd createConfigModel recommend " + jSONObjectOptJSONObject);
                if (jSONObjectOptJSONObject != null) {
                    c = z(jSONObjectOptJSONObject, P());
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("friend");
                WifiLog.d("SquareAd createConfigModel friend " + jSONObjectOptJSONObject2);
                if (jSONObjectOptJSONObject2 != null) {
                    d = z(jSONObjectOptJSONObject2, P());
                }
            } catch (Exception e2) {
                WifiLog.d("SquareAd createConfigModel e " + e2.toString());
            }
        }
    }

    public static c6 z(JSONObject jSONObject, String str) {
        c6 c6Var = new c6();
        if (jSONObject == null) {
            return c6Var;
        }
        WifiLog.d("SquareAd createConfigModel configKey " + str);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return c6Var;
        }
        int iOptInt = jSONObjectOptJSONObject.optInt("limit", c6Var.f1897a);
        if (iOptInt <= 0) {
            iOptInt = c6Var.f1897a;
        }
        c6Var.f1897a = iOptInt;
        int iOptInt2 = jSONObjectOptJSONObject.optInt("firstAd", c6Var.b);
        if (iOptInt2 < 0) {
            iOptInt2 = c6Var.b;
        }
        c6Var.b = iOptInt2;
        int iOptInt3 = jSONObjectOptJSONObject.optInt("gapLength", c6Var.c);
        if (iOptInt3 <= 0) {
            iOptInt3 = c6Var.c;
        }
        c6Var.c = iOptInt3;
        c6Var.d = jSONObjectOptJSONObject.optInt("firstAdRequestTime", c6Var.d);
        int iOptInt4 = jSONObjectOptJSONObject.optInt("adRequestTime", c6Var.e);
        if (iOptInt4 < 0) {
            iOptInt4 = c6Var.e;
        }
        c6Var.e = iOptInt4;
        c6Var.f = jSONObjectOptJSONObject.optString(WfConstant.EVENT_KEY_APP_NAME, c6Var.f);
        c6Var.g = jSONObjectOptJSONObject.optString("adTitle", c6Var.g);
        c6Var.h = jSONObjectOptJSONObject.optString("inFor", c6Var.h);
        int iOptInt5 = jSONObjectOptJSONObject.optInt("min1", c6Var.i);
        if (iOptInt5 <= 0) {
            iOptInt5 = c6Var.i;
        }
        c6Var.i = iOptInt5;
        int iOptInt6 = jSONObjectOptJSONObject.optInt("max1", c6Var.j);
        if (iOptInt6 <= 0) {
            iOptInt6 = c6Var.j;
        }
        c6Var.j = iOptInt6;
        int iOptInt7 = jSONObjectOptJSONObject.optInt("min2", c6Var.k);
        if (iOptInt7 <= 0) {
            iOptInt7 = c6Var.k;
        }
        c6Var.k = iOptInt7;
        int iOptInt8 = jSONObjectOptJSONObject.optInt("max2", c6Var.l);
        if (iOptInt8 <= 0) {
            iOptInt8 = c6Var.l;
        }
        c6Var.l = iOptInt8;
        String strOptString = jSONObjectOptJSONObject.optString("buttonColor");
        if (!TextUtils.isEmpty(strOptString)) {
            try {
                c6Var.m = Color.parseColor(strOptString);
            } catch (Exception unused) {
            }
        }
        String strOptString2 = jSONObjectOptJSONObject.optString("borderColor");
        if (!TextUtils.isEmpty(strOptString2)) {
            try {
                c6Var.n = Color.parseColor(strOptString2);
            } catch (Exception unused2) {
            }
        }
        String strOptString3 = jSONObjectOptJSONObject.optString("textColor");
        if (!TextUtils.isEmpty(strOptString3)) {
            try {
                c6Var.o = Color.parseColor(strOptString3);
            } catch (Exception unused3) {
            }
        }
        return c6Var;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21704a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ b d;

        /* JADX INFO: renamed from: wh5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1284a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f21705a;

            public RunnableC1284a(List list) {
                this.f21705a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                NestAdData nestAdData;
                int i = a.this.f21704a;
                if (i == 1) {
                    boolean unused = wh5.g = false;
                } else if (i == 2) {
                    boolean unused2 = wh5.h = false;
                } else if (i == 73) {
                    boolean unused3 = wh5.r = false;
                } else if (i == 74) {
                    boolean unused4 = wh5.n = false;
                }
                List list = this.f21705a;
                if (list == null || list.size() <= 0 || (nestAdData = (NestAdData) this.f21705a.get(0)) == null) {
                    return;
                }
                a aVar = a.this;
                int i2 = aVar.f21704a;
                if (i2 == 1) {
                    fn1.c(aVar.b, nestAdData, wh5.M(), 1, "LX-35416", wh5.P());
                } else if (i2 == 2) {
                    fn1.c(aVar.b, nestAdData, wh5.J(), 2, "LX-35416", wh5.P());
                } else if (i2 == 73) {
                    fn1.c(aVar.b, nestAdData, wh5.K(), 73, "LX-43408", wh5.N());
                } else if (i2 == 74) {
                    fn1.c(aVar.b, nestAdData, wh5.L(), 74, "LX-44460", wh5.O());
                }
                a aVar2 = a.this;
                wh5.T(aVar2.c, nestAdData, aVar2.f21704a, aVar2.d);
            }
        }

        public a(int i, String str, int i2, b bVar) {
            this.f21704a = i;
            this.b = str;
            this.c = i2;
            this.d = bVar;
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            LogUtil.d("SquareNearBy", "request onAdFailed s " + str + " s1 " + str2);
            int i = this.f21704a;
            if (i == 1) {
                boolean unused = wh5.g = false;
                fn1.d(str, str2, wh5.M(), 1);
                return;
            }
            if (i == 2) {
                boolean unused2 = wh5.h = false;
                fn1.d(str, str2, wh5.J(), 2);
            } else if (i == 73) {
                boolean unused3 = wh5.r = false;
                fn1.d(str, str2, wh5.K(), 73);
            } else if (i == 74) {
                boolean unused4 = wh5.n = false;
                fn1.d(str, str2, wh5.L(), 74);
            }
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            LogUtil.d("SquareNearBy", "request onAdLoaded from " + this.f21704a);
            wh5.k.post(new RunnableC1284a(list));
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }
}
