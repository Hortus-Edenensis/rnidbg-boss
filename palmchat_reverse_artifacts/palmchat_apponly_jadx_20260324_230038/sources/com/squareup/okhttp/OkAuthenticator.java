package com.squareup.okhttp;

import com.squareup.okhttp.internal.Base64;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URL;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface OkAuthenticator {

    /* JADX INFO: compiled from: SearchBox */
    public static final class Challenge {
        private final String realm;
        private final String scheme;

        public Challenge(String str, String str2) {
            this.scheme = str;
            this.realm = str2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Challenge) {
                Challenge challenge = (Challenge) obj;
                if (challenge.scheme.equals(this.scheme) && challenge.realm.equals(this.realm)) {
                    return true;
                }
            }
            return false;
        }

        public String getRealm() {
            return this.realm;
        }

        public String getScheme() {
            return this.scheme;
        }

        public int hashCode() {
            return this.scheme.hashCode() + (this.realm.hashCode() * 31);
        }

        public String toString() {
            return this.scheme + " realm=\"" + this.realm + "\"";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Credential {
        private final String headerValue;

        private Credential(String str) {
            this.headerValue = str;
        }

        public static Credential basic(String str, String str2) {
            try {
                return new Credential("Basic " + Base64.encode((str + ":" + str2).getBytes("ISO-8859-1")));
            } catch (UnsupportedEncodingException unused) {
                throw new AssertionError();
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof Credential) && ((Credential) obj).headerValue.equals(this.headerValue);
        }

        public String getHeaderValue() {
            return this.headerValue;
        }

        public int hashCode() {
            return this.headerValue.hashCode();
        }

        public String toString() {
            return this.headerValue;
        }
    }

    Credential authenticate(Proxy proxy, URL url, List<Challenge> list) throws IOException;

    Credential authenticateProxy(Proxy proxy, URL url, List<Challenge> list) throws IOException;
}
