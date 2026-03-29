package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.fn;
import com.bytedance.embedapplog.jk;
import com.bytedance.embedapplog.ky;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class zn extends je<fn> {
    final xh nr;
    final wu u;

    public zn() {
        super("com.hihonor.id");
        this.u = new wu();
        this.nr = new xh();
    }

    @Override // com.bytedance.embedapplog.je
    public Intent fx(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.bytedance.embedapplog.je, com.bytedance.embedapplog.ky
    public ky.u nr(Context context) {
        new jk(context, fx(context), u()).u();
        ky.u uVar = new ky.u();
        uVar.nr = this.u.nr();
        uVar.fx = this.nr.nr();
        return uVar;
    }

    @Override // com.bytedance.embedapplog.je, com.bytedance.embedapplog.ky
    public /* bridge */ /* synthetic */ boolean u(Context context) {
        return super.u(context);
    }

    @Override // com.bytedance.embedapplog.je
    public jk.nr<fn, String> u() {
        return new jk.nr<fn, String>() { // from class: com.bytedance.embedapplog.zn.1
            @Override // com.bytedance.embedapplog.jk.nr
            /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
            public fn u(IBinder iBinder) {
                return fn.u.u(iBinder);
            }

            @Override // com.bytedance.embedapplog.jk.nr
            public String u(fn fnVar) {
                if (fnVar == null) {
                    com.bytedance.sdk.component.utils.k.nr("honor# ", "service is null");
                    return null;
                }
                fnVar.u(zn.this.u);
                fnVar.nr(zn.this.nr);
                return "";
            }
        };
    }
}
