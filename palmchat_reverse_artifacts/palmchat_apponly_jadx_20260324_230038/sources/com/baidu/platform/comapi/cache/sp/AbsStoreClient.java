package com.baidu.platform.comapi.cache.sp;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbsStoreClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SpStorageService f4130a;
    private final String b;

    public AbsStoreClient(SpStorageConfig spStorageConfig, String str) {
        this.f4130a = SpStorageService.a(spStorageConfig);
        this.b = str;
    }

    private void a() {
        if (TextUtils.isEmpty(this.b)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean readBoolean(boolean z) {
        a();
        return this.f4130a.a(this.b, z);
    }

    public float readFloat(float f) {
        a();
        return this.f4130a.a(this.b, f);
    }

    public int readInt(int i) {
        a();
        return this.f4130a.a(this.b, i);
    }

    public long readLong(long j) {
        a();
        return this.f4130a.a(this.b, j);
    }

    public String readString(String str) {
        a();
        return this.f4130a.a(this.b, str);
    }

    public void remove() {
        a();
        this.f4130a.a(this.b);
    }

    public void writeBoolean(boolean z) {
        a();
        this.f4130a.b(this.b, z);
    }

    public void writeFloat(float f) {
        a();
        this.f4130a.b(this.b, f);
    }

    public void writeInt(int i) {
        a();
        this.f4130a.b(this.b, i);
    }

    public void writeLong(long j) {
        a();
        this.f4130a.b(this.b, j);
    }

    public void writeString(String str) {
        a();
        this.f4130a.b(this.b, str);
    }
}
