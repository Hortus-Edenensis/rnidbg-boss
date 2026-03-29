package im.youni.iccs.iprotobuf.domain;

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
/* JADX INFO: loaded from: classes4.dex */
public final class LogoutProto {

    /* JADX INFO: renamed from: im.youni.iccs.iprotobuf.domain.LogoutProto$1, reason: invalid class name */
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
    public static final class Logout extends GeneratedMessageLite<Logout, Builder> implements LogoutOrBuilder {
        private static final Logout DEFAULT_INSTANCE;
        public static final int MID_FIELD_NUMBER = 1;
        private static volatile Parser<Logout> PARSER = null;
        public static final int SESSIONID_FIELD_NUMBER = 2;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private String mid_ = "";
        private String sessionId_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<Logout, Builder> implements LogoutOrBuilder {
            public Builder clearMid() {
                copyOnWrite();
                ((Logout) this.instance).clearMid();
                return this;
            }

            public Builder clearSessionId() {
                copyOnWrite();
                ((Logout) this.instance).clearSessionId();
                return this;
            }

            @Override // im.youni.iccs.iprotobuf.domain.LogoutProto.LogoutOrBuilder
            public String getMid() {
                return ((Logout) this.instance).getMid();
            }

            @Override // im.youni.iccs.iprotobuf.domain.LogoutProto.LogoutOrBuilder
            public ByteString getMidBytes() {
                return ((Logout) this.instance).getMidBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.LogoutProto.LogoutOrBuilder
            public String getSessionId() {
                return ((Logout) this.instance).getSessionId();
            }

            @Override // im.youni.iccs.iprotobuf.domain.LogoutProto.LogoutOrBuilder
            public ByteString getSessionIdBytes() {
                return ((Logout) this.instance).getSessionIdBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.LogoutProto.LogoutOrBuilder
            public boolean hasMid() {
                return ((Logout) this.instance).hasMid();
            }

            @Override // im.youni.iccs.iprotobuf.domain.LogoutProto.LogoutOrBuilder
            public boolean hasSessionId() {
                return ((Logout) this.instance).hasSessionId();
            }

            public Builder setMid(String str) {
                copyOnWrite();
                ((Logout) this.instance).setMid(str);
                return this;
            }

            public Builder setMidBytes(ByteString byteString) {
                copyOnWrite();
                ((Logout) this.instance).setMidBytes(byteString);
                return this;
            }

            public Builder setSessionId(String str) {
                copyOnWrite();
                ((Logout) this.instance).setSessionId(str);
                return this;
            }

            public Builder setSessionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((Logout) this.instance).setSessionIdBytes(byteString);
                return this;
            }

            private Builder() {
                super(Logout.DEFAULT_INSTANCE);
            }
        }

        static {
            Logout logout = new Logout();
            DEFAULT_INSTANCE = logout;
            logout.makeImmutable();
        }

        private Logout() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMid() {
            this.bitField0_ &= -2;
            this.mid_ = getDefaultInstance().getMid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionId() {
            this.bitField0_ &= -3;
            this.sessionId_ = getDefaultInstance().getSessionId();
        }

        public static Logout getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Logout parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Logout) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Logout parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Logout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Logout> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMid(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.mid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.mid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionId(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.sessionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.sessionId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Logout();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    if (hasMid()) {
                        if (zBooleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (zBooleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder();
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Logout logout = (Logout) obj2;
                    this.mid_ = visitor.visitString(hasMid(), this.mid_, logout.hasMid(), logout.mid_);
                    this.sessionId_ = visitor.visitString(hasSessionId(), this.sessionId_, logout.hasSessionId(), logout.sessionId_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= logout.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    String string = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.mid_ = string;
                                } else if (tag == 18) {
                                    String string2 = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.sessionId_ = string2;
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
                        synchronized (Logout.class) {
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

        @Override // im.youni.iccs.iprotobuf.domain.LogoutProto.LogoutOrBuilder
        public String getMid() {
            return this.mid_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.LogoutProto.LogoutOrBuilder
        public ByteString getMidBytes() {
            return ByteString.copyFromUtf8(this.mid_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getMid()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getSessionId());
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // im.youni.iccs.iprotobuf.domain.LogoutProto.LogoutOrBuilder
        public String getSessionId() {
            return this.sessionId_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.LogoutProto.LogoutOrBuilder
        public ByteString getSessionIdBytes() {
            return ByteString.copyFromUtf8(this.sessionId_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.LogoutProto.LogoutOrBuilder
        public boolean hasMid() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // im.youni.iccs.iprotobuf.domain.LogoutProto.LogoutOrBuilder
        public boolean hasSessionId() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getMid());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getSessionId());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(Logout logout) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(logout);
        }

        public static Logout parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Logout) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Logout parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Logout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Logout parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Logout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Logout parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Logout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Logout parseFrom(InputStream inputStream) throws IOException {
            return (Logout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Logout parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Logout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Logout parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Logout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Logout parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Logout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface LogoutOrBuilder extends MessageLiteOrBuilder {
        String getMid();

        ByteString getMidBytes();

        String getSessionId();

        ByteString getSessionIdBytes();

        boolean hasMid();

        boolean hasSessionId();
    }

    private LogoutProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
