package com.cdadata.sdk.api.protobuf.event;

import com.cdadata.sdk.api.protobuf.event.CdaEventOuterClass;
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
/* JADX INFO: loaded from: classes7.dex */
public final class CdaEventRequestOuterClass {

    /* JADX INFO: renamed from: com.cdadata.sdk.api.protobuf.event.CdaEventRequestOuterClass$1, reason: invalid class name */
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
    public static final class CdaEventRequest extends GeneratedMessageLite<CdaEventRequest, Builder> implements CdaEventRequestOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final CdaEventRequest DEFAULT_INSTANCE;
        public static final int EVENTS_FIELD_NUMBER = 2;
        private static volatile Parser<CdaEventRequest> PARSER;
        private int bitField0_;
        private String appId_ = "";
        private Internal.ProtobufList<CdaEventOuterClass.CdaEvent> events_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<CdaEventRequest, Builder> implements CdaEventRequestOrBuilder {
            private Builder() {
                super(CdaEventRequest.DEFAULT_INSTANCE);
            }

            public Builder addAllEvents(Iterable<? extends CdaEventOuterClass.CdaEvent> iterable) {
                copyOnWrite();
                ((CdaEventRequest) this.instance).addAllEvents(iterable);
                return this;
            }

            public Builder addEvents(int i, CdaEventOuterClass.CdaEvent.Builder builder) {
                copyOnWrite();
                ((CdaEventRequest) this.instance).addEvents(i, builder);
                return this;
            }

            public Builder clearAppId() {
                copyOnWrite();
                ((CdaEventRequest) this.instance).clearAppId();
                return this;
            }

            public Builder clearEvents() {
                copyOnWrite();
                ((CdaEventRequest) this.instance).clearEvents();
                return this;
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventRequestOuterClass.CdaEventRequestOrBuilder
            public String getAppId() {
                return ((CdaEventRequest) this.instance).getAppId();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventRequestOuterClass.CdaEventRequestOrBuilder
            public ByteString getAppIdBytes() {
                return ((CdaEventRequest) this.instance).getAppIdBytes();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventRequestOuterClass.CdaEventRequestOrBuilder
            public CdaEventOuterClass.CdaEvent getEvents(int i) {
                return ((CdaEventRequest) this.instance).getEvents(i);
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventRequestOuterClass.CdaEventRequestOrBuilder
            public int getEventsCount() {
                return ((CdaEventRequest) this.instance).getEventsCount();
            }

            @Override // com.cdadata.sdk.api.protobuf.event.CdaEventRequestOuterClass.CdaEventRequestOrBuilder
            public List<CdaEventOuterClass.CdaEvent> getEventsList() {
                return Collections.unmodifiableList(((CdaEventRequest) this.instance).getEventsList());
            }

            public Builder removeEvents(int i) {
                copyOnWrite();
                ((CdaEventRequest) this.instance).removeEvents(i);
                return this;
            }

            public Builder setAppId(String str) {
                copyOnWrite();
                ((CdaEventRequest) this.instance).setAppId(str);
                return this;
            }

            public Builder setAppIdBytes(ByteString byteString) {
                copyOnWrite();
                ((CdaEventRequest) this.instance).setAppIdBytes(byteString);
                return this;
            }

            public Builder setEvents(int i, CdaEventOuterClass.CdaEvent.Builder builder) {
                copyOnWrite();
                ((CdaEventRequest) this.instance).setEvents(i, builder);
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addEvents(int i, CdaEventOuterClass.CdaEvent cdaEvent) {
                copyOnWrite();
                ((CdaEventRequest) this.instance).addEvents(i, cdaEvent);
                return this;
            }

            public Builder setEvents(int i, CdaEventOuterClass.CdaEvent cdaEvent) {
                copyOnWrite();
                ((CdaEventRequest) this.instance).setEvents(i, cdaEvent);
                return this;
            }

            public Builder addEvents(CdaEventOuterClass.CdaEvent.Builder builder) {
                copyOnWrite();
                ((CdaEventRequest) this.instance).addEvents(builder);
                return this;
            }

            public Builder addEvents(CdaEventOuterClass.CdaEvent cdaEvent) {
                copyOnWrite();
                ((CdaEventRequest) this.instance).addEvents(cdaEvent);
                return this;
            }
        }

        static {
            CdaEventRequest cdaEventRequest = new CdaEventRequest();
            DEFAULT_INSTANCE = cdaEventRequest;
            cdaEventRequest.makeImmutable();
        }

        private CdaEventRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllEvents(Iterable<? extends CdaEventOuterClass.CdaEvent> iterable) {
            ensureEventsIsMutable();
            AbstractMessageLite.addAll(iterable, this.events_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(int i, CdaEventOuterClass.CdaEvent.Builder builder) {
            ensureEventsIsMutable();
            this.events_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppId() {
            this.appId_ = getDefaultInstance().getAppId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEvents() {
            this.events_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureEventsIsMutable() {
            if (this.events_.isModifiable()) {
                return;
            }
            this.events_ = GeneratedMessageLite.mutableCopy(this.events_);
        }

        public static CdaEventRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CdaEventRequest parseDelimitedFrom(InputStream inputStream) {
            return (CdaEventRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CdaEventRequest parseFrom(ByteString byteString) {
            return (CdaEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<CdaEventRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeEvents(int i) {
            ensureEventsIsMutable();
            this.events_.remove(i);
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
        public void setEvents(int i, CdaEventOuterClass.CdaEvent.Builder builder) {
            ensureEventsIsMutable();
            this.events_.set(i, builder.build());
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CdaEventRequest();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.events_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CdaEventRequest cdaEventRequest = (CdaEventRequest) obj2;
                    this.appId_ = visitor.visitString(!this.appId_.isEmpty(), this.appId_, true ^ cdaEventRequest.appId_.isEmpty(), cdaEventRequest.appId_);
                    this.events_ = visitor.visitList(this.events_, cdaEventRequest.events_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= cdaEventRequest.bitField0_;
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
                                    if (!this.events_.isModifiable()) {
                                        this.events_ = GeneratedMessageLite.mutableCopy(this.events_);
                                    }
                                    this.events_.add((CdaEventOuterClass.CdaEvent) codedInputStream.readMessage(CdaEventOuterClass.CdaEvent.parser(), extensionRegistryLite));
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
                        synchronized (CdaEventRequest.class) {
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

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventRequestOuterClass.CdaEventRequestOrBuilder
        public String getAppId() {
            return this.appId_;
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventRequestOuterClass.CdaEventRequestOrBuilder
        public ByteString getAppIdBytes() {
            return ByteString.copyFromUtf8(this.appId_);
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventRequestOuterClass.CdaEventRequestOrBuilder
        public CdaEventOuterClass.CdaEvent getEvents(int i) {
            return this.events_.get(i);
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventRequestOuterClass.CdaEventRequestOrBuilder
        public int getEventsCount() {
            return this.events_.size();
        }

        @Override // com.cdadata.sdk.api.protobuf.event.CdaEventRequestOuterClass.CdaEventRequestOrBuilder
        public List<CdaEventOuterClass.CdaEvent> getEventsList() {
            return this.events_;
        }

        public CdaEventOuterClass.CdaEventOrBuilder getEventsOrBuilder(int i) {
            return this.events_.get(i);
        }

        public List<? extends CdaEventOuterClass.CdaEventOrBuilder> getEventsOrBuilderList() {
            return this.events_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = !this.appId_.isEmpty() ? CodedOutputStream.computeStringSize(1, getAppId()) + 0 : 0;
            for (int i2 = 0; i2 < this.events_.size(); i2++) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(2, this.events_.get(i2));
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.appId_.isEmpty()) {
                codedOutputStream.writeString(1, getAppId());
            }
            for (int i = 0; i < this.events_.size(); i++) {
                codedOutputStream.writeMessage(2, this.events_.get(i));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(int i, CdaEventOuterClass.CdaEvent cdaEvent) {
            cdaEvent.getClass();
            ensureEventsIsMutable();
            this.events_.add(i, cdaEvent);
        }

        public static Builder newBuilder(CdaEventRequest cdaEventRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cdaEventRequest);
        }

        public static CdaEventRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CdaEventRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CdaEventRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CdaEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEvents(int i, CdaEventOuterClass.CdaEvent cdaEvent) {
            cdaEvent.getClass();
            ensureEventsIsMutable();
            this.events_.set(i, cdaEvent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(CdaEventOuterClass.CdaEvent.Builder builder) {
            ensureEventsIsMutable();
            this.events_.add(builder.build());
        }

        public static CdaEventRequest parseFrom(CodedInputStream codedInputStream) {
            return (CdaEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(CdaEventOuterClass.CdaEvent cdaEvent) {
            cdaEvent.getClass();
            ensureEventsIsMutable();
            this.events_.add(cdaEvent);
        }

        public static CdaEventRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CdaEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static CdaEventRequest parseFrom(InputStream inputStream) {
            return (CdaEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CdaEventRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CdaEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CdaEventRequest parseFrom(byte[] bArr) {
            return (CdaEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CdaEventRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CdaEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CdaEventRequestOrBuilder extends MessageLiteOrBuilder {
        String getAppId();

        ByteString getAppIdBytes();

        CdaEventOuterClass.CdaEvent getEvents(int i);

        int getEventsCount();

        List<CdaEventOuterClass.CdaEvent> getEventsList();
    }

    private CdaEventRequestOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
