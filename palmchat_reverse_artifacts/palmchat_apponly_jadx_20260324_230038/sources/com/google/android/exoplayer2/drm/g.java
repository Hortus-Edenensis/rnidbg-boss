package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import defpackage.bk4;
import defpackage.hr0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface g {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f5864a;
        public final String b;
        public final int c;

        public a(byte[] bArr, String str, int i) {
            this.f5864a = bArr;
            this.b = str;
            this.c = i;
        }

        public byte[] a() {
            return this.f5864a;
        }

        public String b() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(g gVar, @Nullable byte[] bArr, int i, int i2, @Nullable byte[] bArr2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        g acquireExoMediaDrm(UUID uuid);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f5865a;
        public final String b;

        public d(byte[] bArr, String str) {
            this.f5865a = bArr;
            this.b = str;
        }

        public byte[] a() {
            return this.f5865a;
        }

        public String b() {
            return this.b;
        }
    }

    void a(@Nullable b bVar);

    void b(byte[] bArr, bk4 bk4Var);

    void closeSession(byte[] bArr);

    hr0 createCryptoConfig(byte[] bArr) throws MediaCryptoException;

    int getCryptoType();

    a getKeyRequest(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException;

    d getProvisionRequest();

    byte[] openSession() throws MediaDrmException;

    @Nullable
    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException;

    void provideProvisionResponse(byte[] bArr) throws DeniedByServerException;

    Map<String, String> queryKeyStatus(byte[] bArr);

    void release();

    boolean requiresSecureDecoder(byte[] bArr, String str);

    void restoreKeys(byte[] bArr, byte[] bArr2);
}
