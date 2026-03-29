package com.zx.a.I8b7;

import android.text.TextUtils;
import com.zx.module.base.Listener;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class t3 implements o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f16866a = new AtomicBoolean(false);
    public final AtomicBoolean b = new AtomicBoolean(false);
    public Listener c;

    public static void a(t3 t3Var) throws Exception {
        t3Var.getClass();
        String str = m3.i;
        if (!m3.p) {
            l.c();
        }
        p1.f();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", 0);
        jSONObject.put("data", m3.a());
        String string = jSONObject.toString();
        t3Var.c.onMessage("MESSAGE_ON_ZXID_RECEIVED", string);
        if (TextUtils.equals(str, m3.i)) {
            return;
        }
        t3Var.c.onMessage("MESSAGE_ON_ZXID_CHANGED", string);
    }
}
