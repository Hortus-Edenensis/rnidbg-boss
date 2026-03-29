package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class y extends com.heytap.nearx.protobuff.wire.b<y, a> {
    public static final com.heytap.nearx.protobuff.wire.e<y> c = new b();
    public static final Integer d = 3000;
    public static final Integer e = 15000;
    public static final Integer f = 30;
    public static final Integer g = 2000;
    public static final Boolean h = Boolean.TRUE;
    public static final Integer i = 30;
    public static final Integer j = 1000;
    public static final Integer k = 0;
    public static final Integer l = 0;
    public static final Integer m = 0;
    public static final Integer n = 0;
    public static final Integer o = 0;
    public static final Integer p = 0;
    public static final Integer q = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 10)
    public final Integer A;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 11)
    public final Integer B;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 12)
    public final Integer C;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 13)
    public final Integer D;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 14)
    public final Integer E;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer r;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer s;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer t;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer u;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean v;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer w;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer x;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 8)
    public final Integer y;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer z;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<y, a> {
        public Integer c;
        public Integer d;
        public Integer e;
        public Integer f;
        public Boolean g;
        public Integer h;
        public Integer i;
        public Integer j;
        public Integer k;
        public Integer l;
        public Integer m;
        public Integer n;
        public Integer o;
        public Integer p;

        public a a(Boolean bool) {
            this.g = bool;
            return this;
        }

        public a b(Integer num) {
            this.d = num;
            return this;
        }

        public a c(Integer num) {
            this.e = num;
            return this;
        }

        public a d(Integer num) {
            this.f = num;
            return this;
        }

        public a e(Integer num) {
            this.h = num;
            return this;
        }

        public a f(Integer num) {
            this.i = num;
            return this;
        }

        public a g(Integer num) {
            this.j = num;
            return this;
        }

        public a h(Integer num) {
            this.k = num;
            return this;
        }

        public a i(Integer num) {
            this.l = num;
            return this;
        }

        public a j(Integer num) {
            this.m = num;
            return this;
        }

        public a k(Integer num) {
            this.n = num;
            return this;
        }

        public a l(Integer num) {
            this.o = num;
            return this;
        }

        public a m(Integer num) {
            this.p = num;
            return this;
        }

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public y b() {
            return new y(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, super.a());
        }
    }

    public y(Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, ByteString byteString) {
        super(c, byteString);
        this.r = num;
        this.s = num2;
        this.t = num3;
        this.u = num4;
        this.v = bool;
        this.w = num5;
        this.x = num6;
        this.y = num7;
        this.z = num8;
        this.A = num9;
        this.B = num10;
        this.C = num11;
        this.D = num12;
        this.E = num13;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return a().equals(yVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.r, yVar.r) && com.heytap.nearx.protobuff.wire.a.b.a(this.s, yVar.s) && com.heytap.nearx.protobuff.wire.a.b.a(this.t, yVar.t) && com.heytap.nearx.protobuff.wire.a.b.a(this.u, yVar.u) && com.heytap.nearx.protobuff.wire.a.b.a(this.v, yVar.v) && com.heytap.nearx.protobuff.wire.a.b.a(this.w, yVar.w) && com.heytap.nearx.protobuff.wire.a.b.a(this.x, yVar.x) && com.heytap.nearx.protobuff.wire.a.b.a(this.y, yVar.y) && com.heytap.nearx.protobuff.wire.a.b.a(this.z, yVar.z) && com.heytap.nearx.protobuff.wire.a.b.a(this.A, yVar.A) && com.heytap.nearx.protobuff.wire.a.b.a(this.B, yVar.B) && com.heytap.nearx.protobuff.wire.a.b.a(this.C, yVar.C) && com.heytap.nearx.protobuff.wire.a.b.a(this.D, yVar.D) && com.heytap.nearx.protobuff.wire.a.b.a(this.E, yVar.E);
    }

    public int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = a().hashCode() * 37;
        Integer num = this.r;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.s;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.t;
        int iHashCode4 = (iHashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.u;
        int iHashCode5 = (iHashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool = this.v;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num5 = this.w;
        int iHashCode7 = (iHashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.x;
        int iHashCode8 = (iHashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.y;
        int iHashCode9 = (iHashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.z;
        int iHashCode10 = (iHashCode9 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.A;
        int iHashCode11 = (iHashCode10 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.B;
        int iHashCode12 = (iHashCode11 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.C;
        int iHashCode13 = (iHashCode12 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.D;
        int iHashCode14 = (iHashCode13 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.E;
        int iHashCode15 = iHashCode14 + (num13 != null ? num13.hashCode() : 0);
        this.b = iHashCode15;
        return iHashCode15;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.r != null) {
            sb.append(", shakeSensorTime=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", shakeSensorDiff=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", tiltAngle=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", tiltTime=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", isBidirectionalTilt=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", forwardAngle=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", forwardTime=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", upSlideDistance=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", fullScreenSlideDistance=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", shakeAndUpSlideSensorTime=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", shakeAndUpSlideSensorDiff=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", shakeAndUpSlideDistance=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", slideLayerDistance=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", rotationAngle=");
            sb.append(this.E);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "InteractionSensor{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<y> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, y.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(y yVar) {
            Integer num = yVar.r;
            int iA = num != null ? com.heytap.nearx.protobuff.wire.e.d.a(1, num) : 0;
            Integer num2 = yVar.s;
            int iA2 = iA + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(2, num2) : 0);
            Integer num3 = yVar.t;
            int iA3 = iA2 + (num3 != null ? com.heytap.nearx.protobuff.wire.e.d.a(3, num3) : 0);
            Integer num4 = yVar.u;
            int iA4 = iA3 + (num4 != null ? com.heytap.nearx.protobuff.wire.e.d.a(4, num4) : 0);
            Boolean bool = yVar.v;
            int iA5 = iA4 + (bool != null ? com.heytap.nearx.protobuff.wire.e.c.a(5, bool) : 0);
            Integer num5 = yVar.w;
            int iA6 = iA5 + (num5 != null ? com.heytap.nearx.protobuff.wire.e.d.a(6, num5) : 0);
            Integer num6 = yVar.x;
            int iA7 = iA6 + (num6 != null ? com.heytap.nearx.protobuff.wire.e.d.a(7, num6) : 0);
            Integer num7 = yVar.y;
            int iA8 = iA7 + (num7 != null ? com.heytap.nearx.protobuff.wire.e.d.a(8, num7) : 0);
            Integer num8 = yVar.z;
            int iA9 = iA8 + (num8 != null ? com.heytap.nearx.protobuff.wire.e.d.a(9, num8) : 0);
            Integer num9 = yVar.A;
            int iA10 = iA9 + (num9 != null ? com.heytap.nearx.protobuff.wire.e.d.a(10, num9) : 0);
            Integer num10 = yVar.B;
            int iA11 = iA10 + (num10 != null ? com.heytap.nearx.protobuff.wire.e.d.a(11, num10) : 0);
            Integer num11 = yVar.C;
            int iA12 = iA11 + (num11 != null ? com.heytap.nearx.protobuff.wire.e.d.a(12, num11) : 0);
            Integer num12 = yVar.D;
            int iA13 = iA12 + (num12 != null ? com.heytap.nearx.protobuff.wire.e.d.a(13, num12) : 0);
            Integer num13 = yVar.E;
            return iA13 + (num13 != null ? com.heytap.nearx.protobuff.wire.e.d.a(14, num13) : 0) + yVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public y a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 3:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 4:
                        aVar.d(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 6:
                        aVar.e(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 7:
                        aVar.f(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 8:
                        aVar.g(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 9:
                        aVar.h(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 10:
                        aVar.i(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 11:
                        aVar.j(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 12:
                        aVar.k(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.l(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 14:
                        aVar.m(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, y yVar) throws IOException {
            Integer num = yVar.r;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, num);
            }
            Integer num2 = yVar.s;
            if (num2 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 2, num2);
            }
            Integer num3 = yVar.t;
            if (num3 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 3, num3);
            }
            Integer num4 = yVar.u;
            if (num4 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 4, num4);
            }
            Boolean bool = yVar.v;
            if (bool != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 5, bool);
            }
            Integer num5 = yVar.w;
            if (num5 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 6, num5);
            }
            Integer num6 = yVar.x;
            if (num6 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 7, num6);
            }
            Integer num7 = yVar.y;
            if (num7 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 8, num7);
            }
            Integer num8 = yVar.z;
            if (num8 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 9, num8);
            }
            Integer num9 = yVar.A;
            if (num9 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 10, num9);
            }
            Integer num10 = yVar.B;
            if (num10 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 11, num10);
            }
            Integer num11 = yVar.C;
            if (num11 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 12, num11);
            }
            Integer num12 = yVar.D;
            if (num12 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 13, num12);
            }
            Integer num13 = yVar.E;
            if (num13 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 14, num13);
            }
            gVar.a(yVar.a());
        }
    }
}
