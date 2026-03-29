package com.lantern.auth.openapi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class LoginResult {
    public String mAuthCode;
    public int mLocalType;
    public String mMsg;
    public String mRemoteType;
    public int mRetCode = 10;
    public String mServerRetCd;

    public String toString() {
        return String.format("mRetCode %d, mLocalType %d, mRemoteType %s, mAuthCode %s, mMsg %s ", Integer.valueOf(this.mRetCode), Integer.valueOf(this.mLocalType), this.mRemoteType, this.mAuthCode, this.mMsg);
    }
}
