package com.zenmen.palmchat.fileupload.dao;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UploadResultVo {
    public String acode;
    public String cdnKey;
    public String cdnToken;
    public boolean exists = false;
    public String fhash;
    public int hdFlag;
    public String hdUrl;
    public int height;
    public String md5;
    public String midUrl;
    public String resId;
    public String saveKey;
    public String thumbUrl;
    public String url;
    public int width;

    public static UploadResultVo buildFromJsonObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        UploadResultVo uploadResultVo = new UploadResultVo();
        uploadResultVo.url = jSONObject.optString("url");
        uploadResultVo.thumbUrl = jSONObject.optString("thumbUrl");
        uploadResultVo.hdUrl = jSONObject.optString("hdUrl");
        uploadResultVo.midUrl = jSONObject.optString("midUrl");
        uploadResultVo.width = jSONObject.optInt("width");
        uploadResultVo.height = jSONObject.optInt("height");
        uploadResultVo.hdFlag = jSONObject.optInt("hdFlag");
        uploadResultVo.acode = jSONObject.optString("acode");
        uploadResultVo.fhash = jSONObject.optString("fhash");
        uploadResultVo.exists = jSONObject.optBoolean("exists");
        uploadResultVo.resId = jSONObject.optString("resId");
        uploadResultVo.cdnToken = jSONObject.optString("cdnToken");
        uploadResultVo.cdnKey = jSONObject.optString("cdnKey");
        return uploadResultVo;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public String toString() {
        return "UploadResultVo =" + this.url + "thumbUrl" + this.thumbUrl + "hdUrl" + this.hdUrl + "midUrl" + this.midUrl + "width" + this.width + "height" + this.height + "hdFlag" + this.hdFlag + "acode" + this.acode + "fhash" + this.fhash;
    }
}
