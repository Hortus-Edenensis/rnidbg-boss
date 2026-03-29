package com.umeng.analytics.pro;

import com.umeng.analytics.pro.da;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dg f10907a;
    private final dt b;

    public ck() {
        this(new da.a());
    }

    private db j(byte[] bArr, co coVar, co... coVarArr) throws cn {
        this.b.a(bArr);
        int length = coVarArr.length + 1;
        co[] coVarArr2 = new co[length];
        int i = 0;
        coVarArr2[0] = coVar;
        int i2 = 0;
        while (i2 < coVarArr.length) {
            int i3 = i2 + 1;
            coVarArr2[i3] = coVarArr[i2];
            i2 = i3;
        }
        this.f10907a.j();
        db dbVarL = null;
        while (i < length) {
            dbVarL = this.f10907a.l();
            if (dbVarL.b == 0 || dbVarL.c > coVarArr2[i].a()) {
                return null;
            }
            if (dbVarL.c != coVarArr2[i].a()) {
                dj.a(this.f10907a, dbVarL.b);
                this.f10907a.m();
            } else {
                i++;
                if (i < length) {
                    this.f10907a.j();
                }
            }
        }
        return dbVarL;
    }

    public void a(ch chVar, byte[] bArr) throws cn {
        try {
            this.b.a(bArr);
            chVar.read(this.f10907a);
        } finally {
            this.b.e();
            this.f10907a.B();
        }
    }

    public Byte b(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (Byte) a((byte) 3, bArr, coVar, coVarArr);
    }

    public Double c(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (Double) a((byte) 4, bArr, coVar, coVarArr);
    }

    public Short d(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (Short) a((byte) 6, bArr, coVar, coVarArr);
    }

    public Integer e(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (Integer) a((byte) 8, bArr, coVar, coVarArr);
    }

    public Long f(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (Long) a((byte) 10, bArr, coVar, coVarArr);
    }

    public String g(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (String) a((byte) 11, bArr, coVar, coVarArr);
    }

    public ByteBuffer h(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (ByteBuffer) a((byte) 100, bArr, coVar, coVarArr);
    }

    public Short i(byte[] bArr, co coVar, co... coVarArr) throws cn {
        try {
            try {
                if (j(bArr, coVar, coVarArr) != null) {
                    this.f10907a.j();
                    return Short.valueOf(this.f10907a.l().c);
                }
                this.b.e();
                this.f10907a.B();
                return null;
            } catch (Exception e) {
                throw new cn(e);
            }
        } finally {
            this.b.e();
            this.f10907a.B();
        }
        this.b.e();
        this.f10907a.B();
    }

    public ck(di diVar) {
        dt dtVar = new dt();
        this.b = dtVar;
        this.f10907a = diVar.a(dtVar);
    }

    public void a(ch chVar, String str, String str2) throws cn {
        try {
            try {
                a(chVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new cn("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f10907a.B();
        }
    }

    public void a(ch chVar, byte[] bArr, co coVar, co... coVarArr) throws cn {
        try {
            try {
                if (j(bArr, coVar, coVarArr) != null) {
                    chVar.read(this.f10907a);
                }
            } catch (Exception e) {
                throw new cn(e);
            }
        } finally {
            this.b.e();
            this.f10907a.B();
        }
    }

    public Boolean a(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (Boolean) a((byte) 2, bArr, coVar, coVarArr);
    }

    private Object a(byte b, byte[] bArr, co coVar, co... coVarArr) throws cn {
        try {
            try {
                db dbVarJ = j(bArr, coVar, coVarArr);
                if (dbVarJ != null) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4) {
                                if (b != 6) {
                                    if (b != 8) {
                                        if (b != 100) {
                                            if (b != 10) {
                                                if (b == 11 && dbVarJ.b == 11) {
                                                    return this.f10907a.z();
                                                }
                                            } else if (dbVarJ.b == 10) {
                                                return Long.valueOf(this.f10907a.x());
                                            }
                                        } else if (dbVarJ.b == 11) {
                                            return this.f10907a.A();
                                        }
                                    } else if (dbVarJ.b == 8) {
                                        return Integer.valueOf(this.f10907a.w());
                                    }
                                } else if (dbVarJ.b == 6) {
                                    return Short.valueOf(this.f10907a.v());
                                }
                            } else if (dbVarJ.b == 4) {
                                return Double.valueOf(this.f10907a.y());
                            }
                        } else if (dbVarJ.b == 3) {
                            return Byte.valueOf(this.f10907a.u());
                        }
                    } else if (dbVarJ.b == 2) {
                        return Boolean.valueOf(this.f10907a.t());
                    }
                }
                this.b.e();
                this.f10907a.B();
                return null;
            } catch (Exception e) {
                throw new cn(e);
            }
        } finally {
            this.b.e();
            this.f10907a.B();
        }
    }

    public void a(ch chVar, String str) throws cn {
        a(chVar, str.getBytes());
    }
}
