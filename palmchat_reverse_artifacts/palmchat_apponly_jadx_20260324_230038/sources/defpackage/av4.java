package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.refund.RefundData;
import com.zenmen.palmchat.refund.RefundDialogActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.fk2;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class av4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1580a = false;
    public static int b = -1;
    public static int c = -1;
    public static boolean d = false;
    public static Activity e = null;
    public static boolean f = false;
    public static String g = "";

    public static void a() {
        ap3.a().S();
    }

    public static boolean b(Intent intent, String str) {
        if (intent == null || intent.getExtras() == null) {
            return false;
        }
        String string = intent.getExtras().getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        if (string.contains("#")) {
            string = string.replace("#", "%23");
        }
        try {
            LogUtil.d("RefundManager", "checkVipRefundUrl return url " + string);
            String queryParameter = Uri.parse(string).getQueryParameter("from");
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            int i = Integer.parseInt(queryParameter);
            if (!e(i)) {
                return false;
            }
            LogUtil.d("RefundManager", "checkVipRefundUrl return true fromInt " + i);
            return true;
        } catch (Throwable th) {
            LogUtil.d("RefundManager", "checkVipRefundUrl Throwable " + th.toString());
            return false;
        }
    }

    public static void c(int i, String str) {
        if (i == 2) {
            LogUtil.d("RefundManager", "closeDone mDialogShow " + f1580a + " lastDialogActivity " + e);
            if ("close".equals(str)) {
                if (f1580a) {
                    ds0.a().b(new zu4(1));
                    return;
                }
                return;
            } else {
                if ("button".equals(str)) {
                    if (f1580a) {
                        ds0.a().b(new zu4(2));
                        return;
                    }
                    Activity activity = e;
                    if (activity != null) {
                        ap3.A(activity, b, c, d, 1);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (i == 1) {
            LogUtil.d("RefundManager", "closeDone scene " + str + " mVipPayShow " + f + " lastVipPayUrl " + g);
            if ("close".equals(str) || !"button".equals(str) || f || TextUtils.isEmpty(g)) {
                return;
            }
            ap3.a().R(c.b(), g + "&welfareType=1");
            g = "";
        }
    }

    public static int d(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean e(int i) {
        return i == 1 || i == 2 || i == 9 || i == 10 || i == 25 || i == 26 || i == 502 || i == 506 || i == 509 || i == 520;
    }

    public static String f(int i) {
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        int i4 = i % 60;
        String strValueOf = String.valueOf(i2);
        if (i2 < 10) {
            strValueOf = "0" + strValueOf;
        }
        String strValueOf2 = String.valueOf(i3);
        if (i3 < 10) {
            strValueOf2 = "0" + strValueOf2;
        }
        String strValueOf3 = String.valueOf(i4);
        if (i4 < 10) {
            strValueOf3 = "0" + strValueOf3;
        }
        return strValueOf + ":" + strValueOf2 + ":" + strValueOf3;
    }

    public static void g() {
        e = null;
    }

    public static void h(Activity activity, int i, int i2, boolean z) {
        e = activity;
        b = i;
        c = i2;
        d = z;
    }

    public static void i(String str) {
        g = str;
        LogUtil.d("RefundManager", "setLastVipPayUrl lastVipPayUrl " + g);
    }

    public static void j(boolean z) {
        f = z;
        LogUtil.d("RefundManager", "setVipShow mVipPayShow " + f);
    }

    public static void k(Activity activity, int i, int i2, boolean z) {
        try {
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("main_tab", "tab_find_friend");
            bundle.putString("find_friend_tab", "userrecommend");
            bundle.putBoolean("find_friend_refund_super_result", true);
            bundle.putInt("find_friend_refund_super_from", i2);
            bundle.putInt("find_friend_refund_super_scene", i);
            bundle.putBoolean("find_friend_refund_super_deep", z);
            aVar.b(bundle);
            activity.startActivity(n5.b(activity, aVar));
        } catch (Exception unused) {
        }
    }

    public static void l(Context context, String str, int i, boolean z) {
        try {
            Intent intent = new Intent(context, (Class<?>) RefundDialogActivity.class);
            intent.putExtra("from", i);
            intent.putExtra("data", str);
            intent.putExtra("allowAnim", z);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void m(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            return;
        }
        try {
            RefundData refundData = (RefundData) az2.a(jSONObject.toString(), RefundData.class);
            if (refundData != null) {
                LogUtil.d("RefundManager", "startVipRefund refundData " + refundData.toString());
                if (refundData.play) {
                    l(context, jSONObject.toString(), 1, true);
                } else if (!refundData.showEnevlop) {
                    l(context, jSONObject.toString(), 1, false);
                }
            }
        } catch (Exception unused) {
        }
    }
}
