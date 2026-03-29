package com.unicom.online.account.kernel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class o extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11162a;
    private final String b;

    public o(j jVar) {
        super(jVar.A);
        this.f11162a = Integer.parseInt(jVar.z);
        this.b = jVar.A;
    }

    public o(j jVar, Exception exc) {
        super(jVar.A);
        this.f11162a = Integer.parseInt(jVar.z);
        this.b = jVar.A + " case by : " + exc.getMessage();
    }
}
