package cn.shuzilm.core;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class k implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            System.loadLibrary(com.umeng.analytics.pro.f.ac);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
