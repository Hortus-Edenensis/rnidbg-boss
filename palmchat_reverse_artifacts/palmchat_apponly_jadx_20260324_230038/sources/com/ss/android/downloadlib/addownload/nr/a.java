package com.ss.android.downloadlib.addownload.nr;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.l;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static a u = new a();
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences fx() {
        return com.bytedance.sdk.openadsdk.ats.b.u(l.getContext(), "sp_ad_download_event", 0);
    }

    @NonNull
    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.u.nr> nr() {
        ConcurrentHashMap<Long, com.ss.android.downloadad.api.u.nr> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = fx().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long jLongValue = Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.downloadad.api.u.nr nrVarNr = com.ss.android.downloadad.api.u.nr.nr(new JSONObject(String.valueOf(entry.getValue())));
                    if (jLongValue > 0 && nrVarNr != null) {
                        concurrentHashMap.put(Long.valueOf(jLongValue), nrVarNr);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return concurrentHashMap;
    }

    public static a u() {
        return u.u;
    }

    public void u(com.ss.android.downloadad.api.u.nr nrVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(nrVar);
        u((Collection<com.ss.android.downloadad.api.u.nr>) arrayList);
    }

    public synchronized void u(final Collection<com.ss.android.downloadad.api.u.nr> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.addownload.nr.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor editorEdit = a.this.fx().edit();
                        for (com.ss.android.downloadad.api.u.nr nrVar : collection) {
                            if (nrVar != null && nrVar.nr() != 0) {
                                editorEdit.putString(String.valueOf(nrVar.nr()), nrVar.tm().toString());
                            }
                        }
                        editorEdit.apply();
                    }
                }, true);
            }
        }
    }

    public void u(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.addownload.nr.a.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = a.this.fx().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    editorEdit.remove((String) it.next());
                }
                editorEdit.apply();
            }
        }, true);
    }
}
