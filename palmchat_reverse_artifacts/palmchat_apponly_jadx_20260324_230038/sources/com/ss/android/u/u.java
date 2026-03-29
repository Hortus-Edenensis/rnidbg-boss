package com.ss.android.u;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u implements nr {
    private final RandomAccessFile u;

    public u(File file) throws FileNotFoundException {
        this.u = new RandomAccessFile(file, t.k);
    }

    @Override // com.ss.android.u.nr
    public void nr() throws IOException {
        this.u.close();
    }

    @Override // com.ss.android.u.nr
    public long u() throws IOException {
        return this.u.length();
    }

    @Override // com.ss.android.u.nr
    public int u(byte[] bArr, int i, int i2) throws IOException {
        return this.u.read(bArr, i, i2);
    }

    @Override // com.ss.android.u.nr
    public void u(long j, long j2) throws IOException {
        this.u.seek(j);
    }
}
