package com.opos.mobad.n.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public enum z implements com.heytap.nearx.protobuff.wire.i {
    UNKNOWN_STATUS(0),
    VIP(1),
    NORMAL(2);

    public static final com.heytap.nearx.protobuff.wire.e<z> d = com.heytap.nearx.protobuff.wire.e.a(z.class);
    private final int e;

    z(int i) {
        this.e = i;
    }

    public static z fromValue(int i) {
        if (i == 0) {
            return UNKNOWN_STATUS;
        }
        if (i == 1) {
            return VIP;
        }
        if (i != 2) {
            return null;
        }
        return NORMAL;
    }

    @Override // com.heytap.nearx.protobuff.wire.i
    public int a() {
        return this.e;
    }
}
