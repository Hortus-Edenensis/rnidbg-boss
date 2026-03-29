package com.tencent.turingfd.sdk.ams.ad;

import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Gemini<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10699a;
    public final LinkedList<E> b = new LinkedList<>();

    public Gemini(int i) {
        this.f10699a = i;
    }

    public void a(E e) {
        if (this.b.size() >= this.f10699a) {
            this.b.poll();
        }
        this.b.offer(e);
    }
}
