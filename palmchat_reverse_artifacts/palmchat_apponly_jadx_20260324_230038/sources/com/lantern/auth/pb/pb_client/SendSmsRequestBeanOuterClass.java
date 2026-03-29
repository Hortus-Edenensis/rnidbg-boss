package com.lantern.auth.pb.pb_client;

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

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class SendSmsRequestBeanOuterClass {

    /* JADX INFO: renamed from: com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass$1, reason: invalid class name */
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
    public static final class SendSmsRequestBean extends GeneratedMessageLite<SendSmsRequestBean, Builder> implements SendSmsRequestBeanOrBuilder {
        public static final int BIZTYPE_FIELD_NUMBER = 4;
        public static final int CONTENT_FIELD_NUMBER = 3;
        public static final int COUNTRYCODE_FIELD_NUMBER = 2;
        private static final SendSmsRequestBean DEFAULT_INSTANCE;
        public static final int EXT_FIELD_NUMBER = 6;
        public static final int MOBILE_FIELD_NUMBER = 1;
        private static volatile Parser<SendSmsRequestBean> PARSER = null;
        public static final int THIRDAPPID_FIELD_NUMBER = 5;
        private int bizType_;
        private String mobile_ = "";
        private String countryCode_ = "";
        private String content_ = "";
        private String thirdAppId_ = "";
        private String ext_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public enum BizType implements Internal.EnumLite {
            BIZTYPE_WINNING(0),
            BIZTYPE_EXPRESS(1),
            BIZTYPE_PROMPT(2),
            UNRECOGNIZED(-1);

            public static final int BIZTYPE_EXPRESS_VALUE = 1;
            public static final int BIZTYPE_PROMPT_VALUE = 2;
            public static final int BIZTYPE_WINNING_VALUE = 0;
            private static final Internal.EnumLiteMap<BizType> internalValueMap = new Internal.EnumLiteMap<BizType>() { // from class: com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBean.BizType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public BizType findValueByNumber(int i) {
                    return BizType.forNumber(i);
                }
            };
            private final int value;

            BizType(int i) {
                this.value = i;
            }

            public static BizType forNumber(int i) {
                if (i == 0) {
                    return BIZTYPE_WINNING;
                }
                if (i == 1) {
                    return BIZTYPE_EXPRESS;
                }
                if (i != 2) {
                    return null;
                }
                return BIZTYPE_PROMPT;
            }

            public static Internal.EnumLiteMap<BizType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static BizType valueOf(int i) {
                return forNumber(i);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<SendSmsRequestBean, Builder> implements SendSmsRequestBeanOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBizType() {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).clearBizType();
                return this;
            }

            public Builder clearContent() {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).clearContent();
                return this;
            }

            public Builder clearCountryCode() {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).clearCountryCode();
                return this;
            }

            public Builder clearExt() {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).clearExt();
                return this;
            }

            public Builder clearMobile() {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).clearMobile();
                return this;
            }

            public Builder clearThirdAppId() {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).clearThirdAppId();
                return this;
            }

            @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
            public BizType getBizType() {
                return ((SendSmsRequestBean) this.instance).getBizType();
            }

            @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
            public int getBizTypeValue() {
                return ((SendSmsRequestBean) this.instance).getBizTypeValue();
            }

            @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
            public String getContent() {
                return ((SendSmsRequestBean) this.instance).getContent();
            }

            @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
            public ByteString getContentBytes() {
                return ((SendSmsRequestBean) this.instance).getContentBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
            public String getCountryCode() {
                return ((SendSmsRequestBean) this.instance).getCountryCode();
            }

            @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
            public ByteString getCountryCodeBytes() {
                return ((SendSmsRequestBean) this.instance).getCountryCodeBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
            public String getExt() {
                return ((SendSmsRequestBean) this.instance).getExt();
            }

            @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
            public ByteString getExtBytes() {
                return ((SendSmsRequestBean) this.instance).getExtBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
            public String getMobile() {
                return ((SendSmsRequestBean) this.instance).getMobile();
            }

            @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
            public ByteString getMobileBytes() {
                return ((SendSmsRequestBean) this.instance).getMobileBytes();
            }

            @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
            public String getThirdAppId() {
                return ((SendSmsRequestBean) this.instance).getThirdAppId();
            }

            @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
            public ByteString getThirdAppIdBytes() {
                return ((SendSmsRequestBean) this.instance).getThirdAppIdBytes();
            }

            public Builder setBizType(BizType bizType) {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).setBizType(bizType);
                return this;
            }

            public Builder setBizTypeValue(int i) {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).setBizTypeValue(i);
                return this;
            }

            public Builder setContent(String str) {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).setContent(str);
                return this;
            }

            public Builder setContentBytes(ByteString byteString) {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).setContentBytes(byteString);
                return this;
            }

            public Builder setCountryCode(String str) {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).setCountryCode(str);
                return this;
            }

            public Builder setCountryCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).setCountryCodeBytes(byteString);
                return this;
            }

            public Builder setExt(String str) {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).setExt(str);
                return this;
            }

            public Builder setExtBytes(ByteString byteString) {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).setExtBytes(byteString);
                return this;
            }

            public Builder setMobile(String str) {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).setMobile(str);
                return this;
            }

            public Builder setMobileBytes(ByteString byteString) {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).setMobileBytes(byteString);
                return this;
            }

            public Builder setThirdAppId(String str) {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).setThirdAppId(str);
                return this;
            }

            public Builder setThirdAppIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SendSmsRequestBean) this.instance).setThirdAppIdBytes(byteString);
                return this;
            }

            private Builder() {
                super(SendSmsRequestBean.DEFAULT_INSTANCE);
            }
        }

        static {
            SendSmsRequestBean sendSmsRequestBean = new SendSmsRequestBean();
            DEFAULT_INSTANCE = sendSmsRequestBean;
            sendSmsRequestBean.makeImmutable();
        }

        private SendSmsRequestBean() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBizType() {
            this.bizType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContent() {
            this.content_ = getDefaultInstance().getContent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCountryCode() {
            this.countryCode_ = getDefaultInstance().getCountryCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExt() {
            this.ext_ = getDefaultInstance().getExt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMobile() {
            this.mobile_ = getDefaultInstance().getMobile();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThirdAppId() {
            this.thirdAppId_ = getDefaultInstance().getThirdAppId();
        }

        public static SendSmsRequestBean getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SendSmsRequestBean parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SendSmsRequestBean) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SendSmsRequestBean parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SendSmsRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<SendSmsRequestBean> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBizType(BizType bizType) {
            bizType.getClass();
            this.bizType_ = bizType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBizTypeValue(int i) {
            this.bizType_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContent(String str) {
            str.getClass();
            this.content_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContentBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.content_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountryCode(String str) {
            str.getClass();
            this.countryCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountryCodeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.countryCode_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExt(String str) {
            str.getClass();
            this.ext_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.ext_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMobile(String str) {
            str.getClass();
            this.mobile_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMobileBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.mobile_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThirdAppId(String str) {
            str.getClass();
            this.thirdAppId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThirdAppIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.thirdAppId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SendSmsRequestBean();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    SendSmsRequestBean sendSmsRequestBean = (SendSmsRequestBean) obj2;
                    this.mobile_ = visitor.visitString(!this.mobile_.isEmpty(), this.mobile_, !sendSmsRequestBean.mobile_.isEmpty(), sendSmsRequestBean.mobile_);
                    this.countryCode_ = visitor.visitString(!this.countryCode_.isEmpty(), this.countryCode_, !sendSmsRequestBean.countryCode_.isEmpty(), sendSmsRequestBean.countryCode_);
                    this.content_ = visitor.visitString(!this.content_.isEmpty(), this.content_, !sendSmsRequestBean.content_.isEmpty(), sendSmsRequestBean.content_);
                    int i = this.bizType_;
                    boolean z = i != 0;
                    int i2 = sendSmsRequestBean.bizType_;
                    this.bizType_ = visitor.visitInt(z, i, i2 != 0, i2);
                    this.thirdAppId_ = visitor.visitString(!this.thirdAppId_.isEmpty(), this.thirdAppId_, !sendSmsRequestBean.thirdAppId_.isEmpty(), sendSmsRequestBean.thirdAppId_);
                    this.ext_ = visitor.visitString(!this.ext_.isEmpty(), this.ext_, !sendSmsRequestBean.ext_.isEmpty(), sendSmsRequestBean.ext_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.mobile_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    this.countryCode_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    this.content_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 32) {
                                    this.bizType_ = codedInputStream.readEnum();
                                } else if (tag == 42) {
                                    this.thirdAppId_ = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 50) {
                                    this.ext_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (SendSmsRequestBean.class) {
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

        @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
        public BizType getBizType() {
            BizType bizTypeForNumber = BizType.forNumber(this.bizType_);
            return bizTypeForNumber == null ? BizType.UNRECOGNIZED : bizTypeForNumber;
        }

        @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
        public int getBizTypeValue() {
            return this.bizType_;
        }

        @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
        public String getContent() {
            return this.content_;
        }

        @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
        public ByteString getContentBytes() {
            return ByteString.copyFromUtf8(this.content_);
        }

        @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
        public String getCountryCode() {
            return this.countryCode_;
        }

        @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
        public ByteString getCountryCodeBytes() {
            return ByteString.copyFromUtf8(this.countryCode_);
        }

        @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
        public String getExt() {
            return this.ext_;
        }

        @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
        public ByteString getExtBytes() {
            return ByteString.copyFromUtf8(this.ext_);
        }

        @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
        public String getMobile() {
            return this.mobile_;
        }

        @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
        public ByteString getMobileBytes() {
            return ByteString.copyFromUtf8(this.mobile_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.mobile_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getMobile());
            if (!this.countryCode_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getCountryCode());
            }
            if (!this.content_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getContent());
            }
            if (this.bizType_ != BizType.BIZTYPE_WINNING.getNumber()) {
                iComputeStringSize += CodedOutputStream.computeEnumSize(4, this.bizType_);
            }
            if (!this.thirdAppId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, getThirdAppId());
            }
            if (!this.ext_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(6, getExt());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
        public String getThirdAppId() {
            return this.thirdAppId_;
        }

        @Override // com.lantern.auth.pb.pb_client.SendSmsRequestBeanOuterClass.SendSmsRequestBeanOrBuilder
        public ByteString getThirdAppIdBytes() {
            return ByteString.copyFromUtf8(this.thirdAppId_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.mobile_.isEmpty()) {
                codedOutputStream.writeString(1, getMobile());
            }
            if (!this.countryCode_.isEmpty()) {
                codedOutputStream.writeString(2, getCountryCode());
            }
            if (!this.content_.isEmpty()) {
                codedOutputStream.writeString(3, getContent());
            }
            if (this.bizType_ != BizType.BIZTYPE_WINNING.getNumber()) {
                codedOutputStream.writeEnum(4, this.bizType_);
            }
            if (!this.thirdAppId_.isEmpty()) {
                codedOutputStream.writeString(5, getThirdAppId());
            }
            if (this.ext_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(6, getExt());
        }

        public static Builder newBuilder(SendSmsRequestBean sendSmsRequestBean) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sendSmsRequestBean);
        }

        public static SendSmsRequestBean parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SendSmsRequestBean) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SendSmsRequestBean parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SendSmsRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SendSmsRequestBean parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SendSmsRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SendSmsRequestBean parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SendSmsRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SendSmsRequestBean parseFrom(InputStream inputStream) throws IOException {
            return (SendSmsRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SendSmsRequestBean parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SendSmsRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SendSmsRequestBean parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SendSmsRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SendSmsRequestBean parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SendSmsRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SendSmsRequestBeanOrBuilder extends MessageLiteOrBuilder {
        SendSmsRequestBean.BizType getBizType();

        int getBizTypeValue();

        String getContent();

        ByteString getContentBytes();

        String getCountryCode();

        ByteString getCountryCodeBytes();

        String getExt();

        ByteString getExtBytes();

        String getMobile();

        ByteString getMobileBytes();

        String getThirdAppId();

        ByteString getThirdAppIdBytes();
    }

    private SendSmsRequestBeanOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
