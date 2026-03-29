package com.heytap.nearx.protobuff.wire;

import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.b.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class b<M extends b<M, B>, B extends a<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    transient int f6421a = 0;
    protected transient int b = 0;
    private final transient e<M> c;
    private final transient ByteString d;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a<T extends b<T, B>, B extends a<T, B>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Buffer f6422a;
        g b;

        public final a<T, B> a(int i, com.heytap.nearx.protobuff.wire.a aVar, Object obj) {
            if (this.b == null) {
                Buffer buffer = new Buffer();
                this.f6422a = buffer;
                this.b = new g(buffer);
            }
            try {
                aVar.a().a(this.b, i, obj);
                return this;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }

        public final a<T, B> a(ByteString byteString) {
            if (byteString.size() > 0) {
                if (this.b == null) {
                    Buffer buffer = new Buffer();
                    this.f6422a = buffer;
                    this.b = new g(buffer);
                }
                try {
                    this.b.a(byteString);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public final ByteString a() {
            Buffer buffer = this.f6422a;
            return buffer != null ? buffer.clone().readByteString() : ByteString.EMPTY;
        }
    }

    public b(e<M> eVar, ByteString byteString) {
        if (eVar == null) {
            throw new NullPointerException("adapter == null");
        }
        if (byteString == null) {
            throw new NullPointerException("unknownFields == null");
        }
        this.c = eVar;
        this.d = byteString;
    }

    public final ByteString a() {
        ByteString byteString = this.d;
        return byteString != null ? byteString : ByteString.EMPTY;
    }

    public final byte[] b() {
        return this.c.b(this);
    }

    public String toString() {
        return this.c.c(this);
    }

    public final Object writeReplace() throws ObjectStreamException {
        return new c(b(), getClass());
    }
}
