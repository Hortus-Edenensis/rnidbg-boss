package defpackage;

import com.zenmen.palmchat.messaging.smack.DomainHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class m40 {
    public static String a(String str) {
        return DomainHelper.j(str);
    }

    public static int b(String str) {
        DomainHelper.Domains domainsN = DomainHelper.n(str);
        return ((domainsN == DomainHelper.Domains.DOMAIN_SINGLECHAT || fu5.v(domainsN)) ? 1 : 0) ^ 1;
    }

    public static String c(String str) {
        return DomainHelper.j(str);
    }

    public static String d(String str) {
        return DomainHelper.j(str);
    }

    public static String e(String str) {
        return DomainHelper.p(str);
    }
}
