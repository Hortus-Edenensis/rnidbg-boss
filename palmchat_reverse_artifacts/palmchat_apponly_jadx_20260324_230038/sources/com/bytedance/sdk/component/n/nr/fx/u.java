package com.bytedance.sdk.component.n.nr.fx;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.sdk.component.n.u.b;
import com.bytedance.sdk.component.n.u.pn;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static final LinkedList<String> u = new LinkedList<>();
    private static final LinkedList<String> nr = new LinkedList<>();
    private static final LinkedList<String> fx = new LinkedList<>();
    private static final LinkedList<String> b = new LinkedList<>();
    private static final Map<String, Integer> pn = new HashMap();
    private static String iz = "upload_init";
    private static int x = 0;
    private static int n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicLong f5155a = new AtomicLong();

    public static boolean a(com.bytedance.sdk.component.n.u.nr nrVar, pn pnVar) {
        return nrVar != null && nrVar.b() == 0 && u(pnVar);
    }

    private static synchronized String b(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = nr;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        return sb.toString();
    }

    public static boolean fx(String str) {
        return false;
    }

    private static synchronized void iz(String str) {
        LinkedList<String> linkedList = b;
        if (linkedList.size() < 10) {
            linkedList.add(str);
        } else {
            linkedList.removeFirst();
            linkedList.add(str);
        }
    }

    public static void n(com.bytedance.sdk.component.n.u.nr nrVar, pn pnVar) {
        if (pnVar == null || pnVar.b() == null || !pnVar.b().a()) {
            return;
        }
        try {
            com.bytedance.sdk.component.n.nr.nr.nr.u.u(System.currentTimeMillis() - nrVar.n());
            nrVar.nr(System.currentTimeMillis());
            if (nrVar.b() == 0 && pnVar.b() != null && pnVar.b().u()) {
                String strU = u(nrVar, pnVar);
                if (fx(strU)) {
                    return;
                }
                JSONObject jSONObjectX = nrVar.x();
                String strOptString = nrVar.x().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("save_success_labels", b(strU));
                    jSONObjectX.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                } else {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject2.optString("save_success_labels"))) {
                        jSONObject2.put("save_success_labels", b(strU));
                    }
                    jSONObjectX.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String nr(int i) {
        switch (i) {
            case 71:
                return "flush once";
            case 72:
                return "flush memory db";
            case 73:
                return "flush memory";
            case 74:
                return "new event";
            case 75:
            default:
                return MapController.DEFAULT_LAYER_TAG;
            case 76:
                return "empty message";
            case 77:
                return "net error";
        }
    }

    private static synchronized String pn(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = fx;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        return sb.toString();
    }

    public static boolean u(int i) {
        return i == 72 || i == 71;
    }

    public static void x(com.bytedance.sdk.component.n.u.nr nrVar, pn pnVar) {
        try {
            if (nrVar.b() == 0 && pnVar.b() != null && pnVar.b().u()) {
                JSONObject jSONObjectX = nrVar.x();
                String strU = u(nrVar, pnVar);
                if (fx(strU)) {
                    return;
                }
                String strOptString = jSONObjectX.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("will_send_labels", pn(strU));
                    jSONObject.put("send_success_valid_labels", nr());
                    jSONObjectX.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(strOptString);
                if (TextUtils.isEmpty(jSONObject2.optString("will_send_labels"))) {
                    jSONObject2.put("will_send_labels", pn(strU));
                    jSONObject2.put("send_success_valid_labels", nr());
                }
                jSONObjectX.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
    }

    public static String fx(com.bytedance.sdk.component.n.u.nr nrVar, pn pnVar) {
        if (pnVar == null || pnVar.b() == null || !pnVar.b().fx()) {
            return "";
        }
        String strU = u(nrVar, pnVar);
        if (!TextUtils.isEmpty(strU)) {
            return "label:" + strU;
        }
        if (TextUtils.isEmpty(nr(nrVar, pnVar))) {
            return null;
        }
        return "type:" + nr(nrVar, pnVar);
    }

    public static synchronized String nr(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = u;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        return sb.toString();
    }

    public static synchronized int u(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Map<String, Integer> map = pn;
        Integer num = map.get(str);
        if (num == null) {
            map.put(str, 1);
            return 1;
        }
        int iIntValue = num.intValue() + 1;
        map.put(str, Integer.valueOf(iIntValue));
        return iIntValue;
    }

    public static String iz(com.bytedance.sdk.component.n.u.nr nrVar, pn pnVar) {
        if (nrVar != null && nrVar.x() != null && !nr(pnVar) && !b(pnVar)) {
            String strOptString = nrVar.x().optString("log_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    return new JSONObject(strOptString).optString(ReportItem.RequestKeyRequestId);
                } catch (JSONException unused) {
                }
            }
        }
        return null;
    }

    public static int b(com.bytedance.sdk.component.n.u.nr nrVar, pn pnVar) {
        if (nrVar != null && nrVar.x() != null && nrVar.b() == 1) {
            try {
                return new JSONObject(nrVar.x().optString("event_extra")).optInt("stats_index");
            } catch (JSONException unused) {
            }
        }
        return -1;
    }

    public static boolean fx(pn pnVar) {
        return pnVar != null && TextUtils.equals(pnVar.pn(), MediationConstant.ADN_PANGLE);
    }

    public static synchronized int pn(com.bytedance.sdk.component.n.u.nr nrVar, pn pnVar) {
        if (nrVar != null) {
            if (nrVar.x() != null) {
                try {
                    return new JSONObject(nrVar.x().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optInt("sdk_event_self_count");
                } catch (Exception unused) {
                    return 0;
                }
            }
        }
        return 0;
    }

    public static boolean fx(com.bytedance.sdk.component.n.u.nr nrVar) {
        return nrVar != null && nrVar.b() == 0 && nrVar.pn() == 2;
    }

    private static synchronized String nr() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator<String> it = b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        return sb.toString();
    }

    public static String u(com.bytedance.sdk.component.n.u.nr nrVar, pn pnVar) {
        if (nrVar == null || nrVar.x() == null || nr(pnVar) || b(pnVar)) {
            return null;
        }
        if (nrVar.nr() == 3) {
            return nrVar.x().optString("event");
        }
        return nrVar.x().optString("label");
    }

    public static int fx(List<com.bytedance.sdk.component.n.u.nr> list, pn pnVar) {
        JSONObject jSONObjectX;
        String strOptString;
        if (list != null && list.size() == 1) {
            try {
                com.bytedance.sdk.component.n.u.nr nrVar = list.get(0);
                if (nrVar != null && nrVar.pn() == 1 && (jSONObjectX = nrVar.x()) != null && nrVar.b() == 0) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectX.optJSONObject("params");
                    if (jSONObjectOptJSONObject == null) {
                        strOptString = jSONObjectX.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                    } else {
                        strOptString = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                    }
                    JSONObject jSONObject = new JSONObject(strOptString);
                    int iOptInt = jSONObject.optInt("inner_appid", 0);
                    if (iOptInt != 0) {
                        jSONObject.remove("inner_appid");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectX.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                        } else {
                            jSONObjectOptJSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                            jSONObjectX.put("params", jSONObjectOptJSONObject);
                        }
                        return iOptInt;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static boolean iz(com.bytedance.sdk.component.n.u.nr nrVar) {
        return nrVar != null && nrVar.b() == 2 && nrVar.pn() == 3;
    }

    public static boolean b(pn pnVar) {
        return pnVar != null && TextUtils.equals(pnVar.pn(), "pgl_mediation");
    }

    public static boolean b(com.bytedance.sdk.component.n.u.nr nrVar) {
        return nrVar != null && nrVar.b() == 1 && nrVar.pn() == 2;
    }

    public static String nr(com.bytedance.sdk.component.n.u.nr nrVar, pn pnVar) {
        if (nrVar == null || nrVar.x() == null || nr(pnVar) || b(pnVar)) {
            return null;
        }
        return nrVar.x().optString("type");
    }

    public static void u(List<com.bytedance.sdk.component.n.u.nr> list, String str, com.bytedance.sdk.component.n.nr.u.nr nrVar) {
        JSONObject jSONObjectX;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    com.bytedance.sdk.component.n.u.nr nrVar2 = list.get(0);
                    if (nrVar2 == null || nrVar2.b() == 0) {
                        long jIncrementAndGet = f5155a.incrementAndGet();
                        for (com.bytedance.sdk.component.n.u.nr nrVar3 : list) {
                            if (nrVar3 != null && (jSONObjectX = nrVar3.x()) != null) {
                                String strOptString = jSONObjectX.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                                if (!TextUtils.isEmpty(strOptString)) {
                                    JSONObject jSONObject = new JSONObject(strOptString);
                                    jSONObject.put("upload_count", jIncrementAndGet);
                                    jSONObject.put("upload_ts", System.currentTimeMillis());
                                    if (nrVar != null) {
                                        String strNr = nrVar.nr();
                                        boolean zU = nrVar.u();
                                        if (!TextUtils.isEmpty(strNr)) {
                                            jSONObject.put("delete_msg", strNr + " success:" + zU);
                                        }
                                    }
                                    jSONObjectX.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean pn(pn pnVar) {
        return u(pnVar) || fx(pnVar);
    }

    public static boolean nr(pn pnVar) {
        return pnVar != null && TextUtils.equals(pnVar.pn(), "csj_mediation");
    }

    public static boolean pn(com.bytedance.sdk.component.n.u.nr nrVar) {
        return nrVar != null && nrVar.b() == 1 && nrVar.pn() == 3;
    }

    public static boolean nr(List<com.bytedance.sdk.component.n.u.nr> list, pn pnVar) {
        com.bytedance.sdk.component.n.u.nr nrVar;
        return (list == null || list.size() == 0 || (nrVar = list.get(0)) == null || nrVar.b() != 0 || !u(pnVar)) ? false : true;
    }

    public static boolean nr(com.bytedance.sdk.component.n.u.nr nrVar) {
        return nrVar != null && nrVar.b() == 3 && nrVar.pn() == 2;
    }

    public static String u(JSONObject jSONObject, pn pnVar) {
        if (jSONObject != null && !nr(pnVar) && !b(pnVar)) {
            String strOptString = jSONObject.optString("log_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    return new JSONObject(strOptString).optString("rit");
                } catch (JSONException unused) {
                }
            }
        }
        return "";
    }

    public static void u(List<com.bytedance.sdk.component.n.u.nr> list, pn pnVar) {
        try {
            if (pnVar.b().a()) {
                for (com.bytedance.sdk.component.n.u.nr nrVar : list) {
                    if (nrVar != null && nrVar.a() != 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - nrVar.a();
                        com.bytedance.sdk.component.n.nr.nr.u.u uVar = com.bytedance.sdk.component.n.nr.nr.nr.u;
                        uVar.n().incrementAndGet();
                        uVar.mv().getAndAdd(jCurrentTimeMillis);
                        nrVar.fx(System.currentTimeMillis());
                    }
                    if (nrVar != null) {
                        x(nrVar, pnVar);
                    }
                }
                com.bytedance.sdk.component.n.nr.nr.nr.u.jk().getAndAdd(list.size());
            }
        } catch (Exception unused) {
        }
    }

    public static boolean u(pn pnVar) {
        return pnVar != null && TextUtils.equals(pnVar.pn(), "csj");
    }

    public static void u(JSONObject jSONObject, com.bytedance.sdk.component.n.nr.b.u.u uVar, pn pnVar, int i) {
        b bVarB;
        if (pnVar != null && (bVarB = pnVar.b()) != null && bVarB.fx() && pn(pnVar)) {
            jSONObject.optString("label");
        }
    }

    public static void u(List<com.bytedance.sdk.component.n.u.nr> list, int i, String str, pn pnVar) {
        b bVarB;
        if (pnVar == null || (bVarB = pnVar.b()) == null || !bVarB.fx() || list == null || nr(pnVar) || b(pnVar)) {
            return;
        }
        boolean z = false;
        for (com.bytedance.sdk.component.n.u.nr nrVar : list) {
            if (nrVar.b() == 0) {
                JSONObject jSONObjectX = nrVar.x();
                u(nrVar, pnVar);
                if (nrVar.nr() != 3) {
                    u(pnVar, nrVar);
                    pn(nrVar, pnVar);
                } else if (jSONObjectX != null) {
                    jSONObjectX.optString("event");
                }
                z = true;
            } else if (nrVar.b() == 1) {
                nr(nrVar, pnVar);
                b(nrVar, pnVar);
            }
        }
        if (z) {
            nr(i);
            list.size();
        } else {
            nr(i);
            list.size();
        }
    }

    public static boolean u(com.bytedance.sdk.component.n.u.nr nrVar) {
        return nrVar != null && nrVar.b() == 0 && nrVar.pn() == 1;
    }

    private static void u(com.bytedance.sdk.component.n.u.nr nrVar, String str, b bVar, pn pnVar) {
        String strU = u(nrVar, pnVar);
        if (fx(strU)) {
            return;
        }
        String strIz = iz(nrVar, pnVar);
        if (nrVar.b() == 0 && bVar.u()) {
            iz(strU + "_" + strIz + "_" + str);
        }
    }

    public static long u(pn pnVar, com.bytedance.sdk.component.n.u.nr nrVar) {
        if (nrVar != null && nrVar.x() != null) {
            try {
                return new JSONObject(nrVar.x().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optLong("sdk_event_index");
            } catch (Exception e) {
                fx.u(e.getMessage(), pnVar);
            }
        }
        return 0L;
    }

    public static void u(boolean z, int i, String str, String str2, int i2, String str3) {
        x++;
        if (z) {
            n++;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("suc", z);
            jSONObject.put("scnt", n);
            jSONObject.put("acnt", x);
            jSONObject.put("code", i);
            jSONObject.put("reqid", str2);
            jSONObject.put("len:", i2);
            jSONObject.put("rit", str3);
            jSONObject.put("msg", str);
            b bVarPn = com.bytedance.sdk.component.n.nr.u.fx("csj").pn();
            if (bVarPn != null) {
                jSONObject.put("url", bVarPn.s().iz());
            } else {
                jSONObject.put("url", "emptyurl");
            }
            iz = jSONObject.toString();
        } catch (Exception unused) {
            iz = "unknown_json";
        }
    }

    public static String u() {
        return iz;
    }

    public static void u(com.bytedance.sdk.component.n.u.nr nrVar, pn pnVar, String str) {
        b bVarPn;
        if (nr(pnVar) || pnVar == null || b(pnVar) || (bVarPn = com.bytedance.sdk.component.n.nr.u.fx(pnVar.pn()).pn()) == null || !bVarPn.fx()) {
            return;
        }
        if (!TextUtils.isEmpty(nr(nrVar, pnVar))) {
            b(nrVar, pnVar);
        }
        if (TextUtils.isEmpty(u(nrVar, pnVar))) {
            return;
        }
        u(pnVar, nrVar);
    }

    public static void u(List<com.bytedance.sdk.component.n.u.nr> list, pn pnVar, String str) {
        if (pnVar == null) {
            return;
        }
        try {
            b bVarB = pnVar.b();
            if (bVarB == null || !bVarB.fx()) {
                return;
            }
            for (com.bytedance.sdk.component.n.u.nr nrVar : list) {
                if (nrVar.b() == 1) {
                    nr(nrVar, pnVar);
                    b(nrVar, pnVar);
                } else if (nrVar.b() == 0) {
                    if (nrVar.nr() == 3) {
                        if (nrVar.x() != null) {
                            nrVar.x().optString("event");
                            u(pnVar, nrVar);
                        }
                    } else {
                        u(nrVar, pnVar);
                        u(pnVar, nrVar);
                    }
                }
            }
            list.size();
        } catch (Exception e) {
            fx.u("_delete error", e.getMessage(), pnVar);
        }
    }

    public static void u(int i, List<com.bytedance.sdk.component.n.u.nr> list, long j, pn pnVar, com.bytedance.sdk.component.n.nr.nr.fx.u uVar) {
        com.bytedance.sdk.component.n.u.nr nrVar;
        if (pnVar != null) {
            try {
                if (pnVar.b().a()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - j;
                    if (i == 200) {
                        com.bytedance.sdk.component.n.nr.nr.u.u uVar2 = com.bytedance.sdk.component.n.nr.nr.nr.u;
                        uVar2.q().getAndAdd(jCurrentTimeMillis);
                        uVar2.dw().incrementAndGet();
                        uVar2.sx().getAndAdd(list.size());
                        uVar2.pn().getAndAdd(list.size());
                        return;
                    }
                    fx.u("-------AdThread code is " + i + " error  ------------", pnVar);
                    byte b2 = -1;
                    if (i == -1) {
                        com.bytedance.sdk.component.n.nr.nr.nr.u.bg().getAndAdd(list.size());
                    } else {
                        com.bytedance.sdk.component.n.nr.nr.nr.u.x().getAndAdd(list.size());
                    }
                    com.bytedance.sdk.component.n.nr.nr.u.u uVar3 = com.bytedance.sdk.component.n.nr.nr.nr.u;
                    uVar3.qq().getAndAdd(jCurrentTimeMillis);
                    uVar3.c().incrementAndGet();
                    if (!list.isEmpty() && (nrVar = list.get(0)) != null) {
                        b2 = nrVar.b();
                    }
                    if (uVar != null) {
                        String str = uVar.b;
                        int i2 = uVar.nr;
                        String str2 = uVar.fx;
                        StringBuffer stringBufferKj = uVar3.kj();
                        stringBufferKj.append((int) b2);
                        stringBufferKj.append("_");
                        stringBufferKj.append(str);
                        stringBufferKj.append("_");
                        stringBufferKj.append(i2);
                        stringBufferKj.append("_");
                        stringBufferKj.append(str2);
                        stringBufferKj.append(" ");
                        return;
                    }
                    StringBuffer stringBufferKj2 = uVar3.kj();
                    stringBufferKj2.append((int) b2);
                    stringBufferKj2.append("_");
                    stringBufferKj2.append(i);
                    stringBufferKj2.append(" ");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void u(List<com.bytedance.sdk.component.n.u.nr> list, String str, pn pnVar) {
        try {
            b bVarB = pnVar.b();
            if (bVarB != null && bVarB.a() && list != null && bVarB.u()) {
                for (com.bytedance.sdk.component.n.u.nr nrVar : list) {
                    if (nrVar != null) {
                        u(nrVar, str, bVarB, pnVar);
                    }
                }
            }
        } catch (Exception e) {
            fx.u(e.getMessage(), pnVar);
        }
    }
}
