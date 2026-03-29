package cn.shuzilm.core;

/* JADX INFO: renamed from: cn.shuzilm.core.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class RunnableC1320r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f2487a;
    final /* synthetic */ DUHelper b;

    public RunnableC1320r(DUHelper dUHelper, int i) {
        this.b = dUHelper;
        this.f2487a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DUHelper.getQueryID(DUHelper.mContext, "NA", "", false, 1, null, this.f2487a + 100);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
