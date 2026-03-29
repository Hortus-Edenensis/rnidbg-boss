package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.wifi.adsdk.download.LxAdDLManager;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends com.heytap.nearx.protobuff.wire.b<i, a> {
    public static final com.heytap.nearx.protobuff.wire.e<i> c = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 1)
    public final String d;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 2)
    public final String e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 3)
    public final String f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 4)
    public final String g;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 5)
    public final String h;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<i, a> {
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;

        public a a(String str) {
            this.c = str;
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

        public i b() {
            String str = this.c;
            if (str == null || this.d == null || this.e == null || this.f == null || this.g == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(str, LxAdDLManager.ITEM_PERURL, this.d, "privacyUrl", this.e, "versionName", this.f, "developerName", this.g, "appDescUrl");
            }
            return new i(this.c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    public i(String str, String str2, String str3, String str4, String str5, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return a().equals(iVar.a()) && this.d.equals(iVar.d) && this.e.equals(iVar.e) && this.f.equals(iVar.f) && this.g.equals(iVar.g) && this.h.equals(iVar.h);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = (((((((((a().hashCode() * 37) + this.d.hashCode()) * 37) + this.e.hashCode()) * 37) + this.f.hashCode()) * 37) + this.g.hashCode()) * 37) + this.h.hashCode();
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", permissionUrl=");
        sb.append(this.d);
        sb.append(", privacyUrl=");
        sb.append(this.e);
        sb.append(", versionName=");
        sb.append(this.f);
        sb.append(", developerName=");
        sb.append(this.g);
        sb.append(", appDescUrl=");
        sb.append(this.h);
        StringBuilder sbReplace = sb.replace(0, 2, "AppPrivacyInfo{");
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
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            return eVar.a(1, iVar.d) + eVar.a(2, iVar.e) + eVar.a(3, iVar.f) + eVar.a(4, iVar.g) + eVar.a(5, iVar.h) + iVar.a().size();
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
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB == 2) {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB == 3) {
                    aVar.c(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB == 4) {
                    aVar.d(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB != 5) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.e(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, i iVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            eVar.a(gVar, 1, iVar.d);
            eVar.a(gVar, 2, iVar.e);
            eVar.a(gVar, 3, iVar.f);
            eVar.a(gVar, 4, iVar.g);
            eVar.a(gVar, 5, iVar.h);
            gVar.a(iVar.a());
        }
    }
}
