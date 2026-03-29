package com.oplus.tblplayer.exception;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class IPCException extends RuntimeException implements Parcelable {
    public static final Parcelable.Creator<IPCException> CREATOR = new Parcelable.Creator<IPCException>() { // from class: com.oplus.tblplayer.exception.IPCException.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPCException createFromParcel(Parcel parcel) {
            return new IPCException(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPCException[] newArray(int i) {
            return new IPCException[i];
        }
    };
    private static final int HAS_CAUSE = 1;
    private static final int NO_CAUSE = 0;
    private final String mClassName;

    public IPCException(Parcel parcel) {
        this(parcel.readString(), parcel.readString());
        int i = parcel.readInt();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i];
        for (int i2 = 0; i2 < i; i2++) {
            stackTraceElementArr[i2] = new StackTraceElement(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }
        setStackTrace(stackTraceElementArr);
        if (parcel.readInt() != 0) {
            initCause(new IPCException(parcel));
        }
    }

    public static IPCException toIPCException(Throwable th) {
        if (th == null) {
            return null;
        }
        if (th instanceof IPCException) {
            return (IPCException) th;
        }
        String name = th.getClass().getName();
        StackTraceElement[] stackTrace = th.getStackTrace();
        IPCException iPCException = new IPCException(name, th.getMessage());
        iPCException.setStackTrace(stackTrace);
        iPCException.initCause(toIPCException(th.getCause()));
        return iPCException;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getClassName() {
        return this.mClassName;
    }

    public IOException toIOException() {
        IOException iOException = new IOException("(" + this.mClassName + ")" + getMessage());
        iOException.initCause(getCause());
        iOException.setStackTrace(getStackTrace());
        return iOException;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mClassName);
        parcel.writeString(getMessage());
        StackTraceElement[] stackTrace = getStackTrace();
        if (stackTrace == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(stackTrace.length);
            for (StackTraceElement stackTraceElement : stackTrace) {
                parcel.writeString(stackTraceElement.getClassName());
                parcel.writeString(stackTraceElement.getMethodName());
                parcel.writeString(stackTraceElement.getFileName());
                parcel.writeInt(stackTraceElement.getLineNumber());
            }
        }
        Throwable cause = getCause();
        if (!(cause instanceof IPCException)) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            ((IPCException) cause).writeToParcel(parcel, i);
        }
    }

    public IPCException(String str, String str2) {
        super(str2);
        this.mClassName = str;
    }
}
