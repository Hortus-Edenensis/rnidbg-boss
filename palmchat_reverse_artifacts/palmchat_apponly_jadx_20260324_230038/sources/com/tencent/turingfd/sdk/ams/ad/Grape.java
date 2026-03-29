package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Grape extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Herbaceous f10702a;

    public Grape(Herbaceous herbaceous) {
        this.f10702a = herbaceous;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            Herbaceous.a(this.f10702a);
        } catch (Throwable unused) {
        }
    }
}
