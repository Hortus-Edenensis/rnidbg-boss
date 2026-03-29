package defpackage;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface d25 {
    int c(f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i);

    boolean isReady();

    void maybeThrowError() throws IOException;

    int skipData(long j);
}
