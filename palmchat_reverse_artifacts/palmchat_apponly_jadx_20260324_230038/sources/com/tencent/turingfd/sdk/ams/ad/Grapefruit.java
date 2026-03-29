package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Grapefruit implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f10703a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Herbaceous d;

    public Grapefruit(Herbaceous herbaceous, Context context, boolean z, int i) {
        this.d = herbaceous;
        this.f10703a = context;
        this.b = z;
        this.c = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean zBooleanValue;
        int i;
        Herbaceous herbaceous = this.d;
        Context context = this.f10703a;
        boolean z = this.b;
        int i2 = this.c;
        herbaceous.d.getClass();
        String strB = Hickory.b(context, "403");
        if (!TextUtils.isEmpty(strB)) {
            zBooleanValue = Boolean.valueOf(strB).booleanValue();
            for (i = 0; i < herbaceous.f10705a.y; i++) {
                Ginkgo ginkgoA = herbaceous.a(context, z, zBooleanValue, i2);
                herbaceous.a(ginkgoA, true);
                int i3 = ginkgoA.c;
                if (i3 == 0 || i3 == -30014) {
                    break;
                }
            }
            if (zBooleanValue) {
                Hickory hickory = herbaceous.d;
                hickory.getClass();
                hickory.a(context, "403", "false", true);
            }
            synchronized (herbaceous.g) {
                herbaceous.g.set(Boolean.FALSE);
                herbaceous.g.notifyAll();
            }
            return;
        }
        zBooleanValue = true;
        while (i < herbaceous.f10705a.y) {
        }
        if (zBooleanValue) {
        }
        synchronized (herbaceous.g) {
        }
    }
}
