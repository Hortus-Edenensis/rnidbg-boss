package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import com.zenmen.palmchat.paidservices.superexpose.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class tj2 {
    public static final String A(String str) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        if (!TextUtils.isEmpty(ac1.m)) {
            builderBuildUpon.appendQueryParameter("channelId", ac1.m);
        }
        return builderBuildUpon.build().toString();
    }

    public static String B() {
        return nl0.q + "/tkroom/#/level";
    }

    public static String C() {
        return nl0.d + "/help/msgcall/visitors.html";
    }

    public static String D() {
        return nl0.c + "/help/legal/yprivacy.html";
    }

    public static String a() {
        return nl0.c + "/help/restriction/index.html?";
    }

    public static String b() {
        return "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-13-4-6889bd307d4943e0ac3f031435d5d3a5-rt3dah";
    }

    public static String c() {
        return nl0.c + "/help/legal/cprivacy.html";
    }

    public static String d() {
        return nl0.c + "/help/legal/realPersonAuth.html";
    }

    public static String e() {
        return nl0.c + "/help/legal/apply_for_permission.html";
    }

    public static String f() {
        return nl0.c + "/help/legal/complaint.html";
    }

    public static String g() {
        return nl0.c + "/help/legal/personal_Information.html";
    }

    public static String h() {
        return nl0.q + "/hgroup/#/";
    }

    public static String i(String str) {
        return nl0.q + str;
    }

    public static String j() {
        return nl0.c + "/help/report/appeal.html";
    }

    public static String k() {
        return nl0.c + "/help/views/video/floatwindow.html";
    }

    public static String l() {
        return nl0.c + "/help/report/report_new.html?";
    }

    public static String m() {
        return ts0.o().l();
    }

    public static String n() {
        return nl0.c + "/help/legal/index.html";
    }

    public static String o() {
        return ts0.o().t();
    }

    public static String p() {
        return nl0.c + "/help/legal/privacy.html";
    }

    public static String q() {
        return nl0.q + "/popup/#/qualityFriend";
    }

    public static String r() {
        return nl0.c + "/help/secretary/index.html";
    }

    public static String s() {
        StringBuilder sb;
        String str;
        if (nl0.k()) {
            sb = new StringBuilder();
            str = nl0.e;
        } else {
            sb = new StringBuilder();
            str = nl0.c;
        }
        sb.append(str);
        sb.append("/bonush5/redpack/pocketMon.html");
        return sb.toString();
    }

    public static String t() {
        return nl0.c + "/bizh5/190123nearby/shareloading2.html";
    }

    public static String u() {
        return nl0.c + "/help/msgcall/sensitiveWord.html";
    }

    public static String v() {
        return nl0.c + "/help/legal/third_partyMe.html";
    }

    public static String w() {
        StringBuilder sb = new StringBuilder();
        sb.append(nl0.f);
        sb.append(nl0.k() ? "/mdc/res/v5/1/9ugxnorjls-13-4-304bac3a94654aafbdc806783e552def-rtkacp" : "/mdc/res/v5/1/9ugxnorjls-13-4-ea2e8cad90504401b6f3d8587fa12931-ru85bz");
        return sb.toString();
    }

    public static String x(int i, int i2, int i3, long j) {
        if (i3 != -10) {
            return nl0.q + "/popup/#/boost/state?from=" + i + "&buyScene=" + i2 + "&superShowType=" + b.x;
        }
        return nl0.q + "/popup/#/boost/state?from=" + i + "&buyScene=" + i2 + "&status=" + i3 + "&showCount=" + j + "&superShowType=" + b.x;
    }

    public static String y() {
        return nl0.c + "/help/legal/thirdparty.html";
    }

    public static String z() {
        return nl0.c + "/help/views/addresslist/addressList.html";
    }
}
