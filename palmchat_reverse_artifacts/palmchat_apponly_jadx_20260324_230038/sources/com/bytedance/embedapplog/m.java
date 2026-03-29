package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.jk;
import com.bytedance.embedapplog.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class m extends je<k> {
    public m() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.embedapplog.je
    public Intent fx(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }

    @Override // com.bytedance.embedapplog.je
    public jk.nr<k, String> u() {
        return new jk.nr<k, String>() { // from class: com.bytedance.embedapplog.m.1
            @Override // com.bytedance.embedapplog.jk.nr
            /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
            public k u(IBinder iBinder) {
                return k.u.u(iBinder);
            }

            @Override // com.bytedance.embedapplog.jk.nr
            public String u(k kVar) {
                if (kVar == null) {
                    return null;
                }
                return kVar.fx();
            }
        };
    }
}
