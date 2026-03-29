package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class lu5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ju5> f19077a = new ArrayList();
    public List<ju5> b = new ArrayList();
    public List<ku5> c = new ArrayList();
    public int d = 0;
    public boolean e = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements po4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TestCase f19078a;

        public a(TestCase testCase) throws Throwable {
            this.f19078a = testCase;
        }

        @Override // defpackage.po4
        public void a() throws Throwable {
            this.f19078a.runBare();
        }
    }

    public synchronized void a(Test test, Throwable th) {
        this.b.add(new ju5(test, th));
        Iterator<ku5> it = c().iterator();
        while (it.hasNext()) {
            it.next().a(test, th);
        }
    }

    public synchronized void b(Test test, AssertionFailedError assertionFailedError) {
        this.f19077a.add(new ju5(test, assertionFailedError));
        Iterator<ku5> it = c().iterator();
        while (it.hasNext()) {
            it.next().b(test, assertionFailedError);
        }
    }

    public final synchronized List<ku5> c() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.c);
        return arrayList;
    }

    public void d(Test test) {
        Iterator<ku5> it = c().iterator();
        while (it.hasNext()) {
            it.next().c(test);
        }
    }

    public void e(TestCase testCase) {
        h(testCase);
        f(testCase, new a(testCase));
        d(testCase);
    }

    public void f(Test test, po4 po4Var) {
        try {
            po4Var.a();
        } catch (ThreadDeath e) {
            throw e;
        } catch (AssertionFailedError e2) {
            b(test, e2);
        } catch (Throwable th) {
            a(test, th);
        }
    }

    public synchronized boolean g() {
        return this.e;
    }

    public void h(Test test) {
        int iCountTestCases = test.countTestCases();
        synchronized (this) {
            this.d += iCountTestCases;
        }
        Iterator<ku5> it = c().iterator();
        while (it.hasNext()) {
            it.next().d(test);
        }
    }
}
