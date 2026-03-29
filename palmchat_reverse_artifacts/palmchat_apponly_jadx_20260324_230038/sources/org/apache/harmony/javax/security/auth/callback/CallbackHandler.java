package org.apache.harmony.javax.security.auth.callback;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public interface CallbackHandler {
    void handle(Callback[] callbackArr) throws UnsupportedCallbackException, IOException;
}
