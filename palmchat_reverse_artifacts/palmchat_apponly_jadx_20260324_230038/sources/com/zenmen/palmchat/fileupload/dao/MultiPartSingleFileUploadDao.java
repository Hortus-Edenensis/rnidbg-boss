package com.zenmen.palmchat.fileupload.dao;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.C;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.k86;
import defpackage.nl0;
import defpackage.rs3;
import defpackage.wt0;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MultiPartSingleFileUploadDao extends wt0 {
    public static final String TAG = "MultiPartSingleFileUploadDao";
    private long crc32;
    private String fhash;
    private File file;
    private String fname;
    private int from;
    private long fsize;
    private int hdFlag;
    private boolean isPStoreEnable;
    private String to;
    private int type;
    private String upToken;

    public MultiPartSingleFileUploadDao(String str, int i, int i2, long j, String str2, long j2, File file, int i3, String str3, String str4, boolean z) {
        this.fhash = str;
        this.type = i;
        this.hdFlag = i2;
        this.fsize = j;
        this.fname = str2;
        this.crc32 = j2;
        this.file = file;
        this.from = i3;
        this.to = str3;
        this.upToken = str4;
        this.isPStoreEnable = z;
    }

    private JSONObject uploadOperation() throws Exception {
        String str;
        if (this.from == 1) {
            str = nl0.f + "/feed-media/v4/single.json";
        } else if (this.isPStoreEnable) {
            str = nl0.w + "/upstream/v6/single";
        } else {
            str = nl0.f + "/media/v4/single.json";
        }
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        if (!TextUtils.isEmpty(this.upToken)) {
            builderBuildUpon.appendQueryParameter("upToken", this.upToken);
        }
        String strZ = k86.Z(builderBuildUpon.build().toString());
        RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
        HashMap map = new HashMap();
        map.put("type", String.valueOf(this.type));
        map.put("fsize", String.valueOf(this.fsize));
        map.put("fname", this.fname);
        map.put("fhash", this.fhash);
        map.put("crc32", String.valueOf(this.crc32));
        map.put("hdFlag", String.valueOf(this.hdFlag));
        map.put(RemoteMessageConst.TO, this.to);
        rs3 rs3Var = new rs3(strZ, requestFutureNewFuture, requestFutureNewFuture, this.file, "file", map, true);
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        rs3Var.setRetryPolicy(new DefaultRetryPolicy(60000, wt0.retryCount, wt0.backoffMultiplier));
        normalRequestQueue.add(rs3Var);
        return new JSONObject((String) requestFutureNewFuture.get(rs3Var));
    }

    public UploadResultVo upload() throws Exception {
        return upload(true);
    }

    public UploadResultVo upload(boolean z) throws Exception {
        JSONObject jSONObjectUploadOperation = uploadOperation();
        String str = TAG;
        LogUtil.i(str, 3, new HashMap<String, Object>(jSONObjectUploadOperation) { // from class: com.zenmen.palmchat.fileupload.dao.MultiPartSingleFileUploadDao.1
            final /* synthetic */ JSONObject val$response;

            {
                this.val$response = jSONObjectUploadOperation;
                put("action", LogUtil.VALUE_FILE_UPLOAD);
                put("status", "multipart_upload");
                put("detail", jSONObjectUploadOperation.toString());
                put("type", Integer.valueOf(MultiPartSingleFileUploadDao.this.type));
                put("fileName", MultiPartSingleFileUploadDao.this.fname);
                put("fileSize", Long.valueOf(MultiPartSingleFileUploadDao.this.fsize));
                put("md5", MultiPartSingleFileUploadDao.this.fhash);
                put("isHd", Integer.valueOf(MultiPartSingleFileUploadDao.this.hdFlag));
            }
        }, (Throwable) null);
        LogUtil.i(str, "response =" + jSONObjectUploadOperation);
        int iOptInt = jSONObjectUploadOperation.optInt("resultCode");
        if (iOptInt == 401) {
            if (!z) {
                return null;
            }
            Thread.sleep(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
            return upload(false);
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectUploadOperation.optJSONObject("data");
        if (iOptInt != 0 || jSONObjectOptJSONObject == null) {
            return null;
        }
        return UploadResultVo.buildFromJsonObject(jSONObjectOptJSONObject);
    }
}
