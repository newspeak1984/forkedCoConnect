package com.example.ivanchow.portablepc;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;


public class ThirdFragment extends Fragment {
    EditText userInput;
    DBHandler dbHandler;
    EditText article;
    EditText author;
    EditText category;
    Bitmap titleImage;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        dbHandler = new DBHandler(getActivity(), null, null, 8);

        userInput = (EditText) v.findViewById(R.id.title);
        author = (EditText) v.findViewById(R.id.author);
        article = (EditText) v.findViewById(R.id.article);
        category = (EditText) v.findViewById(R.id.category);

        Button photo = (Button) v.findViewById(R.id.photo);
        Button add = (Button) v.findViewById(R.id.add);
        Button delete = (Button) v.findViewById(R.id.delete);

        if(!hasCamera())
            photo.setEnabled(false);

        add.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        dbHandler.addNewsStory(new NewsStory(userInput.getText().toString(), titleImage, article.getText().toString(), author.getText().toString(), category.getText().toString()));

                    }
                }
        );
        delete.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        dbHandler.deleteNewsStory(userInput.getText().toString());
                    }
                }
        );
        photo.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                       launchCamera(v);

                    }
                }
        );

        return v;
    }

    public static ThirdFragment newInstance(String text) {

        ThirdFragment f = new ThirdFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
    //Check if the user has a camera
    private boolean hasCamera(){
        return getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    //Launching the camera
    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Take a picture and pass results along to onActivityResult
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    //If you want to return the image taken
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            //Get the photo
            Bundle extras = data.getExtras();
             titleImage = (Bitmap) extras.get("data");

        }
    }

}