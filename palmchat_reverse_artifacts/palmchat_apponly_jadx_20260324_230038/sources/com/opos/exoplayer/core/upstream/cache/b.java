package com.opos.exoplayer.core.upstream.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b implements Comparable<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8374a;
    public final long b;
    public final long c;
    public final boolean d;

    @Nullable
    public final File e;

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull b bVar) {
        if (!this.f8374a.equals(bVar.f8374a)) {
            return this.f8374a.compareTo(bVar.f8374a);
        }
        long j = this.b - bVar.b;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.d;
    }

    public boolean a() {
        return this.c == -1;
    }
}
