package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.jk;
import com.bytedance.embedapplog.ky;
import com.bytedance.embedapplog.o;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class iq extends je<o> {
    public iq() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.embedapplog.je
    public Intent fx(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    @Override // com.bytedance.embedapplog.je, com.bytedance.embedapplog.ky
    public ky.u nr(Context context) {
        u(context, context.getPackageName());
        return super.nr(context);
    }

    @Override // com.bytedance.embedapplog.je
    public jk.nr<o, String> u() {
        return new jk.nr<o, String>() { // from class: com.bytedance.embedapplog.iq.1
            @Override // com.bytedance.embedapplog.jk.nr
            /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
            public o u(IBinder iBinder) {
                return o.u.u(iBinder);
            }

            @Override // com.bytedance.embedapplog.jk.nr
            public String u(o oVar) {
                if (oVar == null) {
                    return null;
                }
                return oVar.u();
            }
        };
    }

    private void u(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            ti.u(e);
        }
    }
}
