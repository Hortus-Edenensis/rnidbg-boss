package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Berry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gemini<Cfinal> f10663a = new Gemini<>(3);
    public static final Gemini<Cfinal> b = new Gemini<>(3);
    public static final Cfinal[] c = new Cfinal[0];
    public static long d = 0;
    public static final Nectarine e = new Cdo();

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Berry$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class Cdo implements Nectarine {
        public void a(Cfinal cfinal) {
            int i = cfinal.b;
            if (i == 2 || i == 3) {
                Gemini<Cfinal> gemini = Berry.b;
                synchronized (gemini) {
                    gemini.a(cfinal);
                }
                return;
            }
            Durian durian = cfinal.c;
            if (durian != null) {
                long jAbs = Math.abs(durian.f10693a - Berry.d);
                Berry.d = System.currentTimeMillis();
                if (jAbs < 1000) {
                    return;
                }
                Gemini<Cfinal> gemini2 = Berry.f10663a;
                synchronized (gemini2) {
                    gemini2.a(cfinal);
                }
            }
        }
    }
}
