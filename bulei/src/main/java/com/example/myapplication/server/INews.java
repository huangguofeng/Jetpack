package com.example.myapplication.server;


import com.example.myapplication.base.BaseResponse;
import com.example.myapplication.bean.News;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author :huangguofeng
 * date    :2021/2/27
 * package :com.lib.http.server
 * desc    :TODO:测试接口
 */
public interface INews {
    /**
     * 获取新闻
     *
     * @param type  类型
     * @param token token
     * @return news
     */
    @GET("toutiao/index")
    Call<News> getNewsGet(@Query("type") String type, @Query("page") int page, @Query("page_size") int pageSize, @Query("key") String token);

    /**
     * 获取新闻
     *
     * @param type  类型
     * @param token token
     * @return news
     */
    @GET("toutiao/index")
    Observable<News> getNewsGet2(@Query("type") String type, @Query("page") int page, @Query("page_size") int pageSize, @Query("key") String token);

    /**
     * 获取新闻
     *
     * @param type  类型
     * @param token token
     * @return news
     */
    @GET("toutiao/index")
    Observable<BaseResponse<News.ResultBean>> getNewsGet3(@Query("type") String type, @Query("page") int page, @Query("page_size") int pageSize, @Query("key") String token);

    /**
     * 获取新闻
     *
     * @param type  类型
     * @param token token
     * @return news
     */
    @GET("toutiao/index")
    Observable<Response<News>> getNewsGet4(@Query("type") String type, @Query("page") int page, @Query("page_size") int pageSize, @Query("key") String token);

}
