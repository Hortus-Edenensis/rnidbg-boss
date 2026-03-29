package defpackage;

import android.content.Context;
import com.zenmen.palmchat.chat.ChatItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class i50 {
    public static i50 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f18101a = new ArrayList();

    public static i50 d() {
        if (b == null) {
            synchronized (i50.class) {
                if (b == null) {
                    b = new i50();
                }
            }
        }
        return b;
    }

    public final o40 a(String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Object objNewInstance = Class.forName(str).newInstance();
        return objNewInstance instanceof o40 ? (o40) objNewInstance : b(objNewInstance);
    }

    public final o40 b(Object obj) {
        ls0 ls0Var = new ls0();
        ls0Var.w((dl2) obj);
        return ls0Var;
    }

    public synchronized List<o40> c(Context context, ChatItem chatItem, p40 p40Var) {
        ArrayList arrayList;
        if (this.f18101a.isEmpty()) {
            throw new UnsupportedOperationException("hasn't register ChatterViewProvider.");
        }
        arrayList = new ArrayList();
        Iterator<String> it = this.f18101a.iterator();
        int viewTypeCount = 0;
        while (it.hasNext()) {
            try {
                o40 o40VarA = a(it.next());
                o40VarA.f(context, chatItem);
                o40VarA.h(p40Var);
                o40VarA.g(viewTypeCount);
                viewTypeCount += o40VarA.getViewTypeCount();
                arrayList.add(o40VarA);
            } catch (Exception e) {
                throw new UnsupportedOperationException("can't create ChatterViewAdapter", e);
            }
        }
        return arrayList;
    }

    public synchronized void e(String str) {
        if (!this.f18101a.contains(str)) {
            this.f18101a.add(str);
        }
    }
}
