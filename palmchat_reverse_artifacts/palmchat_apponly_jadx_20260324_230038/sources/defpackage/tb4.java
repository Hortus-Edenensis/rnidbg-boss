package defpackage;

import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.square.lxpager.BasePagerBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class tb4<T extends BasePagerBean> implements om2<T> {
    public km2<T> b;
    public String f;
    public int h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<T> f20952a = new ArrayList();
    public int c = 2;
    public int d = 0;
    public int e = 0;
    public boolean g = true;

    @Override // defpackage.om2
    public void d(ir<BaseNetListBean<T>> irVar) {
        if (this.c == 1) {
            return;
        }
        this.c = 1;
        o(irVar);
    }

    @Override // defpackage.om2
    public List<T> e() {
        return this.f20952a;
    }

    @Override // defpackage.om2
    public void f(ir<BaseNetListBean<T>> irVar) {
        if (this.c == 1) {
            return;
        }
        this.c = 1;
    }

    public boolean h() {
        return false;
    }

    public void i(int i, T t) {
        j(i, t);
    }

    public void j(int i, T t) {
        if (i >= this.f20952a.size() || i < 0) {
            return;
        }
        this.f20952a.remove(i);
        this.b.b(i, t);
    }

    public JSONObject k(String str) {
        HashMap map = new HashMap();
        map.put("native_err", str);
        return new JSONObject(map);
    }

    public String l() {
        return "已加载全部";
    }

    public boolean m() {
        return this.g;
    }

    public boolean n() {
        return false;
    }

    public abstract void o(ir<BaseNetListBean<T>> irVar);

    public void p(List<T> list) {
        if (list != null) {
            this.f20952a = list;
            this.b.g(list);
        }
    }

    public void q(km2 km2Var) {
        this.b = km2Var;
    }
}
