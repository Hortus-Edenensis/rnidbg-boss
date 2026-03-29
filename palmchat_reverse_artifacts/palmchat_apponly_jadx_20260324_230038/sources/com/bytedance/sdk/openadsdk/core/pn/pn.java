package com.bytedance.sdk.openadsdk.core.pn;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.qq.s;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b3, code lost:
    
        if (r3 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b5, code lost:
    
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bc, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c8, code lost:
    
        if ((r10.bc() + r4) >= java.lang.System.currentTimeMillis()) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ca, code lost:
    
        if (r11 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cc, code lost:
    
        r10 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ce, code lost:
    
        r10 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d0, code lost:
    
        com.bytedance.sdk.openadsdk.core.pn.b.pn.u(r10).u(r9.b());
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e3, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e4, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar, boolean z) {
        boolean z2;
        if (!dw.nr().nr(nrVar.b())) {
            return true;
        }
        if (bcVar == null) {
            s.u().nr(3);
            return false;
        }
        String strDw = nrVar.dw();
        long jGi = bcVar.gi();
        String strM = bcVar.m();
        try {
            if (!TextUtils.isEmpty(strDw)) {
                JSONObject jSONObjectU = com.bytedance.sdk.openadsdk.core.fx.iz.u(new JSONObject(strDw), false, true);
                if (jSONObjectU != null) {
                    kj.u uVarU = kj.u.u(jSONObjectU, nrVar, null);
                    com.bytedance.sdk.openadsdk.core.kj.u uVar = uVarU.n;
                    if (uVar != null) {
                        uVar.u(jSONObjectU);
                        List<bc> listNr = uVarU.n.nr();
                        if (listNr != null) {
                            Iterator<bc> it = listNr.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z2 = false;
                                    break;
                                }
                                bc next = it.next();
                                if (TextUtils.isEmpty(next.m())) {
                                    s.u().nr(2);
                                    return false;
                                }
                                if (!next.pb()) {
                                    s.u().nr(5);
                                    return false;
                                }
                                if (TextUtils.equals(next.m(), strM)) {
                                    bcVar.rh(next.ir());
                                    z2 = true;
                                    break;
                                }
                            }
                        } else {
                            s.u().nr(1);
                            return false;
                        }
                    } else {
                        s.u().nr(1);
                        return false;
                    }
                } else {
                    s.u().nr(1);
                    return false;
                }
            } else {
                s.u().nr(1);
                return false;
            }
        } catch (Exception unused) {
            s.u().nr(1000);
            return false;
        }
    }
}
