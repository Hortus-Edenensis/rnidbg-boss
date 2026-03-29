package defpackage;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class wb3 implements za4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Mac f21667a;
    public int b;
    public String c;

    public wb3(String str) {
        this.c = str;
        try {
            Mac mac = Mac.getInstance(str);
            this.f21667a = mac;
            this.b = mac.getMacLength();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // defpackage.za4
    public int a() {
        return this.b;
    }

    @Override // defpackage.za4
    public void b(byte[] bArr) {
        try {
            this.f21667a.init(new SecretKeySpec(bArr, this.c));
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // defpackage.za4
    public byte[] c(byte[] bArr) {
        return this.f21667a.doFinal(bArr);
    }

    public byte[] d() {
        return this.f21667a.doFinal();
    }

    public void e(byte[] bArr, int i, int i2) {
        try {
            this.f21667a.update(bArr, i, i2);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }
}
