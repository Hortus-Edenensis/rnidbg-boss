package im.youni.iccs.iprotobuf.domain;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.ss.bytertc.engine.type.ErrorCode;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class AuthProto {

    /* JADX INFO: renamed from: im.youni.iccs.iprotobuf.domain.AuthProto$1, reason: invalid class name */
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
    public static final class Auth extends GeneratedMessageLite<Auth, Builder> implements AuthOrBuilder {
        public static final int APNS_FIELD_NUMBER = 7;
        private static final Auth DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 9;
        public static final int DOMAIN_FIELD_NUMBER = 8;
        public static final int LOCALE_FIELD_NUMBER = 11;
        public static final int LOGONSESSIONID_FIELD_NUMBER = 10;
        public static final int MID_FIELD_NUMBER = 1;
        private static volatile Parser<Auth> PARSER = null;
        public static final int PHONE_FIELD_NUMBER = 4;
        public static final int RESOURCE_FIELD_NUMBER = 5;
        public static final int TOKEN_FIELD_NUMBER = 3;
        public static final int UID_FIELD_NUMBER = 2;
        public static final int VERSION_FIELD_NUMBER = 6;
        private boolean apns_;
        private int bitField0_;
        private int version_;
        private byte memoizedIsInitialized = -1;
        private String mid_ = "";
        private String uid_ = "";
        private String token_ = "";
        private String phone_ = "";
        private String resource_ = "";
        private String domain_ = "";
        private String deviceId_ = "";
        private String logonSessionId_ = "";
        private String locale_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<Auth, Builder> implements AuthOrBuilder {
            public Builder clearApns() {
                copyOnWrite();
                ((Auth) this.instance).clearApns();
                return this;
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((Auth) this.instance).clearDeviceId();
                return this;
            }

            public Builder clearDomain() {
                copyOnWrite();
                ((Auth) this.instance).clearDomain();
                return this;
            }

            public Builder clearLocale() {
                copyOnWrite();
                ((Auth) this.instance).clearLocale();
                return this;
            }

            public Builder clearLogonSessionId() {
                copyOnWrite();
                ((Auth) this.instance).clearLogonSessionId();
                return this;
            }

            public Builder clearMid() {
                copyOnWrite();
                ((Auth) this.instance).clearMid();
                return this;
            }

            public Builder clearPhone() {
                copyOnWrite();
                ((Auth) this.instance).clearPhone();
                return this;
            }

            public Builder clearResource() {
                copyOnWrite();
                ((Auth) this.instance).clearResource();
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((Auth) this.instance).clearToken();
                return this;
            }

            public Builder clearUid() {
                copyOnWrite();
                ((Auth) this.instance).clearUid();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((Auth) this.instance).clearVersion();
                return this;
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public boolean getApns() {
                return ((Auth) this.instance).getApns();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public String getDeviceId() {
                return ((Auth) this.instance).getDeviceId();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public ByteString getDeviceIdBytes() {
                return ((Auth) this.instance).getDeviceIdBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public String getDomain() {
                return ((Auth) this.instance).getDomain();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public ByteString getDomainBytes() {
                return ((Auth) this.instance).getDomainBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public String getLocale() {
                return ((Auth) this.instance).getLocale();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public ByteString getLocaleBytes() {
                return ((Auth) this.instance).getLocaleBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public String getLogonSessionId() {
                return ((Auth) this.instance).getLogonSessionId();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public ByteString getLogonSessionIdBytes() {
                return ((Auth) this.instance).getLogonSessionIdBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public String getMid() {
                return ((Auth) this.instance).getMid();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public ByteString getMidBytes() {
                return ((Auth) this.instance).getMidBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public String getPhone() {
                return ((Auth) this.instance).getPhone();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public ByteString getPhoneBytes() {
                return ((Auth) this.instance).getPhoneBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public String getResource() {
                return ((Auth) this.instance).getResource();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public ByteString getResourceBytes() {
                return ((Auth) this.instance).getResourceBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public String getToken() {
                return ((Auth) this.instance).getToken();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public ByteString getTokenBytes() {
                return ((Auth) this.instance).getTokenBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public String getUid() {
                return ((Auth) this.instance).getUid();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public ByteString getUidBytes() {
                return ((Auth) this.instance).getUidBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public int getVersion() {
                return ((Auth) this.instance).getVersion();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public boolean hasApns() {
                return ((Auth) this.instance).hasApns();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public boolean hasDeviceId() {
                return ((Auth) this.instance).hasDeviceId();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public boolean hasDomain() {
                return ((Auth) this.instance).hasDomain();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public boolean hasLocale() {
                return ((Auth) this.instance).hasLocale();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public boolean hasLogonSessionId() {
                return ((Auth) this.instance).hasLogonSessionId();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public boolean hasMid() {
                return ((Auth) this.instance).hasMid();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public boolean hasPhone() {
                return ((Auth) this.instance).hasPhone();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public boolean hasResource() {
                return ((Auth) this.instance).hasResource();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public boolean hasToken() {
                return ((Auth) this.instance).hasToken();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public boolean hasUid() {
                return ((Auth) this.instance).hasUid();
            }

            @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
            public boolean hasVersion() {
                return ((Auth) this.instance).hasVersion();
            }

            public Builder setApns(boolean z) {
                copyOnWrite();
                ((Auth) this.instance).setApns(z);
                return this;
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((Auth) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).setDeviceIdBytes(byteString);
                return this;
            }

            public Builder setDomain(String str) {
                copyOnWrite();
                ((Auth) this.instance).setDomain(str);
                return this;
            }

            public Builder setDomainBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).setDomainBytes(byteString);
                return this;
            }

            public Builder setLocale(String str) {
                copyOnWrite();
                ((Auth) this.instance).setLocale(str);
                return this;
            }

            public Builder setLocaleBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).setLocaleBytes(byteString);
                return this;
            }

            public Builder setLogonSessionId(String str) {
                copyOnWrite();
                ((Auth) this.instance).setLogonSessionId(str);
                return this;
            }

            public Builder setLogonSessionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).setLogonSessionIdBytes(byteString);
                return this;
            }

            public Builder setMid(String str) {
                copyOnWrite();
                ((Auth) this.instance).setMid(str);
                return this;
            }

            public Builder setMidBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).setMidBytes(byteString);
                return this;
            }

            public Builder setPhone(String str) {
                copyOnWrite();
                ((Auth) this.instance).setPhone(str);
                return this;
            }

            public Builder setPhoneBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).setPhoneBytes(byteString);
                return this;
            }

            public Builder setResource(String str) {
                copyOnWrite();
                ((Auth) this.instance).setResource(str);
                return this;
            }

            public Builder setResourceBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).setResourceBytes(byteString);
                return this;
            }

            public Builder setToken(String str) {
                copyOnWrite();
                ((Auth) this.instance).setToken(str);
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).setTokenBytes(byteString);
                return this;
            }

            public Builder setUid(String str) {
                copyOnWrite();
                ((Auth) this.instance).setUid(str);
                return this;
            }

            public Builder setUidBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).setUidBytes(byteString);
                return this;
            }

            public Builder setVersion(int i) {
                copyOnWrite();
                ((Auth) this.instance).setVersion(i);
                return this;
            }

            private Builder() {
                super(Auth.DEFAULT_INSTANCE);
            }
        }

        static {
            Auth auth = new Auth();
            DEFAULT_INSTANCE = auth;
            auth.makeImmutable();
        }

        private Auth() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearApns() {
            this.bitField0_ &= -65;
            this.apns_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceId() {
            this.bitField0_ &= -257;
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDomain() {
            this.bitField0_ &= -129;
            this.domain_ = getDefaultInstance().getDomain();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLocale() {
            this.bitField0_ &= ErrorCode.ERROR_CODE_JOIN_ROOM_ROOM_FORBIDDEN;
            this.locale_ = getDefaultInstance().getLocale();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLogonSessionId() {
            this.bitField0_ &= -513;
            this.logonSessionId_ = getDefaultInstance().getLogonSessionId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMid() {
            this.bitField0_ &= -2;
            this.mid_ = getDefaultInstance().getMid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPhone() {
            this.bitField0_ &= -9;
            this.phone_ = getDefaultInstance().getPhone();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearResource() {
            this.bitField0_ &= -17;
            this.resource_ = getDefaultInstance().getResource();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToken() {
            this.bitField0_ &= -5;
            this.token_ = getDefaultInstance().getToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUid() {
            this.bitField0_ &= -3;
            this.uid_ = getDefaultInstance().getUid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.bitField0_ &= -33;
            this.version_ = 0;
        }

        public static Auth getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Auth parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Auth) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Auth parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Auth> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApns(boolean z) {
            this.bitField0_ |= 64;
            this.apns_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.bitField0_ |= 256;
            this.deviceId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 256;
            this.deviceId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDomain(String str) {
            str.getClass();
            this.bitField0_ |= 128;
            this.domain_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDomainBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 128;
            this.domain_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLocale(String str) {
            str.getClass();
            this.bitField0_ |= 1024;
            this.locale_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLocaleBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1024;
            this.locale_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLogonSessionId(String str) {
            str.getClass();
            this.bitField0_ |= 512;
            this.logonSessionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLogonSessionIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 512;
            this.logonSessionId_ = byteString.toStringUtf8();
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
        public void setPhone(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.phone_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPhoneBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.phone_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setResource(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.resource_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setResourceBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.resource_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToken(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.token_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTokenBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.token_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUid(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.uid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.uid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(int i) {
            this.bitField0_ |= 32;
            this.version_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Auth();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    if (!hasMid()) {
                        if (zBooleanValue) {
                            this.memoizedIsInitialized = (byte) 0;
                        }
                        return null;
                    }
                    if (!hasUid()) {
                        if (zBooleanValue) {
                            this.memoizedIsInitialized = (byte) 0;
                        }
                        return null;
                    }
                    if (!hasToken()) {
                        if (zBooleanValue) {
                            this.memoizedIsInitialized = (byte) 0;
                        }
                        return null;
                    }
                    if (!hasResource()) {
                        if (zBooleanValue) {
                            this.memoizedIsInitialized = (byte) 0;
                        }
                        return null;
                    }
                    if (hasVersion()) {
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
                    Auth auth = (Auth) obj2;
                    this.mid_ = visitor.visitString(hasMid(), this.mid_, auth.hasMid(), auth.mid_);
                    this.uid_ = visitor.visitString(hasUid(), this.uid_, auth.hasUid(), auth.uid_);
                    this.token_ = visitor.visitString(hasToken(), this.token_, auth.hasToken(), auth.token_);
                    this.phone_ = visitor.visitString(hasPhone(), this.phone_, auth.hasPhone(), auth.phone_);
                    this.resource_ = visitor.visitString(hasResource(), this.resource_, auth.hasResource(), auth.resource_);
                    this.version_ = visitor.visitInt(hasVersion(), this.version_, auth.hasVersion(), auth.version_);
                    this.apns_ = visitor.visitBoolean(hasApns(), this.apns_, auth.hasApns(), auth.apns_);
                    this.domain_ = visitor.visitString(hasDomain(), this.domain_, auth.hasDomain(), auth.domain_);
                    this.deviceId_ = visitor.visitString(hasDeviceId(), this.deviceId_, auth.hasDeviceId(), auth.deviceId_);
                    this.logonSessionId_ = visitor.visitString(hasLogonSessionId(), this.logonSessionId_, auth.hasLogonSessionId(), auth.logonSessionId_);
                    this.locale_ = visitor.visitString(hasLocale(), this.locale_, auth.hasLocale(), auth.locale_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= auth.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            switch (tag) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    String string = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.mid_ = string;
                                    break;
                                case 18:
                                    String string2 = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.uid_ = string2;
                                    break;
                                case 26:
                                    String string3 = codedInputStream.readString();
                                    this.bitField0_ |= 4;
                                    this.token_ = string3;
                                    break;
                                case 34:
                                    String string4 = codedInputStream.readString();
                                    this.bitField0_ |= 8;
                                    this.phone_ = string4;
                                    break;
                                case 42:
                                    String string5 = codedInputStream.readString();
                                    this.bitField0_ |= 16;
                                    this.resource_ = string5;
                                    break;
                                case 48:
                                    this.bitField0_ |= 32;
                                    this.version_ = codedInputStream.readUInt32();
                                    break;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.apns_ = codedInputStream.readBool();
                                    break;
                                case 66:
                                    String string6 = codedInputStream.readString();
                                    this.bitField0_ |= 128;
                                    this.domain_ = string6;
                                    break;
                                case 74:
                                    String string7 = codedInputStream.readString();
                                    this.bitField0_ |= 256;
                                    this.deviceId_ = string7;
                                    break;
                                case 82:
                                    String string8 = codedInputStream.readString();
                                    this.bitField0_ |= 512;
                                    this.logonSessionId_ = string8;
                                    break;
                                case 90:
                                    String string9 = codedInputStream.readString();
                                    this.bitField0_ |= 1024;
                                    this.locale_ = string9;
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
                        synchronized (Auth.class) {
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

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public boolean getApns() {
            return this.apns_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public String getDeviceId() {
            return this.deviceId_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public ByteString getDeviceIdBytes() {
            return ByteString.copyFromUtf8(this.deviceId_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public String getDomain() {
            return this.domain_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public ByteString getDomainBytes() {
            return ByteString.copyFromUtf8(this.domain_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public String getLocale() {
            return this.locale_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public ByteString getLocaleBytes() {
            return ByteString.copyFromUtf8(this.locale_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public String getLogonSessionId() {
            return this.logonSessionId_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public ByteString getLogonSessionIdBytes() {
            return ByteString.copyFromUtf8(this.logonSessionId_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public String getMid() {
            return this.mid_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public ByteString getMidBytes() {
            return ByteString.copyFromUtf8(this.mid_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public String getPhone() {
            return this.phone_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public ByteString getPhoneBytes() {
            return ByteString.copyFromUtf8(this.phone_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public String getResource() {
            return this.resource_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public ByteString getResourceBytes() {
            return ByteString.copyFromUtf8(this.resource_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getMid()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getUid());
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getToken());
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, getPhone());
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, getResource());
            }
            if ((this.bitField0_ & 32) == 32) {
                iComputeStringSize += CodedOutputStream.computeUInt32Size(6, this.version_);
            }
            if ((this.bitField0_ & 64) == 64) {
                iComputeStringSize += CodedOutputStream.computeBoolSize(7, this.apns_);
            }
            if ((this.bitField0_ & 128) == 128) {
                iComputeStringSize += CodedOutputStream.computeStringSize(8, getDomain());
            }
            if ((this.bitField0_ & 256) == 256) {
                iComputeStringSize += CodedOutputStream.computeStringSize(9, getDeviceId());
            }
            if ((this.bitField0_ & 512) == 512) {
                iComputeStringSize += CodedOutputStream.computeStringSize(10, getLogonSessionId());
            }
            if ((this.bitField0_ & 1024) == 1024) {
                iComputeStringSize += CodedOutputStream.computeStringSize(11, getLocale());
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public String getToken() {
            return this.token_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public String getUid() {
            return this.uid_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public ByteString getUidBytes() {
            return ByteString.copyFromUtf8(this.uid_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public boolean hasApns() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public boolean hasDeviceId() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public boolean hasDomain() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public boolean hasLocale() {
            return (this.bitField0_ & 1024) == 1024;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public boolean hasLogonSessionId() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public boolean hasMid() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public boolean hasPhone() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public boolean hasResource() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public boolean hasToken() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public boolean hasUid() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // im.youni.iccs.iprotobuf.domain.AuthProto.AuthOrBuilder
        public boolean hasVersion() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getMid());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getUid());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeString(3, getToken());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeString(4, getPhone());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeString(5, getResource());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeUInt32(6, this.version_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeBool(7, this.apns_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeString(8, getDomain());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeString(9, getDeviceId());
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeString(10, getLogonSessionId());
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeString(11, getLocale());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(Auth auth) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(auth);
        }

        public static Auth parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Auth) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Auth parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Auth parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Auth parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Auth parseFrom(InputStream inputStream) throws IOException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Auth parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Auth parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Auth parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AuthOrBuilder extends MessageLiteOrBuilder {
        boolean getApns();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        String getDomain();

        ByteString getDomainBytes();

        String getLocale();

        ByteString getLocaleBytes();

        String getLogonSessionId();

        ByteString getLogonSessionIdBytes();

        String getMid();

        ByteString getMidBytes();

        String getPhone();

        ByteString getPhoneBytes();

        String getResource();

        ByteString getResourceBytes();

        String getToken();

        ByteString getTokenBytes();

        String getUid();

        ByteString getUidBytes();

        int getVersion();

        boolean hasApns();

        boolean hasDeviceId();

        boolean hasDomain();

        boolean hasLocale();

        boolean hasLogonSessionId();

        boolean hasMid();

        boolean hasPhone();

        boolean hasResource();

        boolean hasToken();

        boolean hasUid();

        boolean hasVersion();
    }

    private AuthProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
