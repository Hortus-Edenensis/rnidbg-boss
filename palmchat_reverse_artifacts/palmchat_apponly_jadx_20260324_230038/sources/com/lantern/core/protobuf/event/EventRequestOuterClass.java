package com.lantern.core.protobuf.event;

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
import com.lantern.core.protobuf.event.EventOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class EventRequestOuterClass {

    /* JADX INFO: renamed from: com.lantern.core.protobuf.event.EventRequestOuterClass$1, reason: invalid class name */
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
    public static final class EventRequest extends GeneratedMessageLite<EventRequest, Builder> implements EventRequestOrBuilder {
        private static final EventRequest DEFAULT_INSTANCE;
        public static final int EVENTCOUNT_FIELD_NUMBER = 2;
        public static final int EVENTS_FIELD_NUMBER = 1;
        private static volatile Parser<EventRequest> PARSER;
        private int bitField0_;
        private int eventCount_;
        private Internal.ProtobufList<EventOuterClass.Event> events_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<EventRequest, Builder> implements EventRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllEvents(Iterable<? extends EventOuterClass.Event> iterable) {
                copyOnWrite();
                ((EventRequest) this.instance).addAllEvents(iterable);
                return this;
            }

            public Builder addEvents(EventOuterClass.Event event) {
                copyOnWrite();
                ((EventRequest) this.instance).addEvents(event);
                return this;
            }

            public Builder clearEventCount() {
                copyOnWrite();
                ((EventRequest) this.instance).clearEventCount();
                return this;
            }

            public Builder clearEvents() {
                copyOnWrite();
                ((EventRequest) this.instance).clearEvents();
                return this;
            }

            @Override // com.lantern.core.protobuf.event.EventRequestOuterClass.EventRequestOrBuilder
            public int getEventCount() {
                return ((EventRequest) this.instance).getEventCount();
            }

            @Override // com.lantern.core.protobuf.event.EventRequestOuterClass.EventRequestOrBuilder
            public EventOuterClass.Event getEvents(int i) {
                return ((EventRequest) this.instance).getEvents(i);
            }

            @Override // com.lantern.core.protobuf.event.EventRequestOuterClass.EventRequestOrBuilder
            public int getEventsCount() {
                return ((EventRequest) this.instance).getEventsCount();
            }

            @Override // com.lantern.core.protobuf.event.EventRequestOuterClass.EventRequestOrBuilder
            public List<EventOuterClass.Event> getEventsList() {
                return Collections.unmodifiableList(((EventRequest) this.instance).getEventsList());
            }

            public Builder removeEvents(int i) {
                copyOnWrite();
                ((EventRequest) this.instance).removeEvents(i);
                return this;
            }

            public Builder setEventCount(int i) {
                copyOnWrite();
                ((EventRequest) this.instance).setEventCount(i);
                return this;
            }

            public Builder setEvents(int i, EventOuterClass.Event event) {
                copyOnWrite();
                ((EventRequest) this.instance).setEvents(i, event);
                return this;
            }

            private Builder() {
                super(EventRequest.DEFAULT_INSTANCE);
            }

            public Builder addEvents(int i, EventOuterClass.Event event) {
                copyOnWrite();
                ((EventRequest) this.instance).addEvents(i, event);
                return this;
            }

            public Builder setEvents(int i, EventOuterClass.Event.Builder builder) {
                copyOnWrite();
                ((EventRequest) this.instance).setEvents(i, builder);
                return this;
            }

            public Builder addEvents(EventOuterClass.Event.Builder builder) {
                copyOnWrite();
                ((EventRequest) this.instance).addEvents(builder);
                return this;
            }

            public Builder addEvents(int i, EventOuterClass.Event.Builder builder) {
                copyOnWrite();
                ((EventRequest) this.instance).addEvents(i, builder);
                return this;
            }
        }

        static {
            EventRequest eventRequest = new EventRequest();
            DEFAULT_INSTANCE = eventRequest;
            eventRequest.makeImmutable();
        }

        private EventRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllEvents(Iterable<? extends EventOuterClass.Event> iterable) {
            ensureEventsIsMutable();
            AbstractMessageLite.addAll(iterable, this.events_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(EventOuterClass.Event event) {
            event.getClass();
            ensureEventsIsMutable();
            this.events_.add(event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventCount() {
            this.eventCount_ = 0;
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

        public static EventRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static EventRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EventRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EventRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<EventRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeEvents(int i) {
            ensureEventsIsMutable();
            this.events_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCount(int i) {
            this.eventCount_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEvents(int i, EventOuterClass.Event event) {
            event.getClass();
            ensureEventsIsMutable();
            this.events_.set(i, event);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new EventRequest();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.events_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EventRequest eventRequest = (EventRequest) obj2;
                    int i = this.eventCount_;
                    boolean z = i != 0;
                    int i2 = eventRequest.eventCount_;
                    this.eventCount_ = visitor.visitInt(z, i, i2 != 0, i2);
                    this.events_ = visitor.visitList(this.events_, eventRequest.events_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= eventRequest.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    if (!this.events_.isModifiable()) {
                                        this.events_ = GeneratedMessageLite.mutableCopy(this.events_);
                                    }
                                    this.events_.add((EventOuterClass.Event) codedInputStream.readMessage(EventOuterClass.Event.parser(), extensionRegistryLite));
                                } else if (tag == 16) {
                                    this.eventCount_ = codedInputStream.readInt32();
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
                        synchronized (EventRequest.class) {
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

        @Override // com.lantern.core.protobuf.event.EventRequestOuterClass.EventRequestOrBuilder
        public int getEventCount() {
            return this.eventCount_;
        }

        @Override // com.lantern.core.protobuf.event.EventRequestOuterClass.EventRequestOrBuilder
        public EventOuterClass.Event getEvents(int i) {
            return this.events_.get(i);
        }

        @Override // com.lantern.core.protobuf.event.EventRequestOuterClass.EventRequestOrBuilder
        public int getEventsCount() {
            return this.events_.size();
        }

        @Override // com.lantern.core.protobuf.event.EventRequestOuterClass.EventRequestOrBuilder
        public List<EventOuterClass.Event> getEventsList() {
            return this.events_;
        }

        public EventOuterClass.EventOrBuilder getEventsOrBuilder(int i) {
            return this.events_.get(i);
        }

        public List<? extends EventOuterClass.EventOrBuilder> getEventsOrBuilderList() {
            return this.events_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = 0;
            for (int i2 = 0; i2 < this.events_.size(); i2++) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(1, this.events_.get(i2));
            }
            int i3 = this.eventCount_;
            if (i3 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
            }
            this.memoizedSerializedSize = iComputeInt32Size;
            return iComputeInt32Size;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.events_.size(); i++) {
                codedOutputStream.writeMessage(1, this.events_.get(i));
            }
            int i2 = this.eventCount_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(2, i2);
            }
        }

        public static Builder newBuilder(EventRequest eventRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(eventRequest);
        }

        public static EventRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EventRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EventRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(int i, EventOuterClass.Event event) {
            event.getClass();
            ensureEventsIsMutable();
            this.events_.add(i, event);
        }

        public static EventRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEvents(int i, EventOuterClass.Event.Builder builder) {
            ensureEventsIsMutable();
            this.events_.set(i, builder.build());
        }

        public static EventRequest parseFrom(InputStream inputStream) throws IOException {
            return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EventRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(EventOuterClass.Event.Builder builder) {
            ensureEventsIsMutable();
            this.events_.add(builder.build());
        }

        public static EventRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EventRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(int i, EventOuterClass.Event.Builder builder) {
            ensureEventsIsMutable();
            this.events_.add(i, builder.build());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface EventRequestOrBuilder extends MessageLiteOrBuilder {
        int getEventCount();

        EventOuterClass.Event getEvents(int i);

        int getEventsCount();

        List<EventOuterClass.Event> getEventsList();
    }

    private EventRequestOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
