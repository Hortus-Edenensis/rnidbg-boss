package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.embedapplog.jk;
import com.bytedance.embedapplog.ky;
import com.bytedance.embedapplog.my;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class qb implements ky {
    private ob<Boolean> nr;
    private final ky u;

    public qb() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fx(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (Exception e) {
            ti.u(e);
        }
        Signature[] signatureArr = packageInfo != null ? packageInfo.signatures : null;
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
                    return sb.toString();
                }
            } catch (Exception e2) {
                ti.u(e2);
            }
        }
        return null;
    }

    @Override // com.bytedance.embedapplog.ky
    public ky.u nr(final Context context) {
        if (this.u != null && !this.nr.nr(new Object[0]).booleanValue()) {
            return this.u.nr(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new jk(context, intent, new jk.nr<my, String>() { // from class: com.bytedance.embedapplog.qb.2
            @Override // com.bytedance.embedapplog.jk.nr
            /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
            public my u(IBinder iBinder) {
                return my.u.u(iBinder);
            }

            @Override // com.bytedance.embedapplog.jk.nr
            public String u(my myVar) {
                if (myVar == null) {
                    return null;
                }
                String strFx = qb.this.fx(context);
                if (TextUtils.isEmpty(strFx)) {
                    return null;
                }
                return myVar.u(context.getPackageName(), strFx, "OUID");
            }
        }).u();
        ky.u uVar = new ky.u();
        uVar.nr = str;
        return uVar;
    }

    public qb(ky kyVar) {
        this.nr = new ob<Boolean>() { // from class: com.bytedance.embedapplog.qb.1
            @Override // com.bytedance.embedapplog.ob
            /* JADX INFO: renamed from: fx, reason: merged with bridge method [inline-methods] */
            public Boolean u(Object... objArr) {
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return Boolean.FALSE;
                    }
                    return Boolean.valueOf((Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode) >= 1);
                } catch (PackageManager.NameNotFoundException unused) {
                    return Boolean.FALSE;
                } catch (Throwable th) {
                    ti.u(th);
                    return Boolean.FALSE;
                }
            }
        };
        this.u = kyVar;
    }

    @Override // com.bytedance.embedapplog.ky
    public boolean u(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolNr = this.nr.nr(context);
        return (this.u == null || boolNr.booleanValue()) ? boolNr.booleanValue() : this.u.u(context);
    }
}
