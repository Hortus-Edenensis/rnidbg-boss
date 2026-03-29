package org.conscrypt;

import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public interface ConscryptHostnameVerifier {
    boolean verify(String str, SSLSession sSLSession);
}
