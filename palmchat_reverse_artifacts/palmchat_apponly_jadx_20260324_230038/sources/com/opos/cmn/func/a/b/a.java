package com.opos.cmn.func.a.b;

import android.content.Context;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.h;
import com.opos.cmn.func.a.a.a.g;
import com.opos.cmn.func.a.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a implements f {
    private volatile g b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<Long, Long> f7936a = new HashMap<>();
    private Object c = new Object();
    private Object d = new Object();

    /* JADX INFO: renamed from: com.opos.cmn.func.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class RunnableC0665a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.func.a.a.d f7937a;
        final /* synthetic */ Context b;
        final /* synthetic */ com.opos.cmn.an.g.f c;
        final /* synthetic */ com.opos.cmn.func.a.a.c d;
        final /* synthetic */ a e;

        @Override // java.lang.Runnable
        public void run() {
            long jA = h.a();
            this.e.a(this.f7937a.e, jA);
            try {
                try {
                    com.opos.cmn.func.a.a.e eVarA = this.e.a(h.a(this.b, jA, this.c), jA);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onResponse,");
                    sb.append(eVarA == null ? com.igexin.push.core.b.m : eVarA.toString());
                    com.opos.cmn.an.f.a.a("AdNetHttpImpl", sb.toString());
                    com.opos.cmn.func.a.a.c cVar = this.d;
                    if (cVar != null) {
                        if (eVarA == null) {
                            cVar.a(new Exception("response is null"));
                        } else {
                            cVar.a(eVarA);
                        }
                    }
                    this.e.a(this.f7937a.e);
                    if (eVarA != null) {
                        return;
                    }
                } catch (Throwable th) {
                    this.e.a(this.f7937a.e);
                    if (0 == 0) {
                        try {
                            h.a(jA);
                            com.opos.cmn.an.f.a.b("AdNetHttpImpl", "netResponse == null, NetTool.shutDown");
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("AdNetHttpImpl", "", e);
                com.opos.cmn.func.a.a.c cVar2 = this.d;
                if (cVar2 != null) {
                    cVar2.a(new Exception(e.getMessage()));
                }
                this.e.a(this.f7937a.e);
                if (0 != 0) {
                    return;
                }
            }
            try {
                h.a(jA);
                com.opos.cmn.an.f.a.b("AdNetHttpImpl", "netResponse == null, NetTool.shutDown");
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b<K, V> extends HashMap<K, V> {
        private b() {
        }

        public /* synthetic */ b(RunnableC0665a runnableC0665a) {
            this();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            String str;
            if (obj == null) {
                return null;
            }
            String str2 = (String) obj;
            Iterator<Map.Entry<K, V>> it = entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                Map.Entry<K, V> next = it.next();
                if (str2.equalsIgnoreCase((String) next.getKey())) {
                    str = (String) next.getValue();
                    break;
                }
            }
            if (str != null) {
                return (V) str;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements com.opos.cmn.func.a.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, String> f7938a;

        public c(Map<String, String> map) {
            this.f7938a = map;
        }

        @Override // com.opos.cmn.func.a.a.a
        public String a(String str) {
            Map<String, String> map;
            if (str == null || (map = this.f7938a) == null || map.size() == 0) {
                return null;
            }
            for (Map.Entry<String, String> entry : this.f7938a.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return null;
        }
    }

    private com.opos.cmn.an.g.f b(Context context, com.opos.cmn.func.a.a.d dVar) {
        if (dVar == null) {
            return null;
        }
        com.opos.cmn.func.a.a.d dVarA = com.opos.cmn.func.a.b.a.c.a(context, dVar);
        f.a aVar = new f.a();
        aVar.b(dVarA.b);
        Map<String, String> map = dVarA.c;
        if (map != null) {
            aVar.a(map);
        }
        if (dVarA.f7932a == "GET") {
            aVar.a("GET");
        }
        if (dVarA.f7932a == "POST") {
            aVar.a("POST");
        }
        byte[] bArr = dVarA.d;
        if (bArr != null) {
            aVar.a(bArr);
        }
        aVar.a(this.b.f7929a);
        aVar.b(this.b.b);
        aVar.a(this.b.d);
        aVar.a(this.b.c);
        return aVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0053 A[EXC_TOP_SPLITTER, PHI: r2
      0x0053: PHI (r2v3 com.opos.cmn.func.a.a.e) = (r2v2 com.opos.cmn.func.a.a.e), (r2v5 com.opos.cmn.func.a.a.e) binds: [B:23:0x0064, B:15:0x0051] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // com.opos.cmn.func.a.b.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.opos.cmn.func.a.a.e a(Context context, com.opos.cmn.func.a.a.d dVar) {
        com.opos.cmn.func.a.a.e eVarA = null;
        if (dVar == null || context == null) {
            return null;
        }
        long jA = h.a();
        try {
            try {
                Context applicationContext = context.getApplicationContext();
                a(applicationContext, (g) null);
                com.opos.cmn.an.f.a.a("AdNetHttpImpl", dVar.toString());
                com.opos.cmn.an.g.f fVarB = b(applicationContext, dVar);
                if (fVarB != null) {
                    a(dVar.e, jA);
                    eVarA = a(h.a(applicationContext, jA, fVarB), jA);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onResponse,");
                    sb.append(eVarA == null ? com.igexin.push.core.b.m : eVarA.toString());
                    com.opos.cmn.an.f.a.a("AdNetHttpImpl", sb.toString());
                }
                a(dVar.e);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("AdNetHttpImpl", "execSync fail", e);
                a(dVar.e);
                if (eVarA == null) {
                }
            }
            if (eVarA == null) {
                try {
                    h.a(jA);
                    com.opos.cmn.an.f.a.b("AdNetHttpImpl", "netResponse == null, NetTool.shutDown");
                } catch (Exception unused) {
                }
            }
            return eVarA;
        } catch (Throwable th) {
            a(dVar.e);
            if (eVarA == null) {
                try {
                    h.a(jA);
                    com.opos.cmn.an.f.a.b("AdNetHttpImpl", "netResponse == null, NetTool.shutDown");
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.opos.cmn.func.a.b.a$a] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.opos.cmn.func.a.a.e$a] */
    public com.opos.cmn.func.a.a.e a(com.opos.cmn.an.g.g gVar, long j) {
        ?? r0 = 0;
        r0 = 0;
        if (gVar == null) {
            return null;
        }
        Map<String, String> map = gVar.e;
        if (map != null) {
            try {
                map.remove(null);
                b bVar = new b(r0);
                try {
                    for (Map.Entry<String, String> entry : gVar.e.entrySet()) {
                        bVar.put(entry.getKey(), entry.getValue());
                    }
                } catch (Exception unused) {
                }
                r0 = bVar;
            } catch (Exception unused2) {
            }
        }
        return new e.a().a(gVar.f7785a).a(gVar.b).a(gVar.d).a(r0).a(new c(gVar.e)).a(gVar.c).b(j).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Long a(long j) {
        try {
            synchronized (this.c) {
                Long l = this.f7936a.get(Long.valueOf(j));
                if (l == null) {
                    return null;
                }
                this.f7936a.remove(Long.valueOf(j));
                return l;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdNetHttpImpl", "removeRequestFromMap fail", (Throwable) e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        synchronized (this.c) {
            this.f7936a.put(Long.valueOf(j), Long.valueOf(j2));
        }
    }

    @Override // com.opos.cmn.func.a.b.d
    public void a(Context context) {
        a(context, (g) null);
    }

    private void a(Context context, g gVar) {
        if (this.b == null) {
            synchronized (this.d) {
                if (this.b == null) {
                    if (gVar == null) {
                        this.b = com.opos.cmn.func.a.b.a.c.a(context);
                    } else {
                        this.b = gVar;
                    }
                }
            }
        }
    }
}
