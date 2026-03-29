package com.wifi.ad.core.spstrategy.all;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
public final class WkSPAllResponse {

    /* JADX INFO: renamed from: com.wifi.ad.core.spstrategy.all.WkSPAllResponse$1, reason: invalid class name */
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
    public static final class AdStrategy extends GeneratedMessageLite<AdStrategy, Builder> implements AdStrategyOrBuilder {
        public static final int CACHE_CFG_FIELD_NUMBER = 80;
        private static final AdStrategy DEFAULT_INSTANCE;
        public static final int GROUP_CFG_FIELD_NUMBER = 90;
        public static final int MATERIAL_CONTROL_FIELD_NUMBER = 100;
        private static volatile Parser<AdStrategy> PARSER = null;
        public static final int PK_CFG_FIELD_NUMBER = 60;
        public static final int SDK_CFG_FIELD_NUMBER = 70;
        public static final int STRATEGY_ID_FIELD_NUMBER = 10;
        public static final int STRATEGY_VER_FIELD_NUMBER = 20;
        public static final int SWITCH_FIELD_NUMBER = 50;
        public static final int TIMEOUT_FIELD_NUMBER = 40;
        public static final int UPDATE_INTERVAL_FIELD_NUMBER = 30;
        public static final int USER_TYPE_FIELD_NUMBER = 110;
        private int bitField0_;
        private CacheCfg cacheCfg_;
        private MaterialControl materialControl_;
        private Switch switch_;
        private int timeout_;
        private int updateInterval_;
        private int userType_;
        private String strategyId_ = "";
        private String strategyVer_ = "";
        private Internal.ProtobufList<PkCfg> pkCfg_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<SdkCfg> sdkCfg_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<GroupCfg> groupCfg_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<AdStrategy, Builder> implements AdStrategyOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllGroupCfg(Iterable<? extends GroupCfg> iterable) {
                copyOnWrite();
                ((AdStrategy) this.instance).addAllGroupCfg(iterable);
                return this;
            }

            public Builder addAllPkCfg(Iterable<? extends PkCfg> iterable) {
                copyOnWrite();
                ((AdStrategy) this.instance).addAllPkCfg(iterable);
                return this;
            }

            public Builder addAllSdkCfg(Iterable<? extends SdkCfg> iterable) {
                copyOnWrite();
                ((AdStrategy) this.instance).addAllSdkCfg(iterable);
                return this;
            }

            public Builder addGroupCfg(GroupCfg groupCfg) {
                copyOnWrite();
                ((AdStrategy) this.instance).addGroupCfg(groupCfg);
                return this;
            }

            public Builder addPkCfg(PkCfg pkCfg) {
                copyOnWrite();
                ((AdStrategy) this.instance).addPkCfg(pkCfg);
                return this;
            }

            public Builder addSdkCfg(SdkCfg sdkCfg) {
                copyOnWrite();
                ((AdStrategy) this.instance).addSdkCfg(sdkCfg);
                return this;
            }

            public Builder clearCacheCfg() {
                copyOnWrite();
                ((AdStrategy) this.instance).clearCacheCfg();
                return this;
            }

            public Builder clearGroupCfg() {
                copyOnWrite();
                ((AdStrategy) this.instance).clearGroupCfg();
                return this;
            }

            public Builder clearMaterialControl() {
                copyOnWrite();
                ((AdStrategy) this.instance).clearMaterialControl();
                return this;
            }

            public Builder clearPkCfg() {
                copyOnWrite();
                ((AdStrategy) this.instance).clearPkCfg();
                return this;
            }

            public Builder clearSdkCfg() {
                copyOnWrite();
                ((AdStrategy) this.instance).clearSdkCfg();
                return this;
            }

            public Builder clearStrategyId() {
                copyOnWrite();
                ((AdStrategy) this.instance).clearStrategyId();
                return this;
            }

            public Builder clearStrategyVer() {
                copyOnWrite();
                ((AdStrategy) this.instance).clearStrategyVer();
                return this;
            }

            public Builder clearSwitch() {
                copyOnWrite();
                ((AdStrategy) this.instance).clearSwitch();
                return this;
            }

            public Builder clearTimeout() {
                copyOnWrite();
                ((AdStrategy) this.instance).clearTimeout();
                return this;
            }

            public Builder clearUpdateInterval() {
                copyOnWrite();
                ((AdStrategy) this.instance).clearUpdateInterval();
                return this;
            }

