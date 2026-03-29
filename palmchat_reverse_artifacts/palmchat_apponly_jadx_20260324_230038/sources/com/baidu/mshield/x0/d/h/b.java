package com.baidu.mshield.x0.d.h;

import android.annotation.TargetApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@TargetApi(9)
public abstract class b implements a<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4060a;

    public b() {
        this(5);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        try {
            return bVar.f4060a - this.f4060a;
        } catch (Throwable th) {
            com.baidu.mshield.x0.d.d.a(th);
            return 0;
        }
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public b(int i) {
        this.f4060a = i;
    }
}
