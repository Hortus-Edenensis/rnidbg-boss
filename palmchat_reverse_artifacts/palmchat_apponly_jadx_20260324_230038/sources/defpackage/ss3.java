package defpackage;

import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.venus.bean.VenusUserDetailBean;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ss3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20832a = "venus.get.user.full.info.v1";

    /* JADX INFO: compiled from: SearchBox */
    public class a extends jw3<BaseNetBean<VenusUserDetailBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20833a;
        public final /* synthetic */ ir b;

        public a(String str, ir irVar) {
            this.f20833a = str;
            this.b = irVar;
        }

        @Override // defpackage.jw3
        public Map<String, Object> a(Map<String, Object> map) {
            map.put("queryUid", this.f20833a);
            return map;
        }

        @Override // defpackage.jw3
        public void c(BaseNetBean<VenusUserDetailBean> baseNetBean) {
            this.b.a(baseNetBean);
        }
    }

    public static void a(String str, ir<BaseNetBean<VenusUserDetailBean>> irVar) {
        ow3.f(f20832a, new a(str, irVar));
    }
}
