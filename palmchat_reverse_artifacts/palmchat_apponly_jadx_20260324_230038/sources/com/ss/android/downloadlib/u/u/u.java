package com.ss.android.downloadlib.u.u;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.u.u.fx;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    private static String b = "";
    private static String iz = "";
    private static String pn = "";
    private static volatile u x;
    private Context t;
    public fx u;
    private boolean n = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10593a = false;
    private volatile boolean jk = false;
    private final List<Pair<nr, b>> l = new ArrayList();
    public final List<Object> nr = new ArrayList();
    private final ServiceConnection mv = new ServiceConnection() { // from class: com.ss.android.downloadlib.u.u.u.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (u.this.fx) {
                u.this.u(false);
                u.this.u = fx.u.u(iBinder);
                u.this.fx();
                Iterator<Object> it = u.this.nr.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (u.this.fx) {
                u.this.u(false);
                u uVar = u.this;
                uVar.u = null;
                Iterator<Object> it = uVar.nr.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    };
    private String s = "";
    public final Object fx = new Object();

    private u() {
    }

    public static u u() {
        if (x == null) {
            synchronized (u.class) {
                if (x == null) {
                    x = new u();
                }
            }
        }
        return x;
    }

    public boolean b() {
        return this.jk;
    }

    public void fx() {
        for (Pair<nr, b> pair : this.l) {
            try {
                this.u.u((nr) pair.first, (b) pair.second);
            } catch (RemoteException unused) {
            }
        }
        this.l.clear();
    }

    public void nr() {
        if (this.u != null) {
            this.t.unbindService(this.mv);
            this.u = null;
        }
        this.nr.clear();
        this.l.clear();
    }

    public boolean u(Context context, boolean z) {
        if (TextUtils.isEmpty(b)) {
            JSONObject jSONObjectA = l.a();
            String strOptString = jSONObjectA.optString("s");
            b = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("q"), strOptString);
            pn = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("u"), strOptString);
            iz = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString(RXScreenCaptureService.KEY_WIDTH), strOptString);
        }
        this.f10593a = z;
        if (context == null) {
            return true;
        }
        this.t = context.getApplicationContext();
        if (TextUtils.isEmpty(iz)) {
            iz = this.t.getPackageName();
        }
        if (this.u != null || b()) {
            return true;
        }
        return this.t.bindService(u(context), this.mv, 33);
    }

    public Intent u(Context context) {
        Intent intent = new Intent();
        intent.setAction(b);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            return null;
        }
        Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (pn.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void u(nr nrVar, b bVar) {
        synchronized (this.fx) {
            nrVar.pn = iz;
            if (TextUtils.isEmpty(nrVar.iz)) {
                nrVar.iz = this.s;
            }
            fx fxVar = this.u;
            if (fxVar != null) {
                try {
                    fxVar.u(nrVar, bVar);
                } catch (RemoteException unused) {
                }
            } else if (b() || u(this.t, this.f10593a)) {
                this.l.add(Pair.create(nrVar, bVar));
            }
        }
    }

    public void u(boolean z) {
        this.jk = z;
    }
}
