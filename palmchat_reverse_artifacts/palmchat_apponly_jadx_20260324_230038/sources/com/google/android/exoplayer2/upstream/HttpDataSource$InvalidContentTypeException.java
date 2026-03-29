package com.google.android.exoplayer2.upstream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class HttpDataSource$InvalidContentTypeException extends HttpDataSource$HttpDataSourceException {
    public final String contentType;

    public HttpDataSource$InvalidContentTypeException(String str, b bVar) {
        super("Invalid content type: " + str, bVar, 2003, 1);
        this.contentType = str;
    }
}
