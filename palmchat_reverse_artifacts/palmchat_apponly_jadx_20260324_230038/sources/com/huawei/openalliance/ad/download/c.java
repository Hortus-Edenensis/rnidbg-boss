package com.huawei.openalliance.ad.download;

import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.download.DownloadTask;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c<T extends DownloadTask> {
    private static final String Code = "DownloadQueue";
    private Queue<T> V = new ConcurrentLinkedQueue();

    public T Code(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (fh.Code()) {
            fh.Code(Code, "findTask, workingQueue.size:%s", Integer.valueOf(this.V.size()));
        }
        return (T) Code(this.V, str);
    }

    public void V() {
        this.V.clear();
    }

    private T Code(Queue<T> queue, String str) {
        if (fh.Code()) {
            fh.Code(Code, "findTaskFromQueue, taskId:%s", str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (T t : queue) {
            if (str.equals(t.F())) {
                return t;
            }
        }
        return null;
    }

    public boolean V(T t) {
        if (t == null || !this.V.contains(t)) {
            return false;
        }
        this.V.remove(t);
        return true;
    }

    public Queue<T> Code() {
        return this.V;
    }

    public void Code(T t) {
        if (t == null || this.V.contains(t)) {
            return;
        }
        this.V.offer(t);
    }
}
