package com.twineworks.tweakstreet.api.encryption;

public final class Encryption {

  private final PasswordCrypto passwordCrypto;

  public Encryption(PasswordCrypto passwordCrypto) {
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

  public String encrypt(String str){
    if (str == null) return null;
    return EncryptionConstants.PREFIX + passwordCrypto.encrypt(str);
  }
}
