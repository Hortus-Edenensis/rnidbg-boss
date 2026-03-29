package defpackage;

import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.be;
import com.lantern.auth.server.WkParams;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.dn;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.wallet.WalletActivity;
import org.apache.cordova.jssdk.general.Action;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ji6 {
    public static Integer a(int i) {
        if (i == 0) {
            return 0;
        }
        return i == 2 ? -3 : -2;
    }

    public static void b(WalletActivity walletActivity, String str, String str2) {
        walletActivity.O1(str, fi6.a(k86.F(walletActivity, str2) ? 0 : 4001));
    }

    public static void c(WalletActivity walletActivity, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Action.ACTION_ISTEENAGERMODE, TeenagersModeManager.a().d());
            walletActivity.O1(str, fi6.e(jSONObject));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(WalletActivity walletActivity, String str, String str2, String str3) {
        byte b;
        str.hashCode();
        switch (str.hashCode()) {
            case -1913901306:
                b = !str.equals(Action.ACTION_GET_PAY_VER) ? (byte) -1 : (byte) 0;
                break;
            case -1263203643:
                if (str.equals("openUrl")) {
                    b = 1;
                    break;
                }
                break;
            case -504962947:
                if (str.equals("openItem")) {
                    b = 2;
                    break;
                }
                break;
            case -296535207:
                if (str.equals(Action.ACTION_UNION_PAY)) {
                    b = 3;
                    break;
                }
                break;
            case -266803431:
                if (str.equals("userInfo")) {
                    b = 4;
                    break;
                }
                break;
            case 110760:
                if (str.equals("pay")) {
                    b = 5;
                    break;
                }
                break;
            case 110621003:
                if (str.equals(FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK)) {
                    b = 6;
                    break;
                }
                break;
            case 180965168:
                if (str.equals("exchangeWindowColor")) {
                    b = 7;
                    break;
                }
                break;
            case 277236744:
                if (str.equals(Action.ACTION_CLOSE_WINDOW)) {
                    b = 8;
                    break;
                }
                break;
            case 341222968:
                if (str.equals("getConfig")) {
                    b = 9;
                    break;
                }
                break;
            case 978035875:
                if (str.equals("isAppInstalled")) {
                    b = 10;
                    break;
                }
                break;
            case 1095692943:
                if (str.equals(ReportItem.LogTypeRequest)) {
                    b = 11;
                    break;
                }
                break;
            case 1888917090:
                if (str.equals(Action.ACTION_OPEN_WX_MINIPROGRAM)) {
                    b = 12;
                    break;
                }
                break;
            case 2071080634:
                if (str.equals(Action.ACTION_ISTEENAGERMODE)) {
                    b = dn.k;
                    break;
                }
                break;
        }
        switch (b) {
            case 0:
                walletActivity.z.b(str3);
                break;
            case 1:
                i(walletActivity, str2);
                break;
            case 2:
                h(walletActivity, str2);
                break;
            case 3:
                try {
                    walletActivity.z.h(walletActivity, str3, new JSONObject(str2));
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case 4:
                k(walletActivity, str3);
                break;
            case 5:
                walletActivity.y.a(str2, str3);
                break;
            case 6:
                j(str2);
                break;
            case 7:
                f(walletActivity, str2);
                break;
            case 8:
                e(walletActivity, str2);
                break;
            case 9:
                g(walletActivity, str3);
                break;
            case 10:
                b(walletActivity, str3, str2);
                break;
            case 11:
                walletActivity.x.o(str2, str3);
                break;
            case 12:
                try {
                    walletActivity.z.f(str3, new JSONObject(str2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case 13:
                c(walletActivity, str3);
                break;
            default:
                LogUtil.w("LxWallet", "JS call native method[" + str + "] NOT EXISTS!");
                walletActivity.O1(str3, fi6.b(-1, fi6.f17535a.get(-1)));
                break;
        }
    }

    public static void e(WalletActivity walletActivity, String str) {
        if (walletActivity.B) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("payResultCode", -1);
                String strOptString = jSONObject.optString("payMsg");
                qp3.a().b(walletActivity.C, Pair.create(a(iOptInt), strOptString));
            } catch (JSONException e) {
                LogUtil.e("LxWallet", e);
                qp3.a().b(walletActivity.C, Pair.create(-2, "支付结果异常"));
            }
        }
        walletActivity.finish();
    }

    public static void f(WalletActivity walletActivity, String str) {
        try {
            walletActivity.I1(new JSONObject(str).optString("bgColor"));
        } catch (JSONException e) {
            LogUtil.e("LxWallet", e);
        }
    }

    public static void g(WalletActivity walletActivity, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(az.at, Integer.valueOf(walletActivity.getIntent().getIntExtra(az.at, -1)));
        } catch (JSONException unused) {
        }
        try {
            jSONObject.putOpt("mid", walletActivity.getIntent().getStringExtra("mid"));
        } catch (JSONException unused2) {
        }
        try {
            jSONObject.putOpt("statusBarHeight", Integer.valueOf(a46.n(walletActivity.getApplicationContext())));
        } catch (JSONException unused3) {
        }
        Point point = new Point();
        walletActivity.getWindowManager().getDefaultDisplay().getRealSize(point);
        try {
            jSONObject.putOpt("windowWidth", Integer.valueOf(point.x));
            jSONObject.putOpt("windowHeight", Integer.valueOf(point.y));
        } catch (JSONException unused4) {
        }
        DisplayMetrics displayMetrics = walletActivity.getApplicationContext().getResources().getDisplayMetrics();
        try {
            jSONObject.putOpt(be.ar, Float.valueOf(displayMetrics.density));
            jSONObject.putOpt("densityDpi", Integer.valueOf(displayMetrics.densityDpi));
            jSONObject.putOpt("scaledDensity", Float.valueOf(displayMetrics.scaledDensity));
            jSONObject.putOpt("xdpi", Float.valueOf(displayMetrics.xdpi));
            jSONObject.putOpt("ydpi", Float.valueOf(displayMetrics.ydpi));
            jSONObject.putOpt("screenHeight", Integer.valueOf(displayMetrics.heightPixels));
            jSONObject.putOpt("screenWidth", Integer.valueOf(displayMetrics.widthPixels));
        } catch (JSONException unused5) {
        }
        try {
            jSONObject.putOpt("version", 1L);
            jSONObject.putOpt("channel", ac1.m);
            jSONObject.put(az.aW, ac1.f);
            jSONObject.put("versionName", ac1.g);
        } catch (JSONException unused6) {
        }
        walletActivity.O1(str, fi6.e(jSONObject));
    }

    public static void h(WalletActivity walletActivity, String str) {
        try {
            String strOptString = new JSONObject(str).optString("openUrl", null);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            new JSONObject();
            Uri.parse(strOptString).getQueryParameter("page");
            if (ve.q(walletActivity, strOptString)) {
                return;
            }
            ve.s(walletActivity, strOptString, false);
        } catch (JSONException e) {
            LogUtil.e("LxWallet", e);
        }
    }

    public static void i(WalletActivity walletActivity, String str) {
        try {
            String strOptString = new JSONObject(str).optString("url");
            if (TextUtils.isEmpty(strOptString) || ve.q(walletActivity, strOptString)) {
                return;
            }
            ve.s(walletActivity, strOptString, false);
        } catch (JSONException e) {
            LogUtil.e("LxWallet", e);
        }
    }

    public static void j(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("name");
            String strOptString2 = jSONObject.optString(BaseConstants.EVENT_LABEL_EXTRA);
            if (TextUtils.isEmpty(strOptString)) {
                LogUtil.w("LxWallet", "JS call track with NO NAME!");
            } else {
                LogUtil.d("LxWallet", "JS call track with:" + strOptString + " extra:" + strOptString2);
                dg4.a(strOptString, strOptString2);
            }
        } catch (JSONException e) {
            LogUtil.e("LxWallet", e);
        }
    }

    public static void k(WalletActivity walletActivity, String str) {
        int iG;
        s4 s4VarA = v4.a(AppContext.getContext());
        JSONObject jSONObject = new JSONObject();
        if (s4VarA != null) {
            try {
                jSONObject.putOpt(DeviceInfoUtil.UID_TAG, s4VarA.g());
            } catch (JSONException unused) {
            }
            try {
                jSONObject.putOpt(WkParams.COUNTRYCODE, s4VarA.a());
            } catch (JSONException unused2) {
            }
            try {
                jSONObject.putOpt(bd.h, s4VarA.b());
            } catch (JSONException unused3) {
            }
            try {
                jSONObject.putOpt("phone", s4VarA.d());
            } catch (JSONException unused4) {
            }
            try {
                jSONObject.putOpt("nickName", s4VarA.c());
            } catch (JSONException unused5) {
            }
            ContactInfoItem contactInfoItemL = bo0.r().l(s4VarA.g());
            if (contactInfoItemL != null) {
                try {
                    iG = fg6.g(contactInfoItemL.getExt());
                } catch (Exception unused6) {
                }
            } else {
                iG = 0;
            }
            jSONObject.putOpt("isVip", Boolean.valueOf(fg6.q(iG)));
        }
        walletActivity.O1(str, fi6.e(jSONObject));
    }
}
