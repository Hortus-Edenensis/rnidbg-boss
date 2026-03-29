package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.e;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class w extends com.heytap.nearx.protobuff.wire.b<w, a> {
    public static final com.heytap.nearx.protobuff.wire.e<w> c = new b();
    public static final z d = z.UNKNOWN_STATUS;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 1)
    public final String e;

    @WireField(adapter = "com.opos.mobad.strategy.proto.VipStatus#ADAPTER", tag = 2)
    public final z f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<w, a> {
        public String c;
        public z d;

        public a a(z zVar) {
            this.d = zVar;
            return this;
        }

        public w b() {
            String str = this.c;
            if (str != null) {
                return new w(this.c, this.d, super.a());
            }
            throw com.heytap.nearx.protobuff.wire.a.b.a(str, "token");
        }

        public a a(String str) {
            this.c = str;
            return this;
        }
    }

    public w(String str, z zVar, ByteString byteString) {
        super(c, byteString);
        this.e = str;
        this.f = zVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return a().equals(wVar.a()) && this.e.equals(wVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, wVar.f);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((a().hashCode() * 37) + this.e.hashCode()) * 37;
        z zVar = this.f;
        int iHashCode2 = iHashCode + (zVar != null ? zVar.hashCode() : 0);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", token=");
        sb.append(this.e);
        if (this.f != null) {
            sb.append(", vipStatus=");
            sb.append(this.f);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "UserAccountInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<w> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, w.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(w wVar) {
            int iA = com.heytap.nearx.protobuff.wire.e.p.a(1, wVar.e);
            z zVar = wVar.f;
            return iA + (zVar != null ? z.d.a(2, zVar) : 0) + wVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public w a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB != 2) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    try {
                        aVar.a(z.d.a(fVar));
                    } catch (e.a e) {
                        aVar.a(iB, com.heytap.nearx.protobuff.wire.a.VARINT, Long.valueOf(e.f6425a));
                    }
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, w wVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, wVar.e);
            z zVar = wVar.f;
            if (zVar != null) {
                z.d.a(gVar, 2, zVar);
            }
            gVar.a(wVar.a());
        }
    }
}
