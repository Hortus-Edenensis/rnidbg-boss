package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.jk;
import com.bytedance.embedapplog.mv;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bl extends je<mv> {
    public bl() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.je
    public Intent fx(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }

    @Override // com.bytedance.embedapplog.je
    public jk.nr<mv, String> u() {
        return new jk.nr<mv, String>() { // from class: com.bytedance.embedapplog.bl.1
            @Override // com.bytedance.embedapplog.jk.nr
            /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
            public mv u(IBinder iBinder) {
                return mv.u.u(iBinder);
            }

            @Override // com.bytedance.embedapplog.jk.nr
            public String u(mv mvVar) {
                return mvVar.u();
            }
        };
    }
}
