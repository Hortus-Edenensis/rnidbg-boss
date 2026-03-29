package org.apache.harmony.javax.security.sasl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public interface SaslClient {
    void dispose() throws SaslException;

    byte[] evaluateChallenge(byte[] bArr) throws SaslException;

    String getMechanismName();

    Object getNegotiatedProperty(String str);

    boolean hasInitialResponse();

    boolean isComplete();

    byte[] unwrap(byte[] bArr, int i, int i2) throws SaslException;

    byte[] wrap(byte[] bArr, int i, int i2) throws SaslException;
}
