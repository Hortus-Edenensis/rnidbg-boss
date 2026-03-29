package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cq implements dg<Context> {
    @Override // cn.fly.verify.dg
    public boolean a(Context context, Class<Context> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (ed.a("016)ee4fiLejdkfhIif+dfej[f(djdddiTcf").equals(str) && objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                try {
                    objArr2[0] = context.getSystemService((String) obj);
                } catch (Throwable th) {
                    objArr2[0] = null;
                    thArr[0] = th;
                }
                return true;
            }
        }
        if ("getApplicationInfo".equals(str) && objArr.length == 0) {
            objArr2[0] = context.getApplicationInfo();
            return true;
        }
        if (ed.a("018*eeDfi@gked6eifei;giOfZfhed=gOddDf)dj").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getContentResolver();
            return true;
        }
        if (ed.a("014Hee'fi=glIdc)dl[d[ee[fRehKdLdfSf").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getPackageName();
            return true;
        }
        if (ed.a("017UeeSfiYgl$dcHdl7dAee_fVhcTded.ee<fHdj").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getPackageManager();
            return true;
        }
        if (ed.a("0137fhAidEdjMiFelMci4didddi6i<dk").equals(str) && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof Intent) {
                context.startActivity((Intent) obj2);
                return true;
            }
        }
        if (ed.a("011:ee6fi8fldi?gfRfhfkdidj").equals(str)) {
            objArr2[0] = context.getFilesDir();
            return true;
        }
        if (ed.a("009Tee>fi;elfhfh<fi5fh").equals(str)) {
            objArr2[0] = context.getAssets();
            return true;
        }
        if (ed.a("019chfc;dlejXfg^efglQfZdjdfdifhfhdiedFe").equals(str) && objArr.length == 1) {
            Object obj3 = objArr[0];
            if (obj3 instanceof String) {
                if (Build.VERSION.SDK_INT >= 23) {
                    objArr2[0] = Integer.valueOf(context.checkSelfPermission((String) obj3));
                } else {
                    objArr2[0] = Integer.valueOf(context.getPackageManager().checkPermission((String) objArr[0], context.getPackageName()));
                }
                return true;
            }
        }
        if (ed.a("011Wfedi,e:dcej'f'djdddi<cf").equals(str) && objArr.length == 3) {
            objArr2[0] = Boolean.valueOf(context.bindService((Intent) objArr[0], (ServiceConnection) objArr[1], ((Integer) objArr[2]).intValue()));
            return true;
        }
        if (ed.a("0136dg4ePfedi:e^dcejXfTdjdddi2cf").equals(str) && objArr.length == 1) {
            Object obj4 = objArr[0];
            if (obj4 instanceof ServiceConnection) {
                context.unbindService((ServiceConnection) obj4);
                return true;
            }
        }
        return false;
    }
}
