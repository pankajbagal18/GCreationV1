package com.dev.pankaj.gcreationv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ListView listView;
    List<ProfileData> profileList=null;
    Button addButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        addButton = (Button) view.findViewById(R.id.addProfileButton);
        listView = (ListView) view.findViewById(R.id.profileList);
        if(listView==null)
            Log.d("ListView","NULL1");
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),AddProfile.class));
            }
        });
        profileList = new ArrayList<ProfileData>();
        getProfiles();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProfileData profileData = profileList.get(position);
                Intent intent = new Intent(getContext(), ShowSelectedProfile.class);
                intent.putExtra("PROFILE_DATA", profileData);
                startActivity(intent);
            }
        });
        return view;
    }
    private void getProfiles()
    {

        final FirebaseDatabase songDatabase = FirebaseDatabase.getInstance();
        DatabaseReference songRef = songDatabase.getReference("profile");
        songRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {

                    for(DataSnapshot child:dataSnapshot.getChildren())
                    {
                        ProfileData profileData = child.getValue(ProfileData.class);
                        profileList.add(profileData);
                        Log.d("Empty","fgh");
                    }
                    CustomListAdapter adapter = new CustomListAdapter((Activity) getContext(), profileList);
                    listView.setAdapter(adapter);
                }
                else
                    Log.d("createPlaylist","no record found");
                //Log.d("Song",dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("HomeFragment","Not got");
            }
        });
        return;
    }
}
