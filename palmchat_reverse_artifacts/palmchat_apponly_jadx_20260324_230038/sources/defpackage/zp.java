package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class zp<V, O> implements rd<V, O> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h03<V>> f22472a;

    public zp(List<h03<V>> list) {
        this.f22472a = list;
    }

    @Override // defpackage.rd
    public List<h03<V>> b() {
        return this.f22472a;
    }

    @Override // defpackage.rd
    public boolean isStatic() {
        if (this.f22472a.isEmpty()) {
            return true;
        }
        return this.f22472a.size() == 1 && this.f22472a.get(0).h();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f22472a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f22472a.toArray()));
        }
        return sb.toString();
    }
}
