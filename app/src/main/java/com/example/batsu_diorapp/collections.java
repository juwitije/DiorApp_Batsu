package com.example.batsu_diorapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class collections extends AppCompatActivity {
    RecyclerView myRecycler;
    RecyclerView.LayoutManager layoutManager;
    List<String> mList = new ArrayList<>();
    MyRecAdapter myRecAdapter;

    TextView userNameCol;

    DbHelper dbHelper;
    TextInputEditText stName, stPhone, stFaculty, stEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);
        myRecycler=findViewById(R.id.myRecycler);
        userNameCol = findViewById(R.id.userNameCol);
        myRecAdapter=new MyRecAdapter(this,mList);
        Intent intent = getIntent();
        userNameCol.setText(intent.getStringExtra("username"));

        dbHelper = new  DbHelper(this);

        mList.add("Air Force");
        mList.add("Air Jordan");
        mList.add("All Star");
        mList.add("High Heels");
        mList.add("High Heels light");
        layoutManager= new LinearLayoutManager(this);
        myRecycler.setLayoutManager(layoutManager);
        myRecycler.setAdapter(myRecAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuAdd:
                //
                break;
            case R.id.mnuShow:
                //call activity containing custom recycler view
                startActivity(new Intent(collections.this,Recycler.class));


            case R.id.mnuAddStudent:
                saveStudent();
                break;
            case R.id.mnuViewStudent:
                displayStudent();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void displayStudent(){

        startActivity(new Intent(collections.this, ShowCustomer.class));

    }
    private void saveStudent(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Entry");
        builder.setMessage("Record properly customer info");
        View view = LayoutInflater.from(this).inflate(R.layout.customerform,null);
        stName = view.findViewById(R.id.stName);
        stPhone = view.findViewById(R.id.stPhone);
        stFaculty = view.findViewById(R.id.stFaculty);
        stEmail = view.findViewById(R.id.stEmail);

        builder.setView(view);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String name = stName.getText().toString();
                String phone = stPhone.getText().toString();
                String faculty = stFaculty.getText().toString();
                String email = stEmail.getText().toString();
                if (name.isEmpty()||phone.isEmpty()||faculty.isEmpty()||email.isEmpty()){

                    Toast.makeText(collections.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    stName.setError("Name is required");
                    stFaculty.setError("Faculty is required");
                    stPhone.setError("Phone is required");
                    stEmail.setError("EMail is required");
                    stName.requestFocus();
                }
                else{
                    dbHelper.addData(new Customer(name,phone,faculty,email));
                }}
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setCancelable(false);
        builder.show();

    }
}