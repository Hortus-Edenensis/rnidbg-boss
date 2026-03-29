package com.zx.a.I8b7;

import com.zx.module.base.Callback;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class u0 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f16868a;
        public final /* synthetic */ CountDownLatch b;

        public a(String[] strArr, CountDownLatch countDownLatch) {
            this.f16868a = strArr;
            this.b = countDownLatch;
        }

        @Override // com.zx.module.base.Callback
        public void callback(String str) {
            try {
                this.f16868a[0] = str;
                this.b.countDown();
            } catch (Throwable unused) {
            }
        }
    }

    public static final String a() {
        String[] strArr = {""};
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new v0(new a(strArr, countDownLatch)));
            thread.setUncaughtExceptionHandler(new w0());
            thread.start();
            countDownLatch.await(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
        }
        return strArr[0];
    }
}
