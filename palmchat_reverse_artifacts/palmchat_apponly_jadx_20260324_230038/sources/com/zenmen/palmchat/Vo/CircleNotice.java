package com.zenmen.palmchat.Vo;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleNotice {
    private Notice notice;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static final class Notice {
        private int confirm;
        private String content;
        private int mediaType;
        private String mediaUrl;
        private int noticeId;
        private String rid;
        private int status;
        private String targetUrl;
        private int topChatWindow;

        public int getConfirm() {
            return this.confirm;
        }

        public String getContent() {
            return this.content;
        }

        public int getMediaType() {
            return this.mediaType;
        }

        public String getMediaUrl() {
            return this.mediaUrl;
        }

        public int getNoticeId() {
            return this.noticeId;
        }

        public String getRid() {
            return this.rid;
        }

        public int getStatus() {
            return this.status;
        }

        public String getTargetUrl() {
            return this.targetUrl;
        }

        public int getTopChatWindow() {
            return this.topChatWindow;
        }

        public void setConfirm(int i) {
            this.confirm = i;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setMediaType(int i) {
            this.mediaType = i;
        }

        public void setMediaUrl(String str) {
            this.mediaUrl = str;
        }

        public void setNoticeId(int i) {
            this.noticeId = i;
        }

        public void setRid(String str) {
            this.rid = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public void setTargetUrl(String str) {
            this.targetUrl = str;
        }

        public void setTopChatWindow(int i) {
            this.topChatWindow = i;
        }
    }

    public Notice getNotice() {
        return this.notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }
}
