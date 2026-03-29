package com.wifi.ad.core.monitor.whitelist;

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
/* JADX INFO: loaded from: classes10.dex */
public final class WkWhiteAdConfigRequest {

    /* JADX INFO: renamed from: com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest$1, reason: invalid class name */
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
    public static final class SdkWhiteRequest extends GeneratedMessageLite<SdkWhiteRequest, Builder> implements SdkWhiteRequestOrBuilder {
        public static final int APIVERSION_FIELD_NUMBER = 1;
        public static final int APP_FIELD_NUMBER = 3;
        private static final SdkWhiteRequest DEFAULT_INSTANCE;
        public static final int DID_FIELD_NUMBER = 5;
        private static volatile Parser<SdkWhiteRequest> PARSER = null;
        public static final int REQUESTID_FIELD_NUMBER = 2;
        public static final int SCENE_FIELD_NUMBER = 6;
        public static final int TAICHI_FIELD_NUMBER = 7;
        public static final int VERSION_FIELD_NUMBER = 8;
        private int apiversion_;
        private App app_;
        private int bitField0_;
        private int scene_;
        private String requestid_ = "";
        private String did_ = "";
        private String taichi_ = "";
        private String version_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class App extends GeneratedMessageLite<App, Builder> implements AppOrBuilder {
            private static final App DEFAULT_INSTANCE;
            public static final int MARKET_FIELD_NUMBER = 3;
            private static volatile Parser<App> PARSER = null;
            public static final int PKGNAME_FIELD_NUMBER = 1;
            public static final int SUB_APPID_FIELD_NUMBER = 4;
            public static final int VERSION_FIELD_NUMBER = 2;
            private int bitField0_;
            private String pkgname_ = "";
            private String version_ = "";
            private String market_ = "";
            private String subAppid_ = "";

            /* JADX INFO: compiled from: SearchBox */
            public static final class Builder extends GeneratedMessageLite.Builder<App, Builder> implements AppOrBuilder {
                public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
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

                public Builder clearSubAppid() {
                    copyOnWrite();
                    ((App) this.instance).clearSubAppid();
                    return this;
                }

                public Builder clearVersion() {
                    copyOnWrite();
                    ((App) this.instance).clearVersion();
                    return this;
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
                public String getMarket() {
                    return ((App) this.instance).getMarket();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
                public ByteString getMarketBytes() {
                    return ((App) this.instance).getMarketBytes();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
                public String getPkgname() {
                    return ((App) this.instance).getPkgname();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
                public ByteString getPkgnameBytes() {
                    return ((App) this.instance).getPkgnameBytes();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
                public String getSubAppid() {
                    return ((App) this.instance).getSubAppid();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
                public ByteString getSubAppidBytes() {
                    return ((App) this.instance).getSubAppidBytes();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
                public String getVersion() {
                    return ((App) this.instance).getVersion();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
                public ByteString getVersionBytes() {
                    return ((App) this.instance).getVersionBytes();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
                public boolean hasMarket() {
                    return ((App) this.instance).hasMarket();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
                public boolean hasPkgname() {
                    return ((App) this.instance).hasPkgname();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
                public boolean hasSubAppid() {
                    return ((App) this.instance).hasSubAppid();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
                public boolean hasVersion() {
                    return ((App) this.instance).hasVersion();
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

                public Builder setSubAppid(String str) {
                    copyOnWrite();
                    ((App) this.instance).setSubAppid(str);
                    return this;
                }

                public Builder setSubAppidBytes(ByteString byteString) {
                    copyOnWrite();
                    ((App) this.instance).setSubAppidBytes(byteString);
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
            public void clearSubAppid() {
                this.bitField0_ &= -9;
                this.subAppid_ = getDefaultInstance().getSubAppid();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVersion() {
                this.bitField0_ &= -3;
                this.version_ = getDefaultInstance().getVersion();
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
            public void setSubAppid(String str) {
                str.getClass();
                this.bitField0_ |= 8;
                this.subAppid_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSubAppidBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 8;
                this.subAppid_ = byteString.toStringUtf8();
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
                        this.subAppid_ = visitor.visitString(hasSubAppid(), this.subAppid_, app.hasSubAppid(), app.subAppid_);
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
                                        this.subAppid_ = string4;
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

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
            public String getMarket() {
                return this.market_;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
            public ByteString getMarketBytes() {
                return ByteString.copyFromUtf8(this.market_);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
            public String getPkgname() {
                return this.pkgname_;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
            public ByteString getPkgnameBytes() {
                return ByteString.copyFromUtf8(this.pkgname_);
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
                    iComputeStringSize += CodedOutputStream.computeStringSize(4, getSubAppid());
                }
                int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
            public String getSubAppid() {
                return this.subAppid_;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
            public ByteString getSubAppidBytes() {
                return ByteString.copyFromUtf8(this.subAppid_);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
            public String getVersion() {
                return this.version_;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
            public ByteString getVersionBytes() {
                return ByteString.copyFromUtf8(this.version_);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
            public boolean hasMarket() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
            public boolean hasPkgname() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
            public boolean hasSubAppid() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.AppOrBuilder
            public boolean hasVersion() {
                return (this.bitField0_ & 2) == 2;
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
                    codedOutputStream.writeString(4, getSubAppid());
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
            String getMarket();

            ByteString getMarketBytes();

            String getPkgname();

            ByteString getPkgnameBytes();

            String getSubAppid();

            ByteString getSubAppidBytes();

            String getVersion();

            ByteString getVersionBytes();

            boolean hasMarket();

            boolean hasPkgname();

            boolean hasSubAppid();

            boolean hasVersion();
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<SdkWhiteRequest, Builder> implements SdkWhiteRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearApiversion() {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).clearApiversion();
                return this;
            }

            public Builder clearApp() {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).clearApp();
                return this;
            }

            public Builder clearDid() {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).clearDid();
                return this;
            }

            public Builder clearRequestid() {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).clearRequestid();
                return this;
            }

            public Builder clearScene() {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).clearScene();
                return this;
            }

            public Builder clearTaichi() {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).clearTaichi();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).clearVersion();
                return this;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public int getApiversion() {
                return ((SdkWhiteRequest) this.instance).getApiversion();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public App getApp() {
                return ((SdkWhiteRequest) this.instance).getApp();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public String getDid() {
                return ((SdkWhiteRequest) this.instance).getDid();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public ByteString getDidBytes() {
                return ((SdkWhiteRequest) this.instance).getDidBytes();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public String getRequestid() {
                return ((SdkWhiteRequest) this.instance).getRequestid();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public ByteString getRequestidBytes() {
                return ((SdkWhiteRequest) this.instance).getRequestidBytes();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public int getScene() {
                return ((SdkWhiteRequest) this.instance).getScene();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public String getTaichi() {
                return ((SdkWhiteRequest) this.instance).getTaichi();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public ByteString getTaichiBytes() {
                return ((SdkWhiteRequest) this.instance).getTaichiBytes();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public String getVersion() {
                return ((SdkWhiteRequest) this.instance).getVersion();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public ByteString getVersionBytes() {
                return ((SdkWhiteRequest) this.instance).getVersionBytes();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public boolean hasApiversion() {
                return ((SdkWhiteRequest) this.instance).hasApiversion();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public boolean hasApp() {
                return ((SdkWhiteRequest) this.instance).hasApp();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public boolean hasDid() {
                return ((SdkWhiteRequest) this.instance).hasDid();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public boolean hasRequestid() {
                return ((SdkWhiteRequest) this.instance).hasRequestid();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public boolean hasScene() {
                return ((SdkWhiteRequest) this.instance).hasScene();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public boolean hasTaichi() {
                return ((SdkWhiteRequest) this.instance).hasTaichi();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
            public boolean hasVersion() {
                return ((SdkWhiteRequest) this.instance).hasVersion();
            }

            public Builder mergeApp(App app) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).mergeApp(app);
                return this;
            }

            public Builder setApiversion(int i) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).setApiversion(i);
                return this;
            }

            public Builder setApp(App app) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).setApp(app);
                return this;
            }

            public Builder setDid(String str) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).setDid(str);
                return this;
            }

            public Builder setDidBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).setDidBytes(byteString);
                return this;
            }

            public Builder setRequestid(String str) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).setRequestid(str);
                return this;
            }

            public Builder setRequestidBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).setRequestidBytes(byteString);
                return this;
            }

            public Builder setScene(int i) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).setScene(i);
                return this;
            }

            public Builder setTaichi(String str) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).setTaichi(str);
                return this;
            }

            public Builder setTaichiBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).setTaichiBytes(byteString);
                return this;
            }

            public Builder setVersion(String str) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).setVersion(str);
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).setVersionBytes(byteString);
                return this;
            }

            private Builder() {
                super(SdkWhiteRequest.DEFAULT_INSTANCE);
            }

            public Builder setApp(App.Builder builder) {
                copyOnWrite();
                ((SdkWhiteRequest) this.instance).setApp(builder);
                return this;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class Device extends GeneratedMessageLite<Device, Builder> implements DeviceOrBuilder {
            public static final int AID_FIELD_NUMBER = 4;
            private static final Device DEFAULT_INSTANCE;
            public static final int IMEI_FIELD_NUMBER = 1;
            public static final int LATITUDE_FIELD_NUMBER = 6;
            public static final int LONGITUDE_FIELD_NUMBER = 5;
            public static final int MAC_FIELD_NUMBER = 2;
            public static final int OAID_FIELD_NUMBER = 3;
            private static volatile Parser<Device> PARSER;
            private int bitField0_;
            private String imei_ = "";
            private String mac_ = "";
            private String oaid_ = "";
            private String aid_ = "";
            private String longitude_ = "";
            private String latitude_ = "";

            /* JADX INFO: compiled from: SearchBox */
            public static final class Builder extends GeneratedMessageLite.Builder<Device, Builder> implements DeviceOrBuilder {
                public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearAid() {
                    copyOnWrite();
                    ((Device) this.instance).clearAid();
                    return this;
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

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public String getAid() {
                    return ((Device) this.instance).getAid();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public ByteString getAidBytes() {
                    return ((Device) this.instance).getAidBytes();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public String getImei() {
                    return ((Device) this.instance).getImei();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public ByteString getImeiBytes() {
                    return ((Device) this.instance).getImeiBytes();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public String getLatitude() {
                    return ((Device) this.instance).getLatitude();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public ByteString getLatitudeBytes() {
                    return ((Device) this.instance).getLatitudeBytes();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public String getLongitude() {
                    return ((Device) this.instance).getLongitude();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public ByteString getLongitudeBytes() {
                    return ((Device) this.instance).getLongitudeBytes();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public String getMac() {
                    return ((Device) this.instance).getMac();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public ByteString getMacBytes() {
                    return ((Device) this.instance).getMacBytes();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public String getOaid() {
                    return ((Device) this.instance).getOaid();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public ByteString getOaidBytes() {
                    return ((Device) this.instance).getOaidBytes();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public boolean hasAid() {
                    return ((Device) this.instance).hasAid();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public boolean hasImei() {
                    return ((Device) this.instance).hasImei();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public boolean hasLatitude() {
                    return ((Device) this.instance).hasLatitude();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public boolean hasLongitude() {
                    return ((Device) this.instance).hasLongitude();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public boolean hasMac() {
                    return ((Device) this.instance).hasMac();
                }

                @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
                public boolean hasOaid() {
                    return ((Device) this.instance).hasOaid();
                }

                public Builder setAid(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setAid(str);
                    return this;
                }

                public Builder setAidBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setAidBytes(byteString);
                    return this;
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

                public Builder setLatitude(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setLatitude(str);
                    return this;
                }

                public Builder setLatitudeBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setLatitudeBytes(byteString);
                    return this;
                }

                public Builder setLongitude(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setLongitude(str);
                    return this;
                }

                public Builder setLongitudeBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setLongitudeBytes(byteString);
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
            public void clearAid() {
                this.bitField0_ &= -9;
                this.aid_ = getDefaultInstance().getAid();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearImei() {
                this.bitField0_ &= -2;
                this.imei_ = getDefaultInstance().getImei();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLatitude() {
                this.bitField0_ &= -33;
                this.latitude_ = getDefaultInstance().getLatitude();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLongitude() {
                this.bitField0_ &= -17;
                this.longitude_ = getDefaultInstance().getLongitude();
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
            public void setAid(String str) {
                str.getClass();
                this.bitField0_ |= 8;
                this.aid_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAidBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 8;
                this.aid_ = byteString.toStringUtf8();
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
            public void setLatitude(String str) {
                str.getClass();
                this.bitField0_ |= 32;
                this.latitude_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLatitudeBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 32;
                this.latitude_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLongitude(String str) {
                str.getClass();
                this.bitField0_ |= 16;
                this.longitude_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLongitudeBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 16;
                this.longitude_ = byteString.toStringUtf8();
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
                        this.aid_ = visitor.visitString(hasAid(), this.aid_, device.hasAid(), device.aid_);
                        this.longitude_ = visitor.visitString(hasLongitude(), this.longitude_, device.hasLongitude(), device.longitude_);
                        this.latitude_ = visitor.visitString(hasLatitude(), this.latitude_, device.hasLatitude(), device.latitude_);
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
                                    } else if (tag == 34) {
                                        String string4 = codedInputStream.readString();
                                        this.bitField0_ |= 8;
                                        this.aid_ = string4;
                                    } else if (tag == 42) {
                                        String string5 = codedInputStream.readString();
                                        this.bitField0_ |= 16;
                                        this.longitude_ = string5;
                                    } else if (tag == 50) {
                                        String string6 = codedInputStream.readString();
                                        this.bitField0_ |= 32;
                                        this.latitude_ = string6;
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

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public String getAid() {
                return this.aid_;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public ByteString getAidBytes() {
                return ByteString.copyFromUtf8(this.aid_);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public String getImei() {
                return this.imei_;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public ByteString getImeiBytes() {
                return ByteString.copyFromUtf8(this.imei_);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public String getLatitude() {
                return this.latitude_;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public ByteString getLatitudeBytes() {
                return ByteString.copyFromUtf8(this.latitude_);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public String getLongitude() {
                return this.longitude_;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public ByteString getLongitudeBytes() {
                return ByteString.copyFromUtf8(this.longitude_);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public String getMac() {
                return this.mac_;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public ByteString getMacBytes() {
                return ByteString.copyFromUtf8(this.mac_);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public String getOaid() {
                return this.oaid_;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
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
                    iComputeStringSize += CodedOutputStream.computeStringSize(4, getAid());
                }
                if ((this.bitField0_ & 16) == 16) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(5, getLongitude());
                }
                if ((this.bitField0_ & 32) == 32) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(6, getLatitude());
                }
                int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public boolean hasAid() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public boolean hasImei() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public boolean hasLatitude() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public boolean hasLongitude() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
            public boolean hasMac() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequest.DeviceOrBuilder
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
                    codedOutputStream.writeString(4, getAid());
                }
                if ((this.bitField0_ & 16) == 16) {
                    codedOutputStream.writeString(5, getLongitude());
                }
                if ((this.bitField0_ & 32) == 32) {
                    codedOutputStream.writeString(6, getLatitude());
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
            String getAid();

            ByteString getAidBytes();

            String getImei();

            ByteString getImeiBytes();

            String getLatitude();

            ByteString getLatitudeBytes();

            String getLongitude();

            ByteString getLongitudeBytes();

            String getMac();

            ByteString getMacBytes();

            String getOaid();

            ByteString getOaidBytes();

            boolean hasAid();

            boolean hasImei();

            boolean hasLatitude();

            boolean hasLongitude();

            boolean hasMac();

            boolean hasOaid();
        }

        static {
            SdkWhiteRequest sdkWhiteRequest = new SdkWhiteRequest();
            DEFAULT_INSTANCE = sdkWhiteRequest;
            sdkWhiteRequest.makeImmutable();
        }

        private SdkWhiteRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearApiversion() {
            this.bitField0_ &= -2;
            this.apiversion_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearApp() {
            this.app_ = null;
            this.bitField0_ &= -5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDid() {
            this.bitField0_ &= -9;
            this.did_ = getDefaultInstance().getDid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRequestid() {
            this.bitField0_ &= -3;
            this.requestid_ = getDefaultInstance().getRequestid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScene() {
            this.bitField0_ &= -17;
            this.scene_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaichi() {
            this.bitField0_ &= -33;
            this.taichi_ = getDefaultInstance().getTaichi();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.bitField0_ &= -65;
            this.version_ = getDefaultInstance().getVersion();
        }

        public static SdkWhiteRequest getDefaultInstance() {
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
            this.bitField0_ |= 4;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SdkWhiteRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SdkWhiteRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SdkWhiteRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SdkWhiteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<SdkWhiteRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
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
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDid(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.did_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.did_ = byteString.toStringUtf8();
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
            this.bitField0_ |= 16;
            this.scene_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaichi(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.taichi_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaichiBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.taichi_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(String str) {
            str.getClass();
            this.bitField0_ |= 64;
            this.version_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.version_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SdkWhiteRequest();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    SdkWhiteRequest sdkWhiteRequest = (SdkWhiteRequest) obj2;
                    this.apiversion_ = visitor.visitInt(hasApiversion(), this.apiversion_, sdkWhiteRequest.hasApiversion(), sdkWhiteRequest.apiversion_);
                    this.requestid_ = visitor.visitString(hasRequestid(), this.requestid_, sdkWhiteRequest.hasRequestid(), sdkWhiteRequest.requestid_);
                    this.app_ = (App) visitor.visitMessage(this.app_, sdkWhiteRequest.app_);
                    this.did_ = visitor.visitString(hasDid(), this.did_, sdkWhiteRequest.hasDid(), sdkWhiteRequest.did_);
                    this.scene_ = visitor.visitInt(hasScene(), this.scene_, sdkWhiteRequest.hasScene(), sdkWhiteRequest.scene_);
                    this.taichi_ = visitor.visitString(hasTaichi(), this.taichi_, sdkWhiteRequest.hasTaichi(), sdkWhiteRequest.taichi_);
                    this.version_ = visitor.visitString(hasVersion(), this.version_, sdkWhiteRequest.hasVersion(), sdkWhiteRequest.version_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= sdkWhiteRequest.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.bitField0_ |= 1;
                                    this.apiversion_ = codedInputStream.readInt32();
                                } else if (tag == 18) {
                                    String string = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.requestid_ = string;
                                } else if (tag == 26) {
                                    App.Builder builder = (this.bitField0_ & 4) == 4 ? this.app_.toBuilder() : null;
                                    App app = (App) codedInputStream.readMessage(App.parser(), extensionRegistryLite);
                                    this.app_ = app;
                                    if (builder != null) {
                                        builder.mergeFrom(app);
                                        this.app_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (tag == 42) {
                                    String string2 = codedInputStream.readString();
                                    this.bitField0_ |= 8;
                                    this.did_ = string2;
                                } else if (tag == 48) {
                                    this.bitField0_ |= 16;
                                    this.scene_ = codedInputStream.readInt32();
                                } else if (tag == 58) {
                                    String string3 = codedInputStream.readString();
                                    this.bitField0_ |= 32;
                                    this.taichi_ = string3;
                                } else if (tag == 66) {
                                    String string4 = codedInputStream.readString();
                                    this.bitField0_ |= 64;
                                    this.version_ = string4;
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
                        synchronized (SdkWhiteRequest.class) {
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

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public int getApiversion() {
            return this.apiversion_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public App getApp() {
            App app = this.app_;
            return app == null ? App.getDefaultInstance() : app;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public String getDid() {
            return this.did_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public ByteString getDidBytes() {
            return ByteString.copyFromUtf8(this.did_);
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public String getRequestid() {
            return this.requestid_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public ByteString getRequestidBytes() {
            return ByteString.copyFromUtf8(this.requestid_);
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
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
                iComputeInt32Size += CodedOutputStream.computeMessageSize(3, getApp());
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(5, getDid());
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(6, this.scene_);
            }
            if ((this.bitField0_ & 32) == 32) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(7, getTaichi());
            }
            if ((this.bitField0_ & 64) == 64) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(8, getVersion());
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public String getTaichi() {
            return this.taichi_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public ByteString getTaichiBytes() {
            return ByteString.copyFromUtf8(this.taichi_);
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public String getVersion() {
            return this.version_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public boolean hasApiversion() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public boolean hasApp() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public boolean hasDid() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public boolean hasRequestid() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public boolean hasScene() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public boolean hasTaichi() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest.SdkWhiteRequestOrBuilder
        public boolean hasVersion() {
            return (this.bitField0_ & 64) == 64;
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
                codedOutputStream.writeMessage(3, getApp());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeString(5, getDid());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(6, this.scene_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeString(7, getTaichi());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeString(8, getVersion());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(SdkWhiteRequest sdkWhiteRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sdkWhiteRequest);
        }

        public static SdkWhiteRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkWhiteRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SdkWhiteRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkWhiteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SdkWhiteRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SdkWhiteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SdkWhiteRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkWhiteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApp(App.Builder builder) {
            this.app_ = builder.build();
            this.bitField0_ |= 4;
        }

        public static SdkWhiteRequest parseFrom(InputStream inputStream) throws IOException {
            return (SdkWhiteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SdkWhiteRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkWhiteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SdkWhiteRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SdkWhiteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SdkWhiteRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkWhiteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SdkWhiteRequestOrBuilder extends MessageLiteOrBuilder {
        int getApiversion();

        SdkWhiteRequest.App getApp();

        String getDid();

        ByteString getDidBytes();

        String getRequestid();

        ByteString getRequestidBytes();

        int getScene();

        String getTaichi();

        ByteString getTaichiBytes();

        String getVersion();

        ByteString getVersionBytes();

        boolean hasApiversion();

        boolean hasApp();

        boolean hasDid();

        boolean hasRequestid();

        boolean hasScene();

        boolean hasTaichi();

        boolean hasVersion();
    }

    private WkWhiteAdConfigRequest() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
