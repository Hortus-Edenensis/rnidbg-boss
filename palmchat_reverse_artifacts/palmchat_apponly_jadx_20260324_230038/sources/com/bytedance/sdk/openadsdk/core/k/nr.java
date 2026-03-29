package com.bytedance.sdk.openadsdk.core.k;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.core.dw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static final nr u = new nr();

    public void insert(u uVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("dev1", Long.valueOf(uVar.a()));
        contentValues.put("dev2", Long.valueOf(uVar.jk()));
        contentValues.put("dev3", Long.valueOf(uVar.t()));
        contentValues.put("dev4", Long.valueOf(uVar.l()));
        contentValues.put("dev5", Integer.valueOf(uVar.mv()));
        contentValues.put("dev6", Long.valueOf(uVar.n()));
        contentValues.put("dev7", Long.valueOf(uVar.u()));
        contentValues.put("dev8", Long.valueOf(uVar.nr()));
        com.bytedance.sdk.openadsdk.core.multipro.u.u.insert(dw.getContext(), "sdk_launch", contentValues);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00bd A[DONT_GENERATE, PHI: r0 r3
      0x00bd: PHI (r0v5 java.util.ArrayList) = (r0v6 java.util.ArrayList), (r0v8 java.util.ArrayList) binds: [B:23:0x00bb, B:17:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00bd: PHI (r3v3 android.database.Cursor) = (r3v4 android.database.Cursor), (r3v5 android.database.Cursor) binds: [B:23:0x00bb, B:17:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<u> u(long j) {
        ArrayList arrayList;
        long j2 = j - 518400000;
        ArrayList arrayList2 = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "sdk_launch", null, "dev1 > ?", new String[]{String.valueOf(j2)}, null, null, "dev1 DESC");
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        long j3 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev1"));
                        long j4 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev2"));
                        long j5 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev3"));
                        long j6 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev4"));
                        long j7 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev5"));
                        long j8 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev6"));
                        long j9 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev7"));
                        ArrayList arrayList3 = arrayList2;
                        try {
                            long j10 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev8"));
                            u uVar = new u();
                            uVar.b(j3);
                            uVar.pn(j4);
                            uVar.iz(j5);
                            uVar.x(j6);
                            uVar.nr((int) j7);
                            uVar.fx(j8);
                            uVar.u(j9);
                            uVar.nr(j10);
                            arrayList = arrayList3;
                            try {
                                arrayList.add(uVar);
                                arrayList2 = arrayList;
                            } catch (Exception unused) {
                                return arrayList;
                            }
                        } catch (Exception unused2) {
                            arrayList = arrayList3;
                        }
                    }
                }
                arrayList = arrayList2;
            } catch (Exception unused3) {
                arrayList = arrayList2;
            }
            if (cursorQuery != null) {
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public void u() {
        com.bytedance.sdk.openadsdk.core.multipro.u.u.delete(dw.getContext(), "sdk_launch", "dev1 < ?", new String[]{String.valueOf(fx.pn().a() - 2592000000L)});
    }
}
