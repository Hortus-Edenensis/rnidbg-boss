package com.opos.mobad.service.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.opos.cmn.an.j.b;
import com.opos.mobad.b.a.ai;
import com.opos.mobad.b.a.aj;
import com.opos.mobad.service.f.b;
import java.io.IOException;
import okio.BufferedSource;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9194a;
    private ai.a b;
    private LruCache<String, C0766a> c = new LruCache<>(100);

    /* JADX INFO: renamed from: com.opos.mobad.service.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0766a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f9197a;
        private final long b;

        public C0766a(boolean z, long j) {
            this.f9197a = z;
            this.b = j;
        }
    }

    private void b(final String str) {
        if (this.b == null || TextUtils.isEmpty("https://adx.ads.heytapmobi.com/show/frequency/req/check")) {
            return;
        }
        b.b(new Runnable() { // from class: com.opos.mobad.service.b.a.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                T t;
                b.C0773b c0773bA = com.opos.mobad.service.f.b.a(a.this.f9194a, "https://adx.ads.heytapmobi.com/show/frequency/req/check", a.this.b.a(com.opos.mobad.service.f.a.a(a.this.f9194a)).a(com.opos.mobad.service.f.a.a()).a(com.opos.mobad.service.f.a.b()).a(com.opos.mobad.service.f.a.b(a.this.f9194a)).c(str).b().b(), new b.a<aj>() { // from class: com.opos.mobad.service.b.a.1.1
                    @Override // com.opos.mobad.service.f.b.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public aj b(BufferedSource bufferedSource) throws IOException {
                        return aj.c.a(bufferedSource);
                    }
                });
                com.opos.cmn.an.f.a.b("StateManager", "refresh:", Integer.valueOf(c0773bA.f9237a), c0773bA.c);
                if (c0773bA.f9237a != 200 || (t = c0773bA.c) == 0) {
                    return;
                }
                if (((aj) t).f.intValue() == 0) {
                    a.this.b(str, true, ((aj) c0773bA.c).g.intValue());
                } else if (((aj) c0773bA.c).f.intValue() == 1035) {
                    a.this.b(str, false, ((aj) c0773bA.c).g.intValue());
                }
            }
        });
    }

    public synchronized void a(Context context, String str, String str2, int i, int i2) {
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f9194a != null) {
                    return;
                }
                this.f9194a = context;
                this.b = new ai.a().a(str).b(str2).a(Integer.valueOf(i)).b(Integer.valueOf(i2)).d(context.getPackageName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z, int i) {
        com.opos.cmn.an.f.a.b("StateManager", "update", str, Boolean.valueOf(z), Integer.valueOf(i));
        this.c.put(str, new C0766a(z, SystemClock.elapsedRealtime() + ((long) i)));
    }

    private void a(String str, C0766a c0766a) {
        if (c0766a == null || a(c0766a)) {
            b(str);
        }
    }

    public void a(String str, boolean z, int i) {
        b(str, z, i);
    }

    private boolean a(C0766a c0766a) {
        return c0766a == null || SystemClock.elapsedRealtime() >= c0766a.b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C0766a c0766a = this.c.get(str);
        if (c0766a == null) {
            b(str);
            return true;
        }
        if (c0766a.f9197a) {
            a(str, c0766a);
            return true;
        }
        if (!a(c0766a)) {
            return false;
        }
        b(str);
        return true;
    }
}
