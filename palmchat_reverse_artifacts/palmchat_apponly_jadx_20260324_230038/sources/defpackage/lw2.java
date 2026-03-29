package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class lw2 {
    public static List<mw2> a(String str, int i, List<mw2> list, mw2 mw2Var) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str) || mw2Var == null) {
            return null;
        }
        Iterator<mw2> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            mw2 next = it.next();
            if (e(str, i, next)) {
                next.b = mw2Var.b;
                next.c = mw2Var.c;
                break;
            }
        }
        return list;
    }

    public static mw2 b(String str, int i, List<mw2> list) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (mw2 mw2Var : list) {
                if (e(str, i, mw2Var)) {
                    return mw2Var;
                }
            }
        }
        return null;
    }

    public static String c(Context context) {
        return "";
    }

    public static List<mw2> d(Context context) {
        mw2 mw2VarB;
        mw2 mw2VarD = jw2.d(context);
        ArrayList<mw2> arrayListF = nw2.f(context);
        ArrayList<mw2> arrayListC = jw2.c(context);
        if (arrayListF != null && !arrayListF.isEmpty()) {
            for (int size = arrayListF.size() - 1; size >= 0; size--) {
                if (arrayListF.get(size).b()) {
                    arrayListF.remove(size);
                }
            }
        }
        if (arrayListF != null && !arrayListF.isEmpty()) {
            for (mw2 mw2Var : arrayListF) {
                if (TextUtils.isEmpty(mw2Var.f19378a) && !TextUtils.isEmpty(mw2Var.b)) {
                    mw2 mw2VarB2 = b(mw2Var.b, 1, arrayListC);
                    if (mw2VarB2 != null) {
                        mw2Var.f19378a = mw2VarB2.f19378a;
                    }
                } else if (TextUtils.isEmpty(mw2Var.b) && !TextUtils.isEmpty(mw2Var.f19378a) && (mw2VarB = b(mw2Var.f19378a, 1, arrayListC)) != null) {
                    mw2Var.b = mw2VarB.b;
                    mw2Var.c = mw2VarB.c;
                }
            }
            return arrayListF;
        }
        if (mw2VarD == null || mw2VarD.b()) {
            return arrayListC;
        }
        if (arrayListC == null || arrayListC.size() != 1) {
            mw2 mw2VarB3 = b(mw2VarD.f19378a, 0, arrayListC);
            return (mw2VarB3 != null && TextUtils.isEmpty(mw2VarB3.b) && b(mw2VarD.b, 1, arrayListC) == null) ? a(mw2VarD.f19378a, 0, arrayListC, mw2VarD) : arrayListC;
        }
        if (!TextUtils.isEmpty(mw2VarD.f19378a) && mw2VarD.f19378a.equals(arrayListC.get(0).f19378a)) {
            if (TextUtils.isEmpty(mw2VarD.b) || mw2VarD.b.equals(arrayListC.get(0).b)) {
                return arrayListC;
            }
            arrayListC.add(mw2VarD);
            return arrayListC;
        }
        if (TextUtils.isEmpty(mw2VarD.b) || !mw2VarD.b.equals(arrayListC.get(0).b)) {
            arrayListC.add(mw2VarD);
            return arrayListC;
        }
        mw2VarD.b = "";
        mw2VarD.c = "";
        if (mw2VarD.b()) {
            return arrayListC;
        }
        arrayListC.add(mw2VarD);
        return arrayListC;
    }

    public static boolean e(String str, int i, mw2 mw2Var) {
        return i != 0 ? i != 1 ? i == 2 && str.equals(mw2Var.c) : str.equals(mw2Var.b) : str.equals(mw2Var.f19378a);
    }
}
