package com.bytedance.sdk.component.a.fx;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.sdk.component.a.u;
import com.bytedance.sdk.component.jk.jk;
import com.bytedance.sdk.component.utils.bq;
import com.bytedance.sdk.component.utils.rh;
import com.heytap.mcssdk.constant.a;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements rh.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f5077a;
    private static boolean n;
    private com.bytedance.sdk.component.a.u mv;
    private final boolean nr;
    private int s;
    private final Context t;
    private volatile boolean fx = false;
    private boolean b = true;
    private boolean pn = false;
    private long iz = 0;
    private long x = 0;
    private AtomicBoolean jk = new AtomicBoolean(false);
    private volatile boolean l = false;
    final rh u = com.bytedance.sdk.component.jk.nr.u.u().u(this, "tt-net");

    public u(Context context, int i) {
        this.t = context;
        this.nr = bq.u(context);
        this.s = i;
    }

    private com.bytedance.sdk.component.a.u a() {
        if (this.mv == null) {
            u.C0203u c0203u = new u.C0203u();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.mv = c0203u.u(10L, timeUnit).nr(10L, timeUnit).fx(10L, timeUnit).u();
        }
        return this.mv;
    }

    private void b(boolean z) {
        if (this.pn) {
            return;
        }
        if (this.b) {
            this.b = false;
            this.iz = 0L;
            this.x = 0L;
        }
        long j = z ? 360000L : a.g;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.iz > j) {
            if (jCurrentTimeMillis - this.x > 120000 || !this.l) {
                fx();
            }
        }
    }

    private boolean n() {
        String[] strArrIz = iz();
        if (strArrIz != null && strArrIz.length != 0) {
            u(0);
        }
        return false;
    }

    public static ThreadPoolExecutor x() {
        if (f5077a == null) {
            synchronized (u.class) {
                if (f5077a == null) {
                    com.bytedance.sdk.component.jk.b.b bVar = new com.bytedance.sdk.component.jk.b.b(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new jk("tnc/AppConfig"));
                    f5077a = bVar;
                    bVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f5077a;
    }

    public boolean fx() {
        com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "doRefresh: updating state " + this.jk.get());
        x().execute(new Runnable() { // from class: com.bytedance.sdk.component.a.fx.u.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zU = com.bytedance.sdk.component.a.b.pn.u(u.this.t);
                if (zU) {
                    u.this.x = System.currentTimeMillis();
                    if (u.this.jk.compareAndSet(false, true)) {
                        u.this.fx(zU);
                    } else {
                        com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "doRefresh, already running");
                    }
                }
            }
        });
        return true;
    }

    public Context getContext() {
        return this.t;
    }

    public String[] iz() {
        String[] strArrIz = x.u().u(this.s).b() != null ? x.u().u(this.s).b().iz() : null;
        return (strArrIz == null || strArrIz.length <= 0) ? new String[0] : strArrIz;
    }

    public void pn() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.nr) {
                b();
            } else {
                nr();
            }
        } catch (Throwable unused) {
        }
    }

    public static void nr(boolean z) {
        n = z;
    }

    public void fx(boolean z) {
        com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "doRefresh, actual request");
        b();
        this.pn = true;
        if (!z) {
            this.u.sendEmptyMessage(102);
            return;
        }
        try {
            n();
        } catch (Exception unused) {
            this.jk.set(false);
        }
    }

    public synchronized void nr() {
        if (System.currentTimeMillis() - this.iz > 3600000) {
            this.iz = System.currentTimeMillis();
            try {
                if (x.u().u(this.s).n() != null) {
                    x.u().u(this.s).n().nr();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void u() {
        u(false);
    }

    public synchronized void u(boolean z) {
        if (this.nr) {
            b(z);
            return;
        }
        if (this.iz <= 0) {
            try {
                x().execute(new Runnable() { // from class: com.bytedance.sdk.component.a.fx.u.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.nr();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void b() {
        if (this.l) {
            return;
        }
        this.l = true;
        long j = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.t, "ss_app_config", 0).getLong("last_refresh_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j > jCurrentTimeMillis) {
            j = jCurrentTimeMillis;
        }
        this.iz = j;
        try {
            if (x.u().u(this.s).n() != null) {
                x.u().u(this.s).n().u();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(int i) {
        rh rhVar = this.u;
        if (rhVar != null) {
            rhVar.sendEmptyMessage(i);
        }
    }

    public static void u(Context context, int i) {
        u uVarU;
        if (n && (uVarU = x.u().u(i, context)) != null) {
            if (bq.u(context)) {
                uVarU.u(true);
            } else {
                uVarU.u();
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        int i = message.what;
        if (i == 101) {
            this.pn = false;
            this.iz = System.currentTimeMillis();
            com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "doRefresh, succ");
            if (this.b) {
                u();
            }
            this.jk.set(false);
            return;
        }
        if (i != 102) {
            return;
        }
        this.pn = false;
        if (this.b) {
            u();
        }
        com.bytedance.sdk.component.a.b.fx.nr("TNCManager", "doRefresh, error");
        this.jk.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor editorEdit = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.t, "ss_app_config", 0).edit();
            editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
            editorEdit.apply();
        }
        if (x.u().u(this.s).n() == null) {
            return true;
        }
        x.u().u(this.s).n().u(jSONObject2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final int i) {
        String[] strArrIz = iz();
        if (strArrIz != null && strArrIz.length > i) {
            String str = strArrIz[i];
            if (TextUtils.isEmpty(str)) {
                nr(102);
                return;
            }
            try {
                String strU = u(str);
                if (TextUtils.isEmpty(strU)) {
                    nr(102);
                    return;
                }
                com.bytedance.sdk.component.a.nr.fx fxVarFx = a().fx();
                fxVarFx.u(strU);
                u(fxVarFx);
                fxVarFx.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.component.a.fx.u.3
                    @Override // com.bytedance.sdk.component.a.u.u
                    public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                        JSONObject jSONObject;
                        if (nrVar == null || !nrVar.a()) {
                            u.this.u(i + 1);
                            return;
                        }
                        String string = null;
                        try {
                            jSONObject = new JSONObject(nrVar.pn());
                        } catch (Exception unused) {
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            u.this.u(i + 1);
                            return;
                        }
                        try {
                            string = jSONObject.getString("message");
                        } catch (Exception unused2) {
                        }
                        if (!"success".equals(string)) {
                            u.this.u(i + 1);
                            return;
                        }
                        try {
                            if (u.this.u(jSONObject)) {
                                u.this.nr(101);
                            } else {
                                u.this.u(i + 1);
                            }
                        } catch (Exception unused3) {
                        }
                    }

                    @Override // com.bytedance.sdk.component.a.u.u
                    public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                        u.this.u(i + 1);
                    }
                });
                return;
            } catch (Throwable th) {
                com.bytedance.sdk.component.a.b.fx.nr("AppConfig", "try app config exception: ".concat(String.valueOf(th)));
                return;
            }
        }
        nr(102);
    }

    private String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "https://" + str + "/get_domains/v4/";
    }

    private void u(com.bytedance.sdk.component.a.nr.fx fxVar) {
        if (fxVar == null) {
            return;
        }
        Address addressU = x.u().u(this.s).b() != null ? x.u().u(this.s).b().u(this.t) : null;
        if (addressU != null && addressU.hasLatitude() && addressU.hasLongitude()) {
            StringBuilder sb = new StringBuilder();
            sb.append(addressU.getLatitude());
            fxVar.u("latitude", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(addressU.getLongitude());
            fxVar.u("longitude", sb2.toString());
            String locality = addressU.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                fxVar.u(DistrictSearchQuery.KEYWORDS_CITY, Uri.encode(locality));
            }
        }
        if (this.fx) {
            fxVar.u("force", "1");
        }
        try {
            fxVar.u("abi", Build.SUPPORTED_ABIS[0]);
        } catch (Throwable unused) {
        }
        if (x.u().u(this.s).b() != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(x.u().u(this.s).b().u());
            fxVar.u("aid", sb3.toString());
            fxVar.u("device_platform", x.u().u(this.s).b().fx());
            fxVar.u("channel", x.u().u(this.s).b().nr());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(x.u().u(this.s).b().b());
            fxVar.u("version_code", sb4.toString());
            fxVar.u("custom_info_1", x.u().u(this.s).b().pn());
        }
    }

    public static void u(ThreadPoolExecutor threadPoolExecutor) {
        f5077a = threadPoolExecutor;
    }
}
