package com.zx.a.I8b7;

import com.zx.a.I8b7.n0;
import com.zx.a.I8b7.t1;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class j implements n0 {
    @Override // com.zx.a.I8b7.n0
    public t1 a(n0.a aVar) throws IOException {
        j1 j1Var = (j1) aVar;
        q1 q1Var = j1Var.c;
        HttpURLConnection httpURLConnection = j1Var.d;
        if (httpURLConnection.getDoOutput() && q1Var.d != null) {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            r1 r1Var = (r1) q1Var.d;
            outputStream.write(r1Var.c, r1Var.d, r1Var.b);
            c2.a(outputStream);
        }
        int responseCode = httpURLConnection.getResponseCode();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        x0 x0VarB = x0.b("text/json; charset=utf-8");
        if (httpURLConnection.getContentType() != null) {
            x0VarB = x0.b(httpURLConnection.getContentType());
        }
        String responseMessage = httpURLConnection.getResponseMessage();
        t1.a aVar2 = new t1.a();
        aVar2.b = responseCode;
        aVar2.d = new HashMap(headerFields);
        aVar2.c = responseMessage;
        aVar2.e = u1.a(x0VarB, httpURLConnection.getContentLength(), responseCode == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream());
        aVar2.f16864a = q1Var;
        return aVar2.a();
    }
}
