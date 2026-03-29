package com.bytedance.sdk.openadsdk.core.y;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.qq.gdt.action.ActionUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class sx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile long f5413a;
    private static volatile String b;
    private static volatile String fx;
    private static volatile String iz;
    private static volatile String n;
    private static volatile String pn;
    private static volatile long x;
    public static AtomicBoolean u = new AtomicBoolean(false);
    public static AtomicBoolean nr = new AtomicBoolean(false);
    private static final Map<String, String> jk = new ConcurrentHashMap();
    private static volatile long t = 0;
    private static final AtomicBoolean l = new AtomicBoolean(false);

    private static boolean a() {
        return (nr.get() || t.u(x, 1800000L) || TextUtils.isEmpty(fx)) ? false : true;
    }

    private static Map<String, String> b(boolean z) {
        Enumeration<NetworkInterface> networkInterfaces;
        long jElapsedRealtime = SystemClock.elapsedRealtime() + 300000;
        if (!z) {
            if (u.get()) {
                t = 0L;
                u.set(false);
            }
            if (jElapsedRealtime - t < 300000) {
                l.set(true);
                return jk;
            }
        }
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (Throwable unused) {
        }
        if (networkInterfaces == null) {
            t = jElapsedRealtime;
            l.set(true);
            return null;
        }
        HashMap map = new HashMap();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
            if (networkInterfaceNextElement != null) {
                map.put(networkInterfaceNextElement.getName(), networkInterfaceNextElement);
            }
        }
        nr(map);
        u(map);
        t = jElapsedRealtime;
        l.set(true);
        return jk;
    }

    public static String fx() {
        return a() ? fx : jk.nr(false)[0];
    }

    public static String[] iz() {
        if (!x()) {
            return new String[]{"", ""};
        }
        if (!com.bytedance.sdk.openadsdk.core.b.u.n() || TextUtils.isEmpty(b) || TextUtils.isEmpty(iz)) {
            return t();
        }
        new com.bytedance.sdk.openadsdk.core.b.nr("device_get_ip").u(5).nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.sx.1
            @Override // java.lang.Runnable
            public void run() {
                sx.t();
            }
        });
        return new String[]{b, iz};
    }

    private static String[] jk() {
        String[] strArrIz = iz();
        if (TextUtils.isEmpty(strArrIz[0]) && TextUtils.isEmpty(strArrIz[1])) {
            com.bytedance.sdk.openadsdk.core.fx.b.u().mv("");
        }
        return strArrIz;
    }

    public static String nr() {
        Map<String, String> mapU = u(false);
        String str = mapU != null ? mapU.get("zaid_ipv6") : null;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static JSONArray pn() {
        JSONArray jSONArray = new JSONArray();
        try {
            Map<String, String> mapU = u(false);
            if (mapU == null) {
                return jSONArray;
            }
            String str = mapU.get("register_ipv6");
            return !TextUtils.isEmpty(str) ? new JSONArray(str) : jSONArray;
        } catch (Exception unused) {
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] t() {
        String[] strArr = {"", ""};
        Map<String, String> mapU = u(false);
        if (mapU != null) {
            strArr[0] = mapU.get("local_ipv4");
            strArr[1] = mapU.get("local_ipv6");
        }
        return strArr;
    }

    public static String u() {
        Map<String, String> mapU = u(false);
        String str = mapU != null ? mapU.get("mac") : "";
        return str == null ? "" : str;
    }

    public static boolean x() {
        JSONArray jSONArray;
        int length;
        if (!com.bytedance.sdk.openadsdk.k.fx.u().fx()) {
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.dw.nr().vz()) {
            return true;
        }
        try {
            jSONArray = new JSONArray(com.bytedance.sdk.openadsdk.core.n.o().gi());
            length = jSONArray.length();
        } catch (JSONException unused) {
        }
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && !jSONObjectOptJSONObject.isNull("name") && "tt_inner_isw".equals(jSONObjectOptJSONObject.optString("name"))) {
                return jSONObjectOptJSONObject.optBoolean(ActionUtils.PAYMENT_AMOUNT, true);
            }
            return true;
        }
        return true;
    }

    public static Map<String, String> u(boolean z) {
        Map<String, String> mapB;
        if (!x()) {
            return jk;
        }
        if (l.get()) {
            return b(z);
        }
        synchronized (sx.class) {
            mapB = b(z);
        }
        return mapB;
    }

    public static String[] nr(boolean z) {
        long j;
        String strFx;
        String strFx2;
        String strBg;
        if (a()) {
            return new String[]{fx, pn};
        }
        String[] strArrJk = {"", ""};
        String strSx = com.bytedance.sdk.openadsdk.core.fx.b.u().sx();
        long j2 = 0;
        if (strSx != null) {
            try {
                JSONObject jSONObject = new JSONObject(strSx);
                strFx = com.bytedance.sdk.component.utils.u.fx(jSONObject.getString(ActionUtils.PAYMENT_AMOUNT));
                try {
                    j = jSONObject.getLong("time");
                } catch (JSONException unused) {
                    j = 0;
                }
            } catch (JSONException unused2) {
                j = 0;
                strFx = null;
                strFx2 = null;
            }
        } else {
            j = 0;
            strFx = null;
        }
        try {
            strBg = com.bytedance.sdk.openadsdk.core.fx.b.u().bg();
        } catch (JSONException unused3) {
        }
        if (strBg != null) {
            JSONObject jSONObject2 = new JSONObject(strBg);
            strFx2 = com.bytedance.sdk.component.utils.u.fx(jSONObject2.getString(ActionUtils.PAYMENT_AMOUNT));
            try {
                j2 = jSONObject2.getLong("time");
            } catch (JSONException unused4) {
            }
        } else {
            strFx2 = null;
        }
        if (strFx != null || strFx2 != null) {
            strArrJk[0] = strFx;
            b = strFx;
            strArrJk[1] = strFx2;
            iz = strFx2;
            if (z) {
                return strArrJk;
            }
        }
        if (nr.getAndSet(false)) {
            strArrJk = jk();
            if (TextUtils.isEmpty(strArrJk[0]) && TextUtils.isEmpty(strArrJk[1])) {
                if (strFx == null) {
                    strFx = "";
                }
                strArrJk[0] = strFx;
                strArrJk[1] = strFx2 != null ? strFx2 : "";
            }
        } else {
            if (strFx != null && System.currentTimeMillis() - j > 3600000) {
                strFx = null;
            }
            String str = (strFx2 == null || System.currentTimeMillis() - j2 <= 3600000) ? strFx2 : null;
            if (TextUtils.isEmpty(strFx) && TextUtils.isEmpty(str)) {
                strArrJk = jk();
            } else {
                strArrJk[0] = strFx;
                strArrJk[1] = str;
            }
        }
        fx = strArrJk[0];
        pn = strArrJk[1];
        x = System.currentTimeMillis();
        return strArrJk;
    }

    public static String[] fx(boolean z) {
        String[] strArr = {"", ""};
        try {
            Map<String, String> mapU = u(z);
            if (mapU != null) {
                strArr[0] = mapU.get("enc_ipv4");
                strArr[1] = mapU.get("enc_ipv6");
            }
        } catch (Throwable unused) {
        }
        return strArr;
    }

    private static boolean fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if ((cCharAt != '2' && cCharAt != '3' && cCharAt != '5') || str.length() < 2) {
            return false;
        }
        char cCharAt2 = str.charAt(1);
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            return true;
        }
        if (cCharAt2 < 'a' || cCharAt2 > 'f') {
            return cCharAt2 >= 'A' && cCharAt2 <= 'F';
        }
        return true;
    }

    public static String u(String str) {
        if (!TextUtils.isEmpty(n) && !t.u(f5413a, 1800000L)) {
            return n;
        }
        String strFx = com.bytedance.sdk.openadsdk.core.fx.b.u().fx("dev14", 1800000L);
        if (TextUtils.isEmpty(strFx)) {
            if (str == null) {
                str = jk.s();
            }
            n = str;
        } else {
            n = com.bytedance.sdk.component.utils.u.fx(strFx);
        }
        f5413a = System.currentTimeMillis();
        return n;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void u(Map<String, NetworkInterface> map) {
        int i;
        Iterator<Map.Entry<String, NetworkInterface>> it;
        String str;
        String hostAddress;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<String, NetworkInterface>> it2 = map.entrySet().iterator();
        String str2 = "";
        String strU = "";
        String strU2 = strU;
        String str3 = strU2;
        while (it2.hasNext()) {
            Map.Entry<String, NetworkInterface> next = it2.next();
            if (next != null) {
                String key = next.getKey();
                NetworkInterface value = next.getValue();
                if (value != null) {
                    try {
                        if (TextUtils.equals(key, "wlan0")) {
                            strU = u(value);
                        }
                        if (TextUtils.equals(key, "eth0")) {
                            strU2 = u(value);
                        }
                    } catch (Throwable unused) {
                    }
                    List<InetAddress> listNr = nr(value);
                    if (listNr != null) {
                        for (InetAddress inetAddress : listNr) {
                            String hostAddress2 = inetAddress.getHostAddress();
                            if (TextUtils.equals(key, "wlan0") && (inetAddress instanceof Inet6Address) && inetAddress.isLinkLocalAddress() && (hostAddress = inetAddress.getHostAddress()) != null && hostAddress.startsWith("fe80")) {
                                str3 = hostAddress;
                            }
                            if (TextUtils.isEmpty(hostAddress2)) {
                                it = it2;
                                str = str2;
                            } else if (!(hostAddress2.indexOf(58) < 0)) {
                                int iIndexOf = hostAddress2.indexOf(37);
                                try {
                                    it = it2;
                                    if ("dummy0".equals(key)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject();
                                            str = str2;
                                            try {
                                                jSONObject.put("type", "client_tun");
                                                jSONObject.put(ActionUtils.PAYMENT_AMOUNT, iIndexOf < 0 ? hostAddress2.toUpperCase() : hostAddress2.substring(0, iIndexOf).toUpperCase());
                                                jSONArray.put(jSONObject);
                                            } catch (JSONException unused2) {
                                            }
                                        } catch (JSONException unused3) {
                                            str = str2;
                                            if (inetAddress.isLoopbackAddress()) {
                                            }
                                            it2 = it;
                                            str2 = str;
                                        }
                                    } else {
                                        str = str2;
                                        if ("wlan0".equals(key)) {
                                            JSONObject jSONObject2 = new JSONObject();
                                            jSONObject2.put("type", "client_anpi");
                                            jSONObject2.put(ActionUtils.PAYMENT_AMOUNT, iIndexOf < 0 ? hostAddress2.toUpperCase() : hostAddress2.substring(0, iIndexOf).toUpperCase());
                                            jSONArray.put(jSONObject2);
                                        }
                                    }
                                } catch (JSONException unused4) {
                                    it = it2;
                                }
                            }
                            if (inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && !TextUtils.isEmpty(hostAddress2)) {
                                if (inetAddress instanceof Inet6Address) {
                                    sb.append(hostAddress2);
                                    sb.append(",");
                                } else if (inetAddress instanceof Inet4Address) {
                                    sb2.append(hostAddress2);
                                    sb2.append(",");
                                }
                            }
                            it2 = it;
                            str2 = str;
                        }
                    }
                }
            }
            it2 = it2;
            str2 = str2;
        }
        String str4 = str2;
        if (TextUtils.isEmpty(sb)) {
            i = 1;
        } else {
            i = 1;
            sb = sb.delete(sb.length() - 1, sb.length());
        }
        if (!TextUtils.isEmpty(sb2)) {
            sb2 = sb2.delete(sb2.length() - i, sb2.length());
        }
        Map<String, String> map2 = jk;
        map2.put("enc_ipv4", sb2.toString());
        map2.put("enc_ipv6", sb.toString());
        map2.put("register_ipv6", jSONArray.toString());
        if (!TextUtils.isEmpty(strU)) {
            map2.put("mac", strU);
        } else {
            map2.put("mac", strU2);
        }
        map2.put("zaid_ipv6", TextUtils.isEmpty(str3) ? str4 : str3);
    }

    public static String b() {
        if (a()) {
            return pn;
        }
        return jk.nr(false)[1];
    }

    public static void nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.fx.b.u().b("dev14", com.bytedance.sdk.component.utils.u.nr(str));
        n = str;
        f5413a = System.currentTimeMillis();
    }

    private static void nr(Map<String, NetworkInterface> map) {
        String[] strArr = {"", ""};
        Iterator<Map.Entry<String, NetworkInterface>> it = map.entrySet().iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            NetworkInterface value = it.next().getValue();
            if (value != null) {
                for (InetAddress inetAddress : nr(value)) {
                    boolean z3 = inetAddress instanceof Inet4Address;
                    if (!z3 || !z) {
                        if (z3 || !z2) {
                            if (u(z3, inetAddress, strArr)) {
                                if (!TextUtils.isEmpty(strArr[0]) && !TextUtils.isEmpty(strArr[1])) {
                                    Map<String, String> map2 = jk;
                                    map2.put("local_ipv4", strArr[0]);
                                    map2.put("local_ipv6", strArr[1]);
                                    return;
                                }
                            } else {
                                String hostAddress = inetAddress.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && !hostAddress.startsWith("127")) {
                                    if (z3) {
                                        com.bytedance.sdk.openadsdk.core.fx.b.u().mv(com.bytedance.sdk.component.utils.u.nr(hostAddress));
                                        strArr[0] = hostAddress;
                                        b = hostAddress;
                                        fx = hostAddress;
                                        if (z2) {
                                            Map<String, String> map3 = jk;
                                            map3.put("local_ipv4", hostAddress);
                                            map3.put("local_ipv6", strArr[1]);
                                            return;
                                        }
                                        z = true;
                                    } else {
                                        int iIndexOf = hostAddress.indexOf(37);
                                        if (iIndexOf >= 0) {
                                            hostAddress = hostAddress.substring(0, iIndexOf);
                                        }
                                        if (fx(hostAddress)) {
                                            com.bytedance.sdk.openadsdk.core.fx.b.u().s(com.bytedance.sdk.component.utils.u.nr(hostAddress));
                                            strArr[1] = hostAddress;
                                            iz = hostAddress;
                                            pn = hostAddress;
                                            if (z) {
                                                Map<String, String> map4 = jk;
                                                map4.put("local_ipv4", strArr[0]);
                                                map4.put("local_ipv6", hostAddress);
                                                return;
                                            }
                                            z2 = true;
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static String u(NetworkInterface networkInterface) throws SocketException {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = com.bytedance.sdk.openadsdk.core.n.o().sx();
        if (bVarSx != null && !bVarSx.b()) {
            return bVarSx.t();
        }
        byte[] hardwareAddress = networkInterface.getHardwareAddress();
        if (hardwareAddress == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : hardwareAddress) {
            sb.append(String.format("%02X:", Byte.valueOf(b2)));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static List<InetAddress> nr(NetworkInterface networkInterface) {
        if (networkInterface == null) {
            return Collections.emptyList();
        }
        try {
            Object objU = z.u(networkInterface, "java.net.NetworkInterface", "addrs", null);
            if (!(objU instanceof InetAddress[])) {
                return Collections.list(networkInterface.getInetAddresses());
            }
            return Arrays.asList((InetAddress[]) objU);
        } catch (Throwable unused) {
            return Collections.list(networkInterface.getInetAddresses());
        }
    }

    private static String nr(byte[] bArr) {
        return (bArr[0] & UByte.MAX_VALUE) + "." + (bArr[1] & UByte.MAX_VALUE) + "." + (bArr[2] & UByte.MAX_VALUE) + "." + (bArr[3] & UByte.MAX_VALUE);
    }

    private static boolean u(boolean z, InetAddress inetAddress, String[] strArr) {
        Field declaredField;
        if (z) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (!z && !TextUtils.isEmpty(strArr[1])) {
            return true;
        }
        if (z) {
            declaredField = InetAddress.class.getDeclaredField("holder");
        } else {
            declaredField = Inet6Address.class.getDeclaredField("holder6");
        }
        declaredField.setAccessible(true);
        Object obj = declaredField.get(inetAddress);
        Class<?> cls = obj.getClass();
        if (z) {
            Field declaredField2 = cls.getDeclaredField("address");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            int iIntValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : 0;
            byte[] bArr = {(byte) ((iIntValue >>> 24) & 255), (byte) ((iIntValue >>> 16) & 255), (byte) ((iIntValue >>> 8) & 255), (byte) (iIntValue & 255)};
            String strNr = nr(bArr);
            if (bArr[0] != 127) {
                strArr[0] = strNr;
            }
        } else {
            Field declaredField3 = cls.getDeclaredField("ipaddress");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj);
            if (obj3 instanceof byte[]) {
                String strU = u((byte[]) obj3);
                if (!fx(strU)) {
                    return true;
                }
                strArr[1] = strU;
            }
        }
        return true;
    }

    private static String u(byte[] bArr) {
        StringBuilder sb = new StringBuilder(39);
        for (int i = 0; i < 8; i++) {
            int i2 = i << 1;
            sb.append(Integer.toHexString(((bArr[i2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[i2 + 1] & UByte.MAX_VALUE)));
            if (i < 7) {
                sb.append(":");
            }
        }
        return sb.toString();
    }
}
