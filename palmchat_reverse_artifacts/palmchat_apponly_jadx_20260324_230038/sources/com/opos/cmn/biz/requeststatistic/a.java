package com.opos.cmn.biz.requeststatistic;

import android.content.Context;
import com.efs.sdk.base.Constants;
import com.opos.cmn.biz.a.e;
import com.opos.cmn.func.a.a.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: com.opos.cmn.biz.requeststatistic.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class RunnableC0655a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7864a;
        final /* synthetic */ String b;
        final /* synthetic */ b c;

        public RunnableC0655a(Context context, String str, b bVar) {
            this.f7864a = context;
            this.b = str;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f7864a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onFail();

        void onSuccess();
    }

    private static Map<String, String> a(Context context) {
        HashMap map = new HashMap();
        map.put("Content-type", "application/json");
        map.put(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
        map.put("Connection", HTTP.CONN_KEEP_ALIVE);
        map.put("Route-Data", e.a(context));
        return map;
    }

    public static final void b(Context context, String str, b bVar) {
        com.opos.cmn.an.j.b.a().execute(new RunnableC0655a(context, str, bVar));
    }

    public static final void a(Context context, String str, b bVar) {
        com.opos.cmn.func.a.a.e eVarA = null;
        try {
            try {
                Map<String, String> mapA = a(context);
                mapA.put("Content-Encoding", Constants.CP_GZIP);
                byte[] bArrA = a(str);
                eVarA = com.opos.cmn.func.a.a.b.a().a(context, new d.a().a(mapA).a(bArrA).a("POST").b(com.opos.cmn.biz.requeststatistic.b.a(context)).a());
                if (eVarA == null || 200 != eVarA.f7934a) {
                    if (bVar != null) {
                        bVar.onFail();
                    }
                } else if (bVar != null) {
                    bVar.onSuccess();
                }
                if (eVarA == null) {
                    return;
                }
            } catch (Exception unused) {
                if (bVar != null) {
                    bVar.onFail();
                }
                if (0 == 0) {
                    return;
                }
            }
            eVarA.a();
        } catch (Throwable th) {
            if (0 != 0) {
                eVarA.a();
            }
            throw th;
        }
    }

    public static final byte[] a(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }
}
