package com.example.testapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceholderApi {

    @GET("posts")
    Call<List<Post>> getPost();

    // posts/1/comments
    @GET("posts/{id}/comments")
    Call<List<Comments>> getComments(@Path("id") int postId);

    // comments?postId=1
    @GET("comments")
    Call<List<Comments>> getPostComments(@Query("postId") int postId);

    // comments?postId=1&_sort=id&_order=desc
    @GET("comments")
    Call<List<Comments>> getPostCommentCondition(
            @Query("postId") int postId,
            @Query("_sort") String postSort,
            @Query("_order") String postOrder
    );
    //  Send Details to the server
    @POST("posts")
    Call<Post> createPost(@Body Post post);

    // send Data to the server
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPostAlternative(@Field("userId") int userId, @Field("title") String title, @Field("body") String text);

}
