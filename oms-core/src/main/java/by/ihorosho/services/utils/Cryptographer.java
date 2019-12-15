package by.ihorosho.services.utils;

import by.ihorosho.api.utils.ICryptographer;
import com.ovea.crypto.HEX;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Component("cryptographer")
public class Cryptographer implements ICryptographer {
    private static final String ALGORITHM_NAME = "HmacSHA256";

    @Override
    public String encode(String value, String key) {
        try {
            Mac sha256HMAC = Mac.getInstance(ALGORITHM_NAME);
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM_NAME);
            sha256HMAC.init(secretKey);
            return HEX.encodeHexString(sha256HMAC.doFinal(value.getBytes()));
        } catch (Exception e) {
            return null;
        }
    }
}
