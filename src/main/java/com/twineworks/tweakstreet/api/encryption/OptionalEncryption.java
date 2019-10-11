package com.twineworks.tweakstreet.api.encryption;

public final class OptionalEncryption {

  private final PasswordCrypto passwordCrypto;

  public OptionalEncryption(PasswordCrypto passwordCrypto) {
    this.passwordCrypto = passwordCrypto;
  }

  public String decryptOptionallyEncrypted(String str) {
    if (str == null) return null;
    if (str.startsWith(EncryptionConstants.PREFIX)){
      return passwordCrypto.decrypt(str.substring(EncryptionConstants.PREFIX.length()));
    } else {
      return str;
    }

  }
}
