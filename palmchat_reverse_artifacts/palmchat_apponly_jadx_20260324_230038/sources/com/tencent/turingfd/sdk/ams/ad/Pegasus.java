package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.ad.Perseus;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Pegasus extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Perseus.Cdo f10733a;
    public final /* synthetic */ Context b;

    public Pegasus(Perseus.Cdo cdo, Context context) {
        this.f10733a = cdo;
        this.b = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f10733a.f10735a.b(this.b);
    }
}
