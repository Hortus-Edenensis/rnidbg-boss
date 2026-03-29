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
public final class LSAutoLoginReqOuterClass {

    /* JADX INFO: renamed from: com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass$1, reason: invalid class name */
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
    public static final class LSAutoLoginReq extends GeneratedMessageLite<LSAutoLoginReq, Builder> implements LSAutoLoginReqOrBuilder {
        public static final int ACCESSTOKEN_FIELD_NUMBER = 1;
        public static final int APPTYPE_FIELD_NUMBER = 3;
        public static final int CLIENTID_FIELD_NUMBER = 4;
        public static final int COUNTRYCODE_FIELD_NUMBER = 12;
        private static final LSAutoLoginReq DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 9;
        public static final int EXT_FIELD_NUMBER = 11;
        public static final int MASKMOBILE_FIELD_NUMBER = 8;
        public static final int MOVETYPE_FIELD_NUMBER = 5;
        public static final int OPERATOR_FIELD_NUMBER = 14;
        private static volatile Parser<LSAutoLoginReq> PARSER = null;
        public static final int SCOPE_FIELD_NUMBER = 7;
        public static final int SIMID_FIELD_NUMBER = 10;
        public static final int THIRDAPPID_FIELD_NUMBER = 6;
        public static final int TOKEN_FIELD_NUMBER = 13;
        public static final int UNIQUEID_FIELD_NUMBER = 2;
        private String accessToken_ = "";
        private String uniqueId_ = "";
        private String apptype_ = "";
        private String clientId_ = "";
        private String moveType_ = "";
        private String thirdAppId_ = "";
        private String scope_ = "";
        private String maskMobile_ = "";
        private String deviceId_ = "";
        private String simId_ = "";
        private String ext_ = "";
        private String countryCode_ = "";
        private String token_ = "";
        private String operator_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<LSAutoLoginReq, Builder> implements LSAutoLoginReqOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAccessToken() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearAccessToken();
                return this;
            }

