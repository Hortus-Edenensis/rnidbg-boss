package defpackage;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ta1<T> implements mp2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20939a;
    public List<T> b;

    public ta1(List<T> list) {
        this.b = list;
    }

    @Override // defpackage.mp2
    public T b() {
        int size = this.f20939a % this.b.size();
        this.f20939a = size;
        return this.b.get(size);
    }

    @Override // defpackage.mp2
    public T c() {
        this.f20939a++;
        return b();
    }
}
