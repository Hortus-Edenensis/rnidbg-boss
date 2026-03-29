package com.zenmen.palmchat.fileupload.dao;

import androidx.media3.common.C;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.huawei.hms.ads.ex;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.hx3;
import defpackage.ir5;
import defpackage.k86;
import defpackage.nl0;
import defpackage.wt0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FileUploadCheckDao extends wt0 {
    public static final String TAG = "FileUploadCheckDao";
    private boolean checkSize;
    private int from;
    private boolean isExpression;
    private boolean isPStoreEnable;
    private String md5;
    private String mid;
    private String to;
    private long totalSize;
    private int type;

    /* JADX INFO: compiled from: SearchBox */
    public class CheckVO {
        public static final int TYPE_EXIST = 2;
        public static final int TYPE_NOT_EXIST = 0;
        public static final int TYPE_PARTLY_EXIST = 1;
        public int blockSize;
        public ArrayList<BlockVo> blockVOs;
        public int chunkSize;
        public int type;
        public String upToken;
        public UploadResultVo uploadResultVo;

        public CheckVO(JSONObject jSONObject) {
            this.type = 0;
            String strOptString = jSONObject.optString("exists");
            if (strOptString != null && strOptString.equals(ex.Code)) {
                this.type = 2;
                this.uploadResultVo = UploadResultVo.buildFromJsonObject(jSONObject);
                return;
            }
            if (strOptString.equals(ex.V)) {
                this.type = 0;
                this.blockSize = jSONObject.optInt("blockSize");
                this.chunkSize = jSONObject.optInt("chunkSize");
                this.upToken = jSONObject.optString("upToken");
                return;
            }
            if (strOptString.equals("partly")) {
                this.type = 1;
                this.blockSize = jSONObject.optInt("blockSize");
                this.chunkSize = jSONObject.optInt("chunkSize");
                this.upToken = jSONObject.optString("upToken");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("blocks");
                if (jSONArrayOptJSONArray != null) {
                    this.blockVOs = new ArrayList<>();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                            if (jSONObject2 != null) {
                                BlockVo blockVo = new BlockVo();
                                blockVo.blockId = jSONObject2.optString("blockId");
                                blockVo.index = jSONObject2.optInt("index");
                                blockVo.size = jSONObject2.optInt("size");
                                blockVo.offset = jSONObject2.optInt("offset");
                                this.blockVOs.add(blockVo);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public FileUploadCheckDao(String str, int i, long j, String str2, int i2, boolean z, boolean z2, String str3, boolean z3) {
        this.md5 = str;
        this.type = i;
        this.totalSize = j;
        this.mid = str2;
        this.from = i2;
        this.isExpression = z;
        this.isPStoreEnable = z2;
        this.to = str3;
        this.checkSize = z3;
    }

    private JSONObject checkOperation() throws Exception {
        String str;
        try {
            int i = 1;
            if (this.from == 1) {
                str = nl0.f + "/feed-media/v4/check.json";
            } else if (this.isPStoreEnable) {
                str = nl0.w + "/upstream/v6/check";
            } else {
                str = nl0.f + "/media/v4/check.json";
            }
            String strZ = k86.Z(str);
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TKDownloadReason.KSAD_TK_NET, hx3.h());
            jSONObject.put("type", this.type);
            jSONObject.put("fsize", this.totalSize);
            jSONObject.put("fhash", this.md5);
            if (!this.isExpression) {
                i = 0;
            }
            jSONObject.put("fav", i);
            jSONObject.put(RemoteMessageConst.TO, this.to);
            jSONObject.put("checkSize", this.checkSize);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            Request fileRequest = this.isPStoreEnable ? new FileRequest(1, strZ, jSONObject.toString(), requestFutureNewFuture, requestFutureNewFuture) : new EncryptedJsonRequest(1, strZ, jSONObject, requestFutureNewFuture, requestFutureNewFuture);
            fileRequest.setRetryPolicy(wt0.genRetryPolicy());
            normalRequestQueue.add(fileRequest);
            return (JSONObject) requestFutureNewFuture.get(fileRequest);
        } catch (ExecutionException e) {
            LogUtil.i(TAG, 3, new HashMap<String, Object>() { // from class: com.zenmen.palmchat.fileupload.dao.FileUploadCheckDao.1
                {
                    put("action", LogUtil.VALUE_FILE_UPLOAD);
                    put("status", "checkOperation");
                    put("detail", "ExecutionException");
                    put("type", Integer.valueOf(FileUploadCheckDao.this.type));
                    put("md5", FileUploadCheckDao.this.md5);
                    put("fileSize", Long.valueOf(FileUploadCheckDao.this.totalSize));
                    put("mid", FileUploadCheckDao.this.mid);
                }
            }, e);
            return null;
        } catch (Exception e2) {
            LogUtil.i(TAG, 3, new HashMap<String, Object>() { // from class: com.zenmen.palmchat.fileupload.dao.FileUploadCheckDao.2
                {
                    put("action", LogUtil.VALUE_FILE_UPLOAD);
                    put("status", "checkOperation");
                    put("detail", "Exception");
                    put("type", Integer.valueOf(FileUploadCheckDao.this.type));
                    put("md5", FileUploadCheckDao.this.md5);
                    put("fileSize", Long.valueOf(FileUploadCheckDao.this.totalSize));
                    put("mid", FileUploadCheckDao.this.mid);
                }
            }, e2);
            return null;
        }
    }

    public CheckVO checkSync() throws Exception {
        return checkSync(true);
    }

    public CheckVO checkSync(boolean z) throws Exception {
        long jB = ir5.b();
        JSONObject jSONObjectCheckOperation = checkOperation();
        if (jSONObjectCheckOperation == null) {
            return null;
        }
        LogUtil.i(TAG, 3, new HashMap<String, Object>(jSONObjectCheckOperation, ir5.b(), jB) { // from class: com.zenmen.palmchat.fileupload.dao.FileUploadCheckDao.3
            final /* synthetic */ long val$finishTime;
            final /* synthetic */ JSONObject val$response;
            final /* synthetic */ long val$startTime;

            {
                this.val$response = jSONObjectCheckOperation;
                this.val$finishTime = j;
                this.val$startTime = jB;
                put("action", LogUtil.VALUE_FILE_UPLOAD);
                put("status", "finish_check");
                put("detail", jSONObjectCheckOperation != null ? jSONObjectCheckOperation.toString() : "checkOperation jsonObject is null");
                put("duration", Long.valueOf(j - jB));
                put("type", Integer.valueOf(FileUploadCheckDao.this.type));
                put("md5", FileUploadCheckDao.this.md5);
                put("fileSize", Long.valueOf(FileUploadCheckDao.this.totalSize));
                put("mid", FileUploadCheckDao.this.mid);
            }
        }, (Throwable) null);
        int i = jSONObjectCheckOperation.getInt("resultCode");
        if (i == 401) {
            if (!z) {
                return null;
            }
            Thread.sleep(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
            return checkSync(false);
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectCheckOperation.optJSONObject("data");
        if (i != 0 || jSONObjectOptJSONObject == null) {
            return null;
        }
        return new CheckVO(jSONObjectOptJSONObject);
    }
}
