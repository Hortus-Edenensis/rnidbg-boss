package com.android.volley;

import com.android.volley.Request;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class LXRequestHelper {
    public static final String TAG = "Volley_LXRequestHelper";
    public static boolean isPriorityEnable = true;
    public static boolean isRunInThreadEnable = true;
    private Set<Object> waitSet = new HashSet();
    private static LXRequestHelper self = new LXRequestHelper();
    private static Set<String> coreList = new HashSet<String>() { // from class: com.android.volley.LXRequestHelper.1
        {
            add("/token.ak.v12");
            add("/token.ak.v13");
            add("/one/ax/dispatch.select.v4");
        }
    };
    private static Set<String> deliveryRunInThread = new HashSet<String>() { // from class: com.android.volley.LXRequestHelper.2
        {
            add("/token.ak.v12");
            add("/token.ak.v13");
            add("/one/ax/dispatch.select.v4");
            add("/smooth/v6/update");
            add("/menu.get.v1");
        }
    };
    private static Set<String> highestPriorityList = new HashSet<String>() { // from class: com.android.volley.LXRequestHelper.3
        {
            add("/token.ak.v12");
            add("/token.ak.v13");
            add("/one/ax/dispatch.select.v4");
        }
    };
    private static Set<String> highPriorityList = new HashSet<String>() { // from class: com.android.volley.LXRequestHelper.4
        {
            add("lbs.square.friends.recommend.pull.v4");
            add("/webuic/auth/v14/auth_login.json");
        }
    };
    private static HashMap<String, Integer> requestMap = new LinkedHashMap();

    public static LXRequestHelper getInstance() {
        return self;
    }

    public static Request.Priority getPriority(Request request) {
        String url;
        Request.Priority priority = Request.Priority.NORMAL;
        if (request == null || !isPriorityEnable || (url = request.getUrl()) == null) {
            return priority;
        }
        if (highPriorityList.size() > 0) {
            Iterator<String> it = highPriorityList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (url.contains(it.next())) {
                    priority = Request.Priority.HIGH;
                    break;
                }
            }
        }
        if (highestPriorityList.size() <= 0) {
            return priority;
        }
        Iterator<String> it2 = highestPriorityList.iterator();
        while (it2.hasNext()) {
            if (url.contains(it2.next())) {
                return Request.Priority.IMMEDIATE;
            }
        }
        return priority;
    }

    public static void logRequest(Request<?> request, String str) {
        if (request != null) {
            request.getUrl();
        }
    }

    public static boolean needRunInThread(Request request) {
        String url;
        if (request != null && isRunInThreadEnable && (url = request.getUrl()) != null && deliveryRunInThread.size() > 0) {
            Iterator<String> it = deliveryRunInThread.iterator();
            while (it.hasNext()) {
                if (url.contains(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void notifyOnTokenReady() {
        LogUtil.i(TAG, "notifyOnTokenReady=" + this.waitSet.size());
        if (this.waitSet.size() > 0) {
            for (Object obj : this.waitSet) {
                try {
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.waitSet.clear();
    }

    public void waitForToken(EncryptedJsonRequest encryptedJsonRequest, long j) {
        try {
            synchronized (encryptedJsonRequest.tokenWaitObj) {
                this.waitSet.add(encryptedJsonRequest.tokenWaitObj);
                encryptedJsonRequest.tokenWaitObj.wait(j);
                this.waitSet.remove(encryptedJsonRequest.tokenWaitObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logRequest() {
        for (Map.Entry<String, Integer> entry : requestMap.entrySet()) {
            LogUtil.i("Volley_LXRequestHelperlogRequest", "logRequest count=" + entry.getValue() + " url= " + entry.getKey());
        }
    }
}
