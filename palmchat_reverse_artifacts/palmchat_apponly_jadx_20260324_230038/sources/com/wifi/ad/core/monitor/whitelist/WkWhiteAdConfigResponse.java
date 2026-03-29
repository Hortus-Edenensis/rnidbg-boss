package com.wifi.ad.core.monitor.whitelist;

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
public final class WkWhiteAdConfigResponse {

    /* JADX INFO: renamed from: com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse$1, reason: invalid class name */
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
    public static final class Data extends GeneratedMessageLite<Data, Builder> implements DataOrBuilder {
        public static final int ADDED_LIST_FIELD_NUMBER = 4;
        private static final Data DEFAULT_INSTANCE;
        public static final int ENABLE_FIELD_NUMBER = 1;
        public static final int FULL_LIST_FIELD_NUMBER = 6;
        public static final int MORE_DATA_FIELD_NUMBER = 3;
        private static volatile Parser<Data> PARSER = null;
        public static final int REMOVED_LIST_FIELD_NUMBER = 5;
        public static final int UPDATE_INTERVAL_FIELD_NUMBER = 8;
        public static final int UPDATE_TYPE_FIELD_NUMBER = 2;
        public static final int VERSION_FIELD_NUMBER = 7;
        private int bitField0_;
        private int moreData_;
        private int updateType_;
        private int enable_ = 1;
        private Internal.ProtobufList<String> addedList_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> removedList_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> fullList_ = GeneratedMessageLite.emptyProtobufList();
        private String version_ = "";
        private int updateInterval_ = 1;

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<Data, Builder> implements DataOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAddedList(String str) {
                copyOnWrite();
                ((Data) this.instance).addAddedList(str);
                return this;
            }

            public Builder addAddedListBytes(ByteString byteString) {
                copyOnWrite();
                ((Data) this.instance).addAddedListBytes(byteString);
                return this;
            }

            public Builder addAllAddedList(Iterable<String> iterable) {
                copyOnWrite();
                ((Data) this.instance).addAllAddedList(iterable);
                return this;
            }

            public Builder addAllFullList(Iterable<String> iterable) {
                copyOnWrite();
                ((Data) this.instance).addAllFullList(iterable);
                return this;
            }

            public Builder addAllRemovedList(Iterable<String> iterable) {
                copyOnWrite();
                ((Data) this.instance).addAllRemovedList(iterable);
                return this;
            }

            public Builder addFullList(String str) {
                copyOnWrite();
                ((Data) this.instance).addFullList(str);
                return this;
            }

            public Builder addFullListBytes(ByteString byteString) {
                copyOnWrite();
                ((Data) this.instance).addFullListBytes(byteString);
                return this;
            }

            public Builder addRemovedList(String str) {
                copyOnWrite();
                ((Data) this.instance).addRemovedList(str);
                return this;
            }

            public Builder addRemovedListBytes(ByteString byteString) {
                copyOnWrite();
                ((Data) this.instance).addRemovedListBytes(byteString);
                return this;
            }

            public Builder clearAddedList() {
                copyOnWrite();
                ((Data) this.instance).clearAddedList();
                return this;
            }

            public Builder clearEnable() {
                copyOnWrite();
                ((Data) this.instance).clearEnable();
                return this;
            }

            public Builder clearFullList() {
                copyOnWrite();
                ((Data) this.instance).clearFullList();
                return this;
            }

            public Builder clearMoreData() {
                copyOnWrite();
                ((Data) this.instance).clearMoreData();
                return this;
            }

            public Builder clearRemovedList() {
                copyOnWrite();
                ((Data) this.instance).clearRemovedList();
                return this;
            }

            public Builder clearUpdateInterval() {
                copyOnWrite();
                ((Data) this.instance).clearUpdateInterval();
                return this;
            }

