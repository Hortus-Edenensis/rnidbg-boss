package com.baidu.mapapi.http.wrapper;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.http.wrapper.annotation.DELETE;
import com.baidu.mapapi.http.wrapper.annotation.FileParam;
import com.baidu.mapapi.http.wrapper.annotation.GET;
import com.baidu.mapapi.http.wrapper.annotation.HttpHeader;
import com.baidu.mapapi.http.wrapper.annotation.POST;
import com.baidu.mapapi.http.wrapper.annotation.PUT;
import com.baidu.mapapi.http.wrapper.annotation.QueryString;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class HttpManager {
    public static final String HTTP_DELETE = "DELETE";
    public static final String HTTP_GET = "GET";
    public static final String HTTP_POST = "POST";
    public static final String HTTP_PUT = "PUT";
    private static final String UN_SUPPORT_REQUEST_METHOD = "UN_SUPPORT_REQUEST_METHOD";
    private String host;
    private String prefix;
    private final ExecutorService threadPool;

    public HttpManager(String str) {
        this(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Class<?> getGenericReturnType(Method method) {
        return (Class) ((ParameterizedType) method.getGenericReturnType()).getActualTypeArguments()[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeCommonHeader(HttpClient.HttpHeader httpHeader, Class<?> cls, String str) {
        if (httpHeader != null) {
            if (cls == POST.class || cls == PUT.class) {
                httpHeader.setAccept("application/body").setCharset("UTF-8").setConnection(HTTP.CONN_KEEP_ALIVE);
                if (BodyData.TYPE_URL_ENCODED.equals(str)) {
                    httpHeader.setContentType("application/x-www-form-urlencoded");
                }
                if (BodyData.TYPE_FORM_DATA.equals(str)) {
                    httpHeader.setContentType("multipart/form-data;boundary=bd_map_sdk_cc");
                }
                if (BodyData.TYPE_JSON.equals(str)) {
                    httpHeader.setContentType("application/json");
                }
            }
        }
    }

    public <T> T getApiInstance(Class<T> cls) {
        return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.baidu.mapapi.http.wrapper.HttpManager.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                Class cls2;
                HttpClient httpClient;
                String strValue;
                String str;
                String str2;
                Annotation[] annotationArr;
                int i;
                Iterator it;
                String str3;
                Class<?> returnType = method.getReturnType();
                if (returnType != AsyncResponse.class && returnType != Response.class) {
                    return returnType.newInstance();
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                final HashMap map = new HashMap();
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                String str4 = "";
                String str5 = "";
                for (int i2 = 0; i2 < objArr.length && i2 < parameterAnnotations.length; i2++) {
                    Annotation[] annotationArr2 = parameterAnnotations[i2];
                    int length = annotationArr2.length;
                    int i3 = 0;
                    while (i3 < length) {
                        Annotation annotation = annotationArr2[i3];
                        Annotation[][] annotationArr3 = parameterAnnotations;
                        if (annotation instanceof QueryString) {
                            arrayList.add(objArr[i2]);
                        }
                        if (annotation instanceof BodyData) {
                            String strValue2 = ((BodyData) annotation).value();
                            arrayList2.add(objArr[i2]);
                            str5 = strValue2;
                        }
                        if (annotation instanceof HttpHeader) {
                            arrayList3.add(objArr[i2]);
                        }
                        if (annotation instanceof FileParam) {
                            FileParam fileParam = (FileParam) annotation;
                            str = str4;
                            if (fileParam.type() == 2) {
                                Iterator it2 = ((Map) objArr[i2]).entrySet().iterator();
                                while (it2.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it2.next();
                                    Iterator it3 = it2;
                                    if (map.containsKey(entry.getKey())) {
                                        str3 = str5;
                                    } else {
                                        str3 = str5;
                                        map.put(entry.getKey(), new ArrayList());
                                    }
                                    ((List) map.get(entry.getKey())).add(new FileWrapper((File) entry.getValue()));
                                    it2 = it3;
                                    str5 = str3;
                                }
                            }
                            str2 = str5;
                            if (fileParam.type() == 3) {
                                Iterator it4 = ((Map) objArr[i2]).entrySet().iterator();
                                while (it4.hasNext()) {
                                    Map.Entry entry2 = (Map.Entry) it4.next();
                                    if (map.containsKey(entry2.getKey())) {
                                        it = it4;
                                    } else {
                                        it = it4;
                                        map.put(entry2.getKey(), new ArrayList());
                                    }
                                    if (entry2.getValue() != null) {
                                        File[] fileArr = (File[]) entry2.getValue();
                                        int length2 = fileArr.length;
                                        Annotation[] annotationArr4 = annotationArr2;
                                        int i4 = 0;
                                        while (i4 < length2) {
                                            ((List) map.get(entry2.getKey())).add(new FileWrapper(fileArr[i4]));
                                            i4++;
                                            length2 = length2;
                                            fileArr = fileArr;
                                            entry2 = entry2;
                                        }
                                        it4 = it;
                                        annotationArr2 = annotationArr4;
                                    } else {
                                        it4 = it;
                                    }
                                }
                            }
                            annotationArr = annotationArr2;
                            if (fileParam.type() == 6) {
                                for (Map.Entry entry3 : ((Map) objArr[i2]).entrySet()) {
                                    if (!map.containsKey(entry3.getKey())) {
                                        map.put(entry3.getKey(), new ArrayList());
                                    }
                                    ((List) map.get(entry3.getKey())).add(entry3.getValue());
                                }
                            }
                            if (fileParam.type() == 7) {
                                Iterator it5 = ((Map) objArr[i2]).entrySet().iterator();
                                while (it5.hasNext()) {
                                    Map.Entry entry4 = (Map.Entry) it5.next();
                                    if (!map.containsKey(entry4.getKey())) {
                                        map.put(entry4.getKey(), new ArrayList());
                                    }
                                    if (entry4.getValue() != null) {
                                        FileWrapper[] fileWrapperArr = (FileWrapper[]) entry4.getValue();
                                        int length3 = fileWrapperArr.length;
                                        Iterator it6 = it5;
                                        int i5 = 0;
                                        while (i5 < length3) {
                                            ((List) map.get(entry4.getKey())).add(fileWrapperArr[i5]);
                                            i5++;
                                            length3 = length3;
                                            fileWrapperArr = fileWrapperArr;
                                        }
                                        it5 = it6;
                                    }
                                }
                            }
                            String strValue3 = fileParam.value();
                            if (!TextUtils.isEmpty(strValue3)) {
                                if (!map.containsKey(strValue3)) {
                                    map.put(strValue3, new ArrayList());
                                }
                                if (fileParam.type() == 0) {
                                    ((List) map.get(strValue3)).add(new FileWrapper((File) objArr[i2]));
                                }
                                if (fileParam.type() == 1) {
                                    File[] fileArr2 = (File[]) objArr[i2];
                                    int length4 = fileArr2.length;
                                    int i6 = 0;
                                    while (i6 < length4) {
                                        ((List) map.get(strValue3)).add(new FileWrapper(fileArr2[i6]));
                                        i6++;
                                        length4 = length4;
                                        length = length;
                                        fileArr2 = fileArr2;
                                    }
                                }
                                i = length;
                                if (fileParam.type() == 4) {
                                    ((List) map.get(strValue3)).add((FileWrapper) objArr[i2]);
                                }
                                if (fileParam.type() == 5) {
                                    ((List) map.get(strValue3)).addAll(Arrays.asList((FileWrapper[]) objArr[i2]));
                                }
                            }
                            i3++;
                            parameterAnnotations = annotationArr3;
                            str4 = str;
                            str5 = str2;
                            annotationArr2 = annotationArr;
                            length = i;
                        } else {
                            str = str4;
                            str2 = str5;
                            annotationArr = annotationArr2;
                        }
                        i = length;
                        i3++;
                        parameterAnnotations = annotationArr3;
                        str4 = str;
                        str5 = str2;
                        annotationArr2 = annotationArr;
                        length = i;
                    }
                }
                String str6 = str4;
                Annotation[] annotations = method.getAnnotations();
                int length5 = annotations.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length5) {
                        cls2 = null;
                        httpClient = null;
                        strValue = str6;
                        break;
                    }
                    Annotation annotation2 = annotations[i7];
                    if (annotation2 instanceof GET) {
                        httpClient = new HttpClient("GET");
                        strValue = ((GET) annotation2).value();
                        cls2 = GET.class;
                        break;
                    }
                    if (annotation2 instanceof POST) {
                        httpClient = new HttpClient("POST");
                        strValue = ((POST) annotation2).value();
                        cls2 = POST.class;
                        break;
                    }
                    if (annotation2 instanceof PUT) {
                        httpClient = new HttpClient("PUT");
                        strValue = ((PUT) annotation2).value();
                        cls2 = PUT.class;
                        break;
                    }
                    if (annotation2 instanceof DELETE) {
                        httpClient = new HttpClient(HttpManager.HTTP_DELETE);
                        strValue = ((DELETE) annotation2).value();
                        cls2 = DELETE.class;
                        break;
                    }
                    i7++;
                }
                if (cls2 == null) {
                    if (returnType == AsyncResponse.class) {
                        AsyncResponse asyncResponse = new AsyncResponse();
                        asyncResponse.onFailed(new Throwable(HttpManager.UN_SUPPORT_REQUEST_METHOD));
                        return asyncResponse;
                    }
                    Response response = new Response();
                    response.setE(new Throwable(HttpManager.UN_SUPPORT_REQUEST_METHOD));
                    return response;
                }
                try {
                    final String strMakeQueryString = ParamsUtils.makeQueryString(arrayList.toArray());
                    final String strMakeQueryString2 = BodyData.TYPE_URL_ENCODED.equals(str5) ? ParamsUtils.makeQueryString(arrayList2.toArray()) : BodyData.TYPE_FORM_DATA.equals(str5) ? ParamsUtils.makeFormString(arrayList2.toArray()) : ParamsUtils.makeJsonString(arrayList2.toArray());
                    final String str7 = HttpManager.this.host + HttpManager.this.prefix + strValue;
                    final Class genericReturnType = HttpManager.this.getGenericReturnType(method);
                    HttpClient.HttpHeader httpHeader = new HttpClient.HttpHeader();
                    HttpManager.this.makeCommonHeader(httpHeader, cls2, str5);
                    httpClient.setHeader(httpHeader.setCustom(ParamsUtils.getParamsMap(arrayList3.toArray())));
                    if (returnType == AsyncResponse.class) {
                        final AsyncResponse asyncResponse2 = new AsyncResponse();
                        final HttpClient httpClient2 = httpClient;
                        HttpManager.this.threadPool.submit(new Runnable() { // from class: com.baidu.mapapi.http.wrapper.HttpManager.1.1
                            @Override // java.lang.Runnable
                            public void run() throws Throwable {
                                HttpClient.HttpResponse httpResponseRequest = httpClient2.request(str7, strMakeQueryString, strMakeQueryString2, map);
                                if (httpResponseRequest.getError() != HttpClient.HttpStateError.NO_ERROR) {
                                    asyncResponse2.onFailed(new Throwable(httpResponseRequest.getError().toString()));
                                    return;
                                }
                                try {
                                    asyncResponse2.onSuccess(ParamsUtils.toObject(httpResponseRequest.getData(), genericReturnType));
                                } catch (Exception e) {
                                    asyncResponse2.onFailed(e);
                                }
                            }
                        });
                        return asyncResponse2;
                    }
                    Response response2 = new Response();
                    HttpClient.HttpResponse httpResponseRequest = httpClient.request(str7, strMakeQueryString, strMakeQueryString2, map);
                    if (httpResponseRequest.getError() == HttpClient.HttpStateError.NO_ERROR) {
                        try {
                            response2.setData(ParamsUtils.toObject(httpResponseRequest.getData(), genericReturnType));
                        } catch (Exception e) {
                            response2.setE(e);
                        }
                    } else {
                        response2.setE(new Throwable(httpResponseRequest.getError().toString()));
                    }
                    return response2;
                } catch (Exception e2) {
                    if (returnType == AsyncResponse.class) {
                        AsyncResponse asyncResponse3 = new AsyncResponse();
                        asyncResponse3.onFailed(e2);
                        return asyncResponse3;
                    }
                    Response response3 = new Response();
                    response3.setE(e2);
                    return response3;
                }
            }
        });
    }

    public HttpManager(String str, String str2) {
        this.host = "";
        this.prefix = "";
        this.threadPool = ThreadPoolUtils.getThreadPool();
        if (!TextUtils.isEmpty(str)) {
            this.host = str;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.prefix = str2;
    }
}
