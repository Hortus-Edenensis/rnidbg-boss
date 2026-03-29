package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.u.nr.fx;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mi7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<fx, List<ol7>> f19230a = new HashMap();
    public Map<String, String> b = new HashMap();
    public final List<Object> c = new CopyOnWriteArrayList();
    public final List<Object> d = new CopyOnWriteArrayList();
    public final List<Object> e = new CopyOnWriteArrayList();
    public final List<Object> f = new CopyOnWriteArrayList();
    public cf7 g = null;

    @Nullable
    public cf7 a() {
        return this.g;
    }

    @NonNull
    public List<Object> b() {
        return this.f;
    }

    @NonNull
    public List<Object> c() {
        return this.d;
    }

    @Nullable
    public List<ol7> d(fx fxVar) {
        return this.f19230a.get(fxVar);
    }

    public Map<String, String> e() {
        return this.b;
    }

    public void f(cf7 cf7Var) {
        this.g = cf7Var;
    }

    public void g(Map<? extends String, ? extends String> map) {
        this.b.putAll(map);
    }
}
