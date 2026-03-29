package com.bytedance.adsdk.nr.nr;

import com.bytedance.adsdk.nr.nr.fx.u.a;
import com.bytedance.adsdk.nr.nr.fx.u.b;
import com.bytedance.adsdk.nr.nr.fx.u.fx;
import com.bytedance.adsdk.nr.nr.fx.u.iz;
import com.bytedance.adsdk.nr.nr.fx.u.jk;
import com.bytedance.adsdk.nr.nr.fx.u.n;
import com.bytedance.adsdk.nr.nr.fx.u.nr;
import com.bytedance.adsdk.nr.nr.fx.u.pn;
import com.bytedance.adsdk.nr.nr.fx.u.x;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    private static final com.bytedance.adsdk.nr.nr.fx.u u;
    private Deque<com.bytedance.adsdk.nr.nr.nr.u> b = new LinkedList();
    private com.bytedance.adsdk.nr.nr.nr.u fx;
    private final com.bytedance.adsdk.nr.nr.fx.u nr;
    private String pn;

    static {
        int i = 8;
        iz[] izVarArr = {new jk(), new b(), new a(), new nr(), new pn(), new com.bytedance.adsdk.nr.nr.fx.u.u(), new x(), new fx(), new n()};
        final com.bytedance.adsdk.nr.nr.fx.u uVar = new com.bytedance.adsdk.nr.nr.fx.u() { // from class: com.bytedance.adsdk.nr.nr.u.1
            @Override // com.bytedance.adsdk.nr.nr.fx.u
            public int u(String str, int i2, Deque<com.bytedance.adsdk.nr.nr.nr.u> deque) {
                return i2;
            }
        };
        while (i >= 0) {
            final iz izVar = izVarArr[i];
            i--;
            uVar = new com.bytedance.adsdk.nr.nr.fx.u() { // from class: com.bytedance.adsdk.nr.nr.u.2
                @Override // com.bytedance.adsdk.nr.nr.fx.u
                public int u(String str, int i2, Deque<com.bytedance.adsdk.nr.nr.nr.u> deque) {
                    return izVar.u(str, i2, deque, uVar);
                }
            };
        }
        u = uVar;
    }

    private u(String str, com.bytedance.adsdk.nr.nr.fx.u uVar) {
        this.nr = uVar;
        this.pn = str;
        try {
            u();
        } catch (Exception e) {
            throw new com.bytedance.adsdk.nr.u.nr(str, e);
        }
    }

    public static u u(String str) {
        return new u(str, u);
    }

    private void u() {
        int length = this.pn.length();
        int i = 0;
        while (i < length) {
            int iU = this.nr.u(this.pn, i, this.b);
            if (iU == i) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.pn.substring(0, i));
            }
            i = iU;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.bytedance.adsdk.nr.nr.nr.u uVarPollFirst = this.b.pollFirst();
            if (uVarPollFirst == null) {
                this.fx = com.bytedance.adsdk.nr.nr.pn.nr.u(arrayList, this.pn, i);
                this.b = null;
                return;
            }
            arrayList.add(0, uVarPollFirst);
        }
    }

    public <T> T u(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("default_key", jSONObject);
        return (T) u(map);
    }

    public <T> T u(Map<String, JSONObject> map) {
        return (T) this.fx.u(map);
    }
}
