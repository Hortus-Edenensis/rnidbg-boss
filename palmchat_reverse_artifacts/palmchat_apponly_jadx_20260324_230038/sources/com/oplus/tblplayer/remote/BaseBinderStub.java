package com.oplus.tblplayer.remote;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tblplayer.exception.IPCException;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ParcelUtils;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseBinderStub extends Binder {
    private static final String TAG = "BaseBinderStub";
    protected static final Object UNSET_CODE = new Object();

    public boolean execTransactInternal(int i, Parcel parcel, Parcel parcel2) throws IOException {
        Object objOnTransactInternal = onTransactInternal(i, ParcelUtils.readParcels(parcel));
        if (objOnTransactInternal == UNSET_CODE || parcel2 == null) {
            return false;
        }
        ParcelUtils.writeObject(parcel2, objOnTransactInternal);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    @Override // android.os.Binder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTransact(int i, @NonNull Parcel parcel, @Nullable Parcel parcel2, int i2) throws RemoteException {
        String interfaceDescriptor = getInterfaceDescriptor();
        try {
        } catch (RemoteException e) {
            e = e;
            LogUtil.d(TAG, "onTransact: Caught a Exception is ", e);
            if ((i2 & 1) == 0) {
                LogUtil.d(TAG, e instanceof RemoteException ? "Binder call failed." : "Caught a RuntimeException from the binder stub implementation.", e);
            } else {
                parcel2.setDataSize(0);
                parcel2.setDataPosition(0);
                ParcelUtils.writeException(parcel2, IPCException.toIPCException(e));
            }
        } catch (IOException e2) {
            e = e2;
            LogUtil.d(TAG, "onTransact: Caught a Exception is ", e);
            if ((i2 & 1) == 0) {
            }
        } catch (Error e3) {
            e = e3;
            LogUtil.d(TAG, "onTransact: Caught a Exception is ", e);
            if ((i2 & 1) == 0) {
            }
        } catch (RuntimeException e4) {
            e = e4;
            LogUtil.d(TAG, "onTransact: Caught a Exception is ", e);
            if ((i2 & 1) == 0) {
            }
        }
        if (i == 1598968902) {
            parcel2.writeString(interfaceDescriptor);
            return true;
        }
        if (i < 1 || i > 16777215) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(interfaceDescriptor);
        if (parcel2 != null) {
            ParcelUtils.writeNoException(parcel2);
        }
        if (execTransactInternal(i, parcel, parcel2)) {
            return true;
        }
        throw new UnsupportedOperationException("Unsupport Method, class: " + getClass().getName() + "code: " + i);
    }

    public Object onTransactInternal(int i, Object... objArr) throws IOException {
        return UNSET_CODE;
    }
}
