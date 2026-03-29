package defpackage;

import com.google.protobuf.GeneratedMessageLite;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class lb4 implements gb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class f18953a;

    public lb4(Class cls) {
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Packet type must be a sub-class of Packet.");
        }
        this.f18953a = cls;
    }

    @Override // defpackage.gb4
    public boolean a(GeneratedMessageLite generatedMessageLite, String str) {
        return this.f18953a.isInstance(generatedMessageLite);
    }

    public String toString() {
        return "PacketTypeFilter: " + this.f18953a.getName();
    }
}
