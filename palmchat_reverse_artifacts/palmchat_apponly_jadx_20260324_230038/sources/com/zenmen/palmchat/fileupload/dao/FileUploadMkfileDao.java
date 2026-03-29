package com.zenmen.palmchat.fileupload.dao;

import android.net.Uri;
import android.text.TextUtils;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ir5;
import defpackage.k86;
import defpackage.nl0;
import defpackage.rb3;
import defpackage.wt0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FileUploadMkfileDao extends wt0 {
    public static final String TAG = "FileUploadMkfileDao";
    private ArrayList<String> blockIds;
    private long crc32;
    private String fhash;
    private String fname;
    private int from;
    private long fsize;
    private int hdFlag;
    private boolean isPStoreEnable;
    private String mid;
    private String oriFilePath;
    private String to;
    private int type;
    private String upToken;

    public FileUploadMkfileDao(String str, ArrayList<String> arrayList, String str2, int i, int i2, long j, String str3, long j2, String str4, int i3, String str5, String str6, boolean z) {
        this.oriFilePath = str;
        this.blockIds = arrayList;
        this.fhash = str2;
        this.type = i;
        this.hdFlag = i2;
        this.fsize = j;
        this.fname = str3;
        this.crc32 = j2;
        this.mid = str4;
        this.from = i3;
        this.upToken = str5;
        this.to = str6;
        this.isPStoreEnable = z;
    }

    private JSONObject mkFileOperation() throws Exception {
        String str;
        try {
            if (this.from == 1) {
                str = nl0.f + "/feed-media/v4/mkfile.json";
            } else if (this.isPStoreEnable) {
                str = nl0.w + "/upstream/v6/mkfile";
            } else {
                str = nl0.f + "/media/v4/mkfile.json";
            }
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            if (!TextUtils.isEmpty(this.upToken)) {
                builderBuildUpon.appendQueryParameter("upToken", this.upToken);
            }
            String strZ = k86.Z(builderBuildUpon.build().toString());
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", this.type);
            jSONObject.put("fsize", this.fsize);
            jSONObject.put("fname", this.fname);
            jSONObject.put("fhash", this.fhash);
            jSONObject.put("crc32", this.crc32);
            jSONObject.put("hdFlag", this.hdFlag);
            jSONObject.put(RemoteMessageConst.TO, this.to);
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.blockIds.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("blockIds", jSONArray);
            if (!TextUtils.isEmpty(this.oriFilePath)) {
                jSONObject.put("pfhash", rb3.b(new File(this.oriFilePath)));
            }
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            Request fileRequest = this.isPStoreEnable ? new FileRequest(1, strZ, jSONObject.toString(), requestFutureNewFuture, requestFutureNewFuture) : new EncryptedJsonRequest(1, strZ, jSONObject, requestFutureNewFuture, requestFutureNewFuture);
            fileRequest.setRetryPolicy(new DefaultRetryPolicy(wt0.waitTime, 0, 1.0f));
            normalRequestQueue.add(fileRequest);
            return (JSONObject) requestFutureNewFuture.get(fileRequest);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i(TAG, 3, new HashMap<String, Object>() { // from class: com.zenmen.palmchat.fileupload.dao.FileUploadMkfileDao.2
                {
                    put("action", LogUtil.VALUE_FILE_UPLOAD);
                    put("status", "mk_file");
                    put("type", Integer.valueOf(FileUploadMkfileDao.this.type));
                    put("fileName", FileUploadMkfileDao.this.fname);
                    put("fileSize", Long.valueOf(FileUploadMkfileDao.this.fsize));
                    put("md5", FileUploadMkfileDao.this.fhash);
                    put("isHd", Integer.valueOf(FileUploadMkfileDao.this.hdFlag));
                    put("mid", FileUploadMkfileDao.this.mid);
                }
            }, e);
            return null;
        }
    }

    public UploadResultVo mkFile() throws Exception {
        long jB = ir5.b();
        JSONObject jSONObjectMkFileOperation = mkFileOperation();
        long jB2 = ir5.b();
        String str = TAG;
        LogUtil.i(str, 3, new HashMap<String, Object>(jSONObjectMkFileOperation, jB2, jB) { // from class: com.zenmen.palmchat.fileupload.dao.FileUploadMkfileDao.1
            final /* synthetic */ long val$finishTime;
            final /* synthetic */ JSONObject val$response;
            final /* synthetic */ long val$startTime;

            {
                this.val$response = jSONObjectMkFileOperation;
                this.val$finishTime = jB2;
                this.val$startTime = jB;
                put("action", LogUtil.VALUE_FILE_UPLOAD);
                put("status", "mk_file");
                put("detail", jSONObjectMkFileOperation == null ? "response is null" : jSONObjectMkFileOperation.toString());
                put("duration", Long.valueOf(jB2 - jB));
                put("type", Integer.valueOf(FileUploadMkfileDao.this.type));
                put("fileName", FileUploadMkfileDao.this.fname);
                put("fileSize", Long.valueOf(FileUploadMkfileDao.this.fsize));
                put("md5", FileUploadMkfileDao.this.fhash);
                put("isHd", Integer.valueOf(FileUploadMkfileDao.this.hdFlag));
                put("mid", FileUploadMkfileDao.this.mid);
            }
        }, (Throwable) null);
        LogUtil.i(str, "response =" + jSONObjectMkFileOperation);
        int iOptInt = jSONObjectMkFileOperation.optInt("resultCode");
        JSONObject jSONObjectOptJSONObject = jSONObjectMkFileOperation.optJSONObject("data");
        if (iOptInt != 0 || jSONObjectOptJSONObject == null) {
            return null;
        }
        return UploadResultVo.buildFromJsonObject(jSONObjectOptJSONObject);
    }
}
