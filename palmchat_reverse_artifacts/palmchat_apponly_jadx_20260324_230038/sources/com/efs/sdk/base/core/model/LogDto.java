package com.efs.sdk.base.core.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class LogDto {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f5587a;
    private b b = new b();
    private byte[] c;
    private File d;

    public LogDto(String str, byte b) {
        this.f5587a = new a(str, b);
    }

    private void a() {
        if (getLogBodyType() == 0 && getData() != null) {
            this.f5587a.f = getData().length;
        } else if (getLogBodyType() == 1 && getFile().exists()) {
            this.f5587a.f = getFile().length();
        }
    }

    public static LogDto buildLogDto(ILogProtocol iLogProtocol) {
        LogDto logDto;
        LogDto logDto2 = null;
        try {
            logDto = new LogDto(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
        } catch (Exception e) {
            e = e;
        }
        try {
            int bodyType = iLogProtocol.getBodyType();
            if (bodyType == 0) {
                logDto.setLogBodyType(0);
                logDto.setData(iLogProtocol.generate());
                if (Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType())) {
                    logDto.setUid(ControllerCenter.getGlobalEnvStruct().getLogUid());
                    logDto.setDid(ControllerCenter.getGlobalEnvStruct().getLogDid());
                    logDto.setBeginTime(iLogProtocol.getLogBeginTime());
                    logDto.setEndTime(iLogProtocol.getLogEndTime());
                }
            } else if (bodyType != 1) {
                Log.w("efs.base", "Can not support body type: " + iLogProtocol.getBodyType());
            } else {
                logDto.setLogBodyType(1);
                logDto.setFile(new File(iLogProtocol.getFilePath()));
            }
            return logDto;
        } catch (Exception e2) {
            e = e2;
            logDto2 = logDto;
            Log.e("efs.base", "log send error", e);
            return logDto2;
        }
    }

    public long getBeginTime() {
        return this.f5587a.j;
    }

    public long getBodySize() {
        a();
        return this.f5587a.f;
    }

    public String getCp() {
        return this.f5587a.d;
    }

    public byte[] getData() {
        return this.c;
    }

    public int getDe() {
        return this.f5587a.e;
    }

    public String getDid() {
        return this.f5587a.i;
    }

    public long getEndTime() {
        return this.f5587a.k;
    }

    public File getFile() {
        return this.d;
    }

    public int getLogBodyType() {
        return this.f5587a.c;
    }

    public int getLogCnt() {
        return this.f5587a.g;
    }

    public byte getLogProtocol() {
        return this.f5587a.b;
    }

    public String getLogType() {
        return this.f5587a.f5588a;
    }

    @Nullable
    public HttpResponse getResponseDto() {
        return this.b.c;
    }

    public String getUid() {
        return this.f5587a.h;
    }

    public boolean isCp() {
        return !"none".equals(this.f5587a.d);
    }

    public boolean isDe() {
        return 1 != this.f5587a.e;
    }

    public boolean isLimitByFlow() {
        return this.b.b;
    }

    public boolean isSendImediately() {
        return this.b.f5589a;
    }

    public void setBeginTime(long j) {
        this.f5587a.j = j;
    }

    public void setCp(String str) {
        this.f5587a.d = str;
    }

    public void setData(byte[] bArr) {
        this.c = bArr;
        a();
    }

    public void setDe(int i) {
        this.f5587a.e = i;
        a();
    }

    public void setDid(String str) {
        this.f5587a.i = str;
    }

    public void setEndTime(long j) {
        this.f5587a.k = j;
    }

    public void setFile(File file) {
        this.d = file;
    }

    public void setLimitByFlow(boolean z) {
        this.b.b = z;
    }

    public void setLogBodyType(int i) {
        this.f5587a.c = i;
    }

    public void setLogCnt(int i) {
        this.f5587a.g = i;
    }

    public void setResponseDto(@NonNull HttpResponse httpResponse) {
        this.b.c = httpResponse;
    }

    public void setSendImediately(boolean z) {
        this.b.f5589a = z;
    }

    public void setUid(String str) {
        this.f5587a.h = str;
    }
}
