package com.zenmen.palmchat.greendao.greendaogen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.zenmen.palmchat.greendao.model.UnreadMessage;
import defpackage.yt0;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class UnreadMessageDao extends AbstractDao<UnreadMessage, Long> {
    public static final String TABLENAME = "UNREAD_MESSAGE";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yt0 f14119a;

    /* JADX INFO: compiled from: SearchBox */
    public static class Properties {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property f14120a = new Property(0, Long.class, "id", true, "_id");
        public static final Property b = new Property(1, String.class, "mid", false, "MID");
        public static final Property c = new Property(2, Long.TYPE, "createTime", false, "CREATE_TIME");
        public static final Property d;
        public static final Property e;
        public static final Property f;
        public static final Property g;

        static {
            Class cls = Integer.TYPE;
            d = new Property(3, cls, SharePluginInfo.ISSUE_SUB_TYPE, false, "SUB_TYPE");
            e = new Property(4, String.class, "extension", false, "EXTENSION");
            f = new Property(5, cls, "deleted", false, "DELETED");
            g = new Property(6, cls, "read", false, "READ");
        }
    }

    public UnreadMessageDao(DaoConfig daoConfig, yt0 yt0Var) {
        super(daoConfig, yt0Var);
        this.f14119a = yt0Var;
    }

    public static void d(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"UNREAD_MESSAGE\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"MID\" TEXT UNIQUE ,\"CREATE_TIME\" INTEGER NOT NULL ,\"SUB_TYPE\" INTEGER NOT NULL ,\"EXTENSION\" TEXT,\"DELETED\" INTEGER NOT NULL ,\"READ\" INTEGER NOT NULL );");
    }

    public static void e(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"UNREAD_MESSAGE\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void attachEntity(UnreadMessage unreadMessage) {
        super.attachEntity(unreadMessage);
        unreadMessage.__setDaoSession(this.f14119a);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, UnreadMessage unreadMessage) {
        sQLiteStatement.clearBindings();
        Long id = unreadMessage.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String mid = unreadMessage.getMid();
        if (mid != null) {
            sQLiteStatement.bindString(2, mid);
        }
        sQLiteStatement.bindLong(3, unreadMessage.getCreateTime().longValue());
        sQLiteStatement.bindLong(4, unreadMessage.getSubType().intValue());
        String extension = unreadMessage.getExtension();
        if (extension != null) {
            sQLiteStatement.bindString(5, extension);
        }
        sQLiteStatement.bindLong(6, unreadMessage.getDeleted());
        sQLiteStatement.bindLong(7, unreadMessage.getRead());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, UnreadMessage unreadMessage) {
        databaseStatement.clearBindings();
        Long id = unreadMessage.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        String mid = unreadMessage.getMid();
        if (mid != null) {
            databaseStatement.bindString(2, mid);
        }
        databaseStatement.bindLong(3, unreadMessage.getCreateTime().longValue());
        databaseStatement.bindLong(4, unreadMessage.getSubType().intValue());
        String extension = unreadMessage.getExtension();
        if (extension != null) {
            databaseStatement.bindString(5, extension);
        }
        databaseStatement.bindLong(6, unreadMessage.getDeleted());
        databaseStatement.bindLong(7, unreadMessage.getRead());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Long getKey(UnreadMessage unreadMessage) {
        if (unreadMessage != null) {
            return unreadMessage.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean hasKey(UnreadMessage unreadMessage) {
        return unreadMessage.getId() != null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public UnreadMessage readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 4;
        return new UnreadMessage(lValueOf, string, cursor.getLong(i + 2), cursor.getInt(i + 3), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.getInt(i + 5), cursor.getInt(i + 6));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, UnreadMessage unreadMessage, int i) {
        int i2 = i + 0;
        unreadMessage.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        unreadMessage.setMid(cursor.isNull(i3) ? null : cursor.getString(i3));
        unreadMessage.setCreateTime(cursor.getLong(i + 2));
        unreadMessage.setSubType(cursor.getInt(i + 3));
        int i4 = i + 4;
        unreadMessage.setExtension(cursor.isNull(i4) ? null : cursor.getString(i4));
        unreadMessage.setDeleted(cursor.getInt(i + 5));
        unreadMessage.setRead(cursor.getInt(i + 6));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(UnreadMessage unreadMessage, long j) {
        unreadMessage.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }
}
