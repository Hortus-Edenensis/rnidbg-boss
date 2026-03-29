package com.opos.mobad.model.a;

import com.opos.cmn.func.a.a.d;
import com.opos.mobad.b.a.ab;
import com.opos.mobad.b.a.ac;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.g;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c extends a {
    private com.opos.mobad.b d;
    private String e;
    private String f;
    private com.opos.mobad.model.c.d g;

    public c(com.opos.mobad.b bVar, String str, String str2, com.opos.mobad.model.c.c cVar, boolean z, g.a aVar) {
        super(bVar, str, cVar, z, new g(str, str2, true), aVar);
        this.d = bVar;
        this.e = str;
        this.f = str2;
    }

    @Override // com.opos.mobad.model.a.a
    public void b(ac acVar) {
    }

    public void f() {
        if (j() != 4 || this.g == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("cAdLoader", "cache origin cache");
        com.opos.mobad.model.e.b bVarK = this.d.k();
        com.opos.mobad.b bVar = this.d;
        String str = this.e;
        com.opos.mobad.model.c.d dVar = this.g;
        bVarK.a(bVar, str, dVar, dVar.h(), this.c.e(), ((a) this).b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.opos.mobad.model.c.d a(com.opos.mobad.model.c.d dVar, i iVar) {
        List<com.opos.mobad.b.a.b> listH;
        com.opos.cmn.func.a.a.e eVarA = null;
        try {
            listH = dVar.h();
        } catch (Throwable th) {
            try {
                com.opos.cmn.an.f.a.c("cAdLoader", "check fail", th);
            } finally {
                if (eVarA != null) {
                    eVarA.a();
                }
            }
        }
        if (listH != null && listH.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (com.opos.mobad.b.a.b bVar : listH) {
                List<ac> list = bVar.F;
                if (list != null && list.size() > 0) {
                    ac acVar = bVar.F.get(0);
                    if (b.a(this.d.b(), acVar, iVar, com.opos.mobad.model.utils.d.a(bVar))) {
                        if (b.a(acVar)) {
                            List<ab> list2 = acVar.as;
                            if (list2 == null || list2.size() <= 0) {
                                iVar.d(acVar);
                            } else if (!b.a(this.d, bVar, list2)) {
                                iVar.e(acVar);
                                com.opos.mobad.model.utils.g.a(this.d.b(), acVar);
                            }
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("adId", bVar.C);
                        jSONObject.put("adSource", bVar.W);
                        jSONObject.put("bizTraceId", acVar.aW);
                        jSONObject.put("posId", bVar.D);
                        jSONArray.put(jSONObject);
                    }
                }
            }
            com.opos.cmn.an.f.a.b("cAdLoader", "data size:" + jSONArray.length());
            if (jSONArray.length() <= 0) {
                return new com.opos.mobad.model.c.b(10004, "adItemList is null.");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("adReqInfoList", jSONArray);
            ((a) this).f9037a.a();
            HashMap map = new HashMap();
            map.put("Content-Type", "application/json");
            map.put("Route-Data", com.opos.cmn.biz.a.e.a(this.d.b()));
            eVarA = com.opos.cmn.func.a.a.b.a().a(this.d.b(), new d.a().a(jSONObject2.toString().getBytes()).a(map).a("POST").b("https://uapi.ads.heytapmobi.com/union/ads/advert/aol").a());
            com.opos.cmn.an.f.a.b("cAdLoader", "check code:" + eVarA.f7934a);
            if (200 != eVarA.f7934a) {
                this.g = dVar;
                return new com.opos.mobad.model.c.b(-1, "Unknown error. ");
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(eVarA.c);
            try {
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    if (i > 0) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                }
                String str = new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));
                com.opos.cmn.an.f.a.b("cAdLoader", "checkAd() check result:", str);
                JSONObject jSONObject3 = new JSONObject(str);
                if (jSONObject3.getInt("code") != 0) {
                    com.opos.mobad.model.c.b bVar2 = new com.opos.mobad.model.c.b(-1, "Unknown error. ");
                    bufferedInputStream.close();
                    eVarA.a();
                    return bVar2;
                }
                JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray("traceIdList");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    HashSet hashSet = new HashSet(jSONArrayOptJSONArray.length());
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        hashSet.add(jSONArrayOptJSONArray.getString(i2));
                    }
                    ArrayList arrayList = new ArrayList();
                    for (com.opos.mobad.b.a.b bVar3 : listH) {
                        List<ac> list3 = bVar3.F;
                        if (list3 != null && list3.size() > 0) {
                            ac acVar2 = bVar3.F.get(0);
                            if (hashSet.contains(acVar2.aW)) {
                                iVar.i(acVar2);
                                arrayList.add(bVar3);
                            } else {
                                iVar.h(acVar2);
                            }
                        }
                    }
                    com.opos.cmn.an.f.a.a("cAdLoader", "enable size:" + arrayList.size());
                    if (arrayList.size() <= 0) {
                        com.opos.mobad.model.c.b bVar4 = new com.opos.mobad.model.c.b(10004, "adItemList is null.");
                        bufferedInputStream.close();
                        eVarA.a();
                        return bVar4;
                    }
                    com.opos.mobad.model.c.d dVar2 = new com.opos.mobad.model.c.d(dVar.c(), arrayList, dVar.i());
                    bufferedInputStream.close();
                    eVarA.a();
                    return dVar2;
                }
                com.opos.mobad.model.c.b bVar5 = new com.opos.mobad.model.c.b(10004, "adItemList is null.");
                bufferedInputStream.close();
                eVarA.a();
                return bVar5;
            } finally {
            }
        }
        return new com.opos.mobad.model.c.b(10004, "adItemList is null.");
    }

    @Override // com.opos.mobad.model.a.a
    public void a(com.opos.mobad.model.c.c cVar) {
        a(this.e, this.f, cVar);
    }

    private void a(final String str, String str2, final com.opos.mobad.model.c.c cVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.d.o().a()) {
                    com.opos.cmn.an.f.a.b("cAdLoader", "cache disable");
                    c.this.b(new AdData(10001, "net response is null."));
                    return;
                }
                com.opos.mobad.model.c.c cVar2 = cVar;
                if (cVar2 != null && (com.opos.mobad.service.d.a.a(cVar2.i()) || cVar.l() != null)) {
                    com.opos.cmn.an.f.a.b("cAdLoader", "cache but in childMode", cVar.l());
                    c.this.b(new AdData(10001, "net response is null."));
                    return;
                }
                try {
                    com.opos.mobad.model.c.d dVarA = c.this.d.k().a(str, cVar.e());
                    if (dVarA == null) {
                        com.opos.cmn.an.f.a.b("cAdLoader", "cache null");
                        c.this.b(new AdData(10001, "net response is null."));
                    } else {
                        if (System.currentTimeMillis() >= dVarA.i()) {
                            c.this.a(new com.opos.mobad.model.c.b(10003, "now time over ad expire time."));
                            return;
                        }
                        com.opos.cmn.an.f.a.b("cAdLoader", "cache data:", dVarA);
                        if (dVarA.h() == null || dVarA.h().size() <= 0) {
                            c.this.a(new com.opos.mobad.model.c.b(10004, "adItemList is null."));
                        } else {
                            c cVar3 = c.this;
                            c.this.a(cVar3.a(dVarA, ((a) cVar3).f9037a));
                        }
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("cAdLoader", "checkResponseAsync() fail cache", e);
                    c.this.a(new com.opos.mobad.model.c.b(-1, "Unknown error. "));
                }
            }
        });
    }

    @Override // com.opos.mobad.model.a.a
    public void a(boolean z) {
        super.a(z);
    }
}
