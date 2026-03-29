package com.zenmen.palmchat.utils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ServerException extends Exception {
    public static final String NETWORK_REQUEST_ERROR_MESSAGE = "network request error";
    public static final String NETWORK_REQUEST_TIMEOUT_MESSAGE = "request timeout";
    private int mServerErrorCode;
    private String mServerErrorMessage;

    public ServerException(int i, String str) {
        this.mServerErrorCode = i;
        this.mServerErrorMessage = str;
    }

    public int getServerErrorCode() {
        return this.mServerErrorCode;
    }

    public String getServerErrorMessage() {
        return this.mServerErrorMessage;
    }

    public ServerException(String str) {
        this.mServerErrorMessage = str;
    }
}
