package cn.fly.verify;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2185a;
    private int b;
    private df c;
    private int d;
    private int e;
    private dj f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements dg<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Throwable f2186a;
        public Object b;

        public boolean a() {
            return this.f2186a != null;
        }

        @Override // cn.fly.verify.dg
        public boolean a(a aVar, Class<a> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
            if ("isError".equals(str) && objArr.length == 0) {
                objArr2[0] = Boolean.valueOf(aVar.a());
                return true;
            }
            if ("getError".equals(str) && objArr.length == 0) {
                objArr2[0] = aVar.f2186a;
                return true;
            }
            if (!"getResult".equals(str) || objArr.length != 0) {
                return false;
            }
            objArr2[0] = aVar.b;
            return true;
        }
    }

    public dm(String str, int i, ArrayList<dl> arrayList, ArrayList<Object> arrayList2, int i2, int i3, df dfVar) {
        this.f2185a = str;
        this.b = i;
        this.f = new dj(arrayList, arrayList2);
        this.d = i2;
        this.e = i3;
        this.c = dfVar;
    }

    public a a(Object... objArr) {
        a aVar = new a();
        try {
            LinkedList<Object> linkedListB = b(objArr);
            if (!linkedListB.isEmpty()) {
                aVar.b = linkedListB.get(0);
            }
        } catch (Throwable th) {
            aVar.f2186a = th;
        }
        return aVar;
    }

    public LinkedList<Object> b(Object... objArr) throws Throwable {
        df dfVarB = this.c.b();
        int i = this.b;
        if (i != 0) {
            if (objArr.length == i) {
                for (int length = objArr.length - 1; length >= 0; length--) {
                    dfVarB.a(objArr[length]);
                }
            } else if (objArr.length < i) {
                for (int length2 = objArr.length; length2 < this.b; length2++) {
                    dfVarB.a((Object) null);
                }
                for (int length3 = objArr.length - 1; length3 >= 0; length3--) {
                    dfVarB.a(objArr[length3]);
                }
            } else {
                ArrayList arrayList = new ArrayList(0);
                for (int i2 = this.b - 1; i2 < objArr.length; i2++) {
                    arrayList.add(objArr[i2]);
                }
                dfVarB.a(arrayList);
                for (int i3 = this.b - 2; i3 >= 0; i3--) {
                    dfVarB.a(objArr[i3]);
                }
            }
        }
        LinkedList<Object> linkedList = new LinkedList<>();
        this.f.a(this.d, this.e, dfVarB, linkedList);
        return linkedList;
    }

    public dm a(df dfVar, String str, int i) {
        if (this.b <= 1) {
            return this;
        }
        ArrayList<dl> arrayList = new ArrayList<>();
        a(str, i, arrayList, 0);
        return new dm(null, 1, arrayList, new ArrayList(), 0, arrayList.size(), dfVar);
    }

    public static dm a(String str, int i, ArrayList<dl> arrayList, ArrayList<Object> arrayList2, int i2, int i3, df dfVar) {
        return new dm(str, i, arrayList, arrayList2, i2, i3, dfVar) { // from class: cn.fly.verify.dm.1
            @Override // cn.fly.verify.dm
            public LinkedList<Object> b(Object... objArr) throws Throwable {
                return new LinkedList<>();
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, int i, ArrayList<dl> arrayList, int i2) {
        dl dlVar;
        dl dlVar2;
        if (i2 != 0) {
            dl dlVar3 = new dl(29);
            dlVar3.b = str;
            dlVar3.c = i;
            dlVar3.i = 1;
            arrayList.add(dlVar3);
        }
        dl dlVar4 = new dl(1);
        dlVar4.b = str;
        dlVar4.c = i;
        StringBuilder sb = new StringBuilder();
        sb.append("arg");
        int i3 = i2 + 1;
        sb.append(i3);
        dlVar4.h = sb.toString();
        arrayList.add(dlVar4);
        int i4 = this.b;
        if (i2 >= i4 - 1) {
            for (int i5 = i4 - 1; i5 >= 0; i5 += -1) {
                dl dlVar5 = new dl(3);
                dlVar5.b = str;
                dlVar5.c = i;
                dlVar5.h = "arg" + (i5 + 1);
                arrayList.add(dlVar5);
            }
            if (this.f2185a == null) {
                dl dlVar6 = new dl(2);
                dlVar6.b = str;
                dlVar6.c = i;
                dlVar6.q = this;
                arrayList.add(dlVar6);
                dlVar = new dl(32);
                dlVar.b = str;
                dlVar.c = i;
            } else {
                dlVar = new dl(31);
                dlVar.b = str;
                dlVar.c = i;
                dlVar.h = this.f2185a;
            }
            dlVar.i = this.b;
            arrayList.add(dlVar);
            Iterator<dl> it = this.f.a().iterator();
            while (it.hasNext()) {
                if (it.next().f2183a == 28) {
                    dlVar2 = new dl(28);
                }
            }
            if (i2 == 0) {
                dl dlVar7 = new dl(30);
                dlVar7.b = str;
                dlVar7.c = i;
                arrayList.add(dlVar7);
                return;
            }
            return;
        }
        a(str, i, arrayList, i3);
        dlVar2 = new dl(28);
        dlVar2.b = str;
        dlVar2.c = i;
        arrayList.add(dlVar2);
        if (i2 == 0) {
        }
    }
}
