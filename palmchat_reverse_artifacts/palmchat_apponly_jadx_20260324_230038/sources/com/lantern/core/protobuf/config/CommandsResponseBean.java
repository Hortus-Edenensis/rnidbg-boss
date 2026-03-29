package com.lantern.core.protobuf.config;

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
/* JADX INFO: loaded from: classes9.dex */
public final class CommandsResponseBean {

    /* JADX INFO: renamed from: com.lantern.core.protobuf.config.CommandsResponseBean$1, reason: invalid class name */
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
    public static final class Command extends GeneratedMessageLite<Command, Builder> implements CommandOrBuilder {
        public static final int AVAILABLETIME_FIELD_NUMBER = 4;
        private static final Command DEFAULT_INSTANCE;
        public static final int EVENTID_FIELD_NUMBER = 2;
        public static final int LEVEL_FIELD_NUMBER = 3;
        public static final int LIMIT_FIELD_NUMBER = 6;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile Parser<Command> PARSER = null;
        public static final int VERSION_FIELD_NUMBER = 5;
        private String op_ = "";
        private String eventId_ = "";
        private String level_ = "";
        private String availableTime_ = "";
        private String version_ = "";
        private String limit_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<Command, Builder> implements CommandOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAvailableTime() {
                copyOnWrite();
                ((Command) this.instance).clearAvailableTime();
                return this;
            }

            public Builder clearEventId() {
                copyOnWrite();
                ((Command) this.instance).clearEventId();
                return this;
            }

            public Builder clearLevel() {
                copyOnWrite();
                ((Command) this.instance).clearLevel();
                return this;
            }

            public Builder clearLimit() {
                copyOnWrite();
                ((Command) this.instance).clearLimit();
                return this;
            }

