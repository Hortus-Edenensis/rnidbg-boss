package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class z92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22380a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;

    static {
        String str = nl0.c + "/one/ax/";
        f22380a = str;
        b = str + "vas.item.panel.detail.v3";
        c = str + "vas.item.buy.give.v2";
        d = str + "vas.item.backpack.detail.v2";
        e = str + "vas.item.giving.v2";
        f = str + "vas.item.empty.send.give.v1";
        g = str + "vas.wallet.lxc.count.v1";
        h = str + "user.gift.received.v1";
    }

    public static void a(JSONObject jSONObject, yw4 yw4Var) {
        zw4.f(b, 1, jSONObject, yw4Var);
    }

    public static void b(JSONObject jSONObject, yw4 yw4Var) {
        zw4.f(d, 1, jSONObject, yw4Var);
    }

    public static void c(JSONObject jSONObject, yw4 yw4Var) {
        LogUtil.d("GiftDao", "queryBalance:" + jSONObject.toString());
        zw4.f(g, 1, jSONObject, yw4Var);
    }

    public static void d(JSONObject jSONObject, yw4 yw4Var) {
        LogUtil.d("GiftDao", "queryUserGiftReceived:" + jSONObject.toString());
        zw4.f(h, 1, jSONObject, yw4Var);
    }

    public static void e(JSONObject jSONObject, yw4 yw4Var) {
        LogUtil.d("GiftDao", "sendGift:" + jSONObject.toString());
        zw4.f(c, 1, jSONObject, yw4Var);
    }

    public static void f(JSONObject jSONObject, yw4 yw4Var) {
        LogUtil.d("GiftDao", "sendIntimacyGuideGift:" + jSONObject.toString());
        zw4.f(f, 1, jSONObject, yw4Var);
    }

    public static void g(JSONObject jSONObject, yw4 yw4Var) {
        LogUtil.d("GiftDao", "sendPackGift:" + jSONObject.toString());
        zw4.f(e, 1, jSONObject, yw4Var);
    }
}
