package com.huawei.hms.ads;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class fi {
    private static final String Code = "HiAdSDKLog";
    private static final int I = 10;
    private static final String V = "HiAdSDK.";
    private static fm Z = fn.Code();
    private String C;
    private int B = 4;
    private boolean S = false;

    private fo I(int i, String str, String str2) {
        fo foVar = new fo(this.C, i, str);
        foVar.Code(str2);
        return foVar;
    }

    public fm Code() {
        return Z;
    }

    public void V(int i, String str, String str2) {
        if (Code(i)) {
            String str3 = V + str;
            Z.Code(I(i, str3, str2), i, str3);
        }
    }

    public void Code(int i, String str, String str2) {
        this.B = i;
        this.C = str2;
        Z.Code(str, Code);
        this.S = true;
    }

    public void Code(int i, String str, String str2, Throwable th) {
        if (th != null) {
            Code(i);
        }
    }

    public void Code(int i, String str, Throwable th) {
        if (th != null) {
            Code(i);
        }
    }

    public void Code(String str, String str2) {
        Z.Code(I(4, str, str2), 4, str);
    }

    public boolean Code(int i) {
        return this.S && i >= this.B;
    }
}
