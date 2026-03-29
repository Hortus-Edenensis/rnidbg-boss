package defpackage;

import com.zenmen.palmchat.greendao.greendaogen.CommentDao;
import com.zenmen.palmchat.greendao.greendaogen.FeedDao;
import com.zenmen.palmchat.greendao.greendaogen.UnreadMessageDao;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.UnreadMessage;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class yt0 extends AbstractDaoSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DaoConfig f22266a;
    public final DaoConfig b;
    public final DaoConfig c;
    public final CommentDao d;
    public final FeedDao e;
    public final UnreadMessageDao f;

    public yt0(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        DaoConfig daoConfigClone = map.get(CommentDao.class).clone();
        this.f22266a = daoConfigClone;
        daoConfigClone.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone2 = map.get(FeedDao.class).clone();
        this.b = daoConfigClone2;
        daoConfigClone2.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone3 = map.get(UnreadMessageDao.class).clone();
        this.c = daoConfigClone3;
        daoConfigClone3.initIdentityScope(identityScopeType);
        CommentDao commentDao = new CommentDao(daoConfigClone, this);
        this.d = commentDao;
        FeedDao feedDao = new FeedDao(daoConfigClone2, this);
        this.e = feedDao;
        UnreadMessageDao unreadMessageDao = new UnreadMessageDao(daoConfigClone3, this);
        this.f = unreadMessageDao;
        registerDao(Comment.class, commentDao);
        registerDao(Feed.class, feedDao);
        registerDao(UnreadMessage.class, unreadMessageDao);
    }

    public void a() {
        this.f22266a.clearIdentityScope();
        this.b.clearIdentityScope();
        this.c.clearIdentityScope();
    }

    public CommentDao b() {
        return this.d;
    }

    public FeedDao c() {
        return this.e;
    }

    public UnreadMessageDao d() {
        return this.f;
    }
}
