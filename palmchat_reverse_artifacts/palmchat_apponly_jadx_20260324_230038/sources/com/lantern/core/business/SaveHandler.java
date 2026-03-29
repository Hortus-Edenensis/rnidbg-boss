package com.lantern.core.business;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.lantern.core.database.DataStoreManager;
import com.lantern.core.database.EventLimitSp;
import com.lantern.core.log.MyLog;
import com.lantern.core.protobuf.ProtobufRequestBeanOuterClass;
import com.lantern.core.protobuf.event.EventOuterClass;
import defpackage.cm0;
import defpackage.ul0;
import defpackage.wn1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SaveHandler {
    private static final int MESSAGE_SAVE_DBERROR = 1;
    private static final int MESSAGE_SAVE_EVENT = 0;
    private final Context mContext;
    private final DataStoreManager mDBManager;
    private final EventLimitSp mEventLimitSp;
    private SaveListener mListener;
    private final IPubParams mPubParams;
    private final MyHandler myHandler;

    /* JADX INFO: compiled from: SearchBox */
    public class MyHandler extends Handler {
        public MyHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                Log.i("CX_EVENT", "SaveHandler handle MESSAGE_SAVE_DBERROR");
                Object obj = message.obj;
                if (obj instanceof EventInfo) {
                    EventInfo eventInfo = (EventInfo) obj;
                    SaveHandler.this.mDBManager.addEventSp(SaveHandler.this.info2DBData(eventInfo, ul0.b(SaveHandler.this.mContext).a(eventInfo.getEventId()), message.arg1));
                    return;
                }
                return;
            }
            Log.i("CX_EVENT", "SaveHandler handle MESSAGE_SAVE_EVENT");
            MyLog.save("", "receive MESSAGE_SAVE_EVENT");
            Object obj2 = message.obj;
            if (obj2 instanceof EventInfo) {
                EventInfo eventInfo2 = (EventInfo) obj2;
                int i2 = message.arg1;
                MyLog.save("", "event = " + eventInfo2.getEventId() + " get config.");
                cm0 cm0VarA = ul0.b(SaveHandler.this.mContext).a(eventInfo2.getEventId());
                if (cm0VarA != null) {
                    if (cm0VarA.c() == 5) {
                        return;
                    }
                    if (SaveHandler.this.mPubParams.isUseLimit() && cm0VarA.d() != -1) {
                        if (SaveHandler.this.mEventLimitSp.getTodayTimes(eventInfo2.getEventId(), EventLimitSp.getToday()) >= cm0VarA.d()) {
                            return;
                        } else {
                            SaveHandler.this.mEventLimitSp.plusOneTimes(eventInfo2.getEventId(), EventLimitSp.getToday());
                        }
                    }
                }
                MyLog.save("", "event = " + eventInfo2.getEventId() + ", change info to DBData");
                Event eventInfo2DBData = SaveHandler.this.info2DBData(eventInfo2, cm0VarA, i2);
                MyLog.save("", "event = " + eventInfo2DBData.getEventId() + ", level = " + eventInfo2DBData.getLevel() + ", prepare to save");
                if (eventInfo2DBData.getLevel() == 4) {
                    if (SaveHandler.this.mListener != null) {
                        SaveHandler.this.mListener.sendOnce(eventInfo2DBData);
                        return;
                    }
                    return;
                }
                long jAddEvent = SaveHandler.this.mDBManager.addEvent(eventInfo2DBData);
                MyLog.save("", "event = " + eventInfo2DBData.getEventId() + ", saveResult = " + jAddEvent);
                if (SaveHandler.this.mListener != null) {
                    if (jAddEvent >= 0) {
                        SaveHandler.this.mListener.saveSuccess(eventInfo2DBData);
                    } else if (eventInfo2DBData.getLevel() == 1) {
                        SaveHandler.this.mListener.sendOnce(eventInfo2DBData);
                    } else {
                        SaveHandler.this.mListener.saveFail(eventInfo2DBData);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SaveListener {
        void saveFail(Event event);

        void saveSuccess(Event event);

        void sendOnce(Event event);
    }

    public SaveHandler(Context context, DataStoreManager dataStoreManager, IPubParams iPubParams) {
        if (context == null || iPubParams == null) {
            throw new IllegalStateException("Save handler constract error, configManager or pubParams is null");
        }
        this.mContext = context;
        this.mDBManager = dataStoreManager;
        this.mPubParams = iPubParams;
        this.mEventLimitSp = new EventLimitSp(context, EventLimitSp.getCurSpName(context), 0);
        HandlerThread handlerThread = new HandlerThread(SaveHandler.class.getName(), 10);
        handlerThread.start();
        this.myHandler = new MyHandler(handlerThread.getLooper());
    }

    private byte[] getPubParams() {
        if (this.mPubParams == null) {
            return ProtobufRequestBeanOuterClass.ProtobufRequestBean.newBuilder().build().toByteArray();
        }
        try {
            return ProtobufRequestBeanOuterClass.ProtobufRequestBean.newBuilder().setDhid(wn1.a(this.mPubParams.getDHID())).setUhid(wn1.a(this.mPubParams.getUHID())).setPid(wn1.a(this.mPubParams.getPid())).setAppId(wn1.a(this.mPubParams.getAppId())).setChanId(wn1.a(this.mPubParams.getChanId())).setOrigChanId(wn1.a(this.mPubParams.getOrigChanId())).setLongi(wn1.a(this.mPubParams.getLongi())).setLati(wn1.a(this.mPubParams.getLati())).setMapSP(wn1.a(this.mPubParams.getMapSp())).setUserToken(wn1.a(this.mPubParams.getUserToken())).setOid(wn1.a(this.mPubParams.getOid())).setSn(wn1.a(this.mPubParams.getSN())).setSr(wn1.a(this.mPubParams.getSR())).setVerCode(String.valueOf(this.mPubParams.getVerCode())).setVerName(wn1.a(this.mPubParams.getVerName())).setLang(wn1.a(this.mPubParams.getLanguage())).setNetModel(wn1.a(this.mPubParams.getNetModel())).setCapSsid(wn1.a(this.mPubParams.getSsid())).setCapBssid(wn1.a(this.mPubParams.getBssid())).setMac(wn1.a(this.mPubParams.getMac())).setImei(wn1.a(this.mPubParams.getIMEI())).setTs(String.valueOf(this.mPubParams.getTs())).build().toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return ProtobufRequestBeanOuterClass.ProtobufRequestBean.newBuilder().build().toByteArray();
        }
    }

    private byte[] getTaiChiParams() {
        long buketId;
        String processId;
        String sessionId;
        long expId;
        long groupId;
        long versionNun;
        IPubParams iPubParams = this.mPubParams;
        if (iPubParams != null) {
            buketId = iPubParams.getBuketId();
            expId = this.mPubParams.getExpId();
            groupId = this.mPubParams.getGroupId();
            versionNun = this.mPubParams.getVersionNun();
            processId = this.mPubParams.getProcessId();
            sessionId = this.mPubParams.getSessionId();
        } else {
            buketId = 0;
            processId = "";
            sessionId = processId;
            expId = 0;
            groupId = 0;
            versionNun = 0;
        }
        EventOuterClass.Event.Taichi.Builder versionNum = EventOuterClass.Event.Taichi.newBuilder().setBucketId(buketId).setExpId(expId).setGroupId(groupId).setVersionNum(versionNun);
        if (processId == null) {
            processId = "";
        }
        return versionNum.setProcessId(processId).setSessionId(sessionId != null ? sessionId : "").build().toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event info2DBData(EventInfo eventInfo, cm0 cm0Var, int i) {
        Event event = new Event();
        event.setEventId(eventInfo.getEventId());
        if (cm0Var != null) {
            event.setLevel(cm0Var.c());
        } else {
            event.setLevel(1);
        }
        Log.i("CX_EVENT", "SaveHandler info2DBData use Preset List!");
        if (ParamHelper.getPresetEventList().contains(eventInfo.getEventId())) {
            event.setLevel(1);
        }
        event.setSaveDateTime(eventInfo.getCreateDateTime());
        MyLog.save("", "event = " + event.getEventId() + " start get pubParams");
        byte[] pubParams = getPubParams();
        MyLog.save("", "event = " + event.getEventId() + " end get pubParams");
        event.setPubParams(pubParams);
        event.setSource(eventInfo.getSource());
        IPubParams iPubParams = this.mPubParams;
        if (iPubParams != null) {
            if (!iPubParams.isForceground()) {
                i = 0;
            }
            event.setState(i);
        } else {
            event.setState(-1);
        }
        event.setExtra(eventInfo.getExtra());
        event.setTaiChi(getTaiChiParams());
        return event;
    }

    public void addDbError(EventInfo eventInfo) {
        Message messageObtainMessage = this.myHandler.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = eventInfo;
        this.myHandler.sendMessage(messageObtainMessage);
    }

    public void addEvent(EventInfo eventInfo) {
        Message messageObtainMessage = this.myHandler.obtainMessage();
        messageObtainMessage.what = 0;
        messageObtainMessage.obj = eventInfo;
        this.myHandler.sendMessage(messageObtainMessage);
    }

    public void setSaveListener(SaveListener saveListener) {
        this.mListener = saveListener;
    }

    public void addEvent(EventInfo eventInfo, int i) {
        Message messageObtainMessage = this.myHandler.obtainMessage();
        messageObtainMessage.what = 0;
        messageObtainMessage.obj = eventInfo;
        messageObtainMessage.arg1 = i;
        this.myHandler.sendMessage(messageObtainMessage);
    }
}
