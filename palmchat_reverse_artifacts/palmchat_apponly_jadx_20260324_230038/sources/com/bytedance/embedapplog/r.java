package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.jk;
import com.bytedance.embedapplog.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class r extends je<s> {
    public r() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.je
    public Intent fx(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }

    @Override // com.bytedance.embedapplog.je
    public jk.nr<s, String> u() {
        return new jk.nr<s, String>() { // from class: com.bytedance.embedapplog.r.1
            @Override // com.bytedance.embedapplog.jk.nr
            /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
            public s u(IBinder iBinder) {
                return s.u.u(iBinder);
            }

            @Override // com.bytedance.embedapplog.jk.nr
            public String u(s sVar) {
                if (sVar == null) {
                    return null;
                }
                return sVar.u();
            }
        };
    }
}
