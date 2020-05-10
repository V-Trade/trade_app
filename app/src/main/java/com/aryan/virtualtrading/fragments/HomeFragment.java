package com.aryan.virtualtrading.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.aryan.virtualtrading.R;
import com.aryan.virtualtrading.activities.LoginActivity;
import com.aryan.virtualtrading.activities.MainActivity;
import com.aryan.virtualtrading.models.UserModel;
import com.facebook.AccessToken;

public class HomeFragment extends Fragment{


    private ImageView mProfilePhotoView;
    private TextView mName;
    private TextView mId;
    private TextView mEmail;
    private TextView mPermissions;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        if (AccessToken.getCurrentAccessToken() == null) {
            Intent loginIntent = new Intent(getContext(), LoginActivity.class);
            startActivity(loginIntent);
        }

        mProfilePhotoView = root.findViewById(R.id.profileimg);
        mName = root.findViewById(R.id.name);
        mId = root.findViewById(R.id.id);
        mEmail = root.findViewById(R.id.email);
        mPermissions = root.findViewById(R.id.permissions);

        UserModel user = MainActivity.currentUser;

        mProfilePhotoView.setImageURI(user.getProfile());
        mName.setText(user.getFullname());
//        mId.setText(user.getId());
        if (user.getEmail() == null) {
            mEmail.setText(R.string.no_email_perm);
            mEmail.setTextColor(Color.RED);
        } else {
            mEmail.setText(user.getEmail());
            mEmail.setTextColor(Color.BLACK);
        }
//        mPermissions.setText(user.getPermissions());
        return root;
    }

}