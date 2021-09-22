package com.usama.retrofitblogger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.usama.retrofitblogger.Adapter.NewsAdapter
import com.usama.retrofitblogger.Model.ApiClient
import com.usama.retrofitblogger.Model.ModelApiResponse
import com.usama.retrofitblogger.Model.ModelNews
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class   MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    var modelApiResponseList: List<ModelApiResponse> = ArrayList()
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        loadCurrentNews()

    }

    fun loadCurrentNews() {

        val call: Call<ModelNews> =
            ApiClient().getApiService()!!.getCurrentNews("us", Constants.API_KEY)
        call.enqueue(object : Callback<ModelNews> {
            override fun onResponse(
                call: Call<ModelNews>,
                response: Response<ModelNews>
            ) {
                if (response.isSuccessful) {

                    modelApiResponseList = response.body()?.getArticles() as List<ModelApiResponse>
                    //modelApiResponseList.add(response.body()?.getArticles())
                    recyclerView.adapter = NewsAdapter(modelApiResponseList)
                    //modelApiResponseList.add(response.body()!!.getArticles())

                    Toast.makeText(this@MainActivity, "Response is successful", Toast.LENGTH_LONG)
                        .show()

                }
            }

            override fun onFailure(call: Call<ModelNews>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

}




