package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
class MetadataManager {
    private static final String ALTERNATE_FORMATS_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/PhoneNumberAlternateFormatsProto";
    private static final String SHORT_NUMBER_METADATA_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/ShortNumberMetadataProto";
    private static final Logger LOGGER = Logger.getLogger(MetadataManager.class.getName());
    private static final Map<Integer, Phonemetadata.PhoneMetadata> callingCodeToAlternateFormatsMap = DesugarCollections.synchronizedMap(new HashMap());
    private static final Map<String, Phonemetadata.PhoneMetadata> regionCodeToShortNumberMetadataMap = DesugarCollections.synchronizedMap(new HashMap());
    private static final Set<Integer> countryCodeSet = AlternateFormatsCountryCodeSet.getCountryCodeSet();
    private static final Set<String> regionCodeSet = ShortNumbersRegionCodeSet.getRegionCodeSet();

    private MetadataManager() {
    }

    private static void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, e.toString());
            }
        }
    }

    public static Phonemetadata.PhoneMetadata getAlternateFormatsForCountry(int i) {
        if (!countryCodeSet.contains(Integer.valueOf(i))) {
            return null;
        }
        Map<Integer, Phonemetadata.PhoneMetadata> map = callingCodeToAlternateFormatsMap;
        synchronized (map) {
            if (!map.containsKey(Integer.valueOf(i))) {
                loadAlternateFormatsMetadataFromFile(i);
            }
        }
        return map.get(Integer.valueOf(i));
    }

    public static Phonemetadata.PhoneMetadata getShortNumberMetadataForRegion(String str) {
        if (!regionCodeSet.contains(str)) {
            return null;
        }
        Map<String, Phonemetadata.PhoneMetadata> map = regionCodeToShortNumberMetadataMap;
        synchronized (map) {
            if (!map.containsKey(str)) {
                loadShortNumberMetadataFromFile(str);
            }
        }
        return map.get(str);
    }

    public static Set<String> getShortNumberMetadataSupportedRegions() {
        return regionCodeSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static void loadAlternateFormatsMetadataFromFile(int i) throws Throwable {
        ObjectInputStream objectInputStream;
        boolean zHasNext;
        ?? r0 = 0;
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(PhoneNumberMatcher.class.getResourceAsStream("/com/google/i18n/phonenumbers/data/PhoneNumberAlternateFormatsProto_" + i));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            Phonemetadata.PhoneMetadataCollection phoneMetadataCollection = new Phonemetadata.PhoneMetadataCollection();
            phoneMetadataCollection.readExternal(objectInputStream);
            Iterator<Phonemetadata.PhoneMetadata> it = phoneMetadataCollection.getMetadataList().iterator();
            while (true) {
                zHasNext = it.hasNext();
                if (!zHasNext) {
                    break;
                }
                Phonemetadata.PhoneMetadata next = it.next();
                callingCodeToAlternateFormatsMap.put(Integer.valueOf(next.getCountryCode()), next);
            }
            close(objectInputStream);
            r0 = zHasNext;
        } catch (IOException e2) {
            e = e2;
            objectInputStream2 = objectInputStream;
            LOGGER.log(Level.WARNING, e.toString());
            close(objectInputStream2);
            r0 = objectInputStream2;
        } catch (Throwable th2) {
            th = th2;
            r0 = objectInputStream;
            close(r0);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    private static void loadShortNumberMetadataFromFile(String str) throws Throwable {
        ObjectInputStream objectInputStream;
        boolean zHasNext;
        ?? r1 = 0;
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(PhoneNumberMatcher.class.getResourceAsStream("/com/google/i18n/phonenumbers/data/ShortNumberMetadataProto_" + str));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            Phonemetadata.PhoneMetadataCollection phoneMetadataCollection = new Phonemetadata.PhoneMetadataCollection();
            phoneMetadataCollection.readExternal(objectInputStream);
            Iterator<Phonemetadata.PhoneMetadata> it = phoneMetadataCollection.getMetadataList().iterator();
            while (true) {
                zHasNext = it.hasNext();
                if (!zHasNext) {
                    break;
                }
                regionCodeToShortNumberMetadataMap.put(str, it.next());
            }
            close(objectInputStream);
            r1 = zHasNext;
        } catch (IOException e2) {
            e = e2;
            objectInputStream2 = objectInputStream;
            LOGGER.log(Level.WARNING, e.toString());
            close(objectInputStream2);
            r1 = objectInputStream2;
        } catch (Throwable th2) {
            th = th2;
            r1 = objectInputStream;
            close(r1);
            throw th;
        }
    }
}
