package defpackage;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ki5 extends tt1<SquareFeed> {
    public ContactInfoItem h;
    public ei5<BaseNetBean<SquareFeed>> i = new b();
    public ei5 j = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ei5<BaseNetBean> {

        /* JADX INFO: renamed from: ki5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1224a extends TypeToken<BaseNetBean> {
            public C1224a() {
            }
        }

        public a() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("feedId", Long.valueOf(((SquareFeed) ki5.this.f21064a).id));
            map.put("exFeedUid", ((SquareFeed) ki5.this.f21064a).exid);
            map.put("random", System.currentTimeMillis() + "");
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new C1224a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean baseNetBean) {
            if (ki5.this.b == null) {
                return;
            }
            if (baseNetBean.isSuccess()) {
                ki5 ki5Var = ki5.this;
                T t = ki5Var.f21064a;
                if (((SquareFeed) t).ifLike) {
                    ((SquareFeed) t).likeNums--;
                } else {
                    ((SquareFeed) t).likeNums++;
                }
                ((SquareFeed) t).ifLike = true ^ ((SquareFeed) t).ifLike;
                ki5Var.c((SquareFeed) t);
                SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
                squareFeedEvent.eventType = 2;
                squareFeedEvent.feed = (SquareFeed) ki5.this.f21064a;
                an1.c().l(squareFeedEvent);
                return;
            }
            int i = baseNetBean.resultCode;
            if (i == 1008) {
                ki5 ki5Var2 = ki5.this;
                T t2 = ki5Var2.f21064a;
                ((SquareFeed) t2).likeNums++;
                ((SquareFeed) t2).ifLike = true;
                ki5Var2.c((SquareFeed) t2);
                return;
            }
            if (i != 1012) {
                if (i != 1006) {
                }
                ki5.this.g(i, baseNetBean.getErrMsg());
                return;
            }
            ki5 ki5Var3 = ki5.this;
            T t3 = ki5Var3.f21064a;
            ((SquareFeed) t3).likeNums--;
            ((SquareFeed) t3).ifLike = false;
            ki5Var3.c((SquareFeed) t3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ei5<BaseNetBean<SquareFeed>> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean<SquareFeed>> {
            public a() {
            }
        }

        public b() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("feedId", Long.valueOf(ki5.this.f));
            if (!TextUtils.isEmpty(ki5.this.e)) {
                map.put("feedUid", ki5.this.e);
            }
            if (!TextUtils.isEmpty(ki5.this.d)) {
                map.put("feedExid", ki5.this.d);
            }
            LocationEx locationExI = d.g().i(86400000L);
            if (locationExI != null) {
                map.put("cityCode", locationExI.getCityCode());
                map.put("longitude", locationExI.getLongitude() + "");
                map.put("latitude", locationExI.getLatitude() + "");
            }
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean<SquareFeed> handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<SquareFeed> baseNetBean) {
            if (baseNetBean.isSuccess() && baseNetBean.data != null) {
                SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
                squareFeedEvent.feed = baseNetBean.data;
                squareFeedEvent.eventType = 2;
                an1.c().l(squareFeedEvent);
                ki5.this.c(baseNetBean.data);
                return;
            }
            int i = baseNetBean.resultCode;
            if (i == 1016 || i == 1107) {
                if (ki5.this.f21064a != 0) {
                    SquareFeedEvent squareFeedEvent2 = new SquareFeedEvent();
                    squareFeedEvent2.feed = (SquareFeed) ki5.this.f21064a;
                    squareFeedEvent2.eventType = 3;
                    an1.c().l(squareFeedEvent2);
                }
                fi5 fi5Var = new fi5();
                SquareFeed squareFeed = new SquareFeed();
                fi5Var.f17534a = squareFeed;
                squareFeed.id = ki5.this.f;
                squareFeed.deleted = 2;
                ds0.a().b(fi5Var);
            }
            ki5.this.f(baseNetBean);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ei5<BaseNetBean> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean> {
            public a() {
            }
        }

        public c() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("feedId", Long.valueOf(((SquareFeed) ki5.this.f21064a).id));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean baseNetBean) {
            if (!baseNetBean.isSuccess()) {
                qj5.q((SquareFeed) ki5.this.f21064a, 2, 4);
                ki5.this.d(baseNetBean.resultCode, baseNetBean.getErrMsg());
                return;
            }
            SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
            squareFeedEvent.eventType = 3;
            squareFeedEvent.feed = (SquareFeed) ki5.this.f21064a;
            an1.c().l(squareFeedEvent);
            fi5 fi5Var = new fi5();
            fi5Var.f17534a = (SquareFeed) ki5.this.f21064a;
            ds0.a().b(fi5Var);
            qj5.q((SquareFeed) ki5.this.f21064a, 1, 4);
            ki5.this.e();
        }
    }

    public void i() {
        bi5.p("square.feed.delete.v1", this.j);
    }

    public ContactInfoItem j() {
        return this.h;
    }

    public SquareFeed k() {
        return (SquareFeed) this.f21064a;
    }

    public int l() {
        T t = this.f21064a;
        return (t == 0 || ((SquareFeed) t).feedType != 1) ? 0 : 21;
    }

    public void m() {
        if (this.c == 15) {
            bi5.p("square.feed.get.session.v8", this.i);
        } else {
            bi5.p("square.feed.get.v9", this.i);
        }
    }

    @Override // defpackage.tt1
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void c(SquareFeed squareFeed) {
        super.c(squareFeed);
        this.f = squareFeed.id;
        this.d = squareFeed.exid;
    }

    public void o() {
        bi5.c(((SquareFeed) this.f21064a).ifLike, new a());
    }

    public void p(ContactInfoItem contactInfoItem) {
        this.h = contactInfoItem;
    }
}
