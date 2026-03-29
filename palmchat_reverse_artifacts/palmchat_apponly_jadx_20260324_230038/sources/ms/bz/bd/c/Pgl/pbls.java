package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.lang.reflect.Method;
import java.util.Iterator;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pbls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19335a = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "c2aab3", new byte[]{94, 3, 34, 26, 78, 33, 100});

    /* JADX WARN: Removed duplicated region for block: B:31:0x00fd A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context) {
        boolean z;
        boolean z2;
        Bundle bundle;
        PackageManager packageManager = context.getPackageManager();
        IBinder iBinder = null;
        if (packageManager == null) {
            z = false;
        } else {
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(new Intent((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3fa265", new byte[]{35, 106, 22, 84, 6, 43, 52, 9, 57, 108, 54, 97, 28, 82, 71, 35, 51, 83, 57, 109, 44, 42, Utf8.REPLACEMENT_BYTE, 103, 32, 12}), (Uri) null), 128).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.applicationInfo.metaData) != null && bundle.get((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "12ecdd", new byte[]{56, 32, 25, 4, 94, 119, Utf8.REPLACEMENT_BYTE, 26, 58, 37, 37, 34, 5, 30, 84, 125})) != null) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        if (!z) {
            String packageName = context.getPackageName();
            String str = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9dba41", new byte[]{41, 101, 5, 28, 29, 47, 46, 92});
            try {
                Method declaredMethod = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "048ac6", new byte[]{32, 56, 79, 7, 83, 40, 55, 91, 102, 34, 111, 5, 78, 7, 74, 40, 48, 16, 68, 48, 47, 55, 76, 16, 78})).getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7081bd", new byte[]{33, 55, 95, 118, 88, 97, 34, 24, 106, 100}), String.class);
                declaredMethod.setAccessible(true);
                iBinder = (IBinder) declaredMethod.invoke(null, str);
            } catch (Exception unused) {
            }
            if (iBinder == null) {
                z2 = false;
                if (!z2) {
                    return false;
                }
            } else {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(f19335a);
                    parcelObtain.writeInt(2);
                    parcelObtain.writeString(packageName);
                    parcelObtain.writeStrongBinder(new Binder());
                } catch (Throwable unused2) {
                }
                if (iBinder.transact(1598837584, parcelObtain, parcelObtain2, 0)) {
                    parcelObtain2.readException();
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    z2 = true;
                    if (!z2) {
                    }
                }
                parcelObtain.recycle();
                parcelObtain2.recycle();
                z2 = false;
                if (!z2) {
                }
            }
        }
        return true;
    }
}
