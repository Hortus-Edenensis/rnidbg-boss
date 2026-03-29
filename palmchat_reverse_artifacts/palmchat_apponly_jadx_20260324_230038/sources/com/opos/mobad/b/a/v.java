package com.opos.mobad.b.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public enum v implements com.heytap.nearx.protobuff.wire.i {
    TYPE_16_8(1),
    TYPE_16_9(2);

    public static final com.heytap.nearx.protobuff.wire.e<v> c = com.heytap.nearx.protobuff.wire.e.a(v.class);
    private final int d;

    v(int i) {
        this.d = i;
    }

    public static v fromValue(int i) {
        if (i == 1) {
            return TYPE_16_8;
        }
        if (i != 2) {
            return null;
        }
        return TYPE_16_9;
    }

    @Override // com.heytap.nearx.protobuff.wire.i
    public int a() {
        return this.d;
    }
}
