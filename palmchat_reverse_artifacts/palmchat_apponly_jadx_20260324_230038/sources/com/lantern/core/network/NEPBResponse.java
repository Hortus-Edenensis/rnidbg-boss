package com.lantern.core.network;

import com.google.protobuf.InvalidProtocolBufferException;
import com.lantern.core.protobuf.ProtobufResponseModelOuterClass;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NEPBResponse extends NEResponse {
    private int mCode;
    private byte[] mData;

    public NEPBResponse(int i, byte[] bArr) {
        this.mCode = i;
        this.mData = bArr;
        if (i == -1) {
            try {
                ProtobufResponseModelOuterClass.ProtobufResponseModel from = ProtobufResponseModelOuterClass.ProtobufResponseModel.parseFrom(bArr);
                if (from != null) {
                    setRetcode(from.getCode());
                    setRetmsg(from.getMsg());
                }
            } catch (InvalidProtocolBufferException unused) {
                setRetcode("-2");
                setRetmsg("InvalidProtocolBufferException");
            }
        }
    }

    public byte[] getServerData() {
        return this.mData;
    }

    @Override // com.lantern.core.network.NEResponse
    public boolean isSuccess() {
        return this.mCode == 0;
    }

    public NEPBResponse(int i, String str, String str2) {
        super(str, str2);
        this.mCode = i;
    }
}
