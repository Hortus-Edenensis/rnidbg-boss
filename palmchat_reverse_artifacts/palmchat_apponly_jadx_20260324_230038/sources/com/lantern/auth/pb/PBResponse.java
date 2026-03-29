package com.lantern.auth.pb;

import com.google.protobuf.InvalidProtocolBufferException;
import com.lantern.auth.android.ResTool;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.pb.pb_client.ProtobufResponseModelOuterClass;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PBResponse extends WkResponse {
    private int mCode;
    private byte[] mData;

    public PBResponse(int i, byte[] bArr) {
        this.mCode = i;
        this.mData = bArr;
        if (i == -1) {
            try {
                ProtobufResponseModelOuterClass.ProtobufResponseModel from = ProtobufResponseModelOuterClass.ProtobufResponseModel.parseFrom(bArr);
                if (from != null) {
                    setRetcode(from.getCode());
                    setRetmsg(from.getMsg());
                }
            } catch (InvalidProtocolBufferException e) {
                BLLog.e(e);
                setRetcode("-2");
                setRetmsg(ResTool.getString("wk_network_err", WkSDKManager.getContext()));
            }
        }
    }

    public byte[] getServerData() {
        return this.mData;
    }

    public boolean isNetFailed() {
        return this.mCode == -1;
    }

    @Override // com.lantern.auth.pb.WkResponse
    public boolean isSuccess() {
        return this.mCode == 0;
    }

    public PBResponse(int i, String str, String str2) {
        super(str, str2);
        this.mCode = i;
    }
}
