package cn.fly.verify;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cv implements dg<cu> {
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011f  */
    @Override // cn.fly.verify.dg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(cu cuVar, Class<cu> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if ("new".equals(str) && objArr.length == 2) {
            objArr2[0] = new cu((String) objArr[0], ((Integer) objArr[1]).intValue());
        } else if (dx.a("009hUbeUg]chCg8bhbg>c8cc").equals(str) && objArr.length == 2) {
            cuVar.a((String) objArr[0], (String) objArr[1]);
        } else if (dx.a("009?ccMdgVchOg3bhbgWc5cc").equals(str) && objArr.length == 2) {
            objArr2[0] = cuVar.b((String) objArr[0], (String) objArr[1]);
        } else if (dx.a("010hIbeFgUdgcbcbGedbc").equals(str) && objArr.length == 2) {
            Object obj = objArr[1];
            if (obj instanceof Boolean) {
                cuVar.a((String) objArr[0], ((Boolean) obj).booleanValue());
            }
        } else if (dx.a("010.cc6dg%dgcbcb$edbc").equals(str) && objArr.length == 2) {
            Object obj2 = objArr[1];
            if (obj2 instanceof Boolean) {
                objArr2[0] = Boolean.valueOf(cuVar.b((String) objArr[0], ((Boolean) obj2).booleanValue()));
            }
        } else if (dx.a("007h<beWg dacbWc0cc").equals(str) && objArr.length == 2) {
            Object obj3 = objArr[1];
            if (obj3 instanceof Long) {
                cuVar.a((String) objArr[0], ((Long) obj3).longValue());
            }
        } else if (dx.a("007(ccSdgWdacbJc=cc").equals(str) && objArr.length == 2) {
            Object obj4 = objArr[1];
            if (obj4 instanceof Long) {
                objArr2[0] = Long.valueOf(cuVar.b((String) objArr[0], ((Long) obj4).longValue()));
            }
        } else if (dx.a("006hQbeSgHcg$cg").equals(str) && objArr.length == 2) {
            Object obj5 = objArr[1];
            if (obj5 instanceof Integer) {
                cuVar.a((String) objArr[0], ((Integer) obj5).intValue());
            }
        } else if (dx.a("006Bcc9dg(cg-cg").equals(str) && objArr.length == 2) {
            objArr2[0] = Integer.valueOf(cuVar.b((String) objArr[0], ((Integer) objArr[1]).intValue()));
        } else if (dx.a("006h:be5g4eedcfe").equals(str) && objArr.length == 2) {
            cuVar.a((String) objArr[0], objArr[1]);
        } else {
            if (!dx.a("006Occ%dgMeedcfe").equals(str) || objArr.length != 1) {
                return false;
            }
            objArr2[0] = cuVar.a((String) objArr[0]);
        }
        return true;
    }
}
