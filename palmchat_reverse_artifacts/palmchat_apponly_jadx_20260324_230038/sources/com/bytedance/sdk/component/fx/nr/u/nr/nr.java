package com.bytedance.sdk.component.fx.nr.u.nr;

import com.bytedance.sdk.component.fx.nr.t;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class nr {
    private boolean b;
    private boolean fx;
    private int nr = 0;
    private final List<t> u;

    public nr(List<t> list) {
        this.u = list;
    }

    private boolean nr(SSLSocket sSLSocket) {
        for (int i = this.nr; i < this.u.size(); i++) {
            if (this.u.get(i).u(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public t u(SSLSocket sSLSocket) throws IOException {
        t tVar;
        int i = this.nr;
        int size = this.u.size();
        while (true) {
            if (i >= size) {
                tVar = null;
                break;
            }
            tVar = this.u.get(i);
            if (tVar.u(sSLSocket)) {
                this.nr = i + 1;
                break;
            }
            i++;
        }
        if (tVar != null) {
            this.fx = nr(sSLSocket);
            com.bytedance.sdk.component.fx.nr.u.u.u.u(tVar, sSLSocket, this.b);
            return tVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.b + ", modes=" + this.u + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean u(IOException iOException) {
        this.b = true;
        if (!this.fx || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }
}
