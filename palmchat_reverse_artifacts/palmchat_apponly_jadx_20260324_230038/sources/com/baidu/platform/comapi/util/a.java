package com.baidu.platform.comapi.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4230a = new a();
    private final Map<Class<?>, CopyOnWriteArraySet<b>> b = new HashMap();
    private final Map<Class<?>, Object> c = new HashMap();

    /* JADX INFO: renamed from: com.baidu.platform.comapi.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class RunnableC0108a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f4231a;
        final /* synthetic */ Object b;

        public RunnableC0108a(b bVar, Object obj) {
            this.f4231a = bVar;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f4231a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f4232a;

        @Override // com.baidu.platform.comapi.util.a.c
        public void a(Object obj) {
            this.f4232a.a(obj);
        }

        public boolean equals(Object obj) {
            return this.f4232a.equals(obj);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(Object obj);
    }

    private a() {
    }

    public static a a() {
        return f4230a;
    }

    public void a(Object obj) {
        CopyOnWriteArraySet<b> copyOnWriteArraySet;
        if (this.b.containsKey(obj.getClass())) {
            synchronized (this) {
                copyOnWriteArraySet = this.b.get(obj.getClass());
            }
            Iterator<b> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                MapTaskManager.postToMainThread(new RunnableC0108a(it.next(), obj), 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, Object obj) {
        cVar.a(obj);
    }
}
