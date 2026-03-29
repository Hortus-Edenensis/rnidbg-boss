package com.bytedance.sdk.openadsdk.core.qq;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.n.u.u;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.adsdk.entity.LxEventReplace;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static final Set<String> pn;
    public static final String u = UUID.randomUUID().toString();
    public static AtomicInteger nr = new AtomicInteger(0);
    private static String b = "_create";
    public static final AtomicBoolean fx = new AtomicBoolean(false);

    static {
        HashSet hashSet = new HashSet();
        pn = hashSet;
        hashSet.add("click_start");
        hashSet.add(WfConstant.EVENT_ID_DOWNLOAD_START);
        hashSet.add("download_finish");
        hashSet.add("install_finish");
        hashSet.add("click");
        hashSet.add(bq.b.V);
    }

    public static void b() {
        try {
            com.bytedance.sdk.component.n.nr.u.nr("csj");
        } catch (Exception e) {
            k.nr(b, e.getMessage());
        }
    }

    public static com.bytedance.sdk.openadsdk.core.qq.fx.u fx() {
        return mv.u;
    }

    private static void nr(Context context, boolean z) {
        if (context == null) {
            return;
        }
        int iCj = dw.nr().cj();
        if (iCj <= 0 || iCj == Integer.MAX_VALUE) {
            iCj = 100;
        }
        int iPb = dw.nr().pb();
        if (iPb > iCj) {
            iPb = 5;
            iCj = 10;
        }
        com.bytedance.sdk.component.n.nr.u.u(new u.C0226u().fx(com.bytedance.sdk.component.n.nr.b.nr.u.u(iPb, iCj)).u(com.bytedance.sdk.component.n.nr.b.nr.u.u(1, iCj)).nr(com.bytedance.sdk.component.n.nr.b.nr.u.u(1, iCj)).nr(z).u("csj").u(context).u(new a()).u(n.u).u(dw.nr().jp()).u());
    }

    public static void u(Context context, boolean z) {
        if (fx.compareAndSet(false, true) || com.bytedance.sdk.component.n.nr.u.u("csj")) {
            nr(context, z);
            com.bytedance.sdk.component.utils.jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qq.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.n.nr.u.b("csj");
                }
            }, com.bytedance.sdk.openadsdk.core.n.o().x() ? 20000L : 30000L);
        }
    }

    public static void u() {
        com.bytedance.sdk.component.n.nr.u.u(false, "csj");
    }

    public static void u(com.bytedance.sdk.component.n.nr.b.u.u uVar, String str, int i) {
        if (com.bytedance.sdk.component.n.nr.u.u("csj")) {
            u(dw.getContext(), com.bytedance.sdk.openadsdk.core.multipro.nr.fx());
        }
        if (dw.nr().wu()) {
            return;
        }
        com.bytedance.sdk.openadsdk.gi.u.fx.u(uVar.x());
        com.bytedance.sdk.component.n.nr.u.u(uVar, "csj");
    }

    private static void u(String str, com.bytedance.sdk.component.n.nr.b.u.u uVar) {
        if (dw.nr().d()) {
            try {
                uVar.fx(com.bytedance.sdk.component.n.nr.fx.u.nr(str));
            } catch (Exception e) {
                k.u(e.getMessage());
            }
        }
    }

    public static void u(com.bytedance.sdk.openadsdk.core.s.u uVar, String str) {
        if (!dw.nr().wu() || pn.contains(str)) {
            com.bytedance.sdk.component.n.nr.b.u.u uVar2 = new com.bytedance.sdk.component.n.nr.b.u.u(uVar.b(), uVar);
            uVar2.nr(uVar.iz() ? (byte) 1 : (byte) 2);
            uVar2.u((byte) 0);
            u(uVar.fx(), uVar2);
            if (com.bytedance.sdk.component.n.nr.u.u("csj")) {
                u(dw.getContext(), com.bytedance.sdk.openadsdk.core.multipro.nr.fx());
            }
            com.bytedance.sdk.openadsdk.gi.u.fx.u(uVar2.x());
            com.bytedance.sdk.component.n.nr.u.u(uVar2, "csj");
        }
    }

    public static void nr() {
        com.bytedance.sdk.component.n.nr.u.u(n.u, "csj");
    }

    public static void u(String str, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        if (list == null || list.size() == 0) {
            return;
        }
        list.size();
        if (com.bytedance.sdk.component.n.nr.u.u("csj")) {
            u(dw.getContext(), com.bytedance.sdk.openadsdk.core.multipro.nr.fx());
        }
        com.bytedance.sdk.component.n.nr.u.u("csj", str, u(list, com.bytedance.sdk.openadsdk.core.y.jk.fx(false)), z, map, jSONObject);
    }

    public static List<String> u(List<String> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList(list);
            list = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                String strReplace = (String) arrayList.get(i);
                if (!TextUtils.isEmpty(strReplace)) {
                    if (strReplace.contains("{OAID}") || strReplace.contains(LxEventReplace.__OAID__)) {
                        strReplace = strReplace.replace("{OAID}", str).replace(LxEventReplace.__OAID__, str);
                    }
                    list.add(strReplace);
                }
            }
        }
        return list;
    }

    public static void u(String str) {
        if (com.bytedance.sdk.component.n.nr.u.u("csj")) {
            u(dw.getContext(), com.bytedance.sdk.openadsdk.core.multipro.nr.fx());
        }
        com.bytedance.sdk.component.n.nr.u.u("csj", str);
    }
}
