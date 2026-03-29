package com.bytedance.sdk.openadsdk.core.pn.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.pn.b.x;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements nr {
    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void nr(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", (Integer) 0);
        com.bytedance.sdk.openadsdk.core.multipro.u.u.update(dw.getContext(), "union_meta_cache", contentValues, "rit =?", new String[]{str});
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void u(String str, x.nr nrVar, iz izVar, x.u uVar, u uVar2) {
        if (uVar.fx() <= 0) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "union_meta_cache", null, "rit =?", new String[]{str}, null, null, "create_time ASC");
        if (cursorQuery != null) {
            if (uVar.fx() > 0 && cursorQuery.getCount() >= uVar.fx()) {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(Constant.MAP_KEY_UUID));
                if (uVar2 != null) {
                    uVar2.u(new x.nr(cursorQuery.getString(cursorQuery.getColumnIndex("meta_data")), cursorQuery.getLong(cursorQuery.getColumnIndex("create_time")), cursorQuery.getLong(cursorQuery.getColumnIndex("expire_time")), cursorQuery.getString(cursorQuery.getColumnIndex(Constant.MAP_KEY_UUID))));
                }
                com.bytedance.sdk.openadsdk.core.multipro.u.u.delete(dw.getContext(), "union_meta_cache", "rit=? AND uuid=?", new String[]{str, string});
            }
            cursorQuery.close();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put(Constant.MAP_KEY_UUID, nrVar.pn);
        contentValues.put("create_time", Long.valueOf(nrVar.u));
        contentValues.put("save_version", Integer.valueOf(nrVar.b));
        contentValues.put("expire_time", Long.valueOf(nrVar.nr));
        contentValues.put("slot_type", uVar.u());
        contentValues.put("is_using", Integer.valueOf(izVar.u ? 1 : 0));
        contentValues.put("priority", Integer.valueOf(izVar.nr));
        contentValues.put("ad_index", Integer.valueOf(izVar.fx));
        contentValues.put("meta_data", nrVar.fx);
        com.bytedance.sdk.openadsdk.core.multipro.u.u.insert(dw.getContext(), "union_meta_cache", contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public x.nr u(String str, x.u uVar, long j) {
        Cursor cursorU = u(uVar, str);
        if (cursorU == null) {
            return null;
        }
        while (cursorU.moveToNext()) {
            try {
                String string = cursorU.getString(cursorU.getColumnIndex("meta_data"));
                long j2 = cursorU.getLong(cursorU.getColumnIndex("create_time"));
                long j3 = cursorU.getLong(cursorU.getColumnIndex("expire_time"));
                if (j <= 0 || j2 >= j) {
                    return new x.nr(string, j2, j3, cursorU.getString(cursorU.getColumnIndex(Constant.MAP_KEY_UUID)));
                }
            } finally {
                cursorU.close();
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public x.nr u(String str, x.u uVar, long j, List<String> list) {
        Cursor cursorU = u(uVar, str);
        if (cursorU == null) {
            return null;
        }
        while (cursorU.moveToNext()) {
            try {
                String string = cursorU.getString(cursorU.getColumnIndex(Constant.MAP_KEY_UUID));
                if (string == null || list == null || !list.contains(string)) {
                    String string2 = cursorU.getString(cursorU.getColumnIndex("meta_data"));
                    long j2 = cursorU.getLong(cursorU.getColumnIndex("create_time"));
                    long j3 = cursorU.getLong(cursorU.getColumnIndex("expire_time"));
                    if (j <= 0 || j2 >= j) {
                        return new x.nr(string2, j2, j3, string);
                    }
                }
            } finally {
                cursorU.close();
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void u(String str) {
        com.bytedance.sdk.openadsdk.core.multipro.u.u.delete(dw.getContext(), "union_meta_cache", "rit =?", new String[]{str});
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void u(x.u uVar) {
        com.bytedance.sdk.openadsdk.core.multipro.u.u.delete(dw.getContext(), "union_meta_cache", "slot_type =?", new String[]{uVar.u()});
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void u(String str, x.u uVar, u uVar2) {
        Cursor cursorQuery;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (uVar2 != null && (cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "union_meta_cache", null, "expire_time <? AND rit =?", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null)) != null) {
            while (cursorQuery.moveToNext()) {
                uVar2.u(new x.nr(cursorQuery.getString(cursorQuery.getColumnIndex("meta_data")), cursorQuery.getLong(cursorQuery.getColumnIndex("create_time")), cursorQuery.getLong(cursorQuery.getColumnIndex("expire_time")), cursorQuery.getString(cursorQuery.getColumnIndex(Constant.MAP_KEY_UUID))));
            }
            cursorQuery.close();
        }
        if (uVar.nr()) {
            com.bytedance.sdk.openadsdk.core.multipro.u.u.delete(dw.getContext(), "union_meta_cache", "rit =? AND (save_version!=? OR expire_time <?)", new String[]{str, "7232", String.valueOf(jCurrentTimeMillis)});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.u.u.delete(dw.getContext(), "union_meta_cache", "rit =? AND expire_time <?", new String[]{str, String.valueOf(jCurrentTimeMillis)});
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void u(String str, String str2) {
        com.bytedance.sdk.openadsdk.core.multipro.u.u.delete(dw.getContext(), "union_meta_cache", "rit =? AND uuid =?", new String[]{str, str2});
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void u(String str, String str2, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", Boolean.valueOf(z));
        com.bytedance.sdk.openadsdk.core.multipro.u.u.update(dw.getContext(), "union_meta_cache", contentValues, "rit =? AND uuid =?", new String[]{str, str2});
    }

    private Cursor u(x.u uVar, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iB = uVar.b();
        if (iB == 1) {
            if (uVar.nr()) {
                return com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7232"}, null, null, "create_time DESC");
            }
            return com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "create_time DESC");
        }
        if (iB == 2) {
            if (uVar.nr()) {
                return com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7232"}, null, null, "priority DESC");
            }
            return com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "priority DESC");
        }
        if (iB != 3) {
            if (uVar.nr()) {
                return com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7232"}, null, null, null);
            }
            return com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        }
        if (uVar.nr()) {
            return com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7232"}, null, null, "ad_index ASC, create_time DESC");
        }
        return com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "ad_index ASC, create_time DESC");
    }
}
