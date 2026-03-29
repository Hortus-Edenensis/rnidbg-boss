package defpackage;

import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class f extends dr6 {
    public int b;
    public AesVersion c;
    public String d;
    public AesKeyStrength e;
    public CompressionMethod f;

    public f() {
        a(HeaderSignature.AES_EXTRA_DATA_RECORD);
        this.b = 7;
        this.c = AesVersion.TWO;
        this.d = "AE";
        this.e = AesKeyStrength.KEY_STRENGTH_256;
        this.f = CompressionMethod.DEFLATE;
    }

    public AesKeyStrength b() {
        return this.e;
    }

    public AesVersion c() {
        return this.c;
    }

    public CompressionMethod d() {
        return this.f;
    }

    public void e(AesKeyStrength aesKeyStrength) {
        this.e = aesKeyStrength;
    }

    public void f(AesVersion aesVersion) {
        this.c = aesVersion;
    }

    public void g(CompressionMethod compressionMethod) {
        this.f = compressionMethod;
    }

    public void h(int i) {
        this.b = i;
    }

    public void i(String str) {
        this.d = str;
    }
}
