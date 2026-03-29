package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class md5 extends fd5<in5, jn5, SubtitleDecoderException> implements en5 {
    public final String n;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends jn5 {
        public a() {
        }

        @Override // defpackage.mw0
        public void l() {
            md5.this.n(this);
        }
    }

    public md5(String str) {
        super(new in5[2], new jn5[2]);
        this.n = str;
        q(1024);
    }

    @Override // defpackage.fd5
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final in5 c() {
        return new in5();
    }

    @Override // defpackage.fd5
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final jn5 d() {
        return new a();
    }

    @Override // defpackage.fd5
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException e(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    public abstract dn5 v(byte[] bArr, int i, boolean z) throws SubtitleDecoderException;

    @Override // defpackage.fd5
    @Nullable
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException f(in5 in5Var, jn5 jn5Var, boolean z) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) vh.e(in5Var.c);
            jn5Var.m(in5Var.e, v(byteBuffer.array(), byteBuffer.limit(), z), in5Var.i);
            jn5Var.c(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }

    @Override // defpackage.en5
    public void setPositionUs(long j) {
    }
}
