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
public final class CDASecurityInfoOuterClass {

    /* JADX INFO: renamed from: com.cdadata.sdk.api.protobuf.event.CDASecurityInfoOuterClass$1, reason: invalid class name */
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
    public static final class CDASecurityInfo extends GeneratedMessageLite<CDASecurityInfo, Builder> implements CDASecurityInfoOrBuilder {
        private static final CDASecurityInfo DEFAULT_INSTANCE;
        public static final int IV_FIELD_NUMBER = 1;
        public static final int KEY_FIELD_NUMBER = 2;
        private static volatile Parser<CDASecurityInfo> PARSER;
        private String iv_ = "";
        private String key_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<CDASecurityInfo, Builder> implements CDASecurityInfoOrBuilder {
            private Builder() {
                super(CDASecurityInfo.DEFAULT_INSTANCE);
            }

            public Builder clearIv() {
                copyOnWrite();
                ((CDASecurityInfo) this.instance).clearIv();
                return this;
            }

            public Builder clearKey() {
                copyOnWrite();
                ((CDASecurityInfo) this.instance).clearKey();
                return this;
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CDASecurityInfoOuterClass.CDASecurityInfoOrBuilder
            public String getIv() {
                return ((CDASecurityInfo) this.instance).getIv();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CDASecurityInfoOuterClass.CDASecurityInfoOrBuilder
            public ByteString getIvBytes() {
                return ((CDASecurityInfo) this.instance).getIvBytes();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CDASecurityInfoOuterClass.CDASecurityInfoOrBuilder
            public String getKey() {
                return ((CDASecurityInfo) this.instance).getKey();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CDASecurityInfoOuterClass.CDASecurityInfoOrBuilder
            public ByteString getKeyBytes() {
                return ((CDASecurityInfo) this.instance).getKeyBytes();
            }

            public Builder setIv(String str) {
                copyOnWrite();
                ((CDASecurityInfo) this.instance).setIv(str);
                return this;
            }

            public Builder setIvBytes(ByteString byteString) {
                copyOnWrite();
                ((CDASecurityInfo) this.instance).setIvBytes(byteString);
                return this;
            }

            public Builder setKey(String str) {
                copyOnWrite();
                ((CDASecurityInfo) this.instance).setKey(str);
                return this;
            }

            public Builder setKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((CDASecurityInfo) this.instance).setKeyBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }
        }

        static {
            CDASecurityInfo cDASecurityInfo = new CDASecurityInfo();
            DEFAULT_INSTANCE = cDASecurityInfo;
            cDASecurityInfo.makeImmutable();
        }

        private CDASecurityInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIv() {
            this.iv_ = getDefaultInstance().getIv();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKey() {
            this.key_ = getDefaultInstance().getKey();
        }

        public static CDASecurityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CDASecurityInfo parseDelimitedFrom(InputStream inputStream) {
            return (CDASecurityInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CDASecurityInfo parseFrom(ByteString byteString) {
            return (CDASecurityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<CDASecurityInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIv(String str) {
            str.getClass();
            this.iv_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIvBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.iv_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKey(String str) {
            str.getClass();
            this.key_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.key_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CDASecurityInfo();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CDASecurityInfo cDASecurityInfo = (CDASecurityInfo) obj2;
                    this.iv_ = visitor.visitString(!this.iv_.isEmpty(), this.iv_, !cDASecurityInfo.iv_.isEmpty(), cDASecurityInfo.iv_);
                    this.key_ = visitor.visitString(!this.key_.isEmpty(), this.key_, true ^ cDASecurityInfo.key_.isEmpty(), cDASecurityInfo.key_);
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.iv_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    this.key_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (CDASecurityInfo.class) {
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

        @Override // com.cdadata.sdk.api.protobuf.event.CDASecurityInfoOuterClass.CDASecurityInfoOrBuilder
        public String getIv() {
            return this.iv_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CDASecurityInfoOuterClass.CDASecurityInfoOrBuilder
        public ByteString getIvBytes() {
            return ByteString.copyFromUtf8(this.iv_);
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CDASecurityInfoOuterClass.CDASecurityInfoOrBuilder
        public String getKey() {
            return this.key_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CDASecurityInfoOuterClass.CDASecurityInfoOrBuilder
        public ByteString getKeyBytes() {
            return ByteString.copyFromUtf8(this.key_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.iv_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getIv());
            if (!this.key_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getKey());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.iv_.isEmpty()) {
                codedOutputStream.writeString(1, getIv());
            }
            if (this.key_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(2, getKey());
        }

        public static Builder newBuilder(CDASecurityInfo cDASecurityInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cDASecurityInfo);
        }

        public static CDASecurityInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CDASecurityInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CDASecurityInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CDASecurityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CDASecurityInfo parseFrom(CodedInputStream codedInputStream) {
            return (CDASecurityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CDASecurityInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CDASecurityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static CDASecurityInfo parseFrom(InputStream inputStream) {
            return (CDASecurityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CDASecurityInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CDASecurityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CDASecurityInfo parseFrom(byte[] bArr) {
            return (CDASecurityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CDASecurityInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CDASecurityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CDASecurityInfoOrBuilder extends MessageLiteOrBuilder {
        String getIv();

        ByteString getIvBytes();

        String getKey();

        ByteString getKeyBytes();
    }

    private CDASecurityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
