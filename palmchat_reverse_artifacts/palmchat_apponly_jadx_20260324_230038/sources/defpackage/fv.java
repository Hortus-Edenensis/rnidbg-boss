package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class fv extends Binder {
    public static final int b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<Bundle> f17606a;

    static {
        b = g86.f17680a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536;
    }

    public fv(List<Bundle> list) {
        this.f17606a = ImmutableList.copyOf((Collection) list);
    }

    public static ImmutableList<Bundle> a(IBinder iBinder) {
        int i;
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        int i2 = 1;
        int i3 = 0;
        while (i2 != 0) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i3);
                try {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (true) {
                        i = parcelObtain2.readInt();
                        if (i == 1) {
                            aVarBuilder.a((Bundle) vh.e(parcelObtain2.readBundle()));
                            i3++;
                        }
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    i2 = i;
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        return aVarBuilder.e();
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, @Nullable Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        if (parcel2 == null) {
            return false;
        }
        int size = this.f17606a.size();
        int i3 = parcel.readInt();
        while (i3 < size && parcel2.dataSize() < b) {
            parcel2.writeInt(1);
            parcel2.writeBundle(this.f17606a.get(i3));
            i3++;
        }
        parcel2.writeInt(i3 < size ? 2 : 0);
        return true;
    }
}
