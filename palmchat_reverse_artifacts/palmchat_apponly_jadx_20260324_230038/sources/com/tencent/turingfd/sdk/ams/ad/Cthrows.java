package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.throws, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Cthrows extends Eridanus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10778a = "";
    public String b = "";

    @Override // com.tencent.turingfd.sdk.ams.ad.Eridanus
    public void a(Draco draco) {
        draco.a(this.f10778a, 0);
        draco.a(this.b, 1);
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.Eridanus
    public void a(Dorado dorado) {
        this.f10778a = dorado.b(0, true);
        this.b = dorado.b(1, true);
    }
}
