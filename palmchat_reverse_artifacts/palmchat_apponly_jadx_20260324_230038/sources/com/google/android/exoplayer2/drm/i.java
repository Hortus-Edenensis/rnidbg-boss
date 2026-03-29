package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.g;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import com.google.common.collect.ImmutableMap;
import defpackage.bv0;
import defpackage.g86;
import defpackage.rk5;
import defpackage.vh;
import defpackage.zv;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class i implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.InterfaceC0360a f5867a;

    @Nullable
    public final String b;
    public final boolean c;
    public final Map<String, String> d;

    public i(@Nullable String str, boolean z, a.InterfaceC0360a interfaceC0360a) {
        vh.a((z && TextUtils.isEmpty(str)) ? false : true);
        this.f5867a = interfaceC0360a;
        this.b = str;
        this.c = z;
        this.d = new HashMap();
    }

    public static byte[] c(a.InterfaceC0360a interfaceC0360a, String str, @Nullable byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        rk5 rk5Var = new rk5(interfaceC0360a.createDataSource());
        com.google.android.exoplayer2.upstream.b bVarA = new b.C0361b().j(str).e(map).d(2).c(bArr).b(1).a();
        int i = 0;
        com.google.android.exoplayer2.upstream.b bVarA2 = bVarA;
        while (true) {
            try {
                bv0 bv0Var = new bv0(rk5Var, bVarA2);
                try {
                    return g86.f1(bv0Var);
                } catch (HttpDataSource$InvalidResponseCodeException e) {
                    String strD = d(e, i);
                    if (strD == null) {
                        throw e;
                    }
                    i++;
                    bVarA2 = bVarA2.a().j(strD).a();
                } finally {
                    g86.n(bv0Var);
                }
            } catch (Exception e2) {
                throw new MediaDrmCallbackException(bVarA, (Uri) vh.e(rk5Var.d()), rk5Var.getResponseHeaders(), rk5Var.c(), e2);
            }
        }
    }

    @Nullable
    public static String d(HttpDataSource$InvalidResponseCodeException httpDataSource$InvalidResponseCodeException, int i) {
        Map<String, List<String>> map;
        List<String> list;
        int i2 = httpDataSource$InvalidResponseCodeException.responseCode;
        if (!((i2 == 307 || i2 == 308) && i < 5) || (map = httpDataSource$InvalidResponseCodeException.headerFields) == null || (list = map.get(HttpHeaders.LOCATION)) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // com.google.android.exoplayer2.drm.j
    public byte[] a(UUID uuid, g.a aVar) throws MediaDrmCallbackException {
        String strB = aVar.b();
        if (this.c || TextUtils.isEmpty(strB)) {
            strB = this.b;
        }
        if (TextUtils.isEmpty(strB)) {
            throw new MediaDrmCallbackException(new b.C0361b().i(Uri.EMPTY).a(), Uri.EMPTY, ImmutableMap.of(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        UUID uuid2 = zv.e;
        map.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : zv.c.equals(uuid) ? "application/json" : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.d) {
            map.putAll(this.d);
        }
        return c(this.f5867a, strB, aVar.a(), map);
    }

    @Override // com.google.android.exoplayer2.drm.j
    public byte[] b(UUID uuid, g.d dVar) throws MediaDrmCallbackException {
        return c(this.f5867a, dVar.b() + "&signedRequest=" + g86.D(dVar.a()), null, Collections.emptyMap());
    }

    public void e(String str, String str2) {
        vh.e(str);
        vh.e(str2);
        synchronized (this.d) {
            this.d.put(str, str2);
        }
    }
}
