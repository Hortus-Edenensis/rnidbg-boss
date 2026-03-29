package defpackage;

import android.content.Intent;
import android.os.AsyncTask;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.greendao.greendaogen.UnreadMessageDao;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.UnreadMessage;
import com.zenmen.square.R$string;
import com.zenmen.square.mvp.model.bean.PlaceFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class l42 extends ar<PlaceFeed> {
    public int c = 0;
    public List<PlaceFeed> d = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements d<List<PlaceFeed>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ir f18901a;

        public a(ir irVar) {
            this.f18901a = irVar;
        }

        @Override // l42.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<PlaceFeed> a() {
            l42.this.r();
            l42.this.c = 0;
            return l42.this.p();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.List<com.zenmen.square.mvp.model.bean.PlaceFeed>] */
        @Override // l42.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<PlaceFeed> list) {
            if (list != null && list.size() > 0) {
                l42.this.d = list;
                if (list.size() < 20) {
                    PlaceFeed placeFeed = new PlaceFeed();
                    placeFeed.bottomTips = com.zenmen.palmchat.c.b().getString(R$string.square_bottom_list_promt);
                    l42.this.d.add(placeFeed);
                }
            }
            BaseNetListBean baseNetListBean = new BaseNetListBean();
            baseNetListBean.resultCode = 0;
            baseNetListBean.data = l42.this.d;
            this.f18901a.a(baseNetListBean);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements d<List<PlaceFeed>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ir f18902a;

        public b(ir irVar) {
            this.f18902a = irVar;
        }

        @Override // l42.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<PlaceFeed> a() {
            return l42.this.p();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.List<com.zenmen.square.mvp.model.bean.PlaceFeed>] */
        @Override // l42.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<PlaceFeed> list) {
            if (list != null) {
                l42.this.d.addAll(list);
                if (list.size() < 20) {
                    PlaceFeed placeFeed = new PlaceFeed();
                    placeFeed.bottomTips = com.zenmen.palmchat.c.b().getString(R$string.square_bottom_list_promt);
                    l42.this.d.add(placeFeed);
                }
            }
            BaseNetListBean baseNetListBean = new BaseNetListBean();
            baseNetListBean.resultCode = 0;
            baseNetListBean.data = l42.this.d;
            this.f18902a.a(baseNetListBean);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c<R> extends AsyncTask<Object, Void, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d<R> f18903a;

        public c(d<R> dVar) {
            this.f18903a = dVar;
        }

        @Override // android.os.AsyncTask
        public R doInBackground(Object... objArr) {
            return this.f18903a.a();
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(R r) {
            this.f18903a.onPostExecute(r);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d<R> {
        R a();

        void onPostExecute(R r);
    }

    public static void q(d dVar) {
        new c(dVar).executeOnExecutor(jo1.b(), new Object[0]);
    }

    @Override // defpackage.om2
    public void d(ir<BaseNetListBean<PlaceFeed>> irVar) {
        q(new b(irVar));
    }

    @Override // defpackage.om2
    public List<PlaceFeed> e() {
        return this.d;
    }

    @Override // defpackage.om2
    public void f(ir<BaseNetListBean<PlaceFeed>> irVar) {
        q(new a(irVar));
    }

    @Override // defpackage.ar
    public boolean i() {
        return false;
    }

    public final PlaceFeed m(UnreadMessage unreadMessage) {
        try {
            Feed feed = new Feed();
            JSONObject jSONObject = new JSONObject(unreadMessage.getExtension());
            JSONObject jSONObject2 = jSONObject.getJSONObject(MediationConstant.RIT_TYPE_FEED);
            String strOptString = jSONObject.getJSONObject("noticeBar").optString("noticeTitle");
            feed.setCover(unreadMessage.getMid());
            feed.setFeedId(Long.valueOf(jSONObject2.getLong("feedId")));
            feed.setUid(jSONObject2.getString("feedUid"));
            feed.setFeedType(jSONObject2.getInt("resourceType"));
            feed.setContent(jSONObject2.getString("resource"));
            Comment comment = new Comment();
            comment.setId(Long.valueOf(jSONObject2.getLong("commentId")));
            comment.setFeedId(feed.getFeedId());
            comment.setCreateDt(Long.valueOf(jSONObject2.getLong("createTime")));
            comment.setFromUid(jSONObject2.getJSONObject("operator").getString(DeviceInfoUtil.UID_TAG));
            if (unreadMessage.hasDeleted()) {
                comment.setContent(com.zenmen.palmchat.c.b().getString(R$string.square_comment_delete_prompt));
            } else {
                comment.setContent(jSONObject2.getString("content"));
            }
            if (unreadMessage.getSubType().intValue() == 11) {
                comment.setType(tq3.d);
            } else {
                comment.setType(tq3.e);
                comment.setToUid(jSONObject2.optString("toUid"));
            }
            PlaceFeed placeFeed = new PlaceFeed();
            placeFeed.feed = feed;
            placeFeed.comment = comment;
            placeFeed.noticeTitle = strOptString;
            ContactInfoItem contactInfoItemA = dn0.a(comment.getFromUid());
            if (contactInfoItemA != null) {
                placeFeed.sex = contactInfoItemA.getGender();
            } else {
                placeFeed.sex = -1;
            }
            if (feed.getFeedType() == 2 || feed.getFeedType() == 3 || feed.getFeedType() == 10 || feed.getFeedType() == 6 || feed.getFeedType() == 7) {
                placeFeed.thumbnail = new JSONObject(feed.getContent()).getJSONArray("urls").getJSONObject(0).getString(feed.getFeedType() == 6 ? "url" : "thumbUrl");
            }
            return placeFeed;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final List<PlaceFeed> p() {
        ArrayList arrayList = new ArrayList();
        if (sq3.o().q() == null) {
            return arrayList;
        }
        QueryBuilder<UnreadMessage> queryBuilder = sq3.o().q().queryBuilder();
        Property property = UnreadMessageDao.Properties.d;
        long jCount = queryBuilder.where(property.notEq(10), property.notEq(10)).buildCount().count();
        while (arrayList.size() < 20 && this.c < jCount) {
            QueryBuilder<UnreadMessage> queryBuilder2 = sq3.o().q().queryBuilder();
            Property property2 = UnreadMessageDao.Properties.d;
            List<UnreadMessage> list = queryBuilder2.where(property2.notEq(10), property2.notEq(10)).orderDesc(UnreadMessageDao.Properties.c).offset(this.c).limit(20 - arrayList.size()).build().list();
            this.c += list.size();
            Iterator<UnreadMessage> it = list.iterator();
            while (it.hasNext()) {
                PlaceFeed placeFeedM = m(it.next());
                if (placeFeedM != null && dn0.d(placeFeedM.comment.getFromUid())) {
                    arrayList.add(placeFeedM);
                }
            }
        }
        return arrayList;
    }

    public final void r() {
        Database database = sq3.o().m().getDatabase();
        StringBuilder sb = new StringBuilder();
        sb.append("update UNREAD_MESSAGE set ");
        Property property = UnreadMessageDao.Properties.g;
        sb.append(property.columnName);
        sb.append("=1 where ");
        sb.append(property.columnName);
        sb.append("=0");
        database.execSQL(sb.toString());
        sq3.o().q().detachAll();
        LocalBroadcastManager.getInstance(com.zenmen.palmchat.c.b()).sendBroadcast(new Intent(tq3.i));
    }

    @Override // defpackage.om2
    public void destroy() {
    }

    @Override // defpackage.om2
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void c(int i, PlaceFeed placeFeed) {
    }

    @Override // defpackage.om2
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void g(int i, PlaceFeed placeFeed) {
    }
}
