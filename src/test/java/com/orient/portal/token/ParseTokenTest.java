/**
 * @Project Name :  portal
 * @Package Name :  com.orient.portal.token
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2017-12-22 3:39 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.portal.token;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pac4j.jwt.config.encryption.SecretEncryptionConfiguration;
import org.pac4j.jwt.config.signature.SecretSignatureConfiguration;
import org.pac4j.jwt.credentials.authenticator.JwtAuthenticator;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @author :  panduanduan
 * @Description :  测试token解析
 * @Creation Date:  2017-12-22 3:39 PM
 */
@RunWith(SpringRunner.class)
public class ParseTokenTest {

    private String salt = "12345678901234567890123456789012";

    @Test
    public void testParseToken() {
        String token = "eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiZGlyIn0..z0iujnoeJgqNchUK.mheSmXVw-1E4568VdAv9KfdR3KS_FkTmD5yxFzjqj_0HXeCBFFbRvBOgnZjufAE4e8cx-gj4zDPunaMr3x-LtvOlTLJHCIPwUOtXstHRC9uMIEt7LJ7RNIQbqHIQnaUXdXavY7jA1KHfeavBLL_nkQtGQ_67D_4fICPUv1H9GS-g9pblgmunMoJj6elpHkh9T04Ac3INGoRhc8RXmcCHny322-tl8_axNU_oQN5L4ty55LFLZnziX2q3Xu-hCO_y-2JZLaP5ZZ21C9Nprn4QzOXhNtnKDZGGoBz04B46npvUAIxyFw7rNhv4megisdapMbqXLkytf-RXMBtq7btzeovaquuIPN3RSb38OdgNmRgipuMpgjZZPimSDfQNh5u5RCBp_gvkV_AYpUhaxBcpCy6jveapyJWqDRKJzJvBoHbPSKfns9TFLBjx_ADdLr-CI1axhVdoGum4HG7pFWNft6nkoDiNcvym3gPundenvrki4EmYw3WHki15Hq-VpIPdVcmi1zrzSvRjK61FBBOpowTTyjaIKpolz4hyRoTD7gDVVUmOxHgjlC_ioLn3BmLrlI5185i54Flkbxl5EEC_GQTWo1VkJvcc4NDVpd46FCPYMNhMXGbsMUQcPkAXoNIKUoG0BEQ6THScyqCb9VGRcRJbuV_X2r1iKGAB-UIO5MvEyFXOjLj3q4GogRVRAGze5zYvPZmQWWDWAbj5sylZBGJpzhy4Aou1My0gJJPRFJg3yEhw_CYrAKdpYZ63FWa4e4-0h9MF9FggRqTr5rVr5YbzlBxWnXe3sBEAnM6fPjA_KKtP9tK5D-tHi7MtxdLW.JxAe3-PfwWG5Dp3j586jFg";
        JwtAuthenticator jwtAuthenticator = new JwtAuthenticator();
        jwtAuthenticator.addSignatureConfiguration(new SecretSignatureConfiguration(salt));
        jwtAuthenticator.addEncryptionConfiguration(new SecretEncryptionConfiguration(salt));
        Map<String, Object> clams = jwtAuthenticator.validateTokenAndGetClaims(token);
        System.err.println(clams);
    }
}