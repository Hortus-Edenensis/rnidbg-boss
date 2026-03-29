package com.efs.sdk.base.core.cache;

import androidx.annotation.Nullable;
import com.efs.sdk.base.core.util.Log;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Byte, d> f5561a = new ConcurrentHashMap<>();

    @Nullable
    public final d a(byte b) {
        if (!this.f5561a.containsKey(Byte.valueOf(b))) {
            if (b == 1) {
                this.f5561a.putIfAbsent(Byte.valueOf(b), new e());
            } else if (b != 2) {
                Log.w("efs.cache", "Cache module not support protocol ".concat(String.valueOf((int) b)));
            } else {
                this.f5561a.putIfAbsent(Byte.valueOf(b), new c());
            }
        }
        return this.f5561a.get(Byte.valueOf(b));
    }
}