            public Builder clearApptype() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearApptype();
                return this;
            }

            public Builder clearClientId() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearClientId();
                return this;
            }

            public Builder clearCountryCode() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearCountryCode();
                return this;
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearDeviceId();
                return this;
            }

            public Builder clearExt() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearExt();
                return this;
            }

            public Builder clearMaskMobile() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearMaskMobile();
                return this;
            }

            public Builder clearMoveType() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearMoveType();
                return this;
            }

            public Builder clearOperator() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearOperator();
                return this;
            }

            public Builder clearScope() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearScope();
                return this;
            }

            public Builder clearSimId() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearSimId();
                return this;
            }

            public Builder clearThirdAppId() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearThirdAppId();
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearToken();
                return this;
            }

            public Builder clearUniqueId() {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).clearUniqueId();
                return this;
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getAccessToken() {
                return ((LSAutoLoginReq) this.instance).getAccessToken();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getAccessTokenBytes() {
                return ((LSAutoLoginReq) this.instance).getAccessTokenBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getApptype() {
                return ((LSAutoLoginReq) this.instance).getApptype();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getApptypeBytes() {
                return ((LSAutoLoginReq) this.instance).getApptypeBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getClientId() {
                return ((LSAutoLoginReq) this.instance).getClientId();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getClientIdBytes() {
                return ((LSAutoLoginReq) this.instance).getClientIdBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getCountryCode() {
                return ((LSAutoLoginReq) this.instance).getCountryCode();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getCountryCodeBytes() {
                return ((LSAutoLoginReq) this.instance).getCountryCodeBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getDeviceId() {
                return ((LSAutoLoginReq) this.instance).getDeviceId();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getDeviceIdBytes() {
                return ((LSAutoLoginReq) this.instance).getDeviceIdBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getExt() {
                return ((LSAutoLoginReq) this.instance).getExt();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getExtBytes() {
                return ((LSAutoLoginReq) this.instance).getExtBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getMaskMobile() {
                return ((LSAutoLoginReq) this.instance).getMaskMobile();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getMaskMobileBytes() {
                return ((LSAutoLoginReq) this.instance).getMaskMobileBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getMoveType() {
                return ((LSAutoLoginReq) this.instance).getMoveType();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getMoveTypeBytes() {
                return ((LSAutoLoginReq) this.instance).getMoveTypeBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getOperator() {
                return ((LSAutoLoginReq) this.instance).getOperator();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getOperatorBytes() {
                return ((LSAutoLoginReq) this.instance).getOperatorBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getScope() {
                return ((LSAutoLoginReq) this.instance).getScope();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getScopeBytes() {
                return ((LSAutoLoginReq) this.instance).getScopeBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getSimId() {
                return ((LSAutoLoginReq) this.instance).getSimId();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getSimIdBytes() {
                return ((LSAutoLoginReq) this.instance).getSimIdBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getThirdAppId() {
                return ((LSAutoLoginReq) this.instance).getThirdAppId();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getThirdAppIdBytes() {
                return ((LSAutoLoginReq) this.instance).getThirdAppIdBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getToken() {
                return ((LSAutoLoginReq) this.instance).getToken();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getTokenBytes() {
                return ((LSAutoLoginReq) this.instance).getTokenBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public String getUniqueId() {
                return ((LSAutoLoginReq) this.instance).getUniqueId();
            }

            @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
            public ByteString getUniqueIdBytes() {
                return ((LSAutoLoginReq) this.instance).getUniqueIdBytes();
            }

            public Builder setAccessToken(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setAccessToken(str);
                return this;
            }

            public Builder setAccessTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setAccessTokenBytes(byteString);
                return this;
            }

            public Builder setApptype(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setApptype(str);
                return this;
            }

            public Builder setApptypeBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setApptypeBytes(byteString);
                return this;
            }

            public Builder setClientId(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setClientId(str);
                return this;
            }

            public Builder setClientIdBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setClientIdBytes(byteString);
                return this;
            }

            public Builder setCountryCode(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setCountryCode(str);
                return this;
            }

            public Builder setCountryCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setCountryCodeBytes(byteString);
                return this;
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setDeviceIdBytes(byteString);
                return this;
            }

            public Builder setExt(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setExt(str);
                return this;
            }

            public Builder setExtBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setExtBytes(byteString);
                return this;
            }

            public Builder setMaskMobile(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setMaskMobile(str);
                return this;
            }

            public Builder setMaskMobileBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setMaskMobileBytes(byteString);
                return this;
            }

            public Builder setMoveType(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setMoveType(str);
                return this;
            }

            public Builder setMoveTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setMoveTypeBytes(byteString);
                return this;
            }

            public Builder setOperator(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setOperator(str);
                return this;
            }

            public Builder setOperatorBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setOperatorBytes(byteString);
                return this;
            }

            public Builder setScope(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setScope(str);
                return this;
            }

            public Builder setScopeBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setScopeBytes(byteString);
                return this;
            }

            public Builder setSimId(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setSimId(str);
                return this;
            }

            public Builder setSimIdBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setSimIdBytes(byteString);
                return this;
            }

            public Builder setThirdAppId(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setThirdAppId(str);
                return this;
            }

            public Builder setThirdAppIdBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setThirdAppIdBytes(byteString);
                return this;
            }

            public Builder setToken(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setToken(str);
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setTokenBytes(byteString);
                return this;
            }

            public Builder setUniqueId(String str) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setUniqueId(str);
                return this;
            }

            public Builder setUniqueIdBytes(ByteString byteString) {
                copyOnWrite();
                ((LSAutoLoginReq) this.instance).setUniqueIdBytes(byteString);
                return this;
            }

            private Builder() {
                super(LSAutoLoginReq.DEFAULT_INSTANCE);
            }
        }

        static {
            LSAutoLoginReq lSAutoLoginReq = new LSAutoLoginReq();
            DEFAULT_INSTANCE = lSAutoLoginReq;
            lSAutoLoginReq.makeImmutable();
        }

        private LSAutoLoginReq() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAccessToken() {
            this.accessToken_ = getDefaultInstance().getAccessToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearApptype() {
            this.apptype_ = getDefaultInstance().getApptype();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientId() {
            this.clientId_ = getDefaultInstance().getClientId();
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
        public void clearMaskMobile() {
            this.maskMobile_ = getDefaultInstance().getMaskMobile();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMoveType() {
            this.moveType_ = getDefaultInstance().getMoveType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOperator() {
            this.operator_ = getDefaultInstance().getOperator();
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
        public void clearThirdAppId() {
            this.thirdAppId_ = getDefaultInstance().getThirdAppId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToken() {
            this.token_ = getDefaultInstance().getToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUniqueId() {
            this.uniqueId_ = getDefaultInstance().getUniqueId();
        }

        public static LSAutoLoginReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static LSAutoLoginReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LSAutoLoginReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LSAutoLoginReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LSAutoLoginReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<LSAutoLoginReq> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAccessToken(String str) {
            str.getClass();
            this.accessToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAccessTokenBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.accessToken_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApptype(String str) {
            str.getClass();
            this.apptype_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApptypeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.apptype_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientId(String str) {
            str.getClass();
            this.clientId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.clientId_ = byteString.toStringUtf8();
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
        public void setMaskMobile(String str) {
            str.getClass();
            this.maskMobile_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMaskMobileBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.maskMobile_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMoveType(String str) {
            str.getClass();
            this.moveType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMoveTypeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.moveType_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOperator(String str) {
            str.getClass();
            this.operator_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOperatorBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.operator_ = byteString.toStringUtf8();
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setUniqueId(String str) {
            str.getClass();
            this.uniqueId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUniqueIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.uniqueId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new LSAutoLoginReq();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    LSAutoLoginReq lSAutoLoginReq = (LSAutoLoginReq) obj2;
                    this.accessToken_ = visitor.visitString(!this.accessToken_.isEmpty(), this.accessToken_, !lSAutoLoginReq.accessToken_.isEmpty(), lSAutoLoginReq.accessToken_);
                    this.uniqueId_ = visitor.visitString(!this.uniqueId_.isEmpty(), this.uniqueId_, !lSAutoLoginReq.uniqueId_.isEmpty(), lSAutoLoginReq.uniqueId_);
                    this.apptype_ = visitor.visitString(!this.apptype_.isEmpty(), this.apptype_, !lSAutoLoginReq.apptype_.isEmpty(), lSAutoLoginReq.apptype_);
                    this.clientId_ = visitor.visitString(!this.clientId_.isEmpty(), this.clientId_, !lSAutoLoginReq.clientId_.isEmpty(), lSAutoLoginReq.clientId_);
                    this.moveType_ = visitor.visitString(!this.moveType_.isEmpty(), this.moveType_, !lSAutoLoginReq.moveType_.isEmpty(), lSAutoLoginReq.moveType_);
                    this.thirdAppId_ = visitor.visitString(!this.thirdAppId_.isEmpty(), this.thirdAppId_, !lSAutoLoginReq.thirdAppId_.isEmpty(), lSAutoLoginReq.thirdAppId_);
                    this.scope_ = visitor.visitString(!this.scope_.isEmpty(), this.scope_, !lSAutoLoginReq.scope_.isEmpty(), lSAutoLoginReq.scope_);
                    this.maskMobile_ = visitor.visitString(!this.maskMobile_.isEmpty(), this.maskMobile_, !lSAutoLoginReq.maskMobile_.isEmpty(), lSAutoLoginReq.maskMobile_);
                    this.deviceId_ = visitor.visitString(!this.deviceId_.isEmpty(), this.deviceId_, !lSAutoLoginReq.deviceId_.isEmpty(), lSAutoLoginReq.deviceId_);
                    this.simId_ = visitor.visitString(!this.simId_.isEmpty(), this.simId_, !lSAutoLoginReq.simId_.isEmpty(), lSAutoLoginReq.simId_);
                    this.ext_ = visitor.visitString(!this.ext_.isEmpty(), this.ext_, !lSAutoLoginReq.ext_.isEmpty(), lSAutoLoginReq.ext_);
                    this.countryCode_ = visitor.visitString(!this.countryCode_.isEmpty(), this.countryCode_, !lSAutoLoginReq.countryCode_.isEmpty(), lSAutoLoginReq.countryCode_);
                    this.token_ = visitor.visitString(!this.token_.isEmpty(), this.token_, !lSAutoLoginReq.token_.isEmpty(), lSAutoLoginReq.token_);
                    this.operator_ = visitor.visitString(!this.operator_.isEmpty(), this.operator_, true ^ lSAutoLoginReq.operator_.isEmpty(), lSAutoLoginReq.operator_);
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
                                    this.accessToken_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 18:
                                    this.uniqueId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 26:
                                    this.apptype_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 34:
                                    this.clientId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 42:
                                    this.moveType_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 50:
                                    this.thirdAppId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 58:
                                    this.scope_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 66:
                                    this.maskMobile_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 74:
                                    this.deviceId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 82:
                                    this.simId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 90:
                                    this.ext_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 98:
                                    this.countryCode_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 106:
                                    this.token_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 114:
                                    this.operator_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (LSAutoLoginReq.class) {
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

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getAccessToken() {
            return this.accessToken_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getAccessTokenBytes() {
            return ByteString.copyFromUtf8(this.accessToken_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getApptype() {
            return this.apptype_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getApptypeBytes() {
            return ByteString.copyFromUtf8(this.apptype_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getClientId() {
            return this.clientId_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getClientIdBytes() {
            return ByteString.copyFromUtf8(this.clientId_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getCountryCode() {
            return this.countryCode_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getCountryCodeBytes() {
            return ByteString.copyFromUtf8(this.countryCode_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getDeviceId() {
            return this.deviceId_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getDeviceIdBytes() {
            return ByteString.copyFromUtf8(this.deviceId_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getExt() {
            return this.ext_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getExtBytes() {
            return ByteString.copyFromUtf8(this.ext_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getMaskMobile() {
            return this.maskMobile_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getMaskMobileBytes() {
            return ByteString.copyFromUtf8(this.maskMobile_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getMoveType() {
            return this.moveType_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getMoveTypeBytes() {
            return ByteString.copyFromUtf8(this.moveType_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getOperator() {
            return this.operator_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getOperatorBytes() {
            return ByteString.copyFromUtf8(this.operator_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getScope() {
            return this.scope_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getScopeBytes() {
            return ByteString.copyFromUtf8(this.scope_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.accessToken_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getAccessToken());
            if (!this.uniqueId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getUniqueId());
            }
            if (!this.apptype_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getApptype());
            }
            if (!this.clientId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, getClientId());
            }
            if (!this.moveType_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, getMoveType());
            }
            if (!this.thirdAppId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(6, getThirdAppId());
            }
            if (!this.scope_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(7, getScope());
            }
            if (!this.maskMobile_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(8, getMaskMobile());
            }
            if (!this.deviceId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(9, getDeviceId());
            }
            if (!this.simId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(10, getSimId());
            }
            if (!this.ext_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(11, getExt());
            }
            if (!this.countryCode_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(12, getCountryCode());
            }
            if (!this.token_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(13, getToken());
            }
            if (!this.operator_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(14, getOperator());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getSimId() {
            return this.simId_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getSimIdBytes() {
            return ByteString.copyFromUtf8(this.simId_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getThirdAppId() {
            return this.thirdAppId_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getThirdAppIdBytes() {
            return ByteString.copyFromUtf8(this.thirdAppId_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getToken() {
            return this.token_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public String getUniqueId() {
            return this.uniqueId_;
        }

        @Override // com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass.LSAutoLoginReqOrBuilder
        public ByteString getUniqueIdBytes() {
            return ByteString.copyFromUtf8(this.uniqueId_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.accessToken_.isEmpty()) {
                codedOutputStream.writeString(1, getAccessToken());
            }
            if (!this.uniqueId_.isEmpty()) {
                codedOutputStream.writeString(2, getUniqueId());
            }
            if (!this.apptype_.isEmpty()) {
                codedOutputStream.writeString(3, getApptype());
            }
            if (!this.clientId_.isEmpty()) {
                codedOutputStream.writeString(4, getClientId());
            }
            if (!this.moveType_.isEmpty()) {
                codedOutputStream.writeString(5, getMoveType());
            }
            if (!this.thirdAppId_.isEmpty()) {
                codedOutputStream.writeString(6, getThirdAppId());
            }
            if (!this.scope_.isEmpty()) {
                codedOutputStream.writeString(7, getScope());
            }
            if (!this.maskMobile_.isEmpty()) {
                codedOutputStream.writeString(8, getMaskMobile());
            }
            if (!this.deviceId_.isEmpty()) {
                codedOutputStream.writeString(9, getDeviceId());
            }
            if (!this.simId_.isEmpty()) {
                codedOutputStream.writeString(10, getSimId());
            }
            if (!this.ext_.isEmpty()) {
                codedOutputStream.writeString(11, getExt());
            }
            if (!this.countryCode_.isEmpty()) {
                codedOutputStream.writeString(12, getCountryCode());
            }
            if (!this.token_.isEmpty()) {
                codedOutputStream.writeString(13, getToken());
            }
            if (this.operator_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(14, getOperator());
        }

        public static Builder newBuilder(LSAutoLoginReq lSAutoLoginReq) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(lSAutoLoginReq);
        }

        public static LSAutoLoginReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LSAutoLoginReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LSAutoLoginReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LSAutoLoginReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LSAutoLoginReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LSAutoLoginReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LSAutoLoginReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LSAutoLoginReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LSAutoLoginReq parseFrom(InputStream inputStream) throws IOException {
            return (LSAutoLoginReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LSAutoLoginReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LSAutoLoginReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LSAutoLoginReq parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LSAutoLoginReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LSAutoLoginReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LSAutoLoginReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface LSAutoLoginReqOrBuilder extends MessageLiteOrBuilder {
        String getAccessToken();

        ByteString getAccessTokenBytes();

        String getApptype();

        ByteString getApptypeBytes();

        String getClientId();

        ByteString getClientIdBytes();

        String getCountryCode();

        ByteString getCountryCodeBytes();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        String getExt();

        ByteString getExtBytes();

        String getMaskMobile();

        ByteString getMaskMobileBytes();

        String getMoveType();

        ByteString getMoveTypeBytes();

        String getOperator();

        ByteString getOperatorBytes();

        String getScope();

        ByteString getScopeBytes();

        String getSimId();

        ByteString getSimIdBytes();

        String getThirdAppId();

        ByteString getThirdAppIdBytes();

        String getToken();

        ByteString getTokenBytes();

        String getUniqueId();

        ByteString getUniqueIdBytes();
    }

    private LSAutoLoginReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
