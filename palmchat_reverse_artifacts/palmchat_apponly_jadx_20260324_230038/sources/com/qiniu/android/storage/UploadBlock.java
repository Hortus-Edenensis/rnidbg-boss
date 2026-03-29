package com.qiniu.android.storage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class UploadBlock {
    final int index;
    final long offset;
    final int size;
    final List<UploadData> uploadDataList;
    String md5 = null;
    String ctx = null;

    public UploadBlock(long j, int i, int i2, int i3) {
        this.offset = j;
        this.size = i;
        this.index = i3;
        this.uploadDataList = createDataList(i2);
    }

    public static UploadBlock blockFromJson(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        long j = jSONObject.getLong("offset");
        int i = jSONObject.getInt("size");
        int i2 = jSONObject.getInt("index");
        String strOptString = jSONObject.optString("md5");
        String strOptString2 = jSONObject.optString("ctx");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("uploadDataList");
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            UploadData uploadDataDataFromJson = UploadData.dataFromJson(jSONArray.getJSONObject(i3));
            if (uploadDataDataFromJson != null) {
                arrayList.add(uploadDataDataFromJson);
            }
        }
        UploadBlock uploadBlock = new UploadBlock(j, i, i2, arrayList);
        uploadBlock.md5 = strOptString;
        uploadBlock.ctx = strOptString2;
        return uploadBlock;
    }

    private ArrayList<UploadData> createDataList(int i) {
        ArrayList<UploadData> arrayList = new ArrayList<>();
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = this.size;
            if (j >= i3) {
                return arrayList;
            }
            int iMin = Math.min((int) (((long) i3) - j), i);
            arrayList.add(new UploadData(j, iMin, i2));
            j += (long) iMin;
            i2++;
        }
    }

    public void checkInfoStateAndUpdate() {
        Iterator<UploadData> it = this.uploadDataList.iterator();
        while (it.hasNext()) {
            it.next().checkStateAndUpdate();
        }
    }

    public void clearUploadState() {
        this.md5 = null;
        this.ctx = null;
        List<UploadData> list = this.uploadDataList;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<UploadData> it = this.uploadDataList.iterator();
        while (it.hasNext()) {
            it.next().clearUploadState();
        }
    }

    public boolean isCompleted() {
        List<UploadData> list = this.uploadDataList;
        if (list == null) {
            return true;
        }
        Iterator<UploadData> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().isUploaded()) {
                return false;
            }
        }
        return true;
    }

    public UploadData nextUploadDataWithoutCheckData() {
        List<UploadData> list = this.uploadDataList;
        if (list == null || list.size() == 0) {
            return null;
        }
        for (UploadData uploadData : this.uploadDataList) {
            if (uploadData.needToUpload()) {
                return uploadData;
            }
        }
        return null;
    }

    public JSONObject toJsonObject() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("offset", Long.valueOf(this.offset));
        jSONObject.putOpt("size", Integer.valueOf(this.size));
        jSONObject.putOpt("index", Integer.valueOf(this.index));
        jSONObject.putOpt("md5", this.md5);
        jSONObject.putOpt("ctx", this.ctx);
        List<UploadData> list = this.uploadDataList;
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<UploadData> it = this.uploadDataList.iterator();
            while (it.hasNext()) {
                JSONObject jsonObject = it.next().toJsonObject();
                if (jsonObject != null) {
                    jSONArray.put(jsonObject);
                }
            }
            jSONObject.put("uploadDataList", jSONArray);
        }
        return jSONObject;
    }

    public long uploadSize() {
        List<UploadData> list = this.uploadDataList;
        long jUploadSize = 0;
        if (list == null) {
            return 0L;
        }
        Iterator<UploadData> it = list.iterator();
        while (it.hasNext()) {
            jUploadSize += it.next().uploadSize();
        }
        return jUploadSize;
    }

    private UploadBlock(long j, int i, int i2, List<UploadData> list) {
        this.offset = j;
        this.size = i;
        this.index = i2;
        this.uploadDataList = list;
    }
}
