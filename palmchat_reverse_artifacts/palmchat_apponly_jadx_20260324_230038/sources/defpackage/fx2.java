package defpackage;

import junit.framework.Test;
import org.junit.runner.Description;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class fx2 implements Test {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Description f17618a;

    public fx2(Description description) {
        this.f17618a = description;
    }

    public Description a() {
        return this.f17618a;
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        return 1;
    }

    @Override // junit.framework.Test
    public void run(lu5 lu5Var) {
        throw new RuntimeException("This test stub created only for informational purposes.");
    }

    public String toString() {
        return a().toString();
    }
}
