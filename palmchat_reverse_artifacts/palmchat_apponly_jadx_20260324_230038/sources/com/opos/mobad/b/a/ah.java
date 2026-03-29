package com.opos.mobad.b.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public enum ah implements com.heytap.nearx.protobuff.wire.i {
    UNKNOWN(0),
    SPLASH(1),
    HOT_SPLASH(2);

    public static final com.heytap.nearx.protobuff.wire.e<ah> d = com.heytap.nearx.protobuff.wire.e.a(ah.class);
    private final int e;

    ah(int i) {
        this.e = i;
    }

    public static ah fromValue(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return SPLASH;
        }
        if (i != 2) {
            return null;
        }
        return HOT_SPLASH;
    }

    @Override // com.heytap.nearx.protobuff.wire.i
    public int a() {
        return this.e;
    }
}
