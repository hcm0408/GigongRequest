package com.onedaydent.gigongrequest.data.retrofit;

import com.onedaydent.gigongrequest.data.model.GigongOptionDTO;
import com.onedaydent.gigongrequest.data.model.GigongRequestDTO;
import com.onedaydent.gigongrequest.data.model.GigongStep1DTO;
import com.onedaydent.gigongrequest.data.model.MemberDTO;
import com.onedaydent.gigongrequest.data.model.PatientDTO;

import java.util.LinkedList;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface GigongAPI {

    @POST("/gigong/getPatientDatas")
    Call<LinkedList<PatientDTO>> getPatientData(@Query("chartID") String chartID);

    @POST("/gigong/getMemberData")
    Call<LinkedList<MemberDTO>> getMemberData();

    @POST("/gigong/setGigongRequest")
    Call<GigongRequestDTO> setGigongRequest(@Body GigongRequestDTO dto);

    @POST("/gigong/setGigongOption")
    Call<LinkedList<GigongOptionDTO>> setGigongOption(@Body List<GigongOptionDTO> items);

    @POST("/gigong/setGigongOptionUpdate")
    Call<LinkedList<GigongOptionDTO>> setGigongOptionUpdate(@Body List<GigongOptionDTO> items);

    @POST("/gigong/setGigongRequest")
    @Multipart
    Call<GigongRequestDTO> saveGigongRequest(@Body GigongRequestDTO dto, @Part MultipartBody.Part file);








    @POST("/gigong/setGigongStep1")
    Call<GigongRequestDTO> setGigongStep1(@Body GigongStep1DTO dto);
}