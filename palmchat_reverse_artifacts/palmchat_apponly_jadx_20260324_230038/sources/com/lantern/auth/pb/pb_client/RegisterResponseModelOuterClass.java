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
public final class RegisterResponseModelOuterClass {

    /* JADX INFO: renamed from: com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass$1, reason: invalid class name */
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
    public static final class RegisterResponseModel extends GeneratedMessageLite<RegisterResponseModel, Builder> implements RegisterResponseModelOrBuilder {
        public static final int CODE_FIELD_NUMBER = 4;
        private static final RegisterResponseModel DEFAULT_INSTANCE;
        public static final int HEADIMGURL_FIELD_NUMBER = 7;
        public static final int MOBILE_FIELD_NUMBER = 1;
        public static final int MSG_FIELD_NUMBER = 5;
        public static final int NICKNAME_FIELD_NUMBER = 6;
        public static final int OAUTHCODE_FIELD_NUMBER = 10;
        private static volatile Parser<RegisterResponseModel> PARSER = null;
        public static final int SEX_FIELD_NUMBER = 8;
        public static final int UHID_FIELD_NUMBER = 2;
        public static final int UNIONID_FIELD_NUMBER = 9;
        public static final int USERTOKEN_FIELD_NUMBER = 3;
        private String mobile_ = "";
        private String uhid_ = "";
        private String userToken_ = "";
        private String code_ = "";
        private String msg_ = "";
        private String nickName_ = "";
        private String headImgUrl_ = "";
        private String sex_ = "";
        private String unionId_ = "";
        private String oauthCode_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<RegisterResponseModel, Builder> implements RegisterResponseModelOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCode() {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).clearCode();
                return this;
            }

