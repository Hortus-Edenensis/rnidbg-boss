package com.bytedance.sdk.openadsdk.core.m;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.k;
import com.qq.gdt.action.ActionUtils;
import com.wifi.adsdk.download.LxAdDLManager;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    private final com.bytedance.sdk.openadsdk.core.m.nr nr;
    private final Context u;
    private boolean fx = false;
    private int b = 0;
    private int pn = -3;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        private static volatile nr pn;
        private boolean b;
        private ConnectivityManager.NetworkCallback fx;
        private Handler iz;
        private Network nr;
        private ConnectivityManager u;
        private final Runnable x = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.m.n.nr.2
            @Override // java.lang.Runnable
            public void run() {
                nr.this.u();
            }
        };

        private nr(Context context) {
            try {
                this.u = (ConnectivityManager) context.getSystemService("connectivity");
                this.iz = new Handler(Looper.getMainLooper());
            } catch (Exception unused) {
            }
        }

        public static nr u(Context context) {
            if (pn == null) {
                synchronized (nr.class) {
                    if (pn == null) {
                        pn = new nr(context);
                    }
                }
            }
            return pn;
        }

        @TargetApi(21)
        public void u(final ConnectivityManager.NetworkCallback networkCallback) {
            NetworkInfo networkInfo;
            this.iz.removeCallbacks(this.x);
            ConnectivityManager connectivityManager = this.u;
            if (connectivityManager == null) {
                return;
            }
            Network network = this.nr;
            if (network != null && !this.b && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
                networkCallback.onAvailable(this.nr);
                return;
            }
            ConnectivityManager.NetworkCallback networkCallback2 = this.fx;
            if (networkCallback2 != null) {
                try {
                    this.u.unregisterNetworkCallback(networkCallback2);
                } catch (Exception unused) {
                    this.fx = null;
                }
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            ConnectivityManager.NetworkCallback networkCallback3 = new ConnectivityManager.NetworkCallback() { // from class: com.bytedance.sdk.openadsdk.core.m.n.nr.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network2) {
                    try {
                        if (nr.this.u.getNetworkCapabilities(network2).hasTransport(0)) {
                            nr.this.nr = network2;
                            networkCallback.onAvailable(network2);
                            nr.this.b = false;
                        } else {
                            nr.this.nr = null;
                            networkCallback.onAvailable(null);
                            nr.this.b = true;
                        }
                    } catch (Exception unused2) {
                        networkCallback.onAvailable(null);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network2) {
                    nr.this.b = true;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onUnavailable() {
                    super.onUnavailable();
                    if (Build.VERSION.SDK_INT >= 26) {
                        networkCallback.onUnavailable();
                    }
                }
            };
            this.fx = networkCallback3;
            if (Build.VERSION.SDK_INT >= 26) {
                this.u.requestNetwork(networkRequestBuild, networkCallback3, 5000);
            } else {
                this.u.requestNetwork(networkRequestBuild, networkCallback3);
            }
        }

        public void u(long j) {
            this.iz.postDelayed(this.x, j);
        }

        public void u() {
            ConnectivityManager connectivityManager = this.u;
            if (connectivityManager == null) {
                return;
            }
            try {
                ConnectivityManager.NetworkCallback networkCallback = this.fx;
                if (networkCallback == null) {
                    return;
                }
                connectivityManager.unregisterNetworkCallback(networkCallback);
                this.fx = null;
                this.nr = null;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        public static String u(int i) {
            switch (i) {
                case 200:
                    return "200_但取号失败";
                case 102101:
                    return "无网络状态";
                case 102102:
                    return "网络异常";
                case 102103:
                    return "预取号只开WiFi";
                case 102203:
                    return "输入参数错误";
                case 102204:
                    return "崩溃错误";
                case 102508:
                    return "数据网络切换失败";
                case 200010:
                    return "imsi获取失败或者没有sim卡，预取号失败";
                case 200050:
                    return "EOF异常";
                default:
                    return "wifi取号失败....";
            }
        }
    }

    public n(Context context, com.bytedance.sdk.openadsdk.core.m.nr nrVar) {
        this.u = context;
        this.nr = nrVar;
    }

    public void u(String str, b bVar) {
        if (bVar == null) {
            return;
        }
        boolean zU = iz.u(this.u);
        this.b = iz.u(this.u, zU);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("headers");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("params");
            Map<String, List<String>> mapU = u(jSONObjectOptJSONObject);
            String upperCase = jSONObject.optString(ActionUtils.METHOD).toUpperCase();
            String strOptString = jSONObject.optString("url");
            this.nr.u(ActionUtils.METHOD, upperCase);
            this.nr.u("url", strOptString);
            this.pn = jSONObject.optInt("operType");
            try {
                if (u(zU, this.nr, bVar)) {
                    if (this.fx) {
                        u(mapU, jSONObjectOptJSONObject2, bVar);
                    } else {
                        u(null, mapU, jSONObjectOptJSONObject2, bVar);
                    }
                }
            } catch (Throwable unused) {
                bVar.u(false, this.b, 102204, u.u(102204), null, null);
            }
        } catch (JSONException unused2) {
            bVar.u(false, this.b, 102203, u.u(102203), null, null);
        }
    }

    private Map<String, List<String>> u(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next);
                List list = (List) map.get(next);
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(strOptString);
                    map.put(next, arrayList);
                } else {
                    list.add(strOptString);
                }
            }
        } catch (Exception unused) {
        }
        return map;
    }

    private boolean u(boolean z, com.bytedance.sdk.openadsdk.core.m.nr nrVar, b bVar) {
        nrVar.u("networktype", this.b);
        String packageName = this.u.getPackageName();
        String strU = fx.u(pn.u(this.u, packageName));
        nrVar.u("apppackage", packageName);
        nrVar.u("appsign", strU);
        int i = this.b;
        if (i == 3) {
            this.fx = true;
        }
        if (!z) {
            bVar.u(false, i, 200010, u.u(200010), null, null);
            return false;
        }
        if (i == 0) {
            bVar.u(false, i, 102101, u.u(102101), null, null);
            return false;
        }
        if (i != 2) {
            return true;
        }
        bVar.u(false, i, 102103, u.u(102103), null, null);
        return false;
    }

    @TargetApi(21)
    private void u(final Map<String, List<String>> map, final JSONObject jSONObject, final b bVar) {
        final nr nrVarU = nr.u(this.u);
        nr.u(this.u).u(new ConnectivityManager.NetworkCallback() { // from class: com.bytedance.sdk.openadsdk.core.m.n.1
            private final AtomicBoolean iz = new AtomicBoolean(false);

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) throws Throwable {
                if (this.iz.getAndSet(true) || network == null) {
                    return;
                }
                n.this.u(network, map, jSONObject, bVar);
                nrVarU.u(1000L);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                bVar.u(false, n.this.b, 102508, u.u(102508), null, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Network network, Map<String, List<String>> map, JSONObject jSONObject, b bVar) throws Throwable {
        String strU = this.nr.u("url");
        String strU2 = this.nr.u(ActionUtils.METHOD);
        a aVar = new a(strU, strU2, map, jSONObject);
        aVar.u(this.nr.u("apppackage"));
        aVar.nr(this.nr.u("appsign"));
        if ("get".equalsIgnoreCase(strU2)) {
            aVar.u("Content-Type", "application/x-www-form-urlencoded");
        }
        try {
            com.bytedance.sdk.openadsdk.core.m.u.u.u(aVar, this.nr.nr("networktype"), this.nr.u("apppackage"), this.pn);
            u(network, aVar, bVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x020a  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.bytedance.sdk.openadsdk.core.m.n] */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.bytedance.sdk.openadsdk.core.m.b] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(Network network, a aVar, b bVar) throws Throwable {
        StringBuilder sb;
        InputStream inputStream;
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        OutputStream outputStream3;
        int i;
        int responseCode;
        ?? r11;
        ?? r112;
        HttpsURLConnection httpsURLConnection2;
        SystemClock.elapsedRealtime();
        boolean z = false;
        try {
            URL url = new URL(aVar.nr());
            if (network != null) {
                httpsURLConnection2 = (HttpsURLConnection) network.openConnection(url);
            } else {
                httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
            }
            httpsURLConnection = httpsURLConnection2;
        } catch (IOException e) {
            e = e;
            sb = null;
            inputStream = null;
            httpsURLConnection = null;
            outputStream = null;
        } catch (Throwable th) {
            th = th;
            sb = null;
            inputStream = null;
            httpsURLConnection = null;
            outputStream = null;
        }
        try {
            Map<String, List<String>> mapU = aVar.u();
            if (mapU != null) {
                for (String str : mapU.keySet()) {
                    List<String> list = mapU.get(str);
                    if (list != null) {
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            httpsURLConnection.addRequestProperty(str, it.next());
                        }
                    }
                }
            }
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setInstanceFollowRedirects(false);
            httpsURLConnection.setConnectTimeout(5000);
            httpsURLConnection.setReadTimeout(5000);
            httpsURLConnection.setDefaultUseCaches(false);
            httpsURLConnection.setRequestMethod(aVar.b());
            if (aVar.b().equalsIgnoreCase("post")) {
                aVar.fx();
                httpsURLConnection.setDoOutput(true);
                outputStream = httpsURLConnection.getOutputStream();
                try {
                    outputStream.write(aVar.fx().getBytes("utf-8"));
                    outputStream.flush();
                } catch (IOException e2) {
                    e = e2;
                    sb = null;
                    inputStream = null;
                    outputStream3 = null;
                    responseCode = -1;
                    r112 = outputStream3;
                    try {
                        k.nr("transmit_business", "doRealTransmitRequest e: " + e.toString());
                        if (e instanceof EOFException) {
                        }
                        u(outputStream);
                        u(inputStream);
                        if (httpsURLConnection != null) {
                        }
                        bVar.u(false, this.b, i, TextUtils.isEmpty(null) ? u.u(i) : null, r112, TextUtils.isEmpty(sb) ? "" : sb.toString());
                    } catch (Throwable th2) {
                        th = th2;
                        i = responseCode;
                        r11 = r112;
                        u(outputStream);
                        u(inputStream);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        bVar.u(false, this.b, i, TextUtils.isEmpty(null) ? u.u(i) : null, r11, TextUtils.isEmpty(sb) ? "" : sb.toString());
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    sb = null;
                    inputStream = null;
                    outputStream2 = null;
                    i = -1;
                    r11 = outputStream2;
                    u(outputStream);
                    u(inputStream);
                    if (httpsURLConnection != null) {
                    }
                    bVar.u(false, this.b, i, TextUtils.isEmpty(null) ? u.u(i) : null, r11, TextUtils.isEmpty(sb) ? "" : sb.toString());
                    throw th;
                }
            } else {
                outputStream = null;
            }
            responseCode = httpsURLConnection.getResponseCode();
            try {
                Map<String, List<String>> headerFields = httpsURLConnection.getHeaderFields();
                try {
                    inputStream = httpsURLConnection.getInputStream();
                    try {
                        byte[] bArr = new byte[2048];
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            try {
                                try {
                                    int i2 = inputStream.read(bArr);
                                    if (i2 <= 0) {
                                        break;
                                    } else {
                                        sb2.append(new String(bArr, 0, i2, "utf-8"));
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    sb = sb2;
                                    r112 = headerFields;
                                    k.nr("transmit_business", "doRealTransmitRequest e: " + e.toString());
                                    int i3 = e instanceof EOFException ? 200050 : 102102;
                                    u(outputStream);
                                    u(inputStream);
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    bVar.u(false, this.b, i3, TextUtils.isEmpty(null) ? u.u(i3) : null, r112, TextUtils.isEmpty(sb) ? "" : sb.toString());
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                sb = sb2;
                                i = responseCode;
                                r11 = headerFields;
                                u(outputStream);
                                u(inputStream);
                                if (httpsURLConnection != null) {
                                }
                                bVar.u(false, this.b, i, TextUtils.isEmpty(null) ? u.u(i) : null, r11, TextUtils.isEmpty(sb) ? "" : sb.toString());
                                throw th;
                            }
                        }
                        String string = sb2.toString();
                        if (!TextUtils.isEmpty(string)) {
                            if (!string.contains("getNewUnicomPhone") && !string.contains("getTelecomPhone")) {
                                try {
                                    JSONObject jSONObject = new JSONObject(sb2.toString());
                                    String string2 = jSONObject.getString("resultCode");
                                    if (string2 == null || !string2.equals("103000")) {
                                        string = jSONObject.getString(LxAdDLManager.ITEM_DESC);
                                    } else {
                                        string = "取号成功";
                                        z = true;
                                    }
                                } catch (Exception unused) {
                                }
                            } else if ((string.contains("\"result\":0") || string.contains("\"result\":\"0\"")) && string.contains("\"data\":")) {
                                string = "取号成功";
                                z = true;
                            } else {
                                string = string.contains("getNewUnicomPhone") ? "联通取号失败" : "电信取号失败";
                            }
                        }
                        u(outputStream);
                        u(inputStream);
                        httpsURLConnection.disconnect();
                        bVar.u(z, this.b, responseCode, TextUtils.isEmpty(string) ? u.u(responseCode) : string, headerFields, TextUtils.isEmpty(sb2) ? "" : sb2.toString());
                    } catch (IOException e4) {
                        e = e4;
                        sb = null;
                    } catch (Throwable th5) {
                        th = th5;
                        sb = null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    sb = null;
                    inputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    sb = null;
                    inputStream = null;
                }
            } catch (IOException e6) {
                e = e6;
                sb = null;
                inputStream = null;
                r112 = 0;
            } catch (Throwable th7) {
                th = th7;
                sb = null;
                inputStream = null;
                r112 = 0;
                i = responseCode;
                r11 = r112;
                u(outputStream);
                u(inputStream);
                if (httpsURLConnection != null) {
                }
                bVar.u(false, this.b, i, TextUtils.isEmpty(null) ? u.u(i) : null, r11, TextUtils.isEmpty(sb) ? "" : sb.toString());
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            sb = null;
            inputStream = null;
            outputStream = null;
            outputStream3 = outputStream;
            responseCode = -1;
            r112 = outputStream3;
            k.nr("transmit_business", "doRealTransmitRequest e: " + e.toString());
            if (e instanceof EOFException) {
            }
            u(outputStream);
            u(inputStream);
            if (httpsURLConnection != null) {
            }
            bVar.u(false, this.b, i3, TextUtils.isEmpty(null) ? u.u(i3) : null, r112, TextUtils.isEmpty(sb) ? "" : sb.toString());
        } catch (Throwable th8) {
            th = th8;
            sb = null;
            inputStream = null;
            outputStream = null;
            outputStream2 = outputStream;
            i = -1;
            r11 = outputStream2;
            u(outputStream);
            u(inputStream);
            if (httpsURLConnection != null) {
            }
            bVar.u(false, this.b, i, TextUtils.isEmpty(null) ? u.u(i) : null, r11, TextUtils.isEmpty(sb) ? "" : sb.toString());
            throw th;
        }
    }

    private void u(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
