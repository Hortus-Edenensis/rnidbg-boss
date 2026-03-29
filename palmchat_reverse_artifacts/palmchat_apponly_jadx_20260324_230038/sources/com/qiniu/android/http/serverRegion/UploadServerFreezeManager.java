package com.qiniu.android.http.serverRegion;

import com.qiniu.android.utils.Utils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UploadServerFreezeManager {
    private static final UploadServerFreezeManager manager = new UploadServerFreezeManager();
    private ConcurrentHashMap<String, UploadServerFreezeItem> frozenInfo = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class UploadServerFreezeItem {
        private Date freezeDate;
        protected final String type;

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void freeze(int i) {
            this.freezeDate = new Date(Utils.currentTimestamp() + ((long) (i * 1000)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean isFrozenByDate(Date date) {
            boolean z;
            Date date2 = this.freezeDate;
            if (date2 != null) {
                z = date2.getTime() >= date.getTime();
            }
            return z;
        }

        private UploadServerFreezeItem(String str) {
            this.type = str;
        }
    }

    public static UploadServerFreezeManager getInstance() {
        return manager;
    }

    public void freezeType(String str, int i) {
        if (str == null || str.length() == 0) {
            return;
        }
        UploadServerFreezeItem uploadServerFreezeItem = this.frozenInfo.get(str);
        if (uploadServerFreezeItem == null) {
            uploadServerFreezeItem = new UploadServerFreezeItem(str);
            this.frozenInfo.put(str, uploadServerFreezeItem);
        }
        uploadServerFreezeItem.freeze(i);
    }

    public boolean isTypeFrozen(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        UploadServerFreezeItem uploadServerFreezeItem = this.frozenInfo.get(str);
        return uploadServerFreezeItem != null && uploadServerFreezeItem.isFrozenByDate(new Date());
    }

    public void unfreezeType(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        this.frozenInfo.remove(str);
    }
}
