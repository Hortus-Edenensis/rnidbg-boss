package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class DialogRedirectImpl extends DialogRedirect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f6700a;
    private final int b;
    private final Intent c;

    public DialogRedirectImpl(Intent intent, Activity activity, int i) {
        this.c = intent;
        this.f6700a = activity;
        this.b = i;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Activity activity;
        Intent intent = this.c;
        if (intent == null || (activity = this.f6700a) == null) {
            return;
        }
        activity.startActivityForResult(intent, this.b);
    }
}
