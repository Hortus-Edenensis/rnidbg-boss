package com.bytedance.pangle.util.nr.u;

import com.bytedance.pangle.util.nr.nr.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public void u(b bVar, RandomAccessFile randomAccessFile) throws Throwable {
        if (bVar == null || randomAccessFile == null) {
            throw new IOException("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                long filePointer = randomAccessFile.getFilePointer();
                u(bVar, byteArrayOutputStream2);
                u(bVar, byteArrayOutputStream2.size(), (int) filePointer, byteArrayOutputStream2);
                randomAccessFile.write(byteArrayOutputStream2.toByteArray());
                byteArrayOutputStream2.close();
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void u(b bVar, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        if (bVar.u() == null || bVar.u().u() == null || bVar.u().u().size() <= 0) {
            return;
        }
        Iterator<com.bytedance.pangle.util.nr.nr.fx> it = bVar.u().u().iterator();
        while (it.hasNext()) {
            u(it.next(), byteArrayOutputStream, bVar.b());
        }
    }

    private void u(com.bytedance.pangle.util.nr.nr.fx fxVar, ByteArrayOutputStream byteArrayOutputStream, fx fxVar2) throws IOException {
        if (fxVar != null) {
            byte[] bArr = {0, 0};
            fxVar2.u((OutputStream) byteArrayOutputStream, 33639248);
            fxVar2.u(byteArrayOutputStream, 0);
            fxVar2.u(byteArrayOutputStream, 0);
            fxVar2.u(byteArrayOutputStream, 0);
            fxVar2.u(byteArrayOutputStream, fxVar.u());
            fxVar2.u(byteArrayOutputStream, 2081);
            fxVar2.u(byteArrayOutputStream, 545);
            fxVar2.u((OutputStream) byteArrayOutputStream, (int) fxVar.x());
            fxVar2.u((OutputStream) byteArrayOutputStream, (int) fxVar.n());
            fxVar2.u((OutputStream) byteArrayOutputStream, (int) fxVar.a());
            byte[] bArrU = new byte[0];
            if (fxVar.l() != null && fxVar.l().trim().length() > 0) {
                bArrU = u(fxVar.l());
            }
            fxVar2.u(byteArrayOutputStream, bArrU.length);
            int iT = fxVar.t();
            fxVar2.u(byteArrayOutputStream, iT);
            fxVar2.u(byteArrayOutputStream, 0);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            fxVar2.u((OutputStream) byteArrayOutputStream, (int) fxVar.mv());
            if (bArrU.length > 0) {
                byteArrayOutputStream.write(bArrU);
            }
            if (iT > 0) {
                byteArrayOutputStream.write(new byte[iT]);
                return;
            }
            return;
        }
        throw new IOException("input parameters is null, cannot write local file header");
    }

    private void u(b bVar, int i, int i2, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        bVar.b().u((OutputStream) byteArrayOutputStream, 101010256);
        bVar.b().u(byteArrayOutputStream, 0);
        bVar.b().u(byteArrayOutputStream, 0);
        int size = bVar.u().u().size();
        bVar.b().u(byteArrayOutputStream, size);
        bVar.b().u(byteArrayOutputStream, size);
        bVar.b().u((OutputStream) byteArrayOutputStream, i);
        bVar.b().u((OutputStream) byteArrayOutputStream, i2);
        bVar.b().u(byteArrayOutputStream, 0);
    }

    private byte[] u(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }
}
