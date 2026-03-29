package com.bytedance.pangle.util.nr.u;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.pangle.util.nr.nr.b;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private long b(RandomAccessFile randomAccessFile, b bVar) throws IOException {
        long length = randomAccessFile.length() - 22;
        long length2 = randomAccessFile.length();
        long length3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        if (length2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            length3 = randomAccessFile.length();
        }
        while (length3 > 0 && length > 0) {
            length--;
            randomAccessFile.seek(length);
            if (bVar.b().u(randomAccessFile) == 101010256) {
                return length;
            }
            length3--;
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private long fx(RandomAccessFile randomAccessFile, b bVar) throws IOException {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j = length - 22;
        randomAccessFile.seek(j);
        return ((long) bVar.b().u(randomAccessFile)) == 101010256 ? j : b(randomAccessFile, bVar);
    }

    private void nr(RandomAccessFile randomAccessFile, b bVar) throws IOException {
        com.bytedance.pangle.util.nr.nr.u uVar = new com.bytedance.pangle.util.nr.nr.u();
        ArrayList arrayList = new ArrayList();
        long jNr = bVar.nr().nr();
        long jU = bVar.nr().u();
        randomAccessFile.seek(jNr);
        for (int i = 0; i < jU; i++) {
            com.bytedance.pangle.util.nr.nr.fx fxVar = new com.bytedance.pangle.util.nr.nr.fx();
            if (bVar.b().u(randomAccessFile) != 33639248) {
                throw new IOException("Expected central directory entry not found (#" + (i + 1) + ")");
            }
            randomAccessFile.skipBytes(6);
            fxVar.u(bVar.b().nr(randomAccessFile));
            randomAccessFile.skipBytes(4);
            fxVar.u(bVar.b().u(randomAccessFile));
            fxVar.nr(bVar.b().u(randomAccessFile));
            fxVar.fx(bVar.b().u(randomAccessFile));
            int iNr = bVar.b().nr(randomAccessFile);
            fxVar.fx(iNr);
            fxVar.b(bVar.b().nr(randomAccessFile));
            int iNr2 = bVar.b().nr(randomAccessFile);
            randomAccessFile.skipBytes(8);
            fxVar.b(bVar.b().u(randomAccessFile));
            if (iNr <= 0) {
                throw new IOException("Invalid entry name in file header");
            }
            byte[] bArr = new byte[iNr];
            randomAccessFile.readFully(bArr);
            fxVar.u(u(bArr));
            randomAccessFile.skipBytes(fxVar.t());
            if (iNr2 > 0) {
                randomAccessFile.skipBytes(iNr2);
            }
            long filePointer = randomAccessFile.getFilePointer();
            randomAccessFile.seek(fxVar.mv() + 28);
            fxVar.nr(bVar.b().nr(randomAccessFile));
            randomAccessFile.seek(filePointer);
            arrayList.add(fxVar);
        }
        uVar.u(arrayList);
        bVar.u(uVar);
    }

    public b u(String str) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, t.k);
            try {
                if (randomAccessFile2.length() < 22) {
                    throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
                }
                b bVar = new b(str);
                u(randomAccessFile2, bVar);
                if (bVar.nr().u() == 0) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused) {
                    }
                    return bVar;
                }
                nr(randomAccessFile2, bVar);
                try {
                    randomAccessFile2.close();
                } catch (IOException unused2) {
                }
                return bVar;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void u(RandomAccessFile randomAccessFile, b bVar) throws IOException {
        randomAccessFile.seek(fx(randomAccessFile, bVar) + 4);
        com.bytedance.pangle.util.nr.nr.nr nrVar = new com.bytedance.pangle.util.nr.nr.nr();
        randomAccessFile.skipBytes(6);
        nrVar.u(bVar.b().nr(randomAccessFile));
        randomAccessFile.skipBytes(4);
        nrVar.u(bVar.b().u(randomAccessFile));
        bVar.u(nrVar);
    }

    private String u(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }
}
