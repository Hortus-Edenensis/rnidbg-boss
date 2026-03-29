package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.C1401r;
import com.xiaomi.push.dy;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fq;
import com.xiaomi.push.fx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ServiceClient {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ServiceClient f860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f861a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f866a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Messenger f867b;
    private static String b = fx.a(5) + "-";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f11663a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Messenger f864a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final BroadcastReceiver f862a = new BroadcastReceiver() { // from class: com.xiaomi.push.service.ServiceClient.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.push.au.m174a();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<Message> f865a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f868b = false;

    private ServiceClient(Context context) {
        this.f866a = false;
        Context applicationContext = context.getApplicationContext();
        this.f863a = applicationContext;
        C1401r.a(applicationContext);
        a(this.f863a);
        if (m669a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f866a = true;
        }
    }

    private void b() {
        this.f863a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f863a, (Class<?>) XMPushService.class), 1, 1);
    }

    public static ServiceClient getInstance(Context context) {
        if (f860a == null) {
            f860a = new ServiceClient(context);
        }
        return f860a;
    }

    public static String getSession() {
        return f861a;
    }

    public static void setSession(String str) {
        f861a = str;
    }

    public boolean batchSendMessage(fn[] fnVarArr, boolean z) {
        if (!com.xiaomi.push.au.m175a(this.f863a)) {
            return false;
        }
        Intent intentA = a();
        int length = fnVarArr.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i = 0; i < fnVarArr.length; i++) {
            String strA = dy.a();
            if (!TextUtils.isEmpty(strA)) {
                fl flVar = new fl("pf", null, null, null);
                fl flVar2 = new fl("sent", null, null, null);
                flVar2.m453a(strA);
                flVar.a(flVar2);
                fnVarArr[i].a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fnVarArr[i].mo455a());
            bundleArr[i] = fnVarArr[i].a();
        }
        if (length <= 0) {
            return false;
        }
        intentA.setAction(an.g);
        intentA.putExtra(an.J, f861a);
        intentA.putExtra("ext_packets", bundleArr);
        intentA.putExtra("ext_encrypt", z);
        return startServiceSafely(intentA);
    }

    public void checkAlive() {
        Intent intentA = a();
        intentA.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(intentA);
    }

    public boolean closeChannel() {
        Intent intentA = a();
        intentA.setAction(an.i);
        return startServiceSafely(intentA);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f866a;
    }

    public boolean notifyMessage(Bundle bundle, String str, String str2) {
        if (bundle == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Failed to notify message: bundle|userId|chid may be empty");
            return false;
        }
        Intent intentA = a();
        intentA.setAction(an.o);
        intentA.putExtras(bundle);
        com.xiaomi.channel.commonutils.logger.b.e("notify: chid=" + str2 + " bundle:" + bundle);
        return startServiceSafely(intentA);
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, a(list), a(list2), z);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean sendIQ(fm fmVar) {
        if (!com.xiaomi.push.au.m175a(this.f863a)) {
            return false;
        }
        Intent intentA = a();
        Bundle bundleA = fmVar.a();
        if (bundleA == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fmVar.mo455a());
        intentA.setAction(an.f);
        intentA.putExtra(an.J, f861a);
        intentA.putExtra("ext_packet", bundleA);
        return startServiceSafely(intentA);
    }

    public boolean sendMessage(fn fnVar, boolean z) {
        if (!com.xiaomi.push.au.m175a(this.f863a)) {
            return false;
        }
        Intent intentA = a();
        String strA = dy.a();
        if (!TextUtils.isEmpty(strA)) {
            fl flVar = new fl("pf", null, null, null);
            fl flVar2 = new fl("sent", null, null, null);
            flVar2.m453a(strA);
            flVar.a(flVar2);
            fnVar.a(flVar);
        }
        Bundle bundleA = fnVar.a();
        if (bundleA == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fnVar.mo455a());
        intentA.setAction(an.e);
        intentA.putExtra(an.J, f861a);
        intentA.putExtra("ext_packet", bundleA);
        intentA.putExtra("ext_encrypt", z);
        return startServiceSafely(intentA);
    }

    public boolean sendPresence(fq fqVar) {
        if (!com.xiaomi.push.au.m175a(this.f863a)) {
            return false;
        }
        Intent intentA = a();
        Bundle bundleA = fqVar.a();
        if (bundleA == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fqVar.mo455a());
        intentA.setAction(an.h);
        intentA.putExtra(an.J, f861a);
        intentA.putExtra("ext_packet", bundleA);
        return startServiceSafely(intentA);
    }

    public void setMessenger(Messenger messenger) {
        this.f864a = messenger;
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (com.xiaomi.push.j.m650a() || Build.VERSION.SDK_INT < 26) {
                this.f863a.startService(intent);
                return true;
            }
            m668a(intent);
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, a(list), a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent intentA = a();
        intentA.setAction(an.j);
        a(intentA, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(intentA);
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent intentA = a();
        intentA.setAction(an.d);
        a(intentA, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(intentA);
        return 0;
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent intentA = a();
        intentA.setAction(an.k);
        a(intentA, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(intentA);
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent intentA = a();
        intentA.setAction(an.l);
        if (map != null) {
            String strA = a(map);
            if (!TextUtils.isEmpty(strA)) {
                intentA.putExtra(an.D, strA);
            }
        }
        if (map2 != null) {
            String strA2 = a(map2);
            if (!TextUtils.isEmpty(strA2)) {
                intentA.putExtra(an.E, strA2);
            }
        }
        intentA.putExtra(an.v, str);
        startServiceSafely(intentA);
    }

    public boolean closeChannel(String str) {
        Intent intentA = a();
        intentA.setAction(an.i);
        intentA.putExtra(an.v, str);
        return startServiceSafely(intentA);
    }

    private void a(Context context) {
        try {
            com.xiaomi.push.au.m170a(context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m74a("add network status listener failed:" + th);
        }
    }

    private Map<String, String> a(List<NameValuePair> list) {
        HashMap map = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair nameValuePair : list) {
                if (nameValuePair != null) {
                    map.put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        }
        return map;
    }

    public boolean closeChannel(String str, String str2) {
        Intent intentA = a();
        intentA.setAction(an.i);
        intentA.putExtra(an.v, str);
        intentA.putExtra(an.s, str2);
        return startServiceSafely(intentA);
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(an.s, str);
        intent.putExtra(an.v, str2);
        intent.putExtra(an.z, str3);
        intent.putExtra(an.B, str5);
        intent.putExtra(an.A, str4);
        intent.putExtra(an.C, z);
        intent.putExtra(an.J, f861a);
        intent.putExtra(an.N, this.f864a);
        if (map != null && map.size() > 0) {
            String strA = a(map);
            if (!TextUtils.isEmpty(strA)) {
                intent.putExtra(an.D, strA);
            }
        }
        if (map2 == null || map2.size() <= 0) {
            return;
        }
        String strA2 = a(map2);
        if (TextUtils.isEmpty(strA2)) {
            return;
        }
        intent.putExtra(an.E, strA2);
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String strSubstring;
        if (com.xiaomi.push.au.m175a(this.f863a) && bArr != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intentA = a();
            intentA.setAction(an.e);
            intentA.putExtra(an.J, f861a);
            intentA.putExtra("ext_raw_packet", bArr);
            int iIndexOf = str.indexOf("@");
            String strSubstring2 = null;
            String strSubstring3 = iIndexOf != -1 ? str.substring(0, iIndexOf) : null;
            int iLastIndexOf = str.lastIndexOf("/");
            if (iLastIndexOf != -1) {
                strSubstring2 = str.substring(iIndexOf + 1, iLastIndexOf);
                strSubstring = str.substring(iLastIndexOf + 1);
            } else {
                strSubstring = null;
            }
            intentA.putExtra(an.s, strSubstring3);
            intentA.putExtra(an.t, strSubstring2);
            intentA.putExtra(an.u, strSubstring);
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            long j = f11663a;
            f11663a = 1 + j;
            sb.append(j);
            String string = sb.toString();
            intentA.putExtra("ext_pkt_id", string);
            intentA.putExtra("ext_chid", str2);
            com.xiaomi.channel.commonutils.logger.b.e("SEND: chid=" + str2 + ", packetId=" + string);
            return startServiceSafely(intentA);
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
        return false;
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            if (i < map.size()) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m669a() {
        if (com.xiaomi.push.x.f1046a) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f863a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private String m665a() {
        try {
            return this.f863a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    private Intent a() {
        if (isMiuiPushServiceEnabled()) {
            Intent intent = new Intent();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m665a());
            intent.putExtra(an.F, this.f863a.getPackageName());
            m667a();
            return intent;
        }
        Intent intent2 = new Intent(this.f863a, (Class<?>) XMPushService.class);
        intent2.putExtra(an.F, this.f863a.getPackageName());
        b();
        return intent2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m667a() {
        this.f863a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f863a, (Class<?>) XMPushService.class), 2, 1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private synchronized void m668a(Intent intent) {
        if (this.f868b) {
            Message messageA = a(intent);
            if (this.f865a.size() >= 50) {
                this.f865a.remove(0);
            }
            this.f865a.add(messageA);
            return;
        }
        if (this.f867b == null) {
            this.f863a.bindService(intent, new ServiceConnection() { // from class: com.xiaomi.push.service.ServiceClient.2
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (ServiceClient.this) {
                        ServiceClient.this.f867b = new Messenger(iBinder);
                        ServiceClient.this.f868b = false;
                        Iterator it = ServiceClient.this.f865a.iterator();
                        while (it.hasNext()) {
                            try {
                                ServiceClient.this.f867b.send((Message) it.next());
                            } catch (RemoteException e) {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                            }
                        }
                        ServiceClient.this.f865a.clear();
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    ServiceClient.this.f867b = null;
                    ServiceClient.this.f868b = false;
                }
            }, 1);
            this.f868b = true;
            this.f865a.clear();
            this.f865a.add(a(intent));
        } else {
            try {
                this.f867b.send(a(intent));
            } catch (RemoteException unused) {
                this.f867b = null;
                this.f868b = false;
            }
        }
    }

    private Message a(Intent intent) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 17;
        messageObtain.obj = intent;
        return messageObtain;
    }
}
