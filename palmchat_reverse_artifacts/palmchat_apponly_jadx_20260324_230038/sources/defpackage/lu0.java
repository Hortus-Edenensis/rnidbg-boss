package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class lu0 extends x50 {
    public byte[] j;
    public volatile boolean k;

    public lu0(a aVar, b bVar, int i, m mVar, int i2, @Nullable Object obj, @Nullable byte[] bArr) {
        lu0 lu0Var;
        byte[] bArr2;
        super(aVar, bVar, i, mVar, i2, obj, -9223372036854775807L, -9223372036854775807L);
        if (bArr == null) {
            bArr2 = g86.f;
            lu0Var = this;
        } else {
            lu0Var = this;
            bArr2 = bArr;
        }
        lu0Var.j = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void cancelLoad() {
        this.k = true;
    }

    public abstract void e(byte[] bArr, int i) throws IOException;

    public byte[] f() {
        return this.j;
    }

    public final void g(int i) {
        byte[] bArr = this.j;
        if (bArr.length < i + 16384) {
            this.j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void load() throws IOException {
        try {
            this.i.a(this.b);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.k) {
                g(i2);
                i = this.i.read(this.j, i2, 16384);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.k) {
                e(this.j, i2);
            }
        } finally {
            cv0.a(this.i);
        }
    }
}
