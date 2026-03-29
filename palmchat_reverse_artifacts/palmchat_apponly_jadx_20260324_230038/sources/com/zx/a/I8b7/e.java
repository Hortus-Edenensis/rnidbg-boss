package com.zx.a.I8b7;

import com.efs.sdk.base.Constants;
import com.zx.a.I8b7.n0;
import com.zx.a.I8b7.q1;
import com.zx.a.I8b7.t1;
import com.zx.a.I8b7.u1;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class e implements n0 {
    @Override // com.zx.a.I8b7.n0
    public t1 a(n0.a aVar) throws IOException {
        boolean z;
        u1 u1Var;
        j1 j1Var = (j1) aVar;
        q1 q1Var = j1Var.c;
        q1.a aVar2 = new q1.a(q1Var);
        HttpURLConnection httpURLConnection = (HttpURLConnection) q1Var.f16847a.openConnection();
        s1 s1Var = q1Var.d;
        if (s1Var != null) {
            r1 r1Var = (r1) s1Var;
            x0 x0Var = r1Var.f16853a;
            if (x0Var != null) {
                aVar2.c.put("Content-Type", x0Var.f16881a);
            }
            long j = r1Var.b;
            if (j != -1) {
                aVar2.c.put("Content-Length", Long.toString(j));
                aVar2.c.remove("Transfer-Encoding");
            } else {
                aVar2.c.put("Transfer-Encoding", HTTP.CHUNK_CODING);
                aVar2.c.remove("Content-Length");
            }
        }
        if (q1Var.c.get("Host") == null) {
            aVar2.c.put("Host", q1Var.f16847a.getHost());
        }
        if (q1Var.c.get("Connection") == null) {
            aVar2.c.put("Connection", HTTP.CONN_KEEP_ALIVE);
        }
        if (q1Var.c.get(HttpHeaders.ACCEPT_ENCODING) == null && q1Var.c.get(HttpHeaders.RANGE) == null) {
            aVar2.c.put(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
            z = true;
        } else {
            z = false;
        }
        t1 t1VarA = j1Var.a(new q1(aVar2), httpURLConnection);
        t1.a aVar3 = new t1.a(t1VarA);
        aVar3.f16864a = q1Var;
        if (z && Constants.CP_GZIP.equalsIgnoreCase(t1VarA.a("Content-Encoding")) && (u1Var = t1VarA.e) != null) {
            aVar3.e = u1.a(((u1.a) u1Var).f16869a, -1L, new GZIPInputStream(((u1.a) t1VarA.e).c));
            aVar3.d.remove("Content-Encoding");
            aVar3.d.remove("Content-Length");
        }
        return aVar3.a();
    }
}
