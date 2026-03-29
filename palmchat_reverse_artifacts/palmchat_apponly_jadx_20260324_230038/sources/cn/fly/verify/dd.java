package cn.fly.verify;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dd implements dg<dc> {
    @Override // cn.fly.verify.dg
    public boolean a(dc dcVar, Class<dc> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        Object obj;
        if (!"setHandler".equals(str) || objArr.length != 1 || (obj = objArr[0]) == null || !(obj instanceof da)) {
            return false;
        }
        dcVar.a((da) obj);
        return true;
    }
}
