package defpackage;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ri1 extends md5 {
    public final si1 o;

    public ri1(List<byte[]> list) {
        super("DvbDecoder");
        gc4 gc4Var = new gc4(list.get(0));
        this.o = new si1(gc4Var.N(), gc4Var.N());
    }

    @Override // defpackage.md5
    public dn5 v(byte[] bArr, int i, boolean z) {
        if (z) {
            this.o.r();
        }
        return new ti1(this.o.b(bArr, i));
    }
}
