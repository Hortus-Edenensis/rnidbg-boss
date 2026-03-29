package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.zenmen.palmchat.greendao.greendaogen.CommentDao;
import com.zenmen.palmchat.greendao.greendaogen.FeedDao;
import com.zenmen.palmchat.greendao.greendaogen.UnreadMessageDao;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class xt0 extends AbstractDaoMaster {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends DatabaseOpenHelper {
        public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 3);
        }
    }

    public xt0(Database database) {
        super(database, 3);
        registerDaoClass(CommentDao.class);
        registerDaoClass(FeedDao.class);
        registerDaoClass(UnreadMessageDao.class);
    }

    public static void a(Database database, boolean z) {
        CommentDao.c(database, z);
        FeedDao.c(database, z);
        UnreadMessageDao.d(database, z);
    }

    public static void b(Database database, boolean z) {
        CommentDao.d(database, z);
        FeedDao.d(database, z);
        UnreadMessageDao.e(database, z);
    }

    @Override // org.greenrobot.greendao.AbstractDaoMaster
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public yt0 newSession() {
        return new yt0(this.db, IdentityScopeType.Session, this.daoConfigMap);
    }

    @Override // org.greenrobot.greendao.AbstractDaoMaster
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public yt0 newSession(IdentityScopeType identityScopeType) {
        return new yt0(this.db, identityScopeType, this.daoConfigMap);
    }
}
