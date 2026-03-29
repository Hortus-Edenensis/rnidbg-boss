package com.lantern.core.protobuf;

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
/* JADX INFO: loaded from: classes9.dex */
public final class ProtobufResponseModelOuterClass {

    /* JADX INFO: renamed from: com.lantern.core.protobuf.ProtobufResponseModelOuterClass$1, reason: invalid class name */
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
    public static final class ProtobufResponseModel extends GeneratedMessageLite<ProtobufResponseModel, Builder> implements ProtobufResponseModelOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final ProtobufResponseModel DEFAULT_INSTANCE;
        public static final int MSG_FIELD_NUMBER = 2;
        private static volatile Parser<ProtobufResponseModel> PARSER = null;
        public static final int SN_FIELD_NUMBER = 3;
        private int bitField0_;
        private MapFieldLite<String, String> sn_ = MapFieldLite.emptyMapField();
        private String code_ = "";
        private String msg_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtobufResponseModel, Builder> implements ProtobufResponseModelOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCode() {
                copyOnWrite();
                ((ProtobufResponseModel) this.instance).clearCode();
                return this;
            }

            public Builder clearMsg() {
                copyOnWrite();
                ((ProtobufResponseModel) this.instance).clearMsg();
                return this;
            }

            public Builder clearSn() {
                copyOnWrite();
                ((ProtobufResponseModel) this.instance).getMutableSnMap().clear();
                return this;
            }

            @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
            public boolean containsSn(String str) {
                str.getClass();
                return ((ProtobufResponseModel) this.instance).getSnMap().containsKey(str);
            }

            @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
            public String getCode() {
                return ((ProtobufResponseModel) this.instance).getCode();
            }

            @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
            public ByteString getCodeBytes() {
                return ((ProtobufResponseModel) this.instance).getCodeBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
            public String getMsg() {
                return ((ProtobufResponseModel) this.instance).getMsg();
            }

            @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
            public ByteString getMsgBytes() {
                return ((ProtobufResponseModel) this.instance).getMsgBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
            @Deprecated
            public Map<String, String> getSn() {
                return getSnMap();
            }

            @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
            public int getSnCount() {
                return ((ProtobufResponseModel) this.instance).getSnMap().size();
            }

            @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
            public Map<String, String> getSnMap() {
                return Collections.unmodifiableMap(((ProtobufResponseModel) this.instance).getSnMap());
            }

            @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
            public String getSnOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> snMap = ((ProtobufResponseModel) this.instance).getSnMap();
                return snMap.containsKey(str) ? snMap.get(str) : str2;
            }

            @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
            public String getSnOrThrow(String str) {
                str.getClass();
                Map<String, String> snMap = ((ProtobufResponseModel) this.instance).getSnMap();
                if (snMap.containsKey(str)) {
                    return snMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            public Builder putAllSn(Map<String, String> map) {
                copyOnWrite();
                ((ProtobufResponseModel) this.instance).getMutableSnMap().putAll(map);
                return this;
            }

            public Builder putSn(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((ProtobufResponseModel) this.instance).getMutableSnMap().put(str, str2);
                return this;
            }

            public Builder removeSn(String str) {
                str.getClass();
                copyOnWrite();
                ((ProtobufResponseModel) this.instance).getMutableSnMap().remove(str);
                return this;
            }

            public Builder setCode(String str) {
                copyOnWrite();
                ((ProtobufResponseModel) this.instance).setCode(str);
                return this;
            }

            public Builder setCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufResponseModel) this.instance).setCodeBytes(byteString);
                return this;
            }

            public Builder setMsg(String str) {
                copyOnWrite();
                ((ProtobufResponseModel) this.instance).setMsg(str);
                return this;
            }

