package com.lantern.auth.pb.pb_client;

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
/* JADX INFO: loaded from: classes9.dex */
public final class LSAutoLoginRespOuterClass {

    /* JADX INFO: renamed from: com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass$1, reason: invalid class name */
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
    public static final class LSAutoLoginResp extends GeneratedMessageLite<LSAutoLoginResp, Builder> implements LSAutoLoginRespOrBuilder {
        public static final int CODE_FIELD_NUMBER = 3;
        private static final LSAutoLoginResp DEFAULT_INSTANCE;
        public static final int MSG_FIELD_NUMBER = 4;
        public static final int OAUTHCODE_FIELD_NUMBER = 2;
        private static volatile Parser<LSAutoLoginResp> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 1;
        private String type_ = "";
        private String oauthCode_ = "";
        private String code_ = "";
        private String msg_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<LSAutoLoginResp, Builder> implements LSAutoLoginRespOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCode() {
                copyOnWrite();
                ((LSAutoLoginResp) this.instance).clearCode();
                return this;
            }

            public Builder clearMsg() {
                copyOnWrite();
                ((LSAutoLoginResp) this.instance).clearMsg();
                return this;
            }

            public Builder clearOauthCode() {
                copyOnWrite();
                ((LSAutoLoginResp) this.instance).clearOauthCode();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((LSAutoLoginResp) this.instance).clearType();
                return this;
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
            public String getCode() {
                return ((LSAutoLoginResp) this.instance).getCode();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
            public ByteString getCodeBytes() {
                return ((LSAutoLoginResp) this.instance).getCodeBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
            public String getMsg() {
                return ((LSAutoLoginResp) this.instance).getMsg();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
            public ByteString getMsgBytes() {
                return ((LSAutoLoginResp) this.instance).getMsgBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
            public String getOauthCode() {
                return ((LSAutoLoginResp) this.instance).getOauthCode();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
            public ByteString getOauthCodeBytes() {
                return ((LSAutoLoginResp) this.instance).getOauthCodeBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
            public String getType() {
                return ((LSAutoLoginResp) this.instance).getType();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
            public ByteString getTypeBytes() {
                return ((LSAutoLoginResp) this.instance).getTypeBytes();
            }

            public Builder setCode(String str) {
                copyOnWrite();
                ((LSAutoLoginResp) this.instance).setCode(str);
                return this;
            }

            public Builder setCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginResp) this.instance).setCodeBytes(byteString);
                return this;
            }

            public Builder setMsg(String str) {
                copyOnWrite();
                ((LSAutoLoginResp) this.instance).setMsg(str);
                return this;
            }

            public Builder setMsgBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginResp) this.instance).setMsgBytes(byteString);
                return this;
            }

            public Builder setOauthCode(String str) {
                copyOnWrite();
                ((LSAutoLoginResp) this.instance).setOauthCode(str);
                return this;
            }

            public Builder setOauthCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginResp) this.instance).setOauthCodeBytes(byteString);
                return this;
            }

            public Builder setType(String str) {
                copyOnWrite();
                ((LSAutoLoginResp) this.instance).setType(str);
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginResp) this.instance).setTypeBytes(byteString);
                return this;
            }

            private Builder() {
                super(LSAutoLoginResp.DEFAULT_INSTANCE);
            }
        }

        static {
            LSAutoLoginResp lSAutoLoginResp = new LSAutoLoginResp();
            DEFAULT_INSTANCE = lSAutoLoginResp;
            lSAutoLoginResp.makeImmutable();
        }

        private LSAutoLoginResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.code_ = getDefaultInstance().getCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsg() {
            this.msg_ = getDefaultInstance().getMsg();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOauthCode() {
            this.oauthCode_ = getDefaultInstance().getOauthCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.type_ = getDefaultInstance().getType();
        }

        public static LSAutoLoginResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static LSAutoLoginResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LSAutoLoginResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LSAutoLoginResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LSAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<LSAutoLoginResp> parser() {
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
        public void setMsg(String str) {
            str.getClass();
            this.msg_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.msg_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOauthCode(String str) {
            str.getClass();
            this.oauthCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOauthCodeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.oauthCode_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(String str) {
            str.getClass();
            this.type_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.type_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new LSAutoLoginResp();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    LSAutoLoginResp lSAutoLoginResp = (LSAutoLoginResp) obj2;
                    this.type_ = visitor.visitString(!this.type_.isEmpty(), this.type_, !lSAutoLoginResp.type_.isEmpty(), lSAutoLoginResp.type_);
                    this.oauthCode_ = visitor.visitString(!this.oauthCode_.isEmpty(), this.oauthCode_, !lSAutoLoginResp.oauthCode_.isEmpty(), lSAutoLoginResp.oauthCode_);
                    this.code_ = visitor.visitString(!this.code_.isEmpty(), this.code_, !lSAutoLoginResp.code_.isEmpty(), lSAutoLoginResp.code_);
                    this.msg_ = visitor.visitString(!this.msg_.isEmpty(), this.msg_, true ^ lSAutoLoginResp.msg_.isEmpty(), lSAutoLoginResp.msg_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.type_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    this.oauthCode_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    this.code_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 34) {
                                    this.msg_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (LSAutoLoginResp.class) {
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

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
        public String getCode() {
            return this.code_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
        public ByteString getCodeBytes() {
            return ByteString.copyFromUtf8(this.code_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
        public String getMsg() {
            return this.msg_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
        public ByteString getMsgBytes() {
            return ByteString.copyFromUtf8(this.msg_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
        public String getOauthCode() {
            return this.oauthCode_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
        public ByteString getOauthCodeBytes() {
            return ByteString.copyFromUtf8(this.oauthCode_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.type_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getType());
            if (!this.oauthCode_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getOauthCode());
            }
            if (!this.code_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getCode());
            }
            if (!this.msg_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, getMsg());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
        public String getType() {
            return this.type_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass.LSAutoLoginRespOrBuilder
        public ByteString getTypeBytes() {
            return ByteString.copyFromUtf8(this.type_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.type_.isEmpty()) {
                codedOutputStream.writeString(1, getType());
            }
            if (!this.oauthCode_.isEmpty()) {
                codedOutputStream.writeString(2, getOauthCode());
            }
            if (!this.code_.isEmpty()) {
                codedOutputStream.writeString(3, getCode());
            }
            if (this.msg_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(4, getMsg());
        }

        public static Builder newBuilder(LSAutoLoginResp lSAutoLoginResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(lSAutoLoginResp);
        }

        public static LSAutoLoginResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LSAutoLoginResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LSAutoLoginResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LSAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LSAutoLoginResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LSAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LSAutoLoginResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LSAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LSAutoLoginResp parseFrom(InputStream inputStream) throws IOException {
            return (LSAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LSAutoLoginResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LSAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LSAutoLoginResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LSAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LSAutoLoginResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LSAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface LSAutoLoginRespOrBuilder extends MessageLiteOrBuilder {
        String getCode();

        ByteString getCodeBytes();

        String getMsg();

        ByteString getMsgBytes();

        String getOauthCode();

        ByteString getOauthCodeBytes();

        String getType();

        ByteString getTypeBytes();
    }

    private LSAutoLoginRespOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
