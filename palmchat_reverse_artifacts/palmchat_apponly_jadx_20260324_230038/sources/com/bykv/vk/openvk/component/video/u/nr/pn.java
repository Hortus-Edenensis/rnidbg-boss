package com.bykv.vk.openvk.component.video.u.nr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class pn {
    private final RandomAccessFile u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends Exception {
        public u(Throwable th) {
            super(th);
        }
    }

    public pn(File file, String str) throws u {
        try {
            this.u = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new u(e);
        }
    }

    public void u(long j) throws u {
        try {
            this.u.seek(j);
        } catch (IOException e) {
            throw new u(e);
        }
    }

    public void u(byte[] bArr, int i, int i2) throws u {
        try {
            this.u.write(bArr, i, i2);
        } catch (IOException e) {
            throw new u(e);
        }
    }

    public void u() {
        com.bykv.vk.openvk.component.video.u.fx.u.u(this.u);
    }
}
