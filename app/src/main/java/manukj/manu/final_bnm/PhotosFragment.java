package manukj.manu.final_bnm;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import manukj.manu.final_bnm.LOGIN_UPLOAD.ImageUploadInfo;
import manukj.manu.final_bnm.LOGIN_UPLOAD.Upload_Image_Server;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhotosFragment extends Fragment {

    // Creating DatabaseReference.
    DatabaseReference databaseReference;

    // Creating RecyclerView.
    RecyclerView recyclerView;

    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter ;

    // Creating Progress dialog
    ProgressDialog progressDialog;

    // Creating List of ImageUploadInfo class.
    List<ImageUploadInfo> list = new ArrayList<>();
    Activity activity;
    public PhotosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        activity = getActivity();
        return inflater.inflate(R.layout.fragment_photos, container, false);
    }

    public void onStart() {

        super.onStart();
        // Assign id to RecyclerView.
        recyclerView = (RecyclerView) activity.findViewById(R.id.recyclerView);

// Setting RecyclerView size true.
        recyclerView.setHasFixedSize(true);

// Setting RecyclerView layout as LinearLayout.
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        // Assign activity this to progress dialog.
        progressDialog = new ProgressDialog(activity);

// Setting up message in Progress dialog.
        progressDialog.setMessage("Loading Images From Firebase.");


// Showing progress dialog.
        progressDialog.show();
        databaseReference = FirebaseDatabase.getInstance().getReference(Upload_Image_Server.Database_Path);
        // Adding Add Value Event Listener to databaseReference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    ImageUploadInfo imageUploadInfo = postSnapshot.getValue(ImageUploadInfo.class);
                    if(imageUploadInfo.getImageURL() != null)
                        list.add(imageUploadInfo);
                }

                adapter = new RecyclerViewAdapter(activity, list);

                recyclerView.setAdapter(adapter);

                // Hiding the progress dialog.
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Hiding the progress dialog.
                progressDialog.dismiss();

            }
        });
    }

}
