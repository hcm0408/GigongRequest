package com.onedaydent.gigongrequest;

import org.junit.Test;

import android.util.Log;

import com.onedaydent.gigongrequest.data.model.PatientDTO;
import com.onedaydent.gigongrequest.data.retrofit.GigongAPI;
import com.onedaydent.gigongrequest.data.retrofit.GigongClient;
import com.onedaydent.gigongrequest.utils.App;
import com.onedaydent.gigongrequest.utils.Utils;

import java.util.LinkedList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private static String TAG = App.class.getSimpleName();

    @Test
    public void test(){
        if (GigongClient.getInstance() != null){
            GigongAPI api = GigongClient.getRetrofit().create(GigongAPI.class);

            Call<LinkedList<PatientDTO>> call2 = api.getPatientData("1807-306");
            call2.enqueue(new Callback<LinkedList<PatientDTO>>() {
                @Override
                public void onResponse(Call<LinkedList<PatientDTO>> call, Response<LinkedList<PatientDTO>> response) {
                    System.out.println(response.body());
                }

                @Override
                public void onFailure(Call<LinkedList<PatientDTO>> call, Throwable t) {
                    Utils.getMessageShort("2에러가 발생했습니다. 관리자에게 문의하세요.");
                }
            });
        }
    }

}