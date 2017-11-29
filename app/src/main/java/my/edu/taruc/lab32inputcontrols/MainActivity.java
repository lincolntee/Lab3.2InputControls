package my.edu.taruc.lab32inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

        private Spinner spinnerAge;
        private RadioGroup radioGroupGender;
        private RadioButton radioButtonMale, radioButtonFemale;
        private CheckBox checkBoxSmoker;
        private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Linking UI to the program
        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

        //Create an adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAge.setOnItemSelectedListener(this); //this activity listen to user selection and take action

        spinnerAge.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Position:" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int pos;
        double premium = 0;
        pos = spinnerAge.getSelectedItemPosition();
        //Determine user gender
        int indexGender;
        indexGender = radioGroupGender.getCheckedRadioButtonId();
        if(indexGender == R.id.radioButtonMale)
        {
            //TODO: calculate premium for male
            switch(pos)
            {
                case 0: premium = 50.00;
                    break;
                case 1: premium = 55.00;
                    break;
                case 2: premium = 60.00;
                    break;
                case 3: premium = 50.00;
                    break;
                case 4: premium = 50.00;
                    break;
                case 5: premium = 50.00;
                    break;
                case 6: premium = 50.00;
                    break;
                case 7: premium = 50.00;
                    break;

            }

        }
        else
        {
            //TODO: Calculate premium for female

        }
        //calculate smoker
        if(checkBoxSmoker.isChecked())
        {

        }

        //Display premium
        textViewPremium.setText(getString(R.string.premium)+premium);
    }

}
