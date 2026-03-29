package com.kwad.sdk.core.diskcache.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static void a(@NonNull final com.kwad.sdk.core.diskcache.a.a aVar, @NonNull final String str, @NonNull final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                OutputStream outputStreamDK = null;
                try {
                    a.C0604a c0604aDR = aVar.dR(str2);
                    if (c0604aDR != null) {
                        outputStreamDK = c0604aDR.dK(0);
                        if (b.a(str, outputStreamDK, new a.C0614a())) {
                            c0604aDR.commit();
                        } else {
                            c0604aDR.abort();
                        }
                        aVar.flush();
                    }
                } catch (IOException unused) {
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamDK);
                }
            }
        });
    }

    public static File a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str) throws Throwable {
        a.c cVarDQ;
        a.c cVar = null;
        try {
            cVarDQ = aVar.dQ(str);
            if (cVarDQ != null) {
                try {
                    File fileDN = cVarDQ.dN(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVarDQ);
                    return fileDN;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    cVar = cVarDQ;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            cVarDQ = null;
        } catch (Throwable th2) {
            th = th2;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cVarDQ);
        return null;
    }

    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2, a.C0614a c0614a) {
        boolean z = false;
        OutputStream outputStreamDK = null;
        try {
            try {
                a.C0604a c0604aDR = aVar.dR(str2);
                if (c0604aDR != null) {
                    outputStreamDK = c0604aDR.dK(0);
                    if (a(str, outputStreamDK, c0614a)) {
                        c0604aDR.commit();
                        z = true;
                    } else {
                        c0604aDR.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e) {
                c0614a.msg = e.getMessage();
            }
            return z;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamDK);
        }
    }

    public static boolean a(String str, OutputStream outputStream, a.C0614a c0614a) {
        return com.kwad.sdk.core.network.a.a.a(str, outputStream, c0614a, -1L, true, null);
    }
}
