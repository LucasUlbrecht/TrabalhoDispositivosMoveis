package ProteceoDados;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.util.Base64;
import android.util.Log;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Security {
    private static final String KEY_ALIAS = "myKeyAlias";
    private static final String akeyStore="AndroidKeyStore";


    private static SecretKey generateKey() {
        try {
            KeyStore keyStore = KeyStore.getInstance(akeyStore);
            keyStore.load(null);

            // Verifica se a chave já existe
            if (!keyStore.containsAlias(KEY_ALIAS)) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance(
                        KeyProperties.KEY_ALGORITHM_AES, akeyStore);

                KeyGenParameterSpec keyGenParameterSpec = new KeyGenParameterSpec.Builder(
                        KEY_ALIAS,
                        KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                        .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                        .build();

                keyGenerator.init(keyGenParameterSpec);
                return keyGenerator.generateKey();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SecretKey getKey() {
        try {
            KeyStore keyStore = KeyStore.getInstance(akeyStore);
            keyStore.load(null);
            return (SecretKey) keyStore.getKey(KEY_ALIAS, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void armazenar(Context context, String dado, String identificador) {
        try {
            SecretKey chave = getKey();

            if (chave != null) {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                cipher.init(Cipher.ENCRYPT_MODE, chave);
                byte[] encryptedData = cipher.doFinal(dado.getBytes());

                String encryptedDataBase64 = Base64.encodeToString(encryptedData, Base64.DEFAULT);

                SharedPreferences sharedPreferences =
                        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(identificador, encryptedDataBase64);
                editor.apply();
            } else {
                // Trate o caso em que a chave não está disponível
                Log.e("Security", "Chave não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Security", "Erro ao armazenar o dado");
        }
    }
    public static String recuperar(Context context, String identificador) {
        try {
            SecretKey chave = getKey();

            if (chave != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE);
                String encryptedData = sharedPreferences.getString(identificador, "");

                if (!encryptedData.isEmpty()) {
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                    cipher.init(Cipher.DECRYPT_MODE, chave);

                    byte[] decodedData = Base64.decode(encryptedData, Base64.DEFAULT);
                    byte[] decryptedData = cipher.doFinal(decodedData);

                    return new String(decryptedData);
                } else {
                    Log.e("Security", "Dados não encontrados para o identificador: " + identificador);
                }
            } else {
                Log.e("Security", "Chave não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Security", "Erro ao recuperar o dado");
        }
        return null;
    }
}

