package org.junit.runners;

import defpackage.bp3;
import java.lang.reflect.Method;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public enum MethodSorters {
    NAME_ASCENDING(bp3.b),
    JVM(null),
    DEFAULT(bp3.f1795a);

    private final Comparator<Method> comparator;

    MethodSorters(Comparator comparator) {
        this.comparator = comparator;
    }

    public Comparator<Method> getComparator() {
        return this.comparator;
    }
}
