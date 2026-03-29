package com.lantern.auth.http;

import android.os.AsyncTask;
import com.lantern.auth.android.BLNetwork;
import com.lantern.auth.app.FunDC;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLHttp;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.pb.PBRequestBean;
import com.lantern.auth.pb.PBResponse;
import com.lantern.auth.pb.util.PbUtils;
import com.lantern.auth.server.WkParams;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PBPostTask extends AsyncTask {
    private PBRequestBean reqBean;

    private PBPostTask(PBRequestBean pBRequestBean) {
        this.reqBean = pBRequestBean;
    }

    public static AsyncTask doPostPB(PBRequestBean pBRequestBean) {
        PBPostTask pBPostTask = new PBPostTask(pBRequestBean);
        pBPostTask.executeOnExecutor(HttpPostManager.getExecutorPool(), new Object[0]);
        return pBPostTask;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        PBRequestBean pBRequestBean = this.reqBean;
        byte[] request = PbUtils.getRequest(pBRequestBean.pid, pBRequestBean.reqByte);
        try {
            BLHttp bLHttp = new BLHttp(this.reqBean.url);
            bLHttp.setHeader("Content-Type", "application/octet-stream");
            bLHttp.setTimeout(3000, 3000);
            byte[] bArrPost = bLHttp.post(request);
            if (bArrPost == null) {
                return null;
            }
            PBResponse response = PbUtils.getResponse(bArrPost);
            BLLog.d(response.getRetmsg(), new Object[0]);
            return response;
        } catch (Exception e) {
            HashMap<String, String> mapGenExt = FunDC.genExt(WkParams.RETCD, BLNetwork.isNetworkConnected(WkSDKManager.getContext()) ? "2" : "1");
            PBRequestBean pBRequestBean2 = this.reqBean;
            if (pBRequestBean2 != null) {
                mapGenExt.put("url", pBRequestBean2.url);
                mapGenExt.put("pid", this.reqBean.pid);
            }
            mapGenExt.put("ErrName", e.getClass().getName());
            mapGenExt.put("ErrMsg", e.getMessage());
            FunDC.onEvent(FunDC.AUTH_FUNID_NETERR, mapGenExt);
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        String retmsg;
        if (obj != null) {
            PBResponse pBResponse = (PBResponse) obj;
            retmsg = pBResponse.getRetmsg();
            if (pBResponse.isSuccess() && pBResponse.getServerData() != null && pBResponse.getServerData().length > 0) {
                this.reqBean.callback.run(1, retmsg, pBResponse);
                return;
            }
        } else {
            retmsg = "";
        }
        this.reqBean.callback.run(10, retmsg, obj);
    }
}
