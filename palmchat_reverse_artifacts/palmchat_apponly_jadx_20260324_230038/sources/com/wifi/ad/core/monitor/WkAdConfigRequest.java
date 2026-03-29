package com.wifi.ad.core.monitor;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.ss.bytertc.engine.type.ErrorCode;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class WkAdConfigRequest {

    /* JADX INFO: renamed from: com.wifi.ad.core.monitor.WkAdConfigRequest$1, reason: invalid class name */
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
    public static final class SdkRequest extends GeneratedMessageLite<SdkRequest, Builder> implements SdkRequestOrBuilder {
        public static final int AD_UNIT_ID_FIELD_NUMBER = 12;
        public static final int APIVERSION_FIELD_NUMBER = 1;
        public static final int APP_FIELD_NUMBER = 4;
        private static final SdkRequest DEFAULT_INSTANCE;
        public static final int DEVICE_FIELD_NUMBER = 3;
        public static final int DEVICE_ID_FIELD_NUMBER = 14;
        public static final int DID_FIELD_NUMBER = 5;
        private static volatile Parser<SdkRequest> PARSER = null;
        public static final int PV_FIELD_NUMBER = 9;
        public static final int REGTIME_FIELD_NUMBER = 8;
        public static final int REQUESTID_FIELD_NUMBER = 2;
        public static final int SCENE_FIELD_NUMBER = 6;
        public static final int TAICHI_FIELD_NUMBER = 7;
        public static final int UID_FIELD_NUMBER = 13;
        public static final int VALUETYPE_FIELD_NUMBER = 10;
        private int apiversion_;
        private App app_;
        private int bitField0_;
        private Device device_;
        private int pv_;
        private int scene_;
        private int valuetype_;
        private String requestid_ = "";
        private String did_ = "";
        private String taichi_ = "";
        private String regtime_ = "";
        private String adUnitId_ = "";
        private String uid_ = "";
        private String deviceId_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class App extends GeneratedMessageLite<App, Builder> implements AppOrBuilder {
            public static final int APPID_FIELD_NUMBER = 4;
            private static final App DEFAULT_INSTANCE;
            public static final int MARKET_FIELD_NUMBER = 3;
            private static volatile Parser<App> PARSER = null;
            public static final int PKGNAME_FIELD_NUMBER = 1;
            public static final int SDK_VER_FIELD_NUMBER = 5;
            public static final int VERSION_FIELD_NUMBER = 2;
            public static final int VERSION_NAME_FIELD_NUMBER = 6;
            private int bitField0_;
            private String pkgname_ = "";
            private String version_ = "";
            private String market_ = "";
            private String appid_ = "";
            private String sdkVer_ = "";
            private String versionName_ = "";

            /* JADX INFO: compiled from: SearchBox */
            public static final class Builder extends GeneratedMessageLite.Builder<App, Builder> implements AppOrBuilder {
                public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearAppid() {
                    copyOnWrite();
                    ((App) this.instance).clearAppid();
                    return this;
                }

                public Builder clearMarket() {
                    copyOnWrite();
                    ((App) this.instance).clearMarket();
                    return this;
                }

                public Builder clearPkgname() {
                    copyOnWrite();
                    ((App) this.instance).clearPkgname();
                    return this;
                }

                public Builder clearSdkVer() {
                    copyOnWrite();
                    ((App) this.instance).clearSdkVer();
                    return this;
                }

                public Builder clearVersion() {
                    copyOnWrite();
                    ((App) this.instance).clearVersion();
                    return this;
                }

                public Builder clearVersionName() {
                    copyOnWrite();
                    ((App) this.instance).clearVersionName();
                    return this;
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public String getAppid() {
                    return ((App) this.instance).getAppid();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public ByteString getAppidBytes() {
                    return ((App) this.instance).getAppidBytes();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public String getMarket() {
                    return ((App) this.instance).getMarket();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public ByteString getMarketBytes() {
                    return ((App) this.instance).getMarketBytes();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public String getPkgname() {
                    return ((App) this.instance).getPkgname();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public ByteString getPkgnameBytes() {
                    return ((App) this.instance).getPkgnameBytes();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public String getSdkVer() {
                    return ((App) this.instance).getSdkVer();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public ByteString getSdkVerBytes() {
                    return ((App) this.instance).getSdkVerBytes();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public String getVersion() {
                    return ((App) this.instance).getVersion();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public ByteString getVersionBytes() {
                    return ((App) this.instance).getVersionBytes();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public String getVersionName() {
                    return ((App) this.instance).getVersionName();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public ByteString getVersionNameBytes() {
                    return ((App) this.instance).getVersionNameBytes();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public boolean hasAppid() {
                    return ((App) this.instance).hasAppid();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public boolean hasMarket() {
                    return ((App) this.instance).hasMarket();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public boolean hasPkgname() {
                    return ((App) this.instance).hasPkgname();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public boolean hasSdkVer() {
                    return ((App) this.instance).hasSdkVer();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public boolean hasVersion() {
                    return ((App) this.instance).hasVersion();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
                public boolean hasVersionName() {
                    return ((App) this.instance).hasVersionName();
                }

                public Builder setAppid(String str) {
                    copyOnWrite();
                    ((App) this.instance).setAppid(str);
                    return this;
                }

                public Builder setAppidBytes(ByteString byteString) {
                    copyOnWrite();
                    ((App) this.instance).setAppidBytes(byteString);
                    return this;
                }

                public Builder setMarket(String str) {
                    copyOnWrite();
                    ((App) this.instance).setMarket(str);
                    return this;
                }

                public Builder setMarketBytes(ByteString byteString) {
                    copyOnWrite();
                    ((App) this.instance).setMarketBytes(byteString);
                    return this;
                }

                public Builder setPkgname(String str) {
                    copyOnWrite();
                    ((App) this.instance).setPkgname(str);
                    return this;
                }

                public Builder setPkgnameBytes(ByteString byteString) {
                    copyOnWrite();
                    ((App) this.instance).setPkgnameBytes(byteString);
                    return this;
                }

                public Builder setSdkVer(String str) {
                    copyOnWrite();
                    ((App) this.instance).setSdkVer(str);
                    return this;
                }

                public Builder setSdkVerBytes(ByteString byteString) {
                    copyOnWrite();
                    ((App) this.instance).setSdkVerBytes(byteString);
                    return this;
                }

                public Builder setVersion(String str) {
                    copyOnWrite();
                    ((App) this.instance).setVersion(str);
                    return this;
                }

                public Builder setVersionBytes(ByteString byteString) {
                    copyOnWrite();
                    ((App) this.instance).setVersionBytes(byteString);
                    return this;
                }

                public Builder setVersionName(String str) {
                    copyOnWrite();
                    ((App) this.instance).setVersionName(str);
                    return this;
                }

                public Builder setVersionNameBytes(ByteString byteString) {
                    copyOnWrite();
                    ((App) this.instance).setVersionNameBytes(byteString);
                    return this;
                }

                private Builder() {
                    super(App.DEFAULT_INSTANCE);
                }
            }

            static {
                App app = new App();
                DEFAULT_INSTANCE = app;
                app.makeImmutable();
            }

            private App() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAppid() {
                this.bitField0_ &= -9;
                this.appid_ = getDefaultInstance().getAppid();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMarket() {
                this.bitField0_ &= -5;
                this.market_ = getDefaultInstance().getMarket();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPkgname() {
                this.bitField0_ &= -2;
                this.pkgname_ = getDefaultInstance().getPkgname();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSdkVer() {
                this.bitField0_ &= -17;
                this.sdkVer_ = getDefaultInstance().getSdkVer();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVersion() {
                this.bitField0_ &= -3;
                this.version_ = getDefaultInstance().getVersion();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVersionName() {
                this.bitField0_ &= -33;
                this.versionName_ = getDefaultInstance().getVersionName();
            }

            public static App getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static App parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (App) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static App parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<App> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAppid(String str) {
                str.getClass();
                this.bitField0_ |= 8;
                this.appid_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAppidBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 8;
                this.appid_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMarket(String str) {
                str.getClass();
                this.bitField0_ |= 4;
                this.market_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMarketBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 4;
                this.market_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPkgname(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.pkgname_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPkgnameBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 1;
                this.pkgname_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSdkVer(String str) {
                str.getClass();
                this.bitField0_ |= 16;
                this.sdkVer_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSdkVerBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 16;
                this.sdkVer_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersion(String str) {
                str.getClass();
                this.bitField0_ |= 2;
                this.version_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersionBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 2;
                this.version_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersionName(String str) {
                str.getClass();
                this.bitField0_ |= 32;
                this.versionName_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersionNameBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 32;
                this.versionName_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new App();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        App app = (App) obj2;
                        this.pkgname_ = visitor.visitString(hasPkgname(), this.pkgname_, app.hasPkgname(), app.pkgname_);
                        this.version_ = visitor.visitString(hasVersion(), this.version_, app.hasVersion(), app.version_);
                        this.market_ = visitor.visitString(hasMarket(), this.market_, app.hasMarket(), app.market_);
                        this.appid_ = visitor.visitString(hasAppid(), this.appid_, app.hasAppid(), app.appid_);
                        this.sdkVer_ = visitor.visitString(hasSdkVer(), this.sdkVer_, app.hasSdkVer(), app.sdkVer_);
                        this.versionName_ = visitor.visitString(hasVersionName(), this.versionName_, app.hasVersionName(), app.versionName_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= app.bitField0_;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int tag = codedInputStream.readTag();
                                if (tag != 0) {
                                    if (tag == 10) {
                                        String string = codedInputStream.readString();
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.pkgname_ = string;
                                    } else if (tag == 18) {
                                        String string2 = codedInputStream.readString();
                                        this.bitField0_ |= 2;
                                        this.version_ = string2;
                                    } else if (tag == 26) {
                                        String string3 = codedInputStream.readString();
                                        this.bitField0_ |= 4;
                                        this.market_ = string3;
                                    } else if (tag == 34) {
                                        String string4 = codedInputStream.readString();
                                        this.bitField0_ |= 8;
                                        this.appid_ = string4;
                                    } else if (tag == 42) {
                                        String string5 = codedInputStream.readString();
                                        this.bitField0_ |= 16;
                                        this.sdkVer_ = string5;
                                    } else if (tag == 50) {
                                        String string6 = codedInputStream.readString();
                                        this.bitField0_ |= 32;
                                        this.versionName_ = string6;
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
                            synchronized (App.class) {
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

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public String getAppid() {
                return this.appid_;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public ByteString getAppidBytes() {
                return ByteString.copyFromUtf8(this.appid_);
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public String getMarket() {
                return this.market_;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public ByteString getMarketBytes() {
                return ByteString.copyFromUtf8(this.market_);
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public String getPkgname() {
                return this.pkgname_;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public ByteString getPkgnameBytes() {
                return ByteString.copyFromUtf8(this.pkgname_);
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public String getSdkVer() {
                return this.sdkVer_;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public ByteString getSdkVerBytes() {
                return ByteString.copyFromUtf8(this.sdkVer_);
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getPkgname()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(2, getVersion());
                }
                if ((this.bitField0_ & 4) == 4) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(3, getMarket());
                }
                if ((this.bitField0_ & 8) == 8) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(4, getAppid());
                }
                if ((this.bitField0_ & 16) == 16) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(5, getSdkVer());
                }
                if ((this.bitField0_ & 32) == 32) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(6, getVersionName());
                }
                int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public String getVersion() {
                return this.version_;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public ByteString getVersionBytes() {
                return ByteString.copyFromUtf8(this.version_);
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public String getVersionName() {
                return this.versionName_;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public ByteString getVersionNameBytes() {
                return ByteString.copyFromUtf8(this.versionName_);
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public boolean hasAppid() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public boolean hasMarket() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public boolean hasPkgname() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public boolean hasSdkVer() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public boolean hasVersion() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.AppOrBuilder
            public boolean hasVersionName() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeString(1, getPkgname());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeString(2, getVersion());
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeString(3, getMarket());
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.writeString(4, getAppid());
                }
                if ((this.bitField0_ & 16) == 16) {
                    codedOutputStream.writeString(5, getSdkVer());
                }
                if ((this.bitField0_ & 32) == 32) {
                    codedOutputStream.writeString(6, getVersionName());
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            public static Builder newBuilder(App app) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(app);
            }

            public static App parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (App) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static App parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static App parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static App parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static App parseFrom(InputStream inputStream) throws IOException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static App parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static App parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static App parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public interface AppOrBuilder extends MessageLiteOrBuilder {
            String getAppid();

            ByteString getAppidBytes();

            String getMarket();

            ByteString getMarketBytes();

            String getPkgname();

            ByteString getPkgnameBytes();

            String getSdkVer();

            ByteString getSdkVerBytes();

            String getVersion();

            ByteString getVersionBytes();

            String getVersionName();

            ByteString getVersionNameBytes();

            boolean hasAppid();

            boolean hasMarket();

            boolean hasPkgname();

            boolean hasSdkVer();

            boolean hasVersion();

            boolean hasVersionName();
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<SdkRequest, Builder> implements SdkRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAdUnitId() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearAdUnitId();
                return this;
            }

            public Builder clearApiversion() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearApiversion();
                return this;
            }

            public Builder clearApp() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearApp();
                return this;
            }

            public Builder clearDevice() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearDevice();
                return this;
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearDeviceId();
                return this;
            }

            public Builder clearDid() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearDid();
                return this;
            }

            public Builder clearPv() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearPv();
                return this;
            }

            public Builder clearRegtime() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearRegtime();
                return this;
            }

            public Builder clearRequestid() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearRequestid();
                return this;
            }

            public Builder clearScene() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearScene();
                return this;
            }

            public Builder clearTaichi() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearTaichi();
                return this;
            }

            public Builder clearUid() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearUid();
                return this;
            }

            public Builder clearValuetype() {
                copyOnWrite();
                ((SdkRequest) this.instance).clearValuetype();
                return this;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public String getAdUnitId() {
                return ((SdkRequest) this.instance).getAdUnitId();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public ByteString getAdUnitIdBytes() {
                return ((SdkRequest) this.instance).getAdUnitIdBytes();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public int getApiversion() {
                return ((SdkRequest) this.instance).getApiversion();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public App getApp() {
                return ((SdkRequest) this.instance).getApp();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public Device getDevice() {
                return ((SdkRequest) this.instance).getDevice();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public String getDeviceId() {
                return ((SdkRequest) this.instance).getDeviceId();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public ByteString getDeviceIdBytes() {
                return ((SdkRequest) this.instance).getDeviceIdBytes();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public String getDid() {
                return ((SdkRequest) this.instance).getDid();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public ByteString getDidBytes() {
                return ((SdkRequest) this.instance).getDidBytes();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public int getPv() {
                return ((SdkRequest) this.instance).getPv();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public String getRegtime() {
                return ((SdkRequest) this.instance).getRegtime();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public ByteString getRegtimeBytes() {
                return ((SdkRequest) this.instance).getRegtimeBytes();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public String getRequestid() {
                return ((SdkRequest) this.instance).getRequestid();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public ByteString getRequestidBytes() {
                return ((SdkRequest) this.instance).getRequestidBytes();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public int getScene() {
                return ((SdkRequest) this.instance).getScene();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public String getTaichi() {
                return ((SdkRequest) this.instance).getTaichi();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public ByteString getTaichiBytes() {
                return ((SdkRequest) this.instance).getTaichiBytes();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public String getUid() {
                return ((SdkRequest) this.instance).getUid();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public ByteString getUidBytes() {
                return ((SdkRequest) this.instance).getUidBytes();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public int getValuetype() {
                return ((SdkRequest) this.instance).getValuetype();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasAdUnitId() {
                return ((SdkRequest) this.instance).hasAdUnitId();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasApiversion() {
                return ((SdkRequest) this.instance).hasApiversion();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasApp() {
                return ((SdkRequest) this.instance).hasApp();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasDevice() {
                return ((SdkRequest) this.instance).hasDevice();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasDeviceId() {
                return ((SdkRequest) this.instance).hasDeviceId();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasDid() {
                return ((SdkRequest) this.instance).hasDid();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasPv() {
                return ((SdkRequest) this.instance).hasPv();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasRegtime() {
                return ((SdkRequest) this.instance).hasRegtime();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasRequestid() {
                return ((SdkRequest) this.instance).hasRequestid();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasScene() {
                return ((SdkRequest) this.instance).hasScene();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasTaichi() {
                return ((SdkRequest) this.instance).hasTaichi();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasUid() {
                return ((SdkRequest) this.instance).hasUid();
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
            public boolean hasValuetype() {
                return ((SdkRequest) this.instance).hasValuetype();
            }

            public Builder mergeApp(App app) {
                copyOnWrite();
                ((SdkRequest) this.instance).mergeApp(app);
                return this;
            }

            public Builder mergeDevice(Device device) {
                copyOnWrite();
                ((SdkRequest) this.instance).mergeDevice(device);
                return this;
            }

            public Builder setAdUnitId(String str) {
                copyOnWrite();
                ((SdkRequest) this.instance).setAdUnitId(str);
                return this;
            }

            public Builder setAdUnitIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkRequest) this.instance).setAdUnitIdBytes(byteString);
                return this;
            }

            public Builder setApiversion(int i) {
                copyOnWrite();
                ((SdkRequest) this.instance).setApiversion(i);
                return this;
            }

            public Builder setApp(App app) {
                copyOnWrite();
                ((SdkRequest) this.instance).setApp(app);
                return this;
            }

            public Builder setDevice(Device device) {
                copyOnWrite();
                ((SdkRequest) this.instance).setDevice(device);
                return this;
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((SdkRequest) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkRequest) this.instance).setDeviceIdBytes(byteString);
                return this;
            }

            public Builder setDid(String str) {
                copyOnWrite();
                ((SdkRequest) this.instance).setDid(str);
                return this;
            }

            public Builder setDidBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkRequest) this.instance).setDidBytes(byteString);
                return this;
            }

            public Builder setPv(int i) {
                copyOnWrite();
                ((SdkRequest) this.instance).setPv(i);
                return this;
            }

            public Builder setRegtime(String str) {
                copyOnWrite();
                ((SdkRequest) this.instance).setRegtime(str);
                return this;
            }

            public Builder setRegtimeBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkRequest) this.instance).setRegtimeBytes(byteString);
                return this;
            }

            public Builder setRequestid(String str) {
                copyOnWrite();
                ((SdkRequest) this.instance).setRequestid(str);
                return this;
            }

            public Builder setRequestidBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkRequest) this.instance).setRequestidBytes(byteString);
                return this;
            }

            public Builder setScene(int i) {
                copyOnWrite();
                ((SdkRequest) this.instance).setScene(i);
                return this;
            }

            public Builder setTaichi(String str) {
                copyOnWrite();
                ((SdkRequest) this.instance).setTaichi(str);
                return this;
            }

            public Builder setTaichiBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkRequest) this.instance).setTaichiBytes(byteString);
                return this;
            }

            public Builder setUid(String str) {
                copyOnWrite();
                ((SdkRequest) this.instance).setUid(str);
                return this;
            }

            public Builder setUidBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkRequest) this.instance).setUidBytes(byteString);
                return this;
            }

            public Builder setValuetype(int i) {
                copyOnWrite();
                ((SdkRequest) this.instance).setValuetype(i);
                return this;
            }

            private Builder() {
                super(SdkRequest.DEFAULT_INSTANCE);
            }

            public Builder setApp(App.Builder builder) {
                copyOnWrite();
                ((SdkRequest) this.instance).setApp(builder);
                return this;
            }

            public Builder setDevice(Device.Builder builder) {
                copyOnWrite();
                ((SdkRequest) this.instance).setDevice(builder);
                return this;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class Device extends GeneratedMessageLite<Device, Builder> implements DeviceOrBuilder {
            private static final Device DEFAULT_INSTANCE;
            public static final int IMEI_FIELD_NUMBER = 1;
            public static final int LATITUDE_FIELD_NUMBER = 5;
            public static final int LONGITUDE_FIELD_NUMBER = 4;
            public static final int MAC_FIELD_NUMBER = 2;
            public static final int OAID_FIELD_NUMBER = 3;
            private static volatile Parser<Device> PARSER;
            private int bitField0_;
            private double latitude_;
            private double longitude_;
            private String imei_ = "";
            private String mac_ = "";
            private String oaid_ = "";

            /* JADX INFO: compiled from: SearchBox */
            public static final class Builder extends GeneratedMessageLite.Builder<Device, Builder> implements DeviceOrBuilder {
                public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearImei() {
                    copyOnWrite();
                    ((Device) this.instance).clearImei();
                    return this;
                }

                public Builder clearLatitude() {
                    copyOnWrite();
                    ((Device) this.instance).clearLatitude();
                    return this;
                }

                public Builder clearLongitude() {
                    copyOnWrite();
                    ((Device) this.instance).clearLongitude();
                    return this;
                }

                public Builder clearMac() {
                    copyOnWrite();
                    ((Device) this.instance).clearMac();
                    return this;
                }

                public Builder clearOaid() {
                    copyOnWrite();
                    ((Device) this.instance).clearOaid();
                    return this;
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public String getImei() {
                    return ((Device) this.instance).getImei();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public ByteString getImeiBytes() {
                    return ((Device) this.instance).getImeiBytes();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public double getLatitude() {
                    return ((Device) this.instance).getLatitude();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public double getLongitude() {
                    return ((Device) this.instance).getLongitude();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public String getMac() {
                    return ((Device) this.instance).getMac();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public ByteString getMacBytes() {
                    return ((Device) this.instance).getMacBytes();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public String getOaid() {
                    return ((Device) this.instance).getOaid();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public ByteString getOaidBytes() {
                    return ((Device) this.instance).getOaidBytes();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public boolean hasImei() {
                    return ((Device) this.instance).hasImei();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public boolean hasLatitude() {
                    return ((Device) this.instance).hasLatitude();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public boolean hasLongitude() {
                    return ((Device) this.instance).hasLongitude();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public boolean hasMac() {
                    return ((Device) this.instance).hasMac();
                }

                @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
                public boolean hasOaid() {
                    return ((Device) this.instance).hasOaid();
                }

                public Builder setImei(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setImei(str);
                    return this;
                }

                public Builder setImeiBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setImeiBytes(byteString);
                    return this;
                }

                public Builder setLatitude(double d) {
                    copyOnWrite();
                    ((Device) this.instance).setLatitude(d);
                    return this;
                }

                public Builder setLongitude(double d) {
                    copyOnWrite();
                    ((Device) this.instance).setLongitude(d);
                    return this;
                }

                public Builder setMac(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setMac(str);
                    return this;
                }

                public Builder setMacBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setMacBytes(byteString);
                    return this;
                }

                public Builder setOaid(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setOaid(str);
                    return this;
                }

                public Builder setOaidBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setOaidBytes(byteString);
                    return this;
                }

                private Builder() {
                    super(Device.DEFAULT_INSTANCE);
                }
            }

            static {
                Device device = new Device();
                DEFAULT_INSTANCE = device;
                device.makeImmutable();
            }

            private Device() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearImei() {
                this.bitField0_ &= -2;
                this.imei_ = getDefaultInstance().getImei();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLatitude() {
                this.bitField0_ &= -17;
                this.latitude_ = 0.0d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLongitude() {
                this.bitField0_ &= -9;
                this.longitude_ = 0.0d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMac() {
                this.bitField0_ &= -3;
                this.mac_ = getDefaultInstance().getMac();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOaid() {
                this.bitField0_ &= -5;
                this.oaid_ = getDefaultInstance().getOaid();
            }

            public static Device getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Device parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Device) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Device parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Device> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setImei(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.imei_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setImeiBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 1;
                this.imei_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLatitude(double d) {
                this.bitField0_ |= 16;
                this.latitude_ = d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLongitude(double d) {
                this.bitField0_ |= 8;
                this.longitude_ = d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMac(String str) {
                str.getClass();
                this.bitField0_ |= 2;
                this.mac_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMacBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 2;
                this.mac_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOaid(String str) {
                str.getClass();
                this.bitField0_ |= 4;
                this.oaid_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOaidBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 4;
                this.oaid_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Device();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Device device = (Device) obj2;
                        this.imei_ = visitor.visitString(hasImei(), this.imei_, device.hasImei(), device.imei_);
                        this.mac_ = visitor.visitString(hasMac(), this.mac_, device.hasMac(), device.mac_);
                        this.oaid_ = visitor.visitString(hasOaid(), this.oaid_, device.hasOaid(), device.oaid_);
                        this.longitude_ = visitor.visitDouble(hasLongitude(), this.longitude_, device.hasLongitude(), device.longitude_);
                        this.latitude_ = visitor.visitDouble(hasLatitude(), this.latitude_, device.hasLatitude(), device.latitude_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= device.bitField0_;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int tag = codedInputStream.readTag();
                                if (tag != 0) {
                                    if (tag == 10) {
                                        String string = codedInputStream.readString();
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.imei_ = string;
                                    } else if (tag == 18) {
                                        String string2 = codedInputStream.readString();
                                        this.bitField0_ |= 2;
                                        this.mac_ = string2;
                                    } else if (tag == 26) {
                                        String string3 = codedInputStream.readString();
                                        this.bitField0_ |= 4;
                                        this.oaid_ = string3;
                                    } else if (tag == 33) {
                                        this.bitField0_ |= 8;
                                        this.longitude_ = codedInputStream.readDouble();
                                    } else if (tag == 41) {
                                        this.bitField0_ |= 16;
                                        this.latitude_ = codedInputStream.readDouble();
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
                            synchronized (Device.class) {
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

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public String getImei() {
                return this.imei_;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public ByteString getImeiBytes() {
                return ByteString.copyFromUtf8(this.imei_);
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public double getLatitude() {
                return this.latitude_;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public double getLongitude() {
                return this.longitude_;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public String getMac() {
                return this.mac_;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public ByteString getMacBytes() {
                return ByteString.copyFromUtf8(this.mac_);
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public String getOaid() {
                return this.oaid_;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public ByteString getOaidBytes() {
                return ByteString.copyFromUtf8(this.oaid_);
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getImei()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(2, getMac());
                }
                if ((this.bitField0_ & 4) == 4) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(3, getOaid());
                }
                if ((this.bitField0_ & 8) == 8) {
                    iComputeStringSize += CodedOutputStream.computeDoubleSize(4, this.longitude_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    iComputeStringSize += CodedOutputStream.computeDoubleSize(5, this.latitude_);
                }
                int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public boolean hasImei() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public boolean hasLatitude() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public boolean hasLongitude() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public boolean hasMac() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequest.DeviceOrBuilder
            public boolean hasOaid() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeString(1, getImei());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeString(2, getMac());
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeString(3, getOaid());
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.writeDouble(4, this.longitude_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    codedOutputStream.writeDouble(5, this.latitude_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            public static Builder newBuilder(Device device) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(device);
            }

            public static Device parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Device) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Device parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Device parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Device parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Device parseFrom(InputStream inputStream) throws IOException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Device parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Device parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Device parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public interface DeviceOrBuilder extends MessageLiteOrBuilder {
            String getImei();

            ByteString getImeiBytes();

            double getLatitude();

            double getLongitude();

            String getMac();

            ByteString getMacBytes();

            String getOaid();

            ByteString getOaidBytes();

            boolean hasImei();

            boolean hasLatitude();

            boolean hasLongitude();

            boolean hasMac();

            boolean hasOaid();
        }

        static {
            SdkRequest sdkRequest = new SdkRequest();
            DEFAULT_INSTANCE = sdkRequest;
            sdkRequest.makeImmutable();
        }

        private SdkRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdUnitId() {
            this.bitField0_ &= ErrorCode.ERROR_CODE_JOIN_ROOM_ROOM_FORBIDDEN;
            this.adUnitId_ = getDefaultInstance().getAdUnitId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearApiversion() {
            this.bitField0_ &= -2;
            this.apiversion_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearApp() {
            this.app_ = null;
            this.bitField0_ &= -9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDevice() {
            this.device_ = null;
            this.bitField0_ &= -5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceId() {
            this.bitField0_ &= -4097;
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDid() {
            this.bitField0_ &= -17;
            this.did_ = getDefaultInstance().getDid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPv() {
            this.bitField0_ &= -257;
            this.pv_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRegtime() {
            this.bitField0_ &= -129;
            this.regtime_ = getDefaultInstance().getRegtime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRequestid() {
            this.bitField0_ &= -3;
            this.requestid_ = getDefaultInstance().getRequestid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScene() {
            this.bitField0_ &= -33;
            this.scene_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaichi() {
            this.bitField0_ &= -65;
            this.taichi_ = getDefaultInstance().getTaichi();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUid() {
            this.bitField0_ &= -2049;
            this.uid_ = getDefaultInstance().getUid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValuetype() {
            this.bitField0_ &= -513;
            this.valuetype_ = 0;
        }

        public static SdkRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeApp(App app) {
            App app2 = this.app_;
            if (app2 == null || app2 == App.getDefaultInstance()) {
                this.app_ = app;
            } else {
                this.app_ = App.newBuilder(this.app_).mergeFrom(app).buildPartial();
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDevice(Device device) {
            Device device2 = this.device_;
            if (device2 == null || device2 == Device.getDefaultInstance()) {
                this.device_ = device;
            } else {
                this.device_ = Device.newBuilder(this.device_).mergeFrom(device).buildPartial();
            }
            this.bitField0_ |= 4;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SdkRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SdkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SdkRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SdkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<SdkRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdUnitId(String str) {
            str.getClass();
            this.bitField0_ |= 1024;
            this.adUnitId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdUnitIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1024;
            this.adUnitId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApiversion(int i) {
            this.bitField0_ |= 1;
            this.apiversion_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApp(App app) {
            app.getClass();
            this.app_ = app;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDevice(Device device) {
            device.getClass();
            this.device_ = device;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.bitField0_ |= 4096;
            this.deviceId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4096;
            this.deviceId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDid(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.did_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.did_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPv(int i) {
            this.bitField0_ |= 256;
            this.pv_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRegtime(String str) {
            str.getClass();
            this.bitField0_ |= 128;
            this.regtime_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRegtimeBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 128;
            this.regtime_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequestid(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.requestid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequestidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.requestid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScene(int i) {
            this.bitField0_ |= 32;
            this.scene_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaichi(String str) {
            str.getClass();
            this.bitField0_ |= 64;
            this.taichi_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaichiBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.taichi_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUid(String str) {
            str.getClass();
            this.bitField0_ |= 2048;
            this.uid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2048;
            this.uid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValuetype(int i) {
            this.bitField0_ |= 512;
            this.valuetype_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SdkRequest();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    SdkRequest sdkRequest = (SdkRequest) obj2;
                    this.apiversion_ = visitor.visitInt(hasApiversion(), this.apiversion_, sdkRequest.hasApiversion(), sdkRequest.apiversion_);
                    this.requestid_ = visitor.visitString(hasRequestid(), this.requestid_, sdkRequest.hasRequestid(), sdkRequest.requestid_);
                    this.device_ = (Device) visitor.visitMessage(this.device_, sdkRequest.device_);
                    this.app_ = (App) visitor.visitMessage(this.app_, sdkRequest.app_);
                    this.did_ = visitor.visitString(hasDid(), this.did_, sdkRequest.hasDid(), sdkRequest.did_);
                    this.scene_ = visitor.visitInt(hasScene(), this.scene_, sdkRequest.hasScene(), sdkRequest.scene_);
                    this.taichi_ = visitor.visitString(hasTaichi(), this.taichi_, sdkRequest.hasTaichi(), sdkRequest.taichi_);
                    this.regtime_ = visitor.visitString(hasRegtime(), this.regtime_, sdkRequest.hasRegtime(), sdkRequest.regtime_);
                    this.pv_ = visitor.visitInt(hasPv(), this.pv_, sdkRequest.hasPv(), sdkRequest.pv_);
                    this.valuetype_ = visitor.visitInt(hasValuetype(), this.valuetype_, sdkRequest.hasValuetype(), sdkRequest.valuetype_);
                    this.adUnitId_ = visitor.visitString(hasAdUnitId(), this.adUnitId_, sdkRequest.hasAdUnitId(), sdkRequest.adUnitId_);
                    this.uid_ = visitor.visitString(hasUid(), this.uid_, sdkRequest.hasUid(), sdkRequest.uid_);
                    this.deviceId_ = visitor.visitString(hasDeviceId(), this.deviceId_, sdkRequest.hasDeviceId(), sdkRequest.deviceId_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= sdkRequest.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            switch (tag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.apiversion_ = codedInputStream.readInt32();
                                    break;
                                case 18:
                                    String string = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.requestid_ = string;
                                    break;
                                case 26:
                                    Device.Builder builder = (this.bitField0_ & 4) == 4 ? this.device_.toBuilder() : null;
                                    Device device = (Device) codedInputStream.readMessage(Device.parser(), extensionRegistryLite);
                                    this.device_ = device;
                                    if (builder != null) {
                                        builder.mergeFrom(device);
                                        this.device_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                    break;
                                case 34:
                                    App.Builder builder2 = (this.bitField0_ & 8) == 8 ? this.app_.toBuilder() : null;
                                    App app = (App) codedInputStream.readMessage(App.parser(), extensionRegistryLite);
                                    this.app_ = app;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(app);
                                        this.app_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 8;
                                    break;
                                case 42:
                                    String string2 = codedInputStream.readString();
                                    this.bitField0_ |= 16;
                                    this.did_ = string2;
                                    break;
                                case 48:
                                    this.bitField0_ |= 32;
                                    this.scene_ = codedInputStream.readInt32();
                                    break;
                                case 58:
                                    String string3 = codedInputStream.readString();
                                    this.bitField0_ |= 64;
                                    this.taichi_ = string3;
                                    break;
                                case 66:
                                    String string4 = codedInputStream.readString();
                                    this.bitField0_ |= 128;
                                    this.regtime_ = string4;
                                    break;
                                case 72:
                                    this.bitField0_ |= 256;
                                    this.pv_ = codedInputStream.readInt32();
                                    break;
                                case 80:
                                    this.bitField0_ |= 512;
                                    this.valuetype_ = codedInputStream.readInt32();
                                    break;
                                case 98:
                                    String string5 = codedInputStream.readString();
                                    this.bitField0_ |= 1024;
                                    this.adUnitId_ = string5;
                                    break;
                                case 106:
                                    String string6 = codedInputStream.readString();
                                    this.bitField0_ |= 2048;
                                    this.uid_ = string6;
                                    break;
                                case 114:
                                    String string7 = codedInputStream.readString();
                                    this.bitField0_ |= 4096;
                                    this.deviceId_ = string7;
                                    break;
                                default:
                                    if (!parseUnknownField(tag, codedInputStream)) {
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
                        synchronized (SdkRequest.class) {
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

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public String getAdUnitId() {
            return this.adUnitId_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public ByteString getAdUnitIdBytes() {
            return ByteString.copyFromUtf8(this.adUnitId_);
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public int getApiversion() {
            return this.apiversion_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public App getApp() {
            App app = this.app_;
            return app == null ? App.getDefaultInstance() : app;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public Device getDevice() {
            Device device = this.device_;
            return device == null ? Device.getDefaultInstance() : device;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public String getDeviceId() {
            return this.deviceId_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public ByteString getDeviceIdBytes() {
            return ByteString.copyFromUtf8(this.deviceId_);
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public String getDid() {
            return this.did_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public ByteString getDidBytes() {
            return ByteString.copyFromUtf8(this.did_);
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public int getPv() {
            return this.pv_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public String getRegtime() {
            return this.regtime_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public ByteString getRegtimeBytes() {
            return ByteString.copyFromUtf8(this.regtime_);
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public String getRequestid() {
            return this.requestid_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public ByteString getRequestidBytes() {
            return ByteString.copyFromUtf8(this.requestid_);
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public int getScene() {
            return this.scene_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.apiversion_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(2, getRequestid());
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(3, getDevice());
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(4, getApp());
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(5, getDid());
            }
            if ((this.bitField0_ & 32) == 32) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(6, this.scene_);
            }
            if ((this.bitField0_ & 64) == 64) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(7, getTaichi());
            }
            if ((this.bitField0_ & 128) == 128) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(8, getRegtime());
            }
            if ((this.bitField0_ & 256) == 256) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(9, this.pv_);
            }
            if ((this.bitField0_ & 512) == 512) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(10, this.valuetype_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(12, getAdUnitId());
            }
            if ((this.bitField0_ & 2048) == 2048) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(13, getUid());
            }
            if ((this.bitField0_ & 4096) == 4096) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(14, getDeviceId());
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public String getTaichi() {
            return this.taichi_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public ByteString getTaichiBytes() {
            return ByteString.copyFromUtf8(this.taichi_);
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public String getUid() {
            return this.uid_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public ByteString getUidBytes() {
            return ByteString.copyFromUtf8(this.uid_);
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public int getValuetype() {
            return this.valuetype_;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasAdUnitId() {
            return (this.bitField0_ & 1024) == 1024;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasApiversion() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasApp() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasDevice() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasDeviceId() {
            return (this.bitField0_ & 4096) == 4096;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasDid() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasPv() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasRegtime() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasRequestid() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasScene() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasTaichi() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasUid() {
            return (this.bitField0_ & 2048) == 2048;
        }

        @Override // com.wifi.ad.core.monitor.WkAdConfigRequest.SdkRequestOrBuilder
        public boolean hasValuetype() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.apiversion_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getRequestid());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, getDevice());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, getApp());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeString(5, getDid());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(6, this.scene_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeString(7, getTaichi());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeString(8, getRegtime());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(9, this.pv_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(10, this.valuetype_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeString(12, getAdUnitId());
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeString(13, getUid());
            }
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.writeString(14, getDeviceId());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(SdkRequest sdkRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sdkRequest);
        }

        public static SdkRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SdkRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SdkRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SdkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SdkRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApp(App.Builder builder) {
            this.app_ = builder.build();
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDevice(Device.Builder builder) {
            this.device_ = builder.build();
            this.bitField0_ |= 4;
        }

        public static SdkRequest parseFrom(InputStream inputStream) throws IOException {
            return (SdkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SdkRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SdkRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SdkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SdkRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SdkRequestOrBuilder extends MessageLiteOrBuilder {
        String getAdUnitId();

        ByteString getAdUnitIdBytes();

        int getApiversion();

        SdkRequest.App getApp();

        SdkRequest.Device getDevice();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        String getDid();

        ByteString getDidBytes();

        int getPv();

        String getRegtime();

        ByteString getRegtimeBytes();

        String getRequestid();

        ByteString getRequestidBytes();

        int getScene();

        String getTaichi();

        ByteString getTaichiBytes();

        String getUid();

        ByteString getUidBytes();

        int getValuetype();

        boolean hasAdUnitId();

        boolean hasApiversion();

        boolean hasApp();

        boolean hasDevice();

        boolean hasDeviceId();

        boolean hasDid();

        boolean hasPv();

        boolean hasRegtime();

        boolean hasRequestid();

        boolean hasScene();

        boolean hasTaichi();

        boolean hasUid();

        boolean hasValuetype();
    }

    private WkAdConfigRequest() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
