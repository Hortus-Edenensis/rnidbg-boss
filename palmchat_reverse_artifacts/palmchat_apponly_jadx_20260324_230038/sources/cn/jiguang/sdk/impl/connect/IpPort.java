package cn.jiguang.sdk.impl.connect;

import android.text.TextUtils;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class IpPort implements Serializable {
    private static final String TAG = "IpPort";
    public transient InetAddress inetAddress;
    public String ip;
    public int port;

    public IpPort(String str, int i) {
        this.ip = str;
        this.port = i;
    }

    public static IpPort fromString(String str) {
        int iLastIndexOf;
        String strSubstring;
        if (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(":")) < 0) {
            return null;
        }
        try {
            int iIntValue = Integer.decode(str.substring(iLastIndexOf + 1)).intValue();
            if (iLastIndexOf == 0) {
                strSubstring = "";
            } else {
                int i = str.startsWith("[") ? 1 : 0;
                if (str.charAt(iLastIndexOf - 1) == ']') {
                    iLastIndexOf--;
                }
                strSubstring = str.substring(i, iLastIndexOf);
            }
            return new IpPort(strSubstring, iIntValue);
        } catch (Exception unused) {
            return null;
        }
    }

    public static LinkedHashSet<IpPort> map2Set(LinkedHashMap<String, Integer> linkedHashMap) {
        LinkedHashSet<IpPort> linkedHashSet = new LinkedHashSet<>();
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            IpPort ipPort = new IpPort(entry.getKey(), entry.getValue().intValue());
            if (ipPort.isLegal()) {
                linkedHashSet.add(ipPort);
            }
        }
        return linkedHashSet;
    }

    public static String set2String(LinkedHashSet<IpPort> linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<IpPort> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static LinkedHashSet<IpPort> string2Set(String str) {
        LinkedHashSet<IpPort> linkedHashSet = new LinkedHashSet<>();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                IpPort ipPortFromString = fromString(str2);
                if (ipPortFromString != null && ipPortFromString.isLegal()) {
                    linkedHashSet.add(ipPortFromString);
                }
            }
        }
        return linkedHashSet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IpPort ipPort = (IpPort) obj;
        if (this.port == ipPort.port) {
            String str = this.ip;
            String str2 = ipPort.ip;
            if (str != null) {
                if (str.equals(str2)) {
                    return true;
                }
            } else if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.ip;
        return ((str != null ? str.hashCode() : 0) * 31) + this.port;
    }

    public boolean isLegal() {
        int i;
        return !TextUtils.isEmpty(this.ip) && (i = this.port) > 0 && i <= 65535;
    }

    public String toString() {
        if (!this.ip.contains(":")) {
            return this.ip + ":" + this.port;
        }
        return "[" + this.ip + "]:" + this.port;
    }

    public static boolean isLegal(String str, int i) {
        return !TextUtils.isEmpty(str) && i > 0 && i <= 65535;
    }

    public IpPort(InetAddress inetAddress, int i) {
        this.ip = inetAddress.getHostAddress();
        this.port = i;
        this.inetAddress = inetAddress;
    }
}
