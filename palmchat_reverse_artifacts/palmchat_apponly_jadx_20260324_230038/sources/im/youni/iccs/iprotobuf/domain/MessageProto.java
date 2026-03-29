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
public final class MessageProto {

    /* JADX INFO: renamed from: im.youni.iccs.iprotobuf.domain.MessageProto$1, reason: invalid class name */
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
    public static final class Message extends GeneratedMessageLite<Message, Builder> implements MessageOrBuilder {
        public static final int BODY_FIELD_NUMBER = 5;
        public static final int CREATETIME_FIELD_NUMBER = 7;
        private static final Message DEFAULT_INSTANCE;
        public static final int EXTENSION_FIELD_NUMBER = 11;
        public static final int EXTYPE_FIELD_NUMBER = 16;
        public static final int FLAG_FIELD_NUMBER = 15;
        public static final int FROM_FIELD_NUMBER = 2;
        public static final int MEDIA_FIELD_NUMBER = 8;
        public static final int MID_FIELD_NUMBER = 1;
        private static volatile Parser<Message> PARSER = null;
        public static final int RECOMMENDINFO_FIELD_NUMBER = 9;
        public static final int STATUSNOTIFY_FIELD_NUMBER = 10;
        public static final int STATUS_FIELD_NUMBER = 6;
        public static final int SUBTYPE_FIELD_NUMBER = 12;
        public static final int SYNCKEY_FIELD_NUMBER = 13;
        public static final int TO_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 4;
        public static final int VERSION_FIELD_NUMBER = 14;
        private int bitField0_;
        private long createTime_;
        private int exType_;
        private int flag_;
        private Media media_;
        private RecommendInfo recommendInfo_;
        private StatusNotify statusNotify_;
        private int status_;
        private int subType_;
        private int type_;
        private long version_;
        private byte memoizedIsInitialized = -1;
        private String mid_ = "";
        private String from_ = "";
        private String to_ = "";
        private String body_ = "";
        private String extension_ = "";
        private String syncKey_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<Message, Builder> implements MessageOrBuilder {
            public Builder clearBody() {
                copyOnWrite();
                ((Message) this.instance).clearBody();
                return this;
            }

            public Builder clearCreateTime() {
                copyOnWrite();
                ((Message) this.instance).clearCreateTime();
                return this;
            }

            public Builder clearExType() {
                copyOnWrite();
                ((Message) this.instance).clearExType();
                return this;
            }

            public Builder clearExtension() {
                copyOnWrite();
                ((Message) this.instance).clearExtension();
                return this;
            }

            public Builder clearFlag() {
                copyOnWrite();
                ((Message) this.instance).clearFlag();
                return this;
            }

            public Builder clearFrom() {
                copyOnWrite();
                ((Message) this.instance).clearFrom();
                return this;
            }

            public Builder clearMedia() {
                copyOnWrite();
                ((Message) this.instance).clearMedia();
                return this;
            }

            public Builder clearMid() {
                copyOnWrite();
                ((Message) this.instance).clearMid();
                return this;
            }

            public Builder clearRecommendInfo() {
                copyOnWrite();
                ((Message) this.instance).clearRecommendInfo();
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((Message) this.instance).clearStatus();
                return this;
            }

            public Builder clearStatusNotify() {
                copyOnWrite();
                ((Message) this.instance).clearStatusNotify();
                return this;
            }

            public Builder clearSubType() {
                copyOnWrite();
                ((Message) this.instance).clearSubType();
                return this;
            }

            public Builder clearSyncKey() {
                copyOnWrite();
                ((Message) this.instance).clearSyncKey();
                return this;
            }

            public Builder clearTo() {
                copyOnWrite();
                ((Message) this.instance).clearTo();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((Message) this.instance).clearType();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((Message) this.instance).clearVersion();
                return this;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public String getBody() {
                return ((Message) this.instance).getBody();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public ByteString getBodyBytes() {
                return ((Message) this.instance).getBodyBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public long getCreateTime() {
                return ((Message) this.instance).getCreateTime();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public int getExType() {
                return ((Message) this.instance).getExType();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public String getExtension() {
                return ((Message) this.instance).getExtension();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public ByteString getExtensionBytes() {
                return ((Message) this.instance).getExtensionBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public int getFlag() {
                return ((Message) this.instance).getFlag();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public String getFrom() {
                return ((Message) this.instance).getFrom();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public ByteString getFromBytes() {
                return ((Message) this.instance).getFromBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public Media getMedia() {
                return ((Message) this.instance).getMedia();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public String getMid() {
                return ((Message) this.instance).getMid();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public ByteString getMidBytes() {
                return ((Message) this.instance).getMidBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public RecommendInfo getRecommendInfo() {
                return ((Message) this.instance).getRecommendInfo();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public int getStatus() {
                return ((Message) this.instance).getStatus();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public StatusNotify getStatusNotify() {
                return ((Message) this.instance).getStatusNotify();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public int getSubType() {
                return ((Message) this.instance).getSubType();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public String getSyncKey() {
                return ((Message) this.instance).getSyncKey();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public ByteString getSyncKeyBytes() {
                return ((Message) this.instance).getSyncKeyBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public String getTo() {
                return ((Message) this.instance).getTo();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public ByteString getToBytes() {
                return ((Message) this.instance).getToBytes();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public int getType() {
                return ((Message) this.instance).getType();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public long getVersion() {
                return ((Message) this.instance).getVersion();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasBody() {
                return ((Message) this.instance).hasBody();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasCreateTime() {
                return ((Message) this.instance).hasCreateTime();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasExType() {
                return ((Message) this.instance).hasExType();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasExtension() {
                return ((Message) this.instance).hasExtension();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasFlag() {
                return ((Message) this.instance).hasFlag();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasFrom() {
                return ((Message) this.instance).hasFrom();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasMedia() {
                return ((Message) this.instance).hasMedia();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasMid() {
                return ((Message) this.instance).hasMid();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasRecommendInfo() {
                return ((Message) this.instance).hasRecommendInfo();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasStatus() {
                return ((Message) this.instance).hasStatus();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasStatusNotify() {
                return ((Message) this.instance).hasStatusNotify();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasSubType() {
                return ((Message) this.instance).hasSubType();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasSyncKey() {
                return ((Message) this.instance).hasSyncKey();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasTo() {
                return ((Message) this.instance).hasTo();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasType() {
                return ((Message) this.instance).hasType();
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
            public boolean hasVersion() {
                return ((Message) this.instance).hasVersion();
            }

            public Builder mergeMedia(Media media) {
                copyOnWrite();
                ((Message) this.instance).mergeMedia(media);
                return this;
            }

            public Builder mergeRecommendInfo(RecommendInfo recommendInfo) {
                copyOnWrite();
                ((Message) this.instance).mergeRecommendInfo(recommendInfo);
                return this;
            }

            public Builder mergeStatusNotify(StatusNotify statusNotify) {
                copyOnWrite();
                ((Message) this.instance).mergeStatusNotify(statusNotify);
                return this;
            }

            public Builder setBody(String str) {
                copyOnWrite();
                ((Message) this.instance).setBody(str);
                return this;
            }

            public Builder setBodyBytes(ByteString byteString) {
                copyOnWrite();
                ((Message) this.instance).setBodyBytes(byteString);
                return this;
            }

            public Builder setCreateTime(long j) {
                copyOnWrite();
                ((Message) this.instance).setCreateTime(j);
                return this;
            }

            public Builder setExType(int i) {
                copyOnWrite();
                ((Message) this.instance).setExType(i);
                return this;
            }

            public Builder setExtension(String str) {
                copyOnWrite();
                ((Message) this.instance).setExtension(str);
                return this;
            }

            public Builder setExtensionBytes(ByteString byteString) {
                copyOnWrite();
                ((Message) this.instance).setExtensionBytes(byteString);
                return this;
            }

            public Builder setFlag(int i) {
                copyOnWrite();
                ((Message) this.instance).setFlag(i);
                return this;
            }

            public Builder setFrom(String str) {
                copyOnWrite();
                ((Message) this.instance).setFrom(str);
                return this;
            }

            public Builder setFromBytes(ByteString byteString) {
                copyOnWrite();
                ((Message) this.instance).setFromBytes(byteString);
                return this;
            }

            public Builder setMedia(Media media) {
                copyOnWrite();
                ((Message) this.instance).setMedia(media);
                return this;
            }

            public Builder setMid(String str) {
                copyOnWrite();
                ((Message) this.instance).setMid(str);
                return this;
            }

            public Builder setMidBytes(ByteString byteString) {
                copyOnWrite();
                ((Message) this.instance).setMidBytes(byteString);
                return this;
            }

            public Builder setRecommendInfo(RecommendInfo recommendInfo) {
                copyOnWrite();
                ((Message) this.instance).setRecommendInfo(recommendInfo);
                return this;
            }

            public Builder setStatus(int i) {
                copyOnWrite();
                ((Message) this.instance).setStatus(i);
                return this;
            }

            public Builder setStatusNotify(StatusNotify statusNotify) {
                copyOnWrite();
                ((Message) this.instance).setStatusNotify(statusNotify);
                return this;
            }

            public Builder setSubType(int i) {
                copyOnWrite();
                ((Message) this.instance).setSubType(i);
                return this;
            }

            public Builder setSyncKey(String str) {
                copyOnWrite();
                ((Message) this.instance).setSyncKey(str);
                return this;
            }

            public Builder setSyncKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((Message) this.instance).setSyncKeyBytes(byteString);
                return this;
            }

            public Builder setTo(String str) {
                copyOnWrite();
                ((Message) this.instance).setTo(str);
                return this;
            }

            public Builder setToBytes(ByteString byteString) {
                copyOnWrite();
                ((Message) this.instance).setToBytes(byteString);
                return this;
            }

            public Builder setType(int i) {
                copyOnWrite();
                ((Message) this.instance).setType(i);
                return this;
            }

            public Builder setVersion(long j) {
                copyOnWrite();
                ((Message) this.instance).setVersion(j);
                return this;
            }

            private Builder() {
                super(Message.DEFAULT_INSTANCE);
            }

            public Builder setMedia(Media.Builder builder) {
                copyOnWrite();
                ((Message) this.instance).setMedia(builder);
                return this;
            }

            public Builder setRecommendInfo(RecommendInfo.Builder builder) {
                copyOnWrite();
                ((Message) this.instance).setRecommendInfo(builder);
                return this;
            }

            public Builder setStatusNotify(StatusNotify.Builder builder) {
                copyOnWrite();
                ((Message) this.instance).setStatusNotify(builder);
                return this;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class Media extends GeneratedMessageLite<Media, Builder> implements MediaOrBuilder {
            private static final Media DEFAULT_INSTANCE;
            public static final int EXTENSION_FIELD_NUMBER = 7;
            public static final int MEDIAID_FIELD_NUMBER = 6;
            public static final int MIMETYPE_FIELD_NUMBER = 8;
            public static final int NAME_FIELD_NUMBER = 4;
            private static volatile Parser<Media> PARSER = null;
            public static final int PLAYLENGTH_FIELD_NUMBER = 3;
            public static final int SIZE_FIELD_NUMBER = 5;
            public static final int THUMBURL_FIELD_NUMBER = 1;
            public static final int URL_FIELD_NUMBER = 2;
            private int bitField0_;
            private int playLength_;
            private int size_;
            private String thumbUrl_ = "";
            private String url_ = "";
            private String name_ = "";
            private String mediaId_ = "";
            private String extension_ = "";
            private String mimeType_ = "";

            /* JADX INFO: compiled from: SearchBox */
            public static final class Builder extends GeneratedMessageLite.Builder<Media, Builder> implements MediaOrBuilder {
                public Builder clearExtension() {
                    copyOnWrite();
                    ((Media) this.instance).clearExtension();
                    return this;
                }

                public Builder clearMediaId() {
                    copyOnWrite();
                    ((Media) this.instance).clearMediaId();
                    return this;
                }

                public Builder clearMimeType() {
                    copyOnWrite();
                    ((Media) this.instance).clearMimeType();
                    return this;
                }

                public Builder clearName() {
                    copyOnWrite();
                    ((Media) this.instance).clearName();
                    return this;
                }

                public Builder clearPlayLength() {
                    copyOnWrite();
                    ((Media) this.instance).clearPlayLength();
                    return this;
                }

                public Builder clearSize() {
                    copyOnWrite();
                    ((Media) this.instance).clearSize();
                    return this;
                }

                public Builder clearThumbUrl() {
                    copyOnWrite();
                    ((Media) this.instance).clearThumbUrl();
                    return this;
                }

                public Builder clearUrl() {
                    copyOnWrite();
                    ((Media) this.instance).clearUrl();
                    return this;
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public String getExtension() {
                    return ((Media) this.instance).getExtension();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public ByteString getExtensionBytes() {
                    return ((Media) this.instance).getExtensionBytes();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public String getMediaId() {
                    return ((Media) this.instance).getMediaId();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public ByteString getMediaIdBytes() {
                    return ((Media) this.instance).getMediaIdBytes();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public String getMimeType() {
                    return ((Media) this.instance).getMimeType();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public ByteString getMimeTypeBytes() {
                    return ((Media) this.instance).getMimeTypeBytes();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public String getName() {
                    return ((Media) this.instance).getName();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public ByteString getNameBytes() {
                    return ((Media) this.instance).getNameBytes();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public int getPlayLength() {
                    return ((Media) this.instance).getPlayLength();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public int getSize() {
                    return ((Media) this.instance).getSize();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public String getThumbUrl() {
                    return ((Media) this.instance).getThumbUrl();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public ByteString getThumbUrlBytes() {
                    return ((Media) this.instance).getThumbUrlBytes();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public String getUrl() {
                    return ((Media) this.instance).getUrl();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public ByteString getUrlBytes() {
                    return ((Media) this.instance).getUrlBytes();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public boolean hasExtension() {
                    return ((Media) this.instance).hasExtension();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public boolean hasMediaId() {
                    return ((Media) this.instance).hasMediaId();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public boolean hasMimeType() {
                    return ((Media) this.instance).hasMimeType();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public boolean hasName() {
                    return ((Media) this.instance).hasName();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public boolean hasPlayLength() {
                    return ((Media) this.instance).hasPlayLength();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public boolean hasSize() {
                    return ((Media) this.instance).hasSize();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public boolean hasThumbUrl() {
                    return ((Media) this.instance).hasThumbUrl();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
                public boolean hasUrl() {
                    return ((Media) this.instance).hasUrl();
                }

                public Builder setExtension(String str) {
                    copyOnWrite();
                    ((Media) this.instance).setExtension(str);
                    return this;
                }

                public Builder setExtensionBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Media) this.instance).setExtensionBytes(byteString);
                    return this;
                }

                public Builder setMediaId(String str) {
                    copyOnWrite();
                    ((Media) this.instance).setMediaId(str);
                    return this;
                }

                public Builder setMediaIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Media) this.instance).setMediaIdBytes(byteString);
                    return this;
                }

                public Builder setMimeType(String str) {
                    copyOnWrite();
                    ((Media) this.instance).setMimeType(str);
                    return this;
                }

                public Builder setMimeTypeBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Media) this.instance).setMimeTypeBytes(byteString);
                    return this;
                }

                public Builder setName(String str) {
                    copyOnWrite();
                    ((Media) this.instance).setName(str);
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Media) this.instance).setNameBytes(byteString);
                    return this;
                }

                public Builder setPlayLength(int i) {
                    copyOnWrite();
                    ((Media) this.instance).setPlayLength(i);
                    return this;
                }

                public Builder setSize(int i) {
                    copyOnWrite();
                    ((Media) this.instance).setSize(i);
                    return this;
                }

                public Builder setThumbUrl(String str) {
                    copyOnWrite();
                    ((Media) this.instance).setThumbUrl(str);
                    return this;
                }

                public Builder setThumbUrlBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Media) this.instance).setThumbUrlBytes(byteString);
                    return this;
                }

                public Builder setUrl(String str) {
                    copyOnWrite();
                    ((Media) this.instance).setUrl(str);
                    return this;
                }

                public Builder setUrlBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Media) this.instance).setUrlBytes(byteString);
                    return this;
                }

                private Builder() {
                    super(Media.DEFAULT_INSTANCE);
                }
            }

            static {
                Media media = new Media();
                DEFAULT_INSTANCE = media;
                media.makeImmutable();
            }

            private Media() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearExtension() {
                this.bitField0_ &= -65;
                this.extension_ = getDefaultInstance().getExtension();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMediaId() {
                this.bitField0_ &= -33;
                this.mediaId_ = getDefaultInstance().getMediaId();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMimeType() {
                this.bitField0_ &= -129;
                this.mimeType_ = getDefaultInstance().getMimeType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearName() {
                this.bitField0_ &= -9;
                this.name_ = getDefaultInstance().getName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPlayLength() {
                this.bitField0_ &= -5;
                this.playLength_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSize() {
                this.bitField0_ &= -17;
                this.size_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearThumbUrl() {
                this.bitField0_ &= -2;
                this.thumbUrl_ = getDefaultInstance().getThumbUrl();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUrl() {
                this.bitField0_ &= -3;
                this.url_ = getDefaultInstance().getUrl();
            }

            public static Media getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Media parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Media) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Media parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Media) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Media> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setExtension(String str) {
                str.getClass();
                this.bitField0_ |= 64;
                this.extension_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setExtensionBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 64;
                this.extension_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMediaId(String str) {
                str.getClass();
                this.bitField0_ |= 32;
                this.mediaId_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMediaIdBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 32;
                this.mediaId_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMimeType(String str) {
                str.getClass();
                this.bitField0_ |= 128;
                this.mimeType_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMimeTypeBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 128;
                this.mimeType_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setName(String str) {
                str.getClass();
                this.bitField0_ |= 8;
                this.name_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNameBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 8;
                this.name_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPlayLength(int i) {
                this.bitField0_ |= 4;
                this.playLength_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSize(int i) {
                this.bitField0_ |= 16;
                this.size_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setThumbUrl(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.thumbUrl_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setThumbUrlBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 1;
                this.thumbUrl_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUrl(String str) {
                str.getClass();
                this.bitField0_ |= 2;
                this.url_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUrlBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 2;
                this.url_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Media();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder();
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Media media = (Media) obj2;
                        this.thumbUrl_ = visitor.visitString(hasThumbUrl(), this.thumbUrl_, media.hasThumbUrl(), media.thumbUrl_);
                        this.url_ = visitor.visitString(hasUrl(), this.url_, media.hasUrl(), media.url_);
                        this.playLength_ = visitor.visitInt(hasPlayLength(), this.playLength_, media.hasPlayLength(), media.playLength_);
                        this.name_ = visitor.visitString(hasName(), this.name_, media.hasName(), media.name_);
                        this.size_ = visitor.visitInt(hasSize(), this.size_, media.hasSize(), media.size_);
                        this.mediaId_ = visitor.visitString(hasMediaId(), this.mediaId_, media.hasMediaId(), media.mediaId_);
                        this.extension_ = visitor.visitString(hasExtension(), this.extension_, media.hasExtension(), media.extension_);
                        this.mimeType_ = visitor.visitString(hasMimeType(), this.mimeType_, media.hasMimeType(), media.mimeType_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= media.bitField0_;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int tag = codedInputStream.readTag();
                                if (tag != 0) {
                                    if (tag == 10) {
                                        String string = codedInputStream.readString();
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.thumbUrl_ = string;
                                    } else if (tag == 18) {
                                        String string2 = codedInputStream.readString();
                                        this.bitField0_ |= 2;
                                        this.url_ = string2;
                                    } else if (tag == 24) {
                                        this.bitField0_ |= 4;
                                        this.playLength_ = codedInputStream.readUInt32();
                                    } else if (tag == 34) {
                                        String string3 = codedInputStream.readString();
                                        this.bitField0_ |= 8;
                                        this.name_ = string3;
                                    } else if (tag == 40) {
                                        this.bitField0_ |= 16;
                                        this.size_ = codedInputStream.readUInt32();
                                    } else if (tag == 50) {
                                        String string4 = codedInputStream.readString();
                                        this.bitField0_ |= 32;
                                        this.mediaId_ = string4;
                                    } else if (tag == 58) {
                                        String string5 = codedInputStream.readString();
                                        this.bitField0_ |= 64;
                                        this.extension_ = string5;
                                    } else if (tag == 66) {
                                        String string6 = codedInputStream.readString();
                                        this.bitField0_ |= 128;
                                        this.mimeType_ = string6;
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
                            synchronized (Media.class) {
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

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public String getExtension() {
                return this.extension_;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public ByteString getExtensionBytes() {
                return ByteString.copyFromUtf8(this.extension_);
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public String getMediaId() {
                return this.mediaId_;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public ByteString getMediaIdBytes() {
                return ByteString.copyFromUtf8(this.mediaId_);
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public String getMimeType() {
                return this.mimeType_;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public ByteString getMimeTypeBytes() {
                return ByteString.copyFromUtf8(this.mimeType_);
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public String getName() {
                return this.name_;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public ByteString getNameBytes() {
                return ByteString.copyFromUtf8(this.name_);
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public int getPlayLength() {
                return this.playLength_;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getThumbUrl()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(2, getUrl());
                }
                if ((this.bitField0_ & 4) == 4) {
                    iComputeStringSize += CodedOutputStream.computeUInt32Size(3, this.playLength_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(4, getName());
                }
                if ((this.bitField0_ & 16) == 16) {
                    iComputeStringSize += CodedOutputStream.computeUInt32Size(5, this.size_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(6, getMediaId());
                }
                if ((this.bitField0_ & 64) == 64) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(7, getExtension());
                }
                if ((this.bitField0_ & 128) == 128) {
                    iComputeStringSize += CodedOutputStream.computeStringSize(8, getMimeType());
                }
                int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public int getSize() {
                return this.size_;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public String getThumbUrl() {
                return this.thumbUrl_;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public ByteString getThumbUrlBytes() {
                return ByteString.copyFromUtf8(this.thumbUrl_);
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public String getUrl() {
                return this.url_;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public ByteString getUrlBytes() {
                return ByteString.copyFromUtf8(this.url_);
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public boolean hasExtension() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public boolean hasMediaId() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public boolean hasMimeType() {
                return (this.bitField0_ & 128) == 128;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public boolean hasPlayLength() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public boolean hasSize() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public boolean hasThumbUrl() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.MediaOrBuilder
            public boolean hasUrl() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeString(1, getThumbUrl());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeString(2, getUrl());
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeUInt32(3, this.playLength_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.writeString(4, getName());
                }
                if ((this.bitField0_ & 16) == 16) {
                    codedOutputStream.writeUInt32(5, this.size_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    codedOutputStream.writeString(6, getMediaId());
                }
                if ((this.bitField0_ & 64) == 64) {
                    codedOutputStream.writeString(7, getExtension());
                }
                if ((this.bitField0_ & 128) == 128) {
                    codedOutputStream.writeString(8, getMimeType());
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            public static Builder newBuilder(Media media) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(media);
            }

            public static Media parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Media) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Media parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Media) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Media parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Media) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Media parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Media) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Media parseFrom(InputStream inputStream) throws IOException {
                return (Media) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Media parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Media) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Media parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Media) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Media parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Media) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public interface MediaOrBuilder extends MessageLiteOrBuilder {
            String getExtension();

            ByteString getExtensionBytes();

            String getMediaId();

            ByteString getMediaIdBytes();

            String getMimeType();

            ByteString getMimeTypeBytes();

            String getName();

            ByteString getNameBytes();

            int getPlayLength();

            int getSize();

            String getThumbUrl();

            ByteString getThumbUrlBytes();

            String getUrl();

            ByteString getUrlBytes();

            boolean hasExtension();

            boolean hasMediaId();

            boolean hasMimeType();

            boolean hasName();

            boolean hasPlayLength();

            boolean hasSize();

            boolean hasThumbUrl();

            boolean hasUrl();
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class RecommendInfo extends GeneratedMessageLite<RecommendInfo, Builder> implements RecommendInfoOrBuilder {
            private static final RecommendInfo DEFAULT_INSTANCE;
            private static volatile Parser<RecommendInfo> PARSER;

            /* JADX INFO: compiled from: SearchBox */
            public static final class Builder extends GeneratedMessageLite.Builder<RecommendInfo, Builder> implements RecommendInfoOrBuilder {
                private Builder() {
                    super(RecommendInfo.DEFAULT_INSTANCE);
                }
            }

            static {
                RecommendInfo recommendInfo = new RecommendInfo();
                DEFAULT_INSTANCE = recommendInfo;
                recommendInfo.makeImmutable();
            }

            private RecommendInfo() {
            }

            public static RecommendInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static RecommendInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (RecommendInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static RecommendInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (RecommendInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<RecommendInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new RecommendInfo();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder();
                    case 5:
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int tag = codedInputStream.readTag();
                                if (tag == 0 || !parseUnknownField(tag, codedInputStream)) {
                                    z = true;
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
                            synchronized (RecommendInfo.class) {
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

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int serializedSize = this.unknownFields.getSerializedSize() + 0;
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                this.unknownFields.writeTo(codedOutputStream);
            }

            public static Builder newBuilder(RecommendInfo recommendInfo) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(recommendInfo);
            }

            public static RecommendInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (RecommendInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static RecommendInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (RecommendInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static RecommendInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (RecommendInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static RecommendInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (RecommendInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static RecommendInfo parseFrom(InputStream inputStream) throws IOException {
                return (RecommendInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static RecommendInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (RecommendInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static RecommendInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (RecommendInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static RecommendInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (RecommendInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public interface RecommendInfoOrBuilder extends MessageLiteOrBuilder {
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class StatusNotify extends GeneratedMessageLite<StatusNotify, Builder> implements StatusNotifyOrBuilder {
            public static final int CODE_FIELD_NUMBER = 1;
            private static final StatusNotify DEFAULT_INSTANCE;
            private static volatile Parser<StatusNotify> PARSER = null;
            public static final int USER_FIELD_NUMBER = 2;
            private int bitField0_;
            private int code_;
            private String user_ = "";

            /* JADX INFO: compiled from: SearchBox */
            public static final class Builder extends GeneratedMessageLite.Builder<StatusNotify, Builder> implements StatusNotifyOrBuilder {
                public Builder clearCode() {
                    copyOnWrite();
                    ((StatusNotify) this.instance).clearCode();
                    return this;
                }

                public Builder clearUser() {
                    copyOnWrite();
                    ((StatusNotify) this.instance).clearUser();
                    return this;
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.StatusNotifyOrBuilder
                public int getCode() {
                    return ((StatusNotify) this.instance).getCode();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.StatusNotifyOrBuilder
                public String getUser() {
                    return ((StatusNotify) this.instance).getUser();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.StatusNotifyOrBuilder
                public ByteString getUserBytes() {
                    return ((StatusNotify) this.instance).getUserBytes();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.StatusNotifyOrBuilder
                public boolean hasCode() {
                    return ((StatusNotify) this.instance).hasCode();
                }

                @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.StatusNotifyOrBuilder
                public boolean hasUser() {
                    return ((StatusNotify) this.instance).hasUser();
                }

                public Builder setCode(int i) {
                    copyOnWrite();
                    ((StatusNotify) this.instance).setCode(i);
                    return this;
                }

                public Builder setUser(String str) {
                    copyOnWrite();
                    ((StatusNotify) this.instance).setUser(str);
                    return this;
                }

                public Builder setUserBytes(ByteString byteString) {
                    copyOnWrite();
                    ((StatusNotify) this.instance).setUserBytes(byteString);
                    return this;
                }

                private Builder() {
                    super(StatusNotify.DEFAULT_INSTANCE);
                }
            }

            static {
                StatusNotify statusNotify = new StatusNotify();
                DEFAULT_INSTANCE = statusNotify;
                statusNotify.makeImmutable();
            }

            private StatusNotify() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCode() {
                this.bitField0_ &= -2;
                this.code_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUser() {
                this.bitField0_ &= -3;
                this.user_ = getDefaultInstance().getUser();
            }

            public static StatusNotify getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static StatusNotify parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (StatusNotify) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static StatusNotify parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (StatusNotify) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<StatusNotify> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCode(int i) {
                this.bitField0_ |= 1;
                this.code_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUser(String str) {
                str.getClass();
                this.bitField0_ |= 2;
                this.user_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUserBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 2;
                this.user_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new StatusNotify();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder();
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        StatusNotify statusNotify = (StatusNotify) obj2;
                        this.code_ = visitor.visitInt(hasCode(), this.code_, statusNotify.hasCode(), statusNotify.code_);
                        this.user_ = visitor.visitString(hasUser(), this.user_, statusNotify.hasUser(), statusNotify.user_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= statusNotify.bitField0_;
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
                                        this.code_ = codedInputStream.readUInt32();
                                    } else if (tag == 18) {
                                        String string = codedInputStream.readString();
                                        this.bitField0_ |= 2;
                                        this.user_ = string;
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
                            synchronized (StatusNotify.class) {
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

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.StatusNotifyOrBuilder
            public int getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeUInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeUInt32Size(1, this.code_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iComputeUInt32Size += CodedOutputStream.computeStringSize(2, getUser());
                }
                int serializedSize = iComputeUInt32Size + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.StatusNotifyOrBuilder
            public String getUser() {
                return this.user_;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.StatusNotifyOrBuilder
            public ByteString getUserBytes() {
                return ByteString.copyFromUtf8(this.user_);
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.StatusNotifyOrBuilder
            public boolean hasCode() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // im.youni.iccs.iprotobuf.domain.MessageProto.Message.StatusNotifyOrBuilder
            public boolean hasUser() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeUInt32(1, this.code_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeString(2, getUser());
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            public static Builder newBuilder(StatusNotify statusNotify) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(statusNotify);
            }

            public static StatusNotify parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (StatusNotify) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static StatusNotify parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (StatusNotify) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static StatusNotify parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (StatusNotify) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static StatusNotify parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (StatusNotify) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static StatusNotify parseFrom(InputStream inputStream) throws IOException {
                return (StatusNotify) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static StatusNotify parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (StatusNotify) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static StatusNotify parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (StatusNotify) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static StatusNotify parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (StatusNotify) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public interface StatusNotifyOrBuilder extends MessageLiteOrBuilder {
            int getCode();

            String getUser();

            ByteString getUserBytes();

            boolean hasCode();

            boolean hasUser();
        }

        static {
            Message message = new Message();
            DEFAULT_INSTANCE = message;
            message.makeImmutable();
        }

        private Message() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -17;
            this.body_ = getDefaultInstance().getBody();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCreateTime() {
            this.bitField0_ &= -65;
            this.createTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExType() {
            this.bitField0_ &= -32769;
            this.exType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExtension() {
            this.bitField0_ &= ErrorCode.ERROR_CODE_JOIN_ROOM_ROOM_FORBIDDEN;
            this.extension_ = getDefaultInstance().getExtension();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFlag() {
            this.bitField0_ &= -16385;
            this.flag_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFrom() {
            this.bitField0_ &= -3;
            this.from_ = getDefaultInstance().getFrom();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMedia() {
            this.media_ = null;
            this.bitField0_ &= -129;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMid() {
            this.bitField0_ &= -2;
            this.mid_ = getDefaultInstance().getMid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecommendInfo() {
            this.recommendInfo_ = null;
            this.bitField0_ &= -257;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStatus() {
            this.bitField0_ &= -33;
            this.status_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStatusNotify() {
            this.statusNotify_ = null;
            this.bitField0_ &= -513;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSubType() {
            this.bitField0_ &= -2049;
            this.subType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSyncKey() {
            this.bitField0_ &= -4097;
            this.syncKey_ = getDefaultInstance().getSyncKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTo() {
            this.bitField0_ &= -5;
            this.to_ = getDefaultInstance().getTo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -9;
            this.type_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.bitField0_ &= -8193;
            this.version_ = 0L;
        }

        public static Message getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMedia(Media media) {
            Media media2 = this.media_;
            if (media2 == null || media2 == Media.getDefaultInstance()) {
                this.media_ = media;
            } else {
                this.media_ = Media.newBuilder(this.media_).mergeFrom(media).buildPartial();
            }
            this.bitField0_ |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRecommendInfo(RecommendInfo recommendInfo) {
            RecommendInfo recommendInfo2 = this.recommendInfo_;
            if (recommendInfo2 == null || recommendInfo2 == RecommendInfo.getDefaultInstance()) {
                this.recommendInfo_ = recommendInfo;
            } else {
                this.recommendInfo_ = RecommendInfo.newBuilder(this.recommendInfo_).mergeFrom(recommendInfo).buildPartial();
            }
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeStatusNotify(StatusNotify statusNotify) {
            StatusNotify statusNotify2 = this.statusNotify_;
            if (statusNotify2 == null || statusNotify2 == StatusNotify.getDefaultInstance()) {
                this.statusNotify_ = statusNotify;
            } else {
                this.statusNotify_ = StatusNotify.newBuilder(this.statusNotify_).mergeFrom(statusNotify).buildPartial();
            }
            this.bitField0_ |= 512;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Message parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Message) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Message parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Message> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.body_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBodyBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.body_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreateTime(long j) {
            this.bitField0_ |= 64;
            this.createTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExType(int i) {
            this.bitField0_ |= 32768;
            this.exType_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtension(String str) {
            str.getClass();
            this.bitField0_ |= 1024;
            this.extension_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtensionBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1024;
            this.extension_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFlag(int i) {
            this.bitField0_ |= 16384;
            this.flag_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFrom(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.from_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFromBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.from_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMedia(Media media) {
            media.getClass();
            this.media_ = media;
            this.bitField0_ |= 128;
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
        public void setRecommendInfo(RecommendInfo recommendInfo) {
            recommendInfo.getClass();
            this.recommendInfo_ = recommendInfo;
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStatus(int i) {
            this.bitField0_ |= 32;
            this.status_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStatusNotify(StatusNotify statusNotify) {
            statusNotify.getClass();
            this.statusNotify_ = statusNotify;
            this.bitField0_ |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSubType(int i) {
            this.bitField0_ |= 2048;
            this.subType_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSyncKey(String str) {
            str.getClass();
            this.bitField0_ |= 4096;
            this.syncKey_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSyncKeyBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4096;
            this.syncKey_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTo(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.to_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.to_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i) {
            this.bitField0_ |= 8;
            this.type_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(long j) {
            this.bitField0_ |= 8192;
            this.version_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Message();
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
                    if (!hasFrom()) {
                        if (zBooleanValue) {
                            this.memoizedIsInitialized = (byte) 0;
                        }
                        return null;
                    }
                    if (!hasTo()) {
                        if (zBooleanValue) {
                            this.memoizedIsInitialized = (byte) 0;
                        }
                        return null;
                    }
                    if (hasType()) {
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
                    Message message = (Message) obj2;
                    this.mid_ = visitor.visitString(hasMid(), this.mid_, message.hasMid(), message.mid_);
                    this.from_ = visitor.visitString(hasFrom(), this.from_, message.hasFrom(), message.from_);
                    this.to_ = visitor.visitString(hasTo(), this.to_, message.hasTo(), message.to_);
                    this.type_ = visitor.visitInt(hasType(), this.type_, message.hasType(), message.type_);
                    this.body_ = visitor.visitString(hasBody(), this.body_, message.hasBody(), message.body_);
                    this.status_ = visitor.visitInt(hasStatus(), this.status_, message.hasStatus(), message.status_);
                    this.createTime_ = visitor.visitLong(hasCreateTime(), this.createTime_, message.hasCreateTime(), message.createTime_);
                    this.media_ = (Media) visitor.visitMessage(this.media_, message.media_);
                    this.recommendInfo_ = (RecommendInfo) visitor.visitMessage(this.recommendInfo_, message.recommendInfo_);
                    this.statusNotify_ = (StatusNotify) visitor.visitMessage(this.statusNotify_, message.statusNotify_);
                    this.extension_ = visitor.visitString(hasExtension(), this.extension_, message.hasExtension(), message.extension_);
                    this.subType_ = visitor.visitInt(hasSubType(), this.subType_, message.hasSubType(), message.subType_);
                    this.syncKey_ = visitor.visitString(hasSyncKey(), this.syncKey_, message.hasSyncKey(), message.syncKey_);
                    this.version_ = visitor.visitLong(hasVersion(), this.version_, message.hasVersion(), message.version_);
                    this.flag_ = visitor.visitInt(hasFlag(), this.flag_, message.hasFlag(), message.flag_);
                    this.exType_ = visitor.visitInt(hasExType(), this.exType_, message.hasExType(), message.exType_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= message.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
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
                                    this.from_ = string2;
                                    break;
                                case 26:
                                    String string3 = codedInputStream.readString();
                                    this.bitField0_ |= 4;
                                    this.to_ = string3;
                                    break;
                                case 32:
                                    this.bitField0_ |= 8;
                                    this.type_ = codedInputStream.readUInt32();
                                    break;
                                case 42:
                                    String string4 = codedInputStream.readString();
                                    this.bitField0_ |= 16;
                                    this.body_ = string4;
                                    break;
                                case 48:
                                    this.bitField0_ |= 32;
                                    this.status_ = codedInputStream.readUInt32();
                                    break;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.createTime_ = codedInputStream.readUInt64();
                                    break;
                                case 66:
                                    Media.Builder builder = (this.bitField0_ & 128) == 128 ? this.media_.toBuilder() : null;
                                    Media media = (Media) codedInputStream.readMessage(Media.parser(), extensionRegistryLite);
                                    this.media_ = media;
                                    if (builder != null) {
                                        builder.mergeFrom(media);
                                        this.media_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 128;
                                    break;
                                case 74:
                                    RecommendInfo.Builder builder2 = (this.bitField0_ & 256) == 256 ? this.recommendInfo_.toBuilder() : null;
                                    RecommendInfo recommendInfo = (RecommendInfo) codedInputStream.readMessage(RecommendInfo.parser(), extensionRegistryLite);
                                    this.recommendInfo_ = recommendInfo;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(recommendInfo);
                                        this.recommendInfo_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 256;
                                    break;
                                case 82:
                                    StatusNotify.Builder builder3 = (this.bitField0_ & 512) == 512 ? this.statusNotify_.toBuilder() : null;
                                    StatusNotify statusNotify = (StatusNotify) codedInputStream.readMessage(StatusNotify.parser(), extensionRegistryLite);
                                    this.statusNotify_ = statusNotify;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(statusNotify);
                                        this.statusNotify_ = builder3.buildPartial();
                                    }
                                    this.bitField0_ |= 512;
                                    break;
                                case 90:
                                    String string5 = codedInputStream.readString();
                                    this.bitField0_ |= 1024;
                                    this.extension_ = string5;
                                    break;
                                case 96:
                                    this.bitField0_ |= 2048;
                                    this.subType_ = codedInputStream.readUInt32();
                                    break;
                                case 106:
                                    String string6 = codedInputStream.readString();
                                    this.bitField0_ |= 4096;
                                    this.syncKey_ = string6;
                                    break;
                                case 112:
                                    this.bitField0_ |= 8192;
                                    this.version_ = codedInputStream.readUInt64();
                                    break;
                                case 120:
                                    this.bitField0_ |= 16384;
                                    this.flag_ = codedInputStream.readUInt32();
                                    break;
                                case 128:
                                    this.bitField0_ |= 32768;
                                    this.exType_ = codedInputStream.readUInt32();
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
                        synchronized (Message.class) {
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

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public String getBody() {
            return this.body_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public ByteString getBodyBytes() {
            return ByteString.copyFromUtf8(this.body_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public long getCreateTime() {
            return this.createTime_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public int getExType() {
            return this.exType_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public String getExtension() {
            return this.extension_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public ByteString getExtensionBytes() {
            return ByteString.copyFromUtf8(this.extension_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public int getFlag() {
            return this.flag_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public String getFrom() {
            return this.from_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public ByteString getFromBytes() {
            return ByteString.copyFromUtf8(this.from_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public Media getMedia() {
            Media media = this.media_;
            return media == null ? Media.getDefaultInstance() : media;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public String getMid() {
            return this.mid_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public ByteString getMidBytes() {
            return ByteString.copyFromUtf8(this.mid_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public RecommendInfo getRecommendInfo() {
            RecommendInfo recommendInfo = this.recommendInfo_;
            return recommendInfo == null ? RecommendInfo.getDefaultInstance() : recommendInfo;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getMid()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getFrom());
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getTo());
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeStringSize += CodedOutputStream.computeUInt32Size(4, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, getBody());
            }
            if ((this.bitField0_ & 32) == 32) {
                iComputeStringSize += CodedOutputStream.computeUInt32Size(6, this.status_);
            }
            if ((this.bitField0_ & 64) == 64) {
                iComputeStringSize += CodedOutputStream.computeUInt64Size(7, this.createTime_);
            }
            if ((this.bitField0_ & 128) == 128) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(8, getMedia());
            }
            if ((this.bitField0_ & 256) == 256) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(9, getRecommendInfo());
            }
            if ((this.bitField0_ & 512) == 512) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(10, getStatusNotify());
            }
            if ((this.bitField0_ & 1024) == 1024) {
                iComputeStringSize += CodedOutputStream.computeStringSize(11, getExtension());
            }
            if ((this.bitField0_ & 2048) == 2048) {
                iComputeStringSize += CodedOutputStream.computeUInt32Size(12, this.subType_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                iComputeStringSize += CodedOutputStream.computeStringSize(13, getSyncKey());
            }
            if ((this.bitField0_ & 8192) == 8192) {
                iComputeStringSize += CodedOutputStream.computeUInt64Size(14, this.version_);
            }
            if ((this.bitField0_ & 16384) == 16384) {
                iComputeStringSize += CodedOutputStream.computeUInt32Size(15, this.flag_);
            }
            if ((this.bitField0_ & 32768) == 32768) {
                iComputeStringSize += CodedOutputStream.computeUInt32Size(16, this.exType_);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public int getStatus() {
            return this.status_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public StatusNotify getStatusNotify() {
            StatusNotify statusNotify = this.statusNotify_;
            return statusNotify == null ? StatusNotify.getDefaultInstance() : statusNotify;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public int getSubType() {
            return this.subType_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public String getSyncKey() {
            return this.syncKey_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public ByteString getSyncKeyBytes() {
            return ByteString.copyFromUtf8(this.syncKey_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public String getTo() {
            return this.to_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public ByteString getToBytes() {
            return ByteString.copyFromUtf8(this.to_);
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public long getVersion() {
            return this.version_;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasBody() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasCreateTime() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasExType() {
            return (this.bitField0_ & 32768) == 32768;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasExtension() {
            return (this.bitField0_ & 1024) == 1024;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasFlag() {
            return (this.bitField0_ & 16384) == 16384;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasFrom() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasMedia() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasMid() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasRecommendInfo() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasStatus() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasStatusNotify() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasSubType() {
            return (this.bitField0_ & 2048) == 2048;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasSyncKey() {
            return (this.bitField0_ & 4096) == 4096;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasTo() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // im.youni.iccs.iprotobuf.domain.MessageProto.MessageOrBuilder
        public boolean hasVersion() {
            return (this.bitField0_ & 8192) == 8192;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getMid());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getFrom());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeString(3, getTo());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeUInt32(4, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeString(5, getBody());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeUInt32(6, this.status_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeUInt64(7, this.createTime_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(8, getMedia());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeMessage(9, getRecommendInfo());
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeMessage(10, getStatusNotify());
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeString(11, getExtension());
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeUInt32(12, this.subType_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.writeString(13, getSyncKey());
            }
            if ((this.bitField0_ & 8192) == 8192) {
                codedOutputStream.writeUInt64(14, this.version_);
            }
            if ((this.bitField0_ & 16384) == 16384) {
                codedOutputStream.writeUInt32(15, this.flag_);
            }
            if ((this.bitField0_ & 32768) == 32768) {
                codedOutputStream.writeUInt32(16, this.exType_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(Message message) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(message);
        }

        public static Message parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Message) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Message parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Message parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Message parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMedia(Media.Builder builder) {
            this.media_ = builder.build();
            this.bitField0_ |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecommendInfo(RecommendInfo.Builder builder) {
            this.recommendInfo_ = builder.build();
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStatusNotify(StatusNotify.Builder builder) {
            this.statusNotify_ = builder.build();
            this.bitField0_ |= 512;
        }

        public static Message parseFrom(InputStream inputStream) throws IOException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Message parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Message parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Message parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface MessageOrBuilder extends MessageLiteOrBuilder {
        String getBody();

        ByteString getBodyBytes();

        long getCreateTime();

        int getExType();

        String getExtension();

        ByteString getExtensionBytes();

        int getFlag();

        String getFrom();

        ByteString getFromBytes();

        Message.Media getMedia();

        String getMid();

        ByteString getMidBytes();

        Message.RecommendInfo getRecommendInfo();

        int getStatus();

        Message.StatusNotify getStatusNotify();

        int getSubType();

        String getSyncKey();

        ByteString getSyncKeyBytes();

        String getTo();

        ByteString getToBytes();

        int getType();

        long getVersion();

        boolean hasBody();

        boolean hasCreateTime();

        boolean hasExType();

        boolean hasExtension();

        boolean hasFlag();

        boolean hasFrom();

        boolean hasMedia();

        boolean hasMid();

        boolean hasRecommendInfo();

        boolean hasStatus();

        boolean hasStatusNotify();

        boolean hasSubType();

        boolean hasSyncKey();

        boolean hasTo();

        boolean hasType();

        boolean hasVersion();
    }

    private MessageProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
