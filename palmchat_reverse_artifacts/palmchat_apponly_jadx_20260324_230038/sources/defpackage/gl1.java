package defpackage;

import com.google.android.exoplayer2.ParserException;
import defpackage.j26;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface gl1 {
    void a(gc4 gc4Var) throws ParserException;

    void b(qs1 qs1Var, j26.d dVar);

    void packetFinished();

    void packetStarted(long j, int i);

    void seek();
}
