package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Bullace extends Eridanus implements Cloneable {
    public static Cprivate d = new Cprivate();
    public static final /* synthetic */ boolean e = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10670a = 0;
    public Cprivate b = null;
    public long c = 0;

    @Override // com.tencent.turingfd.sdk.ams.ad.Eridanus
    public void a(Draco draco) {
        draco.a(this.f10670a, 0);
        Cprivate cprivate = this.b;
        if (cprivate != null) {
            draco.a((Eridanus) cprivate, 1);
        }
        draco.a(this.c, 2);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Bullace bullace = (Bullace) obj;
        return Equuleus.a(this.f10670a, bullace.f10670a) && this.b.equals(bullace.b) && Equuleus.a(this.c, bullace.c);
    }

    public int hashCode() {
        try {
            throw new Exception("");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.Eridanus
    public void a(Dorado dorado) {
        this.f10670a = dorado.a(this.f10670a, 0, true);
        this.b = (Cprivate) dorado.a((Eridanus) d, 1, false);
        this.c = dorado.a(this.c, 2, true);
    }
}
