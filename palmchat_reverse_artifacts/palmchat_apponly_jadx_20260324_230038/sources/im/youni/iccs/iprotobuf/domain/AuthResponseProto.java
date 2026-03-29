package im.youni.iccs.iprotobuf.domain;

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
/* JADX INFO: loaded from: classes4.dex */
public final class AuthResponseProto {

    /* JADX INFO: renamed from: im.youni.iccs.iprotobuf.domain.AuthResponseProto$1, reason: invalid class name */
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
    public static final class AuthResponse extends GeneratedMessageLite<AuthResponse, Builder> implements AuthResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 2;
        private static final AuthResponse DEFAULT_INSTANCE;
        public static final int MID_FIELD_NUMBER = 1;
        public static final int MSG_FIELD_NUMBER = 3;
        private static volatile Parser<AuthResponse> PARSER = null;
        public static final int SESSIONID_FIELD_NUMBER = 4;
        public static final int TIMESTAMP_FIELD_NUMBER = 5;
        private int bitField0_;
        private long timestamp_;
        private byte memoizedIsInitialized = -1;
        private String mid_ = "";
        private String code_ = "";
        private String msg_ = "";
        private String sessionId_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<AuthResponse, Builder> implements AuthResponseOrBuilder {
            public Builder clearCode() {
                copyOnWrite();
                ((AuthResponse) this.instance).clearCode();
                return this;
            }

            public Builder clearMid() {
                copyOnWrite();
                ((AuthResponse) this.instance).clearMid();
                return this;
            }

            public Builder clearMsg() {
                copyOnWrite();
                ((AuthResponse) this.instance).clearMsg();
                return this;
            }

            public Builder clearSessionId() {
                copyOnWrite();
                ((AuthResponse) this.instance).clearSessionId();
                return this;
            }

            public Builder clearTimestamp() {
                copyOnWrite();
                ((AuthResponse) this.instance).clearTimestamp();
                return this;
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public String getCode() {
                return ((AuthResponse) this.instance).getCode();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public ByteString getCodeBytes() {
                return ((AuthResponse) this.instance).getCodeBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public String getMid() {
                return ((AuthResponse) this.instance).getMid();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public ByteString getMidBytes() {
                return ((AuthResponse) this.instance).getMidBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public String getMsg() {
                return ((AuthResponse) this.instance).getMsg();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public ByteString getMsgBytes() {
                return ((AuthResponse) this.instance).getMsgBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public String getSessionId() {
                return ((AuthResponse) this.instance).getSessionId();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public ByteString getSessionIdBytes() {
                return ((AuthResponse) this.instance).getSessionIdBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public long getTimestamp() {
                return ((AuthResponse) this.instance).getTimestamp();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public boolean hasCode() {
                return ((AuthResponse) this.instance).hasCode();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public boolean hasMid() {
                return ((AuthResponse) this.instance).hasMid();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public boolean hasMsg() {
                return ((AuthResponse) this.instance).hasMsg();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public boolean hasSessionId() {
                return ((AuthResponse) this.instance).hasSessionId();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
            public boolean hasTimestamp() {
                return ((AuthResponse) this.instance).hasTimestamp();
            }

            public Builder setCode(String str) {
                copyOnWrite();
                ((AuthResponse) this.instance).setCode(str);
                return this;
            }

            public Builder setCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((AuthResponse) this.instance).setCodeBytes(byteString);
                return this;
            }

            public Builder setMid(String str) {
                copyOnWrite();
                ((AuthResponse) this.instance).setMid(str);
                return this;
            }

            public Builder setMidBytes(ByteString byteString) {
                copyOnWrite();
                ((AuthResponse) this.instance).setMidBytes(byteString);
                return this;
            }

            public Builder setMsg(String str) {
                copyOnWrite();
                ((AuthResponse) this.instance).setMsg(str);
                return this;
            }

            public Builder setMsgBytes(ByteString byteString) {
                copyOnWrite();
                ((AuthResponse) this.instance).setMsgBytes(byteString);
                return this;
            }

            public Builder setSessionId(String str) {
                copyOnWrite();
                ((AuthResponse) this.instance).setSessionId(str);
                return this;
            }

            public Builder setSessionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AuthResponse) this.instance).setSessionIdBytes(byteString);
                return this;
            }

            public Builder setTimestamp(long j) {
                copyOnWrite();
                ((AuthResponse) this.instance).setTimestamp(j);
                return this;
            }

            private Builder() {
                super(AuthResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            AuthResponse authResponse = new AuthResponse();
            DEFAULT_INSTANCE = authResponse;
            authResponse.makeImmutable();
        }

        private AuthResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.bitField0_ &= -3;
            this.code_ = getDefaultInstance().getCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMid() {
            this.bitField0_ &= -2;
            this.mid_ = getDefaultInstance().getMid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsg() {
            this.bitField0_ &= -5;
            this.msg_ = getDefaultInstance().getMsg();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionId() {
            this.bitField0_ &= -9;
            this.sessionId_ = getDefaultInstance().getSessionId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimestamp() {
            this.bitField0_ &= -17;
            this.timestamp_ = 0L;
        }

        public static AuthResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static AuthResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AuthResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AuthResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AuthResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<AuthResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.code_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCodeBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.code_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMid(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.mid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.mid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsg(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.msg_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.msg_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionId(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.sessionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.sessionId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimestamp(long j) {
            this.bitField0_ |= 16;
            this.timestamp_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AuthResponse();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    if (!hasMid()) {
                        if (zBooleanValue) {
                            this.memoizedIsInitialized = (byte) 0;
                        }
                        return null;
                    }
                    if (!hasCode()) {
                        if (zBooleanValue) {
                            this.memoizedIsInitialized = (byte) 0;
                        }
                        return null;
                    }
                    if (hasTimestamp()) {
                        if (zBooleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (zBooleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder();
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    AuthResponse authResponse = (AuthResponse) obj2;
                    this.mid_ = visitor.visitString(hasMid(), this.mid_, authResponse.hasMid(), authResponse.mid_);
                    this.code_ = visitor.visitString(hasCode(), this.code_, authResponse.hasCode(), authResponse.code_);
                    this.msg_ = visitor.visitString(hasMsg(), this.msg_, authResponse.hasMsg(), authResponse.msg_);
                    this.sessionId_ = visitor.visitString(hasSessionId(), this.sessionId_, authResponse.hasSessionId(), authResponse.sessionId_);
                    this.timestamp_ = visitor.visitLong(hasTimestamp(), this.timestamp_, authResponse.hasTimestamp(), authResponse.timestamp_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= authResponse.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    String string = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.mid_ = string;
                                } else if (tag == 18) {
                                    String string2 = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.code_ = string2;
                                } else if (tag == 26) {
                                    String string3 = codedInputStream.readString();
                                    this.bitField0_ |= 4;
                                    this.msg_ = string3;
                                } else if (tag == 34) {
                                    String string4 = codedInputStream.readString();
                                    this.bitField0_ |= 8;
                                    this.sessionId_ = string4;
                                } else if (tag == 40) {
                                    this.bitField0_ |= 16;
                                    this.timestamp_ = codedInputStream.readUInt64();
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
                        synchronized (AuthResponse.class) {
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

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public String getCode() {
            return this.code_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public ByteString getCodeBytes() {
            return ByteString.copyFromUtf8(this.code_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public String getMid() {
            return this.mid_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public ByteString getMidBytes() {
            return ByteString.copyFromUtf8(this.mid_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public String getMsg() {
            return this.msg_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public ByteString getMsgBytes() {
            return ByteString.copyFromUtf8(this.msg_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getMid()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getCode());
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getMsg());
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, getSessionId());
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeStringSize += CodedOutputStream.computeUInt64Size(5, this.timestamp_);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public String getSessionId() {
            return this.sessionId_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public ByteString getSessionIdBytes() {
            return ByteString.copyFromUtf8(this.sessionId_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public boolean hasCode() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public boolean hasMid() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public boolean hasMsg() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public boolean hasSessionId() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthResponseProto.AuthResponseOrBuilder
        public boolean hasTimestamp() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getMid());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getCode());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeString(3, getMsg());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeString(4, getSessionId());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeUInt64(5, this.timestamp_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(AuthResponse authResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(authResponse);
        }

        public static AuthResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AuthResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AuthResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AuthResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AuthResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AuthResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AuthResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AuthResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AuthResponse parseFrom(InputStream inputStream) throws IOException {
            return (AuthResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AuthResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AuthResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AuthResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AuthResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AuthResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AuthResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AuthResponseOrBuilder extends MessageLiteOrBuilder {
        String getCode();

        ByteString getCodeBytes();

        String getMid();

        ByteString getMidBytes();

        String getMsg();

        ByteString getMsgBytes();

        String getSessionId();

        ByteString getSessionIdBytes();

        long getTimestamp();

        boolean hasCode();

        boolean hasMid();

        boolean hasMsg();

        boolean hasSessionId();

        boolean hasTimestamp();
    }

    private AuthResponseProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
