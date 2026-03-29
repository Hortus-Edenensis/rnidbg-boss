package com.efs.sdk.base.core.util.a;

import androidx.annotation.NonNull;
import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.efs.sdk.base.core.util.concurrent.d<HttpResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f5595a;

    public c(@NonNull b bVar) {
        super(bVar);
        this.f5595a = bVar;
    }

    @NonNull
    public final HttpResponse b() {
        this.f5595a.e = "post";
        return a();
    }
}
