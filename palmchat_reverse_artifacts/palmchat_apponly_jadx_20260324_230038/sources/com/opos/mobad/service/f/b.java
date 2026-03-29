package com.opos.mobad.service.f;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.opos.cmn.func.a.a.d;
import com.opos.cmn.func.a.a.e;
import java.io.IOException;
import java.util.HashMap;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Source;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: compiled from: SearchBox */
    public interface a<T> {
        T b(BufferedSource bufferedSource) throws IOException;
    }

    /* JADX INFO: renamed from: com.opos.mobad.service.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0773b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9237a;
        public final String b;
        public final T c;

        public C0773b(int i, T t) {
            this.f9237a = i;
            this.b = null;
            this.c = t;
        }

        public C0773b(int i, String str) {
            this.f9237a = i;
            this.b = str;
            this.c = null;
        }
    }

    public static final <T> C0773b a(Context context, String str, byte[] bArr, a<T> aVar) {
        e eVarA;
        String strA;
        T tB = (T) null;
        if (context == null || TextUtils.isEmpty(str)) {
            return new C0773b(-1, (String) null);
        }
        try {
            HashMap map = new HashMap();
            map.put("Content-Type", "application/x-protobuf");
            map.put(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
            map.put(HttpHeaders.ACCEPT, "application/x-protobuf");
            map.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
            if (bArr != null && bArr.length >= 1024) {
                com.opos.cmn.an.f.a.b("data", "data.length >= 1024 ,need gzip compress.");
                bArr = com.opos.cmn.b.c.a.a(bArr);
                map.put("Content-Encoding", Constants.CP_GZIP);
            }
            d.a aVarA = new d.a().a("POST").b(str).a(map);
            if (bArr != null) {
                aVarA.a(bArr);
            }
            eVarA = com.opos.cmn.func.a.a.b.a().a(context, aVarA.a());
        } catch (Throwable th) {
            th = th;
        }
        if (eVarA == null) {
            if (eVarA != null) {
                eVarA.a();
            }
            return new C0773b(-1, "Unknown error. ");
        }
        try {
            boolean zEqualsIgnoreCase = false;
            com.opos.cmn.an.f.a.b("data", "fetchAd netResponse=", eVarA);
            int i = eVarA.f7934a;
            if (200 != i) {
                C0773b c0773b = new C0773b(i, eVarA.b);
                eVarA.a();
                return c0773b;
            }
            if (aVar != null) {
                com.opos.cmn.func.a.a.a aVar2 = eVarA.f;
                if (aVar2 != null && (strA = aVar2.a("Content-Encoding")) != null) {
                    zEqualsIgnoreCase = Constants.CP_GZIP.equalsIgnoreCase(strA);
                }
                Source source = Okio.source(eVarA.c);
                if (zEqualsIgnoreCase) {
                    source = new GzipSource(source);
                }
                BufferedSource bufferedSourceBuffer = Okio.buffer(source);
                tB = aVar.b(bufferedSourceBuffer);
                source.close();
                bufferedSourceBuffer.close();
            }
            C0773b c0773b2 = new C0773b(eVarA.f7934a, tB);
            eVarA.a();
            return c0773b2;
        } catch (Throwable th2) {
            tB = (T) eVarA;
            th = th2;
            try {
                com.opos.cmn.an.f.a.a("data", "", th);
                return new C0773b(-1, "Unknown error. ");
            } finally {
                if (tB != null) {
                    tB.a();
                }
            }
        }
    }
}
