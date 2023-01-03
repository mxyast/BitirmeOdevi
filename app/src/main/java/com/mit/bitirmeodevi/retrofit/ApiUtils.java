package com.mit.bitirmeodevi.retrofit;

public class ApiUtils {
    public static final String BASE_URL = "http://kasimadalan.pe.hu/";

    public static YemeklerDao getYemeklerDao(){
        return RetrofitClint.getClient(BASE_URL).create(YemeklerDao.class);
    }
    public static SepetYemeklerDao getSepetYemeklerDao(){
        return RetrofitClint.getClient(BASE_URL).create(SepetYemeklerDao.class);
    }
}
