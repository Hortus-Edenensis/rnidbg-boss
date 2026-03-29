package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.embedapplog.jk;
import com.bytedance.embedapplog.ky;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
abstract class je<SERVICE> implements ky {
    private ob<Boolean> nr = new ob<Boolean>() { // from class: com.bytedance.embedapplog.je.1
        @Override // com.bytedance.embedapplog.ob
        /* JADX INFO: renamed from: fx, reason: merged with bridge method [inline-methods] */
        public Boolean u(Object... objArr) {
            return Boolean.valueOf(pq.u((Context) objArr[0], je.this.u));
        }
    };
    private final String u;

    public je(String str) {
        this.u = str;
    }

    public abstract Intent fx(Context context);

    @Override // com.bytedance.embedapplog.ky
    public ky.u nr(Context context) {
        return u((String) new jk(context, fx(context), u()).u());
    }

    public abstract jk.nr<SERVICE, String> u();

    @Override // com.bytedance.embedapplog.ky
    public boolean u(Context context) {
        if (context == null) {
            return false;
        }
        return this.nr.nr(context).booleanValue();
    }

    private ky.u u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ky.u uVar = new ky.u();
        uVar.nr = str;
        return uVar;
    }
}
