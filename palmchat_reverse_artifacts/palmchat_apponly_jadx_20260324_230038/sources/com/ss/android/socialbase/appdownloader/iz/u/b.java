package com.ss.android.socialbase.appdownloader.iz.u;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private int fx;
    private boolean nr;
    private InputStream u;

    public b() {
    }

    public final void fx(int i) throws IOException {
        if (i > 0) {
            long j = i;
            long jSkip = this.u.skip(j);
            this.fx = (int) (((long) this.fx) + jSkip);
            if (jSkip != j) {
                throw new EOFException();
            }
        }
    }

    public final int nr() throws IOException {
        return u(4);
    }

    public final void u(InputStream inputStream, boolean z) {
        this.u = inputStream;
        this.nr = z;
        this.fx = 0;
    }

    public b(InputStream inputStream, boolean z) {
        u(inputStream, z);
    }

    public final int[] nr(int i) throws IOException {
        int[] iArr = new int[i];
        u(iArr, 0, i);
        return iArr;
    }

    public final void fx() throws IOException {
        fx(4);
    }

    public final void u() {
        InputStream inputStream = this.u;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            u(null, false);
        }
    }

    public final int u(int i) throws IOException {
        if (i >= 0 && i <= 4) {
            int i2 = 0;
            if (this.nr) {
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int i4 = this.u.read();
                    if (i4 == -1) {
                        throw new EOFException();
                    }
                    this.fx++;
                    i2 |= i4 << i3;
                }
                return i2;
            }
            int i5 = i * 8;
            int i6 = 0;
            while (i2 != i5) {
                int i7 = this.u.read();
                if (i7 == -1) {
                    throw new EOFException();
                }
                this.fx++;
                i6 |= i7 << i2;
                i2 += 8;
            }
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public final void u(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            iArr[i] = nr();
            i2--;
            i++;
        }
    }
}
