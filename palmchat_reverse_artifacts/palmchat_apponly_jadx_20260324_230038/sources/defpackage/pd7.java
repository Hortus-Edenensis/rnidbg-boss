package defpackage;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class pd7 implements j8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20000a;
    public final String b;
    public nl2 c;

    public pd7(Context context, String str) {
        Log.d("AGC_FixedDecrypt", "init");
        this.f20000a = context;
        this.b = str;
    }

    @Override // defpackage.j8
    public String a(String str, String str2) {
        if (this.c == null) {
            this.c = b();
        }
        return this.c.a(ig7.b(this.f20000a, this.b, "agc_", str), str2);
    }

    public nl2 b() {
        return new yb7(new c87(ig7.b(this.f20000a, this.b, "agc_", "/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138"), ig7.b(this.f20000a, this.b, "agc_", "/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C"), ig7.b(this.f20000a, this.b, "agc_", "/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B"), ig7.b(this.f20000a, this.b, "agc_", "/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD"), "PBKDF2WithHmacSHA1", 5000));
    }
}
