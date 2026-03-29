package com.opos.mobad.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.opos.cmn.func.a.a.d;
import com.opos.mobad.d.a;
import com.opos.mobad.d.a.a;
import com.opos.mobad.p;
import java.io.Closeable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f implements com.opos.mobad.d.a, com.opos.mobad.d.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f8785a;
    private Context b;
    private e c;

    private f() {
    }

    public void b(String str, String str2, int i, int i2, a.InterfaceC0732a interfaceC0732a) {
        if (this.b != null) {
            this.c.b(str, str2, i, i2, interfaceC0732a);
        } else if (interfaceC0732a != null) {
            interfaceC0732a.a(2, null);
        }
    }

    public static f a() {
        f fVar;
        f fVar2 = f8785a;
        if (fVar2 != null) {
            return fVar2;
        }
        synchronized (f.class) {
            fVar = f8785a;
            if (fVar == null) {
                fVar = new f();
                f8785a = fVar;
            }
        }
        return fVar;
    }

    private <T extends a.b> void b(List<T> list, final a.InterfaceC0733a interfaceC0733a, final com.opos.mobad.d.a.b bVar) {
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        final Set setSynchronizedSet = Collections.synchronizedSet(new HashSet());
        if (bVar != null && !p.a(bVar, 6, 70)) {
            if (bVar != null) {
                bVar.b();
            }
            if (interfaceC0733a != null) {
                interfaceC0733a.a();
                return;
            }
            return;
        }
        int i = 0;
        while (i < list.size()) {
            final T t = list.get(i);
            final boolean z = i == list.size() - 1;
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.downloader.f.1
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    a.b bVar2 = t;
                    if (bVar2 != null) {
                        if (setSynchronizedSet.contains(bVar2.f8743a)) {
                            com.opos.cmn.an.f.a.b("fLoader", "url repeat:" + t.f8743a);
                        } else {
                            setSynchronizedSet.add(t.f8743a);
                            a.InterfaceC0733a interfaceC0733a2 = interfaceC0733a;
                            if (interfaceC0733a2 != null) {
                                interfaceC0733a2.a(t.f8743a);
                            }
                            e eVar = f.this.c;
                            a.b bVar3 = t;
                            if (eVar.a(bVar3.f8743a, bVar3.b, bVar3.c)) {
                                a.InterfaceC0733a interfaceC0733a3 = interfaceC0733a;
                                if (interfaceC0733a3 != null) {
                                    interfaceC0733a3.a(t.f8743a, 1);
                                }
                            } else {
                                f fVar = f.this;
                                a.b bVar4 = t;
                                fVar.a(bVar4.f8743a, bVar4.b, bVar4.c, interfaceC0733a);
                            }
                        }
                    }
                    countDownLatch.countDown();
                    if (z) {
                        com.opos.cmn.an.f.a.b("fLoader", "wait for complete");
                        try {
                            try {
                                countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
                            } catch (Exception e) {
                                com.opos.cmn.an.f.a.b("fLoader", "wait time out ", e);
                            }
                            a.InterfaceC0733a interfaceC0733a4 = interfaceC0733a;
                            if (interfaceC0733a4 != null) {
                                interfaceC0733a4.a();
                            }
                        } finally {
                            com.opos.mobad.d.a.b bVar5 = bVar;
                            if (bVar5 != null) {
                                bVar5.b();
                            }
                        }
                    }
                }
            });
            i++;
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("https://") || str.startsWith("http://");
    }

    public void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = new e(applicationContext);
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("fLoader", "close", e);
            }
        }
    }

    @Override // com.opos.mobad.d.a
    public void a(String str, String str2, int i, int i2, a.InterfaceC0732a interfaceC0732a) {
        if (this.b == null) {
            if (interfaceC0732a != null) {
                interfaceC0732a.a(2, null);
            }
        } else if (b(str)) {
            this.c.b(str, str2, i, i2, interfaceC0732a);
        } else {
            this.c.a(str, str2, i, i2, interfaceC0732a);
        }
    }

    @Override // com.opos.mobad.d.a
    public void a(String str, String str2, a.InterfaceC0732a interfaceC0732a) {
        if (this.b == null) {
            if (interfaceC0732a != null) {
                interfaceC0732a.a(2, null);
            }
        } else if (b(str)) {
            this.c.b(str, str2, interfaceC0732a);
        } else {
            this.c.a(str, str2, interfaceC0732a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2, String str3, a.InterfaceC0733a interfaceC0733a) throws Throwable {
        Closeable closeable;
        Closeable closeable2;
        com.opos.cmn.func.a.a.e eVarA;
        BufferedSource bufferedSourceBuffer;
        Buffer buffer;
        Buffer bufferClone;
        String strA;
        try {
            eVarA = com.opos.cmn.func.a.a.b.a().a(this.b, new d.a().b(str).a("GET").a());
            try {
                com.opos.cmn.an.f.a.b("fLoader", "load url:" + str + ", + response:" + eVarA);
            } catch (Exception e) {
                e = e;
                closeable = null;
                closeable2 = null;
                bufferedSourceBuffer = null;
            } catch (Throwable th) {
                th = th;
                closeable = null;
                closeable2 = null;
                bufferedSourceBuffer = null;
            }
        } catch (Exception e2) {
            e = e2;
            closeable = null;
            closeable2 = null;
            eVarA = null;
            bufferedSourceBuffer = null;
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
            closeable2 = null;
            eVarA = null;
            bufferedSourceBuffer = null;
        }
        if (eVarA != null) {
            try {
            } catch (Exception e3) {
                e = e3;
                closeable = null;
                closeable2 = null;
                bufferedSourceBuffer = null;
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                closeable2 = null;
                bufferedSourceBuffer = null;
            }
            if (eVarA.f7934a == 200) {
                long j = eVarA.d;
                com.opos.cmn.func.a.a.a aVar = eVarA.f;
                bufferedSourceBuffer = Okio.buffer((aVar == null || (strA = aVar.a("Content-Encoding")) == null) ? false : Constants.CP_GZIP.equalsIgnoreCase(strA) ? new GzipSource(Okio.source(eVarA.c)) : Okio.source(eVarA.c));
                try {
                } catch (Exception e4) {
                    e = e4;
                    closeable = null;
                    closeable2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    closeable = null;
                    closeable2 = null;
                }
                if (j <= 0 || j > 1638400) {
                    com.opos.cmn.an.f.a.b("fLoader", "load to file");
                    a(str, str2, str3, bufferedSourceBuffer, null, interfaceC0733a);
                    a((Closeable) null);
                    a((Closeable) null);
                    a(bufferedSourceBuffer);
                    eVarA.a();
                    return;
                }
                Buffer buffer2 = new Buffer();
                long j2 = 0;
                do {
                    try {
                        long j3 = bufferedSourceBuffer.read(buffer2, 2048L);
                        if (j3 < 0) {
                            try {
                                com.opos.cmn.an.f.a.b("fLoader", "load to cache");
                                if (TextUtils.isEmpty(str2)) {
                                    bufferClone = null;
                                } else {
                                    bufferClone = buffer2.clone();
                                    try {
                                        if (!bufferClone.md5().hex().equals(str2)) {
                                            com.opos.cmn.an.f.a.b("fLoader", "load but md5 fail");
                                            if (interfaceC0733a != null) {
                                                interfaceC0733a.a(str, 2);
                                            }
                                            a(buffer2);
                                            a(bufferClone);
                                            a(bufferedSourceBuffer);
                                            eVarA.a();
                                            return;
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        closeable = bufferClone;
                                        closeable2 = buffer2;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        closeable = bufferClone;
                                        closeable2 = buffer2;
                                        a(closeable2);
                                        a(closeable);
                                        a(bufferedSourceBuffer);
                                        if (eVarA != null) {
                                        }
                                        throw th;
                                    }
                                }
                                if (interfaceC0733a != null) {
                                    interfaceC0733a.a(str, 0);
                                }
                                this.c.a(str, buffer2, str3);
                                a(buffer2);
                                a(bufferClone);
                                a(bufferedSourceBuffer);
                                eVarA.a();
                                return;
                            } catch (Exception e6) {
                                e = e6;
                                closeable2 = buffer2;
                                closeable = null;
                            } catch (Throwable th6) {
                                th = th6;
                                closeable2 = buffer2;
                                closeable = null;
                                a(closeable2);
                                a(closeable);
                                a(bufferedSourceBuffer);
                                if (eVarA != null) {
                                }
                                throw th;
                            }
                        } else {
                            j2 += j3;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        buffer = buffer2;
                    } catch (Throwable th7) {
                        th = th7;
                        buffer = buffer2;
                    }
                    closeable2 = buffer;
                    closeable = null;
                    try {
                        com.opos.cmn.an.f.a.b("fLoader", TKDownloadReason.KSAD_TK_NET, e);
                        a(closeable2);
                        a(closeable);
                        a(bufferedSourceBuffer);
                        if (eVarA != null) {
                            eVarA.a();
                        }
                        if (interfaceC0733a != null) {
                            interfaceC0733a.a(str, 3);
                            return;
                        }
                        return;
                    } catch (Throwable th8) {
                        th = th8;
                        a(closeable2);
                        a(closeable);
                        a(bufferedSourceBuffer);
                        if (eVarA != null) {
                            eVarA.a();
                        }
                        throw th;
                    }
                } while (j2 <= 1638400);
                com.opos.cmn.an.f.a.b("fLoader", "load to file by size");
                buffer = buffer2;
                try {
                    a(str, str2, str3, bufferedSourceBuffer, buffer, interfaceC0733a);
                    a(buffer);
                    a((Closeable) null);
                    a(bufferedSourceBuffer);
                    eVarA.a();
                    return;
                } catch (Exception e8) {
                    e = e8;
                } catch (Throwable th9) {
                    th = th9;
                    closeable2 = buffer;
                    closeable = null;
                    a(closeable2);
                    a(closeable);
                    a(bufferedSourceBuffer);
                    if (eVarA != null) {
                    }
                    throw th;
                }
            }
        }
        if (interfaceC0733a != null) {
            interfaceC0733a.a(str, 3);
        }
        a((Closeable) null);
        a((Closeable) null);
        a((Closeable) null);
        if (eVarA != null) {
            eVarA.a();
        }
    }

    private void a(String str, String str2, String str3, BufferedSource bufferedSource, Buffer buffer, a.InterfaceC0733a interfaceC0733a) {
        int i;
        int iA = buffer == null ? this.c.a(str, bufferedSource, str2, str3) : this.c.a(str, bufferedSource, buffer, str2, str3);
        if (iA == 0) {
            if (interfaceC0733a == null) {
                return;
            } else {
                i = 0;
            }
        } else if (iA == 1) {
            if (interfaceC0733a == null) {
                return;
            } else {
                i = 2;
            }
        } else if (interfaceC0733a == null) {
            return;
        } else {
            i = 3;
        }
        interfaceC0733a.a(str, i);
    }

    public <T extends a.b> void a(List<T> list, a.InterfaceC0733a interfaceC0733a) {
        a(list, interfaceC0733a, (com.opos.mobad.d.a.b) null);
    }

    public <T extends a.b> void a(List<T> list, a.InterfaceC0733a interfaceC0733a, com.opos.mobad.d.a.b bVar) {
        if (this.b != null && list != null && list.size() > 0) {
            b(list, interfaceC0733a, bVar);
        } else if (interfaceC0733a != null) {
            interfaceC0733a.a();
        }
    }

    public boolean a(String str) {
        return this.c.a(str);
    }
}
