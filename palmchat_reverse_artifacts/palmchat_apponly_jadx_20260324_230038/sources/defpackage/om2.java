package defpackage;

import com.zenmen.listui.list.BaseBean;
import com.zenmen.listui.list.BaseNetListBean;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public interface om2<T extends BaseBean> {
    JSONObject a();

    JSONObject b();

    void c(int i, T t);

    void d(ir<BaseNetListBean<T>> irVar);

    void destroy();

    List<T> e();

    void f(ir<BaseNetListBean<T>> irVar);

    void g(int i, T t);
}
