package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class v00 implements ky3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f21333a;

    public v00(CharSequence charSequence) {
        this.f21333a = a10.g(charSequence);
    }

    @Override // defpackage.ky3, defpackage.ny3
    public Character a() {
        return Character.valueOf(this.f21333a[0]);
    }

    @Override // defpackage.ky3
    public List<ky3> b() {
        return Collections.emptyList();
    }

    @Override // defpackage.ky3
    public CharSequence c() {
        return a10.b(this.f21333a);
    }

    @Override // defpackage.ky3
    public ky3 d(Character ch) {
        return null;
    }

    @Override // defpackage.ky3
    public void e(ky3 ky3Var) {
        throw new IllegalStateException("Cannot update the reference to the following child node for the edge starting with '" + ky3Var.a() + "', no such edge already exists: " + ky3Var);
    }

    @Override // defpackage.ky3
    public Object getValue() {
        return ph6.f20019a;
    }

    public String toString() {
        return "Node{edge=" + this.f21333a + ", value=" + ph6.f20019a + ", edges=[]}";
    }
}
