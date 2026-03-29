package com.opos.cmn.biz.requeststatistic.cache;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.opos.cmn.biz.requeststatistic.a;
import com.opos.cmn.biz.requeststatistic.cache.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {
    private static d g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7869a;
    private com.opos.cmn.biz.requeststatistic.cache.b b;
    private ReadWriteLock c = new ReentrantReadWriteLock();
    private LinkedBlockingQueue<com.opos.cmn.biz.requeststatistic.cache.c> d = new LinkedBlockingQueue<>();
    private com.opos.cmn.biz.requeststatistic.cache.a e;
    private com.opos.cmn.biz.requeststatistic.cache.a f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a.c {
        public a() {
        }

        @Override // com.opos.cmn.biz.requeststatistic.cache.a.c
        public void a(a.b bVar) {
            d.this.c(bVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements a.c {
        public b() {
        }

        @Override // com.opos.cmn.biz.requeststatistic.cache.a.c
        public void a(a.b bVar) {
            d.this.a(bVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.b f7872a;

        public c(a.b bVar) {
            this.f7872a = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            a.b bVar;
            LinkedList linkedList;
            Object objPoll;
            d.this.c.writeLock().lock();
            try {
                com.opos.cmn.an.f.a.a("CacheModel", "startWrite db begin");
                linkedList = new LinkedList();
                objPoll = d.this.d.poll();
            } catch (Throwable th) {
                try {
                    com.opos.cmn.an.f.a.c("CacheModel", "write fail", th);
                    a.b bVar2 = this.f7872a;
                    if (bVar2 != null) {
                        bVar2.onFail();
                        return;
                    }
                } finally {
                    com.opos.cmn.an.f.a.a("CacheModel", "startWrite db end");
                    d.this.c.writeLock().unlock();
                }
            }
            while (true) {
                com.opos.cmn.biz.requeststatistic.cache.c cVar = (com.opos.cmn.biz.requeststatistic.cache.c) objPoll;
                if (cVar == null) {
                    break;
                }
                linkedList.add(cVar);
                objPoll = d.this.d.poll();
                com.opos.cmn.an.f.a.a("CacheModel", "startWrite db end");
                d.this.c.writeLock().unlock();
                bVar = this.f7872a;
                if (bVar == null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            d.this.b.a(linkedList);
            com.opos.cmn.an.f.a.a("CacheModel", "startWrite db end");
            d.this.c.writeLock().unlock();
            bVar = this.f7872a;
            if (bVar == null) {
            }
        }
    }

    /* JADX INFO: renamed from: com.opos.cmn.biz.requeststatistic.cache.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class RunnableC0657d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.biz.requeststatistic.cache.c f7873a;

        public RunnableC0657d(com.opos.cmn.biz.requeststatistic.cache.c cVar) {
            this.f7873a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.c.writeLock().lock();
            try {
                try {
                    d.this.b.a(this.f7873a);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("CacheModel", "delete fail", e);
                }
            } finally {
                d.this.c.writeLock().unlock();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.b f7874a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a.b {
            public a() {
            }

            @Override // com.opos.cmn.biz.requeststatistic.cache.a.b
            public void onFail() {
                d.this.b();
                a.b bVar = e.this.f7874a;
                if (bVar != null) {
                    bVar.onFail();
                }
            }

            @Override // com.opos.cmn.biz.requeststatistic.cache.a.b
            public void onSuccess() {
                d.this.b();
                a.b bVar = e.this.f7874a;
                if (bVar != null) {
                    bVar.onSuccess();
                }
            }
        }

        public e(a.b bVar) {
            this.f7874a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f7876a;
        final /* synthetic */ a.b b;

        public f(List list, a.b bVar) {
            this.f7876a = list;
            this.b = bVar;
        }

        @Override // com.opos.cmn.biz.requeststatistic.a.b
        public void onFail() {
            com.opos.cmn.an.f.a.b("CacheModel", "report cache fail");
            a.b bVar = this.b;
            if (bVar != null) {
                bVar.onFail();
            }
        }

        @Override // com.opos.cmn.biz.requeststatistic.a.b
        public void onSuccess() {
            a.b bVar;
            com.opos.cmn.an.f.a.b("CacheModel", "report cache success");
            if (!d.this.a((List<com.opos.cmn.biz.requeststatistic.cache.c>) this.f7876a) && (bVar = this.b) != null) {
                bVar.onFail();
            } else if (d.this.d()) {
                d.this.b(this.b);
            } else {
                this.b.onSuccess();
            }
        }
    }

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.c.writeLock().lock();
        try {
            try {
                this.b.a(System.currentTimeMillis() - com.igexin.push.f.b.d.b);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("CacheModel", "delete cache expired fail", e2);
            }
        } finally {
            this.c.writeLock().unlock();
        }
    }

    public static d c() {
        d dVar;
        d dVar2 = g;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            if (g == null) {
                g = new d();
            }
            dVar = g;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f7869a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    public void a() {
        com.opos.cmn.biz.requeststatistic.cache.a aVar = this.f;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.b bVar) {
        this.c.readLock().lock();
        long jCurrentTimeMillis = System.currentTimeMillis() - com.igexin.push.f.b.d.b;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - 60000;
        com.opos.cmn.an.f.a.b("CacheModel", "do report cache with start Time:" + jCurrentTimeMillis + ", endTime:" + jCurrentTimeMillis2);
        try {
            List<com.opos.cmn.biz.requeststatistic.cache.c> listA = this.b.a(jCurrentTimeMillis, jCurrentTimeMillis2, 100);
            if (listA == null || listA.size() <= 0) {
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<com.opos.cmn.biz.requeststatistic.cache.c> it = listA.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.put(new JSONObject(it.next().b));
                } catch (JSONException e2) {
                    com.opos.cmn.an.f.a.b("CacheModel", "parse data fail", e2);
                }
            }
            if (jSONArray.length() > 0) {
                com.opos.cmn.biz.requeststatistic.a.b(this.f7869a, jSONArray.toString(), new f(listA, bVar));
                return;
            }
            if (a(listA)) {
                if (bVar != null) {
                    bVar.onSuccess();
                }
            } else if (bVar != null) {
                bVar.onFail();
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.c("CacheModel", "get cache fail", e3);
            if (bVar != null) {
                bVar.onFail();
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a.b bVar) {
        com.opos.cmn.an.j.b.a().execute(new c(bVar));
    }

    public void a(Context context) {
        if (this.f7869a != null) {
            return;
        }
        this.f7869a = context;
        this.b = new com.opos.cmn.biz.requeststatistic.cache.b(context);
        this.e = new com.opos.cmn.biz.requeststatistic.cache.a(new a(), Integer.MAX_VALUE);
        this.f = new com.opos.cmn.biz.requeststatistic.cache.a(new b(), Integer.MAX_VALUE, 1800000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        com.opos.cmn.an.j.b.a().execute(new e(bVar));
    }

    public void b(com.opos.cmn.biz.requeststatistic.cache.c cVar) {
        if (this.d.remove(cVar)) {
            return;
        }
        com.opos.cmn.an.j.b.a().execute(new RunnableC0657d(cVar));
    }

    public void a(com.opos.cmn.biz.requeststatistic.cache.c cVar) {
        if (this.d.size() < 1000) {
            this.d.offer(cVar);
        } else {
            com.opos.cmn.an.f.a.d("CacheModel", "cacheEntity is more than 1000");
        }
        com.opos.cmn.biz.requeststatistic.cache.a aVar = this.e;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<com.opos.cmn.biz.requeststatistic.cache.c> list) {
        this.c.writeLock().lock();
        try {
            try {
                this.b.b(list);
                this.c.writeLock().unlock();
                return true;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("CacheModel", "delete data", e2);
                this.c.writeLock().unlock();
                return false;
            }
        } catch (Throwable th) {
            this.c.writeLock().unlock();
            throw th;
        }
    }
}
