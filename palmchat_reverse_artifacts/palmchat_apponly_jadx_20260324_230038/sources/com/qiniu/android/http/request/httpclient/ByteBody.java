package com.qiniu.android.http.request.httpclient;

import java.io.IOException;
import java.util.Arrays;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ByteBody extends RequestBody {
    private static final int SEGMENT_SIZE = 16384;
    private final byte[] body;
    private final MediaType mediaType;

    public ByteBody(MediaType mediaType, byte[] bArr) {
        this.mediaType = mediaType;
        this.body = bArr;
    }

    private RequestBody getRequestBodyWithRange(int i, int i2) {
        return RequestBody.create(get$contentType(), Arrays.copyOfRange(this.body, i, i2 + i));
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.body.length;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType */
    public MediaType get$contentType() {
        return this.mediaType;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        int i = 0;
        int iMin = 16384;
        while (true) {
            byte[] bArr = this.body;
            if (i >= bArr.length) {
                return;
            }
            iMin = Math.min(iMin, bArr.length - i);
            getRequestBodyWithRange(i, iMin).writeTo(bufferedSink);
            bufferedSink.flush();
            i += iMin;
        }
    }
}
