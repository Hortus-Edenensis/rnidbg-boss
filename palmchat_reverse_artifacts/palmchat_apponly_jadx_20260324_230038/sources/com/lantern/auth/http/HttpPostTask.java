package com.lantern.auth.http;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.lantern.auth.android.BLNetwork;
import com.lantern.auth.android.ResTool;
import com.lantern.auth.app.FunDC;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLHttp;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.server.WkParams;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class HttpPostTask extends AsyncTask<Void, Integer, TaskResp> {
    private BLCallback callback;
    private String errMsg;
    private Map<String, String> paramsMap;
    private int retCode;
    private int retryCount;
    private int retrylim;
    private int taskId;
    private String url;

    public HttpPostTask(int i, BLCallback bLCallback, String str, Map<String, String> map) {
        this(i, bLCallback, str, map, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String doPost() {
        String strPostMap;
        this.retryCount++;
        if (BLNetwork.isNetworkConnected(WkSDKManager.getContext())) {
            try {
                strPostMap = BLHttp.postMap(this.url, this.paramsMap);
            } catch (Exception e) {
                HashMap<String, String> mapGenExt = FunDC.genExt(WkParams.RETCD, "2");
                mapGenExt.put("url", this.url);
                mapGenExt.put("ErrName", e.getClass().getName());
                mapGenExt.put("ErrMsg", e.getMessage());
                FunDC.onEvent(FunDC.AUTH_FUNID_NETERR, mapGenExt);
                e.printStackTrace();
                strPostMap = "";
            }
            BLLog.d("http post " + this.url + "  result " + strPostMap, new Object[0]);
            if (TextUtils.isEmpty(strPostMap)) {
                try {
                    JSONObject jSONObject = new JSONObject(strPostMap);
                    if ("0".equals(jSONObject.optString(WkParams.RETCD))) {
                        this.retCode = 1;
                    } else {
                        this.errMsg = jSONObject.getString(WkParams.RETMSG);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.retCode = 30;
                }
            } else {
                this.retCode = 10;
            }
            return strPostMap;
        }
        this.retCode = 10;
        this.errMsg = WkSDKManager.getContext().getString(ResTool.getStringId("wk_no_network", WkSDKManager.getContext()));
        HashMap<String, String> mapGenExt2 = FunDC.genExt(WkParams.RETCD, "1");
        mapGenExt2.put("url", this.url);
        FunDC.onEvent(FunDC.AUTH_FUNID_NETERR, mapGenExt2);
        strPostMap = "";
        BLLog.d("http post " + this.url + "  result " + strPostMap, new Object[0]);
        if (TextUtils.isEmpty(strPostMap)) {
        }
        return strPostMap;
    }

    public HttpPostTask(int i, BLCallback bLCallback, String str, Map<String, String> map, int i2) {
        this.retryCount = 0;
        this.taskId = i;
        this.callback = bLCallback;
        this.paramsMap = map;
        this.url = str;
        this.retrylim = i2;
    }

    @Override // android.os.AsyncTask
    public TaskResp doInBackground(Void... voidArr) {
        String strDoPost = "";
        for (int i = 0; i < this.retrylim; i++) {
            try {
                strDoPost = doPost();
                if (!TextUtils.isEmpty(strDoPost)) {
                    break;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        TaskResp taskResp = new TaskResp();
        taskResp.taskId = this.taskId;
        taskResp.resp = strDoPost;
        return taskResp;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(TaskResp taskResp) {
        this.callback.run(this.retCode, this.errMsg, taskResp);
    }
}
