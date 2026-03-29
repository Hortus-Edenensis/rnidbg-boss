package com.qiniu.android.storage;

import com.qiniu.android.storage.UploadData;
import com.qiniu.android.utils.BytesUtils;
import com.qiniu.android.utils.ListVector;
import com.qiniu.android.utils.MD5;
import com.qiniu.android.utils.StringUtils;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class UploadInfoV1 extends UploadInfo {
    private static final int BlockListCapacityIncrement = 2;
    private static final int BlockSize = 4194304;
    private static final String TypeKey = "infoType";
    private static final String TypeValue = "UploadInfoV1";
    private ListVector<UploadBlock> blockList;
    private final int dataSize;
    private boolean isEOF;
    private IOException readException;

    private UploadInfoV1(UploadSource uploadSource, int i, ListVector<UploadBlock> listVector) {
        super(uploadSource);
        this.isEOF = false;
        this.readException = null;
        this.dataSize = i;
        this.blockList = listVector;
    }

    public static UploadInfoV1 infoFromJson(UploadSource uploadSource, JSONObject jSONObject) {
        String strOptString;
        UploadInfoV1 uploadInfoV1;
        if (jSONObject == null) {
            return null;
        }
        try {
            strOptString = jSONObject.optString(TypeKey);
            int i = jSONObject.getInt("dataSize");
            JSONArray jSONArray = jSONObject.getJSONArray("blockList");
            ListVector listVector = new ListVector(jSONArray.length(), 2);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    UploadBlock uploadBlockBlockFromJson = UploadBlock.blockFromJson(jSONArray.getJSONObject(i2));
                    if (uploadBlockBlockFromJson != null) {
                        listVector.add(uploadBlockBlockFromJson);
                    }
                } catch (Exception unused) {
                }
            }
            uploadInfoV1 = new UploadInfoV1(uploadSource, i, listVector);
            uploadInfoV1.setInfoFromJson(jSONObject);
        } catch (JSONException unused2) {
        }
        if (TypeValue.equals(strOptString) && uploadSource.getId().equals(uploadInfoV1.getSourceId())) {
            return uploadInfoV1;
        }
        return null;
    }

    private UploadBlock loadBlockData(UploadBlock uploadBlock) throws IOException {
        String str;
        if (uploadBlock == null) {
            return null;
        }
        UploadData uploadDataNextUploadDataWithoutCheckData = uploadBlock.nextUploadDataWithoutCheckData();
        if (uploadDataNextUploadDataWithoutCheckData.getState() == UploadData.State.WaitToUpload && uploadDataNextUploadDataWithoutCheckData.data != null) {
            return uploadBlock;
        }
        byte[] data = readData(uploadBlock.size, uploadBlock.offset);
        if (data == null || data.length == 0) {
            return null;
        }
        String strEncrypt = MD5.encrypt(data);
        if (data.length != uploadBlock.size || (str = uploadBlock.md5) == null || !str.equals(strEncrypt)) {
            UploadBlock uploadBlock2 = new UploadBlock(uploadBlock.offset, data.length, this.dataSize, uploadBlock.index);
            uploadBlock2.md5 = strEncrypt;
            uploadBlock = uploadBlock2;
        }
        for (UploadData uploadData : uploadBlock.uploadDataList) {
            UploadData.State state = uploadData.getState();
            UploadData.State state2 = UploadData.State.Complete;
            if (state != state2) {
                uploadData.data = BytesUtils.subBytes(data, (int) uploadData.offset, uploadData.size);
                uploadData.updateState(UploadData.State.WaitToUpload);
            } else {
                uploadData.updateState(state2);
            }
        }
        return uploadBlock;
    }

    private UploadBlock nextUploadBlockFormBlockList() {
        ListVector<UploadBlock> listVector = this.blockList;
        if (listVector == null || listVector.size() == 0) {
            return null;
        }
        final UploadBlock[] uploadBlockArr = {null};
        this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.6
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadBlock uploadBlock) {
                if (uploadBlock.nextUploadDataWithoutCheckData() == null) {
                    return false;
                }
                uploadBlockArr[0] = uploadBlock;
                return true;
            }
        });
        return uploadBlockArr[0];
    }

    public ArrayList<String> allBlocksContexts() {
        ListVector<UploadBlock> listVector = this.blockList;
        if (listVector == null || listVector.size() == 0) {
            return null;
        }
        final ArrayList<String> arrayList = new ArrayList<>();
        this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.7
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadBlock uploadBlock) {
                String str = uploadBlock.ctx;
                if (StringUtils.isNullOrEmpty(str)) {
                    return false;
                }
                arrayList.add(str);
                return false;
            }
        });
        return arrayList;
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public void checkInfoStateAndUpdate() {
        this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.4
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadBlock uploadBlock) {
                uploadBlock.checkInfoStateAndUpdate();
                return false;
            }
        });
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public void clearUploadState() {
        ListVector<UploadBlock> listVector = this.blockList;
        if (listVector == null || listVector.size() == 0) {
            return;
        }
        this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.1
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadBlock uploadBlock) {
                uploadBlock.clearUploadState();
                return false;
            }
        });
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public boolean isAllUploaded() {
        if (!this.isEOF) {
            return false;
        }
        ListVector<UploadBlock> listVector = this.blockList;
        if (listVector == null || listVector.size() == 0) {
            return true;
        }
        final boolean[] zArr = {true};
        this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.3
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadBlock uploadBlock) {
                if (uploadBlock.isCompleted()) {
                    return false;
                }
                zArr[0] = false;
                return true;
            }
        });
        return zArr[0];
    }

    public boolean isFirstData(UploadData uploadData) {
        return uploadData.index == 0;
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public boolean isSameUploadInfo(UploadInfo uploadInfo) {
        return super.isSameUploadInfo(uploadInfo) && (uploadInfo instanceof UploadInfoV1) && this.dataSize == ((UploadInfoV1) uploadInfo).dataSize;
    }

    public UploadBlock nextUploadBlock() throws IOException {
        long j;
        UploadBlock uploadBlockNextUploadBlockFormBlockList = nextUploadBlockFormBlockList();
        if (uploadBlockNextUploadBlockFormBlockList == null) {
            if (this.isEOF) {
                return null;
            }
            IOException iOException = this.readException;
            if (iOException != null) {
                throw iOException;
            }
            if (this.blockList.size() > 0) {
                ListVector<UploadBlock> listVector = this.blockList;
                UploadBlock uploadBlock = listVector.get(listVector.size() - 1);
                j = uploadBlock.offset + ((long) uploadBlock.size);
            } else {
                j = 0;
            }
            uploadBlockNextUploadBlockFormBlockList = new UploadBlock(j, 4194304, this.dataSize, this.blockList.size());
        }
        try {
            UploadBlock uploadBlockLoadBlockData = loadBlockData(uploadBlockNextUploadBlockFormBlockList);
            if (uploadBlockLoadBlockData == null) {
                this.isEOF = true;
                int size = this.blockList.size();
                int i = uploadBlockNextUploadBlockFormBlockList.index;
                if (size > i) {
                    this.blockList = this.blockList.subList(0, i);
                }
            } else {
                if (uploadBlockLoadBlockData.index == this.blockList.size()) {
                    this.blockList.add(uploadBlockLoadBlockData);
                } else if (uploadBlockLoadBlockData != uploadBlockNextUploadBlockFormBlockList) {
                    this.blockList.set(uploadBlockLoadBlockData.index, uploadBlockLoadBlockData);
                }
                if (uploadBlockLoadBlockData.size < 4194304) {
                    this.isEOF = true;
                    int size2 = this.blockList.size();
                    int i2 = uploadBlockNextUploadBlockFormBlockList.index;
                    if (size2 > i2 + 1) {
                        this.blockList = this.blockList.subList(0, i2 + 1);
                    }
                }
            }
            return uploadBlockLoadBlockData;
        } catch (IOException e) {
            this.readException = e;
            throw e;
        }
    }

    public UploadData nextUploadData(UploadBlock uploadBlock) throws IOException {
        if (uploadBlock == null) {
            return null;
        }
        return uploadBlock.nextUploadDataWithoutCheckData();
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
            ListVector<UploadBlock> listVector = this.blockList;
            if (listVector != null && listVector.size() > 0) {
                final JSONArray jSONArray = new JSONArray();
                this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.5
                    @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
                    public boolean enumerate(UploadBlock uploadBlock) {
                        try {
                            JSONObject jsonObject2 = uploadBlock.toJsonObject();
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
                if (jSONArray.length() != this.blockList.size()) {
                    return null;
                }
                jsonObject.put("blockList", jSONArray);
            }
            return jsonObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public long uploadSize() {
        ListVector<UploadBlock> listVector = this.blockList;
        if (listVector == null || listVector.size() == 0) {
            return 0L;
        }
        final long[] jArr = {0};
        this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.2
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadBlock uploadBlock) {
                long[] jArr2 = jArr;
                jArr2[0] = jArr2[0] + uploadBlock.uploadSize();
                return false;
            }
        });
        return jArr[0];
    }

    public UploadInfoV1(UploadSource uploadSource, Configuration configuration) {
        int i;
        super(uploadSource);
        this.isEOF = false;
        this.readException = null;
        if (!configuration.useConcurrentResumeUpload && (i = configuration.chunkSize) <= 4194304) {
            this.dataSize = i;
        } else {
            this.dataSize = 4194304;
        }
        this.blockList = new ListVector<>(2, 2);
    }
}
