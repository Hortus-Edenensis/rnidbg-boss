package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class f8 implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f17476a;
    public final byte[] b;
    public final byte[] c;

    @Nullable
    public CipherInputStream d;

    public f8(a aVar, byte[] bArr, byte[] bArr2) {
        this.f17476a = aVar;
        this.b = bArr;
        this.c = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final long a(b bVar) throws IOException {
        try {
            Cipher cipherC = c();
            try {
                cipherC.init(2, new SecretKeySpec(this.b, EncryptUtils.AES_ENCRYPT_ALGORITHM), new IvParameterSpec(this.c));
                bv0 bv0Var = new bv0(this.f17476a, bVar);
                this.d = new CipherInputStream(bv0Var, cipherC);
                bv0Var.d();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final void b(u06 u06Var) {
        vh.e(u06Var);
        this.f17476a.b(u06Var);
    }

    public Cipher c() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        if (this.d != null) {
            this.d = null;
            this.f17476a.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final Map<String, List<String>> getResponseHeaders() {
        return this.f17476a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public final Uri getUri() {
        return this.f17476a.getUri();
    }

    @Override // defpackage.ru0
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        vh.e(this.d);
        int i3 = this.d.read(bArr, i, i2);
        if (i3 < 0) {
            return -1;
        }
        return i3;
    }
}
