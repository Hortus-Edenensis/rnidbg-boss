package com.wifi.ad.core.config.adx.all;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class WkAdxAllResponse {

    /* JADX INFO: renamed from: com.wifi.ad.core.config.adx.all.WkAdxAllResponse$1, reason: invalid class name */
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
    public static final class AdStrategyData extends GeneratedMessageLite<AdStrategyData, Builder> implements AdStrategyDataOrBuilder {
        public static final int AD_UNIT_ID_FIELD_NUMBER = 3;
        public static final int APPID_FIELD_NUMBER = 1;
        private static final AdStrategyData DEFAULT_INSTANCE;
        private static volatile Parser<AdStrategyData> PARSER = null;
        public static final int SCENE_FIELD_NUMBER = 2;
        public static final int STRATEGY_FIELD_NUMBER = 5;
        public static final int TAICHI_FIELD_NUMBER = 4;
        private int bitField0_;
        private int scene_;
        private String appid_ = "";
        private String adUnitId_ = "";
        private String taichi_ = "";
        private String strategy_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<AdStrategyData, Builder> implements AdStrategyDataOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAdUnitId() {
                copyOnWrite();
                ((AdStrategyData) this.instance).clearAdUnitId();
                return this;
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((AdStrategyData) this.instance).clearAppid();
                return this;
            }

            public Builder clearScene() {
                copyOnWrite();
                ((AdStrategyData) this.instance).clearScene();
                return this;
            }

            public Builder clearStrategy() {
                copyOnWrite();
                ((AdStrategyData) this.instance).clearStrategy();
                return this;
            }

            public Builder clearTaichi() {
                copyOnWrite();
                ((AdStrategyData) this.instance).clearTaichi();
                return this;
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public String getAdUnitId() {
                return ((AdStrategyData) this.instance).getAdUnitId();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public ByteString getAdUnitIdBytes() {
                return ((AdStrategyData) this.instance).getAdUnitIdBytes();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public String getAppid() {
                return ((AdStrategyData) this.instance).getAppid();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public ByteString getAppidBytes() {
                return ((AdStrategyData) this.instance).getAppidBytes();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public int getScene() {
                return ((AdStrategyData) this.instance).getScene();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public String getStrategy() {
                return ((AdStrategyData) this.instance).getStrategy();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public ByteString getStrategyBytes() {
                return ((AdStrategyData) this.instance).getStrategyBytes();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public String getTaichi() {
                return ((AdStrategyData) this.instance).getTaichi();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public ByteString getTaichiBytes() {
                return ((AdStrategyData) this.instance).getTaichiBytes();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public boolean hasAdUnitId() {
                return ((AdStrategyData) this.instance).hasAdUnitId();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public boolean hasAppid() {
                return ((AdStrategyData) this.instance).hasAppid();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public boolean hasScene() {
                return ((AdStrategyData) this.instance).hasScene();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public boolean hasStrategy() {
                return ((AdStrategyData) this.instance).hasStrategy();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
            public boolean hasTaichi() {
                return ((AdStrategyData) this.instance).hasTaichi();
            }

            public Builder setAdUnitId(String str) {
                copyOnWrite();
                ((AdStrategyData) this.instance).setAdUnitId(str);
                return this;
            }

            public Builder setAdUnitIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AdStrategyData) this.instance).setAdUnitIdBytes(byteString);
                return this;
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((AdStrategyData) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((AdStrategyData) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setScene(int i) {
                copyOnWrite();
                ((AdStrategyData) this.instance).setScene(i);
                return this;
            }

            public Builder setStrategy(String str) {
                copyOnWrite();
                ((AdStrategyData) this.instance).setStrategy(str);
                return this;
            }

            public Builder setStrategyBytes(ByteString byteString) {
                copyOnWrite();
                ((AdStrategyData) this.instance).setStrategyBytes(byteString);
                return this;
            }

            public Builder setTaichi(String str) {
                copyOnWrite();
                ((AdStrategyData) this.instance).setTaichi(str);
                return this;
            }

            public Builder setTaichiBytes(ByteString byteString) {
                copyOnWrite();
                ((AdStrategyData) this.instance).setTaichiBytes(byteString);
                return this;
            }

            private Builder() {
                super(AdStrategyData.DEFAULT_INSTANCE);
            }
        }

        static {
            AdStrategyData adStrategyData = new AdStrategyData();
            DEFAULT_INSTANCE = adStrategyData;
            adStrategyData.makeImmutable();
        }

        private AdStrategyData() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdUnitId() {
            this.bitField0_ &= -5;
            this.adUnitId_ = getDefaultInstance().getAdUnitId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScene() {
            this.bitField0_ &= -3;
            this.scene_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStrategy() {
            this.bitField0_ &= -17;
            this.strategy_ = getDefaultInstance().getStrategy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaichi() {
            this.bitField0_ &= -9;
            this.taichi_ = getDefaultInstance().getTaichi();
        }

        public static AdStrategyData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static AdStrategyData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AdStrategyData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AdStrategyData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AdStrategyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<AdStrategyData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdUnitId(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.adUnitId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdUnitIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.adUnitId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppid(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.appid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.appid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScene(int i) {
            this.bitField0_ |= 2;
            this.scene_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrategy(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.strategy_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrategyBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.strategy_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaichi(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.taichi_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaichiBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.taichi_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AdStrategyData();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    AdStrategyData adStrategyData = (AdStrategyData) obj2;
                    this.appid_ = visitor.visitString(hasAppid(), this.appid_, adStrategyData.hasAppid(), adStrategyData.appid_);
                    this.scene_ = visitor.visitInt(hasScene(), this.scene_, adStrategyData.hasScene(), adStrategyData.scene_);
                    this.adUnitId_ = visitor.visitString(hasAdUnitId(), this.adUnitId_, adStrategyData.hasAdUnitId(), adStrategyData.adUnitId_);
                    this.taichi_ = visitor.visitString(hasTaichi(), this.taichi_, adStrategyData.hasTaichi(), adStrategyData.taichi_);
                    this.strategy_ = visitor.visitString(hasStrategy(), this.strategy_, adStrategyData.hasStrategy(), adStrategyData.strategy_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= adStrategyData.bitField0_;
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
                                    this.appid_ = string;
                                } else if (tag == 16) {
                                    this.bitField0_ |= 2;
                                    this.scene_ = codedInputStream.readInt32();
                                } else if (tag == 26) {
                                    String string2 = codedInputStream.readString();
                                    this.bitField0_ |= 4;
                                    this.adUnitId_ = string2;
                                } else if (tag == 34) {
                                    String string3 = codedInputStream.readString();
                                    this.bitField0_ |= 8;
                                    this.taichi_ = string3;
                                } else if (tag == 42) {
                                    String string4 = codedInputStream.readString();
                                    this.bitField0_ |= 16;
                                    this.strategy_ = string4;
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
                        synchronized (AdStrategyData.class) {
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

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public String getAdUnitId() {
            return this.adUnitId_;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public ByteString getAdUnitIdBytes() {
            return ByteString.copyFromUtf8(this.adUnitId_);
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public int getScene() {
            return this.scene_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getAppid()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(2, this.scene_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getAdUnitId());
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, getTaichi());
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, getStrategy());
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public String getStrategy() {
            return this.strategy_;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public ByteString getStrategyBytes() {
            return ByteString.copyFromUtf8(this.strategy_);
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public String getTaichi() {
            return this.taichi_;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public ByteString getTaichiBytes() {
            return ByteString.copyFromUtf8(this.taichi_);
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public boolean hasAdUnitId() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public boolean hasAppid() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public boolean hasScene() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public boolean hasStrategy() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AdStrategyDataOrBuilder
        public boolean hasTaichi() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getAppid());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.scene_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeString(3, getAdUnitId());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeString(4, getTaichi());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeString(5, getStrategy());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(AdStrategyData adStrategyData) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(adStrategyData);
        }

        public static AdStrategyData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdStrategyData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AdStrategyData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AdStrategyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AdStrategyData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AdStrategyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AdStrategyData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AdStrategyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AdStrategyData parseFrom(InputStream inputStream) throws IOException {
            return (AdStrategyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AdStrategyData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdStrategyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AdStrategyData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AdStrategyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AdStrategyData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdStrategyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AdStrategyDataOrBuilder extends MessageLiteOrBuilder {
        String getAdUnitId();

        ByteString getAdUnitIdBytes();

        String getAppid();

        ByteString getAppidBytes();

        int getScene();

        String getStrategy();

        ByteString getStrategyBytes();

        String getTaichi();

        ByteString getTaichiBytes();

        boolean hasAdUnitId();

        boolean hasAppid();

        boolean hasScene();

        boolean hasStrategy();

        boolean hasTaichi();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class AllStrategiesResponse extends GeneratedMessageLite<AllStrategiesResponse, Builder> implements AllStrategiesResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int DATA_FIELD_NUMBER = 4;
        private static final AllStrategiesResponse DEFAULT_INSTANCE;
        public static final int MSG_FIELD_NUMBER = 2;
        private static volatile Parser<AllStrategiesResponse> PARSER = null;
        public static final int REQUESTID_FIELD_NUMBER = 3;
        public static final int UPDATE_INTERVAL_FIELD_NUMBER = 5;
        private int bitField0_;
        private int code_;
        private int updateInterval_;
        private String msg_ = "";
        private String requestid_ = "";
        private Internal.ProtobufList<AdStrategyData> data_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<AllStrategiesResponse, Builder> implements AllStrategiesResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllData(Iterable<? extends AdStrategyData> iterable) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).addAllData(iterable);
                return this;
            }

            public Builder addData(AdStrategyData adStrategyData) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).addData(adStrategyData);
                return this;
            }

            public Builder clearCode() {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).clearCode();
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).clearData();
                return this;
            }

            public Builder clearMsg() {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).clearMsg();
                return this;
            }

            public Builder clearRequestid() {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).clearRequestid();
                return this;
            }

            public Builder clearUpdateInterval() {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).clearUpdateInterval();
                return this;
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public int getCode() {
                return ((AllStrategiesResponse) this.instance).getCode();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public AdStrategyData getData(int i) {
                return ((AllStrategiesResponse) this.instance).getData(i);
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public int getDataCount() {
                return ((AllStrategiesResponse) this.instance).getDataCount();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public List<AdStrategyData> getDataList() {
                return Collections.unmodifiableList(((AllStrategiesResponse) this.instance).getDataList());
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public String getMsg() {
                return ((AllStrategiesResponse) this.instance).getMsg();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public ByteString getMsgBytes() {
                return ((AllStrategiesResponse) this.instance).getMsgBytes();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public String getRequestid() {
                return ((AllStrategiesResponse) this.instance).getRequestid();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public ByteString getRequestidBytes() {
                return ((AllStrategiesResponse) this.instance).getRequestidBytes();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public int getUpdateInterval() {
                return ((AllStrategiesResponse) this.instance).getUpdateInterval();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public boolean hasCode() {
                return ((AllStrategiesResponse) this.instance).hasCode();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public boolean hasMsg() {
                return ((AllStrategiesResponse) this.instance).hasMsg();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public boolean hasRequestid() {
                return ((AllStrategiesResponse) this.instance).hasRequestid();
            }

            @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
            public boolean hasUpdateInterval() {
                return ((AllStrategiesResponse) this.instance).hasUpdateInterval();
            }

            public Builder removeData(int i) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).removeData(i);
                return this;
            }

            public Builder setCode(int i) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).setCode(i);
                return this;
            }

            public Builder setData(int i, AdStrategyData adStrategyData) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).setData(i, adStrategyData);
                return this;
            }

            public Builder setMsg(String str) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).setMsg(str);
                return this;
            }

            public Builder setMsgBytes(ByteString byteString) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).setMsgBytes(byteString);
                return this;
            }

            public Builder setRequestid(String str) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).setRequestid(str);
                return this;
            }

            public Builder setRequestidBytes(ByteString byteString) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).setRequestidBytes(byteString);
                return this;
            }

            public Builder setUpdateInterval(int i) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).setUpdateInterval(i);
                return this;
            }

            private Builder() {
                super(AllStrategiesResponse.DEFAULT_INSTANCE);
            }

            public Builder addData(int i, AdStrategyData adStrategyData) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).addData(i, adStrategyData);
                return this;
            }

            public Builder setData(int i, AdStrategyData.Builder builder) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).setData(i, builder);
                return this;
            }

            public Builder addData(AdStrategyData.Builder builder) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).addData(builder);
                return this;
            }

            public Builder addData(int i, AdStrategyData.Builder builder) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).addData(i, builder);
                return this;
            }
        }

        static {
            AllStrategiesResponse allStrategiesResponse = new AllStrategiesResponse();
            DEFAULT_INSTANCE = allStrategiesResponse;
            allStrategiesResponse.makeImmutable();
        }

        private AllStrategiesResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllData(Iterable<? extends AdStrategyData> iterable) {
            ensureDataIsMutable();
            AbstractMessageLite.addAll(iterable, this.data_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addData(AdStrategyData adStrategyData) {
            adStrategyData.getClass();
            ensureDataIsMutable();
            this.data_.add(adStrategyData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.bitField0_ &= -2;
            this.code_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsg() {
            this.bitField0_ &= -3;
            this.msg_ = getDefaultInstance().getMsg();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRequestid() {
            this.bitField0_ &= -5;
            this.requestid_ = getDefaultInstance().getRequestid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpdateInterval() {
            this.bitField0_ &= -9;
            this.updateInterval_ = 0;
        }

        private void ensureDataIsMutable() {
            if (this.data_.isModifiable()) {
                return;
            }
            this.data_ = GeneratedMessageLite.mutableCopy(this.data_);
        }

        public static AllStrategiesResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static AllStrategiesResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AllStrategiesResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AllStrategiesResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AllStrategiesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<AllStrategiesResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeData(int i) {
            ensureDataIsMutable();
            this.data_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(int i) {
            this.bitField0_ |= 1;
            this.code_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(int i, AdStrategyData adStrategyData) {
            adStrategyData.getClass();
            ensureDataIsMutable();
            this.data_.set(i, adStrategyData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsg(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.msg_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.msg_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequestid(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.requestid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequestidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.requestid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdateInterval(int i) {
            this.bitField0_ |= 8;
            this.updateInterval_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AllStrategiesResponse();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.data_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    AllStrategiesResponse allStrategiesResponse = (AllStrategiesResponse) obj2;
                    this.code_ = visitor.visitInt(hasCode(), this.code_, allStrategiesResponse.hasCode(), allStrategiesResponse.code_);
                    this.msg_ = visitor.visitString(hasMsg(), this.msg_, allStrategiesResponse.hasMsg(), allStrategiesResponse.msg_);
                    this.requestid_ = visitor.visitString(hasRequestid(), this.requestid_, allStrategiesResponse.hasRequestid(), allStrategiesResponse.requestid_);
                    this.data_ = visitor.visitList(this.data_, allStrategiesResponse.data_);
                    this.updateInterval_ = visitor.visitInt(hasUpdateInterval(), this.updateInterval_, allStrategiesResponse.hasUpdateInterval(), allStrategiesResponse.updateInterval_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= allStrategiesResponse.bitField0_;
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
                                    this.code_ = codedInputStream.readInt32();
                                } else if (tag == 18) {
                                    String string = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.msg_ = string;
                                } else if (tag == 26) {
                                    String string2 = codedInputStream.readString();
                                    this.bitField0_ |= 4;
                                    this.requestid_ = string2;
                                } else if (tag == 34) {
                                    if (!this.data_.isModifiable()) {
                                        this.data_ = GeneratedMessageLite.mutableCopy(this.data_);
                                    }
                                    this.data_.add(codedInputStream.readMessage(AdStrategyData.parser(), extensionRegistryLite));
                                } else if (tag == 40) {
                                    this.bitField0_ |= 8;
                                    this.updateInterval_ = codedInputStream.readInt32();
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
                        synchronized (AllStrategiesResponse.class) {
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

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public AdStrategyData getData(int i) {
            return this.data_.get(i);
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public int getDataCount() {
            return this.data_.size();
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public List<AdStrategyData> getDataList() {
            return this.data_;
        }

        public AdStrategyDataOrBuilder getDataOrBuilder(int i) {
            return this.data_.get(i);
        }

        public List<? extends AdStrategyDataOrBuilder> getDataOrBuilderList() {
            return this.data_;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public String getMsg() {
            return this.msg_;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public ByteString getMsgBytes() {
            return ByteString.copyFromUtf8(this.msg_);
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public String getRequestid() {
            return this.requestid_;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public ByteString getRequestidBytes() {
            return ByteString.copyFromUtf8(this.requestid_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.code_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(2, getMsg());
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(3, getRequestid());
            }
            for (int i2 = 0; i2 < this.data_.size(); i2++) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.data_.get(i2));
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.updateInterval_);
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public int getUpdateInterval() {
            return this.updateInterval_;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public boolean hasCode() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public boolean hasMsg() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public boolean hasRequestid() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.wifi.ad.core.config.adx.all.WkAdxAllResponse.AllStrategiesResponseOrBuilder
        public boolean hasUpdateInterval() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.code_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getMsg());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeString(3, getRequestid());
            }
            for (int i = 0; i < this.data_.size(); i++) {
                codedOutputStream.writeMessage(4, this.data_.get(i));
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(5, this.updateInterval_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(AllStrategiesResponse allStrategiesResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(allStrategiesResponse);
        }

        public static AllStrategiesResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AllStrategiesResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AllStrategiesResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AllStrategiesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AllStrategiesResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AllStrategiesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addData(int i, AdStrategyData adStrategyData) {
            adStrategyData.getClass();
            ensureDataIsMutable();
            this.data_.add(i, adStrategyData);
        }

        public static AllStrategiesResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AllStrategiesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(int i, AdStrategyData.Builder builder) {
            ensureDataIsMutable();
            this.data_.set(i, builder.build());
        }

        public static AllStrategiesResponse parseFrom(InputStream inputStream) throws IOException {
            return (AllStrategiesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AllStrategiesResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AllStrategiesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addData(AdStrategyData.Builder builder) {
            ensureDataIsMutable();
            this.data_.add(builder.build());
        }

        public static AllStrategiesResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AllStrategiesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AllStrategiesResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AllStrategiesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addData(int i, AdStrategyData.Builder builder) {
            ensureDataIsMutable();
            this.data_.add(i, builder.build());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AllStrategiesResponseOrBuilder extends MessageLiteOrBuilder {
        int getCode();

        AdStrategyData getData(int i);

        int getDataCount();

        List<AdStrategyData> getDataList();

        String getMsg();

        ByteString getMsgBytes();

        String getRequestid();

        ByteString getRequestidBytes();

        int getUpdateInterval();

        boolean hasCode();

        boolean hasMsg();

        boolean hasRequestid();

        boolean hasUpdateInterval();
    }

    private WkAdxAllResponse() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
