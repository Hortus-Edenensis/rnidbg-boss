package com.ss.android.socialbase.appdownloader.iz.u;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {
    public static final void u(b bVar, int i) throws IOException {
        int iNr = bVar.nr();
        if (iNr == i) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(iNr) + ".");
    }
}
