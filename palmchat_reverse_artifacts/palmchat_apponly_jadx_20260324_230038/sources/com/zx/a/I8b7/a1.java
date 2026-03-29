package com.zx.a.I8b7;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.gdt.action.ActionUtils;
import com.umeng.analytics.pro.dn;
import com.wifi.adsdk.utils.LxAdOSUtils;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16767a;
    public static volatile a1 b = null;
    public static Context c = null;
    public static boolean d = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        boolean a(Context context);

        String b(Context context);

        boolean c(Context context);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements a {
        public static String f = null;
        public static boolean g = false;
        public static boolean h = false;
        public static final CountDownLatch i = new CountDownLatch(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16768a;
        public final String b;
        public final String c;
        public final String d;
        public e e;

        public b(String str, String str2, String str3, String str4) {
            this.f16768a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        public int a() {
            return 1;
        }

        public String b() {
            return null;
        }

        @Override // com.zx.a.I8b7.a1.a
        public boolean c(Context context) {
            if (h) {
                return g;
            }
            boolean z = false;
            if (context == null || TextUtils.isEmpty(this.f16768a)) {
                g = false;
            } else {
                try {
                    PackageInfo packageInfoA = i3.a(this.f16768a, 0);
                    if (Build.VERSION.SDK_INT >= 28) {
                        if (packageInfoA != null) {
                            if (packageInfoA.getLongVersionCode() >= 1) {
                                return true;
                            }
                        }
                        return false;
                    }
                    if (packageInfoA != null && packageInfoA.versionCode >= 1) {
                        z = true;
                    }
                    g = z;
                } catch (Throwable unused) {
                    return false;
                }
            }
            h = true;
            return g;
        }

        public String d(Context context) {
            return null;
        }

        public String e(Context context) {
            return null;
        }

        @Override // com.zx.a.I8b7.a1.a
        public boolean a(Context context) {
            if (context == null || TextUtils.isEmpty(this.f16768a)) {
                return false;
            }
            if (this.e == null) {
                this.e = new e(this.d, i);
            }
            Intent intent = new Intent();
            if (TextUtils.isEmpty(this.b)) {
                intent.setPackage(this.f16768a);
            } else {
                intent.setComponent(new ComponentName(this.f16768a, this.b));
            }
            if (!TextUtils.isEmpty(this.c)) {
                intent.setAction(this.c);
            }
            return this.e.a(context, intent);
        }

        @Override // com.zx.a.I8b7.a1.a
        public String b(Context context) {
            e eVar;
            d dVar;
            e eVar2;
            if (!TextUtils.isEmpty(f) || (eVar = this.e) == null || (dVar = eVar.f16771a) == null) {
                return f;
            }
            try {
                String strA = dVar.a(d(context), e(context), b(), a());
                f = strA;
                if (!TextUtils.isEmpty(strA) && (eVar2 = this.e) != null) {
                    context.unbindService(eVar2);
                }
            } catch (Throwable unused) {
            }
            return f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements a {
        public static String e = null;
        public static boolean f = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16769a;
        public String b;
        public String[] c;
        public boolean d = false;

        public c(String str, String str2) {
            this.f16769a = str;
            this.b = str2;
        }

        @Override // com.zx.a.I8b7.a1.a
        public boolean a(Context context) {
            return true;
        }

        @Override // com.zx.a.I8b7.a1.a
        public String b(Context context) {
            Cursor cursorQuery;
            if (TextUtils.isEmpty(e)) {
                StringBuilder sbA = f3.a("content://");
                sbA.append(this.f16769a);
                sbA.append("/");
                sbA.append(this.b);
                try {
                    cursorQuery = context.getContentResolver().query(Uri.parse(sbA.toString()), null, null, this.c, null);
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.moveToFirst();
                            e = cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                        } catch (Throwable unused) {
                            try {
                                e = null;
                                return e;
                            } finally {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                    cursorQuery = null;
                }
                if (cursorQuery != null) {
                }
            }
            return e;
        }

        @Override // com.zx.a.I8b7.a1.a
        public boolean c(Context context) {
            if (this.d) {
                return f;
            }
            if (context == null) {
                return false;
            }
            try {
                PackageManager packageManagerC = w3.c(context);
                f = (packageManagerC == null || packageManagerC.resolveContentProvider(this.f16769a, 0) == null) ? false : true;
            } catch (Throwable unused) {
                f = false;
            }
            this.d = true;
            return f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IBinder f16770a;
        public String b;

        public d(IBinder iBinder, String str) {
            this.f16770a = iBinder;
            this.b = str;
        }

        public String a(String str, String str2, String str3, int i) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken(this.b);
                    if (!TextUtils.isEmpty(str)) {
                        parcelObtain.writeString(str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        parcelObtain.writeString(str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        parcelObtain.writeString(str3);
                    }
                    this.f16770a.transact(i, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (Exception unused) {
                    return "";
                }
            } catch (Throwable unused2) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return "";
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f16770a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f16771a;
        public String b;
        public CountDownLatch c;
        public IBinder d;

        public e(String str, CountDownLatch countDownLatch) {
            this.b = str;
            this.c = countDownLatch;
        }

        public boolean a(Context context, Intent intent) {
            d dVar;
            if (this.f16771a != null) {
                return true;
            }
            try {
                boolean zBindService = context.bindService(intent, this, 1);
                this.c.await(1L, TimeUnit.SECONDS);
                IBinder iBinder = this.d;
                String str = this.b;
                if (iBinder == null) {
                    dVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(str);
                    dVar = iInterfaceQueryLocalInterface instanceof d ? (d) iInterfaceQueryLocalInterface : new d(iBinder, str);
                }
                this.f16771a = dVar;
                return zBindService;
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.d = iBinder;
                this.c.countDown();
            } catch (Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f16771a = null;
            this.d = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f extends b {
        public f() {
            super(a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQ="), a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQuU3VwcGxlbWVudGFyeURJRFNlcnZpY2U="), a("Y29tLmFzdXMubXNhLmFjdGlvbi5BQ0NFU1NfRElE"), a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQuSURpZEFpZGxJbnRlcmZhY2U="));
        }

        @Override // com.zx.a.I8b7.a1.b
        public int a() {
            return 2;
        }

        public static String a(String str) {
            return new String(Base64.decode(str, 0));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g extends b {
        public g() {
            super("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService", null, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }

        @Override // com.zx.a.I8b7.a1.b
        public int a() {
            return 2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h extends b {
        public h() {
            super("com.huawei.hwid", null, "com.uodis.opendevice.OPENIDS_SERVICE", "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i extends c {
        public i() {
            super("com.meizu.flyme.openidsdk", "");
        }

        @Override // com.zx.a.I8b7.a1.c, com.zx.a.I8b7.a1.a
        public String b(Context context) {
            this.c = new String[]{"oaid"};
            return super.b(context);
        }

        @Override // com.zx.a.I8b7.a1.c, com.zx.a.I8b7.a1.a
        public boolean c(Context context) {
            if (super.c(context)) {
                c.f = true;
            } else {
                try {
                    Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"support"}, null);
                    if (cursorQuery == null) {
                        return false;
                    }
                    cursorQuery.moveToFirst();
                    int columnIndex = cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT);
                    if (columnIndex >= 0) {
                        String string = cursorQuery.getString(columnIndex);
                        if (TextUtils.isEmpty(string)) {
                            return false;
                        }
                        c.f = "0".equals(string);
                    } else {
                        c.f = false;
                    }
                } catch (Throwable unused) {
                    c.f = false;
                    return false;
                }
            }
            this.d = true;
            return c.f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f16772a = false;
        public boolean b = false;
        public String c = null;

        @Override // com.zx.a.I8b7.a1.a
        public boolean a(Context context) {
            return true;
        }

        @Override // com.zx.a.I8b7.a1.a
        public String b(Context context) {
            Bundle bundleCall;
            try {
                if (TextUtils.isEmpty(this.c)) {
                    Uri uri = Uri.parse("content://cn.nubia.identity/identity");
                    int i = Build.VERSION.SDK_INT;
                    ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
                    if (contentProviderClientAcquireContentProviderClient != null) {
                        bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                        try {
                            if (i >= 24) {
                                Class.forName("android.content.ContentProviderClient").getMethod("close", new Class[0]).invoke(contentProviderClientAcquireContentProviderClient, new Object[0]);
                            } else {
                                contentProviderClientAcquireContentProviderClient.release();
                            }
                        } catch (Throwable unused) {
                        }
                    } else {
                        bundleCall = null;
                    }
                    if (bundleCall == null) {
                        return this.c;
                    }
                    if (bundleCall.getInt("code", -1) == 0) {
                        this.c = bundleCall.getString("id");
                    }
                }
            } catch (Throwable unused2) {
                this.c = null;
            }
            return this.c;
        }

        @Override // com.zx.a.I8b7.a1.a
        public boolean c(Context context) {
            if (this.b) {
                return this.f16772a;
            }
            if (context == null) {
                return false;
            }
            try {
                PackageManager packageManagerC = w3.c(context);
                this.f16772a = (packageManagerC == null || packageManagerC.resolveContentProvider("cn.nubia.identity", 0) == null) ? false : true;
            } catch (Throwable unused) {
                this.f16772a = false;
            }
            this.b = true;
            return this.f16772a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k extends b {
        public String j;
        public String k;

        public k() {
            super("com.heytap.openid", "com.heytap.openid.IdentifyService", "action.com.heytap.openid.OPEN_ID_SERVICE", "com.heytap.openid.IOpenID");
        }

        @Override // com.zx.a.I8b7.a1.b
        public String b() {
            return "OUID";
        }

        @Override // com.zx.a.I8b7.a1.b
        public String d(Context context) {
            if (TextUtils.isEmpty(this.k)) {
                this.k = context.getPackageName();
            }
            return this.k;
        }

        @Override // com.zx.a.I8b7.a1.b
        @SuppressLint({"PackageManagerGetSignatures"})
        public String e(Context context) {
            if (TextUtils.isEmpty(this.j)) {
                try {
                    if (TextUtils.isEmpty(this.k)) {
                        this.k = context.getPackageName();
                    }
                    String str = this.k;
                    this.k = str;
                    Signature[] signatureArr = i3.a(str, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                        }
                        this.j = sb.toString();
                    }
                } catch (Throwable unused) {
                }
            }
            return this.j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class l extends b {
        public l() {
            super("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService", null, "com.samsung.android.deviceidservice.IDeviceIdService");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class m extends c {
        public m() {
            super("com.vivo.vms.IdProvider", "IdentifierId/OAID");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class n implements a {
        public static String b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Class<?> f16773a = null;

        @Override // com.zx.a.I8b7.a1.a
        public boolean a(Context context) {
            return true;
        }

        @Override // com.zx.a.I8b7.a1.a
        public String b(Context context) {
            if (TextUtils.isEmpty(b)) {
                try {
                    b = String.valueOf(this.f16773a.getMethod("getOAID", Context.class).invoke(this.f16773a.newInstance(), context));
                } catch (Throwable unused) {
                    b = null;
                }
            }
            return b;
        }

        @Override // com.zx.a.I8b7.a1.a
        @SuppressLint({"PrivateApi"})
        public boolean c(Context context) {
            try {
                this.f16773a = Class.forName("com.android.id.impl.IdProviderImpl");
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class o extends b {
        public o() {
            super("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService", null, "com.zui.deviceidservice.IDeviceidInterface");
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static {
        a oVar;
        String upperCase = Build.MANUFACTURER.toUpperCase();
        upperCase.getClass();
        byte b2 = -1;
        switch (upperCase.hashCode()) {
            case -2053026509:
                if (upperCase.equals("LENOVO")) {
                    b2 = 0;
                }
                break;
            case -1881642058:
                if (upperCase.equals("REALME")) {
                    b2 = 1;
                }
                break;
            case -1712043046:
                if (upperCase.equals("SAMSUNG")) {
                    b2 = 2;
                }
                break;
            case -1706170181:
                if (upperCase.equals("XIAOMI")) {
                    b2 = 3;
                }
                break;
            case -1134767290:
                if (upperCase.equals("BLACKSHARK")) {
                    b2 = 4;
                }
                break;
            case -602397472:
                if (upperCase.equals("ONEPLUS")) {
                    b2 = 5;
                }
                break;
            case 89198:
                if (upperCase.equals("ZUI")) {
                    b2 = 6;
                }
                break;
            case 89200:
                if (upperCase.equals("ZUK")) {
                    b2 = 7;
                }
                break;
            case 2018896:
                if (upperCase.equals("ASUS")) {
                    b2 = 8;
                }
                break;
            case 2255112:
                if (upperCase.equals("IQOO")) {
                    b2 = 9;
                }
                break;
            case 2432928:
                if (upperCase.equals("OPPO")) {
                    b2 = 10;
                }
                break;
            case 2634924:
                if (upperCase.equals(LxAdOSUtils.ROM_VIVO)) {
                    b2 = 11;
                }
                break;
            case 68924490:
                if (upperCase.equals("HONOR")) {
                    b2 = 12;
                }
                break;
            case 73239724:
                if (upperCase.equals("MEIZU")) {
                    b2 = dn.k;
                }
                break;
            case 74632627:
                if (upperCase.equals("NUBIA")) {
                    b2 = dn.l;
                }
                break;
            case 77852109:
                if (upperCase.equals("REDMI")) {
                    b2 = 15;
                }
                break;
            case 630905871:
                if (upperCase.equals("MOTOLORA")) {
                    b2 = 16;
                }
                break;
            case 1670208650:
                if (upperCase.equals("COOLPAD")) {
                    b2 = 17;
                }
                break;
            case 1972178256:
                if (upperCase.equals("HUA_WEI")) {
                    b2 = 18;
                }
                break;
            case 2141820391:
                if (upperCase.equals("HUAWEI")) {
                    b2 = 19;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 6:
            case 7:
            case 16:
                oVar = new o();
                break;
            case 1:
            case 5:
            case 10:
                oVar = new k();
                break;
            case 2:
                oVar = new l();
                break;
            case 3:
            case 4:
            case 15:
                oVar = new n();
                break;
            case 8:
                oVar = new f();
                break;
            case 9:
            case 11:
                oVar = new m();
                break;
            case 12:
            case 18:
            case 19:
                oVar = new h();
                break;
            case 13:
                oVar = new i();
                break;
            case 14:
                oVar = new j();
                break;
            case 17:
                oVar = new g();
                break;
            default:
                oVar = null;
                break;
        }
        f16767a = oVar;
    }
}
