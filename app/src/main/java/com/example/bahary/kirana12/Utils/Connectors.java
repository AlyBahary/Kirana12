package com.example.bahary.kirana12.Utils;

import com.example.bahary.kirana12.Models.CountryModel.CountryExampleModel;
import com.example.bahary.kirana12.Models.ExampleCatgModel;
import com.example.bahary.kirana12.Models.ExampleMainFactorModel;
import com.example.bahary.kirana12.Models.ExampleProductsModel;
import com.example.bahary.kirana12.Models.ExampleSubCatgModel;
import com.example.bahary.kirana12.Models.ItemDescribtionModel.ItemModel;
import com.example.bahary.kirana12.Models.ORDER_TO_SEND_MODEL;
import com.example.bahary.kirana12.Models.SliderImageModel;
import com.example.bahary.kirana12.Models.SpecificItemModel.SpecificItemExampleModel;
import com.example.bahary.kirana12.Models.UserModel;
import com.example.bahary.kirana12.Models.UserStatusModel;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class Connectors {

    public interface getLoginDataService {
        public String BaseURL = Constants.mBase_Url;

        @FormUrlEncoded
        @POST(Constants.mLogin)
        Call<UserStatusModel> login(@Field("email") String email, @Field("password") String password);

        //@FormUrlEncoded
        @GET(Constants.mGet_countries)
        Call<CountryExampleModel> Countries();

        @FormUrlEncoded
        @POST(Constants.mGet_states)
        Call<CountryExampleModel> States(@Field("country_id") String country_id);
    }

    public interface setNewUser {
        public String BaseURL = Constants.mBase_Url;

        @FormUrlEncoded
        @POST(Constants.mRegistration)
        Call<UserStatusModel> Registration(
                @Field("f_name") String f_name
                , @Field("l_name") String l_name
                , @Field("password") String password
                , @Field("gender") String gender
                , @Field("birth_date") String birth_date
                , @Field("email") String email
                , @Field("mobile") String mobile
                , @Field("postal") String postal
                , @Field("address") String address
                , @Field("newsletter") String newsletter
                , @Field("state_id") String state_id
                , @Field("country_id") String country_id
                , @Field("city") String city
        );
    }

    public interface getCategoriesService {
        public String BaseURL = Constants.mBase_Url;

        @FormUrlEncoded
        @POST(Constants.mMainCategries)
        Call<ExampleCatgModel> getCatries(@Field("type") String type);
    }

    public interface getSubCategroiesServices {
        public String BaseURL = Constants.mBase_Url;

        @FormUrlEncoded
        @POST(Constants.mSubCategries)
        Call<ExampleSubCatgModel> getSubCatries(@Field("category") String category);

    }

    public interface getMainfactorServices {
        public String BaseURL = Constants.mBase_Url;

        @POST(Constants.mManinFacor)
        Call<ExampleMainFactorModel> getMainfactor();

        @POST(Constants.mgetSliderImages)
        Call<SliderImageModel> getSliderImages();


    }

    public interface getProductsServices {
        public String BaseURL = Constants.mBase_Url;

        @FormUrlEncoded
        @POST(Constants.mgetProducts)
        Call<ExampleProductsModel> getProductsByManufac(@Field("manufacturer_id") String id);

        @FormUrlEncoded
        @POST(Constants.mgetProducts)
        Call<ExampleProductsModel> getProductsBySubCat(@Field("category_id") String id);

        @FormUrlEncoded
        @POST(Constants.mgetProducts)
        Call<ExampleProductsModel> getFeaturedProducts(@Field("type") String type);

        @FormUrlEncoded
        @POST(Constants.mgetProducts)
        Call<ExampleProductsModel> getSearchedProducts(@Field("search") String search);

        @FormUrlEncoded
        @POST(Constants.mSpecificProduct)
        Call<SpecificItemExampleModel> mSpecificProduct(@Field("id") String id);

      @FormUrlEncoded
        @POST(Constants.add_order)
        Call<UserStatusModel> add_order(@Body ORDER_TO_SEND_MODEL order_to_send_model);

        // lesa m3mltoo4 mstny 3bdoo yzbt feeh 7agat
       /* @FormUrlEncoded
        @POST(Constants.mgetProductDescription)
        Call<ExampleProductsModel> getProductDescribtion(@Field("id") String id);
*/
    }
}
