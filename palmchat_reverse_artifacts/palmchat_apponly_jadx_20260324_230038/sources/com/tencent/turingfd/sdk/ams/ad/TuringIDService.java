package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TuringIDService {

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.TuringIDService$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class Cdo implements Caelum {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ITuringDIDCallback f10743a;

        public Cdo(ITuringDIDCallback iTuringDIDCallback) {
            this.f10743a = iTuringDIDCallback;
        }
    }

    public static ITuringDID getTuringDID(Context context) {
        int iA = Marc.a();
        return new Lichee(iA != 0 ? Ginkgo.a(iA) : Herbaceous.l.a(context, true, 1));
    }

    public static void getTuringDIDAsync(Context context, ITuringDIDCallback iTuringDIDCallback) {
        if (iTuringDIDCallback == null) {
            return;
        }
        Cdo cdo = new Cdo(iTuringDIDCallback);
        AtomicBoolean atomicBoolean = Marc.b;
        if (context.getApplicationContext() == null) {
            iTuringDIDCallback.onResult(new Lichee(Ginkgo.a(-10016)));
            return;
        }
        int iA = Marc.a();
        if (iA != 0) {
            iTuringDIDCallback.onResult(new Lichee(Ginkgo.a(iA)));
        }
        new Mangosteen(cdo, context).start();
    }

    public static ITuringDID getTuringDIDCached(Context context) {
        Ginkgo ginkgoA;
        int iA = Marc.a();
        if (iA != 0) {
            ginkgoA = Ginkgo.a(iA);
        } else {
            Herbaceous herbaceous = Herbaceous.l;
            ginkgoA = herbaceous.a(context);
            if (herbaceous.f10705a == null) {
                ginkgoA = Ginkgo.a(-10002);
            } else {
                int iA2 = herbaceous.a(ginkgoA);
                if (iA2 != 1) {
                    if (iA2 == 2) {
                        herbaceous.a();
                        ginkgoA = Ginkgo.a(-10009);
                    } else if (iA2 == 3) {
                        herbaceous.a();
                    }
                }
            }
        }
        return new Lichee(ginkgoA);
    }
}
