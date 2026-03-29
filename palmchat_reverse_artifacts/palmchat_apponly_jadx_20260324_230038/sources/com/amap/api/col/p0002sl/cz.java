package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.col.p0002sl.eh;
import com.amap.api.col.p0002sl.id;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.oplus.tblplayer.Constants;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class cz<T, V> extends fy {
    protected T b;
    protected Context e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f2684a = true;
    protected int c = 1;
    protected String d = "";
    private int g = 1;
    protected String f = "";

    public cz(Context context, T t) {
        a(context, t);
    }

    private void a(Context context, T t) {
        this.e = context;
        this.b = t;
        this.c = 1;
        b(ServiceSettings.getInstance().getSoTimeOut());
        a(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    private String i() {
        return this.f;
    }

    private String k() {
        String strB_ = b_();
        if (strB_ == null) {
            return null;
        }
        try {
            int iIndexOf = strB_.indexOf(".com/");
            int iIndexOf2 = strB_.indexOf(Constants.STRING_VALUE_UNSET);
            return iIndexOf2 == -1 ? strB_.substring(iIndexOf + 5) : strB_.substring(iIndexOf + 5, iIndexOf2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private V l() throws AMapException {
        Object obj;
        eh ehVarA;
        eh.c cVarA;
        Object obj2;
        try {
            eh.b bVarG = g();
            boolean zB = eh.a().b(bVarG);
            boolean z = false;
            int i = 0;
            V vB = null;
            boolean z2 = false;
            while (i < this.c) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    try {
                        try {
                            int protocol = ServiceSettings.getInstance().getProtocol();
                            fx.a().a(this.e);
                            ic icVarB = ic.b();
                            if (zB && (cVarA = eh.a().a(bVarG)) != null && (obj2 = cVarA.f2726a) != null) {
                                try {
                                    er.a(this.e, bVarG.f2725a, cVarA.b);
                                    vB = (V) obj2;
                                    z2 = true;
                                } catch (fq e) {
                                    e = e;
                                    vB = (V) obj2;
                                    z2 = true;
                                    er.a(this.e, k(), System.currentTimeMillis() - jCurrentTimeMillis, z);
                                    i++;
                                    if (i >= this.c) {
                                        if (!com.amap.api.maps2d.AMapException.ERROR_CONNECTION.equals(e.getMessage()) && !com.amap.api.maps2d.AMapException.ERROR_SOCKET.equals(e.getMessage()) && !com.amap.api.maps2d.AMapException.ERROR_UNKNOWN.equals(e.a()) && !com.amap.api.maps2d.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                            throw new AMapException(e.a(), 1, e.c());
                                        }
                                        throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());
                                    }
                                    try {
                                        Thread.sleep(this.g * 1000);
                                        if (zB && !z2) {
                                            eh.a().a(bVarG, vB);
                                        }
                                    } catch (InterruptedException unused) {
                                        if (!com.amap.api.maps2d.AMapException.ERROR_CONNECTION.equals(e.getMessage()) && !com.amap.api.maps2d.AMapException.ERROR_SOCKET.equals(e.getMessage()) && !com.amap.api.maps2d.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                            throw new AMapException(e.a(), 1, e.c());
                                        }
                                        throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());
                                    }
                                } catch (AMapException e2) {
                                    e = e2;
                                    vB = (V) obj2;
                                    z2 = true;
                                    er.a(this.e, k(), System.currentTimeMillis() - jCurrentTimeMillis, z);
                                    i++;
                                    if (i >= this.c) {
                                        throw e;
                                    }
                                    if (zB && !z2) {
                                        ehVarA = eh.a();
                                        ehVarA.a(bVarG, vB);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    obj = obj2;
                                    z2 = true;
                                    if (zB) {
                                        eh.a().a(bVarG, obj);
                                    }
                                    throw th;
                                }
                            }
                            if (vB == null) {
                                byte[] bArrA = a(protocol, icVarB, this);
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                vB = b(bArrA);
                                er.a(this.e, k(), jCurrentTimeMillis2 - jCurrentTimeMillis, true);
                            }
                            i = this.c;
                        } catch (Throwable th2) {
                            th = th2;
                            obj = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj = vB;
                        if (zB && !z2) {
                            eh.a().a(bVarG, obj);
                        }
                        throw th;
                    }
                } catch (fq e3) {
                    e = e3;
                } catch (AMapException e4) {
                    e = e4;
                }
                if (!zB || z2) {
                    z = false;
                } else {
                    ehVarA = eh.a();
                    ehVarA.a(bVarG, vB);
                }
            }
            return vB;
        } catch (AMapException e5) {
            throw e5;
        } catch (Throwable th4) {
            th4.printStackTrace();
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    public abstract V a(String str) throws AMapException;

    public abstract String a();

    public final V b() throws AMapException {
        if (this.b == null) {
            return null;
        }
        try {
            return l();
        } catch (AMapException e) {
            er.a(k(), i(), e);
            throw e;
        }
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String c() {
        return "sea";
    }

    @Override // com.amap.api.col.p0002sl.id
    public Map<String, String> d() {
        return null;
    }

    @Override // com.amap.api.col.p0002sl.id
    public Map<String, String> e() {
        return null;
    }

    public eh.b g() {
        return null;
    }

    private V b(byte[] bArr) throws AMapException {
        return a(bArr);
    }

    public V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            di.a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        di.b(str);
        return a(str);
    }

    private byte[] a(int i, ic icVar, fy fyVar) throws fq {
        ie ieVarI;
        a(i == 1 ? id.c.HTTP : id.c.HTTPS);
        if (this.f2684a) {
            ieVarI = hx.c(fyVar);
        } else {
            ieVarI = ic.i(fyVar);
        }
        if (ieVarI == null) {
            return null;
        }
        byte[] bArr = ieVarI.f2902a;
        this.f = ieVarI.d;
        return bArr;
    }
}
