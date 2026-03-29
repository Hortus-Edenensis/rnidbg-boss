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
public final class LogoutResponseProto {

    /* JADX INFO: renamed from: im.youni.iccs.iprotobuf.domain.LogoutResponseProto$1, reason: invalid class name */
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
    public static final class LogoutResponse extends GeneratedMessageLite<LogoutResponse, Builder> implements LogoutResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 2;
        private static final LogoutResponse DEFAULT_INSTANCE;
        public static final int MID_FIELD_NUMBER = 1;
        private static volatile Parser<LogoutResponse> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private String mid_ = "";
        private String code_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<LogoutResponse, Builder> implements LogoutResponseOrBuilder {
            public Builder clearCode() {
                copyOnWrite();
                ((LogoutResponse) this.instance).clearCode();
                return this;
            }

            public Builder clearMid() {
                copyOnWrite();
                ((LogoutResponse) this.instance).clearMid();
                return this;
            }

            @Override // im.youni.iccs.iprotobuf.domain.LogoutResponseProto.LogoutResponseOrBuilder
            public String getCode() {
                return ((LogoutResponse) this.instance).getCode();
            }

            @Override // im.youni.iccs.iprotobuf.domain.LogoutResponseProto.LogoutResponseOrBuilder
            public ByteString getCodeBytes() {
                return ((LogoutResponse) this.instance).getCodeBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.LogoutResponseProto.LogoutResponseOrBuilder
            public String getMid() {
                return ((LogoutResponse) this.instance).getMid();
            }

            @Override // im.youni.iccs.iprotobuf.domain.LogoutResponseProto.LogoutResponseOrBuilder
            public ByteString getMidBytes() {
                return ((LogoutResponse) this.instance).getMidBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.LogoutResponseProto.LogoutResponseOrBuilder
            public boolean hasCode() {
                return ((LogoutResponse) this.instance).hasCode();
            }

            @Override // im.youni.iccs.iprotobuf.domain.LogoutResponseProto.LogoutResponseOrBuilder
            public boolean hasMid() {
                return ((LogoutResponse) this.instance).hasMid();
            }

            public Builder setCode(String str) {
                copyOnWrite();
                ((LogoutResponse) this.instance).setCode(str);
                return this;
            }

            public Builder setCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((LogoutResponse) this.instance).setCodeBytes(byteString);
                return this;
            }

            public Builder setMid(String str) {
                copyOnWrite();
                ((LogoutResponse) this.instance).setMid(str);
                return this;
            }

            public Builder setMidBytes(ByteString byteString) {
                copyOnWrite();
                ((LogoutResponse) this.instance).setMidBytes(byteString);
                return this;
            }

            private Builder() {
                super(LogoutResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            LogoutResponse logoutResponse = new LogoutResponse();
            DEFAULT_INSTANCE = logoutResponse;
            logoutResponse.makeImmutable();
        }

        private LogoutResponse() {
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

        public static LogoutResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static LogoutResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LogoutResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LogoutResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LogoutResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<LogoutResponse> parser() {
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

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new LogoutResponse();
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
                    if (hasCode()) {
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
                    LogoutResponse logoutResponse = (LogoutResponse) obj2;
                    this.mid_ = visitor.visitString(hasMid(), this.mid_, logoutResponse.hasMid(), logoutResponse.mid_);
                    this.code_ = visitor.visitString(hasCode(), this.code_, logoutResponse.hasCode(), logoutResponse.code_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= logoutResponse.bitField0_;
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
                        synchronized (LogoutResponse.class) {
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

        @Override // im.youni.iccs.iprotobuf.domain.LogoutResponseProto.LogoutResponseOrBuilder
        public String getCode() {
            return this.code_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.LogoutResponseProto.LogoutResponseOrBuilder
        public ByteString getCodeBytes() {
            return ByteString.copyFromUtf8(this.code_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.LogoutResponseProto.LogoutResponseOrBuilder
        public String getMid() {
            return this.mid_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.LogoutResponseProto.LogoutResponseOrBuilder
        public ByteString getMidBytes() {
            return ByteString.copyFromUtf8(this.mid_);
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
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // im.youni.iccs.iprotobuf.domain.LogoutResponseProto.LogoutResponseOrBuilder
        public boolean hasCode() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // im.youni.iccs.iprotobuf.domain.LogoutResponseProto.LogoutResponseOrBuilder
        public boolean hasMid() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getMid());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getCode());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(LogoutResponse logoutResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(logoutResponse);
        }

        public static LogoutResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LogoutResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LogoutResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LogoutResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LogoutResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LogoutResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LogoutResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LogoutResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LogoutResponse parseFrom(InputStream inputStream) throws IOException {
            return (LogoutResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LogoutResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LogoutResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LogoutResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LogoutResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LogoutResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LogoutResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface LogoutResponseOrBuilder extends MessageLiteOrBuilder {
        String getCode();

        ByteString getCodeBytes();

        String getMid();

        ByteString getMidBytes();

        boolean hasCode();

        boolean hasMid();
    }

    private LogoutResponseProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
