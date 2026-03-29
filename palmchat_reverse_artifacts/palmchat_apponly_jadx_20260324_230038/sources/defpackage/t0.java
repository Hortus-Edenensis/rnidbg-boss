package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class t0 implements zn2 {
    public String b(int i) {
        return i != -3 ? i != -1 ? i != 0 ? "支付失败" : "支付成功" : "支付中" : "用户取消";
    }

    @Override // defpackage.zn2
    public void release() {
    }
}
