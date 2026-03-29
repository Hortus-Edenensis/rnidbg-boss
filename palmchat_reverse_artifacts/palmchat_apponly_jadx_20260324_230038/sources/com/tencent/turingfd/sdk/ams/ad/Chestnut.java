package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class Chestnut<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile T f10680a;

    public abstract T a();

    public final T b() {
        T tA = this.f10680a;
        if (tA == null) {
            synchronized (this) {
                tA = this.f10680a;
                if (tA == null) {
                    tA = a();
                    this.f10680a = tA;
                }
            }
        }
        return tA;
    }
}
