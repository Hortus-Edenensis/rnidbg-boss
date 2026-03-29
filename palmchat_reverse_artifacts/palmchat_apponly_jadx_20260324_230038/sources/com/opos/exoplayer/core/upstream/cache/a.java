package com.opos.exoplayer.core.upstream.cache;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface a {

    /* JADX INFO: renamed from: com.opos.exoplayer.core.upstream.cache.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0705a extends com.opos.exoplayer.core.util.c {
        @Override // com.opos.exoplayer.core.util.c
        public String a() {
            return "CacheException";
        }
    }

    long a();

    long a(String str);

    b a(String str, long j);

    void a(b bVar);

    @Nullable
    b b(String str, long j);

    void c(String str, long j);
}
