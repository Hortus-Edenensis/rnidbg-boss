package com.huawei.openalliance.ad.download.app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.gd;
import com.huawei.hms.ads.gk;
import com.huawei.openalliance.ad.activity.AgProtocolActivity;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.download.DownloadListener;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ao;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.bl;
import com.huawei.openalliance.ad.utils.z;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e implements DownloadListener<AppDownloadTask>, com.huawei.openalliance.ad.download.e<AppDownloadTask>, NotifyCallback {
    private static final String Code = "ApDnDe";
    private static Map<String, Method> S = new HashMap();
    private long B;
    private Context V;
    private AppDownloadListener Z;
    private Map<String, Set<com.huawei.openalliance.ad.download.g>> I = new ConcurrentHashMap();
    private String C = x.dE + hashCode();
    private BroadcastReceiver F = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.1.1
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb;
                    try {
                        String action = intent.getAction();
                        fh.Code(e.Code, "appRe action: %s", action);
                        e.this.Code(intent, action);
                    } catch (IllegalStateException e) {
                        e = e;
                        sb = new StringBuilder();
                        sb.append("appRe ");
                        sb.append(e.getClass().getSimpleName());
                        fh.I(e.Code, sb.toString());
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder();
                        sb.append("appRe ");
                        sb.append(e.getClass().getSimpleName());
                        fh.I(e.Code, sb.toString());
                    }
                }
            });
        }
    };
    private BroadcastReceiver D = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.e.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb;
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                fh.V(e.Code, "itRe action: %s", action);
                String dataString = intent.getDataString();
                if (TextUtils.isEmpty(dataString)) {
                    fh.I(e.Code, "itRe dataString is empty, " + action);
                    return;
                }
                final String strSubstring = dataString.substring(8);
                e.this.Code(action, strSubstring);
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.onAppInstalled(g.I().Code(strSubstring));
                        }
                    });
                    return;
                }
                if ("android.intent.action.PACKAGE_DATA_CLEARED".equals(action)) {
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        fh.V(e.Code, "a bad intent");
                    } else if (schemeSpecificPart.equals(com.huawei.openalliance.ad.utils.h.I(context))) {
                        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                g.I().V();
                            }
                        });
                    }
                }
            } catch (IllegalStateException e) {
                e = e;
                sb = new StringBuilder();
                sb.append("itRe:");
                sb.append(e.getClass().getSimpleName());
                fh.I(e.Code, sb.toString());
            } catch (Exception e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("itRe:");
                sb.append(e.getClass().getSimpleName());
                fh.I(e.Code, sb.toString());
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {
        private WeakReference<e> Code;

        public a(e eVar) {
            this.Code = new WeakReference<>(eVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = this.Code.get();
            if (eVar == null) {
                return;
            }
            eVar.I();
        }
    }

    public e(Context context) {
        this.V = context.getApplicationContext();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("huawei.intent.action.DOWNLOAD");
            intentFilter.addAction("huawei.intent.action.OPEN");
            intentFilter.addAction(d.Z);
            intentFilter.addAction(d.d);
            intentFilter.addAction(d.C);
            intentFilter.addAction("huawei.intent.action.PPS_APP_USER_CANCEL");
            z.Code(this.V, this.F, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            if (z.B(this.V)) {
                com.huawei.openalliance.ad.msgnotify.b.Code(context, d.j, this);
            } else {
                com.huawei.openalliance.ad.msgnotify.b.V(context, d.j, this);
            }
            gk.Code(context).Code();
            Z();
        } catch (Throwable th) {
            fh.I(Code, "registerReceiver " + th.getClass().getSimpleName());
        }
    }

    private void B(Intent intent) {
        String str;
        if (intent == null) {
            str = "msgData is empty!";
        } else {
            SafeIntent safeIntent = new SafeIntent(intent);
            String stringExtra = safeIntent.getStringExtra(be.aA);
            if (stringExtra == null || stringExtra.equals(this.V.getPackageName())) {
                String stringExtra2 = safeIntent.getStringExtra("contentRecord");
                if (fh.Code()) {
                    fh.Code(Code, "sendNotify content: %s", bl.Code(stringExtra2));
                }
                AdContentData adContentData = (AdContentData) ad.V(stringExtra2, AdContentData.class, new Class[0]);
                if (adContentData != null) {
                    String stringExtra3 = safeIntent.getStringExtra("unique_id");
                    AppInfo appInfoY = adContentData.y();
                    if (appInfoY == null || appInfoY.p() != 1 || TextUtils.isEmpty(appInfoY.q())) {
                        return;
                    }
                    int intExtra = safeIntent.getIntExtra(be.L, 1);
                    gd gdVar = new gd(this.V, adContentData, stringExtra3);
                    gdVar.Code(intExtra);
                    gdVar.I();
                    return;
                }
                str = " contentData is empty.";
            } else {
                str = "sourcePackageName not equals packageName.";
            }
        }
        fh.V(Code, str);
    }

    private synchronized Set<com.huawei.openalliance.ad.download.g> Code(AppInfo appInfo) {
        if (appInfo != null) {
            if (!TextUtils.isEmpty(appInfo.Code())) {
                return V(appInfo.Code());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        fh.V(Code, "unRegisterAppInstReceiver");
        this.V.unregisterReceiver(this.D);
    }

    private static AppInfo V(Intent intent) {
        return (AppInfo) ad.V(new SafeIntent(intent).getStringExtra("appInfo"), AppInfo.class, new Class[0]);
    }

    private static void Z() {
        try {
            for (Method method : e.class.getDeclaredMethods()) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(AppDownloadTask.class)) {
                    S.put(method.getName(), method);
                }
            }
        } catch (Throwable th) {
            fh.Code(Code, "transport=%s", th.getMessage());
            fh.Z(Code, "transport=" + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
    public void onMessageNotify(String str, Intent intent) {
        if (TextUtils.isEmpty(str) || intent == null) {
            fh.V(Code, "msgName or msgData is empty!");
        } else {
            fh.Code(Code, "onMessageNotify msgName:%s", str);
            this.F.onReceive(this.V, intent);
        }
    }

    private void I(Intent intent) {
        try {
            if (d.Z.equals(intent.getAction())) {
                AppInfo appInfoV = V(intent);
                if (appInfoV == null) {
                    fh.V(Code, "appInfo is null");
                    return;
                }
                com.huawei.openalliance.ad.download.a aVarCode = com.huawei.openalliance.ad.download.a.Code();
                if (aVarCode != null) {
                    aVarCode.Code(appInfoV);
                }
            }
        } catch (Throwable th) {
            fh.I(Code, "exception: %s", th.getClass().getSimpleName());
        }
    }

    private synchronized Set<com.huawei.openalliance.ad.download.g> V(String str) {
        return this.I.get(str);
    }

    private void Z(Intent intent) {
        String stringExtra;
        int intExtra;
        String stringExtra2;
        try {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(d.e);
            if (pendingIntent != null) {
                Intent intent2 = new Intent();
                intent2.setClass(this.V, AgProtocolActivity.class);
                intent2.putExtra(d.e, pendingIntent);
                intExtra = intent.getIntExtra(d.f, 6);
                intent2.putExtra(d.f, intExtra);
                stringExtra = intent.getStringExtra(d.g);
                intent2.putExtra(d.g, stringExtra);
                stringExtra2 = intent.getStringExtra("ag_action_name");
                intent2.putExtra("ag_action_name", stringExtra2);
                intent2.addFlags(268959744);
                intent2.setClipData(x.cS);
                this.V.startActivity(intent2);
            } else {
                stringExtra = null;
                intExtra = -1;
                stringExtra2 = null;
            }
            db.Code(this.V, intExtra, stringExtra, stringExtra2, com.huawei.openalliance.ad.download.app.a.Code);
        } catch (Throwable unused) {
            fh.V(Code, " requestAgProtocol error");
        }
    }

    public void Code() {
        fh.V(Code, "registerAppInstReceiver");
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        intentFilter.addDataScheme("package");
        z.Code(this.V, this.D, intentFilter);
        V();
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onAppInstalled(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            appDownloadTask.Code(6);
            Code(AppStatus.INSTALLED, appDownloadTask);
            I(appDownloadTask);
            new m(appDownloadTask).Code();
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onAppUnInstalled(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            String strCode = appDownloadTask.L().Code();
            Set<com.huawei.openalliance.ad.download.g> setV = V(strCode);
            if (setV != null && setV.size() > 0) {
                Iterator<com.huawei.openalliance.ad.download.g> it = setV.iterator();
                while (it.hasNext()) {
                    it.next().I(strCode);
                }
            }
            Code(AppStatus.DOWNLOAD, appDownloadTask);
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadDeleted(AppDownloadTask appDownloadTask) {
        appDownloadTask.I(0);
        appDownloadTask.V(0L);
        appDownloadTask.Code(4);
        I(appDownloadTask);
        Code(AppStatus.DOWNLOADFAILED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadFail(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            fh.V(Code, "onDownloadFail, current way: %s", appDownloadTask.j());
        }
        if (Code(appDownloadTask)) {
            return;
        }
        I(appDownloadTask);
        Code(AppStatus.DOWNLOADFAILED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadPaused(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(AppStatus.PAUSE, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadProgress(AppDownloadTask appDownloadTask) {
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.Z == null);
        fh.Code(Code, "onDownloadProgress: %s", objArr);
        V(appDownloadTask);
        AppDownloadListener appDownloadListener = this.Z;
        if (appDownloadListener != null) {
            appDownloadListener.Code(appDownloadTask.L(), appDownloadTask.S());
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadResumed(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(AppStatus.RESUME, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadStart(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(AppStatus.DOWNLOADING, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadSuccess(AppDownloadTask appDownloadTask) {
        this.B = eh.Code(this.V).h();
        Code();
        Code(AppStatus.DOWNLOADED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadWaiting(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(AppStatus.WAITING, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onSilentInstallFailed(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        fh.I(Code, "install apk failed, reason: %s", Integer.valueOf(appDownloadTask.o()));
        if (!(appDownloadTask.o() == 7)) {
            if ((appDownloadTask.o() == 1) || !Code(appDownloadTask)) {
                I(appDownloadTask);
                Code(appDownloadTask.B() == 4 ? AppStatus.DOWNLOAD : AppStatus.INSTALL, appDownloadTask);
                return;
            }
            return;
        }
        AppDownloadListener appDownloadListener = this.Z;
        if (appDownloadListener != null) {
            appDownloadListener.Code(appDownloadTask.L(), appDownloadTask.S());
        }
        if (appDownloadTask.l()) {
            fh.Code(Code, "switch next install way success");
        } else {
            fh.Code(Code, "switch next install way failed");
            appDownloadTask.B(0);
        }
        I(appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onSilentInstallStart(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(AppStatus.INSTALLING, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onSilentInstallSuccess(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(AppStatus.INSTALLED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onSystemInstallStart(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(AppStatus.INSTALL, appDownloadTask);
    }

    private void Code(Intent intent) {
        com.huawei.openalliance.ad.download.a aVarCode;
        try {
            AppInfo appInfoV = V(intent);
            if (appInfoV == null || (aVarCode = com.huawei.openalliance.ad.download.a.Code()) == null) {
                return;
            }
            aVarCode.V(appInfoV);
        } catch (Throwable th) {
            fh.I(Code, "onUserCancel ex: %s", th.getClass().getSimpleName());
        }
    }

    private void I(AppDownloadTask appDownloadTask) {
        Set<com.huawei.openalliance.ad.download.g> setCode = Code(appDownloadTask.L());
        if (setCode == null || setCode.size() <= 0) {
            return;
        }
        Iterator<com.huawei.openalliance.ad.download.g> it = setCode.iterator();
        while (it.hasNext()) {
            it.next().V(appDownloadTask);
        }
    }

    private void V() {
        ao.Code(this.C);
        ao.Code(new a(this), this.C, this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Intent intent, String str) {
        SafeIntent safeIntent = new SafeIntent(intent);
        if (!"huawei.intent.action.DOWNLOAD".equals(str)) {
            if ("huawei.intent.action.OPEN".equals(str)) {
                String stringExtra = safeIntent.getStringExtra("appPackageName");
                AppDownloadListener appDownloadListener = this.Z;
                if (appDownloadListener != null) {
                    appDownloadListener.Code(stringExtra);
                    return;
                }
                return;
            }
            if (d.Z.equals(str)) {
                I(safeIntent);
                return;
            }
            if (d.d.equals(str)) {
                fh.V(Code, "request intent");
                Z(safeIntent);
                return;
            } else if (d.C.equals(str)) {
                B(safeIntent);
                return;
            } else {
                if ("huawei.intent.action.PPS_APP_USER_CANCEL".equals(str)) {
                    Code(safeIntent);
                    return;
                }
                return;
            }
        }
        String stringExtra2 = safeIntent.getStringExtra("appPackageName");
        AppDownloadTask appDownloadTaskCode = g.I().Code(stringExtra2);
        if (appDownloadTaskCode == null) {
            fh.V(Code, " task is null, pkg=" + stringExtra2);
            I(stringExtra2);
            return;
        }
        String stringExtra3 = safeIntent.getStringExtra("appInfo");
        if (!TextUtils.isEmpty(stringExtra3)) {
            AppInfo appInfo = (AppInfo) ad.V(stringExtra3, AppInfo.class, new Class[0]);
            AppInfo appInfoL = appDownloadTaskCode.L();
            if (appInfo != null) {
                fh.V(Code, "update appInfo from remote task.");
                appInfoL.V(appInfo.e());
            }
        }
        Code(appDownloadTaskCode, safeIntent);
        String stringExtra4 = safeIntent.getStringExtra("appDownloadMethod");
        if (TextUtils.isEmpty(stringExtra4)) {
            return;
        }
        if (stringExtra4.equals("onDownloadDeleted")) {
            g.I().I(appDownloadTaskCode);
            return;
        }
        Method method = S.get(stringExtra4);
        if (method != null) {
            try {
                fh.Code(Code, "methodName:%s", stringExtra4);
                method.invoke(this, appDownloadTaskCode);
            } catch (IllegalAccessException unused) {
                fh.Code(Code, "ilex=%s", stringExtra4);
            } catch (InvocationTargetException unused2) {
                fh.Code(Code, "itex=%s", stringExtra4);
            }
        }
    }

    private void I(String str) {
        if (TextUtils.isEmpty(str)) {
            fh.V(Code, " packageName is empty.");
            return;
        }
        Set<com.huawei.openalliance.ad.download.g> setV = V(str);
        fh.Code(Code, " findAndRefreshTask list:%s", setV);
        if (setV == null || setV.size() <= 0) {
            return;
        }
        Iterator<com.huawei.openalliance.ad.download.g> it = setV.iterator();
        while (it.hasNext()) {
            it.next().Code(str);
        }
    }

    private void V(AppDownloadTask appDownloadTask) {
        Set<com.huawei.openalliance.ad.download.g> setCode = Code(appDownloadTask.L());
        if (setCode == null || setCode.size() <= 0) {
            return;
        }
        Iterator<com.huawei.openalliance.ad.download.g> it = setCode.iterator();
        while (it.hasNext()) {
            it.next().Code(appDownloadTask);
        }
    }

    private void Code(AppDownloadTask appDownloadTask, int i) {
        appDownloadTask.V((appDownloadTask.I() * ((long) i)) / 100);
    }

    public synchronized void V(String str, com.huawei.openalliance.ad.download.g gVar) {
        Set<com.huawei.openalliance.ad.download.g> set = this.I.get(str);
        if (set != null && set.size() > 0) {
            set.remove(gVar);
            if (set.size() <= 0) {
                this.I.remove(str);
            }
        }
    }

    private void Code(AppDownloadTask appDownloadTask, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        appDownloadTask.Code(safeIntent.getIntExtra("downloadStatus", 0));
        appDownloadTask.I(safeIntent.getIntExtra("downloadProgress", 0));
        appDownloadTask.Z(safeIntent.getIntExtra("pauseReason", 0));
        appDownloadTask.B(safeIntent.getIntExtra(d.l, 0));
        Code(appDownloadTask, appDownloadTask.S());
    }

    private void Code(AppStatus appStatus, AppDownloadTask appDownloadTask) {
        AppDownloadListener appDownloadListener = this.Z;
        if (appDownloadListener != null) {
            appDownloadListener.Code(appStatus, appDownloadTask.L());
        }
    }

    public void Code(AppDownloadListener appDownloadListener) {
        this.Z = appDownloadListener;
    }

    public void Code(String str) {
        NotificationManager notificationManager;
        if (TextUtils.isEmpty(str) || (notificationManager = (NotificationManager) this.V.getSystemService("notification")) == null) {
            return;
        }
        notificationManager.cancel(str.hashCode());
    }

    public synchronized void Code(String str, com.huawei.openalliance.ad.download.g gVar) {
        Set<com.huawei.openalliance.ad.download.g> hashSet = this.I.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.I.put(str, hashSet);
        }
        hashSet.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, String str2) {
        Set<com.huawei.openalliance.ad.download.g> setV = V(str2);
        if (setV != null && setV.size() > 0) {
            if ("android.intent.action.PACKAGE_ADDED".equals(str)) {
                for (com.huawei.openalliance.ad.download.g gVar : setV) {
                    if (gVar != null) {
                        gVar.V(str2);
                    }
                }
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(str)) {
                for (com.huawei.openalliance.ad.download.g gVar2 : setV) {
                    if (gVar2 != null) {
                        gVar2.I(str2);
                    }
                }
            }
        }
        if (!"android.intent.action.PACKAGE_REMOVED".equals(str) || this.Z == null) {
            return;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.b(str2);
        this.Z.Code(AppStatus.DOWNLOAD, appInfo);
    }

    @Override // com.huawei.openalliance.ad.download.e
    public boolean Code(AppDownloadTask appDownloadTask) {
        return g.I().Z(appDownloadTask);
    }
}
