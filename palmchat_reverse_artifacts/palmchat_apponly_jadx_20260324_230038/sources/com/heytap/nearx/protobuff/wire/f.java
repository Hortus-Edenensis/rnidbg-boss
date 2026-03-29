package com.heytap.nearx.protobuff.wire;

import com.umeng.analytics.pro.dn;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSource f6426a;
    private int d;
    private a h;
    private long b = 0;
    private long c = Long.MAX_VALUE;
    private int e = 2;
    private int f = -1;
    private long g = -1;

    public f(BufferedSource bufferedSource) {
        this.f6426a = bufferedSource;
    }

    private int j() throws IOException {
        int i;
        this.b++;
        byte b = this.f6426a.readByte();
        if (b >= 0) {
            return b;
        }
        int i2 = b & ByteCompanionObject.MAX_VALUE;
        this.b++;
        byte b2 = this.f6426a.readByte();
        if (b2 >= 0) {
            i = b2 << 7;
        } else {
            i2 |= (b2 & ByteCompanionObject.MAX_VALUE) << 7;
            this.b++;
            byte b3 = this.f6426a.readByte();
            if (b3 >= 0) {
                i = b3 << dn.l;
            } else {
                i2 |= (b3 & ByteCompanionObject.MAX_VALUE) << 14;
                this.b++;
                byte b4 = this.f6426a.readByte();
                if (b4 < 0) {
                    int i3 = i2 | ((b4 & ByteCompanionObject.MAX_VALUE) << 21);
                    this.b++;
                    byte b5 = this.f6426a.readByte();
                    int i4 = i3 | (b5 << 28);
                    if (b5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        this.b++;
                        if (this.f6426a.readByte() >= 0) {
                            return i4;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
                i = b4 << 21;
            }
        }
        return i2 | i;
    }

    private long k() throws IOException {
        if (this.e != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.e);
        }
        long j = this.c - this.b;
        this.f6426a.require(j);
        this.e = 6;
        this.b = this.c;
        this.c = this.g;
        this.g = -1L;
        return j;
    }

    public long a() throws IOException {
        if (this.e != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int i = this.d + 1;
        this.d = i;
        if (i > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long j = this.g;
        this.g = -1L;
        this.e = 6;
        return j;
    }

    public int b() throws IOException {
        int i = this.e;
        if (i == 7) {
            this.e = 2;
            return this.f;
        }
        if (i != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
        while (this.b < this.c && !this.f6426a.exhausted()) {
            int iJ = j();
            if (iJ == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = iJ >> 3;
            this.f = i2;
            int i3 = iJ & 7;
            if (i3 == 0) {
                this.h = a.VARINT;
                this.e = 0;
                return i2;
            }
            if (i3 == 1) {
                this.h = a.FIXED64;
                this.e = 1;
                return i2;
            }
            if (i3 == 2) {
                this.h = a.LENGTH_DELIMITED;
                this.e = 2;
                int iJ2 = j();
                if (iJ2 < 0) {
                    throw new ProtocolException("Negative length: " + iJ2);
                }
                if (this.g != -1) {
                    throw new IllegalStateException();
                }
                long j = this.c;
                this.g = j;
                long j2 = this.b + ((long) iJ2);
                this.c = j2;
                if (j2 <= j) {
                    return this.f;
                }
                throw new EOFException();
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    throw new ProtocolException("Unexpected end group");
                }
                if (i3 == 5) {
                    this.h = a.FIXED32;
                    this.e = 5;
                    return i2;
                }
                throw new ProtocolException("Unexpected field encoding: " + i3);
            }
            a(i2);
        }
        return -1;
    }

    public a c() {
        return this.h;
    }

    public ByteString d() throws IOException {
        return this.f6426a.readByteString(k());
    }

    public String e() throws IOException {
        return this.f6426a.readUtf8(k());
    }

    public int f() throws IOException {
        int i = this.e;
        if (i == 0 || i == 2) {
            int iJ = j();
            b(0);
            return iJ;
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
    }

    public long g() throws IOException {
        int i = this.e;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
        }
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            this.b++;
            byte b = this.f6426a.readByte();
            j |= ((long) (b & ByteCompanionObject.MAX_VALUE)) << i2;
            if ((b & ByteCompanionObject.MIN_VALUE) == 0) {
                b(0);
                return j;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public int h() throws IOException {
        int i = this.e;
        if (i != 5 && i != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.e);
        }
        this.f6426a.require(4L);
        this.b += 4;
        int intLe = this.f6426a.readIntLe();
        b(5);
        return intLe;
    }

    public long i() throws IOException {
        int i = this.e;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.e);
        }
        this.f6426a.require(8L);
        this.b += 8;
        long longLe = this.f6426a.readLongLe();
        b(1);
        return longLe;
    }

    private void a(int i) throws IOException {
        while (this.b < this.c && !this.f6426a.exhausted()) {
            int iJ = j();
            if (iJ == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = iJ >> 3;
            int i3 = iJ & 7;
            if (i3 == 0) {
                this.e = 0;
                g();
            } else if (i3 == 1) {
                this.e = 1;
                i();
            } else if (i3 == 2) {
                long j = j();
                this.b += j;
                this.f6426a.skip(j);
            } else if (i3 == 3) {
                a(i2);
            } else if (i3 == 4) {
                if (i2 != i) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else {
                if (i3 != 5) {
                    throw new ProtocolException("Unexpected field encoding: " + i3);
                }
                this.e = 5;
                h();
            }
        }
        throw new EOFException();
    }

    private void b(int i) throws IOException {
        if (this.e != i) {
            long j = this.b;
            long j2 = this.c;
            if (j > j2) {
                throw new IOException("Expected to end at " + this.c + " but was " + this.b);
            }
            if (j != j2) {
                this.e = 7;
                return;
            } else {
                this.c = this.g;
                this.g = -1L;
            }
        }
        this.e = 6;
    }

    public void a(long j) throws IOException {
        if (this.e != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int i = this.d - 1;
        this.d = i;
        if (i < 0 || this.g != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        if (this.b == this.c || i == 0) {
            this.c = j;
            return;
        }
        throw new IOException("Expected to end at " + this.c + " but was " + this.b);
    }
}
