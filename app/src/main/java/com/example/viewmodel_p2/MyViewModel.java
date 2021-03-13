package com.example.viewmodel_p2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    MutableLiveData<Integer>mMutableInterger = new MutableLiveData<>();

  //constructor trong viewModel ko có tham số
    public MyViewModel() {
        this.mMutableInterger = mMutableInterger;
    }

    public void setCount(int Count){
        mMutableInterger.setValue((Count));
    }

    //sử dụng hàm livedata để ko thay đổi dữ liệu
    public LiveData<Integer>getCount(){
        return mMutableInterger;
    }
}
