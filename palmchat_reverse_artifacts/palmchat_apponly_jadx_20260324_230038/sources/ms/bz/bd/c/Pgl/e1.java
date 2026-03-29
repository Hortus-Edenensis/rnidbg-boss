package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import com.umeng.analytics.pro.dn;
import java.security.MessageDigest;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import ms.bz.bd.c.Pgl.pblk;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19311a;
    public String b;
    public f1 c;
    public ServiceConnection d;

    /* JADX INFO: compiled from: SearchBox */
    public class pgla implements ServiceConnection {
        public pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e1.this.c = new f1(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            e1.this.c = null;
        }
    }

    public e1(Context context) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ca2e07", new byte[]{93, 86, 104, 53});
        this.d = new pgla();
        this.f19311a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(f1 f1Var, String str) {
        Signature[] signatureArr;
        String string;
        String packageName = this.f19311a.getPackageName();
        String string2 = null;
        if (this.b == null) {
            try {
                signatureArr = this.f19311a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception unused) {
                signatureArr = null;
            }
            if (signatureArr == null || signatureArr.length <= 0) {
                string = null;
                this.b = string;
            } else {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4ce5a3", new byte[]{22, 73, 55, 16}));
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    }
                } catch (Exception unused2) {
                }
                this.b = string;
            }
        }
        String str2 = this.b;
        f1Var.getClass();
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a6c50e", new byte[]{115, 59, 29, 15, 7, 119, 123, 3, 51, 117, 62, 59, 0, 68, 1, 123, 102, 89, 27, 74, 96, 49, 30, 104, 43}));
                parcelObtain.writeString(packageName);
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str);
                f1Var.f19313a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string2 = parcelObtain2.readString();
            } catch (Exception unused3) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "44277e", new byte[]{42, 38, 72});
            }
            return string2;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    public final void c(pblk.pblb pblbVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e6504b", new byte[]{87, 53, 72, 74, 4, 97, 38, 5, 113, 110, 52, 59, 72, 4, 38, 116, 111, 25, 80, 104, 102, 49, 71, 64}));
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a9e075", new byte[]{115, 52, 27, 10, 0, 39, 123, 12, 53, 112, 62, 52, 6, 65, 6, 43, 102}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e4b4d6", new byte[]{119, 57, 28, dn.l, 83, 36, ByteCompanionObject.MAX_VALUE, 1, 50, 116, 58, 57, 1, 69, 85, 40, 98, 91, 26, 96, 113, 56, 5, 73, 93, 56, 85, 16, 33, 114, 125, 53, 20})));
        intent.setAction((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a55839", new byte[]{113, 52, 82, 69, 3, 32, 44, 23, 107, 101, 62, Utf8.REPLACEMENT_BYTE, 67, 85, 24, 47, 114, 90, 107, 120, 117, 57, 79, 72, 66, 1, 82, 49, 74, 87, 89, 19, 121, ByteCompanionObject.MAX_VALUE, 41, 28, 84, Base64.padSymbol, 71, 77}));
        boolean z = false;
        try {
            if (this.f19311a.bindService(intent, this.d, 1)) {
                try {
                    try {
                        SystemClock.sleep(3000L);
                    } catch (Exception unused) {
                    }
                    f1 f1Var = this.c;
                    if (f1Var != null) {
                        String strA = a(f1Var, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c16ccb", new byte[]{93, 6, 108, 51}));
                        if (pblbVar != null) {
                            pblbVar.u(strA);
                        }
                    }
                    z = true;
                } catch (Throwable unused2) {
                    z = true;
                    try {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b8dc63", new byte[]{124, 42});
                        if (!z) {
                            return;
                        }
                    } finally {
                        if (z) {
                            this.f19311a.unbindService(this.d);
                        }
                    }
                }
            }
            if (!z) {
            }
        } catch (Throwable unused3) {
        }
    }
}
