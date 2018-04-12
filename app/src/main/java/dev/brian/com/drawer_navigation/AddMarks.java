package dev.brian.com.drawer_navigation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dev.brian.com.drawer_navigation.Model.Student;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by brian-kamau on 4/11/18.
 */

public class AddMarks extends AppCompatActivity implements View.OnClickListener {

    public EditText txtName;
    public EditText txtMarks;
    public Button btnSave;
    public TextView txtLog;
    public Realm realm;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedmarks);
        txtName=(EditText)findViewById(R.id.editName);
        txtMarks = (EditText)findViewById(R.id.editMarks);
        btnSave = (Button)findViewById(R.id.button);
        txtLog = (TextView)findViewById(R.id.txtLog);
        realm = Realm.getDefaultInstance();
        btnSave.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        SendToDatabase(txtName.getText().toString().trim(),Integer.parseInt(txtMarks.getText().toString().trim()));
        showData();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        realm.close();
    }

    public void SendToDatabase(final String name, final int marks){
        realm.executeTransactionAsync(new Realm.Transaction(){

            @Override
            public void execute(Realm realm) {
                Student user =  realm.createObject(Student.class);
                user.setName(name);
                user.setMarks(marks);
            }
        },new Realm.Transaction.OnSuccess(){

        @Override
       public void onSuccess() {
            Log.v("Database","Database Inserted");
            Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();

        }
        },new Realm.Transaction.OnError(){

         @Override
         public void onError(Throwable error) {
                 Log.v("Database","Error Inserting to Database");
                 Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_SHORT).show();
          }
          }
        );
    }
    public void showData(){
        RealmResults<Student> students = realm.where(Student.class).findAll();
        String stu="";
        for(Student student: students){
            stu+=student.toString();
        }
        txtLog.setText(stu);

    }
}
