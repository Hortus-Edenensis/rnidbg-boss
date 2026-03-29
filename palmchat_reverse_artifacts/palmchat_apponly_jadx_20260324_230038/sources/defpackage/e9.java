package defpackage;

import android.app.Activity;
import com.huawei.hms.ads.ContentClassification;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.maintab.AIQuickMatchConfig;
import com.zenmen.palmchat.utils.SAppUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class e9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17234a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static e9 f17235a = new e9();
    }

    public static e9 d() {
        return a.f17235a;
    }

    public boolean a(Activity activity) {
        Class clsG;
        if (activity == null || (clsG = t5.f().g()) == null || !clsG.equals(ChatterActivity.class)) {
            b05.a("checkShowGuideForRec===》不需要显示弹窗");
            return false;
        }
        b05.a("checkShowGuideForRec===》需要显示弹窗");
        return true;
    }

    public void b(int i) {
        if (SAppUtil.a.b()) {
            if (i == 48) {
                this.f17234a = false;
            }
            if (i == 49) {
                this.b = false;
            }
        }
    }

    public AIQuickMatchConfig c() {
        AIQuickMatchConfig aIQuickMatchConfig;
        try {
            aIQuickMatchConfig = (AIQuickMatchConfig) az2.a(q05.f("ai_match").toString(), AIQuickMatchConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
            aIQuickMatchConfig = null;
        }
        return aIQuickMatchConfig == null ? new AIQuickMatchConfig() : aIQuickMatchConfig;
    }

    public boolean e() {
        return SAppUtil.a.b() && c().pop_A;
    }

    public boolean f() {
        return SAppUtil.a.b() && c().pop_B;
    }

    public boolean g() {
        return SAppUtil.a.b() && c().pop_C;
    }

    public boolean h() {
        return SAppUtil.a.b() && c().pop_D;
    }

    public boolean i() {
        return SAppUtil.a.b() && c().pop_F;
    }

    public boolean j() {
        return SAppUtil.a.b() && c().pop_H;
    }

    public boolean k() {
        return SAppUtil.a.b() && c().pop_J;
    }

    public boolean l(Activity activity, String str) {
        if (q05.o(activity) && !str.equals("H")) {
            return false;
        }
        AIQuickMatchConfig aIQuickMatchConfigC = c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = iv0.a(jCurrentTimeMillis, "yyyy-MM-dd");
        Long l = (Long) q05.k("KEY_AI_QUICK_MATCH_POPSHOW_LAST_TIME", 0L);
        Long l2 = (Long) q05.k("KEY_AI_QUICK_MATCH_POPSHOW_LAST_START_TIME", 0L);
        if (l2.longValue() == 0 || l.longValue() == 0) {
            q05.w("KEY_AI_QUICK_MATCH_POPSHOW_TOTAL_COUNT", 0);
            q05.w("KEY_AI_QUICK_MATCH_POPSHOW_DAILY_COUNT", 0);
            q05.w("KEY_AI_QUICK_MATCH_POPSHOW_LAST_START_TIME", Long.valueOf(jCurrentTimeMillis));
            q05.w("KEY_AI_QUICK_MATCH_POPSHOW_LAST_TIME", Long.valueOf(jCurrentTimeMillis));
        } else {
            if ((jCurrentTimeMillis - l2.longValue()) / 86400000 >= aIQuickMatchConfigC.pop_number_day) {
                q05.w("KEY_AI_QUICK_MATCH_POPSHOW_TOTAL_COUNT", 0);
                q05.w("KEY_AI_QUICK_MATCH_POPSHOW_DAILY_COUNT", 0);
                q05.w("KEY_AI_QUICK_MATCH_POPSHOW_LAST_START_TIME", Long.valueOf(jCurrentTimeMillis));
            }
            int iIntValue = ((Integer) q05.k("KEY_AI_QUICK_MATCH_POPSHOW_TOTAL_COUNT", 0)).intValue();
            int iIntValue2 = ((Integer) q05.k("KEY_AI_QUICK_MATCH_POPSHOW_DAILY_COUNT", 0)).intValue();
            if (!strA.equals(iv0.a(l.longValue(), "yyyy-MM-dd"))) {
                q05.w("KEY_AI_QUICK_MATCH_POPSHOW_DAILY_COUNT", 0);
                iIntValue2 = 0;
            }
            if (iIntValue2 >= aIQuickMatchConfigC.pop_maxday) {
                return false;
            }
            if (System.currentTimeMillis() - l.longValue() < aIQuickMatchConfigC.pop_cooldown * 1000) {
                b05.a("时间间隔内");
                return false;
            }
            if (iIntValue >= aIQuickMatchConfigC.pop_number_time) {
                return false;
            }
        }
        int iIntValue3 = ((Integer) q05.k("KEY_AI_QUICK_MATCH_POPSHOW_TOTAL_COUNT", 0)).intValue();
        int iIntValue4 = ((Integer) q05.k("KEY_AI_QUICK_MATCH_POPSHOW_DAILY_COUNT", 0)).intValue();
        q05.w("KEY_AI_QUICK_MATCH_POPSHOW_TOTAL_COUNT", Integer.valueOf(iIntValue3 + 1));
        q05.w("KEY_AI_QUICK_MATCH_POPSHOW_DAILY_COUNT", Integer.valueOf(iIntValue4 + 1));
        q05.w("KEY_AI_QUICK_MATCH_POPSHOW_LAST_TIME", Long.valueOf(jCurrentTimeMillis));
        SAppUtil.K(activity, "zenxin://activity?page=a0052&pkgId=ai-dating&gestureRollback=1&&isTransParent=true&urlExtra=%23%2Fguide%3Fhalffrom%3D" + str);
        return true;
    }

    public void m(Activity activity, int i, int i2) {
        if (!this.g && e()) {
            AIQuickMatchConfig aIQuickMatchConfigC = c();
            if (i == 48 && i2 + 1 >= aIQuickMatchConfigC.pop_A_number && !this.f17234a) {
                this.f17234a = true;
                l(activity, "A");
            }
            if (i != 49 || i2 + 1 < aIQuickMatchConfigC.pop_A_number || this.b) {
                return;
            }
            this.b = true;
            l(activity, "A");
        }
    }

    public void n(Activity activity, int i, int i2) {
        if (i == 48) {
            if (this.e) {
                p(activity, i, i2);
            } else {
                m(activity, i, i2);
            }
        }
        if (i == 49) {
            if (this.f) {
                p(activity, i, i2);
            } else {
                m(activity, i, i2);
            }
        }
    }

    public void o(Activity activity) {
        if (f()) {
            l(activity, WkAdxAdConfigMg.DSP_NAME_BAIDU);
        }
    }

    public void p(Activity activity, int i, int i2) {
        if (g()) {
            AIQuickMatchConfig aIQuickMatchConfigC = c();
            if (i == 48 && i2 + 1 >= aIQuickMatchConfigC.pop_C_number && !this.f17234a) {
                this.f17234a = true;
                l(activity, WkAdxAdConfigMg.DSP_NAME_CSJ);
            }
            if (i != 49 || i2 + 1 < aIQuickMatchConfigC.pop_C_number || this.b) {
                return;
            }
            this.b = true;
            l(activity, WkAdxAdConfigMg.DSP_NAME_CSJ);
        }
    }

    public void q(Activity activity) {
        if (h()) {
            SAppUtil.K(activity, "zenxin://activity?page=a0052&pkgId=ai-dating&gestureRollback=1&urlExtra=%23%2F%3Fhalffrom%3DD");
        }
    }

    public boolean r(Activity activity) {
        if (i()) {
            return l(activity, "F");
        }
        return false;
    }

    public void s(Activity activity) {
        if (j()) {
            l(activity, "H");
        }
    }

    public boolean t(Activity activity) {
        if (k()) {
            return l(activity, ContentClassification.AD_CONTENT_CLASSIFICATION_J);
        }
        return false;
    }

    public e9() {
        this.f17234a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
    }
}
