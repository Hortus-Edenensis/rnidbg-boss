package com.kwad.sdk.core.network;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public final class p {
    private static String aJV = "";
    private static String aJW = "";

    public static String Jt() {
        try {
            if (!TextUtils.isEmpty(aJV)) {
                return aJV;
            }
            String property = System.getProperty("http.agent");
            aJV = property;
            if (TextUtils.isEmpty(property)) {
                return aJV;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = aJV.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = aJV.charAt(i);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                } else {
                    stringBuffer.append(cCharAt);
                }
            }
            String string = stringBuffer.toString();
            aJV = string;
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String Ju() {
        String strDj;
        if (!TextUtils.isEmpty(aJW)) {
            return aJW;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        try {
            strDj = ag.dj(context);
            aJW = strDj;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(strDj)) {
            return aJW;
        }
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        aJW = defaultUserAgent;
        String strEncode = URLEncoder.encode(defaultUserAgent, "UTF-8");
        aJW = strEncode;
        ag.an(context, strEncode);
        return aJW;
    }

    public static void b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", Ju());
        httpURLConnection.setRequestProperty("SystemUa", Jt());
    }

    private static String getDefaultUserAgent() {
        return Jt() + "-ksad-android-4.9.20.1";
    }

    public static String getUserAgent() {
        String userAgent = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getUserAgent();
        return TextUtils.isEmpty(userAgent) ? getDefaultUserAgent() : userAgent;
    }
}
