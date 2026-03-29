package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.platform.comapi.UIMsg;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class x extends com.vivo.push.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f11214a;
    private long b;

    public x() {
        super(UIMsg.MsgDefine.MSG_ONLINE_UPDATA);
    }

    public final void a(HashMap<String, String> map) {
        this.f11214a = map;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        dVar.a("ReporterCommand.EXTRA_PARAMS", this.f11214a);
        dVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        this.f11214a = (HashMap) dVar.d("ReporterCommand.EXTRA_PARAMS");
        this.b = dVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "ReporterCommand（" + this.b + ")";
    }

    public x(long j) {
        this();
        this.b = j;
    }

    public final void d() {
        if (this.f11214a == null) {
            com.vivo.push.util.t.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("report message reportType:");
        sb.append(this.b);
        sb.append(",msgId:");
        String str = this.f11214a.get(com.heytap.mcssdk.constant.b.c);
        if (TextUtils.isEmpty(str)) {
            str = this.f11214a.get("message_id");
        }
        sb.append(str);
        com.vivo.push.util.t.d("ReporterCommand", sb.toString());
    }
}
