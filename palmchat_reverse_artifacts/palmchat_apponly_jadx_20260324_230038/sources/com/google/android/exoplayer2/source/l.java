package com.google.android.exoplayer2.source;

import android.net.Uri;
import defpackage.bk4;
import defpackage.qs1;
import defpackage.ru0;
import defpackage.vk4;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface l {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        l a(bk4 bk4Var);
    }

    void a(ru0 ru0Var, Uri uri, Map<String, List<String>> map, long j, long j2, qs1 qs1Var) throws IOException;

    int b(vk4 vk4Var) throws IOException;

    void disableSeekingOnMp3Streams();

    long getCurrentInputPosition();

    void release();

    void seek(long j, long j2);
}
