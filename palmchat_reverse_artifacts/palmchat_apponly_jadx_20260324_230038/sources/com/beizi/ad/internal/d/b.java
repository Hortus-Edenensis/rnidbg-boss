package com.beizi.ad.internal.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.beizi.ad.internal.e.d;
import com.beizi.ad.internal.e.e;
import com.kuaishou.weapon.p0.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f4395a;
    private ArrayList<a> b = new ArrayList<>();
    private Timer c;
    private boolean d;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4398a;
        int b = 0;

        public a(String str) {
            this.f4398a = str;
        }
    }

    private b(Context context) {
        if (context != null) {
            this.d = context.getPackageManager().checkPermission(g.b, context.getPackageName()) == 0;
        }
    }

    private void c(Context context) {
        if (this.c == null) {
            final WeakReference weakReference = new WeakReference(context);
            Timer timer = new Timer();
            this.c = timer;
            timer.scheduleAtFixedRate(new TimerTask() { // from class: com.beizi.ad.internal.d.b.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Context context2 = (Context) weakReference.get();
                    if (context2 == null) {
                        b.this.a();
                        return;
                    }
                    while (!b.this.b.isEmpty() && b.this.b(context2)) {
                        boolean z = false;
                        final a aVar = (a) b.this.b.remove(0);
                        if (aVar.b < 3) {
                            new d(z, true) { // from class: com.beizi.ad.internal.d.b.1.1
                                @Override // com.beizi.ad.internal.e.d, android.os.AsyncTask
                                /* JADX INFO: renamed from: a */
                                public void onPostExecute(e eVar) {
                                    if (eVar == null || (!eVar.a() && eVar.b() == com.beizi.ad.internal.e.g.CONNECTION_FAILURE)) {
                                        aVar.b++;
                                        b.this.b.add(aVar);
                                    }
                                }

                                @Override // com.beizi.ad.internal.e.d
                                public String a() {
                                    return aVar.f4398a;
                                }
                            }.execute(new Void[0]);
                        }
                    }
                    if (b.this.b.isEmpty()) {
                        b.this.a();
                    }
                }
            }, 10000L, 10000L);
        }
    }

    public static b a(Context context) {
        if (f4395a == null) {
            f4395a = new b(context);
        }
        return f4395a;
    }

    public boolean b(Context context) {
        try {
            if (!this.d) {
                return true;
            }
            if (context == null) {
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public synchronized void a(String str, Context context) {
        this.b.add(new a(str));
        c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
    }
}
