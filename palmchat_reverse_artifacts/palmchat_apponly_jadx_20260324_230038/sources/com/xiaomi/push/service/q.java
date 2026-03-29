package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.lantern.auth.server.WkParams;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.BuildConfig;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static p f11768a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static a f1006a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized p m765a(Context context) {
        p pVar = f11768a;
        if (pVar != null) {
            return pVar;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
        String string = sharedPreferences.getString(Constant.MAP_KEY_UUID, null);
        String string2 = sharedPreferences.getString("token", null);
        String string3 = sharedPreferences.getString("security", null);
        String string4 = sharedPreferences.getString("app_id", null);
        String string5 = sharedPreferences.getString("app_token", null);
        String string6 = sharedPreferences.getString("package_name", null);
        String string7 = sharedPreferences.getString("device_id", null);
        int i = sharedPreferences.getInt("env_type", 1);
        if (!TextUtils.isEmpty(string7) && com.xiaomi.push.i.a(string7)) {
            string7 = com.xiaomi.push.i.g(context);
            sharedPreferences.edit().putString("device_id", string7).commit();
        }
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
            return null;
        }
        String strG = com.xiaomi.push.i.g(context);
        if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(strG) && !TextUtils.isEmpty(string7) && !string7.equals(strG)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("read_phone_state permission changes.");
        }
        p pVar2 = new p(string, string2, string3, string4, string5, string6, i);
        f11768a = pVar2;
        return pVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d A[Catch: all -> 0x032c, TryCatch #6 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:16:0x0057, B:20:0x0063, B:24:0x006f, B:25:0x0079, B:31:0x008d, B:33:0x0096, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0131, B:49:0x013a, B:50:0x0171, B:52:0x0177, B:53:0x017e, B:56:0x018d, B:57:0x01be, B:59:0x01de, B:62:0x01e5, B:64:0x01fc, B:70:0x020b, B:76:0x0229, B:78:0x022f, B:99:0x02e6, B:105:0x0317, B:107:0x031d, B:108:0x0325, B:102:0x02fe, B:74:0x0212, B:28:0x0085), top: B:120:0x0005, inners: #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0 A[Catch: all -> 0x032c, TryCatch #6 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:16:0x0057, B:20:0x0063, B:24:0x006f, B:25:0x0079, B:31:0x008d, B:33:0x0096, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0131, B:49:0x013a, B:50:0x0171, B:52:0x0177, B:53:0x017e, B:56:0x018d, B:57:0x01be, B:59:0x01de, B:62:0x01e5, B:64:0x01fc, B:70:0x020b, B:76:0x0229, B:78:0x022f, B:99:0x02e6, B:105:0x0317, B:107:0x031d, B:108:0x0325, B:102:0x02fe, B:74:0x0212, B:28:0x0085), top: B:120:0x0005, inners: #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0131 A[Catch: all -> 0x032c, TryCatch #6 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:16:0x0057, B:20:0x0063, B:24:0x006f, B:25:0x0079, B:31:0x008d, B:33:0x0096, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0131, B:49:0x013a, B:50:0x0171, B:52:0x0177, B:53:0x017e, B:56:0x018d, B:57:0x01be, B:59:0x01de, B:62:0x01e5, B:64:0x01fc, B:70:0x020b, B:76:0x0229, B:78:0x022f, B:99:0x02e6, B:105:0x0317, B:107:0x031d, B:108:0x0325, B:102:0x02fe, B:74:0x0212, B:28:0x0085), top: B:120:0x0005, inners: #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0177 A[Catch: all -> 0x032c, TRY_LEAVE, TryCatch #6 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:16:0x0057, B:20:0x0063, B:24:0x006f, B:25:0x0079, B:31:0x008d, B:33:0x0096, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0131, B:49:0x013a, B:50:0x0171, B:52:0x0177, B:53:0x017e, B:56:0x018d, B:57:0x01be, B:59:0x01de, B:62:0x01e5, B:64:0x01fc, B:70:0x020b, B:76:0x0229, B:78:0x022f, B:99:0x02e6, B:105:0x0317, B:107:0x031d, B:108:0x0325, B:102:0x02fe, B:74:0x0212, B:28:0x0085), top: B:120:0x0005, inners: #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0206 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0208  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized p a(Context context, String str, String str2, String str3) {
        String strSubstring;
        String str4;
        PackageInfo packageInfo;
        int iA;
        boolean z;
        String strA;
        com.xiaomi.push.as asVarA;
        boolean z2;
        TreeMap treeMap = new TreeMap();
        treeMap.put("devid", com.xiaomi.push.i.a(context, false));
        p pVar = f11768a;
        if (pVar != null && !TextUtils.isEmpty(pVar.f1005a)) {
            treeMap.put(Constant.MAP_KEY_UUID, f11768a.f1005a);
            int iLastIndexOf = f11768a.f1005a.lastIndexOf("/");
            if (iLastIndexOf != -1) {
                strSubstring = f11768a.f1005a.substring(iLastIndexOf + 1);
            }
            com.xiaomi.push.an.a(context).a(treeMap);
            if (!m768a(context)) {
            }
            if (!m768a(context)) {
            }
            if (!m768a(context)) {
            }
            treeMap.put("appid", str);
            treeMap.put("apptoken", str);
            packageInfo = context.getPackageManager().getPackageInfo(str4, 16384);
            treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(BuildConfig.VERSION_CODE));
            treeMap.put("packagename", str4);
            treeMap.put(WkParams.MODEL, com.xiaomi.push.k.a());
            treeMap.put("board", Build.BOARD);
            if (!com.xiaomi.push.j.m656d()) {
            }
            treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            iA = com.xiaomi.push.i.a();
            if (iA >= 0) {
            }
            treeMap.put("brand", Build.BRAND + "");
            treeMap.put("ram", com.xiaomi.push.i.m638a());
            treeMap.put("rom", com.xiaomi.push.i.m643b());
            JSONObject jSONObject = new JSONObject();
            while (r9.hasNext()) {
            }
            String strA2 = av.a(jSONObject.toString());
            TreeMap treeMap2 = new TreeMap();
            treeMap2.put("requestData", strA2);
            treeMap2.put("keyPairVer", "1");
            if (a(context) < 2) {
                z = false;
                strA = a(context, z);
                if (!TextUtils.isEmpty(strA)) {
                }
            }
        } else {
            strSubstring = null;
            com.xiaomi.push.an.a(context).a(treeMap);
            String str5 = !m768a(context) ? "1000271" : str2;
            String str6 = !m768a(context) ? "420100086271" : str3;
            str4 = !m768a(context) ? "com.xiaomi.xmsf" : str;
            treeMap.put("appid", str5);
            treeMap.put("apptoken", str6);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str4, 16384);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                packageInfo = null;
            }
            treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(BuildConfig.VERSION_CODE));
            treeMap.put("packagename", str4);
            treeMap.put(WkParams.MODEL, com.xiaomi.push.k.a());
            treeMap.put("board", Build.BOARD);
            if (!com.xiaomi.push.j.m656d()) {
                String strC = com.xiaomi.push.i.c(context);
                String str7 = TextUtils.isEmpty(strC) ? "" : "" + com.xiaomi.push.bb.a(strC);
                String strE = com.xiaomi.push.i.e(context);
                if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(strE)) {
                    str7 = str7 + "," + strE;
                }
                if (!TextUtils.isEmpty(str7)) {
                    treeMap.put(Constants.EXTRA_KEY_IMEI_MD5, str7);
                }
            }
            treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            iA = com.xiaomi.push.i.a();
            if (iA >= 0) {
                treeMap.put("space_id", Integer.toString(iA));
            }
            treeMap.put("brand", Build.BRAND + "");
            treeMap.put("ram", com.xiaomi.push.i.m638a());
            treeMap.put("rom", com.xiaomi.push.i.m643b());
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry entry : treeMap.entrySet()) {
                try {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("failed to add data in json format: k=" + ((String) entry.getKey()) + ",v=" + ((String) entry.getValue()) + ". " + e2);
                }
            }
            String strA22 = av.a(jSONObject2.toString());
            TreeMap treeMap22 = new TreeMap();
            treeMap22.put("requestData", strA22);
            treeMap22.put("keyPairVer", "1");
            if (a(context) < 2 || TextUtils.isEmpty(strA22)) {
                z = false;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m74a("r.data = " + strA22);
                z = true;
            }
            strA = a(context, z);
            if (!TextUtils.isEmpty(strA)) {
                return null;
            }
            if (z) {
                treeMap = treeMap22;
            }
            try {
                asVarA = com.xiaomi.push.au.a(context, strA, treeMap);
            } catch (IOException e3) {
                com.xiaomi.channel.commonutils.logger.b.d("device registration request failed. " + e3);
                asVarA = null;
            }
            if (asVarA != null && asVarA.f11422a == 200) {
                String strA3 = asVarA.a();
                if (!TextUtils.isEmpty(strA3)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(strA3);
                        try {
                            if (jSONObject3.getInt("code") == 0) {
                                JSONObject jSONObject4 = jSONObject3.getJSONObject("data");
                                String string = jSONObject4.getString("ssecurity");
                                String string2 = jSONObject4.getString("token");
                                String string3 = jSONObject4.getString("userId");
                                if (TextUtils.isEmpty(strSubstring)) {
                                    strSubstring = "an" + com.xiaomi.push.bb.a(6);
                                }
                                p pVar2 = new p(string3 + "@xiaomi.com/" + strSubstring, string2, string, str5, str6, str4, com.xiaomi.push.x.a());
                                a(context, pVar2);
                                f11768a = pVar2;
                                a(context, 0);
                                com.xiaomi.channel.commonutils.logger.b.m74a("device registration is successful. " + string3);
                                return pVar2;
                            }
                            z2 = z;
                            t.a(context, jSONObject3.getInt("code"), jSONObject3.optString("description"));
                            com.xiaomi.channel.commonutils.logger.b.m74a("device registration resp: " + strA3);
                        } catch (JSONException e4) {
                            e = e4;
                            com.xiaomi.channel.commonutils.logger.b.d("failed to parse respone json data. " + e);
                        } catch (Throwable th) {
                            th = th;
                            com.xiaomi.channel.commonutils.logger.b.d("unknow throwable. " + th);
                        }
                    } catch (JSONException e5) {
                        e = e5;
                        z2 = z;
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = z;
                    }
                    com.xiaomi.channel.commonutils.logger.b.d("failed to parse respone json data. " + e);
                }
                if (z2) {
                    a(context, a(context) + 1);
                }
                com.xiaomi.channel.commonutils.logger.b.m74a("fail to register push account. meet error.");
                return null;
            }
            z2 = z;
            if (z2 && com.xiaomi.push.au.b(context)) {
                a(context, a(context) + 1);
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("fail to register push account. meet error.");
            return null;
        }
    }

    private static String a(Context context, boolean z) {
        String strA = b.a(context).a();
        String str = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (com.xiaomi.push.x.b()) {
            return "http://10.38.162.35:9085" + str;
        }
        if (!com.xiaomi.push.n.China.name().equals(strA)) {
            return null;
        }
        return "https://cn.register.xmpush.xiaomi.com" + str;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m768a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    private static void a(Context context, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_account", 0).edit();
        editorEdit.putInt("enc_req_fail_count", i);
        editorEdit.commit();
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    public static void a(Context context, p pVar) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_account", 0).edit();
        editorEdit.putString(Constant.MAP_KEY_UUID, pVar.f1005a);
        editorEdit.putString("security", pVar.c);
        editorEdit.putString("token", pVar.b);
        editorEdit.putString("app_id", pVar.d);
        editorEdit.putString("package_name", pVar.f);
        editorEdit.putString("app_token", pVar.e);
        editorEdit.putString("device_id", com.xiaomi.push.i.g(context));
        editorEdit.putInt("env_type", pVar.f11767a);
        editorEdit.commit();
        a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m767a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f11768a = null;
        a();
    }

    public static void a(a aVar) {
        f1006a = aVar;
    }

    public static void a() {
        a aVar = f1006a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m766a(Context context) {
        p pVarM765a = m765a(context);
        if (pVarM765a != null && !TextUtils.isEmpty(pVarM765a.f1005a)) {
            String[] strArrSplit = pVarM765a.f1005a.split("@");
            if (strArrSplit.length > 0) {
                return strArrSplit[0];
            }
        }
        return null;
    }
}
