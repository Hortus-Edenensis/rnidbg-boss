package cn.shuzilm.core;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f2482a;

    public m(int i) {
        this.f2482a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (DUHelper.h.tryLock()) {
            try {
                if (DUHelper.c == null) {
                    AIClient unused = DUHelper.c = new AIClient(DUHelper.mContext);
                }
                DUHelper.c.asynAI(this.f2482a);
            } catch (Exception unused2) {
            } catch (Throwable th) {
                DUHelper.h.unlock();
                throw th;
            }
            DUHelper.h.unlock();
        }
    }
}
