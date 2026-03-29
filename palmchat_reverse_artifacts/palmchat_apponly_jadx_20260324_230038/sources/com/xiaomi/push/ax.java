package com.xiaomi.push;

import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<a> f11430a = new LinkedList<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ax f11431a = new ax();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f139a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f140a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f141a;

        public a(int i, Object obj) {
            this.f139a = i;
            this.f140a = obj;
        }
    }

    public static ax a() {
        return a.f11431a;
    }

    public synchronized void a(Object obj) {
        this.f11430a.add(new a(0, obj));
        m182a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m182a() {
        if (this.f11430a.size() > 100) {
            this.f11430a.removeFirst();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized int m183a() {
        return this.f11430a.size();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized LinkedList<a> m184a() {
        LinkedList<a> linkedList;
        linkedList = this.f11430a;
        this.f11430a = new LinkedList<>();
        return linkedList;
    }
}
