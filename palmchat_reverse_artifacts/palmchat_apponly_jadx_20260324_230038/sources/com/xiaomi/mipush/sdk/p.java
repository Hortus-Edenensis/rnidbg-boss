package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile p f11382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f65a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<n> f66a = new ArrayList();

    private p(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f65a = applicationContext;
        if (applicationContext == null) {
            this.f65a = context;
        }
    }

    public static p a(Context context) {
        if (f11382a == null) {
            synchronized (p.class) {
                if (f11382a == null) {
                    f11382a = new p(context);
                }
            }
        }
        return f11382a;
    }

    public void b(String str) {
        synchronized (this.f66a) {
            n nVar = new n();
            nVar.f63a = str;
            if (this.f66a.contains(nVar)) {
                Iterator<n> it = this.f66a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if (nVar.equals(next)) {
                        nVar = next;
                        break;
                    }
                }
            }
            nVar.f11380a++;
            this.f66a.remove(nVar);
            this.f66a.add(nVar);
        }
    }

    public void c(String str) {
        synchronized (this.f66a) {
            n nVar = new n();
            nVar.f63a = str;
            if (this.f66a.contains(nVar)) {
                this.f66a.remove(nVar);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m128a(String str) {
        synchronized (this.f66a) {
            n nVar = new n();
            nVar.f11380a = 0;
            nVar.f63a = str;
            if (this.f66a.contains(nVar)) {
                this.f66a.remove(nVar);
            }
            this.f66a.add(nVar);
        }
    }

    public int a(String str) {
        synchronized (this.f66a) {
            n nVar = new n();
            nVar.f63a = str;
            if (this.f66a.contains(nVar)) {
                for (n nVar2 : this.f66a) {
                    if (nVar2.equals(nVar)) {
                        return nVar2.f11380a;
                    }
                }
            }
            return 0;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m129a(String str) {
        synchronized (this.f66a) {
            n nVar = new n();
            nVar.f63a = str;
            return this.f66a.contains(nVar);
        }
    }

    public synchronized String a(v vVar) {
        return this.f65a.getSharedPreferences("mipush_extra", 0).getString(vVar.name(), "");
    }

    public synchronized void a(v vVar, String str) {
        SharedPreferences sharedPreferences = this.f65a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(vVar.name(), str).apply();
    }
}
