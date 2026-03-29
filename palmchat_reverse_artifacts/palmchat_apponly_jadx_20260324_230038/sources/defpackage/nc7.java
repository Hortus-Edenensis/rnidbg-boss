package defpackage;

import com.alipay.sdk.m.x.e;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nc7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Stack<e> f19493a = new Stack<>();

    public void a() {
        if (c()) {
            return;
        }
        Iterator<e> it = this.f19493a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f19493a.clear();
    }

    public void b(e eVar) {
        this.f19493a.push(eVar);
    }

    public boolean c() {
        return this.f19493a.isEmpty();
    }

    public e d() {
        return this.f19493a.pop();
    }
}
