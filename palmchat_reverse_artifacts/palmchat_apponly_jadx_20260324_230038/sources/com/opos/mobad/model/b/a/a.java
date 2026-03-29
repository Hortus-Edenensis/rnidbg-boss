package com.opos.mobad.model.b.a;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.opos.cmn.biz.a.e;
import com.opos.cmn.func.a.a.d;
import com.opos.mobad.model.b.c;
import com.opos.mobad.model.c.d;
import com.opos.mobad.model.utils.f;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a implements com.opos.mobad.model.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f9064a;
    private c b;

    public a(com.opos.mobad.b bVar, c cVar) {
        this.f9064a = bVar.c();
        this.b = cVar;
    }

    private d b(String str, com.opos.mobad.model.c.c cVar, com.opos.mobad.model.e.d dVar) {
        d bVar;
        String strA;
        d bVar2 = new com.opos.mobad.model.c.b(-1, "unknown error.");
        try {
            String strA2 = a(cVar.l());
            if (TextUtils.isEmpty(strA2)) {
                com.opos.cmn.an.f.a.a("FetchAdEngine", "error null req url");
                return bVar2;
            }
            byte[] bArrA = a(cVar);
            if (dVar != null) {
                dVar.a();
            }
            com.opos.cmn.an.f.a.b("FetchAdEngine", "fetchAdTask() data.length=", Integer.valueOf(bArrA.length));
            HashMap map = new HashMap();
            map.put("Content-Type", "application/x-protobuf");
            map.put(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
            map.put(HttpHeaders.ACCEPT, "application/x-protobuf");
            map.put("Route-Data", e.a(this.f9064a.b()));
            map.put("Sdk-Vc", "" + com.opos.mobad.service.d.d.a().m());
            if (bArrA.length >= 1024) {
                com.opos.cmn.an.f.a.b("FetchAdEngine", "data.length >= 1024 ,need gzip compress.");
                bArrA = com.opos.cmn.b.c.a.a(bArrA);
                map.put("Content-Encoding", Constants.CP_GZIP);
            }
            com.opos.cmn.func.a.a.d dVarA = new d.a().a("POST").b(strA2).a(bArrA).a(map).a();
            com.opos.cmn.an.f.a.a("FetchAdEngine", "fetchAd netRequest=", dVarA);
            com.opos.cmn.func.a.a.e eVarA = null;
            try {
                eVarA = com.opos.cmn.func.a.a.b.a().a(this.f9064a.b(), dVarA);
                if (eVarA != null) {
                    com.opos.cmn.an.f.a.a("FetchAdEngine", "fetchAd netResponse=", eVarA);
                    int i = eVarA.f7934a;
                    if (200 == i) {
                        com.opos.cmn.func.a.a.a aVar = eVarA.f;
                        boolean zEqualsIgnoreCase = (aVar == null || (strA = aVar.a("Content-Encoding")) == null) ? false : Constants.CP_GZIP.equalsIgnoreCase(strA);
                        InputStream inputStream = eVarA.c;
                        if (inputStream != null) {
                            byte[] bArrA2 = com.opos.cmn.an.e.b.a.a(inputStream);
                            com.opos.cmn.an.f.a.b("FetchAdEngine", "needUnCompress=", Boolean.valueOf(zEqualsIgnoreCase));
                            if (zEqualsIgnoreCase) {
                                bArrA2 = com.opos.cmn.b.c.a.b(bArrA2);
                            }
                            if (bArrA2 != null && bArrA2.length > 0) {
                                try {
                                    c cVar2 = this.b;
                                    if (cVar2 != null) {
                                        bVar = cVar2.a(bArrA2);
                                        if (bVar != null) {
                                        }
                                    }
                                } catch (Exception e) {
                                    com.opos.cmn.an.f.a.c("FetchAdEngine", "fetchAdTask() fail", e);
                                    bVar = new com.opos.mobad.model.c.b(10102, "parse ad response exception.");
                                }
                            }
                        }
                    } else {
                        String str2 = eVarA.b;
                        if (str2 == null) {
                            str2 = com.igexin.push.core.b.m;
                        }
                        com.opos.cmn.an.f.a.a("FetchAdEngine", "fetchAdTask() http code=", Integer.valueOf(i), "msg=", str2);
                        bVar = new com.opos.mobad.model.c.b(eVarA.f7934a, str2);
                    }
                    bVar2 = bVar;
                }
            } catch (Throwable th) {
                try {
                    com.opos.cmn.an.f.a.c("FetchAdEngine", "fetchAdTask() fail", th);
                    com.opos.mobad.model.c.b bVar3 = new com.opos.mobad.model.c.b(10101, "execute net request exception.");
                    if (eVarA != null) {
                        try {
                            eVarA.a();
                        } catch (Exception e2) {
                            bVar2 = bVar3;
                            e = e2;
                        }
                    }
                    return bVar3;
                } finally {
                    if (eVarA != null) {
                        eVarA.a();
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        com.opos.cmn.an.f.a.c("FetchAdEngine", "fetchAdTask() fail", e);
        return bVar2;
    }

    @Override // com.opos.mobad.model.b.b
    public com.opos.mobad.model.c.d a(String str, com.opos.mobad.model.c.c cVar, com.opos.mobad.model.e.d dVar) {
        com.opos.mobad.model.c.d bVar;
        com.opos.cmn.an.f.a.b("FetchAdEngine", "fetchAd start=", Long.valueOf(System.currentTimeMillis()));
        com.opos.mobad.model.c.d bVar2 = new com.opos.mobad.model.c.b(-1, "unknown error.");
        if (!com.opos.cmn.an.d.b.a(str) && cVar != null) {
            try {
                if (com.opos.cmn.an.h.c.a.d(this.f9064a.b())) {
                    bVar = b(str, cVar, dVar);
                    try {
                        com.opos.cmn.an.f.a.a("FetchAdEngine", "fetchAd fetchAdResponse=", bVar);
                    } catch (Exception e) {
                        e = e;
                        bVar2 = bVar;
                        com.opos.cmn.an.f.a.c("FetchAdEngine", "fetchAd() fail", e);
                    }
                } else {
                    bVar = new com.opos.mobad.model.c.b(10100, "no net.");
                }
                bVar2 = bVar;
            } catch (Exception e2) {
                e = e2;
            }
        }
        com.opos.cmn.an.f.a.b("FetchAdEngine", "fetchAd end=", Long.valueOf(System.currentTimeMillis()));
        return bVar2;
    }

    private String a(List<String> list) {
        return list == null ? f.a() : f.b();
    }

    private byte[] a(com.opos.mobad.model.c.c cVar) {
        c cVar2;
        com.opos.cmn.an.f.a.b("FetchAdEngine", "prepareReqData parser:", this.b, "request:", cVar);
        com.opos.mobad.b bVar = this.f9064a;
        if (bVar != null && (cVar2 = this.b) != null && cVar != null) {
            try {
                return cVar2.a(bVar, cVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("FetchAdEngine", "prepareReqData() fail", e);
            }
        }
        return null;
    }
}
