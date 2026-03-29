package defpackage;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.huawei.hms.ads.ex;
import com.huawei.openalliance.ad.constant.az;
import com.oplus.tblplayer.Constants;
import com.zenmen.palmchat.activity.webview.TransparentCordovaWebActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.utils.time.FastDateFormat;
import com.zenmen.palmchat.wallet.WalletActivity;
import defpackage.qp3;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class nb3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ei6 f19480a = new ei6();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements qp3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19481a;
        public final /* synthetic */ c b;

        public a(String str, c cVar) {
            this.f19481a = str;
            this.b = cVar;
        }

        @Override // qp3.a
        public void a(String str, Object obj) {
            if (this.f19481a.equals(str)) {
                z53.a("TAG", "有回调" + obj);
                qp3.a().d(this);
                if (obj == null || !(obj instanceof Pair)) {
                    return;
                }
                Pair pair = (Pair) obj;
                c cVar = this.b;
                if (cVar != null) {
                    cVar.a(((Integer) pair.first).intValue(), (String) pair.second, null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements qp3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19482a;
        public final /* synthetic */ c b;

        public b(String str, c cVar) {
            this.f19482a = str;
            this.b = cVar;
        }

        @Override // qp3.a
        public void a(String str, Object obj) {
            LogUtil.i("LxWallet", "openRecharge onEvent" + str);
            if (this.f19482a.equals(str)) {
                z53.a("TAG", "有回调" + obj);
                qp3.a().d(this);
                if (obj == null || !(obj instanceof Pair)) {
                    return;
                }
                Pair pair = (Pair) obj;
                if (this.b != null) {
                    LogUtil.i("LxWallet", "openRecharge onPayResult code=" + pair.first + " msg=" + ((String) pair.second));
                    this.b.a(((Integer) pair.first).intValue(), (String) pair.second, null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(int i, String str, Object obj);
    }

    @Nullable
    public static String a() {
        String strOptString = null;
        try {
            JSONObject jSONObjectC = c();
            if (jSONObjectC != null) {
                strOptString = jSONObjectC.optString("home_openurl_v3");
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        return "zenxin://activity?page=a00010&needLogin=true&fullwindow=1&url=" + of2.d();
    }

    @Nullable
    public static String b() {
        String strOptString = null;
        try {
            JSONObject jSONObjectC = c();
            if (jSONObjectC != null) {
                strOptString = jSONObjectC.optString("recharge_openurl_v3");
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        return "zenxin://activity?page=a0045&needLogin=true&url=" + of2.c();
    }

    @Nullable
    public static JSONObject c() {
        JSONObject jSONObjectC = ts0.o().C();
        LogUtil.i("LxWallet", "GetWalletConfig=" + jSONObjectC);
        if (jSONObjectC != null && jSONObjectC.has("wallet")) {
            try {
                return jSONObjectC.getJSONObject("wallet");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(String str) {
        Uri uri;
        String queryParameter;
        String string;
        String strE = e();
        if (!TextUtils.isEmpty(strE)) {
            try {
                uri = Uri.parse(str);
                queryParameter = uri.getQueryParameter("url");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(queryParameter)) {
                string = str;
            } else {
                Uri.Builder builderBuildUpon = Uri.parse(queryParameter).buildUpon();
                builderBuildUpon.appendQueryParameter("lxtag", strE);
                String string2 = builderBuildUpon.build().toString();
                Uri.Builder builderBuildUpon2 = uri.buildUpon();
                builderBuildUpon2.clearQuery();
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str2 : queryParameterNames) {
                        if ("url".equals(str2)) {
                            builderBuildUpon2.appendQueryParameter("url", string2);
                        } else {
                            builderBuildUpon2.appendQueryParameter(str2, uri.getQueryParameter(str2));
                        }
                    }
                }
                string = builderBuildUpon2.build().toString();
            }
        }
        LogUtil.i("LxWallet", "fixHomeUrlWithTimeTag url=" + str + " result =" + string);
        return string;
    }

    public static String e() {
        int iA = vs0.a().a("walletTagTimeIndex", 0);
        if (iA > 0 && iA < 12) {
            try {
                String strG = g("yyyyMMddHHmm");
                return strG.substring(0, strG.length() - iA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String f(String str) {
        Uri uri;
        Set<String> queryParameterNames;
        String strB = of2.b();
        if (str == null || !str.contains(Constants.STRING_VALUE_UNSET) || (queryParameterNames = (uri = Uri.parse(str)).getQueryParameterNames()) == null || queryParameterNames.size() <= 0) {
            return strB;
        }
        Uri.Builder builderBuildUpon = Uri.parse(strB).buildUpon();
        for (String str2 : queryParameterNames) {
            builderBuildUpon.appendQueryParameter(str2, uri.getQueryParameter(str2));
        }
        String strE = e();
        if (!TextUtils.isEmpty(strE)) {
            builderBuildUpon.appendQueryParameter("lxtag", strE);
        }
        String string = builderBuildUpon.build().toString();
        LogUtil.i("LxWallet", "getFixRechargeUrl ori=" + str + " result =" + string);
        return string;
    }

    public static String g(String str) {
        return FastDateFormat.getInstance(str, Locale.US).format(ir5.b());
    }

    public static void h(Context context, String str, int i, String str2, String str3, Boolean bool, String str4) {
        LogUtil.i("LxWallet", "go url=" + str);
        if (of2.h()) {
            Intent intent = new Intent();
            intent.setClass(context, TransparentCordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", f(str));
            bundle.putBoolean("extra_key_full_window", true);
            bundle.putBoolean("hide_progressbar", true);
            intent.putExtra("K_RECHARGE_CALLBACK_ID", str4);
            intent.putExtras(bundle);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } else {
            Intent intent2 = new Intent();
            intent2.setClass(context, WalletActivity.class);
            intent2.putExtra("url", str);
            intent2.putExtra(az.at, i);
            intent2.addFlags(268435456);
            if (!TextUtils.isEmpty(str2)) {
                intent2.putExtra("mid", str2);
            }
            if (str3 != null) {
                intent2.putExtra("bgColor", str3);
            }
            if (bool != null) {
                intent2.putExtra("isRechargeOnly", bool);
            }
            if (!TextUtils.isEmpty(str4)) {
                intent2.putExtra("rechargeCallbackId", str4);
            }
            context.startActivity(intent2);
        }
        LogUtil.d("LxWallet", "go startActivity:" + str);
    }

    public static void i(Context context, ContentValues contentValues) {
        String asString = contentValues.getAsString("url");
        Integer asInteger = contentValues.getAsInteger(az.at);
        if (asInteger == null) {
            asInteger = 0;
        }
        h(context, asString, asInteger.intValue(), contentValues.getAsString("mid"), contentValues.getAsString("bgColor"), contentValues.getAsBoolean("isRechargeOnly"), contentValues.getAsString("rechargeCallbackId"));
    }

    public static void j(Context context) {
        String strD = d(a());
        Activity activity = (Activity) context;
        if (ve.q(activity, strD)) {
            return;
        }
        ve.s(activity, strD, false);
    }

    public static void k(Context context, String str, long j, c cVar) {
        String str2 = "recharge_callback_" + xn3.a();
        HashMap map = new HashMap();
        map.put("needLxBean", String.valueOf(j));
        String strE = e();
        if (!TextUtils.isEmpty(strE)) {
            map.put("lxtag", strE);
        }
        String strC = p86.c(str, map);
        ContentValues contentValues = new ContentValues();
        contentValues.put("isRechargeOnly", ex.Code);
        contentValues.put("rechargeCallbackId", str2);
        contentValues.put("bgColor", "0x00000000");
        contentValues.put("url", strC);
        LogUtil.d("logmatch", "zgr openRecharge=" + strC);
        i(context, contentValues);
        qp3.a().c(new b(str2, cVar));
    }

    public static void l(FrameworkBaseActivity frameworkBaseActivity, int i, c cVar) {
        String str = "recharge_callback_" + xn3.a();
        String strB = b();
        HashMap map = new HashMap();
        map.put("needLxBean", String.valueOf(i));
        String strE = e();
        if (!TextUtils.isEmpty(strE)) {
            map.put("lxtag", strE);
        }
        String strB2 = p86.b(strB, map);
        HashMap map2 = new HashMap();
        map2.put("isRechargeOnly", ex.Code);
        map2.put("rechargeCallbackId", str);
        String strC = p86.c(strB2, map2);
        LogUtil.d("logmatch", "zrg rechargeUrl=" + strC);
        if (!ve.q(frameworkBaseActivity, strC)) {
            ve.s(frameworkBaseActivity, strC, false);
        }
        qp3.a().c(new a(str, cVar));
    }
}
