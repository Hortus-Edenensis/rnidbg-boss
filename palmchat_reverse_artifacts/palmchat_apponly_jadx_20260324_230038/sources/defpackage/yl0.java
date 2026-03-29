package defpackage;

import com.zenmen.palmchat.Vo.GlobalConfig;
import com.zenmen.palmchat.Vo.GreetConfig;
import com.zenmen.palmchat.Vo.GroupCateConfig;
import com.zenmen.palmchat.Vo.MucConfig;
import com.zenmen.palmchat.Vo.UrlWhiteConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface yl0 {
    GlobalConfig a();

    GroupCateConfig b();

    kn0 c();

    UrlWhiteConfig d();

    void e(String str, JSONObject jSONObject);

    DynamicConfig f();

    GreetConfig g();

    MucConfig h();

    void init(String str);
}
