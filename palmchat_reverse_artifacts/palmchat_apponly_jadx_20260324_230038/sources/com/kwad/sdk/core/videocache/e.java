package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class e extends k {
    private final p aPK;
    private final com.kwad.sdk.core.videocache.a.b aPL;
    private b aPM;

    public e(p pVar, com.kwad.sdk.core.videocache.a.b bVar) {
        super(pVar, bVar);
        this.aPL = bVar;
        this.aPK = pVar;
    }

    private String b(d dVar) {
        String strMn = this.aPK.Mn();
        boolean z = !TextUtils.isEmpty(strMn);
        long jMd = this.aPL.isCompleted() ? this.aPL.Md() : this.aPK.length();
        boolean z2 = jMd >= 0;
        boolean z3 = dVar.aPJ;
        long j = z3 ? jMd - dVar.aPI : jMd;
        boolean z4 = z2 && z3;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.aPJ ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? format("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z4 ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.aPI), Long.valueOf(jMd - 1), Long.valueOf(jMd)) : "");
        sb.append(z ? format("Content-Type: %s\n", strMn) : "");
        sb.append("\n");
        return sb.toString();
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final void a(b bVar) {
        this.aPM = bVar;
    }

    @Override // com.kwad.sdk.core.videocache.k
    public final void ee(int i) {
        b bVar = this.aPM;
        if (bVar != null) {
            bVar.a(this.aPL.file, i);
        }
    }

    public final void a(d dVar, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j = dVar.aPI;
        if (a(dVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }

    private boolean a(d dVar) {
        long length = this.aPK.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && dVar.aPJ && ((float) dVar.aPI) > ((float) this.aPL.Md()) + (((float) length) * 0.2f)) ? false : true;
    }

    private void a(OutputStream outputStream, long j) throws ProxyCacheException, IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int iA = a(bArr, j, 1024);
            if (iA == -1) {
                break;
            }
            try {
                outputStream.write(bArr, 0, iA);
                j += (long) iA;
            } catch (Exception unused) {
            }
        }
        outputStream.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b A[Catch: all -> 0x0037, LOOP:0: B:11:0x0024->B:13:0x002b, LOOP_END, TryCatch #0 {all -> 0x0037, blocks: (B:10:0x001d, B:11:0x0024, B:13:0x002b, B:14:0x0030), top: B:20:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0030 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(OutputStream outputStream, long j) {
        p jVar;
        byte[] bArr;
        int i;
        p pVar = this.aPK;
        try {
            if (pVar instanceof h) {
                jVar = new h((h) pVar);
            } else {
                if (pVar instanceof j) {
                    jVar = new j((j) pVar);
                }
                pVar.aK((int) j);
                bArr = new byte[1024];
                while (true) {
                    i = pVar.read(bArr);
                    if (i == -1) {
                        outputStream.write(bArr, 0, i);
                    } else {
                        outputStream.flush();
                        return;
                    }
                }
            }
            pVar.aK((int) j);
            bArr = new byte[1024];
            while (true) {
                i = pVar.read(bArr);
                if (i == -1) {
                }
                outputStream.write(bArr, 0, i);
            }
        } finally {
            pVar.close();
        }
        pVar = jVar;
    }
}
