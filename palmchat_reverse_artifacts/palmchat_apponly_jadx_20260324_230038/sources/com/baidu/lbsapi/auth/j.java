package com.baidu.lbsapi.auth;

import android.text.TextUtils;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class j extends Authenticator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f3375a;

    public j(i iVar) {
        this.f3375a = iVar;
    }

    @Override // java.net.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        if (!TextUtils.isEmpty(this.f3375a.g) && !TextUtils.isEmpty(this.f3375a.h)) {
            return new PasswordAuthentication(this.f3375a.g, this.f3375a.h.toCharArray());
        }
        b.a("Proxy Username or Password is null");
        return null;
    }
}
