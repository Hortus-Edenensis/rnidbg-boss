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
public final class SecurityParameterOuterClass {

    /* JADX INFO: renamed from: com.lantern.auth.pb.pb_client.SecurityParameterOuterClass$1, reason: invalid class name */
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
    public static final class SecurityParameter extends GeneratedMessageLite<SecurityParameter, Builder> implements SecurityParameterOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        public static final int CHANID_FIELD_NUMBER = 6;
        private static final SecurityParameter DEFAULT_INSTANCE;
        public static final int DHID_FIELD_NUMBER = 2;
        public static final int ET_FIELD_NUMBER = 4;
        public static final int IMEI_FIELD_NUMBER = 8;
        public static final int KT_FIELD_NUMBER = 9;
        public static final int LANG_FIELD_NUMBER = 7;
        private static volatile Parser<SecurityParameter> PARSER = null;
        public static final int ST_FIELD_NUMBER = 3;
        public static final int VERCODE_FIELD_NUMBER = 5;
        private int kt_;
        private String appId_ = "";
        private String dhid_ = "";
        private String st_ = "";
        private String et_ = "";
        private String verCode_ = "";
        private String chanId_ = "";
        private String lang_ = "";
        private String imei_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<SecurityParameter, Builder> implements SecurityParameterOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppId() {
                copyOnWrite();
                ((SecurityParameter) this.instance).clearAppId();
                return this;
            }

            public Builder clearChanId() {
                copyOnWrite();
                ((SecurityParameter) this.instance).clearChanId();
                return this;
            }

            public Builder clearDhid() {
                copyOnWrite();
                ((SecurityParameter) this.instance).clearDhid();
                return this;
            }

            public Builder clearEt() {
                copyOnWrite();
                ((SecurityParameter) this.instance).clearEt();
                return this;
            }

            public Builder clearImei() {
                copyOnWrite();
                ((SecurityParameter) this.instance).clearImei();
                return this;
            }

            public Builder clearKt() {
                copyOnWrite();
                ((SecurityParameter) this.instance).clearKt();
                return this;
            }

            public Builder clearLang() {
                copyOnWrite();
                ((SecurityParameter) this.instance).clearLang();
                return this;
            }

            public Builder clearSt() {
                copyOnWrite();
                ((SecurityParameter) this.instance).clearSt();
                return this;
            }

            public Builder clearVerCode() {
                copyOnWrite();
                ((SecurityParameter) this.instance).clearVerCode();
                return this;
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public String getAppId() {
                return ((SecurityParameter) this.instance).getAppId();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public ByteString getAppIdBytes() {
                return ((SecurityParameter) this.instance).getAppIdBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public String getChanId() {
                return ((SecurityParameter) this.instance).getChanId();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public ByteString getChanIdBytes() {
                return ((SecurityParameter) this.instance).getChanIdBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public String getDhid() {
                return ((SecurityParameter) this.instance).getDhid();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public ByteString getDhidBytes() {
                return ((SecurityParameter) this.instance).getDhidBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public String getEt() {
                return ((SecurityParameter) this.instance).getEt();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public ByteString getEtBytes() {
                return ((SecurityParameter) this.instance).getEtBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public String getImei() {
                return ((SecurityParameter) this.instance).getImei();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public ByteString getImeiBytes() {
                return ((SecurityParameter) this.instance).getImeiBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public int getKt() {
                return ((SecurityParameter) this.instance).getKt();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public String getLang() {
                return ((SecurityParameter) this.instance).getLang();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public ByteString getLangBytes() {
                return ((SecurityParameter) this.instance).getLangBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public String getSt() {
                return ((SecurityParameter) this.instance).getSt();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public ByteString getStBytes() {
                return ((SecurityParameter) this.instance).getStBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public String getVerCode() {
                return ((SecurityParameter) this.instance).getVerCode();
            }

            @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
            public ByteString getVerCodeBytes() {
                return ((SecurityParameter) this.instance).getVerCodeBytes();
            }

            public Builder setAppId(String str) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setAppId(str);
                return this;
            }

            public Builder setAppIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setAppIdBytes(byteString);
                return this;
            }

            public Builder setChanId(String str) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setChanId(str);
                return this;
            }

            public Builder setChanIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setChanIdBytes(byteString);
                return this;
            }

            public Builder setDhid(String str) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setDhid(str);
                return this;
            }

            public Builder setDhidBytes(ByteString byteString) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setDhidBytes(byteString);
                return this;
            }

            public Builder setEt(String str) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setEt(str);
                return this;
            }

            public Builder setEtBytes(ByteString byteString) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setEtBytes(byteString);
                return this;
            }

            public Builder setImei(String str) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setImei(str);
                return this;
            }

            public Builder setImeiBytes(ByteString byteString) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setImeiBytes(byteString);
                return this;
            }

            public Builder setKt(int i) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setKt(i);
                return this;
            }

            public Builder setLang(String str) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setLang(str);
                return this;
            }

            public Builder setLangBytes(ByteString byteString) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setLangBytes(byteString);
                return this;
            }

            public Builder setSt(String str) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setSt(str);
                return this;
            }

            public Builder setStBytes(ByteString byteString) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setStBytes(byteString);
                return this;
            }

            public Builder setVerCode(String str) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setVerCode(str);
                return this;
            }

