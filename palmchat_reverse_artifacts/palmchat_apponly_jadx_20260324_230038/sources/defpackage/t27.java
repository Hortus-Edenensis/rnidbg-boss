package defpackage;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class t27 {
    public static /* synthetic */ ZipInputStream a(InputStream inputStream, Charset charset) {
        return new ZipInputStream(inputStream, charset);
    }
}
