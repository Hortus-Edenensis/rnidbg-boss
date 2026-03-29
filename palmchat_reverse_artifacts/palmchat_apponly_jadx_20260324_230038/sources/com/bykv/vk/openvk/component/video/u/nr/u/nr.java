package com.bykv.vk.openvk.component.video.u.nr.u;

import android.content.Context;
import com.bykv.vk.openvk.component.video.u.nr.b;
import com.bytedance.sdk.component.jk.a;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr extends u {
    public final File u;

    @Override // com.bykv.vk.openvk.component.video.u.nr.u.u
    public File b(String str) {
        return pn(str);
    }

    @Override // com.bykv.vk.openvk.component.video.u.nr.u.u
    public File fx(String str) {
        return pn(str);
    }

    public void nr() {
        com.bykv.vk.openvk.component.video.u.nr.fx.u().nr();
        Context context = b.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.u.nr.nr.fx.u(context).u(1);
        }
        for (File file : this.u.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    public File pn(String str) {
        return new File(this.u, str);
    }

    public void u() {
        com.bykv.vk.openvk.component.video.u.fx.u.u(new a("clear") { // from class: com.bykv.vk.openvk.component.video.u.nr.u.nr.1
            @Override // java.lang.Runnable
            public void run() {
                nr.this.nr();
            }
        });
    }
}
