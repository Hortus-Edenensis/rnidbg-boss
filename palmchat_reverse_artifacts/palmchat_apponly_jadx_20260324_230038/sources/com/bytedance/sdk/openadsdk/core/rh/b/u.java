package com.bytedance.sdk.openadsdk.core.rh.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.fx.b;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.rh.jk;
import com.bytedance.sdk.openadsdk.core.rh.nr;
import com.bytedance.sdk.openadsdk.core.rh.t;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends jk implements nr {
    private static volatile u nr;
    private AtomicBoolean u = new AtomicBoolean(false);

    private u() {
    }

    public static u fx() {
        if (nr == null) {
            synchronized (u.class) {
                if (nr == null) {
                    nr = new u();
                }
            }
        }
        return nr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz() {
        try {
            AtomicBoolean atomicBoolean = this.u;
            if (atomicBoolean == null || atomicBoolean.getAndSet(true)) {
                return;
            }
            u(dw.getContext());
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void pn() {
        fx().b();
    }

    public void b() {
        x.nr(new a("pity_splopt") { // from class: com.bytedance.sdk.openadsdk.core.rh.b.u.1
            @Override // java.lang.Runnable
            public void run() {
                u.this.iz();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public String nr() {
        return MediationConstant.RIT_TYPE_SPLASH;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.jk
    public JSONObject nr(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("business_name", "common");
            jSONObject.put("business_type", 2);
            jSONObject.put("general_params", new JSONObject());
        } catch (Exception e) {
            e.getMessage();
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.jk
    public void u(int i, com.bytedance.sdk.openadsdk.core.rh.a aVar) {
        if (n.o().wi()) {
            try {
                Field[] declaredFields = aVar.fx().getClass().getDeclaredFields();
                for (int i2 = 0; i2 < declaredFields.length; i2++) {
                    declaredFields[i2].setAccessible(true);
                    declaredFields[i2].get(aVar.fx());
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.jk
    public boolean u() {
        return t.fx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("spl_load_strategy".equalsIgnoreCase(str)) {
            return b.u().c();
        }
        return com.bytedance.sdk.openadsdk.ats.b.u(nr()).get(str, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("spl_load_strategy".equalsIgnoreCase(str)) {
            b.u().my(str2);
        } else {
            com.bytedance.sdk.openadsdk.ats.b.u(nr()).put(str, str2);
        }
    }
}
