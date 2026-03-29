package defpackage;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.b;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class tu0 extends dq {

    @Nullable
    public b e;

    @Nullable
    public byte[] f;
    public int g;
    public int h;

    public tu0() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws IOException {
        e(bVar);
        this.e = bVar;
        Uri uriNormalizeScheme = bVar.f6011a.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        vh.b("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] strArrZ0 = g86.Z0(uriNormalizeScheme.getSchemeSpecificPart(), ",");
        if (strArrZ0.length != 2) {
            throw ParserException.createForMalformedDataOfUnknownType("Unexpected URI format: " + uriNormalizeScheme, null);
        }
        String str = strArrZ0[1];
        if (strArrZ0[0].contains(";base64")) {
            try {
                this.f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw ParserException.createForMalformedDataOfUnknownType("Error while parsing Base64 encoded string: " + str, e);
            }
        } else {
            this.f = g86.o0(URLDecoder.decode(str, f10.f17407a.name()));
        }
        long j = bVar.g;
        byte[] bArr = this.f;
        if (j > bArr.length) {
            this.f = null;
            throw new DataSourceException(2008);
        }
        int i = (int) j;
        this.g = i;
        int length = bArr.length - i;
        this.h = length;
        long j2 = bVar.h;
        if (j2 != -1) {
            this.h = (int) Math.min(length, j2);
        }
        f(bVar);
        long j3 = bVar.h;
        return j3 != -1 ? j3 : this.h;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        if (this.f != null) {
            this.f = null;
            d();
        }
        this.e = null;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri getUri() {
        b bVar = this.e;
        if (bVar != null) {
            return bVar.f6011a;
        }
        return null;
    }

    @Override // defpackage.ru0
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        System.arraycopy(g86.j(this.f), this.g, bArr, i, iMin);
        this.g += iMin;
        this.h -= iMin;
        c(iMin);
        return iMin;
    }
}
