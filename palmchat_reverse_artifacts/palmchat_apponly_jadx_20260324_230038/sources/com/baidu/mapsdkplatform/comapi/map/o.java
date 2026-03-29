package com.baidu.mapsdkplatform.comapi.map;

import android.os.Message;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f3988a;

    public void a(n nVar) {
        this.f3988a = nVar;
    }

    public void b(n nVar) {
        this.f3988a = null;
    }

    public void a(Message message) {
        if (message.what != 65289) {
            return;
        }
        int i = message.arg1;
        if (i != 12 && i != 101 && i != 102) {
            switch (i) {
            }
            return;
        }
        n nVar = this.f3988a;
        if (nVar != null) {
            nVar.a(i, message.arg2);
        }
    }
}
