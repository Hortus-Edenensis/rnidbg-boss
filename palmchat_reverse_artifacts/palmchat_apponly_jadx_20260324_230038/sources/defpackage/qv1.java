package defpackage;

import android.app.Activity;
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
import com.zenmen.square.mvp.model.bean.NearByBean;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class qv1 {
    public static final AtomicBoolean h = new AtomicBoolean(false);
    public static String i = "LX-45251";
    public WeakReference<gu3> f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20327a = false;
    public String b = "";
    public sv1 c = new sv1();
    public b d = new b();
    public boolean e = false;
    public Handler g = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f20330a = UUID.randomUUID().toString();
        public Map<Integer, NestAdData> b = new HashMap();
        public Set<Integer> c = new TreeSet();
        public sv1 d;
        public String e;

        public b() {
        }

        public void b() {
            if (b6.d()) {
                Map<Integer, NestAdData> map = this.b;
                if (map != null && map.size() > 0) {
                    LogUtil.d("ClearAd", "clearCacheAd FindAdManager mAds.clear()");
                    this.b.clear();
                }
                if (this.c != null) {
                    LogUtil.d("ClearAd", "clearCacheAd FindAdManager mPositions.clear()");
                    this.c.clear();
                }
            }
        }

        public boolean c(int i) {
            return this.b.containsKey(Integer.valueOf(i));
        }

        public sv1 d() {
            sv1 sv1Var = this.d;
            if (sv1Var != null) {
                return sv1Var;
            }
            sv1 sv1Var2 = qv1.this.c;
            this.d = sv1Var2;
            return sv1Var2;
        }

        public NestAdData e(int i) {
            return this.b.get(Integer.valueOf(i));
        }

        public String f() {
            String str = this.e;
            if (str != null) {
                return str;
            }
            String str2 = qv1.this.b;
            this.e = str2;
            return str2;
        }

        public void g(int i, NestAdData nestAdData) {
            if (nestAdData == null) {
                return;
            }
            this.b.put(Integer.valueOf(i), nestAdData);
            this.c.add(Integer.valueOf(i));
        }

        public List<int[]> h(int i) {
            LinkedList linkedList = new LinkedList();
            Iterator<Integer> it = this.c.iterator();
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
            Iterator<Integer> it = this.c.iterator();
            int i2 = 0;
            while (it.hasNext() && it.next().intValue() < i) {
                i2++;
            }
            return i + i2;
        }

        public Integer j(int i) {
            Iterator<Integer> it = this.c.iterator();
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

        public void k(int i) {
            this.c.remove(Integer.valueOf(i));
        }
    }

    public static void i() {
        if (b6.d()) {
            if (b6.b || b6.f1653a) {
                LogUtil.d("ClearAd", "clearCacheAd mFindAd clearAllAd ");
                if (zt4.y().d != null) {
                    zt4.y().d.b();
                }
                SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
                sPCacheManager.clearCacheAd(56);
                if (du3.y().d != null) {
                    du3.y().d.b();
                }
                sPCacheManager.clearCacheAd(57);
            }
        }
    }

    public static boolean r() {
        String strC = jo6.c(i, "A");
        LogUtil.d("LXAdRequestInitManager", "isAllowFindRequestAd res:" + strC);
        return !"A".equals(strC);
    }

    public void f(int i2) {
        WeakReference<gu3> weakReference = this.f;
        gu3 gu3Var = weakReference == null ? null : weakReference.get();
        if (gu3Var != null) {
            for (int[] iArr : this.d.h(i2)) {
                if (iArr[0] >= 0) {
                    if (iArr[0] > gu3Var.e().size()) {
                        return;
                    }
                    NearByBean nearByBean = new NearByBean();
                    nearByBean.adItem = new pv1(this, this.d.e(iArr[1]), iArr[1]);
                    gu3Var.P(iArr[0], nearByBean);
                }
            }
        }
    }

    public void g(gu3 gu3Var) {
        if (gu3Var == null) {
            this.f = null;
        } else {
            this.f = new WeakReference<>(gu3Var);
        }
    }

    public void h() {
        this.d = new b();
    }

    public final sv1 j(JSONObject jSONObject, boolean z) {
        sv1 sv1Var = new sv1(z);
        if (jSONObject == null) {
            return sv1Var;
        }
        try {
            String strP = p();
            WifiLog.d("FindAd createConfigModel configKey " + strP);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strP);
            if (jSONObjectOptJSONObject == null) {
                return sv1Var;
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("requestTime");
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("adPosition");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray.length() == jSONArrayOptJSONArray2.length()) {
                LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    int iOptInt = jSONArrayOptJSONArray.optInt(i2, sv1Var.f20850a);
                    int iOptInt2 = jSONArrayOptJSONArray2.optInt(i2, -1);
                    if (iOptInt2 >= 0) {
                        if (i2 == 0) {
                            sv1Var.f20850a = iOptInt;
                            if (iOptInt <= 0) {
                                iOptInt = 1;
                            }
                        }
                        linkedHashMap.put(Integer.valueOf(iOptInt), Integer.valueOf(iOptInt2));
                    }
                }
                sv1Var.b = linkedHashMap;
            }
        } catch (Exception e) {
            WifiLog.d("FindAd createConfigModel e " + e.toString());
        }
        return sv1Var;
    }

    public void k(String str, String str2, boolean z) {
        boolean z2;
        WifiLog.d("FindAd 1111 getAdJsonAndConfig ");
        this.b = "";
        this.c = new sv1(z);
        if (s()) {
            boolean z3 = true;
            if (TextUtils.isEmpty(str)) {
                z2 = false;
            } else {
                try {
                    this.b = new JSONObject(str).optString(p(), "");
                    z2 = true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    z2 = false;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                z3 = false;
            } else {
                try {
                    this.c = j(new JSONObject(str2), z);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    z3 = false;
                }
            }
            if (z2 && z3) {
                vv1.b(this);
            }
        }
    }

    public abstract int l();

    public String m() {
        return this.d.f20330a;
    }

    public abstract int n();

    public abstract String o();

    public String p() {
        String strC = jo6.c(o(), WkAdxAdConfigMg.DSP_NAME_BAIDU);
        WifiLog.d("FindAd getBannerTaiValue result " + strC);
        return strC;
    }

    public abstract String q();

    public boolean s() {
        return !"A".equalsIgnoreCase(p());
    }

    public void t(int i2) {
        this.d.k(i2);
    }

    public final void u(int i2, NestAdData nestAdData, b bVar) {
        b bVar2 = this.d;
        WeakReference<gu3> weakReference = this.f;
        gu3 gu3Var = weakReference == null ? null : weakReference.get();
        if (bVar != bVar2) {
            return;
        }
        bVar2.g(i2, nestAdData);
        if (gu3Var != null) {
            int i3 = bVar2.i(i2);
            List<NearByBean> listE = gu3Var.e();
            int size = listE.size();
            if (size > 0) {
                int i4 = size - 1;
                if (!TextUtils.isEmpty(listE.get(i4).bottomTips)) {
                    size = i4;
                }
            }
            if (i3 < 0 || i3 > size) {
                return;
            }
            NearByBean nearByBean = new NearByBean();
            nearByBean.adItem = new pv1(this, nestAdData, i2);
            gu3Var.P(i3, nearByBean);
        }
    }

    public void v(Activity activity, int i2, int i3) {
        Map.Entry<Integer, Integer> entryA;
        int iIntValue;
        Integer num;
        b bVar = this.d;
        sv1 sv1VarD = bVar.d();
        String strF = bVar.f();
        if (i2 != 2 || i2 == 3) {
            WifiLog.d("FindAd 3333 tryRequest config " + sv1VarD);
            WifiLog.d("FindAd 3333 tryRequest strategyJson " + strF);
        } else {
            WifiLog.d("FindAd 3333 tryRequest listPosition " + i3);
            if (i3 < 0) {
                return;
            }
        }
        if (!l6.f(n())) {
            ma3.a("[FindAdManager-tryRequest] ad config has not opened.", new Object[0]);
            return;
        }
        if (!h.get()) {
            ma3.a("isAdSdkInit not allow", new Object[0]);
            return;
        }
        if (s()) {
            if (this.e) {
                WifiLog.d("FindAd 3333 tryRequest sRequesting " + this.e);
                return;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    int iIntValue2 = bVar.j(i3).intValue();
                    if (iIntValue2 < 0 || (num = sv1VarD.b.get(Integer.valueOf(iIntValue2 + 1))) == null) {
                        return;
                    } else {
                        iIntValue = num.intValue();
                    }
                } else if (i2 != 3) {
                    return;
                } else {
                    iIntValue = -1;
                }
            } else if (sv1VarD.f20850a != 0 || (entryA = sv1VarD.a()) == null) {
                return;
            } else {
                iIntValue = entryA.getValue().intValue();
            }
            if (bVar.c(iIntValue)) {
                return;
            }
            String adRequestId = AdHelperH5Ad.INSTANCE.getAdRequestId();
            this.e = true;
            vv1.e(adRequestId, this);
            HashMap map = new HashMap();
            map.put("requestId", adRequestId);
            map.put("taiChiKey", o());
            map.put("exp_group", p());
            AdHelperFeed adHelperFeedCreateAdFeed = WifiNestAd.INSTANCE.createAdFeed();
            AdParams adParamsBuild = new AdParams.Builder().setExt(map).setScene(n()).setAdUnitId(q()).setFullStrategyJson(strF).build();
            if (i2 != 3) {
                this.f20327a = true;
            }
            adHelperFeedCreateAdFeed.getNativeFeedAd(activity, adParamsBuild, new a(i2, adRequestId, iIntValue, bVar));
        }
    }

    public void w(String str, boolean z) {
        WifiLog.d("FindAd  updateAdConfig ");
        this.c = new sv1(z);
        if (!s() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.c = j(new JSONObject(str), z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void x(String str) {
        WifiLog.d("FindAd  updateAdJson ");
        this.b = "";
        if (!s() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.b = new JSONObject(str).optString(p(), "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20328a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ b d;

        /* JADX INFO: renamed from: qv1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1271a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f20329a;

            public RunnableC1271a(List list) {
                this.f20329a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                NestAdData nestAdData;
                List list = this.f20329a;
                if (list == null || list.size() <= 0 || (nestAdData = (NestAdData) this.f20329a.get(0)) == null) {
                    return;
                }
                a aVar = a.this;
                vv1.c(aVar.b, nestAdData, qv1.this);
                a aVar2 = a.this;
                qv1.this.u(aVar2.c, nestAdData, aVar2.d);
            }
        }

        public a(int i, String str, int i2, b bVar) {
            this.f20328a = i;
            this.b = str;
            this.c = i2;
            this.d = bVar;
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            qv1.this.e = false;
            vv1.d(str, str2, qv1.this);
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            if (this.f20328a != 3) {
                qv1.this.g.post(new RunnableC1271a(list));
            }
            qv1.this.e = false;
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }
}