            public Builder clearUpdateType() {
                copyOnWrite();
                ((Data) this.instance).clearUpdateType();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((Data) this.instance).clearVersion();
                return this;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public String getAddedList(int i) {
                return ((Data) this.instance).getAddedList(i);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public ByteString getAddedListBytes(int i) {
                return ((Data) this.instance).getAddedListBytes(i);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public int getAddedListCount() {
                return ((Data) this.instance).getAddedListCount();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public List<String> getAddedListList() {
                return Collections.unmodifiableList(((Data) this.instance).getAddedListList());
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public int getEnable() {
                return ((Data) this.instance).getEnable();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public String getFullList(int i) {
                return ((Data) this.instance).getFullList(i);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public ByteString getFullListBytes(int i) {
                return ((Data) this.instance).getFullListBytes(i);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public int getFullListCount() {
                return ((Data) this.instance).getFullListCount();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public List<String> getFullListList() {
                return Collections.unmodifiableList(((Data) this.instance).getFullListList());
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public int getMoreData() {
                return ((Data) this.instance).getMoreData();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public String getRemovedList(int i) {
                return ((Data) this.instance).getRemovedList(i);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public ByteString getRemovedListBytes(int i) {
                return ((Data) this.instance).getRemovedListBytes(i);
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public int getRemovedListCount() {
                return ((Data) this.instance).getRemovedListCount();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public List<String> getRemovedListList() {
                return Collections.unmodifiableList(((Data) this.instance).getRemovedListList());
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public int getUpdateInterval() {
                return ((Data) this.instance).getUpdateInterval();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public UpdateType getUpdateType() {
                return ((Data) this.instance).getUpdateType();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public String getVersion() {
                return ((Data) this.instance).getVersion();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public ByteString getVersionBytes() {
                return ((Data) this.instance).getVersionBytes();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public boolean hasEnable() {
                return ((Data) this.instance).hasEnable();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public boolean hasMoreData() {
                return ((Data) this.instance).hasMoreData();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public boolean hasUpdateInterval() {
                return ((Data) this.instance).hasUpdateInterval();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public boolean hasUpdateType() {
                return ((Data) this.instance).hasUpdateType();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
            public boolean hasVersion() {
                return ((Data) this.instance).hasVersion();
            }

            public Builder setAddedList(int i, String str) {
                copyOnWrite();
                ((Data) this.instance).setAddedList(i, str);
                return this;
            }

            public Builder setEnable(int i) {
                copyOnWrite();
                ((Data) this.instance).setEnable(i);
                return this;
            }

            public Builder setFullList(int i, String str) {
                copyOnWrite();
                ((Data) this.instance).setFullList(i, str);
                return this;
            }

            public Builder setMoreData(int i) {
                copyOnWrite();
                ((Data) this.instance).setMoreData(i);
                return this;
            }

            public Builder setRemovedList(int i, String str) {
                copyOnWrite();
                ((Data) this.instance).setRemovedList(i, str);
                return this;
            }

            public Builder setUpdateInterval(int i) {
                copyOnWrite();
                ((Data) this.instance).setUpdateInterval(i);
                return this;
            }

            public Builder setUpdateType(UpdateType updateType) {
                copyOnWrite();
                ((Data) this.instance).setUpdateType(updateType);
                return this;
            }

            public Builder setVersion(String str) {
                copyOnWrite();
                ((Data) this.instance).setVersion(str);
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((Data) this.instance).setVersionBytes(byteString);
                return this;
            }

            private Builder() {
                super(Data.DEFAULT_INSTANCE);
            }
        }

        static {
            Data data = new Data();
            DEFAULT_INSTANCE = data;
            data.makeImmutable();
        }

        private Data() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAddedList(String str) {
            str.getClass();
            ensureAddedListIsMutable();
            this.addedList_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAddedListBytes(ByteString byteString) {
            byteString.getClass();
            ensureAddedListIsMutable();
            this.addedList_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAddedList(Iterable<String> iterable) {
            ensureAddedListIsMutable();
            AbstractMessageLite.addAll(iterable, this.addedList_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllFullList(Iterable<String> iterable) {
            ensureFullListIsMutable();
            AbstractMessageLite.addAll(iterable, this.fullList_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllRemovedList(Iterable<String> iterable) {
            ensureRemovedListIsMutable();
            AbstractMessageLite.addAll(iterable, this.removedList_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFullList(String str) {
            str.getClass();
            ensureFullListIsMutable();
            this.fullList_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFullListBytes(ByteString byteString) {
            byteString.getClass();
            ensureFullListIsMutable();
            this.fullList_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRemovedList(String str) {
            str.getClass();
            ensureRemovedListIsMutable();
            this.removedList_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRemovedListBytes(ByteString byteString) {
            byteString.getClass();
            ensureRemovedListIsMutable();
            this.removedList_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAddedList() {
            this.addedList_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEnable() {
            this.bitField0_ &= -2;
            this.enable_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFullList() {
            this.fullList_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMoreData() {
            this.bitField0_ &= -5;
            this.moreData_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemovedList() {
            this.removedList_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpdateInterval() {
            this.bitField0_ &= -17;
            this.updateInterval_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpdateType() {
            this.bitField0_ &= -3;
            this.updateType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.bitField0_ &= -9;
            this.version_ = getDefaultInstance().getVersion();
        }

        private void ensureAddedListIsMutable() {
            if (this.addedList_.isModifiable()) {
                return;
            }
            this.addedList_ = GeneratedMessageLite.mutableCopy(this.addedList_);
        }

        private void ensureFullListIsMutable() {
            if (this.fullList_.isModifiable()) {
                return;
            }
            this.fullList_ = GeneratedMessageLite.mutableCopy(this.fullList_);
        }

        private void ensureRemovedListIsMutable() {
            if (this.removedList_.isModifiable()) {
                return;
            }
            this.removedList_ = GeneratedMessageLite.mutableCopy(this.removedList_);
        }

        public static Data getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Data parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Data) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Data parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Data> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAddedList(int i, String str) {
            str.getClass();
            ensureAddedListIsMutable();
            this.addedList_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnable(int i) {
            this.bitField0_ |= 1;
            this.enable_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFullList(int i, String str) {
            str.getClass();
            ensureFullListIsMutable();
            this.fullList_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMoreData(int i) {
            this.bitField0_ |= 4;
            this.moreData_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemovedList(int i, String str) {
            str.getClass();
            ensureRemovedListIsMutable();
            this.removedList_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdateInterval(int i) {
            this.bitField0_ |= 16;
            this.updateInterval_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdateType(UpdateType updateType) {
            updateType.getClass();
            this.bitField0_ |= 2;
            this.updateType_ = updateType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.version_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.version_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Data();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.addedList_.makeImmutable();
                    this.removedList_.makeImmutable();
                    this.fullList_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Data data = (Data) obj2;
                    this.enable_ = visitor.visitInt(hasEnable(), this.enable_, data.hasEnable(), data.enable_);
                    this.updateType_ = visitor.visitInt(hasUpdateType(), this.updateType_, data.hasUpdateType(), data.updateType_);
                    this.moreData_ = visitor.visitInt(hasMoreData(), this.moreData_, data.hasMoreData(), data.moreData_);
                    this.addedList_ = visitor.visitList(this.addedList_, data.addedList_);
                    this.removedList_ = visitor.visitList(this.removedList_, data.removedList_);
                    this.fullList_ = visitor.visitList(this.fullList_, data.fullList_);
                    this.version_ = visitor.visitString(hasVersion(), this.version_, data.hasVersion(), data.version_);
                    this.updateInterval_ = visitor.visitInt(hasUpdateInterval(), this.updateInterval_, data.hasUpdateInterval(), data.updateInterval_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= data.bitField0_;
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
                                    this.enable_ = codedInputStream.readInt32();
                                } else if (tag == 16) {
                                    int i = codedInputStream.readEnum();
                                    if (UpdateType.forNumber(i) == null) {
                                        super.mergeVarintField(2, i);
                                    } else {
                                        this.bitField0_ |= 2;
                                        this.updateType_ = i;
                                    }
                                } else if (tag == 24) {
                                    this.bitField0_ |= 4;
                                    this.moreData_ = codedInputStream.readInt32();
                                } else if (tag == 34) {
                                    String string = codedInputStream.readString();
                                    if (!this.addedList_.isModifiable()) {
                                        this.addedList_ = GeneratedMessageLite.mutableCopy(this.addedList_);
                                    }
                                    this.addedList_.add(string);
                                } else if (tag == 42) {
                                    String string2 = codedInputStream.readString();
                                    if (!this.removedList_.isModifiable()) {
                                        this.removedList_ = GeneratedMessageLite.mutableCopy(this.removedList_);
                                    }
                                    this.removedList_.add(string2);
                                } else if (tag == 50) {
                                    String string3 = codedInputStream.readString();
                                    if (!this.fullList_.isModifiable()) {
                                        this.fullList_ = GeneratedMessageLite.mutableCopy(this.fullList_);
                                    }
                                    this.fullList_.add(string3);
                                } else if (tag == 58) {
                                    String string4 = codedInputStream.readString();
                                    this.bitField0_ |= 8;
                                    this.version_ = string4;
                                } else if (tag == 64) {
                                    this.bitField0_ |= 16;
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
                        synchronized (Data.class) {
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

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public String getAddedList(int i) {
            return this.addedList_.get(i);
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public ByteString getAddedListBytes(int i) {
            return ByteString.copyFromUtf8(this.addedList_.get(i));
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public int getAddedListCount() {
            return this.addedList_.size();
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public List<String> getAddedListList() {
            return this.addedList_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public int getEnable() {
            return this.enable_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public String getFullList(int i) {
            return this.fullList_.get(i);
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public ByteString getFullListBytes(int i) {
            return ByteString.copyFromUtf8(this.fullList_.get(i));
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public int getFullListCount() {
            return this.fullList_.size();
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public List<String> getFullListList() {
            return this.fullList_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public int getMoreData() {
            return this.moreData_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public String getRemovedList(int i) {
            return this.removedList_.get(i);
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public ByteString getRemovedListBytes(int i) {
            return ByteString.copyFromUtf8(this.removedList_.get(i));
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public int getRemovedListCount() {
            return this.removedList_.size();
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public List<String> getRemovedListList() {
            return this.removedList_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.enable_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeEnumSize(2, this.updateType_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, this.moreData_);
            }
            int iComputeStringSizeNoTag = 0;
            for (int i2 = 0; i2 < this.addedList_.size(); i2++) {
                iComputeStringSizeNoTag += CodedOutputStream.computeStringSizeNoTag(this.addedList_.get(i2));
            }
            int size = iComputeInt32Size + iComputeStringSizeNoTag + (getAddedListList().size() * 1);
            int iComputeStringSizeNoTag2 = 0;
            for (int i3 = 0; i3 < this.removedList_.size(); i3++) {
                iComputeStringSizeNoTag2 += CodedOutputStream.computeStringSizeNoTag(this.removedList_.get(i3));
            }
            int size2 = size + iComputeStringSizeNoTag2 + (getRemovedListList().size() * 1);
            int iComputeStringSizeNoTag3 = 0;
            for (int i4 = 0; i4 < this.fullList_.size(); i4++) {
                iComputeStringSizeNoTag3 += CodedOutputStream.computeStringSizeNoTag(this.fullList_.get(i4));
            }
            int size3 = size2 + iComputeStringSizeNoTag3 + (getFullListList().size() * 1);
            if ((this.bitField0_ & 8) == 8) {
                size3 += CodedOutputStream.computeStringSize(7, getVersion());
            }
            if ((this.bitField0_ & 16) == 16) {
                size3 += CodedOutputStream.computeInt32Size(8, this.updateInterval_);
            }
            int serializedSize = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public int getUpdateInterval() {
            return this.updateInterval_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public UpdateType getUpdateType() {
            UpdateType updateTypeForNumber = UpdateType.forNumber(this.updateType_);
            return updateTypeForNumber == null ? UpdateType.UpdateNone : updateTypeForNumber;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public String getVersion() {
            return this.version_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public boolean hasEnable() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public boolean hasMoreData() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public boolean hasUpdateInterval() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public boolean hasUpdateType() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.DataOrBuilder
        public boolean hasVersion() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.enable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeEnum(2, this.updateType_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.moreData_);
            }
            for (int i = 0; i < this.addedList_.size(); i++) {
                codedOutputStream.writeString(4, this.addedList_.get(i));
            }
            for (int i2 = 0; i2 < this.removedList_.size(); i2++) {
                codedOutputStream.writeString(5, this.removedList_.get(i2));
            }
            for (int i3 = 0; i3 < this.fullList_.size(); i3++) {
                codedOutputStream.writeString(6, this.fullList_.get(i3));
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeString(7, getVersion());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(8, this.updateInterval_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(Data data) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(data);
        }

        public static Data parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Data) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Data parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Data parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Data parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Data parseFrom(InputStream inputStream) throws IOException {
            return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Data parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Data parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Data parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface DataOrBuilder extends MessageLiteOrBuilder {
        String getAddedList(int i);

        ByteString getAddedListBytes(int i);

        int getAddedListCount();

        List<String> getAddedListList();

        int getEnable();

        String getFullList(int i);

        ByteString getFullListBytes(int i);

        int getFullListCount();

        List<String> getFullListList();

        int getMoreData();

        String getRemovedList(int i);

        ByteString getRemovedListBytes(int i);

        int getRemovedListCount();

        List<String> getRemovedListList();

        int getUpdateInterval();

        UpdateType getUpdateType();

        String getVersion();

        ByteString getVersionBytes();

        boolean hasEnable();

        boolean hasMoreData();

        boolean hasUpdateInterval();

        boolean hasUpdateType();

        boolean hasVersion();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SdkWhiteResponse extends GeneratedMessageLite<SdkWhiteResponse, Builder> implements SdkWhiteResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int DATA_FIELD_NUMBER = 4;
        private static final SdkWhiteResponse DEFAULT_INSTANCE;
        public static final int MSG_FIELD_NUMBER = 2;
        private static volatile Parser<SdkWhiteResponse> PARSER = null;
        public static final int REQUESTID_FIELD_NUMBER = 3;
        private int bitField0_;
        private int code_;
        private Data data_;
        private String msg_ = "";
        private String requestid_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<SdkWhiteResponse, Builder> implements SdkWhiteResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCode() {
                copyOnWrite();
                ((SdkWhiteResponse) this.instance).clearCode();
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((SdkWhiteResponse) this.instance).clearData();
                return this;
            }

            public Builder clearMsg() {
                copyOnWrite();
                ((SdkWhiteResponse) this.instance).clearMsg();
                return this;
            }

            public Builder clearRequestid() {
                copyOnWrite();
                ((SdkWhiteResponse) this.instance).clearRequestid();
                return this;
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
            public int getCode() {
                return ((SdkWhiteResponse) this.instance).getCode();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
            public Data getData() {
                return ((SdkWhiteResponse) this.instance).getData();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
            public String getMsg() {
                return ((SdkWhiteResponse) this.instance).getMsg();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
            public ByteString getMsgBytes() {
                return ((SdkWhiteResponse) this.instance).getMsgBytes();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
            public String getRequestid() {
                return ((SdkWhiteResponse) this.instance).getRequestid();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
            public ByteString getRequestidBytes() {
                return ((SdkWhiteResponse) this.instance).getRequestidBytes();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
            public boolean hasCode() {
                return ((SdkWhiteResponse) this.instance).hasCode();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
            public boolean hasData() {
                return ((SdkWhiteResponse) this.instance).hasData();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
            public boolean hasMsg() {
                return ((SdkWhiteResponse) this.instance).hasMsg();
            }

            @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
            public boolean hasRequestid() {
                return ((SdkWhiteResponse) this.instance).hasRequestid();
            }

            public Builder mergeData(Data data) {
                copyOnWrite();
                ((SdkWhiteResponse) this.instance).mergeData(data);
                return this;
            }

            public Builder setCode(int i) {
                copyOnWrite();
                ((SdkWhiteResponse) this.instance).setCode(i);
                return this;
            }

            public Builder setData(Data data) {
                copyOnWrite();
                ((SdkWhiteResponse) this.instance).setData(data);
                return this;
            }

            public Builder setMsg(String str) {
                copyOnWrite();
                ((SdkWhiteResponse) this.instance).setMsg(str);
                return this;
            }

            public Builder setMsgBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkWhiteResponse) this.instance).setMsgBytes(byteString);
                return this;
            }

            public Builder setRequestid(String str) {
                copyOnWrite();
                ((SdkWhiteResponse) this.instance).setRequestid(str);
                return this;
            }

            public Builder setRequestidBytes(ByteString byteString) {
                copyOnWrite();
                ((SdkWhiteResponse) this.instance).setRequestidBytes(byteString);
                return this;
            }

            private Builder() {
                super(SdkWhiteResponse.DEFAULT_INSTANCE);
            }

            public Builder setData(Data.Builder builder) {
                copyOnWrite();
                ((SdkWhiteResponse) this.instance).setData(builder);
                return this;
            }
        }

        static {
            SdkWhiteResponse sdkWhiteResponse = new SdkWhiteResponse();
            DEFAULT_INSTANCE = sdkWhiteResponse;
            sdkWhiteResponse.makeImmutable();
        }

        private SdkWhiteResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.bitField0_ &= -2;
            this.code_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = null;
            this.bitField0_ &= -9;
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

        public static SdkWhiteResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeData(Data data) {
            Data data2 = this.data_;
            if (data2 == null || data2 == Data.getDefaultInstance()) {
                this.data_ = data;
            } else {
                this.data_ = Data.newBuilder(this.data_).mergeFrom(data).buildPartial();
            }
            this.bitField0_ |= 8;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SdkWhiteResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SdkWhiteResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SdkWhiteResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SdkWhiteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<SdkWhiteResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(int i) {
            this.bitField0_ |= 1;
            this.code_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(Data data) {
            data.getClass();
            this.data_ = data;
            this.bitField0_ |= 8;
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

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SdkWhiteResponse();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    SdkWhiteResponse sdkWhiteResponse = (SdkWhiteResponse) obj2;
                    this.code_ = visitor.visitInt(hasCode(), this.code_, sdkWhiteResponse.hasCode(), sdkWhiteResponse.code_);
                    this.msg_ = visitor.visitString(hasMsg(), this.msg_, sdkWhiteResponse.hasMsg(), sdkWhiteResponse.msg_);
                    this.requestid_ = visitor.visitString(hasRequestid(), this.requestid_, sdkWhiteResponse.hasRequestid(), sdkWhiteResponse.requestid_);
                    this.data_ = (Data) visitor.visitMessage(this.data_, sdkWhiteResponse.data_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= sdkWhiteResponse.bitField0_;
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
                                    Data.Builder builder = (this.bitField0_ & 8) == 8 ? this.data_.toBuilder() : null;
                                    Data data = (Data) codedInputStream.readMessage(Data.parser(), extensionRegistryLite);
                                    this.data_ = data;
                                    if (builder != null) {
                                        builder.mergeFrom(data);
                                        this.data_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 8;
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
                        synchronized (SdkWhiteResponse.class) {
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

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
        public Data getData() {
            Data data = this.data_;
            return data == null ? Data.getDefaultInstance() : data;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
        public String getMsg() {
            return this.msg_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
        public ByteString getMsgBytes() {
            return ByteString.copyFromUtf8(this.msg_);
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
        public String getRequestid() {
            return this.requestid_;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
        public ByteString getRequestidBytes() {
            return ByteString.copyFromUtf8(this.requestid_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.code_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(2, getMsg());
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(3, getRequestid());
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(4, getData());
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
        public boolean hasCode() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
        public boolean hasData() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
        public boolean hasMsg() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.SdkWhiteResponseOrBuilder
        public boolean hasRequestid() {
            return (this.bitField0_ & 4) == 4;
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
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, getData());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(SdkWhiteResponse sdkWhiteResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sdkWhiteResponse);
        }

        public static SdkWhiteResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkWhiteResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SdkWhiteResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkWhiteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SdkWhiteResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SdkWhiteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SdkWhiteResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkWhiteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(Data.Builder builder) {
            this.data_ = builder.build();
            this.bitField0_ |= 8;
        }

        public static SdkWhiteResponse parseFrom(InputStream inputStream) throws IOException {
            return (SdkWhiteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SdkWhiteResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkWhiteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SdkWhiteResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SdkWhiteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SdkWhiteResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkWhiteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SdkWhiteResponseOrBuilder extends MessageLiteOrBuilder {
        int getCode();

        Data getData();

        String getMsg();

        ByteString getMsgBytes();

        String getRequestid();

        ByteString getRequestidBytes();

        boolean hasCode();

        boolean hasData();

        boolean hasMsg();

        boolean hasRequestid();
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum UpdateType implements Internal.EnumLite {
        UpdateNone(0),
        UndateAll(1),
        UpdateIncrement(2);

        public static final int UndateAll_VALUE = 1;
        public static final int UpdateIncrement_VALUE = 2;
        public static final int UpdateNone_VALUE = 0;
        private static final Internal.EnumLiteMap<UpdateType> internalValueMap = new Internal.EnumLiteMap<UpdateType>() { // from class: com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse.UpdateType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public UpdateType findValueByNumber(int i) {
                return UpdateType.forNumber(i);
            }
        };
        private final int value;

        UpdateType(int i) {
            this.value = i;
        }

        public static UpdateType forNumber(int i) {
            if (i == 0) {
                return UpdateNone;
            }
            if (i == 1) {
                return UndateAll;
            }
            if (i != 2) {
                return null;
            }
            return UpdateIncrement;
        }

        public static Internal.EnumLiteMap<UpdateType> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static UpdateType valueOf(int i) {
            return forNumber(i);
        }
    }

    private WkWhiteAdConfigResponse() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
