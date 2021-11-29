package com.atual.covid.usuario;

import org.jasypt.util.text.AES256TextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

public class CriptografiaService {
	private static final String CHAVE = "<`h@/1j1u#{bp<16:c]ol}%-:(12uwh)-bz.bw+_-[>t4g]mr<<`pi!_k2f%5&z";
    private static final AES256TextEncryptor textEncryptor;

    static {
        textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword(CHAVE);
    }

    public static String criptografar(String textoParaCriptografar) {
        return textEncryptor.encrypt(textoParaCriptografar);
    }

    public static String descriptografar(String textoParaDesincriptografar) {
        return textEncryptor.decrypt(textoParaDesincriptografar);
    }
	

}
