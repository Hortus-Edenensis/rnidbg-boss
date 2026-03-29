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
public final class RegisterRequestBeanOuterClass {

    /* JADX INFO: renamed from: com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass$1, reason: invalid class name */
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
    public static final class RegisterRequestBean extends GeneratedMessageLite<RegisterRequestBean, Builder> implements RegisterRequestBeanOrBuilder {
        public static final int COUNTRYCODE_FIELD_NUMBER = 3;
        private static final RegisterRequestBean DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 9;
        public static final int EXT_FIELD_NUMBER = 7;
        public static final int FROMSOURCE_FIELD_NUMBER = 4;
        public static final int MOBILE_FIELD_NUMBER = 1;
        private static volatile Parser<RegisterRequestBean> PARSER = null;
        public static final int SCOPE_FIELD_NUMBER = 5;
        public static final int SIMID_FIELD_NUMBER = 10;
        public static final int SMSCODE_FIELD_NUMBER = 2;
        public static final int THIRDAPPID_FIELD_NUMBER = 6;
        public static final int TOKEN_FIELD_NUMBER = 8;
        private String mobile_ = "";
        private String smsCode_ = "";
        private String countryCode_ = "";
        private String fromSource_ = "";
        private String scope_ = "";
        private String thirdAppId_ = "";
        private String ext_ = "";
        private String token_ = "";
        private String deviceId_ = "";
        private String simId_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<RegisterRequestBean, Builder> implements RegisterRequestBeanOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCountryCode() {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).clearCountryCode();
                return this;
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).clearDeviceId();
                return this;
            }

            public Builder clearExt() {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).clearExt();
                return this;
            }

            public Builder clearFromSource() {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).clearFromSource();
                return this;
            }

            public Builder clearMobile() {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).clearMobile();
                return this;
            }

            public Builder clearScope() {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).clearScope();
                return this;
            }

            public Builder clearSimId() {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).clearSimId();
                return this;
            }

            public Builder clearSmsCode() {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).clearSmsCode();
                return this;
            }

            public Builder clearThirdAppId() {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).clearThirdAppId();
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).clearToken();
                return this;
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public String getCountryCode() {
                return ((RegisterRequestBean) this.instance).getCountryCode();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public ByteString getCountryCodeBytes() {
                return ((RegisterRequestBean) this.instance).getCountryCodeBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public String getDeviceId() {
                return ((RegisterRequestBean) this.instance).getDeviceId();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public ByteString getDeviceIdBytes() {
                return ((RegisterRequestBean) this.instance).getDeviceIdBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public String getExt() {
                return ((RegisterRequestBean) this.instance).getExt();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public ByteString getExtBytes() {
                return ((RegisterRequestBean) this.instance).getExtBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public String getFromSource() {
                return ((RegisterRequestBean) this.instance).getFromSource();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public ByteString getFromSourceBytes() {
                return ((RegisterRequestBean) this.instance).getFromSourceBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public String getMobile() {
                return ((RegisterRequestBean) this.instance).getMobile();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public ByteString getMobileBytes() {
                return ((RegisterRequestBean) this.instance).getMobileBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public String getScope() {
                return ((RegisterRequestBean) this.instance).getScope();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public ByteString getScopeBytes() {
                return ((RegisterRequestBean) this.instance).getScopeBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public String getSimId() {
                return ((RegisterRequestBean) this.instance).getSimId();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public ByteString getSimIdBytes() {
                return ((RegisterRequestBean) this.instance).getSimIdBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public String getSmsCode() {
                return ((RegisterRequestBean) this.instance).getSmsCode();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public ByteString getSmsCodeBytes() {
                return ((RegisterRequestBean) this.instance).getSmsCodeBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public String getThirdAppId() {
                return ((RegisterRequestBean) this.instance).getThirdAppId();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public ByteString getThirdAppIdBytes() {
                return ((RegisterRequestBean) this.instance).getThirdAppIdBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public String getToken() {
                return ((RegisterRequestBean) this.instance).getToken();
            }

            @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
            public ByteString getTokenBytes() {
                return ((RegisterRequestBean) this.instance).getTokenBytes();
            }

            public Builder setCountryCode(String str) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setCountryCode(str);
                return this;
            }

            public Builder setCountryCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setCountryCodeBytes(byteString);
                return this;
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setDeviceIdBytes(byteString);
                return this;
            }

            public Builder setExt(String str) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setExt(str);
                return this;
            }

            public Builder setExtBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setExtBytes(byteString);
                return this;
            }

            public Builder setFromSource(String str) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setFromSource(str);
                return this;
            }

            public Builder setFromSourceBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setFromSourceBytes(byteString);
                return this;
            }

            public Builder setMobile(String str) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setMobile(str);
                return this;
            }

            public Builder setMobileBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setMobileBytes(byteString);
                return this;
            }

            public Builder setScope(String str) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setScope(str);
                return this;
            }

            public Builder setScopeBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setScopeBytes(byteString);
                return this;
            }

            public Builder setSimId(String str) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setSimId(str);
                return this;
            }

            public Builder setSimIdBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setSimIdBytes(byteString);
                return this;
            }

            public Builder setSmsCode(String str) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setSmsCode(str);
                return this;
            }

            public Builder setSmsCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setSmsCodeBytes(byteString);
                return this;
            }

            public Builder setThirdAppId(String str) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setThirdAppId(str);
                return this;
            }

            public Builder setThirdAppIdBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setThirdAppIdBytes(byteString);
                return this;
            }

            public Builder setToken(String str) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setToken(str);
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterRequestBean) this.instance).setTokenBytes(byteString);
                return this;
            }

            private Builder() {
                super(RegisterRequestBean.DEFAULT_INSTANCE);
            }
        }

        static {
            RegisterRequestBean registerRequestBean = new RegisterRequestBean();
            DEFAULT_INSTANCE = registerRequestBean;
            registerRequestBean.makeImmutable();
        }

        private RegisterRequestBean() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCountryCode() {
            this.countryCode_ = getDefaultInstance().getCountryCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExt() {
            this.ext_ = getDefaultInstance().getExt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFromSource() {
            this.fromSource_ = getDefaultInstance().getFromSource();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMobile() {
            this.mobile_ = getDefaultInstance().getMobile();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScope() {
            this.scope_ = getDefaultInstance().getScope();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSimId() {
            this.simId_ = getDefaultInstance().getSimId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSmsCode() {
            this.smsCode_ = getDefaultInstance().getSmsCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThirdAppId() {
            this.thirdAppId_ = getDefaultInstance().getThirdAppId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToken() {
            this.token_ = getDefaultInstance().getToken();
        }

        public static RegisterRequestBean getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static RegisterRequestBean parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RegisterRequestBean) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RegisterRequestBean parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RegisterRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<RegisterRequestBean> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountryCode(String str) {
            str.getClass();
            this.countryCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountryCodeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.countryCode_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.deviceId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExt(String str) {
            str.getClass();
            this.ext_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.ext_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFromSource(String str) {
            str.getClass();
            this.fromSource_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFromSourceBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.fromSource_ = byteString.toStringUtf8();
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
        public void setScope(String str) {
            str.getClass();
            this.scope_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScopeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.scope_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSimId(String str) {
            str.getClass();
            this.simId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSimIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.simId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSmsCode(String str) {
            str.getClass();
            this.smsCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSmsCodeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.smsCode_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThirdAppId(String str) {
            str.getClass();
            this.thirdAppId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThirdAppIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.thirdAppId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToken(String str) {
            str.getClass();
            this.token_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTokenBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.token_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new RegisterRequestBean();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    RegisterRequestBean registerRequestBean = (RegisterRequestBean) obj2;
                    this.mobile_ = visitor.visitString(!this.mobile_.isEmpty(), this.mobile_, !registerRequestBean.mobile_.isEmpty(), registerRequestBean.mobile_);
                    this.smsCode_ = visitor.visitString(!this.smsCode_.isEmpty(), this.smsCode_, !registerRequestBean.smsCode_.isEmpty(), registerRequestBean.smsCode_);
                    this.countryCode_ = visitor.visitString(!this.countryCode_.isEmpty(), this.countryCode_, !registerRequestBean.countryCode_.isEmpty(), registerRequestBean.countryCode_);
                    this.fromSource_ = visitor.visitString(!this.fromSource_.isEmpty(), this.fromSource_, !registerRequestBean.fromSource_.isEmpty(), registerRequestBean.fromSource_);
                    this.scope_ = visitor.visitString(!this.scope_.isEmpty(), this.scope_, !registerRequestBean.scope_.isEmpty(), registerRequestBean.scope_);
                    this.thirdAppId_ = visitor.visitString(!this.thirdAppId_.isEmpty(), this.thirdAppId_, !registerRequestBean.thirdAppId_.isEmpty(), registerRequestBean.thirdAppId_);
                    this.ext_ = visitor.visitString(!this.ext_.isEmpty(), this.ext_, !registerRequestBean.ext_.isEmpty(), registerRequestBean.ext_);
                    this.token_ = visitor.visitString(!this.token_.isEmpty(), this.token_, !registerRequestBean.token_.isEmpty(), registerRequestBean.token_);
                    this.deviceId_ = visitor.visitString(!this.deviceId_.isEmpty(), this.deviceId_, !registerRequestBean.deviceId_.isEmpty(), registerRequestBean.deviceId_);
                    this.simId_ = visitor.visitString(!this.simId_.isEmpty(), this.simId_, true ^ registerRequestBean.simId_.isEmpty(), registerRequestBean.simId_);
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
                                    this.smsCode_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 26:
                                    this.countryCode_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 34:
                                    this.fromSource_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 42:
                                    this.scope_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 50:
                                    this.thirdAppId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 58:
                                    this.ext_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 66:
                                    this.token_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 74:
                                    this.deviceId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 82:
                                    this.simId_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (RegisterRequestBean.class) {
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

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public String getCountryCode() {
            return this.countryCode_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public ByteString getCountryCodeBytes() {
            return ByteString.copyFromUtf8(this.countryCode_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public String getDeviceId() {
            return this.deviceId_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public ByteString getDeviceIdBytes() {
            return ByteString.copyFromUtf8(this.deviceId_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public String getExt() {
            return this.ext_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public ByteString getExtBytes() {
            return ByteString.copyFromUtf8(this.ext_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public String getFromSource() {
            return this.fromSource_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public ByteString getFromSourceBytes() {
            return ByteString.copyFromUtf8(this.fromSource_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public String getMobile() {
            return this.mobile_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public ByteString getMobileBytes() {
            return ByteString.copyFromUtf8(this.mobile_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public String getScope() {
            return this.scope_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public ByteString getScopeBytes() {
            return ByteString.copyFromUtf8(this.scope_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.mobile_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getMobile());
            if (!this.smsCode_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getSmsCode());
            }
            if (!this.countryCode_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getCountryCode());
            }
            if (!this.fromSource_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, getFromSource());
            }
            if (!this.scope_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, getScope());
            }
            if (!this.thirdAppId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(6, getThirdAppId());
            }
            if (!this.ext_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(7, getExt());
            }
            if (!this.token_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(8, getToken());
            }
            if (!this.deviceId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(9, getDeviceId());
            }
            if (!this.simId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(10, getSimId());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public String getSimId() {
            return this.simId_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public ByteString getSimIdBytes() {
            return ByteString.copyFromUtf8(this.simId_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public String getSmsCode() {
            return this.smsCode_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public ByteString getSmsCodeBytes() {
            return ByteString.copyFromUtf8(this.smsCode_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public String getThirdAppId() {
            return this.thirdAppId_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public ByteString getThirdAppIdBytes() {
            return ByteString.copyFromUtf8(this.thirdAppId_);
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public String getToken() {
            return this.token_;
        }

        @Override // com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass.RegisterRequestBeanOrBuilder
        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.mobile_.isEmpty()) {
                codedOutputStream.writeString(1, getMobile());
            }
            if (!this.smsCode_.isEmpty()) {
                codedOutputStream.writeString(2, getSmsCode());
            }
            if (!this.countryCode_.isEmpty()) {
                codedOutputStream.writeString(3, getCountryCode());
            }
            if (!this.fromSource_.isEmpty()) {
                codedOutputStream.writeString(4, getFromSource());
            }
            if (!this.scope_.isEmpty()) {
                codedOutputStream.writeString(5, getScope());
            }
            if (!this.thirdAppId_.isEmpty()) {
                codedOutputStream.writeString(6, getThirdAppId());
            }
            if (!this.ext_.isEmpty()) {
                codedOutputStream.writeString(7, getExt());
            }
            if (!this.token_.isEmpty()) {
                codedOutputStream.writeString(8, getToken());
            }
            if (!this.deviceId_.isEmpty()) {
                codedOutputStream.writeString(9, getDeviceId());
            }
            if (this.simId_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(10, getSimId());
        }

        public static Builder newBuilder(RegisterRequestBean registerRequestBean) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(registerRequestBean);
        }

        public static RegisterRequestBean parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RegisterRequestBean) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RegisterRequestBean parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RegisterRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RegisterRequestBean parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RegisterRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RegisterRequestBean parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RegisterRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RegisterRequestBean parseFrom(InputStream inputStream) throws IOException {
            return (RegisterRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RegisterRequestBean parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RegisterRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RegisterRequestBean parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RegisterRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RegisterRequestBean parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RegisterRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface RegisterRequestBeanOrBuilder extends MessageLiteOrBuilder {
        String getCountryCode();

        ByteString getCountryCodeBytes();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        String getExt();

        ByteString getExtBytes();

        String getFromSource();

        ByteString getFromSourceBytes();

        String getMobile();

        ByteString getMobileBytes();

        String getScope();

        ByteString getScopeBytes();

        String getSimId();

        ByteString getSimIdBytes();

        String getSmsCode();

        ByteString getSmsCodeBytes();

        String getThirdAppId();

        ByteString getThirdAppIdBytes();

        String getToken();

        ByteString getTokenBytes();
    }

    private RegisterRequestBeanOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
