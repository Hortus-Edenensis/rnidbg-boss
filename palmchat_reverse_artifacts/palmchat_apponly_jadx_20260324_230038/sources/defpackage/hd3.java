package defpackage;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hd3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<sq<z65, Path>> f17934a;
    public final List<sq<Integer, Integer>> b;
    public final List<Mask> c;

    public hd3(List<Mask> list) {
        this.c = list;
        this.f17934a = new ArrayList(list.size());
        this.b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f17934a.add(list.get(i).b().a());
            this.b.add(list.get(i).c().a());
        }
    }

    public List<sq<z65, Path>> a() {
        return this.f17934a;
    }

    public List<Mask> b() {
        return this.c;
    }

    public List<sq<Integer, Integer>> c() {
        return this.b;
    }
}
