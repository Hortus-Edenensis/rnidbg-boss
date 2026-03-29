package com.zenmen.square.comment.struct;

import defpackage.in2;
import defpackage.rw3;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class UnitedException extends IOException implements in2 {
    private int errorCode;
    private String errorMsg;
    private int retCode;

    public UnitedException() {
    }

    public static UnitedException businessException(String str) {
        return new UnitedException(10007, str);
    }

    public static UnitedException paramErrException(String str) {
        return new UnitedException(10000, str);
    }

    public static UnitedException unknownErrException(String str) {
        return new UnitedException(10000, str);
    }

    @Override // defpackage.in2
    public int getCode() {
        int i = this.errorCode;
        return i == 10007 ? this.retCode : i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // defpackage.in2
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.errorMsg;
    }

    public UnitedException(int i) {
        this.errorCode = i;
        this.errorMsg = rw3.a(Integer.valueOf(i));
    }

    public UnitedException(int i, int i2) {
        this.errorCode = i;
        this.errorMsg = rw3.a(Integer.valueOf(i));
    }

    public UnitedException(int i, String str) {
        super(str);
        this.errorCode = i;
        this.errorMsg = str;
    }

    public UnitedException(int i, int i2, String str) {
        super(str);
        this.errorCode = i;
        this.retCode = i2;
        this.errorMsg = str;
    }
}
