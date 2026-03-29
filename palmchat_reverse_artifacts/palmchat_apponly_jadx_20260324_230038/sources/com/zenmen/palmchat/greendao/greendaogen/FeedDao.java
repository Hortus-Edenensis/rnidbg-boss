package com.zenmen.palmchat.greendao.greendaogen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import defpackage.yt0;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class FeedDao extends AbstractDao<Feed, Long> {
    public static final String TABLENAME = "FEED";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Feed.LocationConverter f14117a;
    public final Feed.MediaListConverter b;

    /* JADX INFO: compiled from: SearchBox */
    public static class Properties {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property f14118a = new Property(0, Long.class, "feedId", true, "_id");
        public static final Property b = new Property(1, Long.class, "clientId", false, "CLIENT_ID");
        public static final Property c = new Property(2, String.class, DeviceInfoUtil.UID_TAG, false, "UID");
        public static final Property d = new Property(3, Long.class, "createDt", false, "CREATE_DT");
        public static final Property e = new Property(4, String.class, "content", false, "content");
        public static final Property f;
        public static final Property g;
        public static final Property h;
        public static final Property i;
        public static final Property j;
        public static final Property k;
        public static final Property l;
        public static final Property m;

        static {
            Class cls = Integer.TYPE;
            f = new Property(5, cls, "feedType", false, "FEED_TYPE");
            g = new Property(6, cls, "privateStatus", false, "PRIVATE_STATUS");
            h = new Property(7, cls, "status", false, "STATUS");
            i = new Property(8, String.class, "cover", false, "COVER");
            j = new Property(9, Long.class, "version", false, "VERSION");
            k = new Property(10, Integer.class, "feedSource", false, "FEED_SOURCE");
            l = new Property(11, String.class, "location", false, "LOCATION");
            m = new Property(12, String.class, "mediaList", false, "MEDIA_LIST");
        }
    }

    public FeedDao(DaoConfig daoConfig, yt0 yt0Var) {
        super(daoConfig, yt0Var);
        this.f14117a = new Feed.LocationConverter();
        this.b = new Feed.MediaListConverter();
    }

    public static void c(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"FEED\" (\"_id\" INTEGER PRIMARY KEY ,\"CLIENT_ID\" INTEGER,\"UID\" TEXT,\"CREATE_DT\" INTEGER,\"content\" TEXT,\"FEED_TYPE\" INTEGER NOT NULL ,\"PRIVATE_STATUS\" INTEGER NOT NULL ,\"STATUS\" INTEGER NOT NULL ,\"COVER\" TEXT,\"VERSION\" INTEGER,\"FEED_SOURCE\" INTEGER,\"LOCATION\" TEXT,\"MEDIA_LIST\" TEXT);");
    }

    public static void d(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"FEED\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, Feed feed) {
        sQLiteStatement.clearBindings();
        Long feedId = feed.getFeedId();
        if (feedId != null) {
            sQLiteStatement.bindLong(1, feedId.longValue());
        }
        Long clientId = feed.getClientId();
        if (clientId != null) {
            sQLiteStatement.bindLong(2, clientId.longValue());
        }
        String uid = feed.getUid();
        if (uid != null) {
            sQLiteStatement.bindString(3, uid);
        }
        Long createDt = feed.getCreateDt();
        if (createDt != null) {
            sQLiteStatement.bindLong(4, createDt.longValue());
        }
        String content = feed.getContent();
        if (content != null) {
            sQLiteStatement.bindString(5, content);
        }
        sQLiteStatement.bindLong(6, feed.getFeedType());
        sQLiteStatement.bindLong(7, feed.getPrivateStatus());
        sQLiteStatement.bindLong(8, feed.getStatus());
        String cover = feed.getCover();
        if (cover != null) {
            sQLiteStatement.bindString(9, cover);
        }
        Long version = feed.getVersion();
        if (version != null) {
            sQLiteStatement.bindLong(10, version.longValue());
        }
        if (Integer.valueOf(feed.getFeedSource()) != null) {
            sQLiteStatement.bindLong(11, r0.intValue());
        }
        Feed.Location location = feed.getLocation();
        if (location != null) {
            sQLiteStatement.bindString(12, this.f14117a.convertToDatabaseValue(location));
        }
        List<Media> mediaList = feed.getMediaList();
        if (mediaList != null) {
            sQLiteStatement.bindString(13, this.b.convertToDatabaseValue(mediaList));
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, Feed feed) {
        databaseStatement.clearBindings();
        Long feedId = feed.getFeedId();
        if (feedId != null) {
            databaseStatement.bindLong(1, feedId.longValue());
        }
        Long clientId = feed.getClientId();
        if (clientId != null) {
            databaseStatement.bindLong(2, clientId.longValue());
        }
        String uid = feed.getUid();
        if (uid != null) {
            databaseStatement.bindString(3, uid);
        }
        Long createDt = feed.getCreateDt();
        if (createDt != null) {
            databaseStatement.bindLong(4, createDt.longValue());
        }
        String content = feed.getContent();
        if (content != null) {
            databaseStatement.bindString(5, content);
        }
        databaseStatement.bindLong(6, feed.getFeedType());
        databaseStatement.bindLong(7, feed.getPrivateStatus());
        databaseStatement.bindLong(8, feed.getStatus());
        String cover = feed.getCover();
        if (cover != null) {
            databaseStatement.bindString(9, cover);
        }
        Long version = feed.getVersion();
        if (version != null) {
            databaseStatement.bindLong(10, version.longValue());
        }
        if (Integer.valueOf(feed.getFeedSource()) != null) {
            databaseStatement.bindLong(11, r0.intValue());
        }
        Feed.Location location = feed.getLocation();
        if (location != null) {
            databaseStatement.bindString(12, this.f14117a.convertToDatabaseValue(location));
        }
        List<Media> mediaList = feed.getMediaList();
        if (mediaList != null) {
            databaseStatement.bindString(13, this.b.convertToDatabaseValue(mediaList));
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Long getKey(Feed feed) {
        if (feed != null) {
            return feed.getFeedId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean hasKey(Feed feed) {
        return feed.getFeedId() != null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Feed readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        int i3 = i + 1;
        int i4 = i + 2;
        int i5 = i + 3;
        int i6 = i + 4;
        int i7 = i + 8;
        int i8 = i + 9;
        int i9 = i + 10;
        int i10 = i + 11;
        int i11 = i + 12;
        return new Feed(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)), cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.isNull(i5) ? null : Long.valueOf(cursor.getLong(i5)), cursor.isNull(i6) ? null : cursor.getString(i6), cursor.getInt(i + 5), cursor.getInt(i + 6), cursor.getInt(i + 7), cursor.isNull(i7) ? null : cursor.getString(i7), cursor.isNull(i8) ? null : Long.valueOf(cursor.getLong(i8)), cursor.isNull(i9) ? null : Integer.valueOf(cursor.getInt(i9)), cursor.isNull(i10) ? null : this.f14117a.convertToEntityProperty(cursor.getString(i10)), cursor.isNull(i11) ? null : this.b.convertToEntityProperty(cursor.getString(i11)));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, Feed feed, int i) {
        int i2 = i + 0;
        feed.setFeedId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        feed.setClientId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i4 = i + 2;
        feed.setUid(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        feed.setCreateDt(cursor.isNull(i5) ? null : Long.valueOf(cursor.getLong(i5)));
        int i6 = i + 4;
        feed.setContent(cursor.isNull(i6) ? null : cursor.getString(i6));
        feed.setFeedType(cursor.getInt(i + 5));
        feed.setPrivateStatus(cursor.getInt(i + 6));
        feed.setStatus(cursor.getInt(i + 7));
        int i7 = i + 8;
        feed.setCover(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 9;
        feed.setVersion(cursor.isNull(i8) ? null : Long.valueOf(cursor.getLong(i8)));
        int i9 = i + 10;
        feed.setFeedSource(cursor.isNull(i9) ? null : Integer.valueOf(cursor.getInt(i9)));
        int i10 = i + 11;
        feed.setLocation(cursor.isNull(i10) ? null : this.f14117a.convertToEntityProperty(cursor.getString(i10)));
        int i11 = i + 12;
        feed.setMediaList(cursor.isNull(i11) ? null : this.b.convertToEntityProperty(cursor.getString(i11)));
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
    public final Long updateKeyAfterInsert(Feed feed, long j) {
        feed.setFeedId(Long.valueOf(j));
        return Long.valueOf(j);
    }
}
