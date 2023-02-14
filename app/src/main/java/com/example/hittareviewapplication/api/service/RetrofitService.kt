package com.example.hittareviewapplication.api.service

import android.util.Log
import com.example.hittareviewapplication.api.models.CompanyInfoResponseDTO
import com.example.hittareviewapplication.api.models.ReviewDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitService {

    @GET("/search/v7/app/company/{id}")
    fun getCompanyInfo(@Path("id") id: String): Call<CompanyInfoResponseDTO>?

    @Headers(
        "X-HITTA-DEVICE-NAME: MOBILE_WEB",
        "X-HITTA-SHARED-IDENTIFIER: 15188693697264027",
        "charset: UTF-8")
    @POST("/reviews/v1/company/")
    fun postReview(@Body review: ReviewDTO): Call<Unit>

}

/**
 * Class for getting and posting to API endpoints.
 */
class RetrofitServiceImpl {
    val className = RetrofitService::class.toString()

    private val retrofitGetConfig = Retrofit.Builder()
        .baseUrl("https://api.hitta.se")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitPostConfig = Retrofit.Builder()
        .baseUrl("https://test.hitta.se")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getCompanyInfo(@Path("id") id: String): Call<CompanyInfoResponseDTO>? {
        return retrofitGetConfig.create(RetrofitService::class.java).getCompanyInfo(id)
    }

    /**
     * Post a review to the end point.
     */
    fun postReview(review: ReviewDTO) {
        val service = retrofitPostConfig.create(RetrofitService::class.java)

        service.postReview(review).enqueue(object : Callback<Unit> {
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.e(className, "Failed to post review")
            }

            override fun onResponse(
                call: Call<Unit>,
                response: Response<Unit>
            ) {
                if (response.isSuccessful) {
                    Log.d(className, "Successfully posted, " + response.body())
                } else {
                    Log.e(className, "Failed to post review, " + response.errorBody())
                }

            }
        })
    }

    /**
     * Get the company name from an end point using an identifier as parameter.
     */
    fun getCompanyName(id: String) {
        val service = retrofitGetConfig.create(RetrofitService::class.java)
        service.getCompanyInfo(id)?.enqueue(object : Callback<CompanyInfoResponseDTO?> {
            override fun onResponse(
                call: Call<CompanyInfoResponseDTO?>,
                response: Response<CompanyInfoResponseDTO?>
            ) {
                if (response.isSuccessful) {
                    val displayName = response.body()?.result?.companies?.company?.get(0)?.displayName
                    Log.d(className, displayName.toString())
                }
            }

            override fun onFailure(call: Call<CompanyInfoResponseDTO?>, t: Throwable) {
                Log.e(className, "failure: $t")
                Log.e(className, "failure: $call")
            }
        })
    }
}