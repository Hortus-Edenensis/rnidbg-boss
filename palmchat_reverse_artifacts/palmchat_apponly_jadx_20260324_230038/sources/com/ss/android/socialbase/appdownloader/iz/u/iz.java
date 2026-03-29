package com.ss.android.socialbase.appdownloader.iz.u;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz {
    private int[] nr;
    private int[] u;

    private iz() {
    }

    public static iz u(b bVar) throws IOException {
        nr.u(bVar, 1835009);
        int iNr = bVar.nr();
        int iNr2 = bVar.nr();
        int iNr3 = bVar.nr();
        bVar.nr();
        int iNr4 = bVar.nr();
        int iNr5 = bVar.nr();
        iz izVar = new iz();
        izVar.u = bVar.nr(iNr2);
        if (iNr3 != 0) {
            bVar.nr(iNr3);
        }
        int i = (iNr5 == 0 ? iNr : iNr5) - iNr4;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        izVar.nr = bVar.nr(i / 4);
        if (iNr5 != 0) {
            int i2 = iNr - iNr5;
            if (i2 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            bVar.nr(i2 / 4);
        }
        return izVar;
    }

    public String u(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.u) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int iU = u(this.nr, i2);
        StringBuilder sb = new StringBuilder(iU);
        while (iU != 0) {
            i2 += 2;
            sb.append((char) u(this.nr, i2));
            iU--;
        }
        return sb.toString();
    }

    private static final int u(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}
