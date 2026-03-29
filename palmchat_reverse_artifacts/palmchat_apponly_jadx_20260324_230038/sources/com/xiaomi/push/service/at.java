package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.eg;
import com.xiaomi.push.eh;
import com.xiaomi.push.service.XMPushService;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, c> f11732a = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends XMPushService.j {
        public a() {
            super(17);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "RecordTimeManager clear";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            at.a().m728a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final at f11733a = new at();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f11734a;
        long b;
        long c;
        long d;

        private c() {
        }

        public long a() {
            long j = this.c;
            long j2 = this.b;
            if (j > j2) {
                return j - j2;
            }
            return 0L;
        }

        public long b() {
            long j = this.d;
            long j2 = this.c;
            if (j > j2) {
                return j - j2;
            }
            return 0L;
        }
    }

    public static at a() {
        return b.f11733a;
    }

    public void b(String str, long j) {
        c cVarRemove = this.f11732a.remove(str);
        if (cVarRemove != null) {
            cVarRemove.d = j;
            a(str, cVarRemove);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m728a() {
        if (this.f11732a.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, c>> it = this.f11732a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> next = it.next();
            if (next == null || next.getValue() == null) {
                it.remove();
            } else {
                c value = next.getValue();
                if (Math.abs(SystemClock.elapsedRealtime() - value.b) > 10000) {
                    a(next.getKey(), value);
                    it.remove();
                }
            }
        }
    }

    public void a(String str, long j, long j2) {
        c cVar = new c();
        cVar.f11734a = j2;
        cVar.b = j;
        this.f11732a.put(str, cVar);
    }

    public void a(String str, long j) {
        c cVar = this.f11732a.get(str);
        if (cVar != null) {
            cVar.c = j;
        }
    }

    private void a(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("xmsfVC", Long.valueOf(cVar.f11734a));
        map.put("packetId", str);
        map.put("pTime", Long.valueOf(cVar.a()));
        map.put("bTime", Long.valueOf(cVar.b()));
        eh.a().a(new eg("msg_process_time", map));
    }
}
