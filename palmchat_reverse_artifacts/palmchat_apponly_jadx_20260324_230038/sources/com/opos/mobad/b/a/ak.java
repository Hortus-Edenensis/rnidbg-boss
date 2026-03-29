package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class ak extends com.heytap.nearx.protobuff.wire.b<ak, a> {
    public static final com.heytap.nearx.protobuff.wire.e<ak> c = new b();
    public static final c d = c.NO_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.opos.mobad.biz.proto.VideoTrackEvent$VideoTrackType#ADAPTER", tag = 1)
    public final c e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REPEATED, tag = 2)
    public final List<String> f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<ak, a> {
        public c c;
        public List<String> d = com.heytap.nearx.protobuff.wire.a.b.a();

        public a a(c cVar) {
            this.c = cVar;
            return this;
        }

        public ak b() {
            return new ak(this.c, this.d, super.a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c implements com.heytap.nearx.protobuff.wire.i {
        NO_TYPE(0),
        VIDEO_START(1),
        VIDEO_PROCESS_25_PERCENT(2),
        VIDEO_PROCESS_50_PERCENT(3),
        VIDEO_PROCESS_75_PERCENT(4),
        VIDEO_COMPLETE(5),
        VIDEO_CLICK(6),
        VIDEO_CLOSE(7);

        public static final com.heytap.nearx.protobuff.wire.e<c> i = com.heytap.nearx.protobuff.wire.e.a(c.class);
        private final int j;

        c(int i2) {
            this.j = i2;
        }

        public static c fromValue(int i2) {
            switch (i2) {
                case 0:
                    return NO_TYPE;
                case 1:
                    return VIDEO_START;
                case 2:
                    return VIDEO_PROCESS_25_PERCENT;
                case 3:
                    return VIDEO_PROCESS_50_PERCENT;
                case 4:
                    return VIDEO_PROCESS_75_PERCENT;
                case 5:
                    return VIDEO_COMPLETE;
                case 6:
                    return VIDEO_CLICK;
                case 7:
                    return VIDEO_CLOSE;
                default:
                    return null;
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.j;
        }
    }

    public ak(c cVar, List<String> list, ByteString byteString) {
        super(c, byteString);
        this.e = cVar;
        this.f = com.heytap.nearx.protobuff.wire.a.b.b("trackUrls", list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ak)) {
            return false;
        }
        ak akVar = (ak) obj;
        return a().equals(akVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.e, akVar.e) && this.f.equals(akVar.f);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        c cVar = this.e;
        int iHashCode2 = ((iHashCode + (cVar != null ? cVar.hashCode() : 0)) * 37) + this.f.hashCode();
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", videoTrackType=");
            sb.append(this.e);
        }
        if (!this.f.isEmpty()) {
            sb.append(", trackUrls=");
            sb.append(this.f);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "VideoTrackEvent{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<ak> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, ak.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(ak akVar) {
            c cVar = akVar.e;
            return (cVar != null ? c.i.a(1, cVar) : 0) + com.heytap.nearx.protobuff.wire.e.p.a().a(2, akVar.f) + akVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ak a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        aVar.a(c.i.a(fVar));
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
        public void a(com.heytap.nearx.protobuff.wire.g gVar, ak akVar) throws IOException {
            c cVar = akVar.e;
            if (cVar != null) {
                c.i.a(gVar, 1, cVar);
            }
            com.heytap.nearx.protobuff.wire.e.p.a().a(gVar, 2, akVar.f);
            gVar.a(akVar.a());
        }
    }
}
