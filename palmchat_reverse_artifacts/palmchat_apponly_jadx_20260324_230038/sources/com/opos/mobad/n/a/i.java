package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class i extends com.heytap.nearx.protobuff.wire.b<i, a> {
    public static final com.heytap.nearx.protobuff.wire.e<i> c = new b();
    public static final Boolean d;
    public static final Boolean e;
    public static final Integer f;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 1)
    public final String g;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String h;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 3)
    public final String i;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 4)
    public final String j;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 5)
    public final String k;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 6)
    public final String l;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean m;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean n;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 9)
    public final String o;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 10)
    public final Integer p;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<i, a> {
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public Boolean i;
        public Boolean j;
        public String k;
        public Integer l;

        public a a(Boolean bool) {
            this.i = bool;
            return this;
        }

        public a b(Boolean bool) {
            this.j = bool;
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
            this.k = str;
            return this;
        }

        public a a(Integer num) {
            this.l = num;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public i b() {
            return new i(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, super.a());
        }
    }

    static {
        Boolean bool = Boolean.TRUE;
        d = bool;
        e = bool;
        f = 0;
    }

    public i(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, Integer num, ByteString byteString) {
        super(c, byteString);
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = str5;
        this.l = str6;
        this.m = bool;
        this.n = bool2;
        this.o = str7;
        this.p = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return a().equals(iVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, iVar.g) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, iVar.h) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, iVar.i) && com.heytap.nearx.protobuff.wire.a.b.a(this.j, iVar.j) && com.heytap.nearx.protobuff.wire.a.b.a(this.k, iVar.k) && com.heytap.nearx.protobuff.wire.a.b.a(this.l, iVar.l) && com.heytap.nearx.protobuff.wire.a.b.a(this.m, iVar.m) && com.heytap.nearx.protobuff.wire.a.b.a(this.n, iVar.n) && com.heytap.nearx.protobuff.wire.a.b.a(this.o, iVar.o) && com.heytap.nearx.protobuff.wire.a.b.a(this.p, iVar.p);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.g;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.h;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.i;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.j;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.k;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.l;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Boolean bool = this.m;
        int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.n;
        int iHashCode9 = (iHashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str7 = this.o;
        int iHashCode10 = (iHashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num = this.p;
        int iHashCode11 = iHashCode10 + (num != null ? num.hashCode() : 0);
        this.b = iHashCode11;
        return iHashCode11;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", imei=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", anId=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", mac=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", ouId=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", duId=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", guId=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", ouIdOpenStatus=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", appOuidStatus=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", gaId=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", imeiType=");
            sb.append(this.p);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "DevId{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<i> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, i.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(i iVar) {
            String str = iVar.g;
            int iA = str != null ? com.heytap.nearx.protobuff.wire.e.p.a(1, str) : 0;
            String str2 = iVar.h;
            int iA2 = iA + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str2) : 0);
            String str3 = iVar.i;
            int iA3 = iA2 + (str3 != null ? com.heytap.nearx.protobuff.wire.e.p.a(3, str3) : 0);
            String str4 = iVar.j;
            int iA4 = iA3 + (str4 != null ? com.heytap.nearx.protobuff.wire.e.p.a(4, str4) : 0);
            String str5 = iVar.k;
            int iA5 = iA4 + (str5 != null ? com.heytap.nearx.protobuff.wire.e.p.a(5, str5) : 0);
            String str6 = iVar.l;
            int iA6 = iA5 + (str6 != null ? com.heytap.nearx.protobuff.wire.e.p.a(6, str6) : 0);
            Boolean bool = iVar.m;
            int iA7 = iA6 + (bool != null ? com.heytap.nearx.protobuff.wire.e.c.a(7, bool) : 0);
            Boolean bool2 = iVar.n;
            int iA8 = iA7 + (bool2 != null ? com.heytap.nearx.protobuff.wire.e.c.a(8, bool2) : 0);
            String str7 = iVar.o;
            int iA9 = iA8 + (str7 != null ? com.heytap.nearx.protobuff.wire.e.p.a(9, str7) : 0);
            Integer num = iVar.p;
            return iA9 + (num != null ? com.heytap.nearx.protobuff.wire.e.d.a(10, num) : 0) + iVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 9:
                        aVar.g(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 10:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, i iVar) throws IOException {
            String str = iVar.g;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, str);
            }
            String str2 = iVar.h;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str2);
            }
            String str3 = iVar.i;
            if (str3 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 3, str3);
            }
            String str4 = iVar.j;
            if (str4 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 4, str4);
            }
            String str5 = iVar.k;
            if (str5 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 5, str5);
            }
            String str6 = iVar.l;
            if (str6 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 6, str6);
            }
            Boolean bool = iVar.m;
            if (bool != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 7, bool);
            }
            Boolean bool2 = iVar.n;
            if (bool2 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 8, bool2);
            }
            String str7 = iVar.o;
            if (str7 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 9, str7);
            }
            Integer num = iVar.p;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 10, num);
            }
            gVar.a(iVar.a());
        }
    }
}
