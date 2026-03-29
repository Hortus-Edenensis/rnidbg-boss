package defpackage;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class uk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q16> f21232a = new ArrayList();

    public void a(q16 q16Var) {
        this.f21232a.add(q16Var);
    }

    public void b(Path path) {
        for (int size = this.f21232a.size() - 1; size >= 0; size--) {
            r86.b(path, this.f21232a.get(size));
        }
    }
}
