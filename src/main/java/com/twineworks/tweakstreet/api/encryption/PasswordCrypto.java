package com.twineworks.tweakstreet.api.encryption;

public interface PasswordCrypto {
  /**
   * Returns an encrypted string of given data
   * @param data
   * @return
   */
  String encrypt(String data);

  /**
   * Returns a decrypted clear-text string
   * @param data encoded data as produced by encrypt()
   * @return
   */
  String decrypt(String data);
}
