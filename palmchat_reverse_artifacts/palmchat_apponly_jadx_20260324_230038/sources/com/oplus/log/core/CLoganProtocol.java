package com.oplus.log.core;

import defpackage.gd7;
import defpackage.jg7;
import defpackage.k17;
import defpackage.ve7;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
class CLoganProtocol implements gd7 {
    private static final String LIBRARY_NAME = "opluslog";
    private static boolean sIsCloganOk;
    private boolean mIsLoganInit;
    private boolean mIsLoganOpen;
    private ve7 mLoganProtocolStatus;
    private Set<Integer> mArraySet = Collections.synchronizedSet(new HashSet());
    private long nativeConfigPointer = 0;

    static {
        try {
            if (!jg7.a(LIBRARY_NAME, CLoganProtocol.class)) {
                System.loadLibrary(LIBRARY_NAME);
            }
            sIsCloganOk = true;
        } catch (Throwable th) {
            if (k17.k()) {
                th.printStackTrace();
            }
            sIsCloganOk = false;
        }
    }

    private static native void clogan_debug(boolean z);

    private native void clogan_flush();

    private native int clogan_init(String str, String str2, int i, String str3, String str4);

    private native int clogan_open(String str);

    private native int clogan_write(int i, String str, long j, String str2, long j2);

    public static boolean isCloganSuccess() {
        return sIsCloganOk;
    }

    private void loganStatusCode(String str, int i) {
        if (i < 0) {
            if ("clogan_write".endsWith(str) && i != -4060) {
                if (this.mArraySet.contains(Integer.valueOf(i))) {
                    return;
                } else {
                    this.mArraySet.add(Integer.valueOf(i));
                }
            }
            ve7 ve7Var = this.mLoganProtocolStatus;
            if (ve7Var != null) {
                ve7Var.a(str, i);
            }
        }
    }

    @Override // defpackage.gd7
    public void logan_debug(boolean z) {
        if (this.mIsLoganInit && sIsCloganOk) {
            try {
                clogan_debug(z);
            } catch (UnsatisfiedLinkError e) {
                if (k17.k()) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // defpackage.gd7
    public void logan_flush() {
        if (this.mIsLoganOpen && sIsCloganOk) {
            try {
                clogan_flush();
            } catch (UnsatisfiedLinkError e) {
                if (k17.k()) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // defpackage.gd7
    public void logan_init(String str, String str2, int i, String str3, String str4) {
        if (this.mIsLoganInit) {
            return;
        }
        if (!sIsCloganOk) {
            loganStatusCode("logan_loadso", -5020);
            return;
        }
        try {
            int iClogan_init = clogan_init(str, str2, i, str3, str4);
            this.mIsLoganInit = true;
            loganStatusCode("clogan_init", iClogan_init);
        } catch (UnsatisfiedLinkError e) {
            if (k17.k()) {
                e.printStackTrace();
            }
            loganStatusCode("clogan_init", -1060);
        }
    }

    @Override // defpackage.gd7
    public void logan_open(String str) {
        if (this.mIsLoganInit && sIsCloganOk) {
            try {
                int iClogan_open = clogan_open(str);
                this.mIsLoganOpen = true;
                loganStatusCode("clogan_open", iClogan_open);
            } catch (UnsatisfiedLinkError e) {
                if (k17.k()) {
                    e.printStackTrace();
                }
                loganStatusCode("clogan_open", -2070);
            }
        }
    }

    @Override // defpackage.gd7
    public void logan_write(int i, String str, long j, String str2, long j2) {
        if (this.mIsLoganOpen && sIsCloganOk) {
            try {
                int iClogan_write = clogan_write(i, str, j, str2, j2);
                if (iClogan_write != -4010 || a.b) {
                    loganStatusCode("clogan_write", iClogan_write);
                }
            } catch (UnsatisfiedLinkError e) {
                if (k17.k()) {
                    e.printStackTrace();
                }
                loganStatusCode("clogan_write", -4060);
            }
        }
    }

    @Override // defpackage.gd7
    public void setOnLoganProtocolStatus(ve7 ve7Var) {
        this.mLoganProtocolStatus = ve7Var;
    }
}
