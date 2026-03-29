package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LogDto f5549a;
    private d b;
    private String c;

    public f(LogDto logDto, d dVar, String str) {
        this.f5549a = logDto;
        this.b = dVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar;
        LogDto logDto = this.f5549a;
        HttpResponse httpResponse = (logDto == null || (dVar = this.b) == null) ? new HttpResponse() : dVar.a(logDto, true);
        e.a().a(this.c, httpResponse.succ ? 0 : httpResponse.getHttpCode());
        this.c = null;
        this.b = null;
    }
}
