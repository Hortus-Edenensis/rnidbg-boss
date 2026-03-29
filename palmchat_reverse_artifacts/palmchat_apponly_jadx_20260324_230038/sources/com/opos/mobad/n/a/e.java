package com.opos.mobad.n.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public enum e implements com.heytap.nearx.protobuff.wire.i {
    UNKNOWN(0),
    UNION(1),
    TT(2),
    GDT(3),
    BD(4),
    MIX(5),
    GG(6),
    FB(7),
    JD(8),
    MTG(9),
    PANGLE(10),
    KS(11),
    TOPON(12);

    public static final com.heytap.nearx.protobuff.wire.e<e> n = com.heytap.nearx.protobuff.wire.e.a(e.class);
    private final int o;

    e(int i) {
        this.o = i;
    }

    public static e fromValue(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return UNION;
            case 2:
                return TT;
            case 3:
                return GDT;
            case 4:
                return BD;
            case 5:
                return MIX;
            case 6:
                return GG;
            case 7:
                return FB;
            case 8:
                return JD;
            case 9:
                return MTG;
            case 10:
                return PANGLE;
            case 11:
                return KS;
            case 12:
                return TOPON;
            default:
                return null;
        }
    }

    @Override // com.heytap.nearx.protobuff.wire.i
    public int a() {
        return this.o;
    }
}
