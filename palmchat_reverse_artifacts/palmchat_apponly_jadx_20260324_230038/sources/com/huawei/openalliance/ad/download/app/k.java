package com.huawei.openalliance.ad.download.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jk;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ao;
import com.huawei.openalliance.ad.utils.z;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class k {
    private static final String Code = "GPDownloadManager";
    private static k S = null;
    private static final int V = 900000;
    private Context F;
    private static final byte[] I = new byte[0];
    private static final byte[] Z = new byte[0];
    private String B = x.dE + hashCode();
    private long C = 3600000;
    private Map<String, AppDownloadTask> D = new ConcurrentHashMap();
    private BroadcastReceiver L = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.k.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String dataString = safeIntent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                fh.I(k.Code, "itRer dataString is empty");
                return;
            }
            String strSubstring = dataString.substring(8);
            try {
                if ("android.intent.action.PACKAGE_ADDED".equals(safeIntent.getAction())) {
                    k.this.Code(strSubstring);
                }
            } catch (Throwable th) {
                fh.I(k.Code, "itRer: %s", th.getClass().getSimpleName());
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.S == null) {
                return;
            }
            k.S.Z();
        }
    }

    private k(Context context) {
        this.F = context.getApplicationContext();
    }

    public static k Code(Context context) {
        k kVar;
        synchronized (I) {
            if (S == null) {
                S = new k(context);
            }
            kVar = S;
        }
        return kVar;
    }

    private void I() {
        ao.Code(this.B);
        ao.Code(new a(), this.B, this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        fh.V(Code, "unRegisterAppInstReceiver");
        this.F.unregisterReceiver(this.L);
    }

    public void Code() {
        fh.V(Code, "registerAppInstReceiver");
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        z.Code(this.F, this.L, intentFilter);
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str) {
        fh.V(Code, "dealWithAdd");
        synchronized (Z) {
            if (this.D.containsKey(str)) {
                AppDownloadTask appDownloadTask = this.D.get(str);
                this.D.remove(str);
                fh.V(Code, "task size after remove: %s", Integer.valueOf(this.D.size()));
                AdContentData adContentDataF = appDownloadTask.f();
                if (adContentDataF != null && adContentDataF.y() != null) {
                    jk.Code(this.F, adContentDataF, appDownloadTask.b(), adContentDataF.y().k());
                }
            }
        }
    }

    public void Code(String str, AppDownloadTask appDownloadTask) {
        synchronized (Z) {
            fh.Code(Code, "task size before: %s", Integer.valueOf(this.D.size()));
            Iterator it = new ConcurrentHashMap(this.D).entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                fh.Code(Code, "entry key: %s time: %s", entry.getKey(), Long.valueOf(((AppDownloadTask) entry.getValue()).p()));
                if (System.currentTimeMillis() - ((AppDownloadTask) entry.getValue()).p() > 900000) {
                    this.D.remove(entry.getKey());
                }
            }
            this.D.put(str, appDownloadTask);
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.D.size());
            objArr[1] = str;
            objArr[2] = this.D.get(str) != null ? Long.valueOf(this.D.get(str).p()) : null;
            fh.V(Code, "task size after: %s, packageName: %s time: %s", objArr);
        }
    }
}
