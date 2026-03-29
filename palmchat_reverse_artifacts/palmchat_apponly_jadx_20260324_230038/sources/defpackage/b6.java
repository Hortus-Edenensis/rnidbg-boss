package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1653a = false;
    public static boolean b = false;
    public static int c = 95;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static boolean n = false;
    public static boolean o = false;
    public static boolean p = false;
    public static boolean q = false;
    public static boolean r = false;
    public static boolean s = false;
    public static boolean t = false;
    public static boolean u = false;
    public static boolean v = false;
    public static String d = "LX-43257";
    public static final String w = d + "_B";
    public static String e = "LX-43904";
    public static final String x = e + "_" + b();

    public static void a(String str) {
        LogUtil.d("ClearAd", "clearCacheAd getAllConfig " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c = jSONObject.optInt("oom_low_percent_77583", 95);
            boolean z = false;
            q = jSONObject.optInt("maintabs_allad", -1) != -1;
            f = jSONObject.optInt(w, -1) != -1;
            g = jSONObject.optInt("minebanner_34097", -1) != -1;
            h = jSONObject.optInt("pop_31425", -1) != -1;
            i = jSONObject.optInt("friend_banner_33784", -1) != -1;
            j = jSONObject.optInt("couple_31938", -1) != -1;
            k = jSONObject.optInt("pmfeed_24115", -1) != -1;
            l = jSONObject.optInt("pmsihi_28472", -1) != -1;
            m = jSONObject.optInt("pmlike_28913", -1) != -1;
            n = jSONObject.optInt(x, -1) != -1;
            o = jSONObject.optInt("nearreward_28916", -1) != -1;
            p = jSONObject.optInt("splash_31249", -1) != -1;
            r = jSONObject.optInt("findrecommend_39895", -1) != -1;
            s = jSONObject.optInt("findrenear_39896", -1) != -1;
            t = jSONObject.optInt("square_35416", -1) != -1;
            u = jSONObject.optInt("public_40038", -1) != -1;
            v = jSONObject.optInt("user_draw_44444", -1) != -1;
            if (jSONObject.optInt("findad", -1) != -1) {
                z = true;
            }
            b = z;
        } catch (Exception unused) {
        }
        LogUtil.d("ClearAd", "clearCacheAd mMainTabsAd " + q + " mDetailAd " + f + " mMineBannerAd " + g + " mPopAd " + h + " mNestBannerAd " + i + " mCoupleAd " + j + " mPmNestAd " + k + " mPeopleLikeAd " + l + " mPeopleUnAd " + m + " mNearbyFeedAd " + n + " mNearbyRewardAd " + o + " mSplashAd " + p + " mFindRecommendAd " + r + " mFindNearAd " + s + "mSquareAd " + t + "mPublicAd" + u + " mUserDrawDetailAd " + v + " oomLowPercent " + c);
    }

    public static String b() {
        return jo6.e(e);
    }

    public static void c(String str) {
        a(str);
    }

    public static boolean d() {
        return !"A".equals(ap3.a().n("LX-77583", "A"));
    }

    public static boolean e(String str) {
        if (c <= 0 || !d()) {
            return false;
        }
        long j2 = Runtime.getRuntime().totalMemory();
        long jMaxMemory = Runtime.getRuntime().maxMemory();
        if (jMaxMemory <= 0) {
            return false;
        }
        int i2 = (int) ((j2 * 100.0f) / jMaxMemory);
        LogUtil.d("ClearAd", "clearCacheAd isLowPercentAllow " + str + " scale " + i2 + " total " + j2 + " max " + jMaxMemory);
        if (i2 < c) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("fromName", str);
        LogUtil.log4ClientError("ad_oom_low_percent_event_77583", map, null, true);
        return true;
    }

    public static void f(String str) {
        a(str);
    }
}
