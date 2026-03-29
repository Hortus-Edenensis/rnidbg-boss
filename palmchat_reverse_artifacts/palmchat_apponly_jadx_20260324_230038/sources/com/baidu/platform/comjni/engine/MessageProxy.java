package com.baidu.platform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MessageProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseArray<List<Handler>> f4243a = new SparseArray<>();

    public static void destroy() {
        int size = f4243a.size();
        for (int i = 0; i < size; i++) {
            SparseArray<List<Handler>> sparseArray = f4243a;
            List<Handler> list = sparseArray.get(sparseArray.keyAt(i));
            if (list != null) {
                list.clear();
            }
        }
        f4243a.clear();
    }

    public static void dispatchMessage(int i, int i2, int i3, long j) {
        SparseArray<List<Handler>> sparseArray = f4243a;
        synchronized (sparseArray) {
            List<Handler> list = sparseArray.get(i);
            if (list != null && !list.isEmpty()) {
                for (Handler handler : list) {
                    Message messageObtain = Message.obtain(handler, i, i2, i3, Long.valueOf(j));
                    if (i == 39 && (i2 == 0 || i2 == 1)) {
                        handler.handleMessage(messageObtain);
                    } else {
                        messageObtain.sendToTarget();
                    }
                }
            }
        }
    }

    public static void registerMessageHandler(int i, Handler handler) {
        if (handler == null) {
            return;
        }
        SparseArray<List<Handler>> sparseArray = f4243a;
        synchronized (sparseArray) {
            List<Handler> list = sparseArray.get(i);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(handler);
                sparseArray.put(i, arrayList);
            } else if (!list.contains(handler)) {
                list.add(handler);
            }
        }
    }

    public static void unRegisterMessageHandler(int i, Handler handler) {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            SparseArray<List<Handler>> sparseArray = f4243a;
            synchronized (sparseArray) {
                List<Handler> list = sparseArray.get(i);
                if (list != null) {
                    list.remove(handler);
                }
            }
        }
    }
}
