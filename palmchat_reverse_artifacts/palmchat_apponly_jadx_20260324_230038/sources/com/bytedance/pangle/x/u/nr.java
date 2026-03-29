package com.bytedance.pangle.x.u;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private int nr;
    private InputStream u;

    public nr(InputStream inputStream) {
        u(inputStream);
    }

    public final void fx() throws IOException {
        long jSkip = this.u.skip(4L);
        this.nr = (int) (((long) this.nr) + jSkip);
        if (jSkip != 4) {
            throw new EOFException();
        }
    }

    public final int nr() throws IOException {
        int i = 0;
        for (int i2 = 0; i2 != 32; i2 += 8) {
            int i3 = this.u.read();
            if (i3 == -1) {
                throw new EOFException();
            }
            this.nr++;
            i |= i3 << i2;
        }
        return i;
    }

    public final void u(InputStream inputStream) {
        this.u = inputStream;
        this.nr = 0;
    }

    public final void u() {
        InputStream inputStream = this.u;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            u((InputStream) null);
        }
    }

    public void nr(int i) throws IOException {
        int iNr = nr();
        if (iNr != i) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i), Integer.valueOf(iNr)));
        }
    }

    public final int[] u(int i) throws IOException {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i > 0) {
            iArr[i2] = nr();
            i--;
            i2++;
        }
        return iArr;
    }
}
