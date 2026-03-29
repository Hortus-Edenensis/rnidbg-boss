package com.opos.cmn.func.dl.base.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f7962a;
    private Context b;
    private com.opos.cmn.func.dl.base.e.c c;
    private com.opos.cmn.func.dl.base.a.b d;
    private f e;
    private b f;
    private long g;
    private long h;

    public c(Context context, b bVar, com.opos.cmn.func.dl.base.a.c cVar, com.opos.cmn.func.dl.base.e.c cVar2) {
        this.b = context;
        this.c = cVar2;
        this.f = bVar;
        this.e = cVar.c;
        this.d = cVar.f7967a;
        long j = cVar2.d;
        this.h = j;
        this.g = this.c.b + j;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0095 A[Catch: all -> 0x0108, Exception -> 0x010c, DlException -> 0x0158, IOException -> 0x0186, TryCatch #4 {DlException -> 0x0158, IOException -> 0x0186, Exception -> 0x010c, all -> 0x0108, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0025, B:10:0x003e, B:12:0x0044, B:13:0x0058, B:18:0x0075, B:20:0x0095, B:24:0x00a6, B:25:0x00ad, B:14:0x005c, B:16:0x0062, B:6:0x0021), top: B:71:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ae A[EXC_TOP_SPLITTER, LOOP:0: B:72:0x00ae->B:77:?, LOOP_START, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        InputStream inputStream4;
        long j;
        String str;
        com.opos.cmn.func.dl.base.c.a aVar;
        String str2;
        InputStream inputStreamA;
        int i;
        try {
            try {
                com.opos.cmn.func.dl.base.e.c cVar = this.c;
                j = (cVar.b + cVar.c) - 1;
                str = TextUtils.isEmpty(this.d.f) ? this.d.e : this.d.f;
                aVar = new com.opos.cmn.func.dl.base.c.a(this.d.r);
            } catch (Throwable th) {
                th = th;
            }
        } catch (DlException e) {
            e = e;
            inputStream4 = null;
        } catch (IOException e2) {
            e = e2;
            inputStream3 = null;
        } catch (Exception e3) {
            e = e3;
            inputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        if (this.c.c > 0 && this.d.m) {
            str2 = "bytes=" + this.g + "-" + j;
        } else {
            if (!this.d.m) {
                str2 = null;
                com.opos.cmn.an.f.a.a("BlockReadRunnable", "------http request range = ".concat(String.valueOf(str2)));
                inputStreamA = aVar.a(this.b, str, new com.opos.cmn.func.dl.base.c.b(this.d.q.j));
                if (inputStreamA != null) {
                    throw new DlException(com.opos.cmn.an.h.c.a.d(this.d.f7965a) ? 1001 : 1003, aVar.d());
                }
                do {
                    try {
                        if (this.f7962a) {
                            com.opos.cmn.func.dl.base.i.a.a(inputStreamA);
                            return;
                        }
                        a aVarA = this.f.a();
                        i = inputStreamA.read(aVarA.e);
                        com.opos.cmn.func.dl.base.e.c cVar2 = this.c;
                        aVarA.d = cVar2.b + this.h;
                        aVarA.f7960a = cVar2.f7988a;
                        aVarA.b = this.d.c;
                        aVarA.c = i;
                        this.e.a(aVarA);
                        if (i > 0) {
                            this.h += (long) i;
                        }
                    } catch (DlException e4) {
                        e = e4;
                        inputStream4 = inputStreamA;
                    } catch (IOException e5) {
                        e = e5;
                        inputStream3 = inputStreamA;
                        com.opos.cmn.an.f.a.c("BlockReadRunnable", " download failed1!url:" + this.d.e + ",error msg:" + e.getMessage());
                        this.e.a(new DlException(1003, e));
                        com.opos.cmn.func.dl.base.i.a.a(inputStream3);
                        return;
                    } catch (Exception e6) {
                        e = e6;
                        inputStream2 = inputStreamA;
                        boolean zD = com.opos.cmn.an.h.c.a.d(this.d.f7965a);
                        com.opos.cmn.an.f.a.c("BlockReadRunnable", " download failed3!url:" + this.d.e + ",error msg:" + e.getMessage() + ",hasNet=" + zD);
                        this.e.a(new DlException(!zD ? 1003 : 1000, e));
                        com.opos.cmn.func.dl.base.i.a.a(inputStream2);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = inputStreamA;
                        com.opos.cmn.func.dl.base.i.a.a(inputStream);
                        throw th;
                    }
                } while (i != -1);
                this.e.a(this.c);
                com.opos.cmn.func.dl.base.i.a.a(inputStreamA);
                return;
                com.opos.cmn.an.f.a.c("BlockReadRunnable", " download failed2!url:" + this.d.e + ",error msg:" + e.b());
                this.e.a(e);
                com.opos.cmn.func.dl.base.i.a.a(inputStream4);
            }
            str2 = "bytes=" + this.g + "-";
        }
        aVar.a(HttpHeaders.RANGE, str2);
        com.opos.cmn.an.f.a.a("BlockReadRunnable", "------http request range = ".concat(String.valueOf(str2)));
        inputStreamA = aVar.a(this.b, str, new com.opos.cmn.func.dl.base.c.b(this.d.q.j));
        if (inputStreamA != null) {
        }
        com.opos.cmn.an.f.a.c("BlockReadRunnable", " download failed2!url:" + this.d.e + ",error msg:" + e.b());
        this.e.a(e);
        com.opos.cmn.func.dl.base.i.a.a(inputStream4);
    }
}
