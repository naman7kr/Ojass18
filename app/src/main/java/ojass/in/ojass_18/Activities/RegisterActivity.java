package ojass.in.ojass_18.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import ojass.in.ojass_18.R;

public class RegisterActivity extends AppCompatActivity {

    String[] values=new String[]{"Choose","Xtra Small-XS","Small-S","Medium-M","Large-L","Xtra Large-XL","Xtra Xtra Large-XXL"};
    Spinner spinner;
    Button registerButton,verifyButton;
    EditText inputName,inputEmail,inputMobile,inputCollege,inputRegId,inputBranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        registerButton=(Button)findViewById(R.id.register_button);
        inputName=(EditText)findViewById(R.id.input_name);
        inputEmail=(EditText)findViewById(R.id.input_email);
        inputMobile=(EditText)findViewById(R.id.input_mobile);
        inputCollege=(EditText)findViewById(R.id.input_college);
        inputRegId=(EditText)findViewById(R.id.input_regid);
        inputBranch=(EditText)findViewById(R.id.input_branch);
        verifyButton=(Button)findViewById(R.id.verify_button);


        verifyButton.setVisibility(verifyButton.INVISIBLE);


        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(RegisterActivity.this,R.layout.spinner_item,values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        inputMobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() == 10){
                    verifyButton.setVisibility(verifyButton.VISIBLE);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });
        spinner.setAdapter(adapter);








        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });



    }



    public void register(){

        if(!validate())
            Toast.makeText(this,"Sign up Failed",Toast.LENGTH_SHORT).show();
        else
            onSignUpSuccess();

    }

    private void onSignUpSuccess() {
        startActivity(new Intent(RegisterActivity.this,MainActivity.class));
        finish();

    }



    public boolean validate(){

        boolean valid=true;
        if(inputEmail.getText().toString().trim().isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(inputEmail.getText().toString().trim()).matches())
        {
            inputEmail.setError("Please Enter Valid Email Address");
            valid=false;
        }
        if(inputMobile.getText().toString().trim().isEmpty()||!Patterns.PHONE.matcher(inputMobile.getText().toString().trim()).matches() )
        {
            inputMobile.setError("Please Enter Valid Mobile Number");
            valid=false;
        }

        if(inputName.getText().toString().trim().isEmpty() )
        {
            inputName.setError("Please Enter Your Name");
            valid=false;
        }

        if(inputCollege.getText().toString().trim().isEmpty() )
        {
            inputCollege.setError("Please Enter Your College");
            valid=false;
        }

        if(inputRegId.getText().toString().trim().isEmpty() )
        {
            inputRegId.setError("Please Enter Your RegId");
            valid=false;
        }

        if(inputBranch.getText().toString().trim().isEmpty() )
        {
            inputBranch.setError("Please Enter Your Branch");
            valid=false;
        }

        return valid;
    }

}
