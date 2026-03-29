package cn.fly.verify;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cp implements dg<dy> {
    @Override // cn.fly.verify.dg
    public boolean a(dy dyVar, Class<dy> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (ed.a("004Iee0fi]fk").equals(str)) {
            objArr2[0] = dyVar.a();
        } else if (ed.a("008(fhUfi6fc0dich").equals(str) && objArr != null && objArr.length == 1) {
            objArr2[0] = dyVar.a((CountDownLatch) objArr[0]);
        } else {
            if (!ed.a("005NdifhejAji").equals(str)) {
                return false;
            }
            objArr2[0] = Boolean.valueOf(dyVar.b());
        }
        return true;
    }
}
