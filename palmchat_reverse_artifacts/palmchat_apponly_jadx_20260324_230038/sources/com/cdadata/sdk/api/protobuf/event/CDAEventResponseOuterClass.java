package com.cdadata.sdk.api.protobuf.event;

import com.google.protobuf.AbstractMessageLite;
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
/* JADX INFO: loaded from: classes7.dex */
public final class CDAEventResponseOuterClass {

    /* JADX INFO: renamed from: com.cdadata.sdk.api.protobuf.event.CDAEventResponseOuterClass$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

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
    public static final class CDAEventResponse extends GeneratedMessageLite<CDAEventResponse, Builder> implements CDAEventResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final CDAEventResponse DEFAULT_INSTANCE;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        private static volatile Parser<CDAEventResponse> PARSER;
        private String code_ = "";
        private String message_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<CDAEventResponse, Builder> implements CDAEventResponseOrBuilder {
            private Builder() {
                super(CDAEventResponse.DEFAULT_INSTANCE);
            }

            public Builder clearCode() {
                copyOnWrite();
                ((CDAEventResponse) this.instance).clearCode();
                return this;
            }

            public Builder clearMessage() {
                copyOnWrite();
                ((CDAEventResponse) this.instance).clearMessage();
                return this;
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CDAEventResponseOuterClass.CDAEventResponseOrBuilder
            public String getCode() {
                return ((CDAEventResponse) this.instance).getCode();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CDAEventResponseOuterClass.CDAEventResponseOrBuilder
            public ByteString getCodeBytes() {
                return ((CDAEventResponse) this.instance).getCodeBytes();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CDAEventResponseOuterClass.CDAEventResponseOrBuilder
            public String getMessage() {
                return ((CDAEventResponse) this.instance).getMessage();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CDAEventResponseOuterClass.CDAEventResponseOrBuilder
            public ByteString getMessageBytes() {
                return ((CDAEventResponse) this.instance).getMessageBytes();
            }

            public Builder setCode(String str) {
                copyOnWrite();
                ((CDAEventResponse) this.instance).setCode(str);
                return this;
            }

            public Builder setCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((CDAEventResponse) this.instance).setCodeBytes(byteString);
                return this;
            }

            public Builder setMessage(String str) {
                copyOnWrite();
                ((CDAEventResponse) this.instance).setMessage(str);
                return this;
            }

            public Builder setMessageBytes(ByteString byteString) {
                copyOnWrite();
                ((CDAEventResponse) this.instance).setMessageBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }
        }

        static {
            CDAEventResponse cDAEventResponse = new CDAEventResponse();
            DEFAULT_INSTANCE = cDAEventResponse;
            cDAEventResponse.makeImmutable();
        }

        private CDAEventResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.code_ = getDefaultInstance().getCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessage() {
            this.message_ = getDefaultInstance().getMessage();
        }

        public static CDAEventResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CDAEventResponse parseDelimitedFrom(InputStream inputStream) {
            return (CDAEventResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CDAEventResponse parseFrom(ByteString byteString) {
            return (CDAEventResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<CDAEventResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(String str) {
            str.getClass();
            this.code_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCodeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.code_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessage(String str) {
            str.getClass();
            this.message_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessageBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.message_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CDAEventResponse();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CDAEventResponse cDAEventResponse = (CDAEventResponse) obj2;
                    this.code_ = visitor.visitString(!this.code_.isEmpty(), this.code_, !cDAEventResponse.code_.isEmpty(), cDAEventResponse.code_);
                    this.message_ = visitor.visitString(!this.message_.isEmpty(), this.message_, true ^ cDAEventResponse.message_.isEmpty(), cDAEventResponse.message_);
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.code_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    this.message_ = codedInputStream.readStringRequireUtf8();
                                } else if (!codedInputStream.skipField(tag)) {
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
                        synchronized (CDAEventResponse.class) {
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

        @Override // com.cdadata.sdk.api.protobuf.event.CDAEventResponseOuterClass.CDAEventResponseOrBuilder
        public String getCode() {
            return this.code_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CDAEventResponseOuterClass.CDAEventResponseOrBuilder
        public ByteString getCodeBytes() {
            return ByteString.copyFromUtf8(this.code_);
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CDAEventResponseOuterClass.CDAEventResponseOrBuilder
        public String getMessage() {
            return this.message_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CDAEventResponseOuterClass.CDAEventResponseOrBuilder
        public ByteString getMessageBytes() {
            return ByteString.copyFromUtf8(this.message_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.code_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getCode());
            if (!this.message_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getMessage());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.code_.isEmpty()) {
                codedOutputStream.writeString(1, getCode());
            }
            if (this.message_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(2, getMessage());
        }

        public static Builder newBuilder(CDAEventResponse cDAEventResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cDAEventResponse);
        }

        public static CDAEventResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CDAEventResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CDAEventResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CDAEventResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CDAEventResponse parseFrom(CodedInputStream codedInputStream) {
            return (CDAEventResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CDAEventResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CDAEventResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static CDAEventResponse parseFrom(InputStream inputStream) {
            return (CDAEventResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CDAEventResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CDAEventResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CDAEventResponse parseFrom(byte[] bArr) {
            return (CDAEventResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CDAEventResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CDAEventResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CDAEventResponseOrBuilder extends MessageLiteOrBuilder {
        String getCode();

        ByteString getCodeBytes();

        String getMessage();

        ByteString getMessageBytes();
    }

    private CDAEventResponseOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
