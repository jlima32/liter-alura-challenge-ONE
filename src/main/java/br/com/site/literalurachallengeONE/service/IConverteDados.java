package br.com.site.literalurachallengeONE.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
