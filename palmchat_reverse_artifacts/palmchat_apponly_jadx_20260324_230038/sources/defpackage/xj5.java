package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.topic.bean.TopicListBean;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class xj5 extends Observable {
    public static volatile xj5 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21985a = "SquareTopicManager";
    public TopicListBean b;
    public long c;
    public boolean d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ei5<BaseNetBean<TopicListBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ir f21986a;

        /* JADX INFO: renamed from: xj5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1287a extends TypeToken<BaseNetBean<TopicListBean>> {
            public C1287a() {
            }
        }

        public a(ir irVar) {
            this.f21986a = irVar;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            return new JSONObject();
        }

        @Override // defpackage.ei5
        public BaseNetBean<TopicListBean> handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new C1287a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<TopicListBean> baseNetBean) {
            TopicListBean topicListBean;
            if (baseNetBean.isSuccess() && (topicListBean = baseNetBean.data) != null) {
                xj5.this.b = topicListBean;
                xj5.this.c = System.currentTimeMillis();
                SPUtil.f14322a.t(SPUtil.SCENE.SQUARE, k86.a("key_square_topic_list"), az2.c(xj5.this.b));
            }
            xj5.this.setChanged();
            xj5.this.notifyObservers();
            ir irVar = this.f21986a;
            if (irVar != null) {
                irVar.a(baseNetBean);
            }
            xj5.this.d = false;
            LogUtil.d("SquareTopicManager", "loadTopicList  resultCode = " + baseNetBean.resultCode);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ir<BaseNetBean<TopicListBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f21988a;
        public final /* synthetic */ d b;

        public b(long j, d dVar) {
            this.f21988a = j;
            this.b = dVar;
        }

        @Override // defpackage.ir
        public void a(BaseNetBean<TopicListBean> baseNetBean) {
            if (xj5.this.b == null || xj5.this.b.activityInfo == null || xj5.this.b.activityInfo.activityId != this.f21988a) {
                this.b.b();
            } else {
                this.b.a(xj5.this.b.activityInfo);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ir<BaseNetBean<TopicListBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21989a;

        public c(Activity activity) {
            this.f21989a = activity;
        }

        @Override // defpackage.ir
        public void a(BaseNetBean<TopicListBean> baseNetBean) {
            wj5.g().j(this.f21989a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(TopicListBean.ActivityInfo activityInfo);

        void b();
    }

    public xj5() {
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.SQUARE, k86.a("key_square_topic_list"), "");
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        this.b = (TopicListBean) az2.a(strN, TopicListBean.class);
    }

    public static xj5 h() {
        if (e == null) {
            synchronized (xj5.class) {
                if (e == null) {
                    e = new xj5();
                }
            }
        }
        return e;
    }

    @Override // java.util.Observable
    public synchronized void addObserver(Observer observer) {
        super.addObserver(observer);
        if (n()) {
            m(null);
        } else {
            observer.update(this, null);
        }
    }

    public void f() {
        deleteObservers();
        this.b = null;
        this.c = 0L;
        this.d = false;
        e = null;
        wj5.g().f();
    }

    public TopicListBean.ActivityInfo g() {
        TopicListBean topicListBean = this.b;
        if (topicListBean != null) {
            return topicListBean.activityInfo;
        }
        return null;
    }

    public List<TopicListBean.Topic> i() {
        TopicListBean topicListBean = this.b;
        if (topicListBean != null) {
            return topicListBean.getTopicList(TopicListBean.Topic.TopicType.PUBLIC);
        }
        return null;
    }

    public List<TopicListBean.Topic> j() {
        TopicListBean topicListBean = this.b;
        if (topicListBean != null) {
            return topicListBean.getTopicList(TopicListBean.Topic.TopicType.HEADER);
        }
        return null;
    }

    public String k() {
        String str;
        TopicListBean topicListBean = this.b;
        return (topicListBean == null || (str = topicListBean.topicListText) == null) ? "" : str;
    }

    public void l(long j, d dVar) {
        TopicListBean.ActivityInfo activityInfo;
        TopicListBean topicListBean = this.b;
        if (topicListBean == null || (activityInfo = topicListBean.activityInfo) == null || activityInfo.activityId != j) {
            m(new b(j, dVar));
        } else {
            dVar.a(activityInfo);
        }
    }

    public void m(ir<BaseNetBean<TopicListBean>> irVar) {
        bi5.i(new a(irVar));
        LogUtil.d("SquareTopicManager", "loadTopicList....");
        this.d = true;
    }

    public final boolean n() {
        return !this.d && (this.b == null || Math.abs(System.currentTimeMillis() - this.c) > 3600000);
    }

    public void o(Activity activity) {
        if (activity == null) {
            LogUtil.d("SquareTopicManager", "updateTopic ,null context");
        } else if (n()) {
            m(new c(activity));
            LogUtil.d("SquareTopicManager", "updateTopic ,do loading");
        } else {
            wj5.g().j(activity);
            LogUtil.d("SquareTopicManager", "updateTopic ,ignore");
        }
    }
}
