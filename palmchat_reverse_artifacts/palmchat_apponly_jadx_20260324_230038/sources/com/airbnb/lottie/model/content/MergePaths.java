package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import defpackage.ko0;
import defpackage.m63;
import defpackage.np0;
import defpackage.sn3;
import defpackage.u83;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class MergePaths implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2519a;
    public final MergePathsMode b;
    public final boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.f2519a = str;
        this.b = mergePathsMode;
        this.c = z;
    }

    @Override // defpackage.np0
    @Nullable
    public ko0 a(u83 u83Var, com.airbnb.lottie.model.layer.a aVar) {
        if (u83Var.F()) {
            return new sn3(this);
        }
        m63.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public MergePathsMode b() {
        return this.b;
    }

    public String c() {
        return this.f2519a;
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.b + '}';
    }
}
