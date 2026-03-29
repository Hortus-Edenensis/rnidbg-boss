package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Fig extends Eridanus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10694a = 0;
    public float b = 0.0f;
    public float c = 0.0f;
    public float d = 0.0f;
    public float e = 0.0f;

    @Override // com.tencent.turingfd.sdk.ams.ad.Eridanus
    public void a(Draco draco) {
        draco.a(this.f10694a, 0);
        draco.a(this.b, 1);
        draco.a(this.c, 2);
        float f = this.d;
        if (f != 0.0f) {
            draco.a(f, 3);
        }
        float f2 = this.e;
        if (f2 != 0.0f) {
            draco.a(f2, 4);
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.Eridanus
    public void a(Dorado dorado) {
        this.f10694a = dorado.a(this.f10694a, 0, true);
        this.b = dorado.a(this.b, 1, true);
        this.c = dorado.a(this.c, 2, true);
        this.d = dorado.a(this.d, 3, false);
        this.e = dorado.a(this.e, 4, false);
    }
}
