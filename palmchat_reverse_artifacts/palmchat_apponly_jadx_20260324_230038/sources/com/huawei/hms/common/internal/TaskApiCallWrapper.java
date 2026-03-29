package com.huawei.hms.common.internal;

import defpackage.it5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskApiCall<? extends AnyClient, TResult> f6709a;
    private final it5<TResult> b;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, it5<TResult> it5Var) {
        super(1);
        this.f6709a = taskApiCall;
        this.b = it5Var;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.f6709a;
    }

    public it5<TResult> getTaskCompletionSource() {
        return this.b;
    }
}
