package com.qiniu.android.dns.local;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkRequest;
import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.dns.DnsUdpResolver;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class AndroidDnsServer {

    /* JADX INFO: compiled from: SearchBox */
    public static class AndroidResolver implements IResolver {
        private List<InetAddress> dnsServers = new ArrayList();
        private boolean networkCallback = false;

        @TargetApi(21)
        public AndroidResolver(Context context) {
            List<InetAddress> byReflection = AndroidDnsServer.getByReflection();
            byReflection = byReflection == null ? AndroidDnsServer.getByCommand() : byReflection;
            if (byReflection != null) {
                this.dnsServers.addAll(byReflection);
                return;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            if (connectivityManager != null) {
                try {
                    connectivityManager.registerNetworkCallback(builder.build(), new ConnectivityManager.NetworkCallback() { // from class: com.qiniu.android.dns.local.AndroidDnsServer.AndroidResolver.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                            if (linkProperties != null) {
                                AndroidResolver.this.dnsServers.addAll(linkProperties.getDnsServers());
                            }
                            AndroidResolver.this.networkCallback = true;
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.qiniu.android.dns.IResolver
        public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
            boolean z;
            if (this.dnsServers.isEmpty() && !this.networkCallback) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            List<InetAddress> list = this.dnsServers;
            if (list == null || list.isEmpty()) {
                throw new IOException("cant get local dns server");
            }
            InetAddress inetAddress = this.dnsServers.get(0);
            Record[] recordArrResolve = new HijackingDetectWrapper(new DnsUdpResolver(inetAddress.getHostName())).resolve(domain, networkInfo);
            if (domain.hasCname) {
                int length = recordArrResolve.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    if (recordArrResolve[i].isCname()) {
                        z = true;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    throw new DnshijackingException(domain.domain, inetAddress.getHostAddress());
                }
            }
            if (domain.maxTtl != 0) {
                for (Record record : recordArrResolve) {
                    if (!record.isCname() && record.ttl > domain.maxTtl) {
                        throw new DnshijackingException(domain.domain, inetAddress.getHostAddress(), record.ttl);
                    }
                }
            }
            return recordArrResolve;
        }
    }

    public static IResolver defaultResolver(Context context) {
        return new AndroidResolver(context);
    }

    public static List<InetAddress> getByCommand() {
        int i;
        String hostAddress;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
            ArrayList arrayList = new ArrayList(5);
            while (true) {
                String line = lineNumberReader.readLine();
                if (line == null) {
                    break;
                }
                int iIndexOf = line.indexOf("]: [");
                if (iIndexOf > 1 && line.length() - 1 > (i = iIndexOf + 4)) {
                    String strSubstring = line.substring(1, iIndexOf);
                    String strSubstring2 = line.substring(i, line.length() - 1);
                    if (strSubstring.endsWith(".dns") || strSubstring.endsWith(".dns1") || strSubstring.endsWith(".dns2") || strSubstring.endsWith(".dns3") || strSubstring.endsWith(".dns4")) {
                        InetAddress byName = InetAddress.getByName(strSubstring2);
                        if (byName != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0) {
                            arrayList.add(byName);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (IOException e) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByExec", (Throwable) e);
            return null;
        }
    }

    public static List<InetAddress> getByReflection() {
        ArrayList arrayList;
        InetAddress byName;
        String hostAddress;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            arrayList = new ArrayList(5);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke(null, strArr[i]);
                if (str != null && str.length() != 0 && (byName = InetAddress.getByName(str)) != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0 && !arrayList.contains(byName)) {
                    arrayList.add(byName);
                }
            }
        } catch (Exception e) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByReflection", (Throwable) e);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }
}
