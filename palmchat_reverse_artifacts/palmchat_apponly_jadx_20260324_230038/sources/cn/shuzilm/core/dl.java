package cn.shuzilm.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.ProxyInfo;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.rtt.RangingRequest;
import android.net.wifi.rtt.RangingResult;
import android.net.wifi.rtt.RangingResultCallback;
import android.net.wifi.rtt.WifiRttManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.huawei.openalliance.ad.constant.x;
import defpackage.e97;
import defpackage.k97;
import defpackage.l97;
import defpackage.m97;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dl {
    private static Context b;
    private static NsdManager c;
    private static LinkedList d = new LinkedList();
    private static JSONObject e = new JSONObject();
    private static JSONObject f = null;
    private static Timer g = null;
    private static int h = 0;
    private static int i = 0;
    private static String j = "";
    private static String k = "";
    private static String l = "";
    private static int m = 0;
    private static String n = "";
    private static int o = 0;
    private static int p = -1;
    private static int q = -1;
    private static int r = -1;
    private static int s = -1;
    private static String t = null;
    private static String u = null;
    private static int v = 0;
    private static String w = "";
    private static final Object x = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f2467a = 0;

    /* JADX INFO: compiled from: SearchBox */
    class NsdDiscoverySubJson {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f2472a;
        int b;
        JSONObject c;

        public NsdDiscoverySubJson(String str, int i) {
            this.c = null;
            this.f2472a = str;
            this.b = i;
            if (i != 1) {
                this.c = new JSONObject();
            }
        }

        public void discoverySubType() {
            try {
                NsdManager.DiscoveryListener discoveryListener = new NsdManager.DiscoveryListener() { // from class: cn.shuzilm.core.dl.NsdDiscoverySubJson.1
                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
                        try {
                            String serviceName = nsdServiceInfo.getServiceName();
                            String serviceType = nsdServiceInfo.getServiceType();
                            if (NsdDiscoverySubJson.this.b == 1) {
                                dl.b(serviceName, serviceType);
                            }
                            NsdDiscoverySubJson nsdDiscoverySubJson = NsdDiscoverySubJson.this;
                            if (nsdDiscoverySubJson.b == 2) {
                                dl.b(nsdServiceInfo, serviceName, serviceType, nsdDiscoverySubJson.c);
                            }
                        } catch (Throwable unused) {
                        }
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onStartDiscoveryFailed(String str, int i) {
                        dl.b(dl.c, this);
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onStopDiscoveryFailed(String str, int i) {
                        dl.b(dl.c, this);
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onDiscoveryStarted(String str) {
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onDiscoveryStopped(String str) {
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
                    }
                };
                dl.c.discoverServices(this.f2472a, 1, discoveryListener);
                if (dl.g == null) {
                    Timer unused = dl.g = new Timer();
                }
                dl.g.schedule(new sd(dl.c, discoveryListener, this.b, this.f2472a, this.c), this.b == 2 ? 600 : 800);
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ResolveListenerAddress implements NsdManager.ResolveListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2474a;
        private String b;
        private JSONObject c;

        public ResolveListenerAddress(String str, String str2, JSONObject jSONObject) {
            this.f2474a = str;
            this.b = str2;
            this.c = jSONObject;
        }

        @Override // android.net.nsd.NsdManager.ResolveListener
        public void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i) {
            try {
                String strValueOf = String.valueOf(this.c.length());
                this.c.put(strValueOf, this.f2474a + ",f:" + i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.net.nsd.NsdManager.ResolveListener
        public void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
            try {
                this.f2474a += "," + nsdServiceInfo.getHost().getHostAddress() + ":" + nsdServiceInfo.getPort();
                this.c.put(String.valueOf(this.c.length()), this.f2474a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    class sd extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        NsdManager.DiscoveryListener f2475a;
        NsdManager b;
        int c;
        String d;
        JSONObject e;

        public sd(NsdManager nsdManager, NsdManager.DiscoveryListener discoveryListener, int i, String str, JSONObject jSONObject) {
            this.f2475a = discoveryListener;
            this.b = nsdManager;
            this.c = i;
            this.d = str;
            this.e = jSONObject;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String str;
            JSONObject jSONObject;
            try {
                dl.b(this.b, this.f2475a);
                if (this.c == 2 && (jSONObject = this.e) != null) {
                    int length = jSONObject.toString().length();
                    if (dl.e.toString().length() + length < 4096 && length > 5) {
                        dl.e.put(this.d, this.e);
                    }
                }
                if (dl.m <= 20 && dl.d != null && dl.d.size() > 0 && (str = (String) dl.d.poll()) != null) {
                    new NsdDiscoverySubJson(str, 2).discoverySubType();
                    dl.d();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static /* synthetic */ int d() {
        int i2 = m;
        m = i2 + 1;
        return i2;
    }

    public static synchronized void ia(Context context) {
        b = context;
        if (o == 0) {
            q = 0;
            n = "";
        }
        d(1);
        o++;
    }

    private static int m() {
        int iHashCode = (Build.DISPLAY + String.valueOf(new Random().nextInt())).hashCode() % 227;
        if (iHashCode < 0) {
            iHashCode = -iHashCode;
        }
        return iHashCode + 29;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o() {
        DUHelper.bm(b, e.toString());
    }

    private static String p() {
        ConnectivityManager connectivityManager;
        LinkProperties linkProperties;
        String strSubstring = "";
        try {
            if (Build.VERSION.SDK_INT < 23 || (linkProperties = (connectivityManager = (ConnectivityManager) b.getSystemService("connectivity")).getLinkProperties(connectivityManager.getActiveNetwork())) == null) {
                return "";
            }
            String interfaceName = linkProperties.getInterfaceName();
            if (interfaceName != null && interfaceName.contains("wlan")) {
                List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
                int size = linkAddresses.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String string = linkAddresses.get(i2).toString();
                    if (string != null && string.contains(".") && !string.contains(":")) {
                        strSubstring = string.substring(0, string.lastIndexOf(".") + 1);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
        int iB;
        int iM = m();
        try {
            if ((System.currentTimeMillis() / 1000) - (b.getPackageManager().getPackageInfo(b.getPackageName(), 0).lastUpdateTime / 1000) < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
                iM = 3;
            }
        } catch (Throwable unused) {
        }
        try {
            String strP = p();
            if ((strP == null || strP != "") && (iB = u.b(b)) != 0) {
                strP = (iB & 255) + "." + ((iB >> 8) & 255) + "." + ((iB >> 16) & 255) + ".";
            }
            if (strP == null || strP == "") {
                return;
            }
            if (strP.lastIndexOf(".") == strP.length() - 1) {
                for (int i2 = 1; i2 < iM; i2++) {
                    InetAddress.getByName(strP + String.valueOf(i2)).isReachable(60);
                }
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r() {
        int size;
        try {
            if (DUHelper.mPopu == 10001) {
                return -6;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 28) {
                return -1;
            }
            PackageManager packageManager = b.getPackageManager();
            String packageName = b.getPackageName();
            int iCheckPermission = packageManager.checkPermission(com.kuaishou.weapon.p0.g.g, packageName);
            int iCheckPermission2 = packageManager.checkPermission("android.permission.CHANGE_WIFI_STATE", packageName);
            int iCheckPermission3 = packageManager.checkPermission(com.kuaishou.weapon.p0.g.d, packageName);
            if (iCheckPermission == 0 && iCheckPermission2 == 0 && iCheckPermission3 == 0) {
                if (i2 > 32 && packageManager.checkPermission("android.permission.NEARBY_WIFI_DEVICES", packageName) != 0) {
                    return -2;
                }
                int maxPeers = RangingRequest.getMaxPeers();
                if (maxPeers <= 0) {
                    return -1;
                }
                if (maxPeers > 2) {
                    maxPeers--;
                }
                WifiRttManager wifiRttManagerA = e97.a(b.getSystemService("wifirtt"));
                if (!wifiRttManagerA.isAvailable() || !b.getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                    return -3;
                }
                WifiManager wifiManager = (WifiManager) b.getSystemService("wifi");
                if (wifiManager.getWifiState() != 3) {
                    return -3;
                }
                l97.a();
                RangingRequest.Builder builderA = k97.a();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (scanResults == null || (size = scanResults.size()) <= 0) {
                    return -4;
                }
                if (size < maxPeers) {
                    maxPeers = size;
                }
                for (int i3 = 0; i3 < maxPeers; i3++) {
                    builderA.addAccessPoint(scanResults.get(i3));
                }
                wifiRttManagerA.startRanging(builderA.build(), b.getMainExecutor(), new RangingResultCallback() { // from class: cn.shuzilm.core.dl.1
                    @Override // android.net.wifi.rtt.RangingResultCallback
                    public void onRangingFailure(int i4) {
                        try {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            dl.e.put("wr", jCurrentTimeMillis + ";err_" + i4 + x.aQ);
                        } catch (Exception unused) {
                        }
                    }

                    @Override // android.net.wifi.rtt.RangingResultCallback
                    public void onRangingResults(List list) {
                        if (list == null) {
                            return;
                        }
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append(System.currentTimeMillis() + x.aQ);
                            for (int i4 = 0; i4 < list.size(); i4++) {
                                RangingResult rangingResultA = m97.a(list.get(i4));
                                if (rangingResultA.getStatus() == 0) {
                                    try {
                                        Object objInvoke = rangingResultA.getClass().getMethod(dl.f("\\ZiBVX6YYgZhh"), new Class[0]).invoke(rangingResultA, new Object[0]);
                                        if (objInvoke != null) {
                                            sb.append(objInvoke.toString().replace(":", ""));
                                        }
                                    } catch (Throwable unused) {
                                    }
                                    sb.append(",");
                                    sb.append(rangingResultA.getDistanceMm() + "," + rangingResultA.getRssi());
                                    sb.append(x.aQ);
                                    if (sb.length() > 1024) {
                                        break;
                                    }
                                }
                            }
                            dl.e.put("wr", sb.toString());
                        } catch (Throwable unused2) {
                        }
                    }
                });
            }
            return -2;
        } catch (Throwable unused) {
        }
        return 0;
    }

    private static boolean s() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.getSystemService("connectivity");
            Method declaredMethod = Class.forName(connectivityManager.getClass().getName()).getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void t() {
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        boolean z;
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        TelephonyManager telephonyManager = (TelephonyManager) b.getSystemService("phone");
        String simOperator = telephonyManager.getSimOperator();
        if (simOperator == null) {
            simOperator = "";
        }
        try {
            if (telephonyManager.getSimState() == 5 && s()) {
                r = 0;
            } else {
                r = 1;
            }
        } catch (Exception unused) {
        }
        int iB = u.b(b);
        if (iB != 0) {
            s = 0;
        } else {
            s = 1;
        }
        try {
            connectivityManager = (ConnectivityManager) b.getSystemService("connectivity");
            activeNetwork = connectivityManager.getActiveNetwork();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (activeNetwork == null) {
            q = 1;
            t = "0";
            u = "0";
            DUHelper.c(b, 201, "0");
            DUHelper.c(b, 202, "0");
            return;
        }
        LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
        if (linkProperties == null) {
            return;
        }
        List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
        if (linkAddresses.isEmpty()) {
            q = 1;
        } else {
            StringBuilder sb = new StringBuilder();
            Iterator<LinkAddress> it = linkAddresses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String hostAddress = it.next().getAddress().getHostAddress();
                sb.append(hostAddress);
                if (!n.isEmpty() && n.contains(hostAddress)) {
                    q = 1;
                    z = true;
                    break;
                }
            }
            if (n.isEmpty()) {
                n = sb.toString();
                q = 0;
            }
            if (!z && !n.isEmpty()) {
                n = sb.toString();
                q = 0;
            }
        }
        ProxyInfo httpProxy = linkProperties.getHttpProxy();
        if (httpProxy == null || httpProxy.getHost() == null) {
            p = 1;
        } else {
            p = 0;
        }
        String interfaceName = linkProperties.getInterfaceName();
        if (interfaceName != null && !interfaceName.isEmpty() && (interfaceName.contains("tun") || interfaceName.contains("ppp"))) {
            p = 0;
        }
        if (!w.isEmpty() && (!w.equals(simOperator) || t == null)) {
            q = 0;
        }
        w = simOperator;
        int i2 = v;
        if (i2 != 0 && (i2 != iB || u == null)) {
            q = 0;
        }
        v = iB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String c(Network network, String str, int i2) {
        InputStream inputStream;
        String str2;
        URLConnection uRLConnectionOpenConnection;
        String str3 = null;
        InputStream inputStream2 = null;
        if (str != null) {
            if (!str.isEmpty()) {
                try {
                    uRLConnectionOpenConnection = network != null ? network.openConnection(new URL(str)) : (HttpURLConnection) new URL(str).openConnection();
                } catch (Throwable unused) {
                    inputStream = null;
                }
                try {
                    if (uRLConnectionOpenConnection == null) {
                        return null;
                    }
                    uRLConnectionOpenConnection.setConnectTimeout(5000);
                    uRLConnectionOpenConnection.setReadTimeout(5000);
                    uRLConnectionOpenConnection.setDoInput(true);
                    uRLConnectionOpenConnection.connect();
                    if (((HttpURLConnection) uRLConnectionOpenConnection).getResponseCode() == 200) {
                        inputStream = uRLConnectionOpenConnection.getInputStream();
                        try {
                            str2 = new String(u.a(inputStream));
                            inputStream2 = inputStream;
                        } catch (Throwable unused2) {
                            Log.e("shuzilm", "[20001] network connect error.");
                            if (inputStream != null) {
                            }
                            return str3;
                        }
                    } else {
                        str2 = null;
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    str3 = str2;
                    return str3;
                    Log.e("shuzilm", "[20001] network connect error.");
                    if (inputStream != null) {
                        str2 = null;
                        inputStream2 = inputStream;
                        inputStream2.close();
                        str3 = str2;
                    }
                    return str3;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str) {
        LinkedList linkedList;
        try {
            m = 0;
            l = f("TV^geaVn#TiXe#");
            JSONObject jSONObject = e;
            if (jSONObject != null && jSONObject.length() <= 0 && (linkedList = d) != null && linkedList.size() <= 0) {
                c = (NsdManager) b.getSystemService("servicediscovery");
                a("_service" + str + ".", 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            bytes[i2] = (byte) (bytes[i2] + 11);
        }
        return new String(bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Network network, String str, int i2) {
        InputStream inputStream;
        String str2;
        URLConnection uRLConnectionOpenConnection;
        synchronized (x) {
            String str3 = null;
            InputStream inputStream2 = null;
            if (str != null) {
                try {
                    if (!str.isEmpty()) {
                        try {
                            if (network != null) {
                                uRLConnectionOpenConnection = network.openConnection(new URL(str));
                            } else {
                                uRLConnectionOpenConnection = (HttpURLConnection) new URL(str).openConnection();
                            }
                        } catch (Throwable unused) {
                            inputStream = null;
                        }
                        try {
                            if (uRLConnectionOpenConnection == null) {
                                return null;
                            }
                            uRLConnectionOpenConnection.setConnectTimeout(5000);
                            uRLConnectionOpenConnection.setReadTimeout(5000);
                            uRLConnectionOpenConnection.setDoInput(true);
                            uRLConnectionOpenConnection.connect();
                            if (((HttpURLConnection) uRLConnectionOpenConnection).getResponseCode() == 200) {
                                inputStream = uRLConnectionOpenConnection.getInputStream();
                                try {
                                    str2 = new String(u.a(inputStream));
                                    inputStream2 = inputStream;
                                } catch (Throwable unused2) {
                                    Log.e("shuzilm", "[20007] network connect error.");
                                    if (inputStream != null) {
                                    }
                                    return str3;
                                }
                            } else {
                                str2 = null;
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception unused3) {
                                }
                            }
                            str3 = str2;
                            return str3;
                            Log.e("shuzilm", "[20007] network connect error.");
                            if (inputStream != null) {
                                str2 = null;
                                inputStream2 = inputStream;
                                inputStream2.close();
                                str3 = str2;
                            }
                            return str3;
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception unused4) {
                                }
                            }
                            throw th;
                        }
                    }
                } finally {
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(String str, String str2) {
        try {
            if (str2.contains(".")) {
                d.add(str + "." + str2.split("\\.")[0] + ".");
            }
        } catch (Throwable unused) {
        }
    }

    private static synchronized void a(String str, int i2) {
        new NsdDiscoverySubJson(str, 1).discoverySubType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(NsdServiceInfo nsdServiceInfo, String str, String str2, JSONObject jSONObject) {
        if (str != null) {
            if (!str.isEmpty() && nsdServiceInfo != null && jSONObject != null) {
                c.resolveService(nsdServiceInfo, new ResolveListenerAddress(str, str2, jSONObject));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(NsdManager nsdManager, NsdManager.DiscoveryListener discoveryListener) {
        try {
            nsdManager.stopServiceDiscovery(discoveryListener);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Network network) {
        List<LinkAddress> linkAddresses;
        if (network == null) {
            return;
        }
        try {
            LinkProperties linkProperties = ((ConnectivityManager) b.getSystemService("connectivity")).getLinkProperties(network);
            if (linkProperties == null || (linkAddresses = linkProperties.getLinkAddresses()) == null) {
                return;
            }
            Iterator<LinkAddress> it = linkAddresses.iterator();
            while (it.hasNext()) {
                String hostAddress = it.next().getAddress().getHostAddress();
                if (hostAddress != null && hostAddress.contains(":") && !hostAddress.startsWith("fe80")) {
                    DUHelper.c(b, 204, hostAddress);
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040 A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #6 {all -> 0x002d, blocks: (B:12:0x0024, B:14:0x0028, B:26:0x0040, B:19:0x0032, B:21:0x0036, B:24:0x003c, B:30:0x005e), top: B:85:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007e A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #2 {all -> 0x0076, blocks: (B:33:0x006d, B:35:0x0071, B:42:0x007e, B:47:0x00a8, B:49:0x00ac, B:53:0x00c8, B:52:0x00be, B:51:0x00ba, B:40:0x007a, B:46:0x009c), top: B:77:0x006d, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ef A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void c(final int i2) {
        ConnectivityManager.NetworkCallback networkCallback;
        ConnectivityManager.NetworkCallback networkCallback2;
        ConnectivityManager connectivityManager;
        if (Build.VERSION.SDK_INT >= 23 && q == 0) {
            ConnectivityManager connectivityManager2 = null;
            networkCallback = null;
            networkCallback = null;
            ConnectivityManager.NetworkCallback networkCallback3 = null;
            try {
                try {
                    final CountDownLatch countDownLatch = new CountDownLatch(3);
                    connectivityManager = (ConnectivityManager) b.getSystemService("connectivity");
                    if (i2 == 0) {
                        try {
                            if (r != 0 || s != 0) {
                                if ((i2 == 0 && r == 0 && p == 0) || (i2 == 1 && r == 0)) {
                                    NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
                                    networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: cn.shuzilm.core.dl.2
                                        @Override // android.net.ConnectivityManager.NetworkCallback
                                        public void onAvailable(Network network) {
                                            try {
                                                super.onAvailable(network);
                                                String strD = null;
                                                if (network != null) {
                                                    dl.b(network);
                                                    strD = dl.d(network, DUHelper.c(dl.b, 101, (String) null), 0);
                                                }
                                                String unused = dl.t = strD;
                                                String str = "0";
                                                if (strD == null) {
                                                    strD = "0";
                                                }
                                                if (strD.length() <= 64) {
                                                    str = strD;
                                                }
                                                if (i2 == 1) {
                                                    DUHelper.c(dl.b, 201, str);
                                                }
                                            } catch (Throwable unused2) {
                                            }
                                            countDownLatch.countDown();
                                        }

                                        @Override // android.net.ConnectivityManager.NetworkCallback
                                        public void onUnavailable() {
                                            super.onUnavailable();
                                            countDownLatch.countDown();
                                        }
                                    };
                                    try {
                                        connectivityManager.requestNetwork(networkRequestBuild, networkCallback2);
                                    } catch (Throwable unused) {
                                        if (connectivityManager != null) {
                                        }
                                        if (connectivityManager != null) {
                                        }
                                    }
                                } else {
                                    countDownLatch.countDown();
                                    DUHelper.c(b, 201, "0");
                                    t = "0";
                                    networkCallback2 = null;
                                }
                                if (i2 == 0) {
                                    try {
                                        if (p != 0 || s != 0) {
                                            if (i2 == 1 && s == 0) {
                                                NetworkRequest networkRequestBuild2 = new NetworkRequest.Builder().addCapability(12).addTransportType(1).build();
                                                ConnectivityManager.NetworkCallback networkCallback4 = new ConnectivityManager.NetworkCallback() { // from class: cn.shuzilm.core.dl.3
                                                    @Override // android.net.ConnectivityManager.NetworkCallback
                                                    public void onAvailable(Network network) {
                                                        super.onAvailable(network);
                                                        String strC = null;
                                                        if (network != null) {
                                                            try {
                                                                strC = dl.c(network, DUHelper.c(dl.b, 101, (String) null), 0);
                                                            } catch (Throwable unused2) {
                                                            }
                                                        }
                                                        String unused3 = dl.u = strC;
                                                        String str = "0";
                                                        if (strC == null) {
                                                            strC = "0";
                                                        }
                                                        if (strC.length() <= 64) {
                                                            str = strC;
                                                        }
                                                        if (i2 == 1) {
                                                            DUHelper.c(dl.b, 202, str);
                                                        }
                                                        countDownLatch.countDown();
                                                    }

                                                    @Override // android.net.ConnectivityManager.NetworkCallback
                                                    public void onUnavailable() {
                                                        super.onUnavailable();
                                                        countDownLatch.countDown();
                                                    }
                                                };
                                                try {
                                                    connectivityManager.requestNetwork(networkRequestBuild2, networkCallback4);
                                                    networkCallback3 = networkCallback4;
                                                } catch (Throwable unused2) {
                                                    networkCallback3 = networkCallback4;
                                                    if (connectivityManager != null) {
                                                        connectivityManager.unregisterNetworkCallback(networkCallback2);
                                                    }
                                                    if (connectivityManager != null) {
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                            } else {
                                                countDownLatch.countDown();
                                                DUHelper.c(b, 202, "0");
                                                u = "0";
                                            }
                                            if (p == 0) {
                                                try {
                                                    new Thread(new Runnable() { // from class: cn.shuzilm.core.dl.4
                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            try {
                                                                String strC = dl.c(null, DUHelper.c(dl.b, 101, (String) null), 0);
                                                                String str = "0";
                                                                if (strC == null) {
                                                                    strC = "0";
                                                                }
                                                                if (strC.length() <= 64) {
                                                                    str = strC;
                                                                }
                                                                if (i2 == 1) {
                                                                    DUHelper.c(dl.b, 203, str);
                                                                }
                                                            } catch (Throwable unused3) {
                                                            }
                                                            countDownLatch.countDown();
                                                        }
                                                    }).start();
                                                } catch (Exception unused3) {
                                                    countDownLatch.countDown();
                                                }
                                            } else {
                                                DUHelper.c(b, 203, "0");
                                                countDownLatch.countDown();
                                            }
                                            countDownLatch.await(2000L, TimeUnit.MILLISECONDS);
                                            if (connectivityManager != null && networkCallback2 != null) {
                                                connectivityManager.unregisterNetworkCallback(networkCallback2);
                                            }
                                            if (connectivityManager == null || networkCallback3 == null) {
                                                return;
                                            }
                                        }
                                    } catch (Throwable unused4) {
                                        networkCallback = networkCallback3;
                                        connectivityManager2 = connectivityManager;
                                        connectivityManager = connectivityManager2;
                                        networkCallback3 = networkCallback;
                                        if (connectivityManager != null && networkCallback2 != null) {
                                            connectivityManager.unregisterNetworkCallback(networkCallback2);
                                        }
                                        if (connectivityManager != null || networkCallback3 == null) {
                                            return;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable unused5) {
                            networkCallback = null;
                            networkCallback2 = null;
                            connectivityManager2 = connectivityManager;
                            connectivityManager = connectivityManager2;
                            networkCallback3 = networkCallback;
                            if (connectivityManager != null) {
                            }
                            if (connectivityManager != null) {
                            }
                        }
                    }
                } catch (Throwable unused6) {
                    networkCallback = null;
                    networkCallback2 = null;
                }
                connectivityManager.unregisterNetworkCallback(networkCallback3);
            } catch (Exception unused7) {
            }
        }
    }

    private static void n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(int i2) {
        if (u.a(b, "android.permission.CHANGE_NETWORK_STATE")) {
            t();
            c(i2);
        }
    }

    public static void d(Context context, String str, final boolean z) {
        if (f2467a > 0) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            b = applicationContext;
            if (applicationContext == null) {
                return;
            } else {
                new Thread(new Runnable() { // from class: cn.shuzilm.core.dl.5
                    @Override // java.lang.Runnable
                    public synchronized void run() {
                        try {
                            dl.f2467a++;
                        } catch (Throwable unused) {
                        }
                        if (z) {
                            dl.q();
                            return;
                        }
                        int iR = dl.r();
                        if (u.a(dl.b)) {
                            int unused2 = dl.i = 1;
                            dl.e(dl.f("h#TYch\"hY#TjYe"));
                            dl.q();
                        }
                        dl.d(1);
                        try {
                            Thread.sleep(2000L);
                        } catch (Exception unused3) {
                        }
                        if (dl.e.toString().length() > 0) {
                            dl.e.put("wrs", "" + iR);
                        }
                        if (dl.e != null) {
                            dl.e.put("i", dl.t + "," + dl.u + x.aQ);
                        }
                        dl.o();
                    }
                }).start();
            }
        } catch (Throwable unused) {
        }
        f2467a++;
    }
}
