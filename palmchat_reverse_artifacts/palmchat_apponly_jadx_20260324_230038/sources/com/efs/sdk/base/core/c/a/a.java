package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.model.LogDto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f5555a;

    public abstract void a(LogDto logDto);

    public final void b(LogDto logDto) {
        a aVar = this.f5555a;
        if (aVar != null) {
            aVar.a(logDto);
        }
    }
}
