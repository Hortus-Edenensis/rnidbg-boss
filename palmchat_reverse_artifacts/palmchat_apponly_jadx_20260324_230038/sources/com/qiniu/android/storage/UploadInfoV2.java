package com.qiniu.android.storage;

import com.qiniu.android.storage.UploadData;
import com.qiniu.android.utils.ListVector;
import com.qiniu.android.utils.MD5;
import com.qiniu.android.utils.StringUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class UploadInfoV2 extends UploadInfo {
    private static final int DataListCapacityIncrement = 2;
    private static final String TypeKey = "infoType";
    private static final String TypeValue = "UploadInfoV2";
    private static final int maxDataSize = 1073741824;
    private ListVector<UploadData> dataList;
    private final int dataSize;
    Long expireAt;
    private boolean isEOF;
    private IOException readException;
    String uploadId;

    private UploadInfoV2(UploadSource uploadSource, int i, ListVector<UploadData> listVector) {
        super(uploadSource);
        this.isEOF = false;
        this.readException = null;
        this.dataSize = i;
        this.dataList = listVector;
    }

    public static UploadInfoV2 infoFromJson(UploadSource uploadSource, JSONObject jSONObject) {
        String strOptString;
        UploadInfoV2 uploadInfoV2;
        if (jSONObject == null) {
            return null;
        }
        try {
            strOptString = jSONObject.optString(TypeKey);
            int i = jSONObject.getInt("dataSize");
            Long lValueOf = Long.valueOf(jSONObject.getLong("expireAt"));
            String strOptString2 = jSONObject.optString("uploadId");
            JSONArray jSONArray = jSONObject.getJSONArray("dataList");
            ListVector listVector = new ListVector(jSONArray.length(), 2);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                UploadData uploadDataDataFromJson = UploadData.dataFromJson(jSONArray.getJSONObject(i2));
                if (uploadDataDataFromJson != null) {
                    listVector.add(uploadDataDataFromJson);
                }
            }
            uploadInfoV2 = new UploadInfoV2(uploadSource, i, listVector);
            uploadInfoV2.setInfoFromJson(jSONObject);
            uploadInfoV2.expireAt = lValueOf;
            uploadInfoV2.uploadId = strOptString2;
        } catch (Exception unused) {
        }
        if (TypeValue.equals(strOptString) && uploadSource.getId().equals(uploadInfoV2.getSourceId())) {
            return uploadInfoV2;
        }
        return null;
    }

    private UploadData loadData(UploadData uploadData) throws IOException {
        String str;
        if (uploadData == null) {
            return null;
        }
        if (uploadData.data != null) {
            return uploadData;
        }
        try {
            byte[] data = readData(uploadData.size, uploadData.offset);
            if (data == null || data.length == 0) {
                return null;
            }
            String strEncrypt = MD5.encrypt(data);
            if (data.length != uploadData.size || (str = uploadData.md5) == null || !str.equals(strEncrypt)) {
                UploadData uploadData2 = new UploadData(uploadData.offset, data.length, uploadData.index);
                uploadData2.md5 = strEncrypt;
                uploadData = uploadData2;
            }
            if (StringUtils.isNullOrEmpty(uploadData.etag)) {
                uploadData.data = data;
                uploadData.updateState(UploadData.State.WaitToUpload);
            } else {
                uploadData.updateState(UploadData.State.Complete);
            }
            return uploadData;
        } catch (IOException e) {
            this.readException = e;
            throw e;
        }
    }

    private UploadData nextUploadDataFormDataList() {
        ListVector<UploadData> listVector = this.dataList;
        if (listVector == null || listVector.size() == 0) {
            return null;
        }
        final UploadData[] uploadDataArr = {null};
        this.dataList.enumerateObjects(new ListVector.EnumeratorHandler<UploadData>() { // from class: com.qiniu.android.storage.UploadInfoV2.1
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadData uploadData) {
                if (!uploadData.needToUpload()) {
                    return false;
                }
                uploadDataArr[0] = uploadData;
                return true;
            }
        });
        return uploadDataArr[0];
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public void checkInfoStateAndUpdate() {
        this.dataList.enumerateObjects(new ListVector.EnumeratorHandler<UploadData>() { // from class: com.qiniu.android.storage.UploadInfoV2.6
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadData uploadData) {
                uploadData.checkStateAndUpdate();
                return false;
            }
        });
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public void clearUploadState() {
        this.dataList.enumerateObjects(new ListVector.EnumeratorHandler<UploadData>() { // from class: com.qiniu.android.storage.UploadInfoV2.3
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadData uploadData) {
                uploadData.clearUploadState();
                return false;
            }
        });
    }

    public int getPartIndexOfData(UploadData uploadData) {
        return uploadData.index + 1;
    }

    public List<Map<String, Object>> getPartInfoArray() {
        String str = this.uploadId;
        if (str == null || str.length() == 0) {
            return null;
        }
        final ArrayList arrayList = new ArrayList();
        this.dataList.enumerateObjects(new ListVector.EnumeratorHandler<UploadData>() { // from class: com.qiniu.android.storage.UploadInfoV2.2
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadData uploadData) {
                if (uploadData.getState() != UploadData.State.Complete || StringUtils.isNullOrEmpty(uploadData.etag)) {
                    return false;
                }
                HashMap map = new HashMap();
                map.put("etag", uploadData.etag);
                map.put("partNumber", Integer.valueOf(UploadInfoV2.this.getPartIndexOfData(uploadData)));
                arrayList.add(map);
                return false;
            }
        });
        return arrayList;
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public boolean isAllUploaded() {
        if (!this.isEOF) {
            return false;
        }
        ListVector<UploadData> listVector = this.dataList;
        if (listVector == null || listVector.size() == 0) {
            return true;
        }
        final boolean[] zArr = {true};
        this.dataList.enumerateObjects(new ListVector.EnumeratorHandler<UploadData>() { // from class: com.qiniu.android.storage.UploadInfoV2.5
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadData uploadData) {
                if (uploadData.isUploaded()) {
                    return false;
                }
                zArr[0] = false;
                return true;
            }
        });
        return zArr[0];
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public boolean isSameUploadInfo(UploadInfo uploadInfo) {
        return super.isSameUploadInfo(uploadInfo) && (uploadInfo instanceof UploadInfoV2) && this.dataSize == ((UploadInfoV2) uploadInfo).dataSize;
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public boolean isValid() {
        if (!super.isValid() || StringUtils.isNullOrEmpty(this.uploadId) || this.expireAt == null) {
            return false;
        }
        return this.expireAt.longValue() > (new Date().getTime() / 1000) - 172800;
    }

    public UploadData nextUploadData() throws IOException {
        long j;
        UploadData uploadDataNextUploadDataFormDataList = nextUploadDataFormDataList();
        if (uploadDataNextUploadDataFormDataList == null) {
            if (this.isEOF) {
                return null;
            }
            IOException iOException = this.readException;
            if (iOException != null) {
                throw iOException;
            }
            if (this.dataList.size() > 0) {
                ListVector<UploadData> listVector = this.dataList;
                UploadData uploadData = listVector.get(listVector.size() - 1);
                j = uploadData.offset + ((long) uploadData.size);
            } else {
                j = 0;
            }
            uploadDataNextUploadDataFormDataList = new UploadData(j, this.dataSize, this.dataList.size());
        }
        try {
            UploadData uploadDataLoadData = loadData(uploadDataNextUploadDataFormDataList);
            if (uploadDataLoadData == null) {
                this.isEOF = true;
                int size = this.dataList.size();
                int i = uploadDataNextUploadDataFormDataList.index;
                if (size > i) {
                    this.dataList = this.dataList.subList(0, i);
                }
            } else {
                if (uploadDataLoadData.index == this.dataList.size()) {
                    this.dataList.add(uploadDataLoadData);
                } else if (uploadDataLoadData != uploadDataNextUploadDataFormDataList) {
                    this.dataList.set(uploadDataLoadData.index, uploadDataLoadData);
                }
                if (uploadDataLoadData.size < uploadDataNextUploadDataFormDataList.size) {
                    this.isEOF = true;
                    int size2 = this.dataList.size();
                    int i2 = uploadDataNextUploadDataFormDataList.index;
                    if (size2 > i2 + 1) {
                        this.dataList = this.dataList.subList(0, i2 + 1);
                    }
                }
            }
            return uploadDataLoadData;
        } catch (IOException e) {
            this.readException = e;
            throw e;
        }
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public boolean reloadSource() {
        this.isEOF = false;
        this.readException = null;
        return super.reloadSource();
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public JSONObject toJsonObject() {
        JSONObject jsonObject = super.toJsonObject();
        if (jsonObject == null) {
            return null;
        }
        try {
            jsonObject.put(TypeKey, TypeValue);
            jsonObject.put("dataSize", this.dataSize);
            jsonObject.put("expireAt", this.expireAt);
            jsonObject.put("uploadId", this.uploadId);
            ListVector<UploadData> listVector = this.dataList;
            if (listVector != null && listVector.size() > 0) {
                final JSONArray jSONArray = new JSONArray();
                this.dataList.enumerateObjects(new ListVector.EnumeratorHandler<UploadData>() { // from class: com.qiniu.android.storage.UploadInfoV2.7
                    @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
                    public boolean enumerate(UploadData uploadData) {
                        try {
                            JSONObject jsonObject2 = uploadData.toJsonObject();
                            if (jsonObject2 == null) {
                                return false;
                            }
                            jSONArray.put(jsonObject2);
                            return false;
                        } catch (Exception unused) {
                            return true;
                        }
                    }
                });
                if (jSONArray.length() != this.dataList.size()) {
                    return null;
                }
                jsonObject.put("dataList", jSONArray);
            }
            return jsonObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public long uploadSize() {
        ListVector<UploadData> listVector = this.dataList;
        if (listVector == null || listVector.size() == 0) {
            return 0L;
        }
        final long[] jArr = {0};
        this.dataList.enumerateObjects(new ListVector.EnumeratorHandler<UploadData>() { // from class: com.qiniu.android.storage.UploadInfoV2.4
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadData uploadData) {
                long[] jArr2 = jArr;
                jArr2[0] = jArr2[0] + uploadData.uploadSize();
                return false;
            }
        });
        return jArr[0];
    }

    public UploadInfoV2(UploadSource uploadSource, Configuration configuration) {
        super(uploadSource);
        this.isEOF = false;
        this.readException = null;
        this.dataSize = Math.min(configuration.chunkSize, 1073741824);
        this.dataList = new ListVector<>(2, 2);
    }
}
