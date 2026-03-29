package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.xiaomi.push.af;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class db {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile db f11495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f242a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f243a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends b {
        public a() {
            super();
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.af.b
        public void b() {
            db.this.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends af.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f11499a = System.currentTimeMillis();

        public b() {
        }

        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.af.b
        public void b() {
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public final boolean m288b() {
            return System.currentTimeMillis() - this.f11499a > 172800000;
        }
    }

    private db(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f243a = concurrentLinkedQueue;
        this.f242a = context;
        concurrentLinkedQueue.add(new a());
        b(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            File file = new File(this.f242a.getFilesDir() + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void c() {
        while (!this.f243a.isEmpty()) {
            b bVarPeek = this.f243a.peek();
            if (bVarPeek != null) {
                if (!bVarPeek.m288b() && this.f243a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f243a.remove(bVarPeek);
            }
        }
    }

    public static db a(Context context) {
        if (f11495a == null) {
            synchronized (db.class) {
                if (f11495a == null) {
                    f11495a = new db(context);
                }
            }
        }
        f11495a.f242a = context;
        return f11495a;
    }

    private void b(long j) {
        if (this.f243a.isEmpty()) {
            return;
        }
        fy.a(new af.b() { // from class: com.xiaomi.push.db.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            af.b f11497a;

            @Override // com.xiaomi.push.af.b
            public void b() {
                b bVar = (b) db.this.f243a.peek();
                if (bVar == null || !bVar.a()) {
                    return;
                }
                if (db.this.f243a.remove(bVar)) {
                    this.f11497a = bVar;
                }
                af.b bVar2 = this.f11497a;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }

            @Override // com.xiaomi.push.af.b
            /* JADX INFO: renamed from: c */
            public void mo289c() {
                af.b bVar = this.f11497a;
                if (bVar != null) {
                    bVar.mo289c();
                }
            }
        }, j);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11500a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        File f252a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f253a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f254a;
        String b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        boolean f255b;

        public c(String str, String str2, File file, boolean z) {
            super();
            this.f253a = str;
            this.b = str2;
            this.f252a = file;
            this.f255b = z;
        }

        private boolean c() {
            int i;
            int i2 = 0;
            SharedPreferences sharedPreferences = db.this.f242a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                jCurrentTimeMillis = jSONObject.getLong("time");
                i = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i = 0;
            }
            if (System.currentTimeMillis() - jCurrentTimeMillis >= 86400000) {
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                if (i > 10) {
                    return false;
                }
                i2 = i;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", jCurrentTimeMillis);
                jSONObject2.put("times", i2 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.db.b
        public boolean a() {
            return au.d(db.this.f242a) || (this.f255b && au.m175a(db.this.f242a));
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.af.b
        public void b() {
            try {
                if (c()) {
                    HashMap map = new HashMap();
                    map.put(DeviceInfoUtil.UID_TAG, com.xiaomi.push.service.ax.m729a());
                    map.put("token", this.b);
                    map.put(TKDownloadReason.KSAD_TK_NET, au.m171a(db.this.f242a));
                    au.a(this.f253a, map, this.f252a, "file");
                }
                this.f254a = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.af.b
        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public void mo289c() {
            if (!this.f254a) {
                int i = this.f11500a + 1;
                this.f11500a = i;
                if (i < 3) {
                    db.this.f243a.add(this);
                }
            }
            if (this.f254a || this.f11500a >= 3) {
                this.f252a.delete();
            }
            db.this.a((1 << this.f11500a) * 1000);
        }
    }

    public void a(final String str, final String str2, final Date date, final Date date2, final int i, final boolean z) {
        this.f243a.add(new b() { // from class: com.xiaomi.push.db.1

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            File f245a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.xiaomi.push.db.b, com.xiaomi.push.af.b
            public void b() {
                try {
                    File file = new File(db.this.f242a.getFilesDir() + "/.logcache");
                    if (v.m788a(file)) {
                        file.mkdirs();
                        if (file.isDirectory()) {
                            da daVar = new da();
                            daVar.a(i);
                            this.f245a = daVar.a(db.this.f242a, date, date2, file);
                        }
                    }
                } catch (NullPointerException unused) {
                }
            }

            @Override // com.xiaomi.push.af.b
            /* JADX INFO: renamed from: c */
            public void mo289c() {
                File file = this.f245a;
                if (file != null && file.exists()) {
                    db.this.f243a.add(db.this.new c(str, str2, this.f245a, z));
                }
                db.this.a(0L);
            }
        });
        b(0L);
    }

    public void a() {
        c();
        a(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b bVarPeek = this.f243a.peek();
        if (bVarPeek == null || !bVarPeek.a()) {
            return;
        }
        b(j);
    }
}
