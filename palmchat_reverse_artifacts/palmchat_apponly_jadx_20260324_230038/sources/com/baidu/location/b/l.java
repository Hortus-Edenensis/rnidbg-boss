package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3430a;
    private long b;
    private Context c;
    private BDHttpDns d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final l f3431a = new l();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Dns {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f3432a;
        private BDHttpDns b;

        private b(BDHttpDns bDHttpDns) {
            this.b = bDHttpDns;
        }

        public static b a(BDHttpDns bDHttpDns) {
            if (f3432a == null) {
                f3432a = new b(bDHttpDns);
            }
            return f3432a;
        }

        @Override // okhttp3.Dns
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            String str2;
            if (!com.baidu.location.e.d.f3525a.equals(str)) {
                return Dns.SYSTEM.lookup(str);
            }
            BDHttpDnsResult bDHttpDnsResultSyncResolve = this.b.syncResolve(str, true);
            ArrayList<String> ipv6List = bDHttpDnsResultSyncResolve.getIpv6List();
            ArrayList<String> ipv4List = bDHttpDnsResultSyncResolve.getIpv4List();
            if (ipv6List == null || ipv6List.isEmpty()) {
                str2 = (ipv4List == null || ipv4List.isEmpty()) ? null : ipv4List.get(0);
            } else {
                str2 = "[" + ipv6List.get(0) + "]";
            }
            return str2 != null ? Arrays.asList(InetAddress.getAllByName(str2)) : Dns.SYSTEM.lookup(str);
        }
    }

    private l() {
        this.f3430a = true;
        this.b = 0L;
    }

    public static l a() {
        return a.f3431a;
    }

    public int b() {
        return this.f3430a ? 1 : 0;
    }

    public Dns c() {
        return this.f3430a ? Dns.SYSTEM : b.a(this.d);
    }

    public void a(Context context) {
        if (c.b().eb == 0) {
            return;
        }
        this.c = context;
        this.f3430a = s.a(context).getBoolean("IsDomestic", true);
        this.b = s.a(context).getLong("update_result_time", 0L);
        if (this.f3430a) {
            com.baidu.location.e.d.a();
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("loc.map.baidu.com"));
        BDHttpDns service = BDHttpDns.getService(context);
        this.d = service;
        try {
            service.setAccountID("110001");
            this.d.setSecret("nHpsFU98hcqhzFWY17Ht");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        this.d.setHttpsRequestEnable(true);
        this.d.setNetworkSwitchPolicy(true, true);
        this.d.setCachePolicy(BDHttpDns.CachePolicy.POLICY_TOLERANT);
        this.d.setPreResolveHosts(arrayList);
    }

    public String b(String str) {
        String str2;
        if (this.f3430a) {
            return str;
        }
        try {
            String host = new URL(str).getHost();
            if (host != null && !host.isEmpty()) {
                BDHttpDnsResult bDHttpDnsResultSyncResolve = this.d.syncResolve(host, true);
                ArrayList<String> ipv6List = bDHttpDnsResultSyncResolve.getIpv6List();
                ArrayList<String> ipv4List = bDHttpDnsResultSyncResolve.getIpv4List();
                if (ipv6List == null || ipv6List.isEmpty()) {
                    str2 = (ipv4List == null || ipv4List.isEmpty()) ? null : ipv4List.get(0);
                } else {
                    str2 = "[" + ipv6List.get(0) + "]";
                }
                return str2 != null ? str.replaceFirst(host, str2) : str;
            }
            return str;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return str;
        }
    }

    public void a(BDLocation bDLocation) {
        if (c.b().eb != 1 || bDLocation.getLongitude() == Double.MIN_VALUE || bDLocation.getLatitude() == Double.MIN_VALUE || System.currentTimeMillis() - this.b <= c.b().ec) {
            return;
        }
        a(bDLocation, this.c);
    }

    private void a(BDLocation bDLocation, Context context) {
        double longitude;
        double latitude;
        String str;
        double[] dArrCoorEncrypt = new double[2];
        String coorType = bDLocation.getCoorType();
        if ("wgs84".equals(coorType)) {
            dArrCoorEncrypt[0] = bDLocation.getLongitude();
            dArrCoorEncrypt[1] = bDLocation.getLatitude();
        } else {
            double[] dArrCoorEncrypt2 = new double[2];
            if ("bd09ll".equals(coorType)) {
                longitude = bDLocation.getLongitude();
                latitude = bDLocation.getLatitude();
                str = BDLocation.BDLOCATION_BD09LL_TO_GCJ02;
            } else if ("bd09".equals(coorType)) {
                longitude = bDLocation.getLongitude();
                latitude = bDLocation.getLatitude();
                str = BDLocation.BDLOCATION_BD09_TO_GCJ02;
            } else {
                dArrCoorEncrypt2[0] = bDLocation.getLongitude();
                dArrCoorEncrypt2[1] = bDLocation.getLatitude();
                dArrCoorEncrypt = Jni.coorEncrypt(dArrCoorEncrypt2[0], dArrCoorEncrypt2[1], "gcj2wgs");
            }
            dArrCoorEncrypt2 = Jni.coorEncrypt(longitude, latitude, str);
            dArrCoorEncrypt = Jni.coorEncrypt(dArrCoorEncrypt2[0], dArrCoorEncrypt2[1], "gcj2wgs");
        }
        boolean zA = com.baidu.location.e.e.a().a(dArrCoorEncrypt[0], dArrCoorEncrypt[1]);
        try {
            this.b = System.currentTimeMillis();
            SharedPreferences sharedPreferencesA = s.a(context);
            if (sharedPreferencesA != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                editorEdit.putBoolean("IsDomestic", zA);
                editorEdit.putLong("update_result_time", this.b);
                editorEdit.apply();
            }
        } catch (Exception unused) {
        }
    }

    public boolean a(String str) {
        try {
            String host = new URL(str).getHost();
            if (this.f3430a) {
                return false;
            }
            return com.baidu.location.e.d.f3525a.equals(host);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
