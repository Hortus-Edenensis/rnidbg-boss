package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class h94 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f17897a;
    public String b;
    public String c = rv2.h("bFWKQsRzI9d+ktdqxw44MA==");
    public String d = rv2.h("vWw3rdN6/HN94yy83HO8Lw==");
    public String e = rv2.h("Ha7IUc4OlbRIQFpw3FJeZw==");
    public String f = rv2.h("qFFOesfckPwVmbfqzGl5oBCLe9WD17E04n+Ic7C9fCw=");

    public h94(IBinder iBinder) {
        this.f17897a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public final String g(String str, String str2, String str3) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(this.f);
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeString(str3);
            this.f17897a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } catch (Throwable th) {
            try {
                p63.f("OppoAdvertisingInterface", "getIdByType error: " + th.getMessage());
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return "";
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public String t(Context context) throws RemoteException {
        return context == null ? "" : g(context.getPackageName(), u(context), this.c);
    }

    public final String u(Context context) {
        Signature[] signatureArr;
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(this.b)) {
            try {
                signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (PackageManager.NameNotFoundException e) {
                p63.f("OppoAdvertisingInterface", "packageName: " + packageName + " getPackageInfo error: " + e.getMessage());
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                        }
                        this.b = sb.toString();
                    }
                } catch (Throwable th) {
                    p63.f("OppoAdvertisingInterface", "package sign error: " + th.getMessage());
                }
            }
        }
        return this.b;
    }
}
