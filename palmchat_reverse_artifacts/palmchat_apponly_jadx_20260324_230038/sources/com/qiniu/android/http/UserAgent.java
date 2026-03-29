package com.qiniu.android.http;

import com.qiniu.android.common.Constants;
import com.qiniu.android.utils.Utils;
import java.nio.charset.Charset;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class UserAgent {
    private static UserAgent _instance = new UserAgent();
    public final String id;
    public final String ua;

    private UserAgent() {
        String strGenId = genId();
        this.id = strGenId;
        this.ua = getUserAgent(strGenId);
    }

    private static String genId() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    public static String getUserAgent(String str) {
        return String.format("QiniuAndroid%s/%s (%s; %s; %s", Utils.isDebug() ? "_Debug" : "", Constants.VERSION, Utils.systemVersion(), Utils.systemName(), str);
    }

    public static UserAgent instance() {
        return _instance;
    }

    public String getUa(String str) {
        String strTrim = ("" + str).trim();
        if (strTrim.length() > 15) {
            strTrim = strTrim.substring(0, Math.min(16, strTrim.length()));
        }
        return new String((this.ua + "; " + strTrim + ")").getBytes(Charset.forName("ISO-8859-1")));
    }
}
