package a.a.c.a.d;

import a.a.c.a.a.g;
import a.a.c.a.b.c;
import a.a.c.a.d.o;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class l implements a.a.c.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.a.c.a.b.c f1116a;
    public a.a.c.a.e.c<Boolean> b = new a(this);

    /* JADX INFO: compiled from: SearchBox */
    public class a extends a.a.c.a.e.c<Boolean> {
        public a(l lVar) {
        }

        @Override // a.a.c.a.e.c
        public Boolean a(Object[] objArr) {
            try {
                PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                if (packageInfo == null) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf((Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode) >= 1);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements o.b<a.a.c.a.a.g, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f1117a;

        public b(Context context) {
            this.f1117a = context;
        }

        @Override // a.a.c.a.d.o.b
        public a.a.c.a.a.g a(IBinder iBinder) {
            int i = g.a.f1096a;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a.a.c.a.a.g)) ? new g.a.C0010a(iBinder) : (a.a.c.a.a.g) iInterfaceQueryLocalInterface;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
        @Override // a.a.c.a.d.o.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String a(a.a.c.a.a.g gVar) {
            String string;
            PackageInfo packageInfo;
            a.a.c.a.a.g gVar2 = gVar;
            if (gVar2 == null) {
                return null;
            }
            l lVar = l.this;
            Context context = this.f1117a;
            lVar.getClass();
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Signature[] signatureArr = packageInfo != null ? packageInfo.signatures : null;
            if (signatureArr == null || signatureArr.length <= 0) {
                string = null;
            } else {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return gVar2.a(this.f1117a.getPackageName(), string, "OUID");
        }
    }

    public l(a.a.c.a.b.c cVar) {
        this.f1116a = cVar;
    }

    @Override // a.a.c.a.b.c
    public c.a a(Context context) {
        if (this.f1116a != null && !this.b.b(new Object[0]).booleanValue()) {
            return this.f1116a.a(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new o(context, intent, new b(context)).a();
        c.a aVar = new c.a();
        aVar.f1105a = str;
        return aVar;
    }

    @Override // a.a.c.a.b.c
    public boolean b(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolB = this.b.b(context);
        return (this.f1116a == null || boolB.booleanValue()) ? boolB.booleanValue() : this.f1116a.b(context);
    }
}
