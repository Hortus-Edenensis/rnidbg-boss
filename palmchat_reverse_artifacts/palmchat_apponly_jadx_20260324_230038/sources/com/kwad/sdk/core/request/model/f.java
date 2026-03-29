package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsJson
public class f extends com.kwad.sdk.core.response.a.a {
    public long aNw;
    public int adStyle;
    public int count;
    public int taskType;

    public f() {
    }

    public final void aG(long j) {
        this.aNw = j;
    }

    public f(int i, int i2, int i3, long j) {
        this.adStyle = i;
        this.taskType = i2;
        this.count = 1;
        this.aNw = j;
    }
}
