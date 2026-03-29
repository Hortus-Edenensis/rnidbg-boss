package defpackage;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class x51 implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21880a;

    public x51(String str) {
        this.f21880a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        k63.a("DefaultHostVerifier", "host:" + str + ",checkHost:" + this.f21880a);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f21880a, str);
    }
}
