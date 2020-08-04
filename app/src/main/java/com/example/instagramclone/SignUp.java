package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity {

    private Button saveKickBoxer;
    private EditText name, punchSpeed, punchPower, kickSpeed, kickPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveKickBoxer = findViewById(R.id.save);
        name = findViewById(R.id.edtName);
        punchSpeed = findViewById(R.id.edtPunshSpeed);
        punchPower = findViewById(R.id.edtPunshPower);
        kickSpeed = findViewById(R.id.edtKickSpeed);
        kickPower = findViewById(R.id.edtKickPower);

        saveKickBoxer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ParseObject kickBoxer = new ParseObject("Teakwondo");
                kickBoxer.put("name", name.getText().toString());
                kickBoxer.put("punch_speed", Integer.parseInt(punchSpeed.getText().toString()));
                kickBoxer.put("punch_power", Integer.parseInt(punchPower.getText().toString()));
                kickBoxer.put("kick_speed", Integer.parseInt(kickSpeed.getText().toString()));
                kickBoxer.put("kick_speed", Integer.parseInt(kickPower.getText().toString()));
                kickBoxer.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null){
                            FancyToast.makeText(SignUp.this,"the kickboxer " + kickBoxer.get("name") + "  is saved",
                                    FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                            //  Toast.makeText(SignUp.this, "the kickboxer " + kickBoxer.get("name") + "  is saved", Toast.LENGTH_SHORT).show();
                        }else{
                            FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                            // Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }


  /*  public void helloWordTapped(View view){
        ParseObject boxer = new ParseObject("Boxer");
        boxer.put("punch_speed", 200);
        boxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Toast.makeText(SignUp.this, "boxer object is saved", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }*/
}