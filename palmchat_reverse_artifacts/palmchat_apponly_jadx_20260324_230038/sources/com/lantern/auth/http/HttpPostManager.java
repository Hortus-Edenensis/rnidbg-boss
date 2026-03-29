package com.lantern.auth.http;

import android.os.Handler;
import android.os.Message;
import com.lantern.auth.core.BLCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class HttpPostManager {
    private Executor cachedThreadPool = Executors.newCachedThreadPool();
    private Map<Integer, TaskBean> map = new HashMap();
    private static HttpPostManager mInstance = new HttpPostManager();
    private static Handler handler = new Handler() { // from class: com.lantern.auth.http.HttpPostManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (HttpPostManager.mInstance) {
                if (HttpPostManager.mInstance.map.containsKey(Integer.valueOf(message.what))) {
                    TaskBean taskBean = (TaskBean) HttpPostManager.mInstance.map.remove(Integer.valueOf(message.what));
                    taskBean.callback.run(13, null, null);
                    taskBean.task.cancel(false);
                }
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class TaskBean {
        public BLCallback callback;
        public HttpPostTask task;

        private TaskBean() {
        }
    }

    private static int genMsgKey() {
        int iNextInt = new Random().nextInt();
        return mInstance.map.containsKey(Integer.valueOf(iNextInt)) ? genMsgKey() : iNextInt;
    }

    public static Executor getExecutorPool() {
        return mInstance.cachedThreadPool;
    }

    public static synchronized void init() {
    }

    public static synchronized void postMap(Map<String, String> map, BLCallback bLCallback, String str) {
        postMap(map, bLCallback, str, 5000L);
    }

    public static synchronized void postMap(Map<String, String> map, BLCallback bLCallback, String str, long j) {
        HashMap map2 = new HashMap(map);
        int iGenMsgKey = genMsgKey();
        TaskBean taskBean = new TaskBean();
        HttpPostTask httpPostTask = new HttpPostTask(iGenMsgKey, new BLCallback() { // from class: com.lantern.auth.http.HttpPostManager.2
            @Override // com.lantern.auth.core.BLCallback
            public void run(int i, String str2, Object obj) {
                synchronized (HttpPostManager.mInstance) {
                    if (obj == null) {
                        return;
                    }
                    TaskResp taskResp = (TaskResp) obj;
                    if (HttpPostManager.mInstance.map.containsKey(Integer.valueOf(taskResp.taskId))) {
                        ((TaskBean) HttpPostManager.mInstance.map.remove(Integer.valueOf(taskResp.taskId))).callback.run(i, str2, taskResp.resp);
                        HttpPostManager.handler.removeMessages(taskResp.taskId);
                    }
                }
            }
        }, str, map2);
        taskBean.task = httpPostTask;
        taskBean.callback = bLCallback;
        mInstance.map.put(Integer.valueOf(iGenMsgKey), taskBean);
        httpPostTask.executeOnExecutor(mInstance.cachedThreadPool, new Void[0]);
        if (j > 0) {
            handler.sendEmptyMessageDelayed(iGenMsgKey, j);
        }
    }
}
