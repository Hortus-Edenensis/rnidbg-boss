package com.cdadata.sdk.api.protobuf.event;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class CdaEventOuterClass {

    /* JADX INFO: renamed from: com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

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
    public static final class CdaEvent extends GeneratedMessageLite<CdaEvent, Builder> implements CdaEventOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final CdaEvent DEFAULT_INSTANCE;
        public static final int EVENTDATE_FIELD_NUMBER = 4;
        public static final int EVENTNAME_FIELD_NUMBER = 2;
        public static final int EVENTTIME_FIELD_NUMBER = 5;
        public static final int EVENTTYPE_FIELD_NUMBER = 3;
        public static final int EXTRA_FIELD_NUMBER = 9;
        public static final int FLUSHTIME_FIELD_NUMBER = 7;
        private static volatile Parser<CdaEvent> PARSER = null;
        public static final int PROPERTIES_FIELD_NUMBER = 8;
        public static final int SEQUENCE_FIELD_NUMBER = 6;
        private int bitField0_;
        private MapFieldLite<String, String> properties_ = MapFieldLite.emptyMapField();
        private String appId_ = "";
        private String eventName_ = "";
        private String eventType_ = "";
        private String eventDate_ = "";
        private String eventTime_ = "";
        private String sequence_ = "";
        private String flushTime_ = "";
        private String extra_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<CdaEvent, Builder> implements CdaEventOrBuilder {
            private Builder() {
                super(CdaEvent.DEFAULT_INSTANCE);
            }

            public Builder clearAppId() {
                copyOnWrite();
                ((CdaEvent) this.instance).clearAppId();
                return this;
            }

            public Builder clearEventDate() {
                copyOnWrite();
                ((CdaEvent) this.instance).clearEventDate();
                return this;
            }

            public Builder clearEventName() {
                copyOnWrite();
                ((CdaEvent) this.instance).clearEventName();
                return this;
            }

            public Builder clearEventTime() {
                copyOnWrite();
                ((CdaEvent) this.instance).clearEventTime();
                return this;
            }

            public Builder clearEventType() {
                copyOnWrite();
                ((CdaEvent) this.instance).clearEventType();
                return this;
            }

            public Builder clearExtra() {
                copyOnWrite();
                ((CdaEvent) this.instance).clearExtra();
                return this;
            }

            public Builder clearFlushTime() {
                copyOnWrite();
                ((CdaEvent) this.instance).clearFlushTime();
                return this;
            }

            public Builder clearProperties() {
                copyOnWrite();
                ((CdaEvent) this.instance).getMutablePropertiesMap().clear();
                return this;
            }

            public Builder clearSequence() {
                copyOnWrite();
                ((CdaEvent) this.instance).clearSequence();
                return this;
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public boolean containsProperties(String str) {
                str.getClass();
                return ((CdaEvent) this.instance).getPropertiesMap().containsKey(str);
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public String getAppId() {
                return ((CdaEvent) this.instance).getAppId();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public ByteString getAppIdBytes() {
                return ((CdaEvent) this.instance).getAppIdBytes();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public String getEventDate() {
                return ((CdaEvent) this.instance).getEventDate();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public ByteString getEventDateBytes() {
                return ((CdaEvent) this.instance).getEventDateBytes();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public String getEventName() {
                return ((CdaEvent) this.instance).getEventName();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public ByteString getEventNameBytes() {
                return ((CdaEvent) this.instance).getEventNameBytes();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public String getEventTime() {
                return ((CdaEvent) this.instance).getEventTime();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public ByteString getEventTimeBytes() {
                return ((CdaEvent) this.instance).getEventTimeBytes();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public String getEventType() {
                return ((CdaEvent) this.instance).getEventType();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public ByteString getEventTypeBytes() {
                return ((CdaEvent) this.instance).getEventTypeBytes();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public String getExtra() {
                return ((CdaEvent) this.instance).getExtra();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public ByteString getExtraBytes() {
                return ((CdaEvent) this.instance).getExtraBytes();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public String getFlushTime() {
                return ((CdaEvent) this.instance).getFlushTime();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public ByteString getFlushTimeBytes() {
                return ((CdaEvent) this.instance).getFlushTimeBytes();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            @Deprecated
            public Map<String, String> getProperties() {
                return getPropertiesMap();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public int getPropertiesCount() {
                return ((CdaEvent) this.instance).getPropertiesMap().size();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public Map<String, String> getPropertiesMap() {
                return Collections.unmodifiableMap(((CdaEvent) this.instance).getPropertiesMap());
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public String getPropertiesOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> propertiesMap = ((CdaEvent) this.instance).getPropertiesMap();
                return propertiesMap.containsKey(str) ? propertiesMap.get(str) : str2;
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public String getPropertiesOrThrow(String str) {
                str.getClass();
                Map<String, String> propertiesMap = ((CdaEvent) this.instance).getPropertiesMap();
                if (propertiesMap.containsKey(str)) {
                    return propertiesMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public String getSequence() {
                return ((CdaEvent) this.instance).getSequence();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
            public ByteString getSequenceBytes() {
                return ((CdaEvent) this.instance).getSequenceBytes();
            }

            public Builder putAllProperties(Map<String, String> map) {
                copyOnWrite();
                ((CdaEvent) this.instance).getMutablePropertiesMap().putAll(map);
                return this;
            }

            public Builder putProperties(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((CdaEvent) this.instance).getMutablePropertiesMap().put(str, str2);
                return this;
            }

            public Builder removeProperties(String str) {
                str.getClass();
                copyOnWrite();
                ((CdaEvent) this.instance).getMutablePropertiesMap().remove(str);
                return this;
            }

            public Builder setAppId(String str) {
                copyOnWrite();
                ((CdaEvent) this.instance).setAppId(str);
                return this;
            }

            public Builder setAppIdBytes(ByteString byteString) {
                copyOnWrite();
                ((CdaEvent) this.instance).setAppIdBytes(byteString);
                return this;
            }

            public Builder setEventDate(String str) {
                copyOnWrite();
                ((CdaEvent) this.instance).setEventDate(str);
                return this;
            }

            public Builder setEventDateBytes(ByteString byteString) {
                copyOnWrite();
                ((CdaEvent) this.instance).setEventDateBytes(byteString);
                return this;
            }

            public Builder setEventName(String str) {
                copyOnWrite();
                ((CdaEvent) this.instance).setEventName(str);
                return this;
            }

            public Builder setEventNameBytes(ByteString byteString) {
                copyOnWrite();
                ((CdaEvent) this.instance).setEventNameBytes(byteString);
                return this;
            }

            public Builder setEventTime(String str) {
                copyOnWrite();
                ((CdaEvent) this.instance).setEventTime(str);
                return this;
            }

            public Builder setEventTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((CdaEvent) this.instance).setEventTimeBytes(byteString);
                return this;
            }

            public Builder setEventType(String str) {
                copyOnWrite();
                ((CdaEvent) this.instance).setEventType(str);
                return this;
            }

            public Builder setEventTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((CdaEvent) this.instance).setEventTypeBytes(byteString);
                return this;
            }

            public Builder setExtra(String str) {
                copyOnWrite();
                ((CdaEvent) this.instance).setExtra(str);
                return this;
            }

            public Builder setExtraBytes(ByteString byteString) {
                copyOnWrite();
                ((CdaEvent) this.instance).setExtraBytes(byteString);
                return this;
            }

            public Builder setFlushTime(String str) {
                copyOnWrite();
                ((CdaEvent) this.instance).setFlushTime(str);
                return this;
            }

            public Builder setFlushTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((CdaEvent) this.instance).setFlushTimeBytes(byteString);
                return this;
            }

            public Builder setSequence(String str) {
                copyOnWrite();
                ((CdaEvent) this.instance).setSequence(str);
                return this;
            }

            public Builder setSequenceBytes(ByteString byteString) {
                copyOnWrite();
                ((CdaEvent) this.instance).setSequenceBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class PropertiesDefaultEntryHolder {
            public static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private PropertiesDefaultEntryHolder() {
            }
        }

        static {
            CdaEvent cdaEvent = new CdaEvent();
            DEFAULT_INSTANCE = cdaEvent;
            cdaEvent.makeImmutable();
        }

        private CdaEvent() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppId() {
            this.appId_ = getDefaultInstance().getAppId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventDate() {
            this.eventDate_ = getDefaultInstance().getEventDate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventName() {
            this.eventName_ = getDefaultInstance().getEventName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventTime() {
            this.eventTime_ = getDefaultInstance().getEventTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventType() {
            this.eventType_ = getDefaultInstance().getEventType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExtra() {
            this.extra_ = getDefaultInstance().getExtra();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFlushTime() {
            this.flushTime_ = getDefaultInstance().getFlushTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSequence() {
            this.sequence_ = getDefaultInstance().getSequence();
        }

        public static CdaEvent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutablePropertiesMap() {
            return internalGetMutableProperties();
        }

        private MapFieldLite<String, String> internalGetMutableProperties() {
            if (!this.properties_.isMutable()) {
                this.properties_ = this.properties_.mutableCopy();
            }
            return this.properties_;
        }

        private MapFieldLite<String, String> internalGetProperties() {
            return this.properties_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CdaEvent parseDelimitedFrom(InputStream inputStream) {
            return (CdaEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CdaEvent parseFrom(ByteString byteString) {
            return (CdaEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<CdaEvent> parser() {
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
        public void setEventDate(String str) {
            str.getClass();
            this.eventDate_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventDateBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.eventDate_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventName(String str) {
            str.getClass();
            this.eventName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventNameBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.eventName_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventTime(String str) {
            str.getClass();
            this.eventTime_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventTimeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.eventTime_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventType(String str) {
            str.getClass();
            this.eventType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventTypeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.eventType_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtra(String str) {
            str.getClass();
            this.extra_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtraBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.extra_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFlushTime(String str) {
            str.getClass();
            this.flushTime_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFlushTimeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.flushTime_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSequence(String str) {
            str.getClass();
            this.sequence_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSequenceBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sequence_ = byteString.toStringUtf8();
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public boolean containsProperties(String str) {
            str.getClass();
            return internalGetProperties().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CdaEvent();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.properties_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CdaEvent cdaEvent = (CdaEvent) obj2;
                    this.appId_ = visitor.visitString(!this.appId_.isEmpty(), this.appId_, !cdaEvent.appId_.isEmpty(), cdaEvent.appId_);
                    this.eventName_ = visitor.visitString(!this.eventName_.isEmpty(), this.eventName_, !cdaEvent.eventName_.isEmpty(), cdaEvent.eventName_);
                    this.eventType_ = visitor.visitString(!this.eventType_.isEmpty(), this.eventType_, !cdaEvent.eventType_.isEmpty(), cdaEvent.eventType_);
                    this.eventDate_ = visitor.visitString(!this.eventDate_.isEmpty(), this.eventDate_, !cdaEvent.eventDate_.isEmpty(), cdaEvent.eventDate_);
                    this.eventTime_ = visitor.visitString(!this.eventTime_.isEmpty(), this.eventTime_, !cdaEvent.eventTime_.isEmpty(), cdaEvent.eventTime_);
                    this.sequence_ = visitor.visitString(!this.sequence_.isEmpty(), this.sequence_, !cdaEvent.sequence_.isEmpty(), cdaEvent.sequence_);
                    this.flushTime_ = visitor.visitString(!this.flushTime_.isEmpty(), this.flushTime_, !cdaEvent.flushTime_.isEmpty(), cdaEvent.flushTime_);
                    this.properties_ = visitor.visitMap(this.properties_, cdaEvent.internalGetProperties());
                    this.extra_ = visitor.visitString(!this.extra_.isEmpty(), this.extra_, true ^ cdaEvent.extra_.isEmpty(), cdaEvent.extra_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= cdaEvent.bitField0_;
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
                                    this.appId_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    this.eventName_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    this.eventType_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 34) {
                                    this.eventDate_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 42) {
                                    this.eventTime_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 50) {
                                    this.sequence_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 58) {
                                    this.flushTime_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 66) {
                                    if (!this.properties_.isMutable()) {
                                        this.properties_ = this.properties_.mutableCopy();
                                    }
                                    PropertiesDefaultEntryHolder.defaultEntry.parseInto(this.properties_, codedInputStream, extensionRegistryLite);
                                } else if (tag == 74) {
                                    this.extra_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (CdaEvent.class) {
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

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public String getAppId() {
            return this.appId_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public ByteString getAppIdBytes() {
            return ByteString.copyFromUtf8(this.appId_);
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public String getEventDate() {
            return this.eventDate_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public ByteString getEventDateBytes() {
            return ByteString.copyFromUtf8(this.eventDate_);
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public String getEventName() {
            return this.eventName_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public ByteString getEventNameBytes() {
            return ByteString.copyFromUtf8(this.eventName_);
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public String getEventTime() {
            return this.eventTime_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public ByteString getEventTimeBytes() {
            return ByteString.copyFromUtf8(this.eventTime_);
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public String getEventType() {
            return this.eventType_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public ByteString getEventTypeBytes() {
            return ByteString.copyFromUtf8(this.eventType_);
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public String getExtra() {
            return this.extra_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public ByteString getExtraBytes() {
            return ByteString.copyFromUtf8(this.extra_);
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public String getFlushTime() {
            return this.flushTime_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public ByteString getFlushTimeBytes() {
            return ByteString.copyFromUtf8(this.flushTime_);
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        @Deprecated
        public Map<String, String> getProperties() {
            return getPropertiesMap();
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public int getPropertiesCount() {
            return internalGetProperties().size();
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public Map<String, String> getPropertiesMap() {
            return Collections.unmodifiableMap(internalGetProperties());
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public String getPropertiesOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetProperties = internalGetProperties();
            return mapFieldLiteInternalGetProperties.containsKey(str) ? mapFieldLiteInternalGetProperties.get(str) : str2;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public String getPropertiesOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetProperties = internalGetProperties();
            if (mapFieldLiteInternalGetProperties.containsKey(str)) {
                return mapFieldLiteInternalGetProperties.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public String getSequence() {
            return this.sequence_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass.CdaEventOrBuilder
        public ByteString getSequenceBytes() {
            return ByteString.copyFromUtf8(this.sequence_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.appId_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getAppId());
            if (!this.eventName_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getEventName());
            }
            if (!this.eventType_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getEventType());
            }
            if (!this.eventDate_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, getEventDate());
            }
            if (!this.eventTime_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, getEventTime());
            }
            if (!this.sequence_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(6, getSequence());
            }
            if (!this.flushTime_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(7, getFlushTime());
            }
            for (Map.Entry<String, String> entry : internalGetProperties().entrySet()) {
                iComputeStringSize += PropertiesDefaultEntryHolder.defaultEntry.computeMessageSize(8, entry.getKey(), entry.getValue());
            }
            if (!this.extra_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(9, getExtra());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.appId_.isEmpty()) {
                codedOutputStream.writeString(1, getAppId());
            }
            if (!this.eventName_.isEmpty()) {
                codedOutputStream.writeString(2, getEventName());
            }
            if (!this.eventType_.isEmpty()) {
                codedOutputStream.writeString(3, getEventType());
            }
            if (!this.eventDate_.isEmpty()) {
                codedOutputStream.writeString(4, getEventDate());
            }
            if (!this.eventTime_.isEmpty()) {
                codedOutputStream.writeString(5, getEventTime());
            }
            if (!this.sequence_.isEmpty()) {
                codedOutputStream.writeString(6, getSequence());
            }
            if (!this.flushTime_.isEmpty()) {
                codedOutputStream.writeString(7, getFlushTime());
            }
            for (Map.Entry<String, String> entry : internalGetProperties().entrySet()) {
                PropertiesDefaultEntryHolder.defaultEntry.serializeTo(codedOutputStream, 8, entry.getKey(), entry.getValue());
            }
            if (this.extra_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(9, getExtra());
        }

        public static Builder newBuilder(CdaEvent cdaEvent) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cdaEvent);
        }

        public static CdaEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CdaEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CdaEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CdaEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CdaEvent parseFrom(CodedInputStream codedInputStream) {
            return (CdaEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CdaEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CdaEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static CdaEvent parseFrom(InputStream inputStream) {
            return (CdaEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CdaEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CdaEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CdaEvent parseFrom(byte[] bArr) {
            return (CdaEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CdaEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CdaEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CdaEventOrBuilder extends MessageLiteOrBuilder {
        boolean containsProperties(String str);

        String getAppId();

        ByteString getAppIdBytes();

        String getEventDate();

        ByteString getEventDateBytes();

        String getEventName();

        ByteString getEventNameBytes();

        String getEventTime();

        ByteString getEventTimeBytes();

        String getEventType();

        ByteString getEventTypeBytes();

        String getExtra();

        ByteString getExtraBytes();

        String getFlushTime();

        ByteString getFlushTimeBytes();

        @Deprecated
        Map<String, String> getProperties();

        int getPropertiesCount();

        Map<String, String> getPropertiesMap();

        String getPropertiesOrDefault(String str, String str2);

        String getPropertiesOrThrow(String str);

        String getSequence();

        ByteString getSequenceBytes();
    }

    private CdaEventOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
