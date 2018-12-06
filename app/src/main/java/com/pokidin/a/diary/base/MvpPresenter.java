package com.pokidin.a.diary.base;

public interface MvpPresenter<V extends MvpView> {
    void attachView(V view);

    void viewIsReady();

    void detachView();

    void destroy();
}
