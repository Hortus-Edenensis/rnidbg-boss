package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.embedapplog.jk;
import com.bytedance.embedapplog.ky;
import com.bytedance.embedapplog.l;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class wj extends je<l> {
    private final Context u;

    public wj(Context context) {
        super("com.coolpad.deviceidsupport");
        this.u = context;
    }

    @Override // com.bytedance.embedapplog.je
    public Intent fx(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.bytedance.embedapplog.je, com.bytedance.embedapplog.ky
    public ky.u nr(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                ky.u uVar = new ky.u();
                uVar.nr = string;
                return uVar;
            }
        } catch (Throwable unused) {
        }
        return super.nr(context);
    }

    @Override // com.bytedance.embedapplog.je, com.bytedance.embedapplog.ky
    public /* bridge */ /* synthetic */ boolean u(Context context) {
        return super.u(context);
    }

    @Override // com.bytedance.embedapplog.je
    public jk.nr<l, String> u() {
        return new jk.nr<l, String>() { // from class: com.bytedance.embedapplog.wj.1
            @Override // com.bytedance.embedapplog.jk.nr
            /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
            public l u(IBinder iBinder) {
                return l.u.u(iBinder);
            }

            @Override // com.bytedance.embedapplog.jk.nr
            public String u(l lVar) {
                if (lVar == null) {
                    return null;
                }
                return lVar.nr(wj.this.u.getPackageName());
            }
        };
    }
}
