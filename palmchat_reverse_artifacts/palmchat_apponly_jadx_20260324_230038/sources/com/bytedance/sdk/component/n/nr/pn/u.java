package com.bytedance.sdk.component.n.nr.pn;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.component.n.nr.fx.fx;
import com.bytedance.sdk.component.n.u.b;
import com.bytedance.sdk.component.n.u.n;
import com.bytedance.sdk.component.n.u.pn;
import com.bytedance.sdk.component.n.u.u.iz;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.bq;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.component.n.u.u.u<com.bytedance.sdk.component.n.u.nr> {
    private static final SimpleDateFormat nr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private pn b;
    private final String fx = "x-pglcypher";
    private final boolean u = nr();

    private Map<String, String> b(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json; charset=utf-8");
        if (iz(jSONObject)) {
            map.put("Content-Encoding", "union_sdk_encode");
        }
        return map;
    }

    private boolean iz(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    private String nr(int i) {
        return i >= 4 ? "application/octet-stream" : "application/octet-stream;tt-data=a";
    }

    private int pn(JSONObject jSONObject) {
        int iIndexOf;
        if (jSONObject == null) {
            return 0;
        }
        try {
            String strOptString = jSONObject.optString("s_sig_ts");
            if (strOptString == null || (iIndexOf = strOptString.indexOf("_")) < 5) {
                return 512;
            }
            String strSubstring = strOptString.substring(0, iIndexOf);
            String strSubstring2 = strOptString.substring(iIndexOf + 1);
            JSONObject jSONObjectA = u().b().s().a();
            if (u((jSONObjectA != null ? jSONObjectA.optString("device_id") : "") + "_" + strSubstring, strSubstring2)) {
                return Math.abs((System.currentTimeMillis() / 1000) - Long.valueOf(strSubstring).longValue()) > 300 ? 513 : 0;
            }
            return 512;
        } catch (Throwable unused) {
            return 512;
        }
    }

    public boolean fx(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static PublicKey fx() throws Exception {
        return KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    public static byte[] nr(JSONObject jSONObject) {
        return jSONObject == null ? new byte[0] : jSONObject.toString().getBytes(StandardCharsets.UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public pn u() {
        if (this.b == null) {
            this.b = com.bytedance.sdk.component.n.nr.u.fx("csj").fx();
        }
        return this.b;
    }

    private static boolean nr() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public List<com.bytedance.sdk.component.n.u.nr> nr(List<com.bytedance.sdk.component.n.u.nr> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.component.n.u.nr nrVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObjectX = nrVar.x();
                String strOptString = jSONObjectX.optString("label");
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = jSONObjectX.optString("event");
                }
                jSONObject.putOpt("event", strOptString);
                long jOptLong = jSONObjectX.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(jOptLong));
                jSONObject.putOpt("datetime", nr.format(new Date(jOptLong)));
                JSONObject jSONObject2 = new JSONObject();
                if (jSONObjectX.has("params") && jSONObjectX.has("event")) {
                    jSONObject2 = jSONObjectX.optJSONObject("params");
                } else {
                    Iterator<String> itKeys = jSONObjectX.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!TextUtils.equals(next, "label")) {
                            jSONObject2.putOpt(next, jSONObjectX.opt(next));
                        }
                    }
                }
                jSONObject.putOpt("params", jSONObject2);
                com.bytedance.sdk.component.n.nr.b.u.u uVar = new com.bytedance.sdk.component.n.nr.b.u.u(nrVar.fx(), jSONObject);
                uVar.u(nrVar.b());
                uVar.nr(nrVar.pn());
                arrayList.add(uVar);
            } catch (Exception e) {
                fx.u(e.getMessage(), u());
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.component.n.u.u.u
    public com.bytedance.sdk.component.n.nr.nr.fx.u u(List<com.bytedance.sdk.component.n.u.nr> list) {
        n nVarS;
        com.bytedance.sdk.component.n.nr.nr.fx.u uVarU;
        String strIz;
        b bVarB = u().b();
        if (bVarB != null) {
            try {
                if (bVarB.pn() && (nVarS = bVarB.s()) != null && list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    String str = "1streqid";
                    String strIz2 = "2ndreqid";
                    String str2 = "";
                    boolean z = false;
                    for (com.bytedance.sdk.component.n.u.nr nrVar : list) {
                        try {
                            if (TextUtils.equals(bq.b.V, com.bytedance.sdk.component.n.nr.fx.u.u(nrVar, u()))) {
                                String strU = com.bytedance.sdk.component.n.nr.fx.u.u(nrVar.x(), this.b);
                                if (!z) {
                                    strIz = com.bytedance.sdk.component.n.nr.fx.u.iz(nrVar, this.b);
                                } else {
                                    strIz2 = com.bytedance.sdk.component.n.nr.fx.u.iz(nrVar, this.b);
                                    strIz = strIz2;
                                }
                                str2 = strU;
                                str = strIz;
                                z = true;
                            }
                            arrayList.add(nrVar);
                        } catch (Throwable th) {
                            th = th;
                            fx.u("NetApiImpl", "uploadEvent error" + th.getMessage(), u());
                            return new com.bytedance.sdk.component.n.nr.nr.fx.u(false, 509, th.getMessage(), false, "error");
                        }
                    }
                    int iJk = nVarS.jk();
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    JSONObject jSONObjectU = nVarS.u(nr(arrayList), this.u);
                    byte[] bArrU = nVarS.u(jSONObjectU, iJk);
                    if (bArrU == null) {
                        JSONObject jSONObjectU2 = nVarS.u(jSONObjectU);
                        bArrU = nr(jSONObjectU2);
                        uVarU = u(bArrU, b(jSONObjectU2), "application/json; charset=utf-8");
                    } else {
                        uVarU = u(bArrU, u(iJk), nr(iJk));
                    }
                    if (z) {
                        int length = bArrU != null ? bArrU.length : 0;
                        if (uVarU != null) {
                            com.bytedance.sdk.component.n.nr.fx.u.u(uVarU.u, uVarU.nr, uVarU.fx, str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + strIz2, length, str2);
                        }
                    }
                    return uVarU;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    private void nr(byte[] bArr, Map<String, String> map, String str) {
        pn pnVarU;
        b bVarB;
        n nVarS;
        if (bArr == null || bArr.length == 0 || (pnVarU = u()) == null || (bVarB = pnVarU.b()) == null || (nVarS = bVarB.s()) == null || !nVarS.u()) {
            return;
        }
        iz izVarPn = nVarS.pn();
        izVarPn.u(nVarS.nr());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                izVarPn.u(entry.getKey(), entry.getValue());
            }
        }
        izVarPn.u(str, bArr);
        izVarPn.u("User-Agent", bVarB.t());
        izVarPn.u(new com.bytedance.sdk.component.n.u.u.fx() { // from class: com.bytedance.sdk.component.n.nr.pn.u.1
            @Override // com.bytedance.sdk.component.n.u.u.fx
            public void u(com.bytedance.sdk.component.n.u.u.b bVar, com.bytedance.sdk.component.n.u.u.pn pnVar) {
                if (pnVar == null || !pnVar.u()) {
                    u.this.u();
                } else {
                    pnVar.nr();
                    u.this.u();
                }
            }

            @Override // com.bytedance.sdk.component.n.u.u.fx
            public void u(com.bytedance.sdk.component.n.u.u.b bVar, IOException iOException) {
                iOException.getMessage();
                u.this.u();
            }
        });
    }

    private Map<String, String> u(int i) {
        HashMap map = new HashMap();
        if (i >= 4) {
            map.put("Content-Encoding", "union_sdk_encode");
            map.put("x-pglcypher", String.valueOf(i));
        }
        map.put("Content-Type", nr(i));
        return map;
    }

    private com.bytedance.sdk.component.n.nr.nr.fx.u u(byte[] bArr, Map<String, String> map, String str) {
        int iPn;
        boolean zFx;
        boolean z;
        int i;
        boolean z2;
        String str2;
        try {
            b bVarB = u().b();
            n nVarS = bVarB.s();
            iz izVarPn = nVarS.pn();
            izVarPn.u(nVarS.iz());
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    izVarPn.u(entry.getKey(), entry.getValue());
                }
            }
            izVarPn.u(str, bArr);
            izVarPn.u("User-Agent", bVarB.t());
            com.bytedance.sdk.component.n.u.u.pn pnVarU = izVarPn.u();
            if (pnVarU == null) {
                return new com.bytedance.sdk.component.n.nr.nr.fx.u(false, 510, "RSP IS NULL", false, "error");
            }
            if (!pnVarU.u() || TextUtils.isEmpty(pnVarU.nr())) {
                iPn = 0;
                zFx = false;
            } else {
                JSONObject jSONObject = new JSONObject(pnVarU.nr());
                zFx = fx(jSONObject);
                iPn = pn(jSONObject);
            }
            int iFx = pnVarU.fx();
            String str3 = pnVarU.pn() != null ? pnVarU.pn().get("x-tt-logid") : "error";
            boolean z3 = !zFx && iFx == 200;
            String strB = pnVarU.b();
            if (strB == null || TextUtils.isEmpty(strB)) {
                strB = "DEFAULT OK";
            }
            if (iPn != 0) {
                str2 = "RSP FAIL";
                i = iPn;
                z = false;
                z2 = true;
            } else {
                z = zFx;
                i = iFx;
                z2 = z3;
                str2 = strB;
            }
            nr(bArr, map, str);
            return new com.bytedance.sdk.component.n.nr.nr.fx.u(z, i, str2, z2, str3);
        } catch (Throwable th) {
            fx.u("NetApiImpl", "uploadEvent error" + th.getMessage(), u());
            return new com.bytedance.sdk.component.n.nr.nr.fx.u(false, 511, th.getMessage(), false, "error");
        }
    }

    private boolean u(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(fx().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:23|(1:35)(13:27|28|(1:30)(1:31)|32|(0)|49|37|52|38|(1:40)|41|46|47)|36|49|37|52|38|(0)|41|46|47) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00be, code lost:
    
        r1 = r0;
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c1, code lost:
    
        r0 = r2;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c6, code lost:
    
        r8 = r12;
        r6 = r0;
        r7 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6 A[Catch: all -> 0x00be, TRY_LEAVE, TryCatch #2 {all -> 0x00be, blocks: (B:38:0x00b0, B:40:0x00b6), top: B:52:0x00b0 }] */
    @Override // com.bytedance.sdk.component.n.u.u.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.bytedance.sdk.component.n.nr.nr.fx.u u(JSONObject jSONObject) {
        n nVarS;
        boolean z;
        com.bytedance.sdk.component.n.u.u.pn pnVarU;
        boolean z2;
        b bVarB = u().b();
        if (bVarB == null || !bVarB.pn() || jSONObject == null || jSONObject.length() <= 0 || (nVarS = bVarB.s()) == null) {
            return null;
        }
        iz izVarPn = nVarS.pn();
        izVarPn.u(nVarS.x());
        int iJk = nVarS.jk();
        byte[] bArrNr = nVarS.nr(jSONObject, iJk);
        if (bArrNr == null) {
            izVarPn.nr(nVarS.u(jSONObject).toString());
        } else {
            izVarPn.u(nr(iJk), bArrNr);
            izVarPn.u("x-pglcypher", String.valueOf(iJk));
        }
        izVarPn.u("User-Agent", bVarB.t());
        String strB = "error unknown";
        boolean z3 = false;
        try {
            pnVarU = izVarPn.u();
        } catch (Throwable unused) {
            int i = 0;
            z = false;
        }
        if (pnVarU == null) {
            return new com.bytedance.sdk.component.n.nr.nr.fx.u(false, 0, "error unknown", false, "ignore");
        }
        if (pnVarU.u() && !TextUtils.isEmpty(pnVarU.nr())) {
            JSONObject jSONObject2 = new JSONObject(pnVarU.nr());
            int iOptInt = jSONObject2.optInt("code", -1);
            strB = jSONObject2.optString("data", "");
            z = true;
            z2 = iOptInt == 20000;
            if (iOptInt != 60005) {
            }
            int iFx = pnVarU.fx();
            if (!pnVarU.u()) {
                strB = pnVarU.b();
            }
            String str = strB;
            int i2 = iFx;
            boolean z4 = z2;
            return new com.bytedance.sdk.component.n.nr.nr.fx.u(z4, i2, str, z, "ignore");
        }
        z2 = false;
        z = false;
        int iFx2 = pnVarU.fx();
        if (!pnVarU.u()) {
        }
        String str2 = strB;
        int i22 = iFx2;
        boolean z42 = z2;
        return new com.bytedance.sdk.component.n.nr.nr.fx.u(z42, i22, str2, z, "ignore");
    }
}
