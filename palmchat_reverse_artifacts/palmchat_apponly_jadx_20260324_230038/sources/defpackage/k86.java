package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.huawei.openalliance.ad.constant.x;
import com.lantern.auth.server.WkParams;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.media.MediaMonitor;
import com.zenmen.palmchat.privinfo.PrivInfoManager;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.me3;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class k86 {
    public static String A() {
        return a("teenagers_mode");
    }

    public static String B() {
        return a("upload_contact_dialog_show_time");
    }

    public static int C() {
        try {
            return c.b().getPackageManager().getPackageInfo(c.b().getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean D() {
        return tg4.b(c.b(), BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList);
    }

    public static boolean E(Context context) {
        boolean z = !c.a().isBackground();
        LogUtil.i("Utility", "isAppForeground = " + z);
        return z;
    }

    public static boolean F(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 134217728) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean G() {
        String language;
        Locale locale = c.b().getResources().getConfiguration().locale;
        return locale == null || (language = locale.getLanguage()) == null || language.endsWith("zh");
    }

    public static boolean H(String str) {
        return (str == null || TextUtils.isEmpty(Uri.parse(str).getQueryParameter("token"))) ? false : true;
    }

    public static boolean I(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.canRead() && file.length() > 0;
    }

    public static boolean J(String str) {
        return (str == null || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
    }

    public static boolean K(double d, double d2) {
        return d >= -90.0d && d <= 90.0d && d2 >= -180.0d && d2 <= 180.0d;
    }

    public static boolean L(LocationEx locationEx) {
        if (locationEx == null) {
            return false;
        }
        return K(locationEx.getLatitude(), locationEx.getLongitude());
    }

    public static boolean M() {
        LogUtil.d(SharePluginInfo.ISSUE_MEMORY, "total memory:" + Runtime.getRuntime().totalMemory());
        LogUtil.d(SharePluginInfo.ISSUE_MEMORY, "total memory:" + Runtime.getRuntime().maxMemory());
        return ((double) (((float) (Runtime.getRuntime().totalMemory() / Runtime.getRuntime().maxMemory())) * 1.0f)) > 0.6d;
    }

    public static boolean N(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String O(String str) {
        if (str == null || str.length() <= 8) {
            return str;
        }
        int length = str.length();
        return str.substring(0, length - 8) + "****" + str.substring(length - 4, length);
    }

    public static boolean P(Context context, String str) {
        try {
            String str2 = BaseConstants.MARKET_PREFIX + str;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str2));
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String Q(String str) {
        return !TextUtils.isEmpty(str) ? str.replace("\n", "<br>") : str;
    }

    public static String R(String str) {
        return S(str, false);
    }

    public static String S(String str, boolean z) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Uri uri = Uri.parse(str);
                if (uri.getQueryParameter("mid") != null || ((uri.getPath() != null && uri.getPath().contains("feed-media")) || (uri.getPath() != null && uri.getPath().contains("/mdc/res/")))) {
                    me3.a aVarD = me3.d(str);
                    if (aVarD.a()) {
                        uri = Uri.parse(aVarD.b);
                    }
                    Uri.Builder builderBuildUpon = uri.buildUpon();
                    String strE = v4.e(c.b());
                    if (!TextUtils.isEmpty(strE)) {
                        builderBuildUpon.appendQueryParameter(DeviceInfoUtil.UID_TAG, strE);
                    }
                    String strC = v4.c(c.b());
                    if (!TextUtils.isEmpty(strC)) {
                        builderBuildUpon.appendQueryParameter(WkParams.SESSIONID, strC);
                    }
                    builderBuildUpon.appendQueryParameter("deviceId", ac1.h);
                    String strA = om1.a();
                    if (!TextUtils.isEmpty(strA)) {
                        builderBuildUpon.appendQueryParameter("token", strA);
                    }
                    builderBuildUpon.appendQueryParameter("requestId", xn3.a());
                    String strC2 = om1.c(aVarD.f19200a);
                    if (!TextUtils.isEmpty(strC2)) {
                        builderBuildUpon.appendQueryParameter("resToken", strC2);
                    }
                    if (z && MediaMonitor.a().c(str)) {
                        builderBuildUpon.appendQueryParameter("local", "1");
                    }
                    str = builderBuildUpon.build().toString();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        LogUtil.i("resUrlAppendUidAndRequestId", "resurl =" + str);
        return str;
    }

    public static void T(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.log4ClientError("safeRegisterReceiver", e);
        }
    }

    public static void U(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.log4ClientError("safeUnRegisterReceiver", e);
        }
    }

    public static void V(Activity activity, String str, List<String> list, int i) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder(list.get(0));
        for (int i2 = 1; i2 < list.size(); i2++) {
            sb.append(x.aQ);
            sb.append(list.get(i2));
        }
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + ((Object) sb)));
        intent.putExtra("sms_body", str);
        activity.startActivityForResult(intent, i);
    }

    public static void W(Context context, String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(x.aQ);
            sb.append(list.get(i));
        }
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + ((Object) sb)));
        intent.putExtra("sms_body", str);
        context.startActivity(intent);
    }

    public static void X(Intent intent) {
        intent.addFlags(335544320);
    }

    public static void Y(Intent intent) {
        intent.addFlags(872415232);
    }

    public static String Z(String str) throws UnsupportedEncodingException {
        return a0(str, xn3.a());
    }

    public static String a(String str) {
        return v4.e(c.b()) + str;
    }

    public static String a0(String str, String str2) throws UnsupportedEncodingException {
        return c0(str, str2, v4.e(c.b()), v4.c(c.b()));
    }

    public static String b(String str) {
        return Long.toString(Long.parseLong(str) + 3154131, 36);
    }

    public static String b0(String str, String str2, String str3) throws UnsupportedEncodingException {
        return d0(str, xn3.a(), str2, om1.b(str2), str3);
    }

    public static String c(HashMap<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static String c0(String str, String str2, String str3, String str4) throws UnsupportedEncodingException {
        return d0(str, str2, str3, om1.a(), str4);
    }

    public static HttpURLConnection d(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
    }

    public static String d0(String str, String str2, String str3, String str4, String str5) throws UnsupportedEncodingException {
        Uri uri = Uri.parse(str);
        Uri.Builder builderBuildUpon = uri.buildUpon();
        if (!TextUtils.isEmpty(str3)) {
            builderBuildUpon.appendQueryParameter(DeviceInfoUtil.UID_TAG, str3);
        }
        String queryParameter = uri.getQueryParameter("token");
        if (queryParameter == null && !TextUtils.isEmpty(str4)) {
            builderBuildUpon.appendQueryParameter("token", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            builderBuildUpon.appendQueryParameter(WkParams.SESSIONID, str5);
        }
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(uri.getQueryParameter("requestId"))) {
            builderBuildUpon.appendQueryParameter("requestId", str2);
        }
        String strB = v4.b(c.b());
        if (!TextUtils.isEmpty(strB)) {
            builderBuildUpon.appendQueryParameter(bd.h, strB);
        }
        builderBuildUpon.appendQueryParameter("deviceId", ac1.h);
        String string = builderBuildUpon.build().toString();
        LogUtil.i("urlAppendCommonInfo", "urlAppendCommonInfo = " + string + " customToken=" + queryParameter);
        return string;
    }

    public static int e(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String e0(String str, String str2, String str3, String str4) throws UnsupportedEncodingException {
        String strA = xn3.a();
        String strE = v4.e(c.b());
        String strC = v4.c(c.b());
        String strA2 = om1.a();
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        if (!TextUtils.isEmpty(strE)) {
            builderBuildUpon.appendQueryParameter(DeviceInfoUtil.UID_TAG, strE);
        }
        if (!TextUtils.isEmpty(strA2)) {
            builderBuildUpon.appendQueryParameter("token", strA2);
        }
        if (!TextUtils.isEmpty(strC)) {
            builderBuildUpon.appendQueryParameter(WkParams.SESSIONID, strC);
        }
        if (!TextUtils.isEmpty(strA)) {
            builderBuildUpon.appendQueryParameter("requestId", strA);
        }
        builderBuildUpon.appendQueryParameter("deviceId", ac1.h);
        if (!TextUtils.isEmpty(str2)) {
            builderBuildUpon.appendQueryParameter("callbackId", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            builderBuildUpon.appendQueryParameter("pId", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            builderBuildUpon.appendQueryParameter("sysUid", str4);
        }
        String string = builderBuildUpon.build().toString();
        LogUtil.i("urlAppendCommonInfo", "urlAppendCommonInfo = " + string);
        return string;
    }

    public static byte[] f(byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(om1.e().getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(om1.d().getBytes()));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String f0(String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            builderBuildUpon.appendQueryParameter(str2, str3);
        }
        return builderBuildUpon.build().toString();
    }

    public static double g(double d, int i) {
        return new BigDecimal(d).setScale(i, RoundingMode.HALF_UP).doubleValue();
    }

    public static String g0(String str, String str2) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        if (!TextUtils.isEmpty(str2)) {
            builderBuildUpon.appendQueryParameter("token", str2);
        }
        return builderBuildUpon.build().toString();
    }

    public static String h(String str) {
        try {
            return URLDecoder.decode(Uri.fromFile(new File(str)).toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String i(String str) {
        return u() + "." + str;
    }

    public static String j(String str) {
        try {
            return Z(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String k() {
        return a("contact_tab_count_new");
    }

    public static String l(int i) {
        return i >= 100 ? "⋯" : String.valueOf(i);
    }

    public static String m(Context context) {
        return PrivInfoManager.INSTANCE.getProcessName(context);
    }

    public static String n() {
        return a("new_enable_recommend_contact");
    }

    public static String o(ContentResolver contentResolver, Uri uri) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        if (uri == null) {
            return null;
        }
        if ("file".equals(uri.getScheme())) {
            return uri.getPath();
        }
        if ("content".equals(uri.getScheme())) {
            try {
                cursorQuery = contentResolver.query(uri, new String[]{"_data", "_display_name"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int columnIndex = uri.toString().startsWith("content://com.google.android.gallery3d") ? cursorQuery.getColumnIndex("_display_name") : cursorQuery.getColumnIndex("_data");
                            if (columnIndex != -1) {
                                String string = cursorQuery.getString(columnIndex);
                                cursorQuery.close();
                                return string;
                            }
                        }
                    } catch (SecurityException unused) {
                        if (cursorQuery != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SecurityException unused2) {
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return null;
    }

    public static String p(String str) {
        return (str == null || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("content://") || str.startsWith("file://")) ? str : h(str);
    }

    public static String q() {
        return a("last_contact_upload_time");
    }

    public static String r() {
        return a("local_contact_cache_json");
    }

    public static String s() {
        return a("mode");
    }

    public static String t() {
        return a("new_first_upload_contact_h5_dialog");
    }

    public static String u() {
        return c.c();
    }

    public static String v() {
        return a("get_post_background_api_time");
    }

    public static String w() {
        return a("privacy_config");
    }

    public static String x() {
        return a("get_suggest_contact_info_time");
    }

    public static long y(String str) {
        if (str != null) {
            try {
                return (Long.parseLong(str) >> 14) + 1288834974657L;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static int z(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
