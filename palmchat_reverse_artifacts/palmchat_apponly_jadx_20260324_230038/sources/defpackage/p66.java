package defpackage;

import android.text.TextUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class p66 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<Integer> f19950a = new ArrayList();
    public static List<Float> b = new ArrayList();

    public static boolean a(List<SquareFeed> list) {
        if (list == null || list.size() <= 0) {
            return true;
        }
        SquareFeed squareFeed = list.get(0);
        String strE = v4.e(c.b());
        String strB = v4.b(c.b());
        String str = squareFeed.uid;
        String str2 = squareFeed.exid;
        LogUtil.d("UserDetailAd", "checkUid mineUid " + strE + " feedUid " + str + " mineExid " + strB + " feedExid " + str2);
        if (TextUtils.isEmpty(strE) || TextUtils.isEmpty(str) || !strE.equals(str)) {
            return (TextUtils.isEmpty(strB) || TextUtils.isEmpty(str2) || !strB.equals(str2)) ? false : true;
        }
        return true;
    }

    public static String b() {
        return jo6.c("LX-44444", WkAdxAdConfigMg.DSP_NAME_BAIDU);
    }

    public static void c(String str) {
        h(str);
    }

    public static void d(String str) {
        i(str);
    }

    public static boolean e(int i, List<SquareFeed> list) {
        return i == 16 && g() && l6.f(82) && !a(list);
    }

    public static boolean f() {
        return !"A".contains(bj5.b().a().T("LX-52857", "A"));
    }

    public static boolean g() {
        return !"A".equalsIgnoreCase(b());
    }

    public static void h(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || !g()) {
            return;
        }
        LogUtil.d("UserDetailAd", "parConfig ext " + str);
        try {
            String strOptString = new JSONObject(str).optString("adPosition");
            if (TextUtils.isEmpty(strOptString) || (strArrSplit = strOptString.split(",")) == null || strArrSplit.length <= 0) {
                return;
            }
            f19950a.clear();
            for (int i = 0; i < strArrSplit.length; i++) {
                f19950a.add(Integer.valueOf(Integer.parseInt(strArrSplit[i])));
                LogUtil.d("UserDetailAd", "parConfig i " + i + " mAdpositions[i] " + f19950a.get(i));
            }
            Collections.sort(f19950a);
            d66.b();
        } catch (Exception unused) {
        }
    }

    public static void i(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || !g()) {
            return;
        }
        LogUtil.d("UserDetailAd", "parConfigV2 ext " + str);
        try {
            String strOptString = new JSONObject(str).optString("adPosition");
            if (TextUtils.isEmpty(strOptString) || (strArrSplit = strOptString.split(",")) == null || strArrSplit.length <= 0) {
                return;
            }
            b.clear();
            for (int i = 0; i < strArrSplit.length; i++) {
                b.add(Float.valueOf(Float.parseFloat(strArrSplit[i])));
                LogUtil.d("UserDetailAd", "parConfig i " + i + " mAdpositionsV2[i] " + b.get(i));
            }
            Collections.sort(b);
            d66.b();
        } catch (Exception unused) {
        }
    }

    public static void j(String str) {
        h(str);
    }

    public static void k(String str) {
        i(str);
    }
}
