package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.platform.comapi.UIMsg;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class h extends com.vivo.push.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11200a;
    private String b;

    public h() {
        super(UIMsg.MsgDefine.MSG_ONLINE_DOWNLOAD);
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        dVar.a("MsgArriveCommand.MSG_TAG", this.f11200a);
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        dVar.a("MsgArriveCommand.NODE_INFO", this.b);
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        this.f11200a = dVar.a("MsgArriveCommand.MSG_TAG");
        this.b = dVar.a("MsgArriveCommand.NODE_INFO");
    }

    public h(String str) {
        this();
        this.f11200a = str;
    }

    public h(String str, String str2) {
        this(str);
        this.b = str2;
    }
}
