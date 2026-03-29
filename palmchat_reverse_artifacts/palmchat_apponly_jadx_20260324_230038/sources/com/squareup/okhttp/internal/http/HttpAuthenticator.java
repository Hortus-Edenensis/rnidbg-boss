package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.OkAuthenticator;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class HttpAuthenticator {
    public static final OkAuthenticator SYSTEM_DEFAULT = new OkAuthenticator() { // from class: com.squareup.okhttp.internal.http.HttpAuthenticator.1
        private InetAddress getConnectToInetAddress(Proxy proxy, URL url) throws IOException {
            return (proxy == null || proxy.type() == Proxy.Type.DIRECT) ? InetAddress.getByName(url.getHost()) : ((InetSocketAddress) proxy.address()).getAddress();
        }

        @Override // com.squareup.okhttp.OkAuthenticator
        public OkAuthenticator.Credential authenticate(Proxy proxy, URL url, List<OkAuthenticator.Challenge> list) throws IOException {
            PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
            for (OkAuthenticator.Challenge challenge : list) {
                if ("Basic".equalsIgnoreCase(challenge.getScheme()) && (passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(url.getHost(), getConnectToInetAddress(proxy, url), url.getPort(), url.getProtocol(), challenge.getRealm(), challenge.getScheme(), url, Authenticator.RequestorType.SERVER)) != null) {
                    return OkAuthenticator.Credential.basic(passwordAuthenticationRequestPasswordAuthentication.getUserName(), new String(passwordAuthenticationRequestPasswordAuthentication.getPassword()));
                }
            }
            return null;
        }

        @Override // com.squareup.okhttp.OkAuthenticator
        public OkAuthenticator.Credential authenticateProxy(Proxy proxy, URL url, List<OkAuthenticator.Challenge> list) throws IOException {
            for (OkAuthenticator.Challenge challenge : list) {
                if ("Basic".equalsIgnoreCase(challenge.getScheme())) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                    PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), getConnectToInetAddress(proxy, url), inetSocketAddress.getPort(), url.getProtocol(), challenge.getRealm(), challenge.getScheme(), url, Authenticator.RequestorType.PROXY);
                    if (passwordAuthenticationRequestPasswordAuthentication != null) {
                        return OkAuthenticator.Credential.basic(passwordAuthenticationRequestPasswordAuthentication.getUserName(), new String(passwordAuthenticationRequestPasswordAuthentication.getPassword()));
                    }
                }
            }
            return null;
        }
    };

    private HttpAuthenticator() {
    }

    private static List<OkAuthenticator.Challenge> parseChallenges(RawHeaders rawHeaders, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < rawHeaders.length(); i++) {
            if (str.equalsIgnoreCase(rawHeaders.getFieldName(i))) {
                String value = rawHeaders.getValue(i);
                int iSkipWhitespace = 0;
                while (iSkipWhitespace < value.length()) {
                    int iSkipUntil = HeaderParser.skipUntil(value, iSkipWhitespace, " ");
                    String strTrim = value.substring(iSkipWhitespace, iSkipUntil).trim();
                    int iSkipWhitespace2 = HeaderParser.skipWhitespace(value, iSkipUntil);
                    if (!value.regionMatches(true, iSkipWhitespace2, "realm=\"", 0, 7)) {
                        break;
                    }
                    int i2 = iSkipWhitespace2 + 7;
                    int iSkipUntil2 = HeaderParser.skipUntil(value, i2, "\"");
                    String strSubstring = value.substring(i2, iSkipUntil2);
                    iSkipWhitespace = HeaderParser.skipWhitespace(value, HeaderParser.skipUntil(value, iSkipUntil2 + 1, ",") + 1);
                    arrayList.add(new OkAuthenticator.Challenge(strTrim, strSubstring));
                }
            }
        }
        return arrayList;
    }

    public static boolean processAuthHeader(OkAuthenticator okAuthenticator, int i, RawHeaders rawHeaders, RawHeaders rawHeaders2, Proxy proxy, URL url) throws IOException {
        String str;
        String str2;
        if (i == 401) {
            str = HttpHeaders.WWW_AUTHENTICATE;
            str2 = HttpHeaders.AUTHORIZATION;
        } else {
            if (i != 407) {
                throw new IllegalArgumentException();
            }
            str = HttpHeaders.PROXY_AUTHENTICATE;
            str2 = HttpHeaders.PROXY_AUTHORIZATION;
        }
        List<OkAuthenticator.Challenge> challenges = parseChallenges(rawHeaders, str);
        if (challenges.isEmpty()) {
            return false;
        }
        OkAuthenticator.Credential credentialAuthenticateProxy = rawHeaders.getResponseCode() == 407 ? okAuthenticator.authenticateProxy(proxy, url, challenges) : okAuthenticator.authenticate(proxy, url, challenges);
        if (credentialAuthenticateProxy == null) {
            return false;
        }
        rawHeaders2.set(str2, credentialAuthenticateProxy.getHeaderValue());
        return true;
    }
}
