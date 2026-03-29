package com.zenmen.palmchat.utils.dao;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class DaoException extends Exception {
    public static final String DAO_INITIAL_ERROR_MESSAGE = "dao initial erro";
    public static final String JSON_EMPTY_EXCEPTION_MESSAGE = "json data empty";
    public static final String JSON_RESPONSE_PARSE_ERROR = "json response parse error";
    private int mDaoErrorCode;
    private String mDaoErrorMessage;

    public DaoException(int i, String str) {
        this.mDaoErrorCode = i;
        this.mDaoErrorMessage = str;
    }

    public int getDaoErrorCode() {
        return this.mDaoErrorCode;
    }

    public String getDaoErrorMessage() {
        return this.mDaoErrorMessage;
    }

    public DaoException(String str) {
        this.mDaoErrorMessage = str;
    }
}
