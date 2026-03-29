package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.ad.TuringIDService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Mangosteen extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Caelum f10721a;
    public final /* synthetic */ Context b;

    public Mangosteen(Caelum caelum, Context context) {
        this.f10721a = caelum;
        this.b = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Caelum caelum = this.f10721a;
        if (caelum != null) {
            ((TuringIDService.Cdo) caelum).f10743a.onResult(new Lichee(Herbaceous.l.a(this.b, false, 1)));
        }
    }
}
