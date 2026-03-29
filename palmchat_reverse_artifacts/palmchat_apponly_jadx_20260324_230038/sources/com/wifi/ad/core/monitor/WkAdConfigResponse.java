package com.wifi.ad.core.monitor;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class WkAdConfigResponse {

    /* JADX INFO: renamed from: com.wifi.ad.core.monitor.WkAdConfigResponse$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SdkResponse extends GeneratedMessageLite<SdkResponse, Builder> implements SdkResponseOrBuilder {
        public static final int BLOCKINFO_FIELD_NUMBER = 5;
        public static final int CODE_FIELD_NUMBER = 1;
        private static final SdkResponse DEFAULT_INSTANCE;
        public static final int MSG_FIELD_NUMBER = 2;
        private static volatile Parser<SdkResponse> PARSER = null;
        public static final int REQUESTID_FIELD_NUMBER = 3;
        public static final int STRATEGY_FIELD_NUMBER = 4;
        private int bitField0_;
        private int code_;
        private String msg_ = "";
        private String requestid_ = "";
        private String strategy_ = "";
        private String blockinfo_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<SdkResponse, Builder> implements SdkResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBlockinfo() {
                copyOnWrite();
                ((SdkResponse) this.instance).clearBlockinfo();
                return this;
            }

            public Builder clearCode() {
                copyOnWrite();
                ((SdkResponse) this.instance).clearCode();
                return this;
            }

            public Builder clearMsg() {
                copyOnWrite();
                ((SdkResponse) this.instance).clearMsg();
                return this;
            }

            public Builder clearRequestid() {
                copyOnWrite();
                ((SdkResponse) this.instance).clearRequestid();
                return this;
            }

            public Builder clearStrategy() {
                copyOnWrite();
                ((SdkResponse) this.instance).clearStrategy();
                return this;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public String getBlockinfo() {
                return ((SdkResponse) this.instance).getBlockinfo();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public ByteString getBlockinfoBytes() {
                return ((SdkResponse) this.instance).getBlockinfoBytes();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public int getCode() {
                return ((SdkResponse) this.instance).getCode();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public String getMsg() {
                return ((SdkResponse) this.instance).getMsg();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public ByteString getMsgBytes() {
                return ((SdkResponse) this.instance).getMsgBytes();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public String getRequestid() {
                return ((SdkResponse) this.instance).getRequestid();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public ByteString getRequestidBytes() {
                return ((SdkResponse) this.instance).getRequestidBytes();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public String getStrategy() {
                return ((SdkResponse) this.instance).getStrategy();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public ByteString getStrategyBytes() {
                return ((SdkResponse) this.instance).getStrategyBytes();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public boolean hasBlockinfo() {
                return ((SdkResponse) this.instance).hasBlockinfo();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public boolean hasCode() {
                return ((SdkResponse) this.instance).hasCode();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public boolean hasMsg() {
                return ((SdkResponse) this.instance).hasMsg();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public boolean hasRequestid() {
                return ((SdkResponse) this.instance).hasRequestid();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
            public boolean hasStrategy() {
                return ((SdkResponse) this.instance).hasStrategy();
            }

            public Builder setBlockinfo(String str) {
                copyOnWrite();
                ((SdkResponse) this.instance).setBlockinfo(str);
                return this;
            }

            public Builder setBlockinfoBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkResponse) this.instance).setBlockinfoBytes(byteString);
                return this;
            }

            public Builder setCode(int i) {
                copyOnWrite();
                ((SdkResponse) this.instance).setCode(i);
                return this;
            }

            public Builder setMsg(String str) {
                copyOnWrite();
                ((SdkResponse) this.instance).setMsg(str);
                return this;
            }

            public Builder setMsgBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkResponse) this.instance).setMsgBytes(byteString);
                return this;
            }

            public Builder setRequestid(String str) {
                copyOnWrite();
                ((SdkResponse) this.instance).setRequestid(str);
                return this;
            }

            public Builder setRequestidBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkResponse) this.instance).setRequestidBytes(byteString);
                return this;
            }

            public Builder setStrategy(String str) {
                copyOnWrite();
                ((SdkResponse) this.instance).setStrategy(str);
                return this;
            }

            public Builder setStrategyBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkResponse) this.instance).setStrategyBytes(byteString);
                return this;
            }

            private Builder() {
                super(SdkResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            SdkResponse sdkResponse = new SdkResponse();
            DEFAULT_INSTANCE = sdkResponse;
            sdkResponse.makeImmutable();
        }

        private SdkResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBlockinfo() {
            this.bitField0_ &= -17;
            this.blockinfo_ = getDefaultInstance().getBlockinfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.bitField0_ &= -2;
            this.code_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsg() {
            this.bitField0_ &= -3;
            this.msg_ = getDefaultInstance().getMsg();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRequestid() {
            this.bitField0_ &= -5;
            this.requestid_ = getDefaultInstance().getRequestid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStrategy() {
            this.bitField0_ &= -9;
            this.strategy_ = getDefaultInstance().getStrategy();
        }

        public static SdkResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SdkResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SdkResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SdkResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SdkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<SdkResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBlockinfo(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.blockinfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBlockinfoBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.blockinfo_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(int i) {
            this.bitField0_ |= 1;
            this.code_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsg(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.msg_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.msg_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequestid(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.requestid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequestidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.requestid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrategy(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.strategy_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrategyBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.strategy_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SdkResponse();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    SdkResponse sdkResponse = (SdkResponse) obj2;
                    this.code_ = visitor.visitInt(hasCode(), this.code_, sdkResponse.hasCode(), sdkResponse.code_);
                    this.msg_ = visitor.visitString(hasMsg(), this.msg_, sdkResponse.hasMsg(), sdkResponse.msg_);
                    this.requestid_ = visitor.visitString(hasRequestid(), this.requestid_, sdkResponse.hasRequestid(), sdkResponse.requestid_);
                    this.strategy_ = visitor.visitString(hasStrategy(), this.strategy_, sdkResponse.hasStrategy(), sdkResponse.strategy_);
                    this.blockinfo_ = visitor.visitString(hasBlockinfo(), this.blockinfo_, sdkResponse.hasBlockinfo(), sdkResponse.blockinfo_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= sdkResponse.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.bitField0_ |= 1;
                                    this.code_ = codedInputStream.readUInt32();
                                } else if (tag == 18) {
                                    String string = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.msg_ = string;
                                } else if (tag == 26) {
                                    String string2 = codedInputStream.readString();
                                    this.bitField0_ |= 4;
                                    this.requestid_ = string2;
                                } else if (tag == 34) {
                                    String string3 = codedInputStream.readString();
                                    this.bitField0_ |= 8;
                                    this.strategy_ = string3;
                                } else if (tag == 42) {
                                    String string4 = codedInputStream.readString();
                                    this.bitField0_ |= 16;
                                    this.blockinfo_ = string4;
                                } else if (!parseUnknownField(tag, codedInputStream)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (SdkResponse.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                            break;
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public String getBlockinfo() {
            return this.blockinfo_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public ByteString getBlockinfoBytes() {
            return ByteString.copyFromUtf8(this.blockinfo_);
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public String getMsg() {
            return this.msg_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public ByteString getMsgBytes() {
            return ByteString.copyFromUtf8(this.msg_);
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public String getRequestid() {
            return this.requestid_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public ByteString getRequestidBytes() {
            return ByteString.copyFromUtf8(this.requestid_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeUInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeUInt32Size(1, this.code_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeUInt32Size += CodedOutputStream.computeStringSize(2, getMsg());
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeUInt32Size += CodedOutputStream.computeStringSize(3, getRequestid());
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeUInt32Size += CodedOutputStream.computeStringSize(4, getStrategy());
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeUInt32Size += CodedOutputStream.computeStringSize(5, getBlockinfo());
            }
            int serializedSize = iComputeUInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public String getStrategy() {
            return this.strategy_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public ByteString getStrategyBytes() {
            return ByteString.copyFromUtf8(this.strategy_);
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public boolean hasBlockinfo() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public boolean hasCode() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public boolean hasMsg() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public boolean hasRequestid() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigResponse.SdkResponseOrBuilder
        public boolean hasStrategy() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeUInt32(1, this.code_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getMsg());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeString(3, getRequestid());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeString(4, getStrategy());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeString(5, getBlockinfo());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(SdkResponse sdkResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sdkResponse);
        }

        public static SdkResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SdkResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SdkResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SdkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SdkResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SdkResponse parseFrom(InputStream inputStream) throws IOException {
            return (SdkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SdkResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SdkResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SdkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SdkResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SdkResponseOrBuilder extends MessageLiteOrBuilder {
        String getBlockinfo();

        ByteString getBlockinfoBytes();

        int getCode();

        String getMsg();

        ByteString getMsgBytes();

        String getRequestid();

        ByteString getRequestidBytes();

        String getStrategy();

        ByteString getStrategyBytes();

        boolean hasBlockinfo();

        boolean hasCode();

        boolean hasMsg();

        boolean hasRequestid();

        boolean hasStrategy();
    }

    private WkAdConfigResponse() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
