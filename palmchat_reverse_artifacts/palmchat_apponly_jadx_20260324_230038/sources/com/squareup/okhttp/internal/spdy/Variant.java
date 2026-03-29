package com.squareup.okhttp.internal.spdy;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
interface Variant {
    public static final Variant SPDY3 = new Spdy3();
    public static final Variant HTTP_20_DRAFT_06 = new Http20Draft06();

    FrameReader newReader(InputStream inputStream, boolean z);

    FrameWriter newWriter(OutputStream outputStream, boolean z);
}
