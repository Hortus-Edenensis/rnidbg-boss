package com.zenmen.palmchat.greendao.greendaogen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.zenmen.palmchat.greendao.model.Comment;
import defpackage.yt0;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CommentDao extends AbstractDao<Comment, Long> {
    public static final String TABLENAME = "COMMENT";

    /* JADX INFO: compiled from: SearchBox */
    public static class Properties {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property f14116a = new Property(0, Long.class, "id", true, "_id");
        public static final Property b = new Property(1, Long.class, "feedId", false, "FEED_ID");
        public static final Property c = new Property(2, String.class, "content", false, "content");
        public static final Property d = new Property(3, String.class, "fromUid", false, "FROM_UID");
        public static final Property e = new Property(4, String.class, "toUid", false, "TO_UID");
        public static final Property f = new Property(5, Long.class, "createDt", false, "CREATE_DT");
        public static final Property g = new Property(6, Integer.TYPE, "type", false, "TYPE");
    }

    public CommentDao(DaoConfig daoConfig, yt0 yt0Var) {
        super(daoConfig, yt0Var);
    }

    public static void c(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"COMMENT\" (\"_id\" INTEGER PRIMARY KEY ,\"FEED_ID\" INTEGER NOT NULL ,\"content\" TEXT,\"FROM_UID\" TEXT,\"TO_UID\" TEXT,\"CREATE_DT\" INTEGER,\"TYPE\" INTEGER NOT NULL );");
    }

    public static void d(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"COMMENT\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, Comment comment) {
        sQLiteStatement.clearBindings();
        Long id = comment.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindLong(2, comment.getFeedId().longValue());
        String content = comment.getContent();
        if (content != null) {
            sQLiteStatement.bindString(3, content);
        }
        String fromUid = comment.getFromUid();
        if (fromUid != null) {
            sQLiteStatement.bindString(4, fromUid);
        }
        String toUid = comment.getToUid();
        if (toUid != null) {
            sQLiteStatement.bindString(5, toUid);
        }
        Long createDt = comment.getCreateDt();
        if (createDt != null) {
            sQLiteStatement.bindLong(6, createDt.longValue());
        }
        sQLiteStatement.bindLong(7, comment.getType());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, Comment comment) {
        databaseStatement.clearBindings();
        Long id = comment.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        databaseStatement.bindLong(2, comment.getFeedId().longValue());
        String content = comment.getContent();
        if (content != null) {
            databaseStatement.bindString(3, content);
        }
        String fromUid = comment.getFromUid();
        if (fromUid != null) {
            databaseStatement.bindString(4, fromUid);
        }
        String toUid = comment.getToUid();
        if (toUid != null) {
            databaseStatement.bindString(5, toUid);
        }
        Long createDt = comment.getCreateDt();
        if (createDt != null) {
            databaseStatement.bindLong(6, createDt.longValue());
        }
        databaseStatement.bindLong(7, comment.getType());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Long getKey(Comment comment) {
        if (comment != null) {
            return comment.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean hasKey(Comment comment) {
        return comment.getId() != null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Comment readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        Long lValueOf2 = Long.valueOf(cursor.getLong(i + 1));
        int i3 = i + 2;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 3;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 5;
        return new Comment(lValueOf, lValueOf2, string, string2, string3, cursor.isNull(i6) ? null : Long.valueOf(cursor.getLong(i6)), cursor.getInt(i + 6));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, Comment comment, int i) {
        int i2 = i + 0;
        comment.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        comment.setFeedId(Long.valueOf(cursor.getLong(i + 1)));
        int i3 = i + 2;
        comment.setContent(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        comment.setFromUid(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 4;
        comment.setToUid(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 5;
        comment.setCreateDt(cursor.isNull(i6) ? null : Long.valueOf(cursor.getLong(i6)));
        comment.setType(cursor.getInt(i + 6));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(Comment comment, long j) {
        comment.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }
}
