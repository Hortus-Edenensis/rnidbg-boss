package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class qx4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20350a;
    public final byte[] b;
    public sx4[] c;
    public final BarcodeFormat d;
    public Map<ResultMetadataType, Object> e;
    public final long f;
    public String g;

    public qx4(String str, byte[] bArr, sx4[] sx4VarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, sx4VarArr, barcodeFormat, System.currentTimeMillis());
    }

    public void a(sx4[] sx4VarArr) {
        sx4[] sx4VarArr2 = this.c;
        if (sx4VarArr2 == null) {
            this.c = sx4VarArr;
            return;
        }
        if (sx4VarArr == null || sx4VarArr.length <= 0) {
            return;
        }
        sx4[] sx4VarArr3 = new sx4[sx4VarArr2.length + sx4VarArr.length];
        System.arraycopy(sx4VarArr2, 0, sx4VarArr3, 0, sx4VarArr2.length);
        System.arraycopy(sx4VarArr, 0, sx4VarArr3, sx4VarArr2.length, sx4VarArr.length);
        this.c = sx4VarArr3;
    }

    public BarcodeFormat b() {
        return this.d;
    }

    public String c() {
        return this.g;
    }

    public byte[] d() {
        return this.b;
    }

    public Map<ResultMetadataType, Object> e() {
        return this.e;
    }

    public sx4[] f() {
        return this.c;
    }

    public String g() {
        return this.f20350a;
    }

    public void h(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.e;
            if (map2 == null) {
                this.e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void i(ResultMetadataType resultMetadataType, Object obj) {
        if (this.e == null) {
            this.e = new EnumMap(ResultMetadataType.class);
        }
        this.e.put(resultMetadataType, obj);
    }

    public void j(String str) {
        this.g = str;
    }

    public String toString() {
        return this.f20350a;
    }

    public qx4(String str, byte[] bArr, sx4[] sx4VarArr, BarcodeFormat barcodeFormat, long j) {
        this.f20350a = str;
        this.b = bArr;
        this.c = sx4VarArr;
        this.d = barcodeFormat;
        this.e = null;
        this.f = j;
    }
}
