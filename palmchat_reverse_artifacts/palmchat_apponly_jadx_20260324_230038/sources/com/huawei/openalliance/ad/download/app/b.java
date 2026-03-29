package com.huawei.openalliance.ad.download.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.z;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {
    private static final String B = "reserveappstatus";
    private static final String C = "com.huawei.hms.pps.action.APP_RESERVE_STATUS_CHANGED";
    private static final String Code = "AgReserveDownloadManager";
    private static final String D = "com.huawei.appmarket.RECV_THIRD_COMMON_MSG";
    private static final int F = 2;
    private static final String I = "com.huawei.appgallery.reserveappstatus";
    private static b L = null;
    private static final String S = "callerpackage";
    private static final byte[] V = new byte[0];
    private static final String Z = "reserveapp";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f6935a;
    private c b;
    private com.huawei.openalliance.ad.download.f c;
    private Context d;
    private Map<String, WeakHashMap<com.huawei.openalliance.ad.download.g, Object>> e = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            fh.V(b.Code, "reserve broadcast.");
            try {
                SafeIntent safeIntent = new SafeIntent(intent);
                String action = safeIntent.getAction();
                if (b.I.equals(action)) {
                    b.this.Code(safeIntent);
                } else {
                    fh.I(b.Code, "inValid para %s.", action);
                }
            } catch (IllegalStateException e) {
                fh.I(b.Code, "reserve onReceive IllegalStateException: %s", e.getClass().getSimpleName());
            } catch (Exception e2) {
                fh.I(b.Code, "reserve onReceive Exception: %s", e2.getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.download.app.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0447b implements RemoteCallResultCallback<String> {
        private C0447b() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            fh.V(b.Code, "reserve app %s.", Integer.valueOf(callResult.getCode()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            fh.V(b.Code, "silent reserve broadcast.");
            b.this.Code(context, intent);
        }
    }

    private b(Context context) {
        String str;
        this.d = context.getApplicationContext();
        try {
            Code();
        } catch (IllegalStateException unused) {
            str = "registerReceiver IllegalStateException";
            fh.I(Code, str);
        } catch (Exception unused2) {
            str = "registerReceiver Exception";
            fh.I(Code, str);
        }
    }

    public static b Code(Context context) {
        b bVar;
        synchronized (V) {
            if (L == null) {
                L = new b(context);
            }
            bVar = L;
        }
        return bVar;
    }

    private void V(String str, int i) {
        WeakHashMap<com.huawei.openalliance.ad.download.g, Object> weakHashMapCode = Code(str);
        if (weakHashMapCode != null && weakHashMapCode.size() > 0) {
            for (com.huawei.openalliance.ad.download.g gVar : weakHashMapCode.keySet()) {
                if (gVar != null) {
                    gVar.Code(str, i);
                }
            }
        }
        com.huawei.openalliance.ad.download.f fVar = this.c;
        if (fVar != null) {
            fVar.Code(str, i);
        }
    }

    private synchronized WeakHashMap<com.huawei.openalliance.ad.download.g, Object> Code(String str) {
        return this.e.get(str);
    }

    public synchronized void V(String str, com.huawei.openalliance.ad.download.g gVar) {
        WeakHashMap<com.huawei.openalliance.ad.download.g, Object> weakHashMap = this.e.get(str);
        if (weakHashMap != null && weakHashMap.size() > 0) {
            weakHashMap.remove(gVar);
            if (weakHashMap.size() <= 0) {
                this.e.remove(str);
            }
        }
    }

    private void Code() {
        this.f6935a = new a();
        z.Code(this.d, this.f6935a, new IntentFilter(I), D, null);
        this.b = new c();
        z.Code(this.d, this.b, new IntentFilter(C), "com.huawei.permission.app.DOWNLOAD", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Context context, Intent intent) {
        try {
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (C.equals(action) && context != null) {
                String stringExtra = safeIntent.getStringExtra(S);
                String packageName = context.getPackageName();
                if (!bc.Code(stringExtra, packageName)) {
                    fh.V(Code, "caller does not match, caller %s, currentPackage %s.", stringExtra, packageName);
                    return;
                } else if (safeIntent.getIntExtra(B, -1) == 0) {
                    fh.V(Code, "silent reserve failed no need to notify");
                    return;
                } else {
                    Code(safeIntent);
                    return;
                }
            }
            fh.I(Code, "reserve onReceive inValid para %s.", action);
        } catch (IllegalStateException e) {
            fh.I(Code, "silent reserve onReceive IllegalStateException: %s", e.getClass().getSimpleName());
        } catch (Exception e2) {
            fh.I(Code, "silent reserve onReceive Exception: %s", e2.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Intent intent) {
        String stringExtra = intent.getStringExtra(Z);
        int intExtra = intent.getIntExtra(B, -1);
        fh.V(Code, "reserve status: %s", Integer.valueOf(intExtra));
        if (intExtra == 1 || intExtra == 0) {
            Code(stringExtra, intExtra);
        }
        if (intExtra == 2) {
            intExtra = 1;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            fh.V(Code, "pkg is null");
        } else {
            V(stringExtra, intExtra);
        }
    }

    public void Code(AppDownloadTask appDownloadTask) {
        com.huawei.openalliance.ad.download.app.c.Z(this.d, appDownloadTask, new C0447b(), String.class);
    }

    public void Code(com.huawei.openalliance.ad.download.f fVar) {
        this.c = fVar;
    }

    public void Code(String str, int i) {
        try {
            fh.V(Code, "start report reserve result");
            JSONObject jSONObject = new JSONObject();
            AnalysisEventReport analysisEventReport = new AnalysisEventReport();
            analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.I);
            analysisEventReport.I(str);
            analysisEventReport.Z(String.valueOf(i));
            jSONObject.put(bq.f.T, ad.V(analysisEventReport));
            fh.Code(Code, "report reserve result analysis: %s", jSONObject.toString());
            db.Code(this.d, jSONObject.toString());
        } catch (Exception e) {
            fh.I(Code, "report reserve result analysis error: %s", e.getClass().getSimpleName());
        }
    }

    public synchronized void Code(String str, com.huawei.openalliance.ad.download.g gVar) {
        WeakHashMap<com.huawei.openalliance.ad.download.g, Object> weakHashMap = this.e.get(str);
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap<>();
            this.e.put(str, weakHashMap);
        }
        weakHashMap.put(gVar, null);
    }
}
