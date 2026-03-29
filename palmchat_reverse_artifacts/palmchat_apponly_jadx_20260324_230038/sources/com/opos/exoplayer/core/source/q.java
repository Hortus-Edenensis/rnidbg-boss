package com.opos.exoplayer.core.source;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class q extends com.opos.exoplayer.core.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f8305a;

    public q(String str, Uri uri) {
        super(str);
        this.f8305a = uri;
    }

    @Override // com.opos.exoplayer.core.m, com.opos.exoplayer.core.util.c
    public String a() {
        return "UnrecognizedInputFormatException";
    }
}
