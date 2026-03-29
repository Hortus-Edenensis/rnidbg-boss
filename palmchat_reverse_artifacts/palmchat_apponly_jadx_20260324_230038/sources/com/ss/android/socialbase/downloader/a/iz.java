package com.ss.android.socialbase.downloader.a;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface iz {
    void fx(BaseException baseException);

    void nr(BaseException baseException);

    boolean nr(long j) throws BaseException;

    com.ss.android.socialbase.downloader.exception.n u(BaseException baseException, long j);

    com.ss.android.socialbase.downloader.exception.n u(com.ss.android.socialbase.downloader.model.nr nrVar, BaseException baseException, long j);

    com.ss.android.socialbase.downloader.model.nr u(int i);

    void u(long j) throws BaseException;

    void u(nr nrVar);

    void u(BaseException baseException, boolean z);

    void u(com.ss.android.socialbase.downloader.network.x xVar);

    void u(String str, com.ss.android.socialbase.downloader.network.x xVar, long j) throws a, BaseException;

    boolean u(BaseException baseException);
}
