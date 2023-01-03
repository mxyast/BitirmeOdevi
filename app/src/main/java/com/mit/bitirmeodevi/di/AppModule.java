package com.mit.bitirmeodevi.di;

import com.mit.bitirmeodevi.data.repo.SepetYemeklerDaoRepository;
import com.mit.bitirmeodevi.data.repo.YemeklerDaoRepository;
import com.mit.bitirmeodevi.retrofit.ApiUtils;
import com.mit.bitirmeodevi.retrofit.SepetYemeklerDao;
import com.mit.bitirmeodevi.retrofit.YemeklerDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public YemeklerDaoRepository provideYemeklerDaoRepository(YemeklerDao ydao){
        return new YemeklerDaoRepository(ydao);
    }
    @Provides
    @Singleton
    public YemeklerDao provideYemeklerDao(){
        return ApiUtils.getYemeklerDao();
    }

    @Provides
    @Singleton
    public SepetYemeklerDaoRepository provideSepetYemeklerDaoRepository(SepetYemeklerDao sydao){
        return new SepetYemeklerDaoRepository(sydao);
    }
    @Provides
    @Singleton
    public SepetYemeklerDao provideSepetYemeklerDao(){
        return ApiUtils.getSepetYemeklerDao();
    }

}
