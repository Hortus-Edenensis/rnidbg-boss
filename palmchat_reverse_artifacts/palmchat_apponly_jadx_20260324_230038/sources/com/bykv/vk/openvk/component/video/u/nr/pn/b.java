package com.bykv.vk.openvk.component.video.u.nr.pn;

import android.text.TextUtils;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b implements nr {
    private l u;

    public b() {
        this.u = null;
        this.u = com.bykv.vk.openvk.component.video.api.fx.fx();
    }

    @Override // com.bykv.vk.openvk.component.video.u.nr.pn.nr
    public u u(pn pnVar) throws IOException {
        s.u uVar = new s.u();
        try {
            Map<String, String> map = pnVar.pn;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        uVar.nr(key, value);
                    }
                }
            }
            my myVarNr = this.u.u(uVar.u(pnVar.nr).u().nr()).nr();
            myVarNr.fx();
            return new iz(myVarNr, pnVar);
        } catch (Throwable unused) {
            return null;
        }
    }
}
