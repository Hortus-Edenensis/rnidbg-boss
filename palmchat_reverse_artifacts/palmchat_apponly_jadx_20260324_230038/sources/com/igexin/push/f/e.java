package com.igexin.push.f;

import android.database.Cursor;
import com.igexin.push.core.b.k;
import com.igexin.push.core.d;
import com.igexin.push.core.n;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import java.util.PriorityQueue;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e implements com.igexin.push.f.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f7344a;
    private String b = "ReDisplayTask";
    private volatile long c = 0;

    public static e a() {
        if (f7344a == null) {
            synchronized (e.class) {
                if (f7344a == null) {
                    f7344a = new e();
                }
            }
        }
        return f7344a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0082 A[DONT_GENERATE, PHI: r1
      0x0082: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v3 android.database.Cursor) binds: [B:13:0x0080, B:9:0x0062] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PriorityQueue<k> e() {
        PriorityQueue<k> priorityQueue = new PriorityQueue<>();
        Cursor cursorA = null;
        try {
            cursorA = d.a.f7200a.i.a("message", new String[0], "status = '1' and notify_status = '1' and redisplay_freq != '0' and redisplay_num <= redisplay_freq and expect_redisplay_time <= " + (System.currentTimeMillis() / 1000));
            if (cursorA != null) {
                while (cursorA.moveToNext()) {
                    priorityQueue.offer(new k(cursorA.getBlob(cursorA.getColumnIndex("msgextra")), new String(com.igexin.c.b.a.c(cursorA.getBlob(cursorA.getColumnIndex("info")))), cursorA.getLong(cursorA.getColumnIndex("expect_redisplay_time"))));
                }
            }
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.b(this.b, "get redisplay message" + th.toString());
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
        if (cursorA != null) {
        }
        return priorityQueue;
    }

    @Override // com.igexin.push.f.b.c
    public final boolean c() {
        boolean z = System.currentTimeMillis() / 1000 >= this.c;
        com.igexin.c.a.c.a.a(this.b + " | ReDisplayTask isMatch =" + z + "， nextReDisplayTime =" + this.c, new Object[0]);
        return z;
    }

    public final void d() {
        Cursor cursorA = null;
        try {
            cursorA = d.a.f7200a.i.a("message", new String[0], "status = '1' and notify_status = '1' and redisplay_freq != '0' and redisplay_num <= redisplay_freq  order by expect_redisplay_time asc limit 1");
            if (cursorA != null && cursorA.getCount() == 1 && cursorA.moveToFirst()) {
                this.c = cursorA.getLong(cursorA.getColumnIndex("expect_redisplay_time"));
            } else {
                this.c = Long.MAX_VALUE;
            }
            System.currentTimeMillis();
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.b(this.b, " get next redisplay message fail" + th.toString());
                if (cursorA != null) {
                    cursorA.close();
                }
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
    }

    @Override // com.igexin.push.f.b.c
    public final void b() {
        if (com.igexin.push.g.c.a(System.currentTimeMillis())) {
            com.igexin.c.a.c.a.b(this.b, "message in silent time period, ignored...");
        } else {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new d() { // from class: com.igexin.push.f.e.1
                /* JADX WARN: Removed duplicated region for block: B:17:0x0087 A[Catch: all -> 0x00ab, PHI: r7
                  0x0087: PHI (r7v3 com.igexin.push.extension.mod.PushTaskBean) = (r7v2 com.igexin.push.extension.mod.PushTaskBean), (r7v6 com.igexin.push.extension.mod.PushTaskBean) binds: [B:6:0x0059, B:14:0x007f] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x00ab, blocks: (B:5:0x003a, B:7:0x005b, B:9:0x006f, B:15:0x0081, B:16:0x0083, B:17:0x0087, B:19:0x0095, B:20:0x0098, B:22:0x00a0, B:23:0x00a3), top: B:28:0x003a }] */
                @Override // com.igexin.push.f.d
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void b() {
                    e eVar;
                    PriorityQueue priorityQueueE = e.this.e();
                    String unused = e.this.b;
                    priorityQueueE.size();
                    com.igexin.c.a.c.a.a(e.this.b + " | priorityQueue size = " + priorityQueueE.size(), new Object[0]);
                    while (true) {
                        k kVar = (k) priorityQueueE.poll();
                        if (kVar == null) {
                            return;
                        }
                        try {
                            JSONObject jSONObjectA = kVar.a();
                            String string = jSONObjectA.getString("taskid");
                            String string2 = jSONObjectA.getString("messageid");
                            com.igexin.push.core.a.b.d();
                            String strA = com.igexin.push.core.a.b.a(string, string2);
                            PushTaskBean pushTaskBean = com.igexin.push.core.e.ah.get(strA);
                            if (pushTaskBean == null) {
                                n.a().a(jSONObjectA, kVar.f, false);
                                pushTaskBean = com.igexin.push.core.e.ah.get(strA);
                                if (pushTaskBean == null || n.a().a(string, string2) != PushMessageInterface.ActionPrepareState.success) {
                                    eVar = e.this;
                                } else if (n.a().a(pushTaskBean.getConditionMap(), string, pushTaskBean)) {
                                    String actionIdByType = pushTaskBean.getActionIdByType("notification");
                                    if (actionIdByType == null) {
                                        eVar = e.this;
                                    } else {
                                        n.a().a(string, string2, actionIdByType);
                                    }
                                } else {
                                    eVar = e.this;
                                }
                                String unused2 = eVar.b;
                            }
                        } catch (Throwable th) {
                            String unused3 = e.this.b;
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                }
            }, true);
        }
    }

    @Override // com.igexin.push.f.b.c
    public final void a(long j) {
    }
}
