package androidx.work.impl.model;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import com.baidu.location.LocationConst;
import com.oplus.tblplayer.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetPeriodStartTime;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkSpec = new EntityInsertionAdapter<WorkSpec>(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec`(`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) throws Throwable {
                String str = workSpec.id;
                if (str == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, str);
                }
                supportSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
                String str2 = workSpec.workerClassName;
                if (str2 == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, str2);
                }
                String str3 = workSpec.inputMergerClassName;
                if (str3 == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, str3);
                }
                byte[] byteArray = Data.toByteArray(workSpec.input);
                if (byteArray == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, byteArray);
                }
                byte[] byteArray2 = Data.toByteArray(workSpec.output);
                if (byteArray2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, byteArray2);
                }
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
                supportSQLiteStatement.bindLong(11, WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.periodStartTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                Constraints constraints = workSpec.constraints;
                if (constraints == null) {
                    supportSQLiteStatement.bindNull(16);
                    supportSQLiteStatement.bindNull(17);
                    supportSQLiteStatement.bindNull(18);
                    supportSQLiteStatement.bindNull(19);
                    supportSQLiteStatement.bindNull(20);
                    supportSQLiteStatement.bindNull(21);
                    supportSQLiteStatement.bindNull(22);
                    supportSQLiteStatement.bindNull(23);
                    return;
                }
                supportSQLiteStatement.bindLong(16, WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                supportSQLiteStatement.bindLong(17, constraints.requiresCharging() ? 1L : 0L);
                supportSQLiteStatement.bindLong(18, constraints.requiresDeviceIdle() ? 1L : 0L);
                supportSQLiteStatement.bindLong(19, constraints.requiresBatteryNotLow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(20, constraints.requiresStorageNotLow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(21, constraints.getTriggerContentUpdateDelay());
                supportSQLiteStatement.bindLong(22, constraints.getTriggerMaxContentDelay());
                byte[] bArrContentUriTriggersToByteArray = WorkTypeConverters.contentUriTriggersToByteArray(constraints.getContentUriTriggers());
                if (bArrContentUriTriggersToByteArray == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindBlob(23, bArrContentUriTriggersToByteArray);
                }
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.__preparedStmtOfSetOutput = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetPeriodStartTime = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.__preparedStmtOfMarkWorkSpecScheduled = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetScheduledState = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(ArrayMap<String, ArrayList<String>> arrayMap) {
        ArrayList<String> arrayList;
        int i;
        Set<String> setKeySet = arrayMap.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            ArrayMap<String, ArrayList<String>> arrayMap2 = new ArrayMap<>(999);
            int size = arrayMap.size();
            int i2 = 0;
            loop0: while (true) {
                i = 0;
                while (i2 < size) {
                    arrayMap2.put(arrayMap.keyAt(i2), arrayMap.valueAt(i2));
                    i2++;
                    i++;
                    if (i == 999) {
                        break;
                    }
                }
                __fetchRelationshipWorkTagAsjavaLangString(arrayMap2);
                arrayMap2 = new ArrayMap<>(999);
            }
            if (i > 0) {
                __fetchRelationshipWorkTagAsjavaLangString(arrayMap2);
                return;
            }
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size2 = setKeySet.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size2);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size2 + 0);
        int i3 = 1;
        for (String str : setKeySet) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i3);
            } else {
                roomSQLiteQueryAcquire.bindString(i3, str);
            }
            i3++;
        }
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            int columnIndex = cursorQuery.getColumnIndex("work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (cursorQuery.moveToNext()) {
                if (!cursorQuery.isNull(columnIndex) && (arrayList = arrayMap.get(cursorQuery.getString(columnIndex))) != null) {
                    arrayList.add(cursorQuery.getString(0));
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void delete(String str) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete.acquire();
        this.__db.beginTransaction();
        try {
            if (str == null) {
                supportSQLiteStatementAcquire.bindNull(1);
            } else {
                supportSQLiteStatementAcquire.bindString(1, str);
            }
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllWorkSpecIds() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForScheduling(int i) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
            int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("worker_class_name");
            int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("input_merger_class_name");
            int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("input");
            int columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow("output");
            int columnIndexOrThrow7 = cursorQuery.getColumnIndexOrThrow("initial_delay");
            int columnIndexOrThrow8 = cursorQuery.getColumnIndexOrThrow("interval_duration");
            int columnIndexOrThrow9 = cursorQuery.getColumnIndexOrThrow("flex_duration");
            int columnIndexOrThrow10 = cursorQuery.getColumnIndexOrThrow("run_attempt_count");
            int columnIndexOrThrow11 = cursorQuery.getColumnIndexOrThrow("backoff_policy");
            int columnIndexOrThrow12 = cursorQuery.getColumnIndexOrThrow("backoff_delay_duration");
            int columnIndexOrThrow13 = cursorQuery.getColumnIndexOrThrow("period_start_time");
            int columnIndexOrThrow14 = cursorQuery.getColumnIndexOrThrow("minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = cursorQuery.getColumnIndexOrThrow("schedule_requested_at");
                int columnIndexOrThrow16 = cursorQuery.getColumnIndexOrThrow("required_network_type");
                int i2 = columnIndexOrThrow14;
                int columnIndexOrThrow17 = cursorQuery.getColumnIndexOrThrow("requires_charging");
                int i3 = columnIndexOrThrow13;
                int columnIndexOrThrow18 = cursorQuery.getColumnIndexOrThrow("requires_device_idle");
                int i4 = columnIndexOrThrow12;
                int columnIndexOrThrow19 = cursorQuery.getColumnIndexOrThrow("requires_battery_not_low");
                int i5 = columnIndexOrThrow11;
                int columnIndexOrThrow20 = cursorQuery.getColumnIndexOrThrow("requires_storage_not_low");
                int i6 = columnIndexOrThrow10;
                int columnIndexOrThrow21 = cursorQuery.getColumnIndexOrThrow("trigger_content_update_delay");
                int i7 = columnIndexOrThrow9;
                int columnIndexOrThrow22 = cursorQuery.getColumnIndexOrThrow("trigger_max_content_delay");
                int i8 = columnIndexOrThrow8;
                int columnIndexOrThrow23 = cursorQuery.getColumnIndexOrThrow("content_uri_triggers");
                int i9 = columnIndexOrThrow7;
                int i10 = columnIndexOrThrow6;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    int i11 = columnIndexOrThrow;
                    String string2 = cursorQuery.getString(columnIndexOrThrow3);
                    int i12 = columnIndexOrThrow3;
                    Constraints constraints = new Constraints();
                    int i13 = columnIndexOrThrow16;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow16)));
                    constraints.setRequiresCharging(cursorQuery.getInt(columnIndexOrThrow17) != 0);
                    constraints.setRequiresDeviceIdle(cursorQuery.getInt(columnIndexOrThrow18) != 0);
                    constraints.setRequiresBatteryNotLow(cursorQuery.getInt(columnIndexOrThrow19) != 0);
                    constraints.setRequiresStorageNotLow(cursorQuery.getInt(columnIndexOrThrow20) != 0);
                    int i14 = columnIndexOrThrow18;
                    constraints.setTriggerContentUpdateDelay(cursorQuery.getLong(columnIndexOrThrow21));
                    constraints.setTriggerMaxContentDelay(cursorQuery.getLong(columnIndexOrThrow22));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow23)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow4);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow5));
                    int i15 = i10;
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i15));
                    int i16 = columnIndexOrThrow4;
                    int i17 = i9;
                    int i18 = columnIndexOrThrow5;
                    workSpec.initialDelay = cursorQuery.getLong(i17);
                    int i19 = columnIndexOrThrow17;
                    int i20 = i8;
                    workSpec.intervalDuration = cursorQuery.getLong(i20);
                    int i21 = i7;
                    workSpec.flexDuration = cursorQuery.getLong(i21);
                    int i22 = i6;
                    workSpec.runAttemptCount = cursorQuery.getInt(i22);
                    int i23 = i5;
                    i10 = i15;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(i23));
                    int i24 = i4;
                    workSpec.backoffDelayDuration = cursorQuery.getLong(i24);
                    i6 = i22;
                    int i25 = i3;
                    workSpec.periodStartTime = cursorQuery.getLong(i25);
                    i3 = i25;
                    int i26 = i2;
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(i26);
                    int i27 = columnIndexOrThrow15;
                    i2 = i26;
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(i27);
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow15 = i27;
                    columnIndexOrThrow4 = i16;
                    columnIndexOrThrow5 = i18;
                    columnIndexOrThrow3 = i12;
                    columnIndexOrThrow18 = i14;
                    columnIndexOrThrow16 = i13;
                    i9 = i17;
                    i8 = i20;
                    i5 = i23;
                    columnIndexOrThrow17 = i19;
                    i7 = i21;
                    i4 = i24;
                    columnIndexOrThrow = i11;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEnqueuedWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0", 0);
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
            int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("worker_class_name");
            int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("input_merger_class_name");
            int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("input");
            int columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow("output");
            int columnIndexOrThrow7 = cursorQuery.getColumnIndexOrThrow("initial_delay");
            int columnIndexOrThrow8 = cursorQuery.getColumnIndexOrThrow("interval_duration");
            int columnIndexOrThrow9 = cursorQuery.getColumnIndexOrThrow("flex_duration");
            int columnIndexOrThrow10 = cursorQuery.getColumnIndexOrThrow("run_attempt_count");
            int columnIndexOrThrow11 = cursorQuery.getColumnIndexOrThrow("backoff_policy");
            int columnIndexOrThrow12 = cursorQuery.getColumnIndexOrThrow("backoff_delay_duration");
            int columnIndexOrThrow13 = cursorQuery.getColumnIndexOrThrow("period_start_time");
            int columnIndexOrThrow14 = cursorQuery.getColumnIndexOrThrow("minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = cursorQuery.getColumnIndexOrThrow("schedule_requested_at");
                int columnIndexOrThrow16 = cursorQuery.getColumnIndexOrThrow("required_network_type");
                int i = columnIndexOrThrow14;
                int columnIndexOrThrow17 = cursorQuery.getColumnIndexOrThrow("requires_charging");
                int i2 = columnIndexOrThrow13;
                int columnIndexOrThrow18 = cursorQuery.getColumnIndexOrThrow("requires_device_idle");
                int i3 = columnIndexOrThrow12;
                int columnIndexOrThrow19 = cursorQuery.getColumnIndexOrThrow("requires_battery_not_low");
                int i4 = columnIndexOrThrow11;
                int columnIndexOrThrow20 = cursorQuery.getColumnIndexOrThrow("requires_storage_not_low");
                int i5 = columnIndexOrThrow10;
                int columnIndexOrThrow21 = cursorQuery.getColumnIndexOrThrow("trigger_content_update_delay");
                int i6 = columnIndexOrThrow9;
                int columnIndexOrThrow22 = cursorQuery.getColumnIndexOrThrow("trigger_max_content_delay");
                int i7 = columnIndexOrThrow8;
                int columnIndexOrThrow23 = cursorQuery.getColumnIndexOrThrow("content_uri_triggers");
                int i8 = columnIndexOrThrow7;
                int i9 = columnIndexOrThrow6;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    int i10 = columnIndexOrThrow;
                    String string2 = cursorQuery.getString(columnIndexOrThrow3);
                    int i11 = columnIndexOrThrow3;
                    Constraints constraints = new Constraints();
                    int i12 = columnIndexOrThrow16;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow16)));
                    constraints.setRequiresCharging(cursorQuery.getInt(columnIndexOrThrow17) != 0);
                    constraints.setRequiresDeviceIdle(cursorQuery.getInt(columnIndexOrThrow18) != 0);
                    constraints.setRequiresBatteryNotLow(cursorQuery.getInt(columnIndexOrThrow19) != 0);
                    constraints.setRequiresStorageNotLow(cursorQuery.getInt(columnIndexOrThrow20) != 0);
                    int i13 = columnIndexOrThrow18;
                    constraints.setTriggerContentUpdateDelay(cursorQuery.getLong(columnIndexOrThrow21));
                    constraints.setTriggerMaxContentDelay(cursorQuery.getLong(columnIndexOrThrow22));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow23)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow4);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow5));
                    int i14 = i9;
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i14));
                    int i15 = columnIndexOrThrow4;
                    int i16 = i8;
                    int i17 = columnIndexOrThrow5;
                    workSpec.initialDelay = cursorQuery.getLong(i16);
                    int i18 = columnIndexOrThrow17;
                    int i19 = i7;
                    workSpec.intervalDuration = cursorQuery.getLong(i19);
                    int i20 = i6;
                    workSpec.flexDuration = cursorQuery.getLong(i20);
                    int i21 = i5;
                    workSpec.runAttemptCount = cursorQuery.getInt(i21);
                    int i22 = i4;
                    i9 = i14;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(i22));
                    int i23 = i3;
                    workSpec.backoffDelayDuration = cursorQuery.getLong(i23);
                    i5 = i21;
                    int i24 = i2;
                    workSpec.periodStartTime = cursorQuery.getLong(i24);
                    i2 = i24;
                    int i25 = i;
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(i25);
                    i = i25;
                    int i26 = columnIndexOrThrow15;
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(i26);
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow15 = i26;
                    columnIndexOrThrow4 = i15;
                    columnIndexOrThrow5 = i17;
                    columnIndexOrThrow3 = i11;
                    columnIndexOrThrow18 = i13;
                    columnIndexOrThrow16 = i12;
                    i8 = i16;
                    i7 = i19;
                    i4 = i22;
                    columnIndexOrThrow17 = i18;
                    i6 = i20;
                    i3 = i23;
                    columnIndexOrThrow = i10;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<Data> getInputsFromPrerequisites(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(Data.fromByteArray(cursorQuery.getBlob(0)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getScheduledWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
            int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("worker_class_name");
            int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("input_merger_class_name");
            int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("input");
            int columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow("output");
            int columnIndexOrThrow7 = cursorQuery.getColumnIndexOrThrow("initial_delay");
            int columnIndexOrThrow8 = cursorQuery.getColumnIndexOrThrow("interval_duration");
            int columnIndexOrThrow9 = cursorQuery.getColumnIndexOrThrow("flex_duration");
            int columnIndexOrThrow10 = cursorQuery.getColumnIndexOrThrow("run_attempt_count");
            int columnIndexOrThrow11 = cursorQuery.getColumnIndexOrThrow("backoff_policy");
            int columnIndexOrThrow12 = cursorQuery.getColumnIndexOrThrow("backoff_delay_duration");
            int columnIndexOrThrow13 = cursorQuery.getColumnIndexOrThrow("period_start_time");
            int columnIndexOrThrow14 = cursorQuery.getColumnIndexOrThrow("minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = cursorQuery.getColumnIndexOrThrow("schedule_requested_at");
                int columnIndexOrThrow16 = cursorQuery.getColumnIndexOrThrow("required_network_type");
                int i = columnIndexOrThrow14;
                int columnIndexOrThrow17 = cursorQuery.getColumnIndexOrThrow("requires_charging");
                int i2 = columnIndexOrThrow13;
                int columnIndexOrThrow18 = cursorQuery.getColumnIndexOrThrow("requires_device_idle");
                int i3 = columnIndexOrThrow12;
                int columnIndexOrThrow19 = cursorQuery.getColumnIndexOrThrow("requires_battery_not_low");
                int i4 = columnIndexOrThrow11;
                int columnIndexOrThrow20 = cursorQuery.getColumnIndexOrThrow("requires_storage_not_low");
                int i5 = columnIndexOrThrow10;
                int columnIndexOrThrow21 = cursorQuery.getColumnIndexOrThrow("trigger_content_update_delay");
                int i6 = columnIndexOrThrow9;
                int columnIndexOrThrow22 = cursorQuery.getColumnIndexOrThrow("trigger_max_content_delay");
                int i7 = columnIndexOrThrow8;
                int columnIndexOrThrow23 = cursorQuery.getColumnIndexOrThrow("content_uri_triggers");
                int i8 = columnIndexOrThrow7;
                int i9 = columnIndexOrThrow6;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    int i10 = columnIndexOrThrow;
                    String string2 = cursorQuery.getString(columnIndexOrThrow3);
                    int i11 = columnIndexOrThrow3;
                    Constraints constraints = new Constraints();
                    int i12 = columnIndexOrThrow16;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow16)));
                    constraints.setRequiresCharging(cursorQuery.getInt(columnIndexOrThrow17) != 0);
                    constraints.setRequiresDeviceIdle(cursorQuery.getInt(columnIndexOrThrow18) != 0);
                    constraints.setRequiresBatteryNotLow(cursorQuery.getInt(columnIndexOrThrow19) != 0);
                    constraints.setRequiresStorageNotLow(cursorQuery.getInt(columnIndexOrThrow20) != 0);
                    int i13 = columnIndexOrThrow18;
                    constraints.setTriggerContentUpdateDelay(cursorQuery.getLong(columnIndexOrThrow21));
                    constraints.setTriggerMaxContentDelay(cursorQuery.getLong(columnIndexOrThrow22));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow23)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow4);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow5));
                    int i14 = i9;
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i14));
                    int i15 = columnIndexOrThrow4;
                    int i16 = i8;
                    int i17 = columnIndexOrThrow5;
                    workSpec.initialDelay = cursorQuery.getLong(i16);
                    int i18 = columnIndexOrThrow17;
                    int i19 = i7;
                    workSpec.intervalDuration = cursorQuery.getLong(i19);
                    int i20 = i6;
                    workSpec.flexDuration = cursorQuery.getLong(i20);
                    int i21 = i5;
                    workSpec.runAttemptCount = cursorQuery.getInt(i21);
                    int i22 = i4;
                    i9 = i14;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(i22));
                    int i23 = i3;
                    workSpec.backoffDelayDuration = cursorQuery.getLong(i23);
                    i5 = i21;
                    int i24 = i2;
                    workSpec.periodStartTime = cursorQuery.getLong(i24);
                    i2 = i24;
                    int i25 = i;
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(i25);
                    i = i25;
                    int i26 = columnIndexOrThrow15;
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(i26);
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow15 = i26;
                    columnIndexOrThrow4 = i15;
                    columnIndexOrThrow5 = i17;
                    columnIndexOrThrow3 = i11;
                    columnIndexOrThrow18 = i13;
                    columnIndexOrThrow16 = i12;
                    i8 = i16;
                    i7 = i19;
                    i4 = i22;
                    columnIndexOrThrow17 = i18;
                    i6 = i20;
                    i3 = i23;
                    columnIndexOrThrow = i10;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkInfo.State getState(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            return cursorQuery.moveToFirst() ? WorkTypeConverters.intToState(cursorQuery.getInt(0)) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithTag(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec getWorkSpec(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE id=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
            int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("worker_class_name");
            int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("input_merger_class_name");
            int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("input");
            int columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow("output");
            int columnIndexOrThrow7 = cursorQuery.getColumnIndexOrThrow("initial_delay");
            int columnIndexOrThrow8 = cursorQuery.getColumnIndexOrThrow("interval_duration");
            int columnIndexOrThrow9 = cursorQuery.getColumnIndexOrThrow("flex_duration");
            int columnIndexOrThrow10 = cursorQuery.getColumnIndexOrThrow("run_attempt_count");
            int columnIndexOrThrow11 = cursorQuery.getColumnIndexOrThrow("backoff_policy");
            int columnIndexOrThrow12 = cursorQuery.getColumnIndexOrThrow("backoff_delay_duration");
            int columnIndexOrThrow13 = cursorQuery.getColumnIndexOrThrow("period_start_time");
            int columnIndexOrThrow14 = cursorQuery.getColumnIndexOrThrow("minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = cursorQuery.getColumnIndexOrThrow("schedule_requested_at");
                int columnIndexOrThrow16 = cursorQuery.getColumnIndexOrThrow("required_network_type");
                int columnIndexOrThrow17 = cursorQuery.getColumnIndexOrThrow("requires_charging");
                int columnIndexOrThrow18 = cursorQuery.getColumnIndexOrThrow("requires_device_idle");
                int columnIndexOrThrow19 = cursorQuery.getColumnIndexOrThrow("requires_battery_not_low");
                int columnIndexOrThrow20 = cursorQuery.getColumnIndexOrThrow("requires_storage_not_low");
                int columnIndexOrThrow21 = cursorQuery.getColumnIndexOrThrow("trigger_content_update_delay");
                int columnIndexOrThrow22 = cursorQuery.getColumnIndexOrThrow("trigger_max_content_delay");
                int columnIndexOrThrow23 = cursorQuery.getColumnIndexOrThrow("content_uri_triggers");
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    String string2 = cursorQuery.getString(columnIndexOrThrow3);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow16)));
                    constraints.setRequiresCharging(cursorQuery.getInt(columnIndexOrThrow17) != 0);
                    constraints.setRequiresDeviceIdle(cursorQuery.getInt(columnIndexOrThrow18) != 0);
                    constraints.setRequiresBatteryNotLow(cursorQuery.getInt(columnIndexOrThrow19) != 0);
                    constraints.setRequiresStorageNotLow(cursorQuery.getInt(columnIndexOrThrow20) != 0);
                    constraints.setTriggerContentUpdateDelay(cursorQuery.getLong(columnIndexOrThrow21));
                    constraints.setTriggerMaxContentDelay(cursorQuery.getLong(columnIndexOrThrow22));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow23)));
                    workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow4);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow5));
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow6));
                    workSpec.initialDelay = cursorQuery.getLong(columnIndexOrThrow7);
                    workSpec.intervalDuration = cursorQuery.getLong(columnIndexOrThrow8);
                    workSpec.flexDuration = cursorQuery.getLong(columnIndexOrThrow9);
                    workSpec.runAttemptCount = cursorQuery.getInt(columnIndexOrThrow10);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                    workSpec.backoffDelayDuration = cursorQuery.getLong(columnIndexOrThrow12);
                    workSpec.periodStartTime = cursorQuery.getLong(columnIndexOrThrow13);
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(columnIndexOrThrow14);
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(columnIndexOrThrow15);
                    workSpec.constraints = constraints;
                } else {
                    workSpec = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.id = cursorQuery.getString(columnIndexOrThrow);
                idAndState.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec[] getWorkSpecs(List<String> list) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i);
            } else {
                roomSQLiteQueryAcquire.bindString(i, str);
            }
            i++;
        }
        Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
        try {
            columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
            columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
            columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("worker_class_name");
            columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("input_merger_class_name");
            columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("input");
            columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow("output");
            columnIndexOrThrow7 = cursorQuery.getColumnIndexOrThrow("initial_delay");
            columnIndexOrThrow8 = cursorQuery.getColumnIndexOrThrow("interval_duration");
            columnIndexOrThrow9 = cursorQuery.getColumnIndexOrThrow("flex_duration");
            columnIndexOrThrow10 = cursorQuery.getColumnIndexOrThrow("run_attempt_count");
            columnIndexOrThrow11 = cursorQuery.getColumnIndexOrThrow("backoff_policy");
            columnIndexOrThrow12 = cursorQuery.getColumnIndexOrThrow("backoff_delay_duration");
            columnIndexOrThrow13 = cursorQuery.getColumnIndexOrThrow("period_start_time");
            columnIndexOrThrow14 = cursorQuery.getColumnIndexOrThrow("minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = cursorQuery.getColumnIndexOrThrow("schedule_requested_at");
            int columnIndexOrThrow16 = cursorQuery.getColumnIndexOrThrow("required_network_type");
            int i2 = columnIndexOrThrow14;
            int columnIndexOrThrow17 = cursorQuery.getColumnIndexOrThrow("requires_charging");
            int i3 = columnIndexOrThrow13;
            int columnIndexOrThrow18 = cursorQuery.getColumnIndexOrThrow("requires_device_idle");
            int i4 = columnIndexOrThrow12;
            int columnIndexOrThrow19 = cursorQuery.getColumnIndexOrThrow("requires_battery_not_low");
            int i5 = columnIndexOrThrow11;
            int columnIndexOrThrow20 = cursorQuery.getColumnIndexOrThrow("requires_storage_not_low");
            int i6 = columnIndexOrThrow10;
            int columnIndexOrThrow21 = cursorQuery.getColumnIndexOrThrow("trigger_content_update_delay");
            int i7 = columnIndexOrThrow9;
            int columnIndexOrThrow22 = cursorQuery.getColumnIndexOrThrow("trigger_max_content_delay");
            int i8 = columnIndexOrThrow8;
            int columnIndexOrThrow23 = cursorQuery.getColumnIndexOrThrow("content_uri_triggers");
            int i9 = columnIndexOrThrow7;
            WorkSpec[] workSpecArr = new WorkSpec[cursorQuery.getCount()];
            int i10 = 0;
            while (cursorQuery.moveToNext()) {
                WorkSpec[] workSpecArr2 = workSpecArr;
                String string = cursorQuery.getString(columnIndexOrThrow);
                int i11 = columnIndexOrThrow;
                String string2 = cursorQuery.getString(columnIndexOrThrow3);
                int i12 = columnIndexOrThrow3;
                Constraints constraints = new Constraints();
                int i13 = columnIndexOrThrow16;
                constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow16)));
                constraints.setRequiresCharging(cursorQuery.getInt(columnIndexOrThrow17) != 0);
                constraints.setRequiresDeviceIdle(cursorQuery.getInt(columnIndexOrThrow18) != 0);
                constraints.setRequiresBatteryNotLow(cursorQuery.getInt(columnIndexOrThrow19) != 0);
                constraints.setRequiresStorageNotLow(cursorQuery.getInt(columnIndexOrThrow20) != 0);
                int i14 = columnIndexOrThrow19;
                constraints.setTriggerContentUpdateDelay(cursorQuery.getLong(columnIndexOrThrow21));
                constraints.setTriggerMaxContentDelay(cursorQuery.getLong(columnIndexOrThrow22));
                constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow23)));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow4);
                workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow5));
                workSpec.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow6));
                int i15 = columnIndexOrThrow18;
                int i16 = i9;
                workSpec.initialDelay = cursorQuery.getLong(i16);
                int i17 = i8;
                int i18 = columnIndexOrThrow17;
                workSpec.intervalDuration = cursorQuery.getLong(i17);
                int i19 = columnIndexOrThrow4;
                int i20 = i7;
                int i21 = columnIndexOrThrow5;
                workSpec.flexDuration = cursorQuery.getLong(i20);
                int i22 = i6;
                workSpec.runAttemptCount = cursorQuery.getInt(i22);
                int i23 = i5;
                i9 = i16;
                workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(i23));
                int i24 = i4;
                workSpec.backoffDelayDuration = cursorQuery.getLong(i24);
                int i25 = i3;
                workSpec.periodStartTime = cursorQuery.getLong(i25);
                i6 = i22;
                int i26 = i2;
                workSpec.minimumRetentionDuration = cursorQuery.getLong(i26);
                i2 = i26;
                int i27 = columnIndexOrThrow15;
                workSpec.scheduleRequestedAt = cursorQuery.getLong(i27);
                workSpec.constraints = constraints;
                workSpecArr2[i10] = workSpec;
                i10++;
                columnIndexOrThrow15 = i27;
                columnIndexOrThrow18 = i15;
                columnIndexOrThrow4 = i19;
                workSpecArr = workSpecArr2;
                columnIndexOrThrow3 = i12;
                columnIndexOrThrow19 = i14;
                columnIndexOrThrow16 = i13;
                i3 = i25;
                columnIndexOrThrow5 = i21;
                i7 = i20;
                i5 = i23;
                columnIndexOrThrow17 = i18;
                i8 = i17;
                i4 = i24;
                columnIndexOrThrow = i11;
            }
            WorkSpec[] workSpecArr3 = workSpecArr;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return workSpecArr3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec.WorkInfoPojo getWorkStatusPojoForId(String str) {
        WorkSpec.WorkInfoPojo workInfoPojo;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state, output FROM workspec WHERE id=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
            try {
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
                int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
                int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("output");
                if (cursorQuery.moveToFirst()) {
                    workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.id = cursorQuery.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        ArrayList<String> arrayList = arrayMap.get(string);
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            arrayMap.put(string, arrayList);
                        }
                        workInfoPojo.tags = arrayList;
                    }
                } else {
                    workInfoPojo = null;
                }
                __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                this.__db.setTransactionSuccessful();
                return workInfoPojo;
            } finally {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT id, state, output FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i);
            } else {
                roomSQLiteQueryAcquire.bindString(i, str);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
            try {
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
                int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
                int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("output");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.id = cursorQuery.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        ArrayList<String> arrayList2 = arrayMap.get(string);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                            arrayMap.put(string, arrayList2);
                        }
                        workInfoPojo.tags = arrayList2;
                    }
                    arrayList.add(workInfoPojo);
                }
                __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                this.__db.setTransactionSuccessful();
                return arrayList;
            } finally {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state, output FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
            try {
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
                int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
                int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("output");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.id = cursorQuery.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        ArrayList<String> arrayList2 = arrayMap.get(string);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                            arrayMap.put(string, arrayList2);
                        }
                        workInfoPojo.tags = arrayList2;
                    }
                    arrayList.add(workInfoPojo);
                }
                __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                this.__db.setTransactionSuccessful();
                return arrayList;
            } finally {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state, output FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            Cursor cursorQuery = this.__db.query(roomSQLiteQueryAcquire);
            try {
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
                int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
                int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("output");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.id = cursorQuery.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        ArrayList<String> arrayList2 = arrayMap.get(string);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                            arrayMap.put(string, arrayList2);
                        }
                        workInfoPojo.tags = arrayList2;
                    }
                    arrayList.add(workInfoPojo);
                }
                __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                this.__db.setTransactionSuccessful();
                return arrayList;
            } finally {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT id, state, output FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i);
            } else {
                roomSQLiteQueryAcquire.bindString(i, str);
            }
            i++;
        }
        return new ComputableLiveData<List<WorkSpec.WorkInfoPojo>>(this.__db.getQueryExecutor()) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.10
            private InvalidationTracker.Observer _observer;

            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.lifecycle.ComputableLiveData
            public List<WorkSpec.WorkInfoPojo> compute() {
                if (this._observer == null) {
                    this._observer = new InvalidationTracker.Observer("WorkTag", "workspec") { // from class: androidx.work.impl.model.WorkSpecDao_Impl.10.1
                        @Override // androidx.room.InvalidationTracker.Observer
                        public void onInvalidated(@NonNull Set<String> set) {
                            invalidate();
                        }
                    };
                    WorkSpecDao_Impl.this.__db.getInvalidationTracker().addWeakObserver(this._observer);
                }
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = WorkSpecDao_Impl.this.__db.query(roomSQLiteQueryAcquire);
                    try {
                        ArrayMap arrayMap = new ArrayMap();
                        int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
                        int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
                        int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("output");
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                            workInfoPojo.id = cursorQuery.getString(columnIndexOrThrow);
                            workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                            workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                            if (!cursorQuery.isNull(columnIndexOrThrow)) {
                                String string = cursorQuery.getString(columnIndexOrThrow);
                                ArrayList arrayList2 = (ArrayList) arrayMap.get(string);
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                    arrayMap.put(string, arrayList2);
                                }
                                workInfoPojo.tags = arrayList2;
                            }
                            arrayList.add(workInfoPojo);
                        }
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        cursorQuery.close();
                    }
                } finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }
        }.getLiveData();
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state, output FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return new ComputableLiveData<List<WorkSpec.WorkInfoPojo>>(this.__db.getQueryExecutor()) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.12
            private InvalidationTracker.Observer _observer;

            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.lifecycle.ComputableLiveData
            public List<WorkSpec.WorkInfoPojo> compute() {
                if (this._observer == null) {
                    this._observer = new InvalidationTracker.Observer("WorkTag", "workspec", "workname") { // from class: androidx.work.impl.model.WorkSpecDao_Impl.12.1
                        @Override // androidx.room.InvalidationTracker.Observer
                        public void onInvalidated(@NonNull Set<String> set) {
                            invalidate();
                        }
                    };
                    WorkSpecDao_Impl.this.__db.getInvalidationTracker().addWeakObserver(this._observer);
                }
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = WorkSpecDao_Impl.this.__db.query(roomSQLiteQueryAcquire);
                    try {
                        ArrayMap arrayMap = new ArrayMap();
                        int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
                        int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
                        int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("output");
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                            workInfoPojo.id = cursorQuery.getString(columnIndexOrThrow);
                            workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                            workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                            if (!cursorQuery.isNull(columnIndexOrThrow)) {
                                String string = cursorQuery.getString(columnIndexOrThrow);
                                ArrayList arrayList2 = (ArrayList) arrayMap.get(string);
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                    arrayMap.put(string, arrayList2);
                                }
                                workInfoPojo.tags = arrayList2;
                            }
                            arrayList.add(workInfoPojo);
                        }
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        cursorQuery.close();
                    }
                } finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }
        }.getLiveData();
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state, output FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return new ComputableLiveData<List<WorkSpec.WorkInfoPojo>>(this.__db.getQueryExecutor()) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.11
            private InvalidationTracker.Observer _observer;

            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.lifecycle.ComputableLiveData
            public List<WorkSpec.WorkInfoPojo> compute() {
                if (this._observer == null) {
                    this._observer = new InvalidationTracker.Observer("WorkTag", "workspec", "worktag") { // from class: androidx.work.impl.model.WorkSpecDao_Impl.11.1
                        @Override // androidx.room.InvalidationTracker.Observer
                        public void onInvalidated(@NonNull Set<String> set) {
                            invalidate();
                        }
                    };
                    WorkSpecDao_Impl.this.__db.getInvalidationTracker().addWeakObserver(this._observer);
                }
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = WorkSpecDao_Impl.this.__db.query(roomSQLiteQueryAcquire);
                    try {
                        ArrayMap arrayMap = new ArrayMap();
                        int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
                        int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
                        int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("output");
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                            workInfoPojo.id = cursorQuery.getString(columnIndexOrThrow);
                            workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                            workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                            if (!cursorQuery.isNull(columnIndexOrThrow)) {
                                String string = cursorQuery.getString(columnIndexOrThrow);
                                ArrayList arrayList2 = (ArrayList) arrayMap.get(string);
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                    arrayMap.put(string, arrayList2);
                                }
                                workInfoPojo.tags = arrayList2;
                            }
                            arrayList.add(workInfoPojo);
                        }
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        cursorQuery.close();
                    }
                } finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }
        }.getLiveData();
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int incrementWorkSpecRunAttemptCount(String str) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        this.__db.beginTransaction();
        try {
            if (str == null) {
                supportSQLiteStatementAcquire.bindNull(1);
            } else {
                supportSQLiteStatementAcquire.bindString(1, str);
            }
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void insertWorkSpec(WorkSpec workSpec) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkSpec.insert(workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int markWorkSpecScheduled(String str, long j) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.bindLong(1, j);
            if (str == null) {
                supportSQLiteStatementAcquire.bindNull(2);
            } else {
                supportSQLiteStatementAcquire.bindString(2, str);
            }
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkWorkSpecScheduled.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetScheduledState() {
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfResetScheduledState.acquire();
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetScheduledState.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetWorkSpecRunAttemptCount(String str) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        this.__db.beginTransaction();
        try {
            if (str == null) {
                supportSQLiteStatementAcquire.bindNull(1);
            } else {
                supportSQLiteStatementAcquire.bindString(1, str);
            }
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setOutput(String str, Data data) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetOutput.acquire();
        this.__db.beginTransaction();
        try {
            byte[] byteArray = Data.toByteArray(data);
            if (byteArray == null) {
                supportSQLiteStatementAcquire.bindNull(1);
            } else {
                supportSQLiteStatementAcquire.bindBlob(1, byteArray);
            }
            if (str == null) {
                supportSQLiteStatementAcquire.bindNull(2);
            } else {
                supportSQLiteStatementAcquire.bindString(2, str);
            }
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetOutput.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setPeriodStartTime(String str, long j) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetPeriodStartTime.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.bindLong(1, j);
            if (str == null) {
                supportSQLiteStatementAcquire.bindNull(2);
            } else {
                supportSQLiteStatementAcquire.bindString(2, str);
            }
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetPeriodStartTime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setState(WorkInfo.State state, String... strArr) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE workspec SET state=");
        sbNewStringBuilder.append(Constants.STRING_VALUE_UNSET);
        sbNewStringBuilder.append(" WHERE id IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, strArr.length);
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        supportSQLiteStatementCompileStatement.bindLong(1, WorkTypeConverters.stateToInt(state));
        int i = 2;
        for (String str : strArr) {
            if (str == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i, str);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
        }
    }
}
