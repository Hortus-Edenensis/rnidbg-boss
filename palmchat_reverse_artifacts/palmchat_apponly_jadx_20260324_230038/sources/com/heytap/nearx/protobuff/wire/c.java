package com.heytap.nearx.protobuff.wire;

import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.b.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
final class c<M extends b<M, B>, B extends b.a<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f6423a;
    private final Class<M> b;

    public c(byte[] bArr, Class<M> cls) {
        this.f6423a = bArr;
        this.b = cls;
    }

    public Object readResolve() throws ObjectStreamException {
        try {
            return e.b((Class) this.b).a(this.f6423a);
        } catch (IOException e) {
            throw new StreamCorruptedException(e.getMessage());
        }
    }
}
