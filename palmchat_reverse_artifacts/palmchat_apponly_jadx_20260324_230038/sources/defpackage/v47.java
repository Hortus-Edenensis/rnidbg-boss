package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class v47 extends n27 {
    public final String d;

    public v47(String str) {
        this.d = str;
    }

    @Override // defpackage.n27
    public void a() throws Exception {
        this.f19426a = (byte) 1;
        byte[] bytes = this.d.getBytes("UTF-8");
        this.c = bytes;
        this.b = (byte) bytes.length;
    }
}
