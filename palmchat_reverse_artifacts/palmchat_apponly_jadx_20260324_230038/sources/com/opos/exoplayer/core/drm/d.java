package com.opos.exoplayer.core.drm;

import android.annotation.TargetApi;
import com.opos.exoplayer.core.drm.c;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(18)
public interface d<T extends com.opos.exoplayer.core.drm.c> {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f8150a;
        private final String b;

        public a(byte[] bArr, String str) {
            this.f8150a = bArr;
            this.b = str;
        }

        @Override // com.opos.exoplayer.core.drm.d.b
        public byte[] a() {
            return this.f8150a;
        }

        @Override // com.opos.exoplayer.core.drm.d.b
        public String b() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        byte[] a();

        String b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
    }

    b a(byte[] bArr, byte[] bArr2, String str, int i, HashMap<String, String> map);

    void a(byte[] bArr);

    byte[] a();

    byte[] a(byte[] bArr, byte[] bArr2);

    c b();

    void b(byte[] bArr);

    void b(byte[] bArr, byte[] bArr2);

    Map<String, String> c(byte[] bArr);

    T d(byte[] bArr);
}