            public Builder clearHeadImgUrl() {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).clearHeadImgUrl();
                return this;
            }

            public Builder clearMobile() {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).clearMobile();
                return this;
            }

            public Builder clearMsg() {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).clearMsg();
                return this;
            }

            public Builder clearNickName() {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).clearNickName();
                return this;
            }

            public Builder clearOauthCode() {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).clearOauthCode();
                return this;
            }

            public Builder clearSex() {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).clearSex();
                return this;
            }

            public Builder clearUhid() {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).clearUhid();
                return this;
            }

            public Builder clearUnionId() {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).clearUnionId();
                return this;
            }

            public Builder clearUserToken() {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).clearUserToken();
                return this;
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public String getCode() {
                return ((RegisterResponseModel) this.instance).getCode();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public ByteString getCodeBytes() {
                return ((RegisterResponseModel) this.instance).getCodeBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public String getHeadImgUrl() {
                return ((RegisterResponseModel) this.instance).getHeadImgUrl();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public ByteString getHeadImgUrlBytes() {
                return ((RegisterResponseModel) this.instance).getHeadImgUrlBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public String getMobile() {
                return ((RegisterResponseModel) this.instance).getMobile();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public ByteString getMobileBytes() {
                return ((RegisterResponseModel) this.instance).getMobileBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public String getMsg() {
                return ((RegisterResponseModel) this.instance).getMsg();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public ByteString getMsgBytes() {
                return ((RegisterResponseModel) this.instance).getMsgBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public String getNickName() {
                return ((RegisterResponseModel) this.instance).getNickName();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public ByteString getNickNameBytes() {
                return ((RegisterResponseModel) this.instance).getNickNameBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public String getOauthCode() {
                return ((RegisterResponseModel) this.instance).getOauthCode();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public ByteString getOauthCodeBytes() {
                return ((RegisterResponseModel) this.instance).getOauthCodeBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public String getSex() {
                return ((RegisterResponseModel) this.instance).getSex();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public ByteString getSexBytes() {
                return ((RegisterResponseModel) this.instance).getSexBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public String getUhid() {
                return ((RegisterResponseModel) this.instance).getUhid();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public ByteString getUhidBytes() {
                return ((RegisterResponseModel) this.instance).getUhidBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public String getUnionId() {
                return ((RegisterResponseModel) this.instance).getUnionId();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public ByteString getUnionIdBytes() {
                return ((RegisterResponseModel) this.instance).getUnionIdBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public String getUserToken() {
                return ((RegisterResponseModel) this.instance).getUserToken();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
            public ByteString getUserTokenBytes() {
                return ((RegisterResponseModel) this.instance).getUserTokenBytes();
            }

            public Builder setCode(String str) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setCode(str);
                return this;
            }

            public Builder setCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setCodeBytes(byteString);
                return this;
            }

            public Builder setHeadImgUrl(String str) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setHeadImgUrl(str);
                return this;
            }

            public Builder setHeadImgUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setHeadImgUrlBytes(byteString);
                return this;
            }

            public Builder setMobile(String str) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setMobile(str);
                return this;
            }

            public Builder setMobileBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setMobileBytes(byteString);
                return this;
            }

            public Builder setMsg(String str) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setMsg(str);
                return this;
            }

            public Builder setMsgBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setMsgBytes(byteString);
                return this;
            }

            public Builder setNickName(String str) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setNickName(str);
                return this;
            }

            public Builder setNickNameBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setNickNameBytes(byteString);
                return this;
            }

            public Builder setOauthCode(String str) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setOauthCode(str);
                return this;
            }

            public Builder setOauthCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setOauthCodeBytes(byteString);
                return this;
            }

            public Builder setSex(String str) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setSex(str);
                return this;
            }

            public Builder setSexBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setSexBytes(byteString);
                return this;
            }

            public Builder setUhid(String str) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setUhid(str);
                return this;
            }

            public Builder setUhidBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setUhidBytes(byteString);
                return this;
            }

            public Builder setUnionId(String str) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setUnionId(str);
                return this;
            }

            public Builder setUnionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setUnionIdBytes(byteString);
                return this;
            }

            public Builder setUserToken(String str) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setUserToken(str);
                return this;
            }

            public Builder setUserTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterResponseModel) this.instance).setUserTokenBytes(byteString);
                return this;
            }

            private Builder() {
                super(RegisterResponseModel.DEFAULT_INSTANCE);
            }
        }

        static {
            RegisterResponseModel registerResponseModel = new RegisterResponseModel();
            DEFAULT_INSTANCE = registerResponseModel;
            registerResponseModel.makeImmutable();
        }

        private RegisterResponseModel() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.code_ = getDefaultInstance().getCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeadImgUrl() {
            this.headImgUrl_ = getDefaultInstance().getHeadImgUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMobile() {
            this.mobile_ = getDefaultInstance().getMobile();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsg() {
            this.msg_ = getDefaultInstance().getMsg();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNickName() {
            this.nickName_ = getDefaultInstance().getNickName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOauthCode() {
            this.oauthCode_ = getDefaultInstance().getOauthCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSex() {
            this.sex_ = getDefaultInstance().getSex();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUhid() {
            this.uhid_ = getDefaultInstance().getUhid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnionId() {
            this.unionId_ = getDefaultInstance().getUnionId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserToken() {
            this.userToken_ = getDefaultInstance().getUserToken();
        }

        public static RegisterResponseModel getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static RegisterResponseModel parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RegisterResponseModel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RegisterResponseModel parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RegisterResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<RegisterResponseModel> parser() {
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
        public void setHeadImgUrl(String str) {
            str.getClass();
            this.headImgUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeadImgUrlBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.headImgUrl_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMobile(String str) {
            str.getClass();
            this.mobile_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMobileBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.mobile_ = byteString.toStringUtf8();
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
        public void setNickName(String str) {
            str.getClass();
            this.nickName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNickNameBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.nickName_ = byteString.toStringUtf8();
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
        public void setSex(String str) {
            str.getClass();
            this.sex_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSexBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sex_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUhid(String str) {
            str.getClass();
            this.uhid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUhidBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.uhid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnionId(String str) {
            str.getClass();
            this.unionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnionIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.unionId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserToken(String str) {
            str.getClass();
            this.userToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserTokenBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userToken_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new RegisterResponseModel();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    RegisterResponseModel registerResponseModel = (RegisterResponseModel) obj2;
                    this.mobile_ = visitor.visitString(!this.mobile_.isEmpty(), this.mobile_, !registerResponseModel.mobile_.isEmpty(), registerResponseModel.mobile_);
                    this.uhid_ = visitor.visitString(!this.uhid_.isEmpty(), this.uhid_, !registerResponseModel.uhid_.isEmpty(), registerResponseModel.uhid_);
                    this.userToken_ = visitor.visitString(!this.userToken_.isEmpty(), this.userToken_, !registerResponseModel.userToken_.isEmpty(), registerResponseModel.userToken_);
                    this.code_ = visitor.visitString(!this.code_.isEmpty(), this.code_, !registerResponseModel.code_.isEmpty(), registerResponseModel.code_);
                    this.msg_ = visitor.visitString(!this.msg_.isEmpty(), this.msg_, !registerResponseModel.msg_.isEmpty(), registerResponseModel.msg_);
                    this.nickName_ = visitor.visitString(!this.nickName_.isEmpty(), this.nickName_, !registerResponseModel.nickName_.isEmpty(), registerResponseModel.nickName_);
                    this.headImgUrl_ = visitor.visitString(!this.headImgUrl_.isEmpty(), this.headImgUrl_, !registerResponseModel.headImgUrl_.isEmpty(), registerResponseModel.headImgUrl_);
                    this.sex_ = visitor.visitString(!this.sex_.isEmpty(), this.sex_, !registerResponseModel.sex_.isEmpty(), registerResponseModel.sex_);
                    this.unionId_ = visitor.visitString(!this.unionId_.isEmpty(), this.unionId_, !registerResponseModel.unionId_.isEmpty(), registerResponseModel.unionId_);
                    this.oauthCode_ = visitor.visitString(!this.oauthCode_.isEmpty(), this.oauthCode_, true ^ registerResponseModel.oauthCode_.isEmpty(), registerResponseModel.oauthCode_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            switch (tag) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    this.mobile_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 18:
                                    this.uhid_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 26:
                                    this.userToken_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 34:
                                    this.code_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 42:
                                    this.msg_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 50:
                                    this.nickName_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 58:
                                    this.headImgUrl_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 66:
                                    this.sex_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 74:
                                    this.unionId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 82:
                                    this.oauthCode_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                default:
                                    if (!codedInputStream.skipField(tag)) {
                                        z = true;
                                    }
                                    break;
                            }
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
                        synchronized (RegisterResponseModel.class) {
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

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public String getCode() {
            return this.code_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public ByteString getCodeBytes() {
            return ByteString.copyFromUtf8(this.code_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public String getHeadImgUrl() {
            return this.headImgUrl_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public ByteString getHeadImgUrlBytes() {
            return ByteString.copyFromUtf8(this.headImgUrl_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public String getMobile() {
            return this.mobile_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public ByteString getMobileBytes() {
            return ByteString.copyFromUtf8(this.mobile_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public String getMsg() {
            return this.msg_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public ByteString getMsgBytes() {
            return ByteString.copyFromUtf8(this.msg_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public String getNickName() {
            return this.nickName_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public ByteString getNickNameBytes() {
            return ByteString.copyFromUtf8(this.nickName_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public String getOauthCode() {
            return this.oauthCode_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public ByteString getOauthCodeBytes() {
            return ByteString.copyFromUtf8(this.oauthCode_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.mobile_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getMobile());
            if (!this.uhid_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getUhid());
            }
            if (!this.userToken_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getUserToken());
            }
            if (!this.code_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, getCode());
            }
            if (!this.msg_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, getMsg());
            }
            if (!this.nickName_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(6, getNickName());
            }
            if (!this.headImgUrl_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(7, getHeadImgUrl());
            }
            if (!this.sex_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(8, getSex());
            }
            if (!this.unionId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(9, getUnionId());
            }
            if (!this.oauthCode_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(10, getOauthCode());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public String getSex() {
            return this.sex_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public ByteString getSexBytes() {
            return ByteString.copyFromUtf8(this.sex_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public String getUhid() {
            return this.uhid_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public ByteString getUhidBytes() {
            return ByteString.copyFromUtf8(this.uhid_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public String getUnionId() {
            return this.unionId_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public ByteString getUnionIdBytes() {
            return ByteString.copyFromUtf8(this.unionId_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public String getUserToken() {
            return this.userToken_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass.RegisterResponseModelOrBuilder
        public ByteString getUserTokenBytes() {
            return ByteString.copyFromUtf8(this.userToken_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.mobile_.isEmpty()) {
                codedOutputStream.writeString(1, getMobile());
            }
            if (!this.uhid_.isEmpty()) {
                codedOutputStream.writeString(2, getUhid());
            }
            if (!this.userToken_.isEmpty()) {
                codedOutputStream.writeString(3, getUserToken());
            }
            if (!this.code_.isEmpty()) {
                codedOutputStream.writeString(4, getCode());
            }
            if (!this.msg_.isEmpty()) {
                codedOutputStream.writeString(5, getMsg());
            }
            if (!this.nickName_.isEmpty()) {
                codedOutputStream.writeString(6, getNickName());
            }
            if (!this.headImgUrl_.isEmpty()) {
                codedOutputStream.writeString(7, getHeadImgUrl());
            }
            if (!this.sex_.isEmpty()) {
                codedOutputStream.writeString(8, getSex());
            }
            if (!this.unionId_.isEmpty()) {
                codedOutputStream.writeString(9, getUnionId());
            }
            if (this.oauthCode_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(10, getOauthCode());
        }

        public static Builder newBuilder(RegisterResponseModel registerResponseModel) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(registerResponseModel);
        }

        public static RegisterResponseModel parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RegisterResponseModel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RegisterResponseModel parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RegisterResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RegisterResponseModel parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RegisterResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RegisterResponseModel parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RegisterResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RegisterResponseModel parseFrom(InputStream inputStream) throws IOException {
            return (RegisterResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RegisterResponseModel parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RegisterResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RegisterResponseModel parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RegisterResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RegisterResponseModel parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RegisterResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface RegisterResponseModelOrBuilder extends MessageLiteOrBuilder {
        String getCode();

        ByteString getCodeBytes();

        String getHeadImgUrl();

        ByteString getHeadImgUrlBytes();

        String getMobile();

        ByteString getMobileBytes();

        String getMsg();

        ByteString getMsgBytes();

        String getNickName();

        ByteString getNickNameBytes();

        String getOauthCode();

        ByteString getOauthCodeBytes();

        String getSex();

        ByteString getSexBytes();

        String getUhid();

        ByteString getUhidBytes();

        String getUnionId();

        ByteString getUnionIdBytes();

        String getUserToken();

        ByteString getUserTokenBytes();
    }

    private RegisterResponseModelOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
