package com.amap.api.col.p0002sl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class bx<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected LinkedList<T> f2663a = new LinkedList<>();
    protected final Semaphore b = new Semaphore(0, false);
    protected boolean c = true;

    public final void a() {
        this.c = false;
        this.b.release(100);
    }

    public final void b() {
        LinkedList<T> linkedList = this.f2663a;
        if (linkedList == null) {
            return;
        }
        linkedList.clear();
    }

    public final synchronized void a(List<T> list, boolean z) {
        LinkedList<T> linkedList = this.f2663a;
        if (linkedList == null) {
            return;
        }
        if (z) {
            linkedList.clear();
        }
        if (list != null) {
            this.f2663a.addAll(list);
        }
        this.b.release();
    }

    public final ArrayList<T> a(boolean z) {
        LinkedList<T> linkedList = this.f2663a;
        ArrayList<T> arrayListA = null;
        if (linkedList != null && linkedList.size() != 0) {
            try {
                this.b.acquire();
            } catch (InterruptedException unused) {
            }
            try {
                if (this.c) {
                    arrayListA = a(1, z);
                }
            } catch (Throwable unused2) {
            }
            this.b.release();
        }
        return arrayListA;
    }

    public synchronized ArrayList<T> a(int i, boolean z) {
        LinkedList<T> linkedList = this.f2663a;
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        if (size <= 0) {
            i = size;
        }
        ArrayList<T> arrayList = new ArrayList<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(this.f2663a.get(0));
            this.f2663a.removeFirst();
        }
        return arrayList;
    }
}
