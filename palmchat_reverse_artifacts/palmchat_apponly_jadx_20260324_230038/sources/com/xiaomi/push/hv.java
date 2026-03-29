package com.xiaomi.push;

import com.xiaomi.push.hw;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ia f11637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ih f827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ByteArrayOutputStream f828a;

    public hv() {
        this(new hw.a());
    }

    public byte[] a(hq hqVar) {
        this.f828a.reset();
        hqVar.b(this.f11637a);
        return this.f828a.toByteArray();
    }

    public hv(ic icVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f828a = byteArrayOutputStream;
        ih ihVar = new ih(byteArrayOutputStream);
        this.f827a = ihVar;
        this.f11637a = icVar.a(ihVar);
    }
}
