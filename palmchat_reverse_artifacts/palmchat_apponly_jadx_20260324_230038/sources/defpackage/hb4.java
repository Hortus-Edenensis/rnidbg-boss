package defpackage;

import com.google.protobuf.GeneratedMessageLite;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class hb4 implements gb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17919a;

    public hb4(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Packet ID cannot be null.");
        }
        this.f17919a = str;
    }

    @Override // defpackage.gb4
    public boolean a(GeneratedMessageLite generatedMessageLite, String str) {
        return this.f17919a.equals(str);
    }

    public String toString() {
        return "PacketIDFilter by id: " + this.f17919a;
    }
}
