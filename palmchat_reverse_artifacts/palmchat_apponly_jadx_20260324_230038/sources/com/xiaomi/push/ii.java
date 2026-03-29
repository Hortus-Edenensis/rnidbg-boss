package com.xiaomi.push;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ii extends ik {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private hs f844a;

    public ii(int i) {
        this.f844a = new hs(i);
    }

    @Override // com.xiaomi.push.ik
    public int a(byte[] bArr, int i, int i2) {
        byte[] bArrM623a = this.f844a.m623a();
        if (i2 > this.f844a.a() - this.f11650a) {
            i2 = this.f844a.a() - this.f11650a;
        }
        if (i2 > 0) {
            System.arraycopy(bArrM623a, this.f11650a, bArr, i, i2);
            this.f11650a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.ik
    /* JADX INFO: renamed from: a */
    public void mo646a(byte[] bArr, int i, int i2) throws IOException {
        this.f844a.write(bArr, i, i2);
    }

    public int a() {
        return this.f844a.size();
    }
}
