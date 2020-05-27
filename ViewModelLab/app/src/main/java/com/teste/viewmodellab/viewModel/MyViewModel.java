package com.teste.viewmodellab.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MyViewModel extends AndroidViewModel {

    private MutableLiveData<String> name;

    public MyViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getName() {
        if (name == null){
            name = new MutableLiveData<>();
            updateName();
        }
        return name;
    }

    public void updateName(){
        name.setValue("Dev venture");
    }
}
