package com.lantern.core.database;

import android.content.Context;
import com.lantern.core.business.Event;
import com.lantern.core.database.SqliteDataStore;
import com.lantern.core.log.MyLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DataStoreManager {
    public static final String DB_LOG = "wkdbtag";
    public static final String DB_NAME = "wkstore.db";
    public static final int DB_VERSION = 2;
    private final Context mContext;
    private final SpDataStore mSpStore;
    private final SqliteDataStore mSqliteStore;

    public DataStoreManager(Context context) {
        this.mContext = context;
        this.mSpStore = new SpDataStore(context);
        this.mSqliteStore = new SqliteDataStore(context);
    }

    public long addEvent(Event event) {
        if (DataStoreUtils.isLackDiskSpace(this.mContext)) {
            this.mSqliteStore.deleteExtraData();
            this.mSpStore.deleteAllSp();
        }
        long jInsertEvent = this.mSqliteStore.insertEvent(event);
        MyLog.save("", "event = " + event.getEventId() + ", save Database result = " + jInsertEvent);
        if (jInsertEvent >= 0 || !this.mSpStore.addEventBySp(event)) {
            return jInsertEvent;
        }
        MyLog.save("", "event = " + event.getEventId() + ", save sp success");
        return 1L;
    }

    public void addEventSp(Event event) {
        this.mSpStore.addEventBySp(event);
    }

    public void closeDatabase() {
        this.mSqliteStore.close();
    }

    public List<Event> getEvents(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.addAll(this.mSqliteStore.getEventList(it.next()));
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public List<Event> getTopCountDataByLevel(int i, int i2) {
        return this.mSqliteStore.getEventList(i, i2);
    }

    public boolean removeListData(List<Event> list) {
        boolean zDeleteListItem;
        boolean z;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (Event event : list) {
            if (event.getSaveSrc() == 0) {
                arrayList.add(String.valueOf(event.getSaveDateTime()));
            } else if (event.getSaveSrc() == 1) {
                String strValueOf = String.valueOf(event.getSaveDateTime());
                int level = event.getLevel();
                if (level == 1) {
                    arrayList2.add(strValueOf);
                } else if (level == 2) {
                    arrayList3.add(strValueOf);
                } else if (level == 3) {
                    arrayList4.add(strValueOf);
                }
            }
        }
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (int i = 0; i < arrayList.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append("'" + ((String) arrayList.get(i)) + "'");
            }
            sb.append(")");
            zDeleteListItem = this.mSqliteStore.deleteListItem(sb.toString());
        } else {
            zDeleteListItem = true;
        }
        try {
            if (arrayList2.size() > 0) {
                this.mSpStore.deleteSpEventList(arrayList2, 1);
            }
            if (arrayList3.size() > 0) {
                this.mSpStore.deleteSpEventList(arrayList3, 2);
            }
            if (arrayList4.size() > 0) {
                this.mSpStore.deleteSpEventList(arrayList4, 3);
            }
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        return zDeleteListItem && z;
    }

    public void setDBErrListener(SqliteDataStore.IDbErrListener iDbErrListener) {
        this.mSqliteStore.setDbErrListener(iDbErrListener);
    }

    public List<Event> getEvents(String str) {
        return this.mSqliteStore.getEventList(str);
    }
}
