package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.zenmen.square.dynamiclife.MultiTypeAdapter;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zu2<T, VH extends RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MultiTypeAdapter f22515a;

    public long a(T t, int i) {
        return -1L;
    }

    public abstract void b(VH vh, T t, int i);

    public void c(VH vh, T t, int i, List<Object> list) {
        b(vh, t, i);
    }

    public abstract VH d(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public boolean e(VH vh) {
        return false;
    }

    public void f(VH vh) {
    }

    public void g(VH vh) {
    }

    public void h(VH vh) {
    }
}
