package com.zenmen.media.common;

import com.huawei.openalliance.ad.constant.x;
import com.zenmen.media.common.IPInfo;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import defpackage.it0;
import defpackage.nl0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11946a = false;
    public static Map<String, List<Integer>> b = new HashMap();

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        r0 = r6.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        r2 = r6.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        if (r2 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        if (r2.size() <= 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
    
        r4 = (int) (java.lang.Math.random() * ((double) r2.size()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
    
        if (r4 < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        if (r4 <= r2.size()) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        r3 = r2.get(r4).intValue();
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static IPInfo a() {
        String str;
        int iIntValue;
        String key;
        Map<String, List<Integer>> map = b;
        if (map == null || map.isEmpty()) {
            b();
        }
        Map<String, List<Integer>> map2 = b;
        if (map2 != null && !map2.isEmpty()) {
            int iRandom = (int) (Math.random() * ((double) b.size()));
            str = null;
            iIntValue = -1;
            try {
                Iterator<Map.Entry<String, List<Integer>>> it = b.entrySet().iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, List<Integer>> next = it.next();
                    int i2 = i + 1;
                    if (i == iRandom) {
                        break;
                    }
                    i = i2;
                }
            } catch (Exception unused) {
            }
            if (str != null && str.length() > 0 && iIntValue > 0) {
                return new IPInfo(IPInfo.IP_Type.Notify, str, iIntValue);
            }
        }
        IPInfo.IP_Type iP_Type = IPInfo.IP_Type.Notify;
        IPInfo iPInfo = new IPInfo(iP_Type, "43.247.90.31", 2199);
        if (!nl0.c().equals("debug")) {
            return new IPInfo(iP_Type, "43.247.90.31", 2199);
        }
        if (nl0.c().equals("debug2")) {
            return new IPInfo(iP_Type, "43.247.90.31", 2199);
        }
        if (nl0.c().equals("dev")) {
            return new IPInfo(iP_Type, "43.247.90.217", 2199);
        }
        if (!nl0.c().equals("release")) {
            return iPInfo;
        }
        try {
            String[] strArrSplit = "121.46.192.78:2199;121.46.192.78:3569;121.46.192.78:4880;121.46.192.78:5465;121.46.192.78:7145;121.46.192.78:8368;121.46.192.78:9602;121.46.192.78:10323;121.46.192.78:6580;121.46.192.76:2199;121.46.192.76:3569;121.46.192.76:4880;121.46.192.76:5465;121.46.192.76:7145;121.46.192.76:8368;121.46.192.76:9602;121.46.192.76:10323;121.46.192.76:6580".split(x.aQ);
            int iNextInt = new Random().nextInt(strArrSplit.length);
            if (iNextInt >= strArrSplit.length) {
                iNextInt = 0;
            }
            String[] strArrSplit2 = strArrSplit[iNextInt].split(":");
            return new IPInfo(iP_Type, strArrSplit2[0], Integer.valueOf(strArrSplit2[1]).intValue());
        } catch (Exception unused2) {
            return System.currentTimeMillis() % 2 == 0 ? new IPInfo(IPInfo.IP_Type.Notify, "121.46.192.78", 2199) : new IPInfo(IPInfo.IP_Type.Notify, "121.46.192.76", 2199);
        }
        str = key;
        if (str != null) {
            return new IPInfo(IPInfo.IP_Type.Notify, str, iIntValue);
        }
        IPInfo.IP_Type iP_Type2 = IPInfo.IP_Type.Notify;
        IPInfo iPInfo2 = new IPInfo(iP_Type2, "43.247.90.31", 2199);
        if (!nl0.c().equals("debug")) {
        }
    }

    public static Map<String, List<Integer>> b() {
        if (b == null) {
            b = new HashMap();
        }
        b.clear();
        if (f11946a) {
            ArrayList arrayList = new ArrayList();
            for (int i = 1; i < 10; i++) {
                arrayList.add(Integer.valueOf(i * 1111));
            }
            for (int i2 = 1; i2 < 10; i2++) {
                b.put("17.2.0." + i2, arrayList);
            }
        }
        try {
            DNSNode[] dNSNodeArrI = it0.k().i(nl0.x);
            if (dNSNodeArrI == null || dNSNodeArrI.length == 0) {
                return null;
            }
            for (DNSNode dNSNode : dNSNodeArrI) {
                List<Integer> arrayList2 = b.get(dNSNode.host);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                ArrayList arrayList3 = new ArrayList(arrayList2);
                arrayList3.add(Integer.valueOf(dNSNode.port));
                b.put(dNSNode.host, arrayList3);
            }
            return b;
        } catch (Exception unused) {
            return null;
        }
    }
}
