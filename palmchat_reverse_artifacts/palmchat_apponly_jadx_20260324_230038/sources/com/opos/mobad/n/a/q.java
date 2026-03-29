package com.opos.mobad.n.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public enum q implements com.heytap.nearx.protobuff.wire.i {
    HORIZONTAL(0),
    VERTICAL(1);

    public static final com.heytap.nearx.protobuff.wire.e<q> c = com.heytap.nearx.protobuff.wire.e.a(q.class);
    private final int d;

    q(int i) {
        this.d = i;
    }

    public static q fromValue(int i) {
        if (i == 0) {
            return HORIZONTAL;
        }
        if (i != 1) {
            return null;
        }
        return VERTICAL;
    }

    @Override // com.heytap.nearx.protobuff.wire.i
    public int a() {
        return this.d;
    }
}
