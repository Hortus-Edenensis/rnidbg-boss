package junit.framework;

import defpackage.dz4;
import defpackage.ex2;
import defpackage.ez4;
import defpackage.fx2;
import defpackage.lu5;
import defpackage.mu5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class JUnit4TestAdapterCache extends HashMap<Description, Test> {
    private static final JUnit4TestAdapterCache fInstance = new JUnit4TestAdapterCache();
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends dz4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ lu5 f18510a;

        public a(lu5 lu5Var) {
            this.f18510a = lu5Var;
        }
    }

    public static JUnit4TestAdapterCache getDefault() {
        return fInstance;
    }

    public Test asTest(Description description) {
        if (description.isSuite()) {
            return createTest(description);
        }
        if (!containsKey(description)) {
            put(description, createTest(description));
        }
        return get(description);
    }

    public List<Test> asTestList(Description description) {
        if (description.isTest()) {
            return Arrays.asList(asTest(description));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            arrayList.add(asTest(it.next()));
        }
        return arrayList;
    }

    public Test createTest(Description description) {
        if (description.isTest()) {
            return new fx2(description);
        }
        mu5 mu5Var = new mu5(description.getDisplayName());
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            mu5Var.a(asTest(it.next()));
        }
        return mu5Var;
    }

    public ez4 getNotifier(lu5 lu5Var, ex2 ex2Var) {
        ez4 ez4Var = new ez4();
        ez4Var.a(new a(lu5Var));
        return ez4Var;
    }
}
