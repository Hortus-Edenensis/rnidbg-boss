package com.opos.exoplayer.core.upstream;

import android.net.Uri;
import android.util.Base64;
import java.net.URLDecoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DataSpec f8376a;
    private int b;
    private byte[] c;

    @Override // com.opos.exoplayer.core.upstream.g
    public int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int length = this.c.length - this.b;
        if (length == 0) {
            return -1;
        }
        int iMin = Math.min(i2, length);
        System.arraycopy(this.c, this.b, bArr, i, iMin);
        this.b += iMin;
        return iMin;
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public void b() {
        this.f8376a = null;
        this.c = null;
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public long a(DataSpec dataSpec) throws com.opos.exoplayer.core.m {
        this.f8376a = dataSpec;
        Uri uri = dataSpec.f8366a;
        String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            throw new com.opos.exoplayer.core.m("Unsupported scheme: " + scheme);
        }
        String[] strArrSplit = uri.getSchemeSpecificPart().split(",");
        if (strArrSplit.length > 2) {
            throw new com.opos.exoplayer.core.m("Unexpected URI format: " + uri);
        }
        String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.c = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw new com.opos.exoplayer.core.m("Error while parsing Base64 encoded string: " + str, e);
            }
        } else {
            this.c = URLDecoder.decode(str, "US-ASCII").getBytes();
        }
        return this.c.length;
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public Uri a() {
        DataSpec dataSpec = this.f8376a;
        if (dataSpec != null) {
            return dataSpec.f8366a;
        }
        return null;
    }
}
