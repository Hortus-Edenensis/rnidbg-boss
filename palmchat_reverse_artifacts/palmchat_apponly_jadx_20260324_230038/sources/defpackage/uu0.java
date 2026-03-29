package defpackage;

import com.google.android.exoplayer2.upstream.b;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface uu0 {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        uu0 createDataSink();
    }

    void a(b bVar) throws IOException;

    void close() throws IOException;

    void write(byte[] bArr, int i, int i2) throws IOException;
}
