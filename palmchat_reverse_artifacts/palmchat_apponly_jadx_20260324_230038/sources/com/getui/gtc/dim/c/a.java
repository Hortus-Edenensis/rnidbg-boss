package com.getui.gtc.dim.c;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.base.annotation.MutableMethod;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.dim.c.d;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.assist.util.AssistUtils;
import com.kuaishou.weapon.p0.g;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private static final Map<String, String> c = new HashMap<String, String>() { // from class: com.getui.gtc.dim.c.a.1
        {
            put("huawei", LxAdEmuiDevice.PROP_VERSION);
            put("honor", "ro.build.version.magic#ro.build.version.emui");
            put("xiaomi", "ro.build.version.incremental");
            put("redmi", "ro.build.version.incremental");
            put("blackshark", "ro.build.version.incremental");
            put("samsang", "ro.build.version.incremental");
            put("vivo", "ro.vivo.os.version");
            put("oppo", "ro.build.version.opporom#ro.build.version.oplusrom");
            put(AssistUtils.BRAND_MZ, "ro.build.display.id");
            put("lenovo", "ro.build.version.incremental");
            put("smartisan", "ro.modversion");
            put("htc", "ro.build.sense.version");
            put("oneplus", "ro.rom.version");
            put("yunos", "ro.cta.yunos.version");
            put("360", "ro.build.uiversion");
            put("nubia", "ro.build.rom.internal.id");
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f5730a = new HashMap();
    private static final Map<String, String> d = new HashMap<String, String>() { // from class: com.getui.gtc.dim.c.a.2
        {
            put("huawei", "com.android.permission.GET_INSTALLED_APP");
            put("honor", "com.android.permission.GET_INSTALLED_APPS");
        }
    };
    public static final Map<String, String> b = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public class b implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f5732a;

        public b(IBinder iBinder) {
            this.f5732a = iBinder;
        }

        public final String a() throws RemoteException {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f5732a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Exception e) {
                    com.getui.gtc.dim.e.b.a(e);
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    string = null;
                }
                return string;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f5732a;
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, String str) {
        try {
            com.getui.gtc.dim.e.c.a(context, "network".equals(str) ? g.h : g.g, true);
            return ((LocationManager) context.getSystemService("location")).getLastKnownLocation(str);
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    @MutableMethod
    public static String b() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @MutableMethod
    @SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(int i, Context context) {
        int subscriptionId;
        Cursor cursorQuery = null;
        int i2 = -1;
        try {
            com.getui.gtc.dim.e.c.a(context, g.c, true);
            try {
                subscriptionId = Build.VERSION.SDK_INT >= 22 ? SubscriptionManager.from(context).getActiveSubscriptionInfoForSimSlotIndex(i).getSubscriptionId() : -1;
                if (subscriptionId == -1) {
                    try {
                        throw new RuntimeException("invalid subId");
                    } catch (Throwable unused) {
                        i2 = subscriptionId;
                        cursorQuery = context.getContentResolver().query(Uri.parse("content://telephony/siminfo"), new String[]{"_id", "sim_id"}, "sim_id = ?", new String[]{String.valueOf(i)}, null);
                        subscriptionId = (cursorQuery == null || !cursorQuery.moveToFirst()) ? i2 : cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                        if (cursorQuery != null) {
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            if (cursorQuery != null) {
                return subscriptionId;
            }
            cursorQuery.close();
            return subscriptionId;
        } catch (Throwable th) {
            try {
                com.getui.gtc.dim.e.b.a(th);
                return i2;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
    }

    @MutableMethod
    public static String d() {
        try {
            String strB = b();
            if (!TextUtils.isEmpty(strB)) {
                String lowerCase = strB.toLowerCase();
                Map<String, String> map = f5730a;
                if (map.containsKey(lowerCase)) {
                    return com.getui.gtc.dim.e.c.a(map.get(lowerCase), "");
                }
                Map<String, String> map2 = c;
                if (map2.containsKey(lowerCase)) {
                    return com.getui.gtc.dim.e.c.a(map2.get(lowerCase), "");
                }
            }
            String strE = e();
            if (!TextUtils.isEmpty(strE)) {
                String lowerCase2 = strE.toLowerCase();
                Map<String, String> map3 = f5730a;
                if (map3.containsKey(lowerCase2)) {
                    return com.getui.gtc.dim.e.c.a(map3.get(lowerCase2), "");
                }
                Map<String, String> map4 = c;
                if (map4.containsKey(lowerCase2)) {
                    return com.getui.gtc.dim.e.c.a(map4.get(lowerCase2), "");
                }
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
        return "";
    }

    @MutableMethod
    public static String e() {
        try {
            return Build.MANUFACTURER;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String f() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String g(Context context) {
        byte[] hardwareAddress;
        String string = "";
        try {
            if (Build.VERSION.SDK_INT < 23) {
                com.getui.gtc.dim.e.c.a(context, g.d, true);
                return ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            }
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ("wlan0".equalsIgnoreCase(networkInterfaceNextElement.getName()) && (hardwareAddress = networkInterfaceNextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    string = sb.toString();
                }
            }
            return string;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008b  */
    @MutableMethod
    @SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h(Context context) {
        byte b2;
        try {
            String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            if (TextUtils.isEmpty(simOperator)) {
                return "";
            }
            int iHashCode = simOperator.hashCode();
            if (iHashCode != 49679479) {
                if (iHashCode != 49679502) {
                    switch (iHashCode) {
                        case 49679470:
                            b2 = !simOperator.equals("46000") ? (byte) -1 : (byte) 0;
                            break;
                        case 49679471:
                            if (simOperator.equals("46001")) {
                                b2 = 4;
                                break;
                            }
                            break;
                        case 49679472:
                            if (simOperator.equals("46002")) {
                                b2 = 1;
                                break;
                            }
                            break;
                        case 49679473:
                            if (simOperator.equals("46003")) {
                                b2 = 7;
                                break;
                            }
                            break;
                        case 49679474:
                            if (simOperator.equals("46004")) {
                                b2 = 2;
                                break;
                            }
                            break;
                        case 49679475:
                            if (simOperator.equals("46005")) {
                                b2 = 8;
                                break;
                            }
                            break;
                        case 49679476:
                            if (simOperator.equals("46006")) {
                                b2 = 5;
                                break;
                            }
                            break;
                        case 49679477:
                            if (simOperator.equals("46007")) {
                                b2 = 3;
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                } else if (simOperator.equals("46011")) {
                    b2 = 9;
                }
            } else if (simOperator.equals("46009")) {
                b2 = 6;
            }
            switch (b2) {
                case 0:
                case 1:
                case 2:
                case 3:
                    return "中国移动";
                case 4:
                case 5:
                case 6:
                    return "中国联通";
                case 7:
                case 8:
                case 9:
                    return "中国电信";
                default:
                    return simOperator;
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @Deprecated
    public static String i() {
        return "";
    }

    @MutableMethod
    public static String j(Context context) {
        try {
            if (!com.getui.gtc.dim.e.c.a(context)) {
                throw new IllegalStateException("network not connected");
            }
            boolean zB = com.getui.gtc.dim.e.c.b(context);
            boolean zC = com.getui.gtc.dim.e.c.c(context);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ((zB && networkInterfaceNextElement.getName().toLowerCase().contains("rmnet")) || (zC && networkInterfaceNextElement.getName().toLowerCase().contains("wlan0"))) {
                    List<InterfaceAddress> interfaceAddresses = networkInterfaceNextElement.getInterfaceAddresses();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<InterfaceAddress> it = interfaceAddresses.iterator();
                    while (it.hasNext()) {
                        InetAddress address = it.next().getAddress();
                        if (!address.isLoopbackAddress()) {
                            arrayList3.add(address.getHostAddress());
                        }
                    }
                    if (zB) {
                        arrayList.addAll(arrayList3);
                    }
                    if (zC) {
                        arrayList2.addAll(arrayList3);
                    }
                }
            }
            if (zB) {
                StringBuilder sb = new StringBuilder();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    sb.append((String) it2.next());
                    sb.append(",");
                }
                if (sb.toString().endsWith(",")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
            if (!zC) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                sb2.append((String) it3.next());
                sb2.append(",");
            }
            if (sb2.toString().endsWith(",")) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String k(Context context) {
        try {
            if (!com.getui.gtc.dim.e.c.a(context)) {
                throw new IllegalStateException("network not connected");
            }
            boolean zB = com.getui.gtc.dim.e.c.b(context);
            boolean zC = com.getui.gtc.dim.e.c.c(context);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                String lowerCase = networkInterfaceNextElement.getName().toLowerCase();
                if ((zB && (lowerCase.contains("rmnet") || lowerCase.contains("ccmni"))) || (zC && lowerCase.contains("wlan0"))) {
                    List<InterfaceAddress> interfaceAddresses = networkInterfaceNextElement.getInterfaceAddresses();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<InterfaceAddress> it = interfaceAddresses.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        InetAddress address = it.next().getAddress();
                        if (!address.isLoopbackAddress()) {
                            if (address instanceof Inet6Address) {
                                arrayList3.add(address.getHostAddress());
                            } else if (address instanceof Inet4Address) {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        if (zB) {
                            arrayList.addAll(arrayList3);
                        }
                        if (zC) {
                            arrayList2.addAll(arrayList3);
                        }
                    }
                }
            }
            if (zB) {
                StringBuilder sb = new StringBuilder();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    sb.append((String) it2.next());
                    sb.append(",");
                }
                if (sb.toString().endsWith(",")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
            if (!zC) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                sb2.append((String) it3.next());
                sb2.append(",");
            }
            if (sb2.toString().endsWith(",")) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static WifiInfo l(Context context) {
        try {
            com.getui.gtc.dim.e.c.a(context, g.d, true);
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                try {
                    Field declaredField = WifiInfo.class.getDeclaredField("mIpAddress");
                    declaredField.setAccessible(true);
                    declaredField.set(connectionInfo, null);
                } catch (Throwable th) {
                    com.getui.gtc.dim.e.b.a(th);
                }
            }
            return connectionInfo;
        } catch (Throwable th2) {
            com.getui.gtc.dim.e.b.a(th2);
            return null;
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static List<ScanResult> m(Context context) {
        try {
            if (CommonUtil.isMainThread()) {
                throw new IllegalStateException("cannot get wifi list from the main thread");
            }
            com.getui.gtc.dim.e.c.a(context, g.g, true);
            List<ScanResult> scanResults = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getScanResults();
            if (scanResults == null || scanResults.size() <= 0) {
                return null;
            }
            return scanResults;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [int] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v7 */
    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String n(Context context) {
        int systemId;
        int i;
        int baseStationId;
        ?? r8;
        boolean z;
        ?? r82;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                com.getui.gtc.dim.e.c.a(context, g.g, true);
            } else if (!com.getui.gtc.dim.e.c.a(context, g.h) && !com.getui.gtc.dim.e.c.a(context, g.g)) {
                throw new IllegalStateException("permission coarse/fine location not granted");
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            List list = null;
            if (telephonyManager.getSimState() == 5) {
                String networkOperator = telephonyManager.getNetworkOperator();
                if (networkOperator == null || networkOperator.length() < 3) {
                    systemId = 0;
                    i = 0;
                } else {
                    i = Integer.parseInt(networkOperator.substring(0, 3));
                    systemId = Integer.parseInt(networkOperator.substring(3));
                }
                try {
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    z = cellLocation instanceof GsmCellLocation;
                    try {
                        if (z) {
                            int lac = ((GsmCellLocation) cellLocation).getLac();
                            baseStationId = ((GsmCellLocation) cellLocation).getCid();
                            r82 = lac;
                        } else if (cellLocation instanceof CdmaCellLocation) {
                            int networkId = ((CdmaCellLocation) cellLocation).getNetworkId();
                            if (systemId == 0) {
                                systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                            }
                            baseStationId = ((CdmaCellLocation) cellLocation).getBaseStationId();
                            r82 = networkId;
                        } else {
                            baseStationId = 0;
                            r82 = 0;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.getui.gtc.dim.e.b.a(th);
                        baseStationId = 0;
                        r82 = z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    r8 = r82;
                } else {
                    list = (List) telephonyManager.getClass().getMethod("getNeighboringCellInfo", new Class[0]).invoke(telephonyManager, new Object[0]);
                    r8 = r82;
                }
            } else {
                systemId = 0;
                i = 0;
                baseStationId = 0;
                r8 = 0;
            }
            ?? sb = new StringBuilder();
            sb.append(i);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(systemId);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(r8);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(baseStationId);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            for (int i2 = 0; list != null && i2 < list.size(); i2++) {
                sb.append(((NeighboringCellInfo) list.get(i2)).getCid());
                if (i2 < list.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } catch (Throwable th3) {
            com.getui.gtc.dim.e.b.a(th3);
            return "0|0|0|0|";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0199 A[Catch: all -> 0x01da, TryCatch #4 {all -> 0x01da, blocks: (B:3:0x0008, B:10:0x001f, B:13:0x0029, B:15:0x0037, B:18:0x003f, B:19:0x004e, B:21:0x0054, B:23:0x0060, B:25:0x0064, B:66:0x0193, B:68:0x0199, B:69:0x019e, B:27:0x0088, B:29:0x008c, B:30:0x00a6, B:32:0x00aa, B:33:0x00c8, B:35:0x00cc, B:36:0x00ea, B:64:0x0185, B:71:0x01c6, B:73:0x01cc, B:76:0x01d2, B:77:0x01d9), top: B:89:0x0008 }] */
    @MutableMethod
    @SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String o(Context context) {
        String str;
        Iterator<CellInfo> it;
        long j;
        Method method;
        Method method2;
        Object objInvoke;
        String str2;
        int i;
        int mnc;
        int tac;
        long ci;
        String str3 = "android.telephony.CellInfoNr";
        try {
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
        if (!CommonUtil.hasPermission(context, Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 ? g.g : g.h, true)) {
            throw new RuntimeException("not has location permission");
        }
        List<CellInfo> allCellInfo = ((TelephonyManager) context.getSystemService("phone")).getAllCellInfo();
        if (allCellInfo != null && !allCellInfo.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<CellInfo> it2 = allCellInfo.iterator();
            long jLongValue = 0;
            int mcc = 0;
            int i2 = 0;
            int iIntValue = 0;
            int i3 = 0;
            while (it2.hasNext()) {
                CellInfo next = it2.next();
                if (next.isRegistered()) {
                    if (next instanceof CellInfoGsm) {
                        CellIdentityGsm cellIdentity = ((CellInfoGsm) next).getCellIdentity();
                        mcc = cellIdentity.getMcc();
                        mnc = cellIdentity.getMnc();
                        tac = cellIdentity.getLac();
                        ci = cellIdentity.getCid();
                        str = str3;
                        it = it2;
                        i3 = 1;
                    } else if (next instanceof CellInfoCdma) {
                        CellIdentityCdma cellIdentity2 = ((CellInfoCdma) next).getCellIdentity();
                        mnc = cellIdentity2.getSystemId();
                        tac = cellIdentity2.getNetworkId();
                        ci = cellIdentity2.getBasestationId();
                        str = str3;
                        it = it2;
                        i3 = 2;
                    } else if (next instanceof CellInfoWcdma) {
                        CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) next).getCellIdentity();
                        mcc = cellIdentity3.getMcc();
                        mnc = cellIdentity3.getMnc();
                        tac = cellIdentity3.getLac();
                        ci = cellIdentity3.getCid();
                        str = str3;
                        it = it2;
                        i3 = 4;
                    } else if (next instanceof CellInfoLte) {
                        CellIdentityLte cellIdentity4 = ((CellInfoLte) next).getCellIdentity();
                        mcc = cellIdentity4.getMcc();
                        mnc = cellIdentity4.getMnc();
                        tac = cellIdentity4.getTac();
                        ci = cellIdentity4.getCi();
                        str = str3;
                        it = it2;
                        i3 = 3;
                    } else {
                        if (str3.equals(next.getClass().getName())) {
                            try {
                                Method method3 = Class.forName(str3).getMethod("getCellIdentity", new Class[0]);
                                Class<?> cls = Class.forName("android.telephony.CellIdentityNr");
                                str = str3;
                                try {
                                    Method method4 = cls.getMethod("getMccString", new Class[0]);
                                    it = it2;
                                    try {
                                        Method method5 = cls.getMethod("getMncString", new Class[0]);
                                        int i4 = mcc;
                                        try {
                                            method = cls.getMethod("getTac", new Class[0]);
                                            j = jLongValue;
                                            try {
                                                method2 = cls.getMethod("getNci", new Class[0]);
                                                objInvoke = method3.invoke(next, new Object[0]);
                                                String str4 = (String) method4.invoke(objInvoke, new Object[0]);
                                                str2 = (String) method5.invoke(objInvoke, new Object[0]);
                                                i = Integer.parseInt(str4);
                                            } catch (Throwable th2) {
                                                th = th2;
                                                mcc = i4;
                                                com.getui.gtc.dim.e.b.b(th);
                                                jLongValue = j;
                                                if (sb.length() != 0) {
                                                }
                                                sb.append(mcc);
                                                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                                sb.append(i2);
                                                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                                sb.append(iIntValue);
                                                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                                sb.append(jLongValue);
                                                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                                sb.append(i3);
                                                it2 = it;
                                                str3 = str;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            j = jLongValue;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        j = jLongValue;
                                        com.getui.gtc.dim.e.b.b(th);
                                        jLongValue = j;
                                        if (sb.length() != 0) {
                                        }
                                        sb.append(mcc);
                                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                        sb.append(i2);
                                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                        sb.append(iIntValue);
                                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                        sb.append(jLongValue);
                                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                        sb.append(i3);
                                        it2 = it;
                                        str3 = str;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    it = it2;
                                    j = jLongValue;
                                    com.getui.gtc.dim.e.b.b(th);
                                    jLongValue = j;
                                    if (sb.length() != 0) {
                                    }
                                    sb.append(mcc);
                                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                    sb.append(i2);
                                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                    sb.append(iIntValue);
                                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                    sb.append(jLongValue);
                                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                    sb.append(i3);
                                    it2 = it;
                                    str3 = str;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                str = str3;
                            }
                            try {
                                i2 = Integer.parseInt(str2);
                                iIntValue = ((Integer) method.invoke(objInvoke, new Object[0])).intValue();
                                jLongValue = ((Long) method2.invoke(objInvoke, new Object[0])).longValue();
                                i3 = 6;
                                mcc = i;
                            } catch (Throwable th7) {
                                th = th7;
                                mcc = i;
                                com.getui.gtc.dim.e.b.b(th);
                                jLongValue = j;
                            }
                        } else {
                            str = str3;
                            it = it2;
                        }
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(mcc);
                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        sb.append(i2);
                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        sb.append(iIntValue);
                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        sb.append(jLongValue);
                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        sb.append(i3);
                        it2 = it;
                        str3 = str;
                    }
                    long j2 = ci;
                    i2 = mnc;
                    iIntValue = tac;
                    jLongValue = j2;
                    if (sb.length() != 0) {
                    }
                    sb.append(mcc);
                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                    sb.append(i2);
                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                    sb.append(iIntValue);
                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                    sb.append(jLongValue);
                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                    sb.append(i3);
                    it2 = it;
                    str3 = str;
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return "0|0|0|0|0";
        }
        return "0|0|0|0|0";
    }

    @MutableMethod
    public static List<PackageInfo> p(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (listQueryIntentActivities.size() > 0) {
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    try {
                        arrayList.add(com.getui.gtc.dim.e.d.a(it.next().activityInfo.packageName, 0));
                    } catch (Throwable unused) {
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return Collections.emptyList();
        }
    }

    @MutableMethod
    public static List<PackageInfo> q(Context context) {
        String str;
        try {
            String lowerCase = b().toLowerCase();
            Map<String, String> map = b;
            if (map.containsKey(lowerCase)) {
                str = map.get(lowerCase);
            } else {
                Map<String, String> map2 = d;
                if (!map2.containsKey(lowerCase)) {
                    throw new RuntimeException("not support brand: ".concat(String.valueOf(lowerCase)));
                }
                str = map2.get(lowerCase);
            }
            com.getui.gtc.dim.e.c.a(context, str, false);
            PackageManager packageManager = context.getPackageManager();
            return (List) packageManager.getClass().getDeclaredMethod(new String(Base64.decode("Z2V0SW5zdGFsbGVkUGFja2FnZXM=", 0)), Integer.TYPE).invoke(packageManager, 5);
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return Collections.emptyList();
        }
    }

    @MutableMethod
    public static List<PackageInfo> r(Context context) {
        String[] list;
        File parentFile;
        try {
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            throw new RuntimeException("can not get localDirs above 29");
        }
        File externalCacheDir = context.getExternalCacheDir();
        File parentFile2 = (externalCacheDir == null || (parentFile = externalCacheDir.getParentFile()) == null) ? null : parentFile.getParentFile();
        if (parentFile2 != null && parentFile2.isDirectory() && (list = parentFile2.list(new FilenameFilter() { // from class: com.getui.gtc.dim.c.a.3
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                try {
                    if (file.isDirectory()) {
                        if (str.contains(".")) {
                            return true;
                        }
                    }
                } catch (Throwable unused) {
                }
                return false;
            }
        })) != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                try {
                    arrayList.add(com.getui.gtc.dim.e.d.a(str, 0));
                } catch (Throwable unused) {
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String a() {
        Process processA;
        BufferedReader bufferedReader = null;
        try {
            StringBuilder sb = new StringBuilder();
            processA = com.getui.gtc.dim.e.c.a(new String(Base64.decode("aXAgYWRkcg==", 0)));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processA.getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        if (Pattern.matches("^\\d+: ((wlan\\d+)|(eth\\d+)): .*", line)) {
                            String strSubstring = line.substring(line.indexOf(": ") + 2);
                            sb.append(sb.length() == 0 ? "" : ",");
                            sb.append(strSubstring.substring(0, strSubstring.indexOf(": ")));
                            sb.append("#");
                            String line2 = bufferedReader2.readLine();
                            if (line2 != null) {
                                sb.append(line2.substring(line2.indexOf("link/ether ") + 11, line2.indexOf(" brd")));
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        try {
                            com.getui.gtc.dim.e.b.a(th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused) {
                                }
                            }
                            if (processA != null) {
                                try {
                                    processA.destroy();
                                } catch (Throwable unused2) {
                                }
                            }
                            return "";
                        } finally {
                        }
                    }
                }
                String string = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (Throwable unused3) {
                }
                try {
                    processA.destroy();
                } catch (Throwable unused4) {
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            processA = null;
        }
    }

    @MutableMethod
    public static String b(int i, Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new RuntimeException("can not get imsi above 29");
            }
            com.getui.gtc.dim.e.c.a(context, g.c, true);
            Object objA = com.getui.gtc.dim.e.c.a(i, "getSubscriberId", context);
            return objA != null ? (String) objA : "";
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String c() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String d(int i, Context context) {
        String str = "";
        try {
            com.getui.gtc.dim.e.c.a(context, g.c, true);
            Object objA = com.getui.gtc.dim.e.c.a(i, "getSimSerialNumber", context);
            String str2 = objA != null ? (String) objA : "";
            try {
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.length() < 20) {
                        return "";
                    }
                }
                return str2;
            } catch (Throwable th) {
                str = str2;
                th = th;
                com.getui.gtc.dim.e.b.a(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @MutableMethod
    public static String e(Context context) {
        try {
            if (CommonUtil.isMainThread()) {
                throw new RuntimeException("cannot get advertisingId from main thread");
            }
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            ServiceConnectionC0337a serviceConnectionC0337a = new ServiceConnectionC0337a();
            if (!context.bindService(intent, serviceConnectionC0337a, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                if (serviceConnectionC0337a.f5731a) {
                    throw new IllegalStateException();
                }
                serviceConnectionC0337a.f5731a = true;
                return new b(serviceConnectionC0337a.b.poll(3000L, TimeUnit.MILLISECONDS)).a();
            } finally {
                context.unbindService(serviceConnectionC0337a);
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String f(Context context) {
        Object objInvoke;
        try {
            com.getui.gtc.dim.e.c.a(context, g.c, true);
            int i = Build.VERSION.SDK_INT;
            if (i < 26) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                objInvoke = cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
            } else {
                if (i >= 29) {
                    throw new RuntimeException("can not get serialnumber above 29");
                }
                Class<?> cls2 = Class.forName("android.os.Build");
                objInvoke = cls2.getMethod("getSerial", new Class[0]).invoke(cls2, new Object[0]);
            }
            return (String) objInvoke;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @MutableMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<PackageInfo> g() {
        Process processA;
        BufferedReader bufferedReader;
        Throwable th;
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                throw new RuntimeException("can not get al by pm above 33");
            }
            ArrayList arrayList = new ArrayList();
            processA = com.getui.gtc.dim.e.c.a(new String(Base64.decode("cG0gbGlzdCBwYWNrYWdlcw==", 0)));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(processA.getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            try {
                                arrayList.add(com.getui.gtc.dim.e.d.a(line.split(":")[1], 0));
                            } catch (Throwable unused) {
                            }
                        } else {
                            try {
                                break;
                            } catch (Throwable unused2) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            com.getui.gtc.dim.e.b.a(th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused3) {
                                }
                            }
                            if (processA != null) {
                                try {
                                    processA.destroy();
                                } catch (Throwable unused4) {
                                }
                            }
                            return Collections.emptyList();
                        } finally {
                        }
                    }
                }
                bufferedReader.close();
                try {
                    processA.destroy();
                } catch (Throwable unused5) {
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                th = th;
                com.getui.gtc.dim.e.b.a(th);
                if (bufferedReader != null) {
                }
                if (processA != null) {
                }
                return Collections.emptyList();
            }
        } catch (Throwable th4) {
            th = th4;
            processA = null;
            bufferedReader = null;
        }
    }

    @MutableMethod
    public static List<PackageInfo> h() {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new RuntimeException("can not get al by us at main thread");
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 10000; i <= 19999; i++) {
                PackageInfo packageInfoA = com.getui.gtc.dim.e.d.a(i);
                if (packageInfoA != null) {
                    arrayList.add(packageInfoA);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return Collections.emptyList();
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String i(Context context) {
        try {
            com.getui.gtc.dim.e.c.a(context, g.b, true);
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                throw new IllegalStateException("getSystemService: CONNECTIVITY_SERVICE failed");
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                throw new IllegalStateException("getActiveNetworkInfo failed");
            }
            if (!activeNetworkInfo.isAvailable()) {
                throw new IllegalStateException("no available activeNetwork");
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                return "WIFI";
            }
            int subtype = activeNetworkInfo.getSubtype();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                subtype = telephonyManager.getNetworkType();
            }
            if (subtype == 20) {
                return "5G";
            }
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    return "NULL";
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "NULL";
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String a(int i, Context context) {
        String deviceId;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                throw new RuntimeException("can not get imei above 29");
            }
            if ("vivo".equalsIgnoreCase(b()) && i2 < 26) {
                throw new RuntimeException("do not get imei from vivo below 29");
            }
            if (i2 < 23) {
                return "";
            }
            com.getui.gtc.dim.e.c.a(context, g.c, true);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (telephonyManager == null || i < 0 || (deviceId = telephonyManager.getDeviceId(i)) == null) ? "" : deviceId;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String b(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new RuntimeException("can not get imsi above 29");
            }
            com.getui.gtc.dim.e.c.a(context, g.c, true);
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            return !TextUtils.isEmpty(subscriberId) ? subscriberId : "";
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String c(Context context) {
        Throwable th;
        String simSerialNumber;
        try {
            com.getui.gtc.dim.e.c.a(context, g.c, true);
            simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            if (TextUtils.isEmpty(simSerialNumber)) {
                simSerialNumber = "";
            }
            try {
                if (!TextUtils.isEmpty(simSerialNumber)) {
                    if (simSerialNumber.length() < 20) {
                        return "";
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.getui.gtc.dim.e.b.a(th);
            }
        } catch (Throwable th3) {
            th = th3;
            simSerialNumber = "";
        }
        return simSerialNumber;
    }

    @MutableMethod
    public static String d(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new RuntimeException("can not get imei above 29");
            }
            com.getui.gtc.dim.e.c.a(context, g.c, true);
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return !TextUtils.isEmpty(deviceId) ? deviceId : "";
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String b(Context context, String str) {
        try {
            com.getui.gtc.dim.e.c.a(context, g.d, true);
            if (!com.getui.gtc.dim.e.c.c(context)) {
                return "2##";
            }
            int i = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway;
            String strB = com.getui.gtc.dim.e.c.b((i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255));
            return "1#" + str.replace("\"", "") + "#" + strB;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String a(Context context, boolean z) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new RuntimeException("can not get oaid at main thread");
            }
            d.a();
            d.a aVar = d.f5734a;
            if (aVar != null && context != null) {
                d.b = context.getApplicationContext();
                if (d.b()) {
                    d.c = aVar.c(d.b);
                }
            }
            String strC = d.c ? d.c() : null;
            if (!"HONOR".equals(d.d)) {
                return strC;
            }
            String strB = b(context, z);
            if (strB == null) {
                strB = "";
            }
            return strB + '#' + strC;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x0010, B:10:0x001a, B:12:0x0025, B:14:0x002d, B:15:0x0034), top: B:19:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x0010, B:10:0x001a, B:12:0x0025, B:14:0x002d, B:15:0x0034), top: B:19:0x0004 }] */
    @MutableMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(Context context, boolean z) {
        if (!z) {
            try {
                if (d.i.c()) {
                    com.getui.gtc.dim.e.b.a("support honor oaid");
                    return "";
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    throw new RuntimeException("can not get oaid at main thread");
                }
                d.h hVar = new d.h();
                if (hVar.a(context)) {
                    hVar.c(context);
                    return hVar.b(context);
                }
            } catch (Throwable th) {
                com.getui.gtc.dim.e.b.a(th);
            }
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
        }
        return "";
    }

    /* JADX INFO: renamed from: com.getui.gtc.dim.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ServiceConnectionC0337a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5731a = false;
        final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (Throwable th) {
                com.getui.gtc.dim.e.b.a(th);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
