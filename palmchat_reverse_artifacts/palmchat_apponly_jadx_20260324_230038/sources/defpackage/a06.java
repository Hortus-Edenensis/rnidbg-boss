package defpackage;

import com.oplus.tbl.exoplayer2.extractor.TrackOutput;
import com.oplus.tbl.exoplayer2.upstream.DataReader;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class a06 {
    public static int a(TrackOutput trackOutput, DataReader dataReader, int i, boolean z) throws IOException {
        return trackOutput.sampleData(dataReader, i, z, 0);
    }

    public static void b(TrackOutput trackOutput, ParsableByteArray parsableByteArray, int i) {
        trackOutput.sampleData(parsableByteArray, i, 0);
    }
}
