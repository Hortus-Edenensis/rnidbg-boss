package com.baidu.platform.comapi.longlink;

import com.baidu.platform.comapi.exception.ComInitException;
import com.baidu.platform.comapi.exception.InvalidComException;
import com.baidu.platform.comjni.base.longlink.NALongLink;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class LongLinkClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4147a;
    private long b;
    private int c;

    private LongLinkClient(long j, int i) {
        this.b = j;
        this.f4147a = i;
    }

    public static LongLinkClient create() throws ComInitException {
        long jCreate = NALongLink.create();
        if (jCreate != 0) {
            return new LongLinkClient(jCreate);
        }
        throw new ComInitException("LongLink Component created failed!");
    }

    public synchronized int getRequestId() {
        return this.c;
    }

    public boolean init(String str, String str2) throws InvalidComException {
        if (isValid()) {
            return NALongLink.init(this.b, str, str2);
        }
        throw new InvalidComException();
    }

    public boolean isValid() {
        return this.b != 0;
    }

    public synchronized boolean register(LongLinkDataCallback longLinkDataCallback) throws InvalidComException {
        if (!isValid()) {
            throw new InvalidComException();
        }
        return NALongLink.register(this.b, this.f4147a, longLinkDataCallback);
    }

    public int release() {
        if (!isValid() || NALongLink.release(this.b) > 0) {
            return -1;
        }
        this.b = 0L;
        return -1;
    }

    public synchronized ELongLinkStatus sendData(byte[] bArr) throws InvalidComException {
        ELongLinkStatus eLongLinkStatus;
        if (!isValid()) {
            throw new InvalidComException();
        }
        this.c++;
        eLongLinkStatus = ELongLinkStatus.values()[NALongLink.sendData(this.b, this.f4147a, this.c, bArr)];
        eLongLinkStatus.setRequestId(this.c);
        return eLongLinkStatus;
    }

    public synchronized ELongLinkStatus sendFileData(String str, ArrayList<LongLinkFileData> arrayList) throws InvalidComException {
        ELongLinkStatus eLongLinkStatus;
        if (!isValid()) {
            throw new InvalidComException();
        }
        this.c++;
        eLongLinkStatus = ELongLinkStatus.values()[NALongLink.sendFileData(this.b, this.f4147a, this.c, str, arrayList)];
        eLongLinkStatus.setRequestId(this.c);
        return eLongLinkStatus;
    }

    public void setModuleId(int i) {
        this.f4147a = i;
    }

    public boolean start() throws InvalidComException {
        if (isValid()) {
            return NALongLink.start(this.b);
        }
        throw new InvalidComException();
    }

    public void stop() throws InvalidComException {
        if (!isValid()) {
            throw new InvalidComException();
        }
        NALongLink.stop(this.b);
    }

    public synchronized boolean unRegister(LongLinkDataCallback longLinkDataCallback) throws InvalidComException {
        if (!isValid()) {
            throw new InvalidComException();
        }
        return NALongLink.unRegister(this.b, this.f4147a, longLinkDataCallback);
    }

    private LongLinkClient(long j) {
        this.b = j;
    }

    public static LongLinkClient create(int i) throws ComInitException {
        long jCreate = NALongLink.create();
        if (jCreate != 0) {
            return new LongLinkClient(jCreate, i);
        }
        throw new ComInitException("LongLink Component created failed!");
    }
}