            public Builder setMsgBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufResponseModel) this.instance).setMsgBytes(byteString);
                return this;
            }

            private Builder() {
                super(ProtobufResponseModel.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class SnDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private SnDefaultEntryHolder() {
            }
        }

        static {
            ProtobufResponseModel protobufResponseModel = new ProtobufResponseModel();
            DEFAULT_INSTANCE = protobufResponseModel;
            protobufResponseModel.makeImmutable();
        }

        private ProtobufResponseModel() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.code_ = getDefaultInstance().getCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsg() {
            this.msg_ = getDefaultInstance().getMsg();
        }

        public static ProtobufResponseModel getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableSnMap() {
            return internalGetMutableSn();
        }

        private MapFieldLite<String, String> internalGetMutableSn() {
            if (!this.sn_.isMutable()) {
                this.sn_ = this.sn_.mutableCopy();
            }
            return this.sn_;
        }

        private MapFieldLite<String, String> internalGetSn() {
            return this.sn_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ProtobufResponseModel parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtobufResponseModel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtobufResponseModel parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtobufResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<ProtobufResponseModel> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(String str) {
            str.getClass();
            this.code_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCodeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.code_ = byteString.toStringUtf8();
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

        @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
        public boolean containsSn(String str) {
            str.getClass();
            return internalGetSn().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtobufResponseModel();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.sn_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ProtobufResponseModel protobufResponseModel = (ProtobufResponseModel) obj2;
                    this.code_ = visitor.visitString(!this.code_.isEmpty(), this.code_, !protobufResponseModel.code_.isEmpty(), protobufResponseModel.code_);
                    this.msg_ = visitor.visitString(!this.msg_.isEmpty(), this.msg_, true ^ protobufResponseModel.msg_.isEmpty(), protobufResponseModel.msg_);
                    this.sn_ = visitor.visitMap(this.sn_, protobufResponseModel.internalGetSn());
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= protobufResponseModel.bitField0_;
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
                                    this.code_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    this.msg_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    if (!this.sn_.isMutable()) {
                                        this.sn_ = this.sn_.mutableCopy();
                                    }
                                    SnDefaultEntryHolder.defaultEntry.parseInto(this.sn_, codedInputStream, extensionRegistryLite);
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
                        synchronized (ProtobufResponseModel.class) {
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

        @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
        public String getCode() {
            return this.code_;
        }

        @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
        public ByteString getCodeBytes() {
            return ByteString.copyFromUtf8(this.code_);
        }

        @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
        public String getMsg() {
            return this.msg_;
        }

        @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
        public ByteString getMsgBytes() {
            return ByteString.copyFromUtf8(this.msg_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.code_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getCode());
            if (!this.msg_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getMsg());
            }
            for (Map.Entry<String, String> entry : internalGetSn().entrySet()) {
                iComputeStringSize += SnDefaultEntryHolder.defaultEntry.computeMessageSize(3, entry.getKey(), entry.getValue());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
        @Deprecated
        public Map<String, String> getSn() {
            return getSnMap();
        }

        @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
        public int getSnCount() {
            return internalGetSn().size();
        }

        @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
        public Map<String, String> getSnMap() {
            return Collections.unmodifiableMap(internalGetSn());
        }

        @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
        public String getSnOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetSn = internalGetSn();
            return mapFieldLiteInternalGetSn.containsKey(str) ? mapFieldLiteInternalGetSn.get(str) : str2;
        }

        @Override // com.lantern.core.protobuf.ProtobufResponseModelOuterClass.ProtobufResponseModelOrBuilder
        public String getSnOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetSn = internalGetSn();
            if (mapFieldLiteInternalGetSn.containsKey(str)) {
                return mapFieldLiteInternalGetSn.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.code_.isEmpty()) {
                codedOutputStream.writeString(1, getCode());
            }
            if (!this.msg_.isEmpty()) {
                codedOutputStream.writeString(2, getMsg());
            }
            for (Map.Entry<String, String> entry : internalGetSn().entrySet()) {
                SnDefaultEntryHolder.defaultEntry.serializeTo(codedOutputStream, 3, entry.getKey(), entry.getValue());
            }
        }

        public static Builder newBuilder(ProtobufResponseModel protobufResponseModel) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(protobufResponseModel);
        }

        public static ProtobufResponseModel parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtobufResponseModel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtobufResponseModel parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtobufResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtobufResponseModel parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtobufResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtobufResponseModel parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtobufResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtobufResponseModel parseFrom(InputStream inputStream) throws IOException {
            return (ProtobufResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtobufResponseModel parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtobufResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtobufResponseModel parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtobufResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtobufResponseModel parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtobufResponseModel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ProtobufResponseModelOrBuilder extends MessageLiteOrBuilder {
        boolean containsSn(String str);

        String getCode();

        ByteString getCodeBytes();

        String getMsg();

        ByteString getMsgBytes();

        @Deprecated
        Map<String, String> getSn();

        int getSnCount();

        Map<String, String> getSnMap();

        String getSnOrDefault(String str, String str2);

        String getSnOrThrow(String str);
    }

    private ProtobufResponseModelOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