            public Builder clearUserType() {
                copyOnWrite();
                ((AdStrategy) this.instance).clearUserType();
                return this;
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public CacheCfg getCacheCfg() {
                return ((AdStrategy) this.instance).getCacheCfg();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public GroupCfg getGroupCfg(int i) {
                return ((AdStrategy) this.instance).getGroupCfg(i);
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public int getGroupCfgCount() {
                return ((AdStrategy) this.instance).getGroupCfgCount();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public List<GroupCfg> getGroupCfgList() {
                return Collections.unmodifiableList(((AdStrategy) this.instance).getGroupCfgList());
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public MaterialControl getMaterialControl() {
                return ((AdStrategy) this.instance).getMaterialControl();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public PkCfg getPkCfg(int i) {
                return ((AdStrategy) this.instance).getPkCfg(i);
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public int getPkCfgCount() {
                return ((AdStrategy) this.instance).getPkCfgCount();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public List<PkCfg> getPkCfgList() {
                return Collections.unmodifiableList(((AdStrategy) this.instance).getPkCfgList());
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public SdkCfg getSdkCfg(int i) {
                return ((AdStrategy) this.instance).getSdkCfg(i);
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public int getSdkCfgCount() {
                return ((AdStrategy) this.instance).getSdkCfgCount();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public List<SdkCfg> getSdkCfgList() {
                return Collections.unmodifiableList(((AdStrategy) this.instance).getSdkCfgList());
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public String getStrategyId() {
                return ((AdStrategy) this.instance).getStrategyId();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public ByteString getStrategyIdBytes() {
                return ((AdStrategy) this.instance).getStrategyIdBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public String getStrategyVer() {
                return ((AdStrategy) this.instance).getStrategyVer();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public ByteString getStrategyVerBytes() {
                return ((AdStrategy) this.instance).getStrategyVerBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public Switch getSwitch() {
                return ((AdStrategy) this.instance).getSwitch();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public int getTimeout() {
                return ((AdStrategy) this.instance).getTimeout();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public int getUpdateInterval() {
                return ((AdStrategy) this.instance).getUpdateInterval();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public int getUserType() {
                return ((AdStrategy) this.instance).getUserType();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public boolean hasCacheCfg() {
                return ((AdStrategy) this.instance).hasCacheCfg();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public boolean hasMaterialControl() {
                return ((AdStrategy) this.instance).hasMaterialControl();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public boolean hasStrategyId() {
                return ((AdStrategy) this.instance).hasStrategyId();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public boolean hasStrategyVer() {
                return ((AdStrategy) this.instance).hasStrategyVer();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public boolean hasSwitch() {
                return ((AdStrategy) this.instance).hasSwitch();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public boolean hasTimeout() {
                return ((AdStrategy) this.instance).hasTimeout();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public boolean hasUpdateInterval() {
                return ((AdStrategy) this.instance).hasUpdateInterval();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
            public boolean hasUserType() {
                return ((AdStrategy) this.instance).hasUserType();
            }

            public Builder mergeCacheCfg(CacheCfg cacheCfg) {
                copyOnWrite();
                ((AdStrategy) this.instance).mergeCacheCfg(cacheCfg);
                return this;
            }

            public Builder mergeMaterialControl(MaterialControl materialControl) {
                copyOnWrite();
                ((AdStrategy) this.instance).mergeMaterialControl(materialControl);
                return this;
            }

            public Builder mergeSwitch(Switch r2) {
                copyOnWrite();
                ((AdStrategy) this.instance).mergeSwitch(r2);
                return this;
            }

            public Builder removeGroupCfg(int i) {
                copyOnWrite();
                ((AdStrategy) this.instance).removeGroupCfg(i);
                return this;
            }

            public Builder removePkCfg(int i) {
                copyOnWrite();
                ((AdStrategy) this.instance).removePkCfg(i);
                return this;
            }

            public Builder removeSdkCfg(int i) {
                copyOnWrite();
                ((AdStrategy) this.instance).removeSdkCfg(i);
                return this;
            }

            public Builder setCacheCfg(CacheCfg cacheCfg) {
                copyOnWrite();
                ((AdStrategy) this.instance).setCacheCfg(cacheCfg);
                return this;
            }

            public Builder setGroupCfg(int i, GroupCfg groupCfg) {
                copyOnWrite();
                ((AdStrategy) this.instance).setGroupCfg(i, groupCfg);
                return this;
            }

            public Builder setMaterialControl(MaterialControl materialControl) {
                copyOnWrite();
                ((AdStrategy) this.instance).setMaterialControl(materialControl);
                return this;
            }

            public Builder setPkCfg(int i, PkCfg pkCfg) {
                copyOnWrite();
                ((AdStrategy) this.instance).setPkCfg(i, pkCfg);
                return this;
            }

            public Builder setSdkCfg(int i, SdkCfg sdkCfg) {
                copyOnWrite();
                ((AdStrategy) this.instance).setSdkCfg(i, sdkCfg);
                return this;
            }

            public Builder setStrategyId(String str) {
                copyOnWrite();
                ((AdStrategy) this.instance).setStrategyId(str);
                return this;
            }

            public Builder setStrategyIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AdStrategy) this.instance).setStrategyIdBytes(byteString);
                return this;
            }

            public Builder setStrategyVer(String str) {
                copyOnWrite();
                ((AdStrategy) this.instance).setStrategyVer(str);
                return this;
            }

            public Builder setStrategyVerBytes(ByteString byteString) {
                copyOnWrite();
                ((AdStrategy) this.instance).setStrategyVerBytes(byteString);
                return this;
            }

            public Builder setSwitch(Switch r2) {
                copyOnWrite();
                ((AdStrategy) this.instance).setSwitch(r2);
                return this;
            }

            public Builder setTimeout(int i) {
                copyOnWrite();
                ((AdStrategy) this.instance).setTimeout(i);
                return this;
            }

            public Builder setUpdateInterval(int i) {
                copyOnWrite();
                ((AdStrategy) this.instance).setUpdateInterval(i);
                return this;
            }

            public Builder setUserType(int i) {
                copyOnWrite();
                ((AdStrategy) this.instance).setUserType(i);
                return this;
            }

            private Builder() {
                super(AdStrategy.DEFAULT_INSTANCE);
            }

            public Builder addGroupCfg(int i, GroupCfg groupCfg) {
                copyOnWrite();
                ((AdStrategy) this.instance).addGroupCfg(i, groupCfg);
                return this;
            }

            public Builder addPkCfg(int i, PkCfg pkCfg) {
                copyOnWrite();
                ((AdStrategy) this.instance).addPkCfg(i, pkCfg);
                return this;
            }

            public Builder addSdkCfg(int i, SdkCfg sdkCfg) {
                copyOnWrite();
                ((AdStrategy) this.instance).addSdkCfg(i, sdkCfg);
                return this;
            }

            public Builder setCacheCfg(CacheCfg.Builder builder) {
                copyOnWrite();
                ((AdStrategy) this.instance).setCacheCfg(builder);
                return this;
            }

            public Builder setGroupCfg(int i, GroupCfg.Builder builder) {
                copyOnWrite();
                ((AdStrategy) this.instance).setGroupCfg(i, builder);
                return this;
            }

            public Builder setMaterialControl(MaterialControl.Builder builder) {
                copyOnWrite();
                ((AdStrategy) this.instance).setMaterialControl(builder);
                return this;
            }

            public Builder setPkCfg(int i, PkCfg.Builder builder) {
                copyOnWrite();
                ((AdStrategy) this.instance).setPkCfg(i, builder);
                return this;
            }

            public Builder setSdkCfg(int i, SdkCfg.Builder builder) {
                copyOnWrite();
                ((AdStrategy) this.instance).setSdkCfg(i, builder);
                return this;
            }

            public Builder setSwitch(Switch.Builder builder) {
                copyOnWrite();
                ((AdStrategy) this.instance).setSwitch(builder);
                return this;
            }

            public Builder addGroupCfg(GroupCfg.Builder builder) {
                copyOnWrite();
                ((AdStrategy) this.instance).addGroupCfg(builder);
                return this;
            }

            public Builder addPkCfg(PkCfg.Builder builder) {
                copyOnWrite();
                ((AdStrategy) this.instance).addPkCfg(builder);
                return this;
            }

            public Builder addSdkCfg(SdkCfg.Builder builder) {
                copyOnWrite();
                ((AdStrategy) this.instance).addSdkCfg(builder);
                return this;
            }

            public Builder addGroupCfg(int i, GroupCfg.Builder builder) {
                copyOnWrite();
                ((AdStrategy) this.instance).addGroupCfg(i, builder);
                return this;
            }

            public Builder addPkCfg(int i, PkCfg.Builder builder) {
                copyOnWrite();
                ((AdStrategy) this.instance).addPkCfg(i, builder);
                return this;
            }

            public Builder addSdkCfg(int i, SdkCfg.Builder builder) {
                copyOnWrite();
                ((AdStrategy) this.instance).addSdkCfg(i, builder);
                return this;
            }
        }

        static {
            AdStrategy adStrategy = new AdStrategy();
            DEFAULT_INSTANCE = adStrategy;
            adStrategy.makeImmutable();
        }

        private AdStrategy() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllGroupCfg(Iterable<? extends GroupCfg> iterable) {
            ensureGroupCfgIsMutable();
            AbstractMessageLite.addAll(iterable, this.groupCfg_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPkCfg(Iterable<? extends PkCfg> iterable) {
            ensurePkCfgIsMutable();
            AbstractMessageLite.addAll(iterable, this.pkCfg_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllSdkCfg(Iterable<? extends SdkCfg> iterable) {
            ensureSdkCfgIsMutable();
            AbstractMessageLite.addAll(iterable, this.sdkCfg_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addGroupCfg(GroupCfg groupCfg) {
            groupCfg.getClass();
            ensureGroupCfgIsMutable();
            this.groupCfg_.add(groupCfg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPkCfg(PkCfg pkCfg) {
            pkCfg.getClass();
            ensurePkCfgIsMutable();
            this.pkCfg_.add(pkCfg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSdkCfg(SdkCfg sdkCfg) {
            sdkCfg.getClass();
            ensureSdkCfgIsMutable();
            this.sdkCfg_.add(sdkCfg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCacheCfg() {
            this.cacheCfg_ = null;
            this.bitField0_ &= -33;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGroupCfg() {
            this.groupCfg_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMaterialControl() {
            this.materialControl_ = null;
            this.bitField0_ &= -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPkCfg() {
            this.pkCfg_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSdkCfg() {
            this.sdkCfg_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStrategyId() {
            this.bitField0_ &= -2;
            this.strategyId_ = getDefaultInstance().getStrategyId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStrategyVer() {
            this.bitField0_ &= -3;
            this.strategyVer_ = getDefaultInstance().getStrategyVer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSwitch() {
            this.switch_ = null;
            this.bitField0_ &= -17;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeout() {
            this.bitField0_ &= -9;
            this.timeout_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpdateInterval() {
            this.bitField0_ &= -5;
            this.updateInterval_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserType() {
            this.bitField0_ &= -129;
            this.userType_ = 0;
        }

        private void ensureGroupCfgIsMutable() {
            if (this.groupCfg_.isModifiable()) {
                return;
            }
            this.groupCfg_ = GeneratedMessageLite.mutableCopy(this.groupCfg_);
        }

        private void ensurePkCfgIsMutable() {
            if (this.pkCfg_.isModifiable()) {
                return;
            }
            this.pkCfg_ = GeneratedMessageLite.mutableCopy(this.pkCfg_);
        }

        private void ensureSdkCfgIsMutable() {
            if (this.sdkCfg_.isModifiable()) {
                return;
            }
            this.sdkCfg_ = GeneratedMessageLite.mutableCopy(this.sdkCfg_);
        }

        public static AdStrategy getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCacheCfg(CacheCfg cacheCfg) {
            CacheCfg cacheCfg2 = this.cacheCfg_;
            if (cacheCfg2 == null || cacheCfg2 == CacheCfg.getDefaultInstance()) {
                this.cacheCfg_ = cacheCfg;
            } else {
                this.cacheCfg_ = CacheCfg.newBuilder(this.cacheCfg_).mergeFrom(cacheCfg).buildPartial();
            }
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMaterialControl(MaterialControl materialControl) {
            MaterialControl materialControl2 = this.materialControl_;
            if (materialControl2 == null || materialControl2 == MaterialControl.getDefaultInstance()) {
                this.materialControl_ = materialControl;
            } else {
                this.materialControl_ = MaterialControl.newBuilder(this.materialControl_).mergeFrom(materialControl).buildPartial();
            }
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSwitch(Switch r3) {
            Switch r0 = this.switch_;
            if (r0 == null || r0 == Switch.getDefaultInstance()) {
                this.switch_ = r3;
            } else {
                this.switch_ = Switch.newBuilder(this.switch_).mergeFrom(r3).buildPartial();
            }
            this.bitField0_ |= 16;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static AdStrategy parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AdStrategy) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AdStrategy parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<AdStrategy> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeGroupCfg(int i) {
            ensureGroupCfgIsMutable();
            this.groupCfg_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePkCfg(int i) {
            ensurePkCfgIsMutable();
            this.pkCfg_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeSdkCfg(int i) {
            ensureSdkCfgIsMutable();
            this.sdkCfg_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCacheCfg(CacheCfg cacheCfg) {
            cacheCfg.getClass();
            this.cacheCfg_ = cacheCfg;
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGroupCfg(int i, GroupCfg groupCfg) {
            groupCfg.getClass();
            ensureGroupCfgIsMutable();
            this.groupCfg_.set(i, groupCfg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMaterialControl(MaterialControl materialControl) {
            materialControl.getClass();
            this.materialControl_ = materialControl;
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPkCfg(int i, PkCfg pkCfg) {
            pkCfg.getClass();
            ensurePkCfgIsMutable();
            this.pkCfg_.set(i, pkCfg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkCfg(int i, SdkCfg sdkCfg) {
            sdkCfg.getClass();
            ensureSdkCfgIsMutable();
            this.sdkCfg_.set(i, sdkCfg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrategyId(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.strategyId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrategyIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.strategyId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrategyVer(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.strategyVer_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrategyVerBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.strategyVer_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSwitch(Switch r1) {
            r1.getClass();
            this.switch_ = r1;
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeout(int i) {
            this.bitField0_ |= 8;
            this.timeout_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdateInterval(int i) {
            this.bitField0_ |= 4;
            this.updateInterval_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserType(int i) {
            this.bitField0_ |= 128;
            this.userType_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AdStrategy();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.pkCfg_.makeImmutable();
                    this.sdkCfg_.makeImmutable();
                    this.groupCfg_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    AdStrategy adStrategy = (AdStrategy) obj2;
                    this.strategyId_ = visitor.visitString(hasStrategyId(), this.strategyId_, adStrategy.hasStrategyId(), adStrategy.strategyId_);
                    this.strategyVer_ = visitor.visitString(hasStrategyVer(), this.strategyVer_, adStrategy.hasStrategyVer(), adStrategy.strategyVer_);
                    this.updateInterval_ = visitor.visitInt(hasUpdateInterval(), this.updateInterval_, adStrategy.hasUpdateInterval(), adStrategy.updateInterval_);
                    this.timeout_ = visitor.visitInt(hasTimeout(), this.timeout_, adStrategy.hasTimeout(), adStrategy.timeout_);
                    this.switch_ = (Switch) visitor.visitMessage(this.switch_, adStrategy.switch_);
                    this.pkCfg_ = visitor.visitList(this.pkCfg_, adStrategy.pkCfg_);
                    this.sdkCfg_ = visitor.visitList(this.sdkCfg_, adStrategy.sdkCfg_);
                    this.cacheCfg_ = (CacheCfg) visitor.visitMessage(this.cacheCfg_, adStrategy.cacheCfg_);
                    this.groupCfg_ = visitor.visitList(this.groupCfg_, adStrategy.groupCfg_);
                    this.materialControl_ = (MaterialControl) visitor.visitMessage(this.materialControl_, adStrategy.materialControl_);
                    this.userType_ = visitor.visitInt(hasUserType(), this.userType_, adStrategy.hasUserType(), adStrategy.userType_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= adStrategy.bitField0_;
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
                                case 82:
                                    String string = codedInputStream.readString();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.strategyId_ = string;
                                    break;
                                case 162:
                                    String string2 = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.strategyVer_ = string2;
                                    break;
                                case 240:
                                    this.bitField0_ |= 4;
                                    this.updateInterval_ = codedInputStream.readInt32();
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME /* 320 */:
                                    this.bitField0_ |= 8;
                                    this.timeout_ = codedInputStream.readInt32();
                                    break;
                                case 402:
                                    Switch.Builder builder = (this.bitField0_ & 16) == 16 ? this.switch_.toBuilder() : null;
                                    Switch r3 = (Switch) codedInputStream.readMessage(Switch.parser(), extensionRegistryLite);
                                    this.switch_ = r3;
                                    if (builder != null) {
                                        builder.mergeFrom(r3);
                                        this.switch_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 16;
                                    break;
                                case 482:
                                    if (!this.pkCfg_.isModifiable()) {
                                        this.pkCfg_ = GeneratedMessageLite.mutableCopy(this.pkCfg_);
                                    }
                                    this.pkCfg_.add(codedInputStream.readMessage(PkCfg.parser(), extensionRegistryLite));
                                    break;
                                case 562:
                                    if (!this.sdkCfg_.isModifiable()) {
                                        this.sdkCfg_ = GeneratedMessageLite.mutableCopy(this.sdkCfg_);
                                    }
                                    this.sdkCfg_.add(codedInputStream.readMessage(SdkCfg.parser(), extensionRegistryLite));
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH /* 642 */:
                                    CacheCfg.Builder builder2 = (this.bitField0_ & 32) == 32 ? this.cacheCfg_.toBuilder() : null;
                                    CacheCfg cacheCfg = (CacheCfg) codedInputStream.readMessage(CacheCfg.parser(), extensionRegistryLite);
                                    this.cacheCfg_ = cacheCfg;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(cacheCfg);
                                        this.cacheCfg_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 32;
                                    break;
                                case 722:
                                    if (!this.groupCfg_.isModifiable()) {
                                        this.groupCfg_ = GeneratedMessageLite.mutableCopy(this.groupCfg_);
                                    }
                                    this.groupCfg_.add(codedInputStream.readMessage(GroupCfg.parser(), extensionRegistryLite));
                                    break;
                                case 802:
                                    MaterialControl.Builder builder3 = (this.bitField0_ & 64) == 64 ? this.materialControl_.toBuilder() : null;
                                    MaterialControl materialControl = (MaterialControl) codedInputStream.readMessage(MaterialControl.parser(), extensionRegistryLite);
                                    this.materialControl_ = materialControl;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(materialControl);
                                        this.materialControl_ = builder3.buildPartial();
                                    }
                                    this.bitField0_ |= 64;
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE /* 880 */:
                                    this.bitField0_ |= 128;
                                    this.userType_ = codedInputStream.readInt32();
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
                        synchronized (AdStrategy.class) {
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

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public CacheCfg getCacheCfg() {
            CacheCfg cacheCfg = this.cacheCfg_;
            return cacheCfg == null ? CacheCfg.getDefaultInstance() : cacheCfg;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public GroupCfg getGroupCfg(int i) {
            return this.groupCfg_.get(i);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public int getGroupCfgCount() {
            return this.groupCfg_.size();
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public List<GroupCfg> getGroupCfgList() {
            return this.groupCfg_;
        }

        public GroupCfgOrBuilder getGroupCfgOrBuilder(int i) {
            return this.groupCfg_.get(i);
        }

        public List<? extends GroupCfgOrBuilder> getGroupCfgOrBuilderList() {
            return this.groupCfg_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public MaterialControl getMaterialControl() {
            MaterialControl materialControl = this.materialControl_;
            return materialControl == null ? MaterialControl.getDefaultInstance() : materialControl;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public PkCfg getPkCfg(int i) {
            return this.pkCfg_.get(i);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public int getPkCfgCount() {
            return this.pkCfg_.size();
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public List<PkCfg> getPkCfgList() {
            return this.pkCfg_;
        }

        public PkCfgOrBuilder getPkCfgOrBuilder(int i) {
            return this.pkCfg_.get(i);
        }

        public List<? extends PkCfgOrBuilder> getPkCfgOrBuilderList() {
            return this.pkCfg_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public SdkCfg getSdkCfg(int i) {
            return this.sdkCfg_.get(i);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public int getSdkCfgCount() {
            return this.sdkCfg_.size();
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public List<SdkCfg> getSdkCfgList() {
            return this.sdkCfg_;
        }

        public SdkCfgOrBuilder getSdkCfgOrBuilder(int i) {
            return this.sdkCfg_.get(i);
        }

        public List<? extends SdkCfgOrBuilder> getSdkCfgOrBuilderList() {
            return this.sdkCfg_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(10, getStrategyId()) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += CodedOutputStream.computeStringSize(20, getStrategyVer());
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(30, this.updateInterval_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(40, this.timeout_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(50, getSwitch());
            }
            for (int i2 = 0; i2 < this.pkCfg_.size(); i2++) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(60, this.pkCfg_.get(i2));
            }
            for (int i3 = 0; i3 < this.sdkCfg_.size(); i3++) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(70, this.sdkCfg_.get(i3));
            }
            if ((this.bitField0_ & 32) == 32) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(80, getCacheCfg());
            }
            for (int i4 = 0; i4 < this.groupCfg_.size(); i4++) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(90, this.groupCfg_.get(i4));
            }
            if ((this.bitField0_ & 64) == 64) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(100, getMaterialControl());
            }
            if ((this.bitField0_ & 128) == 128) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(110, this.userType_);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public String getStrategyId() {
            return this.strategyId_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public ByteString getStrategyIdBytes() {
            return ByteString.copyFromUtf8(this.strategyId_);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public String getStrategyVer() {
            return this.strategyVer_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public ByteString getStrategyVerBytes() {
            return ByteString.copyFromUtf8(this.strategyVer_);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public Switch getSwitch() {
            Switch r0 = this.switch_;
            return r0 == null ? Switch.getDefaultInstance() : r0;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public int getTimeout() {
            return this.timeout_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public int getUpdateInterval() {
            return this.updateInterval_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public int getUserType() {
            return this.userType_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public boolean hasCacheCfg() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public boolean hasMaterialControl() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public boolean hasStrategyId() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public boolean hasStrategyVer() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public boolean hasSwitch() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public boolean hasTimeout() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public boolean hasUpdateInterval() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyOrBuilder
        public boolean hasUserType() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(10, getStrategyId());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(20, getStrategyVer());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(30, this.updateInterval_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(40, this.timeout_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(50, getSwitch());
            }
            for (int i = 0; i < this.pkCfg_.size(); i++) {
                codedOutputStream.writeMessage(60, this.pkCfg_.get(i));
            }
            for (int i2 = 0; i2 < this.sdkCfg_.size(); i2++) {
                codedOutputStream.writeMessage(70, this.sdkCfg_.get(i2));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(80, getCacheCfg());
            }
            for (int i3 = 0; i3 < this.groupCfg_.size(); i3++) {
                codedOutputStream.writeMessage(90, this.groupCfg_.get(i3));
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeMessage(100, getMaterialControl());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(110, this.userType_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(AdStrategy adStrategy) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(adStrategy);
        }

        public static AdStrategy parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdStrategy) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AdStrategy parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AdStrategy parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addGroupCfg(int i, GroupCfg groupCfg) {
            groupCfg.getClass();
            ensureGroupCfgIsMutable();
            this.groupCfg_.add(i, groupCfg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPkCfg(int i, PkCfg pkCfg) {
            pkCfg.getClass();
            ensurePkCfgIsMutable();
            this.pkCfg_.add(i, pkCfg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSdkCfg(int i, SdkCfg sdkCfg) {
            sdkCfg.getClass();
            ensureSdkCfgIsMutable();
            this.sdkCfg_.add(i, sdkCfg);
        }

        public static AdStrategy parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCacheCfg(CacheCfg.Builder builder) {
            this.cacheCfg_ = builder.build();
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGroupCfg(int i, GroupCfg.Builder builder) {
            ensureGroupCfgIsMutable();
            this.groupCfg_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMaterialControl(MaterialControl.Builder builder) {
            this.materialControl_ = builder.build();
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPkCfg(int i, PkCfg.Builder builder) {
            ensurePkCfgIsMutable();
            this.pkCfg_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkCfg(int i, SdkCfg.Builder builder) {
            ensureSdkCfgIsMutable();
            this.sdkCfg_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSwitch(Switch.Builder builder) {
            this.switch_ = builder.build();
            this.bitField0_ |= 16;
        }

        public static AdStrategy parseFrom(InputStream inputStream) throws IOException {
            return (AdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AdStrategy parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addGroupCfg(GroupCfg.Builder builder) {
            ensureGroupCfgIsMutable();
            this.groupCfg_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPkCfg(PkCfg.Builder builder) {
            ensurePkCfgIsMutable();
            this.pkCfg_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSdkCfg(SdkCfg.Builder builder) {
            ensureSdkCfgIsMutable();
            this.sdkCfg_.add(builder.build());
        }

        public static AdStrategy parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AdStrategy parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addGroupCfg(int i, GroupCfg.Builder builder) {
            ensureGroupCfgIsMutable();
            this.groupCfg_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPkCfg(int i, PkCfg.Builder builder) {
            ensurePkCfgIsMutable();
            this.pkCfg_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSdkCfg(int i, SdkCfg.Builder builder) {
            ensureSdkCfgIsMutable();
            this.sdkCfg_.add(i, builder.build());
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
        private AdStrategy strategy_;
        private String appid_ = "";
        private String adUnitId_ = "";
        private String taichi_ = "";

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

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public String getAdUnitId() {
                return ((AdStrategyData) this.instance).getAdUnitId();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public ByteString getAdUnitIdBytes() {
                return ((AdStrategyData) this.instance).getAdUnitIdBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public String getAppid() {
                return ((AdStrategyData) this.instance).getAppid();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public ByteString getAppidBytes() {
                return ((AdStrategyData) this.instance).getAppidBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public int getScene() {
                return ((AdStrategyData) this.instance).getScene();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public AdStrategy getStrategy() {
                return ((AdStrategyData) this.instance).getStrategy();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public String getTaichi() {
                return ((AdStrategyData) this.instance).getTaichi();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public ByteString getTaichiBytes() {
                return ((AdStrategyData) this.instance).getTaichiBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public boolean hasAdUnitId() {
                return ((AdStrategyData) this.instance).hasAdUnitId();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public boolean hasAppid() {
                return ((AdStrategyData) this.instance).hasAppid();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public boolean hasScene() {
                return ((AdStrategyData) this.instance).hasScene();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public boolean hasStrategy() {
                return ((AdStrategyData) this.instance).hasStrategy();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
            public boolean hasTaichi() {
                return ((AdStrategyData) this.instance).hasTaichi();
            }

            public Builder mergeStrategy(AdStrategy adStrategy) {
                copyOnWrite();
                ((AdStrategyData) this.instance).mergeStrategy(adStrategy);
                return this;
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

            public Builder setStrategy(AdStrategy adStrategy) {
                copyOnWrite();
                ((AdStrategyData) this.instance).setStrategy(adStrategy);
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

            public Builder setStrategy(AdStrategy.Builder builder) {
                copyOnWrite();
                ((AdStrategyData) this.instance).setStrategy(builder);
                return this;
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
            this.strategy_ = null;
            this.bitField0_ &= -17;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaichi() {
            this.bitField0_ &= -9;
            this.taichi_ = getDefaultInstance().getTaichi();
        }

        public static AdStrategyData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeStrategy(AdStrategy adStrategy) {
            AdStrategy adStrategy2 = this.strategy_;
            if (adStrategy2 == null || adStrategy2 == AdStrategy.getDefaultInstance()) {
                this.strategy_ = adStrategy;
            } else {
                this.strategy_ = AdStrategy.newBuilder(this.strategy_).mergeFrom(adStrategy).buildPartial();
            }
            this.bitField0_ |= 16;
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
        public void setStrategy(AdStrategy adStrategy) {
            adStrategy.getClass();
            this.strategy_ = adStrategy;
            this.bitField0_ |= 16;
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
                    this.strategy_ = (AdStrategy) visitor.visitMessage(this.strategy_, adStrategyData.strategy_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= adStrategyData.bitField0_;
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
                                    AdStrategy.Builder builder = (this.bitField0_ & 16) == 16 ? this.strategy_.toBuilder() : null;
                                    AdStrategy adStrategy = (AdStrategy) codedInputStream.readMessage(AdStrategy.parser(), extensionRegistryLite);
                                    this.strategy_ = adStrategy;
                                    if (builder != null) {
                                        builder.mergeFrom(adStrategy);
                                        this.strategy_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 16;
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

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
        public String getAdUnitId() {
            return this.adUnitId_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
        public ByteString getAdUnitIdBytes() {
            return ByteString.copyFromUtf8(this.adUnitId_);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
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
                iComputeStringSize += CodedOutputStream.computeMessageSize(5, getStrategy());
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
        public AdStrategy getStrategy() {
            AdStrategy adStrategy = this.strategy_;
            return adStrategy == null ? AdStrategy.getDefaultInstance() : adStrategy;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
        public String getTaichi() {
            return this.taichi_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
        public ByteString getTaichiBytes() {
            return ByteString.copyFromUtf8(this.taichi_);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
        public boolean hasAdUnitId() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
        public boolean hasAppid() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
        public boolean hasScene() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
        public boolean hasStrategy() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AdStrategyDataOrBuilder
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
                codedOutputStream.writeMessage(5, getStrategy());
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrategy(AdStrategy.Builder builder) {
            this.strategy_ = builder.build();
            this.bitField0_ |= 16;
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

        AdStrategy getStrategy();

        String getTaichi();

        ByteString getTaichiBytes();

        boolean hasAdUnitId();

        boolean hasAppid();

        boolean hasScene();

        boolean hasStrategy();

        boolean hasTaichi();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AdStrategyOrBuilder extends MessageLiteOrBuilder {
        CacheCfg getCacheCfg();

        GroupCfg getGroupCfg(int i);

        int getGroupCfgCount();

        List<GroupCfg> getGroupCfgList();

        MaterialControl getMaterialControl();

        PkCfg getPkCfg(int i);

        int getPkCfgCount();

        List<PkCfg> getPkCfgList();

        SdkCfg getSdkCfg(int i);

        int getSdkCfgCount();

        List<SdkCfg> getSdkCfgList();

        String getStrategyId();

        ByteString getStrategyIdBytes();

        String getStrategyVer();

        ByteString getStrategyVerBytes();

        Switch getSwitch();

        int getTimeout();

        int getUpdateInterval();

        int getUserType();

        boolean hasCacheCfg();

        boolean hasMaterialControl();

        boolean hasStrategyId();

        boolean hasStrategyVer();

        boolean hasSwitch();

        boolean hasTimeout();

        boolean hasUpdateInterval();

        boolean hasUserType();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class AllStrategiesResponse extends GeneratedMessageLite<AllStrategiesResponse, Builder> implements AllStrategiesResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int DATA_FIELD_NUMBER = 5;
        private static final AllStrategiesResponse DEFAULT_INSTANCE;
        public static final int EXPIDS_FIELD_NUMBER = 7;
        public static final int MSG_FIELD_NUMBER = 2;
        private static volatile Parser<AllStrategiesResponse> PARSER = null;
        public static final int REQUESTID_FIELD_NUMBER = 3;
        public static final int UPDATE_INTERVAL_FIELD_NUMBER = 6;
        private int bitField0_;
        private int code_;
        private int updateInterval_;
        private String msg_ = "";
        private String requestid_ = "";
        private Internal.ProtobufList<AdStrategyData> data_ = GeneratedMessageLite.emptyProtobufList();
        private String expids_ = "";

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

            public Builder clearExpids() {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).clearExpids();
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

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public int getCode() {
                return ((AllStrategiesResponse) this.instance).getCode();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public AdStrategyData getData(int i) {
                return ((AllStrategiesResponse) this.instance).getData(i);
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public int getDataCount() {
                return ((AllStrategiesResponse) this.instance).getDataCount();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public List<AdStrategyData> getDataList() {
                return Collections.unmodifiableList(((AllStrategiesResponse) this.instance).getDataList());
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public String getExpids() {
                return ((AllStrategiesResponse) this.instance).getExpids();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public ByteString getExpidsBytes() {
                return ((AllStrategiesResponse) this.instance).getExpidsBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public String getMsg() {
                return ((AllStrategiesResponse) this.instance).getMsg();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public ByteString getMsgBytes() {
                return ((AllStrategiesResponse) this.instance).getMsgBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public String getRequestid() {
                return ((AllStrategiesResponse) this.instance).getRequestid();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public ByteString getRequestidBytes() {
                return ((AllStrategiesResponse) this.instance).getRequestidBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public int getUpdateInterval() {
                return ((AllStrategiesResponse) this.instance).getUpdateInterval();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public boolean hasCode() {
                return ((AllStrategiesResponse) this.instance).hasCode();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public boolean hasExpids() {
                return ((AllStrategiesResponse) this.instance).hasExpids();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public boolean hasMsg() {
                return ((AllStrategiesResponse) this.instance).hasMsg();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
            public boolean hasRequestid() {
                return ((AllStrategiesResponse) this.instance).hasRequestid();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
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

            public Builder setExpids(String str) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).setExpids(str);
                return this;
            }

            public Builder setExpidsBytes(ByteString byteString) {
                copyOnWrite();
                ((AllStrategiesResponse) this.instance).setExpidsBytes(byteString);
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
        public void clearExpids() {
            this.bitField0_ &= -17;
            this.expids_ = getDefaultInstance().getExpids();
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
        public void setExpids(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.expids_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExpidsBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.expids_ = byteString.toStringUtf8();
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
                    this.expids_ = visitor.visitString(hasExpids(), this.expids_, allStrategiesResponse.hasExpids(), allStrategiesResponse.expids_);
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
                                } else if (tag == 42) {
                                    if (!this.data_.isModifiable()) {
                                        this.data_ = GeneratedMessageLite.mutableCopy(this.data_);
                                    }
                                    this.data_.add(codedInputStream.readMessage(AdStrategyData.parser(), extensionRegistryLite));
                                } else if (tag == 48) {
                                    this.bitField0_ |= 8;
                                    this.updateInterval_ = codedInputStream.readInt32();
                                } else if (tag == 58) {
                                    String string3 = codedInputStream.readString();
                                    this.bitField0_ |= 16;
                                    this.expids_ = string3;
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

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public AdStrategyData getData(int i) {
            return this.data_.get(i);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public int getDataCount() {
            return this.data_.size();
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public List<AdStrategyData> getDataList() {
            return this.data_;
        }

        public AdStrategyDataOrBuilder getDataOrBuilder(int i) {
            return this.data_.get(i);
        }

        public List<? extends AdStrategyDataOrBuilder> getDataOrBuilderList() {
            return this.data_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public String getExpids() {
            return this.expids_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public ByteString getExpidsBytes() {
            return ByteString.copyFromUtf8(this.expids_);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public String getMsg() {
            return this.msg_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public ByteString getMsgBytes() {
            return ByteString.copyFromUtf8(this.msg_);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public String getRequestid() {
            return this.requestid_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
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
                iComputeInt32Size += CodedOutputStream.computeMessageSize(5, this.data_.get(i2));
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(6, this.updateInterval_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(7, getExpids());
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public int getUpdateInterval() {
            return this.updateInterval_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public boolean hasCode() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public boolean hasExpids() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public boolean hasMsg() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
        public boolean hasRequestid() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.AllStrategiesResponseOrBuilder
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
                codedOutputStream.writeMessage(5, this.data_.get(i));
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(6, this.updateInterval_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeString(7, getExpids());
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

        String getExpids();

        ByteString getExpidsBytes();

        String getMsg();

        ByteString getMsgBytes();

        String getRequestid();

        ByteString getRequestidBytes();

        int getUpdateInterval();

        boolean hasCode();

        boolean hasExpids();

        boolean hasMsg();

        boolean hasRequestid();

        boolean hasUpdateInterval();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class CacheCfg extends GeneratedMessageLite<CacheCfg, Builder> implements CacheCfgOrBuilder {
        private static final CacheCfg DEFAULT_INSTANCE;
        private static volatile Parser<CacheCfg> PARSER = null;
        public static final int QUEUE_LEN_FIELD_NUMBER = 1;
        private int bitField0_;
        private int queueLen_;

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<CacheCfg, Builder> implements CacheCfgOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearQueueLen() {
                copyOnWrite();
                ((CacheCfg) this.instance).clearQueueLen();
                return this;
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.CacheCfgOrBuilder
            public int getQueueLen() {
                return ((CacheCfg) this.instance).getQueueLen();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.CacheCfgOrBuilder
            public boolean hasQueueLen() {
                return ((CacheCfg) this.instance).hasQueueLen();
            }

            public Builder setQueueLen(int i) {
                copyOnWrite();
                ((CacheCfg) this.instance).setQueueLen(i);
                return this;
            }

            private Builder() {
                super(CacheCfg.DEFAULT_INSTANCE);
            }
        }

        static {
            CacheCfg cacheCfg = new CacheCfg();
            DEFAULT_INSTANCE = cacheCfg;
            cacheCfg.makeImmutable();
        }

        private CacheCfg() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQueueLen() {
            this.bitField0_ &= -2;
            this.queueLen_ = 0;
        }

        public static CacheCfg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CacheCfg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CacheCfg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CacheCfg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CacheCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<CacheCfg> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQueueLen(int i) {
            this.bitField0_ |= 1;
            this.queueLen_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CacheCfg();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CacheCfg cacheCfg = (CacheCfg) obj2;
                    this.queueLen_ = visitor.visitInt(hasQueueLen(), this.queueLen_, cacheCfg.hasQueueLen(), cacheCfg.queueLen_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= cacheCfg.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.bitField0_ |= 1;
                                    this.queueLen_ = codedInputStream.readInt32();
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
                        synchronized (CacheCfg.class) {
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

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.CacheCfgOrBuilder
        public int getQueueLen() {
            return this.queueLen_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = ((this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.queueLen_) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = iComputeInt32Size;
            return iComputeInt32Size;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.CacheCfgOrBuilder
        public boolean hasQueueLen() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.queueLen_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(CacheCfg cacheCfg) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cacheCfg);
        }

        public static CacheCfg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CacheCfg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CacheCfg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CacheCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CacheCfg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CacheCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CacheCfg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CacheCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CacheCfg parseFrom(InputStream inputStream) throws IOException {
            return (CacheCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CacheCfg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CacheCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CacheCfg parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CacheCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CacheCfg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CacheCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CacheCfgOrBuilder extends MessageLiteOrBuilder {
        int getQueueLen();

        boolean hasQueueLen();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class DspWeight extends GeneratedMessageLite<DspWeight, Builder> implements DspWeightOrBuilder {
        private static final DspWeight DEFAULT_INSTANCE;
        public static final int DSPNAME_FIELD_NUMBER = 1;
        private static volatile Parser<DspWeight> PARSER = null;
        public static final int WEIGHT_FIELD_NUMBER = 2;
        private int bitField0_;
        private String dspname_ = "";
        private int weight_;

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<DspWeight, Builder> implements DspWeightOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDspname() {
                copyOnWrite();
                ((DspWeight) this.instance).clearDspname();
                return this;
            }

            public Builder clearWeight() {
                copyOnWrite();
                ((DspWeight) this.instance).clearWeight();
                return this;
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.DspWeightOrBuilder
            public String getDspname() {
                return ((DspWeight) this.instance).getDspname();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.DspWeightOrBuilder
            public ByteString getDspnameBytes() {
                return ((DspWeight) this.instance).getDspnameBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.DspWeightOrBuilder
            public int getWeight() {
                return ((DspWeight) this.instance).getWeight();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.DspWeightOrBuilder
            public boolean hasDspname() {
                return ((DspWeight) this.instance).hasDspname();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.DspWeightOrBuilder
            public boolean hasWeight() {
                return ((DspWeight) this.instance).hasWeight();
            }

            public Builder setDspname(String str) {
                copyOnWrite();
                ((DspWeight) this.instance).setDspname(str);
                return this;
            }

            public Builder setDspnameBytes(ByteString byteString) {
                copyOnWrite();
                ((DspWeight) this.instance).setDspnameBytes(byteString);
                return this;
            }

            public Builder setWeight(int i) {
                copyOnWrite();
                ((DspWeight) this.instance).setWeight(i);
                return this;
            }

            private Builder() {
                super(DspWeight.DEFAULT_INSTANCE);
            }
        }

        static {
            DspWeight dspWeight = new DspWeight();
            DEFAULT_INSTANCE = dspWeight;
            dspWeight.makeImmutable();
        }

        private DspWeight() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDspname() {
            this.bitField0_ &= -2;
            this.dspname_ = getDefaultInstance().getDspname();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWeight() {
            this.bitField0_ &= -3;
            this.weight_ = 0;
        }

        public static DspWeight getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DspWeight parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DspWeight) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DspWeight parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DspWeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<DspWeight> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDspname(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.dspname_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDspnameBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.dspname_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWeight(int i) {
            this.bitField0_ |= 2;
            this.weight_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DspWeight();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    DspWeight dspWeight = (DspWeight) obj2;
                    this.dspname_ = visitor.visitString(hasDspname(), this.dspname_, dspWeight.hasDspname(), dspWeight.dspname_);
                    this.weight_ = visitor.visitInt(hasWeight(), this.weight_, dspWeight.hasWeight(), dspWeight.weight_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= dspWeight.bitField0_;
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
                                    this.dspname_ = string;
                                } else if (tag == 16) {
                                    this.bitField0_ |= 2;
                                    this.weight_ = codedInputStream.readInt32();
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
                        synchronized (DspWeight.class) {
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

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.DspWeightOrBuilder
        public String getDspname() {
            return this.dspname_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.DspWeightOrBuilder
        public ByteString getDspnameBytes() {
            return ByteString.copyFromUtf8(this.dspname_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getDspname()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(2, this.weight_);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.DspWeightOrBuilder
        public int getWeight() {
            return this.weight_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.DspWeightOrBuilder
        public boolean hasDspname() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.DspWeightOrBuilder
        public boolean hasWeight() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getDspname());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.weight_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(DspWeight dspWeight) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(dspWeight);
        }

        public static DspWeight parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DspWeight) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DspWeight parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DspWeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DspWeight parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DspWeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DspWeight parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DspWeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DspWeight parseFrom(InputStream inputStream) throws IOException {
            return (DspWeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DspWeight parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DspWeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DspWeight parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DspWeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DspWeight parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DspWeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface DspWeightOrBuilder extends MessageLiteOrBuilder {
        String getDspname();

        ByteString getDspnameBytes();

        int getWeight();

        boolean hasDspname();

        boolean hasWeight();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class GroupCfg extends GeneratedMessageLite<GroupCfg, Builder> implements GroupCfgOrBuilder {
        private static final GroupCfg DEFAULT_INSTANCE;
        public static final int GROUP_MAXPRICE_FIELD_NUMBER = 3;
        public static final int GROUP_MINPRICE_FIELD_NUMBER = 2;
        public static final int GROUP_TIMEOUT_FIELD_NUMBER = 4;
        private static volatile Parser<GroupCfg> PARSER = null;
        public static final int SLOT_CFG_FIELD_NUMBER = 1;
        private int bitField0_;
        private int groupMaxprice_;
        private int groupMinprice_;
        private int groupTimeout_;
        private Internal.ProtobufList<SlotCfg> slotCfg_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<GroupCfg, Builder> implements GroupCfgOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllSlotCfg(Iterable<? extends SlotCfg> iterable) {
                copyOnWrite();
                ((GroupCfg) this.instance).addAllSlotCfg(iterable);
                return this;
            }

            public Builder addSlotCfg(SlotCfg slotCfg) {
                copyOnWrite();
                ((GroupCfg) this.instance).addSlotCfg(slotCfg);
                return this;
            }

            public Builder clearGroupMaxprice() {
                copyOnWrite();
                ((GroupCfg) this.instance).clearGroupMaxprice();
                return this;
            }

            public Builder clearGroupMinprice() {
                copyOnWrite();
                ((GroupCfg) this.instance).clearGroupMinprice();
                return this;
            }

            public Builder clearGroupTimeout() {
                copyOnWrite();
                ((GroupCfg) this.instance).clearGroupTimeout();
                return this;
            }

            public Builder clearSlotCfg() {
                copyOnWrite();
                ((GroupCfg) this.instance).clearSlotCfg();
                return this;
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
            public int getGroupMaxprice() {
                return ((GroupCfg) this.instance).getGroupMaxprice();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
            public int getGroupMinprice() {
                return ((GroupCfg) this.instance).getGroupMinprice();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
            public int getGroupTimeout() {
                return ((GroupCfg) this.instance).getGroupTimeout();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
            public SlotCfg getSlotCfg(int i) {
                return ((GroupCfg) this.instance).getSlotCfg(i);
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
            public int getSlotCfgCount() {
                return ((GroupCfg) this.instance).getSlotCfgCount();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
            public List<SlotCfg> getSlotCfgList() {
                return Collections.unmodifiableList(((GroupCfg) this.instance).getSlotCfgList());
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
            public boolean hasGroupMaxprice() {
                return ((GroupCfg) this.instance).hasGroupMaxprice();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
            public boolean hasGroupMinprice() {
                return ((GroupCfg) this.instance).hasGroupMinprice();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
            public boolean hasGroupTimeout() {
                return ((GroupCfg) this.instance).hasGroupTimeout();
            }

            public Builder removeSlotCfg(int i) {
                copyOnWrite();
                ((GroupCfg) this.instance).removeSlotCfg(i);
                return this;
            }

            public Builder setGroupMaxprice(int i) {
                copyOnWrite();
                ((GroupCfg) this.instance).setGroupMaxprice(i);
                return this;
            }

            public Builder setGroupMinprice(int i) {
                copyOnWrite();
                ((GroupCfg) this.instance).setGroupMinprice(i);
                return this;
            }

            public Builder setGroupTimeout(int i) {
                copyOnWrite();
                ((GroupCfg) this.instance).setGroupTimeout(i);
                return this;
            }

            public Builder setSlotCfg(int i, SlotCfg slotCfg) {
                copyOnWrite();
                ((GroupCfg) this.instance).setSlotCfg(i, slotCfg);
                return this;
            }

            private Builder() {
                super(GroupCfg.DEFAULT_INSTANCE);
            }

            public Builder addSlotCfg(int i, SlotCfg slotCfg) {
                copyOnWrite();
                ((GroupCfg) this.instance).addSlotCfg(i, slotCfg);
                return this;
            }

            public Builder setSlotCfg(int i, SlotCfg.Builder builder) {
                copyOnWrite();
                ((GroupCfg) this.instance).setSlotCfg(i, builder);
                return this;
            }

            public Builder addSlotCfg(SlotCfg.Builder builder) {
                copyOnWrite();
                ((GroupCfg) this.instance).addSlotCfg(builder);
                return this;
            }

            public Builder addSlotCfg(int i, SlotCfg.Builder builder) {
                copyOnWrite();
                ((GroupCfg) this.instance).addSlotCfg(i, builder);
                return this;
            }
        }

        static {
            GroupCfg groupCfg = new GroupCfg();
            DEFAULT_INSTANCE = groupCfg;
            groupCfg.makeImmutable();
        }

        private GroupCfg() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllSlotCfg(Iterable<? extends SlotCfg> iterable) {
            ensureSlotCfgIsMutable();
            AbstractMessageLite.addAll(iterable, this.slotCfg_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSlotCfg(SlotCfg slotCfg) {
            slotCfg.getClass();
            ensureSlotCfgIsMutable();
            this.slotCfg_.add(slotCfg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGroupMaxprice() {
            this.bitField0_ &= -3;
            this.groupMaxprice_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGroupMinprice() {
            this.bitField0_ &= -2;
            this.groupMinprice_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGroupTimeout() {
            this.bitField0_ &= -5;
            this.groupTimeout_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSlotCfg() {
            this.slotCfg_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureSlotCfgIsMutable() {
            if (this.slotCfg_.isModifiable()) {
                return;
            }
            this.slotCfg_ = GeneratedMessageLite.mutableCopy(this.slotCfg_);
        }

        public static GroupCfg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static GroupCfg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GroupCfg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GroupCfg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GroupCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<GroupCfg> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeSlotCfg(int i) {
            ensureSlotCfgIsMutable();
            this.slotCfg_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGroupMaxprice(int i) {
            this.bitField0_ |= 2;
            this.groupMaxprice_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGroupMinprice(int i) {
            this.bitField0_ |= 1;
            this.groupMinprice_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGroupTimeout(int i) {
            this.bitField0_ |= 4;
            this.groupTimeout_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSlotCfg(int i, SlotCfg slotCfg) {
            slotCfg.getClass();
            ensureSlotCfgIsMutable();
            this.slotCfg_.set(i, slotCfg);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new GroupCfg();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.slotCfg_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    GroupCfg groupCfg = (GroupCfg) obj2;
                    this.slotCfg_ = visitor.visitList(this.slotCfg_, groupCfg.slotCfg_);
                    this.groupMinprice_ = visitor.visitInt(hasGroupMinprice(), this.groupMinprice_, groupCfg.hasGroupMinprice(), groupCfg.groupMinprice_);
                    this.groupMaxprice_ = visitor.visitInt(hasGroupMaxprice(), this.groupMaxprice_, groupCfg.hasGroupMaxprice(), groupCfg.groupMaxprice_);
                    this.groupTimeout_ = visitor.visitInt(hasGroupTimeout(), this.groupTimeout_, groupCfg.hasGroupTimeout(), groupCfg.groupTimeout_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= groupCfg.bitField0_;
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
                                if (tag == 10) {
                                    if (!this.slotCfg_.isModifiable()) {
                                        this.slotCfg_ = GeneratedMessageLite.mutableCopy(this.slotCfg_);
                                    }
                                    this.slotCfg_.add(codedInputStream.readMessage(SlotCfg.parser(), extensionRegistryLite));
                                } else if (tag == 16) {
                                    this.bitField0_ |= 1;
                                    this.groupMinprice_ = codedInputStream.readInt32();
                                } else if (tag == 24) {
                                    this.bitField0_ |= 2;
                                    this.groupMaxprice_ = codedInputStream.readInt32();
                                } else if (tag == 32) {
                                    this.bitField0_ |= 4;
                                    this.groupTimeout_ = codedInputStream.readInt32();
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
                        synchronized (GroupCfg.class) {
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

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
        public int getGroupMaxprice() {
            return this.groupMaxprice_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
        public int getGroupMinprice() {
            return this.groupMinprice_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
        public int getGroupTimeout() {
            return this.groupTimeout_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = 0;
            for (int i2 = 0; i2 < this.slotCfg_.size(); i2++) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(1, this.slotCfg_.get(i2));
            }
            if ((this.bitField0_ & 1) == 1) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.groupMinprice_);
            }
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, this.groupMaxprice_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(4, this.groupTimeout_);
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
        public SlotCfg getSlotCfg(int i) {
            return this.slotCfg_.get(i);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
        public int getSlotCfgCount() {
            return this.slotCfg_.size();
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
        public List<SlotCfg> getSlotCfgList() {
            return this.slotCfg_;
        }

        public SlotCfgOrBuilder getSlotCfgOrBuilder(int i) {
            return this.slotCfg_.get(i);
        }

        public List<? extends SlotCfgOrBuilder> getSlotCfgOrBuilderList() {
            return this.slotCfg_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
        public boolean hasGroupMaxprice() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
        public boolean hasGroupMinprice() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.GroupCfgOrBuilder
        public boolean hasGroupTimeout() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.slotCfg_.size(); i++) {
                codedOutputStream.writeMessage(1, this.slotCfg_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(2, this.groupMinprice_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(3, this.groupMaxprice_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(4, this.groupTimeout_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(GroupCfg groupCfg) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(groupCfg);
        }

        public static GroupCfg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GroupCfg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GroupCfg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GroupCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GroupCfg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GroupCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSlotCfg(int i, SlotCfg slotCfg) {
            slotCfg.getClass();
            ensureSlotCfgIsMutable();
            this.slotCfg_.add(i, slotCfg);
        }

        public static GroupCfg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GroupCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSlotCfg(int i, SlotCfg.Builder builder) {
            ensureSlotCfgIsMutable();
            this.slotCfg_.set(i, builder.build());
        }

        public static GroupCfg parseFrom(InputStream inputStream) throws IOException {
            return (GroupCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GroupCfg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GroupCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSlotCfg(SlotCfg.Builder builder) {
            ensureSlotCfgIsMutable();
            this.slotCfg_.add(builder.build());
        }

        public static GroupCfg parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GroupCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GroupCfg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GroupCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSlotCfg(int i, SlotCfg.Builder builder) {
            ensureSlotCfgIsMutable();
            this.slotCfg_.add(i, builder.build());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface GroupCfgOrBuilder extends MessageLiteOrBuilder {
        int getGroupMaxprice();

        int getGroupMinprice();

        int getGroupTimeout();

        SlotCfg getSlotCfg(int i);

        int getSlotCfgCount();

        List<SlotCfg> getSlotCfgList();

        boolean hasGroupMaxprice();

        boolean hasGroupMinprice();

        boolean hasGroupTimeout();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class MaterialControl extends GeneratedMessageLite<MaterialControl, Builder> implements MaterialControlOrBuilder {
        private static final MaterialControl DEFAULT_INSTANCE;
        public static final int FREQUENCY_PV_FIELD_NUMBER = 3;
        public static final int FREQUENCY_TIME_FIELD_NUMBER = 2;
        private static volatile Parser<MaterialControl> PARSER = null;
        public static final int URL_PREFIX_FIELD_NUMBER = 1;
        private int bitField0_;
        private int frequencyPv_;
        private int frequencyTime_;
        private Internal.ProtobufList<String> urlPrefix_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<MaterialControl, Builder> implements MaterialControlOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUrlPrefix(Iterable<String> iterable) {
                copyOnWrite();
                ((MaterialControl) this.instance).addAllUrlPrefix(iterable);
                return this;
            }

            public Builder addUrlPrefix(String str) {
                copyOnWrite();
                ((MaterialControl) this.instance).addUrlPrefix(str);
                return this;
            }

            public Builder addUrlPrefixBytes(ByteString byteString) {
                copyOnWrite();
                ((MaterialControl) this.instance).addUrlPrefixBytes(byteString);
                return this;
            }

            public Builder clearFrequencyPv() {
                copyOnWrite();
                ((MaterialControl) this.instance).clearFrequencyPv();
                return this;
            }

            public Builder clearFrequencyTime() {
                copyOnWrite();
                ((MaterialControl) this.instance).clearFrequencyTime();
                return this;
            }

            public Builder clearUrlPrefix() {
                copyOnWrite();
                ((MaterialControl) this.instance).clearUrlPrefix();
                return this;
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
            public int getFrequencyPv() {
                return ((MaterialControl) this.instance).getFrequencyPv();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
            public int getFrequencyTime() {
                return ((MaterialControl) this.instance).getFrequencyTime();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
            public String getUrlPrefix(int i) {
                return ((MaterialControl) this.instance).getUrlPrefix(i);
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
            public ByteString getUrlPrefixBytes(int i) {
                return ((MaterialControl) this.instance).getUrlPrefixBytes(i);
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
            public int getUrlPrefixCount() {
                return ((MaterialControl) this.instance).getUrlPrefixCount();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
            public List<String> getUrlPrefixList() {
                return Collections.unmodifiableList(((MaterialControl) this.instance).getUrlPrefixList());
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
            public boolean hasFrequencyPv() {
                return ((MaterialControl) this.instance).hasFrequencyPv();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
            public boolean hasFrequencyTime() {
                return ((MaterialControl) this.instance).hasFrequencyTime();
            }

            public Builder setFrequencyPv(int i) {
                copyOnWrite();
                ((MaterialControl) this.instance).setFrequencyPv(i);
                return this;
            }

            public Builder setFrequencyTime(int i) {
                copyOnWrite();
                ((MaterialControl) this.instance).setFrequencyTime(i);
                return this;
            }

            public Builder setUrlPrefix(int i, String str) {
                copyOnWrite();
                ((MaterialControl) this.instance).setUrlPrefix(i, str);
                return this;
            }

            private Builder() {
                super(MaterialControl.DEFAULT_INSTANCE);
            }
        }

        static {
            MaterialControl materialControl = new MaterialControl();
            DEFAULT_INSTANCE = materialControl;
            materialControl.makeImmutable();
        }

        private MaterialControl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUrlPrefix(Iterable<String> iterable) {
            ensureUrlPrefixIsMutable();
            AbstractMessageLite.addAll(iterable, this.urlPrefix_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUrlPrefix(String str) {
            str.getClass();
            ensureUrlPrefixIsMutable();
            this.urlPrefix_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUrlPrefixBytes(ByteString byteString) {
            byteString.getClass();
            ensureUrlPrefixIsMutable();
            this.urlPrefix_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFrequencyPv() {
            this.bitField0_ &= -3;
            this.frequencyPv_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFrequencyTime() {
            this.bitField0_ &= -2;
            this.frequencyTime_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUrlPrefix() {
            this.urlPrefix_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureUrlPrefixIsMutable() {
            if (this.urlPrefix_.isModifiable()) {
                return;
            }
            this.urlPrefix_ = GeneratedMessageLite.mutableCopy(this.urlPrefix_);
        }

        public static MaterialControl getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static MaterialControl parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MaterialControl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MaterialControl parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MaterialControl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<MaterialControl> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFrequencyPv(int i) {
            this.bitField0_ |= 2;
            this.frequencyPv_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFrequencyTime(int i) {
            this.bitField0_ |= 1;
            this.frequencyTime_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUrlPrefix(int i, String str) {
            str.getClass();
            ensureUrlPrefixIsMutable();
            this.urlPrefix_.set(i, str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new MaterialControl();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.urlPrefix_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MaterialControl materialControl = (MaterialControl) obj2;
                    this.urlPrefix_ = visitor.visitList(this.urlPrefix_, materialControl.urlPrefix_);
                    this.frequencyTime_ = visitor.visitInt(hasFrequencyTime(), this.frequencyTime_, materialControl.hasFrequencyTime(), materialControl.frequencyTime_);
                    this.frequencyPv_ = visitor.visitInt(hasFrequencyPv(), this.frequencyPv_, materialControl.hasFrequencyPv(), materialControl.frequencyPv_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= materialControl.bitField0_;
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
                                    if (!this.urlPrefix_.isModifiable()) {
                                        this.urlPrefix_ = GeneratedMessageLite.mutableCopy(this.urlPrefix_);
                                    }
                                    this.urlPrefix_.add(string);
                                } else if (tag == 16) {
                                    this.bitField0_ |= 1;
                                    this.frequencyTime_ = codedInputStream.readInt32();
                                } else if (tag == 24) {
                                    this.bitField0_ |= 2;
                                    this.frequencyPv_ = codedInputStream.readInt32();
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
                        synchronized (MaterialControl.class) {
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

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
        public int getFrequencyPv() {
            return this.frequencyPv_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
        public int getFrequencyTime() {
            return this.frequencyTime_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSizeNoTag = 0;
            for (int i2 = 0; i2 < this.urlPrefix_.size(); i2++) {
                iComputeStringSizeNoTag += CodedOutputStream.computeStringSizeNoTag(this.urlPrefix_.get(i2));
            }
            int size = 0 + iComputeStringSizeNoTag + (getUrlPrefixList().size() * 1);
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(2, this.frequencyTime_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(3, this.frequencyPv_);
            }
            int serializedSize = size + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
        public String getUrlPrefix(int i) {
            return this.urlPrefix_.get(i);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
        public ByteString getUrlPrefixBytes(int i) {
            return ByteString.copyFromUtf8(this.urlPrefix_.get(i));
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
        public int getUrlPrefixCount() {
            return this.urlPrefix_.size();
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
        public List<String> getUrlPrefixList() {
            return this.urlPrefix_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
        public boolean hasFrequencyPv() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.MaterialControlOrBuilder
        public boolean hasFrequencyTime() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.urlPrefix_.size(); i++) {
                codedOutputStream.writeString(1, this.urlPrefix_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(2, this.frequencyTime_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(3, this.frequencyPv_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(MaterialControl materialControl) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(materialControl);
        }

        public static MaterialControl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MaterialControl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MaterialControl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MaterialControl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MaterialControl parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MaterialControl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MaterialControl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MaterialControl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MaterialControl parseFrom(InputStream inputStream) throws IOException {
            return (MaterialControl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MaterialControl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MaterialControl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MaterialControl parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MaterialControl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MaterialControl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MaterialControl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface MaterialControlOrBuilder extends MessageLiteOrBuilder {
        int getFrequencyPv();

        int getFrequencyTime();

        String getUrlPrefix(int i);

        ByteString getUrlPrefixBytes(int i);

        int getUrlPrefixCount();

        List<String> getUrlPrefixList();

        boolean hasFrequencyPv();

        boolean hasFrequencyTime();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class PkCfg extends GeneratedMessageLite<PkCfg, Builder> implements PkCfgOrBuilder {
        private static final PkCfg DEFAULT_INSTANCE;
        public static final int DSP_WEIGHT_FIELD_NUMBER = 2;
        private static volatile Parser<PkCfg> PARSER = null;
        public static final int PRICE_TAG_FIELD_NUMBER = 1;
        private int bitField0_;
        private String priceTag_ = "";
        private Internal.ProtobufList<DspWeight> dspWeight_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<PkCfg, Builder> implements PkCfgOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllDspWeight(Iterable<? extends DspWeight> iterable) {
                copyOnWrite();
                ((PkCfg) this.instance).addAllDspWeight(iterable);
                return this;
            }

            public Builder addDspWeight(DspWeight dspWeight) {
                copyOnWrite();
                ((PkCfg) this.instance).addDspWeight(dspWeight);
                return this;
            }

            public Builder clearDspWeight() {
                copyOnWrite();
                ((PkCfg) this.instance).clearDspWeight();
                return this;
            }

            public Builder clearPriceTag() {
                copyOnWrite();
                ((PkCfg) this.instance).clearPriceTag();
                return this;
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.PkCfgOrBuilder
            public DspWeight getDspWeight(int i) {
                return ((PkCfg) this.instance).getDspWeight(i);
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.PkCfgOrBuilder
            public int getDspWeightCount() {
                return ((PkCfg) this.instance).getDspWeightCount();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.PkCfgOrBuilder
            public List<DspWeight> getDspWeightList() {
                return Collections.unmodifiableList(((PkCfg) this.instance).getDspWeightList());
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.PkCfgOrBuilder
            public String getPriceTag() {
                return ((PkCfg) this.instance).getPriceTag();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.PkCfgOrBuilder
            public ByteString getPriceTagBytes() {
                return ((PkCfg) this.instance).getPriceTagBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.PkCfgOrBuilder
            public boolean hasPriceTag() {
                return ((PkCfg) this.instance).hasPriceTag();
            }

            public Builder removeDspWeight(int i) {
                copyOnWrite();
                ((PkCfg) this.instance).removeDspWeight(i);
                return this;
            }

            public Builder setDspWeight(int i, DspWeight dspWeight) {
                copyOnWrite();
                ((PkCfg) this.instance).setDspWeight(i, dspWeight);
                return this;
            }

            public Builder setPriceTag(String str) {
                copyOnWrite();
                ((PkCfg) this.instance).setPriceTag(str);
                return this;
            }

            public Builder setPriceTagBytes(ByteString byteString) {
                copyOnWrite();
                ((PkCfg) this.instance).setPriceTagBytes(byteString);
                return this;
            }

            private Builder() {
                super(PkCfg.DEFAULT_INSTANCE);
            }

            public Builder addDspWeight(int i, DspWeight dspWeight) {
                copyOnWrite();
                ((PkCfg) this.instance).addDspWeight(i, dspWeight);
                return this;
            }

            public Builder setDspWeight(int i, DspWeight.Builder builder) {
                copyOnWrite();
                ((PkCfg) this.instance).setDspWeight(i, builder);
                return this;
            }

            public Builder addDspWeight(DspWeight.Builder builder) {
                copyOnWrite();
                ((PkCfg) this.instance).addDspWeight(builder);
                return this;
            }

            public Builder addDspWeight(int i, DspWeight.Builder builder) {
                copyOnWrite();
                ((PkCfg) this.instance).addDspWeight(i, builder);
                return this;
            }
        }

        static {
            PkCfg pkCfg = new PkCfg();
            DEFAULT_INSTANCE = pkCfg;
            pkCfg.makeImmutable();
        }

        private PkCfg() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDspWeight(Iterable<? extends DspWeight> iterable) {
            ensureDspWeightIsMutable();
            AbstractMessageLite.addAll(iterable, this.dspWeight_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDspWeight(DspWeight dspWeight) {
            dspWeight.getClass();
            ensureDspWeightIsMutable();
            this.dspWeight_.add(dspWeight);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDspWeight() {
            this.dspWeight_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPriceTag() {
            this.bitField0_ &= -2;
            this.priceTag_ = getDefaultInstance().getPriceTag();
        }

        private void ensureDspWeightIsMutable() {
            if (this.dspWeight_.isModifiable()) {
                return;
            }
            this.dspWeight_ = GeneratedMessageLite.mutableCopy(this.dspWeight_);
        }

        public static PkCfg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static PkCfg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PkCfg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PkCfg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<PkCfg> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDspWeight(int i) {
            ensureDspWeightIsMutable();
            this.dspWeight_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDspWeight(int i, DspWeight dspWeight) {
            dspWeight.getClass();
            ensureDspWeightIsMutable();
            this.dspWeight_.set(i, dspWeight);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPriceTag(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.priceTag_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPriceTagBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.priceTag_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new PkCfg();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.dspWeight_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    PkCfg pkCfg = (PkCfg) obj2;
                    this.priceTag_ = visitor.visitString(hasPriceTag(), this.priceTag_, pkCfg.hasPriceTag(), pkCfg.priceTag_);
                    this.dspWeight_ = visitor.visitList(this.dspWeight_, pkCfg.dspWeight_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= pkCfg.bitField0_;
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
                                if (tag == 10) {
                                    String string = codedInputStream.readString();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.priceTag_ = string;
                                } else if (tag == 18) {
                                    if (!this.dspWeight_.isModifiable()) {
                                        this.dspWeight_ = GeneratedMessageLite.mutableCopy(this.dspWeight_);
                                    }
                                    this.dspWeight_.add(codedInputStream.readMessage(DspWeight.parser(), extensionRegistryLite));
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
                        synchronized (PkCfg.class) {
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

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.PkCfgOrBuilder
        public DspWeight getDspWeight(int i) {
            return this.dspWeight_.get(i);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.PkCfgOrBuilder
        public int getDspWeightCount() {
            return this.dspWeight_.size();
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.PkCfgOrBuilder
        public List<DspWeight> getDspWeightList() {
            return this.dspWeight_;
        }

        public DspWeightOrBuilder getDspWeightOrBuilder(int i) {
            return this.dspWeight_.get(i);
        }

        public List<? extends DspWeightOrBuilder> getDspWeightOrBuilderList() {
            return this.dspWeight_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.PkCfgOrBuilder
        public String getPriceTag() {
            return this.priceTag_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.PkCfgOrBuilder
        public ByteString getPriceTagBytes() {
            return ByteString.copyFromUtf8(this.priceTag_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getPriceTag()) + 0 : 0;
            for (int i2 = 0; i2 < this.dspWeight_.size(); i2++) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(2, this.dspWeight_.get(i2));
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.PkCfgOrBuilder
        public boolean hasPriceTag() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getPriceTag());
            }
            for (int i = 0; i < this.dspWeight_.size(); i++) {
                codedOutputStream.writeMessage(2, this.dspWeight_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(PkCfg pkCfg) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(pkCfg);
        }

        public static PkCfg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PkCfg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PkCfg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PkCfg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDspWeight(int i, DspWeight dspWeight) {
            dspWeight.getClass();
            ensureDspWeightIsMutable();
            this.dspWeight_.add(i, dspWeight);
        }

        public static PkCfg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDspWeight(int i, DspWeight.Builder builder) {
            ensureDspWeightIsMutable();
            this.dspWeight_.set(i, builder.build());
        }

        public static PkCfg parseFrom(InputStream inputStream) throws IOException {
            return (PkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PkCfg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDspWeight(DspWeight.Builder builder) {
            ensureDspWeightIsMutable();
            this.dspWeight_.add(builder.build());
        }

        public static PkCfg parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PkCfg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDspWeight(int i, DspWeight.Builder builder) {
            ensureDspWeightIsMutable();
            this.dspWeight_.add(i, builder.build());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface PkCfgOrBuilder extends MessageLiteOrBuilder {
        DspWeight getDspWeight(int i);

        int getDspWeightCount();

        List<DspWeight> getDspWeightList();

        String getPriceTag();

        ByteString getPriceTagBytes();

        boolean hasPriceTag();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SdkCfg extends GeneratedMessageLite<SdkCfg, Builder> implements SdkCfgOrBuilder {
        public static final int CACHE_SEC_FIELD_NUMBER = 5;
        private static final SdkCfg DEFAULT_INSTANCE;
        public static final int DSPID_FIELD_NUMBER = 2;
        public static final int DSPNAME_FIELD_NUMBER = 1;
        private static volatile Parser<SdkCfg> PARSER = null;
        public static final int TIMEOUT_FIELD_NUMBER = 4;
        public static final int TYPE_FIELD_NUMBER = 3;
        private int bitField0_;
        private int cacheSec_;
        private int dspid_;
        private String dspname_ = "";
        private int timeout_;
        private int type_;

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<SdkCfg, Builder> implements SdkCfgOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCacheSec() {
                copyOnWrite();
                ((SdkCfg) this.instance).clearCacheSec();
                return this;
            }

            public Builder clearDspid() {
                copyOnWrite();
                ((SdkCfg) this.instance).clearDspid();
                return this;
            }

            public Builder clearDspname() {
                copyOnWrite();
                ((SdkCfg) this.instance).clearDspname();
                return this;
            }

            public Builder clearTimeout() {
                copyOnWrite();
                ((SdkCfg) this.instance).clearTimeout();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((SdkCfg) this.instance).clearType();
                return this;
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
            public int getCacheSec() {
                return ((SdkCfg) this.instance).getCacheSec();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
            public int getDspid() {
                return ((SdkCfg) this.instance).getDspid();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
            public String getDspname() {
                return ((SdkCfg) this.instance).getDspname();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
            public ByteString getDspnameBytes() {
                return ((SdkCfg) this.instance).getDspnameBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
            public int getTimeout() {
                return ((SdkCfg) this.instance).getTimeout();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
            public int getType() {
                return ((SdkCfg) this.instance).getType();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
            public boolean hasCacheSec() {
                return ((SdkCfg) this.instance).hasCacheSec();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
            public boolean hasDspid() {
                return ((SdkCfg) this.instance).hasDspid();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
            public boolean hasDspname() {
                return ((SdkCfg) this.instance).hasDspname();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
            public boolean hasTimeout() {
                return ((SdkCfg) this.instance).hasTimeout();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
            public boolean hasType() {
                return ((SdkCfg) this.instance).hasType();
            }

            public Builder setCacheSec(int i) {
                copyOnWrite();
                ((SdkCfg) this.instance).setCacheSec(i);
                return this;
            }

            public Builder setDspid(int i) {
                copyOnWrite();
                ((SdkCfg) this.instance).setDspid(i);
                return this;
            }

            public Builder setDspname(String str) {
                copyOnWrite();
                ((SdkCfg) this.instance).setDspname(str);
                return this;
            }

            public Builder setDspnameBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkCfg) this.instance).setDspnameBytes(byteString);
                return this;
            }

            public Builder setTimeout(int i) {
                copyOnWrite();
                ((SdkCfg) this.instance).setTimeout(i);
                return this;
            }

            public Builder setType(int i) {
                copyOnWrite();
                ((SdkCfg) this.instance).setType(i);
                return this;
            }

            private Builder() {
                super(SdkCfg.DEFAULT_INSTANCE);
            }
        }

        static {
            SdkCfg sdkCfg = new SdkCfg();
            DEFAULT_INSTANCE = sdkCfg;
            sdkCfg.makeImmutable();
        }

        private SdkCfg() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCacheSec() {
            this.bitField0_ &= -17;
            this.cacheSec_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDspid() {
            this.bitField0_ &= -3;
            this.dspid_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDspname() {
            this.bitField0_ &= -2;
            this.dspname_ = getDefaultInstance().getDspname();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeout() {
            this.bitField0_ &= -9;
            this.timeout_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -5;
            this.type_ = 0;
        }

        public static SdkCfg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SdkCfg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SdkCfg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SdkCfg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SdkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<SdkCfg> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCacheSec(int i) {
            this.bitField0_ |= 16;
            this.cacheSec_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDspid(int i) {
            this.bitField0_ |= 2;
            this.dspid_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDspname(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.dspname_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDspnameBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.dspname_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeout(int i) {
            this.bitField0_ |= 8;
            this.timeout_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i) {
            this.bitField0_ |= 4;
            this.type_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SdkCfg();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    SdkCfg sdkCfg = (SdkCfg) obj2;
                    this.dspname_ = visitor.visitString(hasDspname(), this.dspname_, sdkCfg.hasDspname(), sdkCfg.dspname_);
                    this.dspid_ = visitor.visitInt(hasDspid(), this.dspid_, sdkCfg.hasDspid(), sdkCfg.dspid_);
                    this.type_ = visitor.visitInt(hasType(), this.type_, sdkCfg.hasType(), sdkCfg.type_);
                    this.timeout_ = visitor.visitInt(hasTimeout(), this.timeout_, sdkCfg.hasTimeout(), sdkCfg.timeout_);
                    this.cacheSec_ = visitor.visitInt(hasCacheSec(), this.cacheSec_, sdkCfg.hasCacheSec(), sdkCfg.cacheSec_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= sdkCfg.bitField0_;
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
                                    this.dspname_ = string;
                                } else if (tag == 16) {
                                    this.bitField0_ |= 2;
                                    this.dspid_ = codedInputStream.readInt32();
                                } else if (tag == 24) {
                                    this.bitField0_ |= 4;
                                    this.type_ = codedInputStream.readInt32();
                                } else if (tag == 32) {
                                    this.bitField0_ |= 8;
                                    this.timeout_ = codedInputStream.readInt32();
                                } else if (tag == 40) {
                                    this.bitField0_ |= 16;
                                    this.cacheSec_ = codedInputStream.readInt32();
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
                        synchronized (SdkCfg.class) {
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

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
        public int getCacheSec() {
            return this.cacheSec_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
        public int getDspid() {
            return this.dspid_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
        public String getDspname() {
            return this.dspname_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
        public ByteString getDspnameBytes() {
            return ByteString.copyFromUtf8(this.dspname_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getDspname()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(2, this.dspid_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(3, this.type_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(4, this.timeout_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(5, this.cacheSec_);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
        public int getTimeout() {
            return this.timeout_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
        public boolean hasCacheSec() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
        public boolean hasDspid() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
        public boolean hasDspname() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
        public boolean hasTimeout() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SdkCfgOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getDspname());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.dspid_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.type_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.timeout_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.cacheSec_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(SdkCfg sdkCfg) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sdkCfg);
        }

        public static SdkCfg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkCfg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SdkCfg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SdkCfg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SdkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SdkCfg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SdkCfg parseFrom(InputStream inputStream) throws IOException {
            return (SdkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SdkCfg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SdkCfg parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SdkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SdkCfg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SdkCfgOrBuilder extends MessageLiteOrBuilder {
        int getCacheSec();

        int getDspid();

        String getDspname();

        ByteString getDspnameBytes();

        int getTimeout();

        int getType();

        boolean hasCacheSec();

        boolean hasDspid();

        boolean hasDspname();

        boolean hasTimeout();

        boolean hasType();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SlotCfg extends GeneratedMessageLite<SlotCfg, Builder> implements SlotCfgOrBuilder {
        public static final int ADCOST_TYPE_FIELD_NUMBER = 7;
        private static final SlotCfg DEFAULT_INSTANCE;
        public static final int DSPNAME_FIELD_NUMBER = 1;
        public static final int ECPM_FIELD_NUMBER = 3;
        public static final int ECPM_LOW_PRICE_FIELD_NUMBER = 9;
        public static final int ECPM_RATIO_FIELD_NUMBER = 8;
        public static final int ECPM_TAG_FIELD_NUMBER = 4;
        public static final int FREEZETIME_FIELD_NUMBER = 5;
        private static volatile Parser<SlotCfg> PARSER = null;
        public static final int PRE_REQUEST_FIELD_NUMBER = 6;
        public static final int PRICE_SWITCH_FIELD_NUMBER = 10;
        public static final int SLOTID_FIELD_NUMBER = 2;
        private int adcostType_;
        private int bitField0_;
        private int ecpmLowPrice_;
        private float ecpmRatio_;
        private int ecpm_;
        private int freezetime_;
        private int preRequest_;
        private int priceSwitch_ = 1;
        private String dspname_ = "";
        private String slotid_ = "";
        private String ecpmTag_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<SlotCfg, Builder> implements SlotCfgOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAdcostType() {
                copyOnWrite();
                ((SlotCfg) this.instance).clearAdcostType();
                return this;
            }

            public Builder clearDspname() {
                copyOnWrite();
                ((SlotCfg) this.instance).clearDspname();
                return this;
            }

            public Builder clearEcpm() {
                copyOnWrite();
                ((SlotCfg) this.instance).clearEcpm();
                return this;
            }

            public Builder clearEcpmLowPrice() {
                copyOnWrite();
                ((SlotCfg) this.instance).clearEcpmLowPrice();
                return this;
            }

            public Builder clearEcpmRatio() {
                copyOnWrite();
                ((SlotCfg) this.instance).clearEcpmRatio();
                return this;
            }

            public Builder clearEcpmTag() {
                copyOnWrite();
                ((SlotCfg) this.instance).clearEcpmTag();
                return this;
            }

            public Builder clearFreezetime() {
                copyOnWrite();
                ((SlotCfg) this.instance).clearFreezetime();
                return this;
            }

            public Builder clearPreRequest() {
                copyOnWrite();
                ((SlotCfg) this.instance).clearPreRequest();
                return this;
            }

            public Builder clearPriceSwitch() {
                copyOnWrite();
                ((SlotCfg) this.instance).clearPriceSwitch();
                return this;
            }

            public Builder clearSlotid() {
                copyOnWrite();
                ((SlotCfg) this.instance).clearSlotid();
                return this;
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public int getAdcostType() {
                return ((SlotCfg) this.instance).getAdcostType();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public String getDspname() {
                return ((SlotCfg) this.instance).getDspname();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public ByteString getDspnameBytes() {
                return ((SlotCfg) this.instance).getDspnameBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public int getEcpm() {
                return ((SlotCfg) this.instance).getEcpm();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public int getEcpmLowPrice() {
                return ((SlotCfg) this.instance).getEcpmLowPrice();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public float getEcpmRatio() {
                return ((SlotCfg) this.instance).getEcpmRatio();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public String getEcpmTag() {
                return ((SlotCfg) this.instance).getEcpmTag();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public ByteString getEcpmTagBytes() {
                return ((SlotCfg) this.instance).getEcpmTagBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public int getFreezetime() {
                return ((SlotCfg) this.instance).getFreezetime();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public int getPreRequest() {
                return ((SlotCfg) this.instance).getPreRequest();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public int getPriceSwitch() {
                return ((SlotCfg) this.instance).getPriceSwitch();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public String getSlotid() {
                return ((SlotCfg) this.instance).getSlotid();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public ByteString getSlotidBytes() {
                return ((SlotCfg) this.instance).getSlotidBytes();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public boolean hasAdcostType() {
                return ((SlotCfg) this.instance).hasAdcostType();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public boolean hasDspname() {
                return ((SlotCfg) this.instance).hasDspname();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public boolean hasEcpm() {
                return ((SlotCfg) this.instance).hasEcpm();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public boolean hasEcpmLowPrice() {
                return ((SlotCfg) this.instance).hasEcpmLowPrice();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public boolean hasEcpmRatio() {
                return ((SlotCfg) this.instance).hasEcpmRatio();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public boolean hasEcpmTag() {
                return ((SlotCfg) this.instance).hasEcpmTag();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public boolean hasFreezetime() {
                return ((SlotCfg) this.instance).hasFreezetime();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public boolean hasPreRequest() {
                return ((SlotCfg) this.instance).hasPreRequest();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public boolean hasPriceSwitch() {
                return ((SlotCfg) this.instance).hasPriceSwitch();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
            public boolean hasSlotid() {
                return ((SlotCfg) this.instance).hasSlotid();
            }

            public Builder setAdcostType(int i) {
                copyOnWrite();
                ((SlotCfg) this.instance).setAdcostType(i);
                return this;
            }

            public Builder setDspname(String str) {
                copyOnWrite();
                ((SlotCfg) this.instance).setDspname(str);
                return this;
            }

            public Builder setDspnameBytes(ByteString byteString) {
                copyOnWrite();
                ((SlotCfg) this.instance).setDspnameBytes(byteString);
                return this;
            }

            public Builder setEcpm(int i) {
                copyOnWrite();
                ((SlotCfg) this.instance).setEcpm(i);
                return this;
            }

            public Builder setEcpmLowPrice(int i) {
                copyOnWrite();
                ((SlotCfg) this.instance).setEcpmLowPrice(i);
                return this;
            }

            public Builder setEcpmRatio(float f) {
                copyOnWrite();
                ((SlotCfg) this.instance).setEcpmRatio(f);
                return this;
            }

            public Builder setEcpmTag(String str) {
                copyOnWrite();
                ((SlotCfg) this.instance).setEcpmTag(str);
                return this;
            }

            public Builder setEcpmTagBytes(ByteString byteString) {
                copyOnWrite();
                ((SlotCfg) this.instance).setEcpmTagBytes(byteString);
                return this;
            }

            public Builder setFreezetime(int i) {
                copyOnWrite();
                ((SlotCfg) this.instance).setFreezetime(i);
                return this;
            }

            public Builder setPreRequest(int i) {
                copyOnWrite();
                ((SlotCfg) this.instance).setPreRequest(i);
                return this;
            }

            public Builder setPriceSwitch(int i) {
                copyOnWrite();
                ((SlotCfg) this.instance).setPriceSwitch(i);
                return this;
            }

            public Builder setSlotid(String str) {
                copyOnWrite();
                ((SlotCfg) this.instance).setSlotid(str);
                return this;
            }

            public Builder setSlotidBytes(ByteString byteString) {
                copyOnWrite();
                ((SlotCfg) this.instance).setSlotidBytes(byteString);
                return this;
            }

            private Builder() {
                super(SlotCfg.DEFAULT_INSTANCE);
            }
        }

        static {
            SlotCfg slotCfg = new SlotCfg();
            DEFAULT_INSTANCE = slotCfg;
            slotCfg.makeImmutable();
        }

        private SlotCfg() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdcostType() {
            this.bitField0_ &= -65;
            this.adcostType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDspname() {
            this.bitField0_ &= -2;
            this.dspname_ = getDefaultInstance().getDspname();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEcpm() {
            this.bitField0_ &= -5;
            this.ecpm_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEcpmLowPrice() {
            this.bitField0_ &= -257;
            this.ecpmLowPrice_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEcpmRatio() {
            this.bitField0_ &= -129;
            this.ecpmRatio_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEcpmTag() {
            this.bitField0_ &= -9;
            this.ecpmTag_ = getDefaultInstance().getEcpmTag();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFreezetime() {
            this.bitField0_ &= -17;
            this.freezetime_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPreRequest() {
            this.bitField0_ &= -33;
            this.preRequest_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPriceSwitch() {
            this.bitField0_ &= -513;
            this.priceSwitch_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSlotid() {
            this.bitField0_ &= -3;
            this.slotid_ = getDefaultInstance().getSlotid();
        }

        public static SlotCfg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SlotCfg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SlotCfg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SlotCfg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SlotCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<SlotCfg> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdcostType(int i) {
            this.bitField0_ |= 64;
            this.adcostType_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDspname(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.dspname_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDspnameBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.dspname_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEcpm(int i) {
            this.bitField0_ |= 4;
            this.ecpm_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEcpmLowPrice(int i) {
            this.bitField0_ |= 256;
            this.ecpmLowPrice_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEcpmRatio(float f) {
            this.bitField0_ |= 128;
            this.ecpmRatio_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEcpmTag(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.ecpmTag_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEcpmTagBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.ecpmTag_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFreezetime(int i) {
            this.bitField0_ |= 16;
            this.freezetime_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPreRequest(int i) {
            this.bitField0_ |= 32;
            this.preRequest_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPriceSwitch(int i) {
            this.bitField0_ |= 512;
            this.priceSwitch_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSlotid(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.slotid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSlotidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.slotid_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SlotCfg();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    SlotCfg slotCfg = (SlotCfg) obj2;
                    this.dspname_ = visitor.visitString(hasDspname(), this.dspname_, slotCfg.hasDspname(), slotCfg.dspname_);
                    this.slotid_ = visitor.visitString(hasSlotid(), this.slotid_, slotCfg.hasSlotid(), slotCfg.slotid_);
                    this.ecpm_ = visitor.visitInt(hasEcpm(), this.ecpm_, slotCfg.hasEcpm(), slotCfg.ecpm_);
                    this.ecpmTag_ = visitor.visitString(hasEcpmTag(), this.ecpmTag_, slotCfg.hasEcpmTag(), slotCfg.ecpmTag_);
                    this.freezetime_ = visitor.visitInt(hasFreezetime(), this.freezetime_, slotCfg.hasFreezetime(), slotCfg.freezetime_);
                    this.preRequest_ = visitor.visitInt(hasPreRequest(), this.preRequest_, slotCfg.hasPreRequest(), slotCfg.preRequest_);
                    this.adcostType_ = visitor.visitInt(hasAdcostType(), this.adcostType_, slotCfg.hasAdcostType(), slotCfg.adcostType_);
                    this.ecpmRatio_ = visitor.visitFloat(hasEcpmRatio(), this.ecpmRatio_, slotCfg.hasEcpmRatio(), slotCfg.ecpmRatio_);
                    this.ecpmLowPrice_ = visitor.visitInt(hasEcpmLowPrice(), this.ecpmLowPrice_, slotCfg.hasEcpmLowPrice(), slotCfg.ecpmLowPrice_);
                    this.priceSwitch_ = visitor.visitInt(hasPriceSwitch(), this.priceSwitch_, slotCfg.hasPriceSwitch(), slotCfg.priceSwitch_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= slotCfg.bitField0_;
                    }
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
                                    String string = codedInputStream.readString();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.dspname_ = string;
                                    break;
                                case 18:
                                    String string2 = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.slotid_ = string2;
                                    break;
                                case 24:
                                    this.bitField0_ |= 4;
                                    this.ecpm_ = codedInputStream.readInt32();
                                    break;
                                case 34:
                                    String string3 = codedInputStream.readString();
                                    this.bitField0_ |= 8;
                                    this.ecpmTag_ = string3;
                                    break;
                                case 40:
                                    this.bitField0_ |= 16;
                                    this.freezetime_ = codedInputStream.readInt32();
                                    break;
                                case 48:
                                    this.bitField0_ |= 32;
                                    this.preRequest_ = codedInputStream.readInt32();
                                    break;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.adcostType_ = codedInputStream.readInt32();
                                    break;
                                case 69:
                                    this.bitField0_ |= 128;
                                    this.ecpmRatio_ = codedInputStream.readFloat();
                                    break;
                                case 72:
                                    this.bitField0_ |= 256;
                                    this.ecpmLowPrice_ = codedInputStream.readInt32();
                                    break;
                                case 80:
                                    this.bitField0_ |= 512;
                                    this.priceSwitch_ = codedInputStream.readInt32();
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
                        synchronized (SlotCfg.class) {
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

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public int getAdcostType() {
            return this.adcostType_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public String getDspname() {
            return this.dspname_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public ByteString getDspnameBytes() {
            return ByteString.copyFromUtf8(this.dspname_);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public int getEcpm() {
            return this.ecpm_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public int getEcpmLowPrice() {
            return this.ecpmLowPrice_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public float getEcpmRatio() {
            return this.ecpmRatio_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public String getEcpmTag() {
            return this.ecpmTag_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public ByteString getEcpmTagBytes() {
            return ByteString.copyFromUtf8(this.ecpmTag_);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public int getFreezetime() {
            return this.freezetime_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public int getPreRequest() {
            return this.preRequest_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public int getPriceSwitch() {
            return this.priceSwitch_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getDspname()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getSlotid());
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(3, this.ecpm_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, getEcpmTag());
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(5, this.freezetime_);
            }
            if ((this.bitField0_ & 32) == 32) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(6, this.preRequest_);
            }
            if ((this.bitField0_ & 64) == 64) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(7, this.adcostType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                iComputeStringSize += CodedOutputStream.computeFloatSize(8, this.ecpmRatio_);
            }
            if ((this.bitField0_ & 256) == 256) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(9, this.ecpmLowPrice_);
            }
            if ((this.bitField0_ & 512) == 512) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(10, this.priceSwitch_);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public String getSlotid() {
            return this.slotid_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public ByteString getSlotidBytes() {
            return ByteString.copyFromUtf8(this.slotid_);
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public boolean hasAdcostType() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public boolean hasDspname() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public boolean hasEcpm() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public boolean hasEcpmLowPrice() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public boolean hasEcpmRatio() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public boolean hasEcpmTag() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public boolean hasFreezetime() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public boolean hasPreRequest() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public boolean hasPriceSwitch() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SlotCfgOrBuilder
        public boolean hasSlotid() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getDspname());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getSlotid());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.ecpm_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeString(4, getEcpmTag());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.freezetime_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(6, this.preRequest_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(7, this.adcostType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeFloat(8, this.ecpmRatio_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(9, this.ecpmLowPrice_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(10, this.priceSwitch_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(SlotCfg slotCfg) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(slotCfg);
        }

        public static SlotCfg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SlotCfg) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SlotCfg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SlotCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SlotCfg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SlotCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SlotCfg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SlotCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SlotCfg parseFrom(InputStream inputStream) throws IOException {
            return (SlotCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SlotCfg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SlotCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SlotCfg parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SlotCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SlotCfg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SlotCfg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SlotCfgOrBuilder extends MessageLiteOrBuilder {
        int getAdcostType();

        String getDspname();

        ByteString getDspnameBytes();

        int getEcpm();

        int getEcpmLowPrice();

        float getEcpmRatio();

        String getEcpmTag();

        ByteString getEcpmTagBytes();

        int getFreezetime();

        int getPreRequest();

        int getPriceSwitch();

        String getSlotid();

        ByteString getSlotidBytes();

        boolean hasAdcostType();

        boolean hasDspname();

        boolean hasEcpm();

        boolean hasEcpmLowPrice();

        boolean hasEcpmRatio();

        boolean hasEcpmTag();

        boolean hasFreezetime();

        boolean hasPreRequest();

        boolean hasPriceSwitch();

        boolean hasSlotid();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Switch extends GeneratedMessageLite<Switch, Builder> implements SwitchOrBuilder {
        public static final int BLACKLIST_FIELD_NUMBER = 2;
        public static final int DEBUG_REPORT_FIELD_NUMBER = 5;
        private static final Switch DEFAULT_INSTANCE;
        public static final int MAXPRICE_SWITCH_FIELD_NUMBER = 10;
        private static volatile Parser<Switch> PARSER = null;
        public static final int PRIME_RIT_SWITCH_FIELD_NUMBER = 8;
        public static final int REALTIME_AD_HIGH_PRIORITY_FIELD_NUMBER = 6;
        public static final int RESPONSE_STRATEGY_OPTIMIZE_FIELD_NUMBER = 7;
        public static final int SHAKE_SWITCH_FIELD_NUMBER = 9;
        public static final int STRATEGY_SHOW_FIELD_NUMBER = 4;
        public static final int STRATEGY_TYPE_FIELD_NUMBER = 3;
        public static final int WHITELIST_FIELD_NUMBER = 1;
        private int bitField0_;
        private int blacklist_;
        private int debugReport_;
        private int maxpriceSwitch_;
        private int primeRitSwitch_;
        private int realtimeAdHighPriority_;
        private int responseStrategyOptimize_;
        private int shakeSwitch_;
        private int strategyShow_;
        private int strategyType_;
        private int whitelist_;

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<Switch, Builder> implements SwitchOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBlacklist() {
                copyOnWrite();
                ((Switch) this.instance).clearBlacklist();
                return this;
            }

            public Builder clearDebugReport() {
                copyOnWrite();
                ((Switch) this.instance).clearDebugReport();
                return this;
            }

            public Builder clearMaxpriceSwitch() {
                copyOnWrite();
                ((Switch) this.instance).clearMaxpriceSwitch();
                return this;
            }

            public Builder clearPrimeRitSwitch() {
                copyOnWrite();
                ((Switch) this.instance).clearPrimeRitSwitch();
                return this;
            }

            public Builder clearRealtimeAdHighPriority() {
                copyOnWrite();
                ((Switch) this.instance).clearRealtimeAdHighPriority();
                return this;
            }

            public Builder clearResponseStrategyOptimize() {
                copyOnWrite();
                ((Switch) this.instance).clearResponseStrategyOptimize();
                return this;
            }

            public Builder clearShakeSwitch() {
                copyOnWrite();
                ((Switch) this.instance).clearShakeSwitch();
                return this;
            }

            public Builder clearStrategyShow() {
                copyOnWrite();
                ((Switch) this.instance).clearStrategyShow();
                return this;
            }

            public Builder clearStrategyType() {
                copyOnWrite();
                ((Switch) this.instance).clearStrategyType();
                return this;
            }

            public Builder clearWhitelist() {
                copyOnWrite();
                ((Switch) this.instance).clearWhitelist();
                return this;
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public int getBlacklist() {
                return ((Switch) this.instance).getBlacklist();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public int getDebugReport() {
                return ((Switch) this.instance).getDebugReport();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public int getMaxpriceSwitch() {
                return ((Switch) this.instance).getMaxpriceSwitch();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public int getPrimeRitSwitch() {
                return ((Switch) this.instance).getPrimeRitSwitch();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public int getRealtimeAdHighPriority() {
                return ((Switch) this.instance).getRealtimeAdHighPriority();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public int getResponseStrategyOptimize() {
                return ((Switch) this.instance).getResponseStrategyOptimize();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public int getShakeSwitch() {
                return ((Switch) this.instance).getShakeSwitch();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public int getStrategyShow() {
                return ((Switch) this.instance).getStrategyShow();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public int getStrategyType() {
                return ((Switch) this.instance).getStrategyType();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public int getWhitelist() {
                return ((Switch) this.instance).getWhitelist();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public boolean hasBlacklist() {
                return ((Switch) this.instance).hasBlacklist();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public boolean hasDebugReport() {
                return ((Switch) this.instance).hasDebugReport();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public boolean hasMaxpriceSwitch() {
                return ((Switch) this.instance).hasMaxpriceSwitch();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public boolean hasPrimeRitSwitch() {
                return ((Switch) this.instance).hasPrimeRitSwitch();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public boolean hasRealtimeAdHighPriority() {
                return ((Switch) this.instance).hasRealtimeAdHighPriority();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public boolean hasResponseStrategyOptimize() {
                return ((Switch) this.instance).hasResponseStrategyOptimize();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public boolean hasShakeSwitch() {
                return ((Switch) this.instance).hasShakeSwitch();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public boolean hasStrategyShow() {
                return ((Switch) this.instance).hasStrategyShow();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public boolean hasStrategyType() {
                return ((Switch) this.instance).hasStrategyType();
            }

            @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
            public boolean hasWhitelist() {
                return ((Switch) this.instance).hasWhitelist();
            }

            public Builder setBlacklist(int i) {
                copyOnWrite();
                ((Switch) this.instance).setBlacklist(i);
                return this;
            }

            public Builder setDebugReport(int i) {
                copyOnWrite();
                ((Switch) this.instance).setDebugReport(i);
                return this;
            }

            public Builder setMaxpriceSwitch(int i) {
                copyOnWrite();
                ((Switch) this.instance).setMaxpriceSwitch(i);
                return this;
            }

            public Builder setPrimeRitSwitch(int i) {
                copyOnWrite();
                ((Switch) this.instance).setPrimeRitSwitch(i);
                return this;
            }

            public Builder setRealtimeAdHighPriority(int i) {
                copyOnWrite();
                ((Switch) this.instance).setRealtimeAdHighPriority(i);
                return this;
            }

            public Builder setResponseStrategyOptimize(int i) {
                copyOnWrite();
                ((Switch) this.instance).setResponseStrategyOptimize(i);
                return this;
            }

            public Builder setShakeSwitch(int i) {
                copyOnWrite();
                ((Switch) this.instance).setShakeSwitch(i);
                return this;
            }

            public Builder setStrategyShow(int i) {
                copyOnWrite();
                ((Switch) this.instance).setStrategyShow(i);
                return this;
            }

            public Builder setStrategyType(int i) {
                copyOnWrite();
                ((Switch) this.instance).setStrategyType(i);
                return this;
            }

            public Builder setWhitelist(int i) {
                copyOnWrite();
                ((Switch) this.instance).setWhitelist(i);
                return this;
            }

            private Builder() {
                super(Switch.DEFAULT_INSTANCE);
            }
        }

        static {
            Switch r0 = new Switch();
            DEFAULT_INSTANCE = r0;
            r0.makeImmutable();
        }

        private Switch() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBlacklist() {
            this.bitField0_ &= -3;
            this.blacklist_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDebugReport() {
            this.bitField0_ &= -17;
            this.debugReport_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMaxpriceSwitch() {
            this.bitField0_ &= -513;
            this.maxpriceSwitch_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrimeRitSwitch() {
            this.bitField0_ &= -129;
            this.primeRitSwitch_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRealtimeAdHighPriority() {
            this.bitField0_ &= -33;
            this.realtimeAdHighPriority_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearResponseStrategyOptimize() {
            this.bitField0_ &= -65;
            this.responseStrategyOptimize_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearShakeSwitch() {
            this.bitField0_ &= -257;
            this.shakeSwitch_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStrategyShow() {
            this.bitField0_ &= -9;
            this.strategyShow_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStrategyType() {
            this.bitField0_ &= -5;
            this.strategyType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWhitelist() {
            this.bitField0_ &= -2;
            this.whitelist_ = 0;
        }

        public static Switch getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Switch parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Switch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Switch parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Switch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Switch> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBlacklist(int i) {
            this.bitField0_ |= 2;
            this.blacklist_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDebugReport(int i) {
            this.bitField0_ |= 16;
            this.debugReport_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMaxpriceSwitch(int i) {
            this.bitField0_ |= 512;
            this.maxpriceSwitch_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrimeRitSwitch(int i) {
            this.bitField0_ |= 128;
            this.primeRitSwitch_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRealtimeAdHighPriority(int i) {
            this.bitField0_ |= 32;
            this.realtimeAdHighPriority_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setResponseStrategyOptimize(int i) {
            this.bitField0_ |= 64;
            this.responseStrategyOptimize_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setShakeSwitch(int i) {
            this.bitField0_ |= 256;
            this.shakeSwitch_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrategyShow(int i) {
            this.bitField0_ |= 8;
            this.strategyShow_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrategyType(int i) {
            this.bitField0_ |= 4;
            this.strategyType_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWhitelist(int i) {
            this.bitField0_ |= 1;
            this.whitelist_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Switch();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Switch r6 = (Switch) obj2;
                    this.whitelist_ = visitor.visitInt(hasWhitelist(), this.whitelist_, r6.hasWhitelist(), r6.whitelist_);
                    this.blacklist_ = visitor.visitInt(hasBlacklist(), this.blacklist_, r6.hasBlacklist(), r6.blacklist_);
                    this.strategyType_ = visitor.visitInt(hasStrategyType(), this.strategyType_, r6.hasStrategyType(), r6.strategyType_);
                    this.strategyShow_ = visitor.visitInt(hasStrategyShow(), this.strategyShow_, r6.hasStrategyShow(), r6.strategyShow_);
                    this.debugReport_ = visitor.visitInt(hasDebugReport(), this.debugReport_, r6.hasDebugReport(), r6.debugReport_);
                    this.realtimeAdHighPriority_ = visitor.visitInt(hasRealtimeAdHighPriority(), this.realtimeAdHighPriority_, r6.hasRealtimeAdHighPriority(), r6.realtimeAdHighPriority_);
                    this.responseStrategyOptimize_ = visitor.visitInt(hasResponseStrategyOptimize(), this.responseStrategyOptimize_, r6.hasResponseStrategyOptimize(), r6.responseStrategyOptimize_);
                    this.primeRitSwitch_ = visitor.visitInt(hasPrimeRitSwitch(), this.primeRitSwitch_, r6.hasPrimeRitSwitch(), r6.primeRitSwitch_);
                    this.shakeSwitch_ = visitor.visitInt(hasShakeSwitch(), this.shakeSwitch_, r6.hasShakeSwitch(), r6.shakeSwitch_);
                    this.maxpriceSwitch_ = visitor.visitInt(hasMaxpriceSwitch(), this.maxpriceSwitch_, r6.hasMaxpriceSwitch(), r6.maxpriceSwitch_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= r6.bitField0_;
                    }
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
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.whitelist_ = codedInputStream.readInt32();
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.blacklist_ = codedInputStream.readInt32();
                                    break;
                                case 24:
                                    this.bitField0_ |= 4;
                                    this.strategyType_ = codedInputStream.readInt32();
                                    break;
                                case 32:
                                    this.bitField0_ |= 8;
                                    this.strategyShow_ = codedInputStream.readInt32();
                                    break;
                                case 40:
                                    this.bitField0_ |= 16;
                                    this.debugReport_ = codedInputStream.readInt32();
                                    break;
                                case 48:
                                    this.bitField0_ |= 32;
                                    this.realtimeAdHighPriority_ = codedInputStream.readInt32();
                                    break;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.responseStrategyOptimize_ = codedInputStream.readInt32();
                                    break;
                                case 64:
                                    this.bitField0_ |= 128;
                                    this.primeRitSwitch_ = codedInputStream.readInt32();
                                    break;
                                case 72:
                                    this.bitField0_ |= 256;
                                    this.shakeSwitch_ = codedInputStream.readInt32();
                                    break;
                                case 80:
                                    this.bitField0_ |= 512;
                                    this.maxpriceSwitch_ = codedInputStream.readInt32();
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
                        synchronized (Switch.class) {
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

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public int getBlacklist() {
            return this.blacklist_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public int getDebugReport() {
            return this.debugReport_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public int getMaxpriceSwitch() {
            return this.maxpriceSwitch_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public int getPrimeRitSwitch() {
            return this.primeRitSwitch_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public int getRealtimeAdHighPriority() {
            return this.realtimeAdHighPriority_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public int getResponseStrategyOptimize() {
            return this.responseStrategyOptimize_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.whitelist_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.blacklist_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, this.strategyType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(4, this.strategyShow_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.debugReport_);
            }
            if ((this.bitField0_ & 32) == 32) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(6, this.realtimeAdHighPriority_);
            }
            if ((this.bitField0_ & 64) == 64) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.responseStrategyOptimize_);
            }
            if ((this.bitField0_ & 128) == 128) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.primeRitSwitch_);
            }
            if ((this.bitField0_ & 256) == 256) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(9, this.shakeSwitch_);
            }
            if ((this.bitField0_ & 512) == 512) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(10, this.maxpriceSwitch_);
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public int getShakeSwitch() {
            return this.shakeSwitch_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public int getStrategyShow() {
            return this.strategyShow_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public int getStrategyType() {
            return this.strategyType_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public int getWhitelist() {
            return this.whitelist_;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public boolean hasBlacklist() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public boolean hasDebugReport() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public boolean hasMaxpriceSwitch() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public boolean hasPrimeRitSwitch() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public boolean hasRealtimeAdHighPriority() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public boolean hasResponseStrategyOptimize() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public boolean hasShakeSwitch() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public boolean hasStrategyShow() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public boolean hasStrategyType() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.wifi.ad.core.spstrategy.all.WkSPAllResponse.SwitchOrBuilder
        public boolean hasWhitelist() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.whitelist_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.blacklist_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.strategyType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.strategyShow_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.debugReport_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(6, this.realtimeAdHighPriority_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(7, this.responseStrategyOptimize_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(8, this.primeRitSwitch_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(9, this.shakeSwitch_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(10, this.maxpriceSwitch_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(Switch r1) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
        }

        public static Switch parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Switch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Switch parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Switch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Switch parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Switch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Switch parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Switch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Switch parseFrom(InputStream inputStream) throws IOException {
            return (Switch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Switch parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Switch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Switch parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Switch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Switch parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Switch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SwitchOrBuilder extends MessageLiteOrBuilder {
        int getBlacklist();

        int getDebugReport();

        int getMaxpriceSwitch();

        int getPrimeRitSwitch();

        int getRealtimeAdHighPriority();

        int getResponseStrategyOptimize();

        int getShakeSwitch();

        int getStrategyShow();

        int getStrategyType();

        int getWhitelist();

        boolean hasBlacklist();

        boolean hasDebugReport();

        boolean hasMaxpriceSwitch();

        boolean hasPrimeRitSwitch();

        boolean hasRealtimeAdHighPriority();

        boolean hasResponseStrategyOptimize();

        boolean hasShakeSwitch();

        boolean hasStrategyShow();

        boolean hasStrategyType();

        boolean hasWhitelist();
    }

    private WkSPAllResponse() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
