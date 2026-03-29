package com.opos.cmn.func.dl.base.a.a;

import com.opos.cmn.func.dl.base.exception.DlException;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f7964a;
    Map<Integer, RandomAccessFile> b = new ConcurrentHashMap();
    BlockingQueue<a> c = new ArrayBlockingQueue(200);
    private d d;

    public e(d dVar) {
        this.d = dVar;
    }

    public final int a() {
        return this.c.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090 A[Catch: all -> 0x00c5, Exception -> 0x00c8, DlException -> 0x00cd, IOException -> 0x00d2, InterruptedException -> 0x00d7, TryCatch #4 {DlException -> 0x00cd, IOException -> 0x00d2, InterruptedException -> 0x00d7, Exception -> 0x00c8, all -> 0x00c5, blocks: (B:7:0x0014, B:9:0x001e, B:12:0x0030, B:15:0x003b, B:17:0x0047, B:19:0x004d, B:22:0x0056, B:23:0x006d, B:31:0x0087, B:36:0x0090, B:37:0x00b2, B:38:0x00b9), top: B:74:0x0014 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        f fVar;
        f fVar2;
        a aVarTake;
        Throwable th;
        com.opos.cmn.func.dl.base.a.c cVarA;
        RandomAccessFile randomAccessFile;
        long j;
        boolean z;
        com.opos.cmn.an.f.a.a("BlockWriteRunnbale", "Write thread start!");
        while (!this.f7964a) {
            a aVar = null;
            fVar = null;
            fVar = null;
            f fVar3 = null;
            aVar = null;
            aVar = null;
            aVar = null;
            try {
                try {
                    aVarTake = this.c.take();
                } catch (Throwable th2) {
                    aVarTake = null;
                    th = th2;
                }
            } catch (DlException e) {
                e = e;
                fVar2 = null;
            } catch (IOException e2) {
                e = e2;
                fVar2 = null;
            } catch (InterruptedException unused) {
            } catch (Exception e3) {
                e = e3;
                fVar = null;
            }
            try {
                cVarA = this.d.a(aVarTake.b);
            } catch (DlException e4) {
                e = e4;
                fVar2 = fVar3;
                aVar = aVarTake;
                com.opos.cmn.an.f.a.c("BlockWriteRunnbale", "write block error! ", e);
                a(aVar.b);
                if (fVar2 != null) {
                    fVar2.a(e);
                }
                this.d.f7963a.f.a(aVar);
            } catch (IOException e5) {
                e = e5;
                fVar2 = fVar3;
                aVar = aVarTake;
                com.opos.cmn.an.f.a.c("BlockWriteRunnbale", "write block io error! ", e);
                a(aVar.b);
                if (fVar2 != null) {
                    e = new DlException(1004);
                    fVar2.a(e);
                }
                this.d.f7963a.f.a(aVar);
            } catch (InterruptedException unused2) {
                aVar = aVarTake;
                com.opos.cmn.an.f.a.c("BlockWriteRunnbale", "write block inerrupted! ");
                this.d.f7963a.f.a(aVar);
            } catch (Exception e6) {
                e = e6;
                fVar = fVar3;
                aVar = aVarTake;
                com.opos.cmn.an.f.a.c("BlockWriteRunnbale", "onError error! ", e);
                a(aVar.b);
                if (fVar != null) {
                    fVar.a(new DlException(1000, e));
                }
                this.d.f7963a.f.a(aVar);
            } catch (Throwable th3) {
                th = th3;
                this.d.f7963a.f.a(aVarTake);
                throw th;
            }
            if (cVarA != null && (randomAccessFile = this.b.get(Integer.valueOf(aVarTake.b))) != null && cVarA.b.a() == 3) {
                fVar3 = cVarA.c;
                com.opos.cmn.func.dl.base.a.b bVar = cVarA.f7967a;
                if (!bVar.j.exists()) {
                    throw new DlException(1009);
                }
                boolean z2 = false;
                if (aVarTake.c == -1) {
                    long j2 = bVar.s.get();
                    j = bVar.k;
                    z = j2 < j && j != -1;
                    if (j == -1 && aVarTake.c == -1) {
                        z2 = true;
                    }
                    if (!z || z2) {
                        com.opos.cmn.an.f.a.a("BlockWriteRunnbale", "Write finish by isOverLen :" + z + ",isEndBuffer:" + z2);
                        a(aVarTake.b);
                        fVar3.a();
                    }
                } else if (cVarA.b.a() == 3) {
                    randomAccessFile.seek(aVarTake.d);
                    randomAccessFile.write(aVarTake.e, 0, aVarTake.c);
                    bVar.s.addAndGet(aVarTake.c);
                    fVar3.b(aVarTake);
                    long j22 = bVar.s.get();
                    j = bVar.k;
                    if (j22 < j) {
                        if (j == -1) {
                            z2 = true;
                        }
                        if (!z) {
                            com.opos.cmn.an.f.a.a("BlockWriteRunnbale", "Write finish by isOverLen :" + z + ",isEndBuffer:" + z2);
                            a(aVarTake.b);
                            fVar3.a();
                        }
                    }
                }
            }
            this.d.f7963a.f.a(aVarTake);
        }
    }

    public final void a(int i) {
        try {
            com.opos.cmn.func.dl.base.i.a.a(this.b.remove(Integer.valueOf(i)));
        } catch (Throwable unused) {
        }
    }

    public final void a(a aVar) throws DlException {
        int i = aVar.b;
        if (this.b.get(Integer.valueOf(i)) == null) {
            com.opos.cmn.func.dl.base.a.c cVarA = this.d.a(i);
            if (cVarA == null || cVarA.b.a() != 3) {
                return;
            }
            try {
                File file = cVarA.f7967a.j;
                if (!com.opos.cmn.an.e.b.a.a(file)) {
                    com.opos.cmn.func.dl.base.i.a.a(file);
                }
                this.b.put(Integer.valueOf(i), new RandomAccessFile(file, "rw"));
            } catch (Exception e) {
                boolean zA = com.opos.cmn.func.dl.base.i.a.a(this.d.c);
                com.opos.cmn.an.f.a.d("BlockWriteRunnbale", "create tempFile failed!hasStorage=".concat(String.valueOf(zA)), e);
                throw new DlException(zA ? 1000 : 1008, e);
            }
        }
        try {
            this.c.put(aVar);
        } catch (InterruptedException e2) {
            com.opos.cmn.an.f.a.c("BlockWriteRunnbale", "addBuffer interrupt!", e2);
        }
    }
}
