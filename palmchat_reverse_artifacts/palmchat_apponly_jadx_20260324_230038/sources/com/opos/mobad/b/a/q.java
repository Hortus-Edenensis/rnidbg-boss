package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.e;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends com.heytap.nearx.protobuff.wire.b<q, a> {
    public static final com.heytap.nearx.protobuff.wire.e<q> c = new d();
    public static final b d = b.CONNECTION_UNKNOWN;
    public static final c e = c.UNKNOWN_OPERATOR;
    public static final Integer f = 0;
    public static final Integer g = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.opos.mobad.biz.proto.DevStatus$ConnectionType#ADAPTER", tag = 1)
    public final b h;

    @WireField(adapter = "com.opos.mobad.biz.proto.DevStatus$OperatorType#ADAPTER", tag = 2)
    public final c i;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer j;

    @WireField(adapter = "com.opos.mobad.biz.proto.DevGps#ADAPTER", tag = 4)
    public final l k;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer l;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<q, a> {
        public b c;
        public c d;
        public Integer e;
        public l f;
        public Integer g;

        public a a(l lVar) {
            this.f = lVar;
            return this;
        }

        public a b(Integer num) {
            this.g = num;
            return this;
        }

        public a a(b bVar) {
            this.c = bVar;
            return this;
        }

        public q b() {
            return new q(this.c, this.d, this.e, this.f, this.g, super.a());
        }

        public a a(c cVar) {
            this.d = cVar;
            return this;
        }

        public a a(Integer num) {
            this.e = num;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b implements com.heytap.nearx.protobuff.wire.i {
        CONNECTION_UNKNOWN(0),
        CELL_2G(2),
        CELL_3G(3),
        CELL_4G(4),
        CELL_5G(5),
        WIFI(100),
        NEW_TYPE(999);

        public static final com.heytap.nearx.protobuff.wire.e<b> h = com.heytap.nearx.protobuff.wire.e.a(b.class);
        private final int i;

        b(int i) {
            this.i = i;
        }

        public static b fromValue(int i) {
            if (i == 0) {
                return CONNECTION_UNKNOWN;
            }
            if (i == 100) {
                return WIFI;
            }
            if (i == 999) {
                return NEW_TYPE;
            }
            if (i == 2) {
                return CELL_2G;
            }
            if (i == 3) {
                return CELL_3G;
            }
            if (i == 4) {
                return CELL_4G;
            }
            if (i != 5) {
                return null;
            }
            return CELL_5G;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c implements com.heytap.nearx.protobuff.wire.i {
        UNKNOWN_OPERATOR(0),
        CHINA_MOBILE(1),
        CHINA_TELECOM(2),
        CHINA_UNICOM(3);

        public static final com.heytap.nearx.protobuff.wire.e<c> e = com.heytap.nearx.protobuff.wire.e.a(c.class);
        private final int f;

        c(int i) {
            this.f = i;
        }

        public static c fromValue(int i) {
            if (i == 0) {
                return UNKNOWN_OPERATOR;
            }
            if (i == 1) {
                return CHINA_MOBILE;
            }
            if (i == 2) {
                return CHINA_TELECOM;
            }
            if (i != 3) {
                return null;
            }
            return CHINA_UNICOM;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.f;
        }
    }

    public q(b bVar, c cVar, Integer num, l lVar, Integer num2, ByteString byteString) {
        super(c, byteString);
        this.h = bVar;
        this.i = cVar;
        this.j = num;
        this.k = lVar;
        this.l = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return a().equals(qVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, qVar.h) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, qVar.i) && com.heytap.nearx.protobuff.wire.a.b.a(this.j, qVar.j) && com.heytap.nearx.protobuff.wire.a.b.a(this.k, qVar.k) && com.heytap.nearx.protobuff.wire.a.b.a(this.l, qVar.l);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        b bVar = this.h;
        int iHashCode2 = (iHashCode + (bVar != null ? bVar.hashCode() : 0)) * 37;
        c cVar = this.i;
        int iHashCode3 = (iHashCode2 + (cVar != null ? cVar.hashCode() : 0)) * 37;
        Integer num = this.j;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        l lVar = this.k;
        int iHashCode5 = (iHashCode4 + (lVar != null ? lVar.hashCode() : 0)) * 37;
        Integer num2 = this.l;
        int iHashCode6 = iHashCode5 + (num2 != null ? num2.hashCode() : 0);
        this.b = iHashCode6;
        return iHashCode6;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.h != null) {
            sb.append(", netType=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", operator=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", ori=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", devGps=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", linkSpeed=");
            sb.append(this.l);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "DevStatus{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends com.heytap.nearx.protobuff.wire.e<q> {
        public d() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, q.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(q qVar) {
            b bVar = qVar.h;
            int iA = bVar != null ? b.h.a(1, bVar) : 0;
            c cVar = qVar.i;
            int iA2 = iA + (cVar != null ? c.e.a(2, cVar) : 0);
            Integer num = qVar.j;
            int iA3 = iA2 + (num != null ? com.heytap.nearx.protobuff.wire.e.d.a(3, num) : 0);
            l lVar = qVar.k;
            int iA4 = iA3 + (lVar != null ? l.c.a(4, lVar) : 0);
            Integer num2 = qVar.l;
            return iA4 + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(5, num2) : 0) + qVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public q a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(b.h.a(fVar));
                } else if (iB == 2) {
                    try {
                        aVar.a(c.e.a(fVar));
                    } catch (e.a e) {
                        aVar.a(iB, com.heytap.nearx.protobuff.wire.a.VARINT, Long.valueOf(e.f6425a));
                    }
                } else if (iB == 3) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                } else if (iB == 4) {
                    aVar.a(l.c.a(fVar));
                } else if (iB != 5) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, q qVar) throws IOException {
            b bVar = qVar.h;
            if (bVar != null) {
                b.h.a(gVar, 1, bVar);
            }
            c cVar = qVar.i;
            if (cVar != null) {
                c.e.a(gVar, 2, cVar);
            }
            Integer num = qVar.j;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 3, num);
            }
            l lVar = qVar.k;
            if (lVar != null) {
                l.c.a(gVar, 4, lVar);
            }
            Integer num2 = qVar.l;
            if (num2 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 5, num2);
            }
            gVar.a(qVar.a());
        }
    }
}
