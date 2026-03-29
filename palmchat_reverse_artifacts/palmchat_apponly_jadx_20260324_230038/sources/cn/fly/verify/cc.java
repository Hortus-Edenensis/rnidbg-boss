package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import cn.fly.verify.ce;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cc extends ce {
    public cc(Context context) {
        super(context);
    }

    @Override // cn.fly.verify.ce
    public Intent a() {
        Intent intent = new Intent();
        intent.setAction(ed.a("028cAeddffd5h$di?hRed[e-eddjfddidcfdfjZe5ggAdUeidcej$f9djdddi.cf"));
        intent.setPackage(ed.a("014c1eddffd*h5di4h^edHe^eddjfddidc"));
        return intent;
    }

    @Override // cn.fly.verify.ce
    public ce.b a(IBinder iBinder) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        dy dyVar = new dy();
        dyVar.a(countDownLatch);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken(ed.a("042cYeddffdKh4di_hEedUeTeddjfd<cg^eddgdcfhHf.djdddiGcfBfded-dJdidcfdeiggeleifkejGf=djdddi5cf"));
                parcelObtain.writeStrongBinder(dyVar);
                iBinder.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                countDownLatch.await(2000L, TimeUnit.MILLISECONDS);
                parcelObtain.recycle();
            } catch (Throwable th) {
                try {
                    en.a().a(th);
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    try {
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                    } catch (Throwable unused) {
                    }
                    throw th2;
                }
            }
            parcelObtain2.recycle();
        } catch (Throwable unused2) {
        }
        en.a().a("hord is null ? " + TextUtils.isEmpty(dyVar.a()) + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        if (TextUtils.isEmpty(dyVar.a())) {
            return null;
        }
        ce.b bVar = new ce.b();
        bVar.b = dyVar.a();
        return bVar;
    }
}