            public Builder setVerCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((SecurityParameter) this.instance).setVerCodeBytes(byteString);
                return this;
            }

            private Builder() {
                super(SecurityParameter.DEFAULT_INSTANCE);
            }
        }

        static {
            SecurityParameter securityParameter = new SecurityParameter();
            DEFAULT_INSTANCE = securityParameter;
            securityParameter.makeImmutable();
        }

        private SecurityParameter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppId() {
            this.appId_ = getDefaultInstance().getAppId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChanId() {
            this.chanId_ = getDefaultInstance().getChanId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDhid() {
            this.dhid_ = getDefaultInstance().getDhid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEt() {
            this.et_ = getDefaultInstance().getEt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImei() {
            this.imei_ = getDefaultInstance().getImei();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKt() {
            this.kt_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLang() {
            this.lang_ = getDefaultInstance().getLang();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSt() {
            this.st_ = getDefaultInstance().getSt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVerCode() {
            this.verCode_ = getDefaultInstance().getVerCode();
        }

        public static SecurityParameter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SecurityParameter parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SecurityParameter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SecurityParameter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SecurityParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<SecurityParameter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppId(String str) {
            str.getClass();
            this.appId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.appId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChanId(String str) {
            str.getClass();
            this.chanId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChanIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.chanId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDhid(String str) {
            str.getClass();
            this.dhid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDhidBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.dhid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEt(String str) {
            str.getClass();
            this.et_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEtBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.et_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImei(String str) {
            str.getClass();
            this.imei_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImeiBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.imei_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKt(int i) {
            this.kt_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLang(String str) {
            str.getClass();
            this.lang_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLangBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.lang_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSt(String str) {
            str.getClass();
            this.st_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.st_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVerCode(String str) {
            str.getClass();
            this.verCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVerCodeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.verCode_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SecurityParameter();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    SecurityParameter securityParameter = (SecurityParameter) obj2;
                    this.appId_ = visitor.visitString(!this.appId_.isEmpty(), this.appId_, !securityParameter.appId_.isEmpty(), securityParameter.appId_);
                    this.dhid_ = visitor.visitString(!this.dhid_.isEmpty(), this.dhid_, !securityParameter.dhid_.isEmpty(), securityParameter.dhid_);
                    this.st_ = visitor.visitString(!this.st_.isEmpty(), this.st_, !securityParameter.st_.isEmpty(), securityParameter.st_);
                    this.et_ = visitor.visitString(!this.et_.isEmpty(), this.et_, !securityParameter.et_.isEmpty(), securityParameter.et_);
                    this.verCode_ = visitor.visitString(!this.verCode_.isEmpty(), this.verCode_, !securityParameter.verCode_.isEmpty(), securityParameter.verCode_);
                    this.chanId_ = visitor.visitString(!this.chanId_.isEmpty(), this.chanId_, !securityParameter.chanId_.isEmpty(), securityParameter.chanId_);
                    this.lang_ = visitor.visitString(!this.lang_.isEmpty(), this.lang_, !securityParameter.lang_.isEmpty(), securityParameter.lang_);
                    this.imei_ = visitor.visitString(!this.imei_.isEmpty(), this.imei_, !securityParameter.imei_.isEmpty(), securityParameter.imei_);
                    int i = this.kt_;
                    boolean z = i != 0;
                    int i2 = securityParameter.kt_;
                    this.kt_ = visitor.visitInt(z, i, i2 != 0, i2);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.appId_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    this.dhid_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    this.st_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 34) {
                                    this.et_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 42) {
                                    this.verCode_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 50) {
                                    this.chanId_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 58) {
                                    this.lang_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 66) {
                                    this.imei_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 72) {
                                    this.kt_ = codedInputStream.readInt32();
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
                        synchronized (SecurityParameter.class) {
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

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public String getAppId() {
            return this.appId_;
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public ByteString getAppIdBytes() {
            return ByteString.copyFromUtf8(this.appId_);
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public String getChanId() {
            return this.chanId_;
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public ByteString getChanIdBytes() {
            return ByteString.copyFromUtf8(this.chanId_);
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public String getDhid() {
            return this.dhid_;
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public ByteString getDhidBytes() {
            return ByteString.copyFromUtf8(this.dhid_);
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public String getEt() {
            return this.et_;
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public ByteString getEtBytes() {
            return ByteString.copyFromUtf8(this.et_);
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public String getImei() {
            return this.imei_;
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public ByteString getImeiBytes() {
            return ByteString.copyFromUtf8(this.imei_);
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public int getKt() {
            return this.kt_;
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public String getLang() {
            return this.lang_;
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public ByteString getLangBytes() {
            return ByteString.copyFromUtf8(this.lang_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.appId_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getAppId());
            if (!this.dhid_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getDhid());
            }
            if (!this.st_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getSt());
            }
            if (!this.et_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, getEt());
            }
            if (!this.verCode_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, getVerCode());
            }
            if (!this.chanId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(6, getChanId());
            }
            if (!this.lang_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(7, getLang());
            }
            if (!this.imei_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(8, getImei());
            }
            int i2 = this.kt_;
            if (i2 != 0) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(9, i2);
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public String getSt() {
            return this.st_;
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public ByteString getStBytes() {
            return ByteString.copyFromUtf8(this.st_);
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public String getVerCode() {
            return this.verCode_;
        }

        @Override // com.lantern.auth.pb.pb_client.SecurityParameterOuterClass.SecurityParameterOrBuilder
        public ByteString getVerCodeBytes() {
            return ByteString.copyFromUtf8(this.verCode_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.appId_.isEmpty()) {
                codedOutputStream.writeString(1, getAppId());
            }
            if (!this.dhid_.isEmpty()) {
                codedOutputStream.writeString(2, getDhid());
            }
            if (!this.st_.isEmpty()) {
                codedOutputStream.writeString(3, getSt());
            }
            if (!this.et_.isEmpty()) {
                codedOutputStream.writeString(4, getEt());
            }
            if (!this.verCode_.isEmpty()) {
                codedOutputStream.writeString(5, getVerCode());
            }
            if (!this.chanId_.isEmpty()) {
                codedOutputStream.writeString(6, getChanId());
            }
            if (!this.lang_.isEmpty()) {
                codedOutputStream.writeString(7, getLang());
            }
            if (!this.imei_.isEmpty()) {
                codedOutputStream.writeString(8, getImei());
            }
            int i = this.kt_;
            if (i != 0) {
                codedOutputStream.writeInt32(9, i);
            }
        }

        public static Builder newBuilder(SecurityParameter securityParameter) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(securityParameter);
        }

        public static SecurityParameter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SecurityParameter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SecurityParameter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SecurityParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SecurityParameter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SecurityParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SecurityParameter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SecurityParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SecurityParameter parseFrom(InputStream inputStream) throws IOException {
            return (SecurityParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SecurityParameter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SecurityParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SecurityParameter parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SecurityParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SecurityParameter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SecurityParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SecurityParameterOrBuilder extends MessageLiteOrBuilder {
        String getAppId();

        ByteString getAppIdBytes();

        String getChanId();

        ByteString getChanIdBytes();

        String getDhid();

        ByteString getDhidBytes();

        String getEt();

        ByteString getEtBytes();

        String getImei();

        ByteString getImeiBytes();

        int getKt();

        String getLang();

        ByteString getLangBytes();

        String getSt();

        ByteString getStBytes();

        String getVerCode();

        ByteString getVerCodeBytes();
    }

    private SecurityParameterOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
