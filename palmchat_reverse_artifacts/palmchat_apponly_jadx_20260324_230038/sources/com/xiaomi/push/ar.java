package com.xiaomi.push;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ar implements at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11421a;
    private final String b;

    public ar(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f11421a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.at
    public String a() {
        return this.f11421a;
    }

    @Override // com.xiaomi.push.at
    public String b() {
        return this.b;
    }
}
