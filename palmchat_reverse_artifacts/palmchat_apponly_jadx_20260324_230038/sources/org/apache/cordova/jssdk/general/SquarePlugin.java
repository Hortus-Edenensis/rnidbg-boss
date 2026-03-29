package org.apache.cordova.jssdk.general;

import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.v93;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class SquarePlugin extends SubPlugin {
    private void openFeedDetail(JSONObject jSONObject, v93 v93Var) {
        SquareFeed squareFeed = new SquareFeed();
        squareFeed.id = jSONObject.optLong("feedId", -1L);
        squareFeed.exid = jSONObject.optString(bd.h);
        squareFeed.uid = jSONObject.optString(DeviceInfoUtil.UID_TAG);
        squareFeed.feedType = jSONObject.optInt("feedType", 2);
        int iOptInt = jSONObject.optInt("from", 28);
        if (squareFeed.id != -1 && (!TextUtils.isEmpty(squareFeed.exid) || !TextUtils.isEmpty(squareFeed.uid))) {
            MediaViewActivity.B1(iOptInt, this.mCordovaInterface.getActivity(), squareFeed, false);
            v93Var.a(makeDefaultSucMsg());
            return;
        }
        JSONObject jSONObjectMakeInvalidArgsMsg = makeInvalidArgsMsg();
        try {
            jSONObjectMakeInvalidArgsMsg.put("msg", "feed id or exid or uid is null");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        v93Var.a(jSONObjectMakeInvalidArgsMsg);
    }

    @Override // defpackage.ib3
    public void exec(String str, JSONObject jSONObject, v93 v93Var) {
        str.hashCode();
        if (str.equals(Action.ACTION_SQUARE_OPEN_FEED_DETAIL)) {
            openFeedDetail(jSONObject, v93Var);
        } else {
            super.exec(str, jSONObject, v93Var);
        }
    }
}
