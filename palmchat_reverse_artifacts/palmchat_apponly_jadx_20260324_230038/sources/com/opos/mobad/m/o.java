package com.opos.mobad.m;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Integer, Set<Integer>> f8998a;
    private AtomicInteger b;
    private ReentrantReadWriteLock c = new ReentrantReadWriteLock();
    private String d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8999a;
        private int b;
        private Map<Integer, Set<Integer>> c = new HashMap();

        public a(int i) {
            this.b = i;
        }

        public a a(int i, int i2) {
            Set<Integer> hashSet = this.c.get(Integer.valueOf(i));
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.c.put(Integer.valueOf(i), hashSet);
            }
            hashSet.add(Integer.valueOf(i2));
            return this;
        }

        public a a(int i, int... iArr) {
            if (iArr == null) {
                return this;
            }
            Set<Integer> hashSet = this.c.get(Integer.valueOf(i));
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.c.put(Integer.valueOf(i), hashSet);
            }
            for (int i2 : iArr) {
                hashSet.add(Integer.valueOf(i2));
            }
            return this;
        }

        public a a(String str) {
            this.f8999a = str;
            return this;
        }

        public o a() {
            return new o(this.b, this.c, this.f8999a);
        }
    }

    public o(int i, Map<Integer, Set<Integer>> map, String str) {
        this.b = new AtomicInteger(i);
        this.d = str;
        a(map);
    }

    private void b() {
    }

    public int a() {
        return this.b.get();
    }

    private boolean b(int i, int i2) {
        String str;
        Map<Integer, Set<Integer>> map = this.f8998a;
        if (map == null) {
            str = "checkEnable but mController = null";
        } else if (!map.containsKey(Integer.valueOf(i))) {
            str = "checkEnable but error current state:" + i;
        } else {
            if (this.f8998a.get(Integer.valueOf(i)).contains(Integer.valueOf(i2))) {
                return true;
            }
            str = "checkEnable but error next state:" + i + ",to:" + i2;
        }
        a(str);
        return false;
    }

    public int a(int i) {
        a("changeToState:" + i);
        try {
            this.c.readLock().lock();
            int i2 = this.b.get();
            if (i2 == i) {
                return i;
            }
            int i3 = 3;
            while (i3 > 0) {
                if (!b(i2, i)) {
                    return i2;
                }
                if (this.b.compareAndSet(i2, i)) {
                    return i;
                }
                i3--;
                i2 = this.b.get();
            }
            this.c.readLock().unlock();
            return a(i, (Callable<Boolean>) null);
        } finally {
            this.c.readLock().unlock();
        }
    }

    public int a(int i, int i2) {
        a("changeToStateFrom:" + i + ", to:" + i2 + ", mCurrentState:" + this.b.get());
        try {
            this.c.readLock().lock();
            if (this.b.get() == i2) {
                a("changeToStateFrom target equal mCurrentState:" + this.b);
            } else if (!b(i, i2) || !this.b.compareAndSet(i, i2)) {
                AtomicInteger atomicInteger = this.b;
                return atomicInteger.get();
            }
            return i2;
        } finally {
            this.c.readLock().unlock();
        }
    }

    private int a(int i, int i2, Callable<Boolean> callable) {
        try {
            if (!callable.call().booleanValue()) {
                a("execute fail");
                return i;
            }
            if (!this.b.compareAndSet(i, i2)) {
                a("unexpected fail");
                b();
            }
            return i2;
        } catch (Exception e) {
            a("call exception :" + e);
            return i;
        }
    }

    public int a(int i, Callable<Boolean> callable) {
        String str;
        a("changeToStateBy:" + i + ", callable = " + callable + ", mCurrentState:" + this.b.get());
        try {
            this.c.writeLock().lock();
            int i2 = this.b.get();
            if (i2 == i) {
                str = "changeToStateBy but now target:" + i;
            } else {
                if (b(i2, i)) {
                    if (callable != null) {
                        i = a(i2, i, callable);
                    } else if (!this.b.compareAndSet(i2, i)) {
                        b();
                    }
                    return i;
                }
                str = "changeToStateBy but target is not enable:" + i;
            }
            a(str);
            return i2;
        } finally {
            this.c.writeLock().unlock();
        }
    }

    private final void a(String str) {
        com.opos.cmn.an.f.a.b("SyncStateController:" + this.d, str);
    }

    private void a(Map<Integer, Set<Integer>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f8998a = new HashMap();
        for (Integer num : map.keySet()) {
            Set<Integer> set = map.get(num);
            if (set != null && !set.isEmpty()) {
                this.f8998a.put(num, new HashSet(map.get(num)));
            }
        }
    }
}
