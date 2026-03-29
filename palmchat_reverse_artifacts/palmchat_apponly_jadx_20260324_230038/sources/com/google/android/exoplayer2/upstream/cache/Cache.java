package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import defpackage.lp0;
import defpackage.mp0;
import defpackage.nw;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface Cache {

    /* JADX INFO: compiled from: SearchBox */
    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(Throwable th) {
            super(th);
        }

        public CacheException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Cache cache, nw nwVar, nw nwVar2);

        void c(Cache cache, nw nwVar);

        void d(Cache cache, nw nwVar);
    }

    @WorkerThread
    void a(nw nwVar);

    void b(nw nwVar);

    @WorkerThread
    void c(String str, mp0 mp0Var) throws CacheException;

    @WorkerThread
    void commitFile(File file, long j) throws CacheException;

    lp0 getContentMetadata(String str);

    @WorkerThread
    File startFile(String str, long j, long j2) throws CacheException;

    @WorkerThread
    nw startReadWrite(String str, long j, long j2) throws InterruptedException, CacheException;

    @Nullable
    @WorkerThread
    nw startReadWriteNonBlocking(String str, long j, long j2) throws CacheException;
}
