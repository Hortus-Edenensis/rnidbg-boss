package com.bytedance.sdk.openadsdk.core.pn;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.LruCache;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.n;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.gi.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static final LruCache<String, Integer> u = new LruCache<>(20);

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private int b;
        private long fx;
        private String nr;
        private int pn = 0;
        private int u;

        public u(int i, String str, int i2, long j) {
            this.u = i;
            this.nr = str;
            this.b = i2;
            this.fx = j;
        }

        public void u(int i) {
            this.pn = i;
        }
    }

    public static void nr(final bc bcVar) {
        LruCache<String, Integer> lruCache = u;
        if (lruCache.get(bcVar.nu()) != null) {
            return;
        }
        lruCache.put(bcVar.nu(), 1);
        final int iJk = jp.jk(bcVar);
        if (n.u(iJk).s() <= 0) {
            return;
        }
        x.u(new a("cacheDataCenter-recordShow") { // from class: com.bytedance.sdk.openadsdk.core.pn.fx.2
            @Override // java.lang.Runnable
            public void run() {
                String strU = jp.u(bcVar, "");
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", strU);
                contentValues.put("slot_type", Integer.valueOf(iJk));
                contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("status", Integer.valueOf(bcVar.ah() ? 2 : 1));
                contentValues.put("event_type", (Integer) 2);
                com.bytedance.sdk.openadsdk.core.multipro.u.u.insert(dw.getContext(), "meta_req_record", contentValues);
            }
        });
    }

    public static JSONObject u(bc bcVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (bcVar == null) {
            return null;
        }
        int iJk = jp.jk(bcVar);
        int iS = n.u(iJk).s();
        if (iS <= 0) {
            return null;
        }
        nr(bcVar);
        long jCurrentTimeMillis = System.currentTimeMillis() - (((long) iS) * 60000);
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "meta_req_record", null, "slot_type = ? and create_time >= ? and event_type = 1", new String[]{String.valueOf(iJk), String.valueOf(jCurrentTimeMillis)}, null, null, null);
        int i8 = 2;
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            int i9 = 0;
            int i10 = 0;
            i3 = 0;
            int i11 = 0;
            i4 = 0;
            while (true) {
                int i12 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                if (i12 == 1) {
                    i9 += cursorQuery.getInt(cursorQuery.getColumnIndex("request_count"));
                    cursorQuery.getInt(cursorQuery.getColumnIndex("response_count"));
                } else if (i12 == i8) {
                    i10 += cursorQuery.getInt(cursorQuery.getColumnIndex("request_count"));
                    i3 += cursorQuery.getInt(cursorQuery.getColumnIndex("response_count"));
                } else if (i12 == 3) {
                    i11 += cursorQuery.getInt(cursorQuery.getColumnIndex("request_count"));
                    i4 += cursorQuery.getInt(cursorQuery.getColumnIndex("response_count"));
                }
                if (!cursorQuery.moveToNext()) {
                    break;
                }
                i8 = 2;
            }
            i2 = i9 + i10 + i11;
            i = i3 + i4;
        }
        Cursor cursorQuery2 = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "meta_req_record", null, "slot_type = ? and create_time >= ? and event_type = 2", new String[]{String.valueOf(iJk), String.valueOf(jCurrentTimeMillis)}, null, null, null);
        if (cursorQuery2 == null || !cursorQuery2.moveToFirst()) {
            i5 = 0;
            i6 = 0;
            i7 = 0;
        } else {
            i5 = 0;
            int i13 = 0;
            do {
                int i14 = Integer.parseInt(cursorQuery2.getString(cursorQuery2.getColumnIndex("status")));
                if (i14 == 1) {
                    i13++;
                } else if (i14 == 2) {
                    i5++;
                }
            } while (cursorQuery2.moveToNext());
            int i15 = i13;
            i7 = i13 + i5;
            i6 = i15;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (cursorQuery2 != null) {
            cursorQuery2.close();
        }
        int i16 = i2 <= 0 ? -1 : (int) ((i * 100.0f) / i2);
        int i17 = i <= 0 ? -1 : (int) ((i3 * 100.0f) / i);
        int i18 = i <= 0 ? -1 : (int) ((i4 * 100.0f) / i);
        int i19 = (i7 <= 0 || i <= 0) ? -1 : (int) ((i7 * 100.0f) / i);
        int i20 = i7 <= 0 ? -1 : (int) ((i5 * 100.0f) / i7);
        int i21 = i7 > 0 ? (int) ((i6 * 100.0f) / i7) : -1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("send_request_sum", i2);
            jSONObject.put("send_response_sum", i);
            jSONObject.put("send_fill_rate", i16);
            jSONObject.put("send_net_rate", i17);
            jSONObject.put("send_cache_rate", i18);
            jSONObject.put("show_sum", i7);
            jSONObject.put("show_rate", i19);
            jSONObject.put("show_cache_rate", i20);
            jSONObject.put("show_net_rate", i21);
            jSONObject.put("interval_minute", iS);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void u(final u uVar, final int i) {
        if (uVar != null && n.u(uVar.u).s() > 0) {
            x.u(new a("cacheDataCenter-recordSend") { // from class: com.bytedance.sdk.openadsdk.core.pn.fx.1
                @Override // java.lang.Runnable
                public void run() {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("rit", uVar.nr);
                    contentValues.put("slot_type", Integer.valueOf(uVar.u));
                    contentValues.put("create_time", Long.valueOf(uVar.fx));
                    contentValues.put("status", Integer.valueOf(i));
                    contentValues.put("request_count", Integer.valueOf(uVar.b));
                    contentValues.put("response_count", Integer.valueOf(uVar.pn));
                    contentValues.put("event_type", (Integer) 1);
                    com.bytedance.sdk.openadsdk.core.multipro.u.u.insert(dw.getContext(), "meta_req_record", contentValues);
                }
            });
        }
    }

    public static void u() {
        x.u(new a("cacheDataCenter-clearOldData") { // from class: com.bytedance.sdk.openadsdk.core.pn.fx.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.u.u.delete(dw.getContext(), "meta_req_record", "create_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000)});
            }
        });
    }
}
