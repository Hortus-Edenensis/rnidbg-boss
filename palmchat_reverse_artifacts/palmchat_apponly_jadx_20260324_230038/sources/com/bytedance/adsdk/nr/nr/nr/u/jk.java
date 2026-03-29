package com.bytedance.adsdk.nr.nr.nr.u;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class jk implements com.bytedance.adsdk.nr.nr.nr.u {
    private com.bytedance.adsdk.nr.nr.u.u fx;
    private String nr;
    private com.bytedance.adsdk.nr.nr.nr.u[] u;

    public jk(String str) {
        this.nr = str;
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public String nr() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nr);
        sb.append("(");
        com.bytedance.adsdk.nr.nr.nr.u[] uVarArr = this.u;
        if (uVarArr != null && uVarArr.length > 0) {
            int i = 0;
            while (true) {
                com.bytedance.adsdk.nr.nr.nr.u[] uVarArr2 = this.u;
                if (i >= uVarArr2.length) {
                    break;
                }
                sb.append(uVarArr2[i].nr());
                sb.append(",");
                i++;
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void u(com.bytedance.adsdk.nr.nr.nr.u[] uVarArr) {
        this.u = uVarArr;
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        com.bytedance.adsdk.nr.nr.u.u uVar = new com.bytedance.adsdk.nr.nr.u.u();
        this.fx = uVar;
        uVar.u(this.nr);
        Object[] objArr = new Object[this.u.length];
        int i = 0;
        while (true) {
            com.bytedance.adsdk.nr.nr.nr.u[] uVarArr = this.u;
            if (i >= uVarArr.length) {
                this.fx.u(objArr);
                return com.bytedance.adsdk.nr.my.u(this.nr).u(map.get("default_key"), objArr);
            }
            com.bytedance.adsdk.nr.nr.nr.u uVar2 = uVarArr[i];
            if (uVar2 != null) {
                objArr[i] = uVar2.u(map);
            }
            i++;
        }
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public com.bytedance.adsdk.nr.nr.b.pn u() {
        return com.bytedance.adsdk.nr.nr.b.nr.METHOD;
    }
}
