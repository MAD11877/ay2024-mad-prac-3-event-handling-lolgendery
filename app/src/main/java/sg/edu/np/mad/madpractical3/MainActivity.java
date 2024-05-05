package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Console;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Boolean following = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            User user = new User("John Doe", "MAD Development", 1,  false);

            TextView name = findViewById(R.id.textView2);
            int id = new Random().nextInt(999999);
            String username = new String(user.name);
            name.setText(username + String.valueOf(id));

            return insets;
        });


        Button follow = findViewById(R.id.button);
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!following){
                    following = true;
                    follow.setText("Unfollow");
                    Toast.makeText(MainActivity.this,"Followed",Toast.LENGTH_SHORT).show();
                }
                else{
                    following = false;
                    follow.setText("Follow");
                    Toast.makeText(MainActivity.this,"Unf   ollowed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}