package proyekAkhir.JSN.mygadget.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import proyekAkhir.JSN.mygadget.R;

public class ContactUsActivity extends AppCompatActivity {

    private EditText etName, etSubject, etMessage;
    private Button btnSend;
    private String[] email = {"test@gmail.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        etName = findViewById(R.id.et_name);
        etSubject = findViewById(R.id.et_subject);
        etMessage = findViewById(R.id.et_message);
        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Kalau user belum mengisi apa pun
                if(!etName.getText().toString().isEmpty() && !etSubject.getText().toString().isEmpty()
                        && !etMessage.getText().toString().isEmpty())
                {
                    String strName = etName.getText().toString();
                    String strSubject = etSubject.getText().toString();
                    String strMessage = etMessage.getText().toString();

                    String realMessage = "Hello , my name is " + strName + ". " + strMessage;

                    Intent send = new Intent(Intent.ACTION_SENDTO);
                    send.putExtra(Intent.EXTRA_EMAIL, email);
                    send.putExtra(Intent.EXTRA_SUBJECT, strSubject);
                    send.putExtra(Intent.EXTRA_TEXT, realMessage);
                    send.setData(Uri.parse("mailto:"));
                    send.setPackage("com.google.android.gm");

                    // Jika user memiliki aplikasi gmail
                    if(send.resolveActivity(getPackageManager()) != null)
                    {
                        startActivity(send);
                    }
                    else
                    {
                        Toast.makeText(ContactUsActivity.this, "Tidak ada aplikasi yang support", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(ContactUsActivity.this, "Tolong isi semua datanya dulu!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}