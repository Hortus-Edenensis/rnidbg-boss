package com.opos.mobad.b.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public enum ag implements com.heytap.nearx.protobuff.wire.i {
    MODE_ONE(1),
    MODE_TWO(2);

    public static final com.heytap.nearx.protobuff.wire.e<ag> c = com.heytap.nearx.protobuff.wire.e.a(ag.class);
    private final int d;

    ag(int i) {
        this.d = i;
    }

    public static ag fromValue(int i) {
        if (i == 1) {
            return MODE_ONE;
        }
        if (i != 2) {
            return null;
        }
        return MODE_TWO;
    }

    @Override // com.heytap.nearx.protobuff.wire.i
    public int a() {
        return this.d;
    }
}
