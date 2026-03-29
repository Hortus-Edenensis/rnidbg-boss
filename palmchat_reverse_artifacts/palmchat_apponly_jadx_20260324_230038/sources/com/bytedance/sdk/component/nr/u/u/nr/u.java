package com.bytedance.sdk.component.nr.u.u.nr;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.sdk.component.nr.u.a;
import com.bytedance.sdk.component.nr.u.k;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import com.bytedance.sdk.component.nr.u.t;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.component.nr.u.nr {
    private volatile boolean iz;
    b nr;
    s u;
    private AtomicBoolean pn = new AtomicBoolean(false);
    final String fx = com.bytedance.sdk.component.nr.u.nr.b.u(UUID.randomUUID().toString()).u();
    t b = new t();

    /* JADX INFO: renamed from: com.bytedance.sdk.component.nr.u.u.nr.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public final class C0228u extends com.bytedance.sdk.component.nr.u.nr.pn {
        private final u b;
        private final com.bytedance.sdk.component.nr.u.fx fx;

        public C0228u(com.bytedance.sdk.component.nr.u.fx fxVar, u uVar) {
            super("net-async-call", new Object[0]);
            this.fx = fxVar;
            this.b = uVar;
        }

        @Override // com.bytedance.sdk.component.nr.u.nr.pn
        public void nr() {
            t tVar;
            try {
                u uVar = this.b;
                if (uVar != null && (tVar = uVar.b) != null) {
                    tVar.u();
                }
                my myVarPn = u.this.pn();
                if (myVarPn == null) {
                    this.fx.onFailure(u.this, new IOException("response is null"));
                } else {
                    this.fx.onResponse(u.this, myVarPn);
                }
            } catch (Throwable th) {
                try {
                    if (th instanceof IOException) {
                        this.fx.onFailure(u.this, th);
                    } else {
                        this.fx.onFailure(u.this, new IOException(th));
                    }
                    try {
                        this.b.nr.nr(this);
                    } catch (Throwable unused) {
                    }
                } finally {
                    try {
                        this.b.nr.nr(this);
                    } catch (Throwable unused2) {
                    }
                }
            }
        }

        public void u() {
            t tVar;
            u uVar = this.b;
            if (uVar == null || (tVar = uVar.b) == null) {
                return;
            }
            tVar.b();
        }
    }

    public u(s sVar, b bVar) {
        this.u = sVar;
        this.nr = bVar;
    }

    private boolean fx(k kVar) {
        s sVar;
        return (kVar == null || (sVar = this.u) == null || !"POST".equalsIgnoreCase(sVar.fx()) || kVar.iz != k.u.STRING_TYPE || TextUtils.isEmpty(kVar.b)) ? false : true;
    }

    private boolean x() {
        if (this.u.b() == null) {
            return false;
        }
        return this.u.b().containsKey("Content-Type");
    }

    @Override // com.bytedance.sdk.component.nr.u.nr
    public boolean b() {
        return this.pn.get();
    }

    /* JADX INFO: renamed from: iz, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.nr.u.nr clone() {
        return new u(this.u, this.nr);
    }

    @Override // com.bytedance.sdk.component.nr.u.nr
    public my nr() throws IOException {
        synchronized (this) {
            if (this.iz) {
                throw new IllegalStateException("Already Executed");
            }
            this.iz = true;
        }
        try {
            this.nr.u(this);
            return pn();
        } finally {
            this.nr.nr(this);
        }
    }

    public my pn() {
        List<a> list;
        if (this.pn.get()) {
            return null;
        }
        try {
            l lVar = this.u.u;
            if (lVar == null || (list = lVar.u) == null || list.size() <= 0) {
                return u(this.u);
            }
            ArrayList arrayList = new ArrayList(this.u.u.u);
            arrayList.add(new a() { // from class: com.bytedance.sdk.component.nr.u.u.nr.u.1
                @Override // com.bytedance.sdk.component.nr.u.a
                public my u(a.u uVar) throws IOException {
                    return u.this.u(uVar.u());
                }
            });
            return ((a) arrayList.get(0)).u(new nr(arrayList, this.u));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.nr
    public s u() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.nr.u.nr
    public void u(com.bytedance.sdk.component.nr.u.fx fxVar) {
        try {
            synchronized (this) {
                if (this.iz) {
                    throw new IllegalStateException("Already Executed");
                }
                this.iz = true;
            }
            this.nr.u(new C0228u(fxVar, this));
        } catch (Throwable th) {
            if (fxVar != null) {
                fxVar.onFailure(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.nr
    public void fx() {
        this.pn.set(true);
    }

    private boolean nr(k kVar) {
        s sVar;
        byte[] bArr;
        return kVar != null && (sVar = this.u) != null && "POST".equalsIgnoreCase(sVar.fx()) && kVar.iz == k.u.BYTE_ARRAY_TYPE && (bArr = kVar.pn) != null && bArr.length > 0;
    }

    public my u(s sVar) throws IOException {
        try {
            t tVar = this.b;
            if (tVar != null) {
                tVar.nr();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(sVar.nr().u().toString()).openConnection();
            if (sVar.b() != null && sVar.b().size() > 0) {
                for (Map.Entry<String, List<String>> entry : sVar.b().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                    }
                }
            }
            l lVar = sVar.u;
            if (lVar != null) {
                TimeUnit timeUnit = lVar.fx;
                if (timeUnit != null) {
                    httpURLConnection.setConnectTimeout((int) timeUnit.toMillis(lVar.nr));
                }
                l lVar2 = sVar.u;
                TimeUnit timeUnit2 = lVar2.pn;
                if (timeUnit2 != null) {
                    httpURLConnection.setReadTimeout((int) timeUnit2.toMillis(lVar2.b));
                }
            }
            if (sVar.iz() == null) {
                httpURLConnection.setRequestMethod("GET");
            } else {
                if (!x() && sVar.iz().fx != null) {
                    httpURLConnection.addRequestProperty("Content-Type", sVar.iz().fx.toString());
                }
                httpURLConnection.setRequestMethod(sVar.fx());
                if (u(sVar.iz())) {
                    u(httpURLConnection);
                }
                if ("POST".equalsIgnoreCase(sVar.fx())) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (fx(sVar.iz())) {
                        outputStream.write(sVar.iz().b.getBytes());
                    } else if (u(sVar.iz())) {
                        u(sVar.iz().pn, outputStream, sVar.iz().nr(), sVar.iz().u());
                    } else if (nr(sVar.iz())) {
                        outputStream.write(sVar.iz().pn);
                    }
                    outputStream.flush();
                    outputStream.close();
                }
            }
            httpURLConnection.connect();
            long jCurrentTimeMillis = System.currentTimeMillis();
            t tVar2 = this.b;
            if (tVar2 != null) {
                tVar2.fx();
                this.b.u(jCurrentTimeMillis);
            }
            httpURLConnection.getResponseCode();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (this.pn.get()) {
                httpURLConnection.disconnect();
                return null;
            }
            iz izVar = new iz(httpURLConnection, sVar);
            izVar.b = jCurrentTimeMillis;
            izVar.fx = jCurrentTimeMillis2;
            t tVar3 = this.b;
            if (tVar3 != null) {
                tVar3.nr(jCurrentTimeMillis2);
            }
            izVar.pn = this.b;
            return izVar;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void u(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.fx);
    }

    private void u(byte[] bArr, OutputStream outputStream, String str, String str2) throws IOException {
        if (bArr == null || outputStream == null) {
            return;
        }
        PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
        printWriter.append((CharSequence) (HttpClient.ENDFLAG + this.fx)).append((CharSequence) HttpClient.NEWLINE);
        printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"")).append((CharSequence) HttpClient.NEWLINE);
        printWriter.append((CharSequence) "Content-Type: multipart/form-data").append((CharSequence) HttpClient.NEWLINE);
        StringBuilder sb = new StringBuilder("Content-Length: ");
        sb.append(bArr.length);
        printWriter.append((CharSequence) sb.toString()).append((CharSequence) HttpClient.NEWLINE);
        printWriter.append((CharSequence) HttpClient.NEWLINE);
        printWriter.flush();
        outputStream.write(bArr);
        printWriter.append((CharSequence) HttpClient.NEWLINE);
        printWriter.append((CharSequence) (HttpClient.ENDFLAG + this.fx + HttpClient.ENDFLAG)).append((CharSequence) HttpClient.NEWLINE);
        printWriter.flush();
        printWriter.close();
    }

    private boolean u(k kVar) {
        s sVar;
        byte[] bArr;
        return kVar != null && (sVar = this.u) != null && "POST".equalsIgnoreCase(sVar.fx()) && kVar.iz == k.u.FILE_TYPE && (bArr = kVar.pn) != null && bArr.length > 0;
    }
}
