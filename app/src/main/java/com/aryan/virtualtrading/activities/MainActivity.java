package com.aryan.virtualtrading.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.aryan.virtualtrading.GetUserCallback;
import com.aryan.virtualtrading.R;
import com.aryan.virtualtrading.RetrofitUrl;
import com.aryan.virtualtrading.UserRequest;
import com.aryan.virtualtrading.api.UserAPI;
import com.aryan.virtualtrading.fragments.HomeFragment;
import com.aryan.virtualtrading.fragments.LeaderboardFragment;
import com.aryan.virtualtrading.fragments.PortfolioFragment;
import com.aryan.virtualtrading.models.UserModel;
import com.facebook.AccessToken;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    //Creating user object for easy access from all fragments
    public static UserModel userProfile;
    private AppBarConfiguration mAppBarConfiguration;
    String name;
    TextView navUserProfile, navUsername, navUserBalance;

//    public static UserModel currentUser;
//    //New changes
//    private static final int RESULT_PROFILE_ACTIVITY = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        //nav header views
        View headerView = navigationView.getHeaderView(0);
        navUserProfile = (TextView) headerView.findViewById(R.id.tv_profile);
        navUsername = (TextView) headerView.findViewById(R.id.profileName);
        navUserBalance = (TextView) headerView.findViewById(R.id.balance);

        getUserProfile();

        // If MainActivity is reached without the user being logged in, redirect to the Login
        // Activity
//        if (AccessToken.getCurrentAccessToken() == null) {
//            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
//            startActivity(loginIntent);
//        }
//
//        // Make a button which leads to profile information of the user
//                if (AccessToken.getCurrentAccessToken() == null) {
//                    Intent profileIntent = new Intent(MainActivity.this, LoginActivity
//                            .class);
//                    startActivityForResult(profileIntent, RESULT_PROFILE_ACTIVITY);
//                } else {
////                    Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
////                    startActivity(profileIntent);
//                }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_market, R.id.nav_portfolio,
                R.id.nav_leaderboard, R.id.nav_share, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (requestCode) {
//            case RESULT_PROFILE_ACTIVITY:
//                if (resultCode == RESULT_OK) {
////                    Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
////                    startActivity(profileIntent);
//                }
//                break;
//            default:
//                super.onActivityResult(requestCode,resultCode, data);
//        }
//    }

//    //Old code
//    @Override
//    protected void onResume() {
//        super.onResume();
//        UserRequest.makeUserRequest(new GetUserCallback(MainActivity.this).getCallback());
//    }

//    @Override
//    public void onCompleted(UserModel user) {
//        currentUser = user;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    //Getting logged in user profile
    public void getUserProfile(){

        UserAPI userAPI = RetrofitUrl.getInstance().create(UserAPI.class);
        Call<UserModel> usersCall = userAPI.getUserProfile(RetrofitUrl.token);

        usersCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Error loading profile!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                userProfile = response.body();
                showdetail(userProfile.getFullName());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error loading profile...", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void showdetail(String name){
        //Changing the content of nav header
        navUserProfile.setText(name.charAt(0)+ "");
        navUsername.setText(name+"");
        navUserBalance.setText("Rs. 1000000000000");
    }
}
