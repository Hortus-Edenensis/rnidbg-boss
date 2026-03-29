package defpackage;

import java.util.Iterator;
import java.util.Vector;
import junit.framework.Test;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class mu5 implements Test {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19371a;
    public Vector<Test> b = new Vector<>(10);

    public mu5(String str) {
        d(str);
    }

    public void a(Test test) {
        this.b.add(test);
    }

    public String b() {
        return this.f19371a;
    }

    public void c(Test test, lu5 lu5Var) {
        test.run(lu5Var);
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        Iterator<Test> it = this.b.iterator();
        int iCountTestCases = 0;
        while (it.hasNext()) {
            iCountTestCases += it.next().countTestCases();
        }
        return iCountTestCases;
    }

    public void d(String str) {
        this.f19371a = str;
    }

    @Override // junit.framework.Test
    public void run(lu5 lu5Var) {
        for (Test test : this.b) {
            if (lu5Var.g()) {
                return;
            } else {
                c(test, lu5Var);
            }
        }
    }

    public String toString() {
        return b() != null ? b() : super.toString();
    }
}
