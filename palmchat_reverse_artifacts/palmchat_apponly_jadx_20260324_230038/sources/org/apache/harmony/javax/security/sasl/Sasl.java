package org.apache.harmony.javax.security.sasl;

import java.security.Provider;
import java.security.Security;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.apache.harmony.javax.security.auth.callback.CallbackHandler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class Sasl {
    private static final String CLIENTFACTORYSRV = "SaslClientFactory";
    public static final String MAX_BUFFER = "javax.security.sasl.maxbuffer";
    public static final String POLICY_FORWARD_SECRECY = "javax.security.sasl.policy.forward";
    public static final String POLICY_NOACTIVE = "javax.security.sasl.policy.noactive";
    public static final String POLICY_NOANONYMOUS = "javax.security.sasl.policy.noanonymous";
    public static final String POLICY_NODICTIONARY = "javax.security.sasl.policy.nodictionary";
    public static final String POLICY_NOPLAINTEXT = "javax.security.sasl.policy.noplaintext";
    public static final String POLICY_PASS_CREDENTIALS = "javax.security.sasl.policy.credentials";
    public static final String QOP = "javax.security.sasl.qop";
    public static final String RAW_SEND_SIZE = "javax.security.sasl.rawsendsize";
    public static final String REUSE = "javax.security.sasl.reuse";
    private static final String SERVERFACTORYSRV = "SaslServerFactory";
    public static final String SERVER_AUTH = "javax.security.sasl.server.authentication";
    public static final String STRENGTH = "javax.security.sasl.strength";

    private Sasl() {
    }

    public static SaslClient createSaslClient(String[] strArr, String str, String str2, String str3, Map<String, ?> map, CallbackHandler callbackHandler) throws SaslException {
        SaslClient saslClientCreateSaslClient;
        if (strArr == null) {
            throw new NullPointerException("auth.33");
        }
        Collection<?> collectionFindFactories = findFactories(CLIENTFACTORYSRV);
        if (collectionFindFactories.isEmpty()) {
            return null;
        }
        Iterator<?> it = collectionFindFactories.iterator();
        while (it.hasNext()) {
            SaslClientFactory saslClientFactory = (SaslClientFactory) it.next();
            String[] mechanismNames = saslClientFactory.getMechanismNames(null);
            boolean z = false;
            if (mechanismNames != null) {
                boolean z2 = false;
                for (String str4 : mechanismNames) {
                    int i = 0;
                    while (true) {
                        if (i >= strArr.length) {
                            break;
                        }
                        if (str4.equals(strArr[i])) {
                            z2 = true;
                            break;
                        }
                        i++;
                    }
                }
                z = z2;
            }
            if (z && (saslClientCreateSaslClient = saslClientFactory.createSaslClient(strArr, str, str2, str3, map, callbackHandler)) != null) {
                return saslClientCreateSaslClient;
            }
        }
        return null;
    }

    public static SaslServer createSaslServer(String str, String str2, String str3, Map<String, ?> map, CallbackHandler callbackHandler) throws SaslException {
        SaslServer saslServerCreateSaslServer;
        if (str == null) {
            throw new NullPointerException("auth.32");
        }
        Collection<?> collectionFindFactories = findFactories(SERVERFACTORYSRV);
        if (collectionFindFactories.isEmpty()) {
            return null;
        }
        Iterator<?> it = collectionFindFactories.iterator();
        while (it.hasNext()) {
            SaslServerFactory saslServerFactory = (SaslServerFactory) it.next();
            String[] mechanismNames = saslServerFactory.getMechanismNames(null);
            boolean z = false;
            if (mechanismNames != null) {
                int i = 0;
                while (true) {
                    if (i >= mechanismNames.length) {
                        break;
                    }
                    if (mechanismNames[i].equals(str)) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
            if (z && (saslServerCreateSaslServer = saslServerFactory.createSaslServer(str, str2, str3, map, callbackHandler)) != null) {
                return saslServerCreateSaslServer;
            }
        }
        return null;
    }

    private static Collection<?> findFactories(String str) {
        HashSet hashSet = new HashSet();
        Provider[] providers = Security.getProviders();
        if (providers != null && providers.length != 0) {
            HashSet hashSet2 = new HashSet();
            for (int i = 0; i < providers.length; i++) {
                String name = providers[i].getName();
                Enumeration<Object> enumerationKeys = providers[i].keys();
                while (enumerationKeys.hasMoreElements()) {
                    String str2 = (String) enumerationKeys.nextElement();
                    if (str2.startsWith(str)) {
                        String property = providers[i].getProperty(str2);
                        try {
                            if (hashSet2.add(name.concat(property))) {
                                hashSet.add(newInstance(property, providers[i]));
                            }
                        } catch (SaslException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return hashSet;
    }

    public static Enumeration<SaslClientFactory> getSaslClientFactories() {
        return Collections.enumeration(findFactories(CLIENTFACTORYSRV));
    }

    public static Enumeration<SaslServerFactory> getSaslServerFactories() {
        return Collections.enumeration(findFactories(SERVERFACTORYSRV));
    }

    private static Object newInstance(String str, Provider provider) throws SaslException {
        ClassLoader classLoader = provider.getClass().getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        try {
            return Class.forName(str, true, classLoader).newInstance();
        } catch (ClassNotFoundException e) {
            throw new SaslException("auth.31" + str, e);
        } catch (IllegalAccessException e2) {
            throw new SaslException("auth.31" + str, e2);
        } catch (InstantiationException e3) {
            throw new SaslException("auth.31" + str, e3);
        }
    }
}
