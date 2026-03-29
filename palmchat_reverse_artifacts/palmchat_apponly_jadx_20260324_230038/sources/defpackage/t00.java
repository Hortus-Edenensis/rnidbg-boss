package defpackage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class t00 implements ky3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f20879a;
    public final AtomicReferenceArray<ky3> b;
    public final Object c;

    public t00(CharSequence charSequence, Object obj, List<ky3> list) {
        ky3[] ky3VarArr = (ky3[]) list.toArray(new ky3[list.size()]);
        Arrays.sort(ky3VarArr, new ly3());
        this.b = new AtomicReferenceArray<>(ky3VarArr);
        this.f20879a = a10.g(charSequence);
        this.c = obj;
    }

    @Override // defpackage.ky3, defpackage.ny3
    public Character a() {
        return Character.valueOf(this.f20879a[0]);
    }

    @Override // defpackage.ky3
    public List<ky3> b() {
        return new aj(this.b);
    }

    @Override // defpackage.ky3
    public CharSequence c() {
        return a10.b(this.f20879a);
    }

    @Override // defpackage.ky3
    public ky3 d(Character ch) {
        int iA = ry3.a(this.b, ch);
        if (iA < 0) {
            return null;
        }
        return this.b.get(iA);
    }

    @Override // defpackage.ky3
    public void e(ky3 ky3Var) {
        int iA = ry3.a(this.b, ky3Var.a());
        if (iA >= 0) {
            this.b.set(iA, ky3Var);
            return;
        }
        throw new IllegalStateException("Cannot update the reference to the following child node for the edge starting with '" + ky3Var.a() + "', no such edge already exists: " + ky3Var);
    }

    @Override // defpackage.ky3
    public Object getValue() {
        return this.c;
    }

    public String toString() {
        return "Node{edge=" + this.f20879a + ", value=" + this.c + ", edges=" + b() + "}";
    }
}
