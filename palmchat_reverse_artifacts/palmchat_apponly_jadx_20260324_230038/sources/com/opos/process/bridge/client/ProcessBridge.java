package com.opos.process.bridge.client;

import com.opos.process.bridge.dispatch.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ProcessBridge {
    private static final ProcessBridge ourInstance = new ProcessBridge();

    private ProcessBridge() {
    }

    public static ProcessBridge getInstance() {
        return ourInstance;
    }

    public void init() {
        a.a().b();
    }
}
