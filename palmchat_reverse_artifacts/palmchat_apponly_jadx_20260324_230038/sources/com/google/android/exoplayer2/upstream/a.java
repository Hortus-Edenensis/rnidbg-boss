package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import defpackage.ru0;
import defpackage.u06;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface a extends ru0 {

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0360a {
        a createDataSource();
    }

    long a(b bVar) throws IOException;

    void b(u06 u06Var);

    void close() throws IOException;

    Map<String, List<String>> getResponseHeaders();

    @Nullable
    Uri getUri();
}
