package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class r extends com.heytap.nearx.protobuff.wire.b<r, a> {
    public static final com.heytap.nearx.protobuff.wire.e<r> c = new c();
    public static final b d = b.NO_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.opos.mobad.biz.proto.DownLoadTrackEvent$DownLoadTrackType#ADAPTER", tag = 1)
    public final b e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REPEATED, tag = 2)
    public final List<String> f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<r, a> {
        public b c;
        public List<String> d = com.heytap.nearx.protobuff.wire.a.b.a();

        public a a(b bVar) {
            this.c = bVar;
            return this;
        }

        public r b() {
            return new r(this.c, this.d, super.a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b implements com.heytap.nearx.protobuff.wire.i {
        NO_TYPE(0),
        DOWNLOAD_START(1),
        DOWNLOAD_COMPLETE(2),
        INSTALL_COMPLETE(3);

        public static final com.heytap.nearx.protobuff.wire.e<b> e = com.heytap.nearx.protobuff.wire.e.a(b.class);
        private final int f;

        b(int i) {
            this.f = i;
        }

        public static b fromValue(int i) {
            if (i == 0) {
                return NO_TYPE;
            }
            if (i == 1) {
                return DOWNLOAD_START;
            }
            if (i == 2) {
                return DOWNLOAD_COMPLETE;
            }
            if (i != 3) {
                return null;
            }
            return INSTALL_COMPLETE;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.f;
        }
    }

    public r(b bVar, List<String> list, ByteString byteString) {
        super(c, byteString);
        this.e = bVar;
        this.f = com.heytap.nearx.protobuff.wire.a.b.b("trackUrls", list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return a().equals(rVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.e, rVar.e) && this.f.equals(rVar.f);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        b bVar = this.e;
        int iHashCode2 = ((iHashCode + (bVar != null ? bVar.hashCode() : 0)) * 37) + this.f.hashCode();
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", downLoadTrackType=");
            sb.append(this.e);
        }
        if (!this.f.isEmpty()) {
            sb.append(", trackUrls=");
            sb.append(this.f);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "DownLoadTrackEvent{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends com.heytap.nearx.protobuff.wire.e<r> {
        public c() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, r.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(r rVar) {
            b bVar = rVar.e;
            return (bVar != null ? b.e.a(1, bVar) : 0) + com.heytap.nearx.protobuff.wire.e.p.a().a(2, rVar.f) + rVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public r a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    try {
                        aVar.a(b.e.a(fVar));
                    } catch (e.a e) {
                        aVar.a(iB, com.heytap.nearx.protobuff.wire.a.VARINT, Long.valueOf(e.f6425a));
                    }
                } else if (iB != 2) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.d.add(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, r rVar) throws IOException {
            b bVar = rVar.e;
            if (bVar != null) {
                b.e.a(gVar, 1, bVar);
            }
            com.heytap.nearx.protobuff.wire.e.p.a().a(gVar, 2, rVar.f);
            gVar.a(rVar.a());
        }
    }
}
