package com.bytedance.pangle.x.u;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private int[] nr;
    private int[] u;

    private iz() {
    }

    public static iz u(nr nrVar) throws IOException {
        nrVar.nr(1835009);
        int iNr = nrVar.nr();
        int iNr2 = nrVar.nr();
        int iNr3 = nrVar.nr();
        nrVar.nr();
        int iNr4 = nrVar.nr();
        int iNr5 = nrVar.nr();
        iz izVar = new iz();
        izVar.u = nrVar.u(iNr2);
        if (iNr3 != 0) {
            nrVar.u(iNr3);
        }
        int i = (iNr5 == 0 ? iNr : iNr5) - iNr4;
        if (i % 4 != 0) {
            throw new IOException();
        }
        izVar.nr = nrVar.u(i / 4);
        if (iNr5 != 0) {
            int i2 = iNr - iNr5;
            if (i2 % 4 != 0) {
                throw new IOException();
            }
            nrVar.u(i2 / 4);
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
