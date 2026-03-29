package com.lantern.core.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.lantern.core.business.Event;
import com.lantern.core.configuration.ConfigConstant;
import defpackage.cn1;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SpDataStore {
    private static final String FILENAME_BACKUP = "event_backup_new_";
    private Context mContext;
    private File mSharedPreferenceDir;
    private final String KEY_TIME = "keytime";
    private final String KEY_LEVEL = "level";
    private final String KEY_ID = ConfigConstant.COLUMN_EVENTID;
    private final String KEY_BODY = "eventbody";
    private final String KEY_SOURCE = "eventsource";
    private final String KEY_STATE = "eventstate";
    private final String KEY_PUB = "eventpub";
    private final String KEY_TC = "eventtc";
    private FilenameFilter mBackFilter = new FilenameFilter() { // from class: com.lantern.core.database.SpDataStore.1
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith("event_backup_new_");
        }
    };

    public SpDataStore(Context context) {
        this.mContext = context;
        File filesDir = context.getFilesDir();
        if (filesDir != null && filesDir.exists()) {
            this.mSharedPreferenceDir = new File(filesDir.getParentFile(), "shared_prefs");
            return;
        }
        this.mSharedPreferenceDir = new File("/data/data/" + this.mContext.getPackageName(), "shared_prefs");
    }

    private static String getFileName(Context context) {
        return cn1.a(context.getApplicationContext()).replace(".", "_").replace(":", "_") + "_event_backup_new_";
    }

    public synchronized boolean addEventBySp(Event event) {
        SharedPreferences.Editor editorEdit;
        JSONObject jSONObject = new JSONObject();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject.put("keytime", jCurrentTimeMillis);
            jSONObject.put(ConfigConstant.COLUMN_EVENTID, event.getEventId());
            jSONObject.put("level", event.getLevel());
            jSONObject.put("eventbody", event.getExtra());
            jSONObject.put("eventsource", event.getSource());
            jSONObject.put("eventstate", event.getState());
            if (event.getPubParams().length > 0) {
                jSONObject.put("eventpub", Base64.encodeToString(event.getPubParams(), 0));
            }
            if (event.getTaiChi().length > 0) {
                jSONObject.put("eventtc", Base64.encodeToString(event.getTaiChi(), 0));
            }
            editorEdit = this.mContext.getSharedPreferences(getFileName(this.mContext) + event.getLevel(), 0).edit();
            editorEdit.putString(String.valueOf(jCurrentTimeMillis), jSONObject.toString());
        } catch (JSONException e) {
            Log.i(DataStoreManager.DB_LOG, e.toString());
            return false;
        }
        return editorEdit.commit();
    }

    public synchronized void deleteAllSp() {
        File[] fileArrListFiles = this.mSharedPreferenceDir.listFiles(this.mBackFilter);
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                String name = file.getName();
                this.mContext.getSharedPreferences(name.substring(0, name.indexOf(".")), 0).edit().clear().commit();
                file.delete();
            }
        }
    }

    public synchronized boolean deleteSpEventList(List<String> list, int i) {
        SharedPreferences.Editor editorEdit;
        editorEdit = this.mContext.getSharedPreferences(getFileName(this.mContext) + i, 0).edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        return editorEdit.commit();
    }

    public synchronized List<Event> getSpEventList(int i, int i2) {
        String str = getFileName(this.mContext) + i;
        ArrayList arrayList = new ArrayList();
        Map<String, ?> all = this.mContext.getSharedPreferences(str, 0).getAll();
        if (all != null && all.size() != 0) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    JSONObject jSONObject = new JSONObject((String) it.next().getValue());
                    Event event = new Event();
                    event.setSaveDateTime(jSONObject.optLong("keytime"));
                    event.setEventId(jSONObject.optString(ConfigConstant.COLUMN_EVENTID));
                    event.setLevel(jSONObject.optInt("level"));
                    event.setExtra(jSONObject.optString("eventbody"));
                    event.setSource(jSONObject.optString("eventsource"));
                    event.setState(jSONObject.optInt("eventstate"));
                    event.setSaveSrc(1);
                    if (!TextUtils.isEmpty(jSONObject.optString("eventpub"))) {
                        event.setPubParams(Base64.decode(jSONObject.optString("eventpub"), 0));
                    }
                    if (!TextUtils.isEmpty(jSONObject.optString("eventtc"))) {
                        event.setTaiChi(Base64.decode(jSONObject.optString("eventtc"), 0));
                    }
                    arrayList.add(event);
                } catch (Exception e) {
                    Log.i(DataStoreManager.DB_LOG, e.toString());
                }
                if (arrayList.size() == i2) {
                    return arrayList;
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public void writeDbExcpData(String str) {
        Event event = new Event();
        event.setEventId("new_event_exceptions");
        event.setExtra(str);
        event.setLevel(3);
        addEventBySp(event);
    }
}
