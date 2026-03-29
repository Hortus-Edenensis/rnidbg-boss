package com.lantern.core.protobuf.event;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.lantern.core.protobuf.ProtobufRequestBeanOuterClass;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class EventOuterClass {

    /* JADX INFO: renamed from: com.lantern.core.protobuf.event.EventOuterClass$1, reason: invalid class name */
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
    public static final class Event extends GeneratedMessageLite<Event, Builder> implements EventOrBuilder {
        public static final int COMMONPARAMETERS_FIELD_NUMBER = 2;
        private static final Event DEFAULT_INSTANCE;
        public static final int EVENTID_FIELD_NUMBER = 1;
        public static final int FOREORBACK_FIELD_NUMBER = 6;
        public static final int MSG_FIELD_NUMBER = 3;
        private static volatile Parser<Event> PARSER = null;
        public static final int SOURCE_FIELD_NUMBER = 5;
        public static final int TAICHI_FIELD_NUMBER = 4;
        private ProtobufRequestBeanOuterClass.ProtobufRequestBean commonParameters_;
        private int foreOrBack_;
        private Taichi taichi_;
        private String eventId_ = "";
        private String msg_ = "";
        private String source_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<Event, Builder> implements EventOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCommonParameters() {
                copyOnWrite();
                ((Event) this.instance).clearCommonParameters();
                return this;
            }

            public Builder clearEventId() {
                copyOnWrite();
                ((Event) this.instance).clearEventId();
                return this;
            }

            public Builder clearForeOrBack() {
                copyOnWrite();
                ((Event) this.instance).clearForeOrBack();
                return this;
            }

            public Builder clearMsg() {
                copyOnWrite();
                ((Event) this.instance).clearMsg();
                return this;
            }

            public Builder clearSource() {
                copyOnWrite();
                ((Event) this.instance).clearSource();
                return this;
            }

            public Builder clearTaichi() {
                copyOnWrite();
                ((Event) this.instance).clearTaichi();
                return this;
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
            public ProtobufRequestBeanOuterClass.ProtobufRequestBean getCommonParameters() {
                return ((Event) this.instance).getCommonParameters();
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
            public String getEventId() {
                return ((Event) this.instance).getEventId();
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
            public ByteString getEventIdBytes() {
                return ((Event) this.instance).getEventIdBytes();
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
            public int getForeOrBack() {
                return ((Event) this.instance).getForeOrBack();
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
            public String getMsg() {
                return ((Event) this.instance).getMsg();
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
            public ByteString getMsgBytes() {
                return ((Event) this.instance).getMsgBytes();
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
            public String getSource() {
                return ((Event) this.instance).getSource();
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
            public ByteString getSourceBytes() {
                return ((Event) this.instance).getSourceBytes();
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
            public Taichi getTaichi() {
                return ((Event) this.instance).getTaichi();
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
            public boolean hasCommonParameters() {
                return ((Event) this.instance).hasCommonParameters();
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
            public boolean hasTaichi() {
                return ((Event) this.instance).hasTaichi();
            }

            public Builder mergeCommonParameters(ProtobufRequestBeanOuterClass.ProtobufRequestBean protobufRequestBean) {
                copyOnWrite();
                ((Event) this.instance).mergeCommonParameters(protobufRequestBean);
                return this;
            }

            public Builder mergeTaichi(Taichi taichi) {
                copyOnWrite();
                ((Event) this.instance).mergeTaichi(taichi);
                return this;
            }

            public Builder setCommonParameters(ProtobufRequestBeanOuterClass.ProtobufRequestBean protobufRequestBean) {
                copyOnWrite();
                ((Event) this.instance).setCommonParameters(protobufRequestBean);
                return this;
            }

            public Builder setEventId(String str) {
                copyOnWrite();
                ((Event) this.instance).setEventId(str);
                return this;
            }

            public Builder setEventIdBytes(ByteString byteString) {
                copyOnWrite();
                ((Event) this.instance).setEventIdBytes(byteString);
                return this;
            }

            public Builder setForeOrBack(int i) {
                copyOnWrite();
                ((Event) this.instance).setForeOrBack(i);
                return this;
            }

            public Builder setMsg(String str) {
                copyOnWrite();
                ((Event) this.instance).setMsg(str);
                return this;
            }

            public Builder setMsgBytes(ByteString byteString) {
                copyOnWrite();
                ((Event) this.instance).setMsgBytes(byteString);
                return this;
            }

            public Builder setSource(String str) {
                copyOnWrite();
                ((Event) this.instance).setSource(str);
                return this;
            }

            public Builder setSourceBytes(ByteString byteString) {
                copyOnWrite();
                ((Event) this.instance).setSourceBytes(byteString);
                return this;
            }

            public Builder setTaichi(Taichi taichi) {
                copyOnWrite();
                ((Event) this.instance).setTaichi(taichi);
                return this;
            }

            private Builder() {
                super(Event.DEFAULT_INSTANCE);
            }

            public Builder setCommonParameters(ProtobufRequestBeanOuterClass.ProtobufRequestBean.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setCommonParameters(builder);
                return this;
            }

            public Builder setTaichi(Taichi.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setTaichi(builder);
                return this;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class Taichi extends GeneratedMessageLite<Taichi, Builder> implements TaichiOrBuilder {
            public static final int BUCKETID_FIELD_NUMBER = 4;
            private static final Taichi DEFAULT_INSTANCE;
            public static final int EXPID_FIELD_NUMBER = 1;
            public static final int GROUPID_FIELD_NUMBER = 2;
            private static volatile Parser<Taichi> PARSER = null;
            public static final int PROCESSID_FIELD_NUMBER = 5;
            public static final int SESSIONID_FIELD_NUMBER = 6;
            public static final int VERSIONNUM_FIELD_NUMBER = 3;
            private long bucketId_;
            private long expId_;
            private long groupId_;
            private String processId_ = "";
            private String sessionId_ = "";
            private long versionNum_;

            /* JADX INFO: compiled from: SearchBox */
            public static final class Builder extends GeneratedMessageLite.Builder<Taichi, Builder> implements TaichiOrBuilder {
                public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearBucketId() {
                    copyOnWrite();
                    ((Taichi) this.instance).clearBucketId();
                    return this;
                }

                public Builder clearExpId() {
                    copyOnWrite();
                    ((Taichi) this.instance).clearExpId();
                    return this;
                }

                public Builder clearGroupId() {
                    copyOnWrite();
                    ((Taichi) this.instance).clearGroupId();
                    return this;
                }

                public Builder clearProcessId() {
                    copyOnWrite();
                    ((Taichi) this.instance).clearProcessId();
                    return this;
                }

                public Builder clearSessionId() {
                    copyOnWrite();
                    ((Taichi) this.instance).clearSessionId();
                    return this;
                }

                public Builder clearVersionNum() {
                    copyOnWrite();
                    ((Taichi) this.instance).clearVersionNum();
                    return this;
                }

                @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
                public long getBucketId() {
                    return ((Taichi) this.instance).getBucketId();
                }

                @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
                public long getExpId() {
                    return ((Taichi) this.instance).getExpId();
                }

                @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
                public long getGroupId() {
                    return ((Taichi) this.instance).getGroupId();
                }

                @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
                public String getProcessId() {
                    return ((Taichi) this.instance).getProcessId();
                }

                @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
                public ByteString getProcessIdBytes() {
                    return ((Taichi) this.instance).getProcessIdBytes();
                }

                @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
                public String getSessionId() {
                    return ((Taichi) this.instance).getSessionId();
                }

                @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
                public ByteString getSessionIdBytes() {
                    return ((Taichi) this.instance).getSessionIdBytes();
                }

                @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
                public long getVersionNum() {
                    return ((Taichi) this.instance).getVersionNum();
                }

                public Builder setBucketId(long j) {
                    copyOnWrite();
                    ((Taichi) this.instance).setBucketId(j);
                    return this;
                }

                public Builder setExpId(long j) {
                    copyOnWrite();
                    ((Taichi) this.instance).setExpId(j);
                    return this;
                }

                public Builder setGroupId(long j) {
                    copyOnWrite();
                    ((Taichi) this.instance).setGroupId(j);
                    return this;
                }

                public Builder setProcessId(String str) {
                    copyOnWrite();
                    ((Taichi) this.instance).setProcessId(str);
                    return this;
                }

                public Builder setProcessIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Taichi) this.instance).setProcessIdBytes(byteString);
                    return this;
                }

                public Builder setSessionId(String str) {
                    copyOnWrite();
                    ((Taichi) this.instance).setSessionId(str);
                    return this;
                }

                public Builder setSessionIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Taichi) this.instance).setSessionIdBytes(byteString);
                    return this;
                }

                public Builder setVersionNum(long j) {
                    copyOnWrite();
                    ((Taichi) this.instance).setVersionNum(j);
                    return this;
                }

                private Builder() {
                    super(Taichi.DEFAULT_INSTANCE);
                }
            }

            static {
                Taichi taichi = new Taichi();
                DEFAULT_INSTANCE = taichi;
                taichi.makeImmutable();
            }

            private Taichi() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBucketId() {
                this.bucketId_ = 0L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearExpId() {
                this.expId_ = 0L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearGroupId() {
                this.groupId_ = 0L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearProcessId() {
                this.processId_ = getDefaultInstance().getProcessId();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSessionId() {
                this.sessionId_ = getDefaultInstance().getSessionId();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVersionNum() {
                this.versionNum_ = 0L;
            }

            public static Taichi getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Taichi parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Taichi) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Taichi parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Taichi) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Taichi> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBucketId(long j) {
                this.bucketId_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setExpId(long j) {
                this.expId_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setGroupId(long j) {
                this.groupId_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setProcessId(String str) {
                str.getClass();
                this.processId_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setProcessIdBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.processId_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSessionId(String str) {
                str.getClass();
                this.sessionId_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSessionIdBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.sessionId_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersionNum(long j) {
                this.versionNum_ = j;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                boolean z = false;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Taichi();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Taichi taichi = (Taichi) obj2;
                        long j = this.expId_;
                        boolean z2 = j != 0;
                        long j2 = taichi.expId_;
                        this.expId_ = visitor.visitLong(z2, j, j2 != 0, j2);
                        long j3 = this.groupId_;
                        boolean z3 = j3 != 0;
                        long j4 = taichi.groupId_;
                        this.groupId_ = visitor.visitLong(z3, j3, j4 != 0, j4);
                        long j5 = this.versionNum_;
                        boolean z4 = j5 != 0;
                        long j6 = taichi.versionNum_;
                        this.versionNum_ = visitor.visitLong(z4, j5, j6 != 0, j6);
                        long j7 = this.bucketId_;
                        boolean z5 = j7 != 0;
                        long j8 = taichi.bucketId_;
                        this.bucketId_ = visitor.visitLong(z5, j7, j8 != 0, j8);
                        this.processId_ = visitor.visitString(!this.processId_.isEmpty(), this.processId_, !taichi.processId_.isEmpty(), taichi.processId_);
                        this.sessionId_ = visitor.visitString(!this.sessionId_.isEmpty(), this.sessionId_, !taichi.sessionId_.isEmpty(), taichi.sessionId_);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        while (!z) {
                            try {
                                int tag = codedInputStream.readTag();
                                if (tag != 0) {
                                    if (tag == 8) {
                                        this.expId_ = codedInputStream.readInt64();
                                    } else if (tag == 16) {
                                        this.groupId_ = codedInputStream.readInt64();
                                    } else if (tag == 24) {
                                        this.versionNum_ = codedInputStream.readInt64();
                                    } else if (tag == 32) {
                                        this.bucketId_ = codedInputStream.readInt64();
                                    } else if (tag == 42) {
                                        this.processId_ = codedInputStream.readStringRequireUtf8();
                                    } else if (tag == 50) {
                                        this.sessionId_ = codedInputStream.readStringRequireUtf8();
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
                            synchronized (Taichi.class) {
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

            @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
            public long getBucketId() {
                return this.bucketId_;
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
            public long getExpId() {
                return this.expId_;
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
            public long getGroupId() {
                return this.groupId_;
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
            public String getProcessId() {
                return this.processId_;
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
            public ByteString getProcessIdBytes() {
                return ByteString.copyFromUtf8(this.processId_);
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                long j = this.expId_;
                int iComputeInt64Size = j != 0 ? 0 + CodedOutputStream.computeInt64Size(1, j) : 0;
                long j2 = this.groupId_;
                if (j2 != 0) {
                    iComputeInt64Size += CodedOutputStream.computeInt64Size(2, j2);
                }
                long j3 = this.versionNum_;
                if (j3 != 0) {
                    iComputeInt64Size += CodedOutputStream.computeInt64Size(3, j3);
                }
                long j4 = this.bucketId_;
                if (j4 != 0) {
                    iComputeInt64Size += CodedOutputStream.computeInt64Size(4, j4);
                }
                if (!this.processId_.isEmpty()) {
                    iComputeInt64Size += CodedOutputStream.computeStringSize(5, getProcessId());
                }
                if (!this.sessionId_.isEmpty()) {
                    iComputeInt64Size += CodedOutputStream.computeStringSize(6, getSessionId());
                }
                this.memoizedSerializedSize = iComputeInt64Size;
                return iComputeInt64Size;
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
            public String getSessionId() {
                return this.sessionId_;
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
            public ByteString getSessionIdBytes() {
                return ByteString.copyFromUtf8(this.sessionId_);
            }

            @Override // com.lantern.core.protobuf.event.EventOuterClass.Event.TaichiOrBuilder
            public long getVersionNum() {
                return this.versionNum_;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                long j = this.expId_;
                if (j != 0) {
                    codedOutputStream.writeInt64(1, j);
                }
                long j2 = this.groupId_;
                if (j2 != 0) {
                    codedOutputStream.writeInt64(2, j2);
                }
                long j3 = this.versionNum_;
                if (j3 != 0) {
                    codedOutputStream.writeInt64(3, j3);
                }
                long j4 = this.bucketId_;
                if (j4 != 0) {
                    codedOutputStream.writeInt64(4, j4);
                }
                if (!this.processId_.isEmpty()) {
                    codedOutputStream.writeString(5, getProcessId());
                }
                if (this.sessionId_.isEmpty()) {
                    return;
                }
                codedOutputStream.writeString(6, getSessionId());
            }

            public static Builder newBuilder(Taichi taichi) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(taichi);
            }

            public static Taichi parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Taichi) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Taichi parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Taichi) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Taichi parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Taichi) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Taichi parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Taichi) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Taichi parseFrom(InputStream inputStream) throws IOException {
                return (Taichi) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Taichi parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Taichi) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Taichi parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Taichi) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Taichi parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Taichi) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public interface TaichiOrBuilder extends MessageLiteOrBuilder {
            long getBucketId();

            long getExpId();

            long getGroupId();

            String getProcessId();

            ByteString getProcessIdBytes();

            String getSessionId();

            ByteString getSessionIdBytes();

            long getVersionNum();
        }

        static {
            Event event = new Event();
            DEFAULT_INSTANCE = event;
            event.makeImmutable();
        }

        private Event() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCommonParameters() {
            this.commonParameters_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventId() {
            this.eventId_ = getDefaultInstance().getEventId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearForeOrBack() {
            this.foreOrBack_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsg() {
            this.msg_ = getDefaultInstance().getMsg();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSource() {
            this.source_ = getDefaultInstance().getSource();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaichi() {
            this.taichi_ = null;
        }

        public static Event getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCommonParameters(ProtobufRequestBeanOuterClass.ProtobufRequestBean protobufRequestBean) {
            ProtobufRequestBeanOuterClass.ProtobufRequestBean protobufRequestBean2 = this.commonParameters_;
            if (protobufRequestBean2 == null || protobufRequestBean2 == ProtobufRequestBeanOuterClass.ProtobufRequestBean.getDefaultInstance()) {
                this.commonParameters_ = protobufRequestBean;
            } else {
                this.commonParameters_ = ProtobufRequestBeanOuterClass.ProtobufRequestBean.newBuilder(this.commonParameters_).mergeFrom(protobufRequestBean).buildPartial();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTaichi(Taichi taichi) {
            Taichi taichi2 = this.taichi_;
            if (taichi2 == null || taichi2 == Taichi.getDefaultInstance()) {
                this.taichi_ = taichi;
            } else {
                this.taichi_ = Taichi.newBuilder(this.taichi_).mergeFrom(taichi).buildPartial();
            }
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Event parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Event) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Event parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Event> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCommonParameters(ProtobufRequestBeanOuterClass.ProtobufRequestBean protobufRequestBean) {
            protobufRequestBean.getClass();
            this.commonParameters_ = protobufRequestBean;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventId(String str) {
            str.getClass();
            this.eventId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.eventId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setForeOrBack(int i) {
            this.foreOrBack_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsg(String str) {
            str.getClass();
            this.msg_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.msg_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSource(String str) {
            str.getClass();
            this.source_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSourceBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.source_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaichi(Taichi taichi) {
            taichi.getClass();
            this.taichi_ = taichi;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Event();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Event event = (Event) obj2;
                    this.eventId_ = visitor.visitString(!this.eventId_.isEmpty(), this.eventId_, !event.eventId_.isEmpty(), event.eventId_);
                    this.commonParameters_ = (ProtobufRequestBeanOuterClass.ProtobufRequestBean) visitor.visitMessage(this.commonParameters_, event.commonParameters_);
                    this.msg_ = visitor.visitString(!this.msg_.isEmpty(), this.msg_, !event.msg_.isEmpty(), event.msg_);
                    this.taichi_ = (Taichi) visitor.visitMessage(this.taichi_, event.taichi_);
                    this.source_ = visitor.visitString(!this.source_.isEmpty(), this.source_, !event.source_.isEmpty(), event.source_);
                    int i = this.foreOrBack_;
                    boolean z = i != 0;
                    int i2 = event.foreOrBack_;
                    this.foreOrBack_ = visitor.visitInt(z, i, i2 != 0, i2);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.eventId_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    ProtobufRequestBeanOuterClass.ProtobufRequestBean protobufRequestBean = this.commonParameters_;
                                    ProtobufRequestBeanOuterClass.ProtobufRequestBean.Builder builder = protobufRequestBean != null ? protobufRequestBean.toBuilder() : null;
                                    ProtobufRequestBeanOuterClass.ProtobufRequestBean protobufRequestBean2 = (ProtobufRequestBeanOuterClass.ProtobufRequestBean) codedInputStream.readMessage(ProtobufRequestBeanOuterClass.ProtobufRequestBean.parser(), extensionRegistryLite);
                                    this.commonParameters_ = protobufRequestBean2;
                                    if (builder != null) {
                                        builder.mergeFrom(protobufRequestBean2);
                                        this.commonParameters_ = builder.buildPartial();
                                    }
                                } else if (tag == 26) {
                                    this.msg_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 34) {
                                    Taichi taichi = this.taichi_;
                                    Taichi.Builder builder2 = taichi != null ? taichi.toBuilder() : null;
                                    Taichi taichi2 = (Taichi) codedInputStream.readMessage(Taichi.parser(), extensionRegistryLite);
                                    this.taichi_ = taichi2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(taichi2);
                                        this.taichi_ = builder2.buildPartial();
                                    }
                                } else if (tag == 42) {
                                    this.source_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 48) {
                                    this.foreOrBack_ = codedInputStream.readInt32();
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
                        synchronized (Event.class) {
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

        @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
        public ProtobufRequestBeanOuterClass.ProtobufRequestBean getCommonParameters() {
            ProtobufRequestBeanOuterClass.ProtobufRequestBean protobufRequestBean = this.commonParameters_;
            return protobufRequestBean == null ? ProtobufRequestBeanOuterClass.ProtobufRequestBean.getDefaultInstance() : protobufRequestBean;
        }

        @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
        public String getEventId() {
            return this.eventId_;
        }

        @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
        public ByteString getEventIdBytes() {
            return ByteString.copyFromUtf8(this.eventId_);
        }

        @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
        public int getForeOrBack() {
            return this.foreOrBack_;
        }

        @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
        public String getMsg() {
            return this.msg_;
        }

        @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
        public ByteString getMsgBytes() {
            return ByteString.copyFromUtf8(this.msg_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.eventId_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getEventId());
            if (this.commonParameters_ != null) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(2, getCommonParameters());
            }
            if (!this.msg_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getMsg());
            }
            if (this.taichi_ != null) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(4, getTaichi());
            }
            if (!this.source_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, getSource());
            }
            int i2 = this.foreOrBack_;
            if (i2 != 0) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(6, i2);
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
        public String getSource() {
            return this.source_;
        }

        @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
        public ByteString getSourceBytes() {
            return ByteString.copyFromUtf8(this.source_);
        }

        @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
        public Taichi getTaichi() {
            Taichi taichi = this.taichi_;
            return taichi == null ? Taichi.getDefaultInstance() : taichi;
        }

        @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
        public boolean hasCommonParameters() {
            return this.commonParameters_ != null;
        }

        @Override // com.lantern.core.protobuf.event.EventOuterClass.EventOrBuilder
        public boolean hasTaichi() {
            return this.taichi_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.eventId_.isEmpty()) {
                codedOutputStream.writeString(1, getEventId());
            }
            if (this.commonParameters_ != null) {
                codedOutputStream.writeMessage(2, getCommonParameters());
            }
            if (!this.msg_.isEmpty()) {
                codedOutputStream.writeString(3, getMsg());
            }
            if (this.taichi_ != null) {
                codedOutputStream.writeMessage(4, getTaichi());
            }
            if (!this.source_.isEmpty()) {
                codedOutputStream.writeString(5, getSource());
            }
            int i = this.foreOrBack_;
            if (i != 0) {
                codedOutputStream.writeInt32(6, i);
            }
        }

        public static Builder newBuilder(Event event) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(event);
        }

        public static Event parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Event) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Event parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Event parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCommonParameters(ProtobufRequestBeanOuterClass.ProtobufRequestBean.Builder builder) {
            this.commonParameters_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaichi(Taichi.Builder builder) {
            this.taichi_ = builder.build();
        }

        public static Event parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Event parseFrom(InputStream inputStream) throws IOException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Event parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Event parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Event parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface EventOrBuilder extends MessageLiteOrBuilder {
        ProtobufRequestBeanOuterClass.ProtobufRequestBean getCommonParameters();

        String getEventId();

        ByteString getEventIdBytes();

        int getForeOrBack();

        String getMsg();

        ByteString getMsgBytes();

        String getSource();

        ByteString getSourceBytes();

        Event.Taichi getTaichi();

        boolean hasCommonParameters();

        boolean hasTaichi();
    }

    private EventOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
