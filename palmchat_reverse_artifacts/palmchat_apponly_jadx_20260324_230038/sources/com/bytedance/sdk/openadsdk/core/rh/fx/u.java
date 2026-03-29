package com.bytedance.sdk.openadsdk.core.rh.fx;

import android.content.Context;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.ats.b;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.rh.a;
import com.bytedance.sdk.openadsdk.core.rh.jk;
import com.bytedance.sdk.openadsdk.core.rh.nr;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends jk implements nr {
    private static volatile u u;
    private AtomicBoolean nr = new AtomicBoolean(false);

    private u() {
    }

    public static String b() {
        return "q_" + Calendar.getInstance().get(11) + (o.b(dw.getContext()) ? RXScreenCaptureService.KEY_WIDTH : "c");
    }

    public static u fx() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public String nr() {
        return "network";
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.jk
    public void u(int i, a aVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.jk
    public JSONObject nr(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.jk
    public boolean u() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public String u(String str) {
        return b.u(nr()).get(b(), "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public void u(String str, String str2) {
        b.u(nr()).put(str, str2);
    }
}
