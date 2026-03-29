package com.bytedance.pangle.util.nr;

import com.bytedance.pangle.util.a;
import com.bytedance.pangle.util.nr.nr.b;
import com.bytedance.pangle.util.nr.nr.fx;
import com.bytedance.pangle.util.x;
import com.kuaishou.weapon.p0.t;
import com.oplus.tblplayer.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private final com.bytedance.pangle.util.nr.u.nr nr = new com.bytedance.pangle.util.nr.u.nr();
    private final b u;

    public u(b bVar) {
        this.u = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0113 A[Catch: all -> 0x0138, TryCatch #3 {all -> 0x0138, blocks: (B:25:0x00c6, B:27:0x0128, B:26:0x0113), top: B:63:0x00c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(boolean z, boolean z2) throws Throwable {
        File file;
        RandomAccessFile randomAccessFile;
        File file2;
        Iterator<fx> it;
        File file3 = new File(this.u.fx().getAbsolutePath() + ".rm_tmp");
        if (file3.exists()) {
            file3.delete();
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file3, "rw");
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.u.fx(), t.k);
                try {
                    List<fx> listU = this.u.u().u();
                    HashSet hashSet = new HashSet();
                    Iterator<fx> it2 = listU.iterator();
                    int iFx = 0;
                    while (it2.hasNext()) {
                        try {
                            fx next = it2.next();
                            if (u(next, z, z2)) {
                                hashSet.add(next.l());
                            } else {
                                long jMv = next.mv();
                                if ("resources.arsc".equals(next.l())) {
                                    long filePointer = randomAccessFile.getFilePointer() + next.b();
                                    long jIz = filePointer % 4096 == 0 ? 0L : 4096 - ((filePointer - ((long) next.iz())) % 4096);
                                    if (jIz != 0) {
                                        int iIz = next.iz();
                                        int i = (int) jIz;
                                        next.nr(i);
                                        it = it2;
                                        file2 = file3;
                                        try {
                                            u(randomAccessFile3, randomAccessFile, jMv, next.pn(), next.l());
                                            this.u.b().u(randomAccessFile, i);
                                            u(randomAccessFile3, randomAccessFile, jMv + next.pn() + 2, next.jk(), next.l());
                                            randomAccessFile.write(new byte[i]);
                                            u(randomAccessFile3, randomAccessFile, jMv + next.pn() + 2 + ((long) next.jk()) + ((long) iIz), next.nr(), next.l());
                                        } catch (Throwable th) {
                                            th = th;
                                            randomAccessFile2 = randomAccessFile3;
                                            file = file2;
                                            if (randomAccessFile2 != null) {
                                            }
                                            if (randomAccessFile != null) {
                                            }
                                            u(file);
                                            throw th;
                                        }
                                    } else {
                                        it = it2;
                                        file2 = file3;
                                        u(randomAccessFile3, randomAccessFile, jMv, next.fx(), next.l());
                                    }
                                    long j = iFx;
                                    next.b(j);
                                    iFx = (int) (j + next.fx());
                                    it2 = it;
                                    file3 = file2;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            file2 = file3;
                        }
                    }
                    File file4 = file3;
                    try {
                        this.u.u().u(hashSet);
                        this.nr.u(this.u, randomAccessFile);
                        file = file4;
                        try {
                            u(this.u.fx(), file);
                            randomAccessFile3.close();
                            randomAccessFile.close();
                            u(file);
                        } catch (Throwable th3) {
                            th = th3;
                            randomAccessFile2 = randomAccessFile3;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            u(file);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        file = file4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    file = file3;
                }
            } catch (Throwable th6) {
                th = th6;
                file = file3;
            }
        } catch (Throwable th7) {
            th = th7;
            file = file3;
            randomAccessFile = null;
        }
    }

    private boolean u(fx fxVar, boolean z, boolean z2) {
        if (z) {
            if (a.iz() && fxVar.l().equals("classes.dex")) {
                return false;
            }
            if (fxVar.l().startsWith("classes") && fxVar.l().endsWith(".dex")) {
                return true;
            }
        }
        return z2 && fxVar.l().startsWith("lib/") && fxVar.l().endsWith(Constants.LIBRARY_SUFFIX);
    }

    public void u(File file) throws ZipException {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    public void u(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) throws IOException {
        x.u(randomAccessFile, randomAccessFile2, j, j + j2, str);
    }

    private void u(File file, File file2) throws ZipException {
        if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }
}
