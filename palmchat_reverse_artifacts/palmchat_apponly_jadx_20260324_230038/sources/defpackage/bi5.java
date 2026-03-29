package defpackage;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.SmidHelper;
import com.zenmen.square.mvp.model.bean.DislikeResp;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class bi5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1722a = nl0.c + "/one/ax/";
    public static Map<String, String> b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ei5<BaseNetBean<DislikeResp>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeed f1723a;
        public final /* synthetic */ int b;
        public final /* synthetic */ b c;

        /* JADX INFO: renamed from: bi5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0027a extends TypeToken<BaseNetBean<DislikeResp>> {
            public C0027a() {
            }
        }

        public a(SquareFeed squareFeed, int i, b bVar) {
            this.f1723a = squareFeed;
            this.b = i;
            this.c = bVar;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("feedId", Long.valueOf(this.f1723a.id));
            map.put("fexid", this.f1723a.exid);
            map.put("type", Integer.valueOf(this.b));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean<DislikeResp> handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new C0027a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<DislikeResp> baseNetBean) {
            this.c.a(baseNetBean);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b<T extends BaseNetBean> {
        void a(T t);
    }

    static {
        HashMap map = new HashMap();
        b = map;
        map.put("lbs.square.nearby.pull.v9", "nearby");
        b.put("square.recommend.list.v8", MediationConstant.RIT_TYPE_FEED);
        b.put("onev1.beautiful.girls.list.v1", "quality_friendship");
    }

    public static void a(ei5 ei5Var) {
        SmidHelper.x(SmidHelper.SMScene.SQUARE_COMMENT);
        p("square.feed.discussion.post.v1", ei5Var);
    }

    public static void b(ei5 ei5Var) {
        p("square.feed.like.remove.v1", ei5Var);
    }

    public static void c(boolean z, ei5 ei5Var) {
        if (z) {
            b(ei5Var);
            return;
        }
        n(ei5Var);
        gi5.f17735a = System.currentTimeMillis();
        SPUtil.f14322a.t(SPUtil.SCENE.SQUARE, k86.a("key_square_praise_time"), Long.valueOf(gi5.f17735a));
    }

    public static void d(ei5 ei5Var) {
        p("square.feed.delete.v1", ei5Var);
    }

    public static void e(ei5 ei5Var) {
        p("square.feed.like.remove.v1", ei5Var);
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b.get(str);
    }

    public static void g(ei5 ei5Var) {
        p("square.discussion.list.v3", ei5Var);
    }

    public static void h(ei5 ei5Var) {
        p("dynamic.data.board.look.me.v1", ei5Var);
    }

    public static void i(ei5 ei5Var) {
        p("square.topic.list.v1", ei5Var);
    }

    public static void j(ei5 ei5Var) {
        p("square.feed.notice.count.v1", ei5Var);
    }

    public static void k(ei5 ei5Var) {
        p("square.feed.like.post.v1", ei5Var);
    }

    public static void l(String str, ei5 ei5Var, int i, String str2) {
        vj5.f(str, ei5Var, i, str2);
    }

    public static void m(b bVar, SquareFeed squareFeed, int i) {
        vj5.d("square.feed.unlike.v1", new a(squareFeed, i, bVar));
    }

    public static void n(ei5 ei5Var) {
        p("square.feed.like.post.v1", ei5Var);
    }

    public static void o(ei5 ei5Var) {
        p("square.feed.discussion.del.v1", ei5Var);
    }

    public static void p(String str, ei5 ei5Var) {
        q(str, ei5Var, -1);
    }

    public static void q(String str, ei5 ei5Var, int i) {
        vj5.e(str, ei5Var, i);
    }
}
