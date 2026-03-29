package com.bytedance.sdk.component.a.fx;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import com.ss.android.download.api.constant.BaseConstants;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private boolean b;
    private int bg;
    private u fx;
    private b n;
    private nr pn;
    private Context x;
    private long nr = 0;
    private boolean iz = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5076a = 0;
    private long jk = 19700101000L;
    private int t = 0;
    private HashMap<String, Integer> l = new HashMap<>();
    private HashMap<String, Integer> mv = new HashMap<>();
    private int s = 0;
    private HashMap<String, Integer> k = new HashMap<>();
    private HashMap<String, Integer> my = new HashMap<>();
    private boolean o = true;
    private Map<String, Integer> sx = new HashMap();
    Handler u = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.component.a.fx.pn.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            pn.this.nr(message.arg1 != 0);
        }
    };

    private pn() {
    }

    private void a() {
        SharedPreferences sharedPreferencesNr = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.x, u(), 0);
        this.f5076a = sharedPreferencesNr.getInt("tnc_probe_cmd", 0);
        this.jk = sharedPreferencesNr.getLong("tnc_probe_version", 19700101000L);
    }

    private void jk() {
        com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "resetTNCControlState");
        this.t = 0;
        this.l.clear();
        this.mv.clear();
        this.s = 0;
        this.k.clear();
        this.my.clear();
    }

    private boolean u(int i) {
        return i >= 200 && i < 400;
    }

    public nr b() {
        return this.pn;
    }

    public boolean fx() {
        return this.b;
    }

    public fx iz() {
        b bVar = this.n;
        if (bVar != null) {
            return bVar.fx();
        }
        return null;
    }

    public b n() {
        return this.n;
    }

    public u nr() {
        return this.fx;
    }

    public void pn() {
        this.sx.clear();
    }

    public Map<String, String> x() {
        fx fxVarIz = iz();
        if (fxVarIz != null) {
            return fxVarIz.b;
        }
        return null;
    }

    private boolean b(String str) {
        Map<String, String> mapX = x();
        if (mapX == null) {
            return false;
        }
        String str2 = mapX.get(str);
        if (TextUtils.isEmpty(str2) || this.sx.get(str2) == null || this.sx.get(str2).intValue() < 3) {
            return false;
        }
        com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "handleHostMapping, TNC host faild num over limit: ".concat(String.valueOf(str)));
        return true;
    }

    private void fx(String str) {
        if (!TextUtils.isEmpty(str) && this.sx.containsKey(str)) {
            this.sx.put(str, 0);
        }
    }

    private void nr(String str) {
        Map<String, String> mapX;
        if (TextUtils.isEmpty(str) || (mapX = x()) == null || !mapX.containsValue(str)) {
            return;
        }
        if (this.sx.get(str) == null) {
            this.sx.put(str, 1);
        } else {
            this.sx.put(str, Integer.valueOf(this.sx.get(str).intValue() + 1));
        }
    }

    public String u() {
        return "ttnet_tnc_config" + this.bg;
    }

    public void u(boolean z) {
        this.b = z;
    }

    public void u(nr nrVar) {
        this.pn = nrVar;
    }

    public synchronized void u(Context context, boolean z) {
        if (!this.iz) {
            this.x = context;
            this.o = z;
            this.n = new b(context, z, this.bg);
            if (z) {
                a();
            }
            com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.f5076a + " probeVersion: " + this.jk);
            this.fx = x.u().u(this.bg, this.x);
            this.iz = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(boolean z) {
        fx fxVarIz = iz();
        if (fxVarIz == null) {
            return;
        }
        com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "doUpdateRemote, ".concat(String.valueOf(z)));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.nr + (((long) fxVarIz.t) * 1000) > jElapsedRealtime) {
            com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "doUpdateRemote, time limit");
        } else {
            this.nr = jElapsedRealtime;
            x.u().u(this.bg, this.x).fx();
        }
    }

    public pn(int i) {
        this.bg = i;
    }

    public String u(String str) {
        String protocol;
        if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v4") && !str.contains("/ies/speed")) {
            String host = null;
            try {
                URL url = new URL(str);
                protocol = url.getProtocol();
                try {
                    host = url.getHost();
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                protocol = null;
            }
            if (!TextUtils.isEmpty(protocol) && ((HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || BaseConstants.SCHEME_HTTPS.equals(protocol)) && !TextUtils.isEmpty(host))) {
                if (b(host)) {
                    com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "handleHostMapping, TNC host faild num over limit: ".concat(String.valueOf(host)));
                    return str;
                }
                Map<String, String> mapX = x();
                if (mapX != null && mapX.containsKey(host)) {
                    String str2 = mapX.get(host);
                    if (TextUtils.isEmpty(str2)) {
                        return str;
                    }
                    com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "handleHostMapping, match, origin: ".concat(str));
                    String str3 = protocol + "://" + host;
                    String str4 = protocol + "://" + str2;
                    if (str.startsWith(str3)) {
                        str = str.replaceFirst(str3, str4);
                    }
                    com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "handleHostMapping, target: ".concat(String.valueOf(str)));
                    return str;
                }
                com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "handleHostMapping, nomatch: ".concat(String.valueOf(host)));
            }
        }
        return str;
    }

    private boolean nr(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        fx fxVarIz = iz();
        return (fxVarIz == null || TextUtils.isEmpty(fxVarIz.mv) || !fxVarIz.mv.contains(String.valueOf(i))) ? false : true;
    }

    public synchronized void u(s sVar, my myVar) {
        URL urlU;
        if (sVar == null || myVar == null) {
            return;
        }
        if (this.o) {
            if (com.bytedance.sdk.component.a.b.pn.u(this.x)) {
                try {
                    urlU = sVar.nr().u();
                } catch (Exception unused) {
                    urlU = null;
                }
                if (urlU == null) {
                    return;
                }
                String protocol = urlU.getProtocol();
                String host = urlU.getHost();
                String path = urlU.getPath();
                String strU = u(sVar);
                int iFx = myVar.fx();
                if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || BaseConstants.SCHEME_HTTPS.equals(protocol)) {
                    if (TextUtils.isEmpty(strU)) {
                        return;
                    }
                    com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + strU + "#" + iFx);
                    fx fxVarIz = iz();
                    if (fxVarIz != null && fxVarIz.nr) {
                        u(myVar, host);
                    }
                    if (fxVarIz == null) {
                        return;
                    }
                    com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + strU + "#" + iFx + " " + this.t + "#" + this.l.size() + "#" + this.mv.size() + " " + this.s + "#" + this.k.size() + "#" + this.my.size());
                    if (iFx > 0) {
                        if (u(iFx)) {
                            if (this.t > 0 || this.s > 0) {
                                jk();
                            }
                            fx(host);
                            return;
                        }
                        if (!nr(iFx)) {
                            this.s++;
                            this.k.put(path, 0);
                            this.my.put(strU, 0);
                            if (this.s >= fxVarIz.n && this.k.size() >= fxVarIz.f5075a && this.my.size() >= fxVarIz.jk) {
                                com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + strU + "#" + iFx);
                                u(false, 0L);
                                jk();
                            }
                            nr(host);
                        }
                    }
                }
            }
        }
    }

    private String u(s sVar) {
        if (sVar == null || sVar.nr() == null || sVar.nr().u() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(sVar.nr().u().getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    public synchronized void u(s sVar, Exception exc) {
        URL urlU;
        if (sVar != null) {
            if (sVar.nr() != null && exc != null) {
                if (this.o) {
                    if (com.bytedance.sdk.component.a.b.pn.u(this.x)) {
                        try {
                            urlU = sVar.nr().u();
                        } catch (Exception unused) {
                            urlU = null;
                        }
                        if (urlU == null) {
                            return;
                        }
                        String protocol = urlU.getProtocol();
                        String host = urlU.getHost();
                        String path = urlU.getPath();
                        String strU = u(sVar);
                        if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || BaseConstants.SCHEME_HTTPS.equals(protocol)) {
                            fx fxVarIz = iz();
                            if (fxVarIz == null) {
                                return;
                            }
                            com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + strU + "# " + this.t + "#" + this.l.size() + "#" + this.mv.size() + " " + this.s + "#" + this.k.size() + "#" + this.my.size());
                            this.t = this.t + 1;
                            this.l.put(path, 0);
                            this.mv.put(strU, 0);
                            if (this.t >= fxVarIz.pn && this.l.size() >= fxVarIz.iz && this.mv.size() >= fxVarIz.x) {
                                com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + strU);
                                u(false, 0L);
                                jk();
                            }
                            nr(host);
                        }
                    }
                }
            }
        }
    }

    private void u(my myVar, String str) {
        int i;
        long j;
        fx fxVarIz;
        if (myVar != null && this.o) {
            String strU = myVar.u("tnc-cmd", null);
            if (TextUtils.isEmpty(strU)) {
                com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "handleTncProbe, no probeProto, ".concat(String.valueOf(str)));
                return;
            }
            String[] strArrSplit = strU.split("@");
            if (strArrSplit != null && strArrSplit.length == 2) {
                try {
                    i = Integer.parseInt(strArrSplit[0]);
                } catch (Throwable unused) {
                    i = 0;
                }
                try {
                    j = Long.parseLong(strArrSplit[1]);
                } catch (Throwable unused2) {
                    com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "handleTncProbe, probeProto except, ".concat(String.valueOf(str)));
                    j = 0;
                }
                com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "handleTncProbe, local: " + this.f5076a + "@" + this.jk + " svr: " + i + "@" + j + " " + str);
                if (j <= this.jk) {
                    return;
                }
                this.f5076a = i;
                this.jk = j;
                com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.x, u(), 0).edit().putInt("tnc_probe_cmd", i).putLong("tnc_probe_version", j).apply();
                if (this.f5076a != 10000 || (fxVarIz = iz()) == null) {
                    return;
                }
                Random random = new Random(System.currentTimeMillis());
                int i2 = fxVarIz.l;
                long jNextInt = i2 > 0 ? ((long) random.nextInt(i2)) * 1000 : 0L;
                com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "handleTncProbe, updateConfig delay: " + jNextInt + " " + str);
                u(true, jNextInt);
                return;
            }
            com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "handleTncProbe, probeProto err, ".concat(String.valueOf(str)));
        }
    }

    private void u(boolean z, long j) {
        if (this.u.hasMessages(10000)) {
            return;
        }
        Message messageObtainMessage = this.u.obtainMessage();
        messageObtainMessage.what = 10000;
        messageObtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.u.sendMessageDelayed(messageObtainMessage, j);
        } else {
            this.u.sendMessage(messageObtainMessage);
        }
    }
}
