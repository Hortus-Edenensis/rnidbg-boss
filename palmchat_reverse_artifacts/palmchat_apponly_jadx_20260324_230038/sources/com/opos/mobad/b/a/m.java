package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends com.heytap.nearx.protobuff.wire.b<m, a> {
    public static final com.heytap.nearx.protobuff.wire.e<m> c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 1)
    public final String e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 3)
    public final String g;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 4)
    public final String h;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 5)
    public final String i;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 6)
    public final String j;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 7)
    public final String k;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 8)
    public final String l;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 9)
    public final String m;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 10)
    public final String n;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 11)
    public final String o;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 12)
    public final Integer p;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 13)
    public final String q;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 14)
    public final String r;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<m, a> {
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public Integer n;
        public String o;
        public String p;

        public a a(Integer num) {
            this.n = num;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a d(String str) {
            this.f = str;
            return this;
        }

        public a e(String str) {
            this.g = str;
            return this;
        }

        public a f(String str) {
            this.h = str;
            return this;
        }

        public a g(String str) {
            this.i = str;
            return this;
        }

        public a h(String str) {
            this.j = str;
            return this;
        }

        public a i(String str) {
            this.k = str;
            return this;
        }

        public a j(String str) {
            this.l = str;
            return this;
        }

        public a k(String str) {
            this.m = str;
            return this;
        }

        public a l(String str) {
            this.o = str;
            return this;
        }

        public a m(String str) {
            this.p = str;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public m b() {
            return new m(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, super.a());
        }
    }

    public m(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num, String str12, String str13, ByteString byteString) {
        super(c, byteString);
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = str6;
        this.k = str7;
        this.l = str8;
        this.m = str9;
        this.n = str10;
        this.o = str11;
        this.p = num;
        this.q = str12;
        this.r = str13;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return a().equals(mVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.e, mVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, mVar.f) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, mVar.g) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, mVar.h) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, mVar.i) && com.heytap.nearx.protobuff.wire.a.b.a(this.j, mVar.j) && com.heytap.nearx.protobuff.wire.a.b.a(this.k, mVar.k) && com.heytap.nearx.protobuff.wire.a.b.a(this.l, mVar.l) && com.heytap.nearx.protobuff.wire.a.b.a(this.m, mVar.m) && com.heytap.nearx.protobuff.wire.a.b.a(this.n, mVar.n) && com.heytap.nearx.protobuff.wire.a.b.a(this.o, mVar.o) && com.heytap.nearx.protobuff.wire.a.b.a(this.p, mVar.p) && com.heytap.nearx.protobuff.wire.a.b.a(this.q, mVar.q) && com.heytap.nearx.protobuff.wire.a.b.a(this.r, mVar.r);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.e;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.f;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.g;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.h;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.i;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.j;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.k;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.l;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.m;
        int iHashCode10 = (iHashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.n;
        int iHashCode11 = (iHashCode10 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.o;
        int iHashCode12 = (iHashCode11 + (str11 != null ? str11.hashCode() : 0)) * 37;
        Integer num = this.p;
        int iHashCode13 = (iHashCode12 + (num != null ? num.hashCode() : 0)) * 37;
        String str12 = this.q;
        int iHashCode14 = (iHashCode13 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.r;
        int iHashCode15 = iHashCode14 + (str13 != null ? str13.hashCode() : 0);
        this.b = iHashCode15;
        return iHashCode15;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", imei=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", anId=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", mac=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", oaId=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", vaId=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", udId=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", ouId=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", duId=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", guId=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", mkDuId=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", serialId=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", imeiType=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", osId=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", mspTransparent=");
            sb.append(this.r);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "DevId{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<m> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, m.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(m mVar) {
            String str = mVar.e;
            int iA = str != null ? com.heytap.nearx.protobuff.wire.e.p.a(1, str) : 0;
            String str2 = mVar.f;
            int iA2 = iA + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str2) : 0);
            String str3 = mVar.g;
            int iA3 = iA2 + (str3 != null ? com.heytap.nearx.protobuff.wire.e.p.a(3, str3) : 0);
            String str4 = mVar.h;
            int iA4 = iA3 + (str4 != null ? com.heytap.nearx.protobuff.wire.e.p.a(4, str4) : 0);
            String str5 = mVar.i;
            int iA5 = iA4 + (str5 != null ? com.heytap.nearx.protobuff.wire.e.p.a(5, str5) : 0);
            String str6 = mVar.j;
            int iA6 = iA5 + (str6 != null ? com.heytap.nearx.protobuff.wire.e.p.a(6, str6) : 0);
            String str7 = mVar.k;
            int iA7 = iA6 + (str7 != null ? com.heytap.nearx.protobuff.wire.e.p.a(7, str7) : 0);
            String str8 = mVar.l;
            int iA8 = iA7 + (str8 != null ? com.heytap.nearx.protobuff.wire.e.p.a(8, str8) : 0);
            String str9 = mVar.m;
            int iA9 = iA8 + (str9 != null ? com.heytap.nearx.protobuff.wire.e.p.a(9, str9) : 0);
            String str10 = mVar.n;
            int iA10 = iA9 + (str10 != null ? com.heytap.nearx.protobuff.wire.e.p.a(10, str10) : 0);
            String str11 = mVar.o;
            int iA11 = iA10 + (str11 != null ? com.heytap.nearx.protobuff.wire.e.p.a(11, str11) : 0);
            Integer num = mVar.p;
            int iA12 = iA11 + (num != null ? com.heytap.nearx.protobuff.wire.e.d.a(12, num) : 0);
            String str12 = mVar.q;
            int iA13 = iA12 + (str12 != null ? com.heytap.nearx.protobuff.wire.e.p.a(13, str12) : 0);
            String str13 = mVar.r;
            return iA13 + (str13 != null ? com.heytap.nearx.protobuff.wire.e.p.a(14, str13) : 0) + mVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public m a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 2:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.d(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 5:
                        aVar.e(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 6:
                        aVar.f(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.g(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 8:
                        aVar.h(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 9:
                        aVar.i(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 10:
                        aVar.j(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 11:
                        aVar.k(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 12:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.l(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 14:
                        aVar.m(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, m mVar) throws IOException {
            String str = mVar.e;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, str);
            }
            String str2 = mVar.f;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str2);
            }
            String str3 = mVar.g;
            if (str3 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 3, str3);
            }
            String str4 = mVar.h;
            if (str4 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 4, str4);
            }
            String str5 = mVar.i;
            if (str5 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 5, str5);
            }
            String str6 = mVar.j;
            if (str6 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 6, str6);
            }
            String str7 = mVar.k;
            if (str7 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 7, str7);
            }
            String str8 = mVar.l;
            if (str8 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 8, str8);
            }
            String str9 = mVar.m;
            if (str9 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 9, str9);
            }
            String str10 = mVar.n;
            if (str10 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 10, str10);
            }
            String str11 = mVar.o;
            if (str11 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 11, str11);
            }
            Integer num = mVar.p;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 12, num);
            }
            String str12 = mVar.q;
            if (str12 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 13, str12);
            }
            String str13 = mVar.r;
            if (str13 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 14, str13);
            }
            gVar.a(mVar.a());
        }
    }
}
