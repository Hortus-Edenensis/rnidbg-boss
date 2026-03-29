package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class f1<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n0<TResult> f6448a;
    public final String b;
    public final IMessageEntity c;
    public final w d;
    public RequestHeader e;

    public f1(String str, IMessageEntity iMessageEntity) {
        this.b = str;
        this.c = iMessageEntity;
        this.d = w.a(str);
    }

    public abstract void a(ApiException apiException, Object obj);

    public final void b(ApiException apiException, Object obj) {
        if (this.f6448a != null) {
            a(apiException, obj);
        }
    }
}
