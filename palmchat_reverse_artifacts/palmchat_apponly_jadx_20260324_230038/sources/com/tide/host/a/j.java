package com.tide.host.a;

import android.text.TextUtils;
import com.tide.protocol.util.TdLogUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class j implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f10791a;
    public final /* synthetic */ k b;

    public j(k kVar, s sVar) {
        this.b = kVar;
        this.f10791a = sVar;
    }

    @Override // com.tide.host.a.s
    public final void a(Object obj) {
        c cVar;
        String str = (String) obj;
        try {
            if (this.b.e == null) {
                this.f10791a.a(13001, "Request succeeded responseFactory is null cannot parse");
            } else if (TextUtils.isEmpty(str)) {
                this.f10791a.a(13002, "Request succeeded but response is empty");
            } else {
                TdLogUtils.log("EncryptedPostRequest", "onSuccess before parse " + str);
                d dVar = (d) this.b.e.fromJson(str);
                if (dVar == null || dVar.f10786a != 0 || (cVar = dVar.c) == null) {
                    this.f10791a.a(13003, "Request succeeded but response is error");
                } else {
                    String str2 = cVar.f10785a;
                    if (TextUtils.isEmpty(str2)) {
                        this.f10791a.a(13004, "Request succeeded but response data value is null");
                    } else {
                        String strA = a.a(str2);
                        if (TextUtils.isEmpty(strA)) {
                            this.f10791a.a(13005, "Request succeeded Aes decrypt error, decryptedJson is null");
                        } else {
                            this.f10791a.a(this.b.g.fromJson(strA));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            this.f10791a.a(13006, "Failed to parse response: " + th.getMessage());
        }
    }

    @Override // com.tide.host.a.s
    public final void a(int i, String str) {
        if (k.a(this.b, i)) {
            k kVar = this.b;
            kVar.f10798a++;
            kVar.a(this.f10791a);
        } else {
            this.f10791a.a(13007, "Request failed http code is " + i + " and error is " + str);
        }
    }
}
