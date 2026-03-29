package org.apache.harmony.javax.security.sasl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public interface SaslServer {
    void dispose() throws SaslException;

    byte[] evaluateResponse(byte[] bArr) throws SaslException;

    String getAuthorizationID();

    String getMechanismName();

    Object getNegotiatedProperty(String str);

    boolean isComplete();

    byte[] unwrap(byte[] bArr, int i, int i2) throws SaslException;

    byte[] wrap(byte[] bArr, int i, int i2) throws SaslException;
}
