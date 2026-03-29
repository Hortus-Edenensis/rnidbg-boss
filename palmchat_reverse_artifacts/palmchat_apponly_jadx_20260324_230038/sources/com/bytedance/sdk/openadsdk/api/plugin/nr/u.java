package com.bytedance.sdk.openadsdk.api.plugin.nr;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements HostnameVerifier {
    public static final u u = new u();
    private static final Pattern nr = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private u() {
    }

    private boolean fx(String str, X509Certificate x509Certificate) {
        String strU;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listU = u(x509Certificate, 2);
        int size = listU.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (u(lowerCase, listU.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (strU = new nr(x509Certificate.getSubjectX500Principal()).u("cn")) == null) {
            return false;
        }
        return u(lowerCase, strU);
    }

    private boolean nr(String str, X509Certificate x509Certificate) {
        List<String> listU = u(x509Certificate, 7);
        int size = listU.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(listU.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean u(String str, X509Certificate x509Certificate) {
        return u(str) ? nr(str, x509Certificate) : fx(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return u(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private static boolean u(String str) {
        return nr.matcher(str).matches();
    }

    private static List<String> u(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private boolean u(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String strSubstring = lowerCase.substring(1);
            if (!str.endsWith(strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
