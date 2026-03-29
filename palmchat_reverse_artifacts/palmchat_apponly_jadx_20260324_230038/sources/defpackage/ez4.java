package defpackage;

import defpackage.dz4;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ez4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<dz4> f17398a = new CopyOnWriteArrayList();
    public volatile boolean b = false;

    public void a(dz4 dz4Var) {
        if (dz4Var == null) {
            throw new NullPointerException("Cannot add a null listener");
        }
        this.f17398a.add(b(dz4Var));
    }

    public dz4 b(dz4 dz4Var) {
        return dz4Var.getClass().isAnnotationPresent(dz4.a.class) ? dz4Var : new kq5(dz4Var, this);
    }
}
