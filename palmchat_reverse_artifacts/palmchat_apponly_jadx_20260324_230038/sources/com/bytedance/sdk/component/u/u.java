package com.bytedance.sdk.component.u;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.AnyThread;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.sdk.component.u.x;
import com.huawei.openalliance.ad.constant.bq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {
    protected String b;
    protected n fx;
    x iz;
    protected mv nr;
    protected Context u;
    private Handler x;
    protected volatile boolean pn = false;
    private final Map<String, x> n = new HashMap();

    public void fx() {
        this.iz.u();
        Iterator<x> it = this.n.values().iterator();
        while (it.hasNext()) {
            it.next().u();
        }
        nr().removeCallbacksAndMessages(null);
        this.pn = true;
    }

    public abstract Context getContext(jk jkVar);

    public void invokeMethod(final String str) {
        if (this.pn) {
            return;
        }
        nr().post(new Runnable() { // from class: com.bytedance.sdk.component.u.u.1
            @Override // java.lang.Runnable
            public void run() {
                my myVarU;
                if (u.this.pn) {
                    return;
                }
                try {
                    myVarU = u.this.u(new JSONObject(str));
                } catch (Exception e) {
                    a.nr("Exception thrown while parsing function.", e);
                    myVarU = null;
                }
                if (!my.u(myVarU)) {
                    u.this.u(myVarU);
                } else if (myVarU != null) {
                    u.this.nr(qq.u(new sx(myVarU.u, "Failed to parse invocation.")), myVarU);
                }
            }
        });
    }

    public Handler nr() {
        if (this.x == null) {
            this.x = new Handler(Looper.getMainLooper());
        }
        return this.x;
    }

    public abstract String u();

    public abstract void u(jk jkVar);

    @AnyThread
    public abstract void u(String str);

    public void u(Looper looper) {
        if (looper == null) {
            return;
        }
        this.x = new Handler(looper);
    }

    public void u(String str, my myVar) {
        u(str);
    }

    public final void nr(String str, my myVar) {
        JSONObject jSONObject;
        if (this.pn || TextUtils.isEmpty(myVar.iz)) {
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            a.u(new IllegalArgumentException("Illegal callback data: ".concat(str)));
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        u(k.u().u("__msg_type", bq.f.L).u("__callback_id", myVar.iz).u("__params", jSONObject).nr(), myVar);
    }

    @MainThread
    public final void u(my myVar) {
        if (this.pn) {
            return;
        }
        String strU = u();
        if (strU == null) {
            strU = "";
        }
        x xVarNr = nr(myVar.x);
        if (xVarNr == null) {
            if (this.nr != null) {
                u();
            }
            nr(qq.u(new sx(-4, "Namespace " + myVar.x + " unknown.")), myVar);
            return;
        }
        iz izVar = new iz();
        izVar.nr = strU;
        izVar.u = this.u;
        izVar.fx = xVarNr;
        try {
            x.u uVarU = xVarNr.u(myVar, izVar);
            if (uVarU == null) {
                nr(qq.u(new sx(-2, "Function " + myVar.b + " is not registered.")), myVar);
                return;
            }
            if (uVarU.u) {
                nr(uVarU.nr, myVar);
            }
        } catch (Exception e) {
            a.u("call finished with error, ".concat(String.valueOf(myVar)), e);
            nr(qq.u(e), myVar);
        }
    }

    private x nr(String str) {
        if (!TextUtils.equals(str, this.b) && !TextUtils.isEmpty(str)) {
            return this.n.get(str);
        }
        return this.iz;
    }

    public final void u(jk jkVar, dw dwVar) {
        this.u = getContext(jkVar);
        this.fx = jkVar.b;
        this.nr = jkVar.f5169a;
        this.iz = new x(jkVar, this, dwVar);
        this.b = jkVar.t;
        u(jkVar);
    }

    public final <T> void u(String str, T t) {
        if (this.pn) {
            return;
        }
        u("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + this.fx.u(t) + "}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public my u(JSONObject jSONObject) {
        String strOptString;
        if (this.pn) {
            return null;
        }
        String strOptString2 = jSONObject.optString("__callback_id");
        String strOptString3 = jSONObject.optString("func");
        try {
            String string = jSONObject.getString("__msg_type");
            String strValueOf = "";
            try {
                Object objOpt = jSONObject.opt("params");
                if (objOpt == null) {
                    strOptString = strValueOf;
                } else if (objOpt instanceof JSONObject) {
                    strOptString = String.valueOf((JSONObject) objOpt);
                } else {
                    if (objOpt instanceof String) {
                        strValueOf = (String) objOpt;
                    } else {
                        strValueOf = String.valueOf(objOpt);
                    }
                    strOptString = strValueOf;
                }
            } catch (Throwable unused) {
                strOptString = jSONObject.optString("params");
            }
            String string2 = jSONObject.getString("JSSDK");
            String strOptString4 = jSONObject.optString("namespace");
            return my.u().u(string2).nr(string).fx(strOptString3).b(strOptString).pn(strOptString2).iz(strOptString4).x(jSONObject.optString("__iframe_url")).u();
        } catch (JSONException e) {
            a.nr("Failed to create call.", e);
            return my.u(strOptString2, -1);
        }
    }
}
