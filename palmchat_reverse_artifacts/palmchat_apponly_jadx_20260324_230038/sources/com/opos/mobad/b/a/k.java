package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends com.heytap.nearx.protobuff.wire.b<k, a> {
    public static final com.heytap.nearx.protobuff.wire.e<k> c = new b();
    public static final Integer d = 0;
    public static final Boolean e;
    public static final Boolean f;
    public static final Boolean g;
    public static final Boolean h;
    public static final Boolean i;
    public static final Boolean j;
    public static final Boolean k;
    public static final Boolean l;
    public static final Boolean m;
    public static final Boolean n;
    public static final Boolean o;
    public static final Boolean p;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean A;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 12)
    public final Boolean B;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 13)
    public final Boolean C;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 14)
    public final Boolean D;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 1)
    public final Integer q;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String r;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 3)
    public final Boolean s;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean t;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean u;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean v;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean w;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean x;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean y;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<k, a> {
        public Integer c;
        public String d;
        public Boolean e;
        public Boolean f;
        public Boolean g;
        public Boolean h;
        public Boolean i;
        public Boolean j;
        public Boolean k;
        public Boolean l;
        public Boolean m;
        public Boolean n;
        public Boolean o;
        public Boolean p;

        public a a(Boolean bool) {
            this.e = bool;
            return this;
        }

        public a b(Boolean bool) {
            this.f = bool;
            return this;
        }

        public a c(Boolean bool) {
            this.g = bool;
            return this;
        }

        public a d(Boolean bool) {
            this.h = bool;
            return this;
        }

        public a e(Boolean bool) {
            this.i = bool;
            return this;
        }

        public a f(Boolean bool) {
            this.j = bool;
            return this;
        }

        public a g(Boolean bool) {
            this.k = bool;
            return this;
        }

        public a h(Boolean bool) {
            this.l = bool;
            return this;
        }

        public a i(Boolean bool) {
            this.m = bool;
            return this;
        }

        public a j(Boolean bool) {
            this.n = bool;
            return this;
        }

        public a k(Boolean bool) {
            this.o = bool;
            return this;
        }

        public a l(Boolean bool) {
            this.p = bool;
            return this;
        }

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public k b() {
            Integer num = this.c;
            if (num != null) {
                return new k(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, super.a());
            }
            throw com.heytap.nearx.protobuff.wire.a.b.a(num, "code");
        }

        public a a(String str) {
            this.d = str;
            return this;
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        e = bool;
        f = bool;
        g = bool;
        h = bool;
        i = bool;
        j = bool;
        k = bool;
        l = bool;
        m = bool;
        n = bool;
        o = bool;
        p = bool;
    }

    public k(Integer num, String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, ByteString byteString) {
        super(c, byteString);
        this.q = num;
        this.r = str;
        this.s = bool;
        this.t = bool2;
        this.u = bool3;
        this.v = bool4;
        this.w = bool5;
        this.x = bool6;
        this.y = bool7;
        this.z = bool8;
        this.A = bool9;
        this.B = bool10;
        this.C = bool11;
        this.D = bool12;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return a().equals(kVar.a()) && this.q.equals(kVar.q) && com.heytap.nearx.protobuff.wire.a.b.a(this.r, kVar.r) && com.heytap.nearx.protobuff.wire.a.b.a(this.s, kVar.s) && com.heytap.nearx.protobuff.wire.a.b.a(this.t, kVar.t) && com.heytap.nearx.protobuff.wire.a.b.a(this.u, kVar.u) && com.heytap.nearx.protobuff.wire.a.b.a(this.v, kVar.v) && com.heytap.nearx.protobuff.wire.a.b.a(this.w, kVar.w) && com.heytap.nearx.protobuff.wire.a.b.a(this.x, kVar.x) && com.heytap.nearx.protobuff.wire.a.b.a(this.y, kVar.y) && com.heytap.nearx.protobuff.wire.a.b.a(this.z, kVar.z) && com.heytap.nearx.protobuff.wire.a.b.a(this.A, kVar.A) && com.heytap.nearx.protobuff.wire.a.b.a(this.B, kVar.B) && com.heytap.nearx.protobuff.wire.a.b.a(this.C, kVar.C) && com.heytap.nearx.protobuff.wire.a.b.a(this.D, kVar.D);
    }

    public int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = ((a().hashCode() * 37) + this.q.hashCode()) * 37;
        String str = this.r;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        Boolean bool = this.s;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.t;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.u;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.v;
        int iHashCode6 = (iHashCode5 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.w;
        int iHashCode7 = (iHashCode6 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.x;
        int iHashCode8 = (iHashCode7 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Boolean bool7 = this.y;
        int iHashCode9 = (iHashCode8 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Boolean bool8 = this.z;
        int iHashCode10 = (iHashCode9 + (bool8 != null ? bool8.hashCode() : 0)) * 37;
        Boolean bool9 = this.A;
        int iHashCode11 = (iHashCode10 + (bool9 != null ? bool9.hashCode() : 0)) * 37;
        Boolean bool10 = this.B;
        int iHashCode12 = (iHashCode11 + (bool10 != null ? bool10.hashCode() : 0)) * 37;
        Boolean bool11 = this.C;
        int iHashCode13 = (iHashCode12 + (bool11 != null ? bool11.hashCode() : 0)) * 37;
        Boolean bool12 = this.D;
        int iHashCode14 = iHashCode13 + (bool12 != null ? bool12.hashCode() : 0);
        this.b = iHashCode14;
        return iHashCode14;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=");
        sb.append(this.q);
        if (this.r != null) {
            sb.append(", msg=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", ttAdAllowed=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", gdtAdAllowed=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", cacheAdAllowed=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", ggAdAllowed=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", fbAdAllowed=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", quicEnable=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", jdAdAllowed=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", mtgAdAllowed=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", adsAllowed=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", pangleAdAllowed=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", ksAdAllowed=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", toponAllowed=");
            sb.append(this.D);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "ControlResponse{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<k> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, k.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(k kVar) {
            int iA = com.heytap.nearx.protobuff.wire.e.d.a(1, kVar.q);
            String str = kVar.r;
            int iA2 = iA + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str) : 0);
            Boolean bool = kVar.s;
            int iA3 = iA2 + (bool != null ? com.heytap.nearx.protobuff.wire.e.c.a(3, bool) : 0);
            Boolean bool2 = kVar.t;
            int iA4 = iA3 + (bool2 != null ? com.heytap.nearx.protobuff.wire.e.c.a(4, bool2) : 0);
            Boolean bool3 = kVar.u;
            int iA5 = iA4 + (bool3 != null ? com.heytap.nearx.protobuff.wire.e.c.a(5, bool3) : 0);
            Boolean bool4 = kVar.v;
            int iA6 = iA5 + (bool4 != null ? com.heytap.nearx.protobuff.wire.e.c.a(6, bool4) : 0);
            Boolean bool5 = kVar.w;
            int iA7 = iA6 + (bool5 != null ? com.heytap.nearx.protobuff.wire.e.c.a(7, bool5) : 0);
            Boolean bool6 = kVar.x;
            int iA8 = iA7 + (bool6 != null ? com.heytap.nearx.protobuff.wire.e.c.a(8, bool6) : 0);
            Boolean bool7 = kVar.y;
            int iA9 = iA8 + (bool7 != null ? com.heytap.nearx.protobuff.wire.e.c.a(9, bool7) : 0);
            Boolean bool8 = kVar.z;
            int iA10 = iA9 + (bool8 != null ? com.heytap.nearx.protobuff.wire.e.c.a(10, bool8) : 0);
            Boolean bool9 = kVar.A;
            int iA11 = iA10 + (bool9 != null ? com.heytap.nearx.protobuff.wire.e.c.a(11, bool9) : 0);
            Boolean bool10 = kVar.B;
            int iA12 = iA11 + (bool10 != null ? com.heytap.nearx.protobuff.wire.e.c.a(12, bool10) : 0);
            Boolean bool11 = kVar.C;
            int iA13 = iA12 + (bool11 != null ? com.heytap.nearx.protobuff.wire.e.c.a(13, bool11) : 0);
            Boolean bool12 = kVar.D;
            return iA13 + (bool12 != null ? com.heytap.nearx.protobuff.wire.e.c.a(14, bool12) : 0) + kVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                switch (iB) {
                    case 1:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 2:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 4:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 5:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 6:
                        aVar.d(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 7:
                        aVar.e(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 8:
                        aVar.f(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 9:
                        aVar.g(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 10:
                        aVar.h(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 11:
                        aVar.i(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 12:
                        aVar.j(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 13:
                        aVar.k(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 14:
                        aVar.l(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, k kVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, kVar.q);
            String str = kVar.r;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str);
            }
            Boolean bool = kVar.s;
            if (bool != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 3, bool);
            }
            Boolean bool2 = kVar.t;
            if (bool2 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 4, bool2);
            }
            Boolean bool3 = kVar.u;
            if (bool3 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 5, bool3);
            }
            Boolean bool4 = kVar.v;
            if (bool4 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 6, bool4);
            }
            Boolean bool5 = kVar.w;
            if (bool5 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 7, bool5);
            }
            Boolean bool6 = kVar.x;
            if (bool6 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 8, bool6);
            }
            Boolean bool7 = kVar.y;
            if (bool7 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 9, bool7);
            }
            Boolean bool8 = kVar.z;
            if (bool8 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 10, bool8);
            }
            Boolean bool9 = kVar.A;
            if (bool9 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 11, bool9);
            }
            Boolean bool10 = kVar.B;
            if (bool10 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 12, bool10);
            }
            Boolean bool11 = kVar.C;
            if (bool11 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 13, bool11);
            }
            Boolean bool12 = kVar.D;
            if (bool12 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 14, bool12);
            }
            gVar.a(kVar.a());
        }
    }
}
