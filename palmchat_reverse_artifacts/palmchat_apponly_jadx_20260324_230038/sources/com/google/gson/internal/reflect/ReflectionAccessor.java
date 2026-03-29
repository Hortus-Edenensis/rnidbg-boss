package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import defpackage.hl4;
import defpackage.t46;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ReflectionAccessor {
    private static final ReflectionAccessor instance;

    static {
        instance = JavaVersion.getMajorJavaVersion() < 9 ? new hl4() : new t46();
    }

    public static ReflectionAccessor getInstance() {
        return instance;
    }

    public abstract void makeAccessible(AccessibleObject accessibleObject);
}
