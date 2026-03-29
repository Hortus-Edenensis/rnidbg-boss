package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class jr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f18483a;
    public List<String> b;

    public jr() {
        this.f18483a = null;
        this.b = null;
        this.f18483a = new ArrayList();
        this.b = new ArrayList();
    }

    public final void a(List<String> list, String str) {
        if (list == null || str == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(str)) {
                return;
            }
        }
        list.add(str);
    }

    public abstract boolean b();

    public abstract boolean c();

    public void d(String str) {
        a(this.f18483a, str);
    }
}
