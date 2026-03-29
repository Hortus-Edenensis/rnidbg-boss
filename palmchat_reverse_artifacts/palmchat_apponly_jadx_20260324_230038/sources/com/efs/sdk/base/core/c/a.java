package com.efs.sdk.base.core.c;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.efs.sdk.base.core.c.a.a f5554a;

    public abstract com.efs.sdk.base.core.c.a.a a();

    public final void a(LogDto logDto) {
        try {
            if (this.f5554a == null) {
                synchronized (this) {
                    if (this.f5554a == null) {
                        com.efs.sdk.base.core.c.a.a aVarA = a();
                        this.f5554a = aVarA;
                        if (aVarA == null) {
                            return;
                        }
                    }
                }
            }
            this.f5554a.a(logDto);
        } catch (Throwable th) {
            Log.e("efs.processor", "log handle error", th);
        }
    }
}