            public Builder clearOp() {
                copyOnWrite();
                ((Command) this.instance).clearOp();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((Command) this.instance).clearVersion();
                return this;
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
            public String getAvailableTime() {
                return ((Command) this.instance).getAvailableTime();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
            public ByteString getAvailableTimeBytes() {
                return ((Command) this.instance).getAvailableTimeBytes();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
            public String getEventId() {
                return ((Command) this.instance).getEventId();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
            public ByteString getEventIdBytes() {
                return ((Command) this.instance).getEventIdBytes();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
            public String getLevel() {
                return ((Command) this.instance).getLevel();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
            public ByteString getLevelBytes() {
                return ((Command) this.instance).getLevelBytes();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
            public String getLimit() {
                return ((Command) this.instance).getLimit();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
            public ByteString getLimitBytes() {
                return ((Command) this.instance).getLimitBytes();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
            public String getOp() {
                return ((Command) this.instance).getOp();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
            public ByteString getOpBytes() {
                return ((Command) this.instance).getOpBytes();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
            public String getVersion() {
                return ((Command) this.instance).getVersion();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
            public ByteString getVersionBytes() {
                return ((Command) this.instance).getVersionBytes();
            }

            public Builder setAvailableTime(String str) {
                copyOnWrite();
                ((Command) this.instance).setAvailableTime(str);
                return this;
            }

            public Builder setAvailableTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((Command) this.instance).setAvailableTimeBytes(byteString);
                return this;
            }

            public Builder setEventId(String str) {
                copyOnWrite();
                ((Command) this.instance).setEventId(str);
                return this;
            }

            public Builder setEventIdBytes(ByteString byteString) {
                copyOnWrite();
                ((Command) this.instance).setEventIdBytes(byteString);
                return this;
            }

            public Builder setLevel(String str) {
                copyOnWrite();
                ((Command) this.instance).setLevel(str);
                return this;
            }

            public Builder setLevelBytes(ByteString byteString) {
                copyOnWrite();
                ((Command) this.instance).setLevelBytes(byteString);
                return this;
            }

            public Builder setLimit(String str) {
                copyOnWrite();
                ((Command) this.instance).setLimit(str);
                return this;
            }

            public Builder setLimitBytes(ByteString byteString) {
                copyOnWrite();
                ((Command) this.instance).setLimitBytes(byteString);
                return this;
            }

            public Builder setOp(String str) {
                copyOnWrite();
                ((Command) this.instance).setOp(str);
                return this;
            }

            public Builder setOpBytes(ByteString byteString) {
                copyOnWrite();
                ((Command) this.instance).setOpBytes(byteString);
                return this;
            }

            public Builder setVersion(String str) {
                copyOnWrite();
                ((Command) this.instance).setVersion(str);
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((Command) this.instance).setVersionBytes(byteString);
                return this;
            }

            private Builder() {
                super(Command.DEFAULT_INSTANCE);
            }
        }

        static {
            Command command = new Command();
            DEFAULT_INSTANCE = command;
            command.makeImmutable();
        }

        private Command() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAvailableTime() {
            this.availableTime_ = getDefaultInstance().getAvailableTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventId() {
            this.eventId_ = getDefaultInstance().getEventId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLevel() {
            this.level_ = getDefaultInstance().getLevel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimit() {
            this.limit_ = getDefaultInstance().getLimit();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOp() {
            this.op_ = getDefaultInstance().getOp();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = getDefaultInstance().getVersion();
        }

        public static Command getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Command parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Command) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Command parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Command> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAvailableTime(String str) {
            str.getClass();
            this.availableTime_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAvailableTimeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.availableTime_ = byteString.toStringUtf8();
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
        public void setLevel(String str) {
            str.getClass();
            this.level_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLevelBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.level_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimit(String str) {
            str.getClass();
            this.limit_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimitBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.limit_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOp(String str) {
            str.getClass();
            this.op_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOpBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.op_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(String str) {
            str.getClass();
            this.version_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.version_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Command();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Command command = (Command) obj2;
                    this.op_ = visitor.visitString(!this.op_.isEmpty(), this.op_, !command.op_.isEmpty(), command.op_);
                    this.eventId_ = visitor.visitString(!this.eventId_.isEmpty(), this.eventId_, !command.eventId_.isEmpty(), command.eventId_);
                    this.level_ = visitor.visitString(!this.level_.isEmpty(), this.level_, !command.level_.isEmpty(), command.level_);
                    this.availableTime_ = visitor.visitString(!this.availableTime_.isEmpty(), this.availableTime_, !command.availableTime_.isEmpty(), command.availableTime_);
                    this.version_ = visitor.visitString(!this.version_.isEmpty(), this.version_, !command.version_.isEmpty(), command.version_);
                    this.limit_ = visitor.visitString(!this.limit_.isEmpty(), this.limit_, true ^ command.limit_.isEmpty(), command.limit_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.op_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    this.eventId_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    this.level_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 34) {
                                    this.availableTime_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 42) {
                                    this.version_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 50) {
                                    this.limit_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (Command.class) {
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

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
        public String getAvailableTime() {
            return this.availableTime_;
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
        public ByteString getAvailableTimeBytes() {
            return ByteString.copyFromUtf8(this.availableTime_);
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
        public String getEventId() {
            return this.eventId_;
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
        public ByteString getEventIdBytes() {
            return ByteString.copyFromUtf8(this.eventId_);
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
        public String getLevel() {
            return this.level_;
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
        public ByteString getLevelBytes() {
            return ByteString.copyFromUtf8(this.level_);
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
        public String getLimit() {
            return this.limit_;
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
        public ByteString getLimitBytes() {
            return ByteString.copyFromUtf8(this.limit_);
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
        public String getOp() {
            return this.op_;
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
        public ByteString getOpBytes() {
            return ByteString.copyFromUtf8(this.op_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.op_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getOp());
            if (!this.eventId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getEventId());
            }
            if (!this.level_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getLevel());
            }
            if (!this.availableTime_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, getAvailableTime());
            }
            if (!this.version_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, getVersion());
            }
            if (!this.limit_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(6, getLimit());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
        public String getVersion() {
            return this.version_;
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandOrBuilder
        public ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.op_.isEmpty()) {
                codedOutputStream.writeString(1, getOp());
            }
            if (!this.eventId_.isEmpty()) {
                codedOutputStream.writeString(2, getEventId());
            }
            if (!this.level_.isEmpty()) {
                codedOutputStream.writeString(3, getLevel());
            }
            if (!this.availableTime_.isEmpty()) {
                codedOutputStream.writeString(4, getAvailableTime());
            }
            if (!this.version_.isEmpty()) {
                codedOutputStream.writeString(5, getVersion());
            }
            if (this.limit_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(6, getLimit());
        }

        public static Builder newBuilder(Command command) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(command);
        }

        public static Command parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Command) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Command parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Command parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Command parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Command parseFrom(InputStream inputStream) throws IOException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Command parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Command parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Command parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CommandOrBuilder extends MessageLiteOrBuilder {
        String getAvailableTime();

        ByteString getAvailableTimeBytes();

        String getEventId();

        ByteString getEventIdBytes();

        String getLevel();

        ByteString getLevelBytes();

        String getLimit();

        ByteString getLimitBytes();

        String getOp();

        ByteString getOpBytes();

        String getVersion();

        ByteString getVersionBytes();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Commands extends GeneratedMessageLite<Commands, Builder> implements CommandsOrBuilder {
        public static final int ALL_FIELD_NUMBER = 3;
        public static final int COMMAND_FIELD_NUMBER = 2;
        private static final Commands DEFAULT_INSTANCE;
        private static volatile Parser<Commands> PARSER = null;
        public static final int VERSION_FIELD_NUMBER = 1;
        private int bitField0_;
        private String version_ = "";
        private Internal.ProtobufList<Command> command_ = GeneratedMessageLite.emptyProtobufList();
        private String all_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<Commands, Builder> implements CommandsOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllCommand(Iterable<? extends Command> iterable) {
                copyOnWrite();
                ((Commands) this.instance).addAllCommand(iterable);
                return this;
            }

            public Builder addCommand(Command command) {
                copyOnWrite();
                ((Commands) this.instance).addCommand(command);
                return this;
            }

            public Builder clearAll() {
                copyOnWrite();
                ((Commands) this.instance).clearAll();
                return this;
            }

            public Builder clearCommand() {
                copyOnWrite();
                ((Commands) this.instance).clearCommand();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((Commands) this.instance).clearVersion();
                return this;
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
            public String getAll() {
                return ((Commands) this.instance).getAll();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
            public ByteString getAllBytes() {
                return ((Commands) this.instance).getAllBytes();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
            public Command getCommand(int i) {
                return ((Commands) this.instance).getCommand(i);
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
            public int getCommandCount() {
                return ((Commands) this.instance).getCommandCount();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
            public List<Command> getCommandList() {
                return Collections.unmodifiableList(((Commands) this.instance).getCommandList());
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
            public String getVersion() {
                return ((Commands) this.instance).getVersion();
            }

            @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
            public ByteString getVersionBytes() {
                return ((Commands) this.instance).getVersionBytes();
            }

            public Builder removeCommand(int i) {
                copyOnWrite();
                ((Commands) this.instance).removeCommand(i);
                return this;
            }

            public Builder setAll(String str) {
                copyOnWrite();
                ((Commands) this.instance).setAll(str);
                return this;
            }

            public Builder setAllBytes(ByteString byteString) {
                copyOnWrite();
                ((Commands) this.instance).setAllBytes(byteString);
                return this;
            }

            public Builder setCommand(int i, Command command) {
                copyOnWrite();
                ((Commands) this.instance).setCommand(i, command);
                return this;
            }

            public Builder setVersion(String str) {
                copyOnWrite();
                ((Commands) this.instance).setVersion(str);
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((Commands) this.instance).setVersionBytes(byteString);
                return this;
            }

            private Builder() {
                super(Commands.DEFAULT_INSTANCE);
            }

            public Builder addCommand(int i, Command command) {
                copyOnWrite();
                ((Commands) this.instance).addCommand(i, command);
                return this;
            }

            public Builder setCommand(int i, Command.Builder builder) {
                copyOnWrite();
                ((Commands) this.instance).setCommand(i, builder);
                return this;
            }

            public Builder addCommand(Command.Builder builder) {
                copyOnWrite();
                ((Commands) this.instance).addCommand(builder);
                return this;
            }

            public Builder addCommand(int i, Command.Builder builder) {
                copyOnWrite();
                ((Commands) this.instance).addCommand(i, builder);
                return this;
            }
        }

        static {
            Commands commands = new Commands();
            DEFAULT_INSTANCE = commands;
            commands.makeImmutable();
        }

        private Commands() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllCommand(Iterable<? extends Command> iterable) {
            ensureCommandIsMutable();
            AbstractMessageLite.addAll(iterable, this.command_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCommand(Command command) {
            command.getClass();
            ensureCommandIsMutable();
            this.command_.add(command);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAll() {
            this.all_ = getDefaultInstance().getAll();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCommand() {
            this.command_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = getDefaultInstance().getVersion();
        }

        private void ensureCommandIsMutable() {
            if (this.command_.isModifiable()) {
                return;
            }
            this.command_ = GeneratedMessageLite.mutableCopy(this.command_);
        }

        public static Commands getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Commands parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Commands) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Commands parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Commands) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Commands> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeCommand(int i) {
            ensureCommandIsMutable();
            this.command_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAll(String str) {
            str.getClass();
            this.all_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAllBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.all_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCommand(int i, Command command) {
            command.getClass();
            ensureCommandIsMutable();
            this.command_.set(i, command);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(String str) {
            str.getClass();
            this.version_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.version_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Commands();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.command_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Commands commands = (Commands) obj2;
                    this.version_ = visitor.visitString(!this.version_.isEmpty(), this.version_, !commands.version_.isEmpty(), commands.version_);
                    this.command_ = visitor.visitList(this.command_, commands.command_);
                    this.all_ = visitor.visitString(!this.all_.isEmpty(), this.all_, true ^ commands.all_.isEmpty(), commands.all_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= commands.bitField0_;
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
                                    this.version_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    if (!this.command_.isModifiable()) {
                                        this.command_ = GeneratedMessageLite.mutableCopy(this.command_);
                                    }
                                    this.command_.add((Command) codedInputStream.readMessage(Command.parser(), extensionRegistryLite));
                                } else if (tag == 26) {
                                    this.all_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (Commands.class) {
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

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
        public String getAll() {
            return this.all_;
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
        public ByteString getAllBytes() {
            return ByteString.copyFromUtf8(this.all_);
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
        public Command getCommand(int i) {
            return this.command_.get(i);
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
        public int getCommandCount() {
            return this.command_.size();
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
        public List<Command> getCommandList() {
            return this.command_;
        }

        public CommandOrBuilder getCommandOrBuilder(int i) {
            return this.command_.get(i);
        }

        public List<? extends CommandOrBuilder> getCommandOrBuilderList() {
            return this.command_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = !this.version_.isEmpty() ? CodedOutputStream.computeStringSize(1, getVersion()) + 0 : 0;
            for (int i2 = 0; i2 < this.command_.size(); i2++) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(2, this.command_.get(i2));
            }
            if (!this.all_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getAll());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
        public String getVersion() {
            return this.version_;
        }

        @Override // com.lantern.core.protobuf.config.CommandsResponseBean.CommandsOrBuilder
        public ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.version_.isEmpty()) {
                codedOutputStream.writeString(1, getVersion());
            }
            for (int i = 0; i < this.command_.size(); i++) {
                codedOutputStream.writeMessage(2, this.command_.get(i));
            }
            if (this.all_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(3, getAll());
        }

        public static Builder newBuilder(Commands commands) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(commands);
        }

        public static Commands parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Commands) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Commands parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Commands) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Commands parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Commands) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCommand(int i, Command command) {
            command.getClass();
            ensureCommandIsMutable();
            this.command_.add(i, command);
        }

        public static Commands parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Commands) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCommand(int i, Command.Builder builder) {
            ensureCommandIsMutable();
            this.command_.set(i, builder.build());
        }

        public static Commands parseFrom(InputStream inputStream) throws IOException {
            return (Commands) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Commands parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Commands) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCommand(Command.Builder builder) {
            ensureCommandIsMutable();
            this.command_.add(builder.build());
        }

        public static Commands parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Commands) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Commands parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Commands) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCommand(int i, Command.Builder builder) {
            ensureCommandIsMutable();
            this.command_.add(i, builder.build());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CommandsOrBuilder extends MessageLiteOrBuilder {
        String getAll();

        ByteString getAllBytes();

        Command getCommand(int i);

        int getCommandCount();

        List<Command> getCommandList();

        String getVersion();

        ByteString getVersionBytes();
    }

    private CommandsResponseBean() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
