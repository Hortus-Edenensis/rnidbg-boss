package defpackage;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.ContainerUtils;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.greendao.greendaogen.CommentDao;
import com.zenmen.palmchat.greendao.greendaogen.FeedDao;
import com.zenmen.palmchat.greendao.greendaogen.UnreadMessageDao;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.UnreadMessage;
import com.zenmen.palmchat.thread.worker.TaskType;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class sq3 {
    public static volatile sq3 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20808a = "MomentsDBOperator";
    public Handler b;
    public String c;
    public qs0 d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageProto.Message f20809a;
        public final /* synthetic */ Context b;

        public a(MessageProto.Message message, Context context) {
            this.f20809a = message;
            this.b = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x010c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x010f A[Catch: JSONException -> 0x014d, Exception -> 0x028b, TRY_LEAVE, TryCatch #2 {JSONException -> 0x014d, blocks: (B:12:0x004d, B:14:0x0072, B:16:0x00ce, B:18:0x00d4, B:19:0x00d8, B:21:0x00de, B:29:0x010f), top: B:72:0x004d, outer: #0 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01ef -> B:74:0x0234). Please report as a decompilation issue!!! */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            try {
                int subType = this.f20809a.getSubType();
                if (sq3.this.d.f().queryBuilder().where(UnreadMessageDao.Properties.b.eq(this.f20809a.getMid()), new WhereCondition[0]).build().unique() == null) {
                    if (subType == 10 || subType == 12) {
                        UnreadMessage unreadMessage = new UnreadMessage();
                        unreadMessage.setMid(this.f20809a.getMid());
                        unreadMessage.setCreateTime(this.f20809a.getCreateTime());
                        unreadMessage.setSubType(this.f20809a.getSubType());
                        unreadMessage.setExtension(this.f20809a.getExtension());
                        unreadMessage.setDeleted(0);
                        unreadMessage.setRead(0);
                        try {
                            sq3.this.d.f().save(unreadMessage);
                        } catch (SQLiteException e) {
                            e.printStackTrace();
                        }
                    } else if (subType == 11) {
                        try {
                            JSONObject jSONObject = new JSONObject(this.f20809a.getExtension()).getJSONObject(MediationConstant.RIT_TYPE_FEED);
                            long j = jSONObject.getLong("feedId");
                            JSONObject jSONObject2 = jSONObject.getJSONObject("operator");
                            String str = MediationConstant.RIT_TYPE_FEED;
                            long j2 = jSONObject2.getLong(DeviceInfoUtil.UID_TAG);
                            if (jSONObject.getInt("resourceType") != 10) {
                                QueryBuilder<UnreadMessage> queryBuilder = sq3.this.d.f().queryBuilder();
                                WhereCondition whereConditionEq = UnreadMessageDao.Properties.d.eq(11);
                                Property property = UnreadMessageDao.Properties.e;
                                List<UnreadMessage> list = queryBuilder.where(whereConditionEq, property.like("%" + j + "%"), property.like("%" + j2 + "%")).build().list();
                                if (list == null || list.size() <= 0) {
                                    z = true;
                                    if (z) {
                                        UnreadMessage unreadMessage2 = new UnreadMessage();
                                        unreadMessage2.setMid(this.f20809a.getMid());
                                        unreadMessage2.setCreateTime(this.f20809a.getCreateTime());
                                        unreadMessage2.setSubType(this.f20809a.getSubType());
                                        unreadMessage2.setExtension(this.f20809a.getExtension());
                                        unreadMessage2.setDeleted(0);
                                        unreadMessage2.setRead(0);
                                        sq3.this.d.f().save(unreadMessage2);
                                    }
                                } else {
                                    Iterator<UnreadMessage> it = list.iterator();
                                    while (it.hasNext()) {
                                        String str2 = str;
                                        JSONObject jSONObject3 = new JSONObject(it.next().getExtension()).getJSONObject(str2);
                                        long j3 = jSONObject3.getLong("feedId");
                                        long j4 = jSONObject3.getJSONObject("operator").getLong(DeviceInfoUtil.UID_TAG);
                                        if (j == j3 && j2 == j4) {
                                            z = false;
                                            break;
                                        }
                                        str = str2;
                                    }
                                    z = true;
                                    if (z) {
                                    }
                                }
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    } else if (subType == 22 || subType == 21) {
                        try {
                            long j5 = new JSONObject(this.f20809a.getExtension()).getJSONObject(MediationConstant.RIT_TYPE_FEED).getLong("commentId");
                            List<UnreadMessage> list2 = sq3.this.d.f().queryBuilder().where(UnreadMessageDao.Properties.e.like("%" + j5 + "%"), new WhereCondition[0]).build().list();
                            if (list2 != null) {
                                Iterator<UnreadMessage> it2 = list2.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        UnreadMessage next = it2.next();
                                        if (j5 == new JSONObject(next.getExtension()).getJSONObject(MediationConstant.RIT_TYPE_FEED).getLong("commentId")) {
                                            next.setDeleted(1);
                                            if (subType == 21) {
                                                sq3.this.d.f().delete(next);
                                            } else {
                                                sq3.this.d.f().update(next);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        break;
                    }
                }
                if (subType == 21 || subType == 22) {
                    sq3.this.g(this.f20809a);
                    LocalBroadcastManager.getInstance(this.b).sendBroadcast(new Intent(tq3.i));
                }
                switch (subType) {
                    case 10:
                        LocalBroadcastManager.getInstance(this.b).sendBroadcast(new Intent(tq3.j));
                        LogUtil.uploadInfoImmediate("M111", null, null, null);
                        break;
                    case 11:
                    case 12:
                        sq3.this.x(this.f20809a);
                        LocalBroadcastManager.getInstance(this.b).sendBroadcast(new Intent(tq3.i));
                        LogUtil.uploadInfoImmediate("M112", null, null, null);
                        break;
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u46 f20810a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f20811a;

            public a(List list) {
                this.f20811a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f20810a.a(this.f20811a);
            }
        }

        public b(u46 u46Var) {
            this.f20810a = u46Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f20810a != null) {
                QueryBuilder<Feed> queryBuilder = sq3.this.d.e().queryBuilder();
                queryBuilder.where(FeedDao.Properties.h.eq(Integer.valueOf(tq3.h)), new WhereCondition[0]);
                queryBuilder.orderDesc(FeedDao.Properties.j);
                sq3.this.b.post(new a(sq3.this.F(queryBuilder.list())));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r46 f20812a;
        public final /* synthetic */ WhereCondition b;
        public final /* synthetic */ WhereCondition[] c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q46 f20813a;

            public a(q46 q46Var) {
                this.f20813a = q46Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f20812a.a(this.f20813a);
            }
        }

        public c(r46 r46Var, WhereCondition whereCondition, WhereCondition[] whereConditionArr) {
            this.f20812a = r46Var;
            this.b = whereCondition;
            this.c = whereConditionArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i("MomentsDBOperator", "getUnreadMessageInfo");
            if (this.f20812a != null) {
                sq3.this.b.post(new a(sq3.this.r(this.b, this.c)));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r46 f20814a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q46 f20815a;

            public a(q46 q46Var) {
                this.f20815a = q46Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f20814a.a(this.f20815a);
            }
        }

        public d(r46 r46Var) {
            this.f20814a = r46Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i("MomentsDBOperator", "getUnreadPostInfo");
            if (this.f20814a != null) {
                sq3.this.b.post(new a(sq3.this.u()));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20816a;

        public e(Context context) {
            this.f20816a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i("MomentsDBOperator", "setMomentsPostToRead");
            try {
                Database database = sq3.this.d.d().getDatabase();
                StringBuilder sb = new StringBuilder();
                sb.append("update UNREAD_MESSAGE set ");
                Property property = UnreadMessageDao.Properties.g;
                sb.append(property.columnName);
                sb.append("=1 where ");
                sb.append(UnreadMessageDao.Properties.d.columnName);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(10);
                sb.append(" and ");
                sb.append(property.columnName);
                sb.append("=0");
                database.execSQL(sb.toString());
                Intent intent = new Intent(tq3.j);
                intent.putExtra("clearPostRead", true);
                LocalBroadcastManager.getInstance(this.f20816a).sendBroadcast(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20817a;

        public f(Context context) {
            this.f20817a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i("MomentsDBOperator", "setMomentMsgToRead");
            Database database = sq3.this.d.d().getDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append("update UNREAD_MESSAGE set ");
            Property property = UnreadMessageDao.Properties.g;
            sb.append(property.columnName);
            sb.append("=1 where ");
            sb.append(property.columnName);
            sb.append("=0");
            database.execSQL(sb.toString());
            sq3.this.d.f().detachAll();
            LocalBroadcastManager.getInstance(this.f20817a).sendBroadcast(new Intent(tq3.i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Feed f20818a;

        public g(Feed feed, k kVar) {
            this.f20818a = feed;
        }

        @Override // java.lang.Runnable
        public void run() {
            sq3.this.h(this.f20818a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Feed f20819a;
        public final /* synthetic */ boolean b;

        public h(Feed feed, boolean z, k kVar) {
            this.f20819a = feed;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            sq3.this.B(this.f20819a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f20820a;

        public i(List list, k kVar) {
            this.f20820a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            sq3.this.z(this.f20820a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Long f20821a;

        public j(Long l) {
            this.f20821a = l;
        }

        @Override // java.lang.Runnable
        public void run() {
            sq3.this.d.c().queryBuilder().where(CommentDao.Properties.b.eq(this.f20821a), CommentDao.Properties.g.eq(Integer.valueOf(tq3.d))).buildDelete().executeDeleteWithoutDetachingEntities();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface k {
    }

    public sq3() {
        this.c = null;
        this.d = null;
        String strE = v4.e(com.zenmen.palmchat.c.b());
        this.c = strE;
        this.d = new qs0(com.zenmen.palmchat.c.b(), l(strE));
        this.b = new Handler(com.zenmen.palmchat.c.b().getMainLooper());
    }

    public static synchronized boolean D() {
        return e != null;
    }

    public static sq3 o() {
        if (e == null) {
            synchronized (sq3.class) {
                if (e == null) {
                    e = new sq3();
                }
            }
        }
        return e;
    }

    public void A(List<Comment> list, k kVar) {
        this.d.b().runInTx(new i(list, kVar));
    }

    public void B(Feed feed, boolean z) {
        List<Feed> listN;
        Feed feed2;
        if (feed == null) {
            return;
        }
        if (!z && (listN = n(feed.getFeedId().longValue())) != null && listN.size() > 0 && (feed2 = listN.get(0)) != null) {
            feed.setVersion(feed2.getVersion());
        }
        feed.storeSource();
        this.d.e().insertOrReplace(feed);
        this.d.c().insertOrReplaceInTx(k(feed));
    }

    public void C(Feed feed, boolean z, k kVar) {
        this.d.b().runInTx(new h(feed, z, kVar));
    }

    public void E(Context context, MessageProto.Message message) {
        l13.b(TaskType.SQLITE_IO_SINGLE).execute(new a(message, context));
    }

    public final List<Feed> F(List<Feed> list) {
        if (list == null) {
            return null;
        }
        Iterator<Feed> it = list.iterator();
        while (it.hasNext()) {
            it.next().restoreSource();
        }
        return list;
    }

    public void G(Context context) {
        l13.b(TaskType.SQLITE_IO_SINGLE).execute(new f(context));
    }

    public void H(Context context) {
        l13.b(TaskType.SQLITE_IO_SINGLE).execute(new e(context));
    }

    public void f(String str) {
        if (str == null || str.equals(this.c)) {
            return;
        }
        this.c = str;
        this.d.a(com.zenmen.palmchat.c.b(), l(str));
    }

    public final void g(MessageProto.Message message) {
        try {
            JSONObject jSONObject = new JSONObject(message.getExtension()).getJSONObject(MediationConstant.RIT_TYPE_FEED);
            long j2 = jSONObject.getLong("feedId");
            long j3 = jSONObject.getLong("commentId");
            LogUtil.d("logfeed", "deleteComment: " + jSONObject);
            this.d.c().deleteByKey(Long.valueOf(j3));
            Feed feedH = st1.f().h(j2);
            if (feedH != null) {
                int subType = message.getSubType();
                if (subType == 21) {
                    List<Comment> likesList = feedH.getLikesList();
                    Iterator<Comment> it = likesList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Comment next = it.next();
                        if (next.getId().longValue() == j3) {
                            likesList.remove(next);
                            break;
                        }
                    }
                    feedH.setLikesList(likesList);
                } else if (subType == 22) {
                    List<Comment> commentList = feedH.getCommentList();
                    Iterator<Comment> it2 = commentList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Comment next2 = it2.next();
                        if (next2.getId().longValue() == j3) {
                            commentList.remove(next2);
                            break;
                        }
                    }
                    feedH.setCommentList(commentList);
                }
                st1.f().p(feedH);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void h(Feed feed) {
        this.d.e().deleteByKey(feed.getFeedId());
        this.d.c().deleteInTx(k(feed));
    }

    public void i(Feed feed, k kVar) {
        this.d.b().runInTx(new g(feed, kVar));
    }

    public void j(Long l) {
        this.d.b().runInTx(new j(l));
    }

    public final List<Comment> k(Feed feed) {
        ArrayList arrayList = new ArrayList();
        if (feed.getCommentList() != null) {
            arrayList.addAll(feed.getCommentList());
        }
        if (feed.getLikesList() != null) {
            arrayList.addAll(feed.getLikesList());
        }
        return arrayList;
    }

    public final String l(String str) {
        return str + "moments.db";
    }

    public yt0 m() {
        return this.d.d();
    }

    public List<Feed> n(long j2) {
        QueryBuilder<Feed> queryBuilder = this.d.e().queryBuilder();
        queryBuilder.where(FeedDao.Properties.f14118a.eq(Long.valueOf(j2)), new WhereCondition[0]);
        queryBuilder.orderDesc(FeedDao.Properties.d).limit(10);
        return F(queryBuilder.list());
    }

    public long p(String str) {
        QueryBuilder<Feed> queryBuilder = this.d.e().queryBuilder();
        if (str != null) {
            queryBuilder.where(FeedDao.Properties.c.eq(str), new WhereCondition[0]);
        }
        queryBuilder.orderDesc(FeedDao.Properties.j);
        List<Feed> list = queryBuilder.limit(1).list();
        long jLongValue = (list == null || list.size() == 0) ? 0L : list.get(0).getVersion().longValue();
        LogUtil.i("MomentsDBOperator", "getMaxVersion = " + jLongValue);
        return jLongValue;
    }

    public UnreadMessageDao q() {
        return this.d.f();
    }

    public q46 r(WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        boolean z;
        JSONException e2;
        int i2;
        q46 q46Var = new q46();
        try {
            QueryBuilder<UnreadMessage> queryBuilderWhere = this.d.f().queryBuilder().where(whereCondition, whereConditionArr);
            boolean z2 = true;
            Iterator<UnreadMessage> it = queryBuilderWhere.orderDesc(UnreadMessageDao.Properties.c).build().list().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                try {
                    JSONObject jSONObject = new JSONObject(it.next().getExtension());
                    String string = jSONObject.getJSONObject(MediationConstant.RIT_TYPE_FEED).getJSONObject("operator").getString(DeviceInfoUtil.UID_TAG);
                    String strOptString = jSONObject.optJSONObject("noticeBar").optString("icon");
                    if (dn0.d(string)) {
                        i3++;
                        if (z2) {
                            try {
                                q46Var.f(string);
                                q46Var.e(strOptString);
                                z2 = false;
                            } catch (JSONException e3) {
                                e2 = e3;
                                i2 = i3;
                                z = false;
                                e2.printStackTrace();
                                z2 = z;
                                i3 = i2;
                            }
                        }
                    }
                } catch (JSONException e4) {
                    int i4 = i3;
                    z = z2;
                    e2 = e4;
                    i2 = i4;
                }
            }
            q46Var.d(i3);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return q46Var;
    }

    public void s(r46 r46Var) {
        t(r46Var, UnreadMessageDao.Properties.g.eq(0), UnreadMessageDao.Properties.d.notEq(10));
    }

    public void t(r46 r46Var, WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        l13.b(TaskType.SQLITE_IO_SINGLE).execute(new c(r46Var, whereCondition, whereConditionArr));
    }

    public q46 u() {
        q46 q46Var = new q46();
        try {
            List<UnreadMessage> list = this.d.f().queryBuilder().where(UnreadMessageDao.Properties.g.eq(0), UnreadMessageDao.Properties.d.eq(10)).orderDesc(UnreadMessageDao.Properties.c).build().list();
            if (list != null && list.size() > 0) {
                q46Var.d(list.size());
                try {
                    q46Var.f(new JSONObject(list.get(0).getExtension()).getJSONObject(MediationConstant.RIT_TYPE_FEED).getJSONObject("operator").getString(DeviceInfoUtil.UID_TAG));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return q46Var;
    }

    public void v(r46 r46Var) {
        l13.b(TaskType.SQLITE_IO_SINGLE).execute(new d(r46Var));
    }

    public void w(u46 u46Var) {
        if (this.d.b() != null) {
            this.d.b().runInTx(new b(u46Var));
        } else if (u46Var != null) {
            u46Var.a(null);
        }
    }

    public final void x(MessageProto.Message message) {
        try {
            JSONObject jSONObject = new JSONObject(message.getExtension()).getJSONObject(MediationConstant.RIT_TYPE_FEED);
            long j2 = jSONObject.getLong("feedId");
            LogUtil.d("logfeed", "insertComment: " + jSONObject);
            Comment comment = new Comment();
            comment.setFeedId(Long.valueOf(j2));
            comment.setContent(jSONObject.getString("content"));
            comment.setId(Long.valueOf(jSONObject.getLong("commentId")));
            comment.setFromUid(jSONObject.getJSONObject("operator").getString(DeviceInfoUtil.UID_TAG));
            comment.setToUid(jSONObject.optString("toUid"));
            comment.setCreateDt(Long.valueOf(message.getCreateTime()));
            int subType = message.getSubType();
            if (subType == 11) {
                comment.setType(tq3.d);
            } else if (subType == 12) {
                comment.setType(tq3.e);
            }
            y(comment);
            Feed feedH = st1.f().h(j2);
            if (feedH != null) {
                boolean z = true;
                if (subType == 12) {
                    List<Comment> commentList = feedH.getCommentList();
                    Iterator<Comment> it = commentList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        } else if (it.next().getId().longValue() == comment.getId().longValue()) {
                            break;
                        }
                    }
                    if (!z) {
                        commentList.add(comment);
                    }
                } else if (subType == 11) {
                    List<Comment> likesList = feedH.getLikesList();
                    Iterator<Comment> it2 = likesList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        } else if (it2.next().getId().longValue() == comment.getId().longValue()) {
                            break;
                        }
                    }
                    if (!z) {
                        likesList.add(comment);
                    }
                }
            }
            st1.f().p(feedH);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void y(Comment comment) {
        this.d.c().insertOrReplace(comment);
    }

    public void z(List<Comment> list) {
        this.d.c().insertOrReplaceInTx(list);
    }
}
