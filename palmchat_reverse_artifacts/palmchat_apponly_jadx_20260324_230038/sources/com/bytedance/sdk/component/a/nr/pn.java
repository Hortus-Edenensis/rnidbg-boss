package com.bytedance.sdk.component.a.nr;

import android.text.TextUtils;
import com.bytedance.sdk.component.nr.u.iz;
import com.bytedance.sdk.component.nr.u.jk;
import com.bytedance.sdk.component.nr.u.k;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.o;
import com.bytedance.sdk.component.nr.u.pn;
import com.bytedance.sdk.component.nr.u.s;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends b {
    k u;

    public pn(l lVar) {
        super(lVar);
        this.u = null;
    }

    public void fx(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.u = k.u(jk.u("application/json; charset=utf-8"), str);
    }

    public void u(JSONObject jSONObject) {
        this.u = k.u(jk.u("application/json; charset=utf-8"), jSONObject != null ? jSONObject.toString() : "{}");
    }

    public void u(Map<String, String> map) {
        pn.u uVar = new pn.u();
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                uVar.u(str, map.get(str));
            }
        }
        this.u = uVar.u();
    }

    public void u(String str, byte[] bArr) {
        this.u = k.u(jk.u(str), bArr);
    }

    public void u(final com.bytedance.sdk.component.a.u.u uVar) {
        try {
            s.u uVar2 = new s.u();
            if (TextUtils.isEmpty(this.iz)) {
                uVar.u(this, new IOException("Url is Empty"));
                return;
            }
            uVar2.u(this.iz);
            if (this.u == null) {
                if (uVar != null) {
                    uVar.u(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                u(uVar2);
                uVar2.u((Object) nr());
                this.fx.u(uVar2.u(this.u).nr()).u(new com.bytedance.sdk.component.nr.u.fx() { // from class: com.bytedance.sdk.component.a.nr.pn.1
                    @Override // com.bytedance.sdk.component.nr.u.fx
                    public void onFailure(com.bytedance.sdk.component.nr.u.nr nrVar, IOException iOException) {
                        com.bytedance.sdk.component.a.u.u uVar3 = uVar;
                        if (uVar3 != null) {
                            uVar3.u(pn.this, iOException);
                        }
                    }

                    @Override // com.bytedance.sdk.component.nr.u.fx
                    public void onResponse(com.bytedance.sdk.component.nr.u.nr nrVar, my myVar) throws IOException {
                        com.bytedance.sdk.component.a.nr nrVar2;
                        HashMap map;
                        com.bytedance.sdk.component.a.u.u uVar3 = uVar;
                        if (uVar3 != null) {
                            if (myVar == null) {
                                uVar3.u(pn.this, new IOException("No response"));
                                return;
                            }
                            com.bytedance.sdk.component.a.nr nrVar3 = null;
                            IOException iOException = null;
                            try {
                                map = new HashMap();
                                iz izVarX = myVar.x();
                                if (izVarX != null) {
                                    for (int i = 0; i < izVarX.u(); i++) {
                                        String strU = izVarX.u(i);
                                        String strNr = izVarX.nr(i);
                                        map.put(strU, strNr);
                                        if (strU != null && strU.equalsIgnoreCase("content-type")) {
                                            map.put("content-type", strNr == null ? "" : strNr.toLowerCase());
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                if (com.bytedance.sdk.component.a.b.u.u(map)) {
                                    byte[] bArrB = myVar.iz().b();
                                    nrVar2 = new com.bytedance.sdk.component.a.nr(myVar.b(), myVar.fx(), myVar.pn(), map, null, myVar.nr(), myVar.u());
                                    nrVar2.u(bArrB);
                                } else if (pn.this.x) {
                                    byte[] bArrB2 = myVar.iz().b();
                                    pn pnVar = pn.this;
                                    nrVar2 = new com.bytedance.sdk.component.a.nr(myVar.b(), myVar.fx(), myVar.pn(), map, new String(bArrB2, pnVar.u(pnVar.u(myVar.iz()))), myVar.nr(), myVar.u());
                                    nrVar2.u(bArrB2);
                                } else {
                                    nrVar2 = new com.bytedance.sdk.component.a.nr(myVar.b(), myVar.fx(), myVar.pn(), map, myVar.iz().nr(), myVar.nr(), myVar.u());
                                }
                                pn.this.u(nrVar2, myVar);
                            } catch (Throwable th2) {
                                th = th2;
                                nrVar3 = nrVar2;
                                nrVar2 = nrVar3;
                                iOException = new IOException(th);
                            }
                            if (nrVar2 != null) {
                                uVar.u(pn.this, nrVar2);
                                return;
                            }
                            com.bytedance.sdk.component.a.u.u uVar4 = uVar;
                            pn pnVar2 = pn.this;
                            if (iOException == null) {
                                iOException = new IOException("Unexpected exception");
                            }
                            uVar4.u(pnVar2, iOException);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            uVar.u(this, new IOException(th.getMessage()));
        }
    }

    @Override // com.bytedance.sdk.component.a.nr.b
    public com.bytedance.sdk.component.a.nr u() {
        com.bytedance.sdk.component.a.nr nrVar;
        try {
            s.u uVar = new s.u();
            if (TextUtils.isEmpty(this.iz)) {
                return new com.bytedance.sdk.component.a.nr(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            uVar.u(this.iz);
            if (this.u == null) {
                return new com.bytedance.sdk.component.a.nr(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            u(uVar);
            uVar.u((Object) nr());
            my myVarNr = this.fx.u(uVar.u(this.u).nr()).nr();
            if (myVarNr == null) {
                return null;
            }
            HashMap map = new HashMap();
            iz izVarX = myVarNr.x();
            if (izVarX != null) {
                for (int i = 0; i < izVarX.u(); i++) {
                    String strU = izVarX.u(i);
                    String strNr = izVarX.nr(i);
                    map.put(strU, strNr);
                    if (strU != null && strU.equalsIgnoreCase("content-type")) {
                        map.put("content-type", strNr == null ? "" : strNr.toLowerCase());
                    }
                }
            }
            if (com.bytedance.sdk.component.a.b.u.u(map)) {
                byte[] bArrB = myVarNr.iz().b();
                nrVar = new com.bytedance.sdk.component.a.nr(myVarNr.b(), myVarNr.fx(), myVarNr.pn(), map, null, myVarNr.nr(), myVarNr.u());
                nrVar.u(bArrB);
            } else if (this.x) {
                byte[] bArrB2 = myVarNr.iz().b();
                nrVar = new com.bytedance.sdk.component.a.nr(myVarNr.b(), myVarNr.fx(), myVarNr.pn(), map, new String(bArrB2, u(u(myVarNr.iz()))), myVarNr.nr(), myVarNr.u());
                nrVar.u(bArrB2);
            } else {
                nrVar = new com.bytedance.sdk.component.a.nr(myVarNr.b(), myVarNr.fx(), myVarNr.pn(), map, myVarNr.iz().nr(), myVarNr.nr(), myVarNr.u());
            }
            u(nrVar, myVarNr);
            return nrVar;
        } catch (Throwable th) {
            return new com.bytedance.sdk.component.a.nr(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset u(jk jkVar) {
        try {
            return jkVar != null ? jkVar.u(com.bytedance.sdk.component.nr.u.nr.jk.u) : com.bytedance.sdk.component.nr.u.nr.jk.u;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.nr.u.nr.jk.u;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public jk u(o oVar) {
        try {
            return oVar.pn();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.component.a.nr nrVar, my myVar) {
        if (nrVar == null || myVar == null) {
            return;
        }
        nrVar.u(myVar.n());
    }
}
