package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.ad.find.FindAdViewHolder2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class rv1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f20582a = 48;
    public static WeakReference<Activity> b;
    public static NestAdData c;
    public static NestAdData d;
    public static ArrayList<FindAdViewHolder2> e = new ArrayList<>();
    public static ArrayList<FindAdViewHolder2> f = new ArrayList<>();

    public static boolean a() {
        return !"A".equalsIgnoreCase(bj5.b().a().T("LX-60751", "A"));
    }

    public static void b() {
        FindAdViewHolder2 findAdViewHolder2;
        FindAdViewHolder2 findAdViewHolder22;
        LogUtil.d("FindAdSJManager", "changeNewAdData start mCurPageType " + f20582a);
        int i = f20582a;
        int i2 = 0;
        if (i == 49) {
            LogUtil.d("FindAdSJManager", "changeNewAdData NEARBY mNearbyCheckAdData " + d);
            if (d != null) {
                while (true) {
                    if (i2 >= f.size()) {
                        findAdViewHolder22 = null;
                        break;
                    }
                    findAdViewHolder22 = f.get(i2);
                    if (findAdViewHolder22.g) {
                        break;
                    } else {
                        i2++;
                    }
                }
                LogUtil.d("FindAdSJManager", "changeNewAdData NEARBY curAdViewHolder " + findAdViewHolder22);
                if (findAdViewHolder22 != null) {
                    findAdViewHolder22.u(d, 1);
                    d = null;
                    LogUtil.d("FindAdSJManager", "changeNewAdData NEARBY showAdUi success ");
                    return;
                }
                return;
            }
            return;
        }
        if (i == 48) {
            LogUtil.d("FindAdSJManager", "changeNewAdData RECOMMEND mRecommendCheckAdData " + c);
            if (c != null) {
                while (true) {
                    if (i2 >= e.size()) {
                        findAdViewHolder2 = null;
                        break;
                    }
                    findAdViewHolder2 = e.get(i2);
                    if (findAdViewHolder2.g) {
                        break;
                    } else {
                        i2++;
                    }
                }
                LogUtil.d("FindAdSJManager", "changeNewAdData RECOMMEND curAdViewHolder " + findAdViewHolder2);
                if (findAdViewHolder2 != null) {
                    findAdViewHolder2.u(c, 1);
                    c = null;
                    LogUtil.d("FindAdSJManager", "changeNewAdData RECOMMEND showAdUi success ");
                }
            }
        }
    }

    public static NestAdData c() {
        WeakReference<Activity> weakReference;
        LogUtil.d("FindAdSJManager", "checkRequestAd start ");
        int iH = h();
        if (iH == -1) {
            return null;
        }
        SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
        int iFindCacheSizeAdByScene = sPCacheManager.findCacheSizeAdByScene(iH);
        LogUtil.d("FindAdSJManager", "checkRequestAd cacheAd scene " + iH + " cacheSize " + iFindCacheSizeAdByScene);
        if (iFindCacheSizeAdByScene <= 1) {
            qv1 qv1VarG = g();
            boolean z = qv1VarG.f20327a;
            LogUtil.d("FindAdSJManager", "checkRequestAd adManager allowRequest " + z + " " + qv1VarG);
            if (z && (weakReference = b) != null) {
                qv1VarG.v(weakReference.get(), 3, -1);
                LogUtil.d("FindAdSJManager", "changeNewAdData tryRequest success ");
            }
        }
        NestAdData nestAdDataFindCacheMaxAdByScene = sPCacheManager.findCacheMaxAdByScene(iH);
        LogUtil.d("FindAdSJManager", "checkRequestAd cacheAd scene " + iH + " cacheAd " + nestAdDataFindCacheMaxAdByScene);
        return nestAdDataFindCacheMaxAdByScene;
    }

    public static void d() {
        f.clear();
        d = null;
        LogUtil.d("FindAdSJManager", "clearNearBy ");
    }

    public static void e() {
        e.clear();
        c = null;
        LogUtil.d("FindAdSJManager", "clearRecommend ");
    }

    public static void f(int i) {
        NestAdData nestAdDataC;
        LogUtil.d("FindAdSJManager", "mainTabSelect findPageSelect pageType " + i);
        f20582a = i;
        if (!a() || (nestAdDataC = c()) == null) {
            return;
        }
        int i2 = f20582a;
        if (i2 == 49) {
            d = nestAdDataC;
        } else if (i2 == 48) {
            c = nestAdDataC;
        }
        b();
    }

    public static qv1 g() {
        int i = f20582a;
        if (i == 49) {
            return du3.y();
        }
        if (i == 48) {
            return zt4.y();
        }
        return null;
    }

    public static int h() {
        int i = f20582a;
        if (i == 49) {
            return 57;
        }
        return i == 48 ? 56 : -1;
    }

    public static void i(Activity activity) {
        if (a() && activity != null && b == null) {
            LogUtil.d("FindAdSJManager", "initActivity activity " + activity);
            b = new WeakReference<>(activity);
        }
    }

    public static void j(String str, String str2) {
        LogUtil.d("FindAdSJManager", "mainTabSelect tabName " + str + " findTabName " + str2);
        if (!a() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str2.equals(str)) {
            return;
        }
        f(f20582a);
    }

    public static void k() {
        b = null;
        if (b6.d()) {
            ArrayList<FindAdViewHolder2> arrayList = e;
            if (arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < e.size(); i++) {
                    e.get(i).s();
                }
            }
            ArrayList<FindAdViewHolder2> arrayList2 = f;
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (int i2 = 0; i2 < f.size(); i2++) {
                    f.get(i2).s();
                }
            }
        }
        e.clear();
        f.clear();
        c = null;
        d = null;
    }

    public static void l(FindAdViewHolder2 findAdViewHolder2, int i) {
        if (a()) {
            LogUtil.d("FindAdSJManager", "setViewAdHolder adViewHolder " + findAdViewHolder2);
            if (findAdViewHolder2 != null) {
                if (i == 49) {
                    if (f.contains(findAdViewHolder2)) {
                        return;
                    }
                    f.add(findAdViewHolder2);
                } else {
                    if (i != 48 || e.contains(findAdViewHolder2)) {
                        return;
                    }
                    e.add(findAdViewHolder2);
                }
            }
        }
    }
}
