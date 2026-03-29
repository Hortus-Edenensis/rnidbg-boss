package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class li<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2965a;
    private File b;
    private Handler e;
    private String f;
    private boolean g;
    private boolean c = false;
    private Map<String, a> d = new ConcurrentHashMap();
    private Runnable h = new Runnable() { // from class: com.amap.api.col.2sl.li.2
        @Override // java.lang.Runnable
        public final void run() {
            if (li.this.c) {
                if (li.this.g) {
                    li.this.e();
                    li.e(li.this);
                }
                if (li.this.e != null) {
                    li.this.e.postDelayed(li.this.h, 60000L);
                }
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2968a;
        long b;
        long c;

        public a(int i, long j, long j2) {
            this.f2968a = i;
            this.b = j;
            this.c = j2;
        }
    }

    public li(Context context, String str, Handler handler) {
        this.f = null;
        if (context == null) {
            return;
        }
        this.e = handler;
        this.f2965a = TextUtils.isEmpty(str) ? "unknow" : str;
        this.f = mm.l(context);
        try {
            this.b = new File(context.getFilesDir().getPath(), this.f2965a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        d();
    }

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static /* synthetic */ boolean e(li liVar) {
        liVar.g = false;
        return false;
    }

    public abstract void a(T t, long j);

    public abstract long b();

    public abstract String b(T t);

    public abstract int c(T t);

    public abstract long c();

    public abstract long d(T t);

    private void b(T t, long j) {
        if (t == null || d(t) < 0) {
            return;
        }
        String strB = b(t);
        a aVar = this.d.get(strB);
        if (aVar == null) {
            a(t, j);
            this.d.put(strB, new a(c(t), d(t), j));
            this.g = true;
            return;
        }
        aVar.c = j;
        if (aVar.f2968a == c(t)) {
            a(t, aVar.b);
            return;
        }
        a(t, j);
        aVar.f2968a = c(t);
        aVar.b = d(t);
        this.g = true;
    }

    private void d() {
        try {
            Iterator<String> it = mm.a(this.b).iterator();
            while (it.hasNext()) {
                try {
                    String[] strArrSplit = new String(lt.b(fw.b(it.next()), this.f), "UTF-8").split(",");
                    this.d.put(strArrSplit[0], new a(Integer.parseInt(strArrSplit[1]), Long.parseLong(strArrSplit[2]), strArrSplit.length >= 4 ? Long.parseLong(strArrSplit[3]) : mm.b()));
                } catch (Throwable th) {
                    if (this.b.exists()) {
                        this.b.delete();
                    }
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (c() > 0) {
            this.d.size();
            if (b() > 0) {
                long jB = mm.b();
                Iterator<Map.Entry<String, a>> it = this.d.entrySet().iterator();
                while (it.hasNext()) {
                    if (jB - this.d.get(it.next().getKey()).c > b()) {
                        it.remove();
                    }
                }
            }
            if (this.d.size() > c()) {
                ArrayList arrayList = new ArrayList(this.d.keySet());
                Collections.sort(arrayList, new Comparator<String>() { // from class: com.amap.api.col.2sl.li.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(String str, String str2) {
                        return li.a(((a) li.this.d.get(str2)).c, ((a) li.this.d.get(str)).c);
                    }
                });
                for (int iC = (int) c(); iC < arrayList.size(); iC++) {
                    this.d.remove(arrayList.get(iC));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, a> entry : this.d.entrySet()) {
            try {
                sb.append(fw.b(lt.a((entry.getKey() + "," + entry.getValue().f2968a + "," + entry.getValue().b + "," + entry.getValue().c).getBytes("UTF-8"), this.f)) + "\n");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        mm.a(this.b, string);
    }

    public final void a() {
        Handler handler;
        if (!this.c && (handler = this.e) != null) {
            handler.removeCallbacks(this.h);
            this.e.postDelayed(this.h, 60000L);
        }
        this.c = true;
    }

    public final void a(boolean z) {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacks(this.h);
        }
        if (!z) {
            this.h.run();
        }
        this.c = false;
    }

    public final void a(T t) {
        b(t, mm.b());
    }

    public final void a(List<T> list) {
        long jB = mm.b();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            b(it.next(), jB);
        }
        if (this.d.size() >= list.size()) {
            this.g = true;
        }
        if (this.d.size() > 16384 || c() <= 0) {
            this.d.clear();
            for (T t : list) {
                this.d.put(b(t), new a(c(t), d(t), jB));
            }
        }
    }

    public final long e(T t) {
        return (mm.b() - d(t)) / 1000;
    }
}
