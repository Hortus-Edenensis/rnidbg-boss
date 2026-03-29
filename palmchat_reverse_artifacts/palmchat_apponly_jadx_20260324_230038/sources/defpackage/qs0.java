package defpackage;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import com.zenmen.palmchat.greendao.greendaogen.CommentDao;
import com.zenmen.palmchat.greendao.greendaogen.FeedDao;
import com.zenmen.palmchat.greendao.greendaogen.UnreadMessageDao;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.xt0;
import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.database.Database;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class qs0 {
    public static final Uri g = Uri.parse("content://com.zenmen.palmchat.friendcircle/feeds");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CommentDao f20310a = null;
    public FeedDao b = null;
    public UnreadMessageDao c = null;
    public yt0 d;
    public AsyncSession e;
    public a f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends xt0.a {
        public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }

        @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
        public void onCreate(Database database) {
            Log.i("greenDAO", "Creating tables for schema version 3");
            xt0.a(database, true);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            LogUtil.d("logdb", "moments: downgrade begin --> from version " + i + " to " + i2);
            try {
                ep3.c().e(wrap(sQLiteDatabase), FeedDao.class);
                ep3.c().e(wrap(sQLiteDatabase), CommentDao.class);
                ep3.c().e(wrap(sQLiteDatabase), UnreadMessageDao.class);
            } catch (Exception unused) {
                xt0.b(wrap(sQLiteDatabase), true);
                onCreate(sQLiteDatabase);
            }
            LogUtil.d("logdb", "moments: downgrade end --> from version " + i + " to " + i2);
        }

        @Override // org.greenrobot.greendao.database.DatabaseOpenHelper, android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            super.onOpen(sQLiteDatabase);
            LogUtil.d("logdb", "moments: open version " + sQLiteDatabase.getVersion());
        }

        @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
        public void onUpgrade(Database database, int i, int i2) {
            LogUtil.d("logdb", "moments: upgrade begin --> from version " + i + " to " + i2);
            Log.i("greenDAO", "Upgrading schema from version " + i + " to " + i2 + " by dropping all tables");
            ep3.c().e(database, FeedDao.class);
            LogUtil.d("logdb", "moments: upgrade end --> from version " + i + " to " + i2);
        }
    }

    public qs0(Application application, String str) {
        g(application, str);
    }

    public void a(Application application, String str) {
        try {
            if (this.f != null) {
                this.d.a();
                this.f.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        g(application, str);
    }

    public AsyncSession b() {
        return this.e;
    }

    public CommentDao c() {
        return this.f20310a;
    }

    public yt0 d() {
        return this.d;
    }

    public FeedDao e() {
        return this.b;
    }

    public UnreadMessageDao f() {
        return this.c;
    }

    public final void g(Application application, String str) {
        try {
            a aVar = new a(application, str, null);
            this.f = aVar;
            yt0 yt0VarNewSession = new xt0(aVar.getWritableDb()).newSession();
            this.d = yt0VarNewSession;
            this.e = yt0VarNewSession.startAsyncSession();
            this.f20310a = this.d.b();
            this.b = this.d.c();
            this.c = this.d.d();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
