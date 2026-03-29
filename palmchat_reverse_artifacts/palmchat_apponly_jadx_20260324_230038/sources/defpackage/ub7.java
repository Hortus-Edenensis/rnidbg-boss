package defpackage;

import java.io.DataOutputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ub7 extends DataOutputStream {
    public ub7(OutputStream outputStream) {
        super(outputStream);
    }

    public void c() {
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
