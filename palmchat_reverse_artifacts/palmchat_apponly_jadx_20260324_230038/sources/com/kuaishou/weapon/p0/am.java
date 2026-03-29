package com.kuaishou.weapon.p0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7392a = "tun";
    private static final String b = "ppp";
    private static int c;

    public static boolean a(Context context) {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
                if (networkCapabilities.hasTransport(4)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String b(Context context) {
        JSONArray jSONArrayA;
        try {
            jSONArrayA = a();
        } catch (Throwable unused) {
        }
        return jSONArrayA != null ? jSONArrayA.toString() : a(context) ? "[\"con\"]" : "";
    }

    public static int c() {
        return c;
    }

    public static String d() {
        StringBuilder sb = new StringBuilder();
        try {
            c = 0;
            KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
            if (keyStore != null) {
                keyStore.load(null, null);
                Enumeration<String> enumerationAliases = keyStore.aliases();
                while (enumerationAliases.hasMoreElements()) {
                    c++;
                    X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(enumerationAliases.nextElement());
                    if (x509Certificate.getIssuerDN().getName().contains("2022") || x509Certificate.getIssuerDN().getName().contains("2023") || x509Certificate.getIssuerDN().getName().contains("HttpCanary") || x509Certificate.getIssuerDN().getName().contains("macbook") || x509Certificate.getIssuerDN().getName().contains("proxy") || x509Certificate.getIssuerDN().getName().contains("Proxy") || x509Certificate.getIssuerDN().getName().contains("local") || x509Certificate.getIssuerDN().getName().contains("github")) {
                        sb.append(x509Certificate.getIssuerDN().getName());
                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                    }
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static String b() {
        String property = System.getProperty("http.proxyHost");
        return TextUtils.isEmpty(property) ? "" : property;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(6:44|3|42|4|40|5)|(5:6|(2:8|(4:48|12|51|49)(2:50|49))(1:46)|34|19|31)|13|(2:16|14)|38|18|34|19|31|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONArray a() {
        BufferedReader bufferedReader;
        DataInputStream dataInputStream;
        HashSet hashSet;
        JSONArray jSONArray = new JSONArray();
        DataInputStream dataInputStream2 = null;
        try {
            dataInputStream = new DataInputStream(Runtime.getRuntime().exec("cat /proc/net/route").getInputStream());
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                try {
                    hashSet = new HashSet();
                } catch (Throwable unused) {
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (bufferedReader != null) {
                    }
                    return jSONArray;
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            String strA = bo.a(line);
            if (strA.contains(f7392a) || strA.contains(b)) {
                hashSet.add(strA.split("\t")[0]);
            }
            bufferedReader.close();
            return jSONArray;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        dataInputStream.close();
        bufferedReader.close();
        return jSONArray;
    }
}
