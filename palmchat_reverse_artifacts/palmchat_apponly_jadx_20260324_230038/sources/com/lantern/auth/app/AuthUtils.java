package com.lantern.auth.app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.text.TextUtils;
import com.lantern.auth.app.WkConstants;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.http.HttpPostManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AuthUtils {
    public static List<String> loacalHost;

    public static boolean canCallLocalJSAPI(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (loacalHost == null) {
                loacalHost = getAllHost();
            }
            String host = Uri.parse(str).getHost();
            BLLog.d("net host is " + host, new Object[0]);
            for (String str2 : loacalHost) {
                BLLog.d("validHost " + str2, new Object[0]);
                if (str2.equals(host)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> getAllHost() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Uri.parse(WkConstants.ServerConsts.getHost()).getHost());
        return arrayList;
    }

    public static void getAuthCode(String str, String str2, BLCallback bLCallback, String str3) {
        HashMap<String, String> publicParams = WkSDKManager.getSign().getPublicParams();
        publicParams.put("ak", str);
        publicParams.put("thirdAppId", str2);
        if (!TextUtils.isEmpty(str3)) {
            publicParams.put("srcReq", str3);
        }
        HttpPostManager.postMap(publicParams, bLCallback, WkConstants.ServerConsts.getUrl(WkConstants.ServerConsts.URL_GET_AUTH_CODE));
    }

    public static boolean isMobileDataOpen(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
