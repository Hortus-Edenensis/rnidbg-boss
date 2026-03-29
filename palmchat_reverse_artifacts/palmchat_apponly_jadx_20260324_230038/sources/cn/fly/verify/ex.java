package cn.fly.verify;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import cn.fly.verify.fq;
import cn.fly.verify.fy;
import j$.util.function.Consumer$CC;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ex {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f2268a;

        public a(Object obj) {
            this.f2268a = obj;
        }

        public float a() {
            return ((Float) fy.a(this.f2268a, dx.a("0116cc]dg_cjPaa,bebh>ba(bi"), Float.valueOf(0.0f), new Object[0])).floatValue();
        }

        public double b() {
            return ((Double) fy.a(this.f2268a, dx.a("011>ccNdg'daUbg_bgMgQbebaSd"), Double.valueOf(0.0d), new Object[0])).doubleValue();
        }

        public double c() {
            return ((Double) fy.a(this.f2268a, dx.a("012Xcc8dg^dacb,c!ccbgGg:beba;d"), Double.valueOf(0.0d), new Object[0])).doubleValue();
        }

        public long d() {
            return ((Long) fy.a(this.f2268a, dx.a("007Qcc$dg.cibgbd.d"), 0L, new Object[0])).longValue();
        }

        public String e() {
            return (String) fy.a(this.f2268a, dx.a("011[cc:dg<ejbhcbbbbgbaWd5bh"), (Object) null, new Object[0]);
        }

        public double f() {
            return ((Double) fy.a(this.f2268a, dx.a("011]ccTdgBcj^eg;bg gGbeba+d"), Double.valueOf(0.0d), new Object[0])).doubleValue();
        }

        public float g() {
            return ((Float) fy.a(this.f2268a, dx.a("0100cc*dg;dg>db_bhbgSc7cc"), Float.valueOf(0.0f), new Object[0])).floatValue();
        }

        public float h() {
            return ((Float) fy.a(this.f2268a, dx.a("008-cc2dg$ch5hdd(ba"), Float.valueOf(0.0f), new Object[0])).floatValue();
        }

        public boolean i() {
            if (Build.VERSION.SDK_INT >= 26) {
                return ((Boolean) fy.a(this.f2268a, dx.a("019fb>dfeh;d*bhLg*bgFabe'cjKaaObebhQbaAbi"), Boolean.FALSE, new Object[0])).booleanValue();
            }
            return false;
        }

        public float j() {
            if (Build.VERSION.SDK_INT >= 26) {
                return ((Float) fy.a(this.f2268a, dx.a("025^ccKdg*ehQd+bhLg%bgUabe]cj!aaEbebh?ba3bifa>dgdQbhdf"), Float.valueOf(0.0f), new Object[0])).floatValue();
            }
            return 0.0f;
        }
    }

    private static Parcelable.Creator<?> a() throws Throwable {
        return (Parcelable.Creator) fy.c(fy.a(dx.a("025bc3babhcbbgbadbAe1cb1abgZbgcbLc_dbdacb9abg@bgcbFc")), dx.a("007Aeiegefcjcieeeg"));
    }

    public static Object a(Context context, String str) throws Throwable {
        int i;
        int i2;
        Object objA;
        Parcel parcel;
        if (!Cdo.f() || !gf.a().a(str) || (i = Build.VERSION.SDK_INT) < 23) {
            return null;
        }
        ew ewVarA = ew.a(context);
        if (i >= 31) {
            i2 = 0;
            objA = ewVarA.a(dx.a("036bcQbabhcbbgbadbQe;cbQabg[bgcbNc?dbda,b[df4g:dacbJabg)bgcbAc0egPd!bcbe3dVdf8g") + "$" + dx.a("007,dgbebg8eNba^dUbh"), ewVarA.a(dx.a("036bc%babhcbbgbadbQe cbQabgSbgcb<cIdbda_bQdf+g^dacb5abg;bgcbEcVeg!d4bcbeCd-df[g") + "$" + dx.a("007VdgbebgHeYbaSd1bh")), dx.a("005.dcbebg:eDba"), (Class[]) null, (Object[]) null);
        } else {
            i2 = 0;
            objA = ewVarA.a(dx.a("032bc?babhcbbgbadbPe0cb4abg$bgcb[cAdbdacb4abg-bgcb$c@egRdXbcbe)d@df9g"), (Object) null, dx.a("028aUbhKdbgd:djbhcbbddiMdh7bh1dabgdEbaejbhcbbbbgba=dCbh"), new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE}, new Object[]{str, 0, 0, Boolean.TRUE});
        }
        Object obj = objA;
        int iIntValue = ((Integer) ewVarA.a(dx.a("033bc4babhcbbgbadb]e?cb.abg(bgcb2cQdbcgdacb,abg)bgcb=cWfaObcbQccLdIbh") + "$" + dx.a("004[ch9gObedc"), dx.a("0278ciegcjcfchcjeicicgeecfbfcc@dg3daYb7dfKgHdacbFabgBbgcb)c"), (Object) null)).intValue();
        String strA = dx.a("025bc1babhcbbgbadbcbdfdbchMd$bhbbbgFadVfa*bcbLccPd2bh");
        String strA2 = dx.a("010Scc1dg8ch4d7bhbbbg%ad");
        Class[] clsArr = new Class[1];
        clsArr[i2] = String.class;
        Object[] objArr = new Object[1];
        objArr[i2] = dx.a("008e0cb>abg,bgcbAc");
        IBinder iBinder = (IBinder) ewVarA.a(strA, (Object) null, strA2, clsArr, objArr);
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(dx.a("033bc;babhcbbgbadbFe<cbGabg[bgcb@cUdbcgdacb+abg8bgcb_cCfaEbcb2ccZd5bh"));
            if (i >= 31) {
                parcelObtain.writeString(str);
                parcelObtain.writeTypedObject((Parcelable) obj, i2);
                parcel = parcelObtain2;
            } else {
                parcelObtain.writeInt(1);
                Class<?> cls = obj.getClass();
                String strA3 = dx.a("013 ddbhbg9gd=cicbejPb.bhJade");
                Class[] clsArr2 = new Class[2];
                clsArr2[i2] = Parcel.class;
                clsArr2[1] = Integer.TYPE;
                Object[] objArr2 = new Object[2];
                objArr2[i2] = parcelObtain;
                objArr2[1] = Integer.valueOf(i2);
                parcel = parcelObtain2;
                try {
                    ewVarA.a(cls, obj, strA3, clsArr2, objArr2);
                } catch (Throwable th) {
                    th = th;
                    ew.a(context).b(context);
                    parcel.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
            parcelObtain.writeString(context.getPackageName());
            if (i >= 30) {
                parcelObtain.writeString(context.getAttributionTag());
            }
            iBinder.transact(iIntValue, parcelObtain, parcel, i2);
            parcel.readException();
            Object typedObject = parcel.readTypedObject(a());
            ew.a(context).b(context);
            parcel.recycle();
            parcelObtain.recycle();
            return typedObject;
        } catch (Throwable th2) {
            th = th2;
            parcel = parcelObtain2;
        }
    }

    public static Object a(Context context, String str, long j) throws Throwable {
        int i;
        String str2;
        int i2;
        int i3;
        Object objA;
        Context context2;
        Parcel parcel;
        Parcel parcel2;
        Parcel parcel3;
        char c;
        Object objA2;
        Object objA3;
        if (!Cdo.e() || !gf.a().a(str) || (i = Build.VERSION.SDK_INT) < 23) {
            return null;
        }
        ew ewVarA = ew.a(context);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Object[] objArr = new Object[1];
        if (i >= 31) {
            i2 = 0;
            str2 = "$";
            objA = ewVarA.a(dx.a("032bcMbabhcbbgbadb0eYcbKabgYbgcb6cNdbdacbGabgFbgcbXc7eg2dNbcbeCd'df^g") + "$" + dx.a("007(dgbebg6eJbaWdLbh"), ewVarA.a(dx.a("032bcFbabhcbbgbadb-e4cb[abgYbgcb+c1dbdacb_abgHbgcbQc0eg]dCbcbeHd!dfMg") + "$" + dx.a("0070dgbebgPeQbaIdCbh"), new Class[]{Long.TYPE}, new Object[]{0L}), dx.a("005_dcbebg:eSba"), (Class[]) null, (Object[]) null);
            i3 = 3;
        } else {
            str2 = "$";
            i2 = 0;
            i3 = 3;
            objA = ewVarA.a(dx.a("032bc'babhcbbgbadb$e cb8abg%bgcbJcAdbdacbCabg@bgcbIcOeg+d[bcbe!dJdfMg"), (Object) null, dx.a("028a5bhQdbgd4djbhcbbddiPdh bhCdabgd;baejbhcbbbbgbaKd4bh"), new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE}, new Object[]{str, 0, 0, Boolean.TRUE});
        }
        String strA = dx.a("025bc8babhcbbgbadbcbdfdbchOd^bhbbbgXad(faSbcb+ccWdHbh");
        String strA2 = dx.a("010+cc6dg@ch0dEbhbbbgLad");
        Class[] clsArr = new Class[1];
        clsArr[i2] = String.class;
        Object[] objArr2 = new Object[1];
        objArr2[i2] = dx.a("008eJcb_abgHbgcb<c");
        IBinder iBinder = (IBinder) ewVarA.a(strA, (Object) null, strA2, clsArr, objArr2);
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(dx.a("033bcVbabhcbbgbadb-e?cb!abg0bgcbTcPdbcgdacbIabg=bgcb)cKfa(bcbKcc*d^bh"));
            if (i >= 31) {
                try {
                    parcelObtain.writeString(str);
                    parcelObtain.writeTypedObject((Parcelable) objA, i2);
                    Consumer consumer = new Consumer() { // from class: cn.fly.verify.ex.1
                        @Override // java.util.function.Consumer
                        public void accept(Object obj) {
                            try {
                                objArr[0] = obj;
                            } finally {
                                try {
                                } finally {
                                }
                            }
                        }

                        public /* synthetic */ Consumer andThen(Consumer consumer2) {
                            return Consumer$CC.$default$andThen(this, consumer2);
                        }
                    };
                    StringBuilder sb = new StringBuilder(dx.a("032bc,babhcbbgbadb-eYcb1abgTbgcb2cKdbdacb)abgCbgcbCc!faGbcb!cc*d.bh"));
                    String str3 = str2;
                    sb.append(str3);
                    sb.append(dx.a("027Hgb^dgKeibebhbh8dcgFdacb=abg;bgcb]cWcibhZbc^dfEhNcbbh8g"));
                    String string = sb.toString();
                    Class[] clsArr2 = new Class[i3];
                    clsArr2[i2] = Executor.class;
                    clsArr2[1] = Consumer.class;
                    clsArr2[2] = CancellationSignal.class;
                    Object[] objArr3 = new Object[i3];
                    objArr3[i2] = Executors.newSingleThreadExecutor();
                    objArr3[1] = consumer;
                    objArr3[2] = null;
                    Object objA4 = ewVarA.a(string, clsArr2, objArr3);
                    String strA3 = dx.a("012gGcbegSdadNbgbb*dUbhcgba");
                    Class[] clsArr3 = new Class[1];
                    clsArr3[i2] = Object.class;
                    Object[] objArr4 = new Object[1];
                    objArr4[i2] = consumer;
                    parcel3 = parcelObtain2;
                    parcel2 = parcelObtain;
                    try {
                        String str4 = (String) ewVarA.a(AppOpsManager.class, (Object) null, strA3, clsArr3, objArr4);
                        parcel2.writeStrongInterface((IInterface) objA4);
                        parcel2.writeString(context.getPackageName());
                        parcel2.writeString(context.getAttributionTag());
                        parcel2.writeString(str4);
                        iBinder.transact(((Integer) ewVarA.a(dx.a("033bc[babhcbbgbadb%e6cb8abg bgcb:cKdbcgdacb%abg_bgcb2cOfaDbcb0cc!d>bh") + str3 + dx.a("004<chCg bedc"), dx.a("030NciegcjcfchcjeicicgeecfbfccFdg,eibebhbh<dcg0dacbQabg=bgcbIc"), (Object) null)).intValue(), parcel2, parcel3, 0);
                        parcel = parcel3;
                        c = 0;
                    } catch (Throwable th) {
                        th = th;
                        context2 = context;
                        parcel = parcel3;
                        parcel.recycle();
                        parcel2.recycle();
                        ew.a(context).b(context2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcel3 = parcelObtain2;
                    parcel2 = parcelObtain;
                }
            } else {
                parcel = parcelObtain2;
                parcel2 = parcelObtain;
                String str5 = str2;
                try {
                    parcel2.writeInt(1);
                    ewVarA.a(objA.getClass(), objA, dx.a("013WddbhbgLgdRcicbejPb5bhYade"), new Class[]{Parcel.class, Integer.TYPE}, new Object[]{parcel2, 0});
                    HashMap map = new HashMap();
                    final int iIdentityHashCode = System.identityHashCode(map);
                    try {
                        map.put(dx.a("017Bcb6c3dacbXabg%bgcbVc eiNfbc cc*d=ba"), new fy.a<Object[], Object>() { // from class: cn.fly.verify.ex.2
                            @Override // cn.fly.verify.fy.a
                            public Object a(Object[] objArr5) {
                                if (objArr5 != null) {
                                    try {
                                        if (objArr5.length > 0) {
                                            en.a().a("[212] oncge" + objArr5[0], new Object[0]);
                                            Object obj = objArr5[0];
                                            if (!(obj instanceof List) || ((List) obj).size() <= 0) {
                                                objArr[0] = objArr5[0];
                                            } else {
                                                objArr[0] = ((List) objArr5[0]).get(r5.size() - 1);
                                            }
                                        }
                                    } finally {
                                        try {
                                        } catch (Throwable th3) {
                                        }
                                    }
                                }
                                countDownLatch.countDown();
                                return null;
                            }
                        });
                        map.put("equals", new fy.a<Object[], Object>() { // from class: cn.fly.verify.ex.3
                            @Override // cn.fly.verify.fy.a
                            public Object a(Object[] objArr5) {
                                if (objArr5 != null) {
                                    Object obj = objArr5[0];
                                    if (obj != null) {
                                        return Boolean.valueOf(obj.hashCode() == iIdentityHashCode);
                                    }
                                }
                                return Boolean.FALSE;
                            }
                        });
                        map.put(dx.a("008fb'dfPf3eicbba+d"), new fy.a<Object[], Object>() { // from class: cn.fly.verify.ex.4
                            @Override // cn.fly.verify.fy.a
                            public Object a(Object[] objArr5) {
                                return Integer.valueOf(iIdentityHashCode);
                            }
                        });
                        objA2 = fy.a(map, (Class<?>[]) new Class[]{Class.forName(dx.a("033bcIbabhcbbgbadb;eWcbYabg0bgcb;cPdbdacbMabg%bgcb]cYdabgdf(gdcd bh"))});
                    } catch (Throwable th3) {
                        en.a().a(th3);
                        objA2 = null;
                    }
                    if (Build.VERSION.SDK_INT >= 30) {
                        objA3 = ewVarA.a(dx.a("032bcNbabhcbbgbadbNe(cbMabgMbgcb@c+dbdacb.abg?bgcb3cVfa0bcbNcc(dYbh") + str5 + dx.a("025LdacbVabg[bgcb:c6dabgdfEgdcdAbhcibh4bc4dfZh6cbbhHg"), new Class[]{Class.forName(dx.a("032bcIbabhcbbgbadbCe%cb7abgUbgcbOc6dbdacbQabg[bgcbIc$fa.bcb=cc!d.bh")), Class.forName(dx.a("033bc7babhcbbgbadbRe+cbPabgAbgcb9cMdbdacb abgGbgcb5c,dabgdfSgdcd)bh"))}, new Object[]{fq.d.a(dx.a("008e4cb=abgCbgcbVc")), objA2});
                        ewVarA.a(objA3.getClass(), objA3, dx.a("008PbhDdPccbgdfXgd3bh"), new Class[]{Executor.class}, new Object[]{Executors.newSingleThreadExecutor()});
                    } else {
                        String str6 = dx.a("032bcGbabhcbbgbadbEe!cbIabgHbgcbLc^dbdacbMabg=bgcb9cPfa^bcbFccYdUbh") + str5 + dx.a("017ZdabgdfEgdcd(bhcibhZbc:dfFh;cbbhUg");
                        Class[] clsArr4 = new Class[i3];
                        clsArr4[0] = Class.forName(dx.a("032bc?babhcbbgbadbIe]cb*abgDbgcbBcKdbdacb'abg,bgcb>c!faQbcb_ccTd+bh"));
                        clsArr4[1] = Class.forName(dx.a("033bc[babhcbbgbadbUeQcbRabg0bgcbCcUdbdacbMabg*bgcbKcAdabgdf$gdcdLbh"));
                        clsArr4[2] = Looper.class;
                        Object[] objArr5 = new Object[i3];
                        objArr5[0] = fq.d.a(dx.a("008eIcb abgAbgcbXc"));
                        objArr5[1] = objA2;
                        objArr5[2] = bq.a().b();
                        objA3 = ewVarA.a(str6, clsArr4, objArr5);
                    }
                    parcel2.writeStrongBinder((IBinder) objA3);
                    parcel2.writeInt(0);
                    parcel2.writeString(context.getPackageName());
                    c = 0;
                    iBinder.transact(((Integer) ewVarA.a(dx.a("033bcYbabhcbbgbadb)e)cb<abgNbgcb8c<dbcgdacbDabgIbgcbVc+fa(bcb;cc1d9bh") + str5 + dx.a("004CchSgHbedc"), dx.a("034WciegcjcfchcjeicicgeecfbfbhBd$bcbe^dYdfMgIdacb7abg bgcbCc+ce'hQba'bgdPdf"), (Object) null)).intValue(), parcel2, parcel, 0);
                } catch (Throwable th4) {
                    th = th4;
                    context2 = context;
                    parcel.recycle();
                    parcel2.recycle();
                    ew.a(context).b(context2);
                    throw th;
                }
            }
            parcel.readException();
            countDownLatch.await(j, TimeUnit.MILLISECONDS);
            Object obj = objArr[c];
            parcel.recycle();
            parcel2.recycle();
            ew.a(context).b(context);
            return obj;
        } catch (Throwable th5) {
            th = th5;
            context2 = context;
            parcel = parcelObtain2;
            parcel2 = parcelObtain;
        }
    }
}
