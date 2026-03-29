package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleApplyGroupType implements Serializable {
    private int addType;
    private CheckMode identityCheck;
    private String roomId;

    /* JADX INFO: compiled from: SearchBox */
    public static class CheckMode implements Serializable {
        private int adminVerifyFlag;
        private String checkAnswer;
        private String checkQuestion;
        private int checkType;
        private int memberInviteFlag;

        public int getAdminVerifyFlag() {
            return this.adminVerifyFlag;
        }

        public String getCheckAnswer() {
            return this.checkAnswer;
        }

        public String getCheckQuestion() {
            return this.checkQuestion;
        }

        public int getCheckType() {
            return this.checkType;
        }

        public int getMemberInviteFlag() {
            return this.memberInviteFlag;
        }

        public void setAdminVerifyFlag(int i) {
            this.adminVerifyFlag = i;
        }

        public void setCheckAnswer(String str) {
            this.checkAnswer = str;
        }

        public void setCheckQuestion(String str) {
            this.checkQuestion = str;
        }

        public void setCheckType(int i) {
            this.checkType = i;
        }

        public void setMemberInviteFlag(int i) {
            this.memberInviteFlag = i;
        }
    }

    public int getAddType() {
        return this.addType;
    }

    public CheckMode getIdentityCheck() {
        return this.identityCheck;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setAddType(int i) {
        this.addType = i;
    }

    public void setIdentityCheck(CheckMode checkMode) {
        this.identityCheck = checkMode;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
