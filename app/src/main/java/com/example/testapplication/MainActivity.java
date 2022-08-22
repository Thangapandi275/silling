package com.example.testapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Retrofit retrofit;
    JsonPlaceholderApi jsonPlaceholderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.myvalueabletext);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);

       // getpost();
       // getComments();
//        getPecificComments();
        // getPecificCommentsWithCondition();
        
       // createPost();
        createPostAlternative();


/*
        String text = "This is my extendable text for the color sample";
//        textView.setText("This is my extendable text for the color sample");

        SpannableString ss = new SpannableString(text);

        ForegroundColorSpan fcolor = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan lcolor = new ForegroundColorSpan(Color.GREEN);

        ss.setSpan(fcolor , 5 , 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(lcolor , 10, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
*/
    }

    private void createPostAlternative() {

//        Post post = new Post(23, "title", "content page");

        Call<Post> call = jsonPlaceholderApi.createPostAlternative(23, "title", "content page");
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: "+response.code());
                    return;
                }
                Post postresponse = response.body();
//                for (Post post: postresponse){
                String content="";
                content += "Code: "+ response.code() + "\n";
                content += "ID: "+ postresponse.getId() + "\n";
                content += "User Id: "+postresponse.getUserId() + "\n";
                content += "Title: "+postresponse.getTitle() + "\n";
                content += "Content: "+postresponse.getText() + "\n";
                textView.append(content);
//                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }

    private void createPost() {

        Post post = new Post(23, "title", "content page");

        Call<Post> call = jsonPlaceholderApi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: "+response.code());
                    return;
                }
                Post postresponse = response.body();
//                for (Post post: postresponse){
                    String content="";
                    content += "Code: "+ response.code() + "\n";
                    content += "ID: "+ postresponse.getId() + "\n";
                    content += "User Id: "+postresponse.getUserId() + "\n";
                    content += "Title: "+postresponse.getTitle() + "\n";
                    content += "Content: "+postresponse.getText() + "\n";
                    textView.append(content);
//                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }

    private void getPecificCommentsWithCondition(){
        Call<List<Comments>> call = jsonPlaceholderApi.getPostCommentCondition(4, "id", "asc");
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: "+response.code());
                    return;
                }
                List<Comments> comments = response.body();
                for (Comments comment:comments){
                    String responsecomment = "";
                    responsecomment += "PostId: "+ comment.getPostId()+"\n";
                    responsecomment += "Id: "+ comment.getId()+"\n";
                    responsecomment += "Name: "+ comment.getName()+"\n";
                    responsecomment += "Email: "+ comment.getEmail()+"\n";
                    responsecomment += "Body: "+ comment.getComment()+"\n\n";

                    textView.append(responsecomment);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Comments>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    private void getPecificComments(){
        Call<List<Comments>> call = jsonPlaceholderApi.getPostComments(4);
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: "+response.code());
                    return;
                }
                List<Comments> comments = response.body();
                for (Comments comment:comments){
                    String responsecomment = "";
                    responsecomment += "PostId: "+ comment.getPostId()+"\n";
                    responsecomment += "Id: "+ comment.getId()+"\n";
                    responsecomment += "Name: "+ comment.getName()+"\n";
                    responsecomment += "Email: "+ comment.getEmail()+"\n";
                    responsecomment += "Body: "+ comment.getComment()+"\n\n";

                    textView.append(responsecomment);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Comments>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    private void getComments() {
        Call<List<Comments>> call = jsonPlaceholderApi.getComments(2);
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: "+response.code());
                    return;
                }
                List<Comments> comments = response.body();
                for(Comments comment: comments){
                    String responsecomment = "";
                    responsecomment += "PostId: "+ comment.getPostId()+"\n";
                    responsecomment += "Id: "+ comment.getId()+"\n";
                    responsecomment += "Name: "+ comment.getName()+"\n";
                    responsecomment += "Email: "+ comment.getEmail()+"\n";
                    responsecomment += "Body: "+ comment.getComment()+"\n\n";

                    textView.append(responsecomment);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Comments>> call, Throwable t) {
//                Log.println(lo"Connection "+ t);
                textView.setText(t.getMessage());
            }
        });
    }

    private void getpost() {
        Call<List<Post>> call = jsonPlaceholderApi.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: "+response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post:posts){
                    String content="";
                    content += "ID: "+ post.getId() + "\n";
                    content += "User Id: "+post.getUserId() + "\n";
                    content += "Title: "+post.getTitle() + "\n";
                    content += "Content: "+post.getText() + "\n";
                    textView.append(content);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, Throwable t) {
//                Log.println(lo"Connection "+ t);
                textView.setText(t.getMessage());
            }
        });
    }


}