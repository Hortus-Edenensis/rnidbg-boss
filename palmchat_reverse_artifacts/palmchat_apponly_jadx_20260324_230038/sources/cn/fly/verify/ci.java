package cn.fly.verify;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import cn.fly.verify.ce;
import cn.fly.verify.fq;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ci extends ce {
    private String c;

    public ci(Context context) {
        super(context);
    }

    @Override // cn.fly.verify.ce
    public Intent a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(bq.a("017dGfeeggeQigFel7jekDgefe3kgf0ejed"), bq.a("033d5feeggeDig<el2jekOgefe+kgf%ejedgefjedCgfj0ejfgelfkHg'ekeeej]dg")));
        intent.setAction(bq.a("040edjFejfeJfJge9dHfeeggeHigCel^jek2gefe6kgf-ejedgehhhmhifieifjgleifkhihjhkfjhlhi"));
        return intent;
    }

    @Override // cn.fly.verify.ce
    public synchronized boolean e() {
        Object obj;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Object[] objArr = new Object[1];
        fq.a(ax.g()).c(bq.a("017d+feeggeGigIelKjek:gefeSkgfJejed"), 0).a(new fq.a() { // from class: cn.fly.verify.ci.1
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                try {
                    objArr[0] = bVar.l(new int[0]);
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await(200L, TimeUnit.MILLISECONDS);
            obj = objArr[0];
        } catch (Throwable unused) {
            return false;
        }
        return (obj != null ? Build.VERSION.SDK_INT >= 28 ? fd.g(obj, this.b) : (long) fd.f(obj, this.b) : 0L) >= 1;
    }

    @Override // cn.fly.verify.ce
    public ce.b a(IBinder iBinder) {
        ce.b bVar = new ce.b();
        bVar.b = a(iBinder, bq.a("004Lhhfhfjgl"));
        return bVar;
    }

    private final String a(IBinder iBinder, String str) {
        if (TextUtils.isEmpty(this.c)) {
            try {
                final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                fq.a(ax.g()).c(this.b, 64).a(new fq.a() { // from class: cn.fly.verify.ci.2
                    @Override // cn.fly.verify.fq.a
                    public void a(fq.b bVar) {
                        if (bVar.l(new int[0]) != null) {
                            linkedBlockingQueue.offer(bVar.l(new int[0]));
                        } else {
                            linkedBlockingQueue.offer(Boolean.FALSE);
                        }
                    }
                });
                Object objPoll = linkedBlockingQueue.poll(300L, TimeUnit.MILLISECONDS);
                Signature[] signatureArrB = !(objPoll instanceof Boolean) ? fd.b(objPoll, this.b) : null;
                if (signatureArrB != null && signatureArrB.length > 0) {
                    byte[] byteArray = signatureArrB[0].toByteArray();
                    MessageDigest messageDigest = MessageDigest.getInstance(bq.a("0046fkgkfmig"));
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                        }
                        this.c = sb.toString();
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return a(str, iBinder, bq.a("025dHfeeggeHigPelNjek)gefeIkgfAejedgefjhh5kgf1fjgl"), 1, this.b, this.c, str);
    }
}
