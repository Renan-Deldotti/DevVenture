package com.teste.canilroomviewmodel.viewModel;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.teste.canilroomviewmodel.database.Dog;
import com.teste.canilroomviewmodel.database.DogImageUrl;
import com.teste.canilroomviewmodel.retrofit.RetrofitConfig;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogDetailsViewModel extends AndroidViewModel {

    private static final String TAG = DogDetailsViewModel.class.getSimpleName();

    private RetrofitConfig retrofitConfig;
    private Call<Dog> dogCall;
    private Call<List<DogImageUrl>> dogImageUrlCall;
    private Bitmap bitmap;


    private MutableLiveData<Dog> dogMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Bitmap> bitmapMutableLiveData = new MutableLiveData<>();


    public DogDetailsViewModel(@NonNull Application application) {
        super(application);
        retrofitConfig = new RetrofitConfig();
    }

    public MutableLiveData<Dog> getDogMutableLiveData(String idToSearch) {

        dogCall = retrofitConfig.getDogAPI().getDogById(Integer.parseInt(idToSearch));
        dogCall.enqueue(new Callback<Dog>() {
            @Override
            public void onResponse(Call<Dog> call, Response<Dog> response) {
                Dog dog = response.body();
                if (dog != null){
                    dogMutableLiveData.postValue(dog);
                }
                if (response.code() != 200){
                    Log.e(TAG, "Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Dog> call, Throwable t) {
                Log.e(TAG,"Failed to load dog data...\nError: "+t.getMessage());
            }
        });

        return dogMutableLiveData;
    }

    public MutableLiveData<Bitmap> getBitmapMutableLiveData(String idToSearch) {

        // Set dog image
        bitmap = null;
        dogImageUrlCall = retrofitConfig.getDogAPI().getImageUrl(idToSearch);
        dogImageUrlCall.enqueue(new Callback<List<DogImageUrl>>() {
            @Override
            public void onResponse(Call<List<DogImageUrl>> call, Response<List<DogImageUrl>> response) {
                List<DogImageUrl> dogImageUrls = response.body();
                if (dogImageUrls != null){
                    String url = dogImageUrls.get(0).getUrl();
                    new Thread(){
                        @Override
                        public void run() {
                            try {
                                bitmap = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
                                bitmapMutableLiveData.postValue(bitmap);
                            } catch (MalformedURLException e) {
                                Log.e(TAG,"Error parsing URL\nError: "+ e.getMessage());
                            } catch (IOException e) {
                                Log.e(TAG,"Failed to parse image...\nError: "+ e.getMessage());
                            }
                        }
                    }.start();
                }
            }

            @Override
            public void onFailure(Call<List<DogImageUrl>> call, Throwable t) {
                Log.e(TAG,"Failed to load dog image...\nError: "+ t.getMessage());
            }
        });

        return bitmapMutableLiveData;
    }
}
